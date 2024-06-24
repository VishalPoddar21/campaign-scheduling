package com.vishalpoddar.campaignscheduling.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    public String errorCode;
    public String message;
    public String detail;
}

