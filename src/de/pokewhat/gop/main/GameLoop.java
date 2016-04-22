package de.pokewhat.gop.main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by dwenders on 22.03.2016.
 */
public class GameLoop extends JPanel implements Runnable {

    private Thread thread;
    private boolean running;

    private int fps, tps, width, height;

    public Graphics2D graphics2D;
    private BufferedImage img;

    public static double currFPS = 120D;


    public GameLoop(int width, int height) {
        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
        setFocusable(false);
        requestFocus();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        //INIT
        init();

        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D / currFPS;
        int frames = 0;
        int ticks = 0;
        long lastTimer = System.currentTimeMillis();
        double deltaTime = 0;

        while (running) {
            long now = System.nanoTime();
            deltaTime += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = false;

            while (deltaTime >= 1) {
                ticks++;
                //TICK + DeltaTime
                tick(deltaTime);
                deltaTime -= 1;
                shouldRender = true;
            }

            if (shouldRender == true) {
                frames++;
                //Render
                render();
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (System.currentTimeMillis() - lastTimer >= 1000) {
                lastTimer += 1000;
                tps = frames;
                fps = ticks;
                frames = 0;
                ticks = 0;
            }
        }
    }

    public void init() {
        img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        graphics2D = (Graphics2D) img.getGraphics();
        running = true;
    }

    public void render() {
        graphics2D.clearRect(0,0,width,height);
    }

    public void tick(double deltaTime) {
    }

    public void clear(){
        Graphics g2 = getGraphics();
        if(img != null){
            g2.drawImage(img,0,0,null);
        }
        g2.dispose();
    }





}
