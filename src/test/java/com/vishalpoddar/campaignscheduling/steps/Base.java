package com.vishalpoddar.campaignscheduling.steps;

import com.vishalpoddar.campaignscheduling.client.RestClient;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Base {

    @Autowired
    protected RestClient restClient;

    protected static Response response;

    protected static List<String> emailTemplates;

    protected static List<String> recipientsList;


}

