<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*, eOR.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
//String orderCatValues = "";
request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String function_id = request.getParameter("function_id");
Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

  HttpSession ss = request.getSession(false);
	eOR.ChartResultType beanObjs = new eOR.ChartResultType(); 
	beanObjs.setProperties( (Properties) ss.getValue( "jdbc" ) ) ;


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
/*
firstItem.add("Text");   //Type of item
firstItem.add("Level");  // label
firstItem.add("level");//name
firstItem.add("10");
firstItem.add("20");
*/
firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultMatrixType.label","or_labels"));	  // label
firstItem.add("chart_result_type");	//name of field
firstItem.add("1");
firstItem.add("1");
finAr.add(firstItem); //add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MatrixDesc.label","or_labels"));  // label
secondItem.add("chart_result_type_desc");//name
secondItem.add("20");
secondItem.add("20");
finAr.add(secondItem); //add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MatrixRowDesc.label","or_labels"));  // label
thirdItem.add("chart_horzi_desc");//name
thirdItem.add("15");
thirdItem.add("15");
finAr.add(thirdItem); //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MatrixColumnDesc.label","or_labels"));  // label
fourthItem.add("chart_vert_desc");//name
fourthItem.add("15");
fourthItem.add("15");
finAr.add(fourthItem); //add to ArrayList obj finAr


ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("eff_status");//name
fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fifthItem); //add to ArrayList obj finAr



ArrayList sixthItem = new ArrayList();
sixthItem.add("Hidden");  //Type of item
sixthItem.add("function_id");  // name of field
sixthItem.add(function_id);   //value of field
finAr.add(sixthItem); //add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ResultMatrixType.label","or_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MatrixDesc.label","or_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MatrixRowDesc.label","or_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MatrixColumnDesc.label","or_labels");


orderByColVals[0] = "chart_result_type";
orderByColVals[1] = "chart_result_type_desc";
orderByColVals[2] = "chart_horzi_desc";
orderByColVals[3] = "chart_vert_desc";


strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/ChartResultTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
} catch (Exception e) {
	//out.println(e.toString());//COMMON-ICN-0181
       e.printStackTrace();//COMMON-ICN-0181
	}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

%>

