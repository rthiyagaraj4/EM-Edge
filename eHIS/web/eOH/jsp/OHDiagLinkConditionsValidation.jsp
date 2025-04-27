<!DOCTYPE html>
<%--
*	Copyright © IBAHealth India (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eOH
*	Purpose 		:	
*	Created By		:	Akhilesh Gupta
*	Created On		:	09May 2008

--%>

<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  language="java" import ="webbeans.eCommon.*,java.util.HashMap,java.util.*"  contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="OHDiagLinkConditionOBJ" class="webbeans.eCommon.RecordSet" scope="session"/> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String checkedOnes = "";
	String total_record	 = checkForNull(request.getParameter("record_count"));
	String click_mode	 = checkForNull(request.getParameter("click_mode"));

	if(click_mode.equals("Close"))
	{
		OHDiagLinkConditionOBJ.clearAll();
	}
	else
	{
		OHDiagLinkConditionOBJ.clearAll();
		for( int i=1; i<=(Integer.parseInt(total_record)); i++)
				{
					checkedOnes = checkForNull(request.getParameter(("link_code_chk"+i)));
					if(checkedOnes.equals("Y"))
					{
						OHDiagLinkConditionOBJ.putObject(checkForNull(request.getParameter(("link_code"+i))));						
					}
				}
	}

	session.setAttribute("OHDiagLinkConditionOBJ", OHDiagLinkConditionOBJ);

%>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


