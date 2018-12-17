import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;

public class kaiserfant {
	
		
	RegulatedMotor motorA = new EV3MediumRegulatedMotor(MotorPort.A);
	 
	motorA.setSpeed(250);
	motorA.forward();
	 
	// ...
	 
	motorA.stop();
	 
	motorA.close();

	
}
