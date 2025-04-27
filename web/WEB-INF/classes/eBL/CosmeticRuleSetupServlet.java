/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ehis.persist.PersistenceHelper;

/**
 * Servlet implementation class CosmeticRuleSetupServlet
 */
public class CosmeticRuleSetupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CosmeticRuleSetupServlet() {
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
		String insertUpdate = (String) request.getParameter("insertUpdate");
		CosmeticRuleDAO cosmeticDAO = new CosmeticRuleDAO();
		String beanId = "CosmeticRuleBean" ;
		String beanName = "eBL.CosmeticRuleHeaderBean";
		CosmeticRuleHeaderBean cosmeticBean = null;
		List<String> error = null;
		String errorMessage = "";
		if("I".equals(insertUpdate)){
			cosmeticBean = (CosmeticRuleHeaderBean) PersistenceHelper.getBeanObject(beanId, beanName, request);
			error =  cosmeticDAO.insertCosmeticRuleSetup(cosmeticBean);
			
			
		}
		else{
			cosmeticBean = (CosmeticRuleHeaderBean) PersistenceHelper.getBeanObject(beanId, beanName, request);
			try{
				int seqNo = Integer.parseInt(request.getParameter("seqNo"));
				cosmeticBean.setSeqNo(seqNo);
			}
			catch(Exception e){
				System.err.println("Error in Converting seqNo -> "+e);
			}
			error =  cosmeticDAO.updateCosmeticRuleSetup(cosmeticBean);
		}
		int err_val = 1;
		if(error.isEmpty()){
			errorMessage = "APP-SM0070 Operation Completed Successfully ....";
		}
		else{
			for(String err: error){
				errorMessage = errorMessage + err  +"<br/>";
				err_val = 2;
			}
		}
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMessage,"UTF-8" ) +"&err_value="+err_val);
	}


}
