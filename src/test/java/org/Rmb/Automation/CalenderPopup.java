package org.Rmb.Automation;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopup 
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String requiredDate="30";//DD
		String requiredMonth="November";//MMMM-->January, MM-->07, MMM--->Jan
		String requiredYear="2000";//YYYY

		int requiredMonthInNum=DateTimeFormatter.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(requiredMonth)
				.get(ChronoField.MONTH_OF_YEAR);

		int requiredYearInNum=Integer.parseInt(requiredYear);


		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();

		String[] str=actualMonthYear.split(" ");
		String actualMonth=str[0];
		String actualYear=str[1];
		int actualMonthInNum=DateTimeFormatter.ofPattern("MMMM")
				.withLocale(Locale.ENGLISH)
				.parse(requiredMonth)
				.get(ChronoField.MONTH_OF_YEAR);
		int actualYearInNum=Integer.parseInt(actualYear);


		while(requiredMonthInNum>actualMonthInNum ||requiredYearInNum>actualYearInNum){
			driver.findElement(By.xpath("//span[text()='Next']")).click();

			actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
            str=actualMonthYear.split(" ");
			actualMonth=str[0];
			actualYear=str[1];
            actualMonthInNum=DateTimeFormatter.ofPattern("MMMM")
            		.withLocale(Locale.ENGLISH)
            		.parse(requiredMonth)
            		.get(ChronoField.MONTH_OF_YEAR);
			actualYearInNum=Integer.parseInt(actualYear);



		}

		while(requiredMonthInNum<actualMonthInNum ||requiredYearInNum<actualYearInNum)
		{
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();

			str=actualMonthYear.split(" ");
			actualMonth=str[0];
			actualYear=str[1];

			actualMonthInNum=DateTimeFormatter
					.ofPattern("MMMM")
					.withLocale(Locale.ENGLISH)
					.parse(requiredMonth)
					.get(ChronoField.MONTH_OF_YEAR);
			actualYearInNum=Integer.parseInt(actualYear);
		}
		driver.findElement(By.xpath("//a[text()='"+requiredDate+"']")).click(); 
	}
}
