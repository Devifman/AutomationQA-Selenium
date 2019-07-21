package BestPractices.Models;

import lombok.Data;
import org.testng.annotations.DataProvider;
@Data
public class AccountData {
    private String gender;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String date;
    private String month;
    private String year;
    private String company;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    private String info;
    private String homePhone;
    private String mobilePhone;
    private String alias;
    private long randMail = System.currentTimeMillis();
    private String anotherFirstName;


    public AccountData() {
        this.email = "Checker" + randMail + "@lolol.com";

    }




}
