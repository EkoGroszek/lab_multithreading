package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BetterRadarTest
    {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();
    private PatriotLauncher onOneThreadImpl;

    @Before
    public void setUp()
        {
        onOneThreadImpl = (patriotBattery, times) -> IntStream.range(0, times).forEach(value -> patriotBattery.launchPatriot());
        }

    @Test
    @RepeatRule.Repeat(times = 10)
    public void launchPatriot10TimesOnCurrentThreadWhenNoticesAScudMissle()
        {
        //g
        int numberOfPatriot = 10;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new BetterRadar(batteryMock, onOneThreadImpl, numberOfPatriot);
        //w
        radar.notice(new Scud());
        //t
        verify(batteryMock, times(numberOfPatriot)).launchPatriot();
        }

    @Test
    @RepeatRule.Repeat(times = 10)
    public void launcherInvokesOneTimes()
        {
        //g
        int numberOfPatriot = 10;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        PatriotLauncher patriotLauncherMock = mock(PatriotLauncher.class);

        Radar radar = new BetterRadar(batteryMock, patriotLauncherMock, numberOfPatriot);
        //w
        radar.notice(new Scud());
        //t
        verify(patriotLauncherMock, times(1)).launch(any(), any());
        }

    @Test
    @RepeatRule.Repeat(times = 10)
    public void executorRuns10Times()
        {
        //g
        int numberOfPatriot = 10;
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Executor executorMock = mock(Executor.class);
        PatriotLauncher patriotLauncherMulti = new MultiThreadWithExecutors(executorMock);
        Radar radar = new BetterRadar(batteryMock, patriotLauncherMulti, numberOfPatriot);
        //w
        radar.notice(new Scud());
        //t
        verify(executorMock, times(numberOfPatriot)).execute(any());
        }
    }
