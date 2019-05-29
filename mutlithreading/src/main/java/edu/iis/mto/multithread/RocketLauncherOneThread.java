package edu.iis.mto.multithread;

public class RocketLauncherOneThread {

    public void launchRockets(PatriotBattery battery, int numberOfRockets) {
        for (int i = 0; i < numberOfRockets; i++) {
            battery.launchPatriot();
        }
    }
}
