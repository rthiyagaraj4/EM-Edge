<!DOCTYPE html>
<%@ page import = "java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	eCA.PatientBannerGroupLine usrPrvlgBean = null;
	usrPrvlgBean = (eCA.PatientBannerGroupLine)getObjectFromBean("usrPrvlgBean","eCA.PatientBannerGroupLine",session);

	String chkUnchk = request.getParameter("chkUnchk") == null ? "" :request.getParameter("chkUnchk");
	String practID = request.getParameter("practID") == null ? "" :request.getParameter("practID");
	String clearBean = request.getParameter("clearBean") == null ? "N" :request.getParameter("clearBean");
	if(clearBean.equals("Y")) usrPrvlgBean.clearBean();

	ArrayList list = usrPrvlgBean.returnList1();

	if(chkUnchk.equals("Y"))
		usrPrvlgBean.addRecordstoLine1(practID);
	else
	{
		if(list != null && list.size() != 0 && list.contains(practID))
			list.remove(practID);
	}
	
	putObjectInBean("usrPrvlgBean",usrPrvlgBean,session);

/*	ArrayList listTemp = usrPrvlgBean.returnList1();

	out.println(listTemp);*/
%>
