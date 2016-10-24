package ru.stqa.pft.lesson1;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Вадим on 24.10.2016.
 */
public class DistancePointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 7);
    Assert.assertEquals(p1.distance(p1, p2), 7.0);
  }
}
