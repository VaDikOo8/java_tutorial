package ru.stqa.pft.addressbook;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.*;

public class ContactCreationTests {
  ChromeDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.get("http://localhost/addressbook/");
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactDataFIO("Petr", "Petrovich", "Petrov", "petrov1987"),
                    new ContactDataCompanyAddr("test1", "HOME", "Penza, Russia"),
                    new ContactDataPhoneNumbers("+7 (841) 222-22-22", "+7 (927) 333-22-11", "+7 (841) 111-11-11", "14567"),
                    new ContactDataEmailHomepage("mail1@mail.ru", "mail2@rambler.ru", "mail3@nxt.ru", "http://vk.com/petrov_petr"),
                    new ContactDataBirthday("17", "9", "1987"),
                    new ContactDataAnniversary("17", "9", "2007"));
    submitContactCreation();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactForm(ContactDataFIO contactDataFIO,
                               ContactDataCompanyAddr contactDataCompanyAddr,
                               ContactDataPhoneNumbers contactDataPhoneNumbers,
                               ContactDataEmailHomepage contactDataEmailHomepage,
                               ContactDataBirthday contactDataBirthday,
                               ContactDataAnniversary contactDataAnniversary) {
    fillFIO(contactDataFIO.getFname(), contactDataFIO.getMname(), contactDataFIO.getLname(), contactDataFIO.getNickname());
    fillCpmpanyAddr(contactDataCompanyAddr.getTitle(), contactDataCompanyAddr.getCompany(), contactDataCompanyAddr.getAddress());
    fillPhoneNumbers(contactDataPhoneNumbers.getHome_pnmbr(), contactDataPhoneNumbers.getMobile_pnmbr(), contactDataPhoneNumbers.getWork_pnmbr(), contactDataPhoneNumbers.getFax_nmbr());
    fillEmailHomepage(contactDataEmailHomepage.getEmail1(), contactDataEmailHomepage.getEmail2(), contactDataEmailHomepage.getEmail3(), contactDataEmailHomepage.getHomepage());
    fillBirthday(contactDataBirthday.getBday(), contactDataBirthday.getBmonth(), contactDataBirthday.getByear());
    fillAnniversary(contactDataAnniversary.getAday(), contactDataAnniversary.getAmonth(), contactDataAnniversary.getAyear());
}

  private void fillAnniversary(String aday, String amonth, String ayear) {
    // День годовщины. Значения option[]:
    // 1 - null;
    // 2 - "-";
    // 3 - "1";
    // ...
    // 33 - "31"
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[" + aday + "]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[" + aday + "]")).click();
    }
    // Месяц годовщины. Значения option[]:
    // 1 - "-";
    // 2 - "January";
    // ...
    // 13 - "December"
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[" + amonth + "]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[" + amonth + "]")).click();
    }
    wd.findElement(By.name("ayear")).click();
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys(ayear);
  }

  private void fillBirthday(String bday, String bmonth, String byear) {
    // День рождения. Значения option[]:
    // 1 - null;
    // 2 - "-";
    // 3 - "1";
    // ...
    // 33 - "31"
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + bday + "]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[" + bday + "]")).click();
    }
    // Месяц рождения. Значения option[]:
    // 1 - "-";
    // 2 - "January";
    // ...
    // 13 - "December"
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[" + bmonth + "]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[" + bmonth + "]")).click();
    }
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(byear);
  }

  private void fillEmailHomepage(String email1, String email2, String email3, String homepage) {
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(email1);
    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(email2);
    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(email3);
    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys(homepage);
  }

  private void fillPhoneNumbers(String home_pnmbr, String mobile_pnmbr, String work_pnmbr, String fax_nmbr) {
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(home_pnmbr);
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(mobile_pnmbr);
    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(work_pnmbr);
    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(fax_nmbr);
  }

  private void fillCpmpanyAddr(String title, String company, String address) {
    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(title);
    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(company);
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(address);
  }

  private void fillFIO(String fname, String mname, String lname, String nickname) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(fname);
    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(mname);
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(lname);
    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(nickname);
  }

  private void initContactCreation() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(ChromeDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
