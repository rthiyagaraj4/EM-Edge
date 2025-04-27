<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           	created
18/12/2013  IN045729    Chowminya		Appointments slip showing a blank page for radiology orders Multi-facility
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=ISO-8859-1"%>
<%-- JSP Page specific attributes end --%>

 
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	String facility_id			= (String)session.getValue("facility_id");

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;

	String order_category 		= (String)hash.get("order_category");
	String appt_ref_num 		= (String)hash.get("appt_ref_num");
	String performing_facility_id = (String)hash.get("performing_facility_id"); //IN045729
   
    HashMap allValues			= new HashMap();
			allValues.put("order_category",order_category);
			allValues.put("appt_ref_num",appt_ref_num);
			//allValues.put("facility_id",facility_id);//IN045729 to send performing_facility_id to handle multi facility
			allValues.put("facility_id",performing_facility_id); //IN045729

	out.println("alert('APP-OR0148 Report has been Submitted to the Printer')");
 	OnLinePrinting online_print = new OnLinePrinting();
	online_print.callRDOTOnLinePrint(allValues,request,response);
 %>
