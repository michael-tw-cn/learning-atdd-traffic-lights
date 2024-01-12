package com.michaelxm.trafficlights.test.acceptance;

import com.michaelxm.trafficlights.domain.LightState;

@SuppressWarnings("unused")
public class TrafficLights {

    private LightState state;

    public void setPreviousState(LightState state) {
        this.state = state;
    }

    public LightState nextState() {
        return this.state.next();
    }
}
