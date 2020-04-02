package com.traq.mongo.hadoop.hive;

import com.traq.mongo.hadoop.bean.Track;
import org.bson.Document;

import java.util.List;

public class HdfsTrackBean {
    private List<Track> datalist = null;
    private String responseJson = "";
    private String partcol = "";
    private String assetId = "";
    private String startDate = "";
    private String stopDate = "";
    private String error = "";
    private String resultDesc = "";
    private List<Document> documents = null;

    public List<Track> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<Track> datalist) {
        this.datalist = datalist;
    }

    public String getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(String responseJson) {
        this.responseJson = responseJson;
    }

    public String getPartcol() {
        return partcol;
    }

    public void setPartcol(String partcol) {
        this.partcol = partcol;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "HdfsTrackBean{" +
                "partcol='" + partcol + '\'' +
                ", assetId='" + assetId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", stopDate='" + stopDate + '\'' +
                ", resultDesc='" + resultDesc  +
                '}';
    }
}
