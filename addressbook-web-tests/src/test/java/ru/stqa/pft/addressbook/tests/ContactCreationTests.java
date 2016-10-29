package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactDataFIO("Petr", "Petrovich", "Petrov", "petrov1987"),
                    new ContactDataCompanyAddr("test1", "HOME", "Penza, Russia"),
                    new ContactDataPhoneNumbers("+7 (841) 222-22-22", "+7 (927) 333-22-11", "+7 (841) 111-11-11", "14567"),
                    new ContactDataEmailHomepage("mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/petrov_petr"),
                    new ContactDataBirthday("17", "9", "1987"),
                    new ContactDataAnniversary("17", "9", "2007"));
    app.getContactHelper().submitContactCreation();
    // Вспомогательные методы ContactDataBirthday и ContactDataAnniversary.
    // 1й атрибут - день. Значения option[]:
    // 1 - null;
    // 2 - "-";
    // 3-33 - "1"-"31".
    // 2й атрибут - месяц. Значения option[]:
    // 1 - "-";
    // 2-13 - "January"-"December".
  }

}