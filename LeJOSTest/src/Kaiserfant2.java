import lejos.hardware.BrickFinder;
import lejos.hardware.ev3.EV3;
import lejos.hardware.lcd.TextLCD;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Kaiserfant2 {

	public static void main(String[] args) {

		RegulatedMotor motorA = new EV3MediumRegulatedMotor(MotorPort.A);
		RegulatedMotor motorD = new EV3MediumRegulatedMotor(MotorPort.D);
		
					
		EV3 ev3 = (EV3) BrickFinder.getLocal();
		TextLCD lcd = ev3.getTextLCD();
	////	Keys keys = ev3.getKeys();

		EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S3);
		SensorMode color = colorSensor.getColorIDMode();
		float[] sample = new float[color.sampleSize()];
		color.fetchSample(sample, 0);
		int colorId = (int) sample[0];
		String colorName = "";
		switch (colorId) {
		case Color.NONE:
			colorName = "NONE";
			break;
		case Color.BLACK:
			colorName = "BLACK";
			break;
		case Color.BLUE:
			colorName = "BLUE";
			break;
		case Color.GREEN:
			colorName = "GREEN";
			break;
		case Color.YELLOW:
			colorName = "YELLOW";
			break;
		case Color.RED:
			colorName = "RED";
			break;
		case Color.WHITE:
			colorName = "WHITE";
			break;
		case Color.BROWN:
			colorName = "BROWN";
			break;
		}
		lcd.drawString(colorId + " - " + colorName, 0, 0);
	////	keys.waitForAnyPress();
		
//		motorA.setSpeed(300);
//		motorA.backward();
//
//		motorD.setSpeed(300);
//		motorD.backward();
//
//		Delay.msDelay(3000);
		
//		while(colorSensor.getColorID() != Color.BLACK){
//            System.out.println("waiting for black");
//    }
		
		while(true) {
			if(colorSensor.getColorID() != Color.RED) {
				motorA.setSpeed(300);
				motorA.backward();
				
				motorD.setSpeed(300);
				motorD.backward();
				
				Delay.msDelay(10000);
			}
			
			else {
				motorA.setSpeed(1000);
				motorA.backward();
				
				motorD.setSpeed(1000);
				motorD.backward();
				
				Delay.msDelay(30000);
			}
		}
//		
//		motorA.setSpeed(0);
//		motorA.backward();
//		
//		motorD.setSpeed(0);
//		motorD.backward();
//		 
//		Delay.msDelay(1000);

//		motorA.setSpeed(550);
//		motorA.forward();
//		
//		motorD.setSpeed(550);
//		motorD.backward();
//		 
//		Delay.msDelay(30000);

		

		// ...


	}
}
