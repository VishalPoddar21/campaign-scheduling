package com.vishalpoddar.campaignscheduling.steps;

import com.vishalpoddar.campaignscheduling.dto.ResponseWrapperListEmailTemplateResponse;
import com.vishalpoddar.campaignscheduling.dto.ResponseWrapperRecipientListResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmailSteps extends BaseSteps {

    @Value("${host.email.base}")
    private String baseUrl;

    @Given("I check Email Service health")
    public void getHealth(){
        restClient.getRequestSpecification().get(baseUrl + "/health")
                .then().statusCode(200);
    }

    @When("I fetch all email templates")
    public void getEmailTemplates() {
        ResponseWrapperListEmailTemplateResponse res = restClient.getRequestSpecification()
                .get(baseUrl+"/email/templates").then().statusCode(200)
                .extract().as(ResponseWrapperListEmailTemplateResponse.class);

        List<String> emailTemplates = new ArrayList<>();
        res.getData().forEach(x-> emailTemplates.add(x.id));
        context.setEmailTemplates(emailTemplates);
    }

    @When("I fetch email template with {string}")
    public void getEmailTemplate(String id){
        ResponseWrapperRecipientListResponse res = restClient.getRequestSpecification()
                .get(baseUrl+"/email/templates/"+id).then().statusCode(200)
                .extract().as(ResponseWrapperRecipientListResponse.class);
    }


}

