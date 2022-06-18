package com.github.dmtex.math.adapter;

import com.github.dmtex.math.rational.Rational;

class RationalNumber implements ArithmeticAware<Rational> {

  private final Rational x;

  RationalNumber(Rational x) {
    this.x = x;
  }

  @Override
  public Rational abs() {
    return x.abs();
  }

  @Override
  public Rational negate() {
    return x.negate();
  }

  @Override
  public Rational reciprocal() {
    return x.reciprocal();
  }

  @Override
  public Rational plus(double value) {
    return x.plus(value);
  }

  @Override
  public Rational plus(long value) {
    return x.plus(value);
  }

  @Override
  public Rational minus(double value) {
    return x.minus(value);
  }

  @Override
  public Rational minus(long value) {
    return x.minus(value);
  }

  @Override
  public Rational multiply(double value) {
    return x.multiply(value);
  }

  @Override
  public Rational multiply(long value) {
    return x.multiply(value);
  }

  @Override
  public Rational div(double value) {
    return x.div(value);
  }

  @Override
  public Rational div(long value) {
    return x.div(value);
  }

  @Override
  public Rational mod(double value) {
    return x.mod(value);
  }

  @Override
  public Rational mod(long value) {
    return x.mod(value);
  }

  @Override
  public Rational power(int value) {
    return x.power(value);
  }

  @Override
  public Rational round() {
    return x.round();
  }

  @Override
  public Rational floor() {
    return x.floor();
  }

  @Override
  public Rational ceil() {
    return x.ceil();
  }

  @Override
  public boolean isIntegral() {
    return x.isIntegral();
  }

  @Override
  public int compareTo(Rational o) {
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
    RationalNumber that = (RationalNumber) o;
    return x.equals(that.x);
  }

  @Override
  public int hashCode() {
    return x.hashCode();
  }
}
