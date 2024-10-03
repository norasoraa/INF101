package model;

import java.awt.Color;

public interface ColorFactory {
    Color createColor();



    
    /*
     * //kunne også vært implementert slik:
     * default Color createColor() {
     *    return new Color(255, 255, 255);
     * }
     */
}
