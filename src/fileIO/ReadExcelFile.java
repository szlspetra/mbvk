package fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	String[][] data = null;

	
	int rowCount = 0;
	int columnCount = 0;
   	
	public String[][] readExcel(String filePath,String fileName,String sheetName) throws IOException{

	    File file =    new File(filePath+"\\"+fileName);
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook wbook = null;
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    CellType stringType = null;
	    String cellType;
	    
	    if(fileExtensionName.equals(".xlsx")){
	    	wbook = new XSSFWorkbook(inputStream);
	    }

	    else if(fileExtensionName.equals(".xls")){
	    	wbook = new HSSFWorkbook(inputStream);
	    }

	    Sheet sheet = wbook.getSheet(sheetName);
	    
	    rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
	    columnCount = sheet.getRow(0).getLastCellNum();
	    
	    data = new String[rowCount][sheet.getRow(0).getPhysicalNumberOfCells()];
	    
	    stringType = sheet.getRow(0).getCell(0).getCellType();

	    for (int i = 0; i < rowCount; i++) {

	        Row row = sheet.getRow(i);
	        
	        for (int j = 0; j < columnCount; j++) {
	        	
	        	if(row.getCell(j) != null) {
	        		cellType = row.getCell(j).getCellType().toString();
		        	
		            if (cellType == "STRING") {
		            	data[i][j] = row.getCell(j).toString();
		            }
		            else if (cellType == "NUMERIC") {
		            	row.getCell(j).setCellType(stringType);
		            	data[i][j] = row.getCell(j).toString();
		            }
		            
		            
	        	}
	        	else {
	        		data[i][j] = "";
	        	}
	        }
	    }
	    return data;

	    }  



	public int columnCount() {
		return columnCount;
	}
	
	public int getRowCount() {
		return rowCount;
	}
	
	

	    
}
