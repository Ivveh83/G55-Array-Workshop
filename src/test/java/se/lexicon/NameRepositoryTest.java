package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 tests for the NameRepository class.
 */
public class NameRepositoryTest {

    @BeforeEach
    void setUp() {
        // Återställ till ett känt tillstånd före varje test
        NameRepository.clear();
        NameRepository.add("Ivar Högblom"); // Standarddata för tester
    }

    // --- Befintliga tester med förbättringar ---

    @Test
    void testGetSize() {
        assertEquals(1, NameRepository.getSize(), "Arrayen har 1 namn efter setUp");
    }

    @Test
    void testSetNames() {
        String[] names = {"Erik Svensson", "Mehrdad Javan"};
        NameRepository.setNames(names);
        assertArrayEquals(names, NameRepository.findAll(),
                "findAll borde returnera samma array som sattes med setNames");
        // Förbättring: Jämför med findAll istället för names mot sig själv
    }

    @Test
    void testClear() {
        NameRepository.clear();
        assertEquals(0, NameRepository.getSize(), "Arrayen borde vara tom efter clear");
        assertArrayEquals(new String[0], NameRepository.findAll(),
                "findAll borde returnera en tom array efter clear");
    }

    @Test
    void testFindAll() {
        assertArrayEquals(new String[]{"Ivar Högblom"}, NameRepository.findAll(),
                "findAll borde returnera arrayen med Ivar Högblom från setUp");
    }

    @Test
    void testFind() {
        String name = NameRepository.find("Ivar Högblom");
        assertEquals("Ivar Högblom", name, "find borde returnera Ivar Högblom");
    }

    @Test // Fixade: Lade till @Test-annotering som saknades
    void testAdd() {
        boolean result = NameRepository.add("Barry Potter");
        assertTrue(result, "add borde returnera true för ett nytt namn");
        assertEquals(2, NameRepository.getSize(), "Storleken borde öka till 2");
    }

    @Test
    void testFindByFirstName() {
        String[] result = NameRepository.findByFirstName("Ivar");
        assertArrayEquals(new String[]{"Ivar Högblom"}, result,
                "findByFirstName borde returnera [Ivar Högblom]");
    }

    @Test
    void testFindByLastName() {
        String[] result = NameRepository.findByLastName("Högblom");
        assertArrayEquals(new String[]{"Ivar Högblom"}, result,
                "findByLastName borde returnera [Ivar Högblom]");
    }

    @Test
    void testUpdate() {
        NameRepository.update("Ivar Högblom", "Harry Potter");
        String[] result = NameRepository.findAll();
        assertArrayEquals(new String[]{"Harry Potter"}, result,
                "Arrayen borde uppdateras till [Harry Potter]");
    }

    @Test
    void testRemove() {
        boolean result = NameRepository.remove("Ivar Högblom");
        assertTrue(result, "remove borde returnera true för befintligt namn");
        assertEquals(0, NameRepository.getSize(), "Arrayen borde vara tom efter remove");
    }

    // --- Nya tester ---

    @Test
    void testGetSizeWithEmptyArray() {
        NameRepository.clear();
        assertEquals(0, NameRepository.getSize(), "Storleken borde vara 0 för en tom array");
    }

    @Test
    void testAddDuplicateName() {
        boolean result = NameRepository.add("Ivar Högblom"); // Försök lägga till samma namn igen
        assertFalse(result, "add borde returnera false för ett dubblettnamn");
        assertEquals(1, NameRepository.getSize(), "Storleken borde inte öka vid dubblett");
    }

    @Test
    void testFindNonExistingName() {
        String result = NameRepository.find("Anna Andersson");
        assertNull(result, "find borde returnera null för ett namn som inte finns");
    }

    @Test
    void testFindByFirstNameNoMatch() {
        String[] result = NameRepository.findByFirstName("Anna");
        assertArrayEquals(new String[0], result,
                "findByFirstName borde returnera en tom array om inget namn matchar");
    }

    @Test
    void testFindByLastNameNoMatch() {
        String[] result = NameRepository.findByLastName("Andersson");
        assertArrayEquals(new String[0], result,
                "findByLastName borde returnera en tom array om inget namn matchar");
    }

    @Test
    void testUpdateNonExistingName() {
        boolean result = NameRepository.update("Anna Andersson", "Anna Svensson");
        assertFalse(result, "update borde returnera false om originalnamnet inte finns");
        assertArrayEquals(new String[]{"Ivar Högblom"}, NameRepository.findAll(),
                "Arrayen borde inte ändras vid misslyckad update");
    }

    @Test
    void testRemoveNonExistingName() {
        boolean result = NameRepository.remove("Anna Andersson");
        assertFalse(result, "remove borde returnera false om namnet inte finns");
        assertEquals(1, NameRepository.getSize(), "Storleken borde inte ändras");
    }

    @Test
    void testSetNamesWithNull() {
        NameRepository.setNames(null);
        assertEquals(0, NameRepository.getSize(), "setNames(null) borde resultera i en tom array");
        assertArrayEquals(new String[0], NameRepository.findAll(),
                "findAll borde returnera en tom array efter setNames(null)");
    }

    @Test
    void testFindByFirstNameMultipleMatches() {
        NameRepository.add("Ivar Andersson");
        String[] result = NameRepository.findByFirstName("Ivar");
        assertArrayEquals(new String[]{"Ivar Högblom", "Ivar Andersson"}, result,
                "findByFirstName borde returnera alla namn med förnamnet Ivar");
    }

    @Test
    void testFindByLastNameMultipleMatches() {
        NameRepository.add("Anna Högblom");
        String[] result = NameRepository.findByLastName("Högblom");
        assertArrayEquals(new String[]{"Ivar Högblom", "Anna Högblom"}, result,
                "findByLastName borde returnera alla namn med efternamnet Högblom");
    }
}