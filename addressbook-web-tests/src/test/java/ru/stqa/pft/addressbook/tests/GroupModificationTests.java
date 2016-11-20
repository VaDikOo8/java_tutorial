package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Вадим on 29.10.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().haveFullGroupList() == false) {
      app.getGroupHelper().createGroup(new GroupData("GroupTest", "group_header_test", "group_footer_test"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().editGroup(before.size() - 1, new GroupData("Group3", "group_header3", null));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());
  }
}
