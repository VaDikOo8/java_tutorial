package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void hello(String sbody) {
    System.out.println("Hello, " + sbody + "!");
  }

  public static double area(double a, double b, double h) {
    return (a + b) * h / 2;
  }

  public static double area(double a, double b) {
    return a * b;
  }

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Vadim");

    double a = 13;
    double b = 4.5;
    double h = 4.5;
    System.out.println("Площадь трапеции с основаниями " + a + " и " + b + " и высотой " + h + " равна " + area(a,b,h));

    double x = 4;
    double y = 5;
    System.out.println("Площадь прямоугольника со сторонами " + x + " и " + y  + " равна " + area(x,y));
  }
}