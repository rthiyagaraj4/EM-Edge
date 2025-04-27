<!DOCTYPE html>
<%@ page import="eST.PORequestStatusBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language='javaScript' src="../../eST/js/PORequestStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String bean_id						=		"PORequestStatusBean";
	String bean_name					=		"eST.PORequestStatusBean";
	//String facilityid=(String)session.getValue("facility_id");

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	PORequestStatusBean bean				=		(PORequestStatusBean) getBeanObject(bean_id,bean_name, request);  
	bean.setLanguageId(locale);

	
	if(!bean.checkForNull((String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")}).get("INTERFACE_TO_EXTERNAL_PO_YN"),"N").equals("Y")){%>

<SCRIPT>alert("PO Request is not applicable");window.location.href =
'../../eCommon/jsp/dmenu.jsp'</SCRIPT>
	
	

<%
	putObjectInBean(bean_id,bean,request);

	}
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eST/jsp/PORequestStatusFrameset.jsp" style="height:82vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:10vh;width:100vw"></iframe>
</html>


