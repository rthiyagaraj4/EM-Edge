<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="eOR.Common.OrderEntryRecordBean"%>
<%@ page import="eOR.OrderEntryBean"%>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
try{
	if(patientContext!=null){
		String patientId = patientContext.getPatientId();
		String encounterId = patientContext.getEncounterId();
		String locale = patientContext.getLocale();
		String or_bean_id = "@orderentrybeanm"+patientId+encounterId;
		String or_bean_name = "eOR.OrderEntryBean";
		String key = request.getParameter("key") == null ?"":request.getParameter("key");
		String value = request.getParameter("value") == null ? "":request.getParameter("value");
		OrderEntryBean beanObj	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
		if(!key.equals("")){
			beanObj.setTempValues(key, value);
		}
		putObjectInBean(or_bean_id,beanObj,request);
	}
}catch(Exception e){
	System.out.println(e.getMessage());
}
%>
