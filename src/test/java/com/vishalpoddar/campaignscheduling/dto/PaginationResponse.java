package com.vishalpoddar.campaignscheduling.dto;

import lombok.Data;

@Data
public class PaginationResponse {
    public int pageNumber;
    public int pageSize;
    public long totalElements;
    public int totalPages;
}

