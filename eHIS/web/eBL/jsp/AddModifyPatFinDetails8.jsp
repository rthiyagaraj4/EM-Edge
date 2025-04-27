<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*, java.io.*" contentType="text/html;charset=UTF-8" %>

<!-- The following changes are done for Internationalisation Process
Added by Manivel Natarajan on 10/Aug/2006
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

  <%
	    Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
	//The following changes are done for Internationalisation Process
	//Added by Manivel Natarajan on 10/Aug/2006
		request.setCharacterEncoding("UTF-8");
  	try
  	{
		
		//con = (Connection) session.getValue("connection" );
		con	=	ConnectionManager.getConnection(request);
		//unused variable, commented on 09/06/05
		//String nd_settlement_ind ="";
		//String nd_adm_rec_flag ="";
		String /*slmt_type_code="",*/ cash_slmt_flag="" /*, cust_code1=""*/;
//		System.out.println("Inside 8:"+(String)request.getParameter("billing_group"));
		String mcash_insmt_ref2="",mcash_insmt_date2="",mcash_insmt_rmks2="";
		String cash_set_type2= request.getParameter("cash_set_type2");
		if( cash_set_type2 == null) cash_set_type2="";
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";

		String  payerGrpBySetup= request.getParameter("payerGrpBySetup");
			if(payerGrpBySetup==null ) payerGrpBySetup = "";	

		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";

		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");
		String strModuleId = request.getParameter("calling_module_id");

		if (strRepositoryYN == null)
		{
			strRepositoryYN = "";
		}

		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}
		if (strModuleId ==null)
		{
			strModuleId = "";		
		}	
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			mcash_insmt_ref2 = request.getParameter("cash_insmt_ref2");
			mcash_insmt_date2 = request.getParameter("cash_insmt_date2");
			mcash_insmt_rmks2 = request.getParameter("cash_insmt_rmks2");
		}

	//	out.println("blng_grp_id in jsp4"+blng_grp_id);

		String query_cash_slmt_type="Select cash_slmt_flag from bl_slmt_type where slmt_type_code='"+cash_set_type2+"'";

		
		stmt=con.createStatement();
		rs=stmt.executeQuery(query_cash_slmt_type);
		if(rs != null)
		{
			while(rs.next())
			{
				cash_slmt_flag=rs.getString("cash_slmt_flag");
			}
		}
		if(rs != null) rs.close();
		
	
		//if(nd_settlement_ind.equals("C") && nd_adm_rec_flag.equals("0") && (!(cash_slmt_flag.equals("C"))))
		//	{
		//		out.println("cash_slmt_flag"+cash_slmt_flag);
		//	}
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
<!-- The following changes are done for Internationalisation Process
Commented by Manivel Natarajan on 10/Aug/2006 -->
<!--		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
            <script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>


			<script language='javascript'>
			<!--
			
			function showCalendar_loc(Val1, Val2)
			{	
				if (Val2.disabled == true)		
				{
					return false;
				}
				else
				{
					return showCalendar(Val1);
				}
			}

			//-->
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



  	</head>
  <%

