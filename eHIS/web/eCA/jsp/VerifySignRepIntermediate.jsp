<!DOCTYPE html>
<%@ page import = "java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	eCA.PatientBannerGroupLine verifySignBean = null;
	verifySignBean = (eCA.PatientBannerGroupLine) getObjectFromBean("verifySignBean","eCA.PatientBannerGroupLine",session);
	try
	{
		//String reportId = request.getParameter("reportId") == null ? "" : request.getParameter("reportId");
		//String moduleId = request.getParameter("moduleId") == null ? "" : request.getParameter("moduleId");
		//String requestDate = request.getParameter("requestDate") == null ? "" : request.getParameter("requestDate");
		//String mailedUser = request.getParameter("mailedUser") == null ? "" : request.getParameter("mailedUser");
		String requestSrlNo = request.getParameter("requestSrlNo") == null ? "0" : request.getParameter("requestSrlNo");
		String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		String verify_flag = request.getParameter("verify_flag") == null ? "" : request.getParameter("verify_flag");
		String reason = request.getParameter("reason") == null ? "" : request.getParameter("reason");
		String actual_data = "";
		
		if(!reason.equals(""))
			actual_data = verify_flag+"`"+reason;
		else
			actual_data = verify_flag;
		
		if(mode.equals("add"))
		{
			if(verifySignBean.ContainsKey(requestSrlNo))
			{
				verifySignBean.removeFromHashMap(requestSrlNo);
				verifySignBean.addToHashMap(requestSrlNo,actual_data);
			}
			else
				verifySignBean.addToHashMap(requestSrlNo,actual_data);
		}
		else
			verifySignBean.removeFromHashMap(requestSrlNo);

		putObjectInBean("verifySignBean",verifySignBean,session);
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
%>
