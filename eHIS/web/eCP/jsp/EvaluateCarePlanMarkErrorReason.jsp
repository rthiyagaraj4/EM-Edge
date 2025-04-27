<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Vinay.
*	Created On		:	05 jul 2005
--%>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCP.MarkEvaluationError.label" bundle="${cp_labels}"/></title>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonCalendar.js" type="text/javascript" ></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript" ></script>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/EvaluateCarePlanMarkError.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body OnMouseDown='CodeArrest()'>
<form name="eval_cp_mrk_err_rsn_form" id="eval_cp_mrk_err_rsn_form" method="post" target="blanFrame" action="../../servlet/eCP.EvaluateCarePlanMarkErrorServlet">
<%
String md_plan_id = request.getParameter("md_plan_id");
String care_plan_id = request.getParameter("care_plan_id");
String eval_id = request.getParameter("eval_id");
String error_remarks = request.getParameter("error_remarks");
String mode = request.getParameter("mode");
String readOnly = "";
if(mode.equals("textmsg"))
{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String sql = "select status_remarks from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ? and eval_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,md_plan_id);
		pstmt.setString(2,care_plan_id);
		pstmt.setString(3,eval_id);
		rs = pstmt.executeQuery();
		if(rs!=null)
		{
			if(rs.next())
			{
				error_remarks = rs.getString("status_remarks")==null?"":rs.getString("status_remarks");
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch (Exception e)
	{
		//out.println(e.toString());//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
	readOnly = "readOnly";
}
%>
<table border="0" cellpadding="5" cellspacing="0" width="100%" align='center'>
	<tr>
		<td align='left' class='label'><B><fmt:message key="Common.ErrorRemarks.label" bundle="${common_labels}"/>
</B><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<tr>
		<td align='right'>&nbsp;&nbsp;<TEXTAREA NAME="mrk_reason" ROWS="10" COLS="50" onblur="checkForMax(this)" onkeypress="return notallowenter(event)" <%=readOnly%> ><%=error_remarks%></TEXTAREA>&nbsp;&nbsp;</td>
	</tr>
<%
if(!mode.equals("textmsg"))
{
%>
	<tr>
		<td align="right"><INPUT class="button" TYPE="button" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick="record()"><INPUT TYPE="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="button" onclick="winclose()">
		</td>
	</tr>
<%
}
else
{
%>
	<tr>
		<td align="right"><INPUT TYPE="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class="button" onclick="winclose()">
		</td>
	</tr>
<%
}
%>
	<tr>
		<td align='left' class='label'>&nbsp;</td>
	</tr>
</table>
<INPUT TYPE="hidden" name="md_plan_id" id="md_plan_id" value="<%=md_plan_id%>">
<INPUT TYPE="hidden" name="care_plan_id" id="care_plan_id" value="<%=care_plan_id%>">
<INPUT TYPE="hidden" name="eval_id" id="eval_id" value="<%=eval_id%>">
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
</form>
</body>
</head>
</html>

