<!DOCTYPE html>
<!-- To Show the Next / Previous Links -->

<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String next = request.getParameter("next");
	String previous = request.getParameter("previous");

	System.out.println("next>>>>>>>>>"+next);
	System.out.println("previous>>>>>>>"+previous);
	next="Y";
	String service_code					=	request.getParameter("service_code");
	String service_class				=	request.getParameter("service_class");
	String billing_service				=	request.getParameter("billing_service");
	String item							=	request.getParameter("item");
	String ent_servGroup				=	request.getParameter("ent_servGroup");
	String ent_GrpLine					=	request.getParameter("ent_GrpLine");
	String from_date					=	request.getParameter("from_date");
	String to_date						=	request.getParameter("to_date");
	String billedYN						=	request.getParameter("billedYN");
	String direct_indirectchgs			=	request.getParameter("direct_indirectchgs");
	String underChrgOnly				=	request.getParameter("underChrgOnly");
			

	int fromRcrd	= 0;	
	int toRcrd		= 0;
	int constcnt	= 0;
	
	try{
		fromRcrd =	Integer.parseInt(request.getParameter("fromRcrd"));
		toRcrd   =	Integer.parseInt(request.getParameter("toRcrd"));
		constcnt = 	Integer.parseInt(request.getParameter("constcnt"));
	}
	catch(Exception e){
		fromRcrd 	= 0;
		toRcrd		= 0;
		constcnt	= 0;
	}
%>
 
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eBL/js/BLChargePatient.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body>
	<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
	<tr >
	<td width='20%' class='COLUMNHEADER' nowrap colspan="8" align="left">
      				<fmt:message key="eBL.SummaryByBillingService.label" bundle="${bl_labels}"></fmt:message> 
      			</td>
	</tr>				
	</TABLE>
	
	<!-- <table width='100%'>
	 	<tr>
			<td width='30%'>&nbsp;</td>
			 <td width='7%' align="right">
			 &nbsp;
			</td>
			<td width='7%' align="right">
				<% if("Y".equals(previous)){
				%>
					<a href='javascript:goNext("<%=service_code %>","<%=service_class %>","<%=billing_service %>","<%=item %>","<%=ent_servGroup %>",
		"<%=ent_GrpLine %>","<%=from_date %>","<%=to_date %>","<%=billedYN %>","<%=direct_indirectchgs %>","<%=underChrgOnly %>",	
		"<%=(fromRcrd-constcnt) %>","<%=(toRcrd-constcnt) %>")'>Previous</a>
				<%}
				else{
					out.println("&nbsp;");
				}
				%>
			</td>
			<td  width='7%' align="right">
				<% if ("Y".equals(next)){
				%>
					<a href='javascript:goNext("<%=service_code %>","<%=service_class %>","<%=billing_service %>","<%=item %>","<%=ent_servGroup %>",
		"<%=ent_GrpLine %>","<%=from_date %>","<%=to_date %>","<%=billedYN %>","<%=direct_indirectchgs %>","<%=underChrgOnly %>",
		"<%=(fromRcrd+constcnt) %>","<%=(toRcrd+constcnt) %>")'>Next</a>
				<%}
				else{
					out.println("&nbsp;");
				}
				%>
			</td>
			<td width='3%'>
			&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
	</table>	 -->
</body>
		
</html>

