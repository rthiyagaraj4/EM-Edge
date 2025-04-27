<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/BLGroupOrderRouting.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	try{
		String bean_id = "BLGroupOrderRoutingBean" ; 
		String bean_name = "ePH.BLGroupOrderRoutingBean";
		String facility_id=(String) session.getValue( "facility_id" );
		BLGroupOrderRoutingBean bean = (BLGroupOrderRoutingBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
%>
		<form name='fmBLGruopOdrRoutingButtons' id='fmBLGruopOdrRoutingButtons'>
		   <table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" >
				<td colspan="6" align='right'>
					<input type="button" name="" id="" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class="button" onClick="AddRow()">
					<input type="button" name="" id="" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class="button"  onClick="ResetToDefaultValues()">
				</td>

			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		</form>
<%
		putObjectInBean(bean_id,bean,request);
	}
	catch ( Exception fe ) {
		fe.printStackTrace() ;
	}
%>
	</body>
</html>

