<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ page import ="java.sql.*,webbeans.eCommon.*"  %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="JavaScript" src="../js/OrCommon.js"></script>
		<script language="JavaScript" src="../js/ChartVertical.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

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
	String bean_id = "Or_ChartVertical";
	String bean_name = "eOR.ChartVerticalBean";
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ChartVerticalBean  bean = (ChartVerticalBean)getBeanObject( bean_id,bean_name , request);  
	Connection con=null ;
try {
	Vector obj = bean.getResultType();

	String strList = " "+","+"---Select---"+",";
	for(int k=0;k<obj.size();k++)
	{
		if(k == (obj.size()-1))
			strList = strList + obj.get(k);
		else
			strList = strList + obj.get(k) + ",";
			
	}
	

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	

	try {
		con = ConnectionManager.getConnection(request);
	}catch(Exception e){System.out.println("excepting in jsp="+e);}	
		
		/////////////////////////////

		ArrayList sixthItem = new ArrayList();
		sixthItem.add("List");
		sixthItem.add("Result Matrix");
		sixthItem.add("chart_result_type");
		sixthItem.add(strList);
		sixthItem.add("7");
		finAr.add(sixthItem);

		/////////////////////////////	
			
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MatrixRowCode.label","or_labels"));	  // label
		firstItem.add("chart_vertical_code");	//name of field
		firstItem.add("4");	// SIZE
		firstItem.add("4");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		ArrayList firstItem1 = new ArrayList();
		firstItem1.add("Text");  		 //Type of item
		firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MatrixRowDesc.label","or_labels"));	  // label
		firstItem1.add("long_desc");	//name of field
		firstItem1.add("40");	// SIZE
		firstItem1.add("40");	//LENGTH
		finAr.add(firstItem1);//add to ArrayList obj finAr

		///////////////////////
		
	/*	ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add("Short Description");	  // label
		thirdItem.add("short_desc");	//name of field
		thirdItem.add("15");	// SIZE
		thirdItem.add("15");	//LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr
	*/
		///////////////////////

	/*	ArrayList fourthItem = new ArrayList();
		fourthItem.add("Text");  		 //Type of item
		fourthItem.add("Sequence No.");	  // label
		fourthItem.add("seq_no");	//name of field
		fourthItem.add("4");	// SIZE
		fourthItem.add("4");	//LENGTH
		finAr.add(fourthItem);//add to ArrayList obj finAr
	*/	
		///////////////////////

		ArrayList fifthItem = new ArrayList();
		fifthItem.add("List");
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));
		fifthItem.add("nature");
		fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
		fifthItem.add("7");
		finAr.add(fifthItem);

		///////////////////////

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.resultmatrix.label","or_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MatrixRowCode.label","or_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MatrixRowDesc.label","or_labels");
		//orderByCols[1] = "Matrix Column Code";
		//orderByCols[2] = "Matrix Column Desc";
		//orderByCols[2] = "Short Description";
		//orderByCols[3] = "Sequence No.";
		
		orderByColVals[0] = "chart_result_type";
		orderByColVals[1] = "chart_verti_code";
		orderByColVals[2] = "long_desc";
		//orderByColVals[2] = "short_desc";
		//orderByColVals[3] = "seq_no";
		
		

		strbuff =qrypg.getQueryPage(con, finAr, "Or_ChartVertical", "../../eOR/jsp/ChartVerticalQueryResult.jsp?function_id="+function_id, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
//	out.println(facility_id);
	out.println(strbuff.toString());
	strbuff.setLength(0);
	} catch (Exception e) {System.out.println(e.toString());}
finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
}
%>

</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

