<!DOCTYPE html>
<%
/*
**********************************************************
* @Module		: InPatient Management [IP]
* @Author		: SRIDHAR R 
* @Created Date	: 6 JULY 2004
**********************************************************
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,com.ehis.util.*,java.sql.*,java.text.*,eCommon.Common.*" %>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	String facility_id=(String)session.getValue("facility_id");	
	//Below line added for this CRF ML-MMOH-CRF-0566
	String loginUser = (String) session.getValue("login_user");
	String referral_to_pract="",referral_from_pract="",frm_referral_user="",to_referral_user="";
	
	String queryString = request.getQueryString(); 
	
	//End this ML-MMOH-CRF-0566
 
	Connection con			=	null;
	Statement dateStmt		=	null;
	ResultSet dateRs		=	null;
	con	= ConnectionManager.getConnection(request);
	try
	{
	    //Below line added for this CRF ML-MMOH-CRF-0566
	   	Boolean referralRegister = CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");					
        String strBodyFrame		= request.getParameter("bodyFrame");
		String strSubmitFrame	= request.getParameter("submitFrame");                
       // String callfrom = checkForNull(request.getParameter("callfrom"));  
	   //End ML-MMOH-CRF-0566
	
		String function_id	= checkForNull(request.getParameter("function_id"));  
		String encounter_ID	= checkForNull(request.getParameter("encounterid"));
		String referral_id	= checkForNull(request.getParameter("referral_id"));
		String to_fcy_pract_name	= "";
		String to_hcare_setting_desc= "";
		String to_ref_type			= ""; 
		String to_speciality_desc	= "";
		String referral_priority	= "";
		String reason_for_ref		= "";
		String pref_date			= "";
		String pref_date_display	= "";
		String ValueExample			= "";
		String speciality_code		= "";
		String allow_muti_bedside_review_yn="", besiderefferalstatus="", bedside_ref_seen_date="", bedside_ref_seen_display="", bedside_ref_review_status="",bedside_ref_review_status_select=""; //Added for this CRF HSA-CRF-146.1
	  	
		
		StringBuffer SqlSB = new StringBuffer();
//thai
/*
		SqlSB.append(" select decode (referral_priority,'L', 'Elective','U', 'Semi Emergency','E', 'Emergency','R', 'Emergency') referral_priority, from_encounter_id, bedside_referral_yn, patient_name, ref_notes, to_char(preferred_treatment_date,'dd/mm/rrrr hh:mi')preferred_treatment_date, referred_for_ip, to_facility_id, to_facility_name, to_fcy_pract_name,to_hcare_setting_desc, to_hcare_setting_type, decode(to_locn_type,'N','Nursing Unit','C','Clinic','D','Day Care')to_locn_type, to_ref_locn_desc, to_nurs_unit_code, to_nurs_unit_desc, to_clinic_desc, to_nurs_unit_locn_type,to_pract_id, to_ref_code,  to_ref_desc, to_ref_locn_desc, to_ref_pract_name, decode(to_ref_type,'L','Login Facility','E','Enterprise','X','External')to_ref_type, to_service_code, to_service_desc, to_speciality_code, to_speciality_desc, referral_reason ");
*/
        /*Below line modified for this CRF ML-MMOH-CRF-0566*/   

		SqlSB.append(" select referral_priority, to_char(preferred_treatment_date,'dd/mm/rrrr')preferred_treatment_date, to_ref_type, from_pract_id, to_pract_id,am_get_desc.AM_PRACTITIONER(TO_PRACT_ID,'"+locale+"','1') to_fcy_pract_name, am_get_desc.AM_HCARE_SETTING_TYPE(TO_HCARE_SETTING_TYPE,'"+locale+"','1') to_hcare_setting_desc,to_speciality_code,am_get_desc.AM_SPECIALITY(TO_SPECIALITY_CODE,'"+locale+"','1') to_speciality_desc, am_get_desc.AM_CONTACT_REASON(REFERRAL_REASON_CODE,'"+locale+"','1') referral_reason, to_char(bedside_ref_seen_date,'dd/mm/rrrr') bedside_ref_seen_date, bedside_ref_review_status, (select allow_muti_bedside_review_yn from ip_param where FACILITY_ID='"+facility_id+"') allow_muti_bedside_review_yn "); //Modified for this CRF HSA-CRF-146.1
		SqlSB.append(" from PR_REFERRAL_REGISTER ");
		SqlSB.append(" WHERE ");
		SqlSB.append(" from_encounter_id = '"+encounter_ID+"' AND from_facility_id = '"+facility_id+"'");
		SqlSB.append(" and referral_id = '"+referral_id+"' and bedside_referral_yn = 'Y' ");

		dateStmt	= con.createStatement();
		dateRs		= dateStmt.executeQuery(SqlSB.toString());

		if((dateRs != null) && (dateRs.next()))
		{
			pref_date				= checkForNull(dateRs.getString("preferred_treatment_date"));
			to_fcy_pract_name		= checkForNull(dateRs.getString("to_fcy_pract_name"));
			to_hcare_setting_desc	= checkForNull(dateRs.getString("to_hcare_setting_desc"));
			to_speciality_desc		= checkForNull(dateRs.getString("to_speciality_desc"));
			reason_for_ref			= checkForNull(dateRs.getString("referral_reason"));
			speciality_code			= checkForNull(dateRs.getString("to_speciality_code"));

			to_ref_type				= checkForNull(dateRs.getString("to_ref_type"));
			if (to_ref_type.equals("L"))
				to_ref_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.loginfacility.label","common_labels");
			else if (to_ref_type.equals("E"))
				to_ref_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enterprise.label","common_labels");
			else if (to_ref_type.equals("X"))
				to_ref_type = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");

			referral_priority		= checkForNull(dateRs.getString("referral_priority"));
			if(referral_priority == null) 
				referral_priority="";
			else if (referral_priority.equals("L"))
				referral_priority = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.elective.label","common_labels");
			else if (referral_priority.equals("U"))
				referral_priority = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiemergency.label","common_labels");
			else if (referral_priority.equals("E"))
				referral_priority = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
           //Added for this CRF HSA-CRF-146.1
		   bedside_ref_seen_date =checkForNull(dateRs.getString("bedside_ref_seen_date"));	 
           bedside_ref_review_status=checkForNull(dateRs.getString("bedside_ref_review_status"));  
  		   if(bedside_ref_review_status.equals("P")) bedside_ref_review_status_select="selected";
		   allow_muti_bedside_review_yn	= checkForNull(dateRs.getString("allow_muti_bedside_review_yn"),"N");           		   
		   if(allow_muti_bedside_review_yn.equals("N")) besiderefferalstatus="visibility:hidden";
            
           //Below line added for this CRF ML-MMOH-CRF-0566
		   referral_from_pract = checkForNull(dateRs.getString("from_pract_id"));
           referral_to_pract = checkForNull(dateRs.getString("to_pract_id"));
 		   
		   		        		   
		}		
		
		
		
	//Below line added for this CRF ML-MMOH-CRF-0566
	
	if(referralRegister) {
	frm_referral_user = eIP.IPCommonBean.getFromuserId(con,referral_from_pract);
	
	if(frm_referral_user==null || frm_referral_user.equals("null")) frm_referral_user="";

	to_referral_user = eIP.IPCommonBean.getTouserId(con,referral_to_pract);
	
	if(to_referral_user==null || to_referral_user.equals("null")) to_referral_user="";

	}
		
	//End this CRF ML-MMOH-CRF-0566
		
		
		
		pref_date_display = DateUtils.convertDate(pref_date,"DMY","en",locale); 
        
		/*Added for this CRF HSA-CRF-146.1	*/
	  	java.util.Date dNow = new java.util.Date();
        java.text.SimpleDateFormat ft = new java.text.SimpleDateFormat("dd/MM/yyyy");        	
		if(bedside_ref_seen_date.equals(""))bedside_ref_seen_date=ft.format(dNow);		
		bedside_ref_seen_display = DateUtils.convertDate(bedside_ref_seen_date,"DMY","en",locale);//Added for this CRF HSA-CRF-146.1	
				
		if (dateRs != null) dateRs.close();
		if (dateStmt != null) dateStmt.close();
