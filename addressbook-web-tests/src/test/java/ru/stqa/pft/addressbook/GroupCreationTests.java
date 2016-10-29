package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Group2", "group_header2", "group_footer2"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
