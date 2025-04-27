
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCA.CAClinicalNotesAutoSaveBean"%>
<%
/*
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------

18/03/2020	  IN071264		Nijitha S	 18/03/2020			Ramesh G	   GHL-CRF-0604
------------------------------------------------------------------------------------------
*/
%>

<%@page import="java.sql.*,java.util.*,eCA.*, java.net.*,webbeans.eCommon.* " contentType="text/html;charset=ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%	

CAClinicalNotesAutoSaveBean autoSaveBean = new CAClinicalNotesAutoSaveBean();
	try{
		request.setCharacterEncoding("UTF-8");
		Hashtable hashObj 			 = (Hashtable)XMLobj.parseXMLString(request);
 		hashObj 					 = (Hashtable)hashObj.get("SEARCH");
		Connection			con			=	null;
		con				=	ConnectionManager.getConnection(request);
		String action 			 = (String)hashObj.get("p_action") == null?"":(String)hashObj.get("p_action");
		String patient_id 			 = (String)hashObj.get("patient_id") == null?"":(String)hashObj.get("patient_id");
		String encounter_id 			 = (String)hashObj.get("encounter_id") == null?"":(String)hashObj.get("encounter_id");
		String note_type 			 = (String)hashObj.get("note_type") == null?"":(String)hashObj.get("note_type");
		String logged_user 			 = (String)hashObj.get("logged_user") == null?"":(String)hashObj.get("logged_user");
	 	if(action.equalsIgnoreCase("DELETE_DRAFT_CLINICAL_NOTES"))  {
	 		
	 		int cnt = autoSaveBean.removedatafromsectionTemp(patient_id,encounter_id,note_type,logged_user,con);
	 		
	 		if(cnt>0){
	 			out.println("SUCCESS");
	 		}
			
		} 
		
	}
	catch(Exception ex){
		ex.printStackTrace();
		System.out.println(" 45. CAClinicalNotesAutoSaveIntermediate.jsp = Message => " + ex.getMessage());
		
	}

%>
