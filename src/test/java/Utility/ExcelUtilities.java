package Utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtilities {

    public static List<List<String>> getData(String path, String sheetName, int istenenSutunSayisi) {
        List<List<String>> tablo = new ArrayList<>();
        Sheet sheet = null;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            List<String> satir = new ArrayList<>();

            for (int j = 0; j < istenenSutunSayisi; j++)
                satir.add(sheet.getRow(i).getCell(j).toString());

            tablo.add(satir);
        }

        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tablo;
    }
    public static void writeToExcel(String path, String senaryoAdi, String testSonuc)
    {
        File dosya=new File(path);

        try {
            if (dosya.exists())
            {
                FileInputStream inputStream = new FileInputStream(path);
                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(0);

                Row yeniSatir = sheet.createRow(sheet.getPhysicalNumberOfRows());
                Cell cell = yeniSatir.createCell(0); cell.setCellValue(senaryoAdi+" "+sheet.getPhysicalNumberOfRows());
                Cell cell2 = yeniSatir.createCell(1);  cell2.setCellValue(testSonuc);

                inputStream.close();


                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

                System.out.println("Var olan Excel e ekleme yapıldı");
            } else
            {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Sayfa1");

                Row yeniSatir = sheet.createRow(0);
                Cell cell = yeniSatir.createCell(0); cell.setCellValue(senaryoAdi);
                Cell cell2 = yeniSatir.createCell(1); cell2.setCellValue(testSonuc);

                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

                System.out.println("Yeni Excel oluşturuldu ve kaydedildi.");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Hata oluştu "+ex.getMessage());
        }
    }
}


