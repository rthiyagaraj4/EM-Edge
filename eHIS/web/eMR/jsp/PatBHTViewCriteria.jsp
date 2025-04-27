<!DOCTYPE html>
<!--
CRF Reference No     :  ML-MMOH-CRF-1959
Detected Release  No      :  SEPTEMBER 2023 Release 
File prepared by          :  SANTHOSH KUMAR N
File prepared date        :  1-07-2023
Purpose of the Change   :  As a MR user, In MR Module, I should be able to have a new function Receive BHT where the discharged records of all patient types can be changed to overdue, Delivered, returned or received.
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites    
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	Statement stmt = null;
	ResultSet rs   = null;
	String sql="";
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale           = (String) session.getAttribute("LOCALE");
	String facility_id  = (String) session.getValue("facility_id");
	String module_id = request.getParameter("module_id");
	String currentdate ="";
	int pat_id_len = 0;
	String OsVal="";
	String loginUser = (String)session.getValue("login_user");
	String servingDate="";
	String SystemDate_display="";
	String maxDaysBHTSubmission="";
	try{
		con = ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		rs	= stmt.executeQuery("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
		while(rs.next()){
			servingDate = rs.getString("CURRENT_DATE");
		}
		SystemDate_display = DateUtils.convertDate(servingDate,"DMY" ,"en",locale);
		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
	} catch (Exception e) {
				e.printStackTrace();
	}
		
	try{	
		stmt	= con.createStatement();	
		rs	= stmt.executeQuery(" select patient_id_length, AM_OPER_STN_ACCESS_CHECK('"+facility_id+"','"+loginUser+"','X','','CANCEL_CHECKOUT_YN') osval from mp_param where module_id='MP' ") ;
	if (rs != null && rs.next()) {
		OsVal=rs.getString("osval");	
		pat_id_len = rs.getInt("patient_id_length");
		System.err.println("pat_id_len= "+pat_id_len);
	}
	if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
	} catch (Exception e) {
				e.printStackTrace();
	}
	
	try{	
		stmt	= con.createStatement();	
		rs	= stmt.executeQuery("SELECT MAX_NUM_DAYS_BHT_SUBMISSION FROM MR_PARAMETER") ;
	if (rs != null && rs.next()) {
		maxDaysBHTSubmission=rs.getString("MAX_NUM_DAYS_BHT_SUBMISSION");	
	}
	if(stmt!=null) stmt.close();
	if(rs!=null) rs.close();
	} catch (Exception e) {
				e.printStackTrace();
	}

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src="../js/PatientBHT.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

</script>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >
<form name="BHTQuery" id="BHTQuery" method="post"  target="messageFrame">
<table border='0' cellpadding='2' cellspacing='0' width='80%' align='center'>
<tr>
	<td width="22%" class="label" ><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
		<td class="fields">
		 
				<select name="lstPatientClass" id="lstPatientClass" id="lstPatientClass" onChange="getLocation(this);">
				<option value = ''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
				try {
				pstmt = con.prepareStatement("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS_LANG_VW WHERE PATIENT_CLASS in ('EM','DC','OP','IP') and language_id='"+locale+"' order by 1");
				rs	=pstmt.executeQuery();
				if(rs != null) {									
					while (rs.next()) {	
				%>
						<option value='<%=rs.getString("PATIENT_CLASS")%>'><%=rs.getString("short_desc")%></option>
				<%	}
				}
				if(rs!=null) rs.close();		
				if(pstmt!=null) pstmt.close();						
				}
				catch(Exception e)
					{
						e.printStackTrace();	
					}				
			%>
		</select><img src='../../eCommon/images/mandatory.gif' align='center' id='encType_img'></img></td>
		
		<td class="label" width="25%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%"><input type=text  name='p_encounter_id' id='p_encounter_id' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumVal(this)" align="center"></td>
		
</tr>

<tr>
	<td class="label" width='25%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}" /></td>
	<td class="fields">
		<%
		try {
			sql = "select locn_type, am_get_desc.am_care_locn_type(locn_type,'" + locale
					+ "',2) short_desc, CARE_LOCN_TYPE_IND, to_char(sysdate,'dd/mm/yyyy') sys_date from am_care_locn_type where SYS_USER_DEF_IND='S' and locn_type in ('C','N','Y') order by short_desc";

			stmt = con.createStatement();
			rst = stmt.executeQuery(sql);
		%> <select name='locationType' id='locationType' onChange='clearLocation(this)' tabindex=1>
			<option style='align: center'>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />------

				<%
				String locn_type = "";
				String short_desc = "";
				while (rst.next() && rst != null) {
					locn_type = rst.getString("CARE_LOCN_TYPE_IND");
					short_desc = rst.getString("short_desc");
					currentdate = rst.getString("sys_date");
					out.println("<option value='" + locn_type + "'>" + short_desc);
				}
				if (rst != null) rst.close();
				if (stmt != null) stmt.close();
			}
		catch(Exception e)
			{
			e.printStackTrace();	
			}	
			
	finally {
				ConnectionManager.returnConnection(con, request);
			}
	
	
				%>			
	</select>
	</td>
	<td width='8%' class='label' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}" /></td>
	<td class='fields'><input type='text' size='25' tabindex=3 maxlength='25' name='b_loc_val' id='b_loc_val' value=''
		onblur="ena_loc_lookup(this);"><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="getValues()"
		class='button' tabindex=4> </select><input type="hidden" name="blocation" id="blocation" value=""><input type="hidden" name="clinic" id="clinic" value="">
	</td>
	
