package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RocketLaucherMultiThread implements RocketLauncher {

    private ExecutorService executorService;

    public RocketLaucherMultiThread() {
    }

    public RocketLaucherMultiThread(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void launchRockets(PatriotBattery battery, int numberOfRockets) {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(numberOfRockets);
        }

        for (int i = 0; i < numberOfRockets; i++) {
            executorService.execute(new Runnable() {

                @Override
                public void run() {
                    battery.launchPatriot();
                }
            });
        }
        executorService.shutdown();
    }
}
