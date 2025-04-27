<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"   contentType="text/html;charset=UTF-8"  %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>


<html>
<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script> 
	<script src='../../eMR/js/AddModifyUserAccessRights.js' language='javascript'>
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facility_id=(request.getParameter("facility_id")==null)?"":request.getParameter("facility_id");
	String facility_name=(request.getParameter("facility_name")==null)?"":request.getParameter("facility_name");
	String appl_user_id=(request.getParameter("appl_user_id")==null)?"":request.getParameter("appl_user_id");
	String appl_user_name=(request.getParameter("appl_user_name")==null)?"":request.getParameter("appl_user_name");
	String source=(request.getParameter("source")==null)?"insert":request.getParameter("source");
	String  sql="";

	String sensitive_password="";
	String highrisk_password="";
	String confirm_sensitive_password="";
	String confirm_highrisk_password="";

	String rec_sen_diag_for_cons_pat_yn  =""; 
	String rec_sen_diag_for_oth_pat_yn   =""; 
	String vw_sen_diag_for_cons_pat_yn   =""; 
	String vw_sen_diag_for_oth_pat_yn    =""; 
	String rec_high_risk_for_cons_pat_yn =""; 
	String rec_high_risk_for_oth_pat_yn  =""; 
	String vw_high_risk_for_cons_pat_yn  =""; 
	String vw_high_risk_for_oth_pat_yn   =""; 
	//Maheshwaran K added for the Bru-HIMS-CRF-283 as on 17/08/2012
	String change_password_id_yn="";
	String enable_national_id_yn=""; //Added by Ashwin K for AAKH-CRF-0150
	String cancel_transfer_in_yn=""; //Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124
	String requestor_type_yn=""; //Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
	Connection con=null;
	PreparedStatement pstmt =null;
	ResultSet rset=null;
	String myhix_appl_YN = "N"; // Added for MYHIX integration ML-MMOH-CRF-0507.1.
	String myhix_view_YN="";// Added for MYHIX integration ML-MMOH-CRF-0507.1.

%>
	<body onload='checkSDPwd();checkHRPwd();FocusFirstElement();' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name='useraccessrights_form' id='useraccessrights_form' action='../../servlet/eMR.UserAccessRightsServlet' method='post' target='messageFrame' autocomplete='off'> 
