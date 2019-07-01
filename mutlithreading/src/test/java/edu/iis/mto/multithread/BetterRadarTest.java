package edu.iis.mto.multithread;

import edu.iis.mto.multithread.Launchers.MultipleThreadsRocketLauncher;
import edu.iis.mto.multithread.Launchers.SingleThreadRocketLauncher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.ExecutorService;

import static org.mockito.Mockito.*;

public class BetterRadarTest {

    private PatriotBattery batteryMock;
    private int numberOfRockets;
    private ExecutorService executor;

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Before
    public void init() {
        batteryMock = mock(PatriotBattery.class);
        numberOfRockets = 10;
        executor = mock(ExecutorService.class);
    }

    @Test
    @RepeatRule.Repeat(times = 10)
    public void launchPatriotOnceWhenNoticesAScudMissle_InSingleThread() {
        BetterRadar radar = new BetterRadar(batteryMock, numberOfRockets, new SingleThreadRocketLauncher());
        radar.notice(new Scud());
        verify(batteryMock, times(numberOfRockets)).launchPatriot();
    }
    @Test
    @RepeatRule.Repeat(times = 10)
    public void launchPatriotOnceWhenNoticesAScudMissle_InMultipleThreads() {
        BetterRadar radar = new BetterRadar(batteryMock, numberOfRockets, new MultipleThreadsRocketLauncher(executor));
        radar.notice(new Scud());
        verify(executor, times(numberOfRockets)).execute(any(Runnable.class));
    }


}
