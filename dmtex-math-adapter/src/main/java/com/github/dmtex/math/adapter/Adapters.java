package com.github.dmtex.math.adapter;

import com.github.dmtex.math.rational.BigRational;
import com.github.dmtex.math.rational.Rational;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.Objects.requireNonNullElse;

/**
 * {@code Adapters} class is responsible for converting various {@link Number} instances to {@link ArithmeticAware}.
 *
 * @author Denis Murashev
 *
 * @since Math Adapter 1.0
 */
public final class Adapters {

  private static final Map<Class<?>, Function<Number, ?>> LOOKUP_TABLE = new HashMap<>();

  private static final Function<Number, ?> DEFAULT_ADAPTER = DefaultNumber::new;

  static {
    register(BigDecimal.class, DecimalNumber::new);
    register(Rational.class, RationalNumber::new);
    register(BigRational.class, BigRationalNumber::new);
  }

  private Adapters() {
  }

  /**
   * Registers adapter for given class.
   *
   * @param type    type
   * @param adapter adapter
   * @param <T> numeric class type
   */
  @SuppressWarnings("unchecked")
  public static <T extends Number> void register(Class<T> type, Function<T, ArithmeticAware<T>> adapter) {
    LOOKUP_TABLE.put(type, (Function<Number, ?>) adapter);
  }

  /**
   * Looks for appropriate adapter.
   *
   * @param value numeric value
   * @param <T> numeric class type
   * @return value supporting arithmetic operations
   */
  @SuppressWarnings("unchecked")
  public static <T extends Number> ArithmeticAware<T> lookup(T value) {
    return (ArithmeticAware<T>) requireNonNullElse(LOOKUP_TABLE.get(value.getClass()), DEFAULT_ADAPTER).apply(value);
  }

  /**
   * Provides appropriate adapter.
   *
   * @param value numeric value
   * @param <T> numeric class type
   * @return arithmetic adapter
   */
  public static <T extends Number> ArithmeticAdapter<T> of(T value) {
    return new ArithmeticAdapter<>(value);
  }
}
