<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, eOR.Common.*, eOR.*" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%
	// Dynamic Jsp to populate the List Boxes in Order Entry
	request.setCharacterEncoding("UTF-8");
	 
	String func_mode 		= request.getParameter( "func_mode" ) ;
	String localeName=request.getParameter("localeName");
   	  beanQueryObj.setLanguageId(localeName);
	
	if ( func_mode == null || func_mode.equals( "" ) )
		return ;

	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash = (Hashtable)hash.get( "SEARCH" ) ;

    // Population of the List box of UOM , when the dosage by is changed in the orderentrycaresetresults (order set)

	if ( func_mode.equals("PH_POPULATE_UOM"))
	{
		String form_code	 		= beanQueryObj.checkForNull((String)hash.get("form_code"),"") ;
		String dosage_by	 		= beanQueryObj.checkForNull((String)hash.get("dosage_by"),"") ;
		String strength_uom_desc	= beanQueryObj.checkForNull((String)hash.get("strength_uom_desc"),"") ;
		String row					= beanQueryObj.checkForNull((String)hash.get("row"),"") ;
		Properties properties		= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
		
		String[] record 			= null;
		out.println( "clearUOMList('document.placeOrderForm',\""+row+"\") ; " ) ;
		if(dosage_by!=null && dosage_by.equals("S")) {
			out.println( "addUOMList('document.placeOrderForm',\""+row+"\",\"" +strength_uom_desc+" \",\"" +strength_uom_desc+"\") ; " ) ;
        } else {
			ArrayList FormCode = beanQueryObj.getUOMDetails(properties, form_code) ; // Calling the bean method
			for( int i=0 ; i< FormCode.size() ; i++ ) {
				record 		= (String[])FormCode.get(i);
				out.println( "addUOMList('document.placeOrderForm',\""+row+"\",\"" +record[0]+" \",\"" +record[1]+"\") ; " ) ;
			}	
		} // End of if dosage_type
	} // end of func_mode PH_POPULATE_UOM
%>
