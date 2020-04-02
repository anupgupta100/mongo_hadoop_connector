package com.traq.mongo.hadoop.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Properties;

public abstract class BaseInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseInitializer.class);
    public static Properties properties = null;

    public static Properties loadProperties() {
        try {
            if (null == properties) {
                properties = new Properties();
                properties.load(new FileInputStream("config.properties"));
            }
        } catch (IOException cause) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("EXCEPTION: Configuration Properties Not Found", cause);
            } else {
                System.out.println("EXCEPTION: Configuration Properties Not Found" + cause.getMessage());
            }
        }
        return properties;
    }

    public static Date startDate() {
        Date startDate = null;
        try {
            String startDateStr = properties.getProperty("START_DATE");
            if (null != startDateStr && !startDateStr.trim().isEmpty())
                startDate = sdf.parse(startDateStr);
        } catch (ParseException e) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("EXCEPTION: Configuration Properties Not Found", e);
            }
        }
        return startDate;
    }

    public static Date dateParse(String startDateStr) {
        Date startDate = null;
        try {
            if (null != startDateStr && !startDateStr.trim().isEmpty())
                startDate = sdf.parse(startDateStr);
        } catch (ParseException e) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("EXCEPTION: Configuration Properties Not Found", e);
            }
        }
        return startDate;
    }

    public int startAssetId() {
        int value = 0;
        try {
            String dayDiff = properties.getProperty("START_ASSET_ID");
            value = Integer.valueOf(dayDiff);
            if (value <= 0) {
                value = 1;
            }
        } catch (NumberFormatException e) {
            value = 1;
        }
        return value;
    }

    public int endAssetId() {
        int value = 0;
        try {
            String dayDiff = properties.getProperty("END_ASSET_ID");
            value = Integer.valueOf(dayDiff);
            if (value < 0) {
                value = 0;
            }
        } catch (NumberFormatException e) {
            value = 0;
        }
        return value;
    }

    public int dayDiff() {
        int dayDiffInt = 0;
        try {
            String dayDiff = properties.getProperty("DAY_DIFF");
            dayDiffInt = Integer.valueOf(dayDiff);
            if (dayDiffInt < 1 || dayDiffInt > 10) {
                dayDiffInt = 1;
            }
        } catch (NumberFormatException e) {
            dayDiffInt = 1;
        }
        return dayDiffInt;
    }


    public boolean isProd() {
        boolean val = Boolean.TRUE;

        String mode = properties.getProperty("MODE_RUN");
        if (mode != null && mode.compareToIgnoreCase("TEST") == 0) {
            val = Boolean.FALSE;
        }

        return val;
    }

    public String stopDate(Date startDate, int dayDiffInt) {
        String stopDate = null;
        try {
            Instant after = startDate.toInstant();

            after = after.plus(Duration.ofDays(dayDiffInt));

            Date dateAfter = Date.from(after);
            stopDate = sdf.format(dateAfter);
        } catch (Exception e) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("EXCEPTION: Configuration Properties Not Found", e);
            }
        }
        return stopDate;
    }

    public boolean validateStopDate(String stopDate) {
        Date configStopDate = null;
        Date reqStopDate = null;
        boolean isMaxValueReached = Boolean.TRUE;
        try {
            String stopDateStr = properties.getProperty("STOP_DATE");
            if (null != stopDateStr && !stopDateStr.trim().isEmpty())
                configStopDate = sdf.parse(stopDateStr);

            if (null != stopDate && !stopDate.trim().isEmpty())
                reqStopDate = sdf.parse(stopDate);

            if (reqStopDate.compareTo(configStopDate) > 0) {
                LOGGER.info("StopDate : " + reqStopDate + " greater than config end Date : " + configStopDate + ", so stop program");
                System.out.println("StopDate : " + reqStopDate + " greater than config end Date : " + configStopDate + ", so stop program");
                isMaxValueReached = Boolean.FALSE;
            }
        } catch (ParseException e) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("validateStopDate ParseException: Configuration Properties Not Found", e);
            }
        }
        return isMaxValueReached;
    }

    public boolean checkNullAndEmpty(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return true;
    }

    protected DecimalFormat twoDecimalPlaces = new DecimalFormat("0.00");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
}
