package com.vishalpoddar.campaignscheduling;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Util {
    public String getUniqueName(String prefix) {
        return prefix + LocalTime.now();
    }
}
