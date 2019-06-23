package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {
    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 1000)
    public void launchPatriotOnceWhenNoticesAScudMissile() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

    @Test
    @Repeat(times = 1000)
    public void shouldLaunchPatriotOnceWhenNoticeScudMissileUsingBetterRadarAndSimpleLauncher(){
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        SimpleRocketLauncher launcher = new SimpleRocketLauncher();
        BetterRadar radar = new BetterRadar(batteryMock, launcher);
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();

    }
}
