package com.traq.mongo.hadoop.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
       TestDate test = new TestDate();
       test.compareDateTest();
    }

//    private void testTime(){
//        int days = 1;
//        Date date = new Date(System.currentTimeMillis());
//        Calendar cal = Calendar.getInstance();
//        cal.set(1900 + date.getYear(), date.getMonth(), date.getDate(), 0, 0, 0);
//        cal.add(5, -days);
//        System.out.println(cal.getTime());
//    }

    private void compareDateTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date configStopDate = null;
        Date reqStopDate = null;
        boolean isMaxValueReached = false;
        try {
            String stopDate = "2019-12-31";
            String stopDateStr = "2019-12-30";
            if (null != stopDateStr && !stopDateStr.trim().isEmpty())
                configStopDate = sdf.parse(stopDateStr);

            if (null != stopDate && !stopDate.trim().isEmpty())
                reqStopDate = sdf.parse(stopDate);

            if (reqStopDate.compareTo(configStopDate) > 0) {
                isMaxValueReached = true;
            }
            System.out.println(isMaxValueReached);
        } catch (ParseException e) {
           e.printStackTrace();
        }
    }

    private void testDate(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse("2017-03-02");
            System.out.println(startDate.toString());

//            LocalDate localDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//            System.out.println(localDate.toString());
//
//            localDate = localDate.plusDays(1);
//
//            System.out.println(localDate.toString());


            Instant after = startDate.toInstant();
            after = after.plus(Duration.ofDays(1));

            Date dateAfter = Date.from(after);
            String stopDateVal = sdf.format(dateAfter);
            System.out.println(stopDateVal);
            Date stopDate = sdf.parse(sdf.format(dateAfter));
            System.out.println(stopDate.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
