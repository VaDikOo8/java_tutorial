package ru.stqa.pft.rest;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created by Вадим on 24.12.2016.
 */
public class RestTests extends TestBase {

  @BeforeClass
  public void init() {
    RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
  }

  @Test
  public void testCreateIssue() throws IOException {
    skipIfNotFixed(1);
    Set<Issue> oldIssues = new RestHelper().getIssues();
    Issue newIssue = new Issue().withSubject("Test issue").withDescription("New test issue");
    int issueId = new RestHelper().createIssue(newIssue);
    Set<Issue> newIssues = new RestHelper().getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues, oldIssues);
  }

}