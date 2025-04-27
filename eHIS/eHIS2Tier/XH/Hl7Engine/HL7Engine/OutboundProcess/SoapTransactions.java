package HL7Engine.OutboundProcess;

import java.util.HashMap;
import java.util.Map;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.*;
import java.util.*;
import java.nio.charset.Charset;

import com.csc.eminterface.wsclients.ClientMaster;

import HL7Engine.Common.Common;
import HL7Engine.Common.Message;

import org.apache.commons.lang.StringEscapeUtils;

public class SoapTransactions implements ICommunication
{
	
	private OutboundClientDBInteraction clientDB;
	private OutboundClientParameters clientParameters;
	private Common common = null;	
		
	public SoapTransactions(OutboundClientDBInteraction clientDB, OutboundClientParameters clientParameters)
	{
		super();		
		this.clientDB = clientDB;
		this.clientParameters = clientParameters;
		common = Common.getInstance();
	}

	public void initFunc() throws Exception 
	{
		// TODO Auto-generated method stub
	}

	public String sendMessage(String message) throws Exception 
	{
		String messageStatus = "S";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("message", message);
		
		messageStatus = processCommunication(params);
		return messageStatus;
	}

	public void closeResources() 
	{
		// TODO Auto-generated method stub
	}

	public String processCommunication(Map<String, String> params) throws Exception 
	{
		String status = "E";
		String message = params.get("message");
		
		 SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
         SOAPConnection soapConnection = soapConnectionFactory.createConnection();		
		
		if(clientParameters.logToFile)
		{
			common.fileOutput(clientParameters.strLogFile, "(SoapTrans:processCommunication) \n");
		}
		
		 // Send SOAP Message to SOAP Server
        String url = clientParameters.webserviceURL; //"http://enotistrain.moh.gov.my:8086/eNotifWService.asmx";
        String userAgent = clientParameters.httpUserAgent;
		String contentType = clientParameters.httpContentType;//"text/xml; charset=UTF-8";
		String soapAction = clientParameters.httpSoapaction;//"http://enotis.moh.gov.my/enotifwebsvc/ReceiveTPNotification";
		String transferEncoding = clientParameters.httpTransferEncoding;
		int contentLengthFlag = clientParameters.httpContentLengthFlag;
		java.sql.Clob responseXSL = clientParameters.httpSoapResponseXSL;
		String xmlString = message;
		
        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(xmlString, userAgent, contentType, contentLengthFlag, transferEncoding, soapAction), url);
        
        String soapStr =  printSOAPResponse(soapResponse);
        String clobStr = clobToString(responseXSL);

        // Process the SOAP Response
       
        String outHtml = "";        
        
        if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(SoapTrans:processCommunication) soapResponseStr 1 "+soapStr+"\n" ) ;               
        
        if (clientParameters.strProtocalLinkId.equalsIgnoreCase("enotpl")){
        	soapStr = StringEscapeUtils.unescapeXml(soapStr);
        	soapStr = soapStr.replace("xmlns=\"http://enotis.moh.gov.my/enotifwebsvc/\"","");
        	soapStr = soapStr.replace("<?xml version=\"1.0\" encoding=\"utf-16\"?>","");
        }
        
        if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(SoapTrans:processCommunication) soapResponseStr 2 "+soapStr+"\n" ) ;
        
        outHtml = transformData(soapStr, clobStr);
        
        if (clientParameters.strProtocalLinkId.equalsIgnoreCase("enotpl")){
        	outHtml = outHtml.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>","");
        }
        
        if(clientParameters.logToFile) 
        common.fileOutput( clientParameters.strLogFile, "(SoapTrans:processCommunication) Before updating event message Text \n" ) ;
        
        this.clientDB.updateEventMessageText(this.clientDB.stringToClob(soapStr));        
        
        if(clientParameters.logToFile) 
            common.fileOutput( clientParameters.strLogFile, "(SoapTrans:processCommunication) Before updating application message status text \n" ) ;
        
        this.clientDB.updateApplicationMessageText(this.clientDB.stringToClob(soapStr));
        
        if(clientParameters.logToFile) 
            common.fileOutput( clientParameters.strLogFile, "(SoapTrans:processCommunication) After updating application message status text \n" ) ;
        
