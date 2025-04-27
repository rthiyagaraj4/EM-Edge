<!DOCTYPE html>
<%
/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
%>
<%-- Mandatory declarations start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	

called_from=request.getParameter("called_from");
function_from=request.getParameter("function_from");
 if (called_from==null||called_from.equals("null")||called_from=="")
 if (function_from==null||function_from.equals("null")||function_from=="")

	
	if(function_from!=null)
	{
		if(function_from.equals("EXTERNAL_ORDER")) 
		{ 
			existing_bean_id 		= "Or_ExternalOrders";
			existing_bean_name		= "eOR.ExternalOrdersBean";
			ExternalOrdersBean external_bean_obj		= (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;

			
			if(called_from.equalsIgnoreCase("OH"))
			{
				
				external_bean_obj.setLanguageId(localeName);
				
				external_bean_obj.setPatientId(request.getParameter("patient_id"));
				external_bean_obj.setFacilityId(request.getParameter("facility_id"));
				external_bean_obj.setPractitionerId(request.getParameter("practitioner_id"));
				external_bean_obj.setOrderCategory("OH");
				external_bean_obj.setOrderType(request.getParameter("order_type_code"));
				external_bean_obj.setOrderCatalogCode(request.getParameter("p_order_catalog_code"));
				
				putObjectInBean(existing_bean_id,existing_bean_name,request);
			}
		}
	}
	

String title = request.getParameter("title");
if (title == null) title = "";
%>
<head><title><%=(title.equals("")) ?  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderEntry.label","or_labels"):(title)%></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
	<iframe name="orderMainTab" id="orderMainTab" 		src= "../../eOR/jsp/OrderEntryCommonTabsSingle.jsp?<%=request.getQueryString()%>" framespacing="0" 		noresize frameborder="0"  scrolling="no" style="height:6vh;width:100vw"></iframe>
		<iframe name="orderDetailFrame" id="orderDetailFrame" 	src= "../../eCommon/html/blank.html" framespacing="0"	 	noresize frameborder="0"  scrolling="no" style="height:94vh;width:100vw"></iframe>
		

	
</form>
</html>

