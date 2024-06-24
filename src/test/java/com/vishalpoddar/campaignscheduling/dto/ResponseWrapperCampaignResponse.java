package com.vishalpoddar.campaignscheduling.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseWrapperCampaignResponse {
    public CampaignResponse data;
    public PaginationResponse pagination;
    public List<ErrorResponse> errors;
    public MetaResponse meta;
}

