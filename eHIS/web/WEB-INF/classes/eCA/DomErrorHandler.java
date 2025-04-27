/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
 * DomErrorHandler.java
 *
 * Created on April 22nd, 2005, 3:22 PM 
 * @author arvindk
 */
package eCA;

import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;
public class DomErrorHandler implements org.xml.sax.ErrorHandler
{
	public void fatalError(SAXParseException exception) throws SAXException
	{
		System.out.println("**Fatal Error : line:" + exception.getLineNumber() + " URI: " + exception.getSystemId());
		System.out.println(exception.getMessage());
	}
	public void error(SAXParseException e) throws SAXException
	{
		throw e;
	}
	public void warning(SAXParseException exception) throws SAXException
	{
		System.out.println("**Warning : line:" + exception.getLineNumber() + " URI: " + exception.getSystemId());
		System.out.println(exception.getMessage());
	}		
}
