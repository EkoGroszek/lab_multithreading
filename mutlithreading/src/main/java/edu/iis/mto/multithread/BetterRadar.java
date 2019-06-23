package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery patriotBattery;
    private RocketLauncher rocketLauncher;
    private int amountOfRocketsToLaunch;

    public BetterRadar(PatriotBattery battery, RocketLauncher rocketLauncher) {
        this.patriotBattery = battery;
        this.rocketLauncher = rocketLauncher;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    public void setRocketsToLaunch(int amount) {
        amountOfRocketsToLaunch = amount;
    }

    private void launchPatriot() {
        rocketLauncher.launchRockets(amountOfRocketsToLaunch, patriotBattery);
    }
}


