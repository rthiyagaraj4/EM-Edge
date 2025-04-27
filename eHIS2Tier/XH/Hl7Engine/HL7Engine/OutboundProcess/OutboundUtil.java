package HL7Engine.OutboundProcess;

import java.util.GregorianCalendar;

public class OutboundUtil 
{
	public static String trimMilli(int j)
	{
		String retStr = null;

		if(j < 10) retStr = "00" + j;
		else if (j < 100) retStr = "0" + j;
		else retStr = "" + j;

		return retStr;
	}
	
	public static String trim(int j)
	{
		if(j < 10) return("0" + j);
		else return(j + "");
	}

	public static String getTimeStamp()
	{
		GregorianCalendar gc = new GregorianCalendar();
		String str = "";
		try
		{
			str = trim(gc.get(gc.DAY_OF_MONTH)) + "" +
			trim((gc.get(gc.MONTH)+1)) + "" +
			trim(gc.get(gc.YEAR)) + "_" +
			trim(gc.get(gc.HOUR_OF_DAY)) +
			"" +
			trim(gc.get(gc.MINUTE)) + "" +
			trim(gc.get(gc.SECOND)) + "_" +
			trimMilli(gc.get(gc.MILLISECOND));
		}
		catch(Exception exp)
		{
			System.out.println("Exception in OutboundClientApplication:getTimeStamp "+exp);
		}
		return str;
	}
}
