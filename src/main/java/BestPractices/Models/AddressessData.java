package BestPractices.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddressessData {
    private String company;
    private String address1;
    private String address2;
    private String info;
    private String homePhone;
    private String mobilePhone;
    private String alias;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public int compareTo(AddressessData comparedWith){
        return this.toString().compareTo(comparedWith.toString());
    }

}
