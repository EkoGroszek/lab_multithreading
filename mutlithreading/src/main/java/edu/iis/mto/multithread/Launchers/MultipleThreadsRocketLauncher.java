package edu.iis.mto.multithread.Launchers;

import edu.iis.mto.multithread.PatriotBattery;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleThreadsRocketLauncher implements RocketLauncher {

    private ExecutorService executorService;

    public MultipleThreadsRocketLauncher(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override public void launchRockets(PatriotBattery patriotBattery, int numberOfRockets) {

        if (executorService == null) {
            executorService = Executors.newFixedThreadPool(numberOfRockets);
        }

        for (int i = 0; i < numberOfRockets; i++) {
            executorService.execute(patriotBattery::launchPatriot);
        }
        executorService.shutdown();

    }
}
