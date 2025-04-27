<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language ='javascript' src='../../eIP/js/BedBookingTransfer.js'></script>	
<!--<script language ='javascript' src='../../eIP/js/PatientEmergencyTransfer.js'></script>	-->
<script language ='javascript' src='../../eIP/js/IPPractitionerComponent.js'></script>	
<script language ='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,eCommon.Common.*,java.sql.*, java.text.*,java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String locale				= (String)session.getAttribute("LOCALE");
	
	Connection con			= null;
	Statement stmt			= null;
	PreparedStatement pstmt	= null;
	ResultSet rset			= null;
	StringBuffer StrBuf		= new StringBuffer();
	String topractitionerid	= "";
	String topractdesc		= "";
	String tospecialitycode	= "";
	String tospecialitydesc	= "";
	String tobedclass		= "";
	String tonursingunitcode= "";
	String tonursingunitdesc= "";
	String tobedno			= "";
	String toroomno			= "";
	String tobedtype		= "";
	String tobedtypedesc	= "";
	String tobedclassdesc	= "";
	int    frdailycharge	= 0;
	String medcode 			= "";
	String meddesc 			= "";
	String toteamid 		= "";
	String toservicecode	= "";
	String tosubservcode	= "";
	String subsel			= "";
	String eid				="";
	String patientid		="";
	int BED_BLOCK_PERIOD_MAX=0;
	String TRN_TYPE			="";
	String blocking_period	="";
	String blocking_remark	="";
	String blocking_type_code="";
	String mother_bed_status="";
	String overrideyn		="N";
	String isreadonly		= "";
	String isenable			= "";  
	
	String res_reserve_bed_intraward_yn="N"; //Added for this CRF GHL-CRF-0340
	HashMap ResultParamHashMap = new HashMap();	

	String loginUser				= checkForNull((String)session.getValue("login_user"));
	String facilityId				= checkForNull((String)session.getValue("facility_id"));
	patientid						= checkForNull((String)session.getValue("patientid"));
	String call_function			= checkForNull(request.getParameter("call_function"));
	String admissiondate			= checkForNull(request.getParameter("admission_date"));
	String frpractitionerid			= checkForNull(request.getParameter("frpractitionerid")); 
	String frpractdesc				= checkForNull(request.getParameter("frpractdesc"));
	String frspecialitycode			= checkForNull(request.getParameter("frspecialitycode"));   
	String frspecialitydesc			= checkForNull(request.getParameter("frspecialitydesc"));
	String frbedclass				= checkForNull(request.getParameter("frbedclass"));  
	String frbedclassdesc			= checkForNull(request.getParameter("frbedclassdesc")); 
	String frnursingunitcode	 	= checkForNull(request.getParameter("frnursingunitcode")); 
	String frnursingunitdesc	 	= checkForNull(request.getParameter("frnursingunitdesc")); 
	String frbedno					= checkForNull(request.getParameter("frbedno"));      
	String frroomno					= checkForNull(request.getParameter("frroomno"));
	String frbedtype				= checkForNull(request.getParameter("frbedtype")); 
	String frbedtypedesc			= checkForNull(request.getParameter("frbedtypedesc"));
	String frdailychargeStr			= checkForNull(request.getParameter("frdailycharge"));
	String age						= checkForNull(request.getParameter("age"));
	String gender					= checkForNull(request.getParameter("gender"));
	String frservicecode			= checkForNull(request.getParameter("frservicecode"));
	String frservicedesc			= checkForNull(request.getParameter("frservicedesc"));
	String frsubservcode			= checkForNull(request.getParameter("frsubservcode"));
	String frsubservdesc			= checkForNull(request.getParameter("frsubservdesc"));
	String patient_class			= checkForNull(request.getParameter("patient_class"));
	String frmeddesc				= checkForNull(request.getParameter("frmeddesc"));
	String frmedid					= checkForNull(request.getParameter("frmedid"));
	String BED_BLOCK_PERIOD_MAXS	= checkForNull(request.getParameter("BED_BLOCK_PERIOD_MAX"));
	String max_blk_type				= checkForNull(request.getParameter("max_blk_type"));
	String bed_class_allowed		= checkForNull(request.getParameter("ch_bed_class_param"));
	String deactivate_pseudo_bed_yn = checkForNull(request.getParameter("deact_pseudo_bed"));
	String func_id					= checkForNull(request.getParameter("func_id"));
	if(func_id!=null && func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
			isreadonly = "ReadOnly";
			isenable = "Disabled";
		}

	if(!BED_BLOCK_PERIOD_MAXS.equals(""))
		BED_BLOCK_PERIOD_MAX		= Integer.parseInt(BED_BLOCK_PERIOD_MAXS);
	if(max_blk_type.equals("D"))
		BED_BLOCK_PERIOD_MAX=(BED_BLOCK_PERIOD_MAX)*24;

	if(!frdailychargeStr.equals(""))
	    frdailycharge				= Integer.parseInt(frdailychargeStr);

	if(!call_function.equals("confirm_details"))
		eid							= checkForNull((String)session.getValue("encounter_id"));
	else
		eid							= checkForNull((String)session.getValue("encounter_id"));
	long    encounterid				=	Long.parseLong(eid);

	try
	{
		con							= ConnectionManager.getConnection(request);

		Boolean restrictPseudoBed	= CommonBean.isSiteSpecific(con,"IP","RESTRICT_PSEUDO_BED"); //Added by Sangeetha on  23/05/17 for GDOH-CRF-0151
				
	
	if(call_function.equals("Change_Bedclass"))
	{
		if(StrBuf.length()>0) StrBuf.delete(0,StrBuf.length());
		// Changed by vinod  6/21/2006


/*  Commented this query for PE By Suresh on 09/06/2010

		StrBuf.append("SELECT" );
		StrBuf.append("  REQ_NURSING_UNIT_CODE" );
		StrBuf.append("  ,IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, REQ_NURSING_UNIT_CODE,'"+locale+"','2') REQ_NURSING_UNIT_SHORT_DESC" );
		StrBuf.append("  , TO_SERVICE_CODE" );
		StrBuf.append("  ,AM_GET_DESC.AM_SERVICE(TO_SERVICE_CODE,'"+locale+"','2') TO_SERVICE_SHORT_DESC" );
		StrBuf.append("  , TO_SUBSERVICE_CODE" );
		StrBuf.append("  , AM_GET_DESC.AM_SUBSERVICE(TO_SERVICE_CODE, TO_SUBSERVICE_CODE,'"+locale+"','2')TO_SUBSERVICE_SHORT_DESC" );
		StrBuf.append("  ,REQ_BED_CLASS_CODE" );
		StrBuf.append("  ,IP_GET_DESC.IP_BED_CLASS(REQ_BED_CLASS_CODE,'"+locale+"','2') REQ_BED_CLASS_SHORT_DESC" );
		StrBuf.append("  , REQ_BED_TYPE_CODE" );
		StrBuf.append("  , IP_GET_DESC.IP_BED_TYPE(REQ_BED_TYPE_CODE,'"+locale+"','2') REQ_BED_TYPE_SHORT_DESC" );
		StrBuf.append("  ,REQ_BED_NO" );
		StrBuf.append("  , REQ_ROOM_NO" );
		StrBuf.append("  ,TO_SPECIALTY_CODE" );
		StrBuf.append("  , AM_GET_DESC.AM_SPECIALITY(TO_SPECIALTY_CODE,'"+locale+"','2') TO_SPECIALTY_SHORT_DESC" );
		StrBuf.append("  , TO_PRACTITIONER_ID" );
		StrBuf.append("  , AM_GET_DESC.AM_PRACTITIONER(TO_PRACTITIONER_ID,'"+locale+"','1') TO_PRACTITIONER_NAME" );
		StrBuf.append("  , TO_TEAM_ID" );
		StrBuf.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(FACILITY_ID,TO_TEAM_ID,'"+locale+"','2') TO_TEAM_SHORT_DESC" );
		StrBuf.append("  ,TRN_TYPE" );
		StrBuf.append("  ,BLOCKING_PERIOD" );
		StrBuf.append("  , BLOCKING_REMARKS" );
		StrBuf.append("  ,BLOCKING_TYPE_CODE " );
		StrBuf.append("  ,DELINK_BABY_YN " );
		StrBuf.append("FROM" );
		StrBuf.append("  ip_bed_class_request " );
		StrBuf.append("WHERE encounter_id ='"+eid+"' " );
		StrBuf.append("  AND facility_id = '"+facilityId+"' " );
		StrBuf.append("  AND REQUEST_STATUS='0'" );	
		stmt  = con.createStatement();
		rset  = stmt.executeQuery(StrBuf.toString());

		if(rset!=null && rset.next())
		{
			tonursingunitcode	= checkForNull(rset.getString("REQ_NURSING_UNIT_CODE"));
			tonursingunitdesc	= checkForNull(rset.getString("REQ_NURSING_UNIT_SHORT_DESC"));
			toservicecode		= checkForNull(rset.getString("TO_SERVICE_CODE"));
			tobedclass			= checkForNull(rset.getString("REQ_BED_CLASS_CODE"));
			tobedtype			= checkForNull(rset.getString("REQ_BED_TYPE_CODE"));
			tobedtypedesc		= checkForNull(rset.getString("REQ_BED_TYPE_SHORT_DESC"));
			tobedclassdesc		= checkForNull(rset.getString("REQ_BED_CLASS_SHORT_DESC"));
			tobedno				= checkForNull(rset.getString("REQ_BED_NO"));
			toroomno			= checkForNull(rset.getString("REQ_ROOM_NO"));
			tospecialitycode	= checkForNull(rset.getString("TO_SPECIALTY_CODE"));
			tospecialitydesc	= checkForNull(rset.getString("TO_SPECIALTY_SHORT_DESC"));
			topractitionerid	= checkForNull(rset.getString("TO_PRACTITIONER_ID"));
			topractdesc			= checkForNull(rset.getString("TO_PRACTITIONER_NAME"));
			toteamid			= checkForNull(rset.getString("TO_TEAM_ID"));
			tosubservcode		= checkForNull(rset.getString("TO_SUBSERVICE_CODE"));
			TRN_TYPE 			= checkForNull(rset.getString("TRN_TYPE"));
			blocking_period 	= checkForNull(rset.getString("BLOCKING_PERIOD"));
			blocking_remark 	= checkForNull(rset.getString("BLOCKING_REMARKS"));
			blocking_type_code 	= checkForNull(rset.getString("BLOCKING_TYPE_CODE"));
			mother_bed_status	= checkForNull(rset.getString("DELINK_BABY_YN"));
			
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		}
		*/

			tonursingunitcode	= checkForNull(request.getParameter("tonursingunitcode"));
			tonursingunitdesc	= checkForNull(request.getParameter("tonursingunitdesc"));
			toservicecode		= checkForNull(request.getParameter("toservicecode"));
			tobedclass			= checkForNull(request.getParameter("tobedclass"));
			tobedtype			= checkForNull(request.getParameter("tobedtype"));
			tobedtypedesc		= checkForNull(request.getParameter("tobedtypedesc"));
			tobedclassdesc		= checkForNull(request.getParameter("tobedclassdesc"));
			tobedno				= checkForNull(request.getParameter("tobedno"));
			toroomno			= checkForNull(request.getParameter("toroomno"));
			tospecialitycode	= checkForNull(request.getParameter("tospecialitycode"));
			tospecialitydesc	= checkForNull(request.getParameter("tospecialitydesc"));
			topractitionerid	= checkForNull(request.getParameter("topractitionerid"));
			topractdesc			= checkForNull(request.getParameter("topractdesc"));
			toteamid			= checkForNull(request.getParameter("toteamid"));
			tosubservcode		= checkForNull(request.getParameter("tosubservcode"));
			TRN_TYPE 			= checkForNull(request.getParameter("TRN_TYPE"));
			blocking_period 	= checkForNull(request.getParameter("blocking_period"));
			blocking_remark 	= checkForNull(request.getParameter("blocking_remark"));
			blocking_type_code 	= checkForNull(request.getParameter("blocking_type_code"));
			mother_bed_status	= checkForNull(request.getParameter("mother_bed_status"));
	}
//Condition for Request For Transfer by kishore on 9/10/2004
	else if(call_function.equals("Request_Trasnfer") || call_function.equals("EMERGENCY_TRANSFER"))
	{
	 
		  tobedclass		= frbedclass;
		  tobedtype			= frbedtype;
		  tobedtypedesc		= frbedtypedesc;
		  tobedclassdesc	= frbedclassdesc;
		  topractitionerid	= frpractitionerid;
		  topractdesc		= frpractdesc;
		  tospecialitydesc	= frspecialitydesc;
		  tospecialitycode	= frspecialitycode;
		  toteamid			= frmedid;
		  
	}
//Condition for Transfer Patient by kishore on 9/10/2004
	else if(call_function.equals("Transfer_patient"))
	{
		  tonursingunitcode	= frnursingunitcode;
		  tonursingunitdesc	= frnursingunitdesc;
		  toservicecode		= frservicecode;
		  tosubservcode		= frsubservcode;
		  tobedclass		= frbedclass;
		  tobedtype			= frbedtype;
		  tobedtypedesc		= frbedtypedesc;
		  tobedclassdesc	= frbedclassdesc;
		  topractitionerid	= frpractitionerid;
		  topractdesc		= frpractdesc;
		  tospecialitydesc	= frspecialitydesc;
		  tospecialitycode	= frspecialitycode;
		  toteamid			= frmedid;
	}
//Condition for Confirm Request For Transfer by kishore on 9/10/2004
	else if(call_function.equals("confirm_request")||call_function.equals("cancel_request")||call_function.equals("confirm_details"))
	{
		if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
		// Changed by vinod  4:47 PM
				
		StrBuf.append("select" );
		StrBuf.append("  REQ_NURSING_UNIT_CODE NURSING_UNIT_CODE" );
		StrBuf.append("  , IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, REQ_NURSING_UNIT_CODE,'"+locale+"',2)NURSING_UNIT_SHORT_DESC" );
		StrBuf.append("  , REQ_SPECIALTY_CODE SPECIALTY_CODE" );
		StrBuf.append("  , AM_GET_DESC.AM_SPECIALITY( REQ_SPECIALTY_CODE,'"+locale+"',2) SPECIALTY_SHORT_DESC" );
		StrBuf.append("  , REQ_PRACTITIONER_ID PRACTITIONER_ID" );
		StrBuf.append("  , AM_GET_DESC.AM_PRACTITIONER(REQ_PRACTITIONER_ID,'"+locale+"',1) PRACTITIONER_NAME" );
		StrBuf.append("  , REQ_BED_CLASS_CODE BED_CLASS_CODE" );
		StrBuf.append("  , IP_GET_DESC.IP_BED_CLASS(REQ_BED_CLASS_CODE,'"+locale+"',2) BED_CLASS_SHORT_DESC" );
		StrBuf.append("  , REQ_BED_TYPE_CODE BED_TYPE_CODE" );
		StrBuf.append("  , IP_GET_DESC.IP_BED_TYPE(REQ_BED_TYPE_CODE,'"+locale+"',2) BED_TYPE_SHORT_DESC" );
		StrBuf.append("  , REQ_ROOM_NO ROOM_NO" );
		StrBuf.append("  , REQ_BED_NO BED_NO" );
		StrBuf.append("  , TFR_REQ_TYPE" );
		StrBuf.append("  , IP_GET_DESC.IP_TRANSFER_TYPE(TFR_REQ_TYPE, '"+locale+"',2) TRANSFER_TYPE_SHORT_DESC" );
		StrBuf.append("  , to_char(TFR_REQ_DATE_TIME, 'dd/mm/rrrr hh24:mi') BOOKING_DATE_TIME" );
		StrBuf.append("  , PRIORITY_CODE" );
		StrBuf.append("  , IP_GET_DESC.IP_TRANSFER_PRIORITY(FACILITY_ID,PRIORITY_CODE,'"+locale+"',2) PRIORITY_SHORT_DESC" );
		StrBuf.append("  , AM_GET_DESC.AM_SERVICE(REQ_SERVICE_CODE, '"+locale+"',2) SERVICE_SHORT_DESC" );
		StrBuf.append("  , AM_GET_DESC.AM_SUBSERVICE(REQ_SERVICE_CODE, REQ_SUBSERVICE_CODE,'"+locale+"',2) SUBSERVICE_SHORT_DESC" );
		StrBuf.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(FACILITY_ID, REQ_TEAM_ID,'"+locale+"',2) TEAM_SHORT_DESC" );
		StrBuf.append("  , REQ_TEAM_ID TEAM_ID" );
		StrBuf.append("  , REQ_SERVICE_CODE SERVICE_CODE" );
		StrBuf.append("  , REQ_SUBSERVICE_CODE SUBSERVICE_CODE " );
		StrBuf.append("from" );
		StrBuf.append("  IP_TRANSFER_REQUEST " );
		StrBuf.append("where FACILITY_ID = '"+facilityId+"' " );
		StrBuf.append("  and ENCOUNTER_ID = '"+encounterid+"' " );

		if(!call_function.equals("confirm_details"))
		{
			if(bed_class_allowed.equals("Y"))
			StrBuf.append("and BED_CLASS_REQ_STATUS='1'");
			StrBuf.append(" and TFR_REQ_TYPE='RT' and TFR_REQ_STATUS ='0' ");
			StrBuf.append(" and (PRIORITY_EXP_DATE is null or PRIORITY_EXP_DATE >= sysdate)");
		}
		else
			StrBuf.append(" and tfr_req_status = '1'");
		stmt  = con.createStatement();
		
		rset  = stmt.executeQuery(StrBuf.toString());
		if(rset!=null && rset.next())
		{
			tonursingunitcode		= checkForNull(rset.getString("nursing_unit_code"));
			tonursingunitdesc		= checkForNull(rset.getString("nursing_unit_short_desc"));
			toservicecode			= checkForNull(rset.getString("SERVICE_CODE"));
			tobedclass				= checkForNull(rset.getString("BED_CLASS_CODE"));
			tobedclassdesc			= checkForNull(rset.getString("BED_CLASS_SHORT_DESC"));
			tobedtype				= checkForNull(rset.getString("BED_TYPE_CODE"));
			tobedtypedesc			= checkForNull(rset.getString("BED_TYPE_SHORT_DESC"));
			tobedno					= checkForNull(rset.getString("bed_no"));
			toroomno				= checkForNull(rset.getString("room_no"));
			tospecialitycode		= checkForNull(rset.getString("specialty_code"));
			tospecialitydesc		= checkForNull(rset.getString("specialty_short_desc"));
			topractitionerid		= checkForNull(rset.getString("practitioner_id"));
			topractdesc			= checkForNull(rset.getString("practitioner_name"));
			toteamid					= checkForNull(rset.getString("TEAM_ID"));
			tosubservcode			= checkForNull(rset.getString("SUBSERVICE_CODE"));
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		}
	}//End Here by kishore on 9/10/2004

%>
<script>

</script>
<table border=0 width="100%"  cellspacing=0>	
			<tr>
		
       <th  class='columnheader' align=center colspan='2'><fmt:message key="eIP.CurrentOccupancy.label" bundle="${ip_labels}"/></th>
		<th   class='columnheader' align=center colspan='2'><fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/></th>
	
	</tr>
	
	<tr>
		<td colspan=4 class='CAGROUP'><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
	</tr> 
	<tr>
		<td class="label" width='25%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<td  class='querydata' width='25%' ><%=frnursingunitdesc%>
		<input type="hidden" name="fr_nursing_unit_code" id="fr_nursing_unit_code" value="<%=frnursingunitcode%>">
		<input type="hidden" name="fr_nursing_unit_desc" id="fr_nursing_unit_desc" value="<%=frnursingunitdesc%>">
		</td>
		<td class='label' width='25%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		<!--//Maheshwaran included confirm_request condition for GHL-CRF-0362-->
		<td nowrap class='fields' width='25%'><input type=text  name="nursing_unit_desc" id="nursing_unit_desc"   value="<%=tonursingunitdesc%>" maxlength=15 size=15  <%if(!call_function.equals("Transfer_patient")){%>onblur="beforeGetNursingUnit('<%=facilityId%>','<%=loginUser%>','<%=patient_class%>');CheckNursingUnit();<%if(call_function.equals("Request_Trasnfer") || call_function.equals("EMERGENCY_TRANSFER") || call_function.equals("confirm_request") ){%> enbldisbchk_tfrDtls(this);<%}%>" ><input type=button class=button name=nursing_unit_lookup id=nursing_unit_lookup value='?' onClick="NursingUnitLookup('<%=facilityId%>','<%=loginUser%>','<%=patient_class%>');" ><%}%><img align="center" src="../../eCommon/images/mandatory.gif">
		<input type=hidden name="nurs_desc_hid" id="nurs_desc_hid" value="<%=tonursingunitdesc%>">
		<input type=hidden name="nursing_unit" id="nursing_unit"   value="<%=tonursingunitcode%>">
		<input type=hidden name="additional_locale" id="additional_locale"   value="<%=locale%>">
	</td>
	
</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td  class='querydata' ><%=frservicedesc%>
				<input type="hidden" name="fr_service_code" id="fr_service_code" value="<%=frservicecode%>">
				<input type="hidden" name="fr_service_desc" id="fr_service_desc" value="<%=frservicedesc%>">
			</td>
			
			<td class="label" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name="service" id="service"  onChange='PopulateSubService()'>
			<option value="">-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>
			<%
			if(!call_function.equals("EMERGENCY_TRANSFER")){
				String sel="";
				String service_code=""; String service_desc ="";
				
				if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
								
				// Changed by Vinod 6/19/2006 4:48 PM
				StrBuf.append("SELECT" );
				StrBuf.append("  service_code" );
				StrBuf.append("  , AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc " );
				StrBuf.append("FROM" );
				StrBuf.append("  IP_NURS_UNIT_FOR_SERVICE " );
				StrBuf.append("WHERE facility_id = '"+facilityId+"' " );
				StrBuf.append("  AND nursing_unit_code = '"+tonursingunitcode+"' " );
				StrBuf.append("UNION" );
				StrBuf.append("  " );
				StrBuf.append("SELECT" );
				StrBuf.append("  service_code" );
				StrBuf.append("  , AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc " );
				StrBuf.append("FROM" );
				StrBuf.append("  IP_NURSING_UNIT " );
				StrBuf.append("WHERE facility_id = '"+facilityId+"' " );
				StrBuf.append("  AND nursing_unit_code = '"+tonursingunitcode+"' " );
				StrBuf.append("ORDER BY" );
				StrBuf.append("  2" );


				pstmt = con.prepareStatement(StrBuf.toString());
				
				rset = pstmt.executeQuery();
				if(rset!=null )
				{
					while(rset.next())
					{
						service_code  = rset.getString("service_code");
						service_desc = rset.getString("service_short_desc");
						
						if (service_code.equals(toservicecode))
							sel = "selected";
						else
							sel = "";

						out.print("<option value=\""+service_code+"\" "+sel+">"+service_desc+"");
					}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close(); 
				}
			}
		  %>
			</select><img src="../../eCommon/images/mandatory.gif">
			</td>

		</tr>
		
		<tr>
		<td class="label" ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
		<td  class='querydata' ><%=frsubservdesc%>
			<input type="hidden" name="fr_subservice_code" id="fr_subservice_code" value="<%=frsubservcode%>">
			<input type="hidden" name="fr_subservice_desc" id="fr_subservice_desc" value="<%=frsubservdesc%>">
		</td>
			<td class="label" ><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
		
			<td class='fields'><select name="sub_service" id="sub_service"><option value="">-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>
			<%	
			try
			{
				if(!call_function.equals("EMERGENCY_TRANSFER")){
					String subservice_code = "", subservice_desc = "";
					if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());

				   // Changed By vinod 6/19/2006 4:49 PM
					StrBuf.append("SELECT" );
					StrBuf.append("  service_code" );
					StrBuf.append("  ,am_get_desc.am_service(service_code,'"+locale+"',2) service_short_desc" );
					StrBuf.append("  , subservice_code" );
					StrBuf.append("  ,am_get_desc.am_subservice(service_code,subservice_code,'"+locale+"',2) subservice_short_desc " );
					StrBuf.append("FROM" );
					StrBuf.append("  AM_FACILITY_SUBSRVC " );
					StrBuf.append("WHERE operating_facility_id = '"+facilityId+"' " );
					StrBuf.append("  AND service_code = '"+toservicecode+"' " );
					StrBuf.append("  AND eff_status = 'E' " );
					StrBuf.append("ORDER BY" );
					StrBuf.append("  2 " );
	
					pstmt = con.prepareStatement(StrBuf.toString());
					rset = pstmt.executeQuery();
					if(rset!=null)
					{
						while(rset.next())
						{
						subservice_code  = rset.getString("subservice_code");
						subservice_desc = rset.getString("subservice_short_desc");

						if (subservice_code.equals(tosubservcode))
							subsel = "selected";
						else
							subsel = "";
						out.print("<option value=\""+subservice_code+"\" "+subsel+">"+subservice_desc+"");
						}
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					}
				}
			}catch(Exception e)
			{
				//out.println("<script>alert('Exception : "+e.toString()+"');</script>");
				e.printStackTrace();
			}
			
			%>
			</select>
			</td>
			
		</tr>
		<%
		if(!call_function.equals("Change_Bedclass")&& !call_function.equals("confirm_request") && !call_function.equals("cancel_request") && !call_function.equals("confirm_details")){

		if(bed_class_allowed.equals("Y")){
		%>
		<tr>
			<%
				if(!call_function.equals("EMERGENCY_TRANSFER")){
			%>
				<td class="label" ><fmt:message key="eIP.RequestBedClassChange.label" bundle="${ip_labels}"/></td>
				<td  class='querydata'  ><fmt:message key="eIP.RequestBedClassChange.label" bundle="${ip_labels}"/></td>
				<td class="label" >&nbsp;</td>
					<td class='fields'><input type='checkbox' name='bed_change' id='bed_change'  onClick="setEnable_tfrDtls();" <%if(call_function.equals("Request_Trasnfer") || func_id.equals("MODIFY_SERVICE_INPATIENT")){%> disabled <%}%>>
				</td>
		<%}%>
		</tr>
		<%
		}
	 }//close of if, this if will not let change bed class in Bed Class change
		%>
		<tr>
			<td class="label" ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			<td class='querydata'  ><%=frbedclassdesc%>
				<input type="hidden" name="fr_bed_class" id="fr_bed_class" value="<%=frbedclass%>" >
			</td>
			<%if(call_function.equals("EMERGENCY_TRANSFER")){
				if(!call_function.equals("Change_Bedclass")&& !call_function.equals("confirm_request") && !call_function.equals("cancel_request") && !call_function.equals("confirm_details")){

				if(bed_class_allowed.equals("Y")){
			%>
				<td class="label" ><fmt:message key="eIP.RequestBedClassChange.label" bundle="${ip_labels}"/></td>
				<td class='fields'><input type='checkbox' name='bed_change' id='bed_change'  onClick="setEnable_tfrDtls();"  disabled>
			</td>
			<%}}}else {%>
			<td class="label" ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>	

			<td  class='fields'>
				<select name='Bedcode' id='Bedcode' onChange='getBedtype_tfrDtls();'  <%=isenable%>>
					<option value="">-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>
					<%
					//Maheshwaran added if condition to populate bed class on load of this pagefor GHL-CRF-0362
					//Start
					if(call_function.equals("confirm_request"))
						{
						try{
						if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
//						StrBuf.append("Select bed_class_code,ip_get_desc.ip_bed_class(bed_class_code,'"+locale+"',2)short_desc from IP_BED_CLASS where eff_status='E'  tonursingunitcodeorder by short_desc ");
						StrBuf.append("SELECT DISTINCT bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,?,2) short_desc FROM ip_nursing_unit_bed WHERE facility_id = ? AND eff_status = 'E' AND nursing_unit_code = ?  ORDER BY short_desc");
						String bedcode="";
						String beddesc="";
						pstmt = con.prepareStatement(StrBuf.toString());
						pstmt.setString(1,locale);
						pstmt.setString(2,facilityId);
						pstmt.setString(3,tonursingunitcode);
						rset = pstmt.executeQuery();
						if( rset != null )
							{
							while( rset.next() )
								{
								bedcode   = rset.getString("bed_class_code") ;
								beddesc   = rset.getString("short_desc") ;
								if (bedcode.equals(tobedclass))
									{
									subsel = "selected";					
									}
								else
								subsel = "";
								out.println("<option value=\""+bedcode+"\" "+subsel+">"+beddesc+"</option>");
								}
								if(rset!=null) rset.close();
								if(pstmt!=null) pstmt.close();
							}
						}catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
			
						}
					else
						{
						%><option value="<%=tobedclass%>" selected><%=tobedclassdesc%></option>
						<%}
						//End
						%>
					</select>
	<%
		if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
	%>
	<img src='../../eCommon/images/mandatory.gif'align='center'></img >
	<%
		}
	%>
	<input type="hidden" name="hid_bed_class" id="hid_bed_class" <%if(call_function.equals("Change_Bedclass")){%> value="<%=tobedclass%>"  disabled <%}else{%>   value="<%=frbedclass%>" ><%}%>

