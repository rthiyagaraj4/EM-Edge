<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
26/06/2013    	IN039171		Dinesh	 System do not calculate 'day summary' in chart that summary  required such as ?intake/output chart?
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<script language="JavaScript" src ="../../eCA/js/ChartComponent.js"></script> <!-- to call the function callFunction()-->
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.util.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()" onLoad="callLookupFunc()">
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
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


	calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");
	summaryValue = request.getParameter("summaryValue") == null ? "" : request.getParameter("summaryValue");
	objText = request.getParameter("objText") == null ? "" : request.getParameter("objText");
	objHidden = request.getParameter("objHidden") == null ? "" : request.getParameter("objHidden");
	objTextName = request.getParameter("objTextName") == null ? "" : request.getParameter("objTextName");
	hidObjName = request.getParameter("hidObjName") == null ? "" : request.getParameter("hidObjName");
	String k = request.getParameter("k") == null ? "" : request.getParameter("k");//IN039171
	String noofrows = request.getParameter("noofrows") == null ? "" : request.getParameter("noofrows");//IN039171
	try
	{
	/*
		In the below if-else block, if block was added by
		Name   : T DINESH
		Date   : 2010-08-04
		INCNO  : IN022998
		Reason : For opening a new lookup for the discrete measure in the chart component function in CA
				 and also taken the existing code in this page and put them in the else block of this page itself
	*/
	
	if(calledFrom.equals("summaryDefn"))
	{
		con = ConnectionManager.getConnection(request);
		summarySql = "select discr_msr_id code , short_desc description from am_discr_msr where eff_status = 'E' and upper(discr_msr_id) like  upper(?) and upper(short_desc) like upper(?) and  result_type='S' order by 2";
		summaryId = summaryId + "%";
		summaryValue = summaryValue + "%";
		%>
		<script>
		//var label = "eCA.DiscreteMeasureSearch.label";
		var textObj = eval("parent.chartComponentListFrame.ChartComponentListForm."+"<%=objTextName%>"); 
		var hidObj = eval("parent.chartComponentListFrame.ChartComponentListForm."+"<%=hidObjName%>"); 
		retArray = callFunction("<%=summarySql%>",getLabel("eCA.DiscreteMeasureSearch.label","eCA"),textObj)
		
			var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
			
			if(retArray != null && retArray !="")	
			{
				textObj.value = arr[1];
				hidObj.value = arr[0];
				
			}
			else
			{
				textObj.value = ''
				hidObj.value = ''
			
			}
		chkDupSummValues(textObj,'<%=k%>','<%=noofrows%>');////IN039171 
	</script>
	<%
	}
	else
	{
	int count =0;
	
			con = ConnectionManager.getConnection(request);
			description = request.getParameter("chartCode") == null ? "" : request.getParameter("chartCode");
			sql = "Select CHART_ID, SHORT_DESC from ca_chart where eff_status='E' and upper(SHORT_DESC) like upper(?) order by 2";
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
					out.println("parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartDesc.value='"+rs.getString(2)+"' ");
					out.println("parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartCompSearch.value='"+rs.getString(1)+"' ");
				}
			}
			out.println("</script>");
			
			if(count == 0 || count > 1)
			{
				sql = "Select CHART_ID code, SHORT_DESC description from ca_chart where eff_status='E'  and upper(CHART_ID) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";
%>
	<script>
	async function callLookupFunc(){
	//var label = "eCA.Chart.label";	
	
		retArray = await callFunction("<%=sql%>",getLabel("eCA.Chart.label","eCA"),parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartDesc)
	
		var ret1=unescape(retArray);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		} 
		if(retArray != null && retArray !="")	
		{
			parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartCompSearch.value = arr[0];
			parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartDesc.value = arr[1];			
		}
		else
		{
			parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartCompSearch.value = '';
			parent.chartComponentHeaderFrame.document.ChartComponentHeaderForm.chartDesc.value = '';		
		}
	}
	</script>
<%		
		 }
	if(rs != null) rs.close();
	 if(ps != null) ps.close();
				
	}
	}//end of try-1
	catch(Exception ee)
	{
		//out.println("Exception in try-1 of ChartComponentIntermediate.jsp "+ee.toString());//COMMON-ICN-0181
                  ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
				if(con != null) ConnectionManager.returnConnection(con);
		
	}
%>
 </body>
</html>

