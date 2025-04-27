<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/04/2013    IN30708        Karthi      To incorporate the "Symbol" function  from Microsoft words to the Microsoft Editor in the clinical notes.
---------------------------------------------------------------------------------------------------------------
--> 
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/CASymbol.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;

try{
	con  =  ConnectionManager.getConnection(request);
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");           //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.symbolid.label","ca_labels"));     // label
	firstItem.add("symbolid");   //name of field
	firstItem.add("10"); // SIZE
	firstItem.add("10"); //LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr
	
	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");          //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GroupCode.label","common_labels"));    // label
	secondItem.add("groupcode");  //name of field
	secondItem.add("10");   // SIZE
	secondItem.add("10");   //LENGTH
	finAr.add(secondItem);    //add to ArrayList obj finAr
	
	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	thirdItem.add("eff_status");//name
	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
	finAr.add(thirdItem); //add to ArrayList obj finAr

	String[] orderByCols = new String[2];
	String[] orderByColVals = new String[2];
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.symbolid.label","ca_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GroupCode.label","common_labels");
		
		orderByColVals[0] = "SYMBOL_ID";
		orderByColVals[1] = "SYMBOL_GROUP";
		
			
	strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.symbol.label","ca_labels"),"../../eCA/jsp/CASymbolQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels") ,orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	//fourthItem.clear();
} 

catch (Exception e) 
{
	//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}

finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

