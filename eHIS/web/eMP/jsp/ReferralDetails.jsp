<!DOCTYPE html>
<%
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// Module			: OP
/// Created By		: SRIDHAR R 
/// Created Date	: 6 SEP 2004

/// Function		: To Insert the Referral details into PR_REFERRAL_REGISTER Table...
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
%>

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<script>//alert("Opening ReferralDetails.jsp")</script>
	<TITLE><fmt:message key="Common.DischargeAdvise.label" bundle="${common_labels}"/></TITLE>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	
	<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eMP/js/ReferralDtls.js' language='javascript'></script>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY onKeyDown = 'lockKey();'>
	<form name='ReferralDtls_form' id='ReferralDtls_form'  method="post" onload="" action="../../servlet/eMP.RegisterReferralsServlet" target="messageFrame1" >
	<%
	Connection con			=	null;
	Statement stmt			=	null;
	ResultSet rs			=	null;
	String locale           = (String) session.getAttribute("LOCALE");
	try
	{
		con	= ConnectionManager.getConnection(request);
		stmt= con.createStatement();

		Boolean isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS"); //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		Boolean isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023

		String facilityID		= (String) session.getValue("facility_id");
		
		
String function_id= checkForNull(request.getParameter("function_id")); //this line Added for this CRF-Bru-HIMS-CRF-261
	
		
		String Transaction_type	= request.getParameter("Transaction_type");
			if(Transaction_type	== null	) Transaction_type = "";

		String patient_id		= request.getParameter("patient_id");
			if(patient_id	== null	) patient_id = "";
	/*Added by lakshmanan for ML-MMOH-CRF-1972 on 20/07/2023 start*/	
		String recFun		= request.getParameter("recFun");
		if(recFun	== null	) recFun = "";
		if (!recFun.equals("")){
			function_id=recFun;
		}
		String recFunVal		= request.getParameter("recFunVal");
		if(recFunVal	== null	) recFunVal = "";
		String referral_id1		= request.getParameter("referral_id");
		if(referral_id1	== null	) referral_id1 = "";
		/*Added by lakshmanan for ML-MMOH-CRF-1972 on 20/07/2023 end*/

		String EncounterId		= request.getParameter("EncounterId");
			if(EncounterId	== null	) EncounterId = "";
		String Module			= request.getParameter("Module");
        String regOutref=request.getParameter("regOutref");
		      if(regOutref==null) regOutref="";
		String discharge_indicator		= request.getParameter("discharge_indicator");
			if(discharge_indicator	== null	) discharge_indicator = "";

		String Sql						= "";
		String service_code				= "";
		String specialty_code			= "";
		String practitioner_id			= "";
		String nursing_unit_code		= "";
		
		
		String patient_name				= "";
		
		String practitioner_name		= "";
		String hcare_setting_type_code	= "";
		String nursing_unit_short_desc	= "";
		String locn_type				= "";
		StringBuffer referral_idS		=new StringBuffer();
		String referral_id				= "";

    /*Below line modified for this CRF HSA-CRF-0263.1*/
	String allow_muti_bedside_review_yn = checkForNull(request.getParameter("allow_muti_bedside_review_yn"),"N");
    		
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
	String refButton="button"; 
	String referral_id2="";
	String transfer_case_yn="N";
	String to_ref_type="";
	String to_ref_code="";
	String to_ref_desc="";
	String to_hcare_setting_type="";
	String to_locn_code="";
	String to_locn_desc="";
	String to_speciality_code="";
	String to_locn_type="";
	String to_service_code="";
	String to_service_desc="";
	String to_pract_id="";
	String to_pract_desc="";
	String to_pract_name="";
	String referred_for="";
	String preferred_treatment_date="";
	String referral_reason_code="";
	String referral_reason_desc="";
	String referral_priority="";
	if(isForAdmission && recFun.equals("ModifyReferral")){
		PreparedStatement pstmt1	= null;
		ResultSet rs1 = null;
		String Sql1="";
		String Sql2="";
		
		Sql1  = " select DISP_REFERRAL_ID from  op_patient_queue where  ENCOUNTER_ID=? ";
		pstmt1	= con.prepareStatement(Sql1);
		pstmt1.setString(1,EncounterId );
		rs1=pstmt1.executeQuery();
		if (rs1!=null && rs1.next()) {
			referral_id2=checkForNull(rs1.getString("DISP_REFERRAL_ID"));
		}
		if(pstmt1!=null) pstmt1.close();
		if(rs1!=null) rs1.close();
		
		Sql2 ="select transfer_case_yn, to_ref_type , to_ref_code , am_get_desc.am_referral(to_ref_code,?,'1') as to_ref_desc ,to_facility_id , (case when to_facility_id is not null then( sm_get_desc.sm_facility_param(to_facility_id,?,'1')) end) to_facility_name,  to_hcare_setting_type, to_speciality_code, to_locn_code , to_locn_type , to_locn_desc, to_service_code, am_get_desc.am_service(to_service_code,?,'2') as to_service_desc , to_pract_id ,  DECODE (to_ref_type, 'X', am_get_desc.am_ext_practitioner (to_pract_id, ?, 1 ), am_get_desc.am_practitioner (to_pract_id, ?, 1))  as to_pract_desc ,to_pract_name , referred_for_ip , to_char(preferred_treatment_date,'dd/mm/yyyy') PREFERRED_TREATMENT_DATE , referral_reason_code , am_get_desc.am_contact_reason(referral_reason_code, ?,'1') as referral_reason_desc , referral_priority from pr_referral_register where REFERRAL_ID=?" ;
		pstmt1	= con.prepareStatement(Sql2);
		pstmt1.setString(1,locale );
		pstmt1.setString(2,locale );
		pstmt1.setString(3,locale );
		pstmt1.setString(4,locale );
		pstmt1.setString(5,locale );
		pstmt1.setString(6,locale );
		pstmt1.setString(7,referral_id2 );
		rs1=pstmt1.executeQuery();
		if (rs1!=null && rs1.next()) {
			transfer_case_yn=checkForNull(rs1.getString("transfer_case_yn"),"N");
			to_ref_type=checkForNull(rs1.getString("to_ref_type"));
			if (to_ref_type.equals("X")){
			to_ref_code=checkForNull(rs1.getString("to_ref_code"));
			to_ref_desc=checkForNull(rs1.getString("to_ref_desc"));
			} else {
				to_ref_code=checkForNull(rs1.getString("to_facility_id"));
				to_ref_desc=checkForNull(rs1.getString("to_facility_name"));
			}
			to_hcare_setting_type=checkForNull(rs1.getString("to_hcare_setting_type"));
			to_locn_code=checkForNull(rs1.getString("to_locn_code"));
			to_locn_desc=checkForNull(rs1.getString("to_locn_desc"));
			to_speciality_code=checkForNull(rs1.getString("to_speciality_code"));
			to_locn_type=checkForNull(rs1.getString("to_locn_type"));
			to_service_code=checkForNull(rs1.getString("to_service_code"));
			to_service_desc=checkForNull(rs1.getString("to_service_desc"));
			to_pract_id=checkForNull(rs1.getString("to_pract_id"));
			to_pract_desc=checkForNull(rs1.getString("to_pract_desc"));
			to_pract_name=checkForNull(rs1.getString("to_pract_name"));
			referred_for=checkForNull(rs1.getString("referred_for_ip"));
			preferred_treatment_date=checkForNull(rs1.getString("PREFERRED_TREATMENT_DATE")); 
			referral_reason_code=checkForNull(rs1.getString("referral_reason_code")); 
			referral_reason_desc=checkForNull(rs1.getString("referral_reason_desc")); 
			referral_priority=checkForNull(rs1.getString("referral_priority")); 
		}
			
	}
	if(isForAdmission && (recFun.equals("ModifyReferral") || recFun.equals("for_admission")))
			{
			 refButton="hidden";	
	} 
	
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
		%>

<%		if(Transaction_type.equals("DP"))
		{

		
			locn_type			= checkForNull(request.getParameter("from_locn_type"));
			service_code		= checkForNull(request.getParameter("from_service_code"));
			specialty_code		= checkForNull(request.getParameter("from_specialty_code"));
			practitioner_id		= checkForNull(request.getParameter("from_practitioner_id"));
			practitioner_name	= checkForNull(request.getParameter("from_practitioner_name"));
			nursing_unit_code	= checkForNull(request.getParameter("from_nursing_unit_code"));
			nursing_unit_short_desc	= checkForNull(request.getParameter("from_nursing_unit_short_desc"));
		
			Sql  = " SELECT REFERRAL_ID FROM pr_referral_register WHERE from_facility_id = '"+facilityID+"' AND from_encounter_id = '"+EncounterId+"' order by REFERRAL_ID";
	
		
			rs		= stmt.executeQuery(Sql);

			referral_idS.setLength(0);
			
			if(rs != null)
			{
				while(rs.next())
				{
					referral_id		= rs.getString("REFERRAL_ID");
					if(referral_id == null ) 
					{
						referral_idS.append("'"+referral_id+"'");
					}
					else
					{
						referral_idS.append(referral_id+"/");
					}
				}
			}

			if(rs != null) rs.close();
		}
		else if(Transaction_type.equals("DA") || Transaction_type.equals("CO"))
		{	
		
		
			Sql = " SELECT a.attend_practitioner_id , a.patient_id, decode('"+localeName+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+localeName+"', 1) practitioner_name, service_code, decode(a.assign_care_locn_type, 'N', ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code, '"+localeName+"', 1), op_get_desc.op_clinic(a.facility_id, a.assign_care_locn_code, '"+localeName+"', 1)) clinic_name , specialty_code, assign_care_locn_code, assign_care_locn_type FROM pr_encounter a, mp_patient b WHERE facility_id = '"+facilityID+"' AND encounter_id = '"+EncounterId+"' and a.patient_id = b.patient_id";	
		
			rs		= stmt.executeQuery(Sql);

			if(rs != null)
			{
				while(rs.next())
				{
					locn_type			= rs.getString("assign_care_locn_type");
					practitioner_id		= rs.getString("attend_practitioner_id");
					practitioner_name	= rs.getString("practitioner_name");
					patient_name		= rs.getString("patient_name");
					patient_id			= rs.getString("patient_id");
					specialty_code		= rs.getString("specialty_code");
					service_code		= rs.getString("service_code");
					nursing_unit_code	= rs.getString("assign_care_locn_code");
					nursing_unit_short_desc	= rs.getString("clinic_name");
				}
			}
%>

<%
			if(rs != null) rs.close();
		}	
		
		rs		= stmt.executeQuery("select HCARE_SETTING_TYPE_CODE from SM_FACILITY_PARAM where FACILITY_ID = '"+facilityID+"'");

		if(rs != null)
		{
			while(rs.next())
			{
				hcare_setting_type_code	= rs.getString("HCARE_SETTING_TYPE_CODE");
			}
		}
		if(rs != null)	rs.close();
		if(stmt!= null) stmt.close();

%>
<TABLE id="referral_table" cellspacing=0 cellpadding=0 border="0" width="100%" >
<!--Below line modidfied for this CRF Bru-HIMS-CRF-261-->
	<tr>
		<jsp:include page="../../eMP/jsp/ReferralDetailsComponent.jsp" flush="true" > 
			<jsp:param name ="Module" value= "<%=Module%>" /> 	
			<jsp:param name ="ReasonForRef" value= "N" /> 	
			<jsp:param name ="Option" value= "Y" /> 	
			<jsp:param name ="bodyFrame" value= "parent.frames[1]" /> 	
			<jsp:param name ="submitFrame" value= "parent.frames[3]" /> 	
			<jsp:param name ="Transaction_type" value= "<%=Transaction_type%>" /> 
			<jsp:param name ="discharge_indicator" value= "<%=discharge_indicator%>" /> 
			<jsp:param name ="regOutref" value= "<%=regOutref%>" /> 
			<jsp:param name ="function_id" value= "<%=function_id%>" /> 
			<jsp:param name ="allow_muti_bedside_review_yn" value= "<%=allow_muti_bedside_review_yn%>" /> 
			<jsp:param name ="calling_module" value= "OP" /> 
			<jsp:param name ="referral_id" value= "<%=referral_id2 %>" /> 
			<jsp:param name="recFun" value="<%=recFun%>"/>
			<jsp:param name="recFunVal" value="<%=recFunVal%>"/> 
			<jsp:param name="transfer_case_yn" value="<%=transfer_case_yn%>"/> 
			<jsp:param name="ref_type" value="<%=to_ref_type%>"/> 
			<jsp:param name="referred_to_value" value="<%=to_ref_code%>"/> 
			<jsp:param name="referred_to_desc" value="<%=to_ref_desc%>"/> 
			<jsp:param name="ref_hcare_setting_type" value="<%=to_hcare_setting_type%>"/> 
			<jsp:param name="ref_locn_code" value="<%=to_locn_code%>"/> 
			<jsp:param name="to_locn_desc" value="<%=to_locn_desc%>"/> 
			<jsp:param name="ref_specialty" value="<%=to_speciality_code%>"/> 
			<jsp:param name="ref_locn_type" value="<%=to_locn_type%>"/> 
			<jsp:param name="ref_service_code" value="<%=to_service_code%>"/> 
			<jsp:param name="to_service_desc" value="<%=to_service_desc%>"/> 
			<jsp:param name="to_pract_id" value="<%=to_pract_id%>"/> 
			<jsp:param name="to_pract_desc" value="<%=to_pract_desc%>"/> 
			<jsp:param name="to_pract_name" value="<%=to_pract_name%>"/> 
			<jsp:param name="referred_for" value="<%=referred_for%>"/> 
			<jsp:param name="preferred_treatment_date" value="<%=preferred_treatment_date%>"/> 
			<jsp:param name="referral_reason_code" value="<%=referral_reason_code%>"/> 
			<jsp:param name="referral_reason_desc" value="<%=referral_reason_desc%>"/> 
			<jsp:param name="ref_priority" value="<%=referral_priority%>"/> 
		</jsp:include>
	</tr>

	<!--Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187-->
	<%if(!isImproveReferralProcessAppl || function_id.equals("RegisterInpatientReferral")){%>
		<script>if(document.getElementById('prefDateImg'))document.getElementById('prefDateImg').style.visibility	= 'visible';</script>
	<%}%>

	<tr>
	<table border='0' width='100%'>
	<tr>
		
		<!-- below condition added by Venkatesh.S on 21/12/2012 againist 36866 -->
		<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 -->
		<%if(regOutref.equals("REG_OUT_REF") || function_id.equals("RegPatRefFromAEAssessment")){%>
			<td align='right' colspan='7'><input type='button' name='record' id='record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onclick='clearAll()'></td>
		<%}else{%>
		<!--  below line modified by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023  -->
		<td align='right' colspan='7'><input type='button' name='record' id='record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onclick='clearAll()'><input type='button' name='close' id='close' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' class='button' onclick='closeWin()'><input type='<%=refButton%>' name='Refresh' value='<fmt:message key="Common.Refresh.label" bundle="${common_labels}"/>' class='button' onclick='reloadPage()'></td>
		
		<%}%>
		<!-- end 36866 -->
	</tr>
	<tr>
						<td colspan="4" class=label height=5></td>
					</tr>

	</table>
	</tr>
<%
/// For Calling Function from IP_DISCAHRGE_ADVICE..
	if(Transaction_type.equals("DA") && discharge_indicator.equals("ED"))
	{
		out.println("<script>document.forms[0].close.disabled = true;</script>");
		out.println("<script>alert(getMessage('REGISTER_ONE_REFERRAL','MP'))</script>");
	}

%>


<input type = 'hidden' name='patient_id' id='patient_id' value="<%=patient_id%>" >
<input type = 'hidden' name='patient_name' id='patient_name' value="<%=patient_name%>" >

<input type = 'hidden' name='from_facility_id' id='from_facility_id' value="<%=facilityID%>" >
<input type = 'hidden' name='from_encounter_id' id='from_encounter_id' value="<%=EncounterId%>" >
<input type = 'hidden' name='from_hcare_setting_type' id='from_hcare_setting_type' value="<%=hcare_setting_type_code%>" >
<input type = 'hidden' name='from_locn_type' id='from_locn_type' value="<%=locn_type%>" >
<input type = 'hidden' name='from_ref_code' id='from_ref_code' value="" >
<input type = 'hidden' name='from_ref_type' id='from_ref_type' value="L" >
<input type = 'hidden' name='from_pract_id' id='from_pract_id' value="<%=practitioner_id%>" >
<input type = 'hidden' name='from_pract_name' id='from_pract_name' value="<%=practitioner_name%>" >
<input type = 'hidden' name='from_service_code' id='from_service_code' value="<%=service_code%>" >
<input type = 'hidden' name='from_speciality_code' id='from_speciality_code' value="<%=specialty_code%>" >

<input type = 'hidden' name='from_locn_code' id='from_locn_code' value="<%=nursing_unit_code%>" >
<input type = 'hidden' name='from_locn_desc' id='from_locn_desc' value="<%=nursing_unit_short_desc%>" >
<input type = 'hidden' name='Module' id='Module' value="<%=Module%>" >
<input type = 'hidden' name='Transaction_type' id='Transaction_type' value="<%=Transaction_type%>" >
<input type = 'hidden' name='hdd_discharge_indicator' id='hdd_discharge_indicator' value="<%=discharge_indicator%>" >

<input type = 'hidden' name='referral_idS' id='referral_idS' value="<%=referral_idS.toString()%>" >
<input type = 'hidden' name='mode' id='mode' value="" >
<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 -->
<input type='hidden' name='call_function' id='call_function' value='<%=function_id%>'>
<!--  added by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023 start -->
<input type='hidden' name='recFun' id='recFun' value='<%=recFun%>'>
<input type='hidden' name='recFunVal' id='recFunVal' value='<%=recFunVal%>'>
<input type='hidden' name='referral_id' id='referral_id' value='<%=referral_id2%>'>
<!--  added by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023 end -->
<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
<input type='hidden' name='CA_REF_LETTER_NOTES_REC_YN' id='CA_REF_LETTER_NOTES_REC_YN' value="N">
</table>
<script>updateRefDtls();</script>

<%
 
 referral_idS.setLength(0);

}catch(Exception e) 
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</form>
</BODY>
</HTML>
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

