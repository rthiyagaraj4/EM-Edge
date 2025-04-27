<!DOCTYPE html>
<!--
		Author: Arun
		Date	  : 4th sep 2003
-->
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*" %>
<%
	
	Connection con		= null;	
	PreparedStatement		pstmtAdmDateType	=	null ;
	ResultSet rsAdmDateType		= null;		
	PreparedStatement		pstmtIPTransferDetails	=	null ;
	ResultSet  rsIPTransferDetails = null;	
	PreparedStatement pstmtBedStatus =null;
	ResultSet rsBedStatus = null;
	PreparedStatement pstmtReasonForCancel =null;
	ResultSet rsReasonForCancel = null;
	PreparedStatement	pstmtGenderSex =null;
	ResultSet rsGenderSex = null;
	PreparedStatement pstmtBooking = null;
	ResultSet rsBedBooking=null;
	
	// By Annadurai 3/31/2004 for Billing starts
	PreparedStatement	billingPstmt	= null;
	ResultSet			billingResult	= null;
	
	String facilityId	= (String)session.getValue("facility_id");
	
try{
	con =ConnectionManager.getConnection(request);	
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../js/CancelTransfer.js" language="javascript"></script>
	
	<script src="../../eCommon/js/dchk.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
			request.setCharacterEncoding("UTF-8");
			String patientid	= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			String eid		= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
			long    encounterid	= Long.parseLong(eid);
			String strSrlNo = request.getParameter("srlno");
			String strCountry =request.getParameter("country");

			String sqlAdmission		= "";
			String sqlGenderSex = "";
			String admissiondate	= "";
			String admissiontype	= "";
			String frTrnDate_Time = "";
			String frTrnType = "";
			String frpractitionerid	= "";
			String currPractitionerid ="";
			String frpractdesc	= "";
			String currPractdesc = "";
			String frspecialitycode	= "";
			String currSpecialitycode = "";
			String frspecialitydesc	= "";
			String currSpecialitydesc = "";
			String frbedclass	= "";
			String currBedclass = "";
			String frbedclassdesc	= "";
			String currBedclassdesc = "";
			String frnursingunitcode= "";
			String currNursingunitcode ="";
			String frnursingunitdesc= "";
			String currNursingunitdesc = "";
			String frbedno		= "";
			String currBedno = "";
			String frroomno		= "";
			String currRoomno="";
			String frbedtype	= "";
			String frmeddesc	= "";	
			String currMeddesc = "";
			String frservicecode = "";
			String frservicedesc = "";
			String currServicedesc = "";
			String strPrevBedStatus ="O";	
			String strDisabled ="";
			String strGender = "";
			String strAge = "";
			String date_of_birth = "";

			// By Annadurai.N 3/31/2004 Billing starts., 
			String			bl_interfaced_yn	= "";
			String			oldBillingYN		= "";
			String			oldBillingString	= "";
			String			chargeExists		= "";
			StringBuffer	bl_query			= new StringBuffer();
			
			try
			{
				bl_query.append("select nvl(bl_interfaced_yn,'N') bl_interfaced_yn ");
				bl_query.append("from ip_param where facility_id = '");
				bl_query.append(facilityId);
				bl_query.append("'");
				
				billingPstmt	= con.prepareStatement(bl_query.toString());
				billingResult	= billingPstmt.executeQuery();
				if (billingResult != null)
					if (billingResult.next())
						bl_interfaced_yn = checkForNull(billingResult.getString("bl_interfaced_yn"));
				
				if (billingPstmt != null)	billingPstmt	= null;
				if (billingResult != null)	billingResult	= null;
				
				if (bl_interfaced_yn.equals("Y"))
				{
					oldBillingString	= "select BL_CHECK_OLD_BILLING_YN oldBillingYN from dual";
					billingPstmt		= con.prepareStatement(oldBillingString);
					billingResult		= billingPstmt.executeQuery();
					
					if (billingResult != null)
						if (billingResult.next())
							oldBillingYN = checkForNull(billingResult.getString("oldBillingYN"));
					
					if (billingPstmt != null)	billingPstmt	= null;
					if (billingResult != null)	billingResult	= null;
					
					if (oldBillingYN.equals("N"))
					{
						StringBuffer blStageQuery = new StringBuffer();
						
						blStageQuery.append("select Bl_IP_DETAILS.GET_CHARGE_EXISTS_AFTER_TFR('"); 
						blStageQuery.append(facilityId); 
						blStageQuery.append("', "); 
						blStageQuery.append(encounterid); 
						blStageQuery.append(", "); 
						blStageQuery.append(strSrlNo); 
						blStageQuery.append(") chargeExists from dual "); 
						
						billingPstmt	= con.prepareStatement(blStageQuery.toString());
						billingResult	= billingPstmt.executeQuery();
						if (billingResult != null)
							if (billingResult.next())
								chargeExists = checkForNull(billingResult.getString("chargeExists"));
						
						if (billingPstmt != null)	billingPstmt	= null;
						if (billingResult != null)	billingResult	= null;
					}
				}
			}
			catch(Exception exception)
			{
				out.println(exception.toString());
			}
			finally
			{
					if (billingPstmt  != null)	billingPstmt.close();
					if (billingResult != null)	billingResult.close();
			}
			// By Annadurai.N 3/31/2004 Billing end., 

			sqlGenderSex="SELECT  get_age(date_of_birth) age ,sex, to_char(date_of_birth,'dd/mm/rrrr') date_of_birth from mp_patient where patient_id = '"+patientid+"' ";
			pstmtGenderSex = con.prepareStatement(sqlGenderSex);
			rsGenderSex     = pstmtGenderSex.executeQuery();
			try{
				if(rsGenderSex.next())
				{
					strGender		= rsGenderSex.getString("sex");
					strAge			=	rsGenderSex.getString("age");
					date_of_birth	=	rsGenderSex.getString("date_of_birth");
				}

			}catch(Exception e)
			{
				out.print(e);
			}
			finally
			{
					if(pstmtGenderSex != null)pstmtGenderSex.close();
					if(rsGenderSex != null)rsGenderSex.close();
			}

			sqlAdmission = "SELECT to_char(a.visit_adm_date_time,'dd/mm/rrrr hh24:MI')visit_adm_date_time,b.short_desc FROM pr_encounter a,ip_admission_type b WHERE a.facility_id='"+facilityId+"' AND a.encounter_id = "+encounterid+" AND a.visit_adm_type = b.admission_type_code" ;	
			try
			{
				pstmtAdmDateType = con.prepareStatement(sqlAdmission);
				rsAdmDateType     = pstmtAdmDateType.executeQuery();
					if(rsAdmDateType.next())
					{
						admissiondate		= rsAdmDateType.getString("visit_adm_date_time") ==null ? "": rsAdmDateType.getString("visit_adm_date_time");  
						admissiontype		= rsAdmDateType.getString("short_desc") ==null ? "": rsAdmDateType.getString("short_desc");				
					}
			 }
			 catch(Exception e)
			{
				 out.print(e);
			}
			finally
			{
					if(rsAdmDateType != null)rsAdmDateType.close();
					if(pstmtAdmDateType != null)pstmtAdmDateType.close();
			}

				String sqlIPTranferDetails = "SELECT to_char(A.trn_date_time,'dd/mm/rrrr hh24:MI')trn_date_time,A.fr_bed_no,A.to_bed_no,A.fr_room_no,A.to_room_no,A.fr_nursing_unit_code,A.to_nursing_unit,A.fr_service_code,A.to_service_code,A.fr_bed_class_code,A.to_bed_class_code,A.fr_bed_type_code,A.to_bed_type_code,A.fr_practitioner_id,A.to_practitioner_id,A.fr_specialty_code,A.to_specialty_code,A.from_pract_team_id,A.to_pract_team_id,B.short_desc transfer_type_desc ,C.short_desc fr_nursing_unit_desc,D.short_desc to_nursing_unit_desc,E.short_desc fr_service_desc,F.short_desc to_service_desc,G.short_desc fr_bed_class_desc,H.short_desc to_bed_class_desc,I.short_desc fr_specialty_desc,J.short_desc to_specialty_desc,K.practitioner_name fr_practitioner_name,L.practitioner_name to_practitioner_name,M.short_desc fr_pract_team_desc,N.short_desc to_pract_team_desc FROM IP_ADT_TRN A, IP_TRANSFER_TYPE B, IP_NURSING_UNIT C, IP_NURSING_UNIT D, AM_SERVICE E, AM_SERVICE F, IP_BED_CLASS G, IP_BED_CLASS H, AM_SPECIALITY I,  AM_SPECIALITY J, AM_PRACTITIONER K,AM_PRACTITIONER L, AM_MEDICAL_TEAM M, AM_MEDICAL_TEAM N where A.Facility_id = '"+facilityId+"'  and A.srl_no= "+strSrlNo+"  and A.encounter_id= "+encounterid+" and A.trn_code = B.transfer_type_code and A.facility_id = C.facility_id and A.fr_nursing_unit_code = C.nursing_unit_code and A.facility_id = D.facility_id and A.to_nursing_unit = D.nursing_unit_code and A.fr_service_code = E.service_code (+) and A.to_service_code = F.service_code (+) and A.fr_bed_class_code = G.bed_class_code and A.to_bed_class_code = H.bed_class_code and A.fr_specialty_code = I.speciality_code (+) and A.to_specialty_code = J.speciality_code (+) and A.fr_practitioner_id = K.practitioner_id (+) and A.to_practitioner_id = L.practitioner_id (+) and A.facility_id =	M.facility_id (+) and A.from_pract_team_id = M.team_id (+) and A.facility_id =	N.facility_id (+) and A.to_pract_team_id = N.team_id (+)	";
		try{
				pstmtIPTransferDetails = con.prepareStatement(sqlIPTranferDetails);
				rsIPTransferDetails = pstmtIPTransferDetails.executeQuery();
				if(rsIPTransferDetails.next())
				{
				frTrnDate_Time = rsIPTransferDetails.getString("trn_date_time") 			==null ?"": rsIPTransferDetails.getString("trn_date_time");  
				
				frTrnType  =rsIPTransferDetails.getString("transfer_type_desc") ==null?"":rsIPTransferDetails.getString("transfer_type_desc");

				currPractitionerid	= rsIPTransferDetails.getString("to_practitioner_id") 			==null ?"": rsIPTransferDetails.getString("to_practitioner_id");  
				
				frpractitionerid	= rsIPTransferDetails.getString("fr_practitioner_id") 			==null ?"": rsIPTransferDetails.getString("fr_practitioner_id");  
				
				currPractdesc=rsIPTransferDetails.getString("to_practitioner_name") ==null ? "": rsIPTransferDetails.getString("to_practitioner_name");
			
				frpractdesc=rsIPTransferDetails.getString("fr_practitioner_name") ==null ? "": rsIPTransferDetails.getString("fr_practitioner_name");
				
				currSpecialitycode	= rsIPTransferDetails.getString("to_specialty_code") ==null ? "": rsIPTransferDetails.getString("to_specialty_code");    

				frspecialitycode	= rsIPTransferDetails.getString("fr_specialty_code") ==null ? "": rsIPTransferDetails.getString("fr_specialty_code");    

				currSpecialitydesc=rsIPTransferDetails.getString("to_specialty_desc")  ==null ? "": rsIPTransferDetails.getString("to_specialty_desc"); 

				frspecialitydesc=rsIPTransferDetails.getString("fr_specialty_desc")  ==null ? "": rsIPTransferDetails.getString("fr_specialty_desc");     
				
				currBedclass	 =  rsIPTransferDetails.getString("to_bed_class_code") ==null ? "": rsIPTransferDetails.getString("to_bed_class_code");              

				frbedclass	 =  rsIPTransferDetails.getString("fr_bed_class_code") ==null ? "": rsIPTransferDetails.getString("fr_bed_class_code");                        
				currBedclassdesc=rsIPTransferDetails.getString("to_bed_class_desc")  == null ? "": rsIPTransferDetails.getString("to_bed_class_desc");

				frbedclassdesc=rsIPTransferDetails.getString("fr_bed_class_desc")  == null ? "": rsIPTransferDetails.getString("fr_bed_class_desc");

				currNursingunitcode=rsIPTransferDetails.getString("to_nursing_unit") ==null ? "": rsIPTransferDetails.getString("to_nursing_unit");

				frnursingunitcode=rsIPTransferDetails.getString("fr_nursing_unit_code") ==null ? "": rsIPTransferDetails.getString("fr_nursing_unit_code");

				currNursingunitdesc=rsIPTransferDetails.getString("to_nursing_unit_desc") ==null ? "": rsIPTransferDetails.getString("to_nursing_unit_desc");   

				frnursingunitdesc=rsIPTransferDetails.getString("fr_nursing_unit_desc") ==null ? "": rsIPTransferDetails.getString("fr_nursing_unit_desc");   

				currBedno			= rsIPTransferDetails.getString("to_bed_no") ==null ? "": rsIPTransferDetails.getString("to_bed_no");                                          

				frbedno			= rsIPTransferDetails.getString("fr_bed_no") ==null ? "": rsIPTransferDetails.getString("fr_bed_no");                                           
				
				currRoomno		= rsIPTransferDetails.getString("to_room_no") ==null ? "": rsIPTransferDetails.getString("to_room_no");     
				
				frroomno		= rsIPTransferDetails.getString("fr_room_no") ==null ? "": rsIPTransferDetails.getString("fr_room_no");                                       
	
				frbedtype		= rsIPTransferDetails.getString("fr_bed_type_code") ==null ? "": rsIPTransferDetails.getString("fr_bed_type_code");   

				
				frservicecode = rsIPTransferDetails.getString("fr_service_code") ==null ?"":rsIPTransferDetails.getString("fr_service_code");

				currServicedesc = rsIPTransferDetails.getString("to_service_desc") == null?"":rsIPTransferDetails.getString("to_service_desc");

				frservicedesc = rsIPTransferDetails.getString("fr_service_desc") == null?"":rsIPTransferDetails.getString("fr_service_desc");
				
				currMeddesc = rsIPTransferDetails.getString("to_pract_team_desc");
				if(currMeddesc == null ) currMeddesc = "";
				
				frmeddesc = rsIPTransferDetails.getString("fr_pract_team_desc");
				if(frmeddesc == null ) frmeddesc = "";

                }	
		}
		catch(Exception e)
		{
				out.print(e);
		}
		finally
		{
			if(rsIPTransferDetails != null)rsIPTransferDetails.close();
			if(pstmtIPTransferDetails != null)pstmtIPTransferDetails.close();
		}
	
	String sqlBedStatus = "select Current_status from IP_NURSING_UNIT_BED where FACILITY_ID='"+facilityId+"' and Nursing_unit_code = '"+frnursingunitcode+"' and BED_NO='"+frbedno+"'";	
	try{
	pstmtBedStatus = con.prepareStatement(sqlBedStatus);
	
	rsBedStatus = pstmtBedStatus.executeQuery();
	if(rsBedStatus.next())
	{
		strPrevBedStatus	= 	rsBedStatus.getString("Current_status");
	}
	}catch(Exception e)
	{
		out.print(e);
	}
	finally
	{
		if(rsBedStatus != null)rsBedStatus.close();
		if(pstmtBedStatus != null)pstmtBedStatus.close();
	}

String sqlBooking = "Select booking_type,override_yn from ip_bed_booking WHERE facility_id='"+facilityId+"' and req_nursing_unit_code='"+frnursingunitcode+"' 		and req_bed_no='"+frbedno+"' and booking_status='0' and sysdate between blocked_from_date_time and blocked_until_date_time";

try{
	pstmtBooking = con.prepareStatement(sqlBooking);
	rsBedBooking = pstmtBooking.executeQuery();
	if(rsBedBooking.next())
	{
		 String overrideyn  = rsBedBooking.getString(2) == null ? "" : rsBedBooking.getString(2);
	  if (overrideyn.equals("N"))
		{
		}
	}
	}catch(Exception e)
	{
		out.print(e);
	}
	finally
	{
		if(rsBedBooking != null)rsBedBooking.close();
		if(pstmtBooking != null)pstmtBooking.close();
	}
%>
	<form name="CancelTransfer_Form" id="CancelTransfer_Form"  method="post" action="../../servlet/eIP.CancelTransferServlet" target="parent.frames[1]">
<table border=0 width="100%" cellpadding=0 cellspacing=0>
	<tr><td class="PATIENTLINECOLOROTHLANG"><%=strCountry%></td></tr>
	</table>
		<br>
	<table border=0 width="100%" cellpadding=0 cellspacing=0>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>
			<td align="right" class="label" width="20%"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/> &nbsp; &nbsp; </td>
			<td width="30%" class='querydata'><%=admissiondate%></td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/> &nbsp; &nbsp; </td>
			<td width="35%" class='querydata'><%=admissiontype%></td> 
		</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>
			<td align="right" class="label" width="20%"><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/> &nbsp; &nbsp; </td>
		    <td align='left'  class='querydata'><%=frTrnDate_Time%></td>
			<td align="right" class="label" width="15%"><fmt:message key="eIP.TransferType.label" bundle="${ip_labels}"/> &nbsp; &nbsp; </td>
			<td width="35%" class='querydata'><%=frTrnType%></td>
		</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
	</table>
	<table border=0 width="100%" cellpadding=0 cellspacing=0>
		 <tr>
				<th colspan=2 width="50%" ><fmt:message key="eIP.PreviousOccupancy.label" bundle="${ip_labels}"/></th>
				<th colspan=2 width="50%" ><fmt:message key="eIP.CurrentOccupancy.label" bundle="${ip_labels}"/></th>
		</tr>
		<tr>
			<td colspan=4 class='CAGROUPHEADING'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
		</tr> 
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>
			<td align="right" class="label" width="20%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp; </td>
			<td width="30%" class='querydata'><%=frnursingunitdesc%></td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp; </td>
			<td width="35%" class='querydata'><%=currNursingunitdesc%> </td>
		</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>
			<td align="right" class="label" width="20%"><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td width="30%" class='querydata'><%=frservicedesc%>	</td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td width="35%" class='querydata'><%=currServicedesc%>	</td>
		</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>
			<td align="right" class="label" width="20%"><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td class='querydata' width="30%"><font id='frbedclass'><%=frbedclassdesc%></font>	</td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td width="35%" class='querydata'><%=currBedclassdesc%>	</td>
		</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>
			<td align="right" class="label" width="20%"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td width="30%" class='querydata'>
			<%
				if(strPrevBedStatus.equalsIgnoreCase("A"))
				{
				  strDisabled = "disabled";
			%>
				<%=frbedno%>
				<input type="hidden" name="fr_bed_no" id="fr_bed_no" value="<%=frbedno%>">
			<%	
				}
			else
				{	
			%>
				<input type="text" name="fr_bed_no" id="fr_bed_no"  value="<%=frbedno%>" size=8 maxlength=8 onBlur='return callPopulateRoomNo(this)' onKeyPress='return CheckForSpecChars(event)'>&nbsp;<input type="button" class="button"   value="?" onclick="callBedAvailChart();" <%=strDisabled%>>
				<img align="center" src="../../eCommon/images/mandatory.gif">
			<%
				}
			%>
			</td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td class='querydata' width="35%"> <%=currBedno%></td>
		</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>
			<td align="right" class="label" width="20%"  ><fmt:message key="Common.roomno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td class='querydata' width="30%"> 
				<font id='frroomno'><%=frroomno%> </font></td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.roomno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td width="30%" class='querydata'><%=currRoomno%></td>
		</tr>		
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>
			<td colspan=4 class='CAGROUPHEADING'><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></td>
		</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>
			<td align="right" class="label" width="20%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td class='querydata' width="30%"><%=frspecialitydesc%>	</td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td width="30%" class='querydata'><%=currSpecialitydesc%></td>			
		</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>			
			<td align="right" class="label" width="20%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
			<td class='querydata' id="PractDesc" width="30%" nowrap><%=frpractdesc%>	</td>
			<td align="right" class="label" width="15%"> <fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;&nbsp; </td>
			<td nowrap width="30%" class='querydata'><%=currPractdesc%></td>		
		</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr>
			<td align="right" class="label" width="20%"><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/>&nbsp;&nbsp; </td>
			<td width="30%" class='querydata' id="MedTeamDesc"><%=frmeddesc%>
			</td>
			<td align="right" class="label" width="15%"><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/>&nbsp;&nbsp; </td>
			<td width="30%" class='querydata'><%=currMeddesc%></td>
		</tr>		
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr><td colspan=4 width="50%" class='CAGROUPHEADING' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		</tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
		<%
				String sqlReasonForCancel = "Select Contact_Reason_Code, Contact_reason from Am_Contact_Reason where EFF_STATUS='E' and Cancel_transfer_yn='Y'  ";
				pstmtReasonForCancel = con.prepareStatement(sqlReasonForCancel);
				rsReasonForCancel = pstmtReasonForCancel.executeQuery();
				%>
			<tr>
				<td  class="label" width="15%"  align='right' ><fmt:message key="eIP.ReasonforCancel.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				<td width="15%" colspan='3'>
						<select name='sltReasonForCancel' id='sltReasonForCancel' > 
								<option>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
								<%
										if(rsReasonForCancel != null)
										{
											while(rsReasonForCancel.next())
											{
								%>
											<option value='<%=rsReasonForCancel.getString("Contact_Reason_Code")%>'><%=rsReasonForCancel.getString("Contact_reason")%></option>
								<%
											}
										}
								%>
						</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif">
				</td>
		</tr>
			<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
			<tr><td class='DEFAULTBLANKROW' colspan=4>&nbsp;</td></tr>
</table>	
			
	<input type='hidden' name="hdnSrlNo" id="hdnSrlNo" value="<%=strSrlNo%>">
	<input type='hidden' name="nursing_unit" id="nursing_unit" value="<%=currNursingunitcode%>">
	<input type='hidden' name="practid" id="practid" value="<%=currPractitionerid%>">
	<input type="hidden" name="Splcode" id="Splcode" value="<%=currSpecialitycode%>">
	<input type="hidden" name="Bedcode" id="Bedcode" value="<%=currBedclass%>">

	<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
	<input type="hidden" name="transfer_date" id="transfer_date" value="<%=frTrnDate_Time%>">		
	<input type="hidden" name="transfer_type" id="transfer_type" value="<%=frTrnType%>">
	<input type="hidden" name="fr_practitioner_id" id="fr_practitioner_id" value="<%=frpractitionerid%>">
	<input type="hidden" name="fr_speciality_code" id="fr_speciality_code" value="<%=frspecialitycode%>" >
	<input type="hidden" name="fr_bed_class" id="fr_bed_class" value="<%=frbedclass%>">
	<input type="hidden" name="fr_nursing_unit_code" id="fr_nursing_unit_code" value="<%=frnursingunitcode%>">
	<input type="hidden" name="frservicecode" id="frservicecode" value="<%=frservicecode%>">
	<input type="hidden" name="hdnfr_bed_no" id="hdnfr_bed_no" value="">
	<input type="hidden" name="to_bed_no" id="to_bed_no" value="<%=currBedno%>">
	<input type="hidden" name="curr_bed_no" id="curr_bed_no" value="<%=currBedno%>">
	<input type="hidden" name="fr_room_no" id="fr_room_no" value="<%=frroomno%>">
	<input type="hidden" name="to_room_no" id="to_room_no" value="<%=currRoomno%>">
	<input type="hidden" name="fr_bed_type" id="fr_bed_type" value="<%=frbedtype%>">	
	<input type="hidden" name="gender" id="gender" value="<%=strGender%>">
	<input type="hidden" name="age" id="age"  value="<%=strAge%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
	<input type="hidden" name="cont" id="cont" value="">
<!-- <input type="hidden" name="patientgender" id="patientgender" value="<%=strGender%>"> -->	
	<input type="hidden" name="dateofbirth" id="dateofbirth" value="<%=date_of_birth%>">

<br>
	<table border=0 cellpadding=0 cellspacing=0 align="right">
	<tr>		
		<td><input type="button" class="button" name="btnConfirm" id="btnConfirm" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConfirmCancel.label","common_labels")%>" onclick="confirm();"  ></td>
		<td><input type="button" class="button" value="Close" onclick="cancel();"></td>
	</tr>
	</table>
	</form>
<%	
		// By Annadurai 3/31/2004 Billing Starts here.
		if (chargeExists.equals("Y"))
		{
			out.println("<script>");
			out.println("alert(getMessage('CHARGES_EXISTS','IP'));");
			// CHARGES_EXISTS - Ip
			out.println("parent.window.close();");
			out.println("</script>");
		}
		// By Annadurai 3/31/2004 Billing ends here.
			
	}catch(Exception e){
		out.print("Exception :"+e);
	}
	finally {
		if(pstmtAdmDateType   != null)			pstmtAdmDateType.close();
		if(rsAdmDateType	  != null)			rsAdmDateType.close();
		if(rsBedStatus != null) rsBedStatus.close();
		if(pstmtBedStatus != null)pstmtBedStatus.close();
		if(rsIPTransferDetails != null)rsIPTransferDetails.close();
		if(pstmtIPTransferDetails != null)pstmtIPTransferDetails.close();
		if(rsReasonForCancel != null)rsReasonForCancel.close();
		if(pstmtReasonForCancel !=null)pstmtReasonForCancel.close();
		if(pstmtGenderSex != null)pstmtGenderSex.close();
		if(rsGenderSex != null )rsGenderSex.close();
		if(rsBedBooking != null)rsBedBooking.close();
		if(pstmtBooking != null)pstmtBooking.close();
		ConnectionManager.returnConnection(con,request);
	}
	 %>
</body>
</html>
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

