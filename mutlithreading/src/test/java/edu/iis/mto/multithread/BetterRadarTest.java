package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();
    public PatriotBattery batteryMock;

    @Test
    @Repeat(times = 1000)
    public void launchPatriotOnceWhenNoticesAScudMissle() throws InterruptedException {
        batteryMock = mock(PatriotBattery.class);
        int numberOfRockets = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        ThreadLauncher threadLauncher = new ThreadLauncher(executorService);
        BetterRadar radar = new BetterRadar(batteryMock, threadLauncher);
        radar.setRocketsToLaunch(numberOfRockets);
        radar.notice(new Scud());
        verify(batteryMock, times(numberOfRockets)).launchPatriot();
    }
}
