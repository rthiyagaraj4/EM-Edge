<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,oracle.jdbc.driver.*, java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	try 
	{
		con = (Connection) session.getValue( "connection" );

	

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patienttype.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	 // label
	firstItem.add("patient_type");	//name of field
	firstItem.add("4");	// SIZE
	firstItem.add("4");	// LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patienttype.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	secondItem.add("pat_type_desc");	//name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  		 //Type of item
	thirdItem.add( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));	  // label
	thirdItem.add("patient_class");	//name of field
	thirdItem.add("2");	// SIZE
	thirdItem.add("2");	// LENGTH

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList forthItem = new ArrayList();

	forthItem.add("Text");  		 //Type of item
	forthItem.add( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	forthItem.add("pat_class_desc");	//name of field
	forthItem.add("15");	// SIZE
	forthItem.add("15");	// LENGTH

	finAr.add(forthItem);//add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patienttype.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels");
	orderByCols[2] =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patienttype.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");	
	


	orderByColVals[0] = "patient_type";
	orderByColVals[1] = "patient_class";
	
	orderByColVals[2] = "patient_type_short_desc";
	orderByColVals[3] = "patient_class_short_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Patient Type Class","../../eAM/jsp/PatTypeClassQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	finAr.clear();
	forthItem.clear();
//Added for check style for COMMON-ICN-0056
	} catch (Exception e) 
{
out.println("Exception :"+e);
}
finally{
	if(con != null)  ConnectionManager.returnConnection(con,request);
	
}
%>
