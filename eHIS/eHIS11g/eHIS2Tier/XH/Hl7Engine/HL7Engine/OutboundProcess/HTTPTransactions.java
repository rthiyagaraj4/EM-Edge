package HL7Engine.OutboundProcess;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import HL7Engine.Common.Common;
import HL7Engine.Common.EMConstants;
import HL7Engine.Common.InterfaceUtil;

public class HTTPTransactions implements CommunicationInterface
{
	HttpURLConnection urlconnection;		
	
	private OutboundClientDBInteraction clientDB;
	private OutboundClientParameters clientParameters;
	private Common common = null;
		
	public HTTPTransactions(OutboundClientDBInteraction clientDB, OutboundClientParameters clientParameters)
	{
		super();		
		this.clientDB = clientDB;
		this.clientParameters = clientParameters;
		common = Common.getInstance();
	}
	
	private void setProxy() throws Exception
	{
		Properties iniProperties = new Properties();
		iniProperties.load(new FileInputStream(InterfaceUtil.getiniFilePath("CONFIG")));
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
		setProxy();
	}
		
	private void getExtConn(String message) throws Exception
	{
		if(clientParameters.logToFile && clientParameters.debugYN)
		{
			common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:getExtConn) URL "+clientParameters.url+"\n");
		}
		URL url = new URL(clientParameters.url);
		urlconnection = (HttpURLConnection) url.openConnection();
		urlconnection.setRequestMethod("POST");
		urlconnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		urlconnection.setDoOutput(true);		
		OutputStreamWriter outputStream = new OutputStreamWriter(urlconnection.getOutputStream());
		if(clientParameters.logToFile && clientParameters.debugYN)
		{
			common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) Message "+message+"\n");
		}
		outputStream.write(message);
		outputStream.flush();
		BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
		String ackMsg = "";
		String temp;
		while ((temp = inputStreamReader.readLine()) != null) 
		{
			ackMsg += temp;
		}
		common.fileOutput(clientParameters.strLogFile, "(HTTPTransactions:sendMessage) ackMsg "+ackMsg+"\n");
		if(ackMsg != null) clientDB.processAcknowledgement(ackMsg);
		if(outputStream != null) outputStream.close();
		if(inputStreamReader != null) inputStreamReader.close();		
	}

	public void sendMessage(String message) throws Exception
	{
		message = getMessageDetails(message);
		getExtConn(message);
//		outputStream.write(message);
//		outputStream.flush();
		
	}
	
	private String getMessageDetails(String message)
	{
		String [] connDtls = clientDB.getHTTPDtls(message);
		return connDtls[0];
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
}
