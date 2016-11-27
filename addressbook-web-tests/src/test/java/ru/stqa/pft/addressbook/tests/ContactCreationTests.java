package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withName("Ivan").withPatronymic("Petrovich").withSurname("Sidorov").withNickname("sidorov81")
            .withTitle("title1").withCompany("home").withAddress("St. Peterburg, Russia").withCreationFlag(true)
            .withGroup("[none]")
            .withHomePnmbr("+7 (495) 333-45-67").withMobilePnmbr("+7 (937) 111-44-11").withWorkPnmbr("+7 (495) 333-22-11")
            .withEmail1("mail1@mail.ru").withEmail2("mail2@rambler.ru").withEmail3("mail3@nxt.ru")
            .withHomepage("http://vk.com/sidorov_ivan")
            .withBday("1").withBmonth("January").withByear("1990")
            .withAday("1").withAmonth("January").withAyear("2010");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before
            .withAdded(contact.withId(after.stream().mapToInt((c) -> (c.getId())).max().getAsInt()))));
  }

  @Test (enabled = false)
  //а-ля генератор тестовых данных
  public void testContactsCreation() {
    int before = app.contact().getContactCount();
    int n = before;
    for (int i = 1; i < 10; i++) {
      app.contact().create(new ContactData()
              .withName("Petr").withPatronymic("Petrovich").withSurname("Ivanov").withNickname("ppivanov81")
              .withTitle("title1").withCompany("home").withAddress("St. Peterburg, Russia").withCreationFlag(false)
              .withHomePnmbr("+7 (495) 333-45-67").withMobilePnmbr("+7 (937) 111-44-11").withWorkPnmbr("+7 (495) 333-22-11")
              .withEmail1("mail1@mail.ru").withEmail2("mail2@rambler.ru").withEmail3("mail3@nxt.ru")
              .withHomepage("http://vk.com/ivanov_petr")
              .withBday("1").withBmonth("January").withByear("1990")
              .withAday("1").withAmonth("January").withAyear("2010"));
      n = n + 1;
    }
    int after = app.contact().getContactCount();
    Assert.assertEquals(after, n);
  }
}