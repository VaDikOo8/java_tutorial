package ru.stqa.pft.addressbook.model;

public class ContactDataCompanyAddrGroup {
  private final String title;
  private final String company;
  private final String address;
  private final String group;
  public boolean creation;

  public ContactDataCompanyAddrGroup(String title, String company, String address, String group, boolean creation) {
    this.title = title;
    this.company = company;
    this.address = address;
    this.group = group;
    this.creation = creation;
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
