package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class RadarBetterTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();
    BetterRadar betterRadar;
    PatriotBattery patriotBattery;
    int rocekets = 10;

    @Test
    @Repeat(times = 20)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        patriotBattery = mock(PatriotBattery.class);
        betterRadar = new BetterRadar(patriotBattery, new RocketLauncherOneThread(), rocekets);
        betterRadar.notice(new Scud());
        verify(patriotBattery, times(rocekets)).launchPatriot();
    }
}
