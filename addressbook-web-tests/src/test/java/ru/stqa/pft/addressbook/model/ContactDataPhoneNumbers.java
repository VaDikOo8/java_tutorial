package ru.stqa.pft.addressbook.model;

public class ContactDataPhoneNumbers {
  private final String home_pnmbr;
  private final String mobile_pnmbr;
  private final String work_pnmbr;
  private final String fax_nmbr;

  public ContactDataPhoneNumbers(String home_pnmbr, String mobile_pnmbr, String work_pnmbr, String fax_nmbr) {
    this.home_pnmbr = home_pnmbr;
    this.mobile_pnmbr = mobile_pnmbr;
    this.work_pnmbr = work_pnmbr;
    this.fax_nmbr = fax_nmbr;
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
}
