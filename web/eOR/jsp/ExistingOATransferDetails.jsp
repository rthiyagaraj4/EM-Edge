<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%> 
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
 	String validate			= request.getParameter( "validate" ) ;
 	String facility_id		= (String)session.getValue("facility_id");
   
	if ( validate == null || validate.equals( "" ) )
		return ;

	String bean_id			= "Or_ViewOrder" ;
	String bean_name		= "eOR.ViewOrder";
	//ViewOrder bean		= (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name) ;
	ViewOrder bean			 = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
			
	bean.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash			= (Hashtable)XMLobj.parseXMLString( request ) ;
	 hash					= (Hashtable)hash.get( "SEARCH" ) ;

	String appt_ref_num		= (String) hash.get( "appt_ref_num" ) ;
	String start_date_time	= (String) hash.get( "start_date_time" ) ;
	String order_id	= (String) hash.get( "order_id" ) ;//--[IN027165]--
    if ( validate.equals( "OA_APPT_DETAILS" ) ) {
 			String[] record = null;
 			ArrayList TransferApptDetails = bean.getViewApptTransferDtls(appt_ref_num, facility_id) ;
 			for( int i=0 ; i< TransferApptDetails.size() ; i++ ) {  //only one record
				record = (String[])TransferApptDetails.get(i);
				out.println( "viewTransferDetails(\""+appt_ref_num+"\", \""+start_date_time+"\",\""+order_id+"\", \"" + record[0] + "\",\"" + record[1] + "\" , \"" + record[2] + "\" , \"" + record[3] + "\" , \"" + record[4] + "\" , \"" + record[5] + "\" , \"" + record[6] + "\" , \"" + record[7] + "\" , \"" + record[8] + "\" , \"" + record[9] + "\" , \"" + record[10] + "\" , \"" + record[11] + "\" , \"" + record[12] + "\" , \"" + record[13] + "\") ; " ) ;
			}
	 	}
		
 	//	putObjectInBean(bean_id,bean,request);
%>
