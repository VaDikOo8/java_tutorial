package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Вадим on 24.10.2016.
 */
public class RectangleTests {

  @Test
  public void testArea() {
    Rectangle r = new Rectangle(5, 6);
    Assert.assertEquals(r.area(), 30.0);
  }
}
