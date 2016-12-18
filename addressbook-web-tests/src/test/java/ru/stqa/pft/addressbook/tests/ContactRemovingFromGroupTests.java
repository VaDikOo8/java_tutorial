package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Вадим on 17.12.2016.
 */
public class ContactRemovingFromGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().
              withName("GroupTest").withHeader("group_header_test").withFooter("group_footer_test"));
    }

    if (app.db().contacts().size() == 0) {
      Groups groups = app.db().groups();
      app.contact().create(new ContactData()
              .withName("Name").withPatronymic("Patronymic").withSurname("Surname").withNickname("nickname1234")
              .withTitle("title1").withCompany("home").withAddress("Moscow, Russia")
              .withCreationFlag(true).inGroup(groups.iterator().next())
              .withHomePnmbr("+7 (495) 123-45-67").withMobilePnmbr("+7 (937) 555-44-11").withWorkPnmbr("+7 (495) 333-33-33")
              .withEmail1("mail1@mail.ru").withEmail2("mail2@rambler.ru").withEmail3("mail3@nxt.ru")
              .withHomepage("http://vk.com/ivanov_ivan")
              .withBday("1").withBmonth("January").withByear("1990")
              .withAday("1").withAmonth("January").withAyear("2010"));
    }

  }

  @Test
  public void testAddContactInGroup() {
    Groups groups = app.db().groups();
    Contacts contacts = app.db().contacts();
    for (GroupData group : groups) {
      for (ContactData contact : contacts) {
        if (group.getContacts().contains(contact)) {
          app.contact().fromGroup(contact, group);
          app.db().group(group);
          assertFalse(group.getContacts().contains(contact));
        } else {
          app.contact().toGroup(contact, group.withId(group.getId()));
          app.db().group(group);
          assertTrue(group.getContacts().contains(contact));

          app.contact().fromGroup(contact, group);
          app.db().group(group);
          assertFalse(group.getContacts().contains(contact));
        }
      }
    }
  }
}

