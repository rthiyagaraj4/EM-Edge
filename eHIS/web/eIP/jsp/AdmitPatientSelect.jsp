<!DOCTYPE html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,eCommon.Common.*,java.util.*,java.sql.*,java.text.*, eCommon.XSSRequestWrapper, eBL.*,com.ehis.util.*,blipin.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eIP/js/AdmitPatient.js' language='javascript'></script>
<script src='../../eIP/js/AdmitPatient1.js' language='javascript'></script>
<script src='../../eIP/js/AdmitPatient2.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
</head>

<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    Connection con				= null;
    Statement stmtlen			= null;
    ResultSet rslen				= null;
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String login_user = (String)session.getAttribute("login_user");//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]

		/***************Package Billing Changes**************start******************/
	String bean_id		= "PkgApprovalBean" ;
	String bean_name	= "eBL.PkgApprovalBean";
	PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
	String bean_id1		= "PkgAssociateBean" ;
	String bean_name1	= "eBL.PkgAssociateBean";
	PkgAssociateBean bean1			= (PkgAssociateBean)getBeanObject( bean_id1, bean_name1, request ) ;
	String bean_id2		= "PkgSubsBean" ;
	String bean_name2= "eBL.PkgSubsBean";
	PkgSubsBean bean2			= (PkgSubsBean)getBeanObject( bean_id2, bean_name2, request ) ;
	
	String bean_id3		= "PkgDiscountBean" ;
	String bean_name3	= "eBL.PkgDiscountBean";
	PkgDiscountBean bean3			= (PkgDiscountBean)PersistenceHelper.getBeanObject( bean_id3, bean_name3, request) ;			

	
	
	
	bean.clearBean();
	bean1.clearBean();
	bean2.clearBean();
	bean3.clearBean();
	
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean1,request);
	putObjectInBean(bean_id2,bean2,request);
	putObjectInBean(bean_id3,bean3,request);
/***************Package Billing Changes**************end******************/

	String allowed_admission_type =	checkForNull((String)request.getParameter("allowed_admission_type"));
	String operstn				= checkForNull((String)request.getParameter("oper_stn_id"));
	String bkg_grace_period		= checkForNull(request.getParameter("bkg_grace_period"));	
	String P_call_func			= checkForNull(request.getParameter("P_call_func"));

	String Patient_Id_Length	= "";
	String oa_install_yn		= "N";
	String queryString			= (String) session.getValue( "queryString" ) ;
	queryString					= checkForNull(queryString);
	String patientid			= checkForNull((String)request.getParameter("patient_id"));
	String register_pat_in_admn_yn		= checkForNull((String)request.getParameter("register_pat_in_admn_yn"));
	String called_from=checkForNull((String)request.getParameter("called_from"));
	String bl_interfaced_yn		= checkForNull((String)request.getParameter("bl_interfaced_yn"));
	String bl_operational		= (String)session.getValue("bl_operational");

    String noshow_bkng_period   = checkForNull(request.getParameter("noshow_bkng_period"));//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
    //below code added for ABM CRF 643.1 ICN:36736
	String from_adv_bed_mgmt			= checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");
    String appl_patient_class			= checkForNull((String)request.getParameter("appl_patient_class"));
	
	/*Below line Added for this CRF  Bru-HIMS-CRF-261*/
	String quick_admission_type	= checkForNull((String)request.getParameter("quick_admission_type"));
	String quick_adm_referralid	= checkForNull((String)request.getParameter("quick_adm_referralid"));
	String quick_adm= checkForNull((String)request.getParameter("quick_adm"));
	String ref_encounter_id=checkForNull((String)request.getParameter("ref_encounter_id"));
	if(quick_adm.equals("Quick_admission"))
	called_from=quick_adm;
	
	
	
	try
	{
		con						= ConnectionManager.getConnection(request);
		Boolean isUHID_valid_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); // Added by mujafar for AMRI-CRF-0357
		stmtlen					= con.createStatement();
		rslen					= stmtlen.executeQuery("Select Patient_Id_Length, (select install_yn from SM_MODULE where module_id = 'OA') install_yn from mp_param where module_id='MP'");
		if(rslen!=null && rslen.next())
		{
			Patient_Id_Length		= checkForNull(rslen.getString("Patient_Id_Length"));
			oa_install_yn	= checkForNull(rslen.getString("install_yn"));
		}

		if(rslen!=null) rslen.close();
		if(stmtlen!=null) stmtlen.close();