<input type="hidden" name="hid_bed_class_descn" id="hid_bed_class_descn" <%if(call_function.equals("Change_Bedclass")){%> value="<%=tobedclassdesc%>"  disabled <%}else{%>   value="<%=frbedclassdesc%>"<%}%> >

	</td>
		<%}%>
		
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
			<td class='querydata'  >
				<input type="hidden" name="fr_bed_type" id="fr_bed_type" value="<%=frbedtype%>" ><%=frbedtypedesc%></td>

		<%if(call_function.equals("EMERGENCY_TRANSFER")){%>
			<td class="label" ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>	

			<td  class='fields'>
				<select name='Bedcode' id='Bedcode' onChange='getBedtype_tfrDtls();'  <%=isenable%>><option value="">-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>
	<%
		try{
			
			if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
	
				//StrBuf.append("Select bed_class_code,short_desc from IP_BED_CLASS_LANG_VW where language_id='"+locale+"' and  eff_status='E' order by short_desc ");
				/*Wednesday, April 28, 2010 , modified for PE*/
				StrBuf.append("Select bed_class_code,ip_get_desc.ip_bed_class(bed_class_code,'"+locale+"',2)short_desc from IP_BED_CLASS where eff_status='E' order by short_desc ");
			

			String bedcode="";
			String beddesc="";
			pstmt = con.prepareStatement(StrBuf.toString());
			rset = pstmt.executeQuery();

			if( rset != null )
				{
				  while( rset.next() )
				  {
					bedcode   = rset.getString("bed_class_code") ;
					 beddesc   = rset.getString("short_desc") ;

					if (bedcode.equals(tobedclass))
					  {
						subsel = "selected";					
					  }
					else
						subsel = "";
					out.println("<option value=\""+bedcode+"\" "+subsel+">"+beddesc+"</option>");
					}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				}
			}catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
		
	%>

	</select>
	<%
		if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
	%>
	<img src='../../eCommon/images/mandatory.gif'align='center'></img >
	<%
		}
	%>
	<input type="hidden" name="hid_bed_class" id="hid_bed_class" <%if(call_function.equals("Change_Bedclass")){%> value="<%=tobedclass%>"  disabled <%}else{%>   value="<%=frbedclass%>" ><%}%>

