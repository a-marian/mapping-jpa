package com.mapping.repository;

import com.mapping.model.Cashier;
import jakarta.transaction.Transactional;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
@RunWith(SpringRunner.class)
class CashierRepositoryTest {
    @ClassRule
    static PostgreSQLContainer database = DatabaseTest.getInstance();

    @Autowired
    private CashierRepository cashierRepository;
    @Test
    @Transactional
    void whenUpdateCashierSetStatusByMailThenUpdatedUsersEqualOne() {
        int updatedUsers = cashierRepository
                .updateCashierSetStatusByMail(true, "ulises@mail.com");
        assertThat(updatedUsers).isEqualTo(1);
    }

    @Test
    @Transactional
    void whenUpdateCashierSetStatusByMailNativeThenUpdatedUsersEqualOne() {
        int updatedUsers = cashierRepository
                .updateCashierSetStatusByMailNative(true, "tamara@gmail.com");
        assertThat(updatedUsers).isEqualTo(1);
    }

    @Test
    void whenFindAllCashiersByMailGmailThenFoundCashiers() {
        List<Cashier> cashiers = cashierRepository.findAllCashiersByMailGmail();
        assertThat(cashiers).hasSize(3);
    }
}