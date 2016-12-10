package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

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

    if (text != null) {
      WebElement element = wd.findElement(locator);
      String existingText = element.getAttribute("value");
      if (! text.equals(existingText)) {
        element.clear();
        element.sendKeys(text);
      }
    }

  }

  protected void attach(By locator, File file) {
    if (file != null) {
      wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }

  protected void list(String sel, String option) {
    Select select = new Select(wd.findElement(By.name(sel)));
    select.getOptions();
    select.selectByVisibleText(option);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
