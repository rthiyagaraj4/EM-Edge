<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eBL/js/BLRecordPaymentConsent.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	int pat_id_len= 0;
	String sysdtsql = "";
	String sqlDate = "";
	String sql="";
	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		sql ="select patient_id_length from mp_param";

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		if (rs != null && rs.next() )
		{
			pat_id_len = rs.getInt("patient_id_length") ;
		}

		sysdtsql="select to_char(sysdate,'dd/mm/yyyy') from dual ";
			
		pstmt = con.prepareStatement(sysdtsql);
			
		rs = pstmt.executeQuery();
		if (rs != null && rs.next() )
		{
			sqlDate=rs.getString(1);
		}

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();		

%>
<BODY  onKeyDown="lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" >
	<FORM method='post' name="search" id="search" id="search" action=""	onsubmit="" >
	<TABLE width="100%" CELLSPACING=0 cellpadding=3 align='center'>
		<tr>
			<td  class="columnheader">Search Criteria</td>
		</tr>	
	</TABLE>
	<table cellpadding="3" cellspacing=0 width="100%" align="center" border = '0'>
		<tr>
			<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class="fields">
				<input type="text" name="patient_id" id="patient_id" id="patient_id" maxlength="<%=pat_id_len %>" onBlur="ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == ''){ patient_name.value=''; return PatientIdLookup(); }" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" value="">
				<input type="button" class="button" name="patientidbut" id="patientidbut" value='?' onClick="return PatientIdLookup()"  />
				<span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>

			<td class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class="fields">
				<input type="text" name="patient_name" id="patient_name" id="patient_name" readonly   maxlength="100"  onBlur="ChangeUpperCase(this);" onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onfocus="ChangeUpperCase(this);" >	
			</td>
			
			<td class="label"><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
			<td class="fields">
				<select id="episode_type" name="episode_type" id="episode_type">
					<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
					<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}" /></option>
					<option value="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}" /></option>
					<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}" /></option>					
					<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}" /></option>
				</select>
			</td>
		</tr>
		<tr>
			<td class="label">
				<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="encounter_id" id="encounter_id" id="encounter_id" size = "15" maxlength="12"  onBlur="ChangeUpperCase( this );if(this.value!=''){encounterIDLkup(this);}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type="button" class="button" name="patientidbut" id="patientidbut" value='?' onClick="return encounterIDLkup()"  >
			</td>
			
			<td class="label">
				<fmt:message key="eBL.Encounterdatefrom.label" bundle="${bl_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="enc_from_date" id="enc_from_date" id="enc_from_date" maxlength='10' onblur='encFromDateValidation(this, enc_from_date,enc_to_date);' value="">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('enc_from_date');"  onKeyPress="return lockbackSpace();">
			</td>
			<td class="label">
				<fmt:message key="eBL.Encounterdateto.label" bundle="${bl_labels}"/>
			</td>
			<td class="fields">
				<input type="text" name="enc_to_date" id="enc_to_date" id="enc_to_date" maxlength='10' onblur='encToDateValidation(this, enc_from_date,enc_to_date);' value="">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('enc_to_date');"  onKeyPress="return lockbackSpace();">			
			</td>
		</tr>
		<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td align="center"><input type="button" name="search_btn" id="search_btn" id="search_btn" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>" class="button" onClick='searchForData();'>
			</td>
		</tr>
	</table>
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
		<input type="hidden" name="facility_id" id="facility_id" id="facility_id" value="<%=facility_id%>">	
	</form>
</body>
<%
	}
	catch(Exception e) {
		out.println(e.toString());
		e.printStackTrace();
	}
	finally 
	{
	}		
%>
</html>
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



