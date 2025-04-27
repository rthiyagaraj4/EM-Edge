<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels"));	  // label
firstItem.add("nursing_unit_code");	//name of field
firstItem.add("4");	// SIZE
firstItem.add("4");	//LENGTH
finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels"));  // label
secondItem.add("nursing_unit_desc");   //name of field
secondItem.add("15");	// SIZE
secondItem.add("15");	//LENGTH
finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();
thirdItem.add("Text");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  // label
thirdItem.add("building_code");   //name of field
thirdItem.add("6");	// SIZE
thirdItem.add("6");	//LENGTH
finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();
fourthItem.add("Text");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
fourthItem.add("building_desc");   //name of field
fourthItem.add("15");	// SIZE
fourthItem.add("15");	//LENGTH
finAr.add(fourthItem); //add to ArrayList obj finAr


ArrayList fifthItem=new ArrayList();
fifthItem.add("Text");  //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.floor.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  // label
fifthItem.add("floor_code");   //name of field
fifthItem.add("6");	// SIZE
fifthItem.add("6");	//LENGTH
finAr.add(fifthItem); //add to ArrayList obj finAr

ArrayList sixthItem=new ArrayList();
sixthItem.add("Text");  //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.floor.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
sixthItem.add("floor_desc");   //name of field
sixthItem.add("15");	// SIZE
sixthItem.add("15");	//LENGTH
finAr.add(sixthItem); //add to ArrayList obj finAr



String orderByCols[]		= new String[6];
String orderByColVals[] = new String[6];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.building.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.floor.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.floor.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");


orderByColVals[0] = "nursing_unit_code";
orderByColVals[1] = "nursing_unit_short_desc";
orderByColVals[2] = "bldng_code";
orderByColVals[3] = "bldng_short_desc";
orderByColVals[4] = "floor_code";
orderByColVals[5] = "floor_short_desc";


strbuff = qrypg.getQueryPage(con,finAr, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PhysicalLocationforNursingUnit.label","ip_labels"),"../jsp/NursUnitLocnqueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
} catch (Exception e) {out.println("Exception in tryCatch : "+ e.toString());}
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
