<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%   request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 			= request.getParameter("bean_id");
	String bean_name 		= request.getParameter("bean_name");
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean 		 = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean bean = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
 
	
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="Javascript" src="../../eCommon/js/common.js"></script>

<script language="Javascript" src="../../eOR/js/OrderEntryTab.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
<%
	//String hdg_name = bean.checkForNull(request.getParameter("hdg_name"),"");
	
	String order_id = bean.checkForNull(request.getParameter("order_id"),"");
	StringBuffer comments = new StringBuffer();
	String clin_cmts_reqd_yn = request.getParameter("clin_cmts_reqd_yn");

	if(clin_cmts_reqd_yn==null)
		clin_cmts_reqd_yn="";
	if(bean.getAmendClinicalComments().length() > 0 )
	{
	 	comments = new StringBuffer();
		comments.append(bean.getAmendClinicalComments());		
	}
	else
	{
	 	comments = new StringBuffer();
		comments.append(bean.getAmendComments(order_id));		
	}
	
%>
<title>
		 <fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>
</title>
</head>
<body style="background-color:#E2E3F0;" OnMouseDown="CodeArrest()"; onKeyDown="lockKey()" onunload="doAmendCloseClinic()"
>
<table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>
	<tr>
		<td  class='label' width='10%'></td>
	</tr>
	<tr>
		<td  width='90%' class='label'><textarea name="comments" id="comments" rows="5" cols="60" maxLength="500" onBlur="makeValidString(this)"><%=comments%></textarea></td>
	</tr>
	<TR>
		<td class='button' align="right">
			<input type='Button' class='Button' name='Ok' id='Ok' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%> ' onclick='doAmendCloseClinic()'>
		</TD>
	</TR>
</table>
<input type="hidden" name="clin_cmts_reqd_yn" id="clin_cmts_reqd_yn" value="<%=clin_cmts_reqd_yn%>">
<input type="hidden" name="commentsadd" id="commentsadd" value="<%=comments%>">
</body>
<%
	comments.setLength(0); //nullifying the objects

	// set it back persistence
	// Only get method is used, not setting again, so need to persist
	//putObjectInBean(bean_id,bean,request);
%>
</html>

