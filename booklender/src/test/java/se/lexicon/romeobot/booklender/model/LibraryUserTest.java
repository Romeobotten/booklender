package se.lexicon.romeobot.booklender.model;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
// import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryUserTest {

    LibraryUser testUser;
    LibraryUser testUser2;

    @BeforeEach
    public void setUp(){
        testUser = new LibraryUser(1, LocalDate.now(), "Ada Lovelace", "ada@lexicon.se");
    }

    @Test
    public void test1() {

        testUser.setName("Adam Lovelace");
        assertEquals(testUser.getEmail(),"ada@lexicon.se");
        assertEquals(testUser.getName(), "Adam Lovelace");
    }

    @Test
    public void test2() {

        testUser.setEmail("adam@lexicon.se");
        assertEquals(testUser.getName(), "Ada Lovelace");
        assertEquals(testUser.getEmail(),"adam@lexicon.se");
    }

    @Test
    public void test3() {

        assertEquals(testUser.getUserId(), 1);
        assertEquals(testUser.getRegDate(), LocalDate.now());
    }

    @Test
    public void test4() {
        testUser2 = new LibraryUser(1, LocalDate.now(), "Ada Lovelace", "ada@lexicon.se");

        assertTrue(testUser.equals(testUser2));
        assertEquals(testUser.hashCode(), testUser2.hashCode());
    }

    @Test
    public void test5() {

        assertEquals(testUser.toString(), "LibraryUser{userId=1, regDate=2020-11-05, name='Ada Lovelace', email='ada@lexicon.se'}");
    }

}
