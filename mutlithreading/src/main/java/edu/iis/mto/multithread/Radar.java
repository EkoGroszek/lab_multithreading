package edu.iis.mto.multithread;

public class Radar
    {
    private PatriotBattery battery;

    private Integer numberOfPatriot;
    public Radar(PatriotBattery battery, Integer numberOfPatriot)
        {
        this.battery = battery;
        this.numberOfPatriot = numberOfPatriot;
        }

    public void notice(Scud enemyMissle)
        {
        launchPatriot();
        }

    public Integer getNumberOfPatriot()
        {
        return numberOfPatriot;
        }

    public PatriotBattery getBattery()
        {
        return battery;
        }

    private void launchPatriot()
        {
        Runnable launchPatriotTask = new Runnable()
            {
            public void run()
                {
                for (int i = 0; i < numberOfPatriot; i++)
                    {
                    battery.launchPatriot();
                    }
                }
            };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
        }
    }
