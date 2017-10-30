package com.epam.app.Chief.Vegetables;

import com.epam.app.Chief.Enums.Colour;
import com.epam.app.Chief.Enums.Shape;
import com.epam.app.Chief.Enums.Taste;
import com.epam.app.Chief.Vegetables.Vegetable;

/**
 * Created by Iana_Kasimova on 10/30/2017.
 */
public class Zucchini extends Vegetable {

    public Zucchini(Double weight, Taste taste){
        super(weight, taste);
        this.colour = Colour.GREEN;
        this.shape = Shape.CYLINDER;
    }
    //we can get ClassCastException
    @Override
    public int compareTo(Object o) {
        return super.compareTo((Vegetable)o);
    }
}
