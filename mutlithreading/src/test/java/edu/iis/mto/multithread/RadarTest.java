package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class RadarTest {

    private NewExecutor NEWExecutor;
    private NewExecutor THISExecutor;
    private PatriotBattery batteryMock;
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Before
    public void init() {
        NEWExecutor = new NewExecutor(JobType.NEW);
        THISExecutor = new NewExecutor(JobType.THIS);
        batteryMock = mock(PatriotBattery.class);
    }

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        NewRadar radar = new NewRadar(batteryMock, THISExecutor, 1);
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

    @Test
    public void launchPatriot3TimeInNewThread() {
        NewRadar radar = new NewRadar(batteryMock, NEWExecutor, 3);
        radar.notice(new Scud());
        verify(batteryMock, times(3)).launchPatriot();
    }

    @Test
    @RepeatRule.Repeat(times = 1000)
    public void check100TimeslaunchPatriotOnceWhenNoticesAScudMissle() {
        NewRadar radar = new NewRadar(batteryMock, THISExecutor, 1);
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }
}
