/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.beans.property.BooleanProperty;

/**
 *
 * @author szeman
 */
public  class GlobalState {
    private final GlobalState g = new GlobalState();
    
    public GlobalState get(){
        return this.g;
    }
    
    public static boolean isNewItemRadioSelected;
    public static boolean isMoveItemRadioSelected;
    public static boolean isDeleteItemRadioSelected;
    
}
