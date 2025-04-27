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
-----------------------------------------------------------------------
Date       Edit History   Name        	Description
-----------------------------------------------------------------------
?             100         ?           	created
20/03/2013  IN038754	Nijitha S    CRF-CA- CHL-CRF- 0008 /10- Current Medications Widget->NPB Request cannot be done
21/05/2014  IN044502    Chowminya	 Bru-HIMS-CRF-400 
-----------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 	   
 <html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String called_from="";
String function_from="";
String existing_bean_id		= "";
String existing_bean_name	= "";
	//String ext_order_category	= ""; String ext_order_type_code = "";
String p_called_from_widget =request.getParameter("p_called_from_widget");//IN038754
//IN044502 - Start
String query_string = request.getQueryString();
if("CURRENT_MEDICATION".equals(p_called_from_widget))
	query_string = query_string+"&p_called_from_widget="+p_called_from_widget;
//IN044502 - End
called_from=request.getParameter("called_from");
function_from=request.getParameter("function_from");
 if (called_from==null||called_from.equals("null")||called_from=="")
 if (function_from==null||function_from.equals("null")||function_from=="")
//ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER
	
	if(function_from!=null)
	{
		if(function_from.equals("EXTERNAL_ORDER")) 
		{ // Get the Bean Instance of External Orders
			existing_bean_id 		= "Or_ExternalOrders";
			existing_bean_name		= "eOR.ExternalOrdersBean";
			ExternalOrdersBean external_bean_obj		= (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;

			// In case called_from is OH, set the bean values which are actuallyu set in the ExternalOrdersCall.jsp
			if(called_from.equalsIgnoreCase("OH"))
			{
				//set the bean values
				external_bean_obj.setLanguageId(localeName);
				// Set it in bean
				external_bean_obj.setPatientId(request.getParameter("patient_id"));
				external_bean_obj.setFacilityId(request.getParameter("facility_id"));
				external_bean_obj.setPractitionerId(request.getParameter("practitioner_id"));
				external_bean_obj.setOrderCategory("OH");
				external_bean_obj.setOrderType(request.getParameter("order_type_code"));
				external_bean_obj.setOrderCatalogCode(request.getParameter("p_order_catalog_code"));
				//external_bean_obj.setQryString(qryString);
				putObjectInBean(existing_bean_id,existing_bean_name,request);
			}
		}
	}
	//Added by Uma for OH related changes ends here

String title = request.getParameter("title");
if (title == null) title = "";
%>
<head><title><% if(title.equals("")) { %><fmt:message key="eOR.OrderEntry.label" bundle="${or_labels}"/><% } else { %> <%= title %><% } %></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
</head>
	<!--IN038754 Starts-->
	<% if(!"".equals(p_called_from_widget) && null!=p_called_from_widget){%> 
	<!-- <frameset  rows="6%,90%,*%" framespacing=0>-->
	<iframe name="orderMainTab"  id="orderMainTab" 		src= "../../eOR/jsp/OrderEntryCommonTabs.jsp?<%=query_string%>" framespacing="0" 		noresize frameborder="0"  scrolling="no" style='height:5vh;width:99vw ;margin-top:24px'></iframe> <!--IN044502-->
		<iframe name="orderDetailFrame"  id="orderDetailFrame" 	src= "../../eCommon/html/blank.html" framespacing="0"	 	noresize frameborder="0"  scrolling="no" style='height:91vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp'   frameborder=0 scrolling='no'  noresize style='height:9vh;width:100vw'></iframe>
	<%}else{%>
	<!--IN038754 Ends-->
	<!--  <frameset rows="6%,*%" framespacing=0>-->
	<iframe name="orderMainTab"  id="orderMainTab" 		src= "../../eOR/jsp/OrderEntryCommonTabs.jsp?<%=query_string%>" framespacing="0" 		noresize frameborder="0"  scrolling="no" style='height:7vh;width:99vw ;margin-top:0px'></iframe> <!--IN044502-->
		<iframe name="orderDetailFrame"  id="orderDetailFrame" 	src= "../../eCommon/html/blank.html" framespacing="0"	 	noresize frameborder="0"  scrolling="no" style='height:93vh;width:99vw'></iframe>
	<%}%><!--IN038754-->
 		<!--<frame name="orderMainTab" 		src= "../../eOR/jsp/OrderEntryCommonTabs.jsp?<//%=request.getQueryString()%>" framespacing="0" 		noresize frameborder="0"  scrolling="no"></iframe>--><!--IN044502-->
		
		<!--IN038754 Starts-->
		<% if(!"".equals(p_called_from_widget) && null!=p_called_from_widget)
		{%>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp'   frameborder=0 scrolling='no'  noresize style='height:9vh;width:99vw'></iframe>
		<%
		}%>
		<!--IN038754 Ends-->
	<!--  </frameset>-->
	
</form>
</html>
