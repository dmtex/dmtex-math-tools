package com.github.dmtex.math.adapter;

import java.util.Objects;

/**
 * {@code DefaultNumber} class is adaptation of {@link Double} to {@link ArithmeticAware}.
 *
 * @author Denis Murashev
 *
 * @since Math Adapter 1.0
 */
final class DefaultNumber implements ArithmeticAware<Double> {

  private final double x;

  DefaultNumber(Number value) {
    x = Objects.requireNonNull(value).doubleValue();
  }

  @Override
  public Double abs() {
    return Math.abs(x);
  }

  @Override
  public Double negate() {
    return -x;
  }

  @Override
  public Double reciprocal() {
    return 1 / x;
  }

  @Override
  public Double plus(double value) {
    return x + value;
  }

  @Override
  public Double plus(long value) {
    return x + value;
  }

  @Override
  public Double minus(double value) {
    return x - value;
  }

  @Override
  public Double minus(long value) {
    return x - value;
  }

  @Override
  public Double multiply(double value) {
    return x * value;
  }

  @Override
  public Double multiply(long value) {
    return x * value;
  }

  @Override
  public Double div(double value) {
    return x / value;
  }

  @Override
  public Double div(long value) {
    return x / value;
  }

  @Override
  public Double mod(double value) {
    return x % value;
  }

  @Override
  public Double mod(long value) {
    return x % value;
  }

  @Override
  public Double power(int value) {
    return Math.pow(x, value);
  }

  @Override
  public Double round() {
    return Math.rint(x);
  }

  @Override
  public Double floor() {
    return Math.floor(x);
  }

  @Override
  public Double ceil() {
    return Math.ceil(x);
  }

  @Override
  public boolean isIntegral() {
    return x - (long) x == 0;
  }

  @Override
  public int compareTo(Double o) {
    return Double.compare(x, o);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefaultNumber that = (DefaultNumber) o;
    return Double.compare(x, that.x) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(x);
  }
}
