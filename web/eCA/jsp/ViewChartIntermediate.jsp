<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<script language="JavaScript" src ="../../eCA/js/ViewChartSetup.js"></script> <!-- to call the function callFunction()-->
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.util.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	String description = "";
	String sql = "";
	String calledFrom = "";
	String summaryValue = "";
	String objText = "";
	String objHidden = "";
	String objTextName = "";
	String hidObjName = "";
	String summaryId = "";
	String summarySql = "";


	//calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");
	//summaryValue = request.getParameter("summaryValue") == null ? "" : request.getParameter("summaryValue");
	//objText = request.getParameter("objText") == null ? "" : request.getParameter("objText");
	//objHidden = request.getParameter("objHidden") == null ? "" : request.getParameter("objHidden");
	//objTextName = request.getParameter("objTextName") == null ? "" : request.getParameter("objTextName");
	//hidObjName = request.getParameter("hidObjName") == null ? "" : request.getParameter("hidObjName");
	try
	{
			int count =0;	
			con = ConnectionManager.getConnection(request);
			description = request.getParameter("chartCode") == null ? "" : request.getParameter("chartCode");
			sql = "Select CHART_ID, SHORT_DESC from ca_chart where eff_status='E' and spl_chart_type is null and upper(SHORT_DESC) like upper(?) order by 2";
			description = description + "%";
			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(count == 1)
			{
				ps = con.prepareStatement(sql);
				ps.setString(1,description);
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
					out.println("parent.viewChartHeaderFrame.document.ViewChartHeaderForm.chartDesc.value='"+rs.getString(2)+"' ");
					out.println("parent.viewChartHeaderFrame.document.ViewChartHeaderForm.viewChartSearch.value='"+rs.getString(1)+"' ");
				}
				out.println("</script>");
			}	
			
			if(count == 0 || count > 1)
			{
				sql = "Select CHART_ID code, SHORT_DESC description from ca_chart where eff_status='E' and spl_chart_type is null  and upper(CHART_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";
				%>
				<script>			 
					retArray = callFunction("<%=sql%>",getLabel("eCA.ViewChartSetup.label","eCA"),parent.viewChartHeaderFrame.document.ViewChartHeaderForm.chartDesc)
					if(retArray != null && retArray !=""){
						parent.viewChartHeaderFrame.document.ViewChartHeaderForm.viewChartSearch.value = retArray[0];
						parent.viewChartHeaderFrame.document.ViewChartHeaderForm.chartDesc.value = retArray[1];
							
					}else{
						parent.viewChartHeaderFrame.document.ViewChartHeaderForm.viewChartSearch.value = ''
						parent.viewChartHeaderFrame.document.ViewChartHeaderForm.chartDesc.value = ''
						
					}
				</script>
				<%		
		    }
	if(rs != null) rs.close();
	if(ps != null) ps.close();	
	}//end of try-1
	catch(Exception ee){
		out.println("Exception in try-1 of ChartComponentIntermediate.jsp "+ee.toString());
		ee.printStackTrace();//COMMON-ICN-0181
	}finally {		
		if(con != null) ConnectionManager.returnConnection(con);		
	}
%>
 </body>
</html>

