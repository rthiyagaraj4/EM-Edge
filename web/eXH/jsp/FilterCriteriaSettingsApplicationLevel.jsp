<!DOCTYPE html>
<html> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
																	   
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../eXH/js/FilterCriteriaSettings.js" ></script>
<script language="javascript" src="../eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../eCommon/js/jquery-3.6.3.js'></script>
<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script Language="JavaScript">
function funAction(typ)
{
	if(typ=='N')
	{
		var act = '../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?action_type=N';
		this.document.forms[0].action = act;
		this.document.forms[0].target="";
		this.document.forms[0].submit();
	}  
	else
	{
		var act = '../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?action_type=P';
		this.document.forms[0].action = act;
		this.document.forms[0].target="";
		this.document.forms[0].submit();
	}
}  
</SCRIPT>

  
</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="appLevelInit()">
<FORM METHOD="POST" name="dispFilterCriteria" id="dispFilterCriteria">
<TABLE WIDTH="100%">
<TR>
	<TD CLASS='COLUMNHEADER'>Filter Criteria</TD>
</TR>
<c:forEach items="${filterCriterisList}" var="filterCriteria">
<TR>
	<TD CLASS="label"><A HREF="#" onClick="showFilterCriteria(${filterCriteria.key})" ID="filterCriteriaValue${filterCriteria.key}">${filterCriteria.value}</A></TD>
</TR>
</c:forEach>
<TR>
	<TD CLASS='BUTTON'><INPUT TYPE="button" ID="addFilterButton" onClick="addNewFilter()" VALUE="Add New Filter"></TD>
</TR>
</TABLE>

<INPUT TYPE="HIDDEN" ID="filterGroupCode" name="filterGroupCode" id="filterGroupCode" VALUE=${param.filterGroupCode}>

</FORM>
</BODY>
</HTML>

