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
<script language='javascript' src='../../eBL/js/BLApprStatusTrackSearch.js'></script>


<script type="text/javascript">

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
.reload {
  font-size:28px;
  font-family: verdana;
  text-align: right;
}

</style>
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
	String funct_name = request.getParameter("funct_name");
	String sql="";
	String sysdtsql = "";
	String sqlDate = "";
	String refreshSql= "";
	String refresh = "";
	int pat_id_len= 0;
try{
	
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
	
	refreshSql="select auto_refresh_min from BL_PARAMETERS where OPERATING_FACILITY_ID = '"+facility_id+"' ";
	
	pstmt = con.prepareStatement(refreshSql);

	rs = pstmt.executeQuery();
	if (rs != null && rs.next() )
	{
		refresh=rs.getString(1);
		if(refresh == null)
			refresh = "";
	}
	} catch(Exception e) {
		out.println(e.toString());
		e.printStackTrace();
		}
	finally 
	{
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

	int defaultDate = 7;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	String todaysDate=dateFormat.format(cal.getTime());
	cal.add(Calendar.DATE, -(defaultDate-1)); 
	String sevenDaysBeforeDate=dateFormat.format(cal.getTime());
	String rights="";
	String validInsUser = checkForNull(request.getParameter("validInsUser"));
	String validFrontUser = checkForNull(request.getParameter("validFrontUser"));
	rights = checkForNull(request.getParameter("rights"));
	
	if(rights.equals("")){
	if(validInsUser.equals("Y") && validFrontUser.equals("Y"))
	{
		rights = "S";
	}
	else if(validInsUser.equals("Y"))
	{
		rights = "I";
	}
	else if(validFrontUser.equals("Y"))
	{
		rights = "F";
	}
	}
%>
<script>


</script>

<BODY onload = "rightsTypeOnChange();" onKeyDown="lockKey();" onMouseDown="CodeArrest();"
	onSelect="codeArrestThruSelect();" >
	<FORM method='post' name="search" id="search" id="search" action=""
		onsubmit="return onSearch()" >
		<!--<p  style="text-align:right;" >Auto Refresh Every <%=refresh%> mins &#x27F3;</p>-->
		<table cellpadding='3' cellspacing=0 width="100%" align="center">
		<tr>
			<td colspan="9"></td>
<%
		if(!"".equals(refresh)){
%>			
			<td class="label" style = "text-align: right;font-weight: bold;">[Auto Refresh Every <%=refresh%> mins &#x27F3;]</td>
<%
		}else{
%>	
			<td class="label" style = "text-align: right;font-weight: bold;">[Auto Refresh for dashboard not defined]</td>
<%
		}
%>		
		</tr>
		<tr>
			    <td class="label"  colspan="3"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td><input type="text" name="patient_id" id="patient_id" id="patient_id" maxlength="<%=pat_id_len %>" onBlur="ChangeUpperCase( this ),primaryPatValidation(this);if(this.value == ''){ patient_name.value=''; return PatientIdLookup(); }"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return PatientIdLookup()" tabindex='2' />
				</td>
				<td>
				&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td class="label" ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				<td><input type="text" name="patient_name" id="patient_name" id="patient_name" readonly   maxlength="100"  onBlur="ChangeUpperCase( this );"     onKeyPress="return CheckForSpecChars(event);lockbackSpace();" onfocus="ChangeUpperCase( this );" >	
				</td>
				<td>
				&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td class="label" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td><input type="text" name="encounter_id" id="encounter_id" id="encounter_id"   maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){enCounterIdLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return enCounterIdLookup()"  tabindex='2'>
				</td>
		</tr>
		<tr>
				
				<td class="label"  colspan="3"><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
				<td><select id="epiType" name='episode_type' id='episode_type' >
				<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
				<option value='I'><fmt:message key="Common.inpatient.label" bundle="${common_labels}" /></option>
				<option value='D'><fmt:message key="Common.daycare.label" bundle="${common_labels}" /></option>
				<option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}" /></option>
				<option value='O'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}" /></option>
				</select>
				</td>
				<td>
				&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td class="label" ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
				<td><input type="text" name="payer_group" id="payer_group" id="payer_group" maxlength="30"  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerGroupLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerGroupLookup()"  tabindex='2' /> 
				</td>
				<td>
				&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td class="label" ><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
				<td><input type="text" name="payer" id="payer" id="payer" maxlength="30"  onBlur="ChangeUpperCase( this );if(this.value!=''){ payerLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return payerLookup()"  tabindex='2' />
				</td>

		</tr>
		<tr>
				<td class="label"  colspan="3"><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
				<td><input type="text" name="policy" id="policy" id="policy"    maxlength="100"  onBlur="ChangeUpperCase( this );if(this.value!=''){ policyLookup();}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >	
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return policyLookup()"  tabindex='2'/>
				</td>
				<td>
				&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td class="label"><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/> 
				<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td><input type='text' name='Effective_from' id='Effective_from' id="Effective_from" maxlength="10" onBlur="isValidDate(this);"		value="<%=sevenDaysBeforeDate%>">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_from');"  onKeyPress="return lockbackSpace();">
				<span class='mandHide'><img  src='../../eCommon/images/mandatory.gif'></span>
				</td>
				<td>
				&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td class="label"><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/>
				<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td ><input type='text' name='Effective_to' id='Effective_to' id="Effective_to" maxlength="10" onBlur="isValidDate(this);" value="<%=todaysDate%>">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('Effective_to');"  onKeyPress="return lockbackSpace();">
				<span class='mandHide'><img  src='../../eCommon/images/mandatory.gif'></span>
				</td>

		</tr>
		<tr>
				<td class='label' colspan="3"><fmt:message key="eBL.USER_TYPE.label" bundle="${bl_labels}"/></td>
				<td>
				<select id="rightsType" name="rightsType" id="rightsType" onchange='rightsTypeOnChange()'>
				<option value='S' <%=rights.equals("S")?"selected":""%>>----<fmt:message key="Common.defaultSelect.label"bundle="${common_labels}" />----</option>
				<option value='I' <%=rights.equals("I")?"selected":""%>><fmt:message key="eBL.InsuranceTeam.label" bundle="${bl_labels}"/></option>
				<option value='F' <%=rights.equals("F")?"selected":""%>><fmt:message key="eBL.FrontOffTeam.label" bundle="${bl_labels}"/></option>
				</select>			
				</td>
				<td colspan="3"></td>
				<td>
				&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
				&nbsp;
				</td>
				<td class='button'>
				<input type='button' name="search_button" id="search_button" id='search_button'	value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label", "common_labels")%>"
					class='button' onClick='onSearch();'>
				</td>
		</tr>
			
		</table>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='funct_name' id='funct_name' id='funct_name' value='<%=funct_name %>'>
		<input type='hidden' name='todaysDate' id='todaysDate' id='todaysDate' value='<%=todaysDate%>'>
		<input type='hidden' name='rights' id='rights' value='<%=rights%>'>
		<input type='hidden' name='validInsUser' id='validInsUser' value='<%=validInsUser%>'>
		<input type='hidden' name='validFrontUser' id='validFrontUser' value='<%=validFrontUser%>'>
		<input type='hidden' name='sysdate' id='sysdate' value='<%=sqlDate%>'>
		<input type='hidden' name='refresh' id='refresh' value='<%=refresh%>'>
		<input type='hidden' name = "next_refr_time"  id = "next_refr_time" >
		<input type='hidden' name = "popup_opened_yn"  id = "popup_opened_yn" value="N">

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



