package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Вадим on 30.10.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    if (app.getContactHelper().haveFullContactList() == false) {
      app.getContactHelper().createContact();
    }
    app.getContactHelper().deleteContract();
  }
}
