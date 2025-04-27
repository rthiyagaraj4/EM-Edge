<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	    Edit History      		Name        		             Rev.Date		        Rev.Name		          Description
------------------------------------------------------------------------------------------------------------------------------------------------------
21/04/2023	IN061903			Srinivasa			                  21/04/2023		Ramesh G		           ML-BRU-CRF-0605.4		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.* " %>
<%
		
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
request.setCharacterEncoding("UTF-8");
StringBuffer strbuff;
String function_id = request.getParameter("function_id");

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr		= new ArrayList();
ArrayList secondItem=new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels"));	  // label
secondItem.add("reason_code");	//name of field
secondItem.add("4");	// SIZE
secondItem.add("4");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList sixthItem=new ArrayList();
sixthItem.add("Text");  		 //Type of item
sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels")+"    "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
sixthItem.add("reason_short_desc");	//name of field
sixthItem.add("40");	// SIZE
sixthItem.add("200");	//LENGTH
finAr.add(sixthItem);

ArrayList thirdItem=new ArrayList();
thirdItem.add("Text");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReasonText.label","or_labels"));	  // label
thirdItem.add("reason_desc");	//name of field
thirdItem.add("50");	// SIZE
thirdItem.add("255");	//LENGTH

finAr.add(thirdItem);

//add to ArrayList obj finAr


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


String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ReasonText.label","or_labels");

orderByColVals[0] = "reason_code";
orderByColVals[1] = "reason_short_desc";
orderByColVals[2] = "reason_desc";

strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/CAReasonCodeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);
} catch (Exception e) {System.out.println(e.toString());}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

