package ru.stqa.pft.addressbook.model;

public class ContactDataFIO {
  private final String fname;
  private final String mname;
  private final String lname;
  private final String nickname;

  public ContactDataFIO(String fname, String mname, String lname, String nickname) {
    this.fname = fname;
    this.mname = mname;
    this.lname = lname;
    this.nickname = nickname;
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
}
