package com.vishalpoddar.campaignscheduling.stepDefinitions;

import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class CommonSteps extends BaseSteps {

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int arg0) {
        assertEquals(arg0, context.getResponse().getStatusCode());
    }
}
