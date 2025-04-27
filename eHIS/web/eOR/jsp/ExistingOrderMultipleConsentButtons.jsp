<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<head>
		<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		 <script language='javascript' src='../../eCommon/js/common.js'></script>
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		 <script language="JavaScript" src="../../eOR/js/ConsentOrder.js"></script>
		 <script language="JavaScript" src="../../eOR/js/ExistingOrder.js"></script>
		 <script language="JavaScript" src="../../eOR/js/OrderEntryToolTip.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

	<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="OrderEntryFormatButtons" id="OrderEntryFormatButtons">
		<table width='100%' height='100%' cellpadding=3 cellspacing=0>
			<tr>
				<td class='button' align='right' colspan='3'>
			<% 
			String viewBy = request.getParameter("viewBy");
			viewBy = (viewBy==null)?"":viewBy;
			String recbutton = request.getParameter("recbutton");
			if(viewBy.equals("line"))
			{
			String consent_form_list = request.getParameter("consent_type");
			consent_form_list = (consent_form_list==null)?"":consent_form_list;
			String total_consents = request.getParameter("total_consents");
			total_consents = (total_consents==null)?"":total_consents;
			 if(recbutton.equals("true")){%>
			<input class="button" type="button" name="record" id="record" onClick='recordDetails("<%=total_consents%>")' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>">
			<input class="button" type="reset" name="cancel" id="cancel" onclick='Windowclose()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" ></td> 
				<%}else  if(recbutton.equals("false")){%>
			<input class="button" type="button" name="close" id="close" onclick='Windowclose()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>"></td> 
			<%}			
			}else if(viewBy.equals("header"))
			{
			String tot_catalogs_avail = request.getParameter("tot_catalogs_avail");
			tot_catalogs_avail = (tot_catalogs_avail==null)?"":tot_catalogs_avail;
			 if(recbutton.equals("true")){%>
			<input class="button" type="button" name="record" id="record" onClick='recordDetailsHdr("<%=tot_catalogs_avail%>")' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>">
			<input class="button" type="reset" name="cancel" id="cancel" onclick='Windowclose()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" ></td> 
				<%}else  if(recbutton.equals("false")){%>
			<input class="button" type="button" name="close" id="close" onclick='Windowclose()' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>"></td> 
			<%}
				}%>
			</tr>
		</table>
	</form>
	</body>
</html>

