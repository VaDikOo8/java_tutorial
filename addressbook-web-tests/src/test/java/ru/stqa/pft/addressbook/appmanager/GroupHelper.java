package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Вадим on 29.10.2016.
 */
public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.name("selected[]"));
    }
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public boolean haveFullGroupList() {
    if (isElementPresent(By.className("group"))) {
      return true;
    } else {
      return false;
    }
  }

  public void createGroup() {
    NavigationHelper.gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("TEST_GROUP", "group_header_test", "group_footer_test"));
    submitGroupCreation();
    NavigationHelper.returnToGroupPage();
  }

  public void deleteGroup() {
    selectGroup();
    deleteSelectedGroups();
    NavigationHelper.returnToGroupPage();
  }
}
