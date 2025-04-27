package HL7Engine.OutboundProcess;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.isoft.interfaceengine.util.MultipartUtility;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;
import HL7Engine.Common.FileUtil;
import HL7Engine.Common.InterfaceUtil;
import HL7Engine.Common.XMLUtil;
import HL7Engine.Common.XHJSONUtil;
import HL7Engine.exceptions.InterfaceException;

public class HTTPTransactions implements ICommunication
{
	HttpURLConnection urlconnection;		
	
	private OutboundClientDBInteraction clientDB;
	private OutboundClientParameters clientParameters;
	private Common common = null;	
	private String httpMethod = "POST";
	private String fileUploadBoundary;
	
	private String templateFolder; 
	private String messageEncodingType;
	private String url; 
	private String fileName;
		
	public HTTPTransactions(OutboundClientDBInteraction clientDB, OutboundClientParameters clientParameters)
	{
		super();		
		this.clientDB = clientDB;
		this.clientParameters = clientParameters;
		common = Common.getInstance();
	}
	
	private void setProxy(Properties iniProperties) throws Exception
	{
		if("Y".equalsIgnoreCase(iniProperties.getProperty("PROXY_REQ")))
		{
			Properties sysProps = System.getProperties();
			sysProps.put("proxySet", "true");
			sysProps.put("proxyHost", iniProperties.getProperty("PROXY_IP"));
			sysProps.put("proxyPort", iniProperties.getProperty("PROXY_PORT"));
			sysProps.put("http.proxyUser", iniProperties.getProperty("PROXY_USER"));
			sysProps.put("http.proxyPassword", iniProperties.getProperty("PROXY_PASSWORD"));
		}
	}
	
	public void initFunc() throws Exception
	{
		Properties iniProperties = new Properties();
		iniProperties.load(new FileInputStream(InterfaceUtil.getiniFilePath("CONFIG")));
		setProxy(iniProperties);		
		httpMethod = iniProperties.getProperty("HTTP_METHOD", "POST");
	}
		
