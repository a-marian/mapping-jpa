package com.mapping.repository;

import com.mapping.model.Computer;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest
class ComputerRepositoryTest {

    @ClassRule
    static PostgreSQLContainer database = DatabaseTest.getInstance();

    @Autowired
    private ComputerRepository computerRepository;

    @Test
    @Transactional
    void whenPersistComputerThenNotNullComputerId() {
        Computer computer = createComputer("AAA212", "HP" );
        assertNull(computer.getComputerId());
        computerRepository.persist(computer);
        assertNotNull(computer.getComputerId());
    }

    private Computer createComputer(String code, String brand) {
        Computer comp = new Computer();
        comp.setCode(code);
        comp.setBrand(brand);
        return comp;
    }

    @Test
    @Transactional
    void whenFindAllAppleComputersThenAppleFound(){
        addComputers();
        Collection<Computer> computerRecords = computerRepository.findAllAppleComputers();
        assertThat(computerRecords).hasSize(3);
    }

    @Test
    @Transactional
    void whenFindAllAppleComputersNativeThenAppleFound(){
        addComputers();
        List<Computer> computers = computerRepository.findAllAppleComputersNative();
        assertThat(computers).hasSize(3);
    }


    private void addComputers(){
        computerRepository.persist(createComputer("AAA123", "Apple" ));
        computerRepository.persist(createComputer("AAA222", "HP" ));
        computerRepository.persist(createComputer("AAA333", "Apple" ));
        computerRepository.persist(createComputer("AAA444", "Dell" ));
        computerRepository.persist(createComputer("AAA123", "Apple" ));
        computerRepository.flush();

    }
}