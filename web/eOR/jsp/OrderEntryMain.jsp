<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title><fmt:message key="eOR.OrderEntryMain.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryGlobal.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//	String patient_id			= request.getParameter("patient_id");
//	String encounter_id			= request.getParameter("episode_id");
	String bean_id 				= request.getParameter("bean_id");
	String bean_name 			= request.getParameter("bean_name");
	/* Initialize Function specific start */
	//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean bean			= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */
	String pract_id				= bean.checkForNull(request.getParameter("pract_id"),"");
	String pract_name			= bean.checkForNull(request.getParameter("pract_name"),"");
	String practitioner_type 	= "";
	String bt_module_install	= bean.checkForNull(bean.getModuleInstallYn("BT"),"N");
	String order_mode			= bean.checkForNull(request.getParameter("order_mode"),"");

	bean.setOrderMode(order_mode);
	//Modified by Uma on 3/10/2010 for IN019713
	if(pract_id!="null" && !pract_id.equals("")) //&& !bean.getAmendOrder().equalsIgnoreCase("existing_order"))
	{
	  	bean.setPractitionerId(pract_id);    //Over Writing the Practitioner_id & Practitioner Type
		practitioner_type = bean.getPractType(pract_id.trim());
		bean.setPractitionerType(practitioner_type);
		bean.setPractitionerName(pract_name);
	}
%>
	<!-- <frameset rows="6%,*" framespacing=0>-->
		<iframe name="tabFrame" id="tabFrame" src= "../../eOR/jsp/OrderEntryTab.jsp?<%=request.getQueryString()%>&bt_module_install=<%=bt_module_install%>" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:4vh;width:100vw'></iframe>
		<iframe name="DetailFrame"  id="DetailFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style='height:96vh;width:100vw'></iframe>
		<!--<frame name="DetailFrame" src= "../../eOR/jsp/OrderEntryFrameSet.jsp?<%=request.getQueryString()%>&bt_module_install=<%=bt_module_install%>" framespacing="0" noresize frameborder="0"  scrolling="no"></iframe>-->
	<!-- </frameset>-->
</html>

<%
	// set it back persistence
	putObjectInBean(bean_id,bean,request);

%>

