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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import eAlert.src.alert.bc.ProcessAlertBC;
import eAlert.src.alert.common.AlertBaseResponse;
import eAlert.src.alert.common.AlertErrorInfo;
import eAlert.src.alert.request.AlertFlagManageRequest;
import eAlert.src.alert.request.AlertFwdManageRequest;
import eAlert.src.alert.request.AlertReviewMangRequest;

/**
 * Servlet implementation class AlertManageServlet  
 */
public class AlertManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlertManageServlet() {
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
		
		String userId = "";
		String salertId = "";
		long alertId = 0;
		String sCount = "";
		int count = 0;
		String context = "";
		String sPatientRecipientId = "";
		long patientRecipientId = 0;
		
		salertId = request.getParameter("alertIdhdn");
		sCount = request.getParameter("alertTotcnthdn");
		sPatientRecipientId = request.getParameter("alertPatientRecipientIdhdn");
		
		if(salertId != "")
			alertId = Long.parseLong(salertId);
		if(sCount != ""){
			count = Integer.parseInt(sCount);
		}
		if(sPatientRecipientId != "")
			patientRecipientId = Long.parseLong(sPatientRecipientId);
		context = request.getParameter("alertTabhdn");
		
		userId = (String)session.getAttribute("login_user");
		ProcessAlertBC alertBC = new ProcessAlertBC();
		AlertBaseResponse manageResponse = null;
		
		if(context.equalsIgnoreCase("review")){
			AlertReviewMangRequest reviewRequest = new AlertReviewMangRequest();
			reviewRequest.setAlertId(alertId);
			reviewRequest.setCount(count);
			reviewRequest.setPatRecipientId(patientRecipientId);
			reviewRequest.setCommentText(request.getParameter("rvwtextarea"));
			
			manageResponse = alertBC.updateAlertReviewState(reviewRequest);
		}
		else if(context.equalsIgnoreCase("forward")){
			String strJSON = "";
			List<String> userIdList = new ArrayList<String>();
			
			strJSON = request.getParameter("alertForwardListhdn");
			JsonElement jsonElement = new JsonParser().parse(strJSON);
			JsonArray jsonArr = jsonElement.getAsJsonArray();
			Iterator<JsonElement> iterator = jsonArr.iterator();
			
			while(iterator.hasNext()){
				JsonElement element = (JsonElement)iterator.next();
				Gson gson = new Gson();
				String sUserId = gson.fromJson(element, String.class);
				
				userIdList.add(sUserId);
			}
			
			AlertFwdManageRequest forwardRequest = new AlertFwdManageRequest();
			forwardRequest.setUserId(userId);
			forwardRequest.setAlertId(alertId);
			forwardRequest.setCount(count);
			forwardRequest.setComment(request.getParameter("fwdtextarea"));
			forwardRequest.setPatientAlertRecipientId(patientRecipientId);
			forwardRequest.setUserIdList(userIdList);
			
			manageResponse = alertBC.updateAlertForwardState(forwardRequest);
		}
		else if (context.equalsIgnoreCase("flag")){
			AlertFlagManageRequest flagRequest = new AlertFlagManageRequest();
			flagRequest.setAlertId(alertId);
			flagRequest.setCount(count);
			flagRequest.setPatRecipientId(patientRecipientId);
			flagRequest.setFlagged(request.getParameter("checkbox"));
			flagRequest.setTimeCode(request.getParameter("select"));
			
			manageResponse = alertBC.updateAlertFlagState(flagRequest);
		}
		/*request.setAttribute("AlertDetailsResponse", alertDetailsResponse);*/
		
		if(manageResponse.getErrorInfo().getErrorCode() == AlertErrorInfo.SUCCESS_CODE){
			//RequestDispatcher rd = request.getRequestDispatcher("/AlertDetailServlet?alertId=" + salertId +"&count=" + sCount);
			RequestDispatcher rd = request.getRequestDispatcher("/AlertByUserServlet");
			rd.forward(request, response);
		}
	}

}
