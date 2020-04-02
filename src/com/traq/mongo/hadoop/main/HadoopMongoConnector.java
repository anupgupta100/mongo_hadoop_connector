package com.traq.mongo.hadoop.main;

import com.traq.mongo.hadoop.bean.Asset;
import com.traq.mongo.hadoop.common.BaseInitializer;
import com.traq.mongo.hadoop.hive.HdfsTrackBean;
import com.traq.mongo.hadoop.hive.HiveClient;
import com.traq.mongo.hadoop.mongo.MongoQueryData;
import com.traq.mongo.hadoop.sql.SqlQueryData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class HadoopMongoConnector extends BaseInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(HadoopMongoConnector.class);

    public HadoopMongoConnector() {
        loadProperties();
    }

    public void startApp() {
        List<Asset> assetList = null;
        HiveClient hiveClient = null;
        MongoQueryData queryData = null;
        String startDateStr = null;
        String stopDateStr = null;
        Date inputCurrentDate = null;
        int dayDiff = 0;
        HdfsTrackBean trackBean = null;
        String initialStartDateStr = null;
        String initialEndDateStr = null;
        try {
            // Fetch Asset from SQL Data Base
            SqlQueryData sqlQueryData = new SqlQueryData();
            assetList = sqlQueryData.fetchAssetIdFromSql();

            // Hive Object Initialize
            hiveClient = new HiveClient();
            startDateStr = this.properties.getProperty("START_DATE");
            inputCurrentDate = dateParse(startDateStr);
            dayDiff = dayDiff();
            stopDateStr = stopDate(inputCurrentDate, dayDiff);
            initialStartDateStr = startDateStr;
            initialEndDateStr = stopDateStr;
            // Mongo Object
            queryData = new MongoQueryData();
            int startAssetId = startAssetId();
            int endAssetId = endAssetId();

            int dateCounter = 0;

            if (assetList != null && assetList.size() > 0) {

                for (Asset asset : assetList) {

                    if (endAssetId > 0 && asset.getAsset_id() <= endAssetId) {


                        if (asset.getAsset_id() >= startAssetId) {
                            while (validateStopDate(stopDateStr)) {
                                if (dateCounter == 0) {
                                    // Do nothing
                                } else {
                                    String tmpDateStr = stopDateStr;
                                    startDateStr = tmpDateStr;
                                    Date nwStopDate = dateParse(tmpDateStr);
                                    stopDateStr = stopDate(nwStopDate, dayDiff);
                                }

                                if (asset != null && asset.getAsset_id() > 0)
                                    trackBean = hiveClient.fetchTrackOrcData(asset.getAsset_id() + "", startDateStr, stopDateStr,
                                            asset.getAccount_id(), null);
                                if (trackBean != null && trackBean.getDocuments() != null
                                        && trackBean.getDocuments().size() > 0) {
                                    queryData.insertManyTrackData(trackBean.getDocuments());
                                } else {
                                    System.out.println("No Data Fetch, No entry in Mongo Db");
                                }
                                dateCounter++;
                            }
                            ;

                            LOGGER.info("HadoopMongoConnector .................... Copy Data for specified date range for Asset_Id ["
                                    + asset.getAsset_id() + "], Account_Id [" + asset.getAccount_id() + "] StartDate ["
                                    + initialStartDateStr + "], End Date [" + stopDateStr + "] Complete");
                            System.out.println("HadoopMongoConnector .................... Copy Data for specified date range for Asset_Id ["
                                    + asset.getAsset_id() + "], Account_Id [" + asset.getAccount_id() + "] StartDate ["
                                    + initialStartDateStr + "], End Date [" + stopDateStr + "] Complete");

                            // Reset Data
                            dateCounter = 0;
                            startDateStr = initialStartDateStr;
                            stopDateStr = initialEndDateStr;

                            if (!isProd()) {
                                LOGGER.info("TEST MODE RUN, So Stop Application !!! ");
                                System.out.println("TEST MODE RUN, So Stop Application !!! ");
                                break;
                            }
                        } else {
                            System.out.println("Skip Asset Id : " + asset.getAsset_id() + ", Config StartAssetId :" + startAssetId
                                    + ", EndAssetId : " + endAssetId);
                        }
                    } else {
                        System.out.println("Skip Asset Id : " + asset.getAsset_id() + ", Config StartAssetId :" + startAssetId
                                + ", EndAssetId : " + endAssetId + " Stop Processing");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("HadoopMongoConnector .................. Exception !!! ", e);
            System.out.println("HadoopMongoConnector .................. Exception !!! " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        HadoopMongoConnector connector = new HadoopMongoConnector();
        connector.startApp();
    }

}
