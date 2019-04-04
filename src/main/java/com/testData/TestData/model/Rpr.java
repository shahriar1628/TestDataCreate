package com.testData.TestData.model;

import javax.persistence.*;

@Entity
public class Rpr {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String SpaceName;

    public Rpr() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpaceName() {
        return SpaceName;
    }

    public void setSpaceName(String spaceName) {
        SpaceName = spaceName;
    }
}
