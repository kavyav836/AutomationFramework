package genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat s= new SimpleDateFormat("dd-mm-yyyy_hh_mm_ss");
		String data =s.format(d);
		return data;
		
	}

}