<%
try
{
con=ConnectionManager.getConnection(request);
Boolean isCancelTrnInAvail	= CommonBean.isSiteSpecific(con, "IP","CANCEL_TRANSFER_IN"); //Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124
if(source.equals("modify"))
{
	try{
		sql= " Select facility_id, appl_user_id, facility_name,"+
			"decode(rec_sen_diag_for_cons_pat_yn,'Y','Checked','') rec_sen_diag_for_cons_pat_yn, decode(rec_high_risk_for_cons_pat_yn,'Y','Checked','') rec_high_risk_for_cons_pat_yn, decode(rec_sen_diag_for_oth_pat_yn,'Y','Checked','') rec_sen_diag_for_oth_pat_yn, decode(rec_high_risk_for_oth_pat_yn,'Y','Checked','') rec_high_risk_for_oth_pat_yn, decode(vw_sen_diag_for_cons_pat_yn,'Y','Checked','') vw_sen_diag_for_cons_pat_yn, decode(vw_sen_diag_for_oth_pat_yn,'Y','Checked','') vw_sen_diag_for_oth_pat_yn, decode(vw_high_risk_for_cons_pat_yn,'Y','Checked','') vw_high_risk_for_cons_pat_yn, decode(vw_high_risk_for_oth_pat_yn,'Y','Checked','') vw_high_risk_for_oth_pat_yn, APP_PASSWORD.decrypt(sen_diag_password) sensitive_password, APP_PASSWORD.decrypt(high_risk_password) highrisk_password,decode(CHANGE_NATIONAL_ID_NO_YN,'Y','Checked','') CHANGE_NATIONAL_ID_NO_YN, decode(ENABLE_EMIRATES_ID_YN,'Y','Checked','') ENABLE_EMIRATES_ID_YN,decode(myhix_view_YN,'Y','Checked','') myhix_view_YN, decode(cancel_transfer_in_yn,'Y','Checked','') cancel_transfer_in_yn, decode(requestor_type_yn,'Y','Checked','') requestor_type_yn from MR_USER_ACCESS_TRN_VW where facility_id=? and  appl_user_id=?";  //Modified by Sangeetha on 5-apr-17 for GDOH-CRF-0124
			//"requestor_type_yn" Modified by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
			//Added ENABLE_EMIRATES_ID_YN by Ashwin K for AAKH-CRF-0150

		// sql modified. added myhix_view_YN for MYHIX integration ML-MMOH-CRF-0507.1
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,appl_user_id);
		rset = pstmt.executeQuery();

		if(rset.next()){
			facility_id=rset.getString("facility_id");
			facility_name= rset.getString("facility_name");
			appl_user_id=rset.getString("appl_user_id");
			sensitive_password=rset.getString("sensitive_password");
			highrisk_password=rset.getString("highrisk_password");
			rec_sen_diag_for_cons_pat_yn =rset.getString("rec_sen_diag_for_cons_pat_yn");
			rec_sen_diag_for_oth_pat_yn  =rset.getString("rec_sen_diag_for_oth_pat_yn");		   
			rec_high_risk_for_cons_pat_yn=rset.getString("rec_high_risk_for_cons_pat_yn");
			rec_high_risk_for_oth_pat_yn =rset.getString("rec_high_risk_for_oth_pat_yn");
			vw_sen_diag_for_cons_pat_yn  =rset.getString("vw_sen_diag_for_cons_pat_yn");
			vw_sen_diag_for_oth_pat_yn   =rset.getString("vw_sen_diag_for_oth_pat_yn");
			vw_high_risk_for_cons_pat_yn =rset.getString("vw_high_risk_for_cons_pat_yn");
			vw_high_risk_for_oth_pat_yn  =rset.getString("vw_high_risk_for_oth_pat_yn");
			//Maheshwaran K added for the Bru-HIMS-CRF-283 as on 17/08/2012
			change_password_id_yn=rset.getString("CHANGE_NATIONAL_ID_NO_YN");
			enable_national_id_yn=rset.getString("ENABLE_EMIRATES_ID_YN");//Added by Ashwin K for AAKH-CRF-0150

			cancel_transfer_in_yn=rset.getString("cancel_transfer_in_yn"); //Added by Sangeetha on 5-apr-17 for GDOH-CRF-0124
			requestor_type_yn=rset.getString("requestor_type_yn"); //Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707
			
			//End
			confirm_sensitive_password=sensitive_password;
			confirm_highrisk_password=highrisk_password;
			myhix_view_YN=rset.getString("myhix_view_YN"); // Added myhix_view_YN for MYHIX integration ML-MMOH-CRF-0507.1
		}
	}
	catch(Exception e){
		//out.println("Error on modify"+e);
		e.printStackTrace();
	}
}

	myhix_appl_YN 	= CommonBean.getMyHixApplicable(con); //added for MYHIX integration ML-MMOH-CRF-0507.1.
	
%>		   
			
<BR><BR><BR><BR><BR>
      	<BR><BR><BR>
	
		<table width='90%' cellpadding='3' cellspacing='0' border='0' align='center'>
		<tr><td class='label' colspan='4'>&nbsp;</td></tr>
		<tr>
		   <td class="label" width='20%'><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
		   <td class='fields' width='35%'>
<%
if(appl_user_id.equals("")){
%>
	<input type='text' name='appl_user_id_desc' id='appl_user_id_desc' value='' size='30' > <input type='hidden' name='appl_user_id' id='appl_user_id'><!--<input type='button' class='button' value='?' name='appl_user_button' id='appl_user_button' onClick='searchCode(this,appl_user_id_desc,appl_user_id)'>--><input type='button' class='button' value='?' name='appl_user_button' id='appl_user_button' onClick='commonLookupUserID(document.useraccessrights_form.appl_user_id_desc,this)'><%}
else
	out.println("<input type='text' value=\""+appl_user_name+"\"  name='appl_user_name' id='appl_user_name' readonly><input type='hidden' name='appl_user_id' id='appl_user_id' value=\""+appl_user_id+"\">");%><img src='../../eCommon/images/mandatory.gif'align='center'>
