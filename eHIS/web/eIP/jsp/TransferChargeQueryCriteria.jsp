<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*, oracle.jdbc.driver.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<% request.setCharacterEncoding("UTF-8");  %>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
Connection con =null;
try
{
	con	= ConnectionManager.getConnection(request);

StringBuffer strbuff;
ArrayList finAr = new ArrayList();

//<fmt:message key="eIP.FromBedType.label" bundle="${ip_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/>
ArrayList firstItem = new ArrayList();
firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FromBedType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
firstItem.add("fr_bed_type_code");	//name of field
firstItem.add("2");	// SIZE
firstItem.add("2");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

//<fmt:message key="eIP.FromBedType.label" bundle="${ip_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/>
ArrayList secondItem=new ArrayList();
secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FromBedType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
secondItem.add("fr_bed_type_short_desc");   //name of field
secondItem.add("15");	// SIZE
secondItem.add("15");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ToBedType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
thirdItem.add("to_bed_type_code");	//name of field
thirdItem.add("2");	// SIZE
thirdItem.add("2");	//LENGTH
finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();
fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ToBedType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
fourthItem.add("to_bed_type_short_desc");   //name of field
fourthItem.add("15");	// SIZE
fourthItem.add("15");	//LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr

ArrayList fifthItem=new ArrayList();
fifthItem.add("List");  //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("eff_status");   //name of field
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
finAr.add(fifthItem); //add to ArrayList obj finAr

String orderByCols[]		= new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FromBedType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FromBedType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ToBedType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ToBedType.label","ip_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");


orderByColVals[0] = "fr_bed_type_code";
orderByColVals[1] = "fr_bed_type_short_desc";
orderByColVals[2] = "to_bed_type_code";
orderByColVals[3] = "to_bed_type_short_desc";


strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels"),"../jsp/TransferChargeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());

}catch(Exception e) 
{ 
	//out.println(e.toString());
	e.printStackTrace();
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
