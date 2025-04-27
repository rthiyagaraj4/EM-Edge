<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>


<html>
<head>

	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eOA/js/BulkTransferAppointment.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	
</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String from_speciality = request.getParameter("from_speciality") ;
	if(from_speciality ==null) from_speciality="";
	String to_speciality = request.getParameter("to_speciality") ;
	if(to_speciality ==null) to_speciality="";
	String locn_type=request.getParameter("locn_type");
	if(locn_type ==null) locn_type="";
	String from_locn=request.getParameter("from_locn");
	if(from_locn ==null) from_locn="";
	String to_locn=request.getParameter("to_locn");
	if(to_locn ==null) to_locn="";
	String from_resc=request.getParameter("from_resc");
	if(from_resc ==null)from_resc="";
	String to_resc=request.getParameter("to_resc");
	if(to_resc ==null) to_resc="";
	String from_date=request.getParameter("from_date");
	if(from_date ==null) from_date="";
	String to_date=request.getParameter("to_date");
	if(to_date ==null) to_date="";
	String from_res_class=request.getParameter("from_res_class");
	if(from_res_class ==null) from_res_class="";
	String to_res_class=request.getParameter("to_res_class");
	if(to_res_class ==null) to_res_class="";
	String oper_stn=request.getParameter("oper_stn");
	if(oper_stn ==null) oper_stn="";
	String from_page=request.getParameter("from_page");
	String visit_limit_rule=request.getParameter("visit_limit_rule");
	if(visit_limit_rule ==null) visit_limit_rule="N";
	

			
	%>	
		
		

		
		<iframe name='result1' id='result1'	src='../../eOA/jsp/BulkTransferAppointmentResult1.jsp?from_speciality=<%=from_speciality%>&to_speciality=<%=to_speciality%>&locn_type=<%=locn_type%>&from_locn=<%=from_locn%>&to_locn=<%=to_locn%>&from_resc=<%=from_resc%>&to_resc=<%=to_resc%>&from_date=<%=from_date%>&to_date=<%=to_date%>&from_res_class=<%=from_res_class%>&to_res_class=<%=to_res_class%>&oper_stn=<%=oper_stn%>&from_page=<%=from_page%>&visit_limit_rule=<%=visit_limit_rule%>' frameborder=0  scrolling='auto' noresize style='height:100vh;width:45vw'></iframe>
		<iframe name='gopage' id='gopage'	src='../../eOA/jsp/BulkTransferAppointmentResultGo.jsp?from_speciality=<%=from_speciality%>&to_speciality=<%=to_speciality%>&locn_type=<%=locn_type%>&from_locn=<%=from_locn%>&to_locn=<%=to_locn%>&from_resc=<%=from_resc%>&to_resc=<%=to_resc%>&from_date=<%=from_date%>&to_date=<%=to_date%>&from_res_class=<%=from_res_class%>&to_res_class=<%=to_res_class%>&oper_stn=<%=oper_stn%>&from_page=<%=from_page%>&visit_limit_rule=<%=visit_limit_rule%>' frameborder=0 scrolling='auto' noresize style='height:100vh;width:4vw'></iframe>
		<iframe name='result2' id='result2'	src='../../eOA/jsp/BulkTransferAppointmentResult2.jsp?from_speciality=<%=from_speciality%>&to_speciality=<%=to_speciality%>&locn_type=<%=locn_type%>&from_locn=<%=from_locn%>&to_locn=<%=to_locn%>&from_resc=<%=from_resc%>&to_resc=<%=to_resc%>&from_date=<%=from_date%>&to_date=<%=to_date%>&from_res_class=<%=from_res_class%>&to_res_class=<%=to_res_class%>&oper_stn=<%=oper_stn%>&from_page=<%=from_page%>&visit_limit_rule=<%=visit_limit_rule%>' frameborder=0 scrolling='auto' noresize style='height:100vh;width:50vw'></iframe>
	

	</html>

