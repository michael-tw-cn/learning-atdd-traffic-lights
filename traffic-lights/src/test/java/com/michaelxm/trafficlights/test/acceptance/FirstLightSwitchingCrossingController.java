package com.michaelxm.trafficlights.test.acceptance;

import com.michaelxm.trafficlights.domain.CrossingValidator;
import com.michaelxm.trafficlights.domain.LightState;

@SuppressWarnings("unused")
public class FirstLightSwitchingCrossingController {

    private CrossingValidator crossingValidator = new CrossingValidator();

    private LightState firstLight;
    private LightState secondLight;

    public void setFirstLight(LightState firstLight) {
        this.firstLight = firstLight;
    }

    public void setSecondLight(LightState secondLight) {
        this.secondLight = secondLight;
    }

    public LightState firstLight() {
        return firstLight;
    }

    public LightState secondLight() {
        return secondLight;
    }

    public void execute() {
        switchFirstLight();
    }

    private void switchFirstLight() {
        if (!crossingValidator.isValidLightStateConfiguration(this.firstLight, this.secondLight)) {
            warningConfiguration();
            return;
        }
        this.firstLight = firstLight.next();
        if (!crossingValidator.isValidLightStateConfiguration(this.firstLight, this.secondLight)) {
            warningConfiguration();
        }
    }

    private void warningConfiguration() {
        this.firstLight = LightState.UNKNOWN;
        this.secondLight = LightState.UNKNOWN;
    }

}
