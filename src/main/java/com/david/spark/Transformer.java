package com.david.spark;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.david.spark.beans.JoinedBean;
import com.google.inject.Inject;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Transformer {
    
    @Inject
    private SparkSession session;

    @Inject
    private Properties properties;

    public Dataset<Row> transform(Dataset<Row> ds) {
        System.out.println(properties.getProperty("spark.name"));

        List<JoinedBean> rows = Arrays.asList(new JoinedBean[] {
            new JoinedBean("Test", "DK"),
            new JoinedBean("Key", "FR"),
            new JoinedBean("Today", "NO")
        });
        Dataset<Row> joinedBeans = session.createDataFrame(rows, JoinedBean.class);
        return ds.join(joinedBeans, ds.col("key").equalTo(joinedBeans.col("id")));
    }

}