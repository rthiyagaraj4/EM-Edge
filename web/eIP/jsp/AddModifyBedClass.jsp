<!DOCTYPE html>
<!--
	Developed by 	:	Chitra
	Created on 		:	18/06/2001
	Module			:	ip
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%
	Connection con			= null;
	Statement stmt			= null;
	PreparedStatement pstmt	= null;
	ResultSet rset			= null;
	ResultSet rs			= null;
%>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>


<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>

<script src="../js/BedClass.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

</script>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="FocusFirstElement()" >
<%
	String facilityId = (String)session.getValue("facility_id");
	String fnval		= "insert";
	String chk			= "checked";
	String sel			= "";
	String rd			= "";
	String rdall		= "";
	String dis			= "";
	String depamt		= "";
	String depcharge	= "";
	String bedclasscode	= "";
	String longdesc		= "";
	String shortdesc	= "";
	String effstatus	= "";
	
	String labeltext	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PercentAmount.label","ip_labels"); 
	String labelvalue	= "";
	StringBuffer sql	= new StringBuffer();
	String percentamtindsurgery		= "";
	String ALLOW_BED_SWAP_YN		= "";
	String CheckALLOW_BED_SWAP_YN	= "";
	String setup_bl_dtls_in_ip_yn	= "N";

	String percentamountcode[] = {"","P","A"};
	String percentamountdesc[] = {"&nbsp;-- Select --&nbsp;","Percent","Amount"};

	String code = checkForNull(request.getParameter("bed_class_code"));
	long   bed_count=0;
	long bedtype_count  = 0;

	try{
		con		= ConnectionManager.getConnection(request);
		//stmt	= con.createStatement();
	
		sql.append("select setup_bl_dtls_in_ip_yn from ip_param where facility_id=? ");
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1, facilityId);
		rs = pstmt.executeQuery();
/* 		rs = stmt.executeQuery(sql.toString()); */
		if(rs!=null )
		{
			if(rs.next())
			 {
				setup_bl_dtls_in_ip_yn=checkForNull(rs.getString("setup_bl_dtls_in_ip_yn"));
			 }
		}
        if(rs!=null) rs.close();
        if(stmt!=null) stmt.close();
	if(pstmt != null) pstmt.close();
		if(setup_bl_dtls_in_ip_yn==null || setup_bl_dtls_in_ip_yn.equals("") || setup_bl_dtls_in_ip_yn=="")
		setup_bl_dtls_in_ip_yn = "";

	try{
		if(code == "") 
		{
			code = "";
		}
		else
		{
			fnval = "modify";
			rd	  = "readonly";
			pstmt = con.prepareStatement("select * from ip_bed_class where bed_class_code=? ");

			pstmt.setString(1,code);
			rset=pstmt.executeQuery();
			rset.next();

			bedclasscode	= checkForNull(rset.getString("bed_class_code"));
			longdesc		= checkForNull(rset.getString("long_desc"));
			shortdesc		= checkForNull(rset.getString("short_desc"));
			if(setup_bl_dtls_in_ip_yn.equals("Y"))
			{			
				depamt	= checkForNull(rset.getString("deposit_amount_normal"));;
				percentamtindsurgery = checkForNull(rset.getString("percent_amt_ind_surgery"));
				depcharge    = checkForNull(rset.getString("deposit_charge_surgery"));
			}		

			effstatus    	= checkForNull(rset.getString("eff_status"));

			if(effstatus.equals("D"))
			{
				chk   = "";
				rdall = "readonly";
				dis   = "disabled";
			}

			ALLOW_BED_SWAP_YN    	= checkForNull(rset.getString("ALLOW_BED_SWAP_YN"));

			if(ALLOW_BED_SWAP_YN.equals("Y"))
			{
				CheckALLOW_BED_SWAP_YN   = "checked";
			}
			if(sql.length() > 0) sql.delete(0,sql.length());
			if(pstmt != null) pstmt.close();
			sql.append("SELECT count(1) as bed_count from ip_nursing_unit_bed where bed_class_code=?");
		
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, code);
			rset = pstmt.executeQuery();
			
/* 			stmt = con.createStatement();
			rset = stmt.executeQuery(sql.toString()); */
			
			rset.next();
			bed_count=rset.getLong("bed_count");
			/* Thursday, October 01, 2009 IN015003*/
			if(sql.length() > 0) sql.delete(0,sql.length());
			if(pstmt!=null) pstmt.close();
			sql.append("SELECT count(1) as bedtype_count from ip_bed_type where bed_class_code='"+code+"' ");
			
			pstmt = con.prepareStatement(sql.toString());
			rset = pstmt.executeQuery();
			
			/* stmt = con.createStatement();
			rset = stmt.executeQuery(sql.toString()); */
			
			rset.next();
			bedtype_count=rset.getLong("bedtype_count");
	}
%>

