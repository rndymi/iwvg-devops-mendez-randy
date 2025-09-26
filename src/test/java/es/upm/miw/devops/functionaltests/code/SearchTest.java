package es.upm.miw.devops.functionaltests.code;

import es.upm.miw.devops.code.Search;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {

    @Test
    void testFindUserIdByAllProperFraction() {
        Search search = new Search();

        List<String> result = search.findUserIdByAllProperFraction().toList();

        assertEquals(1, result.size());
        assertTrue(result.contains("5"));
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        Search search = new Search();

        List<Double> result = search.findDecimalImproperFractionByUserName("Ana").toList();

        assertEquals(2, result.size());
        assertTrue(result.contains(2.0));
        assertTrue(result.contains(4.0/3.0));
    }

    @Test
    void testFindUserFamilyNameBySomeImproperFraction() {
        Search search = new Search();

        List<String> result = search.findUserFamilyNameBySomeImproperFraction().toList();

        assertEquals(5, result.size());
        assertTrue(result.contains("Fernandez"));
        assertTrue(result.contains("Blanco"));
        assertTrue(result.contains("López"));
        assertTrue(result.contains("Torres"));
    }

    @Test
    void testFindDecimalFractionByUserName() {
        Search search = new Search();

        List<Double> result = search.findDecimalFractionByUserName("Oscar").toList();

        assertEquals(7, result.size());
        assertTrue(result.contains(0.0));
        assertTrue(result.contains(2.0));
        assertTrue(result.contains(0.2));
        assertTrue(result.contains(-0.5));
        assertTrue(result.contains(0.5));
        assertTrue(result.contains(1.0));
    }

}
