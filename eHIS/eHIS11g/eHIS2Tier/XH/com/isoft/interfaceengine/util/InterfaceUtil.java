package com.isoft.interfaceengine.util;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class InterfaceUtil
{
/*	public static String getOldFileInFolder(String folder, String strExtension) throws Exception
	{		
		File tempFile = null;
		File [] oFileList;
		String fileNamingApi = null;

		String errorMsg = null;

		File fileListDir = new File(folder);

		if(!fileListDir.exists())
		{
			errorMsg = "Folder does not exist...";
		}
		
		oFileList = fileListDir.listFiles();

		if(oFileList.length > 0) 
		{
			tempFile = oFileList[0];
			int totFiles = oFileList.length;

			for (int i = 0; i < totFiles; i++)
			{				
				if (tempFile.isFile()) break;
				else tempFile = oFileList[i];
			}
		
			if(tempFile.isFile())
			{
				for (int i = 0; i < totFiles; i++)
				{				
					if (tempFile != null && ((tempFile.lastModified() - oFileList[i].lastModified()) > 0) && (oFileList[i].isFile()))
					{					
						tempFile = oFileList[i];
					}				
				}
			
				fileNamingApi = folder + "/" + tempFile.getName();
			}
		}
		return fileNamingApi;
	}
*/
	
	public static String getOldFileInFolder(String folder, String strExtension) throws Exception
	{				
		File [] fileList;
		String fileNamingApi = null;

		String errorMsg = null;

		File fileListDir = new File(folder);

		if(!fileListDir.exists())
		{
			errorMsg = "Folder does not exist...";
		}

		fileList = fileListDir.listFiles(new InterfaceFileFilter(strExtension));

		Arrays.sort(fileList, new Comparator<File>() {
			public int compare(File f1, File f2) {
				return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
			} 
		});

		if(fileList.length > 0) fileNamingApi = fileList[0].toString();

		return fileNamingApi;
	}

	public static String getThaiMonthNo(String thaiMonth)
	{
		String monthNo = "00";
		if(ThaiConstants.JANUARY_THAI.equals(thaiMonth)) monthNo = "01";
		else if(ThaiConstants.FEB_THAI.equals(thaiMonth)) monthNo = "02";
		else if(ThaiConstants.MARCH_THAI.equals(thaiMonth)) monthNo = "03";
		else if(ThaiConstants.APRIL_THAI.equals(thaiMonth)) monthNo = "04";		
		else if(ThaiConstants.MAY_THAI.equals(thaiMonth)) monthNo = "05";
		else if(ThaiConstants.JUNE_THAI.equals(thaiMonth)) monthNo = "06";
		else if(ThaiConstants.JULY_THAI.equals(thaiMonth)) monthNo = "07";
		else if(ThaiConstants.AUGUST_THAI.equals(thaiMonth)) monthNo = "08";
		else if(ThaiConstants.SEP_THAI.equals(thaiMonth)) monthNo = "09";
		else if(ThaiConstants.OCT_THAI.equals(thaiMonth)) monthNo = "10";
		else if(ThaiConstants.NOV_THAI.equals(thaiMonth)) monthNo = "11";
		else if(ThaiConstants.DEC_THAI.equals(thaiMonth)) monthNo = "12";

		return monthNo;
	}
}