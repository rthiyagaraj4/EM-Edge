<!DOCTYPE html>
 <!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ -->  

 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %> <!-- Modified for MOHE-CRF-0074 -->
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
 		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ; //Added for MOHE-CRF-0074
		String facility_id =(String) session.getValue( "facility_id" ); //Added for MOHE-CRF-0074
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script> 
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>	
		<script language="javascript" src="../../ePH/js/ExternalPrescription.js"></script>  
        	<script LANGUAGE="javascript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
   <!-- Added for RollForward from SRR - SRR20056-SCF-9388[IN-56583] -->
	</head>
	<style>
textarea {
  resize: none;
}
</style>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0" onLoad="firstFocus();">
		<FORM name="formExternalPresEntry" id="formExternalPresEntry" >
<%
			Connection con			= null;  // Added for MOHE-CRF-0074
			ArrayList referralfcy     = new ArrayList();
			/* Mandatory checks start */
			String bean_id							= "ExternalPrescriptionBean" ;
			String bean_name						= "ePH.ExternalPrescriptionBean";
			
			ExternalPrescriptionBean bean = (ExternalPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(locale);
			try{
				con				= ConnectionManager.getConnection(request); //Added for MOHE-CRF-0074- Start
				boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
				// Added for MOHE-CRF-0074 - END
				bean.clear();
				referralfcy=bean.getReferralFacilities();	
				String regPatientButton_yn=bean.getRegPatientButton();	// added for HSA-CRF-0216[IN050148] 
				String bean_id_2						= "@PrescriptionBean_1";
				String bean_name_2						= "ePH.PrescriptionBean_1";
				String othr_facty_sql					= PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT110A");
				ArrayList e_facilitys                   = null;
				String order_facility_id= "", order_facility_name= ""; //Added for MOHE-CRF-0074
				String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
				ArrayList region_code_check = bean.getRegionCheckExt(region_code); //Added for MOHE-CRF-0074 //Modified for MOHE-CRF-0074
%>
				<table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" >
					<TR><TD colspan="4">&nbsp;</TD></TR>
					<tr>	<th colspan="4" style="font-size:12" align="left"><fmt:message key="ePH.ExternalPrescriptionDetail.label" bundle="${ph_labels}"/></th>
					<TR><TD colspan="4">&nbsp;</TD></TR>
					<tr>
						<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td align="left" colspan="3">
						<input type="text" name="patient_id" id="patient_id" size="20" onKeyPress="changeToUpper()" maxlength="<%=bean.getPatientIDLength()%>" onBlur="chkPatientID();" > <input type="button" value="?" class="button" name="patient_search" id="patient_search"  onclick="callPatientSearch()" >
						<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
					</td>
					</tr>
					<TR><TD colspan="4">&nbsp;</TD></TR>
					<tr>
					<td  class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</td>
					<td colspan="3" class="label" align="left" id="patient_details" ></td>
					</tr>
					</tr>
					<TR><TD colspan="4">&nbsp;</TD></TR>
					<tr>
					<td  class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
						<td align="left"  > 
						<select name="ref_facility" id="ref_facility" onchange = 'CheckVal()'>
							<option value ="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---------&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </option>
<%					if(region_check){ //MOHE-CRF-0074-Start 
	   					for (int i=0;i<region_code_check.size();i+=2){
							order_facility_id=(String)region_code_check.get(i);
							order_facility_name=(String)region_code_check.get(i+1);
%>
						<option value='<%=order_facility_id%>' ><%=order_facility_name%></option>
<%
						}
					}else{  //MOHE-CRF-0074-End 
							for(int i=0;i<referralfcy.size();i+=2){
								String	ref_fcy_code=(String)referralfcy.get(i);
%>
								<option  VALUE="<%= ref_fcy_code %>"><%= referralfcy.get(i+1) %></option>
<%
							}
					}  //Added for MOHE-CRF-0074
%>
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center" id="facilityMand"></img>
						</td>
<%  
						//reffacilitys=bean.getAmRefFacility();
						//if(reffacilitys!=null && reffacilitys.size() > 0 ){
%>
							<!-- <TD COLSPAN="2" ALIGN="left" class='label'nowrap>Other Facility &nbsp;
							&nbsp;<SELECT name="other_facility" id="other_facility" onchange= "CheckVal1()" >
								<OPTION VALUE="">---- Select ----</OPTION>	 -->
<%
								//for(int t=0;t<reffacilitys.size();t++){
									//reffacility1=(HashMap)reffacilitys.get(t);
%>
									<!-- <OPTION  VALUE=''></OPTION> -->
<%
								//}
							//}
%>
							<!-- </SELECT>&nbsp; -->
							<TD COLSPAN="2" ALIGN="left" class='label' nowrap><fmt:message key="Common.OtherFacility.label" bundle="${common_labels}"/> &nbsp;&nbsp;
<% 
								e_facilitys=(ArrayList)bean.getOtherRefFacility(); 
								if(e_facilitys!=null && e_facilitys.size() > 0 ){
%>
									<SELECT name="ref_referral_facility" id="ref_referral_facility" onChange="clear_text(this,other_facility,ref_facility,otherfacility_code,othr_factySearch)">&nbsp;&nbsp;
										<OPTION VALUE="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----</OPTION>	
<%
										for(int i=0;i<e_facilitys.size();i+=2){
%>
											<OPTION  VALUE='<%=e_facilitys.get(i)%>'><%=e_facilitys.get(i+1)%></OPTION>
<%
										}
%>
										</select>
<%
									}
%>
								&nbsp;&nbsp;<INPUT TYPE="text" name="other_facility" id="other_facility">
								<INPUT type="button" value="?" class="button" name="othr_factySearch" id="othr_factySearch"  onclick="callOtherfactySeach()">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" id="OtherFacMand" style='display:none;'></img>
								<INPUT TYPE="hidden" name="otherfacility_code" id="otherfacility_code" value="">
							</TD>
						 </tr>
						<TR><TD colspan="4">&nbsp;</TD></TR>
						<tr>
							<td  class="label"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/>&nbsp;</td>
							<td align="left" COLSPAN="3">
								<input type="text" name="ref_practitioner" id="ref_practitioner"  size= "30" onKeyPress="changeToUpper()" value="" maxlength='30'>
								<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
							</td>
						</tr>
						<TR><TD colspan="4">&nbsp;</TD></TR>
						<tr>
							<td  class="label"><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
							<td align="left"  COLSPAN="3">
							<input type="text" name="dt_ref" id="dt_ref"  size="13"  value="" maxlength="16" onBlur="CheckDateLeap(this,'DMYHM','<%= locale %>')"> <!-- CheckDate function changed to  CheckDateLeap for RollForward from SRR - SRR20056-SCF-9388[IN-56583] -->
							<IMG SRC="../../eCommon/images/CommonCalendar.gif" id="Calendar" onclick="return showCalendar('dt_ref',null,'hh:mm');" > <!-- showCalendar('dt_ref',null,'hh:mm') changed to showCalendar('dt_ref') for SRR - SRR20056-SCF-9388[IN-56583] --> 
							<img src="../../eCommon/images/mandatory.gif" align="center"></img>
							</td>
						</tr>
						<TR><TD colspan="4">&nbsp;</TD></TR>
						<tr>
							<td  class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
							<td align="left"  colspan="3">
								<textarea cols="51"   rows="4" name="remarks" id="Message Text" onKeyPress="return checkMaxLimit(this,500,'');" onBlur="callCheckMaxLen(this,500,'blr');"></textarea>
								<img src="../../eCommon/images/mandatory.gif" align="center"></img>
							</td>
						</tr>
						 <TR><TD colspan="4">&nbsp;</TD></TR>
						<TR><TD colspan="4">&nbsp;</TD></TR> 
						 <TR><TD colspan="4">&nbsp;</TD></TR>
						<TR><TD colspan="4">&nbsp;</TD></TR>
						<tr>
							<td align="right" colspan="4"> 
							<input type="button" name="btnClear" id="btnClear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class="button" onClick="Clear()">
							<input type="button" name="btnPlaceOrd" id="btnPlaceOrd" value='<fmt:message key="Common.PlaceOrder.label" bundle="${common_labels}"/>' class="button" onClick="callPrescription()" >
							</td>
						</tr>
					</table>
					<input type="hidden" name="bean_id" id="bean_id"   value="<%=bean_id_2%>">		
					<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name_2%>">	
					<input type="hidden" name="locale" id="locale" value="<%=locale%>">
					<input type="hidden" name="bean_id1" id="bean_id1"   value="<%=bean_id%>">		
					<input type="hidden" name="bean_name1" id="bean_name1" value="<%=bean_name%>">	
					<INPUT TYPE="hidden" name="othr_facty_sql" id="othr_facty_sql" Value="<%=othr_facty_sql%>">
					<INPUT TYPE="hidden" name="regPatientButton_yn" id="regPatientButton_yn" Value="<%=regPatientButton_yn%>"><!-- added for HSA-CRF-0216[IN050148] -->
<%
				}
				catch(Exception e) {
					out.print("Exception @ Result JSP :"+e.toString());
				}
			finally{  //Added for MOHE-CRF-0074
				
				if(con != null)
					ConnectionManager.returnConnection(con,request);	
			} //Added for MOHE-CRF-0074
%>
			<script>
				parent.frames[0].document.forms[0].reset.disabled = true;
			</script>
	</FORM>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

