package io.murad;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.charset.Charset;

public class CSVHandler {
    File file = new File("C:\\Training\\Groovy Practice\\problem-solving-training\\Reading_XLS_CSV_using_Maven\\src\\main\\java\\io\\murad\\Data_3.csv");


    public void printRowWise() throws IOException {
//        Reader in = new FileReader(file.getAbsoluteFile());
//        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("Name", "Country").withIgnoreHeaderCase().withTrim().parse(in);
//        for (CSVRecord record : records) {
//            String id = record.get("Name");
//            String customerNo = record.get("Country");
//        }
        BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Name", "Price","F","J","D").withIgnoreHeaderCase().withTrim());
        for(CSVRecord record : csvParser){
            System.out.println(record.getRecordNumber());
            System.out.println(record.get(0));
            System.out.println(record.get(1));
            System.out.println(record.get(4));
        }

//        CSVParser csvParser2 = new CSVParser(reader, CSVFormat.DEFAULT.withHeader("Name", "Country").withIgnoreHeaderCase().withTrim());
//
//        for (CSVRecord record : csvParser2){
//            System.out.println(record.get(1));
//        }
        reader.close();
    }
    public static void main(String[] args) throws IOException {
      CSVHandler csvHandler = new CSVHandler();
      csvHandler.printRowWise();
    }
}
