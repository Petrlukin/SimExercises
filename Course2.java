import ch.aplu.robotsim.*;

class Course2
{
	Course2()
  {
    TurtleRobot robot = new TurtleRobot();
    Gear gear = new Gear();
    robot.addPart(gear);
    TouchSensor tsl = new TouchSensor(SensorPort.S1); 
    TouchSensor tsr = new TouchSensor(SensorPort.S2); 
    robot.addPart(tsl);
    robot.addPart(tsr);
    gear.setSpeed(100);
    
    gear.forward();
    while (true)
    {
      boolean t1 = tsl.isPressed();
      boolean t2 = tsr.isPressed();

      if (t1 && t2)
      {
        gear.backward(500);
        gear.left(400);
        gear.forward();
      }
      else
      {
        if (t1)
        {
          gear.backward(500);
          gear.left(400);
          gear.forward();
        }
        else
        {
          if (t2)
          {
            gear.backward(500);
            gear.right(100);
            gear.forward();
          }
        }
      }
      Tools.delay(20);
    }
  }

  static public void main(String[] args)
  {
    new Course2();
  }

  // ------------------ Environment --------------------------
  static
  {
    NxtContext.setLocation(10, 10);
    NxtContext.setStartDirection(270);
    NxtContext.setStartPosition(410, 430);
    NxtContext.useObstacle("sprites/bg2.gif", 250, 250);
  }
} 