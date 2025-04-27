<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eMR/js/MRReports.js" language="javascript"></script>
         <script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
/*function validate_date(obj) {
		var from = obj.value;
		
	   var to   = document.forms[0].CurrentDate.value;
       var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		if (CheckDate(obj)){
			if(Date.parse(todt) < Date.parse(fromdt)) {
					var invaldt = getMessage("DATE1_GT_DATE2",'IP') ;
					var census_date_from=(getLabel("eMR.NotificationDate.label","MR"));
					var sys_date=getLabel("Common.CurrentDate.label","Common");
					invaldt=invaldt.replace('$',census_date_from);
					invaldt=invaldt.replace('#',sys_date);
					alert(invaldt);
					obj.value='';
					obj.focus();
					
				}
			}
		}*/
function ComparePeriodFromToTime(from,to)
{
	
	var frdt = from.value;
	
	var tdt = to.value;
	var greg_tdt = "";
	var greg_frdt = "";

	if(frdt !="" && validDate(frdt,"DMY","en"))
	{
		greg_frdt = convertDate(frdt,"DMY",localeName,"en");
		
	}

	if(to !="" && validDate(tdt,"DMY","en"))
	{
		greg_tdt = convertDate(tdt,"DMY",localeName,"en");
	}
      
	if(greg_frdt != "" && greg_tdt !="")
	{
		if(greg_tdt < greg_frdt)
		{
		
			alert( getMessage("TO_DT_GR_EQ_FM_DT",'SM') );
			document.forms[0].P_TO_ADMN_DATE.focus();
			document.forms[0].P_TO_ADMN_DATE.select();
		}
	}
}

//july 13 2010
function validate_date(obj) {
	
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.select();
				obj.focus();
				return false ;
			}
		}
  }
</script>

</head>
<%
  Connection con =null;
  ResultSet rs   = null;
  Statement stmt = null;
%>
<%
		
     String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
     String CurrentDate=" ";
	 String datarange="";
	try{
		 con  =  ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next())
			CurrentDate= rs.getString(1);
		
        str="select MAX_DAYS_NOTIFY_DIS_LST from mr_parameter";
   	   stmt=con.createStatement();
	   	rs = stmt.executeQuery(str);
		while (rs.next())
			datarange= rs.getString("MAX_DAYS_NOTIFY_DIS_LST");
	
	
	}
	catch(Exception e)
	{}
	finally
	{
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
<%
	//Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
try {

    con=ConnectionManager.getConnection(request);


%>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="lab_test_rep" id="lab_test_rep" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='60%' cellpadding="3" cellspacing="0"  align='center'>
		 <tr>
<td class="COLUMNHEADER" colspan='8'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
</tr>
		 <tr>
		 <td class='label' colspan=3>&nbsp;</td>
		</tr>
		<tr>
			<td class='label' width="30%">&nbsp;</td>
			<td class="querydata" width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
	    <tr>  
			<td class="label"><fmt:message key="eMR.DateReang.label" bundle="${mr_labels}"/></td>
			<td class='fields'><input type='text' id='birthfrom' name='P_FM_ADMN_DATE' id='P_FM_ADMN_DATE' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validate_date(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/><img align="center" src="../../eCommon/images/mandatory.gif"></td>

			<td class='fields'><input type='text' id='birthto' name='P_TO_ADMN_DATE' id='P_TO_ADMN_DATE' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>');validate_date(this);" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"><img align="center" src="../../eCommon/images/mandatory.gif"></td>
	   </tr>
    <tr>
		<td class='label' colspan=3>&nbsp;</td>
	</tr>
   </table>

		 	 	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	
<input type="hidden" name="p_module_id" id="p_module_id"     value="MR">
<input type="hidden" name="p_report_id" id="p_report_id"     value="MRNODTHR">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
<input type="hidden" name="CurrentDate" id="CurrentDate"	    value="<%= CurrentDate %>"> 
<input type="hidden" name="datarange" id="datarange"	    value="<%= datarange %>">
</form>
</body>
</html>
<%
} catch(Exception e) {  /* out.println("in else "+e); */e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

