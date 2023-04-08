package com.mapping.repository;

import com.mapping.model.Product;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductRepositoryTest {
    @ClassRule
    static PostgreSQLContainer db = DatabaseTest.getInstance();
    @Autowired
    private ProductRepository productRepository;

    @Test
    void whenFindProductsSortedByNameThenAllSorted() {
        List<Product>  productList = productRepository.findAllProducts(Sort.by(Sort.Direction.DESC, "price"));
        assertThat(productList)
                .extracting("price")
                .containsSequence(305.0, 300.0, 290.0, 280.0, 270.0, 250.0, 240.0, 230.0, 230.0, 225.0);
    }

    @Test
    void whenFindProductsSortedByNameAndPriceThenAllSorted() {
        List<Product>  productList = productRepository.findAllProducts(JpaSort.unsafe("LENGTH(productName)", "price"));
        assertThat(productList)
                .extracting("productName")
                .containsSequence(
                        "Alien",
                        "Invictus",
                        "Miss Dior",
                        "Sauvage Elixir",
                        "Bleu de Chanel",
                        "Prada Paradoxe",
                        "Good Girl Legere",
                        "Fame Blooming Pink",
                        "Allure Homme Sport",
                        "Boss Bottled Pacific"
                        );
    }

    @Test
    void whenFindAllProductWithPaginationThenPageFound() {
        Page<Product> page = productRepository.findAllProductWithPagination(PageRequest.of(0,3));
        assertThat(page.stream().map(Product::getProductCode)).hasSize(3).containsAnyOf( "CHA111","CAR111", "CHA112");
    }
    @Test
    void whenFindAllProductsWithPaginationNativeThenPageFound() {
        Page<Product> page = productRepository.findAllProductsWithPaginationNative(PageRequest.of(0,2));
        assertThat(page.stream().map(Product::getDescription)).containsOnly("CAROLINA HERRERA", "CHANNEL")
                .hasSize(2);
    }
    @Test
    void whenFindAllProductsByDescriptionAndBetweenPriceRangeThenThree(){
        Page<Product> products = productRepository.findAllProductsBySearchModel(Pageable.ofSize(3),
                "", "CHANNEL", 250.0,400.0);
        assertThat(products.stream().map(Product::getProductName))
                .containsExactly( "Coco Mademoiselle le eau privée", "Bleu de Chanel", "Allure Homme Sport");

    }


}