<input type="hidden" name="hid_bed_class_descn" id="hid_bed_class_descn" <%if(call_function.equals("Change_Bedclass")){%> value="<%=tobedclassdesc%>"  disabled <%}else{%>   value="<%=frbedclassdesc%>"<%}%> >

	</td>
<%}else{%>
			<td class="label" ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<select name='bed_type_code' id='bed_type_code' onChange='ChangeBedtype_tfrDtls();' <%=isenable%>>
			<option value="" >-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>
			<%
			//Maheshwaran added if condition to populate bed type on load of this pagefor GHL-CRF-0362
			//Start
			if(call_function.equals("confirm_request")){
			try{
			if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
			StrBuf.append("SELECT DISTINCT bed_type_code ,ip_get_desc.ip_bed_type(bed_type_code,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED WHERE facility_id = '"+facilityId+"' AND nursing_unit_code = '"+tonursingunitcode+"' AND bed_class_code = '"+tobedtype+"' AND eff_status='E'  ORDER BY short_desc");
			pstmt = con.prepareStatement(StrBuf.toString());
			rset = pstmt.executeQuery();
			if( rset != null )
				{
				 while( rset.next() )
				  {
					String short_desc = rset.getString( "short_desc" ) ;
					String bed_type_code = rset.getString( "bed_type_code" ) ;
					if (bed_type_code.equals(tobedtype))
					  {
						subsel = "selected";					
					  }
					else
					subsel = "";
					out.println("<option value=\""+bed_type_code+"\" "+subsel+">"+short_desc+"</option>");
					}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				}
			}catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
			}
			else
				{
				%>
				<option value="<%=frbedtype%>" selected><%=frbedtypedesc%></option>
				<%
				}
				//End
			%>
			</select>
	<%
		if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
	%>
	<img align="center" id=''  src="../../eCommon/images/mandatory.gif"></img>
	<%
		}
	%>
			<input type="hidden" name="hid_bed_type" id="hid_bed_type" value="<%=tobedtype%>" >
			<input type="hidden" name="hid_tobedtypedesc" id="hid_tobedtypedesc" value="<%=tobedtypedesc%>" >
			</td>
		<%}%>
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			<td class='querydata'  ><input type="hidden" name="fr_bed_no" id="fr_bed_no" value="<%=frbedno%>"><%=frbedno%></td>
			
		<%if(call_function.equals("EMERGENCY_TRANSFER")){%>
			<td class="label" ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name='bed_type_code' id='bed_type_code' onChange='ChangeBedtype_tfrDtls();' <%=isenable%>><option value="" >-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>
		<%
		try{
			
			if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
			//StrBuf.append("Select short_desc,bed_type_code from IP_BED_TYPE_LANG_VW where language_id='"+locale+"' and eff_status='E' order by short_desc ");
			/*Wednesday, April 28, 2010 , modified for PE*/
			StrBuf.append("Select ip_get_desc.IP_BED_TYPE(bed_type_code,'"+locale+"',2)short_desc,bed_type_code from IP_BED_TYPE where eff_status='E' and bed_type_code like '%%'  order by short_desc ");
			pstmt = con.prepareStatement(StrBuf.toString());
			rset = pstmt.executeQuery();
				if( rset != null )
				{
				  while( rset.next() )
				  {
					String short_desc = rset.getString( "short_desc" ) ;
					String bed_type_code = rset.getString( "bed_type_code" ) ;
					if (bed_type_code.equals(tobedtype))
					  {
						subsel = "selected";					
					  }
					else
						subsel = "";
					
					out.println("<option value=\""+bed_type_code+"\" "+subsel+">"+short_desc+"</option>");
					}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				}
			}catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
		
	%></select>
	<%
		if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
	%>
	<img align="center" id=''  src="../../eCommon/images/mandatory.gif"></img>
	<%
		}
	%>
	<input type="hidden" name="hid_bed_type" id="hid_bed_type" value="<%=tobedtype%>" >
		<input type="hidden" name="hid_tobedtypedesc" id="hid_tobedtypedesc" value="<%=tobedtypedesc%>" >
			</td>
		<%}else{ %>
			<!-- Modified by Sangeetha on 25/05/17 for GDOH-CRF-0151-->
			<td class="label" ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="to_bed_no" id="to_bed_no"  value="<%=tobedno%>" size=8 maxlength=8 onBlur="ChangeUpperCase(this);getRoomNo_tfrDtls(this);<% if(restrictPseudoBed){ %>chkforVacantNormalBed();<% }%>" onKeyPress='return CheckForSpecChars(event)' onchange='clearRoom();' readOnly><input type="button" class="button" value="?" id='bedlookkup' name="bed_avail_chart" id="bed_avail_chart" <% if(restrictPseudoBed){ %>onblur="chkforVacantNormalBed()" <% }%> onclick="callBedAvailChart_tfrDtls();" <%=isenable%>>
			<%
			if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
			{
			%>
				<img align="center" id='bedoimg'  src="../../eCommon/images/mandatory.gif"></img>
			<%
			}
			%>
			<input type="hidden" name="hid_tobedno" id="hid_tobedno" value="<%=tobedno%>">
			</td>
<%}%>	
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
			<td class='querydata'  ><input type="hidden" name="fr_room_no" id="fr_room_no"  value="<%=frroomno%>"><%=frroomno%></td>

