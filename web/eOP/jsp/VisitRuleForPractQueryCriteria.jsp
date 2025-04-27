<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.util.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);



ArrayList finAr = new ArrayList();


ArrayList firstItem1 = new ArrayList();

firstItem1.add("Text");  		 //Type of item
firstItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RuleID.label","op_labels"));	  // label
firstItem1.add("rule_id");	//name of field
firstItem1.add("4");	// SIZE
firstItem1.add("4");	//LENGTH

finAr.add(firstItem1);//add to ArrayList obj finAr

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));	  // label
firstItem.add("pract_id");	//name of field
firstItem.add("15");	// SIZE
firstItem.add("15");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels"));  // label
secondItem.add("pract_name");   //name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RuleID.label","op_labels"); 
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");

orderByColVals[0] = "a.rule_id";
orderByColVals[1] = "a.practitioner_id";
orderByColVals[2] = "b.practitioner_name";

strbuff = qrypg.getQueryPage(con,finAr,"Find Rule For Practitioner","../../eOP/jsp/VisitRuleForPractQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));
out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
finAr.clear();
firstItem1.clear();

} catch (Exception e) {
	e.printStackTrace();
}

finally{
	ConnectionManager.returnConnection(con,request);
}
%>
