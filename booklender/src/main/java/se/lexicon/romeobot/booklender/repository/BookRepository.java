package se.lexicon.romeobot.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.romeobot.booklender.entity.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAllByReserved(boolean reserved);

    List<Book> findAllByAvailable(boolean available);

    Book findByTitle(String title);
}
