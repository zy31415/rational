package io.github.zy31415.rational

import org.scalatest.FunSuite


class RationalTest extends FunSuite {
  test("Initialization") {
    assertNumberAndDenom(Rational(8, 10), 4, 5)

    assertNumberAndDenom(Rational(12, 10), 6, 5)
  }

  test("Zero divider") {
    assertThrows[IllegalArgumentException](Rational(8, 0))
  }

  test("Add") {
    val r1 = Rational(8, 10)
    val r2 = Rational(9, 12)
    val r3 = Rational(1, 5)

    assertNumberAndDenom(r1 + r2, 31, 20)
    assertNumberAndDenom(r1 + r3, 1, 1)
  }

  test("Equality") {
    assert(Rational(3, 4).equals(Rational(9, 12)))
    assert(Rational(3, 4) == Rational(9, 12))
  }

  test("Multiplication") {
    assertNumberAndDenom(Rational(2, 3) * Rational(10, 20), 1, 3)
  }

  test("Division") {
    assertNumberAndDenom(Rational(2, 3) / Rational(30, 70), 14, 9)
  }

  private def assertNumberAndDenom(r:Rational, n: Int, d: Int) = assert(r.numer == n && r.denom == d)

}
