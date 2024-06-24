package com.vishalpoddar.campaignscheduling.dto;

import lombok.Data;

import java.util.List;

@Data
public class RecipientListResponse {
    public String id;
    public String name;
    public List<RecipientResponse> recipients;
}

