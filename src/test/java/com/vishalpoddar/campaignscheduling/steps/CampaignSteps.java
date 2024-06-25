package com.vishalpoddar.campaignscheduling.steps;

import com.vishalpoddar.campaignscheduling.dto.CampaignNameRequest;
import com.vishalpoddar.campaignscheduling.dto.CampaignRequest;
import com.vishalpoddar.campaignscheduling.pom.Campaign;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    Campaign campaign;

    @Given("I check Campaign Service health")
    public void getHealth(){
        restClient.getRequestSpecification().get(baseUrl + "/health")
                .then().statusCode(200);
    }

    @When("I create a new email campaign with send time {int}, email template {string} and recipients list {string}")
    public void createEmailCampaign(int time, String emailTemp, String recList) {
        var response = restClient.getRequestSpecification()
                .body(campaign.buildCampaignRequest(time, emailTemp, recList))
                .post(baseUrl+"/campaigns");

        context.setResponse(response);
    }

    @When("I update email campaign name with id {string} to {string}")
    public void createEmailCampaignForTime(String id, String name) {
        var response = restClient.getRequestSpecification()
                .body(new CampaignNameRequest(name))
                .patch(baseUrl+"/campaigns/" + id + "/name");
        context.setResponse(response);
    }

    @Given("I get campaign with id {string}")
    public void getCampaign(String id){
        var response = restClient.getRequestSpecification()
                .get(baseUrl+"/campaigns/" + id);
        context.setResponse(response);
    }
}

