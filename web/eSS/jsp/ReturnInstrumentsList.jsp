<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="alReturnInstrumentsList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eSS/js/ReturnInstruments.js"></script>	
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onMouseDown='CodeArrest();'>
<%
      ReturnInstrumentsListBean bean		=		(ReturnInstrumentsListBean)getBeanObject( "returnInstrumentsListBean", "eSS.ReturnInstrumentsListBean", request ) ;//Moved here from below for TH-KW-CRF-0030
      boolean show_expiry_date = bean.isSiteSpecific("SS","SHOW_EXPIRY_DATE");//Added for TH-KW-CRF-0030
%>
<form name='formReturnInstrumentsList' id='formReturnInstrumentsList' >
	<table border='1' cellpadding='0' cellspacing='0' width='100%'>
			<tr>
			<th width='30'>Del</th>
			<th><fmt:message key="eSS.GroupTrayNoItem.label" bundle="${ss_labels}"/></th>
<%         if(show_expiry_date){//Added for TH-KW-CRF-0030
%>
			<th><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></th><!-- Added for TH-KW-CRF-0030 -->
<%}%>
			<th><fmt:message key="eSS.ReturnQty.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
		</tr>

<%
//	ReturnInstrumentsListBean bean		=		(ReturnInstrumentsListBean)getBeanObject( "returnInstrumentsListBean", "eSS.ReturnInstrumentsListBean", request ) ;//Moved up for TH-KW-CRF-0030
	
	String disabled						=		"";
	HashMap hmRecord					=		new HashMap();
	String className					=		"";
	String doc_type_code				=		request.getParameter("doc_type_code");
	String doc_no						=		request.getParameter("doc_no");

	if(!((doc_no==null)||(doc_type_code==null))){

		disabled						=		bean.isEntryCompleted(doc_type_code,doc_no)?"disabled":disabled;
	}
	int i;

	for	(i	=0;	i<alReturnInstrumentsList.size();i++){

		hmRecord					=		(HashMap)	alReturnInstrumentsList.get(i);
		bean.initialize(hmRecord);
		className					=		((i%2)==0)?"QRYODD":"QRYEVEN";
		String item_code = (String)hmRecord.get("item_code");//Adding start for TH-KW-CRF-0030
		StringTokenizer stItem_code	=	new StringTokenizer(item_code,"|");
		String group_code	=	stItem_code.nextToken();//Adding end for TH-KW-CRF-0030
%>
	<tr>
		<td class="<%=className%>" ><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disabled%>></td>
		<td class="<%=className%>"><%if(disabled.equals("")){%><a href="javascript:listModify(<%=i%>);"><%}%><%=bean.getItem_desc()%></a></td>
<%     if(show_expiry_date){//Added for TH-KW-CRF-0030
%>
		<td class="<%=className%>" ><%=bean.getExpiryDate(group_code)%></td><!-- Added for TH-KW-CRF-0030 -->
<%}%>
		<td class="<%=className%>" ><%=bean.getRet_item_qty()%></td>	<td class="<%=className%>"><%=bean.checkForNull(bean.getInitRemarks(),"&nbsp;")%></td>
	</tr>
<%
}
%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
	<input type="hidden" name="function_id" id="function_id"				value="<%=request.getParameter("function_id")%>">
</form>
</body>
<%
	putObjectInBean("returnInstrumentsListBean",bean,request);
%>

</html>


