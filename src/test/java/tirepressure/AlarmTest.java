package tirepressure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AlarmTest {


    @Test
    void pressureIsGood() {
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
        Alarm alarm = new Alarm(sensor, new Threshold(17, 21));

        alarm.check();

        assertThat(alarm.isAlarmOn()).isFalse();
    }

    @Test
    void pressureIsLow() {
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(16.0);
        Alarm alarm = new Alarm(sensor, new Threshold(17, 21));

        alarm.check();

        assertThat(alarm.isAlarmOn()).isTrue();
    }

    @Test
    void pressureIsHigh() {
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
        Alarm alarm = new Alarm(sensor, new Threshold(17.0, 21.0));

        alarm.check();

        assertThat(alarm.isAlarmOn()).isTrue();
    }

    @Test
    void exceptionExample() {
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenThrow(RuntimeException.class);
        doThrow(RuntimeException.class).when(sensor).enableSensor();
    }
}