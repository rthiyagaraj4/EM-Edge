<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*" %><!--oracle.jdbc.driver.*,-->
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</link>
<script language='javascript' src='../js/ICDCodeForTabList.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%!
ArrayList finAr;
ArrayList secondItem1;
ArrayList firstItem;
ArrayList secondItem;
ArrayList thirdItem;
ArrayList fourthItem;
%>

<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();


StringBuffer strbuff;

Connection con=null ;

try {
	con=ConnectionManager.getConnection(request);


 finAr = new ArrayList();

 secondItem1=new ArrayList();

secondItem1.add("Text");  //Type of item
secondItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TabListCode.label","mr_labels"));  // label
secondItem1.add("tab_list_no");   //name of field
secondItem1.add("10");	// SIZE
secondItem1.add("10");	//LENGTH

finAr.add(secondItem1); //add to ArrayList obj finAr


firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TabListDescription.label","mr_labels"));	  // label
firstItem.add("short_desc");	//name of field
firstItem.add("30");	// SIZE
firstItem.add("30");	//LENGTH 

finAr.add(firstItem);//add to ArrayList obj finAr


secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add("Term Code");  // label
secondItem.add("term_code");   //name of field
secondItem.add("10");	// SIZE
secondItem.add("10");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

thirdItem=new ArrayList();

thirdItem.add("Text");  //Type of item
thirdItem.add("Term Set");  // label
thirdItem.add("term_set_id");   //name of field
thirdItem.add("10");
thirdItem.add("10");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr


fourthItem=new ArrayList();

fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TITLE.label","common_labels"));  // label
fourthItem.add("title_desc");   //name of field
fourthItem.add("60");
fourthItem.add("70");	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TabListCode.label","mr_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.TabListDescription.label","mr_labels");
orderByCols[2] = "Term Code";//com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ICDCode.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TITLE.label","common_labels");

orderByColVals[0] = "a.tab_list_no";
orderByColVals[1] = "c.short_desc";
orderByColVals[2] = "b.term_code";
orderByColVals[3] = "b.LONG_DESC";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ICDCodeForTabulationList.label","mr_labels"),"../jsp/ICDCodeForTabListQueryPageResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
} catch (Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
finally
{
	finAr.clear();
	secondItem1.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	ConnectionManager.returnConnection(con,request);
}

%>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

