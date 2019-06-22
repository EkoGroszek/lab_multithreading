package edu.iis.mto.multithread;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;

public class RadarTest
    {

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    @Test
    @RepeatRule.Repeat( times = 10 )
    public void launchPatriotOnceWhenNoticesAScudMissle()
        {
        PatriotBattery batteryMock = mock(PatriotBattery.class);
        int numberOfPatriot = 10;
        Radar radar = new Radar(batteryMock, numberOfPatriot);
        radar.notice(new Scud());
        verify(batteryMock,times(numberOfPatriot)).launchPatriot();
        }

    }
