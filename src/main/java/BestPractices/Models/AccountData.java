package BestPractices.Models;

import org.testng.annotations.DataProvider;

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

    @DataProvider(name = "RegistrationData")
    public Object[][] dataProviderToUser() {
        return new Object[][]{
                {new AccountData()}
        };
    }

    public String getFirstName() {
        return "Vasya";
    }

    public String getLastName() {
        return "Pupkin";
    }

    public String getPassword() {
        return "55555";
    }

    public String getEmail() {
        return "Checker" + randMail + "@lolol.com";
    }


    public String getAddress1() {
        return "55 Avenue";
    }

    public String getAddress2() {
        return "house 5 app 4";
    }

    public String getCity() {
        return "Boston";
    }

    public String getState() {
        return "1";
    }

    public String getZipCode() {
        return "11111";
    }

    public String getCompany() {
        return "Google";
    }

    public String getMobilePhone() {
        return "89012348645";
    }

    public String getHomePhone() {
        return "222444";
    }

    public String getAlias() {
        return "This Is my Address";
    }

    public AccountData() {
        this.firstName = getFirstName();
        this.lastName = getLastName();
        this.password = getPassword();
        this.address1 = getAddress1();
        this.address2 = getAddress2();
        this.city = getCity();
        this.state = getState();
        this.email = getEmail();
    }


}
