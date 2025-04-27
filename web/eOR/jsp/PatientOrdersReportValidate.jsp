<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=ISO-8859-1"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id = "";//request.getParameter( "bean_id" ) ;
	String order_category = "";//request.getParameter( "validate" ) ;
	//String bean_name = request.getParameter( "bean_name" ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString(request) ;
    hash = (Hashtable)hash.get("SEARCH") ;
	bean_id = (String)hash.get("bean_id") ;
	order_category = (String)hash.get("ord_cat") ;
	
	//PatientOrdersReportBean beanObj = (PatientOrdersReportBean)mh.getBeanObject( bean_id, request , "eOR.PatientOrdersReportBean") ;
	PatientOrdersReportBean beanObj = (PatientOrdersReportBean)getBeanObject( bean_id, "eOR.PatientOrdersReportBean", request ) ;
	
	ArrayList print_order=beanObj.getOrderTypeData(order_category);
	//String outString = "";
	out.println( "addLocationList(\"\" ,\"All\") ; " ) ;
	out.println( "addLocationList1(\"\" ,\"All\") ; " ) ;
	for(int i=0 ; i<print_order.size() ; i++)
	//for(int i=0 ; i<2; i++)
	{
		String[] record = (String []) print_order.get(i);
	//	if(record[0].equals("") || record[1].equals(""))
		//	continue;
		out.println( "addLocationList(\"" +record[0]+" \",\"" +record[1]+"\") ; " ) ;
		out.println( "addLocationList1(\"" +record[0]+" \",\"" +record[1]+"\") ; " ) ;
		//outString += record[0];
		//outString += "|";
		//outString += record[1];
		//outString += "|";
	}
	//out.println(outString);

	putObjectInBean(bean_id,beanObj,request);
%>
