package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactDataFIO("Iliya", "Petrovich", "Ivanchuk", "ivan4uk89"),
                    new ContactDataCompanyAddrGroup("test1", "HOME", "Penza, Russia", "test1", true),
                    new ContactDataPhoneNumbers("+7 (841) 222-22-22", "+7 (927) 333-22-11", "+7 (841) 111-11-11", "14567"),
                    new ContactDataEmailHomepage("mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/ivanchuk_iliya"),
                    new ContactDataBirthday("19", "May", "1987"),
                    new ContactDataAnniversary("19", "May", "2007"));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnHomePage();
  }
}