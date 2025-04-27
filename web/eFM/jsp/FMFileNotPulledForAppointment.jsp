<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html; charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eFM/js/FMCheck.js" language="javascript"></script>
<script src="../../eFM/js/checkSystemDate.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eFM/js/FMNotPulledForAppt.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start-->
	<script language='javascript'>
		function isValidTime(Obj) {
			var Value	= Obj.value;
			if(Value!=""){
				if(!(/^([0-1]?[0-9]|2[0-3]):([0-5][0-9])(:[0-5][0-9])?$/).test(Value) || Value.length!=5){
					var errors= getMessage("INVALID_TIME_FMT","SM");
					alert(errors);
					Obj.value='';
					Obj.focus();
				}
			}
			if(document.forms[0].p_end_time.value!="" && document.forms[0].p_start_time.value!=""){
				ChkTimeValidation(Obj);
			}
			
		}
		
		function ChkTimeValidation(Obj){
			var Todaydate = new Date(); 
			var Formatteddate = Todaydate.getDate() +"/" + Todaydate.getMonth() +"/" + Todaydate.getYear();
			var time1 = Formatteddate + " " + document.forms[0].p_start_time.value;
			var time2 = Formatteddate + " " + document.forms[0].p_end_time.value;
			var StartTime = new Date(time1);
			var EndTime = new Date(time2);
			var TimeDiff = EndTime.getTime() - StartTime.getTime();
			if(TimeDiff <= 0) {
				var message=getMessage("ED_TIME_LESS_EQL_ST_TIME","OA")+" "+document.forms[0].p_start_time.value;; 
				alert(message);
				document.forms[0].p_end_time.value="";
				document.forms[0].p_end_time.focus();
			}
		}
	
		function ChkTimeInput(fld, e){
		    var strCheck = ':0123456789';
			var whichCode = (window.Event) ? e.which : e.keyCode;
			if (whichCode == 13) return true; 
			var key = String.fromCharCode(whichCode);
			if (strCheck.indexOf(key) == -1) return false;
			if(key == ":" && fld.value.indexOf(key) != -1) return false;
		}
	
	</script>
	<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End-->
 </HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="reportFMFileNotPulledForAppointment" id="reportFMFileNotPulledForAppointment" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<%
		Connection conn = ConnectionManager.getConnection(request);
		Statement stmt=null;
		ResultSet rset=null;
		String function_id		= "";
		function_id = request.getParameter("function_id");

		String p_module_id		= "FM" ;
		String p_report_id ="";
		if(function_id.equals("FM_NOT_PULLED_FOR_BKG")){
		p_report_id		= "FMBFNTPB" ;
		}
		else
		{
			p_report_id		= "FMBFNTPL" ;
		}

		Boolean isStartAndEndTimeAvailable 	 = CommonBean.isSiteSpecific(conn, "FM","PULLING_LIST_START_END_TIME");/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014*/
	
		String p_facility_id	=	(String)session.getValue("facility_id");
		String p_user_name		=	(String)session.getValue("login_user");
		//String params = request.getQueryString() ;
		String today ="";
		StringBuffer sb= new StringBuffer();
        int     recordCount		= 0;	
	//	String 	OneRecordFlag	= "No" ;
		String 	itemDescription = "" ;
		String 	itemCOde		= "" ;
	
	try
	  {			
			String sql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			if (rset.next())
			{
			today = rset.getString("today");
			}
			today=DateUtils.convertDate(today,"DMY","en",localeName);
			if(stmt!=null)    stmt.close();
			if(rset!=null)    rset.close();
		
				
			sql ="SELECT fs_locn_code,short_desc FROM fm_storage_locn_lang_vw WHERE facility_id='" +
			p_facility_id +  "' AND mr_locn_yn='Y' AND permanent_file_area_yn='Y' AND eff_status='E' and language_id='"+localeName+"' ORDER BY 2 " ;

			sb.append("<option value=''>----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option>");		
			stmt = conn.createStatement();		
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
					//	OneRecordFlag="Yes";
			}
			if(stmt!=null)   stmt.close();
			if(rset!=null)    rset.close();
		}
		catch(Exception e)
		{
			 out.println("Exception while fetching connection :" + e ) ;
		}
		finally
		{
						 
			 ConnectionManager.returnConnection(conn, request);
		}

%>

<table width='70%' align='center'  border="0" cellpadding='5' cellspacing='0'>
	
		<tr><td colspan='3' height='8'></td></tr>

		<tr>	
				<td class='label'  width='30%' ><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/> </td>
				<td	class='fields' width='30%' ><select name='P_FROM_CODE' id='P_FROM_CODE'  onChange=''><%=sb.toString()%></select>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></img></td>
				</td>
				<td  class='label' width='40%'></td>
		</tr>		

		<tr>
				<%if(function_id.equals("FM_NOT_PULLED_FOR_BKG")){%>
			<td class='label' ><fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/></td>
			<td  class='fields' ><input type='text' id="appt_date" name='p_booking_date' id='p_booking_date' value='<%=today%>' size="10"	maxlength="10"	 onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('appt_date');">&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></img></td>
			<%} else {%>
			<td class='label' ><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<td  class='fields' ><input type='text' id="appt_date" name='P_APPT_DATE' id='P_APPT_DATE' value='<%=today%>' size="10"	maxlength="10"	 onBlur='validDateObj(this,"DMY","<%=localeName%>");'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('appt_date');">&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></img></td>
			<%}%>
			
			
			<td class='label' ></td>
		</tr>
<!-- CheckSystemDateGreater(this,'<%=today%>');
 -->
 
 	
		<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 Start-->
		<% if(isStartAndEndTimeAvailable && !function_id.equals("FM_NOT_PULLED_FOR_BKG")){%>
		<tr>	
				<td class='label'  width='30%' ><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
				<td	class='label' width='45%'  >
				
				<INPUT TYPE=TEXT   SIZE=5 MAXLENGTH=5 name='p_start_time' id='p_start_time'  onBlur="isValidTime(this)" onKeyPress='return(ChkTimeInput(this,event))'   >
				
				<span style="padding-left:110px;" ><fmt:message key="Common.Appointment.label" bundle="${common_labels}" />&nbsp;<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></span>
				
				</td>
				<td  class='fields' width='25%' ><INPUT TYPE=TEXT   SIZE=5 MAXLENGTH=5 name='p_end_time' id='p_end_time'  onBlur="isValidTime(this)" onKeyPress='return(ChkTimeInput(this,event))'   ></td>
		</tr>
		<%}else{%>
		<input type='hidden' name='p_start_time' id='p_start_time' value=''>
		<input type='hidden' name='p_end_time' id='p_end_time' value=''>
	<%}%>
		<!--Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 20th 2014 End-->		
	<tr><td colspan='3' height='8'></td></tr>
 </table>
	 
	<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>' >
	 <input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id%>"> 
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%=p_module_id%>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%=p_report_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=p_user_name%>">
	<input type="hidden" name="today" id="today"		value="<%=today%>">
	 
</form>
</body>
<script>
if('<%=recordCount%>' == 1)
	document.forms[0].P_FROM_CODE.selectedIndex = 1;
</script>
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

