/**Assignment update cell value from excel file
 * for ex, file has email and password.
 * email is test@test.com and password is test123
 * then update the password with new password with test1234
 * use read and write methods
 * sheet, row, and cell is already created
 * use setCell Value method to update the cell data
 * excel sheet must be close or else it will corrupt
 * 
 */
package com.dkatalis.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {
	
	
	public String path;
	public FileInputStream fis=null;
	public FileOutputStream fileOutput=null;
	
	private Workbook workbook=null;
	private Sheet sheet=null;
	private Row row=null;
	private Cell cell=null;
	
	
	{
		
		try {
			 fis = new java.io.FileInputStream("dataFiles/readExcel.xlsx");			
			
			workbook = new XSSFWorkbook(fis);
			sheet=workbook.getSheet("Sheet1");
			int rowCount=sheet.getPhysicalNumberOfRows();
			
			for(int i=2;i<rowCount;i++)
			{
				row=sheet.getRow(i);
				int cellCount=row.getPhysicalNumberOfCells();
				
				for(int j=2;j<cellCount;j++)
				{
					
					cell=row.getCell(j);
					
					System.out.println("Old Contact Number is " +row.getCell(j));
					
					
					// to update the new password into the excel file
					cell.setCellValue("8899332200");
					fileOutput=new FileOutputStream("dataFiles/readExcel.xlsx");
					
					
					String data=cell.toString();
					
					// to write the new password into file
					workbook.write(fileOutput);
					
					System.out.println("New Contact Number is " +data);	
					//System.exit(j);
				}
					
			}
			workbook.close();
			
			fileOutput.close();
			
			fis.close();
		} catch (IOException e) {
			
			System.out.println("File Not Found on specified Location, Please check the file and the records in the file");
		} 
	
	}


}