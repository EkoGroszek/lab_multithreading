package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class RadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @Repeat(times = 100)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        Radar radar = new Radar(batteryMock);
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }

}
