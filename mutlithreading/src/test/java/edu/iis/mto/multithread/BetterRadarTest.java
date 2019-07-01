package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    PatriotBattery batteryMock;
    int numberOfRockets;

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Before
    public void init() {
        batteryMock = mock(PatriotBattery.class);
        numberOfRockets = 10;
    }

    @Test
    @RepeatRule.Repeat(times = 10)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        BetterRadar radar = new BetterRadar(batteryMock, numberOfRockets, new SingleThreadRocketLauncher());
        radar.notice(new Scud());
        verify(batteryMock, times(numberOfRockets)).launchPatriot();
    }

}
