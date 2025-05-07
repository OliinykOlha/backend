package com.ait;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 1980);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 23);

        SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd EEEE", Locale.CANADA);
        Date date = calendar.getTime();
        String dayOfBi = format.format(date);
        System.out.println("I was born  " + dayOfBi);

        calendar.add(Calendar.YEAR, 5);
        calendar.add(Calendar.WEEK_OF_MONTH, 3);
        Date date1 = calendar.getTime();
        System.out.println("New time is " + format.format(date1));





    }
}