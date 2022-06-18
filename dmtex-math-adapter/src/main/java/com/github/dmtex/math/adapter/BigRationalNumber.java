package com.github.dmtex.math.adapter;

import com.github.dmtex.math.rational.BigRational;
import java.util.Objects;

class BigRationalNumber implements ArithmeticAware<BigRational> {

  private final BigRational x;

  BigRationalNumber(BigRational x) {
    this.x = Objects.requireNonNull(x);
  }

  @Override
  public BigRational abs() {
    return x.abs();
  }

  @Override
  public BigRational negate() {
    return x.negate();
  }

  @Override
  public BigRational reciprocal() {
    return x.reciprocal();
  }

  @Override
  public BigRational plus(double value) {
    return x.plus(value);
  }

  @Override
  public BigRational plus(long value) {
    return x.plus(value);
  }

  @Override
  public BigRational minus(double value) {
    return x.minus(value);
  }

  @Override
  public BigRational minus(long value) {
    return x.minus(value);
  }

  @Override
  public BigRational multiply(double value) {
    return x.multiply(value);
  }

  @Override
  public BigRational multiply(long value) {
    return x.multiply(value);
  }

  @Override
  public BigRational div(double value) {
    return x.div(value);
  }

  @Override
  public BigRational div(long value) {
    return x.div(value);
  }

  @Override
  public BigRational mod(double value) {
    return x.mod(value);
  }

  @Override
  public BigRational mod(long value) {
    return x.mod(value);
  }

  @Override
  public BigRational power(int value) {
    return x.power(value);
  }

  @Override
  public BigRational round() {
    return x.round();
  }

  @Override
  public BigRational floor() {
    return x.floor();
  }

  @Override
  public BigRational ceil() {
    return x.ceil();
  }

  @Override
  public boolean isIntegral() {
    return x.isIntegral();
  }

  @Override
  public int compareTo(BigRational o) {
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
    BigRationalNumber that = (BigRationalNumber) o;
    return x.equals(that.x);
  }

  @Override
  public int hashCode() {
    return x.hashCode();
  }
}
