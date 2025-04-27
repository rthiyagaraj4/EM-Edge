<!DOCTYPE html>
<%@  page import="java.sql.*, webbeans.eCommon.* , java.io.*" contentType="text/html;charset=UTF-8"  %>

<!-- The following changes are done for Internationalisation Process
Added by Manivel Natarajan on 10/Aug/2006
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs21 = null;
	PreparedStatement pstmt = null;
	//The following changes are done for Internationalisation Process
    //Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");

  	try
  	{
		//con = (Connection) session.getValue("connection" );
		con = ConnectionManager.getConnection(request);
		//unused variable, commented on 09/06/05
		//String nd_settlement_ind ="";
		//String nd_adm_rec_flag ="";
		String /*slmt_type_code="",*/ cash_slmt_flag="" /*,cust_code1=""*/;

		String blng_grp_id= request.getParameter("blng_grp_id");

		if( blng_grp_id == null) blng_grp_id="";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";

		String query_cash_slmt_type="Select cash_slmt_flag from bl_slmt_type where slmt_type_code=?";
		/* stmt=con.createStatement();
		rs21=stmt.executeQuery(query_cash_slmt_type); */
		pstmt = con.prepareStatement(query_cash_slmt_type);
		pstmt.setString(1, blng_grp_id);
		rs21 = pstmt.executeQuery();
		if(rs21 != null)
		{
			while(rs21.next())
			{
				cash_slmt_flag=rs21.getString("cash_slmt_flag");
			}
		}

		if (rs21 != null)   rs21.close();
		if (pstmt != null)   pstmt.close();		

		%>
	<html>
  		<head>
			<!--
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
			-->
			<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--The following changes are done for Internationalisation Process
Commented by Manivel Natarajan on 10/Aug/2006 -->

<!--		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  		</head>
	<%

if(operation.equals("Update"))
{
%>
	<body onLoad='disableAllElements()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
}
else
{
	
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> 
<%
}

%>
		<%
		if(!(cash_slmt_flag.equals("C")))
		{
		%>
<!-- The following changes are done for Internationalisation Process
Cellpadding changed from 1 to 3 by Manivel Natarajan on 10/Aug/2006 -->

			<table border='0' cellpadding='3' cellspacing='0' width='100%'>

		<tr>
<!-- The following changes are done for Internationalisation Process
Align removed & class='fields' for objects by Manivel Natarajan on 10/Aug/2006 -->
<!--
			<td width="50%" align="right" class="label">Cash Instrument Ref</td>
			<td width="50%" align="left" >&nbsp;<input type='text' name='cash_insmt_ref' id='cash_insmt_ref' size='15' maxlength='15'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
-->
			<td width="50%" class="label"><fmt:message key="eBL.CASH_INSTR_REF.label" bundle="${bl_labels}"/></td>
			<td width="50%" class='fields' ><input type='text' name='cash_insmt_ref' id='cash_insmt_ref' size='15' maxlength='15'><img src='../../eCommon/images/mandatory.gif'></td>

		</tr>
		<tr>
<!--
			<td width="50%" align="right" class="label">Cash Instrument Date</td>
			<td width="50%" align="left" >&nbsp;<input type='text' name='cash_insmt_date' id='cash_insmt_date' size='15' maxlength='15'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
-->
			<td width="50%"  class="label"><fmt:message key="eBL.CASH_INSTR_DATE.label" bundle="${bl_labels}"/></td>
			<td width="50%" class='fields' ><input type='text' name='cash_insmt_date' id='cash_insmt_date' size='15' maxlength='15'><img src='../../eCommon/images/mandatory.gif'></td>

		</tr>
		<tr>
<!--
			<td width="50%" align="right" class="label">Cash Instrument Remarks</td>
			<td width="50%" align="left" >&nbsp;<input type='text' name='cash_insmt_rmks' id='cash_insmt_rmks' size='15' maxlength='15'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
-->		
			<td width="50%"  class="label"><fmt:message key="eBL.CASH_INSTR_REMARKS.label" bundle="${bl_labels}"/></td>
			<td width="50%" class='fields' ><input type='text' name='cash_insmt_rmks' id='cash_insmt_rmks' size='15' maxlength='15'><img src='../../eCommon/images/mandatory.gif'></td>
		</tr>
		<%
		}
	%>
<!-- The following changes are done for Internationalisation Process
blank row removed by Manivel Natarajan on 10/Aug/2006 -->
<!--	<tr><td colspan=2>&nbsp;</td></tr> -->
	</table>	
<% } 
	catch(Exception e )
	{ 
		out.println("Exception in main try"+e);
	}
	finally
	{
		if(stmt != null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}
%> 
	</body>
	</html>
		

