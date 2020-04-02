package com.traq.mongo.hadoop.hive;

import com.mongodb.client.MongoDatabase;
import com.traq.mongo.hadoop.bean.Track;
import com.traq.mongo.hadoop.common.BaseInitializer;
import com.traq.mongo.hadoop.common.Constants;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class HiveClient extends BaseInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HiveQueryData.class);
    HiveQueryData queryData = null;
    private Properties properties = null;

    public HiveClient() {
        queryData = new HiveQueryData();
        this.properties = loadProperties();
    }

    /**
     * Method used for fetch hdfs table 'bsfc_aws_track_orc' based on AssetID, startDate and EndDate
     *
     * @param assetId   -- AssetID fetch from SQL database
     * @param startDate
     * @param stopDate
     * @return HdfsTrackBean object which has hdfs track DataList, Json response and all input fields
     */
    public HdfsTrackBean fetchTrackOrcData(String assetId, String startDate, String stopDate,
                                           Long accountId, MongoDatabase mongoDatabase) {
        HdfsTrackBean bean = null;
        List<Track> datalist = null;
        String partcol = null;
        String response = "";
        String error = "";
        String result = "SUCCESS";
        try {
            bean = new HdfsTrackBean();

            if (assetId.matches("[0-9]+")) {

                partcol = startDate.substring(0, 7).replace("-", "") + (Long.parseLong(assetId) % 1000L);

                // Input Request
                bean.setAssetId(assetId);
                bean.setPartcol(partcol);
                bean.setStartDate(startDate);
                bean.setStopDate(stopDate);

                bean.setDocuments(queryData.fetchDocumentFromHdfs(partcol, assetId, accountId, startDate, stopDate));
//                datalist = queryData.fetchTrackFromHdfs(partcol, assetId, startDate, stopDate);

                // Input Response
//                bean.setDatalist(datalist);

                if (null != bean.getDocuments() && bean.getDocuments().size() > 1) {
//                    Collections.sort(datalist, (Comparator<? super Track>) new TrackSortingClass());
//                    Gson gson = new Gson();
//                    response = gson.toJson(bean.getDocuments());
                    response = "{'DATA':DATA Fetch" + ", 'Size':'" + bean.getDocuments().size() + "', 'RESULT':'" + result + "'}";
                } else {
                    result = "No Data Found";
                    response = "{'DATA':DATA Not Fetch" + ", 'ERROR':'" + "No Data" + "', 'RESULT':'" + result + "'}";
                }

                bean.setResponseJson(response);
                bean.setError(error);
                bean.setResultDesc(result);

                System.out.println("Response ................. fetchTrackOrcData :: " + bean.toString());
                LOGGER.info("Response ................. fetchTrackOrcData :: " + bean.toString());

            }
        } catch (NumberFormatException e) {
            System.out.println("HiveClient ............... NumberFormatException !!!" + e.getMessage());
            e.printStackTrace();
            LOGGER.error("HiveClient ............... NumberFormatException !!!", e);
            error = "ASSET_ID should only be numbers.";
            result = "FAILED (Validation Error)";
            response = "{'DATA':" + response + ", 'ERROR':'" + error + "', 'RESULT':'" + result + "'}";
            bean.setResponseJson(response);
            bean.setError(error);
            bean.setResultDesc(result);

        } catch (SQLException e) {
            System.out.println("HiveClient ............... SQLException !!!" + e.getMessage());
            e.printStackTrace();
            LOGGER.error("HiveClient ............... SQLException !!!", e);
            error = "Hive Connection not establish";
            result = "FAILED (Connection Fail)";
            response = "{'DATA':" + response + ", 'ERROR':'" + error + "', 'RESULT':'" + result + "'}";
            bean.setResponseJson(response);
            bean.setError(error);
            bean.setResultDesc(result);
            System.out.println("Application Halt, Due to SQL Exception !!! ");
            System.exit(-1);
        } catch (Exception exception) {
            System.out.println("HiveClient ............... Exception !!!" + exception.getMessage());
            exception.printStackTrace();
            LOGGER.error("HiveClient ............... Exception !!!", exception);
            error = exception.toString();
            result = "FAILED";
            response = "{'DATA':" + response + ", 'ERROR':'" + error + "', 'RESULT':'" + result + "'}";
            bean.setResponseJson(response);
            bean.setError(error);
            bean.setResultDesc(result);
        } finally {
            return bean;
        }
    }

    @Deprecated
    private Document createMongoDocument(Track data, Long accountId, String deviceId, MongoDatabase mongoDatabase) {
        Document doc = new Document();
        try {
            Double lat = Double.parseDouble(data.getLatitude());
            Double lng = Double.parseDouble(data.getLongitude());
            Double[] geo = new Double[]{lng, lat};
            /**
             * Extra Parameters
             */
            if (null != accountId)
                doc.append(Constants.NODEACCOUNTID, accountId);
            doc.append(Constants.NODEDEVICEID, Long.parseLong(deviceId));
            doc.append(Constants.NODEGEOCODE, Arrays.asList(geo));

            /**
             * HDFS DataBase Parameters
             */
            doc.append(Constants.NODELATITUDE, lat);
            doc.append(Constants.NODELONGITUDE, lng);
            doc.append(Constants.NODEALTITUDE, data.getAltitude());
            doc.append(Constants.NODECOURSE, data.getCourse());

            String speed = data.getSpeed();
            if (!checkNullAndEmpty(speed)) {
                speed = "0.0";
            }
            doc.append(Constants.NODESPEED, Double.parseDouble(speed.trim()));
            String ignition = data.getIgnition();
            if (ignition.isEmpty()) {
                ignition = "N";
            }
            doc.append(Constants.NODEIGNITION, ignition);
            String fuel = data.getFuel();
            if (fuel.isEmpty()) {
                fuel = "0.00";
            } else {
                fuel = twoDecimalPlaces.format(Double.parseDouble(fuel));
            }
            doc.append(Constants.NODEFUEL, Double.parseDouble(fuel));

            doc.append(Constants.NODEFUELS, data.getFuels());
            doc.append(Constants.NODETEMP, data.getTemp());
            doc.append(Constants.NODETEMPS, data.getTemps());
            doc.append(Constants.NODEMISC, data.getMisc());
            doc.append(Constants.NODEMISCS, data.getMiscs());
            doc.append(Constants.NODEAC, data.getAc());
            doc.append(Constants.NODEDOOR, data.getDoor());
            doc.append(Constants.NODERESERVED, data.getReserved());
            doc.append(Constants.NODEGPS, data.getGps());
            doc.append(Constants.NODESATELLITES, data.getSatelites());
            doc.append(Constants.NODEORIGINATED, data.getOriginated());
            doc.append(Constants.NODECREATED, data.getCreated());
            doc.append(Constants.NODELOCATION, data.getLocation());
            doc.append(Constants.NODEGEOCODEID, data.getGeocodeid());
            doc.append(Constants.NODEASSETID, data.getAssetid());
            doc.append(Constants.NODERAWDATAID, data.getRawdataid());
            doc.append(Constants.NODEORIGINATEDTS, data.getOriginatedts());
            doc.append(Constants.NODEPARTCOL, data.getPartcol());


        } catch (Exception e) {
            LOGGER.error("HiveClient ............... createMongoDocument, Exception !!!", e);
        }
        return doc;
    }


}




