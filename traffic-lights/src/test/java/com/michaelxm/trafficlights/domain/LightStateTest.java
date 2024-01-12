package com.michaelxm.trafficlights.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LightStateTest {

    @ParameterizedTest
    @CsvSource({
            "RED, RED_YELLOW",
            "RED_YELLOW, GREEN",
            "GREEN, YELLOW",
            "YELLOW, RED",
            "UNKNOWN, UNKNOWN"
    })
    void test_state_change(LightState previousState, LightState nextState) {
        assertThat(previousState.next()).isEqualTo(nextState);
    }

    public static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of("red", LightState.RED),
                Arguments.of("red, yellow", LightState.RED_YELLOW),
                Arguments.of("green", LightState.GREEN),
                Arguments.of("yellow", LightState.YELLOW),
                Arguments.of("invalid state", LightState.UNKNOWN),
                Arguments.of("yellow blink", LightState.UNKNOWN)
        );
    }


    @ParameterizedTest
    @MethodSource("provideParameters")
    void value_for(String description, LightState lightState) {
        assertThat(LightState.valueFor(description)).isEqualTo(lightState);
    }

}
