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

        // De tu UsersDatabase, revisamos cuáles cumplen:
        // - User 1 (fractions1): [0/1 (propia), 1/1 (no propia), 2/1 (no propia)] ❌
        // - User 2 (fractions2): [2/1 (no propia), -1/5 (propia), 2/4 (propia), 4/3 (no propia)] ❌
        // - User 3 (fractions3): [1/5 (propia), 3/-6 (propia), 1/2 (propia), 4/4 (no propia)] ❌
        // - User 4 (fractions4): [2/2 (no propia), 4/4 (no propia)] ❌
        // - User 5 (fractions5): [0/1 (propia), 0/-2 (propia), 0/3 (propia)] ✅ todas son propias
        // - User 6 (fractions6): [0/0 (indefinida), 1/0 (indefinida), 1/1 (no propia)] ❌

        assertEquals(1, result.size());
        assertTrue(result.contains("5"));
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        Search search = new Search();

        // En UsersDatabase tienes a "Ana" con fracciones:
        // [2/1 (impropia, 2.0), -1/5 (propia), 2/4 (propia), 4/3 (impropia, 1.333...)]
        List<Double> result = search.findDecimalImproperFractionByUserName("Ana").toList();

        assertEquals(2, result.size());
        assertTrue(result.contains(2.0));
        assertTrue(result.contains(4.0/3.0));
    }

}
