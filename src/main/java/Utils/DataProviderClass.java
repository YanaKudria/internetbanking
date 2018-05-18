package Utils;


import org.testng.annotations.DataProvider;

import java.util.Iterator;

public class DataProviderClass {

    @DataProvider(name = "getDataFromCSV")
    public static Iterator<Object[]> getDataFromCSV() {
        return CSVDataProvider.getData("Listofmessages.csv");
    }
}