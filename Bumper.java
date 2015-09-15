import ch.aplu.robotsim.*;

import java.awt.*;

class Bumper
{
	TurtleRobot robot = new TurtleRobot();
    Gear gear = new Gear();
  UltrasonicSensor us;
int NumberOfTargets = 0;
  Bumper()
  {
	 
	    robot.addPart(gear);
   
    gear.setSpeed(50);
    us = new UltrasonicSensor(SensorPort.S1);
    robot.addPart(us);
    us.setBeamAreaColor(Color.green);
    us.setProximityCircleColor(Color.lightGray);

    //CountTargets();
    
    while (true)
    {
    	gear.right(50);
        int distance = us.getDistance();
        System.out.println("Dist "+distance);
    }
  }

  void CountTargets()
  {
    while (true)
    {
      gear.right(50);
      int distance = us.getDistance();
      System.out.println("Dist "+distance);
      if ((distance <210)&(distance>0))
      {
    	  NumberOfTargets++;
    	  gear.right(200);
    	  System.out.println("Number of targets "+NumberOfTargets);
    	  distance=-1;
        //return;
      }
    }
  }

  public static void main(String[] args)
  {
    new Bumper();
  }

  // ------------------ Environment --------------------------
  static
  {
	 // NxtContext.setLocation(10, 10);
	    NxtContext.setStartDirection(180);
	    NxtContext.setStartPosition(250, 450);
	   // NxtContext.useObstacle("sprites/bumper2.png", 250, 250);
    Point[] mesh =
    {
      new Point(50, 200), new Point(150, 300),new Point(350, 250), new Point(50, 350)
      
    };

   /* RobotContext.useTarget("sprites/target_red.gif", mesh, 50,200);
    RobotContext.useTarget("sprites/bumper.png", mesh, 150, 300);
    RobotContext.useTarget("sprites/bumper.png", mesh, 350, 250);
    RobotContext.useTarget("sprites/bumper.png", mesh, 50, 350);*/
  }
} 
