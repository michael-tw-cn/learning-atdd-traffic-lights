package com.michaelxm.trafficlights.domain;

import static com.michaelxm.trafficlights.domain.LightState.GREEN;

public class CrossingValidator {

    public boolean isValidLightStateConfiguration(LightState firstLight, LightState secondLight) {
        if (LightState.UNKNOWN.equals(firstLight) || LightState.UNKNOWN.equals(secondLight)) {
            return false;
        }
        if (LightState.RED.equals(secondLight)) {
            return true;
        }
        if (LightState.RED.equals(firstLight)) {
            return true;
        }
        return false;
    }
}
