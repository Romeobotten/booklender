package se.lexicon.romeobot.booklender.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import se.lexicon.romeobot.booklender.entity.LibraryUser;

import java.time.LocalDate;
import java.util.List;


@DataJpaTest
public class LibraryUserRepositoryTest {

    @Autowired
    LibraryUserRepository libraryUserRepository;

    LibraryUser testUser;

    @BeforeEach
    public void setUp() {
        testUser = new LibraryUser(LocalDate.now(), "Ada Lovelace", "ada@lexicon.se");

        libraryUserRepository.save(testUser);
    }

    @Test
    public void test1() {

        assertEquals(libraryUserRepository.findById(1).toString(), "Optional[" + testUser.toString() + "]");
    }

    @Test
    public void test2() {

        assertTrue(((List<LibraryUser>) libraryUserRepository.findAll()).size() == 1);
    }

    @Test
    public void test3() {

        libraryUserRepository.delete(testUser);

        assertTrue(((List<LibraryUser>) libraryUserRepository.findAll()).size() == 0);
    }

    @Test
    public void test4() {

        assertEquals(libraryUserRepository.findByEmailIgnoreCase("ada@lexicon.se"), testUser);
    }

}
