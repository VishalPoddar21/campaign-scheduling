package com.vishalpoddar.campaignscheduling.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignRequest {
    public String campaignName;
    public String emailTemplateId;
    public String recipientListId;
    public int scheduledTime;
}

