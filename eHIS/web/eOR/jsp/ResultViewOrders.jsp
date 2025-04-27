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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
03/07/2013    IN039857		 Chowminya G    Print Button from result view page for LB order
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
10/05/2017		IN064215		Krishna Gowtham J	10/05/2017		Ramesh G		PMG2017-SH-CRF-0001		
18/07/2018		IN061961		sivabagyam M    	18/07/2018		Ramesh G		GHL-CRF-0433
05/11/2018		IN068986		Ramya Maddena		05/11/2018		Ramesh G		MO-CRF-20137.1
11/06/2019    	        IN070692             sivabagyam	          11/06/2019          Ramesh G		SKR-SCF-1224
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
02/11/2022      35142           Krishna Pranay     03/11/2022      Ramesh G        TH-KW-CRF-0020.6
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%><!--IN070692starts-->
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%@page  import="java.util.*, eOR.*,java.io.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> <!--IN070692ends-->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String orderId = request.getParameter("orderId");
String task_type = request.getParameter("colval1");
String colval = request.getParameter("colval");
String patient_id = request.getParameter("patient_id");
String ord_cat = request.getParameter("ord_cat");
String order_line_num="";
String cont_order_ind=request.getParameter("cont_order_ind");
String pract_reln_id=request.getParameter("pract_reln_id") == null ? "" : request.getParameter("pract_reln_id");
String view_by = request.getParameter("view_by"); //IN064215
String event_code= request.getParameter("event_code");//IN061961
String order_catalog_code = request.getParameter("order_catalog_code");//IN061961
String order_status = request.getParameter("order_status"); //IN068986

String fromFunction=request.getParameter("fromFunction") == null ? "" : request.getParameter("fromFunction");//35142

boolean isSiteSpecific=false;//IN070692
//IN066453 start
String frame_details="26%,0%,*,8%,0%";
if("LB".equals(ord_cat))
	frame_details="30%,0%,*,8%,0%";
//IN066453 end
%>
<!--  IN070692 starts-->
<%
try
{	
	Connection con	=	null;
	con	= ConnectionManager.getConnection();
	isSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","DISP_LB_ORDER_DTLS_INDIV_LVL");
	if(isSiteSpecific)
	{
		order_line_num= request.getParameter("order_line_num");
	}
}catch(Exception eee){
	out.println("Exception in ResultViewOrders.jsp : "+eee.toString());
	eee.printStackTrace();
}	
%>
<!--IN070692 ends  -->
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<title><%=task_type%> - <%=colval%><fmt:message key="Common.Order.label" bundle="${common_labels}"/> </title>
<frameset name='ViewOrderResult' rows='<%=frame_details%>'><!--frameset changed --IN066453-->
	<!--IN064215 start-->
	<!--<frame name='ViewOrderTop' id='ViewOrderTop' src='ResultViewOrderTop.jsp?orderId=<%=orderId%>&order_line_num=<%=order_line_num%>&cont_order_ind=<%=cont_order_ind%>&patient_id=<%=patient_id%>&ord_cat=<%=ord_cat%>&pract_reln_id=<%=pract_reln_id%>' frameborder=0  noresize scrolling='auto'>-->
	
	<frame name='ViewOrderTop' id='ViewOrderTop' src='ResultViewOrderTop.jsp?orderId=<%=orderId%>&order_line_num=<%=order_line_num%>&cont_order_ind=<%=cont_order_ind%>&patient_id=<%=patient_id%>&ord_cat=<%=ord_cat%>&pract_reln_id=<%=pract_reln_id%>&view_by=<%=view_by%>&event_code=<%=event_code%>&order_catalog_code=<%=order_catalog_code%>&fromFunction=<%=fromFunction%>' frameborder=0  noresize scrolling='auto'><!-- 35142 -->
	<!--IN064215 ends-->
	<Frame name='ViewOrderHeader' id='ViewOrderHeader' src='../../eCommon/html/blank.html' FrameBorder='0' scrolling='no' noresize>
	<Frame name='ViewOrderDtl' id='ViewOrderDtl' src='../../eCommon/html/blank.html' FrameBorder='0' scrolling='auto' noresize>
	<!-- <frame name='ViewOrderBtn' id='ViewOrderBtn' src='ResultViewOrderBtn.jsp?orderId=<%=orderId%>&ord_cat=<%=ord_cat%>&order_catalog_code=<%=order_catalog_code%>' frameborder=0 scrolling=auto noresize>--><!--IN039857 included ord_cat -->
	<frame name='ViewOrderBtn' id='ViewOrderBtn' src='ResultViewOrderBtn.jsp?orderId=<%=orderId%>&ord_cat=<%=ord_cat%>&order_catalog_code=<%=order_catalog_code%>&order_line_num=<%=order_line_num%>&view_by=<%=view_by%>&order_status=<%=order_status%>&patient_id=<%=patient_id%>&orderId=<%=orderId%>&event_code=<%=event_code%>' frameborder=0 scrolling=auto noresize><!-- IN061961 --><!-- order_status added for IN068986 --><!-- OREDR ID,EVENT_CODE ADDED FOR 7632 -->
	<frame name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize>
</frameset>

