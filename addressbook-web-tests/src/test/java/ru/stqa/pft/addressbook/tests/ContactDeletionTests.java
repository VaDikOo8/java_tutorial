package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

/**
 * Created by Вадим on 30.10.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (app.getContactHelper().haveFullContactList() == false) {
      app.getContactHelper().createContact(new ContactDataFIO("Name", "Patronymic", "Surname", "nickname1234"),
              new ContactDataCompanyAddrGroup("title1", "home", "Moscow, Russia", "[none]", true),
              new ContactDataPhoneNumbers("+7 (495) 123-45-67", "+7 (937) 555-44-11", "+7 (495) 333-33-33", "12345"),
              new ContactDataEmailHomepage("mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/ivanov_ivan"),
              new ContactDataBirthday("1", "January", "1990"),
              new ContactDataAnniversary("1", "January", "2010"));
    }
    app.getContactHelper().deleteContract();
  }
}
