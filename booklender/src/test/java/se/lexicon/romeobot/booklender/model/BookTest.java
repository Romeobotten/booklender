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
    Book testBook2;
    Book testBook3;

    @BeforeEach
    public void setUp(){
        testBook = new Book(42, "Hitchikers Guide", 14, BigDecimal.valueOf(0.5), "Hitchikers guide to the Galaxy");
    }

    @Test
    public void test1() {

        testBook.setTitle("Hitchikers Guide 2");
        testBook.setDescription("Second edition");

        assertEquals(testBook.getTitle(), "Hitchikers Guide 2");
        assertEquals(testBook.getDescription(), "Second edition");
    }

    @Test
    public void test2() {

        testBook.setReserved(true);
        testBook.setAvailable(false);

        assertFalse(testBook.isAvailable());
        assertTrue(testBook.isReserved());
    }

    @Test
    public void test3() {

        testBook.setMaxLoanDays(7);
        testBook.setFinePerDay(BigDecimal.valueOf(10));

        assertEquals(testBook.getMaxLoanDays(), 7);
        assertEquals(testBook.getFinePerDay(), BigDecimal.TEN);
    }

    @Test
    public void test4() {

        testBook2 = new Book(21, "Hitchikers Guide 2", 14, BigDecimal.valueOf(0.8), "Second Hitchikers guide to the Galaxy");
        testBook3 = new Book(42, "Hitchikers Guide", 14, BigDecimal.valueOf(0.5), "Hitchikers guide to the Galaxy");

        assertTrue(testBook.equals(testBook3));
        assertFalse(testBook.equals(testBook2));
        assertEquals(testBook.hashCode(), testBook3.hashCode());
    }

}

