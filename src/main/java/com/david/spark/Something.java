package com.david.spark;

import java.util.Arrays;
import java.util.List;

import com.david.spark.beans.Bean;
import com.google.inject.Inject;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Something {

    @Inject
    private SparkSession session;

    @Inject
    private Transformer transformer;

	public void show() {

        List<Bean> rows = Arrays.asList(new Bean[] {
            new Bean("Test", "blabla", 1),
            new Bean("Key", "my string", 33),
            new Bean("Today", "something", 90)
        });

        Dataset<Row> ds = session.createDataFrame(rows, Bean.class);
        ds.show();

        ds = transformer.transform(ds);
        ds.show();
	}

}