<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
/* This is a Built for an Criteria Page Where the Fields are given in the form of an ArrayList and a Common Bean is invoked to design the Criteria Page..
The values are then Passed to the Result page where the SQL Query is built & Executed..

Invoking File : NursingUnitTypeQueryResult.jsp
*/
%>

<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
ArrayList finAr = new ArrayList();

try
{
ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  					//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	// label
	firstItem.add("Type");						//name of field
	firstItem.add("4");							// SIZE
	firstItem.add("4");							//LENGTH
finAr.add(firstItem);							//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
	secondItem.add("Text");  					//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	// label
	secondItem.add("long_desc");				//name of field
	secondItem.add("30");						// SIZE
	secondItem.add("30");						//LENGTH
finAr.add(secondItem);							//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   						//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));						// label
	thirdItem.add("eff_status");   					//name
	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));	//static values that need to be displayed as aption
finAr.add(thirdItem); 								//add to ArrayList obj finAr


String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "nursing_unit_type_code";
orderByColVals[1] = "long_desc";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitType.label","ip_labels"),"../jsp/NursingUnitTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
}
catch(Exception e)
{
	out.println(e.toString());
}
finally 
{
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
