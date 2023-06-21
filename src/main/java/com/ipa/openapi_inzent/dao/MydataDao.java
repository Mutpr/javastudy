package com.ipa.openapi_inzent.dao;

import com.ipa.openapi_inzent.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MydataDao {
    List<MdAgencyDTO> mdAgencySelectAll() throws DataAccessException;

    List<MdServiceDTO> mdServiceSelectModal(int id) throws DataAccessException;

    List<MdServiceDTO> mdServiceSelectList() throws DataAccessException;

    MdAgencyDTO mdAgencySelectOne(int id) throws DataAccessException;

    List<MdAgencyDTO> mdAgencySelectBox(String division) throws DataAccessException;

    void mdAgencyDelete(int id) throws DataAccessException;

    MdServiceDTO mdServiceSelectOne(int id) throws DataAccessException;

    List<MdServiceDTO> mdServiceSearchKeyword(String keyword) throws DataAccessException;

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> mdProvider page

    List<MdProviderDTO> mdProviderSelectAll() throws DataAccessException;
    List<MdProviderDTO> mdDetailAllPaging(HashMap<String, String> params) throws DataAccessException;
    MdProviderDTO mdProviderSelectOne(int id) throws DataAccessException;

    List<MdTokenDTO> mdAstList() throws DataAccessException;

    MdAgencyDTO mdAstOne(int id) throws DataAccessException;

    List<MdTokenDTO> mdTokenSearch(String keyword) throws DataAccessException;

    void mdProviderInsert(MdProviderDTO mdProviderDTO) throws DataAccessException;

    List<MdCollectorDTO> mdCollectorSelectAll() throws DataAccessException;

    List<MdProviderDTO> mdReqList() throws DataAccessException;

    List<MdProviderDTO> mdProviderCustomerList(String customerNum) throws DataAccessException;
    int countAll() throws DataAccessException;
    List<MdReqInfoDTO> mdReqAll() throws DataAccessException;
    List<MdReqInfoDTO> selectMdReqAllasPagination(HashMap<String, Integer> params) throws DataAccessException;
    List<MdReqInfoDTO> mdReqSearch(String keyword) throws DataAccessException;
    List<MdProviderDTO> mdProviderDetailAsPaging(HashMap<String, Object> params) throws DataAccessException;
    List<MdProviderDTO> mdProviderSearch(String keyword) throws DataAccessException;
    List<MdProviderDTO> mdProviderSelectAllPagination(HashMap<String, Object> params) throws DataAccessException;

    int countProviderHistoryAll(String customerNum) throws DataAccessException;
}
