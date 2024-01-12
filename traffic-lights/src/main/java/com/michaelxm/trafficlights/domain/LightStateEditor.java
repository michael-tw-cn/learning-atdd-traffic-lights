package com.michaelxm.trafficlights.domain;

import java.beans.PropertyEditorSupport;

public class LightStateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String stateText) throws IllegalArgumentException {
        var lightState = LightState.valueFor(stateText);
        setValue(lightState);
    }

    @Override
    public String getAsText() {
        var lightState = (LightState) super.getValue();
        return lightState.getDescription();
    }
}
