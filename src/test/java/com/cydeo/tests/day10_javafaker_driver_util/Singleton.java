package com.cydeo.tests.day10_javafaker_driver_util;

public class Singleton {

    private Singleton() {

    }

    private static String word;

    public static String getWord() {

        if (word == null) {
            System.out.println("First time call. Word object is null" + " Assigning the value now");
            word = "something";

        } else {
            System.out.println("Word already has value");
        }

        return word;

    }

}
