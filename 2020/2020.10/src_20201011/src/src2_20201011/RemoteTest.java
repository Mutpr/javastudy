package src2_20201011;

import java.util.*;
public class RemoteTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		SmartTelevision remote1 = new SmartTelevision();
		SmartPhone remote2 = new SmartPhone();
		RemoteControl rc = new RemoteControl() {
			@Override
			public void turnOn() { }
			@Override
			public void turnOff() { }
			@Override
			public void setVolume(int volume) {
			}
			};
			
		remote1.turnOn();
		remote1.turnOff();
		remote1.setVolume(10);
		rc.setMute(true);
		
		remote2.turnOn();
		remote2.setVolume(15);
		remote2.turnOff();
		RemoteControl.changeBattery();
		
		
}
}
