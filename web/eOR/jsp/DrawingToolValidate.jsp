<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, eOR.Common.*, eOR.*"  contentType="text/html;charset=ISO-8859-1"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%

	//String bean_id				= request.getParameter( "bean_id" ) ;
	//String bean_name 			= request.getParameter( "bean_name" ) ;
	//if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
	//	return ;
	String patient_id 			= request.getParameter( "patient_id" ) ;
	String encounter_id 		= request.getParameter( "encounter_id" ) ;
	/* Initialize Function specific start */
	//OrderEntryBean bean			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	/* Initialize Function specific end */
	String bean_id1				= "@OrderEntryDrawingToolBean"+patient_id+encounter_id;
	String bean_name1			= "eOR.OrderEntryDrawingToolBean";
	 /* Initialize Function specific start */
	//OrderEntryDrawingToolBean beanObj = (OrderEntryDrawingToolBean)mh.getBeanObject( bean_id1, request,  bean_name1 ) 	;
	OrderEntryDrawingToolBean beanObj = (OrderEntryDrawingToolBean)getBeanObject( bean_id1, bean_name1, request ) ;
	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash						= (Hashtable)hash.get( "SEARCH" ) ;

	String image				= beanObj.checkForNull((String)hash.get("image_content"),"") ;
	if(!image.equals(""))
			beanObj.setImage(image);
 	// Call the method to apply 		
	out.println( "callBeforeApply();" ) ;
		
	putObjectInBean(bean_id1,beanObj,request);
 %>
