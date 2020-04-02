package com.traq.mongo.hadoop.sql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.traq.mongo.hadoop.common.BaseInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory extends BaseInitializer {

    private static Properties properties = null;
    private static ConnectionFactory factory;
    private ComboPooledDataSource cpds;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionFactory.class);

    private ConnectionFactory() throws PropertyVetoException, IOException {

        properties = loadProperties();

        this.cpds = new ComboPooledDataSource();
        this.cpds.setDriverClass("com.mysql.jdbc.Driver");
        this.cpds.setJdbcUrl("jdbc:mysql://" + properties.getProperty("SERVER") + ":" + properties.getProperty("PORT") + "/" + properties.getProperty("DATABASE"));
        this.cpds.setUser(properties.getProperty("USERNAME"));
        this.cpds.setPassword(properties.getProperty("PASSWORD"));
        this.cpds.setAcquireIncrement(Integer.valueOf(properties.getProperty("ACQUIRE_INCREMENT")));
        this.cpds.setMaxIdleTime(Integer.valueOf(properties.getProperty("MAX_IDLE_TIME")));
        this.cpds.setMaxIdleTimeExcessConnections(Integer.valueOf(properties.getProperty("MAX_IDLE_TIME_EXCESS_CONNECTIONS")));
        this.cpds.setInitialPoolSize(Integer.valueOf(properties.getProperty("INITIAL_POOL_SIZE")));
        this.cpds.setMaxPoolSize(Integer.valueOf(properties.getProperty("MAX_POOL_SIZE")));
        this.cpds.setMinPoolSize(Integer.valueOf(properties.getProperty("MIN_POOL_SIZE")));
        this.cpds.setNumHelperThreads(Integer.valueOf(properties.getProperty("NUM_HELPER_THREADS")));
        this.cpds.setUnreturnedConnectionTimeout(Integer.valueOf(properties.getProperty("UNRETURNED_CONNECTION_TIMEOUT")));
        this.cpds.setMaxStatements(Integer.valueOf(properties.getProperty("MAX_STATEMENTS")));
        LOGGER.info("getJdbcUrl :: " + this.cpds.getJdbcUrl() + ", UserName :: " + this.cpds.getUser()
                + ", Password :: " + this.cpds.getPassword()
                + ", getMaxPoolSize :: " + this.cpds.getMaxPoolSize() + ", getMaxIdleTime :: " + this.cpds.getMaxIdleTime()
                + ", getInitialPoolSize :: " + this.cpds.getInitialPoolSize() + ", getMinPoolSize :: " + this.cpds.getMinPoolSize()
        );
        System.out.println("getJdbcUrl :: " + this.cpds.getJdbcUrl() + ", UserName :: " + this.cpds.getUser()
                + ", Password :: " + this.cpds.getPassword()
                + ", getMaxPoolSize :: " + this.cpds.getMaxPoolSize() + ", getMaxIdleTime :: " + this.cpds.getMaxIdleTime()
                + ", getInitialPoolSize :: " + this.cpds.getInitialPoolSize() + ", getMinPoolSize :: " + this.cpds.getMinPoolSize()
        );
    }

    public static ConnectionFactory getInstance() throws PropertyVetoException, IOException {
        if (factory == null) {
            factory = new ConnectionFactory();
        }
        return factory;
    }

    public Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }
}
