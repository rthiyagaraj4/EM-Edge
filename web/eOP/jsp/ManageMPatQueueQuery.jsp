<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<script src="../../eOP/js/ManageMPatQueue.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
    request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String oprstn=request.getParameter("oprstn")==null?"":request.getParameter("oprstn");
	String order=request.getParameter("orderbyvisit");

	if(order==null)
		order="no";	
	try{
	
	String rfresh_param = request.getParameter("refresh");
	String rule=request.getParameter("access_rule");
	String call_from=request.getParameter("call_from")==null?"":request.getParameter("call_from");
	String speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	if(rule == null) rule="";	
	String pat_id_length = request.getParameter("pat_id_length")==null?"":request.getParameter("pat_id_length");
	String bl_package_enabled_yn = request.getParameter("bl_package_enabled_yn")==null?"N":request.getParameter("bl_package_enabled_yn");
	String sdate = request.getParameter("sdate")==null?"":request.getParameter("sdate");
	String action_on_pending_bill =request.getParameter("action_on_pending_bill")==null?"":request.getParameter("action_on_pending_bill");// Added For MMS-QH-CRF-0126 [IN:041880]

%>

<iframe src='../../eOP/jsp/MultiPatframe1.jsp?refresh=<%=rfresh_param%>&access_rule=<%=rule%>&oprstn=<%=oprstn%>&call_from=<%=call_from%>&speciality_code=<%=speciality_code%>&pat_id_length=<%=pat_id_length%>&sdate=<%=sdate%>&bl_package_enabled_yn=<%=bl_package_enabled_yn%>&action_on_pending_bill=<%=action_on_pending_bill%>' name='MultiPatframe1' FRAMEBORDER=NO NORESIZE   style='height:20vh;width:100vw'></iframe>
	<iframe src='../../eCommon/html/blank.html' name='MultiPatframe3' id='MultiPatframe3' FRAMEBORDER=NO   marginwidth='5' NORESIZE style='height:40vh;width:100vw'></iframe>
	<iframe src='../../eOP/jsp/MultiPatStatusBar.jsp' name='status' id='status' FRAMEBORDER=NO   marginwidth='5' scrolling='no' NORESIZE style='height:20vh;width:100vw'></iframe>
	<iframe src='../../eOP/jsp/CheckBoxDisplay.jsp' name='checkbox' id='checkbox' FRAMEBORDER=NO   marginwidth='5' scrolling='no' NORESIZE style='height:20vh;width:100vw'></iframe>

</html>
<%
	}catch(Exception e) {}
	finally{	
	}
%>

