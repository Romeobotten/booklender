package se.lexicon.romeobot.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.romeobot.booklender.entity.Loan;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan, Long> {

    List<Loan> findAllByLoanTakerUserId(int userId);

    List<Loan> findAllByBookBookId(int bookId);

    List<Loan> findAllByTerminate(boolean terminate);
}
