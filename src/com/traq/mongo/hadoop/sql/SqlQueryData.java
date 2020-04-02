package com.traq.mongo.hadoop.sql;

import com.traq.mongo.hadoop.bean.Asset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlQueryData {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlQueryData.class);

    public List<Asset> fetchAssetIdFromSql() {
        List<Asset> assetList = null;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            StringBuilder queryBuild = new StringBuilder();
            queryBuild.append("Select ID,NAME,LICENSE_NUMBER,ACCOUNT_ID from asset");

            con = ConnectionFactory.getInstance().getConnection();
            stmt = con.createStatement();
            rs = (ResultSet) stmt.executeQuery(queryBuild.toString());
            assetList = new ArrayList<>();
            while (rs.next()) {
                Asset asset = new Asset();
                long assetid = rs.getLong("ID");
                String name = rs.getString("NAME");
                String licenseno = rs.getString("LICENSE_NUMBER");
                long accountId = rs.getLong("ACCOUNT_ID");
                asset.setAsset_id(assetid);
                asset.setName(name);
                asset.setLicenseNo(licenseno);
                asset.setAccount_id(accountId);
                assetList.add(asset);
            }
            System.out.println("Hdfds Asset size:::" + assetList.size());
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("SQL asset size:::" + assetList.size());
            }
        } catch (SQLException e) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("SQLException: SqlQueryData ............. !!!", e);
            }
            System.out.println("SQLException: SqlQueryData ............. !!!"+ e.getMessage());
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("PropertyVetoException: SqlQueryData ............. !!!", e);
            }
            System.out.println("SQLException: SqlQueryData ............. !!!"+ e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("IOException: SqlQueryData ............. !!!", e);
            }
            System.out.println("SQLException: SqlQueryData ............. !!!"+ e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (null != rs)
                    rs.close();
            } catch (SQLException e) {
                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
            }

            try {
                if (null != stmt)
                    stmt.close();
            } catch (SQLException e) {
                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
            }

            try {
                if (null != con)
                    con.close();
            } catch (SQLException e) {
                LOGGER.error("EXCEPTION : " + e.getMessage(), e);
            }
        }
        return assetList;
    }

    public static void main(String[] args) {
        SqlQueryData sqlQueryData = new SqlQueryData();
        sqlQueryData.fetchAssetIdFromSql();
    }

}
