<!DOCTYPE html>
<% /*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/ %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
		
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>


<%
//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//======================================================================//

	//String readOnly = "" ;
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String function_id = request.getParameter("function_id") ;
	String bean_id = "catalogsBySection" ;
	String bean_name = "eOR.CatalogsBySection";
	//String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	CatalogsBySection bean = (CatalogsBySection)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	//Connection con=null ;

	try {
	
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();

		String comboString = bean.getComboString();

		firstItem.add("List");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
		firstItem.add("order_category");	//name of field
		firstItem.add("%,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,"+comboString);	// SIZE
		firstItem.add("6");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetID.label","or_labels"));  // label
		secondItem.add("tick_sheet_id");   //name of field
		secondItem.add("6");	// SIZE
		secondItem.add("6");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetDescription.label","or_labels"));  // label
		thirdItem.add("tick_sheet_desc");   //name of field
		thirdItem.add("30");	// SIZE
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr


		//==================== populating the 4th item in the firstitem object

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels"));  // label
		fourthItem.add("section_code");   //name of field
		fourthItem.add("4");
		fourthItem.add("4");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		//=====================================================================

		//==================== populating the 5th item in the firstitem object

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SectionDesc.label","or_labels"));  // label
		fifthItem.add("section_desc");   //name of field
		fifthItem.add("15");
		fifthItem.add("15");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		//==================== populating the 6th item in the firstitem object

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("Text");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));  // label
		sixthItem.add("order_catalog_code");   //name of field
		sixthItem.add("10");
		sixthItem.add("10");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr



		//==================== populating the 7th item in the firstitem object

		ArrayList seventhItem=new ArrayList();
		seventhItem.add("Text");  //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels"));  // label
		seventhItem.add("order_catalog_desc");   //name of field
		seventhItem.add("40");	//LENGTH
		seventhItem.add("40");	//LENGTH
		finAr.add(seventhItem); //add to ArrayList obj finAr


		ArrayList eightItem = new ArrayList();
		eightItem.add("Text");  		 //Type of item
		eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));	  // label
		eightItem.add("order_type_code");	//name of field
		eightItem.add("4");	// SIZE
		eightItem.add("4");	//LENGTH
		finAr.add(eightItem);//add to ArrayList obj finAr

	
		ArrayList nineItem = new ArrayList();
		nineItem.add("Text");  		 //Type of item
		nineItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));	  // label
		nineItem.add("order_type_desc");	//name of field
		nineItem.add("15");	// SIZE
		nineItem.add("15");	//LENGTH
		finAr.add(nineItem);//add to ArrayList obj finAr



		//==================== populating the 10th item in the firstitem object

		function_id = request.getParameter( "function_id" );

		ArrayList tenthItem = new ArrayList();
		tenthItem.add("Hidden");  //Type of item
		tenthItem.add("function_id");  // name of field
		tenthItem.add(function_id);   //value of field
		finAr.add(tenthItem); //add to ArrayList obj finAr


	

		String orderByCols[] = new String[9];
		String orderByColVals[] = new String[9];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetID.label","or_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetDescription.label","or_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SectionDesc.label","or_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
		orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");
		orderByCols[7] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
		orderByCols[8] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
		

	
		orderByColVals[0] = "tick_sheet_id";
		orderByColVals[1] = "tick_sheet_desc";
		orderByColVals[2] = "order_category";
		orderByColVals[3] = "section_code";
		orderByColVals[4] = "section_desc";
		orderByColVals[5] = "order_catalog_code";
		orderByColVals[6] = "order_catalog_desc";
		orderByColVals[7] = "order_type_code";
		orderByColVals[8] = "order_type_desc";


	

		//===============yet to explore================================//

		strbuff = qrypg.getQueryPage(null, finAr, "EORCatalogBySection", "../../eOR/jsp/CatalogBySectionQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		//=========================================================================//

		out.println(strbuff.toString());
		strbuff.setLength(0);

		putObjectInBean(bean_id,bean,request);
		
	}
	catch (Exception e) {
		System.out.println("main"+e);
	}/*finally{
		try
		 { 
			ConnectionManager.returnConnection(con);
		 }catch(Exception e){
			 System.out.println("exception in jsp="+e);
		 
		 }
	}*/
%>


