package se.lexicon.romeobot.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.romeobot.booklender.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
