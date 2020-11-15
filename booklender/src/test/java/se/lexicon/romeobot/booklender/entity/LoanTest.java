package se.lexicon.romeobot.booklender.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LoanTest {

    LibraryUser testUser;
    LibraryUser testUser2;
    Book testBook;
    Book testBook2;
    Loan testLoan;
    Loan testLoan2;

    @BeforeEach
    public void setUp(){
        testUser = new LibraryUser(1, LocalDate.now(), "Ada Lovelace", "ada@lexicon.se");
        testBook = new Book(42, "Hitchikers Guide", 14, BigDecimal.valueOf(0.5), "Hitchikers guide to the Galaxy");
        testLoan = new Loan(1001, testUser, testBook, LocalDate.now().minusDays(10), false);
    }

    @Test
    public void test1() {

        assertEquals(testLoan.getBook(), testBook);
        assertEquals(testLoan.getLoanTaker(), testUser);
    }

    @Test
    public void test2() {

        assertFalse(testLoan.isOverdue());
        assertFalse(testLoan.isTerminate());
    }

    @Test
    public void test3() {

        assertEquals(testLoan.getFine(), BigDecimal.ZERO);
    }

    @Test
    public void test4() {

        testLoan2 = new Loan(1002, testUser, testBook, LocalDate.now().minusMonths(1), false);

        assertTrue(testLoan2.isOverdue());
        assertEquals(testLoan2.getFine(), BigDecimal.valueOf(8.5));
    }

    @Test
    public void test5() {

        testLoan2 = new Loan(1002, testUser, testBook, LocalDate.now().minusMonths(1), false);
        testLoan2.setTerminate(true);

        assertFalse(testLoan2.isOverdue());
        assertEquals(testLoan2.getFine(), BigDecimal.valueOf(0));
    }

    @Test
    public void test6() {

        testLoan2 = new Loan(1001, testUser, testBook, LocalDate.now().minusDays(10), false);

        assertTrue(testLoan.equals(testLoan2));
        assertEquals(testLoan.hashCode(), testLoan2.hashCode());
    }

    @Test
    public void test7() {

        testUser2 = new LibraryUser(2, LocalDate.now(), "Adam Lovelace", "adam@lexicon.se");
        testBook2 = new Book(21, "Hitchikers Guide 2", 14, BigDecimal.valueOf(0.8), "SecondHitchikers guide to the Galaxy");
        testLoan.setBook(testBook2);
        testLoan.setLoanTaker(testUser2);

        assertEquals(testLoan.getBook(), testBook2);
        assertEquals(testLoan.getLoanTaker(), testUser2);
    }

    @Test
    public void test8() {

        assertEquals(testLoan.toString(), "Loan{id=1001, loanTaker=LibraryUser{userId=1, regDate=2020-11-15, name='Ada Lovelace', email='ada@lexicon.se'}, " +
                "book=Book{bookId=42, title='Hitchikers Guide', available=true, reserved=false, maxLoanDays=14, finePerDay=0.5, description='Hitchikers guide to the Galaxy'}, loanDate=2020-11-05, terminate=false}");
    }

}
