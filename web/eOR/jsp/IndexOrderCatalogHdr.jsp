<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eOR.*,java.util.*, eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<html>
<head><title><fmt:message key="eOR.IndexOrderCatalog.label" bundle="${or_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOR/js/IndexOrderCatalog.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

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

	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	</script>

</head>
<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'; onLoad='document.forms[0].service_desc.focus();'>
<%
	
	String bean_id = "indexordercatalogbean" ;
	String bean_name = "eOR.IndexOrderCatalogBean";
	String mode = "1";
	
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	
	/* Mandatory checks end */
	/* Initialize Function specific start */
	IndexOrderCatalogBean bean = (IndexOrderCatalogBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clearDBRec();
	//boolean clearDBbean		=  bean.clearDBRec();
	/* Initialize Function specific end */
%>
<form name="formIndexOrCatalogHdr" id="formIndexOrCatalogHdr">
<table border='0' cellspacing='0' cellpadding='3' width='100%' height='100%' align='center'>
<tr>
	<td class='label'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<input type='hidden' name='service_code' id='service_code' value="">
	<input type='text' name='service_desc' id='service_desc' value="" onBlur="before_show_service_lookup(this,service_code);"><input type='button' class="button" name="service_butoon" id="service_butoon" value="?" onClick="show_service_lookup(service_desc,service_code);"><img src="../../eCommon/images/mandatory.gif" >
	<input type="hidden" name="service_sql" id="service_sql" value="<%=OrRepository.getOrKeyValue("SQL_OR_INDEX_CATLOG_SERVICE_LOOKUP")%>">
	<input type="hidden" name="temp_service_desc" id="temp_service_desc" value="">
	</td></tr>
<tr><td colspan='2' align='left'>
			<table align='left' cellspacing='0' cellpadding='0' width="30%" border='1'>
				<tr>
					<td id="SelectTab" class="clicked" width="15%" height="20"><a href='javascript:dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a></td>
					<td id="AssociateTab" class="normal" width="15%" height="20"><a href='javascript:dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></a></td>
				</tr>
			</table>
		</td>
	</tr>
	<td colspan='2' id='linkId' class="COMMONTOOLBARFUNCTION">
	<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
	</td>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="tabVal" id="tabVal" value="">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

