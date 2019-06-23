package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLauncher implements RocketLauncher {
    private ExecutorService executorService;

    public ThreadLauncher() {
    }

    public ThreadLauncher(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void launchRockets(int amount, PatriotBattery battery) {
        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(amount);
        }
        executorService.execute(new Runnable() {

            @Override
            public void run() {
                battery.launchPatriot();
            }
        });
        executorService.shutdown();
    }

}
