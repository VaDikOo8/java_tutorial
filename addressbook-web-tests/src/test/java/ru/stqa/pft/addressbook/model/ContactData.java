package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String fname;

  @Expose
  @Column(name = "middlename")
  private String mname;

  @Expose
  @Column(name = "lastname")
  private String lname;

  @Expose
  @Column(name = "nickname")
  private String nickname;

  @Expose
  @Column(name = "title")
  private String title;

  @Expose
  @Column(name = "company")
  private String company;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Expose
  @Transient
  private String group;

  @Expose
  @Transient
  public boolean creation = true;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String home_pnmbr;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobile_pnmbr;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String work_pnmbr;

  @Expose
  @Column(name = "fax")
  @Type(type = "text")
  private String fax_nmbr;

  @Transient
  private String allPhones;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String email1;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;

  @Transient
  private String allEmails;

  @Expose
  @Column(name = "homepage")
  @Type(type = "text")
  private String homepage;

  @Expose
  @Column(name = "bday")
  @Type(type = "byte")
  private Byte bday;

  @Expose
  @Column(name = "bmonth")
  private String bmonth;

  @Expose
  @Column(name = "byear")
  private String byear;

  @Expose
  @Column(name = "aday")
  @Type(type = "byte")
  private Byte aday;

  @Expose
  @Column(name = "amonth")
  private String amonth;

  @Expose
  @Column(name = "ayear")
  private String ayear;

  @Transient
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

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

  public Byte getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public Byte getAday() {
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
    this.bday = new Byte(bday);
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
    this.aday = new Byte(aday);
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
            ", mname='" + mname + '\'' +
            ", lname='" + lname + '\'' +
            ", nickname='" + nickname + '\'' +
            ", title='" + title + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", home_pnmbr='" + home_pnmbr + '\'' +
            ", mobile_pnmbr='" + mobile_pnmbr + '\'' +
            ", work_pnmbr='" + work_pnmbr + '\'' +
            ", fax_nmbr='" + fax_nmbr + '\'' +
            ", email1='" + email1 + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            ", homepage='" + homepage + '\'' +
            ", bday=" + bday +
            ", bmonth='" + bmonth + '\'' +
            ", byear='" + byear + '\'' +
            ", aday=" + aday +
            ", amonth='" + amonth + '\'' +
            ", ayear='" + ayear + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
    if (mname != null ? !mname.equals(that.mname) : that.mname != null) return false;
    if (lname != null ? !lname.equals(that.lname) : that.lname != null) return false;
    if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
    if (title != null ? !title.equals(that.title) : that.title != null) return false;
    if (company != null ? !company.equals(that.company) : that.company != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (home_pnmbr != null ? !home_pnmbr.equals(that.home_pnmbr) : that.home_pnmbr != null) return false;
    if (mobile_pnmbr != null ? !mobile_pnmbr.equals(that.mobile_pnmbr) : that.mobile_pnmbr != null) return false;
    if (work_pnmbr != null ? !work_pnmbr.equals(that.work_pnmbr) : that.work_pnmbr != null) return false;
    if (fax_nmbr != null ? !fax_nmbr.equals(that.fax_nmbr) : that.fax_nmbr != null) return false;
    if (email1 != null ? !email1.equals(that.email1) : that.email1 != null) return false;
    if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
    if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
    if (homepage != null ? !homepage.equals(that.homepage) : that.homepage != null) return false;
    if (bday != null ? !bday.equals(that.bday) : that.bday != null) return false;
    if (bmonth != null ? !bmonth.equals(that.bmonth) : that.bmonth != null) return false;
    if (byear != null ? !byear.equals(that.byear) : that.byear != null) return false;
    if (aday != null ? !aday.equals(that.aday) : that.aday != null) return false;
    if (amonth != null ? !amonth.equals(that.amonth) : that.amonth != null) return false;
    return ayear != null ? ayear.equals(that.ayear) : that.ayear == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (fname != null ? fname.hashCode() : 0);
    result = 31 * result + (mname != null ? mname.hashCode() : 0);
    result = 31 * result + (lname != null ? lname.hashCode() : 0);
    result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (company != null ? company.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (home_pnmbr != null ? home_pnmbr.hashCode() : 0);
    result = 31 * result + (mobile_pnmbr != null ? mobile_pnmbr.hashCode() : 0);
    result = 31 * result + (work_pnmbr != null ? work_pnmbr.hashCode() : 0);
    result = 31 * result + (fax_nmbr != null ? fax_nmbr.hashCode() : 0);
    result = 31 * result + (email1 != null ? email1.hashCode() : 0);
    result = 31 * result + (email2 != null ? email2.hashCode() : 0);
    result = 31 * result + (email3 != null ? email3.hashCode() : 0);
    result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
    result = 31 * result + (bday != null ? bday.hashCode() : 0);
    result = 31 * result + (bmonth != null ? bmonth.hashCode() : 0);
    result = 31 * result + (byear != null ? byear.hashCode() : 0);
    result = 31 * result + (aday != null ? aday.hashCode() : 0);
    result = 31 * result + (amonth != null ? amonth.hashCode() : 0);
    result = 31 * result + (ayear != null ? ayear.hashCode() : 0);
    return result;
  }
}
