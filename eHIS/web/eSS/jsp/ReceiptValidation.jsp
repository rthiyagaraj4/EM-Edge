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
//	HashMap dataMap				=	 null;
	String bean_id				=	 "receiptBean" ;
	String bean_name			=	"eSS.ReceiptBean";
	ReceiptBean bean			=	(ReceiptBean)getBeanObject( bean_id, bean_name,request );  
	Hashtable hash				=	(Hashtable)XMLobj.parseXMLString( request ) ;
//	out.println(hash);
	hash						=	(Hashtable)hash.get( "SEARCH" ) ;
	if(request.getParameter("function_id").equals("Receipt_add_modify")){
	String rof_doc_type_code	=	request.getParameter( "rof_doc_type_code" ) ==null?"":request.getParameter( "rof_doc_type_code" );
	String rof_doc_no			=	request.getParameter( "rof_doc_no" ) ==null?"":request.getParameter( "rof_doc_no" );
	String doc_date				=	request.getParameter( "doc_date" ) ==null?"":request.getParameter( "doc_date" );
	String store_code			=	request.getParameter( "store_code" ) ==null?"":request.getParameter( "store_code" );
	String location				=	request.getParameter( "location" ) ==null?"":request.getParameter( "location" );
	String doc_ref				=	request.getParameter( "doc_ref" ) ==null?"":request.getParameter( "doc_ref" );
	

	bean.setStore_code(store_code) ;
	bean.setRof_doc_type_code(rof_doc_type_code) ;
	bean.setRof_doc_no(rof_doc_no) ;
	bean.setDoc_date(doc_date) ;
	bean.setDoc_ref(doc_ref) ;
	bean.setLocation(location) ;
	

//	ArrayList result=new ArrayList();
	
	bean.loadData();
	}
	/*else if(request.getParameter("function_id").equals("washing_detail")){
		int start			=	Integer.parseInt(request.getParameter("start"));
		int end			=	Integer.parseInt(request.getParameter("end"));
		int totalRecords			=	Integer.parseInt(request.getParameter("totalRecords"));
	//out.println(request.getQueryString());
		
		bean.updateSelectedTrays(hash, start, end,totalRecords);
		//out.println(bean.getDataList());
	}
	else if(request.getParameter("function_id").equals("get_temperature")){
			String washing_unit			=	request.getParameter("washing_unit");
			String Temperature="";
			Temperature=bean.getWashUnitTemperature(washing_unit);
			
			out.println("document.forms[0].temperature.value=\""+Temperature+"\";");
	}*/

putObjectInBean(bean_id,bean,request);

%>