%>
<body  onKeyDown='lockKey()' <%if(!called_from.equals("NEWBORN_REG") && !quick_admission_type.equals("Y")){%>onLoad="document.forms[0].elements[0].focus();" <%}%> onMouseDown="CodeArrest();">
	<form name="Select_form" id="Select_form">
		<table cellspacing='0' cellpadding='2' width="100%" border='0'>
			<tr>
				<td width="25%" class="label" ><fmt:message key="eIP.AdmissionFor.label" bundle="${ip_labels}"/></td>
				<td class="fields" width="25%">
					<select name='admission_for' id='admission_for' onchange = "enableFlds();allowedAdmissionType();disableflds();" <%if(called_from.equals("NEWBORN_REG")){%>disabled<%}%>>
						<!-- Modified against MMS-QH-CRF-0144 : "inpatient" value is selected as default-->
						 <option value = ''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option> 
					<%if(from_adv_bed_mgmt.equals("N")){%>					
					<option value = 'I'<%if(called_from.equals("NEWBORN_REG")){%>selected<%}%> selected><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
					<option value = 'D'><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
					<%}else{
						if(appl_patient_class.equals("IP")){%>
							<option value = 'I' selected><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
						<%}else{%>
							<option value = 'D' selected><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
						<%}
					}%>
					</option></select><img src="../../eCommon/images/mandatory.gif">
				</td>
			<script>
				if("<%=oa_install_yn%>" == "N")
				{
					document.forms[0].admission_for.options.remove(2);
				}
			</script>
				<td width="25%" class="label" >&nbsp;</td>
				<td width="25%" class="label" >&nbsp;</td>
			</tr>
			<tr>
				<td width="25%" class="label"  ><fmt:message key="Common.BookingRefNo.label" bundle="${common_labels}"/></td>
				<td width="25%" class="fields"><input type="text" name="booking_ref_no" id="booking_ref_no" maxlength=12 size=20 onBlur="ChangeUpperCase(this);validatePat(document.forms[0].booking_ref_no,'Booking Ref No');" value="" onKeyPress='return CheckForSpecChars(event)' disabled><input type="button" name='book_ref_no_search' id='book_ref_no_search'  onclick="callSearchScreen('B');validatePat(document.forms[0].booking_ref_no,'Booking Ref No');" disabled  value="?" class="button" ></td>
				<!--Below line modified for this CRF Bru-HIMS-CRF-261 -->
				<td width="25%" class="label" ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
				<td  class="fields"><input type='text' size ='14' maxlength='14' name='referral_id' id='referral_id'  onChange="ChangeUpperCase(this);if (document.forms[0].referral_id.readOnly==false) validatePat(this,'Referral ID');" value="<%=quick_adm_referralid%>" onKeyPress='return CheckForSpecChars(event)' disabled><input type='button' class ='button' Value ='?' name='referral_id_search' id='referral_id_search' onClick='PopRefDetails()' disabled></td>
				<input type="hidden" name="encounter_id" id="encounter_id" maxlength=12 size=12 onBlur="if (document.forms[0].encounter_id.readOnly==false) ChkNumValidate(this);" value="" onKeyPress='return allowValidNumber(this,event,12,0)'>
			</tr>
			<tr>
				<td width="25%" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<!--changeValidatePat method is added on blur event for MMS-QH-CRF-0144  -->
				<td width="25%" class="fields"><input type ="text" name="patient_id" id="patient_id"  maxlength='<%=Patient_Id_Length%>' size=20 value="<%=patientid%>"  onBlur="changeValidatePat();ChangeUpperCase(this);if (document.forms[0].patient_id.readOnly==false) validatePat(this,'Patient ID');" onKeyPress='return CheckForSpecChars(event)' disabled><input type="button" name='patient_id_search' id='patient_id_search' value="?" class="button" onclick="callSearchScreen('P');" disabled><img src="../../eCommon/images/mandatory.gif">
				<%
				boolean isSiteSpe_change_pat_dtls= CommonBean.isSiteSpecific(con, "OP","INVOKE_CHANGE_PATIENT_DETIALS");
				int userFunRightsCount		= 0;//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
				if(isSiteSpe_change_pat_dtls)
				{
					userFunRightsCount	= CommonBean.getUserFunRightsCount(con,login_user,"CHG_PAT_DTLS","MP");//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
					if(userFunRightsCount > 0) {
					%> 
				  <img  align='center'  style="visibility:hidden"  id="Update_pat" Title="Change Patient Details" src='../../eCommon/images/update.jpg' onClick="getPatientDetails(document.forms[0].patient_id.value,document.forms[0].from_adv_bed_mgmt.value)" />
                <%
					}
				}%>
			

				
				</td>				
				<td width="25%" class="label" >&nbsp;</td>
				<td width="25%" class="label" >&nbsp;</td>
			</tr>
			<input type = 'hidden' name = 'call_func' id = 'call_func' value="<%=P_call_func%>">
			<input type = 'hidden' name = 'locale' value="<%=locale%>">
			<input type = 'hidden' name = 'pat_flag' value="">
			<input type = 'hidden' name = 'sStyle' value="<%=sStyle%>">
			<input type='hidden' name='allowed_admission_type' id='allowed_admission_type' value="<%=allowed_admission_type%>" >
			<input type='hidden' name='bkg_grace_period' id='bkg_grace_period' value="<%=bkg_grace_period%>" >
			<input type='hidden' name='bkg_type' id='bkg_type' value="">
			<input type='hidden' name='clin_code' id='clin_code' value="">	
			<input type='hidden' name='operator_station' id='operator_station' value="<%=operstn%>">
			<input type='hidden' name='queryString' id='queryString' value="<%=queryString%>">
			<input type='hidden' name='register_pat_in_admn_yn' id='register_pat_in_admn_yn' value="<%=register_pat_in_admn_yn%>">
			<input type='hidden' name='teamid' id='teamid' value="">
			<input type='hidden' name='called_from' id='called_from' value="<%=called_from%>">	
			<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value="<%=bl_interfaced_yn%>">
			<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_operational%>">
			<input type='hidden' name='validatePat_yn' id='validatePat_yn' value="N">
			<input type='hidden' name='noshow_bkng_period' id='noshow_bkng_period' value="<%=noshow_bkng_period%>">  
			<input type='hidden' name='from_adv_bed_mgmt' id='from_adv_bed_mgmt' value="<%=from_adv_bed_mgmt%>">  
			<input type='hidden' name='isSiteSpe_change_pat_dtls' id='isSiteSpe_change_pat_dtls' value="<%=isSiteSpe_change_pat_dtls%>">  
			<input type='hidden' name='userFunRightsCount' id='userFunRightsCount' value="<%=userFunRightsCount%>"> <!--Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]-->

			
				<!--Below line Added for this CRF Bru-HIMS-CRF-261 --> 		
				<input type = 'hidden' name = 'quick_admission_type' value="<%=quick_admission_type%>">  
				<input type = 'hidden' name = 'quick_adm_referralid' value="<%=quick_adm_referralid%>">  
				<input type = 'hidden' name = 'ref_encounter_id' value="<%=ref_encounter_id%>">  

				<input type = 'hidden' name = 'isUHID_valid_appl' value="<%=isUHID_valid_appl%>"> <!-- Added by mujafar for AMRI-CRF-0357 -->
			<input type = 'hidden' name = 'Patient_Id_Length' value="<%=Patient_Id_Length%>"> <!-- Added for MOHE-SCF-0177 -->			


		</table>
	</form>
</body>

<% 
		if(rslen!=null) rslen.close();
		if(stmtlen!=null) stmtlen.close();
}catch(Exception e )
{		
	//out.println("Exception in AdmitPatientSelect.jsp : "+e.toString());
	e.printStackTrace();
}
finally
{
	if(con != null)
		ConnectionManager.returnConnection(con,request);
}%>

<script>
popload();
<!--Below line Added for this CRF Bru-HIMS-CRF-261 -->
   
				if('<%=quick_admission_type%>'=="Y"&&'<%=quick_adm_referralid%>'!=""){
                   validatePat(document.Select_form.quick_adm_referralid,'Referral ID');				
				  for(var m=0; m<document.Select_form.admission_for.length; m++){				  
				    if(document.Select_form.admission_for[m].value=="I")
					document.Select_form.admission_for.value=document.Select_form.admission_for[m].value;
					document.Select_form.admission_for.disabled=true;
				     }
									
				  
				}
			</script>
</script>
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

