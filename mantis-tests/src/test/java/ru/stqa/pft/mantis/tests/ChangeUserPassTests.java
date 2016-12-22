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
    Users users = app.db().users();

    if (users.size() <= 1 && users.iterator().next().getId() != 1) {
      long now = System.currentTimeMillis();
      String user = String.format("user%s", now);
      String password = "password";
      String email = String.format("user%s@localhost.localdomain", now);
      app.registration().start(user, email);
      List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
      String confirmationLink = app.mail().findConfirmationLink(mailMessages, email);
      app.registration().finish(confirmationLink, password);
      assertTrue(app.newSession().login(user, password));
    }
  }

  @Test
  public void testChangeUserPass() throws IOException {
    Users users = app.db().users();
    int id = users.iterator().next().getId();
    app.user().resetPassword(new UserData().withId(id));
    String username = new UserData().getUsername();
    String password = "password";
    String email = new UserData().getEmail();
    List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
    String confirmationLink = app.mail().findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(username, password));
    HttpSession session = app.newSession();
    assertTrue(session.login(username, "root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }
}
