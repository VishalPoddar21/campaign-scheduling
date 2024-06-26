package com.vishalpoddar.campaignscheduling.dto;

import lombok.Data;

@Data
public class CampaignResponse {
    public String id;
    public String campaignName;
    public String emailTemplateId;
    public String recipientListId;
    public Long scheduledTime;
}

