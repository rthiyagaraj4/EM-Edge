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
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.persist.PersistenceHelper;
import com.google.gson.JsonObject;

import eBL.pkgpricerevision.bc.PkgPriceDisountBC;
import eBL.pkgpricerevision.request.PkgPriceRevisionRequest;
import eBL.pkgpricerevision.response.PkgPriceRevisionResponse;

/**
 * Servlet for Updating the Package Price / Discount 
 *  as Individual Update or Bulk Update
 * @author Rajesh V
 *
 */

public class PkgBulkUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PkgBulkUpdateServlet() {
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
		String beanId = "PkgPriceRevisionRequest" ;
		String beanName = "eBL.pkgpricerevision.request.PkgPriceRevisionRequest";
		PkgPriceRevisionRequest pkgPriceDiscount = null;
		HttpSession session = request.getSession(false);
		PkgPriceDisountBC priceDiscountBC = new PkgPriceDisountBC();
		pkgPriceDiscount = (PkgPriceRevisionRequest) PersistenceHelper.getObjectFromBean(beanId, beanName, session);
		String insertUpd = (String) request.getParameter("insertUpd");
		String userId = (String)session.getAttribute("login_user");
		String facilityId = (String)session.getAttribute("facility_id");
		PrintWriter out = response.getWriter();
		JsonObject obj = null;
		if("I".equals(insertUpd)){
			String bulkUpdate = (String) request.getParameter("bulkUpdate");
			pkgPriceDiscount.setBulkUpdateYn(bulkUpdate);
			pkgPriceDiscount.setUserId(userId);
			pkgPriceDiscount.setFacilityId(facilityId);
			PkgPriceRevisionResponse priceResponse = priceDiscountBC.insertPkgUpdateRequest(pkgPriceDiscount);
			if(priceResponse.isStatus()){
				if(priceResponse.getTotalCount()>0){
					
					obj = new JsonObject();
					obj.addProperty("status", "Y");
					obj.addProperty("session_id", priceResponse.getSessionId());
					obj.addProperty("pgm_date", priceResponse.getPgmDate());
					obj.addProperty("count", priceResponse.getTotalCount());
					obj.addProperty("rowsInserted", priceResponse.getRowsInserted());
					out.println(obj);
				}
				else{
					obj = new JsonObject();
					obj.addProperty("status", "Y");
					obj.addProperty("count", priceResponse.getTotalCount());
					obj.addProperty("session_id", priceResponse.getSessionId());
					obj.addProperty("pgm_date", priceResponse.getPgmDate());
					obj.addProperty("rowsInserted", priceResponse.getRowsInserted());
					out.println(obj);
				}
			}
			else{
				obj = new JsonObject();
				obj.addProperty("status", "N");
				String error = "";
				for(String strError: priceResponse.getError()){
					error = error + strError + "<br/> ";
				}
				obj.addProperty("error", error);
				out.println(obj);
			}
			
		}
		else if("U".equals(insertUpd)){
			pkgPriceDiscount.setUserId(userId);
			String session_id = (String) request.getParameter("session_id");
			String pgm_date = (String) request.getParameter("pgm_date");
			pkgPriceDiscount.setSessionId(session_id);
			pkgPriceDiscount.setPgmDate(pgm_date);
			PkgPriceRevisionResponse priceResponse = priceDiscountBC.populatePkgUpdateRequest(pkgPriceDiscount);
			
			String error = "";
			int err_val = 1;
			if(priceResponse.isStatus()){
				/*String jobNo = priceDiscountBC.getJobNumber(session_id,pgm_date);
				if(jobNo == null || "null".equals(jobNo)){
					jobNo = "";
				}
				priceResponse.setJobNumber(jobNo);
				if(!"".equals(priceResponse.getJobNumber())){
					error = "APP-SM0070 Operation Completed Successfully .... Please note down the Job Number <strong> "+priceResponse.getJobNumber()+"</strong>";
				}
				else{
					error = "APP-SM0070 Operation Completed Successfully .... Job has not created ";
				}*/
				error = "APP-SM0070 Operation Completed Successfully ....";
			}
			else{
				for(String err:priceResponse.getError()){
					error = error + err  +"<br/>";
					err_val = 2;
				}
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
		}
		
	}

}