	private void getExtConn(String[] message) throws Exception
	{
		System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1,SSLv3");
		String contentType = "application/x-www-form-urlencoded";
		if("T".equals(clientParameters.strDbfFileType)) contentType = "multipart/form-data; boundary=" + fileUploadBoundary;
		if(clientParameters.logToFile)
		{
			common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:getExtConn) URL "+clientParameters.url+"\n");
		}
		URL url = new URL(clientParameters.url);
		urlconnection = (HttpURLConnection) url.openConnection();
		urlconnection.setRequestMethod(httpMethod);
		urlconnection.setRequestProperty("Content-Type", contentType);
		urlconnection.setDoOutput(true);
	}

	public String sendMessage(String message) throws Exception
	{
		OutputStreamWriter outputStream = null;
		BufferedReader inputStreamReader = null;
		int count = 0;
		
		if(clientParameters.logToFile)			
			common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) Before  getWebServiceParams \n" );
		
		clientDB.getWebServiceParams(); // Added by Sethu for ML-BRU-CRF-0560 
		
		common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) sethu  clientParameters.logToFile "+clientParameters.logToFile+"\n" );
		
		if(clientParameters.logToFile)			
			common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) After  getWebServiceParams \n" );
		
		String [] messageDtls = getMessageDetails(message);			
	
		String l_response_str = "", l_return_resp = "",l_out_JSON = "", l_status = "", l_msg_status = "";
		String statusMsg = "";
		
		l_msg_status = "S";		

		if ("M".equalsIgnoreCase(clientParameters.httpFileUploadType)) 
		{
			
			templateFolder = getTemplateFolder();
			this.fileName = templateFolder + "OPFile1.txt";
			messageEncodingType = InterfaceUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "NOTIFICATION_MESSAGE_ENCODING");
			boolean isTempBulkFileDeleted = new File(this.fileName).delete();			
			
			if(clientParameters.logToFile && clientParameters.debugYN)			
				common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) isTempBulkFileDeleted "+ isTempBulkFileDeleted +"\n" );
			
			if(clientParameters.logToFile && clientParameters.debugYN)			
				common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) Message \n "+ messageDtls[0].toString() +"\n" );
			
			FileUtil.appendToFile(this.fileName, messageDtls[0].toString(), messageEncodingType);
			statusMsg = uploadFile(this.fileName, clientParameters.url);
			if(statusMsg.startsWith("Error")) {
				throw new InterfaceException("Error from vendor - " + statusMsg);
			}
			
			if(statusMsg != null) processAck(statusMsg,messageDtls);
		}
		
		if ("T".equalsIgnoreCase(clientParameters.httpFileUploadType)) 
		{
			
			getExtConn(messageDtls);
			
			try
			{
				outputStream = new OutputStreamWriter(urlconnection.getOutputStream());
				if(clientParameters.logToFile && clientParameters.debugYN)
				{
					common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) Message "+messageDtls[0]+"\n");
				}
				outputStream.write(messageDtls[0]);
				if(clientParameters.logToFile && clientParameters.debugYN)
				{
					common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) Sent.. \n");
				}
				outputStream.flush();
				if(clientParameters.logToFile && clientParameters.debugYN)
				{
					common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) Message flushed from stream...\n");
				}
				
				inputStreamReader = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
				if(clientParameters.logToFile && clientParameters.debugYN)
				{
					common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) Got input stream...\n");
				}
				String ackMsg = "";
				String temp;
				if(clientParameters.logToFile && clientParameters.debugYN)
				{
					common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) before ack\n");
				}
				while ((temp = inputStreamReader.readLine()) != null) 
				{
					count++;
					ackMsg += temp;
					if(count > 3) 
						common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) ack " + ackMsg + "\n");
				}
				if(clientParameters.logToFile && clientParameters.debugYN)
					common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) Response ackMsg :"+ackMsg+"\n");				
				
				if(clientParameters.logToFile && clientParameters.debugYN)
					common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) strProtocalLinkId " + clientParameters.strProtocalLinkId + "\n");
				
				//Code added by Sethu for ML-BRU-CRF-0535 on 20/11/2018 
				if(clientParameters.logToFile && clientParameters.debugYN)
					common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) strProtocalLinkId " + clientParameters.strProtocalLinkId + "\n");
				
				if(clientParameters.logToFile && clientParameters.debugYN)
					common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) httpContentType " + clientParameters.httpContentType + "\n");				
				
				if ("application/json".equalsIgnoreCase(clientParameters.httpContentType))
				{
					l_out_JSON = XHJSONUtil.createJsonObject(ackMsg);
					
					if (l_out_JSON.indexOf("ParseException")>=0)
					{
						l_msg_status = "E";						
					}
					else
					{		
						/* Code changes expected here */
						l_status = XHJSONUtil.getJsonArrayObjString(l_out_JSON, "data", "error");
						
						if (!(l_status.length()>0))	
							l_status = XHJSONUtil.getJsonRequestString(l_out_JSON,  "error");
							
						
						if(clientParameters.logToFile && clientParameters.debugYN)
							common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) Response JSON Status " + l_status + "\n");					
						
						if ("0".equalsIgnoreCase(l_status))					
							l_msg_status = "S";
						else
							l_msg_status = "E";					
					}					
				}
				
				if(clientParameters.logToFile && clientParameters.debugYN)
					common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) Response JSON Message length() " + ackMsg.length() + "\n");					
				
				if (ackMsg.length()>2000)
					 ackMsg = ackMsg.substring(0,2000);				
				
				if(ackMsg != null) processAck(ackMsg,messageDtls);
			}
			catch(Exception exp) {
				throw exp;
			}
			finally {
				if(outputStream != null) outputStream.close();
				if(inputStreamReader != null) inputStreamReader.close();
			}
		}
		return l_msg_status;
	}
	
	private String[] getMessageDetails(String message)
	{
		String [] connDtls = getHTTPDtls(message);
		// && connDtls[0] != null Condition added by Kapil for Brunei SMS issue.
		if("T".equals(clientParameters.strDbfFileType) && connDtls[0] != null)
		{
			connDtls[0] = fileUploadText(connDtls[0]);
		}
		
		return connDtls;
	}

	public void closeResources() 
	{
		/*try
		{
			if(outputStream != null) outputStream.close();
			if(inputStreamReader != null) inputStreamReader.close();
		}
		catch(Exception exp)
		{
			common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
		}	*/	
	}
	
	private String[] getHTTPDtls(String message)
	{
		String[] messageDtls = null;
		if("QMATICQG1".equals(clientParameters.strProtocalLinkId)) // Rutnin Queue
		{
			messageDtls = message.split("\\|");
		//	httpURL = clientParameters.url + messageDtls[1];			
		}
		else
		{
			messageDtls = clientDB.getHTTPDtls(message);
		}
		
		return messageDtls;
	}
	
	// Method for building the text that is sent over HTTP in case of text file upload
	private String fileUploadText(String message)
	{
		StringBuilder msg = new StringBuilder();
		String CRLF = "\r\n"; // Line separator required by multipart/form-data.
		String tempMsg = message.replaceAll("%2B", "+").replaceAll("%20", " ").replaceAll("\\\\.br\\\\", CRLF);
		fileUploadBoundary = Long.toHexString(System.currentTimeMillis());
		
		// Added by Sethu for ML-BRU-CRF-0560 
		if ("T".equalsIgnoreCase(clientParameters.httpFileUploadType)) 
		{
			msg.append("--" + fileUploadBoundary).append(CRLF);
			msg.append("Content-Disposition: form-data; name=\"files\"; filename=\"File1.txt\"").append(CRLF);
			msg.append("Content-Type: text/plain;").append(CRLF); 
			//msg.append("Content-Disposition: form-data; name=\"files\"; filename=\"File1.csv\"").append(CRLF);
			//msg.append("Content-Type: text/csv;").append(CRLF);
			msg.append(CRLF);
			msg.append(tempMsg).append(CRLF);
			msg.append("--" + fileUploadBoundary + "--").append(CRLF);
		}
		else if ("M".equalsIgnoreCase(clientParameters.httpFileUploadType))
		{
			//tempMsg = tempMsg.replaceAll("SMM|", "");
			msg.append(tempMsg);		
		}
		
		return msg.toString();
	}
	
	private void processAck(String ackMsg,String[] message)
	{
		try
		{
			if("QMATICQG1".equals(clientParameters.strProtocalLinkId)) // Rutnin Queue
			{				
				Map<String,String> result = XMLUtil.getNodeElementAsMap(new ByteArrayInputStream(ackMsg.getBytes()),"//response/*");				
				if("Q01".equals(clientDB.strSentEventType) && "0000".equals(result.get("code")))
				{
					String udpateQueNoQry = "UPDATE op_patient_queue SET queue_num = " + result.get("result")
											+ " WHERE facility_id = '" + message[4].substring(0,2)
											+ "' AND encounter_id = " + message[2];
					if(clientParameters.logToFile && clientParameters.debugYN)
					{
						common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:processAck) Update Queue No: "+udpateQueNoQry+"\n");
					}					
					clientDB.executeQuery(udpateQueNoQry);
				}
			}
			clientDB.processAcknowledgement(ackMsg);
		}
		catch(Exception exp)
		{
			common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:processAck) Exception "+exp+"\n");
			common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}

	public String processCommunication(Map<String, String> params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Methods Added by Sethu for ML-BRU-CRF-0560
	private String getTemplateFolder() throws Exception
	{
		return InterfaceUtil.getPropertyVal(InterfaceUtil.getiniFilePath("CONFIG"), "NOTIFICATION_TEMPLATE_FOLDER");
	}
	
	public void setURL(String url, boolean resetURL)
	{
		this.url = url;		
	}
	
	public void setFileName(String filename)
	{
		this.fileName = filename;		
	}
	
	public String uploadFile(String fileName, String url) throws Exception
	{
		setURL(url, false);
		setFileName(fileName); 
		String messageContent = fileUploadText(CommonUtil.fetchFileContents(fileName));
		return sendMessageFile(messageContent, "Y");
	}
	
	public String sendMessageFile(String message, String fileYN) throws Exception
	{
		String ackMsg = "";		
		
		String charset = "UTF-8";
		File uploadFile1 = null;		
			
		if(clientParameters.logToFile && clientParameters.debugYN)
		{
			common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessageFile) Text File " + this.fileName + "\n");
		}
		
		try
		{
			uploadFile1 = new File(this.fileName);	
			
			if(clientParameters.logToFile && clientParameters.debugYN)
			{
				common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessageFile) URL :"+url+" \n");
			}
			
			MultipartUtility multipart = new MultipartUtility(url, charset);
			
			if(clientParameters.logToFile && clientParameters.debugYN)
			{
				common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessageFile) setting Content Type \n");
			}
			
			multipart.addHeaderField("Content-Type", "text/plain");
			multipart.addFormField("userid", clientParameters.odbcDBUserID);
			multipart.addFormField("password", clientParameters.odbcDBPwd);
			
			if(clientParameters.logToFile && clientParameters.debugYN)
			{
				common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessageFile) Adding Form fields "+ clientParameters.odbcDBUserID +" ::: "+ clientParameters.odbcDBPwd+"\n");
			}

			multipart.addFilePart("file",uploadFile1);
			
			if(clientParameters.logToFile && clientParameters.debugYN)
			{
				common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessageFile) Upload File "+ uploadFile1 +" ::: "+ clientParameters.odbcDBPwd+"\n");
			}

			List<String> response = multipart.finish();
			
			if(clientParameters.logToFile && clientParameters.debugYN)
			{
				common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessageFile) SERVER REPLIED: \n");
			}			

            for (String line : response) 
            {	                
                if(clientParameters.logToFile && clientParameters.debugYN)
    			{
    				common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessageFile) Response " + line + "\n");
    			}
                ackMsg += line;
            }
        } catch (IOException ex) {
        	common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessageFile) Exception while uploading " + ex.getMessage() + "\n");
        }	
		
		return ackMsg;
	}
	// Methods Added by Sethu for ML-BRU-CRF-0560

}
