
import ch.aplu.robotsim.*;

/**
 * Solution to the exercise 3.1
 * 
 * @version 15.09.2015
 * @author Lukin Petr
 * 
 */
public class Cleaner {
	
	
	TurtleRobot robot = new TurtleRobot();
	Gear gear = new Gear();
	TouchSensor ts = new TouchSensor(SensorPort.S3);
	int i = 1;

	
	public Cleaner() {
		
		robot.addPart(ts);
		robot.addPart(gear);
		gear.setSpeed(100);

		gear.forward();
		

		while (true) {
			if (ts.isPressed()) {
				goback();
			}
			

		}
	}

	private void goback() {
		gear.backward(200);

		if (i % 2 == 1) 
		{
			gear.left(75);
			gear.forward(300);
			gear.left(100);
		} else 
		{
			gear.right(75);
			gear.forward(300);
			gear.right(100);
		}
		gear.forward();
		i++;
	}

	public static void main(String[] args) {
		new Cleaner();
	}

	// ------------------ Environment --------------------------
	static {
		NxtContext.useObstacle("sprites/box.gif", 250, 250);
		NxtContext.setStartPosition(480, 100);
		NxtContext.setStartDirection(-90);
	}
}
