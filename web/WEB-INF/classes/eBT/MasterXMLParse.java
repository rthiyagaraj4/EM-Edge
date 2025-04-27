/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBT;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.util.Enumeration;
import java.net.MalformedURLException;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.InputSource;
import java.util.Hashtable;
import java.util.Vector;

import eBT.*;



//extends org.xml.sax.HandlerBase
public class MasterXMLParse extends org.xml.sax.HandlerBase
{
	boolean boolCreateMastertable = true;
	boolean boolCreateDetailtable = false;

	Hashtable resultMasterTable = null;
	Hashtable resultDetailTable = null;
	Vector vectorDetailTable = new Vector();
	Hashtable resultTable = null;

	String strMasterElement = "";
	String strDetailElement = "";



	public Hashtable parseXMLData(InputSource inputXML, String strXMLData,Vector elements)throws Exception
	{
		try
		{
			//eBT.LogFile.log("QADebugger","Vector elements= "+elements,this);

			for (int i=0;i<elements.size();i++ )
			{
				if (i==0)
				{
					strMasterElement = ""+elements.get(0);

				}
				else
				{
					strDetailElement = ""+elements.get(1);
				}
			}

			
			javax.xml.parsers.SAXParserFactory saxFactory = javax.xml.parsers.SAXParserFactory.newInstance();
			javax.xml.parsers.SAXParser sax = saxFactory.newSAXParser();
			InputSource input = null;
			if (inputXML == null)
			{
				input = new InputSource(new ByteArrayInputStream(strXMLData.getBytes()));
			}
			else
			{
				input = inputXML;
			}
			sax.parse(input,this);
			
			resultTable = new Hashtable();
			resultTable.put(strMasterElement,resultMasterTable);
			try
			{
				if (vectorDetailTable != null)
				{
					resultTable.put(strDetailElement,vectorDetailTable);
				}
				
			}
			catch(Exception e)
			{
			}
			saxFactory = null;
			sax = null;
			resultMasterTable = null;
			vectorDetailTable = null;
			

		}
		catch(Exception exp)
		{
			System.out.println("Errrrrrr="+exp);
		}
		return resultTable;
	}

	public void  endDocument()throws SAXException
	{
	}
	private String escapeData (char ch[], int start, int length)
	{
		StringBuffer buf = new StringBuffer();
		for (int i = start; i < start + length; i++) 
		{
			buf.append(ch[i]);		
		}	
		return buf.toString();
	}

	public void startElement(String elementName, org.xml.sax.AttributeList atts)throws SAXException
	{
	//	LogFile.log("QADebugger","Element Name= "+elementName,this);
		if (elementName.equalsIgnoreCase("root"))
		{
			return;
		}
		if (boolCreateDetailtable == true)
		{
			strDetailElement = elementName;  
			resultDetailTable = null;
			resultDetailTable = new Hashtable();

			int len=atts.getLength();
			for (int i=0;i<len ;i++ )
			{
				resultDetailTable.put(atts.getName(i),atts.getValue(i));
				
			}
			vectorDetailTable.add(resultDetailTable);
		}
		if (boolCreateMastertable ==  true)
		{
			strMasterElement = elementName;  

			boolCreateMastertable = false;
			boolCreateDetailtable = true;
			resultMasterTable = new Hashtable();
			int len=atts.getLength();
			for (int i=0;i<len ;i++ )
			{
				resultMasterTable.put(atts.getName(i),atts.getValue(i));
			}
			boolCreateMastertable = false;
		}
	}
}
