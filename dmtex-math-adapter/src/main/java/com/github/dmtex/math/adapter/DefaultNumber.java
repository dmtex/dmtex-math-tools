package com.github.dmtex.math.adapter;

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
    x = value.doubleValue();
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
}
