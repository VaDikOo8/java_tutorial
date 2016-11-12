package ru.stqa.pft.addressbook.model;

public class ContactDataCompanyAddrGroup {
  private final String title;
  private final String company;
  private final String address;
  private final String group;

  public ContactDataCompanyAddrGroup(String title, String company, String address, String group) {
    this.title = title;
    this.company = company;
    this.address = address;
    this.group = group;
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
}
