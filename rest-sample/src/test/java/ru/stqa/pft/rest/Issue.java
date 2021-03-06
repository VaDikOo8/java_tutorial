package ru.stqa.pft.rest;

/**
 * Created by Вадим on 24.12.2016.
 */

public class Issue {


  private int id;
  private String subject;
  private String description;
  private int status;


  public int getId() {
    return id;
  }

  public String getSubject() {
    return subject;
  }

  public String getDescription() {
    return description;
  }

  public int getStatus() {
    return status;
  }


  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public Issue withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }


  public Issue withStatus(int status) {
    this.status = status;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Issue issue = (Issue) o;

    if (id != issue.id) return false;
    if (status != issue.status) return false;
    if (subject != null ? !subject.equals(issue.subject) : issue.subject != null) return false;
    return description != null ? description.equals(issue.description) : issue.description == null;
  }


  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (subject != null ? subject.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + status;
    return result;
  }
}
