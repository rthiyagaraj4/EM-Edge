<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*, webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>

<%
ecis.utils.CommonQueryPage chartQrypg = new ecis.utils.CommonQueryPage();

StringBuffer sbChart;
Connection con = null;

try{
	con = ConnectionManager.getConnection(request);
	
	ArrayList chartArray = new ArrayList();
	
	ArrayList listOne = new ArrayList();
	listOne.add("Text");
	listOne.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChartCode.label","ca_labels"));
	listOne.add("chart_id");
	listOne.add("6");
	listOne.add("4");
	chartArray.add(listOne);
	
	ArrayList listTwo = new ArrayList();
	listTwo.add("Text");
	listTwo.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels"));
	listTwo.add("long_desc");
	listTwo.add("40");
	listTwo.add("40");
	chartArray.add(listTwo);
	
	ArrayList listThree = new ArrayList();
	listThree.add("Text");
	listThree.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));
	listThree.add("short_desc");
	listThree.add("30");
	listThree.add("30");
	chartArray.add(listThree);
	
	String[] OrderByCols = null;
	String[] OrderByColValues = null;
	
	OrderByCols = new String[3];
	OrderByColValues = new String[3];
	
	OrderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChartCode.label","ca_labels");
	OrderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels");
	OrderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");
	
	OrderByColValues[0] = "chart_id";
	OrderByColValues[1] = "long_desc";
	OrderByColValues[2] = "short_desc";

	sbChart = chartQrypg.getQueryPage(con,chartArray,"Chart Setup", "../../eCA/jsp/ChartSetupQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),OrderByCols,OrderByColValues,"Execute Query");
	out.println(sbChart.toString());




chartArray.clear();
listOne.clear();
listTwo.clear();
listThree.clear();

}//end of try
catch(Exception e){
//	out.println("Exception in try of ChartSetupQueryCriteria.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

