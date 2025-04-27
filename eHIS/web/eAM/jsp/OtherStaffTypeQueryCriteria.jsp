<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*," %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<% String sStyle =
checkForNull((String)session.getAttribute("PREFERRED_STYLE"),
"IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css'
href='../../eCommon/html/<%=sStyle%>'></link>
</head>
</html>

<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ;

	try 
	{
		con = (Connection) session.getValue( "connection" );
	

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StaffType.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	 // Label
	firstItem.add("StaffTypeCode");	//Name of field
	firstItem.add("1");	// SIZE
	firstItem.add("2");	// LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels"));	  // Label
	secondItem.add("LongDescription");	//Name of field
	secondItem.add("35");	// SIZE
	secondItem.add("30");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("Text");  		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));	  // Label
	thirdItem.add("ShortDescription");	//Name of field
	thirdItem.add("18");	// SIZE
	thirdItem.add("15");	// LENGTH

	finAr.add(thirdItem);//add to ArrayList obj finAr

	ArrayList forthItem = new ArrayList();

	forthItem.add("List");   //Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // Label
	forthItem.add("eff_status");//Name
	forthItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
	
	finAr.add(forthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StaffType.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
	
	orderByColVals[0] = "other_staff_type";
	orderByColVals[1] = "long_desc";
	orderByColVals[2] = "short_desc";
	
strbuff = qrypg.getQueryPage(con,finAr,"OtherStaffType","../../eAM/jsp/OtherStaffTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
	} 
	catch (Exception e) {e.printStackTrace();}
	finally{
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
