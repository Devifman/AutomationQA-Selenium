package BestPractices.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class AccountData {
    private String password;
    private String email;

    private long randMail = System.currentTimeMillis();
//    private String anotherFirstName;
//    private String anotherAddress;
    private ArrayList<AddressessData> adderesses = new ArrayList<>();
    private UserData userData;


    public AccountData() {
        this.email = "Checker" + randMail + "@lolol.com";

    }





}
