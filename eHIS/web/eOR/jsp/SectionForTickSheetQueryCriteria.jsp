<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8"); 
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>



<%
	//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	//======================================================================//
	//String readOnly = "" ;

	/* Mandatory checks start */
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_SectionForTickSheet" ;
	String bean_name = "eOR.SectionForTickSheet";
	//String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	SectionForTickSheet  bean =
	(SectionForTickSheet)getBeanObject( bean_id,bean_name, request );  
	 bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	String  comboString = "";
	//Connection con=null ;

	try {
	
		comboString=bean.getComboString();
	}catch(Exception e){System.out.println("exception in jsp::::::"+e);}	
		ArrayList firstItem = new ArrayList();
		firstItem.add("List");  		 //Type of item
		//System.out.println("======="+pageContext);	
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
		firstItem.add("order_category");	//name of field
		firstItem.add("'',--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ," + comboString);	// SIZE
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
		thirdItem.add("30");	//LENGTH
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr


		//==================== populating the 4th item in the firstitem object
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels"));  // label
		fourthItem.add("section_code");   //name of field
		fourthItem.add("6");	//size
		fourthItem.add("4");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		
		//=====================================================================
		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SectionDesc.label","or_labels"));  // label
		fifthItem.add("section_desc");   //name of field
		fifthItem.add("30");	//LENGTH
		fifthItem.add("30");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		//==================== populating the 5th item in the firstitem object

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		sixthItem.add("eff_status");   //name of field
		sixthItem.add("''B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		sixthItem.add("7");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		
		
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetID.label","or_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetDescription.label","or_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SectionDesc.label","or_labels");

		
		
		
		orderByColVals[0] = "short_desc";
		orderByColVals[1] = "tick_sheet_id";
		orderByColVals[2]="tick_sheet_desc";
		orderByColVals[3]="section_code";
		orderByColVals[4] = "section_desc";
		
		


		strbuff =qrypg.getQueryPage(null,finAr, "Or_SectionForTickSheet", "../../eOR/jsp/SectionForTickSheetQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	strbuff.setLength(0);
	putObjectInBean(bean_id,bean,request);
%>

