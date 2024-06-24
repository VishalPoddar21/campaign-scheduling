package com.vishalpoddar.campaignscheduling.steps;

import com.vishalpoddar.campaignscheduling.dto.CampaignRequest;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CampaignSteps extends BaseSteps {
    /*
    * I want to create a new email campaign with a scheduled send time
        and date, so that the campaign is sent automatically at the specified time.
        * */

    @Value("${host.campaign.base}")
    private String baseUrl;

    @When("I create a new email campaign with send time {int}")
    public void createEmailCampaignForTime(int time) {
        var response = restClient.getRequestSpecification()
                .body(CampaignRequest.builder()
                        .campaignName(LocalTime.now().toString())
                        .scheduledTime(time)
                        .emailTemplateId(context.getEmailTemplates().get(0))
                        .recipientListId(context.getRecipientsList().get(0))
                        .build())
                .post(baseUrl+"/campaigns");
        context.setResponse(response);
    }
}

