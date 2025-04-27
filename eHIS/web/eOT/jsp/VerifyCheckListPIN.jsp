<!DOCTYPE html>
<%
//"java.util.*, eOT.*,eOT.Common.* , eCommon.Common.*"
%>
<%@page   import="eOT.*,eOT.Common.*,eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>


<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/VerifyCheckList.js"></script>
	<script language="javascript" src="../../eCommon/js/crypto-js.min.js"></script> <!-- MMS-ME-SCF-0051-->
	<script language="javascript" src="../../eOT/js/ExamsCheckList.js"></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title>
		<fmt:message key="Common.PIN.label" bundle="${common_labels}"/>
	</title>
</head>
<%
	String user_id	= request.getParameter("user_id");
	String bean_id		= "@VerifyCheckListBean";
	String bean_name	= "eOT.VerifyCheckListBean";
	VerifyCheckListBean bean= (VerifyCheckListBean)mh.getBeanObject( bean_id, request, bean_name );
	//bean.getPIN(user_id);
%>
<body >
	<form name="CheckListPINForm" id="CheckListPINForm">
		<table  border='0' align="center" width='103%' cellpadding=3  cellspacing='0'>
			<tr>
				<td class="label">
					<fmt:message key="eOT.EnterPIN.Label" bundle="${ot_labels}"/>
					<input type="password" name="pin_no" id="pin_no" maxlength="30" size="15" onkeypress='focus_ok(event)'>
				</td>
			</tr>
			<tr>
				<td class="label"></td>
			</tr>
			<tr>
				<td class="fields">
					<input type="button" class="button" name= "btnOK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="validateCheckListPIN(this)" ></input>
					<input type="button" class="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="window.returnValue='false';window.close()" ></input>
				</td>
			</tr>
		</table>
		<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>"   >
		<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>" >
		<input type="hidden" name="user_id" id="user_id"			value="<%=user_id%>">
	</form>
</body>
</html>
<script language="javascript">
	//document.getElementById("checklist_user_pin").focus();
</script>

