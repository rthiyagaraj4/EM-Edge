<!DOCTYPE html>
<%/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
21/04/2023        40016               HARIHARAN     21/04/2023       ramesh goli          ML-MMOH-CRF-1823.V1.0
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/%>
 <%-- saved on 04/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*,java.sql.*, ePH.*, ePH.Common.*, eCommon.Common.*" %> 
<%-- JSP Page specific attributes end --%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>                                 
<head>                                 
<!--  
<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")? 
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link> --> 

 	<script language="javascript" src="../../ePH/js/QuotaLimitReport.js"></script> 
	<script language="javascript" src="../js/PhCommon.js"></script> 
	<script language="javascript" src="../../eCommon/js/common.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>                                

<% 
	request.setCharacterEncoding("UTF-8"); 
	String locale			= (String)session.getAttribute("LOCALE"); 
	

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ; 
	String params = request.getQueryString() ; 
	String source = url + params ; 
%> 

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/QuotaLimitReportCriteria.jsp" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe> 
</html> 

