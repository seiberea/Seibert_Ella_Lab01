import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1;

    @BeforeEach
    void setUp() {
        p1 = new Product("00001", "Ella", "Small Home", 600.0);
    }

    @Test
    void setID() {
        p1.setID("1");
        assertEquals("1", p1.getID());
    }

    @Test
    void setName() {
        p1.setName("Greg");
        assertEquals("Greg", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Small Cabin");
        assertEquals("Small Cabin", p1.getDescription());
    }

    @Test
    void setCost() {
        p1.setCost(800.0);
        assertEquals(800.0, p1.getCost());
    }

    @Test
    void toCSV() {
        assertEquals("00001, Ella, Small Home, 600.0", p1.toCSV());
    }
}