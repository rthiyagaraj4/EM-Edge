<!DOCTYPE html>
<!--saved on 27th Oct 2005 -->
<%@page contentType="text/html; charset=UTF-8" import="eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028
---------------------------------------------------------------------------------------------------------------
*/ %>
<html>
<head>
   <!--  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
  <% 
  request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

	String generic_id	=	request.getParameter("generic_id"); 
	String title		=	request.getParameter("title");
	String called_from	=	CommonBean.checkForNull(request.getParameter("called_from"));//Added for Bru-HIMS-CRF-072.1[IN 049144]
	if(!called_from.equals("MediPlan"))//Added for Bru-HIMS-CRF-072.1[IN 049144]
		called_from="diagnosis";
	if(title == null)	title = "";
	String called_frm	=	request.getParameter("called_frm");
	if(called_frm == null)	called_frm = "";
	String title_desc	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CurrentMedication.label", "ph_labels");
	//"Current Medication";
	
	if(called_frm.equals("OT")){
		title_desc		= title;
	}else {
		if(generic_id!=null && !generic_id.equals(""))
			title_desc	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DuplicateMedication.label", "ph_labels");
		//"Duplicate Medication";
	}
%>
	 

	<title><%=title_desc%></title>
 </head>
 <%
 String params = request.getQueryString() ;
 %>
	<iframe name="f_active_order_details" id="f_active_order_details" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionActiveOrderDetails.jsp?<%=params%>" style="height:85vh;width:99vw"></iframe>
	<iframe name="f_close_frame" id="f_close_frame" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionClose.jsp?called_from=<%=called_from%>&<%=params%> "style="height:9vh;width:99vw"></iframe>
</html>


