package edu.iis.mto.multithread;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.ExecutorService;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    private PatriotBattery batteryMock;
    private int numerOfRockets;
    private ExecutorService executor;

    @Before
    public void setup() {
        batteryMock = mock(PatriotBattery.class);
        numerOfRockets = 10;
        executor = mock(ExecutorService.class);
    }

    @Test
    @Repeat(times = 100)
    public void launchPatriotOnceWhenNoticesAScudMissle() {

        BetterRadar radar = new BetterRadar(batteryMock, new RocketLauncherOneThread(), numerOfRockets);
        radar.notice(new Scud());
        verify(batteryMock, times(numerOfRockets)).launchPatriot();
    }

    @Test
    @Repeat(times = 100)
    public void launchPatriotOnceWhenNoticesAScudMissleInMultipleThread() {
        BetterRadar radar = new BetterRadar(batteryMock, new RocketLaucherMultiThread(executor), numerOfRockets);
        radar.notice(new Scud());

        verify(executor, times(numerOfRockets)).execute(any(Runnable.class));
    }
}
