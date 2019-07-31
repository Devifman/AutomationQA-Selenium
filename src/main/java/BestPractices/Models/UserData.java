package BestPractices.Models;

import BestPractices.Pages.MyDataPage;
import lombok.Builder;
import lombok.Data;
import org.apache.log4j.Logger;

@Data

public class UserData implements Comparable<UserData> {
    static final Logger LOGGER = Logger.getLogger(MyDataPage.class);
    private String gender;
    private String firstName;
    private String lastName;
    private String date;
    private String month;
    private String year;


    public UserData(String gender, String firstName, String lastName, String date, String month, String year) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    @Override
    public int compareTo(UserData object){
        int i = gender.compareTo(object.gender);
        if (i != 0) {
            LOGGER.error("We have different genders");
            return i;

        }

        i = firstName.compareTo(object.firstName);
        if (i != 0) {
            LOGGER.error("We have different names");
            return i;

        }

        i = lastName.compareTo(object.lastName);
        if (i != 0) {
            LOGGER.error("We have different last names");
            return i;

        }

        i = date.compareTo(object.date);
        if (i != 0) {
            LOGGER.error("We have different days");
            return i;

        }

        i = month.compareTo(object.month);
        if (i != 0) {
            LOGGER.error("We have different months");
            return i;

        }

        i = year.compareTo(object.year);
        if (i != 0) {
            LOGGER.error("We have different years");
            return i;

        }

        return 0;

    }

}
