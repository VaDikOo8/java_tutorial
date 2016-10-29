package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.*;

/**
 * Created by Вадим on 29.10.2016.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(ChromeDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactDataFIO contactDataFIO,
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
    list(3, aday);
    list(4, amonth);
    type(By.name("ayear"), ayear);
  }

  private void fillBirthday(String bday, String bmonth, String byear) {
    list(1, bday);
    list(2, bmonth);
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

  private void fillCpmpanyAddr(String title, String company, String address) {
    type(By.name("title"), title);
    type(By.name("company"), company);
    type(By.name("address"), address);
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
}
