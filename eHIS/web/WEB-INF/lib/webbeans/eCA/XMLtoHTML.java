/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package webbeans.eCA;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import java.io.*;

public class XMLtoHTML implements Serializable
{
	String      sXML;	
	String		sXSLTemplateContextReference;

	public void setXSLFileContextReference(String contextUrl)
	{
		this.sXSLTemplateContextReference = contextUrl;
	}
	
/*	public String   buildHTMLFromXML(String sXMLData, String sXSLFile) throws  TransformerException, TransformerConfigurationException, FileNotFoundException, IOException
	{ 
		String        sXSLTemplate = "";
		StringWriter strw=new StringWriter();
		
		try
		{
			if(sXSLFile == null )
				throw new Exception("This method does not support a null as a second parameter. Please give a valid XSL file as a reference...");
	
			if(sXSLTemplateContextReference != null)
				sXSLTemplate = (sXSLTemplateContextReference + sXSLFile);
			else
				sXSLTemplate = sXSLFile;

			sXML = sXMLData;
			try{
				TransformerFactory tFactory = TransformerFactory.newInstance();				
				Transformer transformer = tFactory.newTransformer(new StreamSource(sXSLTemplate));				
				transformer.transform(new StreamSource(new StringReader(sXML)),    new StreamResult(strw));
				System.out.println("XMLTOHTML=====================>41");
				throw new TransformerException("TransformerException in XMLtoHTML");
			}catch(Exception ex){
				try{
					TransformerFactory factory = SAXTransformerFactory.newInstance();					
					Transformer transformer = factory.newTransformer(new StreamSource(sXSLTemplate));					
					transformer.transform(new StreamSource(new StringReader(sXML)), new StreamResult(strw));
					System.out.println("XMLTOHTML=====================>48");
					throw new TransformerException("TransformerException in XMLtoHTML");
				}catch(TransformerConfigurationException etc){
					throw new TransformerConfigurationException("TransformerConfigurationException in XMLtoHTML");
				}catch(TransformerException etx){
					throw new TransformerException("TransformerException in XMLtoHTML");
				}catch(Exception ex1)
				{
					System.err.println("----------------------------------------");
					System.err.println("Exception caught while SAXTransformerFactory Transformer the XML file..." + ex1);			
					System.err.println("sXSLTemplate=" + sXSLTemplate);
					System.err.println("sXSLTemplateContextReference=" + sXSLTemplateContextReference);
					System.err.println("sXSLFile=" + sXSLFile);
					System.err.println("----------------------------------------");
					ex1.printStackTrace(System.err);
					System.out.println("XMLTOHTML=====================>59");
					throw new TransformerException("TransformerException in XMLtoHTML");
				}
			}
		}catch(Exception e)
		{
			System.err.println("----------------------------------------");
			System.err.println("Exception caught while TransformerFactory Transformer the XML file..." + e);			
			System.err.println("sXSLTemplate=" + sXSLTemplate);
			System.err.println("sXSLTemplateContextReference=" + sXSLTemplateContextReference);
			System.err.println("sXSLFile=" + sXSLFile);
			System.err.println("----------------------------------------");
			e.printStackTrace(System.err);
			System.out.println("XMLTOHTML=====================>72");
			try{
			throw new Exception("IOException in XMLtoHTML");
			}catch(Exception e2){}
		}
		return strw.toString();
	} */
	public String   buildHTMLFromXML(String sXMLData, String sXSLFile) throws  TransformerException, TransformerConfigurationException, FileNotFoundException, IOException
	{ 
		String        sXSLTemplate = "";
		StringWriter strw=new StringWriter();
		
		try
		{
			if(sXSLFile == null )
				throw new Exception("This method does not support a null as a second parameter. Please give a valid XSL file as a reference...");
	
			if(sXSLTemplateContextReference != null)
				sXSLTemplate = (sXSLTemplateContextReference +"/"+ sXSLFile);
			else
				sXSLTemplate = sXSLFile;

			sXML = sXMLData;
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource(new File(sXSLTemplate)));
			transformer.transform(new StreamSource(new StringReader(sXML)),    new StreamResult(strw));
		}catch(TransformerConfigurationException etc){
			System.err.println("Exception caught while transforming the XML file..." + etc);
			throw new TransformerConfigurationException("104. TransformerConfigurationException in XMLtoHTML");
		}catch(TransformerException etx){
			System.err.println("Exception caught while transforming the XML file..." + etx);
			throw new TransformerException("106. TransformerException in XMLtoHTML");
		}catch(FileNotFoundException efn){
			System.err.println("Exception caught while transforming the XML file..." + efn);
			throw new FileNotFoundException("108. FileNotFoundException in XMLtoHTML");
		}catch(IOException eio){
			System.err.println("Exception caught while transforming the XML file..." + eio);
			throw new IOException("110. IOException in XMLtoHTML");
		}
		catch(Exception e)
		{
			System.err.println("----------------------------------------");
			System.err.println("Exception caught while transforming the XML file..." + e);			
			System.err.println("sXSLTemplate=" + sXSLTemplate);
			System.err.println("sXSLTemplateContextReference=" + sXSLTemplateContextReference);
			System.err.println("sXSLFile=" + sXSLFile);
			System.err.println("----------------------------------------");
			e.printStackTrace(System.err);
		}
		return strw.toString();
	}
}
