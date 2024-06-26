package com.vishalpoddar.campaignscheduling.configuration;

import com.vishalpoddar.campaignscheduling.Config;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = Config.class)
public class CucumberSpringConfiguration {
}
