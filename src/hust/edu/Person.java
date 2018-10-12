package hust.edu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person extends HustObject {
    private static final SimpleDateFormat BIRTHDATE_FORMAT = new SimpleDateFormat("dd/mm/yyyy");

    private String name;
    private Date birthDate;

    Person(String id, String name, String dateString) {
        super(id);
        this.setName(name);
        this.setBirthDate(this.parseDate(dateString));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    private Date parseDate(String dateString) {
        try {
            return BIRTHDATE_FORMAT.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

}
