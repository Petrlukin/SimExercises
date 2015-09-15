// BridgeAndWall.java

import ch.aplu.robotsim.*;

public class BridgeAndWall {

	public BridgeAndWall() {
		
		NxtRobot robot = new NxtRobot();
		
		LightSensor ls = new LightSensor(SensorPort.S3);
		robot.addPart(ls);
		ls.activate(true);
		
		TouchSensor ts = new TouchSensor(SensorPort.S2);	
		robot.addPart(ts);
		
		Gear gear = new Gear();
		robot.addPart(gear);
		
		gear.setSpeed(100);

		

		while (true) {
			gear.forward();
			int v = ls.getValue();
			if (v < 900) {
				gear.left(180);
			}
					if (ts.isPressed()) {
				gear.left(180);
			}
		}

	}

	public static void main(String[] args) {
		new BridgeAndWall();
	}

	// ------------------ Environment --------------------------
	static {
		NxtContext.setStartPosition(250, 300);
		NxtContext.setStartDirection(-90);
		NxtContext.useBackground("sprites/bridge.gif");
		NxtContext.useObstacle("sprites/wall.gif", 245, 380);
	}
	
}