%>
<HTML>
<HEAD>
	<TITLE><fmt:message key="Common.ConfirmBedsideReferral.label" bundle="${common_labels}"/></TITLE>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eIP/js/IPPractitionerComponent.js" language="JavaScript"></Script>	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script> 
	<script src='../../eMP/js/ReferralDtls.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!--Added for this CRF ML-MMOH-CRF-0566-->
<script>
function compareSeenDate(bedsideDate,prefDate)
{	
	if(validDateObj(bedsideDate,"DMY", localeName))
	{	
		if(prefDate.value != "")
		{			
			var greg_frdt = convertDate(bedsideDate.value,"DMY",localeName,"en");
			var greg_tdt = prefDate.value;
			var sys_dat = getCurrentDate("DMY","en");			
           /*Below Line Added for this CRF [Bru-HIMS-CRF 321]*/   			
			//if(!isBefore(sys_dat,greg_frdt,"DMY",localeName)){			  
			  if(!isBefore(sys_dat,greg_frdt,"DMY","en")){	//Modified By Dharma on 1st Oct 2015 against Leap Year Issue		  
				var error = getMessage("DATE1_LT_DATE2",'IP');
				error = error.replace("$", getLabel("eIP.BedsideReferralSeenDate.label","IP"));
				error = error.replace("#", getLabel("Common.SystemDate.label","Common"));
				alert(error);
				document.forms[0].BedSideDate.value="";
				document.forms[0].BedSideDate.focus();
				document.forms[0].BedSideDate.select();
				return false;
			}
			// if(!isAfter(sys_dat,greg_frdt,"DMY",localeName)) { 
			if(!isAfter(sys_dat,greg_frdt,"DMY","en")) {//Modified By Dharma on 1st Oct 2015 against Leap Year Issue
				var error = getMessage("DATE1_GT_DATE2",'IP');
				error = error.replace("$", getLabel("eIP.BedsideReferralSeenDate.label","IP"));
				error = error.replace("#", getLabel("Common.SystemDate.label","Common"));
				alert(error);
				document.forms[0].BedSideDate.value="";
				document.forms[0].BedSideDate.focus();
				document.forms[0].BedSideDate.select();
				return false;
			}
		}
	}
}



