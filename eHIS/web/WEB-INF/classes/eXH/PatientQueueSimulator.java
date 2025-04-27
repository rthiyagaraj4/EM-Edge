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
import java.util.Map;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import eXH.XHUtil;
import webbeans.eCommon.ConnectionManager;

/**
 *  Class used to handle transactions for patient queue simulation
 */
public class PatientQueueSimulator extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		request.setCharacterEncoding("UTF-8");
   	    response.setContentType("text/html;charset=UTF-8");
   	    String resXML = "<response><code>0000</code><message>success</message><result>1109</result></response>";
		PrintWriter out = response.getWriter();
		out.write(resXML);
		out.flush();
		out.close();
    }
	
}
