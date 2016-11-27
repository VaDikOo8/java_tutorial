package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Group4").withHeader("group_header4").withFooter("group_footer4");
    app.group().create(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> (g.getId())).max().getAsInt()))));
  }

  @Test
  public void testBadGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("Group'").withHeader("group_header4").withFooter("group_footer4");
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
    assertThat(after, equalTo(before));
  }

  @Test (enabled = false)
  //а-ля генератор тестовых данных
  public void testGroupsCreation() {
    int before = app.group().count();
    int n = before;
    for (int i = 1; i < 100; i++) {
      app.group().create(new GroupData().
              withName("GroupTest" + i).withHeader("group_header_test").withFooter("group_footer_test"));
      n = n + 1;
    }
    int after = app.contact().getContactCount();
    Assert.assertEquals(after, n);
  }
}
