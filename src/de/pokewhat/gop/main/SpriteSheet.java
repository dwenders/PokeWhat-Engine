package de.pokewhat.gop.main;

import java.awt.image.BufferedImage;

/**
 * Created by dwenders on 22.03.2016.
 */
public class SpriteSheet {

    private BufferedImage spriteSheet;

    public SpriteSheet(){

    }

    public void setSpriteSheet(BufferedImage spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public BufferedImage getTile(int xTile, int yTile, int width, int height){
        BufferedImage sprite = spriteSheet.getSubimage(xTile, yTile, width, height);
        return sprite;
    }
}
