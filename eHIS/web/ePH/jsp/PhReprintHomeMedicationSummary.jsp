<!DOCTYPE html>
 
<!--  Author 	:	Arun M (157457)
Module name 	:	ePH
Function 		:	RePrint for Home Medication Summary-->

<html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%

String url			= "../../eCommon/jsp/commonToolbar.jsp?" ;
String params		= request.getQueryString() ;
String source		= url + params ;	

%>
<head>
<title></title>
  <%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String bean_id 			= "PhReprintHomeMednBean";
		String bean_name 		= "ePH.PhReprintHomeMednBean";

		PhReprintHomeMednBean bean = (PhReprintHomeMednBean)getBeanObject( bean_id, bean_name , request) ;
		bean.setLanguageId(locale);
		bean.clear();
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../ePH/js/PhReprintHomeMdn.js"></script> 
	  <script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:1vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod"  frameborder="0"  scrolling="no" noresize border='0' src="../../ePH/jsp/PhReprintHomeMednCriteria.jsp"  style='height:4vh;width:100vw'></iframe><iframe name="f_query_dtl_rec" id="f_query_dtl_rec"  frameborder="0"  scrolling="no" noresize border='0' src="../../ePH/jsp/PhReprintHomeMednDtl.jsp"  style='height:5vh;width:100vw'></iframe><iframe name="f_query_dtl_sub_rec" id="f_query_dtl_sub_rec"  frameborder="0"  scrolling="no" noresize border='0' src="../../ePH/jsp/PhReprintHomeMednSubDtl.jsp"  style='height:4vh;width:100vw'></iframe><iframe name="f_query_dtl_add_rec" id="f_query_dtl_add_rec"  frameborder="0"  scrolling="no" noresize border='0' src="../../ePH/jsp/PhReprintHomeMednAddDtl.jsp"  style='height:2vh;width:100vw'></iframe><iframe name="f_query_add_sub_rec" id="f_query_add_sub_rec"  frameborder="0"  scrolling="no" noresize border='0' src="../../ePH/jsp/PhReprintHomeMednSetDtl.jsp"  style='height:30vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize  style="height:5%;width:100vw"></iframe>

</html>

