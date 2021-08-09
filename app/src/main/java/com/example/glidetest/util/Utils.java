package com.example.glidetest.util;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static Utils mReadingManager;
    public static List<String> list;

/*    public static Utils getInstance() {
        if (mReadingManager == null) {
            mReadingManager = new Utils();
        }
        return mReadingManager;
    }*/

    public static List<String> setList() {
        list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        list.add("21");
        list.add("22");
        list.add("23");
        return list;
    }

    public Utils() {

    }
}
