package com.steve.book.common;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

public abstract class AbstractionBaseTest {

    @Container
    private static PostgreSQLContainer POSTGRES_CONTAINER;

    static {
        POSTGRES_CONTAINER = new PostgreSQLContainer()
                .withUsername("postgres")
                .withPassword("postgres")
                .withDatabaseName("dbbook");
    }

    @BeforeAll
    public static void beforeAll() {
        POSTGRES_CONTAINER.start();
    }

    @AfterAll
    public static void afterAll() {
        POSTGRES_CONTAINER.stop();
    }

    @Test()
    void isRunning(){
        Assertions.assertTrue(POSTGRES_CONTAINER.isRunning());
    }

    @DynamicPropertySource
    static void dynamicPropertySource(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", POSTGRES_CONTAINER::getJdbcUrl);
        registry.add("spring.datasource.username", POSTGRES_CONTAINER::getUsername);
        registry.add("spring.datasource.password", POSTGRES_CONTAINER::getPassword);
    }


}
