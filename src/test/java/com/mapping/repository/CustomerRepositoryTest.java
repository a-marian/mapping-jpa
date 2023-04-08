package com.mapping.repository;

import com.mapping.model.Customer;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
class CustomerRepositoryTest {

    @ClassRule
    static PostgreSQLContainer databaseTest = DatabaseTest.getInstance();

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void whenFindCustomersByTaxIdentifierListThenListFound() {
        List<Customer> customerList = customerRepository
                .findCustomersByIdentifierList(List.of("1111111", "1111112"));

        assertThat(customerList).extracting("mail")
                .containsAnyOf("mara@mail.com", "ana@mail.com")
                .hasSize(2);
    }

    @Test
    @Transactional
    void whenPersistCustomerThenCustomerFound(){

        Customer customer = customerRepository.findByIdentifier("1111113");
        assertThat(customer).isNull();

         customer = new  Customer();
                customer.setCustomerName("Ryan Thomas");
                customer.setMail("ryan@mail.com");
                customer.setIdentifier("1111113");
                customer.setAddress("Apple st. 111");

        customerRepository.persist(customer);
        customerRepository.flush();

        Customer customerFound = customerRepository.findByIdentifier("1111113");
        assertThat(customerFound).isNotNull();
        assertEquals(customerFound.getCustomerName(), "Ryan Thomas");
        assertNotNull(customerFound.getCustomerId());

    }

}