package de.hpfsc.java.dynamichash;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AppTest {
    @Test
    public void checkHashWithLength20() {
        final String actualHash = App.getHash("Hello World!", 20);
        final String expectedHash = "aacfe6ebd3737d9f195c";
        assertThat(actualHash).isEqualTo(expectedHash);
    }

    @Test
    public void checkHashWithLength30() {
        final String actualHash = App.getHash("Hello World!", 30);
        final String expectedHash = "aacfe6ebd3737d9f195c837c5281d3";
        assertThat(actualHash).isEqualTo(expectedHash);
    }

    @Test
    public void checkHashWithLength64() {
        final String actualHash = App.getHash("Hello World!", 64);
        final String expectedHash = "aacfe6ebd3737d9f195c837c5281d3f87646ecd7e43864e1a40456e40f264046";
        assertThat(actualHash).isEqualTo(expectedHash);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 3, 17})
    public void checkInvalidArguments(int invalidLength) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> App.getHash("some message", invalidLength)
        );
    }

    @Test
    public void checkInvalidMessages() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> App.getHash("", 16)
        );
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> App.getHash(null, 16)
        );
    }
}
