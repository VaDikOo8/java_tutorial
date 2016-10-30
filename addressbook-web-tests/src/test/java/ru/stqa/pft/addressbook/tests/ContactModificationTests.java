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
    app.getContactHelper().fillContactForm(new ContactDataFIO("Ivan", "Ivanovich", "Ivanov", "ivanov1989"),
            new ContactDataCompanyAddr("test5", "home", "Moscow, Russia"),
            new ContactDataPhoneNumbers("+7 (841) 111-11-11", "+7 (937) 555-44-11", "+7 (495) 333-33-33", "41243"),
            new ContactDataEmailHomepage("mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/ivanov_ivan"),
            new ContactDataBirthday("15", "4", "1989"),
            new ContactDataAnniversary("15", "4", "2009"));
    app.getContactHelper().submitContactModification();
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
