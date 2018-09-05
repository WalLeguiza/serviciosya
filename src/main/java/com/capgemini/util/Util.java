package com.capgemini.util;

public class Util {

    public static boolean isNumeric(String n){
        boolean is = Boolean.TRUE;
        try{
            Integer.valueOf(n);
        }catch (NumberFormatException e){
            is = Boolean.FALSE;
        }
        return is;
    }
}
