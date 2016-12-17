package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    fillAttach(contactData);
    fillCompanyAddrGroup(contactData);
    fillPhoneNumbers(contactData);
    fillEmailHomepage(contactData);
    fillBirthday(contactData);
    fillAnniversary(contactData);
  }

  private void fillAttach(ContactData contactData) {
    attach(By.name("photo"), contactData.getPhoto());
  }

  private void fillAnniversary(ContactData contactData) {
    list("aday", String.valueOf(contactData.getAday()));
    list("amonth", contactData.getAmonth());
    type(By.name("ayear"), contactData.getAyear());
  }

  private void fillBirthday(ContactData contactData) {
    list("bday", String.valueOf(contactData.getBday()));
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

  private void fillCompanyAddrGroup(ContactData contactData) {
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());

    if (contactData.creation) {
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

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

  public void initContactModificationById(int id) {
    //click(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id)));
    //click(By.xpath(String.format("//tr[./input[@value='%s']]/td[8]/a", id)));
    click(By.cssSelector(String.format("a[href='edit.php?id=%s']", id)));
  }

  private void initContactDetailsById(int id) {
    click(By.cssSelector(String.format("a[href='view.php?id=%s']", id)));
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

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    acceptDeletionContact();
    gotoHomePage();
  }

  public void edit(ContactData contact) {
    selectContactById(contact.getId());
    initContactModificationById(contact.getId());
    fillContactForm(contact);
    submitContactModification();
    returnHomePage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> td = element.findElements(By.tagName("td"));
      String lname = td.get(1).getText();
      String fname = td.get(2).getText();
      String address = td.get(3).getText();
      String[] allEmails = td.get(4).getText().split("\n");
      String[] allPhones = td.get(5).getText().split("\n");
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withName(fname).withSurname(lname).withAddress(address)
              .withEmail1(allEmails[0]).withEmail2(allEmails[1]).withEmail3(allEmails[2])
              .withHomePnmbr(allPhones[0]).withMobilePnmbr(allPhones[1]).withWorkPnmbr(allPhones[2]));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String fname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String homePnmbr = wd.findElement(By.name("home")).getAttribute("value");
    String mobilePnmbr = wd.findElement(By.name("mobile")).getAttribute("value");
    String workPnmbr = wd.findElement(By.name("work")).getAttribute("value");
    String email1 = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(fname).withSurname(lname)
            .withAddress(address)
            .withEmail1(email1).withEmail2(email2).withEmail3(email3)
            .withHomePnmbr(homePnmbr).withMobilePnmbr(mobilePnmbr).withWorkPnmbr(workPnmbr);
  }

  public ContactData infoFromDetailsForm(ContactData contact) {
    initContactDetailsById(contact.getId());
    String[] fullName = wd.findElement(By.xpath(String.format("//div[@id='content']//b"))).getText().split("[ ]");
    String[] fullInfo = wd.findElement(By.xpath(String.format("//div[@id='content']"))).getText().split("\n");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(fullName[0]).withSurname(fullName[1])
            .withAddress(fullInfo[1])
            .withEmail1(fullInfo[7]).withEmail2(fullInfo[8]).withEmail3(fullInfo[9])
            .withHomePnmbr(fullInfo[3].substring(3))
            .withMobilePnmbr(fullInfo[4].substring(3))
            .withWorkPnmbr(fullInfo[5].substring(3));
  }

}
