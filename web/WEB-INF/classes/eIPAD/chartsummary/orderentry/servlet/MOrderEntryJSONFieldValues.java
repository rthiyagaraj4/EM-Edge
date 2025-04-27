/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.orderentry.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.persist.PersistenceHelper;
import com.google.gson.Gson;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.orderentry.bc.MOrderEntryBC;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsSearchRequest;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest;
import eIPAD.chartsummary.orderentry.response.MOrderCatalogCountResponse;
import eIPAD.chartsummary.orderentry.response.MOrderEntryConstants;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse;
import eOR.OrderEntryBean;

/**
 * Servlet implementation class OrderEntryJSONFieldValues
 */
public class MOrderEntryJSONFieldValues extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String jsonFieldResponse = "";
		HttpSession session = request.getSession(false);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		response.setContentType("application/json");
		Gson gson = new Gson();
		
		if(patientContext!=null){
			String patientId = patientContext.getPatientId();
			String encounterId = patientContext.getEncounterId();
			String or_bean_id = "@orderentrybeanm"+patientId+encounterId;
			String or_bean_name = "eOR.OrderEntryBean";
			OrderEntryBean bean	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
			MOrderEntryBC bc = new MOrderEntryBC();
			String fieldName = request.getParameter("field") == null? "":request.getParameter("field");
			if(fieldName.equals(MOrderEntryConstants.TICKSHEET_SECTIONS)){
				String tickSheetId = request.getParameter("TickSheetId") == null? "":request.getParameter("TickSheetId");
				if(bean!=null){
					MOrderEntryFieldResponse fieldResponse= bc.getSectionsUnderTickSheet(bean,tickSheetId,true);
					if(fieldResponse!=null){
						jsonFieldResponse = gson.toJson(fieldResponse);
					}
				}
			}
			else if(fieldName.equals(MOrderEntryConstants.TICKSHEET_ORDERS_COUNT)){
				String tickSheetId = request.getParameter("TickSheetId") == null? "":request.getParameter("TickSheetId");
				String tickSheetSec = request.getParameter("TickSheetSec") == null? "":request.getParameter("TickSheetSec");
				if(bean !=null){
					MOrderCatalogsTickSearchRequest tickReq = new MOrderCatalogsTickSearchRequest();
					tickReq.setOrderEntryBean(bean);
					tickReq.setPatientContext(patientContext);
					tickReq.setTickSheetId(tickSheetId);
					tickReq.setSectionCode(tickSheetSec);
					MOrderCatalogCountResponse countResp = bc.getTickSheetOrdersCount(tickReq,true);
					if(countResp!=null){
						jsonFieldResponse = gson.toJson(countResp);
					}
				}
			}
			else if(fieldName.equals(MOrderEntryConstants.SEARCH_ORDERS_COUNT)){
				String orderCategory = request.getParameter("OrderCategory") == null? "":request.getParameter("OrderCategory");
				String orderType = request.getParameter("OrderType") == null? "":request.getParameter("OrderType");
				String searchText = request.getParameter("SearchText") == null? "":request.getParameter("SearchText");
				if(bean !=null){
					MOrderCatalogsSearchRequest searchReq = new MOrderCatalogsSearchRequest();
					searchReq.setOrderEntryBean(bean);
					searchReq.setPatientContext(patientContext);
					searchReq.setOrderCategory(orderCategory);
					searchReq.setOrderType(orderType);
					searchReq.setSearchText(searchText);
					MOrderCatalogCountResponse countResp = bc.getOrdersBySearchCount(searchReq, true);
					if(countResp!=null){
						jsonFieldResponse = gson.toJson(countResp);
					}
				}
			}
			
		}
		response.setContentType("application/json");
		response.getWriter().write(jsonFieldResponse);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
