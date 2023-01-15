package domaci18;


import com.github.javafaker.Faker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        try {
            reedExcel("ImenaPrezimena.xlsx",0,5);
            writeExcell("ImenaPrezimena.xlsx");
            reedExcel("ImenaPrezimena.xlsx",0,10);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void reedExcel(String path, int a, int b) throws IOException {
        FileInputStream inputStream= new FileInputStream(path);
        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        XSSFSheet sheet= workbook.getSheetAt(0);
        for (int i = a; i <b ; i++) {
            XSSFRow row= sheet.getRow(i);
            System.out.print(i+1+" ");

            for (int j = 0; j < 2; j++) {
                XSSFCell cell= row.getCell(j);
                System.out.print(cell.getStringCellValue()+ " ");

            }
            System.out.println();
        }
        System.out.println();
        inputStream.close();
    }

    public static void writeExcell (String path) throws IOException {
        FileInputStream inputStream=new FileInputStream(path);
        XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
        XSSFSheet sheet=workbook.getSheetAt(0);
        Faker faker=new Faker();
        for (int i = 5; i <10 ; i++) {
            XSSFRow row= sheet.createRow(i);
            XSSFCell cell1=row.createCell(0);
XSSFCell cell2= row.createCell(1);
cell1.setCellValue(faker.name().firstName());
cell2.setCellValue(faker.name().lastName());
        }
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        outputStream.close();
    }
}
