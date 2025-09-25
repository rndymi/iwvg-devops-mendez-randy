package es.upm.miw.devops.functionaltests.code;

import es.upm.miw.devops.code.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {

    @Test
    void testFractionConstructor() {
        // Fracción esperada: 3/4
        Fraction fraction = new Fraction(3, 4);
        assertEquals(3, fraction.getNumerator(), "El numerador no es correcto.");
        assertEquals(4, fraction.getDenominator(), "El denominador no es correcto.");
    }

    @Test
    void testFractionDefaultConstructor() {
        // Verifica que la fracción por defecto sea 1/1
        Fraction fraction = new Fraction();
        assertEquals(1, fraction.getNumerator(), "El numerador por defecto debe ser 1.");
        assertEquals(1, fraction.getDenominator(), "El denominador por defecto debe ser 1.");
    }

}
