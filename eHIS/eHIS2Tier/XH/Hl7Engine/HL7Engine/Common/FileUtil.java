package HL7Engine.Common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

public class FileUtil
{
	public static void deleteLine(String fileName, String startStr, String endStr) throws Exception
	{
		BufferedReader reader = null;
		PrintWriter writer = null;

		File file = new File(fileName);
		File tempFile = File.createTempFile("temp", ".txt", file.getParentFile());
		try
		{
			String encodingType = "UTF8";

			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encodingType));
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), encodingType)));

			for(String line; ((line = reader.readLine()) != null);)
			{
				if(!line.startsWith(startStr) && !line.endsWith(endStr))
				{
					writer.println(line);
				}
			}
		}
		catch (Exception exp)
		{
			throw exp;
		}
		finally
		{
			reader.close();
			writer.close();
			file.delete();
			tempFile.renameTo(file);
		}
	}
	
	public static void appendToFile(String fileName, String content, String encodingType) throws Exception
	{
		Writer writer = null;
		try
		{
			encodingType = CommonUtil.checkNullReplace(encodingType, "UTF8");
			System.out.println("encodingType "+encodingType);
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), encodingType));
			writer.append(content);
			writer.flush();
		}
		catch(Exception exp) {
			throw exp;
		}
		finally {
			if(writer != null) writer.close();
		}
	}
	
	/*
	 * Deletes the folder by deleting all the files present inside the folder
	 * 
	 * @param folder Folder to be deleted
	 * 
	 * @param logFile Name of the log file to which the delete status to be
	 * logged. name should be with absolute path
	 */
	public static boolean deleteFolder(File folder, String logFile) 
	{
		boolean isFolderDeleted = false;

		Common common = Common.getInstance();
		common.writeToFile(logFile, "Purging files in " + folder + " folder \n");

		File[] currentFolderFiles = folder.listFiles();

		for (File currentFile : currentFolderFiles) {
			common.writeToFile(logFile,
					"Deleting file " + currentFile.getName() + " status - "
							+ currentFile.delete() + "\n");
		}

		isFolderDeleted = folder.delete();

		return isFolderDeleted;
	}
	
	public static double calculateFileSizeInMB(String fileName) {
		return calculateFileSizeInMB(new File(fileName));
	}
	
	public static double calculateFileSizeInMB(File file) {
		double lengthInBytes = file.length();
		double lenInMB = lengthInBytes / (1024 * 1024);
		double roundOff = Math.round(lenInMB * 100.0) / 100.0;
		return roundOff;
	}
}