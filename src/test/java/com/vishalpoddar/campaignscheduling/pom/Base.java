package com.vishalpoddar.campaignscheduling.pom;

import com.vishalpoddar.campaignscheduling.ScenarioContext;
import com.vishalpoddar.campaignscheduling.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;

public class Base {
    @Autowired
    ScenarioContext context;

    @Autowired
    Util util;
}
