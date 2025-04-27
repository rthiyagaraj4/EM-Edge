<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ page import="eOR.OrReportsBean" %>
<%-- Mandatory declarations end --%>

<HEAD>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>

	<SCRIPT LANGUAGE="javascript" SRC="../js/OrMasterReport.js"></SCRIPT>
</HEAD>

<%
	/* Mandatory checks start */
	String bean_id = "OrReportsBean" ;
	String bean_name = "eOR.OrReportsBean";

	/* Initialize Function specific start */
	OrReportsBean bean = (OrReportsBean)getBeanObject( bean_id, bean_name, request ) ;
	ArrayList masterList = bean.getMasterList();
	/* Initialize Function specific end*/
%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<FORM name="formORReportsMasterList" id="formORReportsMasterList">
	<BR>
	<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" ALIGN="center" WIDTH="40%">
	<TR>
		<TD WIDTH="30%" ALIGN="right" CLASS="label">Code&nbsp;</TD>
		<TD WIDTH="70%" ALIGN="left">
			<SELECT name="code" id="code" onChange="loadPage(this.value)" >
				<OPTION VALUE="" selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>

<%
		for (int i=0; i<masterList.size(); i+=2) {
%>

				<OPTION VALUE="<%= masterList.get(i) %>"><%= masterList.get(i+1)+":"+masterList.get(i) %></OPTION>

<%
		}
putObjectInBean(bean_id,bean,request);
%>

			</SELECT>
		</TD>
	</TR>
    </TABLE>
</FORM>
</BODY>
</HTML>

