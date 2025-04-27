
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	
	//Properties properties			= (Properties) session.getValue( "jdbc" ); 
	String localeName=(String)session.getAttribute("LOCALE");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	System.out.println("hash @33"+hash);
	String bean_id 	= (String)hash.get("BEAN_ID");
	String bean_name = (String)hash.get( "BEAN_NAME" ) ;
	String validate = (String)hash.get( "FUNC_MODE" ) ;
	//String called_from = (String)hash.get( "CALLED_FROM" ) ;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	
	CancelOrder bean = (CancelOrder)getBeanObject( bean_id, bean_name, request ) ;
	
	bean.setLanguageId(localeName);
	 if(validate.equalsIgnoreCase("PRINT_VALUES"))	// To Print the values
	{
		// Call a method to print a report for the order_id generated
		//, beanObj.getStorePrintValues()
 		//beanObj.callOnLineCancelPrinting(beanObj.getPrintValues(), beanObj.getStoreSpecimenPrintValues(), request, response); // Call the Printing Method to print

		//Clear the bean values set for printing
		//beanObj.clearPrintingValues();
		Hashtable tabDataPrint = new Hashtable();
		tabDataPrint=(Hashtable)bean.getStoreReportPrintValues();
		if(tabDataPrint!=null)
		{
			if (tabDataPrint.size() > 0) 
			{
				tabDataPrint.put("p_language_id","en");
				tabDataPrint.put("p_module_id","OR");
			}
			System.out.println("46 CancelOrderValidate"+tabDataPrint);
			 if (tabDataPrint.size() > 0) 
			{
				bean.callOnLineCancelPrinting(tabDataPrint, request, response);
			}
		}
	}
    
	putObjectInBean(bean_id,bean,request);
%>
