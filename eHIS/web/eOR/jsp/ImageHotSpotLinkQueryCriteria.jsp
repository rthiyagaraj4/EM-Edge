<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " %>
<%
  	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();



ArrayList firstItem = new ArrayList();

firstItem.add("Text");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ImageId.label","or_labels"));  // label
firstItem.add("image_id");//name
firstItem.add("6");
firstItem.add("6");
finAr.add(firstItem); //add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ImageDesc.label","or_labels"));  // label
secondItem.add("image_desc");//name
secondItem.add("30");
secondItem.add("30");
finAr.add(secondItem); //add to ArrayList obj finAr



ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.HotspotId.label","or_labels"));  // label
thirdItem.add("hot_spot_id");//name
thirdItem.add("6");
thirdItem.add("6");
finAr.add(thirdItem); //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("Text");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.HotspotDesc.label","or_labels"));  // label
fourthItem.add("hot_spot_desc");//name
fourthItem.add("30");
fourthItem.add("30");
finAr.add(fourthItem); //add to ArrayList obj finAr


ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ImageLink.label","or_labels"));  // label
fifthItem.add("image_link");//name
fifthItem.add("15");
fifthItem.add("15");
finAr.add(fifthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[5];
String orderByColVals[] = new String[5];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ImageId.label","or_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ImageDesc.label","or_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.HotspotId.label","or_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.HotspotDesc.label","or_labels");
orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ImageLink.label","or_labels");


orderByColVals[0] = "a.image_id";
orderByColVals[1] = "b.image_name";
orderByColVals[2] = "a.hotspot_id";
orderByColVals[3] = "c.hotspot_name";
orderByColVals[4] = "a.image_link_id";


strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/ImageHotSpotLinkQueryResults.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
} catch (Exception e) {out.println(e.toString());}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

