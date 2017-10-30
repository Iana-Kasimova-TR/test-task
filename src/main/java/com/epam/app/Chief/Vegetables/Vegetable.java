package com.epam.app.Chief.Vegetables;

import com.epam.app.Chief.CustomException.NotExistThisColourException;
import com.epam.app.Chief.CustomException.NotExistThisShapeException;
import com.epam.app.Chief.CustomException.NotExistThisTasteException;
import com.epam.app.Chief.Enums.Colour;
import com.epam.app.Chief.Enums.Shape;
import com.epam.app.Chief.Enums.Taste;

import java.util.*;

/**
 * Created by Iana_Kasimova on 10/27/2017.
 */
public abstract class Vegetable implements Comparable{

    public Shape shape;
    public Taste taste;
    public Colour colour;
    public Double weight;

    public Vegetable(Double weight, Taste taste){
        this.taste = taste;
        this.weight = weight;
    }

    /**
     *
     * @param vegetables - which we have to sort
     * @param rangeOfParameters - in keys of this hashMap our enums, in values our lists enumvalues, from first element in list to second element in list, if only one enum value in range, then first element equals second element
     * @param <E> - any type of Enum
     * @return vegetables which we sorted
     */
    public static <E extends  Enum<E>> List<Vegetable> findByRangeParameters(List<Vegetable> vegetables, HashMap<Enum<E>, List<String>> rangeOfParameters, Double weight1, Double weight2) {
        isEmpty(vegetables);
        isEmpty(rangeOfParameters);
        List<Vegetable> vegetableList = new ArrayList<>();
        boolean vegetableIsSuit = true;
        for (Vegetable vegetable : vegetables) {
            for (Map.Entry<Enum<E>, List<String>> value : rangeOfParameters.entrySet()) {
                if (value.getKey().getClass().toString().equals(vegetable.shape.getClass().toString())) {
                    if (!itBelongsToRange(Shape.class, value.getValue().get(0), value.getValue().get(1), vegetable.shape.toString())) {
                        vegetableIsSuit = false;
                    }
                }
                if (value.getKey().getClass().toString().equals(vegetable.taste.getClass().toString())) {
                    if (!itBelongsToRange(Taste.class, value.getValue().get(0), value.getValue().get(1), vegetable.taste.toString())) {
                        vegetableIsSuit = false;
                    }
                }
                if (value.getKey().getClass().toString().equals(vegetable.colour.getClass().toString())) {
                    if (!itBelongsToRange(Colour.class, value.getValue().get(0), value.getValue().get(1), vegetable.colour.toString())) {
                        vegetableIsSuit = false;
                    }
                }
            }
            if ((weight1 != null) && (weight2 != null) && vegetableIsSuit) {
                if ((weight1.doubleValue() <= vegetable.weight.doubleValue()) &&(vegetable.weight.doubleValue()<= weight2.doubleValue())){
                               vegetableList.add(vegetable);
                            }
                        }
        }
        return vegetableList;
    }


    private static List<Vegetable> sortByShape(List<Vegetable> vegetables, String parameter){
        isEmpty(vegetables);
        try{
               Shape.valueOf(parameter);
           }catch (Exception e){
               throw new NotExistThisShapeException("this is not correct shape of vegetables!");
           }
            List<Vegetable> vegetableList = new ArrayList<>();
        for (Vegetable vegetable:vegetables) {
            if(vegetable.shape == Shape.valueOf(parameter)){
                vegetableList.add(vegetable);
            }
        }
        return vegetableList;
    }

    private static List<Vegetable> sortByTaste(List<Vegetable> vegetables, String parameter){
        isEmpty(vegetables);
        try{
            Shape.valueOf(parameter);
        }catch (Exception e){
            throw new NotExistThisTasteException("this is not correct shape of vegetables!");
        }
        List<Vegetable> vegetableList = new ArrayList<>();
        for (Vegetable vegetable:vegetables) {
            if(vegetable.taste == Taste.valueOf(parameter)){
                vegetableList.add(vegetable);
            }
        }
        return vegetableList;
    }

    private static List<Vegetable> sortByColour(List<Vegetable> vegetables, String parameter){
        isEmpty(vegetables);
        try{
            Shape.valueOf(parameter);
        }catch (Exception e){
            throw new NotExistThisColourException("this is not correct shape of vegetables!");
        }
        List<Vegetable> vegetableList = new ArrayList<>();
        for (Vegetable vegetable:vegetables) {
            if(vegetable.colour == Colour.valueOf(parameter)){
                vegetableList.add(vegetable);
            }
        }
        return vegetableList;
    }

    public static void isEmpty(List<Vegetable> vegetables){
        if(vegetables.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    public static<E extends  Enum<E>> void isEmpty(Map<Enum<E>, List<String>> rangeOfParameters){
        if(rangeOfParameters.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    public static <E extends  Enum<E>> boolean itBelongsToRange(Class<E> enumType, String enumValue1, String enumValue2, String enumValue){
       if(Enum.valueOf(enumType, enumValue2).compareTo(Enum.valueOf(enumType, enumValue1))<0){
          System.out.println("here is  not corrected range of parameters!");
           throw new IllegalArgumentException();
       }
        boolean isBelong = false;
        if(Enum.valueOf(enumType, enumValue).compareTo(Enum.valueOf(enumType, enumValue1))>=0){
            if(Enum.valueOf(enumType, enumValue).compareTo(Enum.valueOf(enumType, enumValue2))<=0){
                isBelong = true;
            }
        }
        return isBelong;
    }

    public int compareTo(Vegetable vegetable) {
        return this.weight.compareTo(vegetable.weight);
    }
}
