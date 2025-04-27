<!DOCTYPE html>
<%@ page import = "java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%

	String chkUnchk = request.getParameter("chkUnchk") == null ? "" :request.getParameter("chkUnchk");
	String practID = request.getParameter("practID") == null ? "" :request.getParameter("practID");
	String beanObj = request.getParameter("beanObj") == null ? "" :request.getParameter("beanObj");
	String clearBean = request.getParameter("clearBean") == null ? "N" :request.getParameter("clearBean");

	
	eCA.PatientBannerGroupLine pmrForPracBean = null;
	pmrForPracBean = (eCA.PatientBannerGroupLine)getObjectFromBean(beanObj,"eCA.PatientBannerGroupLine",session);

	
	if(clearBean.equals("Y")) pmrForPracBean.clearBean();

	ArrayList list = pmrForPracBean.returnList1();

	

	if(chkUnchk.equals("Y"))
		pmrForPracBean.addRecordstoLine1(practID);
	else
	{
		if(list != null && list.size() != 0 && list.contains(practID))
			list.remove(practID);
	}
	
	putObjectInBean(beanObj,pmrForPracBean,session);	

/*	ArrayList listTemp = pmrForPracBean.returnList1();

	out.println(listTemp);*/
%>
