package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

/**
 * Created by Вадим on 30.10.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactDataFIO("Petr", "Ivanovich", "Ivanov", null),
            new ContactDataCompanyAddrGroup(null, "home", "Moscow, Russia", null, false),
            new ContactDataPhoneNumbers(null, "+7 (937) 555-44-11", "+7 (495) 333-33-33", null),
            new ContactDataEmailHomepage("mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/ivanov_ivan"),
            new ContactDataBirthday("15", "April", "1989"),
            new ContactDataAnniversary("15", "April", "2009"));
    app.getContactHelper().submitContactModification();
  }
}
