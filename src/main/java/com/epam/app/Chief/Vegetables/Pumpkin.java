package com.epam.app.Chief.Vegetables;

import com.epam.app.Chief.Enums.Colour;
import com.epam.app.Chief.Enums.Shape;
import com.epam.app.Chief.Enums.Taste;

/**
 * Created by Iana_Kasimova on 10/30/2017.
 */
public class Pumpkin extends Vegetable {

    public Pumpkin(Double weight, Taste taste){
        super(weight, taste);
        this.colour = Colour.ORANGE;
        this.shape = Shape.ROUND;
    }
    //we can get ClassCastException
    @Override
    public int compareTo(Object o) {
        return super.compareTo((Vegetable)o);
    }
}
