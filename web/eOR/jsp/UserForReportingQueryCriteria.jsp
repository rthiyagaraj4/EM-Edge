<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.util.*, java.sql.*,webbeans.eCommon.*,eOR.Common.*,eCommon.XSSRequestWrapper"%>
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

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;



String function_id = request.getParameter("function_id");
Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();



//add new  Respnosibilty
firstItem.add("Text");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels"));  // label
firstItem.add("resp_id");//name
firstItem.add("15");
firstItem.add("15");
finAr.add(firstItem); //add to ArrayList obj finAr


ArrayList firstINewtem = new ArrayList();
firstINewtem.add("Text");   //Type of item
firstINewtem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels"));  // label
firstINewtem.add("resp_name");//name
firstINewtem.add("15");
firstINewtem.add("15");
finAr.add(firstINewtem); //add to ArrayList obj finAr




ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));  // label
secondItem.add("pract_id");//name
secondItem.add("15");
secondItem.add("15");
finAr.add(secondItem); //add to ArrayList obj finAr



//add new 	 Practitioner Name
ArrayList newItem = new ArrayList();
newItem.add("Text");   //Type of item
newItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"));  // label
newItem.add("practitioner_name");//name
newItem.add("15");
newItem.add("15");
finAr.add(newItem); //add to ArrayList obj finAr



ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));  // label
thirdItem.add("order_category");//name
String temp=OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC5");
temp=temp.replace("?","'"+localeName+"'");
thirdItem.add(temp);
finAr.add(thirdItem); //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));  // label
fourthItem.add("order_type_code");//name
fourthItem.add("15");
fourthItem.add("15");
finAr.add(fourthItem); //add to ArrayList obj finAr


ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Privilege.label","or_labels"));  // label
fifthItem.add("privilege");//name
fifthItem.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---,R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reporting.label","or_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportingandAuthorizing.label","or_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fifthItem); //add to ArrayList obj finAr

/*ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");   //Type of item
sixthItem.add("Security Level");  // label  
sixthItem.add("security");//name
sixthItem.add("5");
sixthItem.add("5");
finAr.add(sixthItem); //add to ArrayList obj finAr*/


ArrayList seventhItem = new ArrayList();
seventhItem.add("Hidden");  //Type of item
seventhItem.add("function_id");  // name of field  
seventhItem.add(function_id);   //value of field
finAr.add(seventhItem); //add to ArrayList obj finAr


String orderByCols[] = new String[7];
String orderByColVals[] = new String[7];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityID.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResponsibilityName.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Privilege.label","or_labels");

orderByColVals[0] = "c.practitioner_id";
orderByColVals[1] = "c.resp_id";
orderByColVals[2] = "a.resp_name";
orderByColVals[3] = "b.practitioner_name";
orderByColVals[4] = "c.order_category";
orderByColVals[5] = "c.order_type_code";
orderByColVals[6] = "c.user_category";

strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/UserForReportingQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);
} catch (Exception e) {System.out.println(e.toString());}

	finally{
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con,request);
		 }catch(Exception e){System.out.println("exception"+e);
		 
		 }
	}


%>

