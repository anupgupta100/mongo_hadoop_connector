package com.traq.mongo.hadoop.hive;

import com.traq.mongo.hadoop.bean.Track;
import com.traq.mongo.hadoop.common.BaseInitializer;
import com.traq.mongo.hadoop.common.Constants;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class HiveQueryData extends BaseInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(HiveQueryData.class);

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

    private static Properties properties = null;

    private static Connection con = null;
    static Byte aByte = new Byte("1");

    public HiveQueryData() {
        properties = loadProperties();
    }

    private void loadPropertiesV2() {
        try {
            properties = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file not found in the classpath");
            }
        } catch (IOException e) {
            LOGGER.error("HiveQueryData .................. loadProperties !!!", e);
        }
    }

    /**
     * Create Hive Connection based on config parameters
     *
     * @return Connection Object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    protected static Connection getConnectionInstance() throws SQLException, ClassNotFoundException {
        try {
            if (null == con) {

                synchronized (aByte) {

                    if (null == con) {
                        String url = "jdbc:hive2://" + properties.getProperty("HIVE_SERVER")
                                + ":" + properties.getProperty("HIVE_PORT") + "/" + properties.getProperty("HIVE_DATABASE")
                                + "";
                        String userName = properties.getProperty("HIVE_USERNAME");
                        String password = properties.getProperty("HIVE_PASSWORD");
                        LOGGER.info("Initialize Hive Connection .................... " + driverName
                                + ", " + url + ", " + userName + ", " + password);
                        System.out.println("Initialize Hive Connection .................... " + driverName
                                + ", " + url + ", " + userName + ", " + password);
                        Class.forName(driverName);

                        con = DriverManager.getConnection(url, userName, password);
                        LOGGER.info("HIVE Connection Establish Successfully");
                        System.out.println("HIVE Connection Establish Successfully");
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("HIVE Connection Establish Failed", e);
            throw e;
        } catch (SQLException e) {
            LOGGER.error("HIVE Connection Establish Failed", e);
            throw e;
        }
        return con;
    }

    /**
     * Method will create Hive connection from HDFS and execute query on
     * table : 'bsfc_aws_track_orc' based on input attributes     *
     *
     * @param partcol
     * @param assetid
     * @param startDate
     * @param stopDate
     * @return list of track data object which consists of multiple row for input assetId in input date range
     * @throws SQLException
     */
    @Deprecated
    public List<Track> fetchTrackFromHdfs(String partcol, String assetid,
                                          String startDate, String stopDate) throws SQLException {
        Statement stmt = null;
        ResultSet res = null;
        List<Track> data = null;

        try {
            LOGGER.info("HiveQueryData ............................... fetchTrackFromHdfs :: " + partcol
                    + ", " + assetid + ", " + startDate + ", " + stopDate);

            con = this.getConnectionInstance();
            stmt = con.createStatement();

            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("select * from ").append(properties.getProperty("HIVE_TABLE_NAME_HISTORY"))
                    .append(" where partcol='").append(partcol).append("' and asset_id='")
                    .append(assetid).append("' and originated >= '").append(startDate)
                    .append("' and originated <= '").append(stopDate).append("'")
            ;
            LOGGER.info("Query :: " + queryBuilder.toString());
//            System.out.println("select * from " + properties.getProperty("HIVE_TABLE_NAME_HISTORY")
//                    + " where partcol='" + partcol + "' and asset_id='" + assetid + "' and originated >= '"
//                    + startDate + "' and originated <= '" + stopDate + "'");
//
//            ResultSet res = stmt.executeQuery("select * from " + properties.getProperty("HIVE_TABLE_NAME_HISTORY")
//                    + " where partcol='" + partcol + "' and asset_id='" + assetid + "' and originated >= '" + startDate
//                    + "' and originated <= '" + stopDate + "'");

            res = stmt.executeQuery(queryBuilder.toString());
            data = new ArrayList<>();
            while (res.next()) {

                Track track = new Track();

                track.setLatitude(res.getString(1));
                track.setLongitude(res.getString(2));

                if (res.getString(3) != null) {

                    track.setAltitude(res.getString(3));
                } else {

                    track.setAltitude("0");
                }

                if (res.getString(4) != null) {

                    track.setCourse(res.getString(4));
                } else {

                    track.setCourse("0");
                }

                if (res.getString(5) != null) {

                    track.setSpeed(res.getString(5));
                } else {

                    track.setSpeed("0");
                }

                if (res.getString(6) != null) {

                    track.setIgnition(res.getString(6));
                } else {

                    track.setIgnition("NA");
                }

                if (res.getString(7) != null) {

                    track.setFuel(res.getString(7));
                } else {

                    track.setFuel("0.0");
                }

                if (res.getString(8) != null) {

                    track.setFuels(res.getString(8));
                } else {

                    track.setFuels("0.0");
                }

                if (res.getString(9) != null) {

                    track.setTemp(res.getString(9));
                } else {

                    track.setTemp("0");
                }

                if (res.getString(10) != null) {

                    track.setTemps(res.getString(10));
                } else {

                    track.setTemps("0");
                }

                if (res.getString(11) != null) {

                    track.setMisc(res.getString(11));
                } else {

                    track.setMisc("NA");
                }

                if (res.getString(12) != null) {

                    track.setMiscs(res.getString(12));
                } else {

                    track.setMiscs("NA");
                }

                if (res.getString(13) != null) {

                    track.setAc(res.getString(13));
                } else {

                    track.setAc("NA");
                }

                if (res.getString(14) != null) {

                    track.setDoor(res.getString(14));
                } else {

                    track.setDoor("NA");
                }

                if (res.getString(15) != null) {

                    track.setReserved(res.getString(15));
                } else {

                    track.setReserved("NA");
                }

                if (res.getString(16) != null) {

                    track.setGps(res.getString(16));
                } else {

                    track.setGps("NA");
                }

                if (res.getString(17) != null) {

                    track.setSatelites(res.getString(17));
                } else {

                    track.setSatelites("0");
                }

                track.setOriginated(res.getString(18));
                track.setCreated(res.getString(19));

                if (res.getString(20) != null) {

                    track.setLocation(res.getString(20));
                } else {

                    track.setLocation("NaN");
                }

                if (res.getString(21) != null) {

                    track.setGeocodeid(res.getString(21));
                } else {

                    track.setGeocodeid("0");
                }

                track.setAssetid(res.getString(22));

                if (res.getString(23) != null) {

                    track.setRawdataid(res.getString(23));
                } else {

                    track.setRawdataid("0");
                }
                try {
                    track.setOriginatedts(res.getString(24));
                    track.setPartcol(res.getString(25));
                } catch (SQLException e) {
                    // Do nothing
                }

                data.add(track);
            }

            System.out.println("Asset :: " + assetid + ",  Data Size :: " + data.size()
                    + ", StartDate :: " + startDate + ", StopDate :: " + stopDate);

            LOGGER.info("Asset :: " + assetid + ",  Data Size :: " + data.size()
                    + ", StartDate :: " + startDate + ", StopDate :: " + stopDate);

        } catch (Exception exception) {
            LOGGER.error("EXCEPTION : " + exception.getMessage(), exception);
            try {
                if (null != con)
                    con.close();
            } catch (SQLException e) {
                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
            }
        } finally {
            try {
                if (null != res)
                    res.close();
            } catch (SQLException e) {
                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
            }

            try {
                if (null != stmt)
                    stmt.close();
            } catch (SQLException e) {
                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
            }

//            try {
//                if (null != con)
//                    con.close();
//            } catch (SQLException e) {
//                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
//            }

        }

        return data;
    }

    /**
     * Method will create Hive connection from HDFS and execute query on
     * table : 'bsfc_aws_track_orc' based on input attributes     *
     *
     * @param partcol
     * @param assetid
     * @param startDate
     * @param stopDate
     * @return list of track data object which consists of multiple row for input assetId in input date range
     * @throws SQLException
     */
    public List<Document> fetchDocumentFromHdfs(String partcol, String assetid, Long accountId,
                                                String startDate, String stopDate) throws SQLException {
        Statement stmt = null;
        ResultSet res = null;
        List<Document> documents = null;

        try {
            LOGGER.info("HiveQueryData ............................... fetchTrackFromHdfs :: " + partcol
                    + ", " + assetid + ", " + startDate + ", " + stopDate);
//            System.out.println("HiveQueryData ............................... fetchTrackFromHdfs :: " + partcol
//                    + ", " + assetid + ", " + startDate + ", " + stopDate);
            con = this.getConnectionInstance();
            stmt = con.createStatement();

            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("select * from ").append(properties.getProperty("HIVE_TABLE_NAME_HISTORY"))
                    .append(" where partcol='").append(partcol).append("' and asset_id='")
                    .append(assetid).append("' and originated >= '").append(startDate).append(" 00:00:00")
                    .append("' and originated <= '").append(stopDate).append(" 23:59:59").append("'")
            ;
            LOGGER.info("Query :: " + queryBuilder.toString());
            System.out.println("Query :: " + queryBuilder.toString());
            res = stmt.executeQuery(queryBuilder.toString());
            documents = new ArrayList<>();
//            int count = 1;
            while (res.next()) {
//                System.out.println(count + " : HDFS Data Found ......................... "
//                        + assetid + ", " + startDate + ", " + stopDate);
                Document doc = new Document();

                Double lat = Double.parseDouble(res.getString(1));
                Double lng = Double.parseDouble(res.getString(2));
                Double[] geo = new Double[]{lng, lat};

                /**
                 * Extra Parameters
                 */
                if (null != accountId)
                    doc.append(Constants.NODEACCOUNTID, accountId);

                doc.append(Constants.NODEASSETID, Long.parseLong(assetid));
                try {
                    doc.append(Constants.NODEGEOCODE, Arrays.asList(geo));
                } catch (Exception e) {
                    // Do nothing
                }

                /**
                 * HDFS DataBase Parameters
                 */
                doc.append(Constants.NODELATITUDE, lat);
                doc.append(Constants.NODELONGITUDE, lng);
//                track.setLatitude(res.getString(1));
//                track.setLongitude(res.getString(2));

                if (res.getString(3) != null) {
                    doc.append(Constants.NODEALTITUDE, res.getString(3));
//                    track.setAltitude(res.getString(3));
                } else {
                    doc.append(Constants.NODEALTITUDE, "0");
//                    track.setAltitude("0");
                }

                if (res.getString(4) != null) {
                    doc.append(Constants.NODEDISHA, res.getString(4));
//                    track.setCourse(res.getString(4));
                } else {
                    doc.append(Constants.NODEDISHA, "0");
//                    track.setCourse("0");
                }

                try {
                    if (res.getString(5) != null) {
                        doc.append(Constants.NODESPEED, Double.parseDouble(res.getString(5)));
                        //                    track.setSpeed(res.getString(5));
                    } else {
                        doc.append(Constants.NODESPEED, Double.parseDouble("0"));
                        //                    track.setSpeed("0");
                    }
                } catch (SQLException e) {
                    doc.append(Constants.NODESPEED, res.getString(5));
                } catch (NumberFormatException e) {
                    doc.append(Constants.NODESPEED, res.getString(5));
                }

                if (res.getString(6) != null) {
                    doc.append(Constants.NODEIGNITION, res.getString(6));
//                    track.setIgnition(res.getString(6));
                } else {
                    doc.append(Constants.NODEIGNITION, "NA");
//                    track.setIgnition("NA");
                }

                try {
                    if (res.getString(7) != null
                            && res.getString(7).trim().compareToIgnoreCase("null") != 0) {
                        doc.append(Constants.NODEFUEL, Double.parseDouble(res.getString(7)));
                        //                    track.setFuel(res.getString(7));
                    } else {
                        doc.append(Constants.NODEFUEL, Double.parseDouble("0.0"));
                        //                    track.setFuel("0.0");
                    }
                } catch (SQLException e) {
                    doc.append(Constants.NODEFUEL, res.getString(7));
                } catch (NumberFormatException e) {
                    doc.append(Constants.NODEFUEL, res.getString(7));
                }

                if (res.getString(8) != null
                        && res.getString(8).trim().compareToIgnoreCase("null") != 0) {
                    doc.append(Constants.NODEFUELS, res.getString(8));
//                    track.setFuels(res.getString(8));
                } else {
                    doc.append(Constants.NODEFUELS, "0.0");
//                    track.setFuels("0.0");
                }

                if (res.getString(9) != null
                        && res.getString(9).trim().compareToIgnoreCase("null") != 0) {
                    doc.append(Constants.NODETEMP, res.getString(9));
//                    track.setTemp(res.getString(9));
                } else {
                    doc.append(Constants.NODETEMP, "0");
//                    track.setTemp("0");
                }

                if (res.getString(10) != null
                        && res.getString(10).trim().compareToIgnoreCase("null") != 0) {
                    doc.append(Constants.NODETEMPS, res.getString(10));
//                    track.setTemps(res.getString(10));
                } else {
                    doc.append(Constants.NODETEMPS, "0");
//                    track.setTemps("0");
                }

                if (res.getString(11) != null
                        && res.getString(11).trim().compareToIgnoreCase("null") != 0) {
                    doc.append(Constants.NODEMISC, res.getString(11));
//                    track.setMisc(res.getString(11));
                } else {
                    doc.append(Constants.NODEMISC, "NA");
//                    track.setMisc("NA");
                }

                if (res.getString(12) != null
                        && res.getString(12).trim().compareToIgnoreCase("null") != 0) {
                    doc.append(Constants.NODEMISCS, res.getString(12));
//                    track.setMiscs(res.getString(12));
                } else {
                    doc.append(Constants.NODEMISCS, "NA");
//                    track.setMiscs("NA");
                }

                if (res.getString(13) != null) {
                    doc.append(Constants.NODEAC, res.getString(13));
//                    track.setAc(res.getString(13));
                } else {
                    doc.append(Constants.NODEAC, "NA");
//                    track.setAc("NA");
                }

                if (res.getString(14) != null) {
                    doc.append(Constants.NODEDOOR, res.getString(14));
//                    track.setDoor(res.getString(14));
                } else {
                    doc.append(Constants.NODEDOOR, "NA");
//                    track.setDoor("NA");
                }

                if (res.getString(15) != null) {
                    doc.append(Constants.NODERESERVED, res.getString(15));
//                    track.setReserved(res.getString(15));
                } else {
                    doc.append(Constants.NODERESERVED, "NA");
//                    track.setReserved("NA");
                }

                if (res.getString(16) != null) {
                    doc.append(Constants.NODEGPS, res.getString(16));
//                    track.setGps(res.getString(16));
                } else {
                    doc.append(Constants.NODEGPS, "NA");
//                    track.setGps("NA");
                }

                if (res.getString(17) != null) {
                    doc.append(Constants.NODESATELLITES, res.getString(17));
//                    track.setSatelites(res.getString(17));
                } else {
                    doc.append(Constants.NODESATELLITES, "0");
//                    track.setSatelites("0");
                }

                doc.append(Constants.NODEORIGINTS, res.getString(18));
                doc.append(Constants.NODECREATEDON, res.getString(19));
//                track.setOriginated(res.getString(18));
//                track.setCreated(res.getString(19));

                if (res.getString(20) != null) {
                    doc.append(Constants.NODEADDRESS, res.getString(20));
//                    track.setLocation(res.getString(20));
                } else {
                    doc.append(Constants.NODEADDRESS, "NaN");
//                    track.setLocation("NaN");
                }

                if (res.getString(21) != null) {
                    doc.append(Constants.NODEGEOCODEID, res.getString(21));
//                    track.setGeocodeid(res.getString(21));
                } else {
                    doc.append(Constants.NODEGEOCODEID, "0");
//                    track.setGeocodeid("0");
                }

                doc.append(Constants.NODEDEVICEID, res.getString(22));
//                track.setAssetid(res.getString(22));

                if (res.getString(23) != null) {
                    doc.append(Constants.NODERAWDATAID, res.getString(23));
//                    track.setRawdataid(res.getString(23));
                } else {
                    doc.append(Constants.NODERAWDATAID, "0");
//                    track.setRawdataid("0");
                }
                try {
                    doc.append(Constants.NODEORIGINATEDTS, res.getString(24));
                    doc.append(Constants.NODEPARTCOL, res.getString(25));
//                    track.setOriginatedts(res.getString(24));
//                    track.setPartcol(res.getString(25));
                } catch (SQLException e) {
                    // Do nothing
                }

                documents.add(doc);
            }

            System.out.println("Asset :: " + assetid
                    + ", StartDate :: " + startDate + ", StopDate :: " + stopDate
                    + ",  HdfsDataFetchSize :: " + documents.size());

            LOGGER.info("Asset :: " + assetid + ",  Data Size :: " + documents.size()
                    + ", StartDate :: " + startDate + ", StopDate :: " + stopDate);

        } catch (SQLException e){
            try {
                if (null != con)
                    con.close();
            } catch (SQLException e1) {
                LOGGER.error("EXCEPTION : " + e1.getMessage(), e1);
            }
            throw e;
        } catch (Exception exception) {
            System.out.println("EXCEPTION : " + exception.getMessage() + exception.getMessage());
            exception.printStackTrace();
            LOGGER.error("EXCEPTION : " + exception.getMessage(), exception);
            try {
                if (null != con)
                    con.close();
            } catch (SQLException e) {
                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
            }
        } finally {
            try {
                if (null != res)
                    res.close();
            } catch (SQLException e) {
                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
            }

            try {
                if (null != stmt)
                    stmt.close();
            } catch (SQLException e) {
                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
            }

//            try {
//                if (null != con)
//                    con.close();
//            } catch (SQLException e) {
//                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
//            }

        }

        return documents;
    }
}
