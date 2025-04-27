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
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT> -->
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
String req_dtl="";
String login_by_name= (String)session.getValue( "login_user" );
String mode	= request.getParameter( "mode" ) ;
if(mode==null) mode="";
String Enq_num	= request.getParameter("Enq_num") ;
if(Enq_num==null) Enq_num="";
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	if(!Enq_num.equals("")){

			
		Enq_Dtl =bean.getEnquirerDetails();
	
		Enq_Dtl =bean.getEnquirerDetails();
		replied_by=(String)Enq_Dtl.get(39);
		if(replied_by==null) replied_by="";
		if(!replied_by.equals("")) dis="disabled";
	
req_dtl=(String)Enq_Dtl.get(25);
if(req_dtl == null)req_dtl="";
String enquiry_recd_by =(String)Enq_Dtl.get(26);
if(enquiry_recd_by ==null)enquiry_recd_by="";
login_by_name=enquiry_recd_by;
}
%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name='PhDrugInfoReqForm' id='PhDrugInfoReqForm'>

<TABLE cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
	<TH colspan='6' height='15'>&nbsp;<fmt:message key="ePH.Request/QueryDetails.label" bundle="${ph_labels}"/></TH>
		 <TR>
				<TD colspan="6">&nbsp;</TD>
		</TR> 
		<TR >
				<TD class="label" width="100%" colspan='6'>
				<textArea name="Request_dtl"   rows='6' cols='105' <%=dis%> onkeypress= "ChkMaxLen('Request Details',this,1000,'mode');"><%=req_dtl%></textarea><IMG src="../../eCommon/images/mandatory.gif" align="center"></IMG></TD>
		</TR>
				
			<TR><TD class='label' colspan='6'>&nbsp;&nbsp;&nbsp;</TD></TR>
			<TR>
				<TD class="label" width="23%" colspan='1'>&nbsp;&nbsp;<fmt:message key="ePH.EnquiryReceviedBy.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;
				<TD class="label" width="77%" colspan='5'><label name="enq_receiver"><b><%=login_by_name%>&nbsp;</b></TD>
			</TR>
			<TR><TD class='label' colspan='6'>&nbsp;&nbsp;&nbsp;</TD></TR>
</TABLE>

	
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%=login_by_name%>">
	<INPUT TYPE="hidden" name="display2" id="display2" VALUE="Y">
	
</form>
	

</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

