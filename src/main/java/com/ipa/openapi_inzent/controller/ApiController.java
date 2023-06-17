package com.ipa.openapi_inzent.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ipa.openapi_inzent.model.*;
import com.ipa.openapi_inzent.service.ApiDetailsService;
import com.ipa.openapi_inzent.service.ApiService;
import com.ipa.openapi_inzent.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@RequestMapping("api")
@Controller
public class ApiController {

    ApiService apiService;
    RoleService roleService;
    ApiDetailsService apiDetailsService;

    String[] array = {"get", "post", "put", "delete"};

    @Autowired
    public ApiController(ApiService apiService, ApiDetailsService apiDetailsService, RoleService roleService) {
        this.apiService = apiService;
        this.apiDetailsService = apiDetailsService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String apis(Model model) {
        model.addAttribute("list", apiService.selectAll());
        model.addAttribute("roles", roleService.selectAll());

        return "/apis/index";
    }

    @GetMapping("/selectOne")
    @ResponseBody
    public JsonObject apiOne(int apiId) {
        JsonObject object = new JsonObject();
        ApiDTO apiDTO = apiService.selectOne(apiId);
        List<RoleDTO> apiSelectedRole = roleService.selectApisRoleList(apiId);

        object.addProperty("apiId", apiId);
        object.addProperty("apiName", apiDTO.getName());
        object.addProperty("apiContext", apiDTO.getContext());
        object.addProperty("apiExplanation", apiDTO.getExplanation());
        object.addProperty("apiDisclosure", apiDTO.isDisclosure());

        JsonArray selectRoleArray = new JsonArray();
        for (RoleDTO role : apiSelectedRole) {
            JsonObject r = new JsonObject();
            r.addProperty("id", role.getId());
            r.addProperty("code", role.getCode());
            r.addProperty("name", role.getName());
            selectRoleArray.add(r);
        }

        object.addProperty("selectedRoleList", selectRoleArray.toString());

//        System.out.println("roleAll = " + roleAll);


        return object;
    }

    //단순 모든 role 출력
    @GetMapping("/roleList")
    @ResponseBody
    public JsonObject roleList() {

        JsonObject result = new JsonObject();
//        List<RoleDTO> roleList = roleService.selectApisRoleList(apiId);
        List<RoleDTO> roleAll = roleService.selectAll();

        System.out.println("roleAll = " + roleAll);
//
//        for (RoleDTO role : roleList) {
//            object.addProperty(role.getCode(), role.getName());
//        }
        JsonArray array = new JsonArray();
        for (RoleDTO r : roleAll) {
            JsonObject roleObject = new JsonObject();
            roleObject.addProperty("id", r.getId());
            roleObject.addProperty("code", r.getCode());
            roleObject.addProperty("name", r.getName());
            array.add(roleObject);
        }
        result.addProperty("responseText", array.toString());
        return result;
    }


    //api별  role 출력
    @GetMapping("/apiRoleList")
    @ResponseBody
    public JsonObject apiRoleList() {

        JsonObject result = new JsonObject();
        List<RoleDTO> roleAll = roleService.selectAll();

//        System.out.println("roleAll = " + roleAll);
        JsonArray array = new JsonArray();
        for (RoleDTO r : roleAll) {
            JsonObject roleObject = new JsonObject();
            roleObject.addProperty("id", r.getId());
            roleObject.addProperty("code", r.getCode());
            roleObject.addProperty("name", r.getName());
            array.add(roleObject);
        }
        result.addProperty("responseText", array.toString());
        return result;
    }


    @GetMapping("/details/{apisId}") // id = apisId
    public String detailsList(@PathVariable int apisId) {
        System.out.println("apisId = " + apisId);
        return "apis/details";
    }


    //pagination
    @ResponseBody
    @GetMapping(value = "/pagination")
    public JsonArray selectAsPagination(@RequestParam("apisId") int apisId ,@RequestParam("pageNo") int pageNo) throws JsonProcessingException {
        System.out.println("apisId = " + apisId);
        System.out.println("pageNo = " + pageNo);
        JsonObject jsonObject = null;
        JsonArray array = null;
        int resourceCount = apiDetailsService.countAll(apisId);
        int size = 1;
        int pageCount = resourceCount/size;
        List<ApiDetailsDTO> resourcelist = apiDetailsService.apiDetailsDTOListPaging(pageNo, apisId);
        System.out.println("list = " + resourcelist);
        if (pageNo != 0 && apisId != 0 && resourcelist != null) {
            for (ApiDetailsDTO apiDetailsDTO: resourcelist) {
                array = new JsonArray();
                jsonObject = new JsonObject();
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonString = objectMapper.writeValueAsString(apiDetailsDTO);

                jsonObject.addProperty("DTO", jsonString);
                jsonObject.addProperty("pageNo", pageNo);
                jsonObject.addProperty("pageCount", pageCount);
                System.out.println("jsonObject = " + jsonObject);
                array.add(jsonObject);
            }
        }
       return array;
    }


    @GetMapping("/delete/{id}")
    public String apiDelete(@PathVariable int id) {
        apiService.delete(id);
        return "redirect:/api";
    }

    @PostMapping("/insert")
    public String insert(ApiDTO apiDTO, ApisRoleDTO
            apisRoleDTO, @RequestParam(value = "roleId") List<String> roleId) {
        System.out.println("id===================" + roleId);
        int id = apiService.insertApi(apiDTO);
//        List<RoleDTO> list = roleService.selectAll();
        System.out.println("roleId = " + roleId);
        apisRoleDTO.setApisId(id);

        if (apisRoleDTO.getApisId() == 0 || apisRoleDTO.getRoleId() == 0) {
            System.out.println("fk 제약조건 위배");
        } else {
            for (String role : roleId) {
                apisRoleDTO.setRoleId(Integer.parseInt(role));
                apiService.insertRole(apisRoleDTO);
            }
            System.out.println("apisRoleDTO = " + apisRoleDTO);

        }
        return "redirect:/api";
    }

    @PostMapping("/update/{id}")
    public String update(ApiDTO apiDTO, @RequestParam(value = "roleId") List<String> roleId, @PathVariable int id) {
        apiService.update(apiDTO);
        System.out.println("roleId = " + roleId);
        System.out.println("id = " + id);
        List<ApiDTO> roleList = apiService.selectRoleList(id);
        ApisRoleDTO apisRoleDTO = new ApisRoleDTO();
        apisRoleDTO.setApisId(id);
        // 수정시 업데이트될 역할들어갈 list
        List<Integer> roles = new ArrayList<>();

        if (apisRoleDTO.getApisId() == 0 || apisRoleDTO.getRoleId() == 0) {
            System.out.println("선택된 ROLE 없음");
        } else {
            for (ApiDTO roleOne : roleList) {
                for (String role : roleId) {
                    if (roleOne.getRoleId() == Integer.parseInt(role)) {
                        System.out.println("");
                    }
                    apisRoleDTO.setRoleId(Integer.parseInt(role));
                    apiService.updateRole(apisRoleDTO);
                }

            }

        }
        return "redirect:/api";
    }

    // ########################################
    //             Api Details Part
    // ########################################


    @PostMapping("/resource/{id}")
    @ResponseBody
    public JsonObject resources(Model model, @PathVariable int id) {
        // 리소스 하나씩
        List<ApiDetailsDTO> resourceInAdList = apiDetailsService.resourceInAdList(id); // resource table id
        System.out.println("resourceInAdList = " + resourceInAdList);
        JsonObject object = new JsonObject();
        List<ApiDetailsDTO> adList = apiDetailsService.resourceInAdList(id);
        return object;
    }

    @PostMapping("/resource/insert")
    @ResponseBody
    public void insertResources(@RequestBody Map<String, String> paramMap) {
        System.out.println("ApiController.insertResources");
        System.out.println("\n");
        System.out.println("=======================================");
        System.out.println("[ModuleApiController] : [testPostBodyJson] : [start]");
        System.out.println("[request keySet] : " + String.valueOf(paramMap.keySet()));
        System.out.println("[request uriId] : " + String.valueOf(paramMap.get("uriId"))); // resource id
        System.out.println("[request url] : " + String.valueOf(paramMap.get("url"))); // https:8080
        System.out.println("[request path] : " + String.valueOf(paramMap.get("path"))); // resource  /vi/insuf/
        System.out.println("[request get] : " + String.valueOf(paramMap.get("get")));

        JsonObject object = new JsonObject();
        object = (JsonObject) JsonParser.parseString(paramMap.get("get"));

        System.out.println(object.size()); // 0
        System.out.println(object.isEmpty()); // true

        System.out.println("[request post] : " + String.valueOf(paramMap.get("post")));
        System.out.println("[request put] : " + String.valueOf(paramMap.get("put")));
        System.out.println("[request delete] : " + String.valueOf(paramMap.get("delete")));
        System.out.println("=======================================");
        System.out.println("\n");

        int apiId = Integer.parseInt(paramMap.get("uriId"));
        getTagId(paramMap, apiId);

    }

    private void getTagId(Map<String, String> paramMap, int apiId) {
        ResourceDTO resourceDTO = new ResourceDTO();
        resourceDTO.setApisId(apiId);
        int uriId = Integer.parseInt(paramMap.get("uriId"));
        System.out.println("uriId = " + uriId);
        System.out.println("==================================RESOURCEID");

        System.out.println(String.valueOf(paramMap.get("resourceId")).isEmpty());
//        int resourceId = Integer.parseInt(paramMap.get("resourceId"));
        String resId = String.valueOf(paramMap.get("resourceId"));
        int resourceId = 0;
        for (int i = 0; i < array.length; i++) {

            JsonObject obj = (JsonObject) JsonParser.parseString(paramMap.get(array[i]));
            if (!obj.isEmpty()) {
                System.out.println(obj.isEmpty());
                if (obj.get("tag") == null || obj.get("tag").toString().replaceAll("[^\\w+]", "").isEmpty()) {
                    System.out.println("태그 없음.");
                } else {
                    System.out.println("태그 있음.");
                    int tagId = Integer.parseInt(obj.get("tag").toString().replaceAll("[^\\w+]", ""));
                    resourceDTO.setTagId(tagId);
                }
                // uri 아이디가 넘어오지 않는다면 리소스가 새롭게 등록되어야 되지만
                if (resId.equals("")) { //기존의 리소스가 아니라 새로 등록이라면 apiDetails 전에 resource 먼저 등록
                    System.out.println("리소스 새로등록");
                    resourceDTO.setApisId(Integer.parseInt(paramMap.get("idx"))); // apis 아이디
                    System.out.println("resourceDTO = " + resourceDTO);

                    resourceId = apiDetailsService.insertResource(resourceDTO); // 리소스 생성
                    System.out.println("resourceId = " + resourceId);
                } else { ///있는 리소스라면 받아온 리소스 아이디 입력
                    resourceId = Integer.parseInt(paramMap.get("resourceId"));
                }
                System.out.println("++++++++++++++++++++++++++++++");
                ApiDetailsDTO apiDetailsDTO = new ApiDetailsDTO();

                System.out.println(obj.get("operation"));
                System.out.println(obj.get("summary"));


                apiDetailsDTO.setOperationId(obj.get("operation").toString());
                apiDetailsDTO.setSummary(obj.get("summary").toString());
                apiDetailsDTO.setUrl(paramMap.get("url"));
                apiDetailsDTO.setUri(paramMap.get("path"));
                apiDetailsDTO.setMethod(array[i].toUpperCase());
                apiDetailsDTO.setResourceId(resourceId);
                apiDetailsDTO.setApisId(apiId);
                System.out.println("apiDetailsDTO = " + apiDetailsDTO);


                int apiDetailsId = apiDetailsService.insertApiDetail(apiDetailsDTO);
                System.out.println("//////////////////param/////////////////////");

                System.out.println(obj.get("param"));
                JsonArray paramArr = (JsonArray) obj.get("param");
                System.out.println(paramArr.size());
                // 파라미터가 있다면 등록
                if (paramArr.size() != 0) {
                    for (int k = 0; k < paramArr.size(); k++) {
                        System.out.println(paramArr.get(k).getClass());
                        System.out.println();
                        JsonObject param = (JsonObject) paramArr.get(k);
                        System.out.println(param.get("name"));
                        System.out.println(param.get("transferMethod"));
                        System.out.println(param.get("explanation"));
                        System.out.println(param.get("required"));
                        System.out.println(param.get("type"));
                        System.out.println(param.get("sample"));

                        ParameterDTO parameterDTO = new ParameterDTO();
                        parameterDTO.setApiDetailsId(apiDetailsId);
                        parameterDTO.setName(String.valueOf(param.get("name")));
                        parameterDTO.setTransferMethod(String.valueOf(param.get("transferMethod")));
                        parameterDTO.setExplanation(String.valueOf(param.get("explanation")));
                        Boolean b = Boolean.valueOf(String.valueOf(param.get("required")));
                        parameterDTO.setRequired(b);
                        parameterDTO.setType(String.valueOf(param.get("type")));
                        parameterDTO.setSample(String.valueOf(param.get("sample")));

                        apiDetailsService.insertParameter(parameterDTO);
                    }
                } else {
                    System.out.println("parma size == 0");
                }

                System.out.println("//////////////////resCode/////////////////////");
                System.out.println(obj.get("resCode"));
                JsonArray resParamArr = (JsonArray) obj.get("resCode");
                System.out.println("resParamArr = " + resParamArr);
                if (resParamArr.size() != 0) {
                    for (int k = 0; k < paramArr.size(); k++) {
                        JsonObject resParam = (JsonObject) resParamArr.get(k);
                        System.out.println("resParam = " + resParam.get("paramKey"));
                        System.out.println("resParam = " + resParam.get("paramValue"));
                        System.out.println("resParam = " + resParam.get("paramType"));

                        String[] paramKeyList = String.valueOf(resParam.get("paramKey")).split(",");
                        String[] paramValueList = String.valueOf(resParam.get("paramValue")).split(",");
                        String[] paramTypeList = String.valueOf(resParam.get("paramType")).split(",");

                        System.out.println("++++++++++++++++++++++++++++++");
//                        2. 분리 후 FOR문을 통해 DB에 넣는다.
//                2-1. response 에 넣기 위해서는 apiDetails id 필요
                        ResponseDTO responseDTO = new ResponseDTO();
                        responseDTO.setApiDetailsId(apiDetailsId);
                        responseDTO.setRespCode(String.valueOf(resParam.get("code")));
                        responseDTO.setRespMsg(String.valueOf(resParam.get("explanation")));
                        responseDTO.setType(String.valueOf(resParam.get("type")));
                        System.out.println("responseDTO = " + responseDTO);
                        int responsId = apiDetailsService.insertResponse(responseDTO);
//                2-2. 키와 VALUE 값을 콤마를 기준으로 분리한다.
                        for (int j = 0; j < paramKeyList.length; j++) {
                            ResParamDTO resParamDTO = new ResParamDTO();
                            resParamDTO.setResId(responsId);
                            resParamDTO.setKey(paramKeyList[j]);
                            resParamDTO.setValue(paramValueList[j]);
                            resParamDTO.setType(paramTypeList[j]);
                            System.out.println("j = " + j);
                            System.out.println("resParamDTO = " + resParamDTO);

                            // 응답 파라미터 등록
                            apiDetailsService.insertResParam(resParamDTO);
                        }
                    }
                }
//                2-3. resParam 넣으려면 response table id값 필요
            }
        }
    }

    @GetMapping("/select/detail")
    @ResponseBody
    public JsonObject detailModal(int id) {
        JsonObject object = new JsonObject();
        ApiDetailsDTO detailList = apiDetailsService.searchDetail(id);

        System.out.println("detailList = " + detailList);
        object.addProperty("id", detailList.getId());
        object.addProperty("resourceId", detailList.getResourceId());
        object.addProperty("method", detailList.getMethod());
        object.addProperty("url", detailList.getUrl());
        object.addProperty("uri", detailList.getUri());
        object.addProperty("summary", detailList.getSummary());
        object.addProperty("security", detailList.getSecurity());
        object.addProperty("scope", detailList.getScope());
        object.addProperty("version", detailList.getVersion());
        object.addProperty("operationId", detailList.getOperationId());

        object.addProperty("status", detailList.getStatus());
        object.addProperty("authorization", detailList.getAuthorization());
        object.addProperty("resource_id", detailList.getResourceId());
        object.addProperty("apisId", detailList.getApisId());

//        parameter jsonArray
        JsonArray paramArray = new JsonArray();
        List<ParameterDTO> list = apiDetailsService.searchParameter(id);
        System.out.println("id" + id);
        System.out.println("list = " + list);
        for (int i = 0; i < list.size(); i++) {
            JsonObject param = new JsonObject();
            param.addProperty("id", list.get(i).getId());
            param.addProperty("apiDetailsId", list.get(i).getApiDetailsId());
            param.addProperty("name", list.get(i).getName());
            param.addProperty("transferMethod", list.get(i).getTransferMethod());
            param.addProperty("explanation", list.get(i).getExplanation());
            param.addProperty("type", list.get(i).getType());
            param.addProperty("required", list.get(i).getRequired());
            param.addProperty("sample", list.get(i).getSample());
            paramArray.add(param);
        }

//       resCode JsonArray
        JsonArray resCodeArray = new JsonArray();
//        List<>

        object.addProperty("parameterList", paramArray.toString());

        return object;
    }


    @GetMapping("/search/path")
    @ResponseBody
    public JsonObject searchKeyword(String keyword, int apisId) {
        List<ApiDetailsDTO> searchList = apiDetailsService.searchPath(keyword, apisId);
        JsonArray array = new JsonArray();
        for (ApiDetailsDTO a : searchList) {
            JsonObject object = new JsonObject();
            object.addProperty("id", a.getId());
            object.addProperty("uri", a.getUri());
            object.addProperty("method", a.getMethod());
            object.addProperty("resourceId", a.getResourceId());
            array.add(object);
        }
        JsonObject result = new JsonObject();
        result.addProperty("responseText", array.toString());

        return result;
    }

    @GetMapping("/resourceModal")
    public String resourceModal() {
        return "/apis/resourceModal";
    }


    // ########################################
    //             Api Details Part
    // ########################################

    @GetMapping("/trash")
    public String apiTrash(Model model) {
        List<ResourceDTO> rlist = apiDetailsService.goTrashResource();
        List<ApiDetailsDTO> adlist = apiDetailsService.goTrashDetail();
        List<ApiDetailsDTO> temp = new ArrayList<>();

        model.addAttribute("rlist", rlist);
        model.addAttribute("adlist", adlist);

        return "/apis/trash";
    }

    @GetMapping("/completeDelete/{id}")
    public String completeDetele(@PathVariable int id) {
        apiDetailsService.completeDelete(id);
        return "redirect:/api/trash";
    }

    @GetMapping("/resourceDelete/{id}")
    public String resourceDetele(@PathVariable int id) {
        System.out.println("ApiController.resourceDetele");
        System.out.println("id = " + id);
        apiDetailsService.resourceDelete(id);
        return "redirect:/api/trash";
    }

    @GetMapping("/return/{id}")
    public String goReturn(@PathVariable int id) {
        ApiDetailsDTO a = apiDetailsService.selectOne(id);
        a.setTrash(false);
        apiDetailsService.updateDetail(a);
        return "redirect:/api/trash";
    }

    @GetMapping("/returnResource/{id}")
    public String goReturnResource(@PathVariable int id) {
        ResourceDTO s = apiDetailsService.resourceOne(id);
        s.setGarbage(false);
        apiDetailsService.updateResource(s);
        return "redirect:/api/details/" + s.getApisId();
    }

    // 휴지통 관리로 보내는 곳
    @GetMapping("/goTrash/{id}")
    public String goTrash(@PathVariable int id) {
        ApiDetailsDTO a = apiDetailsService.selectOne(id);
        a.setTrash(true);
        apiDetailsService.updateDetail(a);
        return "redirect:/api/details/" + a.getApisId();
    }

    @GetMapping("/goTrashResource/{id}")
    public String goTrashResource(@PathVariable int id) {
        ResourceDTO s = apiDetailsService.resourceOne(id);
        s.setGarbage(true);
        apiDetailsService.updateResource(s);
        return "redirect:/api/details/" + s.getApisId();
    }

    @GetMapping("/trashSearch")
    public String trashSearch(Model model, String keyword) {
        model.addAttribute("list", apiDetailsService.trashSearch(keyword));
        return "/apis/trash";
    }

    @GetMapping("/resCode/selectOne")
    @ResponseBody
    public JsonObject selectRescode(int id) {
        JsonObject object = new JsonObject();
        JsonArray resArr = new JsonArray();
        JsonArray resParamArr = new JsonArray();

        List<ResponseDTO> responseList = apiDetailsService.selectResponseList(id); // details 아이디
        System.out.println("responseList = " + responseList);


        if (responseList.size() > 0) {
            System.out.println("응답코드 존재");


            for (ResponseDTO res : responseList) {
                JsonObject response = new JsonObject();
                System.out.println("res.getId() = " + res.getId());
                response.addProperty("id", res.getId());
                response.addProperty("apiDetailsId", res.getApiDetailsId());
                response.addProperty("respCode", res.getRespCode());
                response.addProperty("respMsg", res.getRespMsg());
                response.addProperty("type", res.getType());
                resArr.add(response);

                int resId = res.getId(); // responseID
                List<ResParamDTO> resParamList = apiDetailsService.selectResParamList(resId); // response id
                for (ResParamDTO param : resParamList) {
                    JsonObject resParam = new JsonObject();
                    resParam.addProperty("id", param.getId());
                    resParam.addProperty("resId", param.getResId());
                    resParam.addProperty("key", param.getKey());
                    resParam.addProperty("value", param.getValue());
                    resParam.addProperty("type", param.getType());
                    resParam.addProperty("sample", param.getSample());
                    resParamArr.add(resParam);
                }
            }
        }

        object.addProperty("responseList", resArr.toString());
        object.addProperty("resParamList", resParamArr.toString());
        System.out.println("object = " + object);
        return object;
    }


    @GetMapping("/remove/resCode")
    @ResponseBody
    public void removeResCode(int id) {
        System.out.println("ApiController.removeResCode");
        System.out.println("id   " + id);
        apiDetailsService.removeResCode(id);
    }

    @GetMapping("/remove/resParam")
    @ResponseBody
    public void removeResParam(int id) {
        System.out.println("ApiController.removeResParam");
        System.out.println("id   " + id);
        apiDetailsService.removeResParam(id);
    }

//    public JsonObject parseObject(Object object){
//        JsonParser jsonParser = new JsonParser();
//        JsonElement Json= jsonParser.parse(String.valueOf(object));
//    }
}

