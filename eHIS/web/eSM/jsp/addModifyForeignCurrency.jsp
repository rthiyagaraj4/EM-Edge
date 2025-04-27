<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
		<script src='../../eSM/js/ForeignCurrency.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()' onLoad="FocusFirstElement();disabledEnabledFields();">
<form name="foreign_currency_form" id="foreign_currency_form" action="../../servlet/eSM.ForeignCurrencyServlet" method="post" target="messageFrame">
<%

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String operation		= checkForNull(request.getParameter("operation"));
	String currency_code	= checkForNull(request.getParameter("currency_code"));
	String modify_long_desc				= "";
	String modify_short_desc			= "";
	String modify_conversion_rate		= "";
	String modify_conversion_operator	= "";
	String modify_currency_name_integer = "";
	String modify_currency_name_decimal = "";
	String modify_main_acc1_code		= "";
	String modify_main_acc2_code		= "";
	String modify_subledger_group_code	= "";
	String modify_subledger_line_code	= "";
	String modify_dept_code				= "";
	String modify_product_group_code	= "";
	String modify_product_line_code		= "";
	String modify_num_of_decimal		= "";
	String modify_dept_desc				= "";
	String modify_main_acc_desc			= "";
	String modify_product_line_desc		= "";
	String modify_subledger_desc		= "";
	StringBuffer sql_gl = new StringBuffer();

	Connection conn			= null;
	Statement stmt			= null;
	ResultSet rs		    = null;
	String setup_gl_install_yn	= "N";

	try
	{

		conn = ConnectionManager.getConnection(request);
		stmt	=conn.createStatement();
	
		try
		{
			
			sql_gl.append("select install_yn from sm_module where module_id='GL'");
			rs = stmt.executeQuery(sql_gl.toString());
			if(rs!=null )
			{
				while(rs.next())
				 {
						setup_gl_install_yn = rs.getString("install_yn");
				 }
			}
		}catch(Exception e)
		{
//			out.print("Exception in addModifyForeignCurrency.jsp :"+e);
			e.printStackTrace();
		}	

		if(rs!=null)
			rs.close();
		if(stmt!=null)
			stmt.close();

		if(operation.equals("modify"))
		{
			try
			{
				if(sql_gl.length()>0)
					sql_gl.setLength(0);
				//sql_gl.append("select * from sy_foreign_currency where currency_code='"+currency_code+"'");

				sql_gl.append("select a.currency_code, a.short_desc, a.long_desc, a.conversion_rate, a.conversion_operator, a.currency_name_integer, a.currency_name_decimal, a.num_of_decimal, a.main_acc1_code, a.main_acc2_code,b.main_desc , a.subledger_group_code, a.subledger_line_code , b.sleg_desc , a.dept_code, b.dept_desc,   a.product_group_code, a.product_line_code,b.prod_desc from sy_foreign_currency a, gl_posting_acc b where currency_code='"+currency_code+"' and a.main_acc1_code = b.main_acc1_code(+) and a.main_acc2_code = b.main_acc2_code(+) and a.dept_code = b.dept_code(+) and a.product_group_code = b.product_group_code(+) and a.product_line_code = b.product_line_code(+) and a.subledger_group_code = b.subledger_group_code(+) and a.subledger_line_code = b.subledger_line_code(+)");				

				stmt	=conn.createStatement();
				rs = stmt.executeQuery(sql_gl.toString());

				//out.println("<script>alert(\""+sql_gl.toString()+"\");</script>");
				
				if(rs!=null )
				{
					while(rs.next())
					 {
							modify_long_desc			= checkForNull(rs.getString("long_desc"));
							modify_short_desc			= checkForNull(rs.getString("short_desc"));
							modify_conversion_rate		= checkForNull(rs.getString("conversion_rate"));
							modify_conversion_operator	= checkForNull(rs.getString("conversion_operator"));
							modify_currency_name_integer= checkForNull(rs.getString("currency_name_integer"));
							modify_currency_name_decimal= checkForNull(rs.getString("currency_name_decimal"));
							modify_num_of_decimal		= checkForNull(rs.getString("num_of_decimal"));
							modify_main_acc1_code		= checkForNull(rs.getString("main_acc1_code"));
							modify_main_acc2_code		= checkForNull(rs.getString("main_acc2_code"));
							modify_main_acc_desc		= checkForNull(rs.getString("main_desc"));
							modify_subledger_group_code = checkForNull(rs.getString("subledger_group_code"));
							modify_subledger_line_code	= checkForNull(rs.getString("subledger_line_code"));
							modify_subledger_desc		= checkForNull(rs.getString("sleg_desc"));
							modify_dept_code			= checkForNull(rs.getString("dept_code"));
							modify_dept_desc			= checkForNull(rs.getString("dept_desc"));
							modify_product_group_code	= checkForNull(rs.getString("product_group_code"));
							modify_product_line_code	= checkForNull(rs.getString("product_line_code"));	
							modify_product_line_desc	= checkForNull(rs.getString("prod_desc"));								
					 }
				}
			}
			catch(Exception e)
			{
				//out.print("Exception in addModifyForeignCurrency.jsp in modify mode :"+e.toString());
				e.printStackTrace();
			}

			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
		}
	}
	catch(Exception e)
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}