</td>
	   <td class='label' width='10%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	   <td class='fields' width='35%'>		   
		   <% if(facility_id.equals("")) { %>
		   <select name='user_fac_id' id='user_fac_id' ><option value='' >------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------</option>
		   <%
		   }
		   else
		   {
		   out.println("<input type='text' name='user_fac_id_desc' id='user_fac_id_desc'  size='48' maxlength='35' value=\""+facility_name+"\" readOnly><input type='hidden' name='user_fac_id' id='user_fac_id' value=\""+facility_id+"\"> ");
		   
		   }
		   %></select><img src='../../eCommon/images/mandatory.gif'align='center'></td>
		   
		 </tr>
		</table>
	
	

	<!-- SENSITIVE DIAGNOSIS -->

	<table width=90% cellpadding='3' cellspacing='0' border='0' align='center'>
		<tr>
		<td class="COLUMNHEADER" colspan='4'><fmt:message key="Common.SensitiveDiagnosis.label" bundle="${common_labels}"/></td></tr>
		<tr>
				<td width='20%'  class='label'></td>
				<td width='25%' class='label'><fmt:message key="Common.record.label" bundle="${common_labels}"/></td>
				<td width='20%' class='label'></td>
				<td width='35%' class='label'><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
				</tr>

				<tr>
				<td  class='label'><fmt:message key="Common.ConsultingPatient.label" bundle="${common_labels}"/></td>
				<td  class='fields'><input type='checkbox' name='SD_record_for_cons_patient' id='SD_record_for_cons_patient' value="Y"<%=rec_sen_diag_for_cons_pat_yn%>  onClick="checkSDPwd();"></td>
				<td class='label'></td>
				<td  class='fields'><input type='checkbox' name='SD_view_of_cons_patient' id='SD_view_of_cons_patient' value="Y"<%=vw_sen_diag_for_cons_pat_yn%> onClick="checkSDPwd();"></td>
				</tr>
				<tr>
				<td class="label"><fmt:message key="eMR.OtherPatient.label" bundle="${mr_labels}"/></td>
				<td class="fields"><input type='checkbox' name='SD_record_for_oth_patient' id='SD_record_for_oth_patient'  value="Y"  <%=rec_sen_diag_for_oth_pat_yn%> onClick="checkSDPwd();"></td>
				<td class='label'></td>
				<td class="fields"><input type='checkbox' name='SD_view_of_oth_patient' id='SD_view_of_oth_patient' value="Y"  <%=vw_sen_diag_for_oth_pat_yn%> onClick="checkSDPwd();"></td>
			</tr>
			<tr>
			<td class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type='password' size='20' value="<%=sensitive_password%>"  maxlength='20' name='sensitive_password' autocomplete='off'><img src="../../eCommon/images/mandatory.gif" id="sdimgpwd" style="visibility:hidden" border='0'  align='center'></td>
			<td class="label" ><fmt:message key="Common.confirm.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
			<td class="fields"><input type='password' size='20' value="<%=confirm_sensitive_password%>" maxlength='20' name='sensitive_confirm_password' autocomplete='off'><img src="../../eCommon/images/mandatory.gif" id="sdimgcpwd"  style="visibility:hidden" border='0'  align='center'></td>
			</tr>
			
			</table>
		
	<!-- HIGH RISK CONDITIONS----- -->
	<table width=90% cellpadding='3' cellspacing='0' border='0' align='center'>
				<tr>
				<td class="COLUMNHEADER" colspan='4'><fmt:message key="eMR.HighRiskCondition.label" bundle="${mr_labels}"/></td></tr>
				<tr>
						<td width='20%' class='label'></td>
						<td width='25%' class='label'><fmt:message key="Common.record.label" bundle="${common_labels}"/></td>
						<td width='20%' class='label'></td>
						<td width='35%' class='label'><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
						</tr>

								<tr>
								<td class='label'><fmt:message key="Common.ConsultingPatient.label" bundle="${common_labels}"/></td>
								<td class='fields'><input type='checkbox' name='HR_record_for_cons_patient' id='HR_record_for_cons_patient' value='Y' <%=rec_high_risk_for_cons_pat_yn%> onClick="checkHRPwd();"></td>
								<td class='label'></td>
								<td class='fields'><input type='checkbox' name='HR_view_of_cons_patient' id='HR_view_of_cons_patient'   value='Y' <%=vw_high_risk_for_cons_pat_yn%>  onClick="checkHRPwd();"></td>
								</tr>
								<tr>
								<td class="label"><fmt:message key="eMR.OtherPatient.label" bundle="${mr_labels}"/></td>
								<td class="fields"><input type='checkbox' name='HR_record_for_oth_patient' id='HR_record_for_oth_patient'  value='Y' <%=rec_high_risk_for_oth_pat_yn%>  onClick="checkHRPwd();"></td>
								<td class='label'></td>
								<td class="fields"><input type='checkbox' name='HR_view_of_oth_patient' id='HR_view_of_oth_patient'  value='Y' <%=vw_high_risk_for_oth_pat_yn%>  onClick="checkHRPwd();"></td>
								</tr>
								<tr>
					<td class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
					<td class="fields"><input type='password' value="<%=highrisk_password%>" maxlength='20' size='20' name='highrisk_password'><img src="../../eCommon/images/mandatory.gif" id="hrimgpwd"  style="visibility:hidden" border='0' align='center'></td>
					<td class="label" ><fmt:message key="Common.confirm.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
					<td class="fields"><input type='password' maxlength='20' size='20' name='highrisk_confirm_password' id='highrisk_confirm_password' value="<%=confirm_highrisk_password%>"><img src="../../eCommon/images/mandatory.gif" id="hrimgcpwd"  style="visibility:hidden" border='0'  align='center'></td>
					</tr>
					<tr><td class='label' colspan='4'>&nbsp;</td></tr>
					</table>
		<!--Maheshwaran K added for the Bru-HIMS-CRF-283 as on 17/08/2012-->
		<table width=90% cellpadding='3' cellspacing='0' border='0' align='center'>
				<tr>
					<td class="COLUMNHEADER" colspan='8'><fmt:message key="Common.National.label" bundle="${common_labels}"/> ID</td></tr> 
					<!-- Changed colspan='8' by Ashwin K for AAKH-CRF_0150 -->
				<tr>
				<tr>
				<td width='20%'  class='label'><fmt:message key="Common.change.label" bundle="${common_labels}"/> <fmt:message key="Common.National.label" bundle="${common_labels}"/> ID</td>
				<td width='25%' class='fields'><input name='change_national_id' id='change_national_id' type='checkbox' value='Y' <%=change_password_id_yn%> ></td>

				<!-- Added by Ashwin K for AAKH-CRF_0150 -->
				<td width='20%' class='label'> <fmt:message key="eAE.EnableEmiratesID.label" bundle="${ae_labels}"/> </td>
				<td width='35%' class='fields'><input name='enable_national_id' id='enable_national_id' type='checkbox' value='Y' <%=enable_national_id_yn%> ></td>
				<!-- Ended by Ashwin K for AAKH-CRF_0150 -->
				</tr>
		</table>		
		<!--End-->

		<!--Added for for MYHIX integration ML-MMOH-CRF-0507.1.-->
		<% if (myhix_appl_YN.equals("Y")){%>
			<table width=90% cellpadding='3' cellspacing='0' border='0' align='center'>
					<tr>
						<td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.MyHIX.label" bundle="${mp_labels}"/></td></tr>
					<tr>
					<tr>
						<td width='20%' class="label"><fmt:message key="Common.view.label" bundle="${common_labels}"/> <fmt:message key="eMP.MyHIX.label" bundle="${mp_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td width='25%' class='fields'><input name='myhix_view_YN' id='myhix_view_YN' type='checkbox' value='Y' <%=myhix_view_YN%> ></td>
						<td width='76%'></td>
					</tr>
			</table>		
		<%}%>
		<!--End-->
		
		<!-- Added by sangeetha on 5-apr-2017 for GDOH-CRF-0124-->
		<% if(isCancelTrnInAvail){ %>
		<table width=90% cellpadding='3' cellspacing='0' border='0' align='center'>
				<tr>
					<td class="COLUMNHEADER" colspan='4'><fmt:message key="eAM.Transfer.label" bundle="${am_labels}"/> </td></tr>
				<tr>
				<tr>
					<td width='20%' class="label"><fmt:message key="eAM.CancelTransferIn.label" bundle="${am_labels}"/> </td>
					<td width='25%' class='fields'><input name='cancel_transfer_in_yn' id='cancel_transfer_in_yn' type='checkbox' value='Y' <%=cancel_transfer_in_yn%>></td>
					<td width='76%'></td>
				</tr>
		</table>
		<% } %>

		<!--Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707-->
		<table width=90% cellpadding='3' cellspacing='0' border='0' align='center'>
				<tr>
					<td class="COLUMNHEADER" colspan='4'><fmt:message key="Common.MedicalRecords.label" bundle="${common_labels}"/> </td></tr>
				<tr>
				<tr>
					<td width='20%' class="label"><fmt:message key="eMR.RequestorType.label" bundle="${mr_labels}"/> <fmt:message key="Common.setup.label" bundle="${common_labels}"/></td>
					<td width='25%' class='fields'><input name='requestor_type_yn' id='requestor_type_yn' type='checkbox' value='Y' <%=requestor_type_yn%>></td>
					<td width='76%'></td>
				</tr>
		</table>
	
	<input type='hidden' name='function' id='function' value="<%=source%>">
	<input type='hidden' name='function_name' id='function_name' value="<%=source%>">

	<input type='hidden' value="" name='hidden_highrisk_password' id='hidden_highrisk_password'>
	<input type='hidden' value="" name='hidden_sensitive_password' id='hidden_sensitive_password'>

	</form>
</body>
</html>

<% } catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
finally
{
	try
	{
	if(rset != null)rset.close();
	if(pstmt != null)pstmt.close();
	}
	catch(Exception e) {}
ConnectionManager.returnConnection(con,request);
}
%>
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