<%if(call_function.equals("EMERGENCY_TRANSFER")){%>
<!-- Modified by Sangeetha on 25/05/17 for GDOH-CRF-0151-->
<td class="label" ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type="text" name="to_bed_no" id="to_bed_no"  value="<%=tobedno%>" size=8 maxlength=8 onBlur="ChangeUpperCase(this);getRoomNo_tfrDtls(this);<% if(restrictPseudoBed){ %>chkforVacantNormalBed();<% }%>" onKeyPress='return CheckForSpecChars(event)' onchange='clearRoom();' readOnly><input type="button" class="button" value="?" id='bedlookkup' name="bed_avail_chart" id="bed_avail_chart" <% if(restrictPseudoBed){ %>onblur="chkforVacantNormalBed()" <% }%>  onclick="callBedAvailChart_tfrDtls();" <%=isenable%>>
			<%
			if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
			{
			%>
				<img align="center" id='bedoimg'  src="../../eCommon/images/mandatory.gif"></img>
			<%
			}
			%>
			<input type="hidden" name="hid_tobedno" id="hid_tobedno" value="<%=tobedno%>">
			</td>
<%}else{%>
			<td class="label" ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/><input type="hidden" name="hid_toroomno" id="hid_toroomno"  value="<%=toroomno%>"></td>
			<td class='fields'><input type="text" name="to_room_no" id="to_room_no"  value="<%=toroomno%>" size=10 maxlength=10 onBlur="specialChar(this,'Char')" readonly = true></td>
<%}%>	
		</tr>		
		
		<tr>
			<td class="label" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='querydata'  ><%=frspecialitydesc%>
				<input type="hidden" name="fr_speciality_code" id="fr_speciality_code" value="<%=frspecialitycode%>">
			</td>

