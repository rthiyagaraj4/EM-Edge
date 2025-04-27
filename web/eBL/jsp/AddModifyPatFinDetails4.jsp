<!DOCTYPE html>
<%@  page import="java.sql.*, webbeans.eCommon.* , java.io.*" contentType="text/html;charset=UTF-8" %>
<!-- The following changes are done for Internationalisation Process
Added by Manivel Natarajan on 10/Aug/2006
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs21 = null;	



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
		String /*slmt_type_code="",*/ cash_slmt_flag="" /*,cust_code1=""*/;
		String mcash_insmt_ref1="", mcash_insmt_date1="", mcash_insmt_rmks1="";
		String cash_set_type1= request.getParameter("cash_set_type1");
//		System.out.println("Inside 4:"+(String)request.getParameter("billing_group"));

	//	out.println("<script>'"+cash_set_type1+"'</script>");

		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";


		if( cash_set_type1 == null) cash_set_type1="";
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";

		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");
		String strModuleId = request.getParameter("calling_module_id");
		String reset_blng_grp=request.getParameter("reset_blng_grp");
		if(reset_blng_grp==null || reset_blng_grp.equals("")) reset_blng_grp="";
		if(reset_blng_grp.equals("YES")) 
		{
//			session.removeAttribute("financial_details");
			billing_mode="Add";
			operation="Insert";
		}
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			mcash_insmt_ref1 = request.getParameter("cash_insmt_ref1");
			mcash_insmt_date1 = request.getParameter("cash_insmt_date1");
			mcash_insmt_rmks1 = request.getParameter("cash_insmt_rmks1");
		}

		//out.println("blng_grp_id in jsp4"+blng_grp_id);

		String query_cash_slmt_type="Select cash_slmt_flag from bl_slmt_type where slmt_type_code='"+cash_set_type1+"'";

		//out.println("query_cash_slmt_type"+query_cash_slmt_type);


		stmt=con.createStatement();
		rs21=stmt.executeQuery(query_cash_slmt_type);
		if(rs21 != null)
		{
			while(rs21.next())
			{
				cash_slmt_flag=rs21.getString("cash_slmt_flag");
			}
		}
		if (rs21 != null)   rs21.close();
		stmt.close();
		
			
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
	Commented by Manivel Natarajan on 10/Aug/2006 
-->
<!--		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
            <script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
			<script language='javascript' >
			<!--
			function funDisable()
			{
				try
				{
						var varModuleId = document.getElementById("calling_module_id").value;

						disableAllElements();
						if (varModuleId  != "MP") 
						{
							document.getElementById('cash_insmt_date1').disabled=false;
							document.getElementById('cash_insmt_rmks1').disabled=false;
							document.getElementById('cash_insmt_ref1').disabled=false;
						}
				}
				catch(e)
				{
				}
			}

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

			-->
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



  	</head>
  <%

