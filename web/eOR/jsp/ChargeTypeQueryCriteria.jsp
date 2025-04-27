<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,java.sql.*,webbeans.eCommon.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
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
	String bean_id = "Or_charge_type" ;
	String bean_name = "eOR.ChargeType";
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ChargeType bean = (ChargeType)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.setLanguageId(localeName);
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	//Connection con=null ;

	try {
	
		ArrayList finAr = new ArrayList();
		
		ArrayList firstItem = new ArrayList();

		String comboString = bean.getComboString();		
		//out.println("##comboString="+comboString);
		
		firstItem.add("Text");  //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ChargeTypeCode.label","or_labels"));  // label
		firstItem.add("charge_type_code");   //name of field
		firstItem.add("10");
		firstItem.add("10");	//LENGTH
		finAr.add(firstItem); //add to ArrayList obj finAr
		

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ChargeTypeDescription.label","or_labels"));  // label
		secondItem.add("description");   //name of field
		secondItem.add("30");
		secondItem.add("30");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr		
		
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
		thirdItem.add("order_category");	//name of field
		thirdItem.add("'',&nbsp;&nbsp;&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;,*A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"," + comboString);	// SIZE
		thirdItem.add("6");	//LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr

		function_id = request.getParameter( "function_id" );
		ArrayList fourthItem = new ArrayList();
		fourthItem.add("Hidden");  //Type of item
		fourthItem.add("function_id");  // name of field
		fourthItem.add(function_id);   //value of field
		finAr.add(fourthItem); //add to ArrayList obj finAr
	



		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

	
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ChargeTypeCode.label","or_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ChargeTypeDescription.label","or_labels");		

	
		
		orderByColVals[0] = "charge_type_code";
		orderByColVals[1] = "order_category";
		orderByColVals[2] = "description";


		strbuff =qrypg.getQueryPage(null, finAr, "Or_charge_type", "../../eOR/jsp/ChargeTypeQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		out.println(strbuff.toString());
		strbuff.setLength(0);
		putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) {
		e.printStackTrace(System.out);
	}/*finally{
		try
		 { 
			ConnectionManager.returnConnection(con);
		 }catch(Exception e){
			 System.out.println("exception in the finally of ChargeTypeQueryCriteria.jsp="+e);
		 
		 }
	}*/
%>


