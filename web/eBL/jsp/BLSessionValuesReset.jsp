<!DOCTYPE html>
  <%@ page import="java.sql.*, webbeans.eCommon.* , java.io.*" contentType="text/html;charset=UTF-8"  %>
	 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

  <%

	request.setCharacterEncoding("UTF-8");	

	try
  	{	

//		System.err.println("Inside Session Values Reset");
		String fin_dtls_reset=request.getParameter("fin_dtls_reset");
		if(fin_dtls_reset==null) fin_dtls_reset="N";
		if(fin_dtls_reset.equals("Y"))
		{
			session.removeAttribute("financial_details");
		}
		session.removeAttribute("hosp_panel_str");
		session.removeAttribute("prof_panel_str");
		session.removeAttribute("addl_panel_str");
		session.removeAttribute("prof_panel_str_YN");
		session.removeAttribute("hosp_panel_str_YN");
		session.removeAttribute("addl_panel_str_YN");
		session.removeAttribute("upd_hosp_chrg_amt");
		session.removeAttribute("upd_hosp_chrg_pat_amt");
		session.removeAttribute("upd_med_chrg_amt");
		session.removeAttribute("upd_med_chrg_pat_amt");
		session.removeAttribute("addl_med_chrg_amt");
		session.removeAttribute("addl_med_chrg_pat_amt");
		session.removeAttribute("hosp_dtls");
		session.removeAttribute("prof_dtls");
		session.removeAttribute("addl_dtls");
		session.removeAttribute("fin_dtls_to_chrg_dtls");
		session.removeAttribute("hosp_panel");
		session.removeAttribute("prof_panel");	
		session.removeAttribute("addl_panel");	

%>

<html>

<%
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
%>
</html>


