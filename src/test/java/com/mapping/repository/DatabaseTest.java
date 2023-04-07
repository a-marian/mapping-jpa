package com.mapping.repository;

import org.testcontainers.containers.PostgreSQLContainer;

public class DatabaseTest extends PostgreSQLContainer<DatabaseTest> {

    private static final String IMAGE_VERSION = "postgres:12";
    private static DatabaseTest container;

    private DatabaseTest(){
        super(IMAGE_VERSION);
    }

    public static DatabaseTest getInstance() {
        if (container == null) {
            container = new DatabaseTest();
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        super.stop();
        // do nothing, JVM handles sshut down
    }
}
