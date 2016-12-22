package ru.stqa.pft.mantis.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class UserData {

  @Id
  @Column(name = "id")
  private int id = 0;

  @Expose
  @Column(name = "username")
  private String username;

  @Expose
  @Column(name = "realname")
  private String realname;

  @Expose
  @Column(name = "email")
  private String email;

  @Expose
  @Column(name = "enabled")
  @Type(type = "byte")
  private byte enabled;

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getRealname() {
    return realname;
  }

  public String getEmail() {
    return email;
  }

  public byte getEnabled() {
    return enabled;
  }

  public UserData withId(int id) {
    this.id = id;
    return this;
  }

  public void withUsername(String username) {
    this.username = username;
  }

  public void withRealname(String realname) {
    this.realname = realname;
  }

  public void withEmail(String email) {
    this.email = email;
  }

  public void withEnabled(byte enabled) {
    this.enabled = enabled;
  }

  @Override
  public String toString() {
    return "UserData{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData that = (UserData) o;

    if (id != that.id) return false;
    return username != null ? username.equals(that.username) : that.username == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    return result;
  }
}
