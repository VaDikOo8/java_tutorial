package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Iliya", "Petrovich", "Ivanchuk", "ivan4uk89",
            "test1", "HOME", "Penza, Russia", "[none]", true,
            "+7 (841) 222-22-22", "+7 (927) 333-22-11", "+7 (841) 111-11-11", "14567",
            "mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/ivanchuk_iliya",
            "19", "May", "1987",
            "19", "May", "2007");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test (enabled = false)
  //а-ля генератор тестовых данных
  public void testContactsCreation() {
    int before = app.getContactHelper().getContactCount();
    int n = before;
    for (int i = 1; i < 10; i++) {
      app.getContactHelper().createContact(new ContactData("Iliya", "Petrovich", "Ivanchuk", "ivan4uk89",
              "test1", "HOME", "Penza, Russia", "[none]", true,
              "+7 (841) 222-22-22", "+7 (927) 333-22-11", "+7 (841) 111-11-11", "14567",
              "mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/ivanchuk_iliya",
              "19", "May", "1987",
              "19", "May", "2007"));
      n = n + 1;
    }
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, n);
  }
}