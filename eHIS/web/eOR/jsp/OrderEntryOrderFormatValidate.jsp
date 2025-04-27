<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, eOR.Common.*, eOR.*"  contentType="text/html; charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	// Dynamic Jsp to populate the List Boxes in Order Entry Format
	request.setCharacterEncoding("UTF-8");
	String bean_id 			= request.getParameter( "bean_id" ) ;
	String bean_name 		= request.getParameter( "bean_name" ) ;
	String func_mode 		= request.getParameter( "func_mode" ) ;
	String localeName=request.getParameter("localeName");	

	if ( bean_id == null || bean_id.equals( "" ) || bean_name == null || bean_name.equals(""))
		return ;

	if ( func_mode == null || func_mode.equals( "" ) )
		return ;

	/* Initialize Function specific start */
	//OrderEntryBean beanObj = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean beanObj = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		beanObj.setLanguageId(localeName);

	/* Initialize Function specific end */
	Hashtable hash 		= (Hashtable)XMLobj.parseXMLString( request ) ;
   	hash				= (Hashtable)hash.get( "SEARCH" ) ;

	String mobile_required_yn 		= beanObj.checkForNull((String)hash.get("mobile_required_yn"),"N") ;
	String contr_msr_panel_id 		= beanObj.checkForNull((String)hash.get("contr_msr_panel_id"),"") ;
	//String contr_msr_mod_id 		= beanObj.checkForNull((String)hash.get("contr_msr_mod_id"),"") ;
	
	String performing_facility_id 	= beanObj.checkForNull((String)hash.get("performing_facility_id"),"") ;
	String code 					= beanObj.checkForNull((String)hash.get("code"),"") ;
	String order_category 			= beanObj.checkForNull((String)hash.get("order_category"),"") ;
	ArrayList OrderFormatList		= null;
	String[] record					= null;

	// Called from OrderLineFormat(Flex Fields) for the mobile_required_yn is "Y" to populate the study location
	if ( func_mode.equals("POPULATE_STUDY_LOCATION"))  //To populate the Study Location(field_mnemonic) list box
	{
		out.println( "clearStudyLocationList('STUDY_LOC',\""+code+"\") ; " ) ; //StudyLocation
		OrderFormatList = beanObj.getStudyLocation(order_category,contr_msr_panel_id,performing_facility_id,mobile_required_yn);
		for(int l=0; l<OrderFormatList.size(); l++)
		{
			record 		= (String[])OrderFormatList.get(l);
			System.out.println("record[0] in validate"+record[0]);
			System.out.println("record[1] in validate"+record[1]);
			out.println( "addStudyLocationList('STUDY_LOC',\"" +record[0]+" \",\"" +record[1]+"\") ; " ) ;
		}
	} // End of for


	// no need to set it back persistence
	// putObjectInBean(bean_id,beanObj,request);
%>
