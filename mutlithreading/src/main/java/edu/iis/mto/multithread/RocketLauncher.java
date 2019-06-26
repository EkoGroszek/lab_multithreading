package edu.iis.mto.multithread;

public class RocketLauncher{

    private PatriotBattery patriotBattery;
    private int rocketsToLaunch = 0;

    public RocketLauncher(PatriotBattery patriotBattery) {
        this.patriotBattery = patriotBattery;
    }

    public void loadLauncher(int rocketsToLaunch) {
        this.rocketsToLaunch = rocketsToLaunch;
    }

    public void fireRockets() {
        for (int i = 0; i < rocketsToLaunch; i++) {
            patriotBattery.launchPatriot();
        }
    }
}
