package com.vishalpoddar.campaignscheduling.steps;

import com.vishalpoddar.campaignscheduling.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseSteps {

    @Autowired
    protected RestClient restClient;

    @Autowired
    protected ScenarioContext context;
}

