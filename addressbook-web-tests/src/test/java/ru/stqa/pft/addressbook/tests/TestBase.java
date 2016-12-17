package ru.stqa.pft.addressbook.tests;

import org.eclipse.jetty.websocket.common.events.AbstractEventDriver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by Вадим on 29.10.2016.
 */
public class TestBase {

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static final ApplicationManager app =
          new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] p){
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  @AfterMethod(alwaysRun = true)
  public void logTestStop(Method m, Object[] p){
    logger.info("Stop test " + m.getName() + " with parameters " + Arrays.asList(p));
  }

  public void verifyGroupListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream()
              .map((g) -> new GroupData().withId(g.getId()).withName(g.getName()))
              .collect(Collectors.toSet())));
    }
  }

  public void verifyContactListInUI() {
    if (Boolean.getBoolean("verifyUI")) {
      Contacts dbContacts = app.db().contacts();
      Contacts uiContacts = app.contact().all();
      assertThat(uiContacts, equalTo(dbContacts.stream()
              .map((g) -> new ContactData().withId(g.getId()).withSurname(g.getLname()).withName(g.getFname())
                      .withAddress(g.getAddress())
                      .withEmail1(g.getEmail1()).withEmail2(g.getEmail2()).withEmail3(g.getEmail3())
                      .withHomePnmbr(g.getHome_pnmbr().replaceAll("\\s", "").replaceAll("[-()]", ""))
                      .withMobilePnmbr(g.getMobile_pnmbr().replaceAll("\\s", "").replaceAll("[-()]", ""))
                      .withWorkPnmbr(g.getWork_pnmbr().replaceAll("\\s", "").replaceAll("[-()]", "")))
              .collect(Collectors.toSet())));
    }
  }

}
