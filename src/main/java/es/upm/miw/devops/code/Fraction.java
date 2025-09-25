package es.upm.miw.devops.code;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    // Metodo 1: Fracción Propia (isProper)
    // Una fracción es propia si el valor absoluto del numerador es menor que el valor absoluto del denominador.
    public boolean isProper() {
        return Math.abs(this.numerator) < Math.abs(this.denominator);
    }

    // Metodo 2: Fracción Impropia (isImproper)
    // Una fracción es impropia si el valor absoluto del numerador es mayor o igual que el valor absoluto del denominador.
    // Simplemente es lo opuesto a isProper.
    public boolean isImproper() {
        return Math.abs(this.numerator) >= Math.abs(this.denominator);
    }

    // Metodo 3: Fracción Equivalente (isEquivalent)
    // Dos fracciones son equivalentes si a * d = b * c (siendo a/b y c/d).
    public boolean isEquivalent(Fraction fraction) {
        // a * d == b * c
        return this.numerator * fraction.denominator == this.denominator * fraction.numerator;
    }

    // Metodo 4: Suma (add)
    // La suma de a/b + c/d es (a*d + b*c) / (b*d).
    public Fraction add(Fraction fraction) {
        int newNumerator = this.numerator * fraction.denominator + this.denominator * fraction.numerator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
        // Nota: Para ser más robusto, el resultado debería simplificarse aquí.
    }

    // Metodo 5: Multiplicación (multiply)
    // La multiplicación de a/b * c/d es (a*c) / (b*d).
    public Fraction multiply(Fraction fraction) {
        int newNumerator = this.numerator * fraction.numerator;
        int newDenominator = this.denominator * fraction.denominator;
        return new Fraction(newNumerator, newDenominator);
        // Nota: El resultado debería simplificarse aquí.
    }

    // Metodo 6: División (divide)
    // La división de a/b / c/d es (a*d) / (b*c).
    public Fraction divide(Fraction fraction) {
        int newNumerator = this.numerator * fraction.denominator;
        int newDenominator = this.denominator * fraction.numerator;
        return new Fraction(newNumerator, newDenominator);
        // Nota: El resultado debería simplificarse aquí.
    }



    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

}
