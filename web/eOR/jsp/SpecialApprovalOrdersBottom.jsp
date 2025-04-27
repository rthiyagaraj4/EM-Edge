<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<jsp:useBean id="bean" scope="page" class="eOR.SpecialApproveOrders"/> 
<%-- Mandatory declarations end --%>
<%
	%>

<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/SpecialApproveOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<% 
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
//	String bean_id = "Or_SpecialApproveOrders" ;
//	String bean_name = "eOR.SpecialApproveOrders";

	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";

	String source_type = request.getParameter("location_type");
	String source_code = request.getParameter("locn");
	String patientId   = request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String filter=request.getParameter("filter")==null?"":request.getParameter("filter");

	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	if(patientId == null || patientId.equals("null")) patientId =""; else patientId = patientId.trim();
	if(period_from == null || period_from.equals("null")) period_from =""; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =""; else period_to = period_to.trim();
	//period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",localeName,"en");
	//period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",localeName,"en");
	Properties properties	= (Properties) session.getValue( "jdbc" );

//	SpecialApproveOrders bean = (SpecialApproveOrders)getBeanObject( bean_id, bean_name ,request ) ;

	bean.setLanguageId(localeName);
	//out.print(localeName);
	String  spl_yn = "";
	spl_yn = bean.getSplYN(properties, practitioner_id,resp_id) ;

	if((spl_yn.trim()).equals("")){
		out.println("<script>parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('PRACT_RESP_CANNOT_SPECIAL_APPRV','OR')); parent.location.href='../../eCommon/html/blank.html'</script>");
	}

	/*out.println("source_type > "+source_type+"<");
	out.println("source_code > "+source_code+"<");
	out.println("practitioner_id > "+practitioner_id+"<");
	out.println("resp_id > "+resp_id+"<");
*/
	ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,resp_id,patientId, period_from, period_to,"PS",filter) ;

//	out.println("PriorityData > "+PriorityData.size()+"<");
	if(PriorityData.size() == 0){
		out.println("<script>parent.SpecialApprovalOrdersTop.document.aspl_apprv_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html'</script>");
	}
	if(PriorityData!=null) {
		PriorityData.clear();
		PriorityData = null;
	}

%>
<iframe name='SpecialApprovalOrdersBottomLeft' id='SpecialApprovalOrdersBottomLeft'	src='SpecialApprovalOrdersBottomLeft.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&filter=<%=filter%>'  frameborder=0 scrolling='no' noresize style='height:100vh;width:20vw' ></iframe>
	<iframe name='SpecialApprovalOrdersBottomRight' id='SpecialApprovalOrdersBottomRight' src='SpecialApprovalOrdersBottomRight.jsp?source_type=<%=source_type%>&source_code=<%=source_code%>&patientId=<%=patientId%>&period_from=<%=period_from%>&period_to=<%=period_to%>&order_by=O&filter=<%=filter%>'  frameborder=0 scrolling='no' style='height:100vh;width:77vw'></iframe>
</html>
<%
	//putObjectInBean(bean_id,bean,request);
%>

