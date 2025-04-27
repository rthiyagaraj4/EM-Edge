package eXH;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebserviceUtil 
{
	public static byte[] invokeService(String soapAction, String urlString, String xml) throws Exception
	{
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "text/soap+xml; charset=utf-8");
		connection.setRequestProperty("Content-Length", "250");
		connection.setRequestProperty("SOAPAction", soapAction);

	/*	FileInputStream inStream = new FileInputStream("E:\\ravee\\CDrive\\core\\testPAR.txt");
		byte[] b = new byte[99999];
		int i = inStream.read(b);
		inStream.close();
	
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		System.out.println("one "+new String(b, 0, i));
		out.write(new String(b, 0, i));
		System.out.println("one1");
		out.close();
	*/
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write(xml);		
		out.close();
		System.out.println("Message delivered... waiting for response...");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
							
	/*	String decodedString;

		FileOutputStream fout = new FileOutputStream("C:/eHIS/reports/test.xml");

		while ((decodedString = in.readLine()) != null) 
		{
			fout.write(decodedString.getBytes());
		}
	*/
		String tempStr = "";
		String decodedString = "";
		
		while ((tempStr = in.readLine()) != null) 
		{			
			decodedString = decodedString + tempStr;
			System.out.println("decodedString "+decodedString);
		}
		
		in.close();
		return decodedString.getBytes();
	}
}
