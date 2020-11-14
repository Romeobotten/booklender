package se.lexicon.romeobot.booklender.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.romeobot.booklender.entity.Book;
import se.lexicon.romeobot.booklender.entity.LibraryUser;
import se.lexicon.romeobot.booklender.entity.Loan;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class LoanRepositoryTest {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LibraryUserRepository libraryUserRepository;

    @Autowired
    BookRepository bookRepository;

//    Book testBook;
//    LibraryUser testUser;
//    Loan testLoan;
    LibraryUser testUser = new LibraryUser(LocalDate.now(), "Ada Lovelace", "ada@lexicon.se");
    Book testBook = new Book("Game of Toads", 7, BigDecimal.ONE, "Not a book about frogs");
    Loan testLoan = new Loan(testUser, testBook, LocalDate.now(),false);

    @BeforeEach
    public void setUp() {

//        System.out.println("testUser?");
//        libraryUserRepository.save(testUser);
//        bookRepository.save(testBook);
        loanRepository.save(testLoan);

    }

    @AfterEach
    public void tearDown() {
//        libraryUserRepository.delete(testUser);
//        bookRepository.delete(testBook);
//        loanRepository.delete(testLoan);

    }

    @Test
    public void Test1() {
        System.out.println(testUser);

        assertEquals(loanRepository.findById((long)1).toString(), "Optional[" + testLoan.toString() + "]");
    }

    @Test
    public void Test2() {
//        List<Loan> testLoanList = (List<Loan>) loanRepository.findAll();
        System.out.println((List<Loan>) loanRepository.findAll());

        assertTrue(((List<Loan>) loanRepository.findAll()).size() == 1);
    }

    @Test
    public void Test3() {
        System.out.println(testUser);
        loanRepository.delete(testLoan);
//        System.out.println(testUserList);

        assertTrue(((List<Loan>) loanRepository.findAll()).size() == 0);
    }

    @Test
    public void Test4() {
        System.out.println(testUser);
        assertTrue(((List<Loan>) loanRepository.findAllByLoanTakerUserId(4)).size() == 1);
    }

    @Test
    public void Test5() {
        System.out.println(testUser);
        System.out.println(testBook);
        assertTrue(((List<Loan>) loanRepository.findAllByBookBookId(5)).size() == 1);
    }

    @Test
    public void Test6() {

        assertEquals(loanRepository.findAllByTerminate(false).toString(), "[" + testLoan + "]");
    }
}

