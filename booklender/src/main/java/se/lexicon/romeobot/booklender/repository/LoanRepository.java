package se.lexicon.romeobot.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.romeobot.booklender.entity.Loan;

public interface LoanRepository extends CrudRepository<Loan, String> {

}
