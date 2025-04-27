/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAlert.src.alert.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import eAlert.src.alert.bc.ProcessAlertBC;
import eAlert.src.alert.response.AlertFlagOptionResponse;

/**
 * Servlet implementation class AlertFlagOptionServlet  
 */
public class AlertFlagOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlertFlagOptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		ProcessAlertBC alertBC = new ProcessAlertBC();
		AlertFlagOptionResponse flagOptionResponse = null;
		
		flagOptionResponse = alertBC.getFlagOptions();
		
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(flagOptionResponse);
		
		response.setContentType("application/json");
		response.getWriter().write(jsonResponse);
	}

}
