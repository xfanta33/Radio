package fr.xfanta.radio;

import javazoom.jl.player.JavaSoundAudioDevice;
import javazoom.jl.player.Player;

import javax.swing.*;
import java.net.URL;

public class Autre
        implements Runnable
{
    public static String streamURL;
    private Thread pThread;
    private Player player;
    private float volume;

    public Autre(float vol)
    {
        this.volume = vol;
        try
        {
            this.pThread = new Thread(this);
            this.pThread.start();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        try
        {
            this.player = new Player(new URL(streamURL).openStream());
            JavaSoundAudioDevice.radioVolume = this.volume;
            this.player.play();
        }
        catch (Exception e)
        {
            RadioAddon.setRadioPlayFieldEnabled(true);
            RadioAddon.setRadioStopFieldEnabled(false);
            RadioAddon.setRadioListFieldEnabled(true);
            JOptionPane.showMessageDialog(null, "L'url ne marche pas", "Erreur", 0);
        }
    }

    public void stop()
    {
        if ((this.player != null) && (isPlaying()))
        {
            this.volume = 0.0F;
            JavaSoundAudioDevice.radioVolume = -40.0F;
            this.player.close();
        }
    }

    public boolean isPlaying()
    {
        return this.pThread.isAlive();
    }

    public void setVolume(float f)
    {
        if (this.player != null)
        {

            this.volume = f;
            JavaSoundAudioDevice.radioVolume = f;
        }
    }

    public float getVolume()
    {
        return JavaSoundAudioDevice.radioVolume;
    }

}
