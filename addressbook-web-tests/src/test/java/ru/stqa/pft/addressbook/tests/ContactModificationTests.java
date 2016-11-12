package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

/**
 * Created by Вадим on 30.10.2016.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    if (app.getContactHelper().haveFullContactList() == false) {
      app.getContactHelper().initContactCreation();
      app.getContactHelper().fillContactForm(new ContactDataFIO("Iliya", "Petrovich", "Ivanchuk", "ivan4uk89"),
              new ContactDataCompanyAddrGroup("test1", "HOME", "Penza, Russia", "[none]", true),
              new ContactDataPhoneNumbers("+7 (841) 222-22-22", "+7 (927) 333-22-11", "+7 (841) 111-11-11", "14567"),
              new ContactDataEmailHomepage("mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/ivanchuk_iliya"),
              new ContactDataBirthday("19", "May", "1987"),
              new ContactDataAnniversary("19", "May", "2007"));
      app.getContactHelper().submitContactCreation();
      app.getNavigationHelper().returnHomePage();
    }
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
