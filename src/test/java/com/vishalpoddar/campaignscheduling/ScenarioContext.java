package com.vishalpoddar.campaignscheduling;

import io.restassured.response.Response;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class ScenarioContext {
    private List<String> recipientsList;
    private List<String> emailTemplates;
    private Response response;
}