<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%

	String bean_id				=		"WashingBean" ;
	String bean_name			=		"eSS.WashingBean";
	WashingBean bean			=		(WashingBean)getBeanObject( bean_id,   bean_name, request) ;  
	Hashtable hash				=		(Hashtable)XMLobj.parseXMLString( request ) ;

	hash						=		(Hashtable)hash.get( "SEARCH" ) ;


	if(request.getParameter("function_id").equals("washing_add_modify")){
	String rof_doc_type_code	=		request.getParameter("rof_doc_type_code");
	String	store_code			=		request.getParameter("store_code");
	String	washing_type		=		request.getParameter("washing_type");

	bean.setStore_code(store_code) ;
	bean.setRof_doc_type_code(rof_doc_type_code) ;
	bean.setWashing_type(washing_type) ;

	
	bean.loadData();out.println(bean.getDataList());
	}
	else if(request.getParameter("function_id").equals("washing_detail")){
		int start				=		Integer.parseInt(request.getParameter("start"));
		int end					=		Integer.parseInt(request.getParameter("end"));
		int totalRecords		=		Integer.parseInt(request.getParameter("totalRecords"));

		
		bean.updateSelectedTrays(hash, start, end,totalRecords);
		
	}
	else if(request.getParameter("function_id").equals("get_service_location")){
		try
          {
			 String washing_unit_code	=	request.getParameter("washing_unit");
			
	         HashMap hmRecord		    =	bean.fetchRecord(bean.getSsRepositoryValue("SQL_SS_WASHING_UNIT_SERVICE_LOCATION"),washing_unit_code);
			 out.println("document.formWashing.service_location.value=\""+bean.checkForNull((String)hmRecord.get("SERVICE_LOC_DESC"))+"\"");
	
          }catch(Exception e){
                  System.err.println(e);
	          }

	}
	else if(request.getParameter("function_id").equals("get_temperature")){
			String washing_unit			=	request.getParameter("washing_unit");
			String Temperature			=	"";
			Temperature					=	bean.getWashUnitTemperature(washing_unit);
			
			out.println("document.forms[0].temperature.value=\""+bean.checkForNull(Temperature)+"\";");
	}
	else if(request.getParameter("function_id").equals("washing_delete")){
			int start				=	Integer.parseInt(request.getParameter("start"));
			int end					=	Integer.parseInt(request.getParameter("end"));
			int totalRecords		=	Integer.parseInt(request.getParameter("totalRecords"));
		
		bean.updateUnselectedTrays(hash, start, end,totalRecords);
		
		
	}
	

putObjectInBean(bean_id,bean,request);

%>
