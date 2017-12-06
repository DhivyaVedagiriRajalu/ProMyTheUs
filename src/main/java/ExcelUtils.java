import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;



    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    public static void setExcelFile(String Path,String SheetName) throws Exception {

        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e){

            throw (e);

        }

    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception{
        String CellData;
        try{
            //System.out.println("getcelldata "+RowNum+"-"+ColNum);
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
           // System.out.println("CellContent "+Cell);
            if((RowNum==5 && ColNum==2) || (RowNum==6 && ColNum==2)) {
                CellData = Double.toString(Cell.getNumericCellValue());
                //System.out.println("CellData "+RowNum+"-"+ColNum+" "+CellData);
            }
            else{
                CellData = Cell.getStringCellValue();
                //System.out.println("CellData "+RowNum+"-"+ColNum+" "+CellData);
            }

            return CellData;

        }catch (Exception e){

            return"";

        }

    }


}