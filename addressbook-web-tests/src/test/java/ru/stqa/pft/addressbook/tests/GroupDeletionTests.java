package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().haveFullGroupList() == false) {
      app.getGroupHelper().createGroup(new GroupData("GroupTest", "group_header_test", "group_footer_test"));
    }
    app.getGroupHelper().deleteGroup();
  }
}
