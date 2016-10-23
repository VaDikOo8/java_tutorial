package ru.stqa.pft.sandbox;

/**
 * Created by Вадим on 23.10.2016.
 */
public class Trapeze {
  public double a;
  public double b;
  public double h;

  public Trapeze(double a, double b, double h) {
    this.a = a;
    this.b = b;
    this.h = h;
  }

  public double area() {
    return (this.a + this.b) * this.h / 2;
  }
}
