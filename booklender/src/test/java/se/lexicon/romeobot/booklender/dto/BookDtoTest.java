package se.lexicon.romeobot.booklender.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.romeobot.booklender.entity.Book;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BookDtoTest {


    BookDto testBookDto;
    BookDto testBookDto2;
    BookDto testBookDto3;

    @BeforeEach
    void setUp() {
        testBookDto = new BookDto(42, "Hitchikers Guide", true, false, 14, BigDecimal.valueOf(0.5), "Hitchikers guide to the Galaxy");
    }


    @Test
    public void test1() {

        testBookDto.setTitle("Hitchikers Guide 2");
        testBookDto.setDescription("Second edition");

        assertEquals(testBookDto.getTitle(), "Hitchikers Guide 2");
        assertEquals(testBookDto.getDescription(), "Second edition");
    }

    @Test
    public void test2() {

        testBookDto.setReserved(true);
        testBookDto.setAvailable(false);

        assertFalse(testBookDto.isAvailable());
        assertTrue(testBookDto.isReserved());
    }

    @Test
    public void test3() {

        testBookDto.setMaxLoanDays(7);
        testBookDto.setFinePerDay(BigDecimal.valueOf(10));

        assertEquals(testBookDto.getMaxLoanDays(), 7);
        assertEquals(testBookDto.getFinePerDay(), BigDecimal.TEN);
    }

    @Test
    public void test4() {

        testBookDto2 = new BookDto(21, "Hitchikers Guide 2", false, true, 14, BigDecimal.valueOf(0.8), "Second Hitchikers guide to the Galaxy");
        testBookDto3 = new BookDto(42, "Hitchikers Guide", true, false, 14, BigDecimal.valueOf(0.5), "Hitchikers guide to the Galaxy");

        assertTrue(testBookDto.equals(testBookDto3));
        assertFalse(testBookDto.equals(testBookDto2));
        assertEquals(testBookDto.hashCode(), testBookDto3.hashCode());
    }
}