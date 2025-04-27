<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% /*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
03/07/2013    IN039857		 Chowminya G    	Print Button from result view page for LB order-Added the file
25/02/2015	  IN053439		 Vijayakumar K		MMS-QF-SCF-0486 [IN:053439] - Not able to print the 
												result � showing status partial resulted and colour status Expired	
26/05/2015	  IN054720		 Vijayakumar K		ML-BRU-SCF-1580 [IN:054720]
18/07/2018   IN061961		sivabagyam M    18/07/2018		Ramesh G		GHL-CRF-0433
24/02/2022	 	25671			Ramesh G											NMC-JD-CRF-0091.2 
-------------------------------------------------------------------------------------------------------------------------------------
*/%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,java.sql.*" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	Connection con=null;
try{
	 con=ConnectionManager.getConnection(request);
	Hashtable allValues = (Hashtable)XMLobj.parseXMLString( request ) ;
    allValues = (Hashtable)allValues.get( "SEARCH" ) ;
    String order_catalog_code = (String)allValues.get("order_catalog_code");//IN061961
    String view_by = (String)allValues.get("view_by");//IN061961
	String bean_id = (String)allValues.get("bean_id");
	request.setCharacterEncoding("UTF-8");
	String localeName=request.getParameter("localeName");
	String bean_name = "eOR.ViewOrder";
 	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request   ) ;

	bean.setLanguageId(localeName);
	OnLinePrinting online_print = new OnLinePrinting();

	//Hashtable resultHash	= new Hashtable();//commented for IN061961 checkstyle
	Hashtable orderHash		= new Hashtable();
	//boolean isviewLineDtls= bean.isSiteSpecific("DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961	
	boolean isviewLineDtls = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","DISP_LB_ORDER_DTLS_INDIV_LVL");//IN061961
	int order_count			= 0;
	orderHash.put("ord_typ_code"+order_count,((String)allValues.get("ord_typ_code")));
	orderHash.put("ord_typ_desc"+order_count,((String)allValues.get("ord_typ_desc")));
	orderHash.put("patient_class"+order_count,((String)allValues.get("patient_class")));
	orderHash.put("priority"+order_count,((String)allValues.get("priority")));
	orderHash.put("ord_id"+order_count,((String)allValues.get("ord_id")));
	orderHash.put("source_type"+order_count,((String)allValues.get("source_type")));
	orderHash.put("location_code"+order_count,((String)allValues.get("location_code")));
	orderHash.put("order_category"+order_count,((String)allValues.get("order_category")));
	orderHash.put("cont_order_ind"+order_count,((String)allValues.get("cont_order_ind"))); //IN053439
	orderHash.put("performing_facility_id"+order_count,((String)allValues.get("performing_facility_id"))); //IN054720
	orderHash.put("order_catalog_code"+order_count,((String)allValues.get("order_catalog_code")));//IN061961
	orderHash.put("view_by"+order_count,((String)allValues.get("view_by")));//IN061961
			
 	order_count++;

	orderHash.put("order_entry","ViewOrder");
 	orderHash.put("facility_id",checkForNull((String)allValues.get("facility_id")));
	orderHash.put("mode",checkForNull((String)allValues.get("mode")));
	orderHash.put("total_recs",""+order_count);
	orderHash.put("isviewLineDtls",isviewLineDtls);//IN061961
	orderHash.put("includeESignature",((String)allValues.get("includeESignature"))); //25671

	online_print.callOnlinePrint(orderHash, request, response);
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
<%!

String checkForNull( String inputString, String defaultValue ) {
	return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
}
String checkForNull( String inputString ) {
        return ( inputString == null )  ?   ""  :   inputString;
}
%>
