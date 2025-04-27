<!DOCTYPE html>
<%--
	FileName	: DiscretePanelQueryCriteria.jsp
	Version	    : 3	
	Created On	: 19-5-2005
	Created By	: Jupitora 
--%>

<%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></html></head>
<%!
	ArrayList finAr;
	ArrayList secondItem;
	ArrayList thirdItem ;
	ArrayList fourthItem;
	ArrayList fifthItem;

%>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff= new StringBuffer();

Connection con=null ;

try 
{
	request.setCharacterEncoding("UTF-8");
	con=   ConnectionManager.getConnection(request);
	 finAr = new ArrayList();
	ArrayList firstItem = new ArrayList();
	firstItem.add("List");  //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResultType.label","common_labels"));	// label
	firstItem.add("result_type"); //name of field
	firstItem.add("Q,-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----,G,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ChartSection.label","am_labels")+",V,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VitalSignsBattery.label","common_labels")+",Z,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.PatientCarePanel.label","am_labels"));	
	finAr.add(firstItem);//add to ArrayList obj finAr

	 secondItem = new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels"));	// label
	secondItem.add("discr_msr_id"); //name of field
	secondItem.add("10");	// SIZE
	secondItem.add("10");	//LENGTH
	finAr.add(secondItem);//add to ArrayList obj finAr
	 thirdItem = new ArrayList();
	thirdItem.add("Text");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels"));	// label
	thirdItem.add("long_desc"); //name of field
	thirdItem.add("60");	// SIZE
	thirdItem.add("60");	//LENGTH
	finAr.add(thirdItem);//add to ArrayList obj finAr

	 fourthItem = new ArrayList();
	fourthItem.add("Text");  //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));	// label
	fourthItem.add("short_desc"); //name of field
	fourthItem.add("30");	// SIZE
	fourthItem.add("30");	//LENGTH
	finAr.add(fourthItem);//add to ArrayList obj finAr

	 fifthItem=new ArrayList();
	fifthItem.add("List");  //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	fifthItem.add("nature");   //name of field
	fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as option.Send it along with the value that is inserted.
	fifthItem.add("4");	//LENGTH
	finAr.add(fifthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[4];
String orderByColVals[] = new String[4];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ResultType.label","common_labels");

orderByColVals[0] = "DISCR_MSR_ID";
orderByColVals[1] = "LONG_DESC";
orderByColVals[2] = "SHORT_DESC";
orderByColVals[3] = "RESULT_TYPE";


strbuff = qrypg.getQueryPage(con,finAr,"Discr Panel","../../eAM/jsp/DiscretePanelQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
out.println(strbuff.toString());

firstItem.clear();
}
catch (Exception e) 
{
	e.printStackTrace();
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 

%>

