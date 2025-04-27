<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*,eCommon.XSSRequestWrapper"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//String consent_form_id= request.getParameter("consent_form_id");
	String new_consent_format_id= request.getParameter("new_consent_format_id");
	if(new_consent_format_id==null) new_consent_format_id = "";
	String new_consent_format_label= request.getParameter("new_consent_format_label");
	if(new_consent_format_label==null) new_consent_format_label = "";

	String cons_form_label  = "", cons_form_id = "";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/ConsentOrder.js"></script>
	<script language="javascript" src="../../eOR/js/ConsentDetails.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<title><fmt:message key="eOR.EditorPreview.label" bundle="${or_labels}"/></title>
</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name="editor_preview_button" id="editor_preview_button" method="post" target="messageFrame">
	<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	 	<tr>		
			<td class=button align='right'>
				<input type="button" class="BUTTON" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='closePreview()'>
				<input type="button" class="BUTTON" name="print" id="print" value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' onClick="printPreview()">
			</td>
	</tr>
	<tr>
		<td class="label">
			<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	 
<%			
 			if(new_consent_format_id!=null && !new_consent_format_id.equals("")) {
				StringTokenizer stFormatId	   = new StringTokenizer(new_consent_format_id,"||");
				StringTokenizer stFormatLabel = new StringTokenizer(new_consent_format_label,"||");
				 while(stFormatId.hasMoreTokens())
				 {

					 cons_form_id		= stFormatId.nextToken();
					 cons_form_label	= stFormatLabel.nextToken();
					 if(cons_form_id==null || cons_form_id.equals("~~")) cons_form_id = "";
					 if(cons_form_label==null || cons_form_label.equals("~~")) cons_form_label = "";
%>
				<!--<tr><td class="label"><font size="1"><A href='javascript:reprintNotes("<%=cons_form_id%>")'><%=((cons_form_label==null||cons_form_label.equals(""))?cons_form_id:cons_form_label)%></a></font></td></tr>-->
<%				  
				}
			}
%>
			</table>
		</td>
		</tr>
 	</table>
<!-- <input type="hidden" name="p_language_id" id="p_language_id" value="<%= localeName %>"> -->
	</form>
	</body>
</html>

