<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<html>
<head>

 	<script language="JavaScript" src="../js/PatOrderByPrivReln.js"></script>
 	<script language="JavaScript" src="../js/PatOrderByPrivRelnTracking.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	//String bean_id = "Or_PatOrderByPrivRelnBean" ;
	//String bean_name = "eOR.PatOrderByPrivRelnBean";

//	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	//String resp_id = (String)session.getValue("responsibility_id"); 
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String mod_qry_str   = request.getQueryString();
	//if(resp_id== null)resp_id = "";
//	if(practitioner_id== null)practitioner_id = "";


	//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	

//	String  isValid = "hf";
//	isValid = bean.isAuthorised(practitioner_id,resp_id) ;
	//out.println(isValid);
	//if(isValid != null){

%>
<frameset rows='35%,4%,*'>
	<frame name='PatOrderByPRSearch' id='PatOrderByPRSearch' src='../jsp/PatOrderByPrivRelnSearch.jsp?<%=mod_qry_str%>' frameborder=0 noresize scrolling=no>
	<frame name='PatOrderByPRHeader' id='PatOrderByPRHeader' src='../../eCommon/html/blank.html' frameborder='50%' scrolling=no noresize>
	<frame name='PatOrderByPRResult' id='PatOrderByPRResult'  src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize>
	<!--<frame name=messageFrame src='../../eCommon/html/blank.html' frameborder=0 noresize>-->
</frameset>
	<%//}else{		
	//out.println("<script>alert('Not Authorised ...'); ");
		//}
		%>
</html>

