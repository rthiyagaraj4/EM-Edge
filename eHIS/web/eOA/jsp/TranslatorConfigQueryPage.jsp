<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html>
<script src='../../eCommon/js/common.js' language='javascript'></script></head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;

try{
		con = (Connection) session.getValue( "connection" );
	} catch (Exception e) {}


ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Language.label","common_labels"));	  // label
firstItem.add("language_id");	//name of field
firstItem.add("2");	// SIZE
firstItem.add("2");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Language.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
secondItem.add("language_desc");	//name of field
secondItem.add("20");	// SIZE
secondItem.add("20");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Date");  		 //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.from.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels"));	  // label
thirdItem.add("eff_date_from");	//name of field
thirdItem.add("10");	// SIZE
thirdItem.add("10");	//LENGTH

finAr.add(thirdItem);//add to ArrayList obj finAr

ArrayList fourthItem = new ArrayList();

fourthItem.add("Date");  		 //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels"));	  // label
fourthItem.add("eff_date_to");	//name of field
fourthItem.add("10");	// SIZE
fourthItem.add("10");	//LENGTH

finAr.add(fourthItem);//add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("List");   //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("eff_status");//name
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
finAr.add(fifthItem); //add to ArrayList obj finAr


String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Language.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Language.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.from.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels");


orderByColVals[0] = "language_id";
orderByColVals[1] = "language_desc";
orderByColVals[2] = "eff_date_from";
orderByColVals[3] = "eff_date_to";



strbuff = qrypg.getQueryPage(con,finAr,"Find PatientInstruction","../../eOA/jsp/TranslatorConfigQueryResultPage.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
finAr.clear();

%>

