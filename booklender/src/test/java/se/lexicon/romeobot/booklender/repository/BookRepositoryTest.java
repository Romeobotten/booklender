package se.lexicon.romeobot.booklender.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.romeobot.booklender.entity.Book;
import se.lexicon.romeobot.booklender.entity.LibraryUser;

import java.math.BigDecimal;
import java.math.BigDecimal.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Transactional
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    Book testBook;

    @BeforeEach
    public void setUp() {
        testBook = new Book("Game of Toads",false,false, 7, BigDecimal.ONE, "Not a book about frogs");
        System.out.println("saving testBook in BeforeEach");
        testBook =bookRepository.save(testBook);
        System.out.println("testBook = " + testBook.toString());
    }

    @Test
    public void test1() {

        System.out.println(bookRepository.findById("1"));

//        assertEquals(bookRepository.findById("1"), testBook);
    }

    @Test
    public void test2() {

        List<Book> testBookList = (List<Book>)bookRepository.findAll();
        System.out.println(testBookList);

        assertTrue(((List<Book>) bookRepository.findAll()).size() == 1);
    }









}
