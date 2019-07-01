package edu.iis.mto.multithread;

import edu.iis.mto.multithread.Launchers.RocketLauncher;

public class BetterRadar {
    private PatriotBattery patriotBattery;
    private int numberOfRockets;
    private RocketLauncher rocketLauncher;

    public BetterRadar(PatriotBattery patriotBattery, int numberOfRockets, RocketLauncher rocketLauncher) {
        this.patriotBattery = patriotBattery;
        this.numberOfRockets = numberOfRockets;
        this.rocketLauncher = rocketLauncher;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        rocketLauncher.launchRockets(patriotBattery, numberOfRockets);
    }

}
