<!DOCTYPE html>
<%@ page import=" ePO.STPOCancelRequestBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
    <script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/STPOCancelRequest.js"></script>
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

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

	String facilityid=(String)session.getValue("facility_id");
	STPOCancelRequestBean bean = (STPOCancelRequestBean) getBeanObject("STpoCancelRequestBean","ePO.STPOCancelRequestBean",request);  
	
	//if(!(bean.recordExists(facilityid, "ALL"))) {
		//out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	//}
	bean.setLanguageId(locale);
	
	if(!bean.checkForNull((String)	bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")}).get("PO_INTERFACE_YN"),"N").equals("Y")){ 
		
	%>
	 <SCRIPT>alert("Purchase Module Not Applicable");window.location.href =
'../../eCommon/jsp/dmenu.jsp'</SCRIPT>  
<%}%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" scrolling="no" noresize src="../../ePO/jsp/STPOCancelRequestQueryFrame.jsp?mode=MODE_MODIFY" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>
<%
putObjectInBean("STpoCancelRequestBean",bean,request);
%>
</html>


