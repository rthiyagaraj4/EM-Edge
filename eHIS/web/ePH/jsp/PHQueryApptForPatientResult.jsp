<!DOCTYPE html>
<%@page import="java.util.*,java.text.*,com.ehis.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<HTML>
	<head>		
		<title><fmt:message key="ePH.ViewPatientDetails.label" bundle="${ph_labels}"/></title>	
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
<%
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
		<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
		<form name='QueryApptForPatient' id='QueryApptForPatient'>
<%
			request.setCharacterEncoding("UTF-8");
			String patientid	=	request.getParameter("patientid") ;	
			String apptfromdate	=	request.getParameter("apptfromdate") ;	
			String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
			String showInstructionsYN="N";
			String locale		= (String)session.getAttribute("LOCALE");
			String appttodate	=	request.getParameter("appttodate") ;	    	
			String appt_no1="" ,age="" ,rsource="" , apptfromdate_greg="" ,appttodate_greg="", appt_ref_no ="" ,oth_contact_no =	"" ,patientCatDesc="" ,colour_indicator=""; 
			String referralId	="",order_catalog_code="", classValue = "", patient_id_one="" ,p_name="" ,practitioner_full_name="" ,translator_override_reason="";
			String rule_appl_yn ="", diceased_yn ="", appt_status ="",appt_date="",added_date ="",modified_date ="", added_by ="",deceased_yn = "";
			String appt_slab_from_time ="",appt_slab_to_time ="",appt_duration="",care_locn_type_desc ="",speciality_desc ="",modified_by ="" , gender_code="", visit_type_short_desc ="",clinic_short_desc ="" ;			
			String appt_status_desc="" , rsource_name ="" ,genderdesc="" ,appt_date_disp ="" ,added_date_disp ="",modified_date_disp ="",or_cat_desc="" ;
			
			apptfromdate_greg=DateUtils.convertDate(apptfromdate,"DMY",locale,"en");
			appttodate_greg=DateUtils.convertDate(appttodate,"DMY",locale,"en");

			String bean_id			= "DispMedicationBean" ;
			String bean_name		= "ePH.DispMedicationBean";	
			DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(locale);
%>			
			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<tr>
					<td class='columnheader' nowrap width='7%' ><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/></td>			
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>			
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/> </td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>		
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.PatientInstructions.label" bundle="${common_labels}"/></td>		
<%
					if(rule_appl_yn.equals("Y")){
%>
						<td class='columnheader'  nowrap width='7%'><fmt:message key="ePH.TranslatorOverrideReason.label" bundle="${ph_labels}"/></td>
<%
					}
%>
					<td class='columnheader' nowrap width='7%'><fmt:message key="ePH.ApptGivenBy.label" bundle="${ph_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="ePH.ApptGivenOn.label" bundle="${ph_labels}"/></td>	
					<td class='columnheader' nowrap width='7%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap  width='7%'><fmt:message key="Common.LastModifiedBy.label" bundle="${common_labels}"/></td>
					<td class='columnheader' nowrap width='7%'><fmt:message key="ePH.Lastmodifiedon.label" bundle="${ph_labels}"/></td>		
				</tr>
