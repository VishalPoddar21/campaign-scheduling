package com.vishalpoddar.campaignscheduling.dto;

import lombok.Data;

@Data
public class MetaResponse {
    public Status status;
    public String timestamp;

    public enum Status {
        SUCCESS, FAILURE
    }
}

