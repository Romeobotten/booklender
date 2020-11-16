package se.lexicon.romeobot.booklender.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.romeobot.booklender.entity.Book;
import se.lexicon.romeobot.booklender.entity.LibraryUser;
import se.lexicon.romeobot.booklender.entity.Loan;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanDtoTest {

    LibraryUserDto testUserDto;
    LibraryUserDto testUserDto2;
    BookDto testBookDto;
    BookDto testBookDto2;
    LoanDto testLoanDto;
    LoanDto testLoanDto2;

    @BeforeEach
    void setUp() {
        testUserDto = new LibraryUserDto(1, LocalDate.now(), "Ada Lovelace", "ada@lexicon.se");
        testBookDto = new BookDto(42, "Hitchikers Guide", false, true, 14, BigDecimal.valueOf(0.5), "Hitchikers guide to the Galaxy");
        testLoanDto = new LoanDto(1001, testUserDto, testBookDto, LocalDate.now().minusDays(10), false);
    }

    @Test
    void getLoanId() {
        testLoanDto.setLoanId(99);

        assertEquals(99, testLoanDto.getLoanId());
    }

//    @Test
//    void setLoanId() {
//    }

    @Test
    void getLoanTaker() {
        testUserDto2 = new LibraryUserDto(2, LocalDate.now(), "Adam Lovelace", "adam@lexicon.se");
        testLoanDto.setLoanTaker(testUserDto2);

        assertEquals(testUserDto2, testLoanDto.getLoanTaker());
    }

//    @Test
//    void setLoanTaker() {
//    }

    @Test
    void getBook() {
        testBookDto2 = new BookDto(21, "Hitchikers Guide 2", false, false, 14, BigDecimal.valueOf(10), "Hitchikers guide to the Galaxy 2");
        testLoanDto.setBook(testBookDto2);

        assertEquals(testBookDto2, testLoanDto.getBook());
    }

//    @Test
//    void setBook() {
//    }

    @Test
    void getLoanDate() {
        testLoanDto.setLoanDate(LocalDate.now().minusDays(2));

        assertEquals(LocalDate.now().minusDays(2), testLoanDto.getLoanDate());
    }

//    @Test
//    void setLoanDate() {
//    }

    @Test
    void isTerminate() {
        testLoanDto.setTerminate(true);

        assertTrue(testLoanDto.isTerminate());
    }

//    @Test
//    void setTerminate() {
//    }

    @Test
    void testEquals() {
        testLoanDto2 = new LoanDto(1001, testUserDto, testBookDto, LocalDate.now().minusDays(10), false);

        assertTrue(testLoanDto.equals(testLoanDto2));
        assertEquals(testLoanDto2.hashCode(), testLoanDto.hashCode());

    }


    @Test
    void testToString() {
        testLoanDto2 = new LoanDto(1001, testUserDto, testBookDto, LocalDate.now().minusDays(10), false);

        assertEquals(testLoanDto2.toString(), testLoanDto.toString());
    }
}