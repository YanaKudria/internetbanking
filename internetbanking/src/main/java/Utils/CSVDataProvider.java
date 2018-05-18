package Utils;

import Pages.HomePage;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVDataProvider {

    private static String csvFilePath;

    public static String getPath(String fileName) {
        try {
            URL CsvFileResoruce = HomePage.class.getResource("/" + fileName);
            csvFilePath = Paths.get(CsvFileResoruce.toURI()).toString();
            System.out.println(csvFilePath);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return csvFilePath;
    }

    public static Iterator<Object[]> getData(String fileName) {
        List<Object[]> list = new ArrayList<Object[]>();
        try {
        String filePath = new File(getPath(fileName)).getAbsolutePath();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line = reader.readLine();
                while (line != null) {
                    String[] params = line.split(",");
                    list.add(new Object[]{params[0]});
                    line = reader.readLine();
                }
            }catch (Exception e){
            e.printStackTrace(System.out);;
        }
        return list.iterator();
    }
}
