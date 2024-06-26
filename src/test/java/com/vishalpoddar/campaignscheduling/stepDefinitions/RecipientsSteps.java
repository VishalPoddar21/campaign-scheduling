package com.vishalpoddar.campaignscheduling.stepDefinitions;

import com.vishalpoddar.campaignscheduling.dto.ResponseWrapperListRecipientListResponse;
import com.vishalpoddar.campaignscheduling.dto.ResponseWrapperRecipientListResponse;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class RecipientsSteps extends BaseSteps {
    @Value("${host.recipients.base}")
    private String baseUrl;

    //@Before
    public void getHealthHead() {
        restClient.getRequestSpecification().head(baseUrl + "/health")
                .then().statusCode(200);
    }

    @Given("I check Recipients Service health")
    public void getHealth() {
        restClient.getRequestSpecification().get(baseUrl + "/health")
                .then().statusCode(200);
    }

    @When("I fetch all recipients lists")
    public void getRecipientsLists() {
        ResponseWrapperListRecipientListResponse res = restClient.getRequestSpecification()
                .get(baseUrl + "/recipients/lists").then().statusCode(200)
                .extract().as(ResponseWrapperListRecipientListResponse.class);

        List<String> recipientsList = new ArrayList<>();
        res.getData().forEach(x -> recipientsList.add(x.id));
        context.setRecipientsList(recipientsList);
    }

    @Given("I fetch recipients list for {string}")
    public void getRecipientsList(String id) {
        var res = restClient.getRequestSpecification()
                .get(baseUrl + "/recipients/lists/" + id);
        context.setResponse(res);
        res.then().extract().as(ResponseWrapperRecipientListResponse.class);
    }

}

