package com.vishalpoddar.campaignscheduling.dto;

import java.util.List;

public class ResponseWrapperListRecipientListResponse {
    public List<RecipientListResponse> data;
    public PaginationResponse pagination;
    public List<ErrorResponse> errors;
    public MetaResponse meta;
}