function BeforeGetPractitioner(obj, target)
{
	if(document.forms[0].practid_desc.value !="")
		getPractitionerLocal(obj, target);
	else
		document.forms[0].practid.value =""
}


function getPractitionerLocal(obj, target)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";

	practName_FName=target.name;
	practName_FValue=target.value;
	practId_FName=document.forms[0].practid.name;
	var facility_id		= "<%=facility_id%>";
	var locale			= "<%=locale%>";
	var speciality_code	= "<%=speciality_code%>";
	/*Thursday, July 01, 2010 , specialty code added for SSSIHMS issue , since practioner not filtered based on specialty.*/
	//getPractitioner(obj, target, facility_id, "","","Q3");
	getPractitioner(obj, target, facility_id, speciality_code,"","Q5");
 
} 

// To be called by the GeneralPractitionerSearch to set Practitioner.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr = retVal.split("~");
		document.forms[0].practid.value=arr[0];
		document.forms[0].practid_desc.value=arr[1];			
	}
	else
	{
		document.forms[0].practid.value="";
		document.forms[0].practid_desc.value="";			

	}
}
//Added for this CRF HSA-CRF-0146
async function ReferralRegAuditTrial(referral_id){		       
                var retVal = 	new String();
				var dialogHeight= "80vh" ;				
				if(document.forms[0].referralRegister && document.forms[0].referralRegister.value=="true"){
				  var dialogWidth	= "80vw" ; //Modified for this CRF ML-MMOH-CRF-0566 US3 width changed from(55) to (65) 
				}else{
				  var dialogWidth	= "80vw" ; 
				}
				var status = "no";			
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; 	scroll=auto; status:" + status; 
                retVal =await window.showModalDialog("../../eIP/jsp/ReferralRegAuditTrialFrame.jsp?referral_id="+referral_id,arguments,features);
       
	}

