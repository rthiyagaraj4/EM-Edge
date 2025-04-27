<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.util.*,eOR.Common.*,eOR.*"
	contentType="text/html;charset=ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj" scope="page"
	class="webbeans.eCommon.XMLStringParser" />
<%
	try {
		Hashtable hashObj = (Hashtable) XMLobj.parseXMLString(request);
		hashObj = (Hashtable) hashObj.get("SEARCH");
		String l_bean_id = (String) hashObj.get("p_bean_id");
		String l_bean_name = (String) hashObj.get("p_bean_name");
		String l_action = (String) hashObj.get("p_action") == null ? ""
				: (String) hashObj.get("p_action");

		OrderCatalogBean beanObj = (OrderCatalogBean) getBeanObject(
				l_bean_id, l_bean_name, request);

		if (l_action.equalsIgnoreCase("CLEAR_PAT_INSTRN")) {
			beanObj.clearPatInstrnsRecStr();
		}
		else if(l_action.equalsIgnoreCase("CLEAR_MAPPED_FACS"))//IN068370,IN068373, starts
		{
			beanObj.clearMappedFacilities();
		}//IN068370,IN068373, ends
	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>