<form name="BedClass_form" id="BedClass_form"  method="post" action="../../servlet/eIP.BedClassServlet" target="messageFrame" >
<br><br>
<%
	if(setup_bl_dtls_in_ip_yn.equals("N")) 
	{ %>
	 <br><br>
<% 	} %>

	<br><br>

	<table cellspacing=0 cellpadding=0 align="center" width="80%" border="0">
	
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" align="right" width="40%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" name="bed_class_code" id="bed_class_code" size="2" maxlength="2" value="<%=bedclasscode%>" <%=rd%> onBlur="javascript:ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)"><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>

	<tr>
		<td class="label" align="right"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" value="<%=longdesc%>" <%=rdall%> onBlur="makeValidString(this)"><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" align="right"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" value="<%=shortdesc%>" <%=rdall%> onBlur="makeValidString(this)"><img align="center" src="../../eCommon/images/mandatory.gif"></img>
		</td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" align="right"><fmt:message key="eIP.AllowBedSwap.label" bundle="${ip_labels}"/></td>
		<td>&nbsp;<input type="checkbox" name="ALLOW_BED_SWAP_YN" id="ALLOW_BED_SWAP_YN" value="Y" <%=CheckALLOW_BED_SWAP_YN%>></td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" align="right"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="checkbox" name="eff_status" id="eff_status" value="E" <%=chk%> onClick="checkBedStatus();"></td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	</table>
	<br>

	<table id ='bl_field1'  style=visibility:hidden; cellspacing=0 cellpadding=0 align="center" width="80%" border="0">
	<th align="left" width="100%" colspan="2">Billing Parameters</th>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" align="right" width="40%"><fmt:message key="eIP.DepositAmount.label" bundle="${ip_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text" style="text-align:right" name="deposit_amt_normal" id="deposit_amt_normal" size="11" maxlength="10" value="<%=depamt%>" <%=rdall%> onKeyPress='return(ChkNumberInput(this,event,2))' onblur="javascript:chkCalculate(this);">
		</td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	</table>
	<br>
	<table id ='bl_field2'  style="visibility:hidden"; cellspacing=0 cellpadding=0 align="center" width="80%" border="0">
	<th align="left" width="100%" colspan="2"><fmt:message key="eIP.AdditionalDepositAmount.label" bundle="${ip_labels}"/></th>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" align="right" width="40%"><fmt:message key="eIP.PercentAmountIndicator.label" bundle="${ip_labels}"/></td>
		<td id="per_amt">&nbsp;&nbsp;<select name="percent_amt_ind_surgery" id="percent_amt_ind_surgery" <%=dis%> onChange="javascript:setLegend(this);">
			<%
				for(int i=0;i<3;i++)
				{
					if(percentamtindsurgery.equals(percentamountcode[i]))
						sel = "selected";
					else
						sel = "";

					out.print("<option value='"+percentamountcode[i]+"'"+sel+" >"+percentamountdesc[i]+"");
				}
			%>
			</select>
		</td>
	</tr>

	<tr>
		<td class="label" align="right" id="label"><%=labeltext%></td>
		<td>&nbsp;&nbsp;<input type="text" style="text-align:right" name="label_text" id="label_text" size="11" maxlength="10" value="<%=labelvalue%>" readonly <%=rdall%> onKeyPress='return(ChkNumberInput(this,event,2))' onBlur="javascript:calculateAmount(this);">
		</td>
	</tr>
	<tr>
		<td class="label" align="right"><fmt:message key="eIP.CalculatedAmount.label" bundle="${ip_labels}"/></td>
		<td>&nbsp;&nbsp;<input type="text"  style="text-align:right" name="deposit_charge_surgery" id="deposit_charge_surgery" size="11" maxlength="10" value="<%=depcharge%>" <%=rdall%> readonly>
		</td>
	</tr>
	<tr>
		<td colspan=2>&nbsp;</td>
	</tr>
</table>

	<input type="hidden" name="function_name" id="function_name" value="<%=fnval%>">
	<input type="hidden" name="setup_bl_dtls_in_ip_yn" id="setup_bl_dtls_in_ip_yn" value="<%=setup_bl_dtls_in_ip_yn%>">
	
	<!--- added on 29-09-2003 by dhanasekaran -->
		<input type='hidden' name='bed_count' id='bed_count' value="<%=bed_count%>">
		<input type='hidden' name='bedtype_count' id='bedtype_count' value="<%=bedtype_count%>">

		<script>
			if("<%=effstatus%>" == "D")
				document.BedClass_form.ALLOW_BED_SWAP_YN.disabled=true;
		</script>
	<%
		if(fnval == "modify")
			out.print("<script>setLabelText();</script>");
	%>
	</form>
	<%
	}catch(Exception e){
		//out.print("Exception :"+e);
		e.printStackTrace() ;
	}
%>
<script>
	<%
		if(setup_bl_dtls_in_ip_yn.equals("Y"))
		{
				out.println("document.getElementById('bl_field1').style.visibility='visible';,document.getElementById('bl_field2').style.visibility='visible';");
		}

		if(rset	 != null)   rset.close();
		if(rs	 != null)   rs.close();
		if(stmt  != null)   stmt.close();
		if(pstmt != null)	pstmt.close();

	}catch(Exception e){
		//out.println("Exception in tryCatch : "+ e.toString());
		e.printStackTrace();
	}			
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
</script>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

</body>
</html>