<%if(call_function.equals("EMERGENCY_TRANSFER")){%>
<td class="label" ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/><input type="hidden" name="hid_toroomno" id="hid_toroomno"  value="<%=toroomno%>"></td>
			<td class='fields'><input type="text" name="to_room_no" id="to_room_no"  value="<%=toroomno%>" size=10 maxlength=10 onBlur="specialChar(this,'Char')" readonly = true></td>
<%}else{%>
			<td class="label" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text name='Splcode_desc' id='Splcode_desc' maxlength=15 size=15 <%if(!call_function.equals("EMERGENCY_TRANSFER")){%> value="<%=tospecialitydesc%>" <%}%> onFocus="checkForNursing();" onblur="clearVal_tfrDtls(this);BeforeGetSpecialty(this, '<%=facilityId%>');"  <%=isreadonly%> <%=isenable%>><input type=button name='Splcode_lookup' id='Splcode_lookup'id='splid' value='?' class=button onFocus="checkForNursing();"  onClick="checkTxtVal(Splcode_desc, '<%=facilityId%>');" <%=isenable%>>
			<%
			if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
			{
			%>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			<%
			}
			%>
			</td>

			<input type=hidden name='Splcode' id='Splcode'  value="<%=tospecialitycode%>" >
			<input type=hidden name="spec_desc_hid" id="spec_desc_hid" value="<%=tospecialitydesc%>">

<%}%>		
		</tr>
		<tr>
			
			<td class="label" ><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
			<td class='querydata' nowrap id="PractDesc"  ><%=frpractdesc%>
				<input type="hidden" name="fr_practitioner_id" id="fr_practitioner_id" value="<%=frpractitionerid%>">
			</td>

