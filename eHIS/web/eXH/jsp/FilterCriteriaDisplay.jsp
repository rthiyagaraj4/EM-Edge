<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	String filter_group = request.getParameter("Filter_group_code");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<HTML>
<HEAD>
<LINK REL='StyleSheet' HREF='../../eCommon/html/<%=sStyle%>' TYPE='text/css'></LINK>

<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/common.js'> </Script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eXH/js/FilterCriteriaSettings.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eCommon/js/CommonLookup.js"></Script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eXH/js/Validate.js'></script>

<TITLE>Filter Criteria</TITLE>

</HEAD>
<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<FORM ID="filterCriteriaDisplay" METHOD=POST ACTION="../../servlet/eXH.FilterCriteriaSettingsServlet">
	<TABLE ALIGN="CENTER">
	<TR>
		<TD CLASS=label>Filter Criteria</TD>
	</TR>
	<TR>
		<TD CLASS="field"><TEXTAREA NAME="filterCriteria" ID="filterCriteria" ROWS="6" COLS="70" READONLY>${param.filterCriteriaValue}</TEXTAREA></TD>
	</TR>
	<TR ALIGN="RIGHT">
		<TD>
			<TABLE>
			<TR>
				<TD CLASS=button><INPUT TYPE="button" VALUE="Delete" onClick="deleteFilterCriteria()"></TD>
				<TD CLASS=button><INPUT TYPE="button" VALUE="Close" onClick="window.close()"></TD>
			</TR>
			</TABLE>
		</TD>
	</TR>
	</TABLE>
<INPUT TYPE="HIDDEN" ID="filterGroupCode" name="filterGroupCode" id="filterGroupCode" VALUE=${param.filterGroupCode}>
<INPUT TYPE="HIDDEN" ID="trxNo" name="trxNo" id="trxNo" VALUE=${param.trxNo}>
<INPUT TYPE="HIDDEN" ID="requestType" name="requestType" id="requestType" VALUE="DELETE_FILTER_CRITERIA">
</FORM>
</BODY>

