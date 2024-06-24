package com.vishalpoddar.campaignscheduling.steps;

import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonSteps extends Base{

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int arg0) {
        assertEquals(arg0, response.getStatusCode());
    }
}
