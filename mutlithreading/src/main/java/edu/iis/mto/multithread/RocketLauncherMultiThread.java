package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RocketLauncherMultiThread {

    public ExecutorService executorService;

    public RocketLauncherMultiThread(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void launchRockets(PatriotBattery battery, int rockets) {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(rockets);
        }

        for (int i = 0; i < rockets; i++) {
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
