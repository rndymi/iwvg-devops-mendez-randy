package es.upm.miw.devops.functionaltests.code;

import es.upm.miw.devops.code.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testIsProper() {
        Fraction properFraction = new Fraction(1, 2); // 1/2 es propia
        Fraction improperFraction = new Fraction(3, 2); // 3/2 es impropia

        assertTrue(properFraction.isProper(), "1/2 debería ser propia.");
        assertFalse(improperFraction.isProper(), "3/2 no debería ser propia.");
    }

    // 2. Test para isImproper
    @Test
    void testIsImproper() {
        Fraction improperFraction = new Fraction(5, 3); // 5/3 es impropia
        Fraction properFraction = new Fraction(2, 5); // 2/5 es propia
        Fraction equalFraction = new Fraction(4, 4); // 4/4 es impropia (mayor o igual)

        assertTrue(improperFraction.isImproper(), "5/3 debería ser impropia.");
        assertFalse(properFraction.isImproper(), "2/5 no debería ser impropia.");
        assertTrue(equalFraction.isImproper(), "4/4 debería ser impropia.");
    }

    // 3. Test para isEquivalent
    @Test
    void testIsEquivalent() {
        Fraction f1 = new Fraction(1, 2); // 1/2
        Fraction f2 = new Fraction(2, 4); // 2/4
        Fraction f3 = new Fraction(3, 5); // 3/5 (no equivalente)

        assertTrue(f1.isEquivalent(f2), "1/2 y 2/4 deberían ser equivalentes.");
        assertFalse(f1.isEquivalent(f3), "1/2 y 3/5 no deberían ser equivalentes.");
    }

    // 4. Test para add (Suma)
    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2); // 1/2
        Fraction f2 = new Fraction(1, 3); // 1/3
        // Resultado: (1*3 + 2*1) / (2*3) = 5/6
        Fraction result = f1.add(f2);

        assertEquals(5, result.getNumerator(), "El numerador de la suma debe ser 5.");
        assertEquals(6, result.getDenominator(), "El denominador de la suma debe ser 6.");
    }

    // 5. Test para multiply (Multiplicación)
    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(2, 3); // 2/3
        Fraction f2 = new Fraction(1, 5); // 1/5
        // Resultado: (2*1) / (3*5) = 2/15
        Fraction result = f1.multiply(f2);

        assertEquals(2, result.getNumerator(), "El numerador de la multiplicación debe ser 2.");
        assertEquals(15, result.getDenominator(), "El denominador de la multiplicación debe ser 15.");
    }

    // 6. Test para divide (División)
    @Test
    void testDivide() {
        Fraction f1 = new Fraction(3, 4); // 3/4
        Fraction f2 = new Fraction(1, 2); // 1/2
        // Resultado: (3*2) / (4*1) = 6/4
        Fraction result = f1.divide(f2);

        assertEquals(6, result.getNumerator(), "El numerador de la división debe ser 6.");
        assertEquals(4, result.getDenominator(), "El denominador de la división debe ser 4.");
    }

}
