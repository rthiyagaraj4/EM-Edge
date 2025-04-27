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
package rules.src.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import Polling.RulePollingService;

/**
 * @author PrasannaR
 *
 */
public class RuleInitializeServlet extends HttpServlet {

	public void init(ServletConfig config) throws ServletException
	{
		System.out.println("in init polling");
		RulePollingService pollingService = new RulePollingService();
		pollingService.poll();
		System.out.println("after poll method call");
	}
}
