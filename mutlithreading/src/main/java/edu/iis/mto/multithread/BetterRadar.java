package edu.iis.mto.multithread;

public class BetterRadar {
    private PatriotBattery patriotBattery;
    private RocketLauncher rocketLauncher;
    private int amountOfRocketsToLaunch = 1;

    public BetterRadar(PatriotBattery battery, RocketLauncher rocketLauncher) {
        this.patriotBattery = battery;
        this.rocketLauncher = rocketLauncher;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot();
    }

    private void launchPatriot() {
        rocketLauncher.launchRockets(amountOfRocketsToLaunch, patriotBattery);
    }

    public void setAmountOfRocketsToLaunch(int amountOfRocketsToLaunch) {
        this.amountOfRocketsToLaunch = amountOfRocketsToLaunch;
    }
}


