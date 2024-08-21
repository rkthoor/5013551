package com.example.bookstoreapi.repository;

import com.example.bookstoreapi.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class BookRepositoryIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testSaveAndFindBook() {
        Book book = new Book(null, "Title", "Author", 10.99, "1234567890");
        book = bookRepository.save(book);

        Book foundBook = bookRepository.findById(book.getId()).orElse(null);

        assertThat(foundBook).isNotNull();
        assertThat(foundBook.getTitle()).isEqualTo("Title");
        assertThat(foundBook.getAuthor()).isEqualTo("Author");
    }
}
