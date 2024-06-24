package com.vishalpoddar.campaignscheduling.steps.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.vishalpoddar.campaignscheduling", "com.vishalpoddar.campaignscheduling.client"})
@EnableAutoConfiguration
public class TestConfig {

}
