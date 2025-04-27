<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<%
	Connection con=null;
	try
	{
		con = ConnectionManager.getConnection(request);
		Statement stmt=null;	
		ResultSet rs =null;
		
String acc_per_year="";
String acc_per_month="";
String acc_per_start_date="";
String acc_per_end_date="";
	String acc_cal_year="";
	String acc_cal_month="";
    String acc_per_desc="";
	String 	sys_date="";
		
%>
	
	    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
        <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
        <Script language="JavaScript"src="../../eCommon/js/DateUtils.js" ></Script>
        <Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
		<script language='javascript' src='../../eSM/js/MaintainAccountingPeriod.js'></script>
		<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
 <body  onKeyDown = 'lockKey()' >
<form name="maintain_acc_period" id="maintain_acc_period"  method="post" target="messageFrame" action="../../servlet/eSM.MaintainAcctPeriodServlet">

<%
	try{
		String sql="SELECT ACC_PER_YEAR, ACC_PER_MONTH, ACC_PER_START_DATE, ACC_PER_END_DATE, CAL_PER_YEAR, CAL_PER_MONTH, ACC_PER_DESC, ACC_PER_CLOSED_YN,to_char(sysdate,'dd/mm/yyyy') sysdt FROM SY_ACC_PERIOD_DEFN  ";
		stmt = con.createStatement();
		rs= stmt.executeQuery(sql);

		if (rs.next())
		{
			acc_per_year=rs.getString("ACC_PER_YEAR");
			acc_per_month=rs.getString("ACC_PER_MONTH");
			acc_per_start_date=rs.getString("ACC_PER_START_DATE");
			acc_per_end_date=rs.getString("ACC_PER_END_DATE");
			acc_per_desc=rs.getString("ACC_PER_DESC");
			acc_cal_year=rs.getString("CAL_PER_YEAR");
            acc_cal_month=rs.getString("CAL_PER_MONTH");
           sys_date=rs.getString("sysdt");
		}

		

		
		

%>
<br><br><br><br><br><br><br><br><br><br>

<table border="0" cellpadding='3' cellspacing="0" width="75%" align='center'>
   	<tr>
		<td width="35%" class='label'><fmt:message key="eSM.AccountPeriodYear.label" bundle="${sm_labels}"/></td>
		<td width="60%" class='fields'>
		<input type="text" name="acc_per_year" id="acc_per_year" size="5" maxlength="4" onblur="if(this.value!='')chkYear();if(document.maintain_acc_period.acc_per_mon.value!='')genMonth(this);" onKeyPress='return(ChkNumberInput(this,event,0))'  >&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

</tr>
	<tr>
		<td width="35%" class='label'><fmt:message key="eSM.AccountPeriodMonth.label" bundle="${sm_labels}"/></td>
		<td width="60%" class='fields'>
		<input type="text" name="acc_per_mon" id="acc_per_mon" size="5" maxlength="2"onKeyPress='return(ChkNumberInput(this,event,0))' onblur="if(document.maintain_acc_period.acc_per_mon.value!='')genMonth(this);if(this.value!=''){checkMonth(this)};">&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

</tr>
<tr>
		<td width="35%" class='label'><fmt:message key="eSM.AccountPeriodSdate.label" bundle="${sm_labels}"/></td>
		<td width="60%" class='fields'><input type="text" name="acc_per_start_date" id="acc_per_start_date"  size="10" maxlength="10" onblur = "chkonblur(this,'DMY',localeName);check_date(this);" ><input type='image' id='img1' name='img1' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('acc_per_start_date',null,null);">&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>

	</tr>
	<tr>
		<td width="35%" class='label'><fmt:message key="eSM.AccountPeriodEdate.label" bundle="${sm_labels}"/></td>
		<td width="60%" class='fields'><input type="text" name="acc_per_end_date" id="acc_per_end_date"  size="10" maxlength="10"  onblur = "validDateObj(this,'DMY',localeName);" onchange="" ><input type='image' id="img2" name="img2" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('acc_per_start_date',null,null);"></td>
		<!--
		<input type="text" name="acc_per_end_date" id="acc_per_end_date" size="10"maxlength="10"onKeyPress='return(ChkNumberInput(this,event,0))' ></td>
		-->
		
		

</tr>
<tr>
		<td width="35%" class='label'><fmt:message key="eSM.AccountPeriodDesc.label" bundle="${sm_labels}"/></td>
		<td width="60%" class='fields'>
		<input type="text" name="acc_per_desc" id="acc_per_desc" size="30" maxlength="10" ></td>

</tr>
<tr>
		<td width="35%" class='label'><fmt:message key="eSM.CalenderYear.label" bundle="${sm_labels}"/></td>
		<td width="60%" class='fields'>
		<input type="text" name="acc_cal_year" id="acc_cal_year" size="10" maxlength="10"onKeyPress='return(ChkNumberInput(this,event,0))' READONLY></td>

</tr>
<tr>
		<td width="35%" class='label'><fmt:message key="eSM.CalenderMonth.label" bundle="${sm_labels}"/></td>
		<td width="60%" class='fields'>
		<input type="text" name="acc_cal_month" id="acc_cal_month" size="5" maxlength="4"onKeyPress='return(ChkNumberInput(this,event,0))' READONLY></td>

</tr>

<input type="hidden" name="acc_per_end_date1" id="acc_per_end_date1" value="<%=acc_per_end_date%>">

<input type="hidden" name="acc_per_desc1" id="acc_per_desc1" value="">
<input type="hidden" name="acc_cal_year1" id="acc_cal_year1" value="">
<input type="hidden" name="acc_cal_month1" id="acc_cal_month1" value="">
<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>

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

