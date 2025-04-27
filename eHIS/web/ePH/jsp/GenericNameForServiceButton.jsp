<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<!--
Developed by	: P.Sudhakaran.
Module/Function : Generic Name for Service (Master)
				  display the select/associate buttons and load the bean
-->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
    request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    //ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script language="JavaScript" src="../js/PhCommon.js"></script>
<script language="JavaScript" src="../js/GenericNameForService.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
*
{cursor:pointer;}
</style>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="genericnameforservice_button" id="genericnameforservice_button">
<%

	String from_source	= request.getParameter( "from_source" );
	String service_code	= "";
	String generic_id	= "";
	String bean_id		= "genericnameforservice" ;
	String bean_name	= "ePH.GenericNameforServiceBean";

	/* Initialize Function specific start */
	GenericNameforServiceBean bean = (GenericNameforServiceBean)getBeanObject( bean_id,  bean_name , request) ;
	bean.setLanguageId(locale);


	//for loading the data into DB arraylist passing the service code to bean

	if(from_source.equals( "byservice" )){
		service_code	= request.getParameter( "service_code" ) ;
		bean.loadData(service_code,from_source,locale);
	}
	else{
		generic_id		= request.getParameter( "generic_id" ) ;
		bean.loadData(generic_id,from_source,locale);
	}


%>
<table border="1" width="32%" cellspacing="0" cellpadding="0" >
	<tr>
		<td class="clicked" id="select_col" align="center" width="30%" height="20" onClick="javascript:Display('1','<%=from_source%>')"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<td class="normal" id="association_col" align="center" width="30%" height="20" onClick="javascript:Display('2','<%=from_source%>')"><fmt:message key="Common.Association.label" bundle="${common_labels}"/></td>
	</tr>
</table>
<%
if(from_source.equals( "byservice" )){
%>
	<script>
		callLabelPage("<%=service_code%>");
	</script>
<%
	}else{
%>
	<script>
		callDetailsPage();
	</script>
<%
	}
%>
<input type="hidden" value="N" name="data_change_yn" id="data_change_yn">
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