if(operation.equals("Update"))
{

	if(!("Y").equalsIgnoreCase(payerGrpBySetup)){
	%>
		<body onLoad='disableAllElements()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
	}
	else{
	%>	
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
	}

}
else if (strRepositoryYN.equals("Y") && strModuleId.equals("MP") )
{
%>
	<body onLoad='disableMappingItems()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

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
	if(!(cash_slmt_flag.equals("Y")))
	{
	%>
		<form name='PatFinCase4.1Form' id='PatFinCase4.1Form' method='post' action=''  scrolling=no >
<!-- The following changes are done for Internationalisation Process
Cellpadding changed from 1 to 3 & align is removed by Manivel Natarajan on 10/Aug/2006 -->
	<table align='center' border='0' cellpadding='3' cellspacing='0' width='100%'>
	
	<tr>
<!--
			<td width="" align="right" class="label">Instrument Ref</td>
-->
			<td width="25%" class="label"><fmt:message key="eBL.INSTR_REF.label" bundle="${bl_labels}"/></td>
		<%
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
		%>
<!--
			<td width="" align="left" colspan='2'>&nbsp;<input type='text' name='cash_insmt_ref2' id='cash_insmt_ref2' size='15' maxlength='20' value='<%=mcash_insmt_ref2%>'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
-->
			<td width="25%" class='fields' ><input type='text' name='cash_insmt_ref2' id='cash_insmt_ref2' size='20' maxlength='20' value='<%=mcash_insmt_ref2%>'><img src='../../eCommon/images/mandatory.gif'></td>
		<%
		}
		else
		{
		%>
<!--
			<td width="" align="left" colspan='2'>&nbsp;<input type='text' name='cash_insmt_ref2' id='cash_insmt_ref2' size='15' maxlength='20'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
-->
			<td width="25%" class='fields' ><input type='text' name='cash_insmt_ref2' id='cash_insmt_ref2' size='20' maxlength='20'><img src='../../eCommon/images/mandatory.gif'></td>
		<%
		}
		%>
<!--		<td width="" align="right" class="label">Instrument Date</td> -->
			<td width="25%" class="label"><fmt:message key="eBL.INSTR_DATE.label" bundle="${bl_labels}"/></td>
		<%
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
		%>
<!--		<td width="" align="left" colspan='2'> -->
			<td width="25%" class='fields' ><input type='text' name='cash_insmt_date2' id='cash_insmt_date2' size='15' maxlength='15' value='<%=mcash_insmt_date2%>'onBlur='return CheckDate(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('cash_insmt_date2',document.forms[0].cash_insmt_date2);"><img src='../../eCommon/images/mandatory.gif'></td>
		<%
		}
		else
		{
		%>
<!--		<td width="" align="left" colspan='2'> -->
				<td width="25%" class='fields' ><input type='text' name='cash_insmt_date2' id='cash_insmt_date2' size='15' maxlength='15' onBlur='return CheckDate(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar_loc('cash_insmt_date2',document.forms[0].cash_insmt_date2);"><img src='../../eCommon/images/mandatory.gif'></td>
		<%
		}
		%>
			</tr>
<!--
		</tr>
		<tr> -->
		<tr>
<!--			<td width="" align="right" class="label">Instrument Remarks</td> -->
				<td width="25%" class="label"><fmt:message key="eBL.INSTR_REMARK.label" bundle="${bl_labels}"/></td>
		<%
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
		%>
<!--		<td width="" align="left" colspan=6>&nbsp;<input type='text' name='cash_insmt_rmks2' id='cash_insmt_rmks2' size='20' maxlength='20' value='<%=mcash_insmt_rmks2%>'></td> -->
			<td width="25%" class='fields' ><input type='text' name='cash_insmt_rmks2' id='cash_insmt_rmks2' size='20' maxlength='20' value='<%=mcash_insmt_rmks2%>'></td>
		<%
		}
		else
		{
		%>
<!--		<td width="" align="left" colspan=6>&nbsp;<input type='text' name='cash_insmt_rmks2' id='cash_insmt_rmks2' size='20' maxlength='20'></td> -->
			<td width="25%" class='fields' ><input type='text' name='cash_insmt_rmks2' id='cash_insmt_rmks2' size='20' 	maxlength='20'></td>
		<%
		}
		%>
		<td width="25%" class="label"></td>
		<td width="25%" class="label"></td>
		</tr>
		<%
		}
		%>
<!-- The following changes are done for Internationalisation Process
blank row removed by Manivel Natarajan on 10/Aug/2006 -->
<!--
	<tr>
		<td colspan=15>&nbsp;</td></tr>
			<tr>
		<td colspan=15>&nbsp;</td></tr>
			<tr>
		<td colspan=15>&nbsp;</td></tr>
-->
	<tr>
		<td colspan=15>&nbsp;</td>
	</tr>
	
	<tr>
		<td colspan=15>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=15>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=15>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=15>&nbsp;</td>
	</tr>
	</table>	
	<input type=hidden name="bl_data_from_repos_yn" id="bl_data_from_repos_yn" value='<%=strRepositoryYN%>'>	
	<input type=hidden name="items_disabled" id="items_disabled" value='<%=strItemsDisabled%>'>	
	<input type=hidden name="calling_module_id" id="calling_module_id" value='<%=strModuleId%>'>	


<%  } 
	catch(Exception e )
	{ 
		out.println(e);
	}
	finally
	{
		if(stmt != null) stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%> 

	</body>
	</form>
	</html>
		

