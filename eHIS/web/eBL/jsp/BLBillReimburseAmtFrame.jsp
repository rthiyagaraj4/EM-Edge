<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
		String function_id = request.getParameter("function_id");
		if(function_id == null) function_id="";

//		System.err.println("params in ReimAmtFrame.jsp:"+params);
%>
<HTML>
<HEAD>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

		<script language='javascript' src='../../eBL/js/BLBillReimburseAmtDetails.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
			if(function_id.equals("EBL_OP_OVERRIDE_REIM_DTLS") || function_id.equals("EBL_IP_OVERRIDE_REIM_DTLS"))
			{
%>
		<iframe name='BillReimbAmtBillsListFrame' id='BillReimbAmtBillsListFrame' src='BLBillReimburseAmtBillsList.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
			<iframe name='BillReimbAmtBillServDtlsFrame' id='BillReimbAmtBillServDtlsFrame' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:45vh;width:100vw'></iframe>
<%
			}
			else if(function_id.equals("EBL_OP_OVERIDE_UNBLD_REIM_DTLS") || function_id.equals("EBL_IP_OVERIDE_UNBLD_REIM_DTLS"))
			{
%>
			<iframe SRC="../../eCommon/html/blank.html" name="BillReimbAmtBillsListFrame" id="BillReimbAmtBillsListFrame" frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>	
			<iframe name='BillReimbAmtBillServDtlsFrame' id='BillReimbAmtBillServDtlsFrame' src='BLBillReimburseAmtBillServDetails.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:45vh;width:100vw'></iframe>
<%
			}
%>
			<iframe name='BillReimbAmtBillServAuditDtlsFrame' id='BillReimbAmtBillServAuditDtlsFrame' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:25vh;width:100vw'></iframe>
			<iframe name='BillReimbAmtBillServButtonFrame' id='BillReimbAmtBillServButtonFrame' src='BLBillReimburseAmtButtonPage.jsp' frameborder=0 noresize scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
			<iframe SRC="../../eCommon/html/blank.html"	  name="submit_frame" id="submit_frame" frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
</HTML>

