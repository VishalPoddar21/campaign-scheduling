package com.vishalpoddar.campaignscheduling.stepDefinitions;

import com.vishalpoddar.campaignscheduling.dto.ResponseWrapperEmailTemplateResponse;
import com.vishalpoddar.campaignscheduling.dto.ResponseWrapperListEmailTemplateResponse;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

public class EmailSteps extends BaseSteps {

    @Value("${host.email.base}")
    private String baseUrl;

    @Before
    public void getHealthHead() {
        restClient.getRequestSpecification().head(baseUrl + "/health")
                .then().statusCode(200);
    }

    @Given("I check Email Service health")
    public void getHealth() {
        restClient.getRequestSpecification().get(baseUrl + "/health")
                .then().statusCode(200);
    }

    @When("I fetch all email templates")
    public void getEmailTemplates() {
        ResponseWrapperListEmailTemplateResponse res = restClient.getRequestSpecification()
                .get(baseUrl + "/email/templates").then().statusCode(200)
                .extract().as(ResponseWrapperListEmailTemplateResponse.class);

        List<String> emailTemplates = new ArrayList<>();
        res.getData().forEach(x -> emailTemplates.add(x.id));
        context.setEmailTemplates(emailTemplates);
    }

    @When("I fetch email template with {string}")
    public void getEmailTemplate(String id) {
        var res = restClient.getRequestSpecification()
                .get(baseUrl + "/email/templates/" + id);
        context.setResponse(res);
        res.then().extract().as(ResponseWrapperEmailTemplateResponse.class);
    }


}

