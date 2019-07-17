package BestPractices;

import BestPractices.Models.AccountData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataPool {
    Collection<AccountData> accounts;

    public void processDataFile( String filePath ){

        accounts = new ArrayList<AccountData>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            AccountData newAccount = objectMapper.readValue( new File( filePath ), AccountData.class );
            accounts.add( newAccount );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Object[][] getData() {

        Object[][] data = new Object[ accounts.size() ][ 1 ];

        Iterator<AccountData> it = accounts.iterator();

        int i = 0;
        while( it.hasNext() ) {
            data[ i ][ 0 ] = it.next();
            i++;
        }

        return data;
    }
}
