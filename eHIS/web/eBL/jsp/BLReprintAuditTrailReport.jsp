<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	   Edit History              Name     			Description
--------------------------------------------------------------------------------------------------------------
10-JULY-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page   import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.util.GregorianCalendar,java.util.Date,java.util.Calendar" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
public String getFirstDateOfMonth(Date date, int days) {
    GregorianCalendar cal = new GregorianCalendar();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    cal.setTime(date);
    cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));             
    return dateFormat.format(cal.getTime());
}
%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
	<script language='javascript' src='../../eBL/js/BLReprintAuditTrailReport.js' ></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function onloadRequestStatus() {
			document.forms[0].episode_type.value='A';
		}
		
		$(document).ready(function() {
			$('#reprint_date_from').blur(function(){
				var bool =  checkDateBL(document.forms[0].reprint_date_from);
				if(!bool){
					$('#reprint_date_from').val($('#todaysDate').val());
					return false;
				}
				if($("#reprint_date_from").val()!='' ){
					var fromLesserThanCurrentDt=true;
					var lesserThanCurrentDt=true;
					var toGrtThanFromDt=true;
					fromLesserThanCurrentDt=isBeforeNow($("#reprint_date_from").val(), 'DMY',$("#locale").val());
					if($("#reprint_date_to").val()!=''){
						lesserThanCurrentDt=isBeforeNow($("#reprint_date_to").val(), 'DMY',$("#locale").val());
						toGrtThanFromDt=isAfter( $("#reprint_date_to").val(), $("#reprint_date_from").val(), 'DMY',$("#locale").val());
					}
					if(fromLesserThanCurrentDt == false){
						alert("Future date not allowed. Please enter a valid date");
						$("#reprint_date_from").val($('#todaysDate').val());
					} else if(lesserThanCurrentDt==false){
					  	alert("Future date not allowed. Please enter a valid date");
					  	$("#reprint_date_to").val($('#todaysDate').val());
					} else if(toGrtThanFromDt==false){
						if( $("#reprint_date_from").val()!=''){
					 		alert("Reprint Date From cannot be greater than Reprint Date To. Please enter a valid date");
							$("#reprint_date_from").val($("#reprint_date_to").val());
				   		}
					}
				}
			});
			$('#reprint_date_to').blur(function(){
				var bool =  checkDateBL(document.forms[0].reprint_date_to);
				if(!bool){
					$('#reprint_date_to').val($('#todaysDate').val());
					return false;
				}
				if($("#reprint_date_to").val()!=''){
					var fromLesserThanCurrentDt=isBeforeNow($("#reprint_date_to").val(), 'DMY',$("#locale").val());	
					var  lesserThanCurrentDt=isBeforeNow($("#reprint_date_from").val(), 'DMY',$("#locale").val());			 
					var  toGrtThanFromDt= isAfter( $("#reprint_date_to").val(), $("#reprint_date_from").val(), 'DMY',$("#locale").val());
					if(fromLesserThanCurrentDt == false){
						alert("Future date not allowed. Please enter a valid date");
						$("#reprint_date_to").val($('#todaysDate').val());
					} else if(lesserThanCurrentDt==false){
						alert("Future date not allowed. Please enter a valid date");
						$("#reprint_date_from").val($('#todaysDate').val());
					} else if(toGrtThanFromDt==false){
						if($("#reprint_date_to").val()!='' ){
							alert("Reprint Date To cannot be lesser than Reprint Date From. Please enter a valid date");
						  	$("#reprint_date_to").val($('#reprint_date_from').val());
						}
				    }
						 
				}
			});
		});
	</script>
