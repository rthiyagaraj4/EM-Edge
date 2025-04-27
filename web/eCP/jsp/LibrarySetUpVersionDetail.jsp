<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%
<%-- JSP Page specific attributes start --%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- jsp:useBean id="mh" scope="session" class="CommonMultipleHandler" --%>
<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
  <HEAD>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<SCRIPT language="JavaScript" src="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCP/js/LibrarySetUp.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	  </HEAD>
    <BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<FORM name="LibraryVersionDetailForm" id="LibraryVersionDetailForm">
<%
	String finalString=request.getParameter("finalString");
	String mode="";
	String versionno="";
	String createdby="";

	ArrayList list=new ArrayList();
	if(finalString.length()>1){
		StringTokenizer st = new StringTokenizer(finalString,"||");
		 while (st.hasMoreTokens()) {
			 list.add(st.nextToken());
		}
	    if(list.size()>0){
			mode=(String)list.get(0);
		    versionno=(String)list.get(1);
		   createdby=(String)list.get(2);
		}
	}else{
		mode=finalString;
	}

%>
	<!-- Table to display the version Details -->
<TABLE cellpadding=0 cellspacing=0 width="90%" align="center" border="0" id="versionDetails">
<TR><TD colspan="4">&nbsp;</TD></TR>  
<%if(mode.equals("2")){%>
 <TR>
	<TD align="Right" class="label"><fmt:message key="eCP.VersionNo.label" bundle="${cp_labels}"/></TD>
	<TD align="left" class="label" colspan="3">&nbsp;&nbsp;&nbsp;<B><%=versionno%></B></TD>
</TR>
<TR><TD colspan="4">&nbsp;</TD></TR>  
<%}%>
	<TR>
		<TD align="right"  class="label"><fmt:message key="eCP.Guidelines.label" bundle="${cp_labels}"/></TD>
			<TD align="left" colspan="3">&nbsp;&nbsp;
			<TEXTAREA name="version_remarks"  rows="2" cols="50" maxlength="100" onblur="CheckMaxLength1(this,'100');updateObj(this);"></TEXTAREA>
			<IMG src="../../eCommon/images/mandatory.gif"></IMG>
		</TD>
	</TR>
	<%if(mode.equals("2")){%>
	 <TR><TD colspan="4">&nbsp;</TD></TR>  
<TR>
	<TD align="Right" class="label"><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></TD>
	<TD align="left" class="label" colspan="3">&nbsp;&nbsp;&nbsp;<B><%=createdby%></B></TD>
</TR>
<%}%>
		  <TR><TD colspan="4">&nbsp;</TD></TR>  
		<TD align="right"  class="label" ><fmt:message key="Common.status.label" bundle="${common_labels}"/></TD>
		<TD align="left">&nbsp;&nbsp;
			<SELECT name="Status" id="Status" onchange="updateObj(this)">
				<OPTION value="D"><fmt:message key="eCP.Draft.label" bundle="${cp_labels}"/></OPTION>
				<OPTION value="F"><fmt:message key="Common.final.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="I"><fmt:message key="Common.Inactive.label" bundle="${common_labels}"/></OPTION>
		</SELECT>
		</TD>
		<TD align="right"  class="label"><fmt:message key="Common.DependencyLevel.label" bundle="${common_labels}"/></TD>
		<TD align="left">&nbsp;&nbsp;
			<SELECT name="dependency_level" id="dependency_level" onchange="updateObj(this)" maxlength="10">
			<OPTION value=0>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</OPTION>
		<%
	for(int i=1;i<=9;i++){
%>
				<OPTION value="<%=i%>"><%=i%></OPTION>
<%
		}
%>
				</SELECT><IMG src="../../eCommon/images/mandatory.gif"></IMG>
		</TD>
	</TR>
	<TR><TD colspan="4">&nbsp;</TD></TR>
	<TR>
	<TD class="label" align="left"><fmt:message key="eCP.LibraryBasis.label" bundle="${cp_labels}"/></TD>
	<TD align="left" colspan="3">&nbsp;&nbsp;
		<select name="libraryBasis" id="libraryBasis" onchange="updateObj(this)">
				<option value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<option value="C"><fmt:message key="eCP.CaseType.label" bundle="${cp_labels}"/></option>
				<option value="T"><fmt:message key="Common.TerminologyCode.label" bundle="${common_labels}"/></option>
	</select>
	<IMG src="../../eCommon/images/mandatory.gif"></IMG>
	</TR>
		<TR><TD colspan="4">&nbsp;</TD></TR>
	</TABLE>
			<INPUT type="hidden" name="library_id" id="library_id" value="">
	
	</FORM>
		<Script>
			defaultValues('LibraryVersionDetailForm');
		</Script>
</BODY>

</HTML>

