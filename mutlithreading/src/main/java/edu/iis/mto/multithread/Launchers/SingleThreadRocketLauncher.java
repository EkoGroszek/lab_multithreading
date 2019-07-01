package edu.iis.mto.multithread.Launchers;

import edu.iis.mto.multithread.PatriotBattery;

public class SingleThreadRocketLauncher implements RocketLauncher {

    @Override public void launchRockets(PatriotBattery patriotBattery, int numberOfRockets) {
        for (int i = 0; i < numberOfRockets; i++) {
            patriotBattery.launchPatriot();
        }
    }
}
