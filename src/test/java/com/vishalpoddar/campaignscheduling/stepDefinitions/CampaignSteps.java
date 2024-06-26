package com.vishalpoddar.campaignscheduling.stepDefinitions;

import com.vishalpoddar.campaignscheduling.dto.CampaignNameRequest;
import com.vishalpoddar.campaignscheduling.dto.ResponseWrapperCampaignResponse;
import com.vishalpoddar.campaignscheduling.pom.Campaign;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class CampaignSteps extends BaseSteps {
    /*
    * I want to create a new email campaign with a scheduled send time
        and date, so that the campaign is sent automatically at the specified time.
        * */

    @Autowired
    Campaign campaign;

    @Autowired
    @Value("${host.campaign.base}")
    private String baseUrl;

    @Before
    public void getHealthHead() {
        restClient.getRequestSpecification().head(baseUrl + "/health")
                .then().statusCode(200);
    }

    @Given("I check Campaign Service health")
    public void getHealth() {
        restClient.getRequestSpecification().get(baseUrl + "/health")
                .then().statusCode(200);
    }

    @When("I create a new email campaign with send time {int}, email template {string} and recipients list {string}")
    public void createEmailCampaign(int time, String emailTemp, String recList) {
        var response = restClient.getRequestSpecification()
                .body(campaign.buildCampaignRequest(time, emailTemp, recList))
                .post(baseUrl + "/campaigns");

        context.setResponse(response);
    }

    @When("I update campaign name")
    public void createEmailCampaignForTime() {
        var lasRes = context.getResponse().as(ResponseWrapperCampaignResponse.class);
        var response = restClient.getRequestSpecification()
                .body(new CampaignNameRequest(util.getUniqueName("Upt")))
                .patch(baseUrl + "/campaigns/" + lasRes.getData().getId() + "/name");
        context.setResponse(response);
    }

    @Given("I get last campaign and verify name")
    public void getCampaign() {
        var lastRes = context.getResponse().as(ResponseWrapperCampaignResponse.class);
        var response = restClient.getRequestSpecification()
                .get(baseUrl + "/campaigns/" + lastRes.getData().getId());
        Assert.assertEquals(lastRes.getData().getCampaignName(), response.as(ResponseWrapperCampaignResponse.class).getData().getCampaignName());
        context.setResponse(response);
    }
}

