<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations start --%>
 <%-- Mandatory declarations end --%>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to 	the bean to get the connection if using the query bean and not the functional bean 
	String bean_id = "OrderEntryIPDischargeBean" ;
	String bean_name = "eOR.OrderEntryIPDischargeBean";
	OrderEntryIPDischargeBean Orderables = (OrderEntryIPDischargeBean)getBeanObject( bean_id,bean_name,request) ;
	Orderables.setLanguageId(localeName);
%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String episode_id=request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
	String episode_visit_num=request.getParameter("episode_visit_num")==null?"":request.getParameter("episode_visit_num");
	String source_type=request.getParameter("source_type")==null?"":request.getParameter("source_type");
	String source_code=request.getParameter("source_code")==null?"":request.getParameter("source_code");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String login_user= (String) session.getValue( "login_user") ;
	String new_dis_adv_srl_no=request.getParameter("new_dis_adv_srl_no")==null?"":request.getParameter("new_dis_adv_srl_no");
	String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
	String dischargeaction=request.getParameter("dischargeaction")==null?"C":request.getParameter("dischargeaction"); // /*C/A*/
	String facility_id = (String)session.getValue("facility_id");
	String sysdate=(String)Orderables.getSysDate1();
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String patient_class="IP";

	patient_id="N200000185";
	encounter_id="100131380001";
	episode_id="10013138";
	order_catalog_code="BILLMONCHR";
	episode_visit_num="1";
	source_type="C";
	source_code="CARD";
	String order_catalog_nature=(String)Orderables.getCatalogNature(order_catalog_code);
	String order_catalog_desc="";
	//if(!catalog_nature.equals("S"))
	order_catalog_desc=(String)Orderables.getCatalogDesc(order_catalog_code);

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	</link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryIPDischarge.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM name="OrderEntryIPDischargeDetail" id="OrderEntryIPDischargeDetail" METHOD=POST ACTION="">
	<table cellpadding=3 cellspacing=0 border=0 width="100%" id="tableheader" class="grid">
	<tr><td class="columnheader" colspan="4"><fmt:message key="eOR.OrderCatalogs.label" bundle="${or_labels}"/></td></tr>
	<tr><td>
	<%
	if(order_catalog_nature.equals("S"))
	{%>
		<fmt:message key="eOR.OrderSet.label" bundle="${or_labels}"/>:
	<%
	}
	%>
	<%=order_catalog_desc%></td></tr>
	<%
	if(order_catalog_nature.equals("S"))
	{
		ArrayList careset=Orderables.getCareSetCatalogDesc(order_catalog_code);
		if(careset.size()>0)
		{
			for(int i=0;i<careset.size();i++)
			{
		%>
			<tr><td><%=careset.get(i)%></td></tr>
		<%
			}
		}
	}
	%>

	<input type="hidden" name="order_catalog_code" id="order_catalog_code" value="<%=order_catalog_code%>">
	<input type="hidden" name="order_catalog_nature" id="order_catalog_nature" value="<%=order_catalog_nature%>">
	<input type="hidden" name="mode" id="mode" value="1">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="sysdate" id="sysdate" value="<%=sysdate%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="episode_id" id="episode_id" value="<%=episode_id%>">
	<input type="hidden" name="episode_visit_num" id="episode_visit_num" value="<%=episode_visit_num%>">
	<input type="hidden" name="source_type" id="source_type" value="<%= source_type%>">
	<input type="hidden" name="source_code" id="source_code" value="<%= source_code%>">
	<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%= practitioner_id%>">
	<input type="hidden" name="new_dis_adv_srl_no" id="new_dis_adv_srl_no" value="<%= new_dis_adv_srl_no%>">
	<input type="hidden" name="dischargeaction" id="dischargeaction" value="<%= dischargeaction%>">
	</table>
	<%putObjectInBean(bean_id,Orderables,request);%>
</FORM>
</BODY>
</HTML>

