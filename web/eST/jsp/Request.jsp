<!DOCTYPE html>

<%@ page import=" eST.RequestBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/Request.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
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
	String facilityid=(String)session.getValue("facility_id");

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	

	RequestBean bean = (RequestBean) getBeanObject("requestBean","eST.RequestBean", request );  
	bean.initialize();
	bean.setLanguageId(locale);
	
	 //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 
	String sales_req_yn = bean.checkForNull(request.getParameter( "sales_req_yn" ), "N");

// Passing login_facility_id, material_group_code as arguments
	if(!(bean.recordExists(facilityid, "ALL"))) {
		out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	}

	//Added for 29970	Bru-HIMS-CRF-095
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String count		= request.getParameter("count") == null?"0":request.getParameter("count");

%>
<%
putObjectInBean("requestBean",bean,request);
%>
<%if(sales_req_yn.equals("Y")) {%>
<title> Create/Review Request</title>
<%}%>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style='height:8vh;width:100vw'></iframe>
	<!-- //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 -->
	<%if(sales_req_yn.equals("Y")) {%>
	<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eST/jsp/RequestFrame.jsp?<%=params%>" style='height:82vh;width:100vw'></iframe>
	<%}else{ %>
	 <iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style='height:82vh;width:100vw'></iframe>
	<%} %>
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder="0" noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
<%
if(homepage.equals("Y") && !count.equals("0")){
%>
	<script>
			parent.workAreaFrame.f_query_add_mod.document.location.href = "../../eST/jsp/RequestQueryFrame.jsp?mode=2&<%=params%>";
	</script>
<%
}
%>
</html>