</script>
</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<TABLE id="referral_table" cellspacing=0 cellpadding=4 border="0" width="100%" >
	<input type="hidden" name="hddFuncID" id="hddFuncID" value="<%=function_id%>" >
	<tr>
		<!--Referral Type -->     
		<td class=label width='25%'><fmt:message key="Common.referraltype.label" bundle="${common_labels}"/></td>
        <td class=data	 width='25%'><B><%=to_ref_type%></B></td>
		<td class=label width='25%' colspan='2'></td>
	</tr>
	<tr>
		<td colspan="4" class=label ></td>
	</tr>
	<tr>
		<!--Health Care Setting --> 
		<td  class=label width='25%' nowrap><fmt:message key="Common.HealthcareSettingType.label" bundle="${common_labels}"/></td>
		<td  class=data width='25%' nowrap><B><%=to_hcare_setting_desc%></B></td>
		<td  class=label width='25%' nowrap colspan='2'></td>
	</tr>
	<tr>
		<td colspan="4" class=label ></td>
	</tr>
	<tr>
		<!--Priority --> 
		<td  class=label  width='25%' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td  class=data  width='25%' nowrap><B><%=referral_priority%></B></td>

		<!-- Pref Date --> 		
		<td  class=label  width='25%' nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></td>
		<td  class=data  width='25%' nowrap><B><%=pref_date_display%></B></td>          
		
	</tr>
	<tr>
		<td colspan="4" class=label ></td>
	</tr>
    <tr>
		<!-- Specialty --> 
		<td   class=LABEL  width='25%' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td  class=data  width='25%' nowrap><B><%=to_speciality_desc%></B></td>
		<td class=label  width='25%' nowrap></td>
		<td class=label  width='25%' nowrap></td>
	</tr>
	<tr>
		<td colspan="4" class=label ></td>
	</tr>
	<tr>
		<!--Practitioner-->
        <td  class=label  width='25%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
   		<td  class='data'  width='25%' nowrap><B><%=to_fcy_pract_name%></B></td>
		<td  class='data'  width='25%' nowrap><B><%=ValueExample%></B></td>
		<td class=label  width='25%' nowrap></td>
	</tr>
	<tr>
		<td colspan="4" class=label ></td>
	</tr> 
	<tr>
		<!--Reason for ref --> 
        <td  class=label  width='25%' nowrap><fmt:message key="Common.ReasonforReferral.label" bundle="${common_labels}"/></td>
   		<td  class=label  width='25%' nowrap><B><%=reason_for_ref%></B></td>
		<td class=label  width='25%' nowrap colspan='2'></td>
	</tr>
		<tr><td colspan="4" class=label ></td>	</tr>
		<tr><td colspan="4" class=label ></td>	</tr>
		<tr><td colspan="4" class=label ></td>	</tr>
		<tr><td colspan="4" class=label ></td>	</tr>
<%	if(function_id.equals("PRACT_FOR_BEDSIDE_REFERRAL"))
	{	%>		
		<tr>
			<td  class='label' width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid,practid_desc);" value=""><input type='hidden' name='practid' id='practid' value="" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid,practid_desc);">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td>&nbsp;</td><td>&nbsp;</td>
		</tr>
