package io.murad;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class XLSXHandler {

    final FileInputStream xlsFile;
    final XSSFWorkbook workbook;
    final XSSFSheet sheet;

    public XLSXHandler() throws IOException {
        xlsFile = new FileInputStream(new File("C:\\Training\\Groovy Practice\\problem-solving-training\\Reading_XLS_CSV_using_Maven\\src\\main\\java\\io\\murad\\Data2.xlsx"));
        workbook = new XSSFWorkbook(xlsFile);
        sheet = workbook.getSheetAt(0);
    }


    public void printRowWise() throws IOException {
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.print(cell.getRichStringCellValue() + " ");
            }
            System.out.println(" ");
        }

    }

    public static void main(String[] args) throws IOException {
        XLSXHandler xlsx = new XLSXHandler();
        xlsx.printRowWise();
    }
}
