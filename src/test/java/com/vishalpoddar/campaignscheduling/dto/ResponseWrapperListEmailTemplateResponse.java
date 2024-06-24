package com.vishalpoddar.campaignscheduling.dto;

import java.util.List;

public class ResponseWrapperListEmailTemplateResponse {
    public List<EmailTemplateResponse> data;
    public PaginationResponse pagination;
    public List<ErrorResponse> errors;
    public MetaResponse meta;
}

