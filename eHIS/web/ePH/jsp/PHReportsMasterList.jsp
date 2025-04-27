<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
     request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/PHmessages.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	/* Mandatory checks start */
	String bean_id = "PHReportsBean" ;
	String bean_name = "ePH.PHReportsBean";

	/* Initialize Function specific start */
	PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	ArrayList masterList = bean.getMasterList(locale);
	/* Initialize Function specific end*/
%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<FORM name="formPHReportsMasterList" id="formPHReportsMasterList">
	<BR>
	<TABLE BORDER="0" CELLPADDING="0" CELLSPACING="0" ALIGN="center" WIDTH="40%">
	<TR>
		<TD WIDTH="30%" ALIGN="right" CLASS="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</TD>
		<TD WIDTH="70%" ALIGN="left">
			<SELECT name="code" id="code" onChange="loadPage(this.value)" >
				<OPTION VALUE="" selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>

<%
		for (int i=0; i<masterList.size(); i+=2) {
%>

				<OPTION VALUE="<%= masterList.get(i) %>"><%= masterList.get(i+1) %></OPTION>

<%
		}
%>

			</SELECT>
		</TD>
	</TR>
    </TABLE>
</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

