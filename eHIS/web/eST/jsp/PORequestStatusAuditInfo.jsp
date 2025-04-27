<!DOCTYPE html>
<%@ page import="eST.PORequestStatusBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/PORequestStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%

		String bean_id						=		"PORequestStatusBean";
		String bean_name					=		"eST.PORequestStatusBean";
		String request_status				=		request.getParameter( "request_status" );
		String added_by_id					=		request.getParameter( "added_by_id" );
		String modified_by_id				=		request.getParameter( "modified_by_id" );
		String modified_date				=		request.getParameter( "modified_date" );
		String doc_type_desc				=		request.getParameter("doc_type_desc")==null?"":request.getParameter( "doc_type_desc" ) ;
		String doc_no						=		request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
		PORequestStatusBean bean				=		(PORequestStatusBean) getBeanObject(bean_id,bean_name, request);  
		bean.setLanguageId(locale);
	%>
	<title><fmt:message key="eST.AuditInformationfor.label" bundle="${st_labels}"/> <%=doc_type_desc%>/<%=doc_no%>&nbsp;&nbsp;</title>
	</head>
	<body >
		<table border="1" cellpadding="0" cellspacing="0" width="100%" height="100%" align="center">
			<tr>			
				<td class="OAQRYODD" align="right"><b><fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/></b></td>
				<td class="OAQRYODD" align="left">&nbsp;&nbsp;<%=added_by_id %></td>
			</tr>	
			<tr>	
				<td class="OAQRYEVEN" align="right"><b><fmt:message key="eST.LastAccessedBy.label" bundle="${st_labels}"/></b></td>
				<td class="OAQRYEVEN" align="left">&nbsp;&nbsp;<%= modified_by_id%></td>
			</tr>	
			<tr>	
				<td class="OAQRYODD" align="right"><b><fmt:message key="eST.LastAccessedOn.label" bundle="${st_labels}"/></b></td>
				<td class="OAQRYODD" align="left">&nbsp;&nbsp;<%= com.ehis.util.DateUtils.convertDate(modified_date,"DMY","en",locale)%></td>
			</tr>	
			<tr>	
				<td class="OAQRYEVEN" align="right"><b><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/></b></td>
				<td class="OAQRYEVEN" align="left">&nbsp;&nbsp;<%=request_status %></td>
			</tr>
		
		</table>
	<%
putObjectInBean(bean_id,bean,request);
	%>
	</body>
</html>
	

