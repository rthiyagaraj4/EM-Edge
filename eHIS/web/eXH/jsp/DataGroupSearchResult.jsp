<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/DataGroupId.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>	    
<form name="APPL_RESULTS" id="APPL_RESULTS" method="POST" action=''  >

	<%
	/*

			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "APIBASEDINBOUND";
			Connection conn = null;


			try
			{
				
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"7");
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","xh_labels");
				String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","xh_labels");
				if (boolPrevious == true)
				{
					strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","xh_labels");
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","xh_labels");
				}
				else
				{
					strNext  = " ";
		
			}*/
		%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>


<tr>
	<td class='COLUMNHEADER'  width='50%'>Data</td>
	<td class='COLUMNHEADER'  width='50%'>Application ID</td>
	<td class='COLUMNHEADER'  width='50%'>Facility ID</td>
	<td class='COLUMNHEADER'  width='50%'>Message Type</td>
	<td class='COLUMNHEADER'  width='50%'>Event Type</td>
	<td class='COLUMNHEADER'  width='50%'>Segment Type</td>
	<td class='COLUMNHEADER'  width='50%'>Protocol Link ID</td>

</tr>



</table>

	<input type='hidden' name='mode' id='mode' value='U' >
	<input type='hidden' name='action_type' id='action_type' value=''>
	<input type='hidden' name='inboundapi_id' id='inboundapi_id' value=''>
	<input type='hidden' name='inboundapi_name' id='inboundapi_name' value=''>
	<input type='hidden' name='arg_serial_no' id='arg_serial_no' value=''>
	<input type='hidden' name='arg_id' id='arg_id' value=''>
	<input type='hidden' name='arg_name' id='arg_name' value=''>
	<input type='hidden' name='element_pos' id='element_pos' value=''>
	<input type='hidden' name='element_val' id='element_val' value=''>


</form>
</html>


