package edu.iis.mto.multithread;

public class BetterRadar extends Radar
    {
    private PatriotLauncher patriotLauncher;

    public BetterRadar(PatriotBattery battery, PatriotLauncher patriotLauncher,Integer numberOfPatriot)
        {
        super(battery,numberOfPatriot);
        this.patriotLauncher = patriotLauncher;
        }

    @Override
    public void notice(Scud enemyMissle)
        {
        patriotLauncher.launch(super.getBattery(), super.getNumberOfPatriot());
        }
    }
