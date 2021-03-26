package tirepressure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AlarmTest {


    @Test
    void pressureIsGood() {
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(20.0);
        Alarm alarm = new Alarm(sensor, new Threshold(17, 21));

        alarm.check();

        assertThat(alarm.isAlarmOn()).isFalse();
    }
}