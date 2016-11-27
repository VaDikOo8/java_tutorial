package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Вадим on 27.11.2016.
 */
public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getHome_pnmbr(), equalTo(cleaned(contactInfoFromEditForm.getHome_pnmbr())));
    assertThat(contact.getMobile_pnmbr(), equalTo(cleaned(contactInfoFromEditForm.getMobile_pnmbr())));
    assertThat(contact.getWork_pnmbr(), equalTo(cleaned(contactInfoFromEditForm.getWork_pnmbr())));
  }

  public String cleaned(String phone) {
      return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
