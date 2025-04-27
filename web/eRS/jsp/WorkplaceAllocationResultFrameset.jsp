<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	WorkPlaceAllocationResultFrameset.jsp
*	Purpose 			:
*	Created By		:	Sreenivasulu.Y
*	Created On		:	10 Dec 2004
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	String result_jsp= request.getParameter( "result_jsp") ;
	String facility_id = request.getParameter( "facility_id") ;
	String locn_type= request.getParameter("locn_type");
	String workplace_code=request.getParameter("workplace_code");
	String group_by=request.getParameter("group_by");
	String view_opt=request.getParameter("view_opt");
	String from_date = request.getParameter( "from_date") ;
	String to_date= request.getParameter("to_date");
	String new_todate=request.getParameter("new_todate");
	String next_fromdate=request.getParameter("next_fromdate");
	String onclick_of=request.getParameter("onclick_of");
%>
<html>
<head>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script>function_id = "<%=request.getParameter("function_id")%>";	</script>
<script language="javascript" src="../../eRS/js/WorkplaceAllocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eRS.WorkplaceAllocationDetails.label" bundle="${rs_labels}"/></title>
</head>
<iframe name='arrows' id='arrows' src="../../eRS/jsp/WorkplaceAllocationDisplayArrows.jsp?result_jsp=<%=result_jsp%>&from_date=<%=from_date%>&next_from_date=<%=next_fromdate%>&new_todate=<%=new_todate%>&to_date=<%=to_date%>" frameborder=no scrolling=no noresize style='height:4vh;width:100vw'></iframe>
<iframe name='result1' id='result1' src="<%=result_jsp%>?from_date=<%=from_date%>&to_date=<%=to_date%>&facility_id=<%=facility_id%>&locn_type=<%=locn_type%>&workplace_code=<%=workplace_code%>&group_by=<%=group_by%>&view_opt=<%=view_opt%>&new_todate=<%=new_todate%>&next_fromdate=<%=next_fromdate%>&onclick_of=<%=onclick_of%>"  frameborder=no scrolling='auto' noresize style='height:96vh;width:100vw'></iframe>

</html>

