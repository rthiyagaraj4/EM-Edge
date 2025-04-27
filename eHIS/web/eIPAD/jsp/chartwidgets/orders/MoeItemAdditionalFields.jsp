<!DOCTYPE html>
<%@page import="eOR.OrderEntryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<jsp:useBean id="beanFormatObj" scope="page" class="eOR.OrderEntryFormatBean"/>
<% 
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
try
{
	if(patientContext!=null){
		String patientId = patientContext.getPatientId();
		String encounterId = patientContext.getEncounterId();
		String localeName = patientContext.getLocale();
		String or_bean_id = "@orderentrybeanm"+patientId+encounterId;
		String or_bean_name = "eOR.OrderEntryBean";
		OrderEntryBean bean	= (OrderEntryBean)PersistenceHelper.getBeanObject(or_bean_id,or_bean_name,request);
		beanQueryObj.setLanguageId(localeName);
		beanFormatObj.setLanguageId(localeName);
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean 	= (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
		ArrayList OrderFormat = null;
		Hashtable template				= null;
		String field_mnemonic = null;
		String records[]				= null;
		int seq_num						= 0;
		int max_dependency_row = 0;
		
		Properties properties			= (Properties) session.getValue( "jdbc" );
		String orderCatalogCode = request.getParameter("OrderCatalogCode") == null ? "":request.getParameter("OrderCatalogCode");
		String orderTypeCode = request.getParameter("OrderTypeCode") == null ? "":request.getParameter("OrderTypeCode");
		String orderCategoryCode = request.getParameter("OrderCatCode") == null ? "":request.getParameter("OrderCatCode");
		String format_id = request.getParameter("FormatId") == null ? "":request.getParameter("FormatId");
		String catalog_code = orderCatalogCode;
		String order_type_code = orderTypeCode;
		String order_category = orderCategoryCode;
		
		
		OrderFormat				= bean.getOrderFormat(format_id,order_category,"","","","R",bean.getSex(), bean.getDob(),bean.getLoginFacilityId(),catalog_code,order_type_code,patientId);	    
		out.println("<br>OrderFormat ArrayList size: "+OrderFormat.size());
		for(int k=0; k<OrderFormat.size(); k++)
		{
			records = (String[])OrderFormat.get(k);
			field_mnemonic	 = bean.checkForNull(records[0],"0");
			seq_num = (Integer.parseInt(bean.checkForNull(records[1],"0")));
			template			 = beanQueryObj.buildHashTable(properties, seq_num, patientId, "", format_id, order_type_code, "" ,field_mnemonic,  records);
			max_dependency_row = Integer.parseInt(bean.checkForNull((String) template.get("max_dependency_row"),"0"));
			System.out.println("Template:  "+template.toString());
		}
	
	}
	else{
		out.println("No Patient context");
	}
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
