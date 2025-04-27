package HL7Engine.Common;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Attribute;
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
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFileName, false), CommonUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "OB_TCPIP_ENC")));
		XMLWriter output = new XMLWriter(writer);
		output.write(xmlDoc);
	//	output.flush();
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
	
	public static Map<String,String> getNodeElementAsMapFromXMLStr(String xmlContent,String element) throws Exception
	{
		return getNodeElementAsMap(new ByteArrayInputStream(xmlContent.getBytes()), element);
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
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFileName, false), CommonUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "OB_TCPIP_ENC")));
		XMLWriter output = new XMLWriter(writer);
		output.write(xmlDoc);
		output.close();
	}
	
	public static Map<String, String> getElementAttributes(String xmlFileName,String element) throws Exception
	{
		return getElementAttributesFromXMLStream(new FileInputStream(xmlFileName), element);
	}
	
	public static Map<String, String> getElementAttributesFromXMLStr(String xmlContent,String element) throws Exception
	{
		return getElementAttributesFromXMLStream(new ByteArrayInputStream(xmlContent.getBytes()), element);
	}

	private static Map<String, String> getElementAttributesFromXMLStream(InputStream xmlInputStream, String element) throws Exception
	{
		Map<String, String> attributes = Collections.emptyMap();
		SAXReader saxReader = new SAXReader();
		Document xmlDoc = saxReader.read(xmlInputStream);
		List nodes = xmlDoc.selectNodes(element);
		List<Attribute> tempAttrbutesList = ((Element) nodes.get(0)).attributes();
		int len = tempAttrbutesList.size();

		if(len > 0) attributes = new HashMap<String, String>();

		for (int i = 0; i < len; i++)
		{
			attributes.put(tempAttrbutesList.get(i).getQualifiedName(), tempAttrbutesList.get(i).getValue());
		}
		
		return attributes;
	}
}
