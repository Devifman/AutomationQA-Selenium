package BestPractices.Models;

import BestPractices.Pages.MyDataPage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.log4j.Logger;

import java.util.ArrayList;
@Builder(builderMethodName = "constructorBuild")
@Data
@AllArgsConstructor
public class AccountData implements Comparable<AccountData> {
    private String password;
    private String email;
static Logger LOGGER = Logger.getLogger(MyDataPage.class);
    private long randMail = System.currentTimeMillis();
//    private String anotherFirstName;
//    private String anotherAddress;
    private UserData userData;
    private ArrayList<AddressessData> addresses = new ArrayList<>();




    public AccountData() {
        this.email = "Checker" + randMail + "@lolol.com";

    }
    public static AccountDataBuilder accountDataBuilder(String email){
        return constructorBuild().email(email);
    }

    @Override
    public int compareTo(AccountData comparedWith){
        int i = this.email.compareTo(comparedWith.email);
        if (i != 0) {
            LOGGER.error("We have different email");
            return i;
        }
        return 0;
    }




}
