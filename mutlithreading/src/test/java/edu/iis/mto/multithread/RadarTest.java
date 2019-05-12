package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;

import edu.iis.mto.multithread.RepeatRule.Repeat;

public class RadarTest {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    public PatriotBattery batteryMock;
    public Radar radar;

    @Test
    @Repeat(times = 1)
    public void launchPatriotOnceWhenNoticesAScudMissle() {
        batteryMock = mock(PatriotBattery.class);
        radar = new Radar(batteryMock);
        radar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }
}
