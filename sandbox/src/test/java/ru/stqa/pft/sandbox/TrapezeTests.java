package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Вадим on 24.10.2016.
 */
public class TrapezeTests {

  @Test
  public void testArea() {
    Trapeze t = new Trapeze(2, 4, 5);
    Assert.assertEquals(t.area(), 15.0);
  }
}
