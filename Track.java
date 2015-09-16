// Track.java

import ch.aplu.robotsim.*;

public class Track {
	public Track() {
		NxtRobot robot = new NxtRobot();

		LightSensor ls1 = new LightSensor(SensorPort.S1);
		robot.addPart(ls1);
		ls1.activate(true);

		LightSensor ls2 = new LightSensor(SensorPort.S2);
		robot.addPart(ls2);
		ls2.activate(true);

		TouchSensor ts = new TouchSensor(SensorPort.S3);
		robot.addPart(ts);

		Gear gear = new Gear();
		robot.addPart(gear);
		gear.setSpeed(90);
		
		
		
		while (true) {
			gear.forward();
			int v1 = ls1.getValue();
			int v2 = ls2.getValue();
			if (ts.isPressed()) {
				System.out.println("Wall");
				gear.left(180);
				//gear.forward(70);
				//gear.stop();
		
			}
			if (v1 < 50){
				gear.left(5);
			}
			if (v2 < 50){
				gear.right(5);
			}
			
		}

	}

	public static void main(String[] args) {
		new Track();
	}

	// ------------------ Environment --------------------------
	static {
		NxtContext.setStartPosition(70, 412);
		NxtContext.setStartDirection(-90);
		NxtContext.useBackground("sprites/track.png");
		NxtContext.useObstacle("sprites/wall1.gif", 80, 455);
		NxtContext.useObstacle("sprites/wall2.gif", 450, 80);
	}
}