package com.traq.mongo.hadoop.hive;


import com.traq.mongo.hadoop.bean.Track;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Comparator;

public class TrackSortingClass
        implements Comparator<Track> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrackSortingClass.class);


    public int compare(Track track1, Track track2) {
        long time1 = 0L;

        long time2 = 0L;


        try {
            time1 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(track1.getOriginated()).getTime();

            time2 = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(track2.getOriginated()).getTime();
        } catch (Exception exception) {

            LOGGER.info("PARSE EXCEPTION IN COMPARATOR CLASS (DATESORTINGCLASS) : " + exception.getMessage());
        }

        if (time2 < time1) {
            return 1;
        }
        if (time1 < time2) {
            return -1;
        }


        return 0;
    }
}

