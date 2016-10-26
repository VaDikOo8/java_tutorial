package ru.stqa.pft.lesson1;

/**
 * Created by Вадим on 23.10.2016.
 */

public class Point {

  public double x;
  public double y;

  Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p2) {
    return Math.sqrt( (p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y) );
  }
}

