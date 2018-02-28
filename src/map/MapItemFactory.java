/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 *
 * @author szeman
 */
public class MapItemFactory {

    public static MapItem getNew() {
        return new MapItem();
    }

    public static MapItem getNew(double x, double y, Pane p, Image im) {
        return new MapItem(x,y,p,im);
    }
    
}
