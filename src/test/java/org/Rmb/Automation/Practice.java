package org.Rmb.Automation;

import org.tyss.rmb.genericUtility.FetchDataFromExcelUtility;
import org.tyss.rmb.genericUtility.IConstExternalPath;

public class Practice 
{
	public static void main(String[] args) 
	{
		FetchDataFromExcelUtility eu = new FetchDataFromExcelUtility();
		String url=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "CommonData", 1, 1);
		System.out.println(url);
		String name=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 0);
		System.out.println(name);
		String mobile=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 1);
		System.out.println(mobile);
		String email=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 2);
		System.out.println(email);
		String landline=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 3);
		System.out.println(landline);
		String pan=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 4);
		System.out.println(pan);
		String citizenship=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 5);
		System.out.println(citizenship);
		String homeadd=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 6);
		System.out.println(homeadd);
		String officeadd=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 7);
		System.out.println(officeadd);
		String pin=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 8);
		System.out.println(pin);
		String area=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 9);
		System.out.println(area);
		String nominee=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 10);
		System.out.println(nominee);
		String nomacc=eu.getDataFromExcel(IConstExternalPath.EXCEL_PATH, "OpenAccount", 1, 11);
		System.out.println(nomacc);

	}
}