</tr>

<tr>
	<td align="left" class='label'><fmt:message key="eMR.BHTStatus.label" bundle="${mr_labels}"/></td>
	<td class='fields'>
		<select name="BHTStatus" id="BHTStatus"><option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
		<option value="P"><fmt:message key="eMR.PENDING.label" bundle="${mr_labels}"/></option>
		<option value="O"><fmt:message key="eMR.OVERDUE.label" bundle="${mr_labels}"/></option>
		<option value="D"><fmt:message key="eMR.DELIVERED.label" bundle="${mr_labels}"/></option>
		<option value="R"><fmt:message key="eMR.RECEIVED.label" bundle="${mr_labels}"/> </option>
		<option value="X"><fmt:message key="eMR.RETURNED.label" bundle="${mr_labels}"/></option>
		</select>
	</td>
	
	<td align="left" class="label"><fmt:message key="eMR.DischargePeriodFrom.label" bundle="${mr_labels}"/></td>
	<td class="fields">
	<input type="text" name="periodFrom" id="periodFrom" size="10" maxlength='10' id='periodFrom'
		onblur='if(validDateObj(this,"DMY","<%=locale%>"))validateFromDate(this);'
		value="<%=SystemDate_display%>"></input><img id='period1'
		src='../../eCommon/images/CommonCalendar.gif'
		onClick="document.forms[0].periodFrom.focus();return showCalendar('periodFrom');">

	-<fmt:message key="Common.to.label" bundle="${common_labels}"/>
	<input type="text" name=periodTo size="10" maxlength='10' id='periodTo'
		onblur='if(validDateObj(this,"DMY","<%=locale%>"))validateToDate(this);'
		value="<%=SystemDate_display%>"></input><img id='period2'
		src='../../eCommon/images/CommonCalendar.gif'
		onClick="document.forms[0].periodTo.focus();return showCalendar('periodTo');">
		<img src='../../eCommon/images/mandatory.gif' />
	</td>

</tr>

<tr>
	<td width="23%" class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td width="24%" class="fields" ><input type=text name='PatientId' id='PatientId' size="" maxlength="<%=pat_id_len%>" onBlur="makeValidString(this);ChangeUpperCase(this);PatValidations(document.forms[0].PatientId);" onKeypress='return CheckForSpecChars(event);' align="center">
	<input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'>
	</td>
	
</tr>

<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
		<tr>
			</td>
			<td class="label" align="right">
			
			</td>
			<td class="label" align="right">
			
			</td>
			<td class="label" align="right">
			
			</td>
			
			<td class="label" align="right">
				<input type="button" value="Search"  class="BUTTON" onclick="getViewResult()">
				<input type="button" value="Clear" id="View_label" class="BUTTON" onclick="clearResult()">
			</td>
		</tr>

</table>
	<input type='hidden' name='loginUser' id='loginUser' value='<%=loginUser%>'>
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=OsVal%>'>
	<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='maxDaysBHTSubmission' id='maxDaysBHTSubmission' value='<%=maxDaysBHTSubmission%>'>
	
</form>
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

