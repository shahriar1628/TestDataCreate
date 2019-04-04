package com.testData.TestData.model;

import javax.persistence.*;

@Entity
public class PrequisiteData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long preqId;
    private String type;
    private Long dataId;

    public PrequisiteData() {

    }

    public long getPreqId() {
        return preqId;
    }

    public void setPreqId(long preqId) {
        this.preqId = preqId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }
}
