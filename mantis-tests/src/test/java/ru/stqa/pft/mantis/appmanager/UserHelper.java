package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

/**
 * Created by Вадим on 29.10.2016.
 */
public class UserHelper extends HelperBase {

  public UserHelper(ApplicationManager app) {
    super(app);
  }

  public void resetPassword(UserData user) {
    click(By.linkText("управление"));
    click(By.linkText("Управление пользователями"));
    click(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", user.getId())));
    click(By.linkText("Сбросить пароль"));
  }

}
