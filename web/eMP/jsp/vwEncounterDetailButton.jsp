<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eMP/js/VwEncounterDetails.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY onKeyDown ='lockKey()' >
<FORM name='vwEncounterDetailButton' id='vwEncounterDetailButton'>
 <TABLE width='100%'>
<TR>
	<TD align='right'><INPUT TYPE="button" class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick='close_me()' ></TD>
</TR>
</TABLE>
</FORM>													
</body>															
</html>

