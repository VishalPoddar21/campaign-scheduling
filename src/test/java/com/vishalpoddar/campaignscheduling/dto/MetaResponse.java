package com.vishalpoddar.campaignscheduling.dto;

import lombok.Data;

@Data
public class MetaResponse {
    public enum Status {
        SUCCESS, FAILURE
    }

    public Status status;
    public String timestamp;
}

