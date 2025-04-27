<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Karabi S.
*	Created On		:	11th Dec 2004
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
	String workplace_code= request.getParameter("workplace_code");
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
<script language="javascript" src="../../eRS/js/WorkplaceRoster.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eRS.RosterDetails.label" bundle="${rs_labels}"/></title>
</head>
<iframe name='arrows' id='arrows' src="../../eRS/jsp/WorkplaceRosterDisplayArrows.jsp?from_date=<%=from_date%>&next_from_date=<%=next_fromdate%>&new_todate=<%=new_todate%>&to_date=<%=to_date%>" frameborder=no scrolling=no noresize style='height:21%;width:100vw'></iframe>
<iframe name='result1' id='result1' src="../../eRS/jsp/WorkplaceRosterResult.jsp?from_date=<%=from_date%>&to_date=<%=to_date%>&mode=<%=mode%>&workplace_code=<%=workplace_code%>&function_id=<%=function_id%>&new_todate=<%=new_todate%>&next_fromdate=<%=next_fromdate%>&onclick_of=<%=onclick_of%>"  frameborder=no scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>

</html>

