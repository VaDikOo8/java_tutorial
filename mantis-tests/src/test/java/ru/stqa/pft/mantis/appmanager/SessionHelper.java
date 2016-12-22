package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Вадим on 29.10.2016.
 */
public class SessionHelper extends HelperBase {

  protected ApplicationManager app;
  protected WebDriver wd;

  public SessionHelper(ApplicationManager app) {
    super(app);
    this.wd = app.getDriver();
  }

  public void login(String username, String password) {
    type(By.name("username"), username);
    type(By.name("password"), password);
    click(By.cssSelector("input[value='Войти']"));
  }

}
