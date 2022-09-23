package org.tyss.rmb.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
//updated javaUtility class
public class JavaUtility 

{
	/**
	 * This method is used to generate the random numbers
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit)
	{
		
		return new Random().nextInt(limit);
		

	}

 /**

	 * This method is used to fetch application no and account number from alert pop-up 
	 * @param alertmsg
	 * @return
	 */
	public String FetchNumFromAlert(String alertmsg)
	{
		String number="";
		for(int i=0; i<alertmsg.length();i++)
		{
			if(alertmsg.charAt(i)>='0'&& alertmsg.charAt(i)<='9')
			{
				number=number+alertmsg.charAt(i);

			}

		}
		return number;
	}
	
	public String FetchCustid( String accountno)
	{
		String cust_id="";
        
     
		for(int i=6; i<accountno.length();i++)
		{
			if(i>=6)
			{
				cust_id=cust_id+accountno.charAt(i);
			}
		}
		return cust_id;

	}
	
	/**
	 * This method is used to convert the current date and time into ("dd_MM_yyyy_hh_mm_sss")
	 */
		public String currentTime()
		{
			Date date = new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
			String actualDate = sdf.format(date);
			return actualDate;
		}
	
	
	
}

