<!DOCTYPE html>
<html>
  <head>
	<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eMP/js/ReferralSearch.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
  <%
		String callingMode=request.getParameter("callingMode");
		if(callingMode ==null) callingMode="";
		String from_OR=request.getParameter("from_OR");
		if(from_OR ==null) from_OR="";
		String from_page="";
		from_page="OA_PENDING_REFERRAL_BOOKING";
		String install_yn_val=request.getParameter("install_yn_val")==null?"":request.getParameter("install_yn_val");
		String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String book_appt_yn=request.getParameter("book_appt_yn")==null?"":request.getParameter("book_appt_yn");
		String create_wait_list_yn=request.getParameter("create_wait_list_yn")==null?"":request.getParameter("create_wait_list_yn");

  %>
  <%if(callingMode.equals("MR") || callingMode.equals("OP_RV"))
  {%>
  <iframe name='images12' id='images12' src='../../eOA/jsp/DisplayPendingReferraltab.jsp?install_yn_val=<%=install_yn_val%>&callingMode=<%=callingMode%>&oper_stn_id=<%=oper_stn_id%>&book_appt_yn=<%=book_appt_yn%>&create_wait_list_yn=<%=create_wait_list_yn%>' frameborder=no scrolling=no noresize style='height:5vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod_main' id='f_query_add_mod_main' 	src='../../eMP/jsp/ReferralSearchFrameset.jsp?function_id=<%=from_page%>&callingMode=<%=callingMode%>' frameborder=0 scrolling=no style='height:95vh;width:100vw'></iframe>
  <%}else  {%>
    <iframe name='images12' id='images12' src='../../eOA/jsp/DisplayPendingReferraltab.jsp?install_yn_val=<%=install_yn_val%>&from_OR=<%=from_OR%>&oper_stn_id=<%=oper_stn_id%>&book_appt_yn=<%=book_appt_yn%>&create_wait_list_yn=<%=create_wait_list_yn%>' frameborder=no scrolling=no noresize style='height:5vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod_main' id='f_query_add_mod_main' 	src='../../eMP/jsp/ReferralSearchFrameset.jsp?function_id=<%=from_page%>' frameborder=0 scrolling=no style='height:95vh;width:100vw'></iframe>
  <%}%>
</html>

