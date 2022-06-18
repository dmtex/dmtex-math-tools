package com.github.dmtex.math.adapter;

import com.github.dmtex.math.rational.BigRational;
import com.github.dmtex.math.rational.Rational;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.math.adapter.Adapters.lookup;
import static com.github.dmtex.math.rational.Rational.ONE;
import static com.github.dmtex.math.rational.Rational.TWO;
import static com.github.dmtex.math.rational.Rational.ZERO;
import static com.github.dmtex.math.rational.Rational.valueOf;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RationalAdaptersTest {

  @Test
  void testOperations() {
    assertAll(
        () -> assertEquals(ONE, lookup(ONE).abs(), "abs()"),
        () -> assertEquals(new Rational(-1), lookup(ONE).negate(), "negate()"),
        () -> assertEquals(ONE, lookup(ONE).reciprocal(), "reciprocal()"),
        () -> assertEquals(TWO, lookup(ONE).plus(1.0), "plus(1.0)"),
        () -> assertEquals(TWO, lookup(ONE).plus(1), "plus(1)"),
        () -> assertEquals(TWO, lookup(ONE).plus(BigDecimal.ONE), "plus(BigDecimal.ONE)"),
        () -> assertEquals(TWO, lookup(ONE).plus(BigRational.ONE), "plus(BigRational.ONE)"),
        () -> assertEquals(ZERO, lookup(ONE).minus(1.0), "minus(1.0)"),
        () -> assertEquals(ZERO, lookup(ONE).minus(1), "minus(1)"),
        () -> assertEquals(ZERO, lookup(ONE).minus(BigDecimal.ONE), "minus(BigDecimal.ONE)"),
        () -> assertEquals(ZERO, lookup(ONE).minus(BigRational.ONE), "minus(BigRational.ONE)"),
        () -> assertEquals(ONE, lookup(ONE).times(1.0), "times(1.0)"),
        () -> assertEquals(ONE, lookup(ONE).times(1), "times(1)"),
        () -> assertEquals(ONE, lookup(ONE).times(BigDecimal.ONE), "times(BigDecimal.ONE)"),
        () -> assertEquals(ONE, lookup(ONE).times(BigRational.ONE), "times(BigRational.ONE)"),
        () -> assertEquals(ONE, lookup(ONE).div(1.0), "div(1.0)"),
        () -> assertEquals(ONE, lookup(ONE).div(1), "div(1)"),
        () -> assertEquals(ONE, lookup(ONE).div(BigDecimal.ONE), "div(BigDecimal.ONE)"),
        () -> assertEquals(ONE, lookup(ONE).div(BigRational.ONE), "div(BigRational.ONE)"),
        () -> assertEquals(ZERO, lookup(ONE).rem(1.0), "rem(1.0)"),
        () -> assertEquals(ZERO, lookup(ONE).rem(1), "rem(1)"),
        () -> assertEquals(ZERO, lookup(ONE).rem(BigDecimal.ONE), "rem(BigDecimal.ONE)"),
        () -> assertEquals(ZERO, lookup(ONE).rem(BigRational.ONE), "rem(BigRational.ONE)"),
        () -> assertEquals(ONE, lookup(ONE).power(1), "power(1)"),
        () -> assertEquals(TWO, lookup(valueOf(1.5)).round(), "round()"),
        () -> assertEquals(ONE, lookup(valueOf(1.5)).floor(), "floor()"),
        () -> assertEquals(TWO, lookup(valueOf(1.5)).ceil(), "ceil()"),
        () -> assertTrue(lookup(ONE).isIntegral(), "isIntegral() == true"),
        () -> assertFalse(lookup(valueOf(1.5)).isIntegral(), "isIntegral() == false"),
        () -> assertEquals(0, lookup(ONE).compareTo(ONE), "compareTo(ONE)")
    );
  }

  @Test
  void testEqualsAndHashCode() {
    var value = new RationalNumber(ONE);
    assertAll(
        () -> assertTrue(equals(value, value), "equals(same)"),
        () -> assertFalse(equals(value, null), "equals(null)"),
        () -> assertFalse(equals(value, ONE), "equals(ONE)"),
        () -> assertTrue(equals(value, new RationalNumber(ONE)), "equals(RationalNumber(ONE))"),
        () -> assertEquals(993, value.hashCode(), "hashCode()")
    );
  }

  private boolean equals(Object a, Object b) {
    return a.equals(b);
  }
}
