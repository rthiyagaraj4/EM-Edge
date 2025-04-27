<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%@page import="java.sql.*,java.util.*,eCommon.Common.*,webbeans.eCommon.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
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
	 
	String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_text_block" ;
	String bean_name = "eOR.TextBlockBean";
	//String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	TextBlockBean  bean = (TextBlockBean)getBeanObject( bean_id,bean_name, request );  
	 bean.clear() ;
				


	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	//String  comboString = "";
	Connection con=null ;

	try {
		con = ConnectionManager.getConnection(request);
		//comboString=bean.getComboString();
	
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	  // label
		firstItem.add("text_id");	//name of field
		firstItem.add("10");	// SIZE
		firstItem.add("10");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		ArrayList firstItem1 = new ArrayList();
		firstItem1.add("Text");  		 //Type of item
		firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DiscreteMeasureID.label","or_labels"));	  // label
		firstItem1.add("discr_msr_panel_id");	//name of field
		firstItem1.add("10");	// SIZE
		firstItem1.add("10");	//LENGTH
		finAr.add(firstItem1);//add to ArrayList obj finAr



		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DiscreteMeasureDesc.label","or_labels"));  // label
		thirdItem.add("short_desc");   //name of field
		thirdItem.add("30");	//size
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr

////////////////////////
		ArrayList forthtem=new ArrayList();
		forthtem.add("List");  //Type of item
		forthtem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		forthtem.add("eff_status");   //name of field
		forthtem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");	//size
		forthtem.add("7");	//LENGTH
		finAr.add(forthtem); //add to ArrayList obj finAr

///////////////////////

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		
		
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DiscreteMeasureID.label","or_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DiscreteMeasureDesc.label","or_labels");
		
		
		orderByColVals[0] = "TEXT_BLOCK_ID";
		orderByColVals[1] = "DISCR_MSR_PANEL_ID";
		orderByColVals[2] = "SHORT_DESC";
		
		

		strbuff =qrypg.getQueryPage(con, finAr, "Or_text_block", "../../eOR/jsp/TextBlockQueryResult.jsp?function_id="+function_id, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
//	out.println(facility_id);
	out.println(strbuff.toString());
	strbuff.setLength(0);
	putObjectInBean(bean_id,bean,request);
	}catch (Exception e) {System.out.println(e.toString());}
	finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
}
%>

