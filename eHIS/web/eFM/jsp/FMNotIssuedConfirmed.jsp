<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String p_module_id		= "FM" ;
	String p_report_id		= "FMBFIRNC" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->

	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eFM/js/FMCheck.js" ></script>
<script language="javascript" src='../../eCommon/js/common.js'></script>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
/*
	function defaultOPtion()
	{
		var flag =  document.forms[0].OneRecordFlag.value ;
		if(flag == "Yes"  || flag == "yes" )
		{
			document.forms[0].p_from_code.selectedIndex = 0 ;
		}
	}
	*/
	function DateCompare(from,to,messageFrame,getVal) 
	{
		var getValue = getVal;
		var fromarray; var toarray;
		var fromdate = from.value ;
		var todate = to.value ;
		if(fromdate.length > 0 && todate.length > 0 ) 
		{
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if (!isBefore(fromdate,todate,"DMY",localeName))
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.select();
				return false;
			}
			/*if(Date.parse(todt) < Date.parse(fromdt)) 
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.select();
				return false;
			}*/
			else if(Date.parse(todt) >= Date.parse(fromdt)) 
			{
				return true;
			}
		}
		return true;
	}
</script>
</head>
<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
	<br><br>
	<form name="reportFMFileNotPulledForAppointment" id="reportFMFileNotPulledForAppointment" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rset			= null ;

	String facility_id = (String)session.getValue("facility_id");	
		
	String sql					= "";
	String maintain_doc_or_file = "";
	String mysql				= "";
//	String OneRecordFlag		= "";
	String itemDescription		= "";
	String itemCOde				= "";
   String today="";
	StringBuffer sb = new StringBuffer();

	int recordCount	= 0;

	try
	{
		stmt = con.createStatement();

		mysql = "SELECT maintain_doc_or_file FROM mp_param";
		rset = stmt.executeQuery(mysql);
		if(rset != null && rset.next())
		{
			maintain_doc_or_file = rset.getString("maintain_doc_or_file");
		}
		if(rset!=null)	rset.close();
		
		mysql ="select to_char(sysdate,'dd/mm/yyyy')today from dual";	
		rset = stmt.executeQuery(mysql);
		if(rset != null && rset.next())
		{
			today = rset.getString("today");
		}
		if(rset!=null)	rset.close();
		
		
		
		sql = "SELECT fs_locn_code,short_desc FROM fm_storage_locn_lang_vw WHERE facility_id = '"+facility_id+"' AND mr_locn_yn = 'Y' AND permanent_file_area_yn = 'Y' AND eff_status = 'E' and language_id='"+localeName+"' ORDER BY 2";

		sb.append("<option value=''>----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option>");				
		rset = stmt.executeQuery(sql);
		if(rset!=null)
		{		  
			while(rset.next())
			{
				 itemDescription = rset.getString("short_desc");
				 itemCOde	     = rset.getString("fs_locn_code");
				 sb.append("<option value='"+itemCOde+"'>"+itemDescription+"</option>");
				 recordCount++;
			}

		//	if(recordCount == 1)
		//		OneRecordFlag="Yes";
		}
	%>
		<table width='70%' align='center'  border="0" cellpadding='5' cellspacing='0'>
			<tr>	
				<td class='label' width='40%'  maxlength="10" ><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/> </td>
				<td	class='fields' width='60%'><select name='p_from_code' id='p_from_code'  onChange=''><%=sb.toString()%></select><img align=center src='../../eCommon/images/mandatory.gif'></img></td>
			</tr>
			<tr>
				<%if(maintain_doc_or_file.equals("F")){%>
				<td class='label' ><fmt:message key="eFM.Filespendingformorethan.label" bundle="${fm_labels}"/></td>
				<%}else if(maintain_doc_or_file.equals("D")){%>
				<td class='label'><fmt:message key="eFM.Documentspendingformorethan.label" bundle="${fm_labels}"/></td>
				<%}%>
					<td class='fields' ><input type='text' name='p_no_of_days' id='p_no_of_days' value='' onkeyPress='return allowValidNumber(this,event,3,0);'	  size="3"	maxlength="3"	 onBlur="CheckPositiveNumberMy(this);">&nbsp;days for confirmation&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></img></td>
			</tr>
			<tr><td class='label'><fmt:message key="eFM.DateofIssue.label" bundle="${fm_labels}"/></td>
				<td class='fields'><input type='text' id="date_from" name='p_from_date' id='p_from_date' size='10' maxlength='10' value='' onBlur="validDateObj(this,'DMY','<%=localeName%>');DateCompare(this, p_to_date, 'messageFrame','Date of Issue');"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_from_date.focus(); return showCalendar('date_from');">&nbsp;-&nbsp;<input type='text' id="date_to" name='p_to_date' id='p_to_date' size='10' maxlength='10' value='' onBlur="validDateObj(this,'DMY','<%=localeName%>');DateCompare(p_from_date, this, 'messageFrame','Date of Issue');"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_to_date.focus();return showCalendar('date_to');"></td>
			</tr>
			<tr> 
				<td colspan='2'> &nbsp;</td>
			</tr>
		</table>
		 
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
		<input type="hidden" name="today" id="today"				value="<%=today%>">
			
	<script>
		if('<%=recordCount%>' == 1)
			document.forms[0].p_from_code.selectedIndex = 1;
	</script>
	</form>
<%
	if(stmt!=null)	stmt.close();
	if(rset!=null)	rset.close();
	}
	catch(Exception e)
	{
		 out.println("Exception while fetching connection :" + e ) ;
	}
	finally
	{		
		ConnectionManager.returnConnection(con, request);
	}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

