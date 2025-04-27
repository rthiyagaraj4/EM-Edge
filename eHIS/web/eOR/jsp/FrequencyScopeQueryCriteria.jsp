<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
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

	/* Mandatory checks start */
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_FrequencyScope" ;
	String bean_name = "eOR.FrequencyScopeBean";
	//String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	FrequencyScopeBean  bean =
	(FrequencyScopeBean)getBeanObject( bean_id,bean_name, request );  
	bean.setLanguageId(localeName);

	 bean.clear() ;
	 
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	String  comboString = "";
	Connection con=null ;

		//================= populating the second item in the firstitem object

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyCode.label","common_labels"));  // label
		secondItem.add("freq_code");   //name of field
		secondItem.add("4");	// SIZE
		secondItem.add("4");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FrequencyDesc.label","or_labels"));  // label
		thirdItem.add("freq_desc");   //name of field
		thirdItem.add("20");	//LENGTH
		thirdItem.add("20");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr


	try {
	
		comboString=bean.getComboString();
	}catch(Exception e){System.out.println("exception in jsp="+e);}	
		ArrayList firstItem = new ArrayList();
		firstItem.add("List"); 
		
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
		firstItem.add("order_category");	//name of field
		firstItem.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+comboString);//Type of item
			// SIZE
//		firstItem.add("6");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//==================== populating the 4th item in the firstitem object
		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		
		
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyCode.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FrequencyDesc.label","or_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");

		
		
		
		orderByColVals[0] = "FREQ_CODE";
		orderByColVals[1] = "FREQ_DESC";
		orderByColVals[2]="ORDER_CATEGORY";
		
		


		strbuff =qrypg.getQueryPage(con, finAr, "Or_FrequencyScope", "../../eOR/jsp/FrequencyScopeQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	strbuff.setLength(0);

putObjectInBean(bean_id,bean,request);
%>

