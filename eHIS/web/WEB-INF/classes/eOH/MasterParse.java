/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;
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
import java.util.HashMap;
import java.util.ArrayList;



//extends org.xml.sax.HandlerBase
public class MasterParse extends org.xml.sax.HandlerBase
{
	boolean boolCreateMastertable = true;
	boolean boolCreateDetailtable = false;

	public static final int HEADER_DETAIL=1;
	public static final int HEADER_ONLY=2;
	public static final int DETAIL_ONLY=3;



	HashMap resultMasterTable = null;
	HashMap resultDetailTable = null;
	ArrayList ArrayListDetailTable = new ArrayList();
	HashMap resultTable = null;

	String strMasterElement = "";
	String strDetailElement = "";



	public HashMap parseXMLData(InputSource inputXML, String strXMLData,ArrayList elements,int flag) throws Exception {
			//LogFile.log("OTDebugger","ArrayList elements= "+elements,this);
			if( elements!=null && elements.size() > 0 ){
			for (int i=0;i<elements.size();i++ ){
				if (i==0){
					strMasterElement = ""+elements.get(0);
				}else{
					strDetailElement = ""+elements.get(1);
				}
			 }
			}
			
			javax.xml.parsers.SAXParserFactory saxFactory = javax.xml.parsers.SAXParserFactory.newInstance();
			javax.xml.parsers.SAXParser sax = saxFactory.newSAXParser();
			InputSource input = null;
			if (inputXML == null && strXMLData!=null)
			{
				input = new InputSource(new ByteArrayInputStream(strXMLData.getBytes()));
			}
			else
			{
				input = inputXML;
			}
			sax.parse(input,this);
			resultTable = new HashMap();
			strDetailElement="SEARCH";
			strMasterElement="HEADER";
			if(flag==HEADER_DETAIL){
				resultTable.put(strMasterElement,resultMasterTable);
				//System.err.println("resultMasterTable"+resultMasterTable);
				if (ArrayListDetailTable != null){
						//System.err.println("ArrayListDetailTable="+ArrayListDetailTable);
						resultTable.put(strDetailElement,ArrayListDetailTable);				
						//System.err.println("resultTable"+resultTable);
				}
			}else if(flag==HEADER_ONLY)
				resultTable.put(strMasterElement,resultMasterTable);
			else if(flag==DETAIL_ONLY){
				 if(ArrayListDetailTable!= null){
					 ArrayListDetailTable.add(resultMasterTable);
					 resultTable.put(strDetailElement,ArrayListDetailTable);
				 }
		    }
			saxFactory = null;
			sax = null;
			resultMasterTable = null;
			ArrayListDetailTable = null;
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
		//LogFile.log("OTDebugger","Element Name= "+elementName,this);
		if (elementName.equalsIgnoreCase("root"))
		{
			return;
		}
		if (boolCreateDetailtable == true)
		{
			strDetailElement = elementName;  
			resultDetailTable = null;
			resultDetailTable = new HashMap();

			int len=atts.getLength();
			for (int i=0;i<len ;i++ )
			{
				resultDetailTable.put(atts.getName(i),atts.getValue(i));
				
			}
			ArrayListDetailTable.add(resultDetailTable);
		}
		if (boolCreateMastertable ==  true)
		{
			strMasterElement = elementName;  

			boolCreateMastertable = false;
			boolCreateDetailtable = true;
			resultMasterTable = new HashMap();
			int len=atts.getLength();
			for (int i=0;i<len ;i++ )
			{
				resultMasterTable.put(atts.getName(i),atts.getValue(i));
			}
			boolCreateMastertable = false;
		}

	}

}
