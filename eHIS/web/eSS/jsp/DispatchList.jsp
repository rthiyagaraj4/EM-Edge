<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*"contentType="text/html;charset=UTF-8"%>    
<jsp:useBean id="dispatchList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Sudha Krishnadasar">
<%
			request.setCharacterEncoding("UTF-8");
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eSS/js/Dispatch.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown='CodeArrest();'>

<form name='formDispatchList' id='formDispatchList' >
	<table border='1' cellpadding='0' cellspacing='0' width='100%' >
		<tr>
			<th><fmt:message key="eSS.Dispatch.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.DispatchDate.label" bundle="${ss_labels}"/></th>
			
		</tr>
<%
	DispatchListBean bean = (DispatchListBean)getBeanObject( "DispatchListBean",  "eSS.DispatchListBean" ,request) ;  
	

	String disabled				=	"";
	HashMap hmRecord			=	new HashMap();
	String className			=	"";

	int i=0;
	for	(i	=0;	i<dispatchList.size();i++){
		hmRecord	=(HashMap)	dispatchList.get(i);
		bean.initialize(hmRecord);
		className	=	((i%2)==0)?"QRYODD":"QRYEVEN";
		
%>
	<tr>
		<td class="<%=className%>" align='center'><input type='checkbox' name="checkbox<%=i%>" id="checkbox<%=i%>" <%=disabled%> checked></td>
		<td class="<%=className%>" >
		<a href="javascript:listModify(<%=i%>);"><%=bean.getGroup_desc()%></a>
			</td>
		
		<td class="<%=className%>"><%=bean.checkForNull(bean.getTray_no(),"&nbsp;")%></td>
		<%if(locale.equals("en"))
		{%>
 		<td class="<%=className%>" align='center'><%=bean.checkForNull(bean.getDispatch_date(),"&nbsp;")%></td>
		<%} else 
		{%>
				<td class="<%=className%>" align='center'><%=bean.checkForNull(com.ehis.util.DateUtils.convertDate(bean.getDispatch_date(),"DMY","en",locale),"&nbsp;")%></td>
	<%	}%>
	</tr> 
<%
}
%>
	</table>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
</form>
</body>

</html>
<%
	putObjectInBean("DispatchListBean",  bean,request);
%>



