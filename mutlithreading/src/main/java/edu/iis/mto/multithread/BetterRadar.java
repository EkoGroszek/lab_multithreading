package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery patriotBattery;
    private int rockets;
    private RocketLauncherOneThread rocketLauncher;

    public BetterRadar(PatriotBattery patriotBattery, RocketLauncherOneThread rocketLauncher, int rockets) {
        this.patriotBattery = patriotBattery;
        this.rocketLauncher = rocketLauncher;
        this.rockets = rockets;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    public void launchPatriot() {
        rocketLauncher.launchRockets(patriotBattery, rockets);
    }
}
