<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%	
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBPTHST" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id				= (String)session.getValue("responsibility_id");

	Connection con =null;
	PreparedStatement pstmt = null;
	ResultSet rs=null ;
	String lpd="";
	String purgedUntil = "";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt=new java.util.Date();
	String d = dateFormat.format( dt ) ;
	String module			="";
	String Hist_Sex			="";
	String Hist_Birth		="";
	String Hist_Legal		="";
	String Hist_Alias		="";
	String Hist_Address		="";
	String Hist_Occ_Empl	="";	
	String Hist_Susp_Reins	="";
	String Hist_Inac_Acti	="";
	String Hist_Rec_Rev		="";
	String ID1_Type		=	"";
	String ID2_Type		=	"";
	String ID3_Type		=	"";
	String ID4_Type		=	"";
	String Nationality_hist_yn	=	"";
	String Alt_id1_hist_yn		=	"";
	String Alt_id2_hist_yn		=	"";
	String Alt_id3_hist_yn		=	"";
	String Alt_id4_hist_yn		=	"";
	int count	=	0;
	String Alt_id1_desc = "";
	String Alt_id2_desc = "";
	String Alt_id3_desc = "";
	String Alt_id4_desc = "";
	String family_hist_link_yn = "";
	String org_memeber_hist_yn = "";
	String pat_cat_hist_yn = "";
	String family_no_link_yn = "";
	String family_org_id_accept_yn = "";
	String nat_id_prompt = "";
	String nat_id_hist_yn = "";
	String birth_place_code_hist_yn = "";
	String disabled_f_n_link = "";
	String disabled_f_org = "";
	String pat_series_yn="";
   //added by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]
	String old_file_no_yn="";
	
	try
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("select to_char(purged_date,'dd/MM/yyyy'), to_char(cut_off_date, 'dd/mm/yyyy')  from mp_pat_chng_hist_purge_log where purge_log_ref_id = (select max(purge_log_ref_id) from mp_pat_chng_hist_purge_log)");
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			lpd=rs.getString(1);
			if(lpd==null) lpd="";
			purgedUntil = rs.getString(2);
			if(purgedUntil==null) purgedUntil="";
		}
		lpd=DateUtils.convertDate(lpd,"DMY","en",localeName);
		purgedUntil=DateUtils.convertDate(purgedUntil,"DMY","en",localeName);
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		
		pstmt = con.prepareStatement("Select MODULE_ID,old_file_no_yn, SEX_HIST_YN,PAT_SER_GRP_HIST_YN, BIRTH_DATE_HIST_YN, LEGAL_NAME_HIST_YN, ALIAS_NAME_HIST_YN, ADDRESS_HIST_YN, OCPN_N_EMPL_HIST_YN,SUSPEND_REINSTATE_HIST_YN, INACT_ACT_HIST_YN, REC_REVOKE_DEATH_HIST_YN,NATIONALITY_HIST_YN,ALT_ID1_HIST_YN,ALT_ID2_HIST_YN,ALT_ID3_HIST_YN,ALT_ID4_HIST_YN,ALT_ID1_TYPE,ALT_ID2_TYPE,ALT_ID3_TYPE,ALT_ID4_TYPE,FAMILY_LINK_HIST_YN,ORG_MEMBER_HIST_YN,PAT_CAT_HIST_YN,FAMILY_NO_LINK_YN,FAMILY_ORG_ID_ACCEPT_YN,nvl(nat_id_prompt,'National ID No') NAT_ID_PROMPT,NAT_ID_HIST_YN,BIRTH_PLACE_CODE_HIST_YN from mp_param");
		rs = pstmt.executeQuery();
		
		rs.next();
		module	= checkForNull(rs.getString("MODULE_ID"));
		Hist_Sex = checkForNull(rs.getString("SEX_HIST_YN"));
		pat_series_yn=checkForNull(rs.getString("PAT_SER_GRP_HIST_YN"));
		Hist_Birth = checkForNull(rs.getString("BIRTH_DATE_HIST_YN"));
		Hist_Legal = checkForNull(rs.getString("LEGAL_NAME_HIST_YN"));
		Hist_Alias = checkForNull(rs.getString("ALIAS_NAME_HIST_YN"));
		Hist_Address = checkForNull(rs.getString("ADDRESS_HIST_YN"));
		Hist_Occ_Empl = checkForNull(rs.getString("OCPN_N_EMPL_HIST_YN"));
		Hist_Susp_Reins = checkForNull(rs.getString("SUSPEND_REINSTATE_HIST_YN"));
		Hist_Inac_Acti = checkForNull(rs.getString("INACT_ACT_HIST_YN"));
		Hist_Rec_Rev = checkForNull(rs.getString("REC_REVOKE_DEATH_HIST_YN"));
		ID1_Type=checkForNull(rs.getString("ALT_ID1_TYPE"));		
		ID2_Type=checkForNull(rs.getString("ALT_ID2_TYPE"));
		ID3_Type=checkForNull(rs.getString("ALT_ID3_TYPE"));
		ID4_Type=checkForNull(rs.getString("ALT_ID4_TYPE"));
		Nationality_hist_yn	=	checkForNull(rs.getString("NATIONALITY_HIST_YN"));
		Alt_id1_hist_yn		=	checkForNull(rs.getString("ALT_ID1_HIST_YN"));
		Alt_id2_hist_yn		=	checkForNull(rs.getString("ALT_ID2_HIST_YN"));
		Alt_id3_hist_yn		=	checkForNull(rs.getString("ALT_ID3_HIST_YN"));
		Alt_id4_hist_yn		=	checkForNull(rs.getString("ALT_ID4_HIST_YN"));
		family_hist_link_yn		=	checkForNull(rs.getString("FAMILY_LINK_HIST_YN"));
		org_memeber_hist_yn		=	checkForNull(rs.getString("ORG_MEMBER_HIST_YN"));
		pat_cat_hist_yn		=	checkForNull(rs.getString("PAT_CAT_HIST_YN"));
		family_no_link_yn		=	checkForNull(rs.getString("FAMILY_NO_LINK_YN"));
		family_org_id_accept_yn		=	checkForNull(rs.getString("FAMILY_ORG_ID_ACCEPT_YN"));
		nat_id_hist_yn		=	checkForNull(rs.getString("NAT_ID_HIST_YN"));
		nat_id_prompt		=	checkForNull(rs.getString("NAT_ID_PROMPT"));		
		birth_place_code_hist_yn	=	checkForNull(rs.getString("BIRTH_PLACE_CODE_HIST_YN"));		
        //modified by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]
		old_file_no_yn	=	rs.getString("old_file_no_yn");
		if(ID1_Type != null)
			count++;
		if(ID2_Type != null)
			count++;
		if(ID3_Type != null)
			count++;
		if(ID4_Type != null)
			count++;

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		if(!ID1_Type.equals("")){		
			pstmt = con.prepareStatement("Select long_desc from MP_ALTERNATE_ID_TYPE where alt_id_type = '"+ID1_Type+"'");
			rs = pstmt.executeQuery();
			if(rs.next())				
				Alt_id1_desc =checkForNull(rs.getString("long_desc"));		
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		if(!ID2_Type.equals("")){		
			pstmt = con.prepareStatement("Select long_desc from MP_ALTERNATE_ID_TYPE where alt_id_type = '"+ID2_Type+"'");
			rs = pstmt.executeQuery();
			if(rs.next())				
				Alt_id2_desc = checkForNull(rs.getString("long_desc"));	
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		if(!ID3_Type.equals("")){		
			pstmt = con.prepareStatement("Select long_desc from MP_ALTERNATE_ID_TYPE where alt_id_type = '"+ID3_Type+"'");
			rs = pstmt.executeQuery();
			if(rs.next())				
				Alt_id3_desc =checkForNull(rs.getString("long_desc"));	
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		if(!ID4_Type.equals("")){		
			pstmt = con.prepareStatement("Select long_desc from MP_ALTERNATE_ID_TYPE where alt_id_type = '"+ID4_Type+"'");
			rs = pstmt.executeQuery();
			if(rs.next())				
				Alt_id4_desc =checkForNull(rs.getString("long_desc"));		
		}
		if(pstmt !=null) pstmt.close();
		if(rs!=null) rs.close();

	}
	catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}
	finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	if(family_no_link_yn.equals("Y"))
		disabled_f_n_link="";
   else
		disabled_f_n_link="disabled";
	if(family_org_id_accept_yn.equals("Y"))
		disabled_f_org="";
	else
		disabled_f_org="disabled";
	
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eMP/js/Mp_PurgeAudit.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
		function callMethod(event)
		{
			var whichCode = (window.Event) ? event.which : event.keyCode;
			if (whichCode == 13) return false; 
		}
</script>
</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="mp_purge_audit_form" id="mp_purge_audit_form" action="../../servlet/eMP.mpPurgeAuditServlet" method="post" target="messageFrame">
 <table border="0" cellpadding="3" cellspacing="0" width="50%" align='center'>
 <tr>
	  <td> &nbsp; </td>
      <td align="left" class="label"><fmt:message key="eMP.LastPurgedDate.label" bundle="${mp_labels}"/></td>
      <td class='querydata'><%=lpd%></td>
  	  <td> &nbsp; </td>
 </tr>
 <tr>
	  <td> &nbsp; </td>
      <td align="left" class="label"><fmt:message key="eMP.PurgedUntil.label" bundle="${mp_labels}"/></td>
      <td class='querydata'><%=purgedUntil%></td>
  	  <td> &nbsp; </td>
 </tr>
 <tr>
  	  <td>&nbsp;</td>
      <td align="left" class="label"><fmt:message key="eMP.PurgeChangesupto.label" bundle="${mp_labels}"/></td>
      <td class="fields"><INPUT TYPE="text" id='mppurgefrom' name="Purge_Date" id="Purge_Date" size=10 maxlength=10 onblur = 'validDateObj(this,"DMY",localeName);' onKeyPress="return callMethod(event)"   value=''><img align=center src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mppurgefrom');"><img align=center src='../images/mandatory.gif'></img></td>
 	  <td> &nbsp; </td>
</tr> 
</table>		
<br>
<table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
<tr>
		<td class="label" width="35%"><fmt:message key="eMP.PatientSex.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="Sex_yn" id="Sex_yn" value='<%=Hist_Sex%>' <%if(Hist_Sex.equals("Y")) {%> checked <%}%>   ></td>

		<td class="label" width="35%"><fmt:message key="eMP.PatientDateofBirth.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="BirthDate_yn" id="BirthDate_yn" value='<%=Hist_Birth%>' <%if(Hist_Birth.equals("Y")) {%> checked <%}%> ></td>
 </tr>
 <tr><td colspan='4'>&nbsp;</td></tr>
</table>
<br>
<table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
<tr>
		<td class="label" width="35%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="LegalName_yn" id="LegalName_yn" value='<%=Hist_Legal%>' <%if(Hist_Legal.equals("Y")) {%> checked <%}%>></td>

		<td class="label" width="35%"><fmt:message key="eMP.AliasName.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="AliasName_yn" id="AliasName_yn" value='<%=Hist_Alias%>' <%if(Hist_Alias.equals("Y")) {%> checked <%}%>></td>
</tr>
<tr> <td colspan='4'>&nbsp;</td></tr>
</table>
<br>
<table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
<tr>
		<td class="label" width="35%"><fmt:message key="eMP.FamilyLink.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="FamilyLink_yn" id="FamilyLink_yn" value='<%=family_hist_link_yn%>' <%=disabled_f_n_link%> <%if(family_hist_link_yn.equals("Y")) {%> checked <%}%>   ></td>

		<td class="label" width="35%"><fmt:message key="eMP.OrganizationMembership.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="Oraganization_mem_yn" id="Oraganization_mem_yn" value='<%=org_memeber_hist_yn%>' <%=disabled_f_org%> <%if(org_memeber_hist_yn.equals("Y")) {%> checked <%}%> ></td>
 </tr>
 <tr> <td colspan='4'>&nbsp;</td></tr>
 </table>
 <br>
<table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
<tr>
		<td class="label" width="35%"><fmt:message key="Common.Address.label" bundle="${common_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="Address_yn" id="Address_yn" value='<%=Hist_Address%>' <%if(Hist_Address.equals("Y")) {%> checked <%}%>   ></td>

		<td class="label" width="35%"><fmt:message key="eMP.OccupationEmployer.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="OcpnEmpl_yn" id="OcpnEmpl_yn" value='<%=Hist_Occ_Empl%>' <%if(Hist_Occ_Empl.equals("Y")) {%> checked <%}%> ></td>
 </tr>
 <tr> 
	   <td class="label" width="35%"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
		<td  width="15%" class="fields"><input type="checkbox" name="Nationality_hist_yn" id="Nationality_hist_yn" value='<%=Nationality_hist_yn%>' <%if (Nationality_hist_yn != null)if(Nationality_hist_yn.equals("Y")) {%> checked <%}%> ></td>

		<td class="label" width="35%"><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="Category_yn" id="Category_yn" value='<%=pat_cat_hist_yn%>' <%if (Nationality_hist_yn != null)if(pat_cat_hist_yn.equals("Y")) {%> checked <%}%> ></td>
  </tr>
   <tr> 
	   <td class="label" align="left" width="35%"><%=nat_id_prompt%></td>
		<td align="left" width="15%"><input type="checkbox" name="NatId_yn" id="NatId_yn" value='<%=nat_id_hist_yn%>' <%if (Nationality_hist_yn != null)if(nat_id_hist_yn.equals("Y")) {%> checked <%}%> ></td>

		<td class="label" align="left" width="35%"><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
		<td align="left" width="15%"><input type="checkbox" name="BirthPlace_yn" id="BirthPlace_yn" value='<%=birth_place_code_hist_yn%>' <%if (Nationality_hist_yn != null)if(birth_place_code_hist_yn.equals("Y")) {%> checked <%}%> ></td>
	</tr>
	<tr><td colspan='4'>&nbsp;</tr>
</table>
<br>
<table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
<tr>
		<td class="label" width="35%"><fmt:message key="eMP.SuspendReinstatePatient.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="SuspendReinstate_yn" id="SuspendReinstate_yn" value='<%=Hist_Susp_Reins%>' <%if(Hist_Susp_Reins.equals("Y")) {%> checked <%}%>  ></td>

		<td class="label" width="35%"><fmt:message key="eMP.ActivateInactivatePatient.label" bundle="${mp_labels}"/></td>
		<td width="15%" class="fields"><input type="checkbox" name="InactiveActivate_yn" id="InactiveActivate_yn" value='<%=Hist_Inac_Acti%>' <%if(Hist_Inac_Acti.equals("Y")) {%> checked <%}%> ></td>
 </tr>
 <tr>
		<td class="label" nowrap width="35%"><fmt:message key="eMP.RecordRevokePatientDeath.label" bundle="${mp_labels}"/></td>
		<td width="15%" colspan='3' class="fields"><input type="checkbox" name="RecordRevoke_yn" id="RecordRevoke_yn" value='<%=Hist_Rec_Rev%>' <%if(Hist_Rec_Rev.equals("Y")) {%> checked <%}%>  ></td>
 </tr>
 <tr><td colspan='4'>&nbsp;</td></tr>
 </table>
 <br>
 <table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
 <tr> 
		<td class="label" width="35%"><%=Alt_id1_desc%></td>
		<td width="15%" class="fields"><input type="checkbox" name="alt_id1_hist_yn" id="alt_id1_hist_yn" value='<%=Alt_id1_hist_yn%>' <%if(Alt_id1_hist_yn != null)if(Alt_id1_hist_yn.equals("Y")) {%> checked <%}%>></td>

		<%
		if(ID2_Type != null && ID2_Type != "")
		{
		%>
		<td class="label" width="35%"><%=Alt_id2_desc%></td>
		<td width="15%" class="fields"><input type="checkbox" name="alt_id2_hist_yn" id="alt_id2_hist_yn" value='<%=Alt_id2_hist_yn%>' <%if(Alt_id2_hist_yn != null)if(Alt_id2_hist_yn.equals("Y")) {%> checked <%}%>></td>
	  
		<%
		}else{%>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<%}%>
</tr>
<%
		if( (count == 3) && ( ID2_Type != null))
		{
		%>		
		<tr>
		<%
		}		
		if(ID3_Type != null && ID3_Type != "")
		{
		%>
		<td class="label" width="35%"><%=Alt_id3_desc%></td>
		<td width="15%" class="fields"><input type="checkbox" name="alt_id3_hist_yn" id="alt_id3_hist_yn" value='<%=Alt_id3_hist_yn%>' <%if(Alt_id3_hist_yn != null)if(Alt_id3_hist_yn.equals("Y")) {%> checked <%}%>   ></td>
		<%
		}else{%>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<%}

		if((count == 3) && ( ID3_Type != null) && (ID4_Type != null))
		{
		%>
		<tr>
		<%
		}

		if(ID4_Type != null && ID4_Type != "")
		{
		%>
		<td class="label" width="35%"><%=Alt_id4_desc%></td>
		<td width="15%" class="fields"><input type="checkbox" name="alt_id4_hist_yn" id="alt_id4_hist_yn" value='<%=Alt_id4_hist_yn%>' <%if(Alt_id4_hist_yn != null)if(Alt_id4_hist_yn.equals("Y")) {%> checked <%}%>></td>		
		<%
		}else{%>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<%}

		if((count ==1) ||(count ==3))
		{
		%>
			<td colspan='2'>&nbsp;</td>
		<%
		}
		%>
		</tr>

	<tr> <td colspan='4'>&nbsp;</td> </tr>
</table>
<br>
<table border="0" cellpadding="0" cellspacing="0" width="80%" align='center'>
<tr>
		<td class="label" width="35%"><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td> 
		<td width="15%" class="fields">
		<% if(pat_series_yn.equals("Y")) {%> 
			<input type="checkbox" name="patseries_yn" id="patseries_yn" value='Y' checked></td>
		<%} else {%>
			<input type="checkbox" name="patseries_yn" id="patseries_yn" value='N'></td>
		<%}%>
                    <!--modified by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]-->

		<td class="label" width="35%"><fmt:message key="Common.OldFileNo.label" bundle="${common_labels}"/></td> 
		<td width="15%" class="fields">
		<% if(old_file_no_yn.equals("Y")) {%> 
		<input type="checkbox" name="oldfileNo_yn" id="oldfileNo_yn" value='Y' checked></td></tr>
         <%} else {%>
         <input type="checkbox" name="oldfileNo_yn" id="oldfileNo_yn" value='N'></td></tr>
<%}%>
</table>


<input type='hidden' name='system_date' id='system_date' value='<%=d%>'>
<input type='hidden' name='last_purge_date' id='last_purge_date' value='<%=lpd%>'>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">

 <script>mp_purge_audit_form.Purge_Date.focus()</script> 
<INPUT type='hidden' name='purgedUntil' id='purgedUntil' value='<%=purgedUntil%>'>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