<%	}
	else
	{	%>
		<tr>
			<td class="label"   width='25%' nowrap><fmt:message key="eIP.BedsideReferralSeenDate.label" bundle="${ip_labels}"/></td>
			<td colspan="3"  class='FIELDS' >
			<input type="text" id='BedSideDateID'  name="BedSideDate" id="BedSideDate" maxlength=10 size=10  value="<%=bedside_ref_seen_display%>" onblur='compareSeenDate(this,pref_date);' ><img src="../../eCommon/images/CommonCalendar.gif"  onClick="BedSideDateID.focus();return showCalendar('BedSideDateID');"/><img src='../../eCommon/images/mandatory.gif' align='center'></img>  
			<input type='hidden' name='pref_date' id='pref_date' value="<%=pref_date%>" >
		</tr>
		<!--Below line added for this CRF  HSA-CRF-146.1-->    
         <tr>
			<td class="label"   width='25%' nowrap style="<%=besiderefferalstatus%>"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td><!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->
			<td class='FIELDS' nowrap style="<%=besiderefferalstatus%>"><select name="bedside_ref_review_status" id="bedside_ref_review_status" onchange="getReason(this.value)">
			<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			<!--Added by Thamizh selvi on 22nd Feb 2018 against ML-MMOH-CRF-1090-->
			<% if(!referral_to_pract.equals("")){ %>
				<option value='P' <%=bedside_ref_review_status_select%>><fmt:message key="eIP.SeenandTobeReviewedAgain.label" bundle="${ip_labels}"/></option><!--bundle change for PAS-MP-PMG2020-TECH-CRF-0010/01-Label Name-->
				<option value='C'><fmt:message key="eIP.SeenandClosed.label" bundle="${ip_labels}"/></option>
				<option value='N'><fmt:message key="eIP.NotSeenandClosed.label" bundle="${ip_labels}"/></option>
			<% } %>
			<!--End-->

			<!--Below line added for this CRF ML-MMOH-CRF-0566-->      
	     <%
			if(referralRegister){	
				if(!frm_referral_user.equals("") && frm_referral_user.equals(loginUser)){%>
					<option value='S'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option>
				<%}
				else if(!to_referral_user.equals("") && to_referral_user.equals(loginUser)){
				%>
					<option value='X'><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></option>
				<%}
		    }
		%>
			<!--End ML-MMOH-CRF-0566-->  
			</select><img  src='../../eMP/images/mandatory.gif' align='center' ></img></td>
		    <td class='data' width='25%' colspan="2" style="<%=besiderefferalstatus%>"> <a href="#" onclick="ReferralRegAuditTrial('<%=referral_id%>')"><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/> </a></td>
		  </tr>		  
		<!--End this CRF HSA-CRF-146.1-->
		<!--Below line added for this CRF ML-MMOH-CRF-0566-->
		<%if(referralRegister){%>
		<tr>
			<td class="label" width='25%' nowrap ><span id="referral_reg" name="referral_reg" style="visibility:hidden"></span></td>
			<td colspan="3" class='FIELDS'><select name="referral_reg_id" id="referral_reg_id" id="referral_reg_id" style="visibility:hidden">
			<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
			</select><img src='../../eCommon/images/mandatory.gif' align='center' name="ref_reg_id" id="ref_reg_id" style="visibility:hidden"></td>
		</tr>
		<%}%>
		<!--End this CRF ML-MMOH-CRF-0566-->
		
<%	}	%>
<!--Below line added for this CRF CRF HSA-CRF-146.1-->
<input type="hidden" name="allow_muti_bedside_review_yn" id="allow_muti_bedside_review_yn" value="<%=allow_muti_bedside_review_yn%>">
<!--Below line added for this CRF ML-MMOH-CRF-0566-->
<input type="hidden" name="referralRegister" id="referralRegister" value="<%=referralRegister%>">
<input type='hidden' name='hddBodyFrame' id='hddBodyFrame' value='<%=strBodyFrame%>'>
<input type='hidden' name='hddSubmitFrame' id='hddSubmitFrame' value='<%=strSubmitFrame%>'>
</TABLE> 

<%
	out.println("<script>if(document.forms[0].BedSideDate)document.forms[0].BedSideDate.focus();</script>");

	}catch(Exception e) 
	{
		out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

</BODY>
</HTML>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

