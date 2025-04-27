<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Created by Uma on 6/7/2010 for  SRR20056-SCF-4500 IN021348--%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, eOR.Common.*, eOR.* "%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<% 
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?	
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%
try
{
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id		= (String)hash.get("BEAN_ID");
	String bean_name		= (String)hash.get("BEAN_NAME");
	String l_action = (String)hash.get("ACTION");
	
	OrAdapter bean = (OrAdapter)getBeanObject( bean_id,bean_name, request ) ;

	if("CATALOG_MAP_FACILITIES".equals(l_action))
	{	
		String l_fac_ids = (String)hash.get("FAC_IDS");
		bean.setMappedFacilities(l_fac_ids);
	}
	
	putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	e.printStackTrace();	
}
%>
