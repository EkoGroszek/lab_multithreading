package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private RocketLauncher launcher;
    private int rocketsToLaunch;

    public BetterRadar(PatriotBattery battery, RocketLauncher rocketLauncher) {
        this.battery = battery;
        this.launcher = rocketLauncher;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    public void setRocketsToLaunch(int amount) {
        rocketsToLaunch = amount;
    }

    private void launchPatriot() {
        launcher.launchRockets(rocketsToLaunch, battery);
    }
}
