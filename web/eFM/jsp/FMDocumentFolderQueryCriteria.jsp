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
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DocumentFolderID.label","fm_labels"));
		firstItem.add("DOC_FOLDER_ID");
		firstItem.add("10");
		firstItem.add("10");

		finAr.add(firstItem);
		
		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DocumentFolderName.label","fm_labels"));
		secondItem.add("DOC_FOLDER_NAME");
		secondItem.add("30");
		secondItem.add("30");
			
		finAr.add(secondItem);
		
		ArrayList thirdItem = new ArrayList();

		thirdItem.add("List");
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DocumentFolderType.label","fm_labels"));
		thirdItem.add("PATIENT_PERIOD_SPECIFIC");
		thirdItem.add("B,Both,P,Patient,D,Period");

		finAr.add(thirdItem);

		ArrayList fourthItem = new ArrayList();

		fourthItem.add("List");
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));
		fourthItem.add("EFF_STATUS");
		fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));

		finAr.add(fourthItem);

		String orderByCols[]  = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DocumentFolderID.label","fm_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DocumentFolderName.label","fm_labels");

		orderByColVals[0] = "DOC_FOLDER_ID";
		orderByColVals[1] = "DOC_FOLDER_NAME";

		strbuff = qrypg.getQueryPage(conn,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.DocumentFolder.label","fm_labels"),"../jsp/FMDocumentFolderQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,"Execute Query");

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
