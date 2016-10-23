package ru.stqa.pft.lesson1;

/**
 * Created by Вадим on 23.10.2016.
 */
public class DistancePoint {
  public static void main(String[] args) {

    Point p1 = new Point(6.6, 12.3);
    System.out.println("Точка 1 с координатами (" + p1.x + ";" + p1.y + ")");

    Point p2 = new Point(2.2, 1.1);
    System.out.println("Точка 2 с координатами (" + p2.x + ";" + p2.y + ")");

    System.out.println("Расстояние между двумя точками координат равно " + p1.distance(p1, p2));
  }
}
