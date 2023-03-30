package com.mapping.repository;

import com.mapping.model.Computer;
import com.mapping.record.ComputerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ComputerRepositoryTest {

    @Container
    static PostgreSQLContainer database = new PostgreSQLContainer<>("postgres:12")
            .withDatabaseName("demodb")
            .withUsername("postgres")
            .withPassword("testing");

    @DynamicPropertySource
    static void setDatasourceProperties(DynamicPropertyRegistry propertyRegistry){
        propertyRegistry.add("spring.datasource.url", database::getJdbcUrl);
        propertyRegistry.add("spring.datasource.username", database::getUsername);
        propertyRegistry.add("spring.datasource.password", database::getPassword);
    }

    @Autowired
    private ComputerRepository computerRepository;

    @Test
    void saveComputer() {



    }


    @Test
    void findAllContainingAppleBrand() {
        List<ComputerRecord> computerRecords = computerRepository.findAllContainingAppleBrand();
        assertEquals(2, computerRecords);
    }

    @Test
    void persist() {
        Computer computer1 = createComputer("AAA123", "Apple" );
        Computer computer2 = createComputer("AAA222", "HP" );
        Computer computer3 = createComputer("AAA333", "Apple" );
        Computer computer4 = createComputer("AAA444", "Dell" );
        computerRepository.persist(computer1);
        computerRepository.persist(computer2);
        computerRepository.persist(computer3);
        computerRepository.persist(computer4);
    }
    private Computer createComputer(String code, String brand) {
        Computer comp = new Computer();
        comp.setCode(code);
        comp.setBrand(brand);
        return comp;
    }
}