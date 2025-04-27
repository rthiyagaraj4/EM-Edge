<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
        
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>



<script>

function setValues()
{
	if(document.forms[0].multi_site_yn.value == "N")
	{
		document.forms[0].prefix_dept_by_facility.value = "N";
	}
}

function setValue(Obj)
{
	if(Obj.checked)
		Obj.value = "Y";
	else
		Obj.value = "N";
}

function CheckPositiveNumber1(obj)
		{	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {		
	}
	else {
  		if ( obj.value.length > 0 ) {
  			alert(getMessage('CANNOT_BE_ZERO','Common'));
  			obj.select();
  			obj.focus();
  		}
  	}
}

function checkDept(Obj)
{
	if(parseInt(Obj.value) > 10)
	{
		alert(getMessage("DEPT_LENGTH_6","SM"));
		Obj.select();
		Obj.focus();
	}
	else if(document.forms[0].multi_site_yn.value == "Y" && Obj.value != "")
	{
		var main_dept_length = document.forms[0].acc_dept_length.value;

		if(Obj.value != main_dept_length)
		{
			alert(getMessage("DEPT_LENGTH_MISMATCH","SM"));
            Obj.select();
			Obj.focus();
		}
	}
}

function chkCurrName(Obj)
{
	if(document.forms[0].multi_site_yn.value == "Y" && Obj.value != "")
	{
		var acc_curr_name = document.forms[0].acc_curr_name.value;

		if(Obj.value != acc_curr_name)
		{
			alert(getMessage("CURR_NAME_MISMATCH","SM"));
			Obj.select();
			Obj.focus();
		}
	}
}

function chkDeciName(Obj)
{
	if(document.forms[0].multi_site_yn.value == "Y" && Obj.value != "")
	{
		var acc_deci_name = document.forms[0].acc_deci_name.value;

		if(Obj.value != acc_deci_name)
		{
			alert(getMessage("DECI_NAME_MISMATCH","SM"));
            Obj.select();
			Obj.focus();
		}
	}
}

function chkFiscalMonth(Obj)
{
	if(Obj.value != "" && document.forms[0].no_acct_periods.value != "")
	{
		if(parseInt(Obj.value) > parseInt(document.forms[0].no_acct_periods.value))
		{
			alert(getMessage("FIS_MON_GR_ACC_PERIODS","SM"));
            Obj.select();
			Obj.focus();
		}
	}
}

</script>

<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()' onLoad="FocusFirstElement();setValues();">
<form name="entity_acct_params" id="entity_acct_params" action="../../servlet/eSM.AccountingParametersServlet" method="post" target="messageFrame">
<%
    request.setCharacterEncoding("UTF-8");
	String entity_id	= "";
	String entity_long_name	= "";
	String entity_short_name= "";
	String acct_period	= "";
	String fiscal_month = "";
	String dept_length	= "";
	String pr_dept_by_fac = "";
	String no_of_decmls	= "";
	String curr_name	= "";
	String dec_name		= "";

	String chkbox_state = "";
	String readOnlyPeriod	= "";
	String readOnlyMonth	= "";
	String readOnlyDept		= "";
	String readOnlyNumDec	= "";
	String readOnlyCurrName	= "";
	String readOnlyDeciName	= "";
	String acc_dept_length	= "";
	String acc_curr_name	= "";
	String acc_deci_name	= "";
	String multi_site_yn	= "";
	Connection con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try
		{
			pstmt = con.prepareStatement("Select * from SM_ACC_ENTITY_PARAM ");

			rs = pstmt.executeQuery();

			if(rs != null)
			{
				while(rs.next())
				{
					entity_id		= rs.getString("ACC_ENTITY_ID");
					entity_long_name= rs.getString("ACCOUNTING_NAME_LONG");
					entity_short_name= rs.getString("ACCOUNTING_NAME_SHORT");
					acct_period		= rs.getString("NUM_OF_ACC_PERIODS");
					fiscal_month	= rs.getString("START_FISCAL_MONTH");
					dept_length		= rs.getString("DEPT_CODE_LENGTH");
					no_of_decmls	= rs.getString("NO_OF_DECIMAL");
					pr_dept_by_fac	= rs.getString("PREFIX_FACL_ID_FOR_INT_YN");
					curr_name		= rs.getString("BASE_CURRENCY");
					dec_name		= rs.getString("BASE_CURRENCY_DEC");

					if(entity_id == null)			entity_id = "";
					if(entity_long_name == null)	entity_long_name = "";
					if(entity_short_name == null)	entity_short_name = "";
					if(acct_period == null)			acct_period = "";
					if(fiscal_month == null)		fiscal_month = "";
					if(dept_length == null)			dept_length = "";
					if(no_of_decmls == null)		no_of_decmls = "";
					if(pr_dept_by_fac == null)		pr_dept_by_fac = "N";
					if(curr_name == null)			curr_name = "";
					if(dec_name == null)			dec_name = "";

					if(!acct_period.equals(""))		readOnlyPeriod = "READONLY";
					if(!fiscal_month.equals(""))	readOnlyMonth = "READONLY";
					if(!dept_length.equals(""))		readOnlyDept = "READONLY";
					if(!no_of_decmls.equals(""))	readOnlyNumDec = "READONLY";
					if(!curr_name.equals(""))		readOnlyCurrName = "READONLY";
					if(!dec_name.equals(""))		readOnlyDeciName = "READONLY";

					if(pr_dept_by_fac.equals("Y"))
						chkbox_state = "Checked";
					else
						chkbox_state = "UnChecked";

				}
				if(rs!=null)rs.close();
			}
			pstmt.close();

			pstmt = con.prepareStatement("Select * from SM_ACC_ENTITY");
			rs = pstmt.executeQuery();

			if(rs != null)
			{
				while(rs.next())
				{
					if(entity_id.equals(""))
					entity_id = rs.getString("ACC_ENTITY_ID");
					acc_dept_length		= rs.getString("DEPT_CODE_LENGTH");
					acc_curr_name		= rs.getString("BASE_CURRENCY");
					acc_deci_name		= rs.getString("BASE_CURRENCY_DEC");
				}
				if(rs!=null)rs.close();
			}
			pstmt.close();
			
			pstmt = con.prepareStatement("Select MULTIPLE_SITES_YN from SM_INSTALLATION");
			rs = pstmt.executeQuery();

			if(rs != null)
			{
				while(rs.next())
				{
					multi_site_yn		= rs.getString("MULTIPLE_SITES_YN");
				}
				if(rs!=null)rs.close();
			}
			pstmt.close();

		}
		catch(Exception e)
		{ out.println(e); }

		finally
		{
			if(con != null) 
				ConnectionManager.returnConnection(con,request);
		}
