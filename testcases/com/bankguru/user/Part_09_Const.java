package com.bankguru.user;

public class Part_09_Const {
    public static String browserName ="Chrome";
    public enum Browser{
        CHROME, FIREFOX, CHROMEHEADLESS;
    }
    public static void main (String[]args){
        System.out.println(browserName.toUpperCase());
        Browser browser= Browser.valueOf(browserName.toUpperCase());
        System.out.println(browserName);
    }
}
