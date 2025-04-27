<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
    <TITLE></TITLE>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
   	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ResultReporting.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>function_id = "<%=request.getParameter("function_id")%>";</script>
	<Script>
		function dummy() {
		}
	</Script>
</HEAD>

<%
	/* Mandatory checks start */

	String order_id = request.getParameter("orderId");
	order_id		= (order_id == null) ? "" : order_id.trim();

	String mode	   				= "1";//request.getParameter( "mode" ) ;
	String function_id 			= request.getParameter( "function_id" ) ;

	String bean_id = "Or_RecordProcedure";//request.getParameter("bean_id");
	String bean_name = "eOR.RecordProcedureBean";//request.getParameter("bean_name");

	/* Mandatory checks end */

	/* Initialize Function specific start */

	//RecordProcedureBean bean = (RecordProcedureBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	RecordProcedureBean bean = (RecordProcedureBean)getBeanObject( bean_id, bean_name , request) ;

	bean.setFunctionId(bean.checkForNull(function_id));
	//bean.clear() ;
	bean.setMode( mode ) ;

	ArrayList Orderables = bean.getOrderables(order_id);

	/* Initialize Function specific end */

%>
<Body  style='background-color:#E2E3F0;'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%if( Orderables.size() == 0){ %>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"))</script>
 <%}else{%>
<table cellpadding=0 cellspacing=0 border=0 width="98%" >
<TR><TH>Orderables</TH></TR>
<%
	//String slClassValue = "";
	for(int i=0; i<Orderables.size(); i++)
	{
		String [] record = (String[])Orderables.get(i);
	/*	if(i % 2 == 0) {
			slClassValue = "QRYEVEN";
		} else {
			slClassValue = "QRYODD";}*/%>

		<TR>
			<TD align='center'><font size='1'><A href='javascript:dummy()'><%=record[0]%></A></font></TD>
		</TR>
	<%}
%>
</Table>
<%}%>
<Script>alert('<%=Orderables.size()%>')</Script>
</Body>
</html>

<%
	putObjectInBean(bean_id,bean,request);
%>

