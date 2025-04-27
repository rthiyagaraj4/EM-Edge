<!DOCTYPE html>
 <%@ page import="eST.POGenerateRequestBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eST/js/POGenerateRequest.js'></script>
<script language='javascript' src='../../eST/js/StCommon.js'></script>
<script language='javascript' src='../../eST/js/StTransaction.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
        function_id = "<%=request.getParameter("function_id")%>"
		menu_id		= "<%=request.getParameter("menu_id")%>"
		module_id	= "<%=request.getParameter("module_id")%>"
</script>
</head> 
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;
	String facilityid=(String)session.getValue("facility_id");

	POGenerateRequestBean pogenerateRequestBean = (POGenerateRequestBean)getBeanObject( "pogenerateRequestBean","eST.POGenerateRequestBean", request);  

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

	pogenerateRequestBean.setLanguageId(locale);
	if(!(pogenerateRequestBean.recordExists(facilityid, "ALL"))) {%>
	<SCRIPT>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href =
	'../../eCommon/jsp/dmenu.jsp'</SCRIPT>;
	<%}
/*		String PO_DETAILS_APPLICABLE_YN       ="";
		String INTERFACE_TO_EXTERNAL_PO_YN    ="";
		HashMap hm=pogenerateRequestBean.fetchRecord("SELECT INTERFACE_TO_EXTERNAL_PO_YN,PO_DETAILS_APPLICABLE_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID=?",new String[]{(String)session.getAttribute("ACC_ENTITY_ID")});
		
		PO_DETAILS_APPLICABLE_YN=pogenerateRequestBean.checkForNull((String)hm.get("PO_DETAILS_APPLICABLE_YN"),"N");
		INTERFACE_TO_EXTERNAL_PO_YN=pogenerateRequestBean.checkForNull((String)hm.get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");*/
	if(!pogenerateRequestBean.checkForNull((String)	pogenerateRequestBean.fetchRecord(pogenerateRequestBean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")}).get("INTERFACE_TO_EXTERNAL_PO_YN"),"N").equals("Y")){%>

	<SCRIPT>alert(getMessage("PO_REQUEST_NOT_APPLICABLE","ST"));window.location.href =
	'../../eCommon/jsp/dmenu.jsp'</SCRIPT>
<%}
putObjectInBean("pogenerateRequestBean",pogenerateRequestBean,request);
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/POGenerateRequestFrame.jsp?<%=params%>" frameborder=0 scrolling='no' style='height:85vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:50%;width:100vw'></iframe>
</html>

