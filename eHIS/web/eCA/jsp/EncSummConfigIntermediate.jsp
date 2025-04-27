<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
17/09/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/EncSummConfig.js"></script>
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
	String summary_code = "";
	String detailsFrameSrc = "";
	String sql = "";
	int count =0;
	try
	{
		con = ConnectionManager.getConnection(request);
		summary_code = request.getParameter("summary_code") == null ? "" : request.getParameter("summary_code");
		detailsFrameSrc = request.getParameter("detailsFrameSrc") == null ? "" : request.getParameter("detailsFrameSrc");
		
		sql = "Select es_summ_code code, es_summ_desc description, es_summ_title, es_summ_type from cr_es_summ_hdr "+ 
				" where es_summ_status='E' and (upper(es_summ_code) like upper(?) or upper(es_summ_desc) like upper(?)) order by (es_summ_desc) ";
		 
		summary_code = summary_code + "%";
		ps = con.prepareStatement(sql);
		ps.setString(1,summary_code);
		ps.setString(2,summary_code);
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
				out.println("parent.HeaderFrame.document.HeaderForm.summaryCode.value='"+rs.getString(2)+"' ");
				out.println("parent.HeaderFrame.document.HeaderForm.flag.value='true' ");	
				out.println("parent.HeaderFrame.document.HeaderForm.summary.value='"+rs.getString(1)+"' ");				
				out.println("parent.DetailsFrame.location.href='"+detailsFrameSrc+"'");				
				out.println("parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'");
				out.println("parent.HeaderFrame.document.HeaderForm.finalString.value=''");
			}
		}
		if(rs != null) rs.close();
		out.println("</script>");
		if(count == 0 || count > 1)
		{
			sql = "SELECT es_summ_code code, es_summ_desc description, es_summ_title FROM cr_es_summ_hdr "+ 
					" WHERE es_summ_status='E' and upper(es_summ_code) like upper(?) and  upper(es_summ_desc) like upper(?) ORDER BY(es_summ_desc)";

%>
	<script>
	 	retArray = callFunction("<%=sql%>","MainSummary",parent.HeaderFrame.document.HeaderForm.summaryCode)
		if(retArray != null && retArray !="")	
		{
			secRefresh("");
			parent.HeaderFrame.document.HeaderForm.summaryCode.value = retArray[1];
			parent.HeaderFrame.document.HeaderForm.summary.value = retArray[0];
			parent.HeaderFrame.document.HeaderForm.flag.value = 'true';
			parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';				
		}
		else
		{
			secRefresh("");
			parent.HeaderFrame.document.HeaderForm.summaryCode.value = ''
			parent.HeaderFrame.document.HeaderForm.summary.value = ''
			parent.HeaderFrame.document.HeaderForm.flag.value = 'true';
			parent.parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		}			
	</script>
<%
		}	
		if(rs != null) rs.close();
		if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in Enc Summary Config Intermediate Module "+ee.toString());//COMMON-ICN-0181
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

