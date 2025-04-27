<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page import ="eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	String filter_group = request.getParameter("Filter_group_code");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<HTML>
<HEAD>
<link rel='StyleSheet' href='${pageContext.request.contextPath}/eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>

<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/common.js'> </Script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eXH/js/FilterCriteriaSettings.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eXH/js/Validate.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eCommon/js/CommonLookup.js"></Script>
<script src='${pageContext.request.contextPath}/eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script type='text/javascript'>//<![CDATA[ 
$(window).load(function(){
/**
 * Stop the backspace key from acting like the Back button
 */
$('textarea[readonly]').keydown(function(event) {
    if (event.which === 8) {
        event.preventDefault();
    }
});

});//]]>  

</script>



</HEAD>
<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="criteriaSettingsInit()">
<FORM ID="FilterCriteriaSettings" name="FilterCriteriaSettings" id="FilterCriteriaSettings" TARGET='messageFrame' METHOD="post" ACTION='../servlet/eXH.FilterCriteriaSettingsServlet'>
<TABLE CELLSPACING="10" ALIGN="CENTER">
	<TR>
		<TD>
			<INPUT class="BUTTON" TYPE="button" VALUE="(" TITLE="Add Left bracket to filter criteria" onClick="addLeftBracket()">
		</TD>
		<TD CLASS='fields'>
			<SELECT ID="criteriaElement" name="criteriaElement" id="criteriaElement" onChange="criteriaElementChange()">
			<OPTION VALUE="" SELECTED>Select</OPTION>
				<c:forEach items="${criteriaElementList}" var="currentElement">
					<OPTION VALUE=${currentElement.key}>${currentElement.value}</OPTION>
				</c:forEach>
			</SELECT>
		</TD>
		<TD CLASS='fields'>
			<SELECT ID="operator" name="operator" id="operator" onChange="operatorChange()">
				<OPTION VALUE="" SELECTED></OPTION>
				<c:forEach items="${operatorList}" var="currentOperator">
					<OPTION VALUE="${currentOperator}">${currentOperator}</OPTION>
				</c:forEach>
			</SELECT>
		</TD>
		<TD CLASS='fields'>
			<SELECT ID="filterValues" name="filterValues" id="filterValues">
				<OPTION VALUE="" SELECTED>Select</OPTION>
			</SELECT>
			<SELECT ID="filterValuesBTWN" name="filterValuesBTWN" id="filterValuesBTWN" STYLE="display:none">
			</SELECT>
		</TD>
		<TD>
			<INPUT class="BUTTON" TYPE="button" VALUE=")" TITLE="Add Right bracket to filter criteria" onClick="addRightBracket()">
		</TD>
		<TD CLASS='fields'>
			<SELECT ID="logicOperator" name="logicOperator" id="logicOperator">
				<OPTION VALUE="" SELECTED>Operator</OPTION>
				<OPTION VALUE=" AND ">AND</OPTION>
				<OPTION VALUE=" OR ">OR</OPTION>
			</SELECT>
		</TD>
		<TD>
			<INPUT class="BUTTON" TYPE="button" name="ADD_FILTER" id="ADD_FILTER" VALUE="Add to Filter" onClick="addFilterCriteria()">
		</TD>
	</TR>
</TABLE>
<TABLE CELLSPACING="10" ALIGN="CENTER">
	<TR>
		<TD CLASS='fields'>
			<TEXTAREA ID="guiFilterSyntax" NAME="guiFilterSyntax" ROWS="6" COLS="50" READONLY></TEXTAREA>
		</TD>
	</TR>
	<TR>
		<TD>
			<INPUT class="BUTTON" TYPE="button" name="CLEAR_FILTER" id="CLEAR_FILTER" VALUE="Clear Filter" onClick="clearFilterCriteria()">
			<INPUT class="BUTTON" TYPE="button" name="SAVE_FILTER" id="SAVE_FILTER" VALUE="Save" onClick="saveFilterCriteria()">
		</TD>
	</TR>
</TABLE>

<INPUT TYPE="HIDDEN" ID="filterGroupCode" name="filterGroupCode" id="filterGroupCode" VALUE=${param.filterGroupCode}>
<INPUT TYPE="HIDDEN" ID="processingFilterSyntax" name="processingFilterSyntax" id="processingFilterSyntax">
<INPUT TYPE="HIDDEN" ID="requestType" name="requestType" id="requestType" VALUE="SAVE_FILTER">
<INPUT TYPE="HIDDEN" ID="dependantCriteriaDtlsJSON" name="dependantCriteriaDtlsJSON" id="dependantCriteriaDtlsJSON" VALUE="{}">

</FORM>	
</BODY>
</HTML>

