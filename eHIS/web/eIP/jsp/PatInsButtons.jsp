<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");

%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	  
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>       
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eIP/js/IPBkgPatientInstructions.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onKeyDown='lockKey()'>
	<form name='addChkedInstnButton' id='addChkedInstnButton'>	
		<table align='right'>
			<tr>
				<td width='40px'><input type='button' class="BUTTON" name='addchkedInstn' id='addchkedInstn' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onClick="addCheckedInstructions();"></input></td><td align='right'><div id='closeID'><input type='button' class="BUTTON" name='close' id='close' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='cancelCheckedInstructions();'></input></div></td>
			</tr>
		</table>
	</form>
</body>
</html>

