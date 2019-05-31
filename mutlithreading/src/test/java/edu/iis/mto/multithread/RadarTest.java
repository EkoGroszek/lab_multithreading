package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class RadarTest {

    private NewExecutor NEWExecutor;
    private PatriotBattery batteryMock;

    @Before
    public void init() {
        NEWExecutor = new NewExecutor(JobType.NEW);
        batteryMock = mock(PatriotBattery.class);
    }

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        NewRadar radar = new NewRadar(batteryMock, NEWExecutor, 1);
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
