<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.ConnectionManager, java.sql.Connection,java.sql.Statement, java.sql.ResultSet" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String facility_id = (String)session.getValue("facility_id");
	request.setCharacterEncoding("UTF-8");
	String valubl		= ((request.getParameter("valuble")==null) ?"" : request.getParameter("valuble"));
	String patientId=request.getParameter("patientId");
	String encounter_id=request.getParameter("encounter_id");
	if(patientId == null) patientId="";
    if(encounter_id == null) encounter_id="";
%>
<html>
    <head>
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    	<title><fmt:message key="Common.PatientValuables.label" bundle="${common_labels}"/></title>		
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
        
        <script src='../../eCommon/js/dchk.js' language='javascript'></script>
        <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   
		
	   <script>

	   // By Annadurai 2/3/2004 starts.
	   var GlobalVal ="";
		
		// To get the Patient valuables details if that is already entered. 	
		function onBodyLoad()
		{
			if(document.forms[0].Valuble.value != "")
			{
				var Valubles=unescape(document.forms[0].Valuble.value);
				var assignVal =  new Array();
				assignVal = Valubles.split('||');
		
				PatientValuables.remarks.value = checkForNull(assignVal[2]);
			}
		} // End of onBodyLoad().

		// When pressing Close button all the values entered are concatenated as
		//   one string., and passed as return value.
		function call4Values()
		{
			var greg_checkInDateTime='';
			if(PatientValuables.chk_in_dt_time.value!='')
				greg_checkInDateTime = convertDate(PatientValuables.chk_in_dt_time.value,'DMYHM',localeName,'en');
			PatientValuables.valuble_date.value  = checkForNull(PatientValuables.recordedby.value);
			//PatientValuables.valuble_date.value += "||"+checkForNull(PatientValuables.chk_in_dt_time.value);
			PatientValuables.valuble_date.value += "||"+checkForNull(greg_checkInDateTime);		
			PatientValuables.valuble_date.value += "||"+checkForNull(PatientValuables.remarks.value);
		} // End of call4Values().

		// When clicking Close Button to perform some operations.
		function CloseWin()
		{
			call4Values();
			window.close();
			window.returnValue=PatientValuables.valuble_date.value;
		} // End of CloseWin().
		
		// to avoid NullPointerException.
		function checkForNull(inString)
		{
			return (trimCheck(inString))	?	inString	:	"";
		}// End of checkForNull.
		
		// the patient valuable details can not exceed 2000 characters,
		function verifyMax(obj)
		{
			
			if(obj.value.length > 2000)
			{
				alert(getMessage("PAT_VAL_MAX_2000","IP"));
				obj.focus();
				obj.select();
			}
			else 
			makeValidString(obj);
		} // End of checkMax().

		// To check for maximum length,
		function CheckMaxLen(obj,max) 
		{
				if(obj.value.length >= max) {
					return false;
				} else return true;
		} // End of CheckMaxLen().

		// By Annadurai 02/03/2004 ends.,
		function ChkNumberInput1(fld, e, deci)
		{
			if (	parseInt(deci)>0)
			   var strCheck = '.0123456789 /:';
			else
			   var strCheck = '0123456789 /:';
				
			   var whichCode = (window.Event) ? e.which : e.keyCode;
				if (whichCode == 13) return true;  // Enter
				key = String.fromCharCode(whichCode);  // Get key value from key code
				if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		 }

	  	 </script>
</head>
 <%
	Connection con = null;
	Statement stmt = null;
	ResultSet rset = null;
	String sdate   = "";
	String sdate_converted = "";
	String valuable_details="";
	try
    {
		String loginUser = (String)session.getValue("login_user");

		con = ConnectionManager.getConnection(request);
		String sdatsql = "Select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate from dual";    
		stmt  = con.createStatement();
		rset    = stmt.executeQuery(sdatsql);
		if(rset != null)
		{
			if(rset.next())
			{
				sdate = rset.getString("sdate");
				if(sdate == null) sdate = "";
				if(!(sdate==null || sdate.equals("")))
					sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",localeName);

			}    
		}
        if (rset != null) rset.close();
        if (stmt != null) stmt.close();
 //StringBuffer sql = new StringBuffer("Select  valuable_details  from PR_PATIENT_VALUABLES where encounter_id='"+encounter_id+"' and patient_id='"+patientId+"' and facility_id='"+facility_id+"' ");    
 String sql="Select  valuable_details  from PR_PATIENT_VALUABLES where encounter_id='"+encounter_id+"' and patient_id='"+patientId+"' and facility_id='"+facility_id+"' " ;

      stmt=con.createStatement();
  	 rset	 =stmt.executeQuery(sql);
     if(rset.next()) 
		{
   valuable_details=checkForNull(rset.getString("valuable_details"));
 
		}
     if(valuable_details==null) valuable_details="";
	   if (rset != null) rset.close();
        if (stmt != null) stmt.close();
 %>


	<body onLoad= "FocusFirstElement();onBodyLoad();" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='PatientValuables' id='PatientValuables'> 
            <table border=0 cellspacing=0 cellpadding=0 width='100%'>
			<tr><td colspan='4'>&nbsp;</td></tr>
			<tr>
				<td width='20%' class='label' align='right'><fmt:message key="Common.RecordedBy.label" bundle="${common_labels}"/> &nbsp;&nbsp;</td>
				<td width='30%' align='left'>
				<input type=text name="recordedby" id="recordedby" size="30" maxLength='30' readonly value="<%=loginUser%>">
				</td>
				<td width='25%' class='label' align='right'><fmt:message key="Common.recordeddatetime.label" bundle="${common_labels}"/> &nbsp;&nbsp;</td>
				<td width='25%' align='left'>
				<INPUT TYPE="text" name="chk_in_dt_time" id="chk_in_dt_time" id="blockfrom" size="16" maxlength="16" value="<%=sdate_converted%>" readonly >&nbsp;</TD>
				</td>
            </tr>
			<tr><td colspan='4'>&nbsp;</td></tr>
			<tr>
				<td width='20%' class='label' align='right' scope="session" ><fmt:message key="Common.PatientValuables.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td width='30%' align='left' colspan=3>
				<textarea name="remarks" rows=10 cols=80 maxLength='2000' onBlur="verifyMax(this);" readonly><%=valuable_details%> </textarea>
				</td>
            </tr>
			<tr><td colspan='4'>&nbsp;</td></tr>
			<br>
			<td class='white'>&nbsp;</td><td colspan=3 class='white' align='right'><input type='button' class='button' name='Close' id='Close' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick='CloseWin();'>&nbsp;&nbsp;</td>
			</table>
	<input type='hidden' name='sdate' id='sdate' value="<%=sdate%>">
	<input type='hidden' name='valuble_date' id='valuble_date' >
	<input type='hidden' name='Valuble' id='Valuble' value="<%=valubl%>" >

	</form>
		<%

	}catch(Exception e) {out.println(e.toString());}
    finally
    {
        ConnectionManager.returnConnection(con,request);
    }

	%>

    </body>
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

