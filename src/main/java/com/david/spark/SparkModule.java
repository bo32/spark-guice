package com.david.spark;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.SparkSession;


public class SparkModule extends AbstractModule {

    @Provides
    public Properties getSparkProperties() {
        Properties props = new Properties();
        try {
            InputStream is = new FileInputStream("myprops.properties");
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    SparkConf getSparkConf() {
        SparkConf conf = new SparkConf();
        conf.setAppName(getSparkProperties().getProperty("spark.name"));
        return conf;
    }

    SparkContext getSparkContext() {
        return new SparkContext(getSparkConf());
    }

    @Override
    protected void configure() {
        bind(SparkSession.class).toInstance(SparkSession.builder().config(getSparkConf()).getOrCreate());

    }
}