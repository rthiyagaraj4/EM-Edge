<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.PendingAppointmentbean"/>  
<%-- Mandatory declarations end --%>


<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/PendingAppointment.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 	
	<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%     
 	
	bean.setLanguageId(localeName);
	String practitioner_id = (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String source_type = request.getParameter("location_type")==null?"":request.getParameter("location_type");
	
	
	String source_code = request.getParameter("locn")==null?"":request.getParameter("locn");	
	String patientId   = request.getParameter("patientId")==null?"":request.getParameter("patientId");
	String period_from= request.getParameter("period_from")==null?"":request.getParameter("period_from");
	String period_to		= request.getParameter("period_to")==null?"":request.getParameter("period_to");
	/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added to take filter value from request ". 
						 */
	String filter		= request.getParameter("filter_name")==null?"":request.getParameter("filter_name");	

	/* end here */	
	
	Properties properties	= (Properties) session.getValue( "jdbc" ); 	
 	ArrayList PriorityData = bean.getStatusByPriority(properties, source_type,source_code,practitioner_id,resp_id,facility_id,patientId, period_from, period_to,filter) ;
 	if(PriorityData.size() == 0){
		out.println("<script>parent.CosignOrderTop.document.cosign_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON')); location.href='../../eCommon/html/blank.html'</script>");
	}
	if(PriorityData!=null) {
		PriorityData.clear();
		PriorityData = null;
	}
	 
%>
<iframe name='CosignOrdersBottomLeft' id='CosignOrdersBottomLeft'	src='PendingAppointmentBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>'  frameborder=0 scrolling='no' noresize style="height:90vh;width:100vw"></iframe>
	<iframe name='CosignOrdersBottomRight' id='CosignOrdersBottomRight' src='PendingAppointmentBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>&order_by=O'  frameborder=0 noresize scrolling="no" style="height:10vh;width:100vw"></iframe>
</html>
 

