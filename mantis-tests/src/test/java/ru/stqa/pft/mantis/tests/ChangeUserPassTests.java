package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by Вадим on 22.12.2016.
 */
public class ChangeUserPassTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() throws IOException {
    app.mail().start();
  }

  @Test
  public void testChangeUserPass() throws IOException {
    Users users = app.db().users();
    for (UserData user : users) {
      if (user.getUsername().equals("user_test_1")) {
        int id = user.getId();
        String username = user.getUsername();
        String email = user.getEmail();
        app.user().resetPassword(new UserData().withId(id));
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
        String confirmationLink = app.mail().findConfirmationLink(mailMessages, email);
        String password = "pass1";
        app.registration().finish(confirmationLink, password);
        assertTrue(app.newSession().login(username, password));

        HttpSession session = app.newSession();
        assertTrue(session.login(username, password));
        assertTrue(session.isLoggedInAs(username));
      }
    }
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
