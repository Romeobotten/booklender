package se.lexicon.romeobot.booklender.repository;

import static org.junit.jupiter.api.Assertions.*;
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

@DataJpaTest
public class LoanRepositoryTest {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LibraryUserRepository libraryUserRepository;

    @Autowired
    BookRepository bookRepository;

    LibraryUser testUser = new LibraryUser(LocalDate.now(), "Ada Lovelace", "ada@lexicon.se");
    Book testBook = new Book("Game of Toads", 7, BigDecimal.ONE, "Not a book about frogs");
    Loan testLoan = new Loan(testUser, testBook, LocalDate.now(),false);

    @BeforeEach
    public void setUp() {

        loanRepository.save(testLoan);
    }

    @Test
    public void Test1() { // long, not Long

        assertEquals(loanRepository.findById((long)1).toString(), "Optional[" + testLoan.toString() + "]");
    }

    @Test
    public void Test2() {

        assertTrue(((List<Loan>) loanRepository.findAll()).size() == 1);
    }

    @Test
    public void Test3() {

        loanRepository.delete(testLoan);

        assertTrue(((List<Loan>) loanRepository.findAll()).size() == 0);
    }

    @Test
    public void Test4() {

        assertTrue(((List<Loan>) loanRepository.findAllByLoanTakerUserId(4)).size() == 1);
    }

    @Test
    public void Test5() {

        assertTrue(((List<Loan>) loanRepository.findAllByBookBookId(5)).size() == 1);
    }

    @Test
    public void Test6() {

        assertEquals(loanRepository.findAllByTerminate(false).toString(), "[" + testLoan + "]");
    }

}

