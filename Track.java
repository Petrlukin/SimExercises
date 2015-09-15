// Track.java

import ch.aplu.robotsim.*;

public class Track {
	public Track() {
		NxtRobot robot = new NxtRobot();

		LightSensor ls1 = new LightSensor(SensorPort.S1);
		robot.addPart(ls1);
		ls1.activate(true);

		LightSensor ls2 = new LightSensor(SensorPort.S4);
		robot.addPart(ls2);
		ls2.activate(true);

		TouchSensor ts = new TouchSensor(SensorPort.S2);
		robot.addPart(ts);

		Gear gear = new Gear();
		robot.addPart(gear);
		gear.setSpeed(90);
		
		
		
		while (true) {
			gear.forward();
			int a = 1;
			int v1 = ls1.getValue();
			int v2 = ls2.getValue();
			if (ts.isPressed()) {
				System.out.println("Wall");
				gear.left(310);
				gear.forward(40);
				gear.stop();
				a = -a;
			}
			if (v1 < 50) {
				if (a == 1){
					gear.right(5);
				}
				else{
					gear.left(5);
				}
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