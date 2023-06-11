package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10.2.1. Task.",
                "1.3. Task.",
                "1.4. Task."
        };
        String[] out = {
                "1.3. Task.",
                "1.4. Task.",
                "10.2.1. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(out);
    }
}