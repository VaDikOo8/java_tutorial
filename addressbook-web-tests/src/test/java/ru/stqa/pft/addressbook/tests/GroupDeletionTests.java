package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().haveFullGroupList() == false) {
      app.getGroupHelper().createGroup(new GroupData("GroupTest", "group_header_test", "group_footer_test"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().deleteGroup(1);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
