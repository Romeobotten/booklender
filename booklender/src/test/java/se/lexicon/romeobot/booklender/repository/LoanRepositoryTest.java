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

//    @Autowired
//    LibraryUserRepository libraryUserRepository;
//
//    @Autowired
//    BookRepository bookRepository;

    Book testBook;
    LibraryUser testUser;
    Loan testLoan;

    @BeforeEach
    public void setUp() {
        testUser = new LibraryUser(LocalDate.now(), "Ada Lovelace", "ada@lexicon.se");
        testBook = new Book("Game of Toads",true,false, 7, BigDecimal.ONE, "Not a book about frogs");
        testLoan = new Loan(testUser, testBook, LocalDate.now(),false);
        System.out.println("testUser?");
//        libraryUserRepository.save(testUser);
//        bookRepository.save(testBook);
        loanRepository.save(testLoan);
    }

//    @AfterEach
//    void tearDown() {
//    }

    @Test
    public void Test1() {

        assertEquals(loanRepository.findById((long) 1).toString(), "Optional[" + testLoan.toString() + "]");
    }

    @Test
    public void Test2() {
        List<Loan> testUserList = (List<Loan>) loanRepository.findAll();
//        System.out.println(testUserList);

        assertTrue(((List<Loan>) loanRepository.findAll()).size() == 1);
    }

    @Test
    public void Test3() {

        loanRepository.delete(testLoan);
//        System.out.println(testUserList);

        assertTrue(((List<Loan>) loanRepository.findAll()).size() == 0);
    }

}

