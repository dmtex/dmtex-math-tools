package com.github.dmtex.math.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArithmeticAdapterTest {

  @Test
  void testEqualsAndHashCode() {
    var value = new ArithmeticAdapter<>(1.0);
    assertAll(
        () -> assertTrue(equals(value, value), "equals(same)"),
        () -> assertFalse(equals(value, null), "equals(null)"),
        () -> assertFalse(equals(value, 1.0), "equals(ONE)"),
        () -> assertTrue(equals(value, new ArithmeticAdapter<>(1.0)), "equals(ArithmeticAdapter(1.0))"),
        () -> assertEquals(1072693279, value.hashCode(), "hashCode()")
    );
  }

  private boolean equals(Object a, Object b) {
    return a.equals(b);
  }
}
