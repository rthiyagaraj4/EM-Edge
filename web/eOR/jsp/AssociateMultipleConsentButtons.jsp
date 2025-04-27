<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*,eOR.*,eOR.Common.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
		<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		 <script language='javascript' src='../../eCommon/js/common.js'></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		 <script language="JavaScript" src="../../eOR/js/ConsentOrder.js"></script>
		 <script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
		 <script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="OrderEntryFormatButtons" id="OrderEntryFormatButtons">
		<table width='100%'cellpadding=0 cellspacing=0>
			<tr>
				<td class='button' align='right' colspan='3'>
			<% 
			String buttn_label = request.getParameter("buttn_label");
			String consent_form_list = request.getParameter("consent_form_list");
			consent_form_list = (consent_form_list==null)?"":consent_form_list;
			 if(!consent_form_list.equals("F")){
			
			%>
			<input class="button" type="button" name="record" id="record" value="<%=buttn_label.equals("Consent")?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels"):com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="<%=buttn_label.equals("Consent")?"RecordValues()":"StoreValues()"%>"><input class="button" type="reset" name="reset" id="reset"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>" onClick="parent.multi_detail.document.forms[0].reset();"><%}%><input class="button" type="button" name="cancel" id="cancel"  value="<%=consent_form_list.equals("F")?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels"):com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="window.close()"></td> 
				<!-- <td align='right'class='bodycolorfilled' >
					<input type='button' class='button' value='OK' onClick='recordOrderFormatValues()' name='ok' id='ok' ><input type='button' class='button' value='Cancel' onclick ='removeOrderFormatValues()' name='CANCEL' id='CANCEL' >
				</td> -->
			</tr>
		</table>
	</form>
	</body>
</html>

