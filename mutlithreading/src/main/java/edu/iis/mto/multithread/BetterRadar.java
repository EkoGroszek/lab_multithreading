package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private PatriotBattery battery;
    int numberOfRockets;
    public Executor executor;

    public BetterRadar(PatriotBattery battery, int numberOfRockets) {
        this.battery = battery;
        this.numberOfRockets = numberOfRockets;

    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    battery.launchPatriot();
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}
