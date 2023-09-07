import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person p1;
    @BeforeEach
    void setUp() {
        p1 = new Person("00001", "Ella", "Seibert", "Ms.", 2004);
    }

    @Test
    void toCSV() {
        assertEquals("00001, Ella, Seibert, Ms., 2004", p1.toCSV());
    }

    @Test
    void fullName() {
        assertEquals("Ella Seibert", p1.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Ms. Ella Seibert", p1.formalName());
    }

    @Test
    void getAge() {
        assertEquals(19, p1.getAge());
    }

    @Test
    void testGetAge() {
        assertEquals(26, p1.getAge(2030));
    }

    @Test
    void testSetLastName() {
        p1.setLastName("Johnson");
        assertEquals("Johnson", p1.getLastName());
    }
}