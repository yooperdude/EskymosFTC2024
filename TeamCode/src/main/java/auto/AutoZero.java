package auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import autofunctions.Path;
import autofunctions.RobotFunctions;
import developing.TerraCV;
import developing.TerraCVHandler;
import global.TerraBot;

@Autonomous(name="AutoZero", group="Auto")
public class AutoZero extends LinearOpMode {
    TerraBot bot = new TerraBot();
    Path path = new Path(0,0,0);
    RobotFunctions rf = new RobotFunctions();
    TerraCV.RingNum ringNum = TerraCV.RingNum.ZERO;

    @Override
    public void runOpMode() {
        initialize();
        waitForStart();
        bot.startOdoThreadAuto(this);

        /**
         *
         *
         * TODO LIST
         *  Programming:
         *      shooter (powershot)
         *      localizer test
         *      auton
         *
         *      PlAN
         *          1. shoot 3 rings into normal goal
         *          2. shoot 1 ring into normal goal
         *          3. shoot 3 rings into powershot
         *          4. place wobble goal
         *          5. get other wobble goal
         *          6. place other wobble goal
         *          7. park
         */

//        path.addRF(rf.startOuttake());
//        path.addStop(10);
//        path.addRF(rf.stopOuttake());
//        path.addRF(rf.wgMoveFront());
        path.addSetpoint(0,20,90);

        path.start(bot, this);
//

        bot.stopOdoThread();
    }

    public void initialize() {
        bot.init(hardwareMap);
        rf.init(bot);
        telemetry.addData("Ready:", ringNum);
        telemetry.update();
    }
}