<%if(call_function.equals("EMERGENCY_TRANSFER")){%>
<td class="label" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text name='Splcode_desc' id='Splcode_desc' maxlength=15 size=15 <%if(!call_function.equals("EMERGENCY_TRANSFER")){%> value="<%=tospecialitydesc%>" <%}%> onFocus="checkForNursing();" onblur="clearVal_tfrDtls(this);BeforeGetSpecialty(this, '<%=facilityId%>');"  <%=isreadonly%> <%=isenable%>><input type=button name='Splcode_lookup' id='Splcode_lookup'id='splid' value='?' class=button onFocus="checkForNursing();"  onClick="checkTxtVal(Splcode_desc, '<%=facilityId%>');" <%=isenable%>>
			<%
			if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
			{
			%>
				<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			<%
			}
			%>
			</td>

			<input type=hidden name='Splcode' id='Splcode'  value="<%=tospecialitycode%>" >
			<input type=hidden name="spec_desc_hid" id="spec_desc_hid" value="<%=tospecialitydesc%>">
<%}else{%>
			<td class="label" ><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
			<td nowrap class='fields'><input type='hidden' name='practid' id='practid' value="<%=topractitionerid%>">
			
				<input type='text' name='pract_desc' id='pract_desc' size='30' maxlength='30'  <%if(!call_function.equals("EMERGENCY_TRANSFER")){%>    value="<%=topractdesc%>" <%}%> onblur="BeforeGetPractitioner(document.forms[0].practid,pract_desc, '<%=facilityId%>');" onFocus="checkForValues();"  <%=isreadonly%> <%=isenable%>><input type='button' name='pract_id_search' id='pract_id_search' value='?' id='practlookup' class='button' onClick="checkPractTxtVal(document.forms[0].practid,pract_desc, '<%=facilityId%>');" onFocus="checkForValues();"  <%=isenable%>>
			<%
				if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
				{
			%>
			<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			<%
				}
			%>
			<input type=hidden name="pract_desc_hid" id="pract_desc_hid" value="<%=topractdesc%>" >
			<!--//Maheshwaran added for GHL-CRF-0362-->
			<input type=hidden name="practid4" id="practid4" value="<%=topractitionerid%>" >
			</td>			
		
<%}%>		
		</tr>
		<tr>
			<td class="label" ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
			<td  class='querydata'  id="MedTeamDesc"><%=frmeddesc%>
			<input type="hidden" name="fr_team_id" id="fr_team_id" value="<%=frmedid%>">
			</td>

