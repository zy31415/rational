package io.github.zy31415.rational

class Rational private (val numer: Int, val denom: Int) {

  override def toString: String = "%d/%d".format(numer, denom)

  override def equals(that: scala.Any): Boolean =
    that match {
      case that: Rational => numer == that.numer && denom == that.denom
      case _ => false
    }

  override def hashCode() = (numer.toFloat/denom).hashCode()

  def add(other: Rational): Rational = Rational(numer * other.denom + other.numer * denom, denom * other.denom)
  def + (other: Rational): Rational = add(other)

  def multiply(other: Rational): Rational = Rational(numer * other.numer, denom * other.denom)
  def * (other: Rational): Rational = multiply(other)

  def divide(other: Rational): Rational = Rational(numer * other.denom, denom * other.numer)
  def / (other: Rational): Rational = divide(other)

}

object Rational {

  def apply(n: Int, d: Int): Rational = {
    require(d != 0, "Divider must be non-zero.")
    val g = Rational.gcd(n, d)
    new Rational(n/g, d/g)
  }

  private def gcd (a: Int, b: Int): Int = {
    if (b ==0 ) a else gcd(b, a % b)
  }
}