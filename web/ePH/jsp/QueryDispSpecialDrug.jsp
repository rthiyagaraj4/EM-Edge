<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>                                
<head>                                
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../js/QueryDispSpecialDrug.js"></script> 
 	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>                               

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/QueryDispSpecialDrugFrames.jsp" style="height:83vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>

<%

	String	bean_id			=	"QueryPresVsDispDrugsBean" ;
	String	bean_name	=	"ePH.QueryPresVsDispDrugsBean";

	QueryPresVsDispDrugsBean bean = (QueryPresVsDispDrugsBean)getBeanObject( bean_id,bean_name,request);
	
	
	String 	str=bean.isOrInstalled();
	out.println(str);
	if (str=="N")
	{
			out.println("<script>alert('OR Module not installed!!');window.location.href ='../../eCommon/jsp/dmenu.jsp'</script>");
	}


%>
<% putObjectInBean(bean_id,bean,request); %>
</html>

