<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import=" eSS.*,eSS.Common.*,java.util.*"contentType="text/html;charset=UTF-8" %>  
<jsp:useBean id="alWriteOffGroupList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eSS/js/WriteOffGroup.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eSS/js/SsTransaction.js"></script>	
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
<body onMouseDown="CodeArrest()">
<form name='formWriteOffGroupList' id='formWriteOffGroupList' >
	<table border='1' cellpadding='0' cellspacing='0' width='455' >
<%

	WriteOffGroupListBean bean = (WriteOffGroupListBean)getBeanObject( "WriteOffGroupListBean",  "eSS.WriteOffGroupListBean", request) ;  
	bean.setLoginFacilityId((String)session.getAttribute("facility_id"));
	
	String disabled				=	"";
	HashMap hmRecord			=	new HashMap();
	String className			=	"";
	String doc_type_code		=	request.getParameter("doc_type_code");
	String doc_no				=	request.getParameter("doc_no");

	if(!((doc_no==null)||(doc_type_code==null))){
		disabled=bean.isEntryCompleted(doc_type_code,doc_no)?"disabled":disabled;
	}

	int i;

	for	(i	=0;	i<alWriteOffGroupList.size();i++){
		hmRecord	=(HashMap)	alWriteOffGroupList.get(i);
		bean.initialize(hmRecord);
		className	=	((i%2)==0)?"QRYODD":"QRYEVEN";
%>
	<tr>
		<td  class="<%=className%>" align='center' width='30'><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disabled%>></td>
		<td  width='80' class="<%=className%>"><%if(disabled.equals("")){%><a href="javascript:listModify1(<%=i%>);"><%}%><%=bean.getGroup_type_Text(bean.getGroup_type())%></a></td>
		<td width='100' class="<%=className%>"><%=bean.getDescription()%></td>
		<td width='60' class="<%=className%>" align='right'><%=bean.getTray_no()%></td>
		<td width='150' class="<%=className%>" align='left'><%=bean.getWriteOffReasonDesc()%></td>
	</tr>
<%
}
%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
</form>
<%
putObjectInBean("WriteOffGroupListBean",bean,request);
%>

</body>

</html>


