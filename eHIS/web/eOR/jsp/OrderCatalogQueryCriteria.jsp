<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
08/01/2020	IN068314		Nijitha S     	08/01/2020		Ramesh G		ML-MMOH-CRF-1229
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
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
	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";
	//String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject( bean_id,  bean_name, 	request ) ;  
	bean.setLanguageId(localeName);
	bean.clearALL();
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	Connection con=null ;
	Boolean isFPPApplicableyn =false;//IN068314
	try {
	
		ArrayList finAr = new ArrayList();
		con = ConnectionManager.getConnection(request);//IN068314
		isFPPApplicableyn = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","FPP_APPLICABLE_YN");//IN068314

		String fppApplicableyn="N";//IN068314
		
		//================= populating the second item in the firstitem object
		
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")
);  // label 
		secondItem.add("order_catalog_code");   //name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")
);  // label
		thirdItem.add("long_desc");   //name of field
		thirdItem.add("60");	// SIZE
		thirdItem.add("60");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr


		//==================== populating the 4th item in the firstitem object

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")
);  // label
		fourthItem.add("short_desc");   //name of field
		fourthItem.add("40");
		fourthItem.add("40");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();

		String comboString = bean.getComboString();

		firstItem.add("List");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels")
);	  // label
		firstItem.add("order_category");	//name of field
		firstItem.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---," + comboString);	// SIZE
		firstItem.add("6");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr


		//=====================================================================

		//==================== populating the 5th item in the firstitem object

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels")
);  // label
		fifthItem.add("order_type_code");   //name of field
		fifthItem.add("4");
		fifthItem.add("4");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		//==================== populating the 6th item in the firstitem object

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("Text");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels")
);  // label
		sixthItem.add("order_type_desc");   //name of field
		sixthItem.add("10");
		sixthItem.add("10");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr


		/****************/
		ArrayList seventhItem=new ArrayList();
		seventhItem.add("List");  //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CatalogSynonymType.label","or_labels")
);  // label
		seventhItem.add("catalog_synonym_type");   //name of field
		seventhItem.add("PR,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---,DC,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DirectCare.label","or_labels")+",AD,Ancillary");//static values that need to be displayed as option.Send it along with the value that is inserted.
		seventhItem.add("2");	//LENGTH
		finAr.add(seventhItem); //add to ArrayList obj finAr  
		/****************/
		ArrayList eighth=new ArrayList();
		eighth.add("Text");  //Type of item
		eighth.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CatalogSynonym.label","or_labels")
);  // label
		eighth.add("catalog_synonym");   //name of field
		eighth.add("40");
		eighth.add("40");	//LENGTH
		finAr.add(eighth); //add to ArrayList obj finAr

		/****************/
		ArrayList ninth=new ArrayList();
		ninth.add("List");  //Type of item
		ninth.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels")
);  // label
		ninth.add("eff_status");   //name of field
		ninth.add("''B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		ninth.add("7");	//LENGTH
		finAr.add(ninth); //add to ArrayList obj finAr


		//IN068314 Starts
		if(isFPPApplicableyn)
		{
			ArrayList fppitem=new ArrayList();
			fppitem.add("Check");  //Type of item
			fppitem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FilterByFPP.label","or_labels"));  // label
			fppitem.add("fpp_yn");   //name of field			
			finAr.add(fppitem); //add to ArrayList obj finAr
		}
		//INO68314 Ends


		//==================== populating the 10th item in the firstitem object

		function_id = request.getParameter( "function_id" );

		ArrayList tenthItem = new ArrayList();
		tenthItem.add("Hidden");  //Type of item
		tenthItem.add("function_id");  // name of field
		tenthItem.add(function_id);   //value of field
		finAr.add(tenthItem); //add to ArrayList obj finAr


		//==================== populating the 11th item in the firstitem object

		String module_id = request.getParameter( "module_id" );

		ArrayList eleventhItem = new ArrayList();
		eleventhItem.add("Hidden");  //Type of item
		eleventhItem.add("module_id");  // name of field
		eleventhItem.add(module_id);   //value of field
		finAr.add(eleventhItem); //add to ArrayList obj finAr

		//IN068314 Starts
		if(isFPPApplicableyn)
		{
			fppApplicableyn = "Y";
		}
		ArrayList fppappelement = new ArrayList();
		fppappelement.add("Hidden");  //Type of item
		fppappelement.add("fppApplicableyn");  // name of field
		fppappelement.add(fppApplicableyn);   //value of field
		finAr.add(fppappelement); //add to ArrayList obj finAr
		//IN068314 Ends
	

		String orderByCols[] = new String[7];
		String orderByColVals[] = new String[7];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
//		orderByCols[1] = "Long Desc";
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CatalogSynonymType.label","or_labels");
		orderByCols[6] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CatalogSynonym.label","or_labels");
		
		

	
		orderByColVals[0] = "a.order_catalog_code";
//		orderByColVals[1] = "a.long_desc";
		orderByColVals[1] = "a.short_desc";
		orderByColVals[2] = "a.order_category";
		orderByColVals[3] = "a.order_type_code";
		orderByColVals[4] = "b.short_desc";
		orderByColVals[5] = "d.catalog_synonym_type";
		orderByColVals[6] = "d.catalog_synonym";

	

		//===============yet to explore================================//

		strbuff = qrypg.getQueryPage(con, finAr, "EORCatalogBySection", "../../eOR/jsp/OrderCatalogQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		//=========================================================================//

		out.println(strbuff.toString());
		putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) {
		System.out.println("main"+e);
	}finally{
		try
		 { 
			ConnectionManager.returnConnection(con);
		 }catch(Exception e){System.out.println(e);
		 
		 }
	}
%>


