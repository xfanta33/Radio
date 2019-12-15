package fr.xfanta.radio;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.event.SwingerEvent;
import fr.theshark34.swinger.event.SwingerEventListener;
import fr.theshark34.swinger.textured.STexturedButton;
import fr.xfanta.radio.utils.Folder;
import fr.xfanta.radio.utils.RadioList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioAddon extends JPanel implements SwingerEventListener, ActionListener {

    private static JComboBox RadioL = new JComboBox(RadioList.getRadioList().keySet().toArray());
    private static STexturedButton playAutreMButton = new STexturedButton(Swinger.getResource("playM.png"), Swinger.getResource("playMF.png"));
    private static STexturedButton stopAutreMButton = new STexturedButton(Swinger.getResource("stopM.png"), Swinger.getResource("stopMF.png"));
    private static final JSlider AutreSlider = new JSlider();
    public static Autre AutreRadio;
    public static int vol = -20;

    public RadioAddon(){
        setLayout(null);

        RadioL.setBounds(0, 0, 300, 30);
        RadioL.addActionListener(this);
        add(RadioL);

        playAutreMButton.setBounds(70, 60);
        playAutreMButton.addEventListener(this);
        add(playAutreMButton);

        stopAutreMButton.setBounds(170, 60);
        stopAutreMButton.addEventListener(this);
        add(stopAutreMButton);

        AutreSlider.setBounds(0, 120, 283, 50);
        AutreSlider.setMinimum(-80);
        AutreSlider.setMaximum(6);
        AutreSlider.setValue(vol);
        AutreSlider.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                if ((RadioAddon.AutreRadio != null) && (RadioAddon.AutreRadio.isPlaying())) {
                    RadioAddon.AutreRadio.setVolume(Float.valueOf(RadioAddon.AutreSlider.getValue()).floatValue());
                }
            }
        });
        add(AutreSlider);

    }

    public void onEvent(SwingerEvent e) {
        if (e.getSource() == playAutreMButton){
            setRadioPlayFieldEnabled(false);
            setRadioStopFieldEnabled(true);
            setRadioListFieldEnabled(false);
            AutreRadio = new Autre(Float.valueOf(AutreSlider.getValue()).floatValue());
        }else if (e.getSource() == stopAutreMButton) {
            AutreRadio.stop();
            setRadioPlayFieldEnabled(true);
            setRadioStopFieldEnabled(false);
            setRadioListFieldEnabled(true);
        }
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println(RadioList.getRadioList().get(RadioL.getSelectedItem()));
        Autre.streamURL = RadioList.getRadioList().get(RadioL.getSelectedItem());
        if (RadioList.getRadioList().get(RadioL.getSelectedItem()).equals("v7E2u8Ua")){
            setRadioPlayFieldEnabled(false);
        }else if(RadioList.getRadioList().get(RadioL.getSelectedItem()).equals("v7E2u8Ub")){
            String url = JOptionPane.showInputDialog("URL", Folder.getURL());
            Autre.streamURL = url;
            setRadioPlayFieldEnabled(true);
            Folder.SaveURL(url);
        } else{
            setRadioPlayFieldEnabled(true);
        }

    }

    public static void setRadioPlayFieldEnabled(boolean enabled)
    {
        playAutreMButton.setEnabled(enabled);
    }

    public static void setRadioStopFieldEnabled(boolean enabled)
    {
        stopAutreMButton.setEnabled(enabled);
    }

    public static void setRadioListFieldEnabled(boolean enabled)
    {
        RadioL.setEnabled(enabled);
    }

}
