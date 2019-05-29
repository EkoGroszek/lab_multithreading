package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private RocketLauncher rocketLauncher;

    private int numberOfRockets;

    public BetterRadar(PatriotBattery battery, RocketLauncher launcher, int numberOfRockets) {
        this.battery = battery;
        this.rocketLauncher = launcher;
        this.numberOfRockets = numberOfRockets;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        rocketLauncher.launchRockets(battery, numberOfRockets);
    }

    public RocketLauncher getRocketLauncher() {
        return rocketLauncher;
    }
}
