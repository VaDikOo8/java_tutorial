package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String fname;
  private final String mname;
  private final String lname;
  private final String nickname;
  private final String title;
  private final String company;
  private final String address;
  private final String group;
  public boolean creation;
  private final String home_pnmbr;
  private final String mobile_pnmbr;
  private final String work_pnmbr;
  private final String fax_nmbr;
  private final String email1;
  private final String email2;
  private final String email3;
  private final String homepage;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String aday;
  private final String amonth;
  private final String ayear;

  public ContactData(String fname, String mname, String lname, String nickname,
                     String title, String company, String address, String group, boolean creation,
                     String home_pnmbr, String mobile_pnmbr, String work_pnmbr, String fax_nmbr,
                     String email1, String email2, String email3, String homepage,
                     String bday, String bmonth, String byear,
                     String aday, String amonth, String ayear) {
    this.id = 0;
    this.fname = fname;
    this.mname = mname;
    this.lname = lname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.group = group;
    this.creation = creation;
    this.home_pnmbr = home_pnmbr;
    this.mobile_pnmbr = mobile_pnmbr;
    this.work_pnmbr = work_pnmbr;
    this.fax_nmbr = fax_nmbr;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.aday = aday;
    this.amonth = amonth;
    this.ayear = ayear;
  }

  public ContactData(int id, String fname, String mname, String lname, String nickname,
                     String title, String company, String address, String group, boolean creation,
                     String home_pnmbr, String mobile_pnmbr, String work_pnmbr, String fax_nmbr,
                     String email1, String email2, String email3, String homepage,
                     String bday, String bmonth, String byear,
                     String aday, String amonth, String ayear) {
    this.id = id;
    this.fname = fname;
    this.mname = mname;
    this.lname = lname;
    this.nickname = nickname;
    this.title = title;
    this.company = company;
    this.address = address;
    this.group = group;
    this.creation = creation;
    this.home_pnmbr = home_pnmbr;
    this.mobile_pnmbr = mobile_pnmbr;
    this.work_pnmbr = work_pnmbr;
    this.fax_nmbr = fax_nmbr;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = homepage;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.aday = aday;
    this.amonth = amonth;
    this.ayear = ayear;
  }

  public ContactData(int id, String fname, String lname, String address,
                     String home_pnmbr, String mobile_pnmbr, String work_pnmbr,
                     String email1, String email2, String email3) {
    this.id = id;
    this.fname = fname;
    this.mname = null;
    this.lname = lname;
    this.nickname = null;
    this.title = null;
    this.company = null;
    this.address = address;
    this.group = null;
    this.creation = false;
    this.home_pnmbr = home_pnmbr;
    this.mobile_pnmbr = mobile_pnmbr;
    this.work_pnmbr = work_pnmbr;
    this.fax_nmbr = null;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.homepage = null;
    this.bday = null;
    this.bmonth = null;
    this.byear = null;
    this.aday = null;
    this.amonth = null;
    this.ayear = null;
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
