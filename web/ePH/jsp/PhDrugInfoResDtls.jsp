<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
 <script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<%

ArrayList Enq_Dtl = null;
String replied_by="";
String dis="";
String res_dtl="";
String Enq_num	= request.getParameter("Enq_num") ;
if(Enq_num==null) Enq_num="";
String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	if(!Enq_num.equals("")){
		
		Enq_Dtl =bean.getEnquirerDetails();
		Enq_Dtl =bean.getEnquirerDetails();
		replied_by=(String)Enq_Dtl.get(39);
		if(replied_by==null) replied_by="";
		if(!replied_by.equals("")) dis="disabled";
	
res_dtl=(String)Enq_Dtl.get(36);
if(res_dtl == null)res_dtl="";
	}
%>

<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name='PhDrugInfoResForm' id='PhDrugInfoResForm'>

<TABLE cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
			<TR >
				<TH colspan='4' height='15'><b><fmt:message key="ePH.ResponseDetails.label" bundle="${ph_labels}"/></b></TH>
				
			</TR>
			<TR>
				<TD class="label" width="100%" colspan='4'>&nbsp;<textArea name="Response_dtl"  value="" rows='5' cols='110' <%=dis%> onkeypress= "ChkMaxLen('Response Detail',this,1000,'mode');"><%=res_dtl%></textarea></TD>
			</TR>
			<TR><TD class='label' colspan='4'>&nbsp;&nbsp;&nbsp;</TD>
			</TR>
			<TR>
		<TH colspan='4' height='15'><b><fmt:message key="ePH.InformationSource.label" bundle="${ph_labels}"/></b></TH>
		</TR>
		
</TABLE>


<INPUT TYPE="hidden" name="display4" id="display4" VALUE="Y">
</form>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

