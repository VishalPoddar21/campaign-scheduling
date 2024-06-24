package com.vishalpoddar.campaignscheduling.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResponseWrapperListRecipientListResponse {
    public List<RecipientListResponse> data;
    public PaginationResponse pagination;
    public List<ErrorResponse> errors;
    public MetaResponse meta;
}
