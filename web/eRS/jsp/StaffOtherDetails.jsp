<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	19 Oct 2004
-->
<%-- JSP Page specific attributes start --%>
<%@ page language="java" contentType="text/html;charset=UTF-8"  import ="java.util.*, java.sql.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
	String mode	   = request.getParameter("mode") ;
	String function_id = request.getParameter( "function_id") ;
	String staff_id= request.getParameter("staff_id");
	String role_type=request.getParameter("role_type");
	%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
  	<script language="JavaScript" src="../js/RSCommon.js"></script>
	<script>function_id = "<%=request.getParameter("function_id")%>";	</script>
	<script language="javascript" src="../../eRS/js/StaffProfile.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eRS.StaffOtherDetails.label" bundle="${rs_labels}"/></title>
</head>
<iframe name= "f_query__tabs" id="f_query__tabs" src='../../eRS/jsp/StaffProfileTab.jsp?staff_id=+<%=staff_id %> &role_type=+<%=role_type %>+&mode=+<%=mode %>+&function_id=+<%=function_id %>' frameborder=0 scrolling='auto' noresize style='height:17vh;width:100vw'></iframe>
		<iframe name="f_query_otherdetails" id="f_query_otherdetails" src='../../eRS/jsp/StaffExperience.jsp?staff_id=+<%=staff_id %> &role_type=+<%=role_type %>' frameborder=0 scrolling="auto" noresize style='height:83vh;width:100vw'></iframe>

</html>

