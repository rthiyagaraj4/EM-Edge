<!DOCTYPE html>
 <%@ page import="eST.AuthorizeAtIssueStoreBean,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<!-- 		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<script language="JavaScript" src="../../eST/js/StDuoHeader.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
<script language="JavaScript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="updateValues();">
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		

		String mode = eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		String trn_type = "ISS";
		String sql_from_store = "SQL_ST_REQUEST_FROM_STORE_SELECT_FOR_AUTH_AT_ISS";
		String sql_to_store = "SQL_ST_REQ_BY_STORE_SELECT_FOR_AUTH_AT_ISS";
		String Modal_Window_Open ="Yes";
		String bean_id = "authorizeAtIssueStoreBean";
		String bean_name = "eST.AuthorizeAtIssueStoreBean";
		AuthorizeAtIssueStoreBean bean = (AuthorizeAtIssueStoreBean) getBeanObject(bean_id,bean_name,request);  
		bean.setLanguageId(locale);

	%>
	<form name="formAuthorizeAtIssueStoreHeader" id="formAuthorizeAtIssueStoreHeader">
		<jsp:include page="../../eST/jsp/StDuoHeader.jsp" > 
			<jsp:param name="mode" value="<%=mode%>" />
			<jsp:param name="trn_type" value="<%=trn_type%>" />
			<jsp:param name="sql_from_store" value="<%=sql_from_store%>" />
			<jsp:param name="sql_to_store" value="<%=sql_to_store%>" />
			<jsp:param name="Modal_Window_Open" value="<%=Modal_Window_Open%>" />
			<jsp:param name="from_store_legend" value="Req On Store" />
			<jsp:param name="to_store_legend" value="Req By Store" />
		</jsp:include>
		<table cellspacing="0" width="100%" align=center>
		 <tr>
			<td  class="label">
				<fmt:message key="eST.CloseUponIssue.label" bundle="${st_labels}"/>&nbsp;&nbsp;
			
					<input type="checkbox" name="close_upon_issue_yn" id="close_upon_issue_yn" value="Y" onclick="mandatorygif()">
					&nbsp;&nbsp;
				</td>
			<td>
				<label onMouseOver="changeCursor(this);"  class="label" onClick = "showRemarks();">
					<font class='HYPERLINK'>
						<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
					</font>
				</label>
			&nbsp;&nbsp;<b id="mgif" style="display:none"><img src="../../eCommon/images/mandatory.gif" align=center></b>
			</td>
			<td> 
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
		  </tr>
		</table>
		<input type="hidden" name="request_by_store_code" id="request_by_store_code" value="">
		<input type="hidden" name="request_on_store_code" id="request_on_store_code" value="">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="remarks_details" id="remarks_details" value="<%=bean.getRemarks()%>">
		<%
putObjectInBean(bean_id,bean,request);
%>
	</form>
	</body>
</html>

