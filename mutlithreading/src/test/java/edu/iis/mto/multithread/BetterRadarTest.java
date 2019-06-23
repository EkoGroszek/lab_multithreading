package edu.iis.mto.multithread;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BetterRadarTest {

    @Test
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
