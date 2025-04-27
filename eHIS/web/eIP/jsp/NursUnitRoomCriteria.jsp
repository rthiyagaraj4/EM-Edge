<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con = null ;

try {
	con = ConnectionManager.getConnection(request);;
    
ArrayList finAr = new ArrayList();

ArrayList thirdItem = new ArrayList();
thirdItem.add("Text");  			//Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels"));	// label
thirdItem.add("nursing_unit_code");	//name of field
thirdItem.add("4");					// SIZE
thirdItem.add("4");					//LENGTH
finAr.add(thirdItem);				//add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");  			//Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels"));// label
fourthItem.add("nursing_unit_desc");//name of field
fourthItem.add("15");				// SIZE
fourthItem.add("15");				//LENGTH
finAr.add(fourthItem);				//add to ArrayList obj finAr

ArrayList firstItem = new ArrayList();

firstItem.add("Text");   			//Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels"));   // label
firstItem.add("room");   			//name
firstItem.add("10");					// SIZE
firstItem.add("10");					//LENGTH
finAr.add(firstItem); 				//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();
secondItem.add("Text");   			//Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RoomCubicleDescription.label","ip_labels"));// label
secondItem.add("room_desc");   		//name
secondItem.add("15");				// SIZE
secondItem.add("15");				//LENGTH
finAr.add(secondItem); 				//add to ArrayList obj finAr

String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RoomCubicleDescription.label","ip_labels");

orderByColVals[0] = "nursing_unit_code";
orderByColVals[1] = "nursing_unit_short_desc";
orderByColVals[2] = "room_no";
orderByColVals[3] = "room_short_desc";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels"),"../jsp/NursUnitRoomQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
}catch (Exception e) {out.println("Exception in tryCatch : "+ e.toString());}
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
