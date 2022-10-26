package io.murad.Java_IO_File_Problems;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdvancedJavaIOFileProblems {

    static void storeDataToFile(){

    }

    static void printDataFromFile(){

    }

    public static void main(String[] args) throws IOException {

        //Create a text file ‘SEBPO.txt’.
        File file = new File("SEBPO.txt");
        if (file.createNewFile()) {
            System.out.println();
        } else {
            System.out.println("File already exists");
        }

        String content = "Matcher Class with related problems";

        String filePath = String.valueOf(file.getAbsoluteFile());

        //Write something in the text file.
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write(content);
        bufferedWriter.close();

        //And read the content of the file.
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        StringBuilder stringBuilder = new StringBuilder();

        String text = bufferedReader.readLine();

        while (text != null) {
            stringBuilder.append(text);
            System.out.println(stringBuilder);
            text = bufferedReader.readLine();
            System.out.println(text);
        }

        bufferedReader.close();

        // Read a CSV file from the desktop.
        Scanner input = new Scanner(new File("C:\\Users\\Md. Murad Hossain\\Desktop\\wholesale-trade-survey-mar-2022-quarter.csv"));
        input.useDelimiter(" | ");

        //Print the content of the CSV files.
        while (input.hasNext()) {
            System.out.print(input.next());
        }
        input.close();

        //Read the content of the 10 text files and print it.
        String desktopPath = "C:\\Users\\Md. Murad Hossain\\Desktop\\";
        String[] fileNames = {"text_file_1", "text_file_2", "text_file_3", "text_file_4", "text_file_5", "text_file_6", "text_file_7", "text_file_8", "text_file_9", "text_file_10"};
        List<File> files = new ArrayList<>();
        for (String fName : fileNames) {
//           List<File> files = List.of(new File(desktopPath + "\\text_file_1.txt"));
            files.add(new File(desktopPath + fName + ".txt"));
        }
        BufferedReader bufferedReadertxt = null;
        for (File textFile : files) {
            if (textFile.isFile()) {
                bufferedReadertxt = new BufferedReader(new FileReader(textFile));
                String outputText;
                while ((outputText = bufferedReadertxt.readLine()) != null) {
                    System.out.println(outputText);
                }

            }
        }

        //Create a text file (.txt) using any of your preferred Java File IO methods on your desktop under the folder named ‘Java File I/O Problems’.
        File theDir = new File(desktopPath + "Java File IO Problems");
        if (!theDir.exists()) {
            theDir.mkdirs();
            System.out.println("Folder created");
        }

        //Make sure you name the file – “ListOfCountries.txt”
        File ListOfCountries = new File(desktopPath + "Java File IO Problems" + "\\ListOfCountries.txt");
//        file.mkdirs();
        if (ListOfCountries.createNewFile()) {
            System.out.println("File created");
        } else {
            System.out.println("Already exists");
        }

        /**
         *
         * Under a method called, “storeDataToFile(…)”. Store the dummy data in a text file (.txt) which you will create – “ListOfCountries.txt”, such that each country occupies each separate line. [Pre-process the data, using your knowledge of String Manipulation where necessary. Furthermore, there are some countries, whose first letter does not start with an Upper-case, fix this issue.]
         * After viewing from the notepad app on the desktop, it will show something like this. View from Notepad app Bangladesh India Bhutan Etc.
         *
         */

        String dummyText = "Bangladesh India Bhutan Russia China Mongolia France Italy Germany hungary Turkey Egypt Mexico Romania ethiopia";

        String[] dummyTextArr = dummyText.split(" ");
        String nameCapitalized = dummyTextArr[9].substring(0,1).toUpperCase() + dummyTextArr[9].substring(1);
        System.out.println(nameCapitalized);
        String dummyTextWithFirstLetterUppercase = null;
//
//        for (String dtext : dummyTextArr) {
////            dummyTextWithFirstLetterUppercase = dummyTextWithFirstLetterUppercase +
//            dtext.substring(0,1).toUpperCase();
//            dummyTextWithFirstLetterUppercase = dummyTextWithFirstLetterUppercase + "\n" + dtext;
////            System.out.println(dtext);
//        }

        for (int i = 0; i < dummyTextArr.length; i++) {
            System.out.println(dummyTextArr[i].substring(0,1).toUpperCase());
            dummyTextArr[i].substring(0,1).toUpperCase();
            System.out.println(dummyTextArr[i]);
            dummyTextWithFirstLetterUppercase = dummyTextWithFirstLetterUppercase + dummyTextArr[i];
        }

        System.out.println(ListOfCountries.getAbsolutePath());
        System.out.println(ListOfCountries.getAbsoluteFile());

        String countryListPath = String.valueOf(ListOfCountries.getAbsoluteFile());

        BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(countryListPath));
        bufferedWriter2.write(dummyTextWithFirstLetterUppercase);
        bufferedWriter2.close();

        BufferedReader bufferedReadertxt2 = new BufferedReader(new FileReader(ListOfCountries));
        String listOfCountries;
        while ((listOfCountries = bufferedReadertxt2.readLine()) != null) {
            System.out.println(listOfCountries);
        }

        bufferedReadertxt2.close();

    }
}
