package edu.iis.mto.multithread;

import org.junit.runners.model.Statement;

public class RepeatStatement extends Statement {

    private int times;
    private Statement statement;

    RepeatStatement(int times, Statement statement) {
        this.times = times;
        this.statement = statement;
    }

    @Override
    public void evaluate() throws Throwable {
        for (int i = 0; i < times; i++) {
            statement.evaluate();
        }
    }
}
