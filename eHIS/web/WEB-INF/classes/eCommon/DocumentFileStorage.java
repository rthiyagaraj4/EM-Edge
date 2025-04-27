/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
03/07/2015        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCommon;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.*;
import org.apache.commons.fileupload.*;

import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import eXH.XHUtil;

public class DocumentFileStorage{
	
	private static final long serialVersionUID = 1L;
	boolean isDebugYN =false;

	/*
	 * Returns the file directory path based on the document type. 
	 */	
	public String getFilePath(String docServerPath, String docType) throws Exception {	

		String filePath = "";
		String sYear = "";
		String sModule = "";
		String sFileSeparator = "";
				
		try {

				isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

				sFileSeparator = System.getProperty("file.separator");
				sFileSeparator = sFileSeparator + sFileSeparator;

				sYear = getYear();

				if (docType.equalsIgnoreCase("mp"))
				{
					sModule = "eMP";						
				}
				if (docType.equalsIgnoreCase("ca"))
				{
					sModule = "eCA";						
				}
				
				filePath = docServerPath + sFileSeparator + sModule + sFileSeparator + "Documents" + sFileSeparator +sYear;	
				
				
				if(isDebugYN) System.out.println(" * * * File Path: "+filePath);

			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;				
			} 
		
		
		return filePath;
	}

	/*
	 * Returns the file name based on the document type. 
	 */
	public String getFileName(String patientID, String docType) throws Exception {	

		String fileName = "";
		String sDateTime = "";
		String sModule = "";
				
		try {

				isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

				// Returns the date time as DDMMYYYYHHMMSS format.
				sDateTime = getDateTime();

				if (docType.equalsIgnoreCase("mp") || docType.equalsIgnoreCase("pp"))
				{
					sModule = "MP";						
				}
				if (docType.equalsIgnoreCase("ca"))
				{
					sModule = "CA";						
				}

				fileName = patientID + "_" + sModule + "_" + sDateTime;		
				
				if(isDebugYN) System.out.println(" * * * File Name: "+fileName);

			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;				
			}
		
		return fileName;
	}

	/*
	 * Returns the file name based on the document type. 
	 */
	public boolean saveFileToDir(FileItem fileItem, String fileName, String fileType, String fileDir) throws Exception {	

		File sNewDir = null;
		File fNewFile = null;
		String sNewFile = "";
		File file = null;
		String sFileSeparator = "";
		InputStream fileContent = null;
		
		try {
				isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

				sFileSeparator = System.getProperty("file.separator");
				sFileSeparator = sFileSeparator + sFileSeparator;

				sNewDir = new File(fileDir);	
				
				if (!sNewDir.exists())
				{
					sNewDir.mkdirs();
				}								

				sNewFile = fileName + "." +fileType;
				if(isDebugYN) System.out.println(":::sNewFile:::"+sNewFile);

				file = new File(sNewDir, sNewFile); 
				
				fileContent = fileItem.getInputStream();

				copyInputStreamToFile(fileContent, file);

				fileContent.close();

			} catch ( java.io.FileNotFoundException fe )	{
				fe=new FileNotFoundException("Access denied to store the files in the path   ");
				fe.printStackTrace() ;
				throw fe;				
			}catch ( java.io.IOException ioe )	{
				ioe=new IOException("Access denied to store the files in the path   ");
				ioe.printStackTrace() ;
				throw ioe;				
			} catch ( Exception e )	{
				e=new Exception("Error in File storage!!!!");
				e.printStackTrace() ;
				throw e;				
			} finally{
				if (fileContent != null) {
					try {
						fileContent.close();
					} catch (IOException e) {
						e.printStackTrace();

					}
				}
			}
		return true;
	}

	private void copyInputStreamToFile( InputStream in, File file ) throws Exception{
		OutputStream out = null;

		try {
			out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while((len=in.read(buf))>0){
				out.write(buf,0,len);
			}
			//out.close();
			//in.close();
		} catch ( java.io.FileNotFoundException fe )	{
				fe.printStackTrace() ;
				throw fe;				
			}catch ( java.io.IOException ioe )	{
				ioe.printStackTrace() ;
				throw ioe;				
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e;				
			}
		finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw e ;
				}
			}
		}

	}

	
	/*
	 * Returns the year part. 
	 */
	public String getYear(){
		
		String formattedYear = "";

		Date now = new Date();

		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		
		df.setTimeZone(TimeZone.getDefault());
		
		formattedYear = df.format(new Date());

		return formattedYear;
	}

	
	/*
	 * Returns the date & time with hours minutes and seconds. 
	 */	
	public String getDateTime(){
		
		String fDateTime = "";

		Date now = new Date();

		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyykkmmss");
		
		df.setTimeZone(TimeZone.getDefault());
		
		fDateTime = df.format(new Date());

		return fDateTime;
	}

	/*
	 * Returns the file directory path based on the document type. 
	 */	
	public String getFilePath(String docServerPath, String docType ,String fileCategory) throws Exception {	

		String photoPath = "";
		String sYear = "";
		String sModule = "";
		String sFileSeparator = "";
				
		try {

				isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

				sFileSeparator = System.getProperty("file.separator");
				sFileSeparator = sFileSeparator + sFileSeparator;

				sYear = getYear();
				if(fileCategory.equals("D"))
				{
					if (docType.equalsIgnoreCase("mp") )
					{
						sModule = "eMP";
						
					}
					if (docType.equalsIgnoreCase("ca"))
					{
						sModule = "eCA";						
					}
						
					photoPath = docServerPath + sFileSeparator  + "Documents"  + sFileSeparator +sYear  + sFileSeparator +sModule;	
				}
				else if(fileCategory.equals("P"))
				{
					if (docType.equalsIgnoreCase("BD") )
					{
						sModule = "BD";
						
					}
					if (docType.equalsIgnoreCase("PP"))
					{
						sModule = "PP";						
					}

					photoPath = docServerPath + sFileSeparator  + "Photos" + sFileSeparator + sModule + sFileSeparator + sYear;	

				}
					
				
				
				if(isDebugYN) System.out.println(" * * * photoPath: "+photoPath);

			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;				
			} 
		
		return photoPath;
	}

	
	public String getFileName(String patientID, String docType , String fileCategory) throws Exception {	

		String photoName = "";
		String sDateTime = "";
		String sModule = "";
				
		try {
				isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

				// Returns the date time as DDMMYYYYHHMMSS format.
				sDateTime = getDateTime();

				System.out.println("sDateTime.."+sDateTime);
				
				if(fileCategory.equals("D"))
				{
					
					if (docType.equalsIgnoreCase("mp"))
					{
						sModule = "MP";						
					}
					if (docType.equalsIgnoreCase("ca"))
					{
						sModule = "CA";						
					}
				}
				else if(fileCategory.equals("P"))
				{
					if (docType.equalsIgnoreCase("BD") )
					{
						sModule = "BD";
						
					}
					if (docType.equalsIgnoreCase("PP"))
					{
						sModule = "PP";						
					}

				}


				photoName = patientID + "_" + sModule + "_" + sDateTime;		
				
				if(isDebugYN) System.out.println(" * * * photoName: "+photoName);

			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;				
			}
		
		return photoName;
	}
}
