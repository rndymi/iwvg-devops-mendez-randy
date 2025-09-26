package es.upm.miw.devops.functionaltests.code;

import es.upm.miw.devops.code.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    @Test
    void testFractionConstructor() {
        Fraction fraction = new Fraction(3, 4);
        assertEquals(3, fraction.getNumerator(), "El numerador no es correcto.");
        assertEquals(4, fraction.getDenominator(), "El denominador no es correcto.");
    }

    @Test
    void testFractionDefaultConstructor() {
        Fraction fraction = new Fraction();
        assertEquals(1, fraction.getNumerator(), "El numerador por defecto debe ser 1.");
        assertEquals(1, fraction.getDenominator(), "El denominador por defecto debe ser 1.");
    }

    @Test
    void testIsProper() {
        Fraction properFraction = new Fraction(1, 2);
        Fraction improperFraction = new Fraction(3, 2);

        assertTrue(properFraction.isProper(), "1/2 debería ser propia.");
        assertFalse(improperFraction.isProper(), "3/2 no debería ser propia.");
    }

    @Test
    void testIsImproper() {
        Fraction improperFraction = new Fraction(5, 3);
        Fraction properFraction = new Fraction(2, 5);
        Fraction equalFraction = new Fraction(4, 4);

        assertTrue(improperFraction.isImproper(), "5/3 debería ser impropia.");
        assertFalse(properFraction.isImproper(), "2/5 no debería ser impropia.");
        assertTrue(equalFraction.isImproper(), "4/4 debería ser impropia.");
    }

    @Test
    void testIsEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 5);

        assertTrue(f1.isEquivalent(f2), "1/2 y 2/4 deberían ser equivalentes.");
        assertFalse(f1.isEquivalent(f3), "1/2 y 3/5 no deberían ser equivalentes.");
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);

        Fraction result = f1.add(f2);

        assertEquals(5, result.getNumerator(), "El numerador de la suma debe ser 5.");
        assertEquals(6, result.getDenominator(), "El denominador de la suma debe ser 6.");
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(1, 5);

        Fraction result = f1.multiply(f2);

        assertEquals(2, result.getNumerator(), "El numerador de la multiplicación debe ser 2.");
        assertEquals(15, result.getDenominator(), "El denominador de la multiplicación debe ser 15.");
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(1, 2);

        Fraction result = f1.divide(f2);

        assertEquals(6, result.getNumerator(), "El numerador de la división debe ser 6.");
        assertEquals(4, result.getDenominator(), "El denominador de la división debe ser 4.");
    }

}
