<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*,java.util.*, eOR.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
	<title></title>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../js/OrderTypesForOrderable.js'></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	</script>
	<STYLE TYPE="text/css">
	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 
	</STYLE>
	</head>
	<%
	/* Mandatory checks start */
	String mode		= "1";
	String bean_id = "ordertypesfororderablebean" ;
	String bean_name = "eOR.OrderTypesForOrderableBean";
	//String readOnly = "" ;
	//String disabled = "" ;
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */


	/* Initialize Function specific start */
	OrderTypesForOrderableBean bean = (OrderTypesForOrderableBean)getBeanObject(bean_id,bean_name, request) ;  
	bean.clear() ;
	bean.setMode(mode) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clearDBRec();
	//boolean clearDBbean		=  bean.clearDBRec();
	/* Initialize Function specific end */

	%>
<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'; onLoad='document.formOrderTypesForOrderHdr.order_type_code.focus()'>
	<form name="formOrderTypesForOrderHdr" id="formOrderTypesForOrderHdr">
	<table cellpadding='0' border='0' cellspacing='0' width='90%' align="center">
	<br><br>
	<tr><td colspan='2'>&nbsp;<td></tr>
	<tr>
		<td class="label" align="right" width='40%'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;&nbsp;<select name="order_type_code" id="order_type_code"><option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
		<%=bean.getComboOptionsOrType()%>
		</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"></img></td>
	</tr>
	<tr><td colspan='2'>&nbsp;<td></tr>
	<tr>
		<td colspan='2' align='left'>
			<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
				<tr>
					<td align="center" id="SelectTab" class="clicked" width="15%" height="20"><a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
					<td align="center" id="AssociateTab" class="normal" width="15%" height="20"><a href='javascript:dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
				</tr>
			</table>
		</td>
	</tr> 
	<tr>
		<td colspan='2' align='left' id='linkId'>
		<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
		</td>
	</tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="tabVal" id="tabVal" value="">
	</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

