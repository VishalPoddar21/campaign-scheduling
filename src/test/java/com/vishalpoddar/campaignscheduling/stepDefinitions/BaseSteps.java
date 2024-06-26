package com.vishalpoddar.campaignscheduling.stepDefinitions;

import com.vishalpoddar.campaignscheduling.ScenarioContext;
import com.vishalpoddar.campaignscheduling.client.RestClient;
import com.vishalpoddar.campaignscheduling.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseSteps {

    @Autowired
    protected RestClient restClient;

    @Autowired
    protected ScenarioContext context;

    @Autowired
    protected Util util;
}

