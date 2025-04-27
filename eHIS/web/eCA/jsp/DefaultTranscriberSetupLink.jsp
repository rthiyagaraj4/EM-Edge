<!DOCTYPE html>
<%@page import="eCA.*,java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
<head><title></title>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;	
	String locale = (String) p.getProperty("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="JavaScript" src="../js/DefaultTranscriberSetup.js"></script>
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
</head>
<body onMouseDown='CodeArrest();' onKeyDown='lockKey();'>
<form name="formDefaultTransSetupLink" id="formDefaultTransSetupLink">
<%
	String bean_id = "CATranscriberSetupBean" ;
	String bean_name = "eCA.CATranscriberSetupBean";

	CATranscriberSetupBean bean = (CATranscriberSetupBean)getObjectFromBean( bean_id,bean_name, session ) ; 
	bean.setLocale(locale);
	bean.clearDBRec();
	
%>

<table border='0' cellspacing='0' cellpadding='0' width='100%' height='100%' align='center'>
	<tr id='selectTable'>
		<td width='25%' align='left'>
			<table align='left' cellspacing='0' cellpadding='0' width="100%" border='1'>
				<tr>
					<td id='SelectTab' class='clicked' width='25%' height='20'><a href='javascript:dispLink("S")'><fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/></a></td>
					<td id='AssociateTab' class='normal' width='25%' height='20'><a href='javascript:dispLink("A")'><fmt:message key='Common.Associate.label' bundle='${common_labels}'/></a></td>
				</tr>
			</table>
		</td>
		<td width='25%'></td>
		<td width='25%'></td>
		<td width='25%'></td>
	</tr>
	<tr id='selectLink'>
		<td colspan='4' id='linkId' ><jsp:include page='CACommonAlphaLink.jsp' flush='true'/></td>
	</tr>
</table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,session);
%>

