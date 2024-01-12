package com.michaelxm.trafficlights.domain;

import java.util.Arrays;

public enum LightState {
    RED("red") {
        @Override
        public LightState next() {
            return RED_YELLOW;
        }
    },
    RED_YELLOW("red, yellow") {
        @Override
        public LightState next() {
            return GREEN;
        }
    },
    GREEN("green") {
        @Override
        public LightState next() {
            return YELLOW;
        }
    },
    YELLOW("yellow") {
        @Override
        public LightState next() {
            return RED;
        }
    },
    UNKNOWN("yellow blink");

    private final String description;

    LightState(String description) {
        this.description = description;
    }

    public static LightState valueFor(String description) {
        return Arrays.stream(LightState.values())
                .filter(it -> it.getDescription().equals(description))
                .findFirst().orElse(UNKNOWN);
    }

    public LightState next() {
        return UNKNOWN;
    }

    public String getDescription() {
        return description;
    }
}
