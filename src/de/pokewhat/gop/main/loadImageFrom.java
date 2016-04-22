package de.pokewhat.gop.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by dwenders on 22.03.2016.
 */
public class loadImageFrom {

    public static BufferedImage loadImageFrom(Class<?> classfile, String path){
        URL url = classfile.getResource(path);
        BufferedImage img = null;

        try{
            img = ImageIO.read(url);
        }catch(IOException e){
            e.printStackTrace();
        }

        return img;

    }

}
