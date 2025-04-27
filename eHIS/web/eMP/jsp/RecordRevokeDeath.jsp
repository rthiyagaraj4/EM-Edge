<!DOCTYPE html>
<!-- Last Modified Date Time : 10/6/2005 12:02 PM -->

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		
		<script language='javascript' src='../../eCommon/js/dchk.js'></script>
		<script language='javascript' src='../js/RecordRevokeDeath.js'></script>

	</head>
<%
	Connection con = null;
	ResultSet rs=null;	
	java.sql.PreparedStatement pstmt =null;
	


	int count = 0;
	String proceed = "true";

	try
	{
		request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
	
		Boolean isPatientEncRevokeDeathAppl = CommonBean.isSiteSpecific(con,"MP","PATIENT_ENC_REVOKE_DEATH"); // added by mujafar  for ML-MMOH-CRF-1427
		
		String Patient_Id = request.getParameter("Patient_ID");
		String Patient_Name = "";
		String Deceased_Yn = "";
		int Age = 0;
		String DOB ="";
		String DOB_2 ="";//Used for Displaying Date of birth without time in messageframe.
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
		String date=dateFormat.format( new java.util.Date() );		
		String dec_date="";
		String dec_remark="";
		
	
		String visit_status="";
		String visit_adm_date_time="";
		StringBuffer sql= new StringBuffer();
		
		String system_date="";
		String regn_date="";
		String registered_in_mo_yn=""; 
		String deceased_encounter_id=""; 
		String sqlQuery = "";
		try{
				sqlQuery = "SELECT registered_in_mo_yn, deceased_encounter_id,DECODE (?, 'en', patient_name, NVL (patient_name_loc_lang, patient_name)) patient_name,  deceased_yn,TO_CHAR (deceased_date, 'dd/mm/yyyy hh24:mi') deceased_date, TO_CHAR (regn_date, 'dd/mm/yyyy hh24:mi') regn_date,death_status_remarks,TO_CHAR (date_of_birth, 'DD/MM/RRRR hh24:mi') dob,TO_CHAR (date_of_birth, 'DD/MM/RRRR') dob_2, (SYSDATE - date_of_birth) / 365 age,TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') system_date,(SELECT TO_CHAR (MAX (visit_adm_date_time), 'dd/mm/yyyy hh24:mi') FROM pr_encounter WHERE patient_id = ? AND (visit_status >= '07' OR adt_status = '08')) visit_adm_date_time,(SELECT COUNT (1) FROM pr_encounter WHERE patient_id =? AND (visit_status < '07' OR adt_status < '08')) COUNT FROM mp_patient WHERE patient_id = ?";
				
				pstmt = con.prepareStatement(sqlQuery);
				pstmt.setString(1,localeName);
				pstmt.setString(2,Patient_Id);
				pstmt.setString(3,Patient_Id);
				pstmt.setString(4,Patient_Id);
				rs =pstmt.executeQuery();
				if(rs!=null && rs.next()) {
					registered_in_mo_yn=checkForNull(rs.getString("registered_in_mo_yn")); 
					deceased_encounter_id=checkForNull(rs.getString("deceased_encounter_id"));
					system_date=checkForNull(rs.getString("system_date"));
					count = rs.getInt("count");
					Patient_Name	= rs.getString("Patient_Name") == null ? "" : rs.getString("Patient_Name");
					Deceased_Yn	= rs.getString("Deceased_Yn") == null ? "N" : rs.getString("Deceased_Yn");
					dec_date		= checkForNull(rs.getString("DECEASED_DATE"));
					dec_remark		= rs.getString("DEATH_STATUS_REMARKS") == null ? "" : rs.getString("DEATH_STATUS_REMARKS");
					DOB				= checkForNull(rs.getString("DOB"));				
					DOB_2			= (rs.getString("DOB_2"));				
					Age				= rs.getInt("Age");
					if(Deceased_Yn.equals("N")) {
						dec_date = ""; dec_remark = "";
					}
					if(count > 0) { 
						proceed = "false";
					} else {
						visit_adm_date_time = rs.getString("visit_adm_date_time") == null ? "" : rs.getString("visit_adm_date_time");

					}
					regn_date = rs.getString("regn_date") == null ? "" : rs.getString("regn_date");
				}				
				if(!localeName.equals("en") && dec_date != null)
				{
					dec_date=DateUtils.convertDate(dec_date,"DMYHM","en",localeName);
				}
				if(!localeName.equals("en") && DOB != null)
				{
					DOB=DateUtils.convertDate(DOB,"DMYHM","en",localeName);
				}
				if(!localeName.equals("en") && DOB_2 != null)
				{
					DOB_2=DateUtils.convertDate(DOB_2,"DMY","en",localeName);
				}			

		 if(rs!=null) rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	if(registered_in_mo_yn.equals("Y")) {%>
	      <script>			
			 alert(getMessage('CANNOT_REVOKE_MOREG','MP'));
		     parent.f_query_add_mod.document.location.href="../jsp/blank.jsp?step_1=2";
		 </script>
	 <% 
	}
	else if(!deceased_encounter_id.equals("") && !isPatientEncRevokeDeathAppl) { // modified by mujafar for ML-MMOH-CRF-1427 %>
	      <script>
			 alert(getMessage('CANNOT_REVOKE_DEATH','MP'));
		     parent.f_query_add_mod.document.location.href="../jsp/blank.jsp?step_1=2";
		 </script>
	 <%
	 } else {			
%>

		<Script Language="JavaScript">
			function fieldFocus()
			{
				<%if(Deceased_Yn.equals("N")){%>
					RecordRevokeDeath.Deceased_Date.focus();
				<%}else { %>
					RecordRevokeDeath.Remarks_on_Revoking.focus();

				<%}%>
			}
			
			
		
		</Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
	<body  OnMouseDown="CodeArrest()" onLoad='fieldFocus(); startBlink();' onKeyDown = 'lockKey()'>
	<form name="RecordRevokeDeath" id="RecordRevokeDeath" action="../../servlet/eMP.RecordRevokeDeathServlet?Patient_Id=<%=Patient_Id%>" method="post" target="messageFrame">
		<input type='hidden' name='system_date' id='system_date' value='<%=system_date%>'>
	<center>
		<br>
		<!--<table border="0" cellpadding="0" cellspacing="0" width="97%">
			<tr>
				<td  class='PATIENTLINECOLOROTHLANG' width='90%' id='patdetails' style='position:relative;'>&nbsp;</td>
				<TD style='background-color:red' align='center' id='nam' nowrap></TD>
				 <td class='PATIENTLINECOLOR' width='30%' align='right'><img name='nam' src='../../eCommon/images/Status.gif'><img name='nam1' src='../../eCommon/images/Status.gif'></td> 
			</tr>
		</table>-->
		<table border="0" cellpadding="3" cellspacing="0" width="97%">
			<tr>
				<td width='100% 'class="BORDER">
					<table border="0" cellpadding="3" cellspacing="0" width="100%">
						<tr>
								<td class='label' width='20%'></td>
								<td class='label' width='20%'></td>
								<td class='label' width='60%'></td>
						</tr>
						<tr>
							<td class='label'>&nbsp;</td>
							<td class="label"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
							<td class='fields'><%	
										if(Deceased_Yn.equals("Y")) 
											out.println("<input type='text' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RevokePatientDeath.label","mp_labels")+"' name='Action1' id='Action1' DISABLED> <input type='hidden' value='Revoke_Patient_Death' name='Action' id='Action' >");
										else 
											out.println("<input type='text' value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RecordPatientDeath.label","mp_labels")+"' name='Action1' id='Action1' DISABLED> <input type='hidden' value='Record_Patient_Death' name='Action' id='Action' >");
										%>
							</td>
						</tr>
						<tr>
							<td class='label'>&nbsp;</td>
						   <td  class="label"><fmt:message key="Common.DeceasedDate.label" bundle="${common_labels}"/></td>
							<% if (Deceased_Yn.equals("N")) { %>				   
									<td class='fields'><input type="text" id= 'DeceasedDate' name="Deceased_Date" id="Deceased_Date" size="16" maxlength="16"   onkeypress="return Valid_DT(event);" onblur="ValidateDateTimesp(this);"><img src='../../eCommon/images/CommonCalendar.gif' id='Admissiondate'  onClick="document.forms[0].Deceased_Date.select(); calender();" tabindex=-1><img src='../images/mandatory.gif' align='ABSMIDDLE '></img>
								</td>
							<% } else {%>
							<td class='fields'><input type="text" name="Deceased_Date" id="Deceased_Date" size="16" maxlength="16" value='<%=dec_date%>' readonly ><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='Admissiondate'  onClick="document.forms[0].visit_adm_date_time.select();calender();" tabindex=-1 disabled>
							</td>
							<% } %>
						<tr>
						<% if(Deceased_Yn.equals("N")){ %> 						
						<tr>
								<td class='label'>&nbsp;</td>
								<td class="label" valign="center"><fmt:message key="eMP.deceasedremarks.label" bundle="${mp_labels}"/></td>
								<td class='fields'><TextArea name="Deceased_Remarks" rows="5" cols="45"></TextArea><img align='ABSMIDDLE ' src='../images/mandatory.gif'></img></td>
						</tr>
						<% } else { %>
						<tr>
							<td class='label'>&nbsp;</td>
						   <td  class="label" valign="center"><fmt:message key="eMP.deceasedremarks.label" bundle="${mp_labels}"/></td>
						   <td class='fields'><TextArea name="Deceased_Remarks" rows="5" cols="45" readonly><%=dec_remark%></TextArea></td>
						</tr>
						<%} %>

						<tr><td class='label' colspan='3'>&nbsp;</td></tr>
						<% if(Deceased_Yn.equals("Y")){ %>						
						<tr>
							   <td class='label'>&nbsp;</td>
							   <td  class="label" valign="center"><fmt:message key="eMP.remarksonrevoking.label" bundle="${mp_labels}"/></td>
							   <td class='fields'><TextArea name="Remarks_on_Revoking" rows="5" cols="45"></TextArea><img align='ABSMIDDLE ' src='../images/mandatory.gif'></img></td>
						 </tr>
						<tr><td class='label' colspan='3'>&nbsp;</td></tr>
						<% } else out.println("<input type='hidden' value='' name='Remarks_on_Revoking' id='Remarks_on_Revoking'>");  
						%>						
</table>
</td>
</tr>
</table>

</center>
<input type="hidden" name="Deceased_Date_Hidden" id="Deceased_Date_Hidden" value="<%=date%>">
<input type="hidden" name="DOB" id="DOB" value= "<%=DOB%>">
<input type="hidden" name="DOB_2" id="DOB_2" value= "<%=DOB_2%>">
<input type="hidden" name="visit_status" id="visit_status" value="<%=visit_status%>">
<input type="hidden" name="visit_adm_date_time" id="visit_adm_date_time" value="<%=visit_adm_date_time%>">
<input type="hidden" name="Deceased_Yn" id="Deceased_Yn" value="<%=Deceased_Yn%>">
<input type="hidden" name="proceed" id="proceed" value="<%=proceed%>">
<input type="hidden" name="regn_date" id="regn_date" value="<%=regn_date%>">
<input type="hidden" name="Patient_Id" id="Patient_Id" value="<%=Patient_Id%>">
<input type="hidden" name="isPatientEncRevokeDeathAppl" id="isPatientEncRevokeDeathAppl" value="<%=isPatientEncRevokeDeathAppl%>"> <!--  added by mujafar for ML-MMOH-CRF-1427-->
</form>
<%
	sql.setLength(0);
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	}
}catch(Exception ee){
	out.println("Exception in main try"+ee.toString());
	ee.printStackTrace();
}finally{
if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
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

