package com.vishalpoddar.campaignscheduling.dto;

public class CampaignRequest {
    public String campaignName;
    public String emailTemplateId;
    public String recipientListId;
    public Long scheduledTime;

    public void setScheduledTime(Long scheduledTime) {
        if (scheduledTime < 0) {
            throw new IllegalArgumentException("Scheduled time must be non-negative");
        }
        this.scheduledTime = scheduledTime;
    }
}

