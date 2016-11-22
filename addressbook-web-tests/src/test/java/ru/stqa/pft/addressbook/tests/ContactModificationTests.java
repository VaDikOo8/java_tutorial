package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Вадим on 30.10.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (app.getContactHelper().haveFullContactList() == false) {
      app.getContactHelper().createContact(new ContactData("Name", "Patronymic", "Surname", "nickname1234",
              "title1", "home", "Moscow, Russia", "[none]", true,
              "+7 (495) 123-45-67", "+7 (937) 555-44-11", "+7 (495) 333-33-33", "12345",
              "mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/ivanov_ivan",
              "1", "January", "1990",
              "1", "January", "2010"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Sergey", "Ivanovich", "Ivanov", null,
            null, "home", "Moscow, Russia", null, false,
            null, "+7 (937) 555-44-11", "+7 (495) 333-33-33", null,
            "mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/ivanov_ivan",
            "15", "April", "1989",
            "15", "April", "2009");
    app.getContactHelper().editContact(before.size() - 1, contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
