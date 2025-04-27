<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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
	
	/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String function_id = request.getParameter("function_id") ;

	String bean_id = "Or_WaitTimePendingOrders" ;
	String bean_name = "eOR.WaitTimePendingOrdersBean";
	//String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	WaitTimePendingOrdersBean bean =
	(WaitTimePendingOrdersBean)getBeanObject( bean_id,bean_name, request );  
	bean.clear() ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	Connection con=null ;

	try {
	
		con = ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
				
		String comboString = bean.getComboString();
		
		ArrayList firstItem = new ArrayList();
		firstItem.add("List");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
		firstItem.add("order_category");	//name of field
		firstItem.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--- ,"+comboString);	// SIZE
		firstItem.add("6");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));  // label
		secondItem.add("order_type_code");   //name of field
		secondItem.add("4");	// SIZE
		secondItem.add("4");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));  // label
		thirdItem.add("order_type_desc");   //name of field
		thirdItem.add("40");	//SIZE
		thirdItem.add("40");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr


		//==================== populating the 4th item in the firstitem object

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));  // label
		fourthItem.add("order_catalog_code");   //name of field
		fourthItem.add("4");//SIZE
		fourthItem.add("4");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr
	
		//================= populating the 3rd item in the firstitem object

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels"));  // label
		fifthItem.add("order_catalog_desc");   //name of field
		fifthItem.add("40");	//SIZE
		fifthItem.add("40");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr


		//==================== populating the 5th item in the firstitem object

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		sixthItem.add("active_stat");   //name of field
		sixthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		sixthItem.add("7");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr




		function_id = request.getParameter( "function_id" );

		ArrayList seventhItem = new ArrayList();
		seventhItem.add("Hidden");  //Type of item
		seventhItem.add("function_id");  // name of field
		seventhItem.add(function_id);   //value of field
		finAr.add(seventhItem); //add to ArrayList obj finAr


		//=====================================================================

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		//orderByCols[0] = "Matrix Row Code";
		//orderByCols[1] = "Matrix Row Desc";
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");
			
		orderByColVals[0] = "order_catalog_code";
		orderByColVals[1] = "order_category";
		orderByColVals[2] = "order_type_code";
		orderByColVals[3] = "order_type_desc";
		orderByColVals[4] = "order_catalog_desc";
	
	

		//===============yet to explore================================//

		strbuff = qrypg.getQueryPage(con, finAr, "OrganismQuery", "../../eOR/jsp/WaitTimePendingOrdersQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		//===================================================================//

		out.println(strbuff.toString());
		strbuff.setLength(0);
		putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) {
		System.out.println("main"+e);
	}finally{
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		 }catch(Exception e){
			 System.out.println("caught exception="+e);
		 
		 }
	}
%>


