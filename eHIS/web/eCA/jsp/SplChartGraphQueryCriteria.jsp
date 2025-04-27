<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
String sql;
Connection con=null ;
PreparedStatement pstmt = null;
ResultSet rset = null;
try
{
	String chartTypes = null;
	con  =  ConnectionManager.getConnection(request);
	sql = "Select SPL_CHART_TYPE, SPL_CHART_TYPE_DESC From CA_SPL_CHART_TYPE where eff_status='E' Order by SPL_CHART_TYPE_DESC";
	pstmt = con.prepareStatement(sql);
	rset  = pstmt.executeQuery();
	String chart_type = null,chart_desc = null;
	while(rset!=null && rset.next())
	{
		chart_type=rset.getString("SPL_CHART_TYPE");
		chart_desc=rset.getString("SPL_CHART_TYPE_DESC");
		if(chartTypes==null)
		{
			chartTypes = "";

		//	chartTypes =" ,---Select---,";
		}
		else
			chartTypes = chartTypes + ",";
		chartTypes = chartTypes+chart_type+",";
		chartTypes = chartTypes+chart_desc;
	}
	if(rset!=null)  rset.close(); 
	if(pstmt!=null) pstmt.close();
	 

	ArrayList finAr = new ArrayList();


		ArrayList firstItem  = new ArrayList();
		firstItem.add("List");							//Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels")); 				//label
		firstItem.add("SPL_CHART_TYPE");				//name of field
		firstItem.add(chartTypes);
		finAr.add(firstItem); 
	
		
		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");           //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Graph.label","ca_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")); 	     // label
		secondItem.add("GRAPH_CODE");     //name of field
		secondItem.add("4");			  // SIZE
		secondItem.add("4");			  //LENGTH
		finAr.add(secondItem);			  //add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");			 //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Graph.label","ca_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));     // label
		thirdItem.add("GRAPH_DESC");	 //name of field
		thirdItem.add("30");		  	 // SIZE
		thirdItem.add("30");			 //LENGTH
		finAr.add(thirdItem);			 //add to ArrayList obj finAr
		
		ArrayList fourthItem = new ArrayList();
		fourthItem.add("List");			//Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));		// label
		fourthItem.add("EFF_STATUS");	//name
		fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");
		finAr.add(fourthItem);		    //add to ArrayList obj finAr

		String[] orderByCols = null;
		String[] orderByColVals = null;

		orderByCols = new String[3];
		orderByColVals = new String[3];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Graph.label","ca_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Graph.label","ca_labels")+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
			

		orderByColVals[0] = "SPL_CHART_TYPE";
		orderByColVals[1] = "GRAPH_CODE";
		orderByColVals[2] = "GRAPH_DESC";
			
		strbuff = qrypg.getQueryPage(con,finAr,"SplChartGraph","../../eCA/jsp/SplChartGraphQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
		finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		fourthItem.clear();
	
} 

catch (Exception e) 
{
	//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}

finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

