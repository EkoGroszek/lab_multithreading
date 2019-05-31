package edu.iis.mto.multithread;

import java.util.concurrent.Executor;


public class NewExecutor implements Executor {

    private JobType jobType;

    public NewExecutor(JobType type) {
        this.jobType = type;
    }

    @Override
    public void execute(Runnable command) {
        switch (jobType) {
            case NEW:
                new Thread(command).run();
                break;
            case THIS:
                command.run();
                break;
        }
    }
}
