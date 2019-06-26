package edu.iis.mto.multithread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MultiThreadWithExecutors implements PatriotLauncher
    {
    private Executor executor;


    public MultiThreadWithExecutors(Executor executor)
        {
        this.executor = executor;
        }

    public MultiThreadWithExecutors()
        {
        executor = Executors.newCachedThreadPool();
        }


    @Override
    public void launch(PatriotBattery patriotBattery, Integer times)
        {
        IntStream.range(0, times).forEach(value -> executor.execute(() -> patriotBattery.launchPatriot()));
        }

    }
