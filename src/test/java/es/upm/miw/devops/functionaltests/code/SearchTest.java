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

    @Test
    void testFindUserFamilyNameBySomeImproperFraction() {
        Search search = new Search();

        List<String> result = search.findUserFamilyNameBySomeImproperFraction().toList();

        // Revisando UsersDatabase:
        // - "Oscar Fernandez": tiene 2/1 → impropia ✅
        // - "Ana Blanco": tiene 2/1 y 4/3 → impropias ✅
        // - "Oscar López": tiene 3/-6 (propia), 1/2 (propia), 4/4 (impropia) ✅
        // - "Paula Torres": tiene 2/2 y 4/4 → impropias ✅
        // - "Antonio Blanco": solo ceros → 0/n = propia ❌
        // - "Paula Torres" (id=6): tiene 1/1 → impropia ✅
        // Resultado esperado = ["Fernandez", "Blanco", "López", "Torres", "Torres"]

        assertEquals(5, result.size());
        assertTrue(result.contains("Fernandez"));
        assertTrue(result.contains("Blanco"));
        assertTrue(result.contains("López"));
        assertTrue(result.contains("Torres"));
    }

    @Test
    void testFindDecimalFractionByUserName() {
        Search search = new Search();

        // Caso: buscar las fracciones decimales de "Oscar"
        List<Double> result = search.findDecimalFractionByUserName("Oscar").toList();

        // En UsersDatabase hay 2 usuarios con nombre "Oscar":
        // 1) "Oscar Fernandez" → [0/1=0.0, 1/1=1.0, 2/1=2.0]
        // 2) "Oscar López" → [1/5=0.2, 3/-6=-0.5, 1/2=0.5, 4/4=1.0]
        // Resultado esperado: [0.0, 1.0, 2.0, 0.2, -0.5, 0.5, 1.0]

        assertEquals(7, result.size());
        assertTrue(result.contains(0.0));
        assertTrue(result.contains(2.0));
        assertTrue(result.contains(0.2));
        assertTrue(result.contains(-0.5));
        assertTrue(result.contains(0.5));
        assertTrue(result.contains(1.0)); // aparece dos veces
    }

}
