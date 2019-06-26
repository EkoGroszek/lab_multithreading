package edu.iis.mto.multithread;

public class BetterRadar {

    private RocketLauncher rocketLauncher;
    private int availableRocketsToLaunch;

    public BetterRadar(RocketLauncher rocketLauncher, int availableRocketsToLaunch) {
        this.rocketLauncher = rocketLauncher;
        this.availableRocketsToLaunch = availableRocketsToLaunch;
    }

    public void notice(Scud scud){
        launchPatriot();
    }

    private void launchPatriot(){
        rocketLauncher.loadLauncher(availableRocketsToLaunch);
        rocketLauncher.fireRockets();
    }

}
