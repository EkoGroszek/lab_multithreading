package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {
    @Rule
    public RepeatRule repeatRule = new RepeatRule();
    public PatriotBattery batteryMock;

    @Test
    @Repeat(times = 1000)
    public void shouldLaunchPatriotOnceWhenNoticesAScudMissile(){
        batteryMock = mock(PatriotBattery.class);
        int numberOfRockets = 10;
        SingleThreadLauncher singleThreadLauncher = new SingleThreadLauncher();
        BetterRadar radar = new BetterRadar(batteryMock, singleThreadLauncher);
        radar.setAmountOfRocketsToLaunch(numberOfRockets);
        radar.notice(new Scud());
        verify(batteryMock, times(numberOfRockets)).launchPatriot();
    }
}
