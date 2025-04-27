<!DOCTYPE html>
<%--
	FileName	: DiscrMeasureQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>

<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></html></head>
<%!
	ArrayList finAr;
	ArrayList firstItem;
	ArrayList secondItem;
	ArrayList thirdItem ;
	ArrayList fourthItem;

%>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try 
{
	request.setCharacterEncoding("UTF-8");
	con=   ConnectionManager.getConnection(request);
 finAr = new ArrayList();
	 firstItem = new ArrayList();
	firstItem.add("Text");  //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Discrete.label","am_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.MeasureID.label","am_labels"));	// label
	firstItem.add("discr_msr_id"); //name of field
	firstItem.add("10");	// SIZE
	firstItem.add("10");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

 secondItem = new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasureCode.label","common_labels"));	// label
	secondItem.add("long_desc"); //name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	//LENGTH
	finAr.add(secondItem);//add to ArrayList obj finAr

 thirdItem = new ArrayList();
	thirdItem.add("List");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResultType.label","common_labels"));	// label
	thirdItem.add("result_type"); //name of field
	thirdItem.add("Q,-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----,C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckBox.label","common_labels")+",G,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ChartSection.label","am_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.date.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Formula.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FreeText.label","am_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.List.label","common_labels")+",N,Numeric,Z,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.PatientCarePanel.label","am_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Summary.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+",V,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VitalSignsBattery.label","common_labels")+",");//static values that need to be displayed as option.Send it along with the value that is inserted.

	thirdItem.add("1");	//LENGTH
	finAr.add(thirdItem); //add to ArrayList obj finAr

 fourthItem=new ArrayList();
	fourthItem.add("List");  //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	fourthItem.add("nature");   //name of field
	fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
	fourthItem.add("4");	//LENGTH
	finAr.add(fourthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.Discrete.label","am_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.MeasureID.label","am_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasureDescription.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResultType.label","common_labels");

orderByColVals[0] = "DISCR_MSR_ID";
orderByColVals[1] = "LONG_DESC";
orderByColVals[2] = "RESULT_TYPE";

strbuff = qrypg.getQueryPage(con,finAr,"Discr Measure","../../eAM/jsp/DiscrMeasureQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
out.println(strbuff.toString());
}
catch (Exception e) 
{
	e.printStackTrace();
}
finally
{
	finAr.clear();
	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	fourthItem.clear();

	ConnectionManager.returnConnection(con,request);	
}

%>

