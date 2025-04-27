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
<jsp:useBean id="bean" scope="page" class="eOR.ConsignOrders"/>  
<%-- Mandatory declarations end --%>


<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
 	<script language="JavaScript" src="../js/ConsignOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 	<!--<script language="JavaScript" src="../js/OrMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<% 
     
 	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	//String bean_id = "Or_ConsignOrders" ;
	//String bean_name = "eOR.ConsignOrders";

	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
	bean.setLanguageId(localeName);

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id"); 
	if(resp_id== null)resp_id = "";
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String source_type = request.getParameter("location_type");
	String source_code = request.getParameter("locn");
	String patientId   = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	//out.println(">>>>>rr>>>>>>>>>>----"+period_from);
	//out.println(">>>>>>>>>>>>>>>----"+period_to);
	//out.println("<script>alert('period_from==="+period_from+"=period_to=="+period_to+"==')</script>");
	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =""; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
 	//ConsignOrders bean = (ConsignOrders)getBeanObject( bean_id, bean_name , request ) ; 
	Properties properties	= (Properties) session.getValue( "jdbc" );
 	String  auth_yn = "";
	auth_yn = bean.getAuthYN(properties, practitioner_id,resp_id) ;
	if((auth_yn.trim()).equals("")){
		out.println("<script>parent.CosignOrderTop.document.cosign_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('PRACT_RESP_NOT_COSIGN','OR')); parent.location.href='../../eCommon/html/blank.html'</script>");
	}
 	ArrayList PriorityData = bean.getStatusByPriority(properties, source_type,source_code,practitioner_id,resp_id,facility_id,patientId, period_from, period_to,"CS") ;
 	if(PriorityData.size() == 0){
		out.println("<script>parent.CosignOrderTop.document.cosign_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON')); location.href='../../eCommon/html/blank.html'</script>");
	}
	if(PriorityData!=null) {
		PriorityData.clear();
		PriorityData = null;
	}
	
%>
<iframe name='CosignOrdersBottomLeft' id='CosignOrdersBottomLeft'	src='CosignOrdersBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>'  frameborder=0 scrolling='no' noresize style="height:90vh;width:20vw" align='left'></iframe>
	<iframe name='CosignOrdersBottomRight' id='CosignOrdersBottomRight' src='CosignOrdersBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&order_by=O'  frameborder=0 style="height:93vh;width:77vw" align='right'></iframe>
</html>
 

