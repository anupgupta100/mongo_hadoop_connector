package com.traq.mongo.hadoop.mongo;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.traq.mongo.hadoop.common.BaseInitializer;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MongoQueryData extends BaseInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoQueryData.class);
    private static Properties properties = null;
    private static MongoClient mongoClient = null;
    static MongoDatabase mongoDatabase = null;
    static MongoCollection trackData = null;
    static Byte aByte = new Byte("1");

    public MongoQueryData() {
        properties = loadProperties();
    }

    protected static MongoClient getMongoClientInstance() {

        try {
            if (null == mongoClient) {
                properties = loadProperties();
                synchronized (aByte) {
                    if (null == mongoClient) {

                        String DB_SRV_USR = properties.getProperty("MONGO_USERNAME");
                        String DB_SRV_PWD = properties.getProperty("MONGO_PASSWORD");
                        String DB_DATABASE = properties.getProperty("MONGO_DATABASE");
                        String DB_HOST = properties.getProperty("MONGO_SERVER");
                        int DB_PORT = Integer.valueOf(properties.getProperty("MONGO_PORT")).intValue();
                        int minConnectionsPerHost = Integer.valueOf(properties.getProperty("MONGO_MIN_POOL")).intValue();

                        System.out.println("Mongo Config ................. " + DB_SRV_USR
                        + ", " + DB_SRV_PWD + ", " + DB_DATABASE + ", " + DB_HOST + ", " + DB_PORT
                        + ", " + minConnectionsPerHost + " Initialize connection");
                        //connectionPoolListener.
                        MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
                        //builder.minConnectionsPerHost(2);
                        //builder.connectionsPerHost(20);

                        //build the connection options
                        builder.minConnectionsPerHost(minConnectionsPerHost);//set the max wait time in (ms)
                        builder.maxConnectionIdleTime(60000);//set the max wait time in (ms)
                        //builder.socketTimeout(120000);//set the max wait time in (ms)
                        MongoClientOptions opts = builder.build();

                        MongoCredential credential = null;
                        credential = MongoCredential.createCredential(DB_SRV_USR, DB_DATABASE,
                                DB_SRV_PWD.toCharArray());

                        List<ServerAddress> seeds = new ArrayList<ServerAddress>();
                        seeds.add(new ServerAddress(DB_HOST));        // Primary

                        mongoClient = new MongoClient(seeds, credential, opts);

                        System.out.println("Mongo Connection Establish Successfully");
                        LOGGER.info("Mongo Connection Establish Successfully");
                        // Accessing the admin
                        //setMongoDatabase(mongo.getDatabase(getAppConfig().getMongoDB()));
                    }
                }
            }
        } catch (NumberFormatException e) {
            LOGGER.error("Mongo Connection Establish Failed", e);
            try {
                if(null != mongoClient)
                    mongoClient.close();
                mongoClient = null;
            } catch (Exception e1) {
                // Do nothing
            }
        } catch (Exception e) {
            LOGGER.error("Mongo Connection Establish Failed", e);
            try {
                if(null != mongoClient)
                    mongoClient.close();
                mongoClient = null;
            } catch (Exception e1) {
                // Do nothing
            }
        }
        return mongoClient;
    }

    protected static MongoDatabase getMongoDatabase() {
        if (mongoDatabase == null) {
            String DB_DATABASE = properties.getProperty("MONGO_DATABASE");
            LOGGER.info("Config Mongo DataBase ...................." + DB_DATABASE);
            System.out.println("Config Mongo DataBase ...................." + DB_DATABASE);
            mongoDatabase = getMongoClientInstance().getDatabase(DB_DATABASE);
        }
        return mongoDatabase;
    }

    protected static MongoCollection getMongoCollection() {
        if (trackData == null) {
            String collection = properties.getProperty("MONGO_TRACK_DATA");
            if (collection == null || collection.trim().isEmpty())
                collection = "BSFC_History_TRACKDATA";
            LOGGER.info("Config Mongo collection ...................." + collection);
            System.out.println("Config Mongo collection ...................." + collection);
            trackData = getMongoDatabase().getCollection(collection);
        }
        return trackData;
    }

    public boolean insertManyTrackData(List<Document> trackDataList) {
        boolean result = Boolean.FALSE;
        Exception tmpError = null;
        try {
            try {
                Thread.currentThread().sleep(100L);
            } catch (InterruptedException e) {
                // Do nothing
            }
            getMongoCollection().insertMany(trackDataList);
            result = Boolean.TRUE;
            LOGGER.info("MongoQueryData .................... insertManyTrackData :" + trackDataList.size() + " Successfully");
            System.out.println("MongoQueryData .................... insertManyTrackData :" + trackDataList.size() + " Successfully");
        } catch (Exception e) {
            tmpError = e;
            LOGGER.error("Mongo InsertMany TrackData Failed", e);
            System.out.println("Mongo InsertMany TrackData Failed " + e.getMessage());
        } finally {
            try {
                if(null != tmpError){
                    System.out.println("Attempt to Insert TrackData Individually On Loop");
                    for (Document trackData: trackDataList){
                        this.insertOneTrackData(trackData);
                    }
                }
            } catch (Exception e) {
                System.out.println("Mongo InsertMany TrackData Individual Call Fail" + e.getMessage());
            }
        }
        return result;
    }

    public boolean insertOneTrackData(Document trackData) {
        boolean result = Boolean.FALSE;
        try {
            try {
                Thread.currentThread().sleep(50L);
            } catch (InterruptedException e) {
                // Do nothing
            }
            getMongoCollection().insertOne(trackData);
            result = Boolean.TRUE;
            LOGGER.info("MongoQueryData .................... insertOneTrackData Successfully");
            System.out.println("MongoQueryData .................... insertOneTrackData Successfully");
        } catch (Exception e) {
            LOGGER.error("Mongo insertOneTrackData Failed", e);
            System.out.println("Mongo insertOneTrackData Duplicate Data Insert Failed " + e.getMessage());
        }
        return result;
    }
}
