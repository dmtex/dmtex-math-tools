package com.github.dmtex.math.adapter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * {@code DecimalNumber} class is adaptation of {@link BigDecimal} to {@link ArithmeticAware}.
 *
 * @author Denis Murashev
 *
 * @since Math Adapter 1.0
 */
final class DecimalNumber implements ArithmeticAware<BigDecimal> {

  private final BigDecimal x;
  private final MathContext mc;

  DecimalNumber(BigDecimal value) {
    x = value;
    mc = new MathContext(value.precision());
  }

  @Override
  public BigDecimal abs() {
    return x.abs();
  }

  @Override
  public BigDecimal negate() {
    return x.negate();
  }

  @Override
  public BigDecimal reciprocal() {
    return BigDecimal.ONE.divide(x, mc);
  }

  @Override
  public BigDecimal plus(double value) {
    return x.add(BigDecimal.valueOf(value));
  }

  @Override
  public BigDecimal plus(long value) {
    return x.add(BigDecimal.valueOf(value));
  }

  @Override
  public BigDecimal plus(Number value) {
    if (value instanceof BigDecimal) {
      return x.add((BigDecimal) value);
    }
    return plus(value.doubleValue());
  }

  @Override
  public BigDecimal minus(double value) {
    return x.subtract(BigDecimal.valueOf(value));
  }

  @Override
  public BigDecimal minus(long value) {
    return x.subtract(BigDecimal.valueOf(value));
  }

  @Override
  public BigDecimal minus(Number value) {
    if (value instanceof BigDecimal) {
      return x.subtract((BigDecimal) value);
    }
    return minus(value.doubleValue());
  }

  @Override
  public BigDecimal multiply(double value) {
    return x.multiply(BigDecimal.valueOf(value));
  }

  @Override
  public BigDecimal multiply(long value) {
    return x.multiply(BigDecimal.valueOf(value));
  }

  @Override
  public BigDecimal multiply(Number value) {
    if (value instanceof BigDecimal) {
      return x.multiply((BigDecimal) value);
    }
    return multiply(value.doubleValue());
  }

  @Override
  public BigDecimal div(double value) {
    return x.divide(BigDecimal.valueOf(value), mc);
  }

  @Override
  public BigDecimal div(long value) {
    return x.divide(BigDecimal.valueOf(value), mc);
  }

  @Override
  public BigDecimal div(Number value) {
    if (value instanceof BigDecimal) {
      return x.divide((BigDecimal) value, mc);
    }
    return div(value.doubleValue());
  }

  @Override
  public BigDecimal mod(double value) {
    return x.remainder(BigDecimal.valueOf(value));
  }

  @Override
  public BigDecimal mod(long value) {
    return x.remainder(BigDecimal.valueOf(value));
  }

  @Override
  public BigDecimal mod(Number value) {
    if (value instanceof BigDecimal) {
      return x.remainder((BigDecimal) value, mc);
    }
    return mod(value.doubleValue());
  }

  @Override
  public BigDecimal power(int value) {
    return x.pow(value);
  }

  @Override
  public BigDecimal round() {
    return x.setScale(0, RoundingMode.HALF_UP);
  }

  @Override
  public BigDecimal floor() {
    return x.setScale(0, RoundingMode.DOWN);
  }

  @Override
  public BigDecimal ceil() {
    return x.setScale(0, RoundingMode.UP);
  }

  @Override
  public boolean isIntegral() {
    return x.equals(round());
  }

  @Override
  public int compareTo(BigDecimal o) {
    return x.compareTo(o);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DecimalNumber that = (DecimalNumber) o;
    return x.equals(that.x);
  }

  @Override
  public int hashCode() {
    return x.hashCode();
  }
}
