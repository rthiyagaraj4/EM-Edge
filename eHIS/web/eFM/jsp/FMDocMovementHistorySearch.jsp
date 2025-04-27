<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String p_module_id		= "FM" ;
	String p_report_id		= "FMBFMVHS" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
	<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>

</head>
<script>
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
		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			//var	messag = "APP-SM0005 To Date should be Greater than or equal to From Date";
			var	messag = getMessage("TO_DATE_LESSER_FROM_DATE","FM");
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+messag;			
			to.select();
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) 
		{
			return true;
		}
	}
	return true;
}

	function CheckPatientExists(ObjVal)
	{	
		if(ObjVal != "")
		{
			var facility = ManualEntry_form.p_facility_id.value;
			var HTMLVal = "<html><body onKeyDown = 'lockKey()' ><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMFileMovementCheckPatientExists.jsp?Patient="+ObjVal+"&Facility="+facility+" \"> </form></body></html>";
			parent.frames[2].document.write(HTMLVal);
			parent.frames[2].document.forms[0].submit();
		}	
	}
	function CheckFileExists(ObjVal)
	{
		if(ObjVal != "")
		{
			var facility = ManualEntry_form.p_facility_id.value;
			var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name='Dummy' id='Dummy' method='post' action=\"../../eFM/jsp/FMFileMovementCheckFileExists.jsp?FileNo="+ObjVal+"&Facility="+facility+" \"> </form></body></html>";
			parent.frames[2].document.write(HTMLVal);
			parent.frames[2].document.forms[0].submit();
		}	
	}
</script>
<body OnMouseDown='CodeArrest();' onload='FocusFirstElement();' onKeyDown = 'lockKey();'>
<%
	Connection conn		= ConnectionManager.getConnection(request);

	Statement stmt	= null;
	ResultSet rset	= null;	
	String sql = "";
	String today ="";
    
	try
	{
		sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
		stmt = conn.createStatement();
		rset = stmt.executeQuery(sql);
		if (rset.next())
		{
			today = rset.getString("today");
		}
%>
<form name='ManualEntry_form' id='ManualEntry_form' target='messageFrame' action="../../eCommon/jsp/report_options.jsp">
<table border='0' cellpadding='0' cellspacing='0' width='95%' align='center'>
	<tr><td colspan='4'>&nbsp;</td></tr>	
	</tr><td colspan="6" >
			<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="frame_name" value="parent.searchResultFrame"/>
				<jsp:param name="form_name" value="ManualEntry_form"/>
				<jsp:param name="messageframe_name" value="parent.messageFrame"/>
				<jsp:param name="patientid_name" value="patientid"/>
				<jsp:param name="fileno_name" value="file_no"/>
				<jsp:param name="filetype_name" value="file_type_code"/>
				<jsp:param name="document_type_name" value="doc_type_code"/>
				<jsp:param name="document_folder_id_name" value="doc_folder_id"/>
				<jsp:param name="volumeno_name" value="volume_no"/>
				<jsp:param name="table_width" value="95"/>
				<jsp:param name="tablealign" value="center"/>
				<jsp:param name="volume_mandatory_yn" value="Y"/>
				<jsp:param name="locn_code" value="f_curr_fs_locn"/>
			</jsp:include>
	</td></tr>
	<tr>
		<td  class='label' width='20%'><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;</td>
		<td >&nbsp;<input type='text' id="date_from" name='p_from_date' id='p_from_date' size='10' maxlength='10' tabIndex="3" value='' onBlur="validDateObj(this,'DMY',localeName);DateCompare(this, p_to_date, 'messageFrame','Date');"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');">&nbsp;-&nbsp;<input type='text' id="date_to" name='p_to_date' id='p_to_date' size='10' maxlength='10' value='' tabIndex="4" onBlur="CheckDate(this);DateCompare(p_from_date, this, 'messageFrame','Date');"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');"></td>
	</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
</table>
<%
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
}
catch(Exception e)
{
	out.println(e);
}
finally
{	
	ConnectionManager.returnConnection(conn,request);
}
%>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="today" id="today"				value="<%=today%>">
<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
</form>
</body>
</html>

