package se.lexicon.romeobot.booklender.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import se.lexicon.romeobot.booklender.entity.Book;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    Book testBook;

    @BeforeEach
    public void setUp() {
        testBook = new Book("Game of Toads", 7, BigDecimal.ONE, "Not a book about frogs");

        bookRepository.save(testBook);

    }

    @Test
    public void test1() {

        System.out.println(bookRepository.findById(1));
        assertEquals(bookRepository.findById(1).toString(), "Optional[" + testBook.toString() +"]");
    }

    @Test
    public void test2() {

        List<Book> testBookList = (List<Book>)bookRepository.findAll();

        assertTrue(((List<Book>) bookRepository.findAll()).size() == 1);
    }

    @Test
    public void test3() {

        bookRepository.delete(testBook);

        assertTrue(((List<Book>) bookRepository.findAll()).size() == 0);
    }

    @Test
    public void test4() {

        assertTrue(((List<Book>) bookRepository.findAllByReserved(false)).size() == 1);
    }

    @Test
    public void test5() {

        assertTrue(((List<Book>) bookRepository.findAllByAvailable(true)).size() == 1);
    }

    @Test
    public void test6() {

        assertEquals(bookRepository.findByTitle("Game of Toads"),testBook);
    }

}
