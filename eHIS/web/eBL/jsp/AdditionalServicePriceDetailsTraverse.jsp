<!DOCTYPE html>
<!-- Added By Rajesh varadharajan to Show the Next / Previous Links -->

<%@page import="java.net.URLDecoder"%>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String next = request.getParameter("next");
	String previous = request.getParameter("previous");
	String service_ind				=	request.getParameter("serviceIndicator");
	String service_code				=	request.getParameter("serviceCode");
	String price_code				=	request.getParameter("priceCode");
	String service_description		=	decodeParam(request.getParameter("serviceDescription"));
	String price_ind				=	request.getParameter("priceInd");
	String price_description		=	decodeParam(request.getParameter("priceDescription"));
	String billing_class			=	request.getParameter("billingClass");
	String Effective_from			=	request.getParameter("EffectiveFrom");
	String Effective_to				=	request.getParameter("EffectiveTo");
	String charge_type				=	request.getParameter("chargeType");
	String disc_applicability		=	request.getParameter("discApplicability");
	String Desc						=	request.getParameter("Description");
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
<script language="JavaScript" src="../../eBL/js/AdditionalServiceDetailsScript.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src='../../eXH/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body>
	<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
		<tr >
			<th align="left" class="columnheader" >Price Details</th>
		</tr>		
	</TABLE>
	
	<table width='100%'>
		<tr>
			<td width='30%'>&nbsp;</td>
			 <td width='7%' align="right">
			 <input type="button" class='button' name="add_mod" id="add_mod"	id="add_mod"   value="Add" onclick="goAdd();"  />
			</td>
			<td width='7%' align="right">
				<% if("Y".equals(previous)){
				%>
					<a href='javascript:goNext("<%=service_ind %>","<%=service_code %>","<%=service_description %>","<%=price_ind %>","<%=price_code %>","<%=price_description %>",
					"<%=billing_class %>","<%=Effective_from %>","<%=Effective_to %>","<%=charge_type %>","<%=disc_applicability %>",
					"<%=Desc %>","<%=(fromRcrd-constcnt) %>","<%=(toRcrd-constcnt) %>")'>Previous</a>
				<%}
				else{
					out.println("&nbsp;");
				}
				%>
			</td>
			<td  width='7%' align="right">
				<% if ("Y".equals(next)){
				%>
					<a href='javascript:goNext("<%=service_ind %>","<%=service_code %>","<%=service_description %>","<%=price_ind %>","<%=price_code %>","<%=price_description %>",
					"<%=billing_class %>","<%=Effective_from %>","<%=Effective_to %>","<%=charge_type %>","<%=disc_applicability %>",
					"<%=Desc %>","<%=(fromRcrd+constcnt) %>","<%=(toRcrd+constcnt) %>")'>Next</a>
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
	</table>	
</body>
<%!
private String decodeParam(String input){
	String output = "";
	if(input == null || "null".equals(input)){
		output = "";
	}
	else{
		output = URLDecoder.decode(input);
	}
	return output;
}
%>
</html>

