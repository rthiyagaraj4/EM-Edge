<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	ViewOrder beanObj = (ViewOrder)getBeanObject( bean_id,"eOR.ExistingOrder" ,request ) ;
	beanObj.setLanguageId(localeName);

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	if ( validate.equals( "PRINT" ) ) {
		String ord_typ_code = (String)hash.get("ord_typ_code") ;
		String patient_class = (String)hash.get("patient_class") ;
		String priority = (String)hash.get("priority") ;
		String ord_id = (String)hash.get("ord_id") ;
		String source_type = (String)hash.get("source_type") ;
		String location_code = (String)hash.get("location_code") ;
		String report_srl_no = (String)hash.get("report_srl_no") ;

    	Hashtable repDataPrint 	= new Hashtable();
		repDataPrint.clear();

		repDataPrint.put("facility_id",(String)session.getValue("facility_id"));
		repDataPrint.put("source_type",beanObj.checkForNull(source_type));
		repDataPrint.put("ord_typ_code",beanObj.checkForNull(ord_typ_code));
		repDataPrint.put("patient_class",beanObj.checkForNull(patient_class));
		repDataPrint.put("priority",beanObj.checkForNull(priority));
		repDataPrint.put("ord_id",beanObj.checkForNull(ord_id));
		repDataPrint.put("location_code",beanObj.checkForNull(location_code));
		repDataPrint.put("report_srl_no",beanObj.checkForNull(report_srl_no));

		OnLinePrinting online_print = new OnLinePrinting();
		online_print.printResultEntryReport(repDataPrint,request,response); //Pass the Hashtable 
		//HashMap map = online_print.printResultEntryReport(repDataPrint); //Pass the Hashtable print_values (Stored in generateUniqueIds() )
		//out.println("alert('traceVal="+(String)map.get("traceVal")+"');");

		out.println("alert(getMessage('RPT_SUBMIT_TO_PRINTER','OR'));");

	}

	putObjectInBean(bean_id, beanObj ,request);
%>
