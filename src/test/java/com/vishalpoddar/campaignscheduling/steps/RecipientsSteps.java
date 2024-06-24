package com.vishalpoddar.campaignscheduling.steps;

import com.vishalpoddar.campaignscheduling.dto.ResponseWrapperListRecipientListResponse;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RecipientsSteps extends BaseSteps {
    @Value("${host.recipients.base}")
    private String baseUrl;

    @When("I fetch all recipients lists")
    public void getEmailTemplates() {
        ResponseWrapperListRecipientListResponse res = restClient.getRequestSpecification()
                .get(baseUrl+"/recipients/lists").then().statusCode(200)
                .extract().as(ResponseWrapperListRecipientListResponse.class);

        List<String> recipientsList = new ArrayList<>();
        res.getData().forEach(x-> recipientsList.add(x.id));
        context.setRecipientsList(recipientsList);
    }
    /*
    @Given("I fetch recipients list for {id}")

    @Given("I fetch recipients list for {name}")

     */


}