        if(outHtml!="" && outHtml != null)
        {
	       	 if(outHtml.contains("SUC"))
	       	 {
	       		 status = "S";
	       	 }
	       	 else if(outHtml.contains("FAL"))
	       	 {
	       		 status = "E";
	       	 }
        }
        else
        {
       	 status = "E";
        }
               
        if(clientParameters.logToFile) 
        {
        	common.fileOutput( clientParameters.strLogFile, "(SoapTrans:processCommunication) outHtml "+outHtml+"\n" ) ;
        	common.fileOutput( clientParameters.strLogFile, "(SoapTrans:processCommunication) status "+status+"\n" ) ;
        }
        
        soapConnection.close();
		
        return status;
	}
	
	 private  SOAPMessage createSOAPRequest(String xmlString, String userAgent, String contentType, int contentLengthFlag, String transferEncoding, String soapAction) throws Exception {
			SOAPMessage soapMessage = getSoapMessageFromString(xmlString);

	        MimeHeaders headers = soapMessage.getMimeHeaders();
	        
	        if (userAgent != null){
		        if (userAgent.length()>0)
		        	headers.addHeader("User-Agent", userAgent);
	        }
	        
	        if (contentType != null){
		        if (contentType.length()>0)
		        	headers.addHeader("Content-Type", contentType);
	        }	        
	        
	        if (contentLengthFlag > 0)
	        	headers.addHeader("Content-Length", String.valueOf(xmlString.length()));
	        
	        if (transferEncoding != null){
		        if (transferEncoding.length() > 0)
		        	headers.addHeader("Transfer-Encoding", transferEncoding);
	        }
	        
	        if (soapAction != null){
		        if (soapAction.length() > 0)
		        	headers.addHeader("SOAPAction", soapAction);
	        }

	        soapMessage.saveChanges();

	        /* Print the request message */
	        if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(SoapTrans:processCommunication) Request Soap Message ::: "+soapMessage+"\n");

	        return soapMessage;
	    }

	    /**
	     * Method used to print the SOAP Response
	     */
	    private static String printSOAPResponse(SOAPMessage soapResponse) throws Exception {
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        Source sourceContent = soapResponse.getSOAPPart().getContent();
	        
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	        
	        final ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
	        final StreamResult result = new StreamResult(streamOut);
	        transformer.transform(sourceContent, result);

	        return streamOut.toString();	        
	    }
		
		private SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage(new MimeHeaders(), new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
			return message;
		}
		
		private String clobToString(java.sql.Clob data)
		{
		    final StringBuilder sb = new StringBuilder();
		    try
		    {
		        final Reader         reader = data.getCharacterStream();
		        final BufferedReader br     = new BufferedReader(reader);

		        int b;
		        while(-1 != (b = br.read()))
		        {
		            sb.append((char)b);
		        }

		        br.close();
		    }
		    catch (Exception e)
		    {
		        return e.toString();
		    }	    
		    return sb.toString();
		}
		
		
		/*
		private java.sql.Clob stringToClob(String source)
		{
			 try
			    {
					 if(source!=null)
					 {
				        return new javax.sql.rowset.serial.SerialClob(source.toCharArray());
					 }
					 else{
						 return null;
					 }
			    }
			    catch (Exception e)
			    {
			        e.printStackTrace();
			        return null;
			    }
		}
		*/
		public static String transformData(String xmlIn, String xsl)
	            throws TransformerConfigurationException,
	            TransformerException
	    {
			String outputHTML = "";
			Source xslSource = new StreamSource(new StringReader(xsl));
	        Source xmlInSource = new StreamSource(new StringReader(xmlIn));
	        Transformer tf = TransformerFactory.newInstance().newTransformer(xslSource);
	        StringWriter xmlOutWriter = new StringWriter();
	        tf.transform(xmlInSource, new StreamResult(xmlOutWriter));
	        outputHTML = xmlOutWriter.toString();

			return outputHTML;
		}
		
		public static String returnStatus(String resultStr){
			
			String status = "E"; 
			String replacedStr = resultStr.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>","");

			replacedStr = replacedStr.replace("$!^","^!^");

			String delims = "^!^";
			StringTokenizer st = new StringTokenizer(replacedStr,delims );
			
			ArrayList<String> tokenD = new ArrayList<String>();
			
			while (st.hasMoreElements()) {
				tokenD.add(st.nextToken());
			}
			if (tokenD.size()>0)
				status = tokenD.get(1);
			
			return status;
		}		
}