
<%
/*
-----------------------------------------------------------------------------------------
Date       		Edit History     	Name        Rev.Date  		 Rev.By			Description
-----------------------------------------------------------------------------------------
17/07/2018	  	IN064543		Kamalakannan	17/07/2018		Ramesh G		ML-MMOH-CRF-0776
------------------------------------------------------------------------------------------
*/
%>
<%@page import="eOR.*, java.sql.*,webbeans.eCommon.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<% 
	request.setCharacterEncoding("UTF-8");
	String bean_id = "OR_OrderEntryQueryBean" ;
	String bean_name = "eOR.OrderEntryQueryBean";
	OrderEntryQueryBean bean = (OrderEntryQueryBean)getBeanObject( bean_id, bean_name , request ) ;
	String mode	   = "1";
	request.setCharacterEncoding("UTF-8");
	bean.clear() ;
	bean.setMode( mode ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;
	String action = (String)hash.get("action");
	if("VALIDATE_FOR_WINDOW_INVOKE".equalsIgnoreCase(action)){
		String order_catalog_nature =  (String)hash.get("order_catalog_nature");
		String contr_msr_panel_id =  (String)hash.get("contr_msr_panel_id"); 
		String measure_id =  (String)hash.get("measure_id");
		String category =  (String)hash.get("category");
		bean_id  = (String)hash.get("bean_id");
		bean_name   =  (String)hash.get("bean_name");
		String catalog_code  =  (String)hash.get("catalog_code"); 
		String catalog_desc  =  (String)hash.get("catalog_desc");
		String encounter_id   =  (String)hash.get("encounter_id");
		String patient_class   =  (String)hash.get("patient_class");
		String admission_date   =  (String)hash.get("admission_date");
		String discharge_date_time    =  (String)hash.get("discharge_date_time"); 
		String pract_type    = (String)hash.get("pract_type");
		if("P".equals(order_catalog_nature)){
			int PanelCount = bean.getCatalogCodeForPanelCount((String)hash.get("contr_msr_panel_id"));
			out.println("openInstructionModal('"+PanelCount+"','"+measure_id+"','"+contr_msr_panel_id+"','"+order_catalog_nature+"','"+category+"','"+bean_id+"','"+bean_name+"','"+catalog_desc+"','"+encounter_id+"','"+patient_class+"','"+admission_date+"','"+discharge_date_time+"','"+catalog_code+"','"+pract_type+"')");
		}else if("S".equals(order_catalog_nature)){
			int OrderSetCount = bean.getCatalogCodeForOrderSetCount((String)hash.get("measure_id"));
			out.println("openInstructionModal('"+OrderSetCount+"','"+measure_id+"','"+contr_msr_panel_id+"','"+order_catalog_nature+"','"+category+"','"+bean_id+"','"+bean_name+"','"+catalog_desc+"','"+encounter_id+"','"+patient_class+"','"+admission_date+"','"+discharge_date_time+"','"+catalog_code+"','"+pract_type+"')");
		}
	}else if("INVOKE_MULTIPLE_INSTRN".equalsIgnoreCase(action)){
		String strIndex =  (String)hash.get("index");
		int index = Integer.parseInt(strIndex);
		String catalogCode =  (String)hash.get("catalogCode");
		String key =  (String)hash.get("key");
		
			out.println("loadValueInIntermediate('"+index+"','"+key+"','"+catalogCode+"')");
		
	}else if("VALIDATE_ORDERSET_TAB".equals(action)){
		String care_sets =  (String)hash.get("care_sets");
		int OrderSetCount = bean.getCatalogCodeForOrderSetCount((String)hash.get("care_sets"));
		if(OrderSetCount>0)
			out.println("ENABLE");
	}
%>