if(operation.equals("Update"))
{
%>
	<body onLoad='funDisable()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
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
	<form name='PatFinCase2.1Form' id='PatFinCase2.1Form' method='post' action=''  scrolling=no >
	<%
	if(!(cash_slmt_flag.equals("Y")))
	{
	%>
	<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<!-- The following changes are done for Internationalisation Process
Align removed & legends updated by class='label' & objects by class='fields'  by Manivel Natarajan on 10/Aug/2006 -->	
	<tr>
<!--		<td width="" align="right" class="label">Cash Instrument Ref</td> -->
			<td width="25%" class="label"><fmt:message key="eBL.INSTR_REF.label" bundle="${bl_labels}"/></td> 
	<%
	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
	{
	%>
<!--	<td width="" align="left" colspan='2'>&nbsp;<input type='text' name='cash_insmt_ref1' id='cash_insmt_ref1' size='20' maxlength='20' value='<%=mcash_insmt_ref1%>'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td> -->
	<td width="25%" class='fields' ><input type='text' name='cash_insmt_ref1' id='cash_insmt_ref1' size='20' maxlength='20' value='<%=mcash_insmt_ref1%>'><img src='../../eCommon/images/mandatory.gif'></td>
	<%
	}
	else
	{
	%>
<!--	<td width="" align="left" colspan='2'>&nbsp;<input type='text' name='cash_insmt_ref1' id='cash_insmt_ref1' size='20' maxlength='20'>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td> -->
	<td width="25%" class='fields' ><input type='text' name='cash_insmt_ref1' id='cash_insmt_ref1' size='20' maxlength='20'><img src='../../eCommon/images/mandatory.gif'></td>
	<%
	}
	%>
<!--<td width="" align="right" class="label">Cash Instrument Date</td> -->
	<td width="25%"  class="label"><fmt:message key="eBL.INSTR_DATE.label" bundle="${bl_labels}"/></td>
		<%
	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
	{
	%>
<!-- 	<td width="" align="left" colspan='2'> -->
		<td width="25%" class='fields'><input type='text' name='cash_insmt_date1' id='cash_insmt_date1' size='10' maxlength='10' value='<%=mcash_insmt_date1%>'onBlur='return CheckDate(this);'><img src="../../eCommon/images/CommonCalendar.gif" onBlur='return CheckDate(document.forms[0].cash_insmt_date1);'  onClick="return showCalendar_loc('cash_insmt_date1',document.forms[0].cash_insmt_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
	<%
	}
	else
	{
	%>
<!--	<td width="" align="left" colspan='2'> -->
	<td width="25%" class='fields'><input type='text' name='cash_insmt_date1' id='cash_insmt_date1' size='10' maxlength='10' onBlur='return CheckDate(this);'><img src="../../eCommon/images/CommonCalendar.gif" onBlur='return CheckDate(document.forms[0].cash_insmt_date1);'  onClick="return showCalendar_loc('cash_insmt_date1',document.forms[0].cash_insmt_date1);"><img src='../../eCommon/images/mandatory.gif'></td>
	<%
	}
	%>
	</tr> 
		<tr>
<!--			<td width="" align="right" class="label">Cash Instrument Remarks</td> -->
				<td width="25%" class="label"><fmt:message key="eBL.INSTR_REMARK.label" bundle="${bl_labels}"/></td> 
	<%
	if((billing_mode.equals("Modify")) || (operation.equals("Update")))
	{
	%>
<!--		<td width="" align="left" colspan='5'>&nbsp;<input type='text' name='cash_insmt_rmks1' id='cash_insmt_rmks1' size='30' maxlength='30' value='<%=mcash_insmt_rmks1%>'></td> -->
		<td width="25%" class='fields' ><input type='text' name='cash_insmt_rmks1' id='cash_insmt_rmks1' size='30' maxlength='30' value='<%=mcash_insmt_rmks1%>'></td>
	<%
	}
	else
	{
	%>
<!--		<td width="" align="left" colspan='5'>&nbsp;<input type='text' name='cash_insmt_rmks1' id='cash_insmt_rmks1' size='30' maxlength='30'></td> -->
		<td width="25%" class='fields'><input type='text' name='cash_insmt_rmks1' id='cash_insmt_rmks1' size='30' maxlength='30'></td>
	<%
	}
	%>
	<td width="25%"></td>
	<td width="25%"></td>
	</tr>
		<%
		}
		%>
<!--
	<tr>
		<td colspan=6></td></tr>
-->
	</table>	
	<input type=hidden name="bl_data_from_repos_yn" id="bl_data_from_repos_yn" value='<%=strRepositoryYN%>'>	
	<input type=hidden name="items_disabled" id="items_disabled" value='<%=strItemsDisabled%>'>	
	<input type=hidden name="calling_module_id" id="calling_module_id" value='<%=strModuleId%>'>	
	


<% } 
	catch(Exception e )
	{
		out.println(e);
	} 
	finally
	{
		if(stmt != null)stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	%> 
</form>
</body>
</html>
		

