<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8"%>
<script>

</script>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con					= null;
	Statement stmt					= null;
	Statement stmt2					= null;
	ResultSet rs					= null;
	ResultSet rs1					= null;
	ResultSet rs2					= null;
	String vis						= "";
	String param					= request.getParameter("param");
	try{
		con=ConnectionManager.getConnection(request);
		stmt					= con.createStatement();
		stmt2					= con.createStatement();		
	if(param == null ) param="";
	String fr_bed_type_code=request.getParameter("FR_BED_TYPE_CODE");
	if(fr_bed_type_code == null) fr_bed_type_code="";

	String to_bed_type_code1=request.getParameter("to_bed_type_code");
	if( to_bed_type_code1 == null) to_bed_type_code1="";
	String to_bed_type_code="";
	String fr_bed_type_desc="";
	String to_bed_type_desc="";
	String percent_amt_ind ="";
	String fr_or_to_charge_per ="";
	String transfer_serv_charge   ="";
	String eff_status ="";
	String fr_dly_charge="";
	String to_dly_charge="";

	float entered_amount=0.0f;

	if(fr_bed_type_code != null || !fr_bed_type_code.equals(""))
	{
	StringBuffer sql5 = new StringBuffer();
	sql5.append("Select to_bed_type_code, FR_BED_TYPE_short_DESC,TO_BED_TYPE_short_DESC,percent_amt_ind,blng_serv_code,fr_or_to_charge_per,transfer_serv_charge,eff_status,fr_dly_charge,to_dly_charge   from ip_transfer_charge_vw where fr_bed_type_code='"+fr_bed_type_code+"' and to_bed_type_code='"+to_bed_type_code1+"'");
	
	stmt2 = con.createStatement();

	rs2 = stmt2.executeQuery(sql5.toString());
	if(rs2 !=null)
		{
		 while(rs2.next())
			{
				to_bed_type_code	= rs2.getString("to_bed_type_code");
				fr_bed_type_desc	= rs2.getString("FR_BED_TYPE_short_DESC");
				to_bed_type_desc	= rs2.getString("TO_BED_TYPE_short_DESC");
				percent_amt_ind		= rs2.getString("percent_amt_ind");
				fr_or_to_charge_per = rs2.getString("fr_or_to_charge_per");

				transfer_serv_charge = rs2.getString("transfer_serv_charge");
				eff_status =rs2.getString("eff_status");

				fr_dly_charge=rs2.getString("fr_dly_charge");
				if(fr_dly_charge == null) fr_dly_charge="";

				to_dly_charge=rs2.getString("to_dly_charge");
				if(to_dly_charge == null) to_dly_charge="";

				if(percent_amt_ind.equals("P"))
				{
					if(fr_or_to_charge_per.equals("F"))
					{
						entered_amount = Float.parseFloat(transfer_serv_charge)*100/Float.parseFloat(fr_dly_charge);
					}
					else
					{
						entered_amount = Float.parseFloat(transfer_serv_charge)*100/Float.parseFloat(to_dly_charge);
					}
				}
				else
				{
					entered_amount = Float.parseFloat(transfer_serv_charge);
				}
			}
		}
	if(rs2 !=null) rs2.close();
	if(stmt2 !=null) stmt2.close();
	}
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<HEAD>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>

<script src='../js/TransferCharge.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='transfer_charge' id='transfer_charge' action='../../servlet/eIP.TransferChargeServlet' method='post' target='messageFrame'>
<br>
<br>
<br>
<br>
<br>

<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
<tr>
	<td>

		<table border='0' cellpadding='0' cellspacing='0' width='97%' align='center'>
		<tr>
		<td colspan='4'>&nbsp;</td>
		</tr>

		<TR>
		<TD class="label" width='25%' align='right' nowrap>
			<fmt:message key="eIP.FromBedType.label" bundle="${ip_labels}"/>&nbsp;&nbsp;
		</TD>
		<% if(! param.equals("query")) {	%>
		<TD width='25%' align='left'>
			<SELECT name="from_bed_type" id="from_bed_type" onChange='calcbedcharge(this)'>
			<option value=''>&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;
			<%
	       		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
				StringBuffer sql1 = new StringBuffer();
				sql1.append(" Select bed_type_code,short_desc from ip_bed_type where eff_status='E'  order by short_desc ");
				
	       		rs = stmt.executeQuery(sql1.toString());
				int i=0;
	      if( rs != null )
	      {
			  while( rs.next() )
	          {
				out.println("<script>bedTypeArr["+i+"]='"+rs.getString("bed_type_code")+"';</script>");
				String classcode = rs.getString( "bed_type_code" ) ;
				String classname = rs.getString( "short_desc" ) ;
%>
				<OPTION VALUE='<%= classcode %>' ><%= classname %>
<%
				 i++;
				}
	      }
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
%>
			</SELECT>&nbsp;&nbsp;<img src='../../eMP/images/mandatory.gif'align='center'></img>&nbsp;&nbsp;
		<% } else { %>
			<TD width='25%' align='left'>
			<INPUT TYPE="text" name="from_bed_type1" id="from_bed_type1" value='<%=fr_bed_type_desc%>' readonly>&nbsp;&nbsp;<img src='../../eMP/images/mandatory.gif'align='center'>
			<INPUT TYPE="hidden" name="from_bed_type" id="from_bed_type" value='<%=fr_bed_type_code %>'>
			<% } %>
		</TD>
		<TD class="label" width='25%' align='right' nowrap<fmt:message key="eIP.BedCharge.label" bundle="${ip_labels}"/>&nbsp;&nbsp;
		</TD>
		<TD width='22%' align='left'>
			<INPUT TYPE="text" name="bed_from_charge" id="bed_from_charge" size='10' value='<%=fr_dly_charge%>' readonly>
		</TD>
		</TR>
		<tr>
		<td colspan='4'>&nbsp;</td>
		</tr>
		<TR>
		<TD class="label" width='25%' align='right' nowrap>
			<fmt:message key="eIP.ToBedType.label" bundle="${ip_labels}"/>&nbsp;&nbsp;
		</TD>
		<TD width='25%' align='left'>
		<% if(! param.equals("query")) {	%>
			<SELECT name="to_bed_type" id="to_bed_type" onChange='calcbedcharge(this)'>
			<option value=''>&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;
			<%
				rs.beforeFirst();
	      if( rs != null )
	      {
	          while( rs.next() )
	          {
				String classcode = rs.getString( "bed_type_code" ) ;
				String classname = rs.getString( "short_desc" ) ;
%>
				<OPTION VALUE='<%= classcode %>' ><%= classname%>
<%
			}
	      }
%>
			</SELECT>&nbsp;&nbsp;<img src='../../eMP/images/mandatory.gif'align='center'></img>
		<% } else { %>
				<INPUT TYPE="text" name="to_bed_type1" id="to_bed_type1" value='<%=to_bed_type_desc%>' readonly>&nbsp;&nbsp;<img src='../../eMP/images/mandatory.gif'align='center'>
				<INPUT TYPE="hidden" name="to_bed_type" id="to_bed_type" value='<%=to_bed_type_code %>'>
			<% } %>
		</TD>
		<TD class="label" width='25%' align='right' nowrap<fmt:message key="eIP.BedCharge.label" bundle="${ip_labels}"/>&nbsp;&nbsp;
		</TD>
		<TD width='22%' align='left'>
			<INPUT TYPE="text" name="bed_to_charge" id="bed_to_charge" size='10' readonly value='<%=to_dly_charge%>'>
		</TD>
		</TR>
		<tr>
		<td colspan='4'>&nbsp;</td>
		</tr>
		<TR>
		<TD class="label" width='25%' align='right' nowrap>
			<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;&nbsp;
		</TD>
		<TD width='25%' align='left'>
		<% if(param.equals("query")) { %>
		<% if (eff_status.equals("E")) { %>
			<INPUT TYPE="checkbox" name="eff_status" id="eff_status" value="" checked>
		<% } else { %>
		<INPUT TYPE="checkbox" name="eff_status" id="eff_status" value=""  >
		<% } %>
		<% } else { %>
		<INPUT TYPE="checkbox" name="eff_status" id="eff_status" value="" checked >
		<% } %>

		</TD>
		<TD width='25%'>&nbsp;</TD>
		<TD width='25%'>&nbsp;</TD>
		</TR>
		<tr>
		<td colspan='4'>&nbsp;</td>
		</tr>
		</TABLE>
<tr>
</td>

<tr>
<td>
		<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
		<tr><td colspan='4' class='bodycolorfilled'>&nbsp;</td></tr>
		<tr>
		<th width='100%' colspan='4' align='left'>
			<fmt:message key="eIP.TransferChargeDetails.label" bundle="${ip_labels}"/>&nbsp;&nbsp;
		</td>
		</tr>
		<tr>
		<td colspan='4'>&nbsp;</td>
		</tr>
		</table>
<tr>
<td>
		<table border='0' cellpadding='0' cellspacing='0' width='97%' align='center'>
		<TR>
		<TD class="label" width='25%' align='right' nowrap><fmt:message key="eIP.PercentAmountIndicator.label" bundle="${ip_labels}"/>&nbsp;&nbsp;
		</TD>
		<TD width='25%' nowrap>
<% 		if(! eff_status.equals("D"))
		{
%>
			<SELECT name="p_a_ind" id="p_a_ind" onChange='percentAmount(this)'>
			<option value=''>&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;

<% 			if(percent_amt_ind.equals("P"))
			{
%>			<option value='P' selected><fmt:message key="Common.Percent.label" bundle="${common_labels}"/>
<%			}
			else
			{
%>
			       <option value='P'><fmt:message key="Common.Percent.label" bundle="${common_labels}"/>
<%
			}
%>
<% 			if(percent_amt_ind.equals("A"))
			{
%>
				<option value='A' selected><fmt:message key="Common.amount.label" bundle="${common_labels}"/>
<% 			}
			else
			{
%>
			 	<option value='A' ><fmt:message key="Common.amount.label" bundle="${common_labels}"/>
<%
			}
%>
			</SELECT>&nbsp;&nbsp;
<% 			}
			else
			{
			 if(percent_amt_ind.equals("P"))
			 {
%>				<input type='text' name='p_a_ind1' id='p_a_ind1' value='Percent' readonly>
				<input type='hidden' name='p_a_ind' id='p_a_ind' value='P'>
<% 			 }
			else
			 {
%>
				<input type='text' name='p_a_ind1' id='p_a_ind1' value='Amount' readonly>
				<input type='hidden' name='p_a_ind' id='p_a_ind' value='A'>
<% 			 }
			}
			%>
			<img src='../../eMP/images/mandatory.gif' align='center'></img>
		</TD>
		<TD>
			&nbsp;
		</TD>
		<TD width='25%' align='left'>
			&nbsp;
		</TD>
		</TR>
		<tr>
		<td colspan='4'>&nbsp;</td>
		</tr>
		<TR>
		<TD class="label" width='25%' align='right' nowrap><fmt:message key="eIP.CalculatePercentageOn.label" bundle="${ip_labels}"/>&nbsp;&nbsp;
		</TD>
		<TD width='25%' align='left' nowrap>

		<%
			if(! eff_status.equals("D")) {
			if(percent_amt_ind.equals("P"))
			{
			%>
			<SELECT name="calculate" id="calculate" onChange='calculateAmount(this)'>
			<option value=''>&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;
			<%
			if(fr_or_to_charge_per.equals("F")) { %>
			<option value='F' selected><fmt:message key="eIP.FromBedTypeAmount.label" bundle="${ip_labels}"/>
			<% } else { %>
			  <option value='F'><fmt:message key="eIP.FromBedTypeAmount.label" bundle="${ip_labels}"/>
			<% } %>
			<% 	if(fr_or_to_charge_per.equals("T")) { %>
			<option value='T' selected><fmt:message key="eIP.ToBedTypeAmount.label" bundle="${ip_labels}"/>
			<% } else { %>
			<option value='T'><fmt:message key="eIP.ToBedTypeAmount.label" bundle="${ip_labels}"/>
			<% }

			}
			else
			{
			%>
			<SELECT name="calculate" id="calculate" onChange='calculateAmount(this)' disabled>
			<option value=''>&nbsp;-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------&nbsp;
			<option value='F'><fmt:message key="eIP.FromBedTypeAmount.label" bundle="${ip_labels}"/>
			<option value='T'><fmt:message key="eIP.ToBedTypeAmount.label" bundle="${ip_labels}"/>

			<% } %>
			</SELECT>&nbsp;&nbsp;
			<% }
			else {
			if(fr_or_to_charge_per.equals("F")) {
			%>
			<input type='text' name='calculate1' id='calculate1' value='From Bed Type Amount' readonly>
			<input type='hidden' name='calculate' id='calculate' value='F'>
			<% } else { %>
			<input type='text' name='calculate1' id='calculate1' value='To Bed Type Amount' readonly>
			<input type='hidden' name='calculate' id='calculate' value='T'>

			<% }
			}

			if(param.equals("query") && percent_amt_ind.equals("P")) vis="visibility:visible"; else vis = "visibility:hidden";
			%>
			<img id='calculateimg' style="<%=vis%>" src='../../eMP/images/mandatory.gif'align='center'></img>
		</TD>
		<TD class="label" width='25%' align='right' nowrap>
			&nbsp;
		</TD>
		<TD width='25%' align='left'>
			&nbsp;
		</TD>
		</TR>
		<tr>
		<td colspan='4'>&nbsp;</td>
		</tr>
		<TR>
		<TD class="label" width='25%' align='right' nowrap>
			<fmt:message key="eIP.PercentAmount.label" bundle="${ip_labels}"/>&nbsp;&nbsp;
		</TD>
		<TD width='25%' align='left'>
			<% if(! param.equals("query")) {	%>
			<INPUT TYPE="text"  style="text-align:right" maxlength='10'   name="p_a_amount" id="p_a_amount" onKeyPress="return ChkNumberInput(this,event,2)" onBlur='calculateAmount(calculate)'>&nbsp;&nbsp;<img src='../../eMP/images/mandatory.gif'align='center'></img>
			<% } else { %>
			<INPUT TYPE="text" style="text-align:right" maxlength='10'   name="p_a_amount" id="p_a_amount" value='<%=entered_amount%>' onKeyPress="return ChkNumberInput(this,event,2)" onBlur='calculateAmount(calculate)' >&nbsp;&nbsp;<img src='../../eMP/images/mandatory.gif'align='center'></img>
			<% }%>
		</TD>
		<TD width='25%'>&nbsp;</TD>
		<TD width='25%'>&nbsp;</TD>
		</TR>
		<tr>
		<td colspan='4'>&nbsp;</td>
		</tr>
		<TR>
		<TD class="label" width='25%' align='right' nowrap>
			<fmt:message key="eIP.CalculatedAmount.label" bundle="${ip_labels}"/>&nbsp;&nbsp;
		</TD>
		<TD width='25%' align='left'>
			<INPUT TYPE="text"  style="text-align:right" name="calculated_amount" id="calculated_amount" value='<%= transfer_serv_charge%>' readonly>
		</TD>
		<TD width='25%'>&nbsp;</TD>
		<TD width='25%'>&nbsp;</TD>
		</TR>
		<tr>
		<td colspan='4'>&nbsp;</td>
		</tr>
		</TABLE>
</td>
</tr>
</table>
		<% if(! param.equals("query")) {	%>
		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
<% }	else
	 {
%>
		<input type='hidden' name='function' id='function' value='modify'>
		<input type='hidden' name='function_name' id='function_name' value='modify'>
<%
	 }
%>

</form>

<%
		if (rs != null) rs.close();
		if (rs1 != null) rs1.close();
		if (rs2 != null) rs2.close();

		if (stmt != null) stmt.close();
		if (stmt2 != null) stmt2.close();

	}catch(Exception e) {out.println(e.toString());}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

