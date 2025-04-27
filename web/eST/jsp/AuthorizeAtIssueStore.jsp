<!DOCTYPE html>
<%@ page import="eST.AuthorizeAtIssueStoreBean,java.util.HashMap,java.util.ArrayList,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean  id="as01" class="eST.AuthorizeAtIssueStoreBean" />
<jsp:useBean  id="as02" class="eST.AuthorizeAtIssueStoreDetailBean" />
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

 <%  String sStyle	 =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id		=		"<%= request.getParameter( "function_id" ) %>"
		menu_id			=		"<%= request.getParameter( "menu_id" ) %>"
		module_id		=		"<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	String locale		=		(String)session.getAttribute("LOCALE");
	String url			=		"../../eCommon/jsp/commonToolbar.jsp?" ;
	String params		=		request.getQueryString() ;
	String source		=		url + params ;
	String facilityid	=		(String)session.getValue("facility_id");
	
	/*added by Ganga Thursday, August 16, 2012 for KAUH-SCF-022 Inc# 32778
	String Authorize_Label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.AuthorizeAtIssueStore.label","st_labels");
	params = "menu_id=ST_ISSUE&module_id=ST&function_id=ST_AUTH_AT_ISSUE_STORE&function_name="+Authorize_Label+"&function_type=F&access=NYYNN";
	added ended*/

	//String source		=		url + params ;

	AuthorizeAtIssueStoreBean bean = (AuthorizeAtIssueStoreBean)getBeanObject("authorizeAtIssueStoreBean","eST.AuthorizeAtIssueStoreBean",request);  
	bean.setLanguageId(locale);

	// Passing login_facility_id, material_group_code as arguments
	if(!(bean.recordExists(facilityid, "ALL"))) {
		out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	}
	//Added for 29970	Bru-HIMS-CRF-095
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String count		= request.getParameter("count") == null?"0":request.getParameter("count");
	String store_code	= request.getParameter("store_code") == null?"":request.getParameter("store_code");
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:82vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>
<%
	putObjectInBean("authorizeAtIssueStoreBean",bean,request);
%> 
<%
if(homepage.equals("Y") && !count.equals("0")){
	bean.setRequest_on_store(store_code);
%>
		<script>
			setTimeout('QueryClick();',0 );
			function QueryClick(){
				parent.workAreaFrame.commontoolbarFrame.document.forms[0].query.click();
			}
		</script>
<%
}
%>
</html>

