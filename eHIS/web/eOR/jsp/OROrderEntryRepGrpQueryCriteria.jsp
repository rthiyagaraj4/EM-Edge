<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper " %>
<%-- Mandatory declarations start --%>
	<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%-- Mandatory declarations end --%>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
/* Mandatory checks start */
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String function_id	= request.getParameter("function_id") ;
	String bean_id		= "Or_OrderEntryRptGrp" ;
	String bean_name	= "eOR.OrderEntryReportGrouping";
/* Mandatory checks end */	

/* Initialize Function specific start */
	OrderEntryReportGrouping bean = (OrderEntryReportGrouping)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.clearObject();
	/* Initialize Function specific end */
try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("List");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReportType.label","or_labels"));  // label
firstItem.add("report_type_id");//name
firstItem.add("%,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,ORD,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderFormatSheet.label","or_labels")+"");
//firstItem.add("4");	// SIZE
//firstItem.add("4");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.GroupingCode.label","or_labels"));	  // label
secondItem.add("cust_rep_grp_code");	//name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("Text");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.GroupingDescription.label","or_labels"));	  // label
thirdItem.add("cust_rep_grp_desc");	//name of field
thirdItem.add("30");	// SIZE
thirdItem.add("30");	//LENGTH

finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("List");  	 //Type of item
String orderCategory = bean.getOrderCategoryValues();
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
fourthItem.add("order_category");	//name of field
fourthItem.add("%,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,"+orderCategory);	// Include the values and description
fourthItem.add("30");	//LENGTH

finAr.add(fourthItem);//add to ArrayList obj finAr

//ArrayList fifthItem = new ArrayList();

/*fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PrintReportFormat.label","or_labels")); //label
fifthItem.add("cust_report_id");//name
fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");// Values to be passed
finAr.add(fifthItem); //add to ArrayList obj finAr
*/
ArrayList sixthItem = new ArrayList();

sixthItem.add("List");   //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));//label
sixthItem.add("eff_status");//name
sixthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");// Values to be passed
finAr.add(sixthItem); //add to ArrayList obj finAr

ArrayList seventhItem = new ArrayList();
seventhItem.add("Hidden");  //Type of item
seventhItem.add("function_id");  // name of field
seventhItem.add(function_id);   //value of field
finAr.add(seventhItem); //add to ArrayList obj finAr


String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];

orderByCols[0]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.GroupingCode.label","or_labels");
orderByCols[1]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.GroupingDescription.label","or_labels");
//orderByCols[2]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");

orderByColVals[0] = "cust_rep_grp_code";
orderByColVals[1] = "cust_rep_grp_desc";
//orderByColVals[2] = "cust_report_id";

strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/OROrderEntryRepGrpQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);
} catch (Exception e) {out.println(e.toString());}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
		putObjectInBean(bean_id,bean,request);
 
%>

