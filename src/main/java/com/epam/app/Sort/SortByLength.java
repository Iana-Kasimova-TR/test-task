package com.epam.app.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Iana_Kasimova on 10/27/2017.
 */
public class SortByLength{

    //use bubble sort
    public List<String> sort(List<String> input){
        Collections.sort(input, new Comparator<String>(){
            public int compare(String str1, String str2) {
                if(str1.length() > str2.length()){
                    return 1;
                }else{
                    if(str1.length() < str2.length()){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }

    });
        return input;

    }
}
