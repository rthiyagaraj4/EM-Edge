<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/SectionChart.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<SCRIPT LANGUAGE="JavaScript">
			var returnArray;
		</SCRIPT>
</head>
<%@page import="java.sql.*, java.io.*,java.util.*, webbeans.eCommon.ConnectionManager"%>
<body OnMouseDown='CodeArrest();' onKeyDown="lockKey()">
<%

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String description ="";
	String sql = "";
	int count =0;
	try
	{
			con = ConnectionManager.getConnection(request);
			description = request.getParameter("chartCode") == null ? "" : request.getParameter("chartCode");
			String rowNum = request.getParameter("rowNum") == null ? "" : request.getParameter("rowNum");
			String colNum = request.getParameter("colNum") == null ? "" : request.getParameter("colNum");
			sql = "Select discr_msr_id ,SHORT_DESC  from am_discr_msr where eff_status='E' and upper(SHORT_DESC) like upper(?) order by 2";
			description = description + "%";
			
			ps = con.prepareStatement(sql);
			ps.setString(1,description.toString());
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
				ps.setString(1,description.toString());
				rs = ps.executeQuery();

				while(rs.next())
				{
%>
<SCRIPT LANGUAGE="JavaScript">
var objText  = eval("parent.chartComponentListFrame.document.ChartComponentListForm.summary_column"+"<%=rowNum%>"+"<%=colNum%>")
var objHidden = eval("parent.chartComponentListFrame.document.ChartComponentListForm.summaryColumnCode"+"<%=rowNum%>"+"<%=colNum%>")
objText.value="<%=rs.getString(2)%>"
objHidden.value="<%=rs.getString(1)%>"
parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%				
				}
			}

			if(count == 0 || count > 1)
			{
				sql = "Select discr_msr_id code,SHORT_DESC description from am_discr_msr where eff_status='E' and upper(discr_msr_id) like upper(?) and  upper(SHORT_DESC) like upper(?) order by 2";
%>
	<script>
	var objText5  = eval("parent.chartComponentListFrame.document.ChartComponentListForm.summary_column"+"<%=rowNum%>"+"<%=colNum%>")
		 retArray = callFunction("<%=sql%>","Chart",objText5)

if(retArray != null && retArray !="")	
			{

					var objText1  = eval("parent.chartComponentListFrame.document.ChartComponentListForm.summary_column"+"<%=rowNum%>"+"<%=colNum%>")
					var objHidden1 = eval("parent.chartComponentListFrame.document.ChartComponentListForm.summaryColumnCode"+"<%=rowNum%>"+"<%=colNum%>")
					objText1.value= retArray[1];
					objHidden1.value= retArray[0];					
			}
			else
			{
					var objText2  = eval("parent.chartComponentListFrame.document.ChartComponentListForm.summary_column"+"<%=rowNum%>"+"<%=colNum%>")
					var objHidden2 = eval("parent.chartComponentListFrame.document.ChartComponentListForm.summaryColumnCode"+"<%=rowNum%>"+"<%=colNum%>")
					var objSummYn = eval("parent.chartComponentListFrame.document.ChartComponentListForm.sum_yn"+"<%=rowNum%>"+"<%=colNum%>")

					objText2.value= '';
					objHidden2.value= '';
					objSummYn.value ="N";
					objSummYn.checked = false;


			
			}
	parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'
	</script>
<%	
		 }
	
				if(rs != null) rs.close();
				if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in Chart Section  Intermediate Module "+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();
	}
	finally
	{
	
				if(con != null) ConnectionManager.returnConnection(con);
	}
		
%>
 </body>
</html>

