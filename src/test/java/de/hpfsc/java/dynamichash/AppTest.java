package de.hpfsc.java.dynamichash;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void checkHash() {
        assertThat(App.getHash("Hello World!")).isEqualTo("aacfe6ebd3737d9f195c837c5281d3");
    }
}
