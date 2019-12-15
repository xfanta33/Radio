package fr.xfanta.radio;

import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.util.WindowMover;
import fr.xfanta.radio.utils.Folder;
import fr.xfanta.radio.utils.RadioList;

import javax.swing.*;

public class Radio extends JFrame {

    private static Radio instance;
    private RadioAddon radioAddon;

    public Radio(){
        setTitle("Radio");
        setSize(300, 200);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        Folder.SetURL();
        setContentPane(this.radioAddon = new RadioAddon());
        WindowMover mover = new WindowMover(this);
        addMouseListener(mover);
        addMouseMotionListener(mover);
        RadioAddon.setRadioPlayFieldEnabled(false);
        RadioAddon.setRadioStopFieldEnabled(false);
        setVisible(true);
    }

    public static void main(String[] args){
        RadioList.RadioListSet();
        Folder.SetURL();
        Swinger.setSystemLookNFeel();
        Swinger.setResourcePath("/fr/xfanta/radio/resources/");
        instance = new Radio();
    }

    public static Radio getInstance(){
        return instance;
    }

    public RadioAddon getLauncherPanel(){
        return this.radioAddon;
    }

}
