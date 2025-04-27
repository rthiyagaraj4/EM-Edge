/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XMLUtil
{
	public static void addText2Element(String xmlFileName,String element,String text) throws Exception
	{
		SAXReader saxReader = new SAXReader();
		Document xmlDoc = saxReader.read(new File(xmlFileName));
		List nodes = xmlDoc.selectNodes(element);
		Element dispElement = (Element) nodes.get(0);
		dispElement.addText(text);
		XMLWriter output = new XMLWriter(new FileWriter(new File(xmlFileName)));
		output.write(xmlDoc);
		output.close();		
	}
	
	public static String getElementText(String xmlFileName,String element) throws Exception
	{
		SAXReader saxReader = new SAXReader();
		Document xmlDoc = saxReader.read(new File(xmlFileName));
		String elementTxt = getElementTxtFromDoc(xmlDoc,element);
		return elementTxt;		
	}
	
	public static String getElementTextInXML(String xmlContent,String element) throws Exception
	{
		SAXReader saxReader = new SAXReader();
		Document xmlDoc = saxReader.read(new ByteArrayInputStream(xmlContent.getBytes()));
		String elementTxt = getElementTxtFromDoc(xmlDoc,element);
		return elementTxt;	
	}
	
	public static String getElementTxtFromDoc(Document xmlDoc,String element)
	{
		List nodes = xmlDoc.selectNodes(element);
		Element dispElement = (Element) nodes.get(0);
		String elementTxt = dispElement.getTextTrim();
		return elementTxt;
	}
	
	public static Map<String,String> getNodeElementAsMap(InputStream xmlStream,String element) throws Exception
	{
		HashMap<String,String> elementMap = new HashMap<String,String>();
		SAXReader saxReader = new SAXReader();
		Document xmlDoc = saxReader.read(xmlStream);
		List<Element> elements = xmlDoc.selectNodes(element);
		for(Element currentElement: elements)
		{
			elementMap.put(currentElement.getName(),currentElement.getTextTrim());
		}
		
		return elementMap;
	}
	
	public static void replaceElementText(String xmlFileName,String element,String text,String encodingType) throws Exception
	{
		SAXReader saxReader = new SAXReader();
		Document xmlDoc = saxReader.read(new File(xmlFileName));		
		List nodes = xmlDoc.selectNodes(element);
		Node toBeDeleted = (Node) nodes.get(0);
		String replaceEleName = toBeDeleted.getName();
		Element parentNode = toBeDeleted.getParent();
		toBeDeleted.detach();
		parentNode.addElement(replaceEleName).addText(text);
		XMLWriter output = new XMLWriter(new OutputStreamWriter(new FileOutputStream(xmlFileName),encodingType));
		output.write(xmlDoc);
		output.close();
	}
}
