<!DOCTYPE html>

  
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>                                
<%
    request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");

	String	bean_id			=	"DispMedicationAllStages" ;
	String	bean_name		=	"ePH.DispMedicationAllStages";
	
	DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request ) ;
	//bean.setLanguageId(locale);

	String	bean_id_1		=	"DispMedicationBean" ;
	String	bean_name_1		=	"ePH.DispMedicationBean";
	
	DispMedicationBean bean_1	= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1,request);

	String module_id	=	bean.getModuleId();
	String params		=	request.getQueryString() ;
	String from			=	request.getParameter("source");
	String title		=	"";
	Hashtable legend	=	bean_1.getLegendsFromParam();

	if(from.equals("Alloc")) {
		if(legend.containsKey("A"))
			title	=	(String)legend.get("A")+ " / Re"+((String)legend.get("A")).toLowerCase();
	}
	else if(from.equals("Fill")) {
		if(legend.containsKey("F"))
			title	=	(String)legend.get("F")+" / Re"+((String)legend.get("F")).toLowerCase();
	}
/*
	if(module_id.equals("2")) 
		title		=	title;
	else if(from.equals("Fill"))
		title	=	"Fill Drugs";
	else if(from.equals("Alloc"))
		title	=	"Allocate Drugs";
*/	

%>

<head>                                
	<%
	 
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhMessages.js"></SCRIPT> -->
<title><%=title%></title>

</head>     
<% 
if(module_id.equals("1")) {	%>
<frameset cols="58%,42%" framespacing="2" >
		<frameset rows="10%,79%,6%" framespacing="0">
		<frame name="f_title1" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationAllocateDrugsTitle.jsp">
		<frame name="f_drug_detail" src="../../ePH/jsp/DispMedicationAllocationDetails.jsp?<%=params%>" frameborder="0" noresize scrolling="auto">
		<frame name="f_buttons1" src="../../ePH/jsp/DispMedicationAllocationButtons.jsp?<%=params%>&called_frm=init" frameborder="0" noresize scrolling="no">
		</frameset>
		<frameset rows="10%,84%,6%" framespacing="0">
		<frame name="f_title2" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationAllocateEntryTitle.jsp?<%=params%>">
		<frame name="f_drug_entry" src="../../eCommon/html/blank.html" noresize scrolling="auto" class="CATHIRDWORKAREA">
		<frame name="f_buttons2" src="../../eCommon/html/blank.html"  noresize scrolling="no">
		</frameset>
</frameset>
<%	}	else	{	%>
<frameset rows="60%,40%" framespacing="3">
	<frameset cols="65%,35%" framespacing="3" frameborder="0">
		<frameset rows="10%,76%,9%" framespacing="0">
			<frame name="f_title1" scrolling="no" noresize src="../../ePH/jsp/DispMedicationAllocateDrugsTitle.jsp?<%=params%>">
			<frame name="f_drug_detail" src="../../ePH/jsp/DispMedicationAllocationDetails.jsp?<%=params%>"  noresize scrolling="auto">
			<frame name="f_drug_buttons" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" >
		</frameset>
		<frame name="f_stock_dtls" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html">
	</frameset>

	<frameset rows="30%,61%,9%" framespacing="0">				
				<frame name="f_batch_title" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html">
				<frame name="f_drug_entry" src="../../eCommon/html/blank.html" noresize scrolling="auto" class="CATHIRDWORKAREA" frameborder="0">
				<frame name="f_buttons" src="../../eCommon/html/blank.html"  noresize scrolling="no" frameborder="0">
	</frameset>
</frameset>
<%	}	%>

</html>
<%
//putObjectInBean(bean_id,bean,request);
//putObjectInBean(bean_id_1,bean_1,request);
%>

