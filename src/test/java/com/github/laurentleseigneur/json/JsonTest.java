package com.github.laurentleseigneur.json;

import static java.lang.Math.toIntExact;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.io.Serializable;
import java.util.Map;

import org.json.simple.JSONValue;
import org.junit.Test;

public class JsonTest {

    @Test
    public void jsonJSONExample() {
        //given
        Integer expectedAmount = 39;
        String json = "{\"amountInput\":39}";

        //when
        Map<String, Serializable> content = (Map<String, Serializable>) JSONValue.parse(json);

        //then
        content.computeIfPresent("amountInput", (Object o, Object o2) -> toIntExact((Long) o2));
        assertThat(content).as("should parse integer").contains(entry("amountInput", expectedAmount));

    }
}
