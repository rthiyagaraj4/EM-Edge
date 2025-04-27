<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page  import="eCommon.XSSRequestWrapper " %>

<html>
<head>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/Tabs.css'></link>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<%
String mode = request.getParameter("mode");
//System.out.println("mode...."+mode);
String currentview="ALL";
%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eOR/js/PrivilegeGroup.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<script>
function ChangeTabClass(obj,tabName){
	
	document.getElementById("OrderingTab").className = "normal" ;
		
	//document.getElementById("ViewingTab").className = "normal";

	document.getElementById("AuthorizingTab").className = "normal";

	/*document.getElementById("SplApprovingTab").className = "normal" ;

	document.getElementById("CoSigningTab").className = "normal" ;

	document.getElementById("ResultingTab").className = "normal" ;

	document.getElementById("ConsentTab").className = "normal" ;

	document.getElementById("RecordingTab").className = "normal" ;
	
	document.getElementById("SelectTab").className = "normal" ;
	
	document.getElementById("AssociateTab").className = "normal" ;*/

	obj.className = "clicked";
}
</script>

<% if(sStyle!=null && sStyle.equals("IeStyle.css")) { %>
<STYLE TYPE="text/css">
	A:active { 	COLOR: black; }
	A:visited { COLOR: black; }
	A:link { COLOR: black; }
</STYLE> 
<%	} %>
</head>
	
<body topmargin="0" onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="tab" id="tab">
<table border="1" width="100%" height='100%' cellspacing="1" cellpadding="3" align='center'>
<tr>
<td  id="SelectTab" name="SelectTab" class="clicked" width="15%" height="20" onClick='display("select");ChangeTabClass(this,"select");' nowrap><a href='#'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
<td  id="AssociateTab" name="AssociateTab" class="normal" width="15%" height="20" onClick='display("Associate");ChangeTabClass(this,"Associate");' nowrap><a href='#'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
<td colspan='6' style="border:0px;"></td>
</tr>

<tr id='viewtabs' name='viewtabs' style='Visibility:visible'>
		
		<td  id="OrderingTab" name="OrderingTab" class="normal" width="12%" height="20" onClick='display("OR");ChangeTabClass(this,"OR")' nowrap><a href='#'><fmt:message key="Common.Ordering.label" bundle="${common_labels}"/></a></td>
		<!-- 
			Modified by Kishore kumar N on Aug-17-09, for the CRF 641
		-->
		<!-- <td  id="ViewingTab" class="normal" width="12%" height="20" onClick='display("VW");ChangeTabClass(this,"VW")' nowrap><a href='#'><fmt:message key="eOR.Viewing.label" bundle="${or_labels}"/></a></td> -->
		<td  id="AuthorizingTab"  name="AuthorizingTab" class="normal" width="12%" height="20" onClick='display("AU");ChangeTabClass(this,"AU")' nowrap><a href='#'><fmt:message key="eOR.Authorizing.label" bundle="${or_labels}"/></a></td>
		<!-- <td  id="SplApprovingTab" class="normal" width="12%" height="20" onClick='display("SA");ChangeTabClass(this,"SA")' nowrap><a href='#'><fmt:message key="eOR.Spl-Approving.label" bundle="${or_labels}"/></a></td>
		<td  id="CoSigningTab" class="normal" width="12%" height="20" onClick='display("CS");ChangeTabClass(this,"CS")' nowrap><a href='#'><fmt:message key="eOR.Co-Signing.label" bundle="${or_labels}"/></a></td>
		<td  id="ResultingTab" class="normal" width="12%" height="20" onClick='display("RR");ChangeTabClass(this,"RR")' nowrap><a href='#'><fmt:message key="eOR.Resulting.label" bundle="${or_labels}"/></a></td>
		<td  id="ConsentTab" class="normal" width="12%" height="20" onClick='display("CN");ChangeTabClass(this,"CN")' nowrap><a href='#'><fmt:message key="Common.Consent.label" bundle="${common_labels}"/></a></td>
		<td  id="RecordingTab" class="normal" width="12%" height="20" onClick='display("RC");ChangeTabClass(this,"RC")' nowrap><a href='#'><fmt:message key="eOR.Recording.label" bundle="${or_labels}"/></a></td> -->
	<!-- ends here. -->
		
</tr>

</table>

<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type=hidden name="mode" id="mode" value='<%=mode%>'>
<input type=hidden name="currentview" id="currentview" value='<%=currentview%>'>
<%if(mode.equals("2")){%>
<script>
display("Associate");
document.getElementById("AssociateTab").className = "clicked" ;
document.getElementById("SelectTab").className = "normal" ;
</script>
<%}else{%>
<script>
displayOnStart("OR");
ChangeTabClass("OrderingTab","OR");
</script>
<%}%>
</form>
</body>
</html>

