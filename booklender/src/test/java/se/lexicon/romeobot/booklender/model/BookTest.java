package se.lexicon.romeobot.booklender.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookTest {

    Book testBook;

    @BeforeEach
    public void setUp(){
        testBook = new Book(42, "Hitchikers Guide", 14, BigDecimal.valueOf(0.5), "Hitchikers guide to the Galaxy");
    }

    @Test
    public void test1() {

        testBook.setTitle("Hitchikers Guide 2");

        assertEquals(testBook.getTitle(), "Hitchikers Guide 2");
    }

    @Test
    public void test2() {

        testBook.setReserved(true);
        testBook.setAvailable(false);

        assertFalse(testBook.isAvailable());
        assertTrue(testBook.isReserved());
    }


}
