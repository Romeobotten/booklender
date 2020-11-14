package se.lexicon.romeobot.booklender.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.romeobot.booklender.entity.LibraryUser;

public interface LibraryUserRepository extends CrudRepository<LibraryUser, Integer> {

    LibraryUser findByEmailIgnoreCase(String email);
}
