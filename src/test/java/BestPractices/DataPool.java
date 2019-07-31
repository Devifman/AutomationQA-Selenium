package BestPractices;

import BestPractices.Models.AccountData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.ITestContext;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class DataPool<T> {

    {
        accountData = new ArrayList<>();
    }

    public DataPool(String testParameterName, ITestContext testContext, Class<T> dataClass){
        fillAnotherDataPool(testParameterName, testContext, dataClass);
    }

    public void fillAnotherDataPool(String testParameterName , ITestContext testContext,  Class<T> dataClass){
        HashMap<String,String> parameters = new HashMap<>( testContext.getCurrentXmlTest().getAllParameters());
        this.processDataFile( parameters.get(testParameterName), dataClass );
    }

    Collection<T> accountData;

    public void processDataFile(String filePath, Class<T> classT){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            T data = objectMapper.readValue( new File( filePath ), classT );
            accountData.add( data );
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getData() {

        Object[][] data = new Object[ 1 ][ accountData.size() ];

        Iterator<T> it = accountData.iterator();


        int i = 0;
        while( it.hasNext() ) {
            data[0][ i ] = it.next();
            i++;
        }

        return data;
    }

}
