package edu.iis.mto.multithread;

public class SingleThreadLauncher implements RocketLauncher {

    @Override
    public void launchRockets(int amount, PatriotBattery battery) {
        for (int i = 0; i < amount; i++) {
            battery.launchPatriot();
        }
    }
}
