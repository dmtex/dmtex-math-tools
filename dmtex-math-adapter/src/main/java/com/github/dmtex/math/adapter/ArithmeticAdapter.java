package com.github.dmtex.math.adapter;

import static com.github.dmtex.math.adapter.Adapters.lookup;

/**
 * {@code ArithmeticAdapter} class helps to provide less code dealing with Math Adapters.
 *
 * @author Denis Murashev
 *
 * @param <T> Number class
 *
 * @since Math Adapter 1.0
 */
public final class ArithmeticAdapter<T extends Number> extends Number implements ArithmeticAware<ArithmeticAdapter<T>> {

  private static final long serialVersionUID = 5688270715280059615L;

  private final T value;

  /**
   * Initializes with given value.
   *
   * @param value value
   */
  public ArithmeticAdapter(T value) {
    this.value = value;
  }

  @Override
  public ArithmeticAdapter<T> abs() {
    return new ArithmeticAdapter<>(adapter().abs());
  }

  @Override
  public ArithmeticAdapter<T> negate() {
    return new ArithmeticAdapter<>(adapter().negate());
  }

  @Override
  public ArithmeticAdapter<T> reciprocal() {
    return new ArithmeticAdapter<>(adapter().reciprocal());
  }

  @Override
  public ArithmeticAdapter<T> plus(double value) {
    return new ArithmeticAdapter<>(adapter().plus(value));
  }

  @Override
  public ArithmeticAdapter<T> plus(long value) {
    return new ArithmeticAdapter<>(adapter().plus(value));
  }

  @Override
  public ArithmeticAdapter<T> minus(double value) {
    return new ArithmeticAdapter<>(adapter().minus(value));
  }

  @Override
  public ArithmeticAdapter<T> minus(long value) {
    return new ArithmeticAdapter<>(adapter().minus(value));
  }

  @Override
  public ArithmeticAdapter<T> multiply(double value) {
    return new ArithmeticAdapter<>(adapter().multiply(value));
  }

  @Override
  public ArithmeticAdapter<T> multiply(long value) {
    return new ArithmeticAdapter<>(adapter().multiply(value));
  }

  @Override
  public ArithmeticAdapter<T> div(double value) {
    return new ArithmeticAdapter<>(adapter().div(value));
  }

  @Override
  public ArithmeticAdapter<T> div(long value) {
    return new ArithmeticAdapter<>(adapter().div(value));
  }

  @Override
  public ArithmeticAdapter<T> mod(double value) {
    return new ArithmeticAdapter<>(adapter().mod(value));
  }

  @Override
  public ArithmeticAdapter<T> mod(long value) {
    return new ArithmeticAdapter<>(adapter().mod(value));
  }

  @Override
  public ArithmeticAdapter<T> power(int value) {
    return new ArithmeticAdapter<>(adapter().power(value));
  }

  @Override
  public ArithmeticAdapter<T> round() {
    return new ArithmeticAdapter<>(adapter().round());
  }

  @Override
  public ArithmeticAdapter<T> floor() {
    return new ArithmeticAdapter<>(adapter().floor());
  }

  @Override
  public ArithmeticAdapter<T> ceil() {
    return new ArithmeticAdapter<>(adapter().ceil());
  }

  @Override
  public boolean isIntegral() {
    return adapter().isIntegral();
  }

  @Override
  public int compareTo(ArithmeticAdapter<T> o) {
    return adapter().compareTo(o.value);
  }

  @Override
  public int intValue() {
    return value.intValue();
  }

  @Override
  public long longValue() {
    return value.longValue();
  }

  @Override
  public float floatValue() {
    return value.floatValue();
  }

  @Override
  public double doubleValue() {
    return value.doubleValue();
  }

  /**
   * Provides base value.
   *
   * @return value
   */
  public T toNumber() {
    return value;
  }

  private ArithmeticAware<T> adapter() {
    return lookup(value);
  }
}
