import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Kaiserfant2 {

	public static void main(String[] args) {

		RegulatedMotor motorA = new EV3MediumRegulatedMotor(MotorPort.A);
		RegulatedMotor motorD = new EV3MediumRegulatedMotor(MotorPort.D);
		  
		motorA.setSpeed(250);
		motorA.backward();
		
		motorD.setSpeed(250);
		motorD.backward();
		 
		Delay.msDelay(3000);
		
		motorA.setSpeed(0);
		motorA.backward();
		
		motorD.setSpeed(0);
		motorD.backward();
		 
		Delay.msDelay(1000);
		
		motorA.setSpeed(250);
		motorA.forward();
		
		motorD.setSpeed(250);
		motorD.backward();
		 
		Delay.msDelay(30000);
		
		motorD.stop();
		 
		// ...
		 
		motorA.stop();
		 
		motorA.close();
		 
		motorD.close();

	}

}
