package ru.stqa.pft.addressbook.tests;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromCsv() throws IOException {
    List<Object[]> list = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")))) {
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        list.add(new Object[]{new ContactData().withName(split[0]).withPatronymic(split[1]).withSurname(split[2])
                .withAddress(split[3]).withGroup(split[4]).withEmail1(split[5]).withEmail2(split[6]).withEmail3(split[7])
                .withHomePnmbr(split[8]).withMobilePnmbr(split[9]).withWorkPnmbr(split[10])
                .withBday(split[11]).withBmonth(split[12]).withByear(split[13])
                .withAday(split[14]).withAmonth(split[15]).withAyear(split[16])});
        line = reader.readLine();
      }
      return list.iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType()); // List<GroupData>.class
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testContactsCreationFromFile(ContactData contact) {
    Contacts before = app.contact().all();
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before
            .withAdded(contact.withId(after.stream().mapToInt((c) -> (c.getId())).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testContactCreation() {
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/avatar1.png");
    ContactData contact = new ContactData()
            .withName("Ivan").withPatronymic("Petrovich").withSurname("Sidorov").withNickname("sidorov81")
            .withTitle("title1").withCompany("home").withAddress("St. Peterburg, Russia").withCreationFlag(true)
            .withPhoto(photo).withGroup("[none]")
            .withHomePnmbr("+7 (495) 333-45-67").withMobilePnmbr("+7 (937) 111-44-11").withWorkPnmbr("+7 (495) 333-22-11")
            .withEmail1("mail1@mail.ru").withEmail2("mail2@rambler.ru").withEmail3("mail3@nxt.ru")
            .withHomepage("http://vk.com/sidorov_ivan")
            .withBday("1").withBmonth("January").withByear("1990")
            .withAday("1").withAmonth("January").withAyear("2010");
    app.contact().create(contact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before
            .withAdded(contact.withId(after.stream().mapToInt((c) -> (c.getId())).max().getAsInt()))));
  }
}
