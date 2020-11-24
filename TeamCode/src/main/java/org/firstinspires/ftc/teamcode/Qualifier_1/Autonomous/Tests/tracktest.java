package org.firstinspires.ftc.teamcode.Qualifier_1.Autonomous.Tests;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Qualifier_1.Components.Accesories.Shooter;
import org.firstinspires.ftc.teamcode.Qualifier_1.Components.BasicChassis;
import org.firstinspires.ftc.teamcode.Qualifier_1.Components.Navigations.Odometry;
import org.firstinspires.ftc.teamcode.Qualifier_1.Robot;


@Autonomous(name= "tracktest")
public class tracktest extends LinearOpMode{
final boolean debug = true;

    @Override
    public void runOpMode(){

        Robot robot=new Robot(this, BasicChassis.ChassisType.ENCODER);
        Odometry odom = new Odometry();

        telemetry.addData("Status", "Ready to go");
        telemetry.update();

        odom.init(this);
        telemetry.addData("Status", "InitComplete, Ready to Start");
        telemetry.update();
        sleep(1000);
        waitForStart();
        /*robot.moveAngleOdometry(0,20,0.5);
        telemetry.addData("moved1s", "done");
        telemetry.update();
        sleep(1000);
        robot.moveAngleOdometry(0,-20,0.5);
        telemetry.addData("moved2s", "done");
        telemetry.update();
        sleep(1000);
        robot.moveAngleOdometry( 20,0,0.5);
        telemetry.addData("moved3s", "done");
        telemetry.update();
        sleep(1000);
        robot.moveAngleOdometry( -20,0,0.5);
        telemetry.addData("moved4s", "done");
        telemetry.update();
        sleep(1000);
        robot.moveAngleOdometry( 15,15,0.5);
        telemetry.addData("moved5s", "done");
        telemetry.update();
        sleep(1000);
        robot.moveAngleOdometry( -15,-15,0.5);
        telemetry.addData("moved6s", "done");
        telemetry.update();
        sleep(1000);*/
        robot.moveAngle(0,72,0.2);
        telemetry.addData("moved", "done");
        telemetry.update();
        sleep(1000);
        robot.moveAngle(0,-72,0.5);
        telemetry.addData("moved", "done");
        telemetry.update();
        sleep(1000);
        robot.moveAngle(24,0,0.5);
        telemetry.addData("moved", "done");
        telemetry.update();
        sleep(1000);
        robot.moveAngle(-24,0,0.5);
        telemetry.addData("moved", "done");
        telemetry.update();
        sleep(1000);
        robot.moveAngle(24,24,0.5);
        telemetry.addData("moved", "done");
        telemetry.update();
        sleep(1000);
        robot.moveAngle(-24,-24,0.5);
        telemetry.addData("moved", "done");
        telemetry.update();
        sleep(1000);
        stop();
    }



}