<%
				try{
					ArrayList results = bean.getAppoinmentDetails(patientid,apptfromdate_greg,appttodate_greg,locale);
					for(int k=0;k<results.size();k=k+28){
						rule_appl_yn 			= (String)results.get(k+1);
						deceased_yn  			= (String)results.get(k+1);
						referralId 				= (String)results.get(k+2);
						patientid 				= (String)results.get(k+3);
						patientCatDesc 			= (String)results.get(k+4);
						colour_indicator 		= (String)results.get(k+5);
						oth_contact_no			= (String)results.get(k+6);
						appt_ref_no 			= (String)results.get(k+7);
						rsource 				= (String)results.get(k+8);
						practitioner_full_name 	= (String)results.get(k+9);
						appt_status 			= (String)results.get(k+10);
						gender_code				= (String)results.get(k+11);
						appt_date 				= (String)results.get(k+12);
						added_date 				= (String)results.get(k+13);
						modified_date 			= (String)results.get(k+14);
						p_name 					= (String)results.get(k+15);
						order_catalog_code 		= (String)results.get(k+16);
						translator_override_reason = (String)results.get(k+17);
						age 					= (String)results.get(k+18);
						appt_slab_from_time 	= (String)results.get(k+19);
						appt_slab_to_time 		= (String)results.get(k+20);
						appt_duration 			= (String)results.get(k+21);
						care_locn_type_desc		= (String)results.get(k+22);
						speciality_desc 		= (String)results.get(k+23);
						added_by 				= (String)results.get(k+24);
						modified_by				= (String)results.get(k+25);
						visit_type_short_desc	= (String)results.get(k+26);
						clinic_short_desc		= (String)results.get(k+27);
						
						if ( k % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
						if(deceased_yn.equals("Y"))
							classValue = "DECEASEDPATLINE";
							
						appt_no1 = appt_ref_no;          				
						showInstructionsYN = bean.showInstructions(appt_no1,patientid);
						if(rsource.equals("P"))
							rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						else if(rsource.equals("R"))
							rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						else if(rsource.equals("E"))
							rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
						else if(rsource.equals("O"))
							rsource_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
						

						if(appt_status.equals("1"))
							appt_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
						else if(appt_status.equals("A"))
							appt_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.VisitRegistered.label","oa_labels");

						if(gender_code.equals("M")) 
							genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						else if(gender_code.equals("F")) 
							genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						else if(gender_code.equals("U"))
							genderdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						appt_date_disp=DateUtils.convertDate(appt_date,"DMY","en",locale);
						added_date_disp=DateUtils.convertDate(added_date,"DMYHM","en",locale);
						modified_date_disp=DateUtils.convertDate(modified_date,"DMYHM","en",locale);
						or_cat_desc="";
								   
						if(!order_catalog_code.equals("")){									
							or_cat_desc = bean.orderCatalogDesc(patientid,order_catalog_code,locale,appt_no1); 
						}
%>
						<tr>				
							<td nowrap class='<%=classValue%>'>&nbsp;<%=appt_ref_no%></td>				
<%
							if (patientid.equals("")) {
%>
								<td nowrap class='<%=classValue%>'>&nbsp;<%=patient_id_one%></td>
								<td nowrap class='<%=classValue%>'>&nbsp;<%=p_name%></td>
								<td nowrap class='<%=classValue%>'>&nbsp;<%=genderdesc%></td>
								<td nowrap class='<%=classValue%>'>&nbsp;<%=age%></td>
<%
							}
%>				
							<td nowrap class='<%=classValue%>'>&nbsp;<%=oth_contact_no%></td> 
							<td nowrap class='<%=classValue%>'>&nbsp;<%=patientCatDesc%></td> 
							<td nowrap class='<%=classValue%>'>&nbsp;<%=appt_date_disp%></td>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=appt_slab_from_time%></td>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=appt_slab_to_time%></td>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=appt_duration%></td>
							<td nowrap style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;">&nbsp;<%=visit_type_short_desc%></td> 
							<td nowrap class='<%=classValue%>'>&nbsp;<%=care_locn_type_desc%>&nbsp;/&nbsp;<%=clinic_short_desc%></td>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=rsource_name%>&nbsp;/&nbsp;<%=practitioner_full_name%></td>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=speciality_desc%></td>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=or_cat_desc%>&nbsp;</td>	
							<td nowrap class='<%=classValue%>'>&nbsp;<%=referralId%>&nbsp;</td>	
<%
							if(showInstructionsYN.equals("Y")){
%>
								<td nowrap class='<%=classValue%>' style="color:blue;cursor:pointer;"  onclick="show_patinstructions('<%=appt_no1%>','<%=patientid%>')"><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
<%
							}
							else{
%>
								<td nowrap class='<%=classValue%>'>&nbsp;</td>
<%
							}
							if(rule_appl_yn.equals("Y")){
%>
								<td nowrap class='<%=classValue%>'>&nbsp;<%=translator_override_reason%></td>
<%
							}
%>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=added_by%></td>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=added_date_disp%></td>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=appt_status_desc%></td>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=modified_by%></td>
							<td nowrap class='<%=classValue%>'>&nbsp;<%=modified_date_disp%></td>
						</tr>				
<%
					}	
				}
				catch ( Exception e ){	
					e.printStackTrace();
				}
%>
			</table>
		</form>
	</body>
</html>

