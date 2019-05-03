package edu.iis.mto.multithread;

public class Radar {

    private PatriotBattery battery;
    private final int rocketsToLaunch = 1;

    public Radar(PatriotBattery battery) {
        this.battery = battery;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < rocketsToLaunch; i++) {
                    battery.launchPatriot();
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}
