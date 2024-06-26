package com.vishalpoddar.campaignscheduling.utils;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Util {
    public String getUniqueName(String prefix) {
        return prefix + LocalTime.now();
    }
}
