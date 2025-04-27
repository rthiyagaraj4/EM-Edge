<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="eOR.*,eOR.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title><fmt:message key="eOR.PractForConsent.label" bundle="${or_labels}"/></title>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../js/PractForConsent.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<STYLE TYPE="text/css">

	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 	</STYLE>

	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	</script>
</head>
<% 
 String group_by = request.getParameter("group_by"),disp_label;
 if(group_by == null || group_by.equals(""))
		group_by="";
 if(group_by.equals("P"))
	disp_label=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ConsentFormList.label","or_labels");
    //disp_label = "Consent Form List";
 else
   if(group_by.equals("C"))
	disp_label=  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PractitionerList.label","or_labels");
    //disp_label = "Practitioner List"; 
 else
    disp_label = " ";
%>
<body class='CONTENT' onMouseDown='CodeArrest()'; onKeyDown='lockKey()'; onLoad=''>
<form name="formPractForConsentDtl" id="formPractForConsentDtl">
<table border='0' cellspacing='0' cellpadding='3' width="100%" align='center'>
<tr><td colspan='2' class='labelleft'><%=disp_label%></td></tr>
<tr></tr>
	<tr>
		<td colspan='2' align='left'>
			<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
				<tr>
					<td align="center" id="SelectTab" class="clicked" width="15%" height="20"><a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
					<td align="center" id="AssociateTab" class="normal" width="15%" height="20"><a href='javascript:dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
				</tr>
			</table>
		</td>
	</tr> 
	<br>
<tr>
	<td colspan='2' align='left' name='linkId' id='linkId' class="COMMONTOOLBARFUNCTION">
	<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
	</td>
</tr>
</table>
<input type="hidden" name="tabVal" id="tabVal" value="">
</form>
</body>
</html>

