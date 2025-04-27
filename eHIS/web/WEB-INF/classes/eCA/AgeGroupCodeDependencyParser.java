/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
// this class is used to remove the component form the final XML template before
// displaying it at the transation time.
package eCA;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;
import java.io.*;

public class AgeGroupCodeDependencyParser extends DefaultHandler implements
		java.io.Serializable {
	private String[] arrCompIdSrlNo;

	private String[] arrResult;

	private StringBuffer displayString = new StringBuffer();

	private String rawNameToRemove = "";

	public StringBuffer removeAgeDependentComponents(StringBuffer contentXML,
			String dependentCompIds, String dependentResults) {
		if (fillArrays(dependentCompIds, dependentResults)) {
			parseXmlForRemovingComponent(contentXML.toString());
			return displayString;
		}
		return contentXML;
	}

	private boolean fillArrays(String dependentCompIds, String dependentResults) {
		try {
			StringTokenizer st1 = new StringTokenizer(dependentCompIds, "|");
			StringTokenizer st2 = new StringTokenizer(dependentResults, "|");
			int count = st1.countTokens();
			if (count > 0) {
				arrCompIdSrlNo = new String[count];
				arrResult = new String[count];
				int i = 0;
				while (st1.hasMoreElements()) {
					arrCompIdSrlNo[i] = "C_" + (String) st1.nextElement();
					arrResult[i] = (String) st2.nextElement();
					i++;
				}
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return false;
	}

	private void parseXmlForRemovingComponent(String contentXML) {
		try {
			//SAXParser parser = new SAXParser();
			javax.xml.parsers.SAXParser parser = (javax.xml.parsers.SAXParserFactory.newInstance()).newSAXParser();
			//parser.setContentHandler(this);
			parser.parse(new InputSource(new ByteArrayInputStream(contentXML.getBytes())), this);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	//callback methods for SAX Parsers
	public void processingInstruction(String target, String data) {
		displayString.append("<?");
		displayString.append(target);
		if (data != null && data.length() > 0) {
			displayString.append(" " + data);
		}
		displayString.append("?>");
	}

	public void startElement(String uri, String localName, String rawName,
			Attributes attributes) {
		
		uri = uri;
		localName = localName;
		boolean flag = true;
		for (int j = 0; j < arrResult.length; j++) {
			
			if (arrResult[j].equals("N")) {
				if (arrCompIdSrlNo[j] != null) {
					if (attributes != null
							&& attributes.getValue("NAME") != null
							&& attributes.getValue("NAME").equals(
									arrCompIdSrlNo[j])
							&& rawNameToRemove.equals("")) {
						flag = false;
						rawNameToRemove = rawName;
					}
				}
			}

		}

		if (flag && rawNameToRemove.equals("")) {
			displayString.append("<");
			displayString.append(rawName);
			if (attributes != null) {
				int numberAttributes = attributes.getLength();
				for (int i = 0; i < numberAttributes; i++) {
					
					displayString.append(" ");
					//displayString.append(attributes.getLocalName(i));
					displayString.append(attributes.getQName(i));
					displayString.append("=\"");
					displayString.append(replaceSpecialChars(attributes
							.getValue(i)));
					displayString.append("\"");
				}
			}
			displayString.append(">");
		
		}
	}

	public void characters(char characters[], int start, int length) {
		if (rawNameToRemove.equals("")) {
			String characterData = new String(characters, start, length);
			characterData = replaceSpecialChars(characterData);
			if (characterData.length() > 0) {
				displayString.append(characterData);
			}
		}
	}

	public void endElement(String uri, String localName, String rawName) {
		uri = uri;
		localName = localName;
		if (rawNameToRemove.equals(rawName)) {
			rawNameToRemove = "";
		} else if (rawNameToRemove.equals("")) {
			displayString.append("</");
			displayString.append(rawName);
			displayString.append(">");
		}

	}

	public void warning(SAXParseException exception) {
		System.err.println("WARNING! " + exception.getMessage());
	}

	public void error(SAXParseException exception) {
		System.err.println("ERROR! " + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) {
		System.err.println("FATAL ERROR! " + exception.getMessage());
	}

	private String replaceSpecialChars(String input) {
		
		if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
		if (input.indexOf("<") != -1) input = input.replaceAll("<","&lt;");
		if (input.indexOf(">") != -1) input = input.replaceAll(">","&gt;");	
		if (input.indexOf("\\n") != -1) input = input.replaceAll("\\n","&lt;br&gt;");	

	/*	StringBuffer temp = null;
		int a = 0, b = 0, c = 0, i = 0;
		while (true) {

			a = input.indexOf('&', i) == -1 ? 999999 : input.indexOf('&', i);
			b = input.indexOf('<', i) == -1 ? 999999 : input.indexOf('<', i);
			c = input.indexOf('>', i) == -1 ? 999999 : input.indexOf('>', i);

			if (a < b && a < c && a != -1) {
				temp = new StringBuffer(input);
				temp.replace(a, a + 1, "&amp;");
				input = temp.toString();
				i = a + 5;
			} else if (b < a && b < c && b != -1) {
				temp = new StringBuffer(input);
				temp.replace(b, b + 1, "&lt;");
				input = temp.toString();
				i = b + 4;
			} else if (c < a && c < b && c != -1) {
				temp = new StringBuffer(input);
				temp.replace(c, c + 1, "&gt;");
				input = temp.toString();
				i = c + 4;
			} else if (a == b && b == c) {
				break;
			} else {
				break;
			}

		}
	*/
/*
		int ii = input.indexOf("\n");
		StringBuffer temp = null;
		while (ii != -1) {
			temp = new StringBuffer(input);
			temp.replace(ii, ii + 1, "&lt;br&gt;");
			input = temp.toString();
			ii = input.indexOf("\n");
		}*/
		return input;
	}
}
