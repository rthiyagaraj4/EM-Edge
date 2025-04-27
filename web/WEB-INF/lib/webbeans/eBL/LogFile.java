/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
	package blutil;	
	import java.io.*;
	import java.util.*;

	public class LogFile
	{
		
		public static synchronized void log(String strOutFileName,String strMessage,Object obj)
		{
			GregorianCalendar gregorianCal = new GregorianCalendar();
			FileOutputStream fileOutputStream;
			
			int intDate  = gregorianCal.get(Calendar.DAY_OF_MONTH);
			int intDay	 = gregorianCal.get(Calendar.DAY_OF_WEEK);
			int intMonth = gregorianCal.get(Calendar.MONTH);

			String strClassName = "";
			String strFileName = "";
			String strMonth ="";
			String strDate="";
			String strDay[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
			String strCompleteDate = "";
			boolean boolWriteDate = true;

			try
			{
					if (obj != null)
					{
						strClassName = obj.getClass().getName();
					}
			}
			catch(Exception ex)
			{
			}



			intMonth += 1;
			if (intMonth>9)
			{
				strMonth = intMonth+"";
			}
			else
			{
				strMonth = "0"+intMonth;
			}

			if (intDate>9)
			{
				strDate = intDate+"";
			}
			else
			{
				strDate = "0"+intDate;
			}

			
			strCompleteDate = strDate+","+strMonth+" "+strDay[intDay-1];

			strFileName = strOutFileName+strDate+".dbg";

			try
			{
				File f = new File(strFileName);
				if (f.exists())
				{
					boolWriteDate = false;
				}
				else
				{
					boolWriteDate = true;
				}
			}
			catch(Exception ex)
			{
			}

			

			try
			{
				fileOutputStream = new FileOutputStream(strFileName,true);
				if (boolWriteDate)
				{
					fileOutputStream.write((strCompleteDate+"\n").getBytes());
					fileOutputStream.write(("----------------------------------------"+"\n").getBytes());
				}
				
				fileOutputStream.write((strClassName+"******"+strMessage+"\n").getBytes());
				fileOutputStream.close();	
			}
			catch(FileNotFoundException exceptionFileNotFound)
			{
				//
			}
			catch(IOException exceptionFile)
			{
				//
			}
			catch(Exception exception)
			{
				//
			}
				
		}
		public static void main(String s[])
		{
			System.out.println ("Program to write Logfile  1. File Name\n2.Message");
			log(s[0],s[1],Runtime.getRuntime());
		}
	}
