/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
09/06/2017        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eXH;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.UnsupportedEncodingException;    
import javax.xml.bind.DatatypeConverter;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.IOException;
import java.util.List;

import java.util.Date;
import java.text.DateFormat;
import java.text.*;
import java.util.*;

import java.io.StringReader;
import java.io.StringWriter;

//import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import java.io.*;
import java.nio.charset.Charset;

public class TransformXMLXSLData {	

     public static String getTransformData(String xmlDataStr, String xslStr) {		

	
		StringBuffer outStrBuffer = new StringBuffer();

		String outHTML = "";	

		System.out.println(" xmlDataStr ::: "+xmlDataStr);

		System.out.println(" xslStr ::: "+xslStr);
		
        try
        {			

			xmlDataStr = StringEscapeUtils.unescapeXml(xmlDataStr);

			outHTML = transformData(xmlDataStr, xslStr);
			outStrBuffer = new StringBuffer(outHTML);
        }
        catch (TransformerConfigurationException e)
        {
            System.err.println("TransformerConfigurationException");
            System.err.println(e);
        }
        catch (TransformerException e)
        {
            System.err.println("TransformerException");
            System.err.println(e);
        }		
		catch (Exception e)
        {
            System.err.println("TransformerException");
            System.err.println(e);
        }	

		String responseString = outStrBuffer.toString();

		System.out.println(" responseString ::: "+responseString);

		return responseString;


    }

	public static String transformData(String xmlIn, String xsl)
            throws TransformerConfigurationException,
            TransformerException
    {
		String outputHTML = "";
		StreamSource xslSource = new StreamSource(new StringReader(xsl));
        StreamSource xmlInSource = new StreamSource(new StringReader(xmlIn));
        Transformer tf = TransformerFactory.newInstance().newTransformer(xslSource);
        StringWriter xmlOutWriter = new StringWriter();
        tf.transform(xmlInSource, new StreamResult(xmlOutWriter));
        outputHTML = xmlOutWriter.toString();

		return outputHTML;
	}

	/*
	private static String printSOAPResponse(SOAPMessage soapResponse) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		String soapResponseStr = sourceContent.toString();		
		return soapResponseStr;
	}
	

	private static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
		return message;
	}
	*/

}

