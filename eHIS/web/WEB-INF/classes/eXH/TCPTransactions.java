/***************************************************************************************************************
 * Author   :   Ravindranath.O
 * Desc     :	
 ***************************************************************************************************************/
package eXH;

import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class TCPTransactions
{
	private static final long serialVersionUID = 1L;

	public static String wait_time = "";

	static boolean isDebugYN = false;

	public void processRequest(Map<String, String> reqParams) throws Exception
	{
	//	String ipAddress = XHUtil.getIPByHostname(reqParams.get("IP_ADDRESS") + ".KDAHIT.COM");
		String ipAddress = "", port = "";
		
		String requestMsg = buildRequestMsg(reqParams);		

		try {

			ipAddress = reqParams.get("IP_ADDRESS"); //Added by Sethu for KDAH Credit card transactions.
			port = reqParams.get("PORT_NUMBER");		

			wait_time = reqParams.get("WAIT_TIME");	

			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			if(isDebugYN)
				System.out.println("IP ["+ipAddress+"] Port ["+port+"] Wait Time ["+wait_time+"]");

			//String response = sendRequest("10.65.248.218", port, requestMsg);
			
			String response = sendRequest(ipAddress, port, requestMsg); //Added by Sethu for KDAH Credit card transactions.

			if(isDebugYN)
				System.out.println("(TCPTransactions:processRequest) Response "+response);

			reqParams.put("RESPONSE_TEXT", response);
		}
		catch (Exception exp) {
			System.out.println("(TCPTransactions:processRequest) Exception: " + exp.getMessage());
			exp.printStackTrace(System.err);
			throw exp;
		}
		finally {
			XHUtil.updateInteractiveDetails(reqParams);
		}
	}

	private static String sendRequest(String ipAddress, String port, String message) throws Exception
	{
		String response = "";
		OutputStreamWriter outputStream = null;
		BufferedInputStream inputStream = null;
		Socket socket = null;
		byte [] responseBytes = new byte[1000000]; // 1 MB of bytes
		int l_wait_time = 0;
		
		try
		{
			l_wait_time = Integer.parseInt(wait_time);
			if (l_wait_time < 1000)
			{
				l_wait_time = l_wait_time * 1000;
			}
			
			if(isDebugYN)
				System.out.println("IP ["+ipAddress+"] Port ["+port+"] Wait Time in Milliseconds ["+l_wait_time+"]");


			socket = new Socket(ipAddress, Integer.parseInt(port));
			socket.setSoTimeout(l_wait_time);

			outputStream = new OutputStreamWriter(socket.getOutputStream());		
			outputStream.write(message);
			outputStream.flush();

			inputStream = new BufferedInputStream((socket.getInputStream()));
			int responseLength = inputStream.read(responseBytes);
			response = new String(responseBytes, 0, responseLength);
			
			if(isDebugYN)
				System.out.println("(TCPTransactions:sendRequest) Response " + response);
		}
		catch (Exception exp) {
			System.out.println("(TCPTransactions:processRequest) sendRequest: " + exp);
			throw exp;
		}
		finally {
			XHUtil.closeResourse(outputStream);
			XHUtil.closeResourse(inputStream);
		}
		return response;
	}

	private String buildRequestMsg(Map<String, String> reqParams) 
	{
		String requestMsg = "";
		String requestFormat = reqParams.get("REQUEST_SYNTAX");
		requestMsg = getRequestMsg(requestFormat, reqParams);

		reqParams.put("REQUEST_TEXT", requestMsg);
		return requestMsg;
	}

	private String getRequestMsg(String requestFormat, Map<String,String> reqParams)
	{
		Pattern pattern = Pattern.compile("#REQ_(.*?)_END");
		Matcher matcher = pattern.matcher(requestFormat);
		while(matcher.find())
		{
			String param = matcher.group(1);
			String currentMatch = matcher.group();
			String paramValue = StringUtils.defaultString(reqParams.get(param));
			requestFormat = requestFormat.replace(currentMatch, paramValue);
		}

		return requestFormat;
	}

}