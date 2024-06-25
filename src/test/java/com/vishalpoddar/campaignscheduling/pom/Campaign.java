package com.vishalpoddar.campaignscheduling.pom;

import com.vishalpoddar.campaignscheduling.dto.CampaignRequest;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Campaign extends Base{

    public CampaignRequest buildCampaignRequest(int time, String emailTemp, String recList) {
        String eTemp = emailTemp.equals("any") ? context.getEmailTemplates().get(0) : emailTemp;
        String rList = recList.equals("any") ? context.getRecipientsList().get(0) : recList;
        return CampaignRequest.builder()
                .campaignName(LocalTime.now().toString())
                .scheduledTime(time)
                .emailTemplateId(eTemp)
                .recipientListId(rList)
                .build();
    }
}
