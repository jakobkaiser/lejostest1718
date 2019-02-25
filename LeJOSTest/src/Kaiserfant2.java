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

public class Kaiserfant2 {

	public static void main(String[] args) {

		RegulatedMotor motorA = new EV3MediumRegulatedMotor(MotorPort.A);
		RegulatedMotor motorD = new EV3MediumRegulatedMotor(MotorPort.D);

		EV3 ev3 = (EV3) BrickFinder.getLocal();
		TextLCD lcd = ev3.getTextLCD();
//colorsensor bestimmen
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
		//Output der erkannten Farbe
		lcd.drawString(colorId + " - " + colorName, 0, 0);

		//während kein rot oder weiß erkannt wird -> geht normal
		//während rot sieht -> geht schneller
		//wenn weiß sieht -> Programm wird beendet
		
		while (colorSensor.getColorID() != Color.WHITE) {
			if (colorSensor.getColorID() != Color.RED) {
				motorA.setSpeed(300);
				motorA.backward();

				motorD.setSpeed(300);
				motorD.backward();

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {

				}
			}

			else {
				motorA.setSpeed(600);
				motorA.backward();

				motorD.setSpeed(600);
				motorD.backward();

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {

				}

			}
		}

	}
}
