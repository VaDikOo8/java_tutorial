package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 29.10.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData) {
    fillFIO(contactData);
    fillCompanyAddrGroup(contactData, contactData.creation);
    fillPhoneNumbers(contactData);
    fillEmailHomepage(contactData);
    fillBirthday(contactData);
    fillAnniversary(contactData);
  }

  private void fillAnniversary(ContactData contactData) {
    list("aday", contactData.getAday());
    list("amonth", contactData.getAmonth());
    type(By.name("ayear"), contactData.getAyear());
  }

  private void fillBirthday(ContactData contactData) {
    list("bday", contactData.getBday());
    list("bmonth", contactData.getBmonth());
    type(By.name("byear"), contactData.getByear());
  }

  private void fillEmailHomepage(ContactData contactData) {
    type(By.name("email"), contactData.getEmail1());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getHomepage());
  }

  private void fillPhoneNumbers(ContactData contactData) {
    type(By.name("home"), contactData.getHome_pnmbr());
    type(By.name("mobile"), contactData.getMobile_pnmbr());
    type(By.name("work"), contactData.getWork_pnmbr());
    type(By.name("fax"), contactData.getFax_nmbr());
  }

  private void fillCompanyAddrGroup(ContactData contactData, boolean creation) {
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());

    if (creation) {
      list("new_group", contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  private void fillFIO(ContactData contactData) {
    type(By.name("firstname"), contactData.getFname());
    type(By.name("middlename"), contactData.getMname());
    type(By.name("lastname"), contactData.getLname());
    type(By.name("nickname"), contactData.getNickname());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void acceptDeletionContact() {
    WebDriverWait wait = new WebDriverWait(wd, 1);
    wait.until(ExpectedConditions.alertIsPresent());
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void returnHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home page"));
  }

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public boolean haveFullContactList() {
    if (isElementPresent(By.name("entry"))) {
      return true;
    } else {
      return false;
    }
  }

  public void createContact(ContactData contactData) {
    initContactCreation();
    fillContactForm(contactData);
    submitContactCreation();
    returnHomePage();
  }

  public void deleteContact(int index) {
    selectContact(index);
    deleteSelectedContacts();
    acceptDeletionContact();
    gotoHomePage();
  }

  public void editContact(int index, ContactData contactData) {
    selectContact(index);
    initContactModification();
    fillContactForm(contactData);
    submitContactModification();
    returnHomePage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> td = element.findElements(By.tagName("td"));
      String lname = td.get(1).getText();
      String fname = td.get(2).getText();
      String address = td.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, fname, lname, address, null, null, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
