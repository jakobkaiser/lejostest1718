import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Kaiserfant2 {

	public static void main(String[] args) {

		RegulatedMotor motorA = new EV3MediumRegulatedMotor(MotorPort.A);
		 
		motorA.setSpeed(250);
		motorA.forward();
		
		RegulatedMotor motorD = new EV3MediumRegulatedMotor(MotorPort.D);
		 
		motorD.setSpeed(250);
		motorD.forward();
		 
		Delay.msDelay(5000);
		
		motorD.stop();
		 
		// ...
		 
		motorA.stop();
		 
		motorA.close();
		 
		motorD.close();

	}

}
