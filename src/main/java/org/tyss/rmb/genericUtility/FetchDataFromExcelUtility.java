package org.tyss.rmb.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This file consists all the common actions of excel
 * @author Rakshitha
 *
 */

public class FetchDataFromExcelUtility 
{
	private Workbook workbook;



	/**
	 * 
	 * @param excelPath
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public  String getDataFromExcel(String excelPath, String sheetName, int rowNum, int cellNum)
	{
		FileInputStream fis = null;
		try 
		{
			fis = new FileInputStream(excelPath);

		} 
		catch (FileNotFoundException e) 
		{

			e.printStackTrace();
		}
		Workbook workbook = null;
		try 
		{
			workbook = WorkbookFactory.create(fis);
		} 
		catch (EncryptedDocumentException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}

		Sheet sheet = workbook.getSheet(sheetName);
		String data=new DataFormatter().formatCellValue(sheet.getRow(rowNum).getCell(cellNum));


		try {
			workbook.close();
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		return data;
	}
	/** 
	 * This method is used to open the excel
	 * @param excelPath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public void openExcel(String excelPath) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=  new FileInputStream(excelPath);
		workbook = WorkbookFactory.create(fis);

	}
	/**
	 * This method is used to close the excel
	 * @throws IOException
	 */
	public void closeExcel() throws IOException
	{
		workbook.close();
	}

	public void setDataInToExcel(String sheetname, int rowNum, int cellNum, String text)
	{
		Sheet sheet = workbook.getSheet(sheetname);
		sheet.getRow(rowNum).createCell(cellNum).setCellValue(text);

	}




	/**This method is used to fetch the data from excel and store it in the map
	 * 
	 * @param sheetName
	 * @return
	 */

	public Map<String,String> getDataFromExcelInMap(String sheetName)
	{
		Sheet sheet = workbook.getSheet(sheetName);
		//object maps key to value 
		//HashMap class implements the map interface which allows to store key and value pair 
		Map<String, String> map=new HashMap<>();
		DataFormatter df=new DataFormatter();
		for(int i=0;i<=sheet.getLastRowNum();i++)
			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)),
					df.formatCellValue(sheet.getRow(i).getCell(1)));
      return map;
}

	/**
	 * This method is used to fetch the data from excel and store it in the list<map>
	 * @param sheetName
	 * @return
	 */
	public List<Map<String,String>> getDataFromExcelInList(String sheetName)
	{

		Sheet sheet = workbook.getSheet(sheetName);
		List<Map<String,String>> list=new ArrayList<>();
		
		DataFormatter df=new DataFormatter();
		for(int k=1;k<sheet.getRow(0).getLastCellNum();k++)
		{
			Map<String, String> map=new HashMap<>();
			for(int i=0; i<sheet.getLastRowNum();i++)
			{
				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)),
						df.formatCellValue(sheet.getRow(i).getCell(k)));
			}
			list.add(map);
		}
		return list;
	}

/**
 * This method is used to fetch multiple data from excel sheet
 * @return
 */
	public String[][] fetchMultipleDataFromExcelUtility()
	{
		Sheet sheet = workbook.getSheet("CommonData");
        DataFormatter df=new DataFormatter();
		String[][] arr=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i=0;i<=sheet.getLastRowNum();i++)
		{

			for(int j=0; j<sheet.getRow(i).getLastCellNum();j++)
			{
				arr[i-1][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
			}

		}
		return arr;
	}




	//	public List<Map<String,String>> getDataFromExcelInList1(String sheetName)
	//	{
	//
	//		Sheet sheet = workbook.getSheet(sheetName);
	//		List<Map<String,String>> list=new ArrayList<>();
	//		DataFormatter df=new DataFormatter();
	//		for(int i=0; i<sheet.getLastRowNum();i++)
	//		 {
	//			Map<String, String> map=new HashMap<>();
	//			for(int k=1;k<sheet.getRow(0).getLastCellNum();k++)
	//			{
	//				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)),
	//						df.formatCellValue(sheet.getRow(i).getCell(k)));
	//			}
	//			list.add(map);
	//		}
	//		return list;
	//	}
	//	
	//
}
