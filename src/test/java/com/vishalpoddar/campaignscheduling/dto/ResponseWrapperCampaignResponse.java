package com.vishalpoddar.campaignscheduling.dto;

import java.util.List;

public class ResponseWrapperCampaignResponse {
    public CampaignResponse data;
    public PaginationResponse pagination;
    public List<ErrorResponse> errors;
    public MetaResponse meta;
}