<%if(call_function.equals("EMERGENCY_TRANSFER")){%>
<td class="label" ><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
			<td nowrap class='fields'><input type='hidden' name='practid' id='practid' value="<%=topractitionerid%>">
			
			<input type='text' name='pract_desc' id='pract_desc' size='30' maxlength='30'  <%if(!call_function.equals("EMERGENCY_TRANSFER")){%>    value="<%=topractdesc%>" <%}%> onblur="BeforeGetPractitioner(document.forms[0].practid,pract_desc, '<%=facilityId%>');" onFocus="checkForValues();"  <%=isreadonly%> <%=isenable%>><input type='button' name='pract_id_search' id='pract_id_search' value='?' id='practlookup' class='button' onClick="checkPractTxtVal(document.forms[0].practid,pract_desc, '<%=facilityId%>');" onFocus="checkForValues();"  <%=isenable%>>
			<%
				if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
				{
			%>
			<img align="center" src="../../eCommon/images/mandatory.gif"></img>
			<%
				}
			%>
			<input type=hidden name="pract_desc_hid" id="pract_desc_hid" value="<%=topractdesc%>" >
			</td>	
<%}else{%>
			<td  class="label"><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/><input type="hidden" name="selecTeam" id="selecTeam" value="<%=toteamid%>"></td>
		<!-- added by raghavendra for confirm bed class... -->
			<td nowrap class='fields'><select name="team_id" id="team_id" <%=isenable%>>
					<option value='' >-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>		
<%
					if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
					StrBuf.append(" select team_id,am_get_desc.am_medical_team(facility_id,team_id,'"+locale+"',2) team_short_desc from am_pract_for_team_vw where facility_id = '"+facilityId+"' and practitioner_id ='"+topractitionerid+"' and speciality_code = '"+tospecialitycode+"'");
					pstmt = con.prepareStatement(StrBuf.toString());
					rset = pstmt.executeQuery();
					if(rset!= null)
					{
						while(rset.next())
						{				
							medcode = rset.getString("team_id");
							if(medcode == null) medcode="";
							meddesc = rset.getString("team_short_desc");
							String optSelected="";
							if(medcode.equals(toteamid))
								optSelected="selected";
							else
								optSelected="";
							out.println("<option value=\""+medcode+"\"" +optSelected+">"+meddesc+"</option>");				
						}			
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					}					
%>					
			
	</select></td>
	<%}%>	
		</tr>
