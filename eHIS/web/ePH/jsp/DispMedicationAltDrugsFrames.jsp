<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>                                
<%
	String params = request.getQueryString() ;
	String drug_desc	=	request.getParameter("drug_desc");
	//drug_desc =java.net.URLDecoder.decode(drug_desc,"UTF-8");
%>
	<head>                                
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<title><fmt:message key="ePH.AlternateDrugsfor.label" bundle="${ph_labels}"/> <%=drug_desc%></title>
	</head>                               
	<iframe name="f_alt_drugs" id="f_alt_drugs" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationAltDrugDetails.jsp?<%=params%>" style="height:92vh;width:100vw"></iframe><iframe name="f_buttons" id="f_buttons" src="../../ePH/jsp/DispMedicationAllocationButtons.jsp?<%=params%>&called_frm=multi" frameborder="0" noresize scrolling="no" style="height:8vh;width:100vw"></iframe>
</html>

