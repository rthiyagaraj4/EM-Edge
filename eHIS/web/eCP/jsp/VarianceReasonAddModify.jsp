<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	
*	Created On		:	18th July 2005
-->

<!--OutcomeAddModify.jsp-->

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<HEAD>
<%
//This file is saved on 18/10/2005.
String locale			= (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<SCRIPT src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="javascript" src="../js/VarianceCause.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<br><br><br><br><br><br>
<BODY  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<FORM name='VarianceReasonform' id='VarianceReasonform'  action='../../servlet/eCP.VarianceReasonServlet' method='POST'target='messageFrame'>
<%
String mode=request.getParameter("mode");

Connection connection			=	null;
Statement stmt					=	null;
ResultSet rs					=	null;

String varianceCausesql			=	"SELECT VAR_CAUSE_CODE, VAR_CAUSE_DESC FROM CP_VARIANCE_CAUSE_LANG_VW WHERE EFF_STATUS='E' AND LANGUAGE_ID='"+locale+"'";
String variancereasoncode		=	"";
String variancereasondesc		=	"";
String variancecausecode		=	"";
String tempvariancecausecode		=	"";
String eff_status				=	"";
String varianceselect			=	"";
String enabled					=	"Checked";
String readonly					=	"";
String disabled					=	"";

ArrayList varianceCause			=	new ArrayList();
try{
		connection		=	ConnectionManager.getConnection(request);
		stmt			=	connection.createStatement();
		rs				=	stmt.executeQuery(varianceCausesql);
		if(rs!=null){
			while(rs.next()){
				varianceCause.add(rs.getString("VAR_CAUSE_CODE"));
				varianceCause.add(rs.getString("VAR_CAUSE_DESC"));
			}
		}

}catch(Exception e){
	System.err.println("variance reason"+ e.toString());
	e.printStackTrace();
}finally{
	if(rs!=null)
		rs.close();
	if(stmt!=null)
		stmt.close();
	ConnectionManager.returnConnection(connection,request);

}
if(mode.equals("2")){
	 variancereasoncode		=	request.getParameter("variance_code")==null?"":request.getParameter("variance_code");
	 variancereasondesc		=	request.getParameter("variance_desc")==null?"":request.getParameter("variance_desc");
	 variancecausecode		=	request.getParameter("varianceCausecode")==null?"":request.getParameter("varianceCausecode");
 	 eff_status				=	request.getParameter("eff_status")==null?"":request.getParameter("eff_status");

	if(eff_status.equals("D")){
		enabled			=	"";
		readonly		=	"readonly";
		disabled		=	"disabled";
	}

}

%>
<TABLE cellpadding=0 cellspacing=0 border=0 width="80%" align='center'>
	<TR>
		<TD class="label" colspan="2">&nbsp;</TD>
	</TR>
	<TR>
		<TD align=right class="label" width="12%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></TD>
		<TD align=left >&nbsp;
			<INPUT TYPE="text" name="varianceCode" id="varianceCode" size="6" maxlength="4" <%=readonly%> onKeyPress="return CheckForSpecChars(event);" value="<%=variancereasoncode%>">&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</TD>
	</TR>
	<TR>
		<TD class="label" colspan="2">&nbsp;</TD>
	</TR>
	<TR>
		<TD align=right class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TD>
		<TD align=left >&nbsp;
			<INPUT TYPE="text" name="varianceDesc" id="varianceDesc" size="70" maxlength="60" <%=readonly%> value="<%=variancereasondesc%>">&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</TD>
	</TR>
	<TR>
		<TD class="label" colspan="2">&nbsp;</TD>
	</TR>
	<TR>
		<TD align=right class="label"><fmt:message key="eCP.VarianceCause.label" bundle="${cp_labels}"/></TD>
		<TD align=left >&nbsp;
			<SELECT <%=disabled%> NAME="varianceCause">
			<OPTION value="">&nbsp;&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--
<%
		for(int i=0;i<varianceCause.size();i=i+2){
			tempvariancecausecode=(String)varianceCause.get(i);
			if(variancecausecode.equals(tempvariancecausecode))
				varianceselect="selected";
			else
				varianceselect="";
%>
			<OPTION <%=varianceselect%> value="<%=varianceCause.get(i)%>"><%=varianceCause.get(i+1)%></OPTION>
<%
		}
%>
			</SELECT>
			&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</TD>
	</TR>
	<TR>
		<TD class="label" colspan="2">&nbsp;</TD>
	</TR>
	<TR>
		<TD align=right class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TD>
		<TD align=left >&nbsp;
			<INPUT TYPE="checkbox" <%=enabled%> NAME="eff_status" value="E" onclick="enablestaus(this)">
		</TD>
	</TR>
	<TR>
		<TD class="label" colspan="2">&nbsp;</TD>
	</TR>
</TABLE>
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
</FORM>
</BODY>
</HTML>

