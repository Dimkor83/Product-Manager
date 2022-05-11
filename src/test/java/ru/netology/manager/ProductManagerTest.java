package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager productManager = new ProductManager(repository);
    Book book1 = new Book(1, "First", 100, "Author1");
    Book book2 = new Book(2, "Second", 200, "Author2");
    Book book3 = new Book(3, "Second", 300, "Author3");
    Smartphone smartphone1 = new Smartphone(4, "Iphone", 100000, "Apple");
    Smartphone smartphone2 = new Smartphone(5, "Redmi", 10000, "Xiaomi");
    Smartphone smartphone3 = new Smartphone(6, "Galaxy", 50000, "Samsung");



    @Test
    void shouldAddOneBook() {
        productManager.add(book1);

        Product[] expected = new Product[] {book1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddOneSmartphone() {
        productManager.add(smartphone3);

        Product[] expected = new Product[] {smartphone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameBook() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);

        Product[] expected = new Product[]{book1};
        Product[] actual = productManager.searchBy("First");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameSmartphone() {
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] expected = new Product[]{smartphone2};
        Product[] actual = productManager.searchBy("Redmi");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByDifferentClasses() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] expected = new Product[0];
        Product[] actual = productManager.searchBy("fourth");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySomeProductFitRequest() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);
        productManager.add(smartphone1);
        productManager.add(smartphone2);
        productManager.add(smartphone3);

        Product[] expected = new Product[] {smartphone1};
        Product[] actual = productManager.searchBy("Iphone");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchForProductsWithSameName() {
        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);

        Product[] expected = new Product[] {book2, book3};
        Product[] actual = productManager.searchBy("Second");
        assertArrayEquals(expected, actual);
    }
}