<%if(call_function.equals("EMERGENCY_TRANSFER")){%>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td  class="label"><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/><input type="hidden" name="selecTeam" id="selecTeam" value="<%=toteamid%>"></td>
		<!-- added by raghavendra for confirm bed class... -->
			<td nowrap class='fields'><select name="team_id" id="team_id" <%=isenable%>>
					<option value='' >-----&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;-----</option>		
<%
					if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
					StrBuf.append(" select team_id,am_get_desc.am_medical_team(facility_id,team_id,'"+locale+"',2) team_short_desc from am_pract_for_team_vw where facility_id = '"+facilityId+"' and practitioner_id ='"+topractitionerid+"' and speciality_code = '"+tospecialitycode+"'");
					pstmt = con.prepareStatement(StrBuf.toString());
					rset = pstmt.executeQuery();
					if(rset!= null)
					{
						while(rset.next())
						{				
							medcode = rset.getString("team_id");
							if(medcode == null) medcode="";
							meddesc = rset.getString("team_short_desc");
							String optSelected="";
							if(medcode.equals(toteamid))
								optSelected="selected";
							else
								optSelected="";
							out.println("<option value=\""+medcode+"\"" +optSelected+">"+meddesc+"</option>");				
						}			
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					}					
%>					
			
	</select></td>
	</tr>
<%}%>
		</table>
	 <!--below line added for this CRF GHL-CRF-0340 -->     
	 <input type="hidden" name="specialtyCheck" id="specialtyCheck" value="0">   
	 <input type="hidden" name="practitionerCheck" id="practitionerCheck" value="0"> 
     <input type="hidden" name="request_facilityId" id="request_facilityId" value="<%=facilityId%>">   	 
	 <!--End GHL-CRF-0340 -->
	
	<input type="hidden" name="locale1" id="locale1" value="<%=locale%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
	<input type="hidden" name="from_bed_type" id="from_bed_type" value="<%=frbedtype%>">
	<input type="hidden" name="patient_id2" id="patient_id2" value="<%=patientid%>">	
	<input type="hidden" name="function_ID" id="function_ID" value="<%=call_function%>">	
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
	<input type="hidden" name="to_daily_rate" id="to_daily_rate"  value="<%=frdailycharge%>">
	<input type="hidden" name="bed_class_allowed" id="bed_class_allowed" value="<%=bed_class_allowed%>">
	<input type="hidden" name="ipparam_bed_yn" id="ipparam_bed_yn" value="<%=bed_class_allowed%>">
	<input type="hidden" name="age" id="age" value="<%=age%>">
	<input type="hidden" name="gender" id="gender" value="<%=gender%>">
	<input type="hidden" name="tfr_type" id="tfr_type" value="<%=TRN_TYPE%>">
	<input type="hidden" name="pseudo_bed_yn" id="pseudo_bed_yn" value="">
	<input type="hidden" name="deactivate_pseudo_bed_yn" id="deactivate_pseudo_bed_yn" value="<%=deactivate_pseudo_bed_yn%>">
	<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
	<input type="hidden" name="admissiondate" id="admissiondate" value="<%=admissiondate%>">
	<%if(call_function.equals("Change_Bedclass"))
	{%>
	<input type="hidden" name="bed_blocking_period" id="bed_blocking_period" value="<%=blocking_period%>">
	<input type="hidden" name="bed_block_remarks" id="bed_block_remarks" value="<%=blocking_remark%>">
	<input type="hidden" name="blocking_type_code" id="blocking_type_code" value="<%=blocking_type_code%>">
	<input type="hidden" name="mother_bed_status" id="mother_bed_status" value="<%=mother_bed_status%>">
	<input type="hidden" name="override_yn" id="override_yn" value="<%=overrideyn%>">	
	<%}%>	
	
		<script>
		var count=0
			if(count==0)
			{
				
			}
		//Added by Kishore on 9/7/2004
		<%if(call_function.equals("Change_Bedclass"))
		{%>
			document.forms[0].Bedcode.disabled=true;
			document.forms[0].bed_type_code.disabled=true;
			document.forms[0].sub_service.disabled=true;
			document.forms[0].service.disabled=true;
			document.forms[0].team_id.disabled=true;
			document.getElementById("practlookup").disabled=true;
			document.forms[0].pract_desc.disabled=true;
			document.getElementById('rejection').style.visibility	    =	"Hidden";
			document.forms[0].to_bed_no.disabled=true;
			document.forms[0].to_room_no.disabled=true;
			document.getElementById('bedlookkup').disabled=true;
			document.getElementById('bedoimg').style.visibility	    =	"Hidden";
			document.getElementById('splid').disabled=true;
			document.forms[0].Splcode_desc.disabled=true;
			document.forms[0].nursing_unit_desc.disabled=true;
			document.forms[0].nursing_unit_lookup.disabled=true;
		<%}
		else if(call_function.equals("Request_Trasnfer")){%>
			document.forms[0].to_bed_no.disabled=true;
			document.forms[0].to_room_no.disabled=true;
			document.getElementById('bedlookkup').disabled=true;
			document.getElementById('bedoimg').style.visibility	    =	"Hidden";	

		<%}
		else if(call_function.equals("cancel_request")||call_function.equals("confirm_details")){%>
	//else if(call_function.equals("confirm_request")||call_function.equals("cancel_request")||call_function.equals("confirm_details")){%>
			<%if(bed_class_allowed.equals("Y")){
			%>
			document.forms[0].Bedcode.disabled=true;
			document.forms[0].bed_type_code.disabled=true;
			<%}%>
			document.forms[0].bed_type_code.disabled=true;
			document.forms[0].nursing_unit_desc.disabled=true;
			document.forms[0].nursing_unit_lookup.disabled=true;
			document.forms[0].sub_service.disabled=true;
			document.forms[0].service.disabled=true;
			document.forms[0].team_id.disabled=true;
			document.getElementById("practlookup").disabled=true;
			document.forms[0].pract_desc.disabled=true;
			document.forms[0].to_room_no.readOnly=true;
			<%if(call_function.equals("cancel_request")||call_function.equals("confirm_details"))
			{%>
			document.forms[0].to_bed_no.disabled=true;
			document.getElementById('bedlookkup').disabled=true;
			document.getElementById('bedoimg').style.visibility	    =	"Hidden";
			<%}%>
			document.getElementById('splid').disabled=true;
			document.forms[0].Splcode_desc.disabled=true;;
		<%}
		else if(call_function.equals("Transfer_patient")){%>
			document.forms[0].nursing_unit_desc.readOnly=true;
		<%}else if(call_function.equals("EMERGENCY_TRANSFER")){%>
			/*document.forms[0].to_bed_no.disabled=true;
			document.forms[0].to_room_no.disabled=true;
			document.getElementById('bedlookkup').disabled=true;
			document.getElementById('bedoimg').style.visibility	    =	"Hidden";	
			*/
		<%} else if(call_function.equals("confirm_request")) {%>
		document.forms[0].Bedcode.disabled=false;
		document.forms[0].bed_type_code.disabled=false;
		<%}%>
		</script>
	<%		
		if(stmt   != null)			stmt.close();
		if(rset	  != null)			rset.close();
	}catch(Exception e)
	{
		//out.print("Exception TransferDetails:"+e);
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}
	 %>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>


