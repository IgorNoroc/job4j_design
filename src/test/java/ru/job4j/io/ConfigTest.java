package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void whenGetLastProp() {
        Config config = new Config("./src/data/app.properties");
        config.load();
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }

    @Test
    public void whenTryToGetPropWithComment() {
        Config config = new Config("./src/data/app.properties");
        config.load();
        assertNull(config.value("##"));
    }
}