<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
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
	String bean_id = "privilege" ;
	String bean_name = "eOR.PrivilegeBean";
	//String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	PrivilegeBean bean = (PrivilegeBean)getBeanObject( bean_id,bean_name ,request) ;  
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	//Connection con=null ;

	try {
	
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		
		
		
		//==================== populating the 13th item in the firstitem object

		
		//================= populating the second item in the firstitem object

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.appluserid.label","common_labels"));  // label
		secondItem.add("appl_user_id");   //name of field
		secondItem.add("10");	// SIZE
		secondItem.add("15");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ApplicationUser.label","or_labels"));  // label
		thirdItem.add("appl_user_name");   //name of field
		thirdItem.add("30");	// SIZE
		thirdItem.add("60");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr


		//==================== populating the 4th item in the firstitem object

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels"));  // label
		fourthItem.add("resp_id");   //name of field
		fourthItem.add("10");
		fourthItem.add("20");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		//=====================================================================

		//==================== populating the 5th item in the firstitem object

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels"));  // label
		fifthItem.add("resp_name");   //name of field
		fifthItem.add("30");
		fifthItem.add("60");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		//==================== populating the 6th item in the firstitem object

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("Text");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RelationId.label","or_labels"));  // label
		sixthItem.add("reln_id");   //name of field
		sixthItem.add("10");
		sixthItem.add("20");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr



		//==================== populating the 7th item in the firstitem object

		ArrayList seventhItem=new ArrayList();
		seventhItem.add("Text");  //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RelationName.label","or_labels"));  // label
		seventhItem.add("pract_reln_name");   //name of field
		seventhItem.add("30");	//LENGTH
		seventhItem.add("60");	//LENGTH
		finAr.add(seventhItem); //add to ArrayList obj finAr


		ArrayList eightItem = new ArrayList();
		eightItem.add("Text");  		 //Type of item
		eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Privilege.label","or_labels"));	  // label
		eightItem.add("privilege_id");	//name of field
		eightItem.add("4");	// SIZE
		eightItem.add("4");	//LENGTH
		finAr.add(eightItem);//add to ArrayList obj finAr

	
		ArrayList nineItem = new ArrayList();
		nineItem.add("Text");  		 //Type of item
		nineItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));// label
		nineItem.add("facility_id");	//name of field
		nineItem.add("10");	// SIZE
		nineItem.add("15");	//LENGTH
		finAr.add(nineItem);//add to ArrayList obj finAr

		ArrayList firstItem = new ArrayList();
		firstItem.add("Hidden");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Level.label","common_labels"));	  // label
		firstItem.add("privilege_ctx");	//name of field
		firstItem.add(" ,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.user.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.relationship.label","common_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels")+"");//static 
		firstItem.add("30");	// SIZE
		firstItem.add("30");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		function_id = request.getParameter( "function_id" );

		ArrayList thirdteenItem = new ArrayList();
		thirdteenItem.add("Hidden");  //Type of item
		thirdteenItem.add("function_id");  // name of field
		thirdteenItem.add(function_id);   //value of field
		finAr.add(thirdteenItem); //add to ArrayList obj finAr


/*
		ArrayList tenthItem = new ArrayList();
		tenthItem.add("Text");  		 //Type of item
		tenthItem.add("Facility Name");// label
		tenthItem.add("facility_name");	//name of field
		tenthItem.add("15");	// SIZE
		tenthItem.add("15");	//LENGTH
		finAr.add(tenthItem);//add to ArrayList obj finAr

		ArrayList eleventhItem = new ArrayList();
		eleventhItem.add("Text");  		 //Type of item
		eleventhItem.add("Privilege Value");// label
		eleventhItem.add("privilege_value");	//name of field
		eleventhItem.add("15");	// SIZE
		eleventhItem.add("15");	//LENGTH
		finAr.add(eleventhItem);//add to ArrayList obj finAr

		ArrayList tewelthItem = new ArrayList();
		tewelthItem.add("List");  		 //Type of item
		tewelthItem.add("Active");// label
		tewelthItem.add("active_yn");	//name of field
		tewelthItem.add(" ,Both,Y,Yes,N,No");//static 
		tewelthItem.add("15");	// SIZE
		tewelthItem.add("15");	//LENGTH
		finAr.add(tewelthItem);//add to ArrayList obj finAr

//modified by Subhash.Y on 4th May 2004

*/




	

		String orderByCols[] = new String[7];// actual value 8
		String orderByColVals[] = new String[7];// actual value 8

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.appluserid.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ApplicationUser.label","or_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RelationId.label","or_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.RelationName.label","or_labels");
		orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
		//orderByCols[7] = "Facility Name";
		
		orderByColVals[0] = "resp_id";
		orderByColVals[1] = "resp_name";
		orderByColVals[2] = "appl_user_id";
		orderByColVals[3] = "appl_user_name";
		orderByColVals[4] = "reln_id";
		orderByColVals[5] = "pract_reln_name";
		orderByColVals[6] = "facility_id";
		//orderByColVals[7] = "facility_name";



	

		//===============yet to explore================================//

		strbuff =qrypg.getMultiColumnQueryPage(null, finAr, "privilege_query_form", "../../eOR/jsp/PrivilegeQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		//===================================================================//

		out.println(strbuff.toString());
		strbuff.setLength(0);
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

	 putObjectInBean(bean_id,bean,request);
%>

