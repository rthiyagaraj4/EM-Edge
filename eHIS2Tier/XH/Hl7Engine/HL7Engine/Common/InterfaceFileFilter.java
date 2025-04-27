package HL7Engine.Common;

import java.io.File;
import java.io.FileFilter;

/**
 * Instance of this class can be used to filter the list of files returned by 
 * File.listFiles(FileFilter) method. 
 * Useful in retreiving only the file list with required file extension.
 *
 * @author      Ravindranath
 * @version     1.0, Initial Version
 * @Created     01/04/2010
 */

class InterfaceFileFilter implements FileFilter
{
	String fileExt;

	public InterfaceFileFilter(String fileExt)
	{
		this.fileExt = fileExt.toUpperCase();
	}

	public boolean accept(File file)
	{
		boolean isReqExt = (file.getName().toUpperCase()).endsWith(fileExt);
		return isReqExt;
	}
}