%>
<br><br><br><br><br>
			<table border='0' cellpadding='2' cellspacing='0' width='95%' align='center'> 
				   <tr>
						<td width="35%" class='label'   ><fmt:message key="eSM.AccountingEntityID.label" bundle="${sm_labels}"/></td>
						<td width="60%" class='fields'><input type="text" name="entity" id="entity" size="2" maxlength="2" value="<%=entity_id%>" onBlur="ChangeUpperCase(this);" readonly></td>
						
					</tr>
					<tr>
						<td class='label'><fmt:message key="eSM.AccountEntLongname.label" bundle="${sm_labels}"/></td>
						<td  class='fields'><input type="text" name="entity_desc_long" id="entity_desc_long" size="60" maxlength="60" value="<%=entity_long_name%>"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						
					</tr>
					<tr>
						<td class='label'><fmt:message key="eSM.AccountEntShortname.label" bundle="${sm_labels}"/></td>
						<td  class='fields'><input type="text" name="entity_desc_short" id="entity_desc_short" size="30" maxlength="30" value="<%=entity_short_name%>"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
						
					</tr>
					<tr>
						<td  class='label'  ><fmt:message key="eSM.NoofAccountingPeriods.label" bundle="${sm_labels}"/></td>
						<td class='fields'><input type="text" style='text-align:right' name="no_acct_periods" id="no_acct_periods" size="2" maxlength="2" value="<%=acct_period%>" onKeyPress='return(ChkNumberInput(this,event,0))' <%=readOnlyPeriod%>><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						
					</tr>
					<tr>
						<td  class='label'><fmt:message key="eSM.StartFiscalMonth.label" bundle="${sm_labels}"/></td>
						<td  class='fields'><input type="text" style='text-align:right' name="start_fiscal_month" id="start_fiscal_month" size="2" maxlength="2" value="<%=fiscal_month%>" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="chkFiscalMonth(this);" <%=readOnlyMonth%>><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						
					</tr>
					<tr>
						<td  class='label'><fmt:message key="eSM.DepartmentLength.label" bundle="${sm_labels}"/></td>
						<td class='fields' ><input type="text" style='text-align:right' name="department_length" id="department_length" size="2" maxlength="2" value="<%=dept_length%>"  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckPositiveNumber1(this);checkDept(this);" <%=readOnlyDept%>><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						
					</tr>
						<td class='label' ><fmt:message key="eSM.PrefixDepartmentbyFacilityID.label" bundle="${sm_labels}"/></td>
						<td class='fields'><input type="checkbox" name="prefix_dept_by_facility" id="prefix_dept_by_facility" value="<%=pr_dept_by_fac%>" onClick="setValue(this);" <%=chkbox_state%> ></td>
						
					</tr>
					<tr>
						<td class='label' ><fmt:message key="eSM.NumberofDecimals.label" bundle="${sm_labels}"/></td>
						<td class='fields'><input type="text" name="no_of_decimals" id="no_of_decimals" style='text-align:right' size="1" maxlength="1" value="<%=no_of_decmls%>" onKeyPress='return(ChkNumberInput(this,event,0))' <%=readOnlyNumDec%>></td>
                       
					</tr>
					<tr>
						<td class='label'><fmt:message key="eSM.CurrencyName.label" bundle="${sm_labels}"/></td>
						<td  class='fields'><input type="text" name="currency_name" id="currency_name" size="6" maxlength="6" value="<%=curr_name%>" <%=readOnlyCurrName%> onBlur="chkCurrName(this);"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
					 
					</tr>
						<td class='label' ><fmt:message key="eSM.DecimalName.label" bundle="${sm_labels}"/></td>
						<td  class='fields'><input type="text" name="decimal_name" id="decimal_name" size="6" maxlength="6" value="<%=dec_name%>" <%=readOnlyDeciName%> onBlur="chkDeciName(this);"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
						
					</tr>
				</table>
<input type="hidden" name="multi_site_yn" id="multi_site_yn" value="<%=multi_site_yn%>">
<input type="hidden" name="acc_dept_length" id="acc_dept_length" value="<%=acc_dept_length%>">
<input type="hidden" name="acc_curr_name" id="acc_curr_name" value="<%=acc_curr_name%>">
<input type="hidden" name="acc_deci_name" id="acc_deci_name" value="<%=acc_deci_name%>">
</form>
</body>
</html>

