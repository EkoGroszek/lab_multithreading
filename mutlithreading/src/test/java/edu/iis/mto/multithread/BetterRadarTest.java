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

    @Repeat(times = 100)
    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        BetterRadar radar = new BetterRadar(batteryMock, 5, new TasksInOneThreadExecutor());
        radar.notice(new Scud());
        verify(batteryMock, times(5)).launchPatriot();
    }

}
