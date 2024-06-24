package com.vishalpoddar.campaignscheduling.dto;

public class MetaResponse {
    public enum Status {
        SUCCESS, FAILURE
    }

    public Status status;
    public String timestamp;
}

