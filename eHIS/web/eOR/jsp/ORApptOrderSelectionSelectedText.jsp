<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
24/08/2013    IN030284		Chowminya G 	Created:To capture Pre-consultation orders in Appointment Scheduling
04/09/2013	  IN043092	    Chowminya G		Schedule Appointment - Day Schedule - Select Order - Order Selection webpage	
13/09/2013    IN030284.1 	Chowminya G 	CRF:To capture Pre-consultation orders in Appointment Scheduling - to handle $ issue (replace $$ with ~~)		
---------------------------------------------------------------------------------------------------------------
-->
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*,java.net.*, java.text.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");
	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	RefusalOrdersBean Orderables = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;
	Orderables.setLanguageId(localeName);

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eOR/js/ORApptOrderSelection.js'></script>

<html>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="OrderSelectedtext" id="OrderSelectedtext">
<%
String from			= request.getParameter("from") ;
String to			= request.getParameter("to") ;
String order_category=(request.getParameter("order_category")==null||request.getParameter("order_category").equals("null"))?"":request.getParameter("order_category");
String order_type_code=(request.getParameter("type_code")==null||request.getParameter("type_code").equals("null"))?"":request.getParameter("type_code");
String appt_ref_no=(request.getParameter("appt_ref_no")==null||request.getParameter("appt_ref_no").equals("null"))?"":request.getParameter("appt_ref_no");
String appt_no=(request.getParameter("appt_ref_no")==null||request.getParameter("appt_ref_no").equals("null"))?"":request.getParameter("appt_ref_no");
String Mode=(request.getParameter("Mode")==null||request.getParameter("Mode").equals("null"))?"":request.getParameter("Mode");
String facilityid=(request.getParameter("facilityid")==null||request.getParameter("facilityid").equals("null"))?"":request.getParameter("facilityid");
String validate=(request.getParameter("validate")==null||request.getParameter("validate").equals("null"))?"":request.getParameter("validate");
String option_id = "";
String short_desc ="";
String order_type_code1 = "";
String order_category1 = "";
String OrderCatalog = "";
int recordCount = 0;
String classValue = "";
//IN043092 - Start
if (from == null ) 
		from = "1" ;  
if (to == null )
		to = "7" ;
//IN043092 - End
ArrayList OrderCatalogData = new ArrayList();
if("".equals(validate))
{
	Orderables.clearObject(); 
	Orderables.clearTempObject();
	Orderables.setflag("");
	ArrayList OrderCatalogData1 = new ArrayList();
	OrderCatalogData1 = Orderables.getSelectedCatalogs(appt_ref_no,facilityid);
	String catalogdb = "";
	for(int i=0;i<OrderCatalogData1.size();i++)
	{
		catalogdb = (String)OrderCatalogData1.get(i);
		if(!Orderables.containsObject(catalogdb))
		{
			//Orderables.putObject(catalogdb);//IN043092
			Orderables.putTempObject(catalogdb);
		}
	}
}

if("View".equals(Mode))
{
	OrderCatalogData = Orderables.getSelectedCatalogs(appt_ref_no,facilityid);
	recordCount			=	OrderCatalogData.size();
}
else
{
	OrderCatalogData = Orderables.getSelectedCatalogs(appt_ref_no,facilityid);
	recordCount			=	OrderCatalogData.size();
	if(recordCount <= 0)
	{
		OrderCatalogData = Orderables.getTempArrayList() ;	
		recordCount			=	OrderCatalogData.size();
	}
}

%>
<div id='divDataTitle' style='postion:relative'>
<table border="1" cellpadding="3" cellspacing="0" width="100%" align='center'>
<tr ><td class='CAGROUP' ><b><font size='2'><fmt:message key="eOR.SelectedOrderables.label" bundle="${or_labels}"/></b></td></tr>
</table>
</div> 
 <table border='1' cellpadding='3' cellspacing='0' width='100%' align='center' id='tableId' class='grid'>
 <tr>
<th class='columnHeadercenter'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnHeadercenter'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<% if(!"View".equals(Mode))
{
%>
<th class='columnHeadercenter'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th></tr>
<%
}
if(recordCount > 0)
{	
	for(int j=0; j<recordCount; j++)
	{
		System.out.println(OrderCatalogData.get(j));
		OrderCatalog = (String)OrderCatalogData.get(j);
		
		StringTokenizer strtData = new StringTokenizer(OrderCatalog,"~~"); //IN030284.1
			   
		while(strtData.hasMoreTokens())
		{   
			option_id= (String) strtData.nextToken();
			short_desc= (String) strtData.nextToken();
			order_type_code1= (String) strtData.nextToken();
			order_category1= (String) strtData.nextToken();
			appt_ref_no= (String) strtData.nextToken();
		}
		if(appt_ref_no.equals(appt_no))
		{	
			classValue="gridData";
%>
<tr>
<td class='<%=classValue%>' ><%=option_id%></td>
<td class='<%=classValue%>' ><%=short_desc%></td>
<% if(!"View".equals(Mode))
{
%>
<td  class='<%=classValue%>' align='center'>
<!--IN030284.1 -->
<input type='checkbox' name="chk<%=j%>" id="chk<%=j%>" checked value="<%=option_id%>~~<%=short_desc%>~~<%=order_type_code1%>~~<%=order_category1%>~~<%=appt_ref_no%>" onclick='getDescription(this,"<%=option_id%>","<%=j%>")'></td></tr>
<%
}
%>
<input type="hidden" name="short_desc<%=j%>" id="short_desc<%=j%>" value="<%=short_desc%>">
<input type="hidden" name="order_type_code1<%=j%>" id="order_type_code1<%=j%>" value="<%=order_type_code1%>">
<input type="hidden" name="order_category1<%=j%>" id="order_category1<%=j%>" value="<%=order_category1%>">
<input type="hidden" name="appt_ref_no<%=j%>" id="appt_ref_no<%=j%>" value="<%=appt_ref_no%>">

<%
	}
	}	
}
%>
		<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id%>'>
		<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name%>'>
		<input type=hidden name='facilityid' id='facilityid' value='<%=facilityid%>'>
		<input type=hidden name='Mode' id='Mode' value='<%=Mode%>'>
		<input type=hidden name='appt_ref_no' id='appt_ref_no' value='<%=appt_ref_no%>'>
		<input type=hidden name='validate' id='validate' value='<%=validate%>'>
		<input type=hidden name='from' id='from' value='<%=from%>'>
		<input type=hidden name='to' id='to' value='<%=to%>'>
</table>
</div>
		
</tr>
</table>
</div>

</form>
</body>
</html>

