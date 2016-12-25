package ru.stqa.pft.rest;

import org.testng.SkipException;

import java.io.IOException;

/**
 * Created by Вадим on 29.10.2016.
 */

public class TestBase {


  boolean isIssueOpen(int issueId) throws IOException {
    if (new RestHelper().getIssueStatus(issueId).equals("Closed")) {
      return false;
    } else {
      return true;
    }
  }


  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}
