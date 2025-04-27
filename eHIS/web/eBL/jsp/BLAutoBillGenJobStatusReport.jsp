<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      	Name     			Description
--------------------------------------------------------------------------------------------------------------
30-OCT-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
-->

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*,java.util.GregorianCalendar,java.util.Date,java.util.Calendar" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Query Criteria</title>
<%!
public String getFirstDateOfMonth(Date date, int days) {
    GregorianCalendar cal = new GregorianCalendar();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    cal.setTime(date);
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));             
    return dateFormat.format(cal.getTime());
}
%>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";
	String facilityId = "";
	String loginUser = "";
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	String todaysDate = dateFormat.format(cal.getTime());
	String firstDate = getFirstDateOfMonth(cal.getTime(),29);
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/BLAutoBillGenJobStatus.js"></script>
<script language="javascript" src="../js/BLAutoBillGen.js"></script>
<script language="javascript" src="../js/AddModifyPatFinDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
$(document).ready(function() {
	$('#visitFrom').blur(function(){
		var bool =  checkDateBL(document.forms[0].visitFrom);
		if(!bool){
			$('#visitFrom').val($('#todaysDate').val());
			return false;
		}
		if($("#visitFrom").val()!='' ){
			var fromLesserThanCurrentDt=true;
			var lesserThanCurrentDt=true;
			var toGrtThanFromDt=true;
			fromLesserThanCurrentDt=isBeforeNow($("#visitFrom").val(), 'DMY',$("#locale").val());
			if($("#visitTo").val()!=''){
				lesserThanCurrentDt=isBeforeNow($("#visitTo").val(), 'DMY',$("#locale").val());
				toGrtThanFromDt=isAfter( $("#visitTo").val(), $("#visitFrom").val(), 'DMY',$("#locale").val());
			}
			if(fromLesserThanCurrentDt == false){
				alert(getMessage("BL0777","BL"));
				$("#visitFrom").val($('#todaysDate').val());
			} else if(lesserThanCurrentDt==false){
				alert(getMessage("BL0777","BL"));
			  	$("#visitTo").val($('#todaysDate').val());
			} else if(toGrtThanFromDt==false){
				if( $("#visitFrom").val()!=''){
					var msg = getMessage("BL0775","BL");
					msg = msg.replace("$", "Job Submitted Date From");
					alert(msg);
					$("#visitFrom").val($("#visitTo").val());
		   		}
			}
		}
	});
	
	$('#visitTo').blur(function(){
		var bool =  checkDateBL(document.forms[0].visitTo);
		if(!bool){
			$('#visitTo').val($('#todaysDate').val());
			return false;
		}
		if($("#visitTo").val()!=''){
			var fromLesserThanCurrentDt=isBeforeNow($("#visitTo").val(), 'DMY',$("#locale").val());	
			var  lesserThanCurrentDt=isBeforeNow($("#visitFrom").val(), 'DMY',$("#locale").val());			 
			var  toGrtThanFromDt= isAfter( $("#visitTo").val(), $("#visitFrom").val(), 'DMY',$("#locale").val());
			if(fromLesserThanCurrentDt == false){
				alert(getMessage("BL0777","BL"));
				$("#visitTo").val($('#todaysDate').val());
			} else if(lesserThanCurrentDt==false){
				alert(getMessage("BL0777","BL"));
				$("#visitFrom").val($('#todaysDate').val());
			} else if(toGrtThanFromDt==false){
				if($("#visitTo").val()!='' ){
					var msg = getMessage("BL0776","BL");
					msg = msg.replace("$", "Job Submitted Date To");
					alert(msg);
				  	$("#visitTo").val($('#visitFrom').val());
				}
		    }
				 
		}
	});
});
</script>
<%
try {
	con = ConnectionManager.getConnection(request);
	facilityId = checkForNull((String) session.getValue("facility_id"));
	loginUser = checkForNull((String) session.getValue("login_user"));
	System.out.println(facilityId + "... " + loginUser + "...." + todaysDate + "...." + firstDate);
%>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"
	onSelect="codeArrestThruSelect();">
	<form name='BLAutoBillGenJobStatusReportForm' id='BLAutoBillGenJobStatusReportForm' id='BLAutoBillGenJobStatusReportForm'> 
	<div id='BLAutoBillGenJobStatusReportDiv'>
		<table width="80%" CELLSPACING=0 cellpadding=3 align='center'>
			<tr>
				<br/>
			</tr>
			<tr >
				<td  class="columnheader" ><fmt:message key="eBL.ReportCriteria.label" bundle="${bl_labels}"/>
				</td>
			</tr>		
		</table>	
		<table cellpadding=3 cellspacing=0 width="80%" align="center" border=0>
			<tr>
			 	<td style="width:25%;" class="label" ></td>
				<td style="width:25%;" class='fields'><b><fmt:message key="eBL.From.label" bundle="${bl_labels}"/></b></td>
				<td style="width:25%;" class='fields'><b><fmt:message key="eBL.To.label" bundle="${bl_labels}"/></b></td>
			 </tr>	
			 <tr>
			 	<td style="width:25%;" class="label" ><fmt:message key="eBL.JobSubmittedDate.label" bundle="${bl_labels}"/></td>
				<td style="width:25%;" class='fields'>
					<input type='text' name='visitFrom' id='visitFrom' id='visitFrom' value='<%=firstDate %>' maxlength="10"  size='20' onblur='return checkDateBL(document.forms[0].visitFrom);'>
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('visitFrom');" onblur='return checkDateBL(document.forms[0].visitFrom);'>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td style="width:25%;" class='fields'>
					<input type='text' name='visitTo' id='visitTo' id='visitTo' value='<%=todaysDate %>' maxlength="10"  size='20' onblur='return checkDateBL(document.forms[0].visitTo);'>
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('visitTo');" onblur='return checkDateBL(document.forms[0].visitTo);'>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
			 </tr>
			 <tr>
			 	<td style="width:25%;" class="label" ><fmt:message key="eBL.JobId.label" bundle="${bl_labels}"/></td>
				<td style="width:25%;" class='fields'>
					<input type="text" name="job_id" id="job_id" id="job_id" maxlength='50' size='15'
					onblur='if(this.value!=""){jobIdLookup(job_id,episode_type,cust_group,cust_name,custgroupCode,custnameCode) }else{ this.value=""; clearValues(); }'>
					<input type='button' class='button' name="jobidbtn" id="jobidbtn" value='?' onClick="jobIdLookup(job_id,episode_type,cust_group,cust_name,custgroupCode,custnameCode)" />
				</td>
			 </tr>
			 <tr>
			 	<td style="width:25%;" class="label" ><fmt:message key="eBL.EpisodeType.label" bundle="${bl_labels}"/></td>
				<td style="width:25%;" class='fields'>
					<select id="episode_type" name="episode_type" id="episode_type"  style="width: 100px;" disabled>
						<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
						<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					</select>
				</td>			
			 </tr>
			 <tr>
				<td style="width:25%;" class="label" ><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></td>
				<td style="width:25%;" class='fields'>
					<input type="text" name="cust_group" id="cust_group" id="cust_group" readonly disabled/> 
					<!-- maxlength='40' 	onblur='if(this.value!=""){ customerLookup(2,cust_group,custgroupCode,1);}else{ this.value=""; }'> -->
					<input type="hidden" name="custgroupCode" id="custgroupCode" id="custgroupCode" />
					<!-- <input type='button' class='button' name="custgroupbtn" id="custgroupbtn" value='?' onClick="customerLookup(2,cust_group,custgroupCode,1);" /> -->
				</td>	
				<td style="width:50%;" class="label" colspan='2'>
					<fmt:message key="eBL.Customer.label" bundle="${bl_labels}"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="cust_name" id="cust_name" id="cust_name" readonly disabled/>
					<!-- maxlength="100" onblur='if(this.value!=""){ customerLookup(1,cust_name,custnameCode,1);}else{ this.value=""; }'> -->
					<input type="hidden" name="custnameCode" id="custnameCode" id="custnameCode" />
					<!-- <input type='button' class='button' name="custnamebtn" id="custnamebtn" value='?' onClick="customerLookup(1,cust_name,custnameCode,1);" /> -->
				</td>
			 </tr>
			 <tr>
				<td style="width:25%;" class="label" >
					<input type='button' name='search' id='search' id='search' value='Execute' onclick='executeQuery();'> 
				</td>
			</tr>		
		</table>
	</div>
	<input type=hidden name="getUserQry" id="getUserQry"  value="select code,description from (select bl_user_id code, appl_user_name description from sm_appl_user, bl_user where bl_user_id = appl_user_id ) where upper(description) like upper(?) and upper(code) like upper(?)">
	<input type=hidden name="getJobIdQry" id="getJobIdQry"  value="">
	<input type=hidden name="locale" id="locale" id="locale" value='<%=locale %>'>
	<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='<%=facilityId%>'>
	<input type='hidden' name='loginUser' id='loginUser' id='loginUser' value='<%=loginUser%>'>
	<input type='hidden' name='todaysDate' id='todaysDate' id= 'todaysDate' value='<%=todaysDate%>'>
	<div id='BLAutoBillGenJobStatusResultDiv'></div>
	</form>
<%
	} catch (Exception e) {
		e.printStackTrace() ;
		System.err.println("Exception from Auto Fill Search Criteria :"+e);
		con.rollback();
	} finally {	
		if(rs != null ) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%>
</body>
</html>

