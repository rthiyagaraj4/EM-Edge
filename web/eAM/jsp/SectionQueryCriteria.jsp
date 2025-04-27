<!DOCTYPE html>
<%--
	FileName	: SectionQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.*" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>
<%!
ArrayList finAr;
ArrayList firstItem;
ArrayList secondItem;
ArrayList thirdItem;
ArrayList forthItem;
ArrayList fifthItem;
%>
<%
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;

	try
	{
	 con = ConnectionManager.getConnection(request);
	
	 finAr = new ArrayList();

	 firstItem = new ArrayList();
		firstItem.add("Text");  		 // Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	 // label
		firstItem.add("dept_code");	//name of field
		firstItem.add("10");	// SIZE
		firstItem.add("10");	// LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

	 secondItem = new ArrayList();
		secondItem.add("Text");  		 //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
		secondItem.add("long_desc1");	//name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	// LENGTH
		finAr.add(secondItem);//add to ArrayList obj finAr

	 thirdItem = new ArrayList();
		thirdItem.add("Text");  		 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels"));	  // label
		thirdItem.add("section_code");	//name of field
		thirdItem.add("6");	// SIZE
		thirdItem.add("6");	// LENGTH
		finAr.add(thirdItem);//add to ArrayList obj finAr

	forthItem = new ArrayList();
		forthItem.add("Text");  		 //Type of item
		forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels"));	  // label
		forthItem.add("long_desc2");	//name of field
		forthItem.add("30");	// SIZE
		forthItem.add("30");	// LENGTH
		finAr.add(forthItem);//add to ArrayList obj finAr

	fifthItem = new ArrayList();
		fifthItem.add("List");   //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		fifthItem.add("eff_status");//name
		fifthItem.add("B, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
		finAr.add(fifthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[4];
	String orderByColVals[] = new String[4];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.acctdept.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[2] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionDescription.label","common_labels");

	orderByColVals[0] = "dept_code";
	orderByColVals[1] = "dept_long_desc";
	orderByColVals[2] = "section_code";
	orderByColVals[3] = "section_long_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Section","../../eAM/jsp/SectionQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels"));

	out.println(strbuff.toString());
	}
	catch (Exception e)
	{}
	finally
	{
		 ConnectionManager.returnConnection(con,request);
	}

%>
