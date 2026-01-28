package com.neotech.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtility {
    public static Object[][] excelIntoArray(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook book = new XSSFWorkbook(fis);
            Sheet sheet = book.getSheet(sheetName);

            Object[][] data = new Object[sheet.getPhysicalNumberOfRows() - 1][sheet.getRow(0).getPhysicalNumberOfCells()];
            int rowNum = sheet.getPhysicalNumberOfRows();
            int cellNum = sheet.getRow(0).getPhysicalNumberOfCells();
            for (int row = 1; row < rowNum; row++) {
                for (int cell = 0; cell < cellNum; cell++)
                    data[row][cell] = sheet.getRow(row).getCell(cell).toString();
            }
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
