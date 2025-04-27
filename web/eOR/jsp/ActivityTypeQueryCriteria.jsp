<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,java.sql.*,webbeans.eCommon.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
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

	
	/* Mandatory checks start */
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_activity_type" ;
	String bean_name = "eOR.ActivityType";
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ActivityType bean = (ActivityType)getBeanObject( bean_id,  bean_name , request) ;  
	bean.setLanguageId(localeName);
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	//Connection con=null ;

	try {
	
		ArrayList finAr = new ArrayList();
		
		ArrayList firstItem = new ArrayList();

		String comboString = bean.getComboString();		

		
		
		firstItem.add("Text");  //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ActivityTypeCode.label","or_labels"));  // label
		firstItem.add("activity_type");   //name of field
		firstItem.add("10");
		firstItem.add("10");	//LENGTH
		finAr.add(firstItem); //add to ArrayList obj finAr
		

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ActivityTypeDesc.label","or_labels"));  // label
		secondItem.add("long_desc");   //name of field
		secondItem.add("30");
		secondItem.add("30");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr
		

		/*ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add("Short Desc");  // label
		thirdItem.add("short_desc");   //name of field
		thirdItem.add("15");
		thirdItem.add("15");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr */

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
		thirdItem.add("order_category");	//name of field
		thirdItem.add("'',--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---," + comboString);	// SIZE
		thirdItem.add("6");	//LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr
		

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));  // label
		fourthItem.add("order_type_code");   //name of field
		fourthItem.add("4");	//LENGTH
		fourthItem.add("4");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));  // label
		fifthItem.add("order_type_desc");   //name of field
		fifthItem.add("30");	//LENGTH
		fifthItem.add("30");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		
		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		sixthItem.add("eff_status");   //name of field
		sixthItem.add("''B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		sixthItem.add("7");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr	
		
				
		function_id = request.getParameter( "function_id" );
		ArrayList seventhItem = new ArrayList();
		seventhItem.add("Hidden");  //Type of item
		seventhItem.add("function_id");  // name of field
		seventhItem.add(function_id);   //value of field
		finAr.add(seventhItem); //add to ArrayList obj finAr

	//	firstItem.clear();
	//	secondItem.clear();
	//	thirdItem.clear();
	//	fourthItem.clear();
	//	fifthItem.clear();
	//	sixthItem.clear();
	//	seventhItem.clear();

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

	
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ActivityTypeCode.label","or_labels");
		orderByCols[1] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ActivityTypeDesc.label","or_labels");
		//orderByCols[2] = "Short Desc";
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
		orderByCols[4] =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");	

	
		
		orderByColVals[0] = "activity_type";
		orderByColVals[1] = "long_desc";
		//orderByColVals[2] = "short_desc";
		orderByColVals[2] = "order_category";
		orderByColVals[3] = "order_type_code";
		orderByColVals[4] = "order_type_desc";


		strbuff =qrypg.getQueryPage(null, finAr, "Or_activity_type", "../../eOR/jsp/ActivityTypeQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(strbuff.toString());
		strbuff.setLength(0);
		putObjectInBean(bean_id,bean,request);

	//	finAr.clear();
		
	}
	catch (Exception e) {
		e.printStackTrace(System.out);
		
	}/*finally{
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con);
		 }catch(Exception e){
			 e.printStackTrace(System.out);
		 
		 }
	}*/
%>


