package model;

import java.awt.Color;

public class BlueColorFactory implements ColorFactory {

    @Override
    public Color createColor() {
        int red = 0;
        int green = 0;
        int blue = 255;
        return new Color(red, green, blue);
    }
    
}
