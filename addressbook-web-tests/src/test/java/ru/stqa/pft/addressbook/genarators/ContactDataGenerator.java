package ru.stqa.pft.addressbook.genarators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 11.12.2016.
 */
public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")){
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    String xml = xStream.toXML(contacts);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n",
                contact.getFname(), contact.getMname(), contact.getLname(),
                contact.getAddress(), contact.getGroup(), contact.getEmail1(), contact.getEmail2(), contact.getEmail3(),
                contact.getHome_pnmbr(), contact.getMobile_pnmbr(), contact.getWork_pnmbr(),
                contact.getBday(), contact.getBmonth(), contact.getByear(),
                contact.getAday(), contact.getAmonth(), contact.getAyear()));
      }
    }
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withName(String.format("Name%s", i))
              .withPatronymic(String.format("Patronymic%s", i)).withSurname(String.format("Surname%s", i))
              .withAddress(String.format("FullAddress%s", i)).withGroup("[none]")
              .withHomePnmbr("+7 (495) 111-22-33").withMobilePnmbr("+7 (999) 888-99-00").withWorkPnmbr("+7 (495) 333-22-11")
              .withEmail1("email1@mail.ru").withEmail2("email2@mail.ru").withEmail3("email3@mail.ru")
              .withBday("1").withBmonth("January").withByear("1986")
              .withAday("1").withAmonth("January").withAyear("2006"));
    }
    return contacts;
  }
}
