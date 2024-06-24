package com.vishalpoddar.campaignscheduling.steps;

import com.vishalpoddar.campaignscheduling.dto.ResponseWrapperListEmailTemplateResponse;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmailSteps extends Base {

    @Value("${host.email.base}")
    private String baseUrl;

    @When("I fetch all email templates.")
    public void getEmailTemplates() {
        ResponseWrapperListEmailTemplateResponse res = restClient.getRequestSpecification()
                .get(baseUrl+"/email/templates").then().statusCode(200)
                .extract().as(ResponseWrapperListEmailTemplateResponse.class);

        emailTemplates = new ArrayList<>();
        res.getData().forEach(x-> emailTemplates.add(x.id));
    }


}

