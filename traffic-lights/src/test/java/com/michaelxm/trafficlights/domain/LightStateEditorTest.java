package com.michaelxm.trafficlights.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LightStateEditorTest {

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

    public static Stream<Arguments> provideParametersForGetAsText() {
        return Stream.of(
                Arguments.of(LightState.RED, "red"),
                Arguments.of(LightState.RED_YELLOW, "red, yellow"),
                Arguments.of(LightState.GREEN, "green"),
                Arguments.of(LightState.YELLOW, "yellow"),
                Arguments.of(LightState.UNKNOWN, "yellow blink")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void set_as_text(String stateText, LightState lightState) {
        var lightStateEditor = new LightStateEditor();
        lightStateEditor.setAsText(stateText);

        assertThat(lightStateEditor.getValue()).isEqualTo(lightState);
    }

    @ParameterizedTest
    @MethodSource("provideParametersForGetAsText")
    void get_as_text(LightState lightState, String stateText) {
        var lightStateEditor = new LightStateEditor();
        lightStateEditor.setValue(lightState);

        assertThat(lightStateEditor.getAsText()).isEqualTo(stateText);
    }
}
