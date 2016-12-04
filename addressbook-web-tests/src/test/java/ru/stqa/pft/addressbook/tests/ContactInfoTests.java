package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Вадим on 04.12.2016.
 */
public class ContactInfoTests extends TestBase {

  @Test
  public void testContactPhones() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactFromDetailsForm = app.contact().infoFromDetailsForm(contact);

    assertThat(contact.getFname(), equalTo(contactFromDetailsForm.getFname()));
    assertThat(contact.getLname(), equalTo(contactFromDetailsForm.getLname()));
    assertThat(contact.getAddress(), equalTo(contactFromDetailsForm.getAddress()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactFromDetailsForm)));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactFromDetailsForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s -> ! s.equals("")))
            .collect(Collectors.joining("\n"));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHome_pnmbr(), contact.getMobile_pnmbr(), contact.getWork_pnmbr())
            .stream().filter((s -> ! s.equals("")))
            .collect(Collectors.joining("\n"));
  }

}
