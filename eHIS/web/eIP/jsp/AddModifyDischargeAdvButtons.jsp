<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<HEAD>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
 	<script src="../js/CancelAdmission.js" language="JavaScript"></Script> 
 	<script src="../js/DischargeAdvice.js" language="JavaScript"></Script> 
	<script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	var isShift = false;


function setShift()
	{
		var keyCode=window.event.keyCode;
		if(keyCode == 16) isShift=true;
	}

function shift_tab(){
		var keyCode=window.event.keyCode;
		if(keyCode == 9 && isShift == true){
			
			parent.frames[3].document.getElementById('close').focus();
	
		}
		
	}

	
	</script>
<!-- 	 -->
</HEAD>
<%	
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rs			= null;
	String ca_install_yn	= "N";
	String mr_install_yn	= "N";
	String mo_install_yn	= "N";
	String invoke_death_reg_yn	= "N";
	String access_yn	= "N";
	String facilityId	= (String)session.getValue("facility_id");
	String loginUser	= (String)session.getValue("login_user");
	String nursingunitcode 		= checkForNull(request.getParameter("nursingunitcode"));
	String oper_stn_id	="";
    
	//Added for this CRF ML-MMOH-CRF-0688
	String death_reg_mandatory_yn	= "N"; 
	String enable_dis_diagnosis_yn  = "N"; //ADDED BY SUJI KEERTHI ON 26-MAR-2020 FOR MOHE-CRF-0014
	
	//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
	Boolean isMDSForMainProcAppl = false;
	
	//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
	Boolean isDeceasedDiagClassDeathRegAppl = false;
	String primary_diag_class = "";
	String pri_mand_postmortem_ip_yn = "N";
	String pri_mand_postmortem_dc_yn = "N";
	String pri_mand_non_postmortem_ip_yn = "N";
	String pri_mand_non_postmortem_dc_yn = "N";
	String secondary_diag_class = "";
	String sec_mand_postmortem_ip_yn = "N";
	String sec_mand_postmortem_dc_yn = "N";
	String sec_mand_non_postmortem_ip_yn = "N";
	String sec_mand_non_postmortem_dc_yn = "N";

	try
	{
		con = ConnectionManager.getConnection(request);

		//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
		isMDSForMainProcAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MDS_FOR_MAIN_PROCEDURE");

		isDeceasedDiagClassDeathRegAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","DECEASED_DIAG_CLASS_DEATH_REG");//Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742

		//To Enable/Disable Discharge Diagnosis Button ... 
		StringBuffer CAinstall = new StringBuffer();
		CAinstall.append("SELECT install_yn FROM sm_module WHERE module_id = 'CA'");
		stmt	= con.createStatement();
		rs		= stmt.executeQuery(CAinstall.toString());	

		if ((rs != null) && (rs.next()))
			ca_install_yn = rs.getString("install_yn");
		
		if(ca_install_yn  == null) ca_install_yn ="N";
		if(rs	 != null)   rs.close();


		rs		= stmt.executeQuery("SELECT install_yn FROM sm_module WHERE module_id = 'MR'");	
		if ((rs != null) && (rs.next()))
			mr_install_yn = rs.getString("install_yn");
		if(mr_install_yn  == null) mr_install_yn ="N";
		if(rs	 != null)   rs.close();

		rs		= stmt.executeQuery("SELECT install_yn FROM sm_module WHERE module_id = 'MO'");	
		if ((rs != null) && (rs.next()))
			mo_install_yn = rs.getString("install_yn");
		if(mo_install_yn  == null) mo_install_yn ="N";
		if(rs	 != null)   rs.close();
       
	    /*Below line added for this CRF ML-MMOH-CRF-0688*/
		//Modified by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742
		rs	= stmt.executeQuery(" SELECT a.allow_invoke_maintn_dth_reg_yn, a.death_register_mandatory_yn, a.enable_disch_diagnosis_yn, b.primary_diag_class, b.pri_mand_postmortem_ip_yn, b.pri_mand_postmortem_dc_yn, b.pri_mand_non_postmortem_ip_yn, b.pri_mand_non_postmortem_dc_yn, b.secondary_diag_class, b.sec_mand_postmortem_ip_yn, b.sec_mand_postmortem_dc_yn, b.sec_mand_non_postmortem_ip_yn, b.sec_mand_non_postmortem_dc_yn FROM ip_param a, mr_parameter b WHERE a.facility_id = '"+facilityId+"' ");	
		if ((rs != null) && (rs.next())) {
			invoke_death_reg_yn = rs.getString("allow_invoke_maintn_dth_reg_yn");
		    if(invoke_death_reg_yn  == null) invoke_death_reg_yn ="N";
			
			death_reg_mandatory_yn = rs.getString("death_register_mandatory_yn");
		    if(death_reg_mandatory_yn  == null) death_reg_mandatory_yn ="N";
		    
		    enable_dis_diagnosis_yn = rs.getString("enable_disch_diagnosis_yn"); //ADDED BY SUJI KEERTHI ON 26-MAR-2020 FOR MOHE-CRF-0014
		    if(enable_dis_diagnosis_yn  == null) enable_dis_diagnosis_yn ="N";

			primary_diag_class = rs.getString("primary_diag_class");
		    if(primary_diag_class == null) primary_diag_class = "";

			pri_mand_postmortem_ip_yn = rs.getString("pri_mand_postmortem_ip_yn");
		    if(pri_mand_postmortem_ip_yn == null) pri_mand_postmortem_ip_yn = "N";

			pri_mand_postmortem_dc_yn = rs.getString("pri_mand_postmortem_dc_yn");
		    if(pri_mand_postmortem_dc_yn == null) pri_mand_postmortem_dc_yn = "N";

			pri_mand_non_postmortem_ip_yn = rs.getString("pri_mand_non_postmortem_ip_yn");
		    if(pri_mand_non_postmortem_ip_yn == null) pri_mand_non_postmortem_ip_yn = "N";

			pri_mand_non_postmortem_dc_yn = rs.getString("pri_mand_non_postmortem_dc_yn");
		    if(pri_mand_non_postmortem_dc_yn == null) pri_mand_non_postmortem_dc_yn = "N";

			secondary_diag_class = rs.getString("secondary_diag_class");
		    if(secondary_diag_class == null) secondary_diag_class = "";

			sec_mand_postmortem_ip_yn = rs.getString("sec_mand_postmortem_ip_yn");
		    if(sec_mand_postmortem_ip_yn == null) sec_mand_postmortem_ip_yn = "N";

			sec_mand_postmortem_dc_yn = rs.getString("sec_mand_postmortem_dc_yn");
		    if(sec_mand_postmortem_dc_yn == null) sec_mand_postmortem_dc_yn = "N";

			sec_mand_non_postmortem_ip_yn = rs.getString("sec_mand_non_postmortem_ip_yn");
		    if(sec_mand_non_postmortem_ip_yn == null) sec_mand_non_postmortem_ip_yn = "N";

			sec_mand_non_postmortem_dc_yn = rs.getString("sec_mand_non_postmortem_dc_yn");
		    if(sec_mand_non_postmortem_dc_yn == null) sec_mand_non_postmortem_dc_yn = "N";
		}		
		//End this CRF ML-MMOH-CRF-0688
		
		if(rs	 != null)   rs.close();		

		rs		= stmt.executeQuery("select a.oper_stn_id oper_stn_id from AM_OPER_STN a, AM_USER_FOR_OPER_STN b where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id	and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"' and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ");	
		 if ((rs != null) && (rs.next()))
			{
				oper_stn_id	 = checkForNull(rs.getString("oper_stn_id"));
			}
		if(oper_stn_id  == null) oper_stn_id ="";
		if(rs	 != null)   rs.close();		
			
			rs		= stmt.executeQuery("SELECT maintain_death_register_yn FROM am_os_user_locn_access_vw b WHERE b.facility_id =  '"+facilityId+"' AND locn_code = '"+nursingunitcode+"'  AND b.oper_stn_id = '"+oper_stn_id+"'  AND b.appl_user_id = '"+loginUser+"' ");	
		 if ((rs != null) && (rs.next()))
			{
				access_yn	 = checkForNull(rs.getString("maintain_death_register_yn"));
			}
		if(access_yn  == null) access_yn ="";
		if(rs	 != null)   rs.close();	
		
		if(stmt	 != null)   stmt.close();
%>
	<BODY onKeyDown='lockKey();setShift();'>
	<form name='Discahrge_button_form' id='Discahrge_button_form' onMouseDown="CodeArrest()" onKeyDown="lockKey();">
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' >
		<tr>
			 <td class='fields' width="80%" colspan='2'>
				<input type=button class='button' name = 'family' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientDetails.label","common_labels")%>'   onClick='getPatientFamily()' disabled >
			<%	if (ca_install_yn.equals("Y") && enable_dis_diagnosis_yn.equals("Y"))
				{	%>
					<input type=button class='button' name = 'diagnosis' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.DischargeDiagnosis.label","ip_labels")%>' onclick="callFunctions('DD')">
			<%	}	%>
			<%	if (mr_install_yn.equals("Y"))
				{	%>
				<!--<input type="button"  class= 'button' name="Medical_Certificate" id="Medical_Certificate" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.certificate.label","common_labels")%>" onClick ="OpenMedCert()" id="medical_certificate" >-->
			<%	}	%>
			
			<!--Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1-->
			<%if(isMDSForMainProcAppl){%>
				<input type='button' class='button' name = 'main_procedure' id = 'main_procedure' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.main.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels")%>' onclick="callCAMainProcedure();">
			<%}%>

			</td>

<!-- 				<select name='Demo' id='Demo' multiple size='3'  onclick='FreezePage()'>
					<option  selected ><A HREF='javascript:FreezePage()'>Register Refferal</A></option>
					<option>Place Orders</option>
					<option>Record Diagnosis</option>
				</select>
 -->		
			
			<td class='fields' width="20%" ><input type=button class='button' name = 'record' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' align='right'  onClick="Record(this);" onkeydown="shift_tab();"><input type=button class='button' name = 'clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' align='right'  onClick='resetVals();' onkeydown="shift_tab();"><input type=button class='button' name = 'close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' align='right'  onClick='CloseWin()' onkeydown="shift_tab();">&nbsp;</td>
		 </tr>
	 </table>
		<input type="hidden" name="mo_install_yn" id="mo_install_yn" value="<%=mo_install_yn%>">
		<input type="hidden" name="access_yn" id="access_yn" value="<%=access_yn%>">
		<input type="hidden" name="invoke_death_reg_yn" id="invoke_death_reg_yn" value="<%=invoke_death_reg_yn%>">
		<!--Below line added for this CRF ML-MMOH-CRF-0688-->
		<input type="hidden" name="death_reg_mandatory_yn" id="death_reg_mandatory_yn" value="<%=death_reg_mandatory_yn%>"> 
		<input type="hidden" name="enable_dis_diagnosis_yn" id="enable_dis_diagnosis_yn" value="<%=enable_dis_diagnosis_yn%>">

		<!--Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1-->
		<input type="hidden" name="isMDSForMainProcAppl" id="isMDSForMainProcAppl" value="<%=isMDSForMainProcAppl%>">

		<!--Added by Ashwini on 22-Oct-2024 for ML-MMOH-CRF-1742-->
		<input type="hidden" name="isDeceasedDiagClassDeathRegAppl" id="isDeceasedDiagClassDeathRegAppl" value="<%=isDeceasedDiagClassDeathRegAppl%>">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
		<input type="hidden" name="primary_diag_class" id="primary_diag_class" value="<%=primary_diag_class%>">
		<input type="hidden" name="pri_mand_postmortem_ip_yn" id="pri_mand_postmortem_ip_yn" value="<%=pri_mand_postmortem_ip_yn%>">
		<input type="hidden" name="pri_mand_postmortem_dc_yn" id="pri_mand_postmortem_dc_yn" value="<%=pri_mand_postmortem_dc_yn%>">
		<input type="hidden" name="pri_mand_non_postmortem_ip_yn" id="pri_mand_non_postmortem_ip_yn" value="<%=pri_mand_non_postmortem_ip_yn%>">
		<input type="hidden" name="pri_mand_non_postmortem_dc_yn" id="pri_mand_non_postmortem_dc_yn" value="<%=pri_mand_non_postmortem_dc_yn%>">
		<input type="hidden" name="secondary_diag_class" id="secondary_diag_class" value="<%=secondary_diag_class%>">
		<input type="hidden" name="sec_mand_postmortem_ip_yn" id="sec_mand_postmortem_ip_yn" value="<%=sec_mand_postmortem_ip_yn%>">
		<input type="hidden" name="sec_mand_postmortem_dc_yn" id="sec_mand_postmortem_dc_yn" value="<%=sec_mand_postmortem_dc_yn%>">
		<input type="hidden" name="sec_mand_non_postmortem_ip_yn" id="sec_mand_non_postmortem_ip_yn" value="<%=sec_mand_non_postmortem_ip_yn%>">
		<input type="hidden" name="sec_mand_non_postmortem_dc_yn" id="sec_mand_non_postmortem_dc_yn" value="<%=sec_mand_non_postmortem_dc_yn%>">

	 </form>
	</BODY>
	<!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
	<!--End-->

	<%
	}catch(Exception e)
	{
		out.println("Exception : "+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}%>

	<script>
	setTimeout("DisableConfirm_Dummy()",500);
	function DisableConfirm_Dummy(){
	if(parent.frames[1].document.forms[0])
		{
		if(parent.frames[1].document.forms[0].mr_mds_recorded && parent.frames[1].document.forms[0].mds_chk)
			{
			DisableConfirm();
			}
		else{
			setTimeout("DisableConfirm_Dummy()",500);
			}
		}
	else{
		setTimeout("DisableConfirm_Dummy()",500);
		}			
	}
	function DisableConfirm(){
		if((parent.frames[1].document.forms[0].mr_mds_recorded.value!='Y')&&(parent.frames[1].document.forms[0].mds_chk.value!=0)){
			document.getElementById('record').disabled=true;
			
			//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
			if(document.getElementById("isMDSForMainProcAppl").value=='true'){
				if(parent.frames[1].document.forms[0].main_proc_rec_yn.value=='Y'){
					document.getElementById('main_procedure').disabled=true;
				}
			}
		}
		
		//Added by Ashwini on 08-Jul-2024 for ML-MMOH-CRF-2114.1
		if(document.getElementById("isMDSForMainProcAppl").value=='true'){
			if((parent.frames[1].document.forms[0].mr_mds_recorded.value=='Y')&&(parent.frames[1].document.forms[0].mds_chk.value!=0)){
				document.getElementById('main_procedure').disabled=true;
			}

			if(parent.frames[1].document.forms[0].cnm_proceed_yn.value=='Y'){
				document.getElementById('record').disabled=false;
			}
		}

	}
	</script>
	<!--End-->
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

