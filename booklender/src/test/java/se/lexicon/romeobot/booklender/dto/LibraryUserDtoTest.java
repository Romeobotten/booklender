package se.lexicon.romeobot.booklender.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.romeobot.booklender.entity.LibraryUser;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUserDtoTest {

    LibraryUserDto testUserDto;
    LibraryUserDto testUserDto2;

    @BeforeEach
    void setUp() {
        testUserDto = new LibraryUserDto(1, LocalDate.now(), "Ada Lovelace", "ada@lexicon.se");
    }

    @Test
    void getUserId() {
        testUserDto.setUserId(99);

        assertEquals(99, testUserDto.getUserId());
    }

//    @Test
//    void setUserId() {
//    }

    @Test
    void getRegDate() {
        testUserDto.setRegDate(LocalDate.now().minusDays(2));

        assertEquals(LocalDate.now().minusDays(2), testUserDto.getRegDate());
    }

//    @Test
//    void setRegDate() {
//    }

    @Test
    void getName() {
        testUserDto.setName("Adam L");

        assertEquals("Adam L", testUserDto.getName());

    }

//    @Test
//    void setName() {
//    }

    @Test
    void getEmail() {
        testUserDto.setEmail("adam@lexicon.se");

        assertEquals("adam@lexicon.se", testUserDto.getEmail());
    }

//    @Test
//    void setEmail() {
//    }

    @Test
    void testEquals() {

        testUserDto2 = new LibraryUserDto(1, LocalDate.now(), "Ada Lovelace", "ada@lexicon.se");

        assertTrue(testUserDto.equals(testUserDto2));
        assertEquals(testUserDto.hashCode(), testUserDto2.hashCode());
    }

//    @Test
//    void testHashCode() {
//    }

    @Test
    void testToString() {
        String today = LocalDate.now().toString();

        assertEquals("LibraryUserDto{userId=1, regDate=" + today
                + ", name='Ada Lovelace', email='ada@lexicon.se'}",testUserDto.toString());
    }
}