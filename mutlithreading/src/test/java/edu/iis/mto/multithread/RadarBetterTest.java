package edu.iis.mto.multithread;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.ExecutorService;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class RadarBetterTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    BetterRadar betterRadar;
    PatriotBattery patriotBattery;
    int rockets = 10;
    ExecutorService executorService;

    @Test
    @Repeat(times = 20)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        patriotBattery = mock(PatriotBattery.class);
        betterRadar = new BetterRadar(patriotBattery, new RocketLauncherOneThread(), rockets);
        betterRadar.notice(new Scud());
        verify(patriotBattery, times(rockets)).launchPatriot();
    }

    @Test
    @Repeat(times = 10)
    public void launchPatriotMultiWhenNoticesAScudMissle() {
        executorService = mock(ExecutorService.class);
        betterRadar = new BetterRadar(patriotBattery, new RocketLauncherMultiThread(executorService), rockets);
        betterRadar.noticeMulti(new Scud());

        verify(executorService, times(rockets)).execute(any(Runnable.class));
    }

}
