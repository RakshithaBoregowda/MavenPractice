package org.Rmb.Automation;

	import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class AddDataFromExcel 
	{
	public static void main(String[] args) throws Exception 
	{
		//Step:1 convert the physical file into java readable object
	FileInputStream fis =new FileInputStream("./src/test/resources/TestData.xlsx");
	
       //Step2: Open excel workbook
	Workbook wb=WorkbookFactory.create(fis);
	
      //Step3: get the control on sheet
	 Sheet sheet = wb.getSheet("CommonData");
	 
	 //Step4: get the control on existing row
	  //Row row=sheet.getRow(18);
	 
	 //Step4: get the control on row for new row
	 Row row = sheet.createRow(15);
	 
	 
	 //Step5: get the control on cell
	 Cell cell = row.createCell(3);
	 
	 //Step6: fetch the data
	 cell.setCellValue("pass");
	 
	 
	 FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
	 
	//Step7: write the data into excels
	 wb.write(fos);
	 System.out.println("data updated successfully");
	 
	 wb.close();
	 
	 

	}
	}


