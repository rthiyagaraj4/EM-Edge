<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head></html>
<% 
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection conn = null;
	try
	{
		conn = ConnectionManager.getConnection(request);
		
		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));
		firstItem.add("DOC_CODE");
		firstItem.add("10");
		firstItem.add("10");
		finAr.add(firstItem);
		
		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels"));
		secondItem.add("DOC_NAME");
		secondItem.add("40");
		secondItem.add("40");
		finAr.add(secondItem);

		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.documentno.label","common_labels"));
		thirdItem.add("DOC_NUMBER");
		thirdItem.add("15");
		thirdItem.add("15");
		finAr.add(thirdItem);
		
		ArrayList fourthItem = new ArrayList();
		fourthItem.add("List");
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));
		fourthItem.add("EFF_STATUS");
		fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
		finAr.add(fourthItem);

		String orderByCols[]  = new String[3];
		String orderByColVals[] = new String[3];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DocumentCode.label","fm_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DocumentName.label","fm_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.documentno.label","common_labels");

		orderByColVals[0] = "DOC_TYPE_CODE";
		orderByColVals[1] = "DOC_TYPE_NAME";
		orderByColVals[2] = "DOC_NO";

		strbuff = qrypg.getQueryPage(conn,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DocumentFolder.label","fm_labels"),"../jsp/FMDocumentTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		finAr.clear(); 
		firstItem.clear(); 
		secondItem.clear(); 
		thirdItem.clear(); 
		fourthItem.clear();
	}
	catch(Exception e){
		out.println("Exception while fetching Connection :"+e.toString());
	}
	finally{
		ConnectionManager.returnConnection(conn,request);
	}
%>