%>
	<table border='0' cellpadding='2' cellspacing='0' width='80%' align='center'> 
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.CurrencyCode.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="currency_code" id="currency_code" size="4" maxlength="4" value="<%=currency_code%>" onBlur=""  <%if(operation.equals("modify")){%> disabled<%}%>><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.CurrencyName.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="currency_name" id="currency_name" size="15" maxlength="15" value="<%=modify_currency_name_integer%>"  onKeyPress="return CheckForSpecChars(event);" onBlur="" ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr> 
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.DecimalName.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="decimal_name" id="decimal_name" size="15" maxlength="15" value="<%=modify_currency_name_decimal%>"  onKeyPress="return CheckForSpecChars(event)" onBlur="" ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.ConversionRate.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="conversion_rate" id="conversion_rate" size="17" maxlength="17" value="<%=modify_conversion_rate%>" onKeyPress='return(ChkNumberInput(this,event,1))' onBlur="validateNoOfDecimal(this);" ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.ConversionOperator.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="conversion_operator" id="conversion_operator" size="1" maxlength="1" value="<%=modify_conversion_operator%>" onBlur="validateOperatorValue(this);" ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.NumberofDecimals.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="no_decimal" id="no_decimal" size="1" maxlength="1" value="<%=modify_num_of_decimal%>"  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="validateNoOfDecimal1(this);" ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="long_desc" id="long_desc" size="30" maxlength="30" value="<%=modify_long_desc%>"   onblur="return makeValidString(this);"><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="short_desc" id="short_desc" size="15" maxlength="15" value="<%=modify_short_desc%>"  onblur="return makeValidString(this);" ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
		</tr>
		<% if(setup_gl_install_yn!=null && setup_gl_install_yn.equals("Y")) {%>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.MainAccountCode1.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="acc_code1_desc" id="acc_code1_desc" size="15" maxlength="15" value="<%=modify_main_acc_desc%>"  onBlur="SelectAccountInfo(this,document.forms[0].acc_code1,'MainAccountCode1');" ><input type=button name='acc_code1_lookup' id='acc_code1_lookup' value='?' class=button onClick="SelectMainAccount1(document.forms[0].acc_code1_desc,document.forms[0].acc_code1,'MainAccountCode1');"><input type='hidden' name='acc_code1' id='acc_code1' value='<%=modify_main_acc1_code%>'></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.MainAccountCode2.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="acc_code2_desc" id="acc_code2_desc" size="15" maxlength="15" value="<%=modify_main_acc_desc%>" onBlur="SelectAccountInfo(this,document.forms[0].acc_code2,'MainAccountCode2');"  disabled ><input type=button name='acc_code2_lookup' id='acc_code2_lookup' value='?' class=button onClick="SelectMainAccount1(document.forms[0].acc_code2_desc,document.forms[0].acc_code2,'MainAccountCode2');"  disabled><input type='hidden' name='acc_code2' id='acc_code2' value='<%=modify_main_acc2_code%>'></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.DepartmentCode.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="dept_desc" id="dept_desc" size="15" maxlength="15" value="<%=modify_dept_desc%>" onBlur="SelectAccountInfo(this,document.forms[0].dept_code,'DepartmentCode');"  disabled><input type=button name='dept_code_lookup' id='dept_code_lookup' value='?' class=button onClick="SelectMainAccount1(document.forms[0].dept_desc,document.forms[0].dept_code,'DepartmentCode');" disabled><input type='hidden' name='dept_code' id='dept_code' value='<%=modify_dept_code%>'></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.ProductGroupCode.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="prdt_grp" id="prdt_grp" size="15" maxlength="15" value="<%=modify_product_line_desc%>" onBlur="SelectAccountInfo(this,document.forms[0].prdt_grp_code,'ProductGroupCode');"  disabled><input type=button name='prdt_grp_lookup' id='prdt_grp_lookup' value='?' class=button onClick="SelectMainAccount1(document.forms[0].prdt_grp,document.forms[0].prdt_grp_code,'ProductGroupCode');"  disabled><input type='hidden' name='prdt_grp_code' id='prdt_grp_code' value='<%=modify_product_group_code%>'></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.ProductLineCode.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="prdt_line" id="prdt_line" size="15" maxlength="15" value="<%=modify_product_line_desc%>" onBlur="SelectAccountInfo(this,document.forms[0].prdt_line_code,'ProductLineCode');"  disabled><input type=button name='prdt_line_lookup' id='prdt_line_lookup' value='?' class=button onClick="SelectMainAccount1(document.forms[0].prdt_line,document.forms[0].prdt_line_code,'ProductLineCode');"  disabled><input type='hidden' name='prdt_line_code' id='prdt_line_code' value='<%=modify_product_line_code%>'></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.SubLedgerGroupCode.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="ledger_grp" id="ledger_grp" size="15" maxlength="15" value="<%=modify_subledger_desc%>" onBlur="SelectAccountInfo(this,document.forms[0].ledger_grp_code,'SubLedgerGroupCode');" disabled><input type=button name='ledger_grp_lookup' id='ledger_grp_lookup' value='?' class=button onClick="SelectMainAccount1(document.forms[0].ledger_grp,document.forms[0].ledger_grp_code,'SubLedgerGroupCode');" disabled><input type='hidden' name='ledger_grp_code' id='ledger_grp_code' value='<%=modify_subledger_group_code%>'></td>
		</tr>
		<tr>
			<td width="50%" class='label'   ><fmt:message key="eSM.SubLedgerLineCode.label" bundle="${sm_labels}"/></td>
			<td width="50%" class='fields'><input type="text" name="ledger_line" id="ledger_line" size="15" maxlength="15" value="<%=modify_subledger_desc%>" onBlur="SelectAccountInfo(this,document.forms[0].ledger_line_code,'SubLedgerLineCode');"  disabled><input type=button name='ledger_line_lookup' id='ledger_line_lookup' value='?' class=button onClick="SelectMainAccount1(document.forms[0].ledger_line,document.forms[0].ledger_line_code,'SubLedgerLineCode');" disabled><input type='hidden' name='ledger_line_code' id='ledger_line_code' value='<%=modify_subledger_line_code%>'></td>
		</tr>			
		<%}%>
		<input type='hidden' name='operation' id='operation' value='<%=operation%>'>
		<input type='hidden' name='setup_gl_install_yn' id='setup_gl_install_yn' value='<%=setup_gl_install_yn%>'>
	</table>
</form>
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

