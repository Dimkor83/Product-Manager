package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "First", 100, "Author1");
    Book book2 = new Book(2, "Second", 200, "Author2");
    Book book3 = new Book(3, "Second", 300, "Author3");
    Smartphone smartphone1 = new Smartphone(4, "Iphone", 100000, "Apple");
    Smartphone smartphone2 = new Smartphone(5, "Redmi", 10000, "Xiaomi");
    Smartphone smartphone3 = new Smartphone(6, "Galaxy", 50000, "Samsung");

    @Test
    void findAllProduct() {
        Product[] expected = new  Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSave() {
        repository.save(new Smartphone(7, "Honor", 1000, "Huawei"));
        int expected = 7;
        Product[] actual = repository.findAll();
    }

    @Test
    void shouldAddOneBook() {
        repository.save(book1);
        Product[] expected = new Product[]{book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddOneSmartphone() {
        repository.save(smartphone1);
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}
