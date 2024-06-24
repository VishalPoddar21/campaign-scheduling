package com.vishalpoddar.campaignscheduling.dto;

import java.util.List;

public class ResponseWrapperEmailTemplateResponse {
    public EmailTemplateResponse data;
    public PaginationResponse pagination;
    public List<ErrorResponse> errors;
    public MetaResponse meta;
}

