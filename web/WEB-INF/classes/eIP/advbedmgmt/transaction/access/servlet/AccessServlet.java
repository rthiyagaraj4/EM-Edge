/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIP.advbedmgmt.transaction.access.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIP.advbedmgmt.transaction.access.AccessConstants;
import eIP.advbedmgmt.transaction.access.dao.AccessDAOImpl;
import eIP.advbedmgmt.transaction.access.request.AccessRequest;
import eIP.advbedmgmt.transaction.access.response.AccessResponse;

/**
 * This servlet retrieves the access rights for CRUD operations
 * in graphical bed GUI
 * Based on the access rights, transactions will be provided
 * in the graphical bed GUI
 * This servlet is initially designed to be used for create booking transaction
 * @author GRamamoorthy
 *
 */
public class AccessServlet extends HttpServlet {

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	/**
	 * This is the main method in this servlet
	 * This method gets the access rights and writes it to the output stream
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// get data from the request one by one
		// locale, menu id, function id is needed
		HttpSession session = req.getSession();
		String locale = (String)session.getAttribute("LOCALE");
		
		String menuId = req.getParameter(AccessConstants.MENUID_REQUEST_PARAMETER);
		if(menuId == null){
			menuId = "";
		}
		
		String functionId = req.getParameter(AccessConstants.FUNCTIONID_REQUEST_PARAMETER);
		if(functionId == null){
			functionId = "";
		}
		
		// initialize the access request and set data to it
		AccessRequest accessRequest = new AccessRequest();
		accessRequest.setLocale(locale);
		accessRequest.setMenuId(menuId);
		accessRequest.setFunctionId(functionId);
		accessRequest
				.setFunctionalityIdentifier(AccessConstants.CREATE_BOOKING_ACCESS_IDENTIFIER);
		// initialize the dao impl and get the response
		AccessDAOImpl impl = new AccessDAOImpl();
		AccessResponse accessResponse = impl.getAccess(accessRequest);
		
		// now process the response
		// access string in the response class contains characters for
		// insert, update, query, delete and print access rights
		String access = accessResponse.getAccess();
		// for safety
		if(access == null){
			access = "";
		}

		// now write the access to the output stream
		PrintWriter out = resp.getWriter();
		out.println(access);
		
	}
}
