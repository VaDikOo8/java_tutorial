package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Вадим on 30.10.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (app.getContactHelper().haveFullContactList() == false) {
      app.getContactHelper().createContact(new ContactData("Name", "Patronymic", "Surname", "nickname1234",
              "title1", "home", "Moscow, Russia", "[none]", true,
              "+7 (495) 123-45-67", "+7 (937) 555-44-11", "+7 (495) 333-33-33", "12345",
              "mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/ivanov_ivan",
              "1", "January", "1990",
              "1", "January", "2010"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().deleteContact(1);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(1);
    Assert.assertEquals(before, after);
  }
}
