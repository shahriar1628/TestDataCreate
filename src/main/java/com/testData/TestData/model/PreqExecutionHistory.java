package com.testData.TestData.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PreqExecutionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long preqId;
    private String clientId;
    private String environment;
    private boolean isPassed ;
    private LocalDateTime creationTime;

    public PreqExecutionHistory() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPreqId() {
        return preqId;
    }

    public void setPreqId(long preqId) {
        this.preqId = preqId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }
}