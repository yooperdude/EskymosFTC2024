package org.firstinspires.ftc.teamcode.main.autonomous.location.pipeline;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.competition.utils.sensors.SensorWrapper;
import org.firstinspires.ftc.teamcode.competition.utils.sensors.distance.DistanceSensorWrapper;
import org.firstinspires.ftc.teamcode.competition.utils.sensors.distance.MockDistanceSensor;

public class Axis {
    public SensorWrapper sensor1;
    public SensorWrapper sensor2;
    public double interSensorDistance = 10;
    public DistanceUnit unit = DistanceUnit.CM;

    public Axis(SensorWrapper sensor1, SensorWrapper sensor2) {
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
    }

    public Axis(HardwareMap hardwareMap, String sensor1Name, String sensor2Name) {
        this.sensor1 = new DistanceSensorWrapper(hardwareMap, sensor1Name);
        this.sensor2 = new DistanceSensorWrapper(hardwareMap, sensor2Name);
    }

    public Axis(MockDistanceSensor sensor1, MockDistanceSensor sensor2) {
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
    }

    public AxisReading getReadings() {
        return new AxisReading(
                sensor1.getData(),
                sensor2.getData(),
                interSensorDistance,
                unit,
                isSensorValid(sensor1.getData(), 255, sensor1.didTimeoutOccur()),
                isSensorValid(sensor2.getData(), 255, sensor2.didTimeoutOccur())
        );
    }

    private boolean isSensorValid(double reading, double maxReading, boolean didSensorTimeout) {
        boolean isValid = true;
        if (reading > maxReading) isValid = false;
        if (didSensorTimeout) isValid = false;
        return isValid;
    }

    static class AxisReading {
        public double sensor1;
        public double sensor2;
        public double interSensorDistance;
        public DistanceUnit unit;
        public boolean sensor1Valid;
        public boolean sensor2Valid;

        public AxisReading(double sensor1, double sensor2, double interSensorDistance, DistanceUnit unit, boolean sensor1Valid, boolean sensor2Valid) {
            this.sensor1 = sensor1;
            this.sensor2 = sensor2;
            this.interSensorDistance = interSensorDistance;
            this.unit = unit;
            this.sensor1Valid = sensor1Valid;
            this.sensor2Valid = sensor2Valid;
        }
    }
}
