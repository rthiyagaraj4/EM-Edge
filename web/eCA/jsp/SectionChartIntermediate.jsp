<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/SectionChart.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String description = "";
	String sql = "";
	int count =0;
	try
	{
			con = ConnectionManager.getConnection(request);
			description = request.getParameter("chartCode") == null ? "" : request.getParameter("chartCode");
			sql = "Select CHART_ID, SHORT_DESC from ca_chart where eff_status='E' and upper(SHORT_DESC) like upper(?) and not exists (select 1 from ca_chart_section_comp where chart_id=ca_chart.chart_id ) order by 2";
			description = description + "%";

			ps = con.prepareStatement(sql);
			ps.setString(1,description);
			rs = ps.executeQuery();
			while(rs.next())
			{
				count++;
			}	
			if(count == 1)
			{
				rs = ps.executeQuery();
				out.println("<script>");
				while(rs.next())
				{	
					out.println("parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartDesc.value='"+rs.getString(2)+"' ");
					out.println("parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.flag.value='true' ");	out.println("parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartCode.value='"+rs.getString(1)+"' ");
				}
			}
			if(rs != null) rs.close();
			out.println("</script>");
			if(count == 0 || count > 1)
			{
				sql = "Select CHART_ID code, SHORT_DESC description from ca_chart where eff_status='E'  and CHART_ID like upper(?) and  upper(SHORT_DESC) like upper(?) and not exists (select 1 from ca_chart_section_comp where chart_id=ca_chart.chart_id ) order by 2";
%>
	<script>
		 retArray = callFunction("<%=sql%>","Chart",parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartDesc)
			if(retArray != null && retArray !="")	
			{
					parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartDesc.value = retArray[1];
					parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartCode.value = retArray[0];
					parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.flag.value = 'true'
					parent.sectionChartMiddleFrame.location.href='../../eCommon/html/blank.html';	parent.sectionChartSearchFrame.location.href='../../eCommon/html/blank.html';
					parent.sectionChartBottomFrame.location.href='../../eCommon/html/blank.html';
					parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
			}
			else
			{
				parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartDesc.value = ''
				parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartCode.value = ''
				parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.flag.value = 'true'
				parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
				parent.sectionChartMiddleFrame.location.href='../../eCommon/html/blank.html';	parent.sectionChartSearchFrame.location.href='../../eCommon/html/blank.html';
				parent.sectionChartBottomFrame.location.href='../../eCommon/html/blank.html';
			}			
	</script>
<%
		 }	
	if(rs != null) rs.close();
	if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in Chart Section  Intermediate Module "+ee.toString());//common-icn-0181
	         ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}
%>
 </body>
</html>

