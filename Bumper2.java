import ch.aplu.robotsim.*;
import java.awt.*;

/**
 * Solution to the exercise 4.2
 * 
 * The robot count how many objects are on the workspace
 * 
 * @version 13.09.2015
 * @author Lukin Petr
 * 
 */

class Bumper2 {
	LegoRobot robot;
	Gear gear;
	UltrasonicSensor us;
	int NumberOfTargets = 0;

	Bumper2() {
		robot = new LegoRobot();
		gear = new Gear();
		robot.addPart(gear);
		gear.setSpeed(20);
		us = new UltrasonicSensor(SensorPort.S1);
		robot.addPart(us);
		us.setBeamAreaColor(Color.green);
		us.setProximityCircleColor(Color.lightGray);

		for (int j = 0; j < 4; j++) {
			
			searchTarget();
			NumberOfTargets = 0;
		}
	}

	void searchTarget() {
		
		int prevDist = -1;
		int i = 0;
		while (i < 150) {
			gear.right(50);
			int distance = us.getDistance();
			
			if (distance != -1) {

				if (Math.abs(prevDist - distance) > 30) {

					NumberOfTargets++;
					gear.right(100);
				
				}

			}
			prevDist = distance;
			i++;
		}
		System.out.println(NumberOfTargets + " objects were founded.");
		gear.right(4500);
		gear.forward(5000);

	}

	public static void main(String[] args) {
		new Bumper2();
	}

	// ------------------ Environment --------------------------
	static {
		Point[] mesh = { new Point(50, 0), new Point(25, 42),
				new Point(-25, 42), new Point(-50, 0), new Point(-25, -42),
				new Point(25, -42) };

		RobotContext.useTarget("sprites/bumper.png", mesh, 380, 420);
		RobotContext.useTarget("sprites/bumper.png", mesh, 150, 300);
		RobotContext.useTarget("sprites/bumper.png", mesh, 450, 210);
		RobotContext.useTarget("sprites/bumper.png", mesh, 50, 100);
	}
}
