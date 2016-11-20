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
    fillFIO(contactData.getFname(), contactData.getMname(), contactData.getLname(), contactData.getNickname());
    fillCompanyAddrGroup(contactData.getTitle(), contactData.getCompany(), contactData.getAddress(), contactData.getGroup(), contactData.creation);
    fillPhoneNumbers(contactData.getHome_pnmbr(), contactData.getMobile_pnmbr(), contactData.getWork_pnmbr(), contactData.getFax_nmbr());
    fillEmailHomepage(contactData.getEmail1(), contactData.getEmail2(), contactData.getEmail3(), contactData.getHomepage());
    fillBirthday(contactData.getBday(), contactData.getBmonth(), contactData.getByear());
    fillAnniversary(contactData.getAday(), contactData.getAmonth(), contactData.getAyear());
  }

  private void fillAnniversary(String aday, String amonth, String ayear) {
    list("aday", aday);
    list("amonth", amonth);
    type(By.name("ayear"), ayear);
  }

  private void fillBirthday(String bday, String bmonth, String byear) {
    list("bday", bday);
    list("bmonth", bmonth);
    type(By.name("byear"), byear);
  }

  private void fillEmailHomepage(String email1, String email2, String email3, String homepage) {
    type(By.name("email"), email1);
    type(By.name("email2"), email2);
    type(By.name("email3"), email3);
    type(By.name("homepage"), homepage);
  }

  private void fillPhoneNumbers(String home_pnmbr, String mobile_pnmbr, String work_pnmbr, String fax_nmbr) {
    type(By.name("home"), home_pnmbr);
    type(By.name("mobile"), mobile_pnmbr);
    type(By.name("work"), work_pnmbr);
    type(By.name("fax"), fax_nmbr);
  }

  private void fillCompanyAddrGroup(String title, String company, String address, String group, boolean creation) {
    type(By.name("title"), title);
    type(By.name("company"), company);
    type(By.name("address"), address);

    if (creation) {
      list("new_group", group);
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  private void fillFIO(String fname, String mname, String lname, String nickname) {
    type(By.name("firstname"), fname);
    type(By.name("middlename"), mname);
    type(By.name("lastname"), lname);
    type(By.name("nickname"), nickname);
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
