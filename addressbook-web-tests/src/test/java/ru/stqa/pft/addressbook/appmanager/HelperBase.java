package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Вадим on 29.10.2016.
 */
public class HelperBase {
  WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    WebElement element = wd.findElement(locator);
    click(locator);
    element.clear();
    element.sendKeys(text);
  }

  protected void list(int select, String option) {
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[" + select + "]//option[" + option + "]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[" + select + "]//option[" + option + "]")).click();
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
