package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery patriotBattery;
    private int rockets;
    private RocketLauncherOneThread rocketLauncherOneThread;
    private RocketLauncherMultiThread rocketLauncherMultiThread;

    public BetterRadar(PatriotBattery patriotBattery, RocketLauncherOneThread rocketLauncherOneThread, int rockets) {
        this.patriotBattery = patriotBattery;
        this.rocketLauncherOneThread = rocketLauncherOneThread;
        this.rockets = rockets;
    }

    public BetterRadar(PatriotBattery patriotBattery, RocketLauncherMultiThread rocketLauncherMultiThread, int rockets) {
        this.patriotBattery = patriotBattery;
        this.rocketLauncherMultiThread = rocketLauncherMultiThread;
        this.rockets = rockets;
    }

    public void notice(Scud enemyMissle) {
        launchPatriotOneThread();
    }

    public void launchPatriotOneThread() {
        rocketLauncherOneThread.launchRockets(patriotBattery, rockets);
    }

    public void noticeMulti(Scud enemyMissle) {
        launchPatriotMultiThread();
    }

    public void launchPatriotMultiThread() {
        rocketLauncherMultiThread.launchRockets(patriotBattery, rockets);
    }
}
