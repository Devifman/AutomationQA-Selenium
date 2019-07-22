package BestPractices;

import BestPractices.Models.AccountData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataPool<T> {
    Collection<T> accounts;

    public void processDataFile( String filePath,Class<T> tClass ){

        accounts = new ArrayList<T>();

        ObjectMapper om = new ObjectMapper();
        try {
            T newAccount = om.readValue( new File( filePath ),tClass );
            accounts.add( newAccount );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  Object[][] getData() {

        Object[][] data = new Object[ accounts.size() ][ 1 ];

        Iterator<T> iterator = accounts.iterator();

        int i = 0;
        while( iterator.hasNext() ) {
            data[ i ][ 0 ] = iterator.next();
            i++;
        }

        return data;
    }
}
