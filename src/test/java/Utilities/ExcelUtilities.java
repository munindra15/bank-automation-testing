package Utilities;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ExcelUtilities {


    private static FileInputStream fileInput;
    private static FileOutputStream fileOutput;
    private static XSSFWorkbook workBook;
    private static XSSFSheet workSheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static CellStyle style;

    private static Font font;

    private static DataFormatter dataFormatter = new DataFormatter();


    public static FileInputStream getFileInput() {
        return fileInput;
    }

    public static void setFileInput(FileInputStream fileInput) {
        ExcelUtilities.fileInput = fileInput;
    }

    public static FileOutputStream getFileOutput() {
        return fileOutput;
    }

    public static void setFileOutput(FileOutputStream fileOutput) {
        ExcelUtilities.fileOutput = fileOutput;
    }

    public static XSSFWorkbook getWorkBook() {
        return workBook;
    }

    public static void setWorkBook(XSSFWorkbook workBook) {
        ExcelUtilities.workBook = workBook;
    }

    public static XSSFSheet getWorkSheet() {
        return workSheet;
    }

    public static void setWorkSheet(XSSFSheet workSheet) {
        ExcelUtilities.workSheet = workSheet;
    }

    public static DataFormatter getDataFormatter() {
        return dataFormatter;
    }

    public static XSSFRow getRow() {
        return row;
    }

    public static void setRow(XSSFRow row) {
        ExcelUtilities.row = row;
    }

    public static XSSFCell getCell() {
        return cell;
    }

    public static void setCell(XSSFCell cell) {
        ExcelUtilities.cell = cell;
    }

    public static CellStyle getStyle() {
        return style;
    }

    public static void setStyle(CellStyle style) {
        ExcelUtilities.style = style;
    }


    public static Font getFont() {
        return font;
    }

    public static void setFont(Font font) {
        ExcelUtilities.font = font;
    }

    private static int getRowNumber(String filePath, String sheetName) throws IOException {
        try {
            setFileInput(new FileInputStream(filePath));
            setWorkBook(new XSSFWorkbook(getFileInput()));
            setWorkSheet(getWorkBook().getSheet(sheetName));
            String localDate = LocalDate.now().format(DateTimeFormatter.ofPattern("M/d/yy"));

            int rowCount = getWorkSheet().getLastRowNum();

            System.out.println("RowCount: " + rowCount);
            for (int i = 0; i <= rowCount; i++) {
                setRow(getWorkSheet().getRow(i));
                if (getRow() != null) {
                    for (int j = 0; j < getRow().getLastCellNum(); j++) {
                        setCell(getRow().getCell(j));
                        if (getCell() != null && getCell().getCellType() == CellType.NUMERIC) {
                            if (getDataFormatter().formatCellValue(getCell()).equals(localDate)) {
                                return getRow().getRowNum();
                            }
                        }
                    }
                }
            }
            getFileInput().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void setRowsAndColumns(String filePath, String sheetName, String scenarioStatus, String scenarioName) {
        try {
            setFileInput(new FileInputStream(filePath));
            setWorkBook(new XSSFWorkbook(getFileInput()));
            setWorkSheet(getWorkBook().getSheet(sheetName));
            int rowNumber = getRowNumber(filePath, sheetName);

            System.out.println("RowNumber: " + rowNumber);

            setStyle(getWorkBook().createCellStyle());
            setFont(getWorkBook().createFont());
            getFont().setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            getStyle().setFont(getFont());

            int columnNumber = getWorkSheet().getRow(rowNumber).getLastCellNum();

            System.out.println("ColNumber: " + columnNumber);

            if (scenarioStatus.equals("FAILED")) {
                getStyle().setFillForegroundColor(IndexedColors.RED.getIndex());
                getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
                setCell(getWorkSheet().getRow(rowNumber).createCell(columnNumber));
                getCell().setCellValue(scenarioName);
            } else {
                getStyle().setFillForegroundColor(IndexedColors.GREEN.getIndex());
                getStyle().setFillPattern(FillPatternType.SOLID_FOREGROUND);
                setCell(getWorkSheet().getRow(rowNumber).createCell(columnNumber));
                getCell().setCellValue(scenarioName);
            }

            getCell().setCellStyle(getStyle());
            getFileInput().close();

            setFileOutput(new FileOutputStream(filePath));
            getWorkBook().write(getFileOutput());
            getFileOutput().close();
            getWorkBook().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
