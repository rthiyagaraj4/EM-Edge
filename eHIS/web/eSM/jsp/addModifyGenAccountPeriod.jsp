<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	 String locale1 = (String)session.getAttribute("LOCALE");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	Connection con=null;
	try
	{
		con = ConnectionManager.getConnection(request);
		Statement stmt=null;
		ResultSet rs =null;
		String num_of_acc_periods="";
		String sys_date="";
%>


<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eSM/js/GenerateAccountingPeriod.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<Script language="JavaScript"src="../../eCommon/js/DateUtils.js" ></Script>
<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<form name="generate_acct_period" id="generate_acct_period" action="../../servlet/eSM.GenerateAcctPeriodServlet" method="post" target="messageFrame">


<%
	try{
		String sql="select num_of_acc_periods,to_char(sysdate,'dd/mm/yyyy') sysdt from sm_acc_entity_param";
		stmt = con.createStatement();
		rs= stmt.executeQuery(sql);

		if (rs.next())
		{
			num_of_acc_periods=rs.getString("num_of_acc_periods");
			sys_date=rs.getString("sysdt");
		}
%>

<br><br><br><br><br><br><br><br><br><br>

<table border="0" cellpadding='3' cellspacing="0" width="75%" align='center'>
   	<tr>
		<td width="35%" class='label'><fmt:message key="eSM.AccountYear.label" bundle="${sm_labels}"/></td>
		<td width="60%" class='fields'>
		<input type="text" name="acc_per_year1" id="acc_per_year1" size="5" maxlength="4" onKeyPress='return(ChkNumberInput(this,event,0))'  onblur="if(this.value !=''){if(chkYear(this)){genYear()}};" ><img src='../../eCommon/images/mandatory.gif'align='center'></img></td>
	</tr>
	<tr>
		<td width="35%" class='label'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
		<td width="60%" class='fields'><input type="text" name="acc_per_start_date"  id="acc_per_start_date" size="10" maxlength="10" onblur = "check_date(this);if(validDateObj(this,'DMY',localeName)){if(CheckDate(this)){chkDate()}};" onchange="" ><input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('acc_per_start_date',null,null);">&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

	</tr>
	<tr>
		<td width="35%" class='label'><fmt:message key="eSM.NoofAccountingPeriods.label" bundle="${sm_labels}"/></td>
		<td width="60%" class='fields'><input type="text" name="acc_per1" id="acc_per1" size="2" maxlength="2" value="<%=num_of_acc_periods%>" disabled></td>
		
	</tr>
	
	<input type="hidden" name="acc_per" id="acc_per" value="<%=num_of_acc_periods%>">
	<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
	<input type="hidden" name="function" id="function" value="insert">
	<input type='hidden' name='function_name' id='function_name' value='insert'>
	 <input type='hidden' name='locale' id='locale' value="<%=locale1%>"> 
	 <input type='hidden' name='sys_date' id='sys_date' value="<%=sys_date%>"> 

</table>
</form>

</body>
</html>

<%
		
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	}
}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>


<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

