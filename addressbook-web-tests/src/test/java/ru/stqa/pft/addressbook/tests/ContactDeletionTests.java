package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Вадим on 30.10.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws InterruptedException {
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    Thread.sleep(1000);
    app.getContactHelper().acceptDeletionContact();
  }

}
