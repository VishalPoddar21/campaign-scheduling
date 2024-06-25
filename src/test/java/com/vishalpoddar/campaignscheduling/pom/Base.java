package com.vishalpoddar.campaignscheduling.pom;

import com.vishalpoddar.campaignscheduling.ScenarioContext;
import com.vishalpoddar.campaignscheduling.Util;
import org.springframework.beans.factory.annotation.Autowired;

public class Base {
    @Autowired
    ScenarioContext context;

    @Autowired
    Util util;
}
