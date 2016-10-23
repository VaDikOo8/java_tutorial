package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void hello(String sbody) {
    System.out.println("Hello, " + sbody + "!");
  }

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Vadim");

    Trapeze t = new Trapeze(13, 4.5, 4.5);
    System.out.println("Площадь трапеции с основаниями " + t.a + " и " + t.b + " и высотой " + t.h + " равна " + t.area());

    Rectangle r = new Rectangle(4, 5);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b  + " равна " + r.area());
  }
}