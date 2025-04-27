<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<head> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eXB/js/XBMasterSetUp.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<title>Master Set Up</title> 
</head>
<%																   
//	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	// System.out.println("params XBMasterSetUpMain.jsp :"+params);
	String source = url + params ;
%> 
 
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:30%;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:80%;width:100vw'></iframe><iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:330%;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:30%;width:100vw'></iframe>

</html>
																					     
 


 

