/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webbeans.eCommon.ConnectionManager;

public class HTTPSimulator extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		byte [] b = new byte[9999];
		StringBuilder requestMessage = new StringBuilder();
		ServletInputStream inputStream = request.getInputStream();
		while(inputStream.readLine(b, 0, b.length) != -1) {
			requestMessage.append(new String(b));
		}
		System.out.println("(HTTPSimulator:doPost) Request Message - " + requestMessage.toString());
		String responseMessage = getResponseMessage(request);
		System.out.println("(HTTPSimulator:doPost) Response Message - " + responseMessage);
		
		PrintWriter writer = response.getWriter();
		writer.write(responseMessage);
		writer.flush();
		writer.close();
    }

	private String getResponseMessage(HttpServletRequest request) {
		String responseQry = "SELECT xml_style_sheet_url FROM xh_protocol WHERE protocol_id = 'HTTPSIM'";
		return XHUtil.singleParamExeQry(responseQry);
	}

}
