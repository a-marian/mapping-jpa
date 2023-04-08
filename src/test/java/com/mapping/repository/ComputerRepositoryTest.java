package com.mapping.repository;

import com.mapping.model.Computer;
import jakarta.transaction.Transactional;
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
    void whenFindAllAppleComputersThenAppleFound(){
        Collection<Computer> computerRecords = computerRepository.findAllAppleComputers();
        assertThat(computerRecords).hasSize(3);
    }

    @Test
    void whenFindAllAppleComputersNativeThenAppleFound(){
        List<Computer> computers = computerRepository.findAllAppleComputersNative();
        assertThat(computers).hasSize(3);
    }

}