</head>
<%
	String locale = "";
	String facilityId = "";
	String strLoggedUser = "";
	String todaysDate= "";
	String firstDate ="";
	Calendar cal = Calendar.getInstance();
	String reportId = "BLRREPRT";
	String moduleId = "BL" ;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Connection con = null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;
	try {
		HttpSession httpSession = request.getSession(false);
		con = ConnectionManager.getConnection(request);
		locale	= (String)session.getAttribute("LOCALE");
		facilityId = (String)session.getAttribute("facility_id");
		if (facilityId==null) facilityId = "";
		strLoggedUser = (String) session.getValue("login_user");	
		if (strLoggedUser==null) strLoggedUser = "";
		todaysDate = dateFormat.format(cal.getTime());		
		firstDate = getFirstDateOfMonth(cal.getTime(),29);
	} catch(Exception e) {
		e.printStackTrace();
		System.err.println("Exception in site spec "+e);
	} finally 
	{
		ConnectionManager.returnConnection(con,request);
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
%>
<body onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"onSelect="codeArrestThruSelect();" onLoad="onloadRequestStatus();">
	<form name='BLReprintAuditTrailReport' id='BLReprintAuditTrailReport' method='' action="" target="messageFrame">
		<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
			<tr>
				<td width='17%'  class='label'>
					<fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/>
				</td>
				<td width="17%" class="fields">
					<select id="episode_type" name="episode_type" id="episode_type">
						<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
						<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
						<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
						<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
						<option value="R"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
			<tr>
				<td width='17%'  class='label'>
					<fmt:message key="eBL.ReprintDateFrom.label" bundle="${common_labels}"/>
				</td>
				<td width="17%" class="fields">
					<input type='text' name='reprint_date_from' id='reprint_date_from' id='reprint_date_from' value='<%=firstDate%>' maxlength="10" size="15">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('reprint_date_from');" onBlur='return checkDateBL(document.forms[0].reprint_date_from)'>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td width='17%'  class='label'>
					<fmt:message key="eBL.ReprintDateTo.label" bundle="${common_labels}"/>
				</td>
				<td width="17%" class="fields">
					<input type='text' name='reprint_date_to' id='reprint_date_to' id='reprint_date_to' value='<%=todaysDate%>' maxlength="10" size="15">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('reprint_date_to');" onBlur='return checkDateBL(document.forms[0].reprint_date_to)'>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
			<tr>
				<td width='17%'  class='label'>
					<fmt:message key="eBL.DocTypeFrom.label" bundle="${common_labels}"/>
				</td>
				<td width="17%" class="fields" width="25%">
					<input type="text"  name="doctype_from" id="doctype_from" id='doctype_from' size="8"  maxlength='40'
					onBlur="ChangeUpperCase(this);if(this.value!=''){doctypeLookUp(doctype_from, docnum_from, 'T','FROM');docNoFromToValidation('FROM');}else{ fnClearCode(this); }"
					onKeyPress="return CheckForSpecChars(event);">&nbsp;
					<input type="text"  name="docnum_from" id="docnum_from" id='docnum_from' size="10"  maxlength='40'
					onBlur="ChangeUpperCase(this);if(this.value!=''){doctypeLookUp(doctype_from, docnum_from, 'N','FROM');docNoFromToValidation('FROM');}else{ fnClearCode(this); }"
					onKeyPress="return CheckForSpecChars(event);">&nbsp;
					<input type='button' class='button' name="doctype_from_but" id="doctype_from_but" value='?'
					onclick = "doctypeLookUp(doctype_from, docnum_from, 'N', 'FROM');docNoFromToValidation('FROM');" tabindex='2'/>
				</td>
				<td width='17%'  class='label'>
					<fmt:message key="eBL.DocTypeTo.label" bundle="${common_labels}"/>
				</td>
				<td width="17%" class="fields" width="25%">
					<input type="text"  name="doctype_to" id="doctype_to" id='doctype_to' size="8"  maxlength='40'
					onBlur="ChangeUpperCase(this);if(this.value!=''){doctypeLookUp(doctype_to, docnum_to, 'T', 'TO');docNoFromToValidation('TO');}else{ fnClearCode(this); }"
					onKeyPress="return CheckForSpecChars(event);">&nbsp;
					<input type="text"  name="docnum_to" id="docnum_to" id='docnum_to' size="10"  maxlength='40'
					onBlur="ChangeUpperCase(this);if(this.value!=''){doctypeLookUp(doctype_to, docnum_to, 'N', 'TO');docNoFromToValidation('TO');}else{ fnClearCode(this); }"
					onKeyPress="return CheckForSpecChars(event);">&nbsp;
					<input type='button' class='button' name="doctype_to_but" id="doctype_to_but" value='?'
					onClick="doctypeLookUp(doctype_to, docnum_to, 'N', 'TO');docNoFromToValidation('TO');" tabindex='2'/>
				</td>
			</tr>
		</table>
		<input type= hidden name="locale" id="locale"  id='locale' value="<%=locale%>">
		<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facilityId%>">
		<input type="hidden" name="userid" id="userid" id="userid" 	 value="<%=strLoggedUser%>">
		<input type='hidden' name='todaysDate' id='todaysDate' id='todaysDate' value='<%=todaysDate%>'>
		<input type="hidden" name="p_session_id" id="p_session_id" value="">
		<input type="hidden" name="p_pgm_date" id="p_pgm_date" value="">
		<input type="hidden" name="p_pgm_id" id="p_pgm_id" value="">
		<input type="hidden" name="reportId" id="reportId" value="<%=reportId%>">
		<input type="hidden" name="moduleId" id="moduleId" value="<%=moduleId%>">
	</form>
</body>
</html>

