<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Karabi S.
*	Created On		:	03 Dec 2004
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
String mode	   = request.getParameter("mode") ;
String function_id = request.getParameter( "function_id") ;
String staff_id= request.getParameter("staff_id");
String role_type=request.getParameter("role_type");
String from_date = request.getParameter( "from_date") ;
String to_date= request.getParameter("to_date");
String new_todate=request.getParameter("new_todate");
String next_fromdate=request.getParameter("next_fromdate");
String onclick_of=request.getParameter("onclick_of");
%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script>function_id = "<%=request.getParameter("function_id")%>";	</script>
<script language="javascript" src="../../eRS/js/StaffProfile.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eRS.RosterDetails.label" bundle="${rs_labels}"/></title>
</head>
<iframe name='arrows' id='arrows' src="../../eRS/jsp/StaffRosterDisplayArrows.jsp?from_date=<%=from_date%>&next_from_date=<%=next_fromdate%>&new_todate=<%=new_todate%>&to_date=<%=to_date%>" frameborder=no scrolling=no noresize style='height:4vh;width:100vw'></iframe>
<iframe name='result1' id='result1' src="../../eRS/jsp/StaffRosterResult.jsp?from_date=<%=from_date%>&to_date=<%=to_date%>&mode=<%=mode%>&staff_id=<%=staff_id%>&role_type=<%=role_type%>&function_id=<%=function_id%>&new_todate=<%=new_todate%>&next_fromdate=<%=next_fromdate%>&onclick_of=<%=onclick_of%>"  frameborder=no scrolling='auto' noresize style='height:96vh;width:100vw'></iframe>

</html>

