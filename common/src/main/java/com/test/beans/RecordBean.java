package com.test.beans;

import java.io.Serializable;

public class RecordBean implements Serializable {
    private static String[] commodityNames = new String[]{"coffee", "tea", "pepper", "nutmeg", "sugar", "cocoa"};
    private static String[] typeNames = new String[]{"africa", "asia", "europe", "north_america", "oceania", "south_america"};
    private static String[] partitions = new String[]{"sensex", "nifty", "dow", "nasdaq"};
    private String type;
    private String commodity;
    private String partition;
    private Long ts;
    private String uuid;
    private float value;

    public static String getTypeName(int index) {
        return index >= 0 && index <= 5 ? typeNames[index] : "";
    }

    public static String getCommodity(int index) {
        return index >= 0 && index <= 5 ? commodityNames[index] : "";
    }

    public static String getPartition(int index) {
        return index >= 0 && index <= 3 ? partitions[index] : "";
    }

    public RecordBean() {
    }

    public RecordBean(String uuid, Long ts, String type, String commodity, String partition, float value) {
        this.type = type;
        this.commodity = commodity;
        this.partition = partition;
        this.value = value;
        this.uuid = uuid;
        this.ts = ts;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCommodity() {
        return this.commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getPartition() {
        return this.partition;
    }

    public void setPartition(String partition) {
        this.partition = partition;
    }

    public Long getTs() {
        return this.ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String toString() {
        return "RecordBean{type=" + this.type + ", commodity=" + this.commodity + ", partition=" + this.partition + ", ts=" + this.ts + ", uuid='" + this.uuid + '\'' + ", value=" + this.value + '}';
    }
}
