<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/* 
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
		
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
request.setCharacterEncoding("UTF-8");
StringBuffer strbuff;
String function_id = request.getParameter("function_id");

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr		= new ArrayList();
ArrayList firstItem = new ArrayList();


firstItem.add("List");
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReasonType.label","or_labels"));
firstItem.add("reason_type");
//IN061903 start
//firstItem.add("%,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,"+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Order.label","common_labels")+",CN,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")+",HD,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.HoldDiscontinue.label","or_labels")+",AM,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.AmendOrder.label","or_labels")+""); //added AmendOrder label for IN049419
firstItem.add("%,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,"+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Order.label","common_labels")+",CN,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")+",HD,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.HoldDiscontinue.label","or_labels")+",AM,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.AmendOrder.label","or_labels")+",ND,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NOTDONE.label","or_labels")+"");
//IN061903 ends
finAr.add(firstItem); //add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels"));	  // label
secondItem.add("reason_code");	//name of field
secondItem.add("4");	// SIZE
secondItem.add("4");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();

thirdItem.add("Text");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReasonText.label","or_labels"));	  // label
thirdItem.add("reason_desc");	//name of field
thirdItem.add("30");	// SIZE
thirdItem.add("255");	//LENGTH

ArrayList sixthItem=new ArrayList();

sixthItem.add("Text");  		 //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels")+"    "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
sixthItem.add("reason_short_desc");	//name of field
sixthItem.add("40");	// SIZE
sixthItem.add("40");	//LENGTH

finAr.add(sixthItem);//add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("List");   //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));
fourthItem.add("eff_status");
fourthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
finAr.add(fourthItem); //add to ArrayList obj finAr


ArrayList fifthItem = new ArrayList();
fifthItem.add("Hidden");  //Type of item
fifthItem.add("function_id");  // name of field
fifthItem.add(function_id);   //value of field
finAr.add(fifthItem); //add to ArrayList obj finAr




String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReasonType.label","or_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReasonText.label","or_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

orderByColVals[0] = "action_type";
orderByColVals[1] = "action_reason_code";
orderByColVals[2] = "action_reason_desc";
orderByColVals[3] = "action_description";

strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/ReasonCodeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);
} catch (Exception e) {System.out.println(e.toString());}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

