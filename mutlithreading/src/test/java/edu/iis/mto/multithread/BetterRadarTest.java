package edu.iis.mto.multithread;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat(times = 777)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);

        int rockets = 111;
        RocketLauncher rocketLauncher = new RocketLauncher(batteryMock);
        BetterRadar betterRadar = new BetterRadar(rocketLauncher,rockets);

        betterRadar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
