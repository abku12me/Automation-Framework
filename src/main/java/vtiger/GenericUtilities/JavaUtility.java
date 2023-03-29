package vtiger.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * This class contains generic methods related to java
 * @author mishra
 *
 */
public class JavaUtility {
	/**
	 * This method will return the system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String syst=d.toString();
		return syst;
	}
	
	/**
	 * This method will return date in specific format
	 * @return
	 */
	public String getSystemDateInformat()
	{
		Date d=new Date();
		String dates[]=d.toString().split(" ");//in the form of arrays
	     String month=dates[1];
	     String date=dates[2];
	     String time=dates[3];
	     String year=dates[5];
	     String finalformat=date+" "+month+" "+time+" "+year;
	     return finalformat;
	}
	/**
	 * This method will return the random number
	 * @return
	 */
	public int randomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
	/**
	 * This method will handle calendar as well as future dates
	 * @param dayname
	 * @return
	 */
	
	public String calendarFormatHandle(int date)
	{
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR,date);
		Date currentdate=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/YYYY");
		String modifieddate=sdf.format(currentdate);
		return modifieddate;
	}
	
	
	

}
