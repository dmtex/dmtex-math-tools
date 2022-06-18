package com.github.dmtex.math.adapter;

import com.github.dmtex.math.rational.BigRational;
import com.github.dmtex.math.rational.Rational;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import static com.github.dmtex.math.adapter.Adapters.of;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DoubleAdaptersTest {

  @Test
  void testOperations() {
    assertAll(
        () -> assertEquals(1.0, of(1.0).abs().toNumber(), "abs()"),
        () -> assertEquals(-1.0, of(1.0).negate().toNumber(), "negate()"),
        () -> assertEquals(1.0, of(1.0).reciprocal().toNumber(), "reciprocal()"),
        () -> assertEquals(2.0, of(1.0).plus(1.0).toNumber(), "plus(1.0)"),
        () -> assertEquals(2.0, of(1.0).plus(1).toNumber(), "plus(1)"),
        () -> assertEquals(2.0, of(1.0).plus(BigDecimal.ONE).toNumber(), "plus(BigDecimal.ONE)"),
        () -> assertEquals(2.0, of(1.0).plus(Rational.ONE).toNumber(), "plus(Rational.ONE)"),
        () -> assertEquals(2.0, of(1.0).plus(BigRational.ONE).toNumber(), "plus(BigRational.ONE)"),
        () -> assertEquals(2.0, of(1.0).plus(Short.valueOf((short) 1)).toNumber(), "plus(Number)"),
        () -> assertEquals(0.0, of(1.0).minus(1.0).toNumber(), "minus(1.0)"),
        () -> assertEquals(0.0, of(1.0).minus(1).toNumber(), "minus(1)"),
        () -> assertEquals(0.0, of(1.0).minus(BigDecimal.ONE).toNumber(), "minus(BigDecimal.ONE)"),
        () -> assertEquals(0.0, of(1.0).minus(Rational.ONE).toNumber(), "minus(Rational.ONE)"),
        () -> assertEquals(0.0, of(1.0).minus(BigRational.ONE).toNumber(), "minus(BigRational.ONE)"),
        () -> assertEquals(0.0, of(1.0).minus(Short.valueOf((short) 1)).toNumber(), "minus(Number)"),
        () -> assertEquals(1.0, of(1.0).times(1.0).toNumber(), "times(1.0)"),
        () -> assertEquals(1.0, of(1.0).times(1).toNumber(), "times(1)"),
        () -> assertEquals(1.0, of(1.0).times(BigDecimal.ONE).toNumber(), "times(BigDecimal.ONE)"),
        () -> assertEquals(1.0, of(1.0).times(Rational.ONE).toNumber(), "times(Rational.ONE)"),
        () -> assertEquals(1.0, of(1.0).times(BigRational.ONE).toNumber(), "times(BigRational.ONE)"),
        () -> assertEquals(1.0, of(1.0).times(Short.valueOf((short) 1)).toNumber(), "times(Number)"),
        () -> assertEquals(1.0, of(1.0).div(1.0).toNumber(), "div(1.0)"),
        () -> assertEquals(1.0, of(1.0).div(1).toNumber(), "div(1)"),
        () -> assertEquals(1.0, of(1.0).div(BigDecimal.ONE).toNumber(), "div(BigDecimal.ONE)"),
        () -> assertEquals(1.0, of(1.0).div(Rational.ONE).toNumber(), "div(Rational.ONE)"),
        () -> assertEquals(1.0, of(1.0).div(BigRational.ONE).toNumber(), "div(BigRational.ONE)"),
        () -> assertEquals(1.0, of(1.0).div(Short.valueOf((short) 1)).toNumber(), "div(Number)"),
        () -> assertEquals(0.0, of(1.0).rem(1.0).toNumber(), "rem(1.0)"),
        () -> assertEquals(0.0, of(1.0).rem(1).toNumber(), "rem(1)"),
        () -> assertEquals(0.0, of(1.0).rem(BigDecimal.ONE).toNumber(), "rem(BigDecimal.ONE)"),
        () -> assertEquals(0.0, of(1.0).rem(Rational.ONE).toNumber(), "rem(Rational.ONE)"),
        () -> assertEquals(0.0, of(1.0).rem(BigRational.ONE).toNumber(), "rem(BigRational.ONE)"),
        () -> assertEquals(0.0, of(1.0).rem(Short.valueOf((short) 1)).toNumber(), "rem(Number)"),
        () -> assertEquals(1.0, of(1.0).power(1).toNumber(), "power(1)"),
        () -> assertEquals(2.0, of(1.5).round().toNumber(), "round()"),
        () -> assertEquals(1.0, of(1.5).floor().toNumber(), "floor()"),
        () -> assertEquals(2.0, of(1.5).ceil().toNumber(), "ceil()"),
        () -> assertTrue(of(1.0).isIntegral(), "isIntegral() == true"),
        () -> assertFalse(of(1.5).isIntegral(), "isIntegral() == false"),
        () -> assertEquals(0, of(1.0).compareTo(of(1.0)), "compareTo(1.0)"),
        () -> assertEquals(1, of(1.0).intValue(), "intValue()"),
        () -> assertEquals(1L, of(1.0).longValue(), "longValue()"),
        () -> assertEquals(1.0f, of(1.0).floatValue(), "floatValue()"),
        () -> assertEquals(1.0, of(1.0).doubleValue(), "doubleValue()")
    );
  }

  @Test
  void testEqualsAndHashCode() {
    var value = new DefaultNumber(1.0);
    assertAll(
        () -> assertTrue(equals(value, value), "equals(same)"),
        () -> assertFalse(equals(value, null), "equals(null)"),
        () -> assertFalse(equals(value, 1.0), "equals(1.0)"),
        () -> assertTrue(equals(value, new DefaultNumber(1.0)), "equals(DecimalNumber(1.0))"),
        () -> assertFalse(equals(value, new DefaultNumber(0.0)), "equals(DecimalNumber(0.0))"),
        () -> assertEquals(1072693248, value.hashCode(), "hashCode()")
    );
  }

  private boolean equals(Object a, Object b) {
    return a.equals(b);
  }
}
