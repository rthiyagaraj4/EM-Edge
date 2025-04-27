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
		String orderCatalogCode = request.getParameter("OrderCatalogCode") == null ? "":request.getParameter("OrderCatalogCode");
		String orderTypeCode = request.getParameter("OrderTypeCode") == null ? "":request.getParameter("OrderTypeCode");
		String orderCategoryCode = request.getParameter("OrderCatCode") == null ? "":request.getParameter("OrderCatCode");
		String orderCatalogCodeCSV = request.getParameter("OrderCatalogCodes") == null ? "":request.getParameter("OrderCatalogCodes"); //In case of ordersets, multiple values will be present in the csv
		String [] orderCatalogCodes = orderCatalogCodeCSV.split(",");
		String clinComments = request.getParameter("ClinComments") == null ? "":request.getParameter("ClinComments");
		String authorized = request.getParameter("authorized"+orderCategoryCode) == null ? "false":request.getParameter("authorized"+orderCategoryCode);
		String consented = request.getParameter("consented"+orderCategoryCode) == null ? "false":request.getParameter("consented"+orderCategoryCode);
		String cosigned = request.getParameter("cosigned"+orderCategoryCode) == null ? "false":request.getParameter("cosigned"+orderCategoryCode);
		String special_approved = request.getParameter("special_approved"+orderCategoryCode) == null ? "false":request.getParameter("special_approved"+orderCategoryCode);
		
		OrderEntryBean beanObj	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) beanObj.getOrderEntryRecordBean();
		
		orderEntryRecordBean.setOrderFormats(orderCategoryCode+"_CLINICALCOMMENTS", (orderCategoryCode+"_CLINICALCOMMENTS_0"),clinComments);
		beanObj.setTempValues("authorized"+orderCategoryCode,authorized);
		beanObj.setTempValues("consented"+orderCategoryCode,consented);
		beanObj.setTempValues("cosigned"+orderCategoryCode,cosigned);
		beanObj.setTempValues("special_approved"+orderCategoryCode,special_approved);
		
		for(int i=0;i<orderCatalogCodes.length;i++){
			beanObj.setTempValues("start_date_time"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("StartDate-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("end_date_time"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("EndDate-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("order_type_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("OrderType-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("priority"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("Priority-"+orderCatalogCodes[i]),""));
			String quantity = request.getParameter("Quantity-"+orderCatalogCodes[i]);
			if(quantity == null || quantity.trim().equals(""))
				quantity = "1";
			beanObj.setTempValues("quantity"+orderCatalogCodes[i],beanObj.checkForNull(quantity,"1"));
			beanObj.setTempValues("frequency_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("Frequency-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("duration_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("Duration-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("duration_value"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("DurationNum-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("performing_facility_id"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingLocation-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("performing_dept_loc_code"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingDept-"+orderCatalogCodes[i]),""));
			beanObj.setTempValues("performing_facility_desc"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingLocation-"+orderCatalogCodes[i]+"_input"),""));
			beanObj.setTempValues("performing_dept_loc_desc"+orderCatalogCodes[i],beanObj.checkForNull(request.getParameter("PerformingDept-"+orderCatalogCodes[i]+"_input"),""));
		}
		
		
		
		//Setting all the values entered in the form
		//beanObj.setTempValues(key,value);
		putObjectInBean(or_bean_id,beanObj,request);
	}
}catch(Exception e){
	System.out.println(e.getMessage());
}
%>
