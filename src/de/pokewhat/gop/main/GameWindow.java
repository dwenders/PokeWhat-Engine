package de.pokewhat.gop.main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dwenders on 21.03.2016.
 */
public class GameWindow extends JFrame{

    boolean fse = false;
    int fsm = 0;
    GraphicsDevice device;


    public GameWindow( String title, int width, int height, GraphicsDevice device){
        super(device.getDefaultConfiguration());
        this.device = device;

        setTitle(title);
        setSize(width, height);
        //setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void setfullscreen(){
        switch(fsm){
            case 1:
                //setUndecorated(false);
                System.out.println("No FullScreen");
                break;
            case 2:
                setUndecorated(true);
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                break;
            case 3:
                setUndecorated(true);
                device.setFullScreenWindow(this);
                break;
        }
    }

    public void setFullscreen(int fsnm){
        fse = true;
        if(fsm<=2){
            this.fsm = fsnm;
            setfullscreen();
        } else {
            System.out.println("Error "+fsnm+" is not supported!");
        }
    }

}
