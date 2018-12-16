package com.david.spark.beans;

public class JoinedBean {
    private String id;
    private String location;

    public JoinedBean(String id, String location) {
        this.setId(id);
        this.setLocation(location);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }


}