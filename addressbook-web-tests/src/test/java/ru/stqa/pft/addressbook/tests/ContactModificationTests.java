package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

/**
 * Created by Вадим on 30.10.2016.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withName("Name").withPatronymic("Patronymic").withSurname("Surname").withNickname("nickname1234")
              .withTitle("title1").withCompany("home").withAddress("Moscow, Russia").withCreationFlag(true)
              .withGroup("[none]")
              .withHomePnmbr("+7 (495) 123-45-67").withMobilePnmbr("+7 (937) 555-44-11").withWorkPnmbr("+7 (495) 333-33-33")
              .withEmail1("mail1@mail.ru").withEmail2("mail2@rambler.ru").withEmail3("mail3@nxt.ru")
              .withHomepage("http://vk.com/ivanov_ivan")
              .withBday("1").withBmonth("January").withByear("1990")
              .withAday("1").withAmonth("January").withAyear("2010"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId())
            .withName("Petr").withPatronymic("Sergeevich").withSurname("Ivanov").withNickname("ppivanov81")
            .withTitle("title1").withCompany("home").withAddress("Moscow, St. Peterburg").withCreationFlag(false)
            .withHomePnmbr("+7 (495) 333-45-67").withMobilePnmbr("+7 (937) 111-44-11").withWorkPnmbr("+7 (495) 333-22-11")
            .withEmail1("mail1@mail.ru").withEmail2("mail2@rambler.ru").withEmail3("mail3@nxt.ru")
            .withHomepage("http://vk.com/ivanov_petr")
            .withBday("1").withBmonth("January").withByear("1990")
            .withAday("1").withAmonth("January").withAyear("2010");
    app.contact().edit(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.withModified(modifiedContact, contact)));
  }
}
