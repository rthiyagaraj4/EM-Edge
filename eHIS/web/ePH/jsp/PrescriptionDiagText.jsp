<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<TITLE><fmt:message key="ePH.DiagnosisText.label" bundle="${ph_labels}"/></TITLE>
</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String classValue		=	"";
	String patient_id		= request.getParameter( "patient_id" ) ;
	String encounter_id		= request.getParameter( "encounter_id" ) ;
	String called_frm		= request.getParameter( "called_frm" ) ;
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	ArrayList	diag_text	=	new ArrayList();
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);

	if(called_frm.equals("Header"))
		diag_text				=  bean.getDiagText();
	else {

		String diag_det			=   java.net.URLDecoder.decode(called_frm,"UTF-8");

		StringTokenizer diag	=	new StringTokenizer(diag_det,"~");
		
		while(diag.hasMoreTokens()) {
		String txt	=	(String)diag.nextToken();
		diag_text.add("");
		diag_text.add("");
		diag_text.add("");
		diag_text.add(txt);
		}


	}
%>
<FORM name="PrescriptionDiagForm" id="PrescriptionDiagForm" ><BR>
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="90%" ALIGN="center" BORDER="1">
<%  int incr=0;
for(int i=0; i<diag_text.size(); i+=4) { 

	if(incr%2==0) 
		classValue	=	"QRYEVEN";
	else
		classValue	=	"QRYODD";

	String diag_desc	=	(String)diag_text.get(i+3);

	if(!diag_desc.equals("")) {
%><TR>
	<td class="<%=classValue%>" width="3%"  ><b>&nbsp;&nbsp;.&nbsp;</b></td>
	<td class="<%=classValue%>" width="97%"  ><%=diag_desc%></td>
		</TR>
<%	}incr++;
	}	%>
</TABLE>
</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

