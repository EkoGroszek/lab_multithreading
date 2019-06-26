package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class NewRadar implements Runnable {

    private PatriotBattery battery;
    private Executor executor;
    private int rocketLaunchedCount;

    public NewRadar(PatriotBattery battery, Executor executor, int rocketLaunchedCount) {
        this.battery = battery;
        this.executor = executor;
        this.rocketLaunchedCount = rocketLaunchedCount;
    }

    public void notice(Scud enemyMissle) {
        executor.execute(this);
    }


    @Override
    public void run() {
        for (int i = 0; i < rocketLaunchedCount; i++) {
            battery.launchPatriot();
        }
    }

}




