package io.murad;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * Hello world!
 */
public class XLSHandler {
    final FileInputStream xlsFile;
    final XSSFWorkbook workbook;
    final XSSFSheet sheet;

    public XLSHandler() throws IOException {
       xlsFile = new FileInputStream(new File("C:\\Training\\Groovy Practice\\problem-solving-training\\Reading_XLS_CSV_using_Maven\\src\\main\\java\\io\\murad\\Data1.xls"));
       workbook = new XSSFWorkbook(xlsFile);
       sheet = workbook.getSheetAt(0);
    }

    public void printRowWise() throws IOException {
        Iterator<Row> rowIterator = sheet.iterator();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                System.out.print(cell.getRichStringCellValue() + " ");
            }
            System.out.println(" ");
        }
//        xlsFile.close();
    }

    public void printColumnWise() throws IOException {
//        Iterator<Row> rowIterator = sheet.iterator();
//        while(rowIterator.hasNext()){
//            Row row = rowIterator.next();
//            Iterator<Cell> cellIterator = row.cellIterator();
//            while(cellIterator.hasNext()){
//                Cell cell = cellIterator.next();
//
//                if(row.getRowNum() > 0){
//                    System.out.print(cell.getStringCellValue());
//                }
//            }
//            System.out.println(" ");
//        }

//        Object[][] arrayExcelData = null;
//        Row row = sheet.getRow(1);
//        int lastRowIndex = sheet.getLastRowNum() + 1;
//        System.out.println("Last row index :" + lastRowIndex);
//        int totalNoOfCols = row.getLastCellNum();
//        System.out.println("Total columns :" + totalNoOfCols);
//        arrayExcelData = new Object[totalNoOfCols][lastRowIndex];
//        DataFormatter df = new DataFormatter();
//        for (int i = 0; i <= totalNoOfCols; i++) {
//            for (int j = 1; j < lastRowIndex; j++) {
//                row = sheet.getRow(j);
//                Cell c = row.getCell(i);
//                String cellData = df.formatCellValue(c);
//                System.out.println(cellData);
//                arrayExcelData[i][j] = cellData;
//            }

        for (int i=0; i< sheet.getLastRowNum() + 1; i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(0);
                System.out.println(cell);
//                cell = row.getCell(1);
//                System.out.println(cell);
                System.out.println("");
                cell = row.getCell(1);
                System.out.println(cell);

            }else{
                System.out.println("Empty");
            }
        }
//            System.out.println("-----------");

//        Iterator<Row> rowIterator = sheet.iterator(); // Traversing over each row of XLSX file
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next(); // For each row, iterate through each columns
//            Iterator<Cell> cellIterator = row.cellIterator();
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                System.out.println(cell.getColumnIndex());
//                for (int i=0; i<cell.getColumnIndex(); i++) {
//                    System.out.println(cell.getStringCellValue());
//                }
//
//            }
//        }
            xlsFile.close();

        }

    public static void main(String[] args) throws IOException {

       XLSHandler xls = new XLSHandler();

       xls.printRowWise();
       xls.printColumnWise();
    }
}
