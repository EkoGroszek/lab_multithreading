package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 100)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        int numerOfRocekets = 10;
        BetterRadar radar = new BetterRadar(batteryMock, new RocketLauncherOneThread(), numerOfRocekets);
        radar.notice(new Scud());
        verify(batteryMock, times(numerOfRocekets)).launchPatriot();
    }
}
