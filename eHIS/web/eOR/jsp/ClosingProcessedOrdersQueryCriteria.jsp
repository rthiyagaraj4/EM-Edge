
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eOR.*,eOR.Common.*,eCommon.Common.* " %>
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

	String bean_id			= "Or_Cl_Process_Order" ;
	String bean_name		= "eOR.ClosingProcessOrderBean";

	ClosingProcessOrderBean bean = (ClosingProcessOrderBean)getBeanObject( bean_id, bean_name,request) ;
	bean.setLanguageId(localeName);
	bean.clear() ;

try {
	con = ConnectionManager.getConnection(request);
	
	
	String[] record  = null;
	ArrayList  patientClass = new ArrayList();
	
	try {

		patientClass=bean.getPatientClass();
	}catch(Exception e){}

	ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("List");   //Type of item
ArrayList orderCategory = new ArrayList();
orderCategory=bean.getAllOrderCategory();
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));  // label
firstItem.add("order_category");//name
String strList="";
for( int k=0;k<orderCategory.size();k++)
{
	record=(String[])orderCategory.get(k);
	strList=strList+ (String)record[0]+","+(String)record[1]+",";
}
firstItem.add("%,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,"+strList);
finAr.add(firstItem); //add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));	  // label
secondItem.add("order_type_code");	//name of field
secondItem.add("4");	// SIZE
secondItem.add("4");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList ThirdItem=new ArrayList();

ThirdItem.add("Text");  		 //Type of item
ThirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));	  // label
ThirdItem.add("short_desc");	//name of field
ThirdItem.add("15");	// SIZE
ThirdItem.add("15");	//LENGTH
finAr.add(ThirdItem);//add to ArrayList obj finAr


ArrayList fourthItem=new ArrayList();
fourthItem.add("List");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));  // label
fourthItem.add("patient_class");   //name of field
String patientList="";
for( int k=0;k<patientClass.size();k++)
{
	record=(String[])patientClass.get(k);
	patientList=patientList+ (String)record[0]+","+(String)record[1]+",";
}
fourthItem.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,*A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+" ," + patientList);	//LENGTH
fourthItem.add("6");	//LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");

orderByColVals[0] = "order_category";
orderByColVals[1] = "order_type_code";
orderByColVals[2] = "short_desc";
orderByColVals[3] = "patient_class";

strbuff = qrypg.getQueryPage(null,finAr,"Or_Cl_Process_Order","../jsp/ClosingProcessedOrdersQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
out.println(strbuff.toString());

strbuff.setLength(0);
} catch (Exception e) {System.out.println(e.toString());}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

