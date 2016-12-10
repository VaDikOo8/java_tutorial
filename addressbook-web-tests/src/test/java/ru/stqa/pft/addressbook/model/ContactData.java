package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String fname;
  private String mname;
  private String lname;
  private String nickname;
  private String title;
  private String company;
  private String address;
  private String group;
  public boolean creation;
  private String home_pnmbr;
  private String mobile_pnmbr;
  private String work_pnmbr;
  private String fax_nmbr;
  private String allPhones;
  private String email1;
  private String email2;
  private String email3;
  private String allEmails;
  private String homepage;
  private String bday;
  private String bmonth;
  private String byear;
  private String aday;
  private String amonth;
  private String ayear;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  private File photo;

  public int getId() {
    return id;
  }

  public String getFname() {
    return fname;
  }

  public String getMname() {
    return mname;
  }

  public String getLname() {
    return lname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getGroup() {
    return group;
  }

  public String getHome_pnmbr() {
    return home_pnmbr;
  }

  public String getMobile_pnmbr() {
    return mobile_pnmbr;
  }

  public String getWork_pnmbr() {
    return work_pnmbr;
  }

  public String getFax_nmbr() {
    return fax_nmbr;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomepage() {
    return homepage;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getAday() {
    return aday;
  }

  public String getAmonth() {
    return amonth;
  }

  public String getAyear() {
    return ayear;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String fname) {
    this.fname = fname;
    return this;
  }

  public ContactData withPatronymic(String mname) {
    this.mname = mname;
    return this;
  }

  public ContactData withSurname(String lname) {
    this.lname = lname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withCreationFlag(boolean creation) {
    this.creation = creation;
    return this;
  }

  public ContactData withHomePnmbr(String home_pnmbr) {
    this.home_pnmbr = home_pnmbr;
    return this;
  }

  public ContactData withMobilePnmbr(String mobile_pnmbr) {
    this.mobile_pnmbr = mobile_pnmbr;
    return this;
  }

  public ContactData withWorkPnmbr(String work_pnmbr) {
    this.work_pnmbr = work_pnmbr;
    return this;
  }

  public ContactData withFaxNmbr(String fax_nmbr) {
    this.fax_nmbr = fax_nmbr;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withBday(String bday) {
    this.bday = bday;
    return this;
  }

  public ContactData withBmonth(String bmonth) {
    this.bmonth = bmonth;
    return this;
  }

  public ContactData withByear(String byear) {
    this.byear = byear;
    return this;
  }

  public ContactData withAday(String aday) {
    this.aday = aday;
    return this;
  }

  public ContactData withAmonth(String amonth) {
    this.amonth = amonth;
    return this;
  }

  public ContactData withAyear(String ayear) {
    this.ayear = ayear;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", fname='" + fname + '\'' +
            ", lname='" + lname + '\'' +
            ", address='" + address + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
    if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
    return address != null ? address.equals(that.address) : that.address == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (fname != null ? fname.hashCode() : 0);
    result = 31 * result + (lname != null ? lname.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    return result;
  }
}
