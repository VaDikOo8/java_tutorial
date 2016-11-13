package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Вадим on 29.10.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (app.getGroupHelper().haveFullGroupList() == false) {
      app.getGroupHelper().createGroup();
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Group3", "group_header3", null));
    app.getGroupHelper().submitGroupModification();
    app.getNavigationHelper().returnToGroupPage();
  }
}
