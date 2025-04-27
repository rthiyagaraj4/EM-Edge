<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*, com.ehis.util.* " %>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

	Connection con		= null;
	Statement stmt		= null;
	ResultSet rset		= null;
	String frmeddesc	= "";
	String facilityId	= (String)session.getValue("facility_id");
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();	
%>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eIP/js/TransferPractitioner.js" language="javascript"></script>
		<script src="../../eIP/js/IPPractitionerComponent.js" language="javascript"></script>	
        <Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<%
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt=new java.util.Date();
			String d				= dateFormat.format( dt ) ;
			d						= d + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
			String d_converted		= "";
			if(!(d.equals("") || d == null))
					d_converted = DateUtils.convertDate(d,"DMYHM","en",locale); 	
			
			String patientid		= checkForNull(request.getParameter("patient_id"));
			String eid				= checkForNull(request.getParameter("encounter_id")); long    encounterid			    = Long.parseLong(eid);
			String admissiondate	= "";
			String admissiontype	= "";
			String frpractitionerid	= "";
			String frpractdesc		= "";
			String frspecialitycode	= "";
			String frspecialitydesc	= "";
			String frbedclass		= "";
			String frbedclassdesc	= "";
			String frnursingunitcode= "";
			String frnursingunitdesc= "";
			String frbedno			= "";
			String frroomno			= "";
			String frbedtype		= "";
			String gender			= "";
			String age				= "";
			String medcode 			= "";
			String meddesc 			= "";
			String frpractteamid 	= "";         
			String frteamid 		= "";
			String frservicecode	= "";
			String Nationality		= "";
			String patient_class	= "";
			String Bed_Speciality	= "";
			String Enc_Service		= "";
			String admissiondate_converted = "";
			String entitlement_by_pat_cat_yn = "";
			StringBuffer sqlSb		= new StringBuffer();

			sqlSb.append(" select to_char(a.admission_date_time,'dd/mm/rrrr hh24:MI') admission_date, ip_get_desc.ip_admission_type(a.admission_type,'"+locale+"',2) admission_short_desc,a.attend_practitioner_id practitioner_id, 		 am_get_desc.am_practitioner(a.attend_practitioner_id,'"+locale+"',1) practitioner_name,a.specialty_code, am_get_desc.am_speciality(a.specialty_code,'"+locale+"',2) specialty_short_desc,a.bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc,a.nursing_unit_code, 			  ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code,'"+locale+"',2) nursing_unit_short_desc,a.bed_num bed_no,a.room_num room_no, a.bed_type_code, b.sex gender, get_age(b.date_of_birth) age,a.service_code, am_get_desc.am_service(a.service_code,'"+locale+"',2) service_short_desc,b.nationality_code, mp_get_desc.mp_country(b.nationality_code,'"+locale+"',1) nationality,a.patient_class, am_get_desc.am_medical_team (a.facility_id, a.team_id,'"+locale+"',2) team_desc, a.team_id,(select specialty_code from ip_nursing_unit_bed where facility_id = a.facility_id and nursing_unit_code = a.nursing_unit_code and bed_no = a.bed_num) bed_speciality,(select entitlement_by_pat_cat_yn from MP_PARAM) entitlement_by_pat_cat_yn from ip_open_encounter a, mp_patient b where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" and a.patient_id = b.patient_id ");
			
			stmt  = con.createStatement();
			rset  = stmt.executeQuery(sqlSb.toString());

			if(rset.next())
			{
				admissiondate		= checkForNull(rset.getString("admission_date"));
				if(!(admissiondate.equals("") || admissiondate == null))
					admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 	
				admissiontype		= checkForNull(rset.getString("admission_short_desc"));
				frpractitionerid	= checkForNull(rset.getString("practitioner_id"));
				frpractdesc			= checkForNull(rset.getString("practitioner_name"));
				frspecialitycode	= checkForNull(rset.getString("specialty_code"));
				frspecialitydesc	= checkForNull(rset.getString("specialty_short_desc"));
				frbedclass			= checkForNull(rset.getString("bed_class_code"));
				frbedclassdesc		= checkForNull(rset.getString("bed_class_short_desc"));
				frnursingunitcode	= checkForNull(rset.getString("nursing_unit_code"));
				frnursingunitdesc	= checkForNull(rset.getString("nursing_unit_short_desc"));
				frbedno				= checkForNull(rset.getString("bed_no"));
				frroomno			= checkForNull(rset.getString("room_no"));
				frbedtype			= checkForNull(rset.getString("bed_type_code"));
				gender				= checkForNull(rset.getString("gender"));
				age					= checkForNull(rset.getString("age"));
				frservicecode		= checkForNull(rset.getString("service_code"));
				Enc_Service			= checkForNull(rset.getString("service_code"));
				Nationality			= checkForNull(rset.getString("nationality"));
				patient_class		= checkForNull(rset.getString("patient_class"));
				frmeddesc	= checkForNull(rset.getString("team_desc"));
				frteamid	= checkForNull(rset.getString("team_id"));
				Bed_Speciality = checkForNull(rset.getString("bed_speciality"));
				entitlement_by_pat_cat_yn = checkForNull(rset.getString("entitlement_by_pat_cat_yn"));
			}
			if (rset != null)   rset.close();
			if (stmt != null)   stmt.close();
			if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());
			if(frbedclassdesc == null || frbedclassdesc.equals(""))
			{
				sqlSb.append(" select to_bed_class_code, ip_get_desc.ip_bed_class(to_bed_class_code,'"+locale+"',2) short_desc from ip_adt_trn where facility_id='"+facilityId+"' and encounter_id = '"+encounterid+"' and trn_type = 'A' ");

				stmt  = con.createStatement();
				rset  = stmt.executeQuery(sqlSb.toString());

				while(rset.next())
				{
				   frbedclass = rset.getString("to_bed_class_code");
				   frbedclassdesc = rset.getString("short_desc");
				}
				if (rset != null)   rset.close();
				if (stmt != null)   stmt.close();
			}
			if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());
			/*
			Commented for PE and merged with IP_OPEN_ENCOUNTER ON 11/05/2010
			sqlSb.append("select team_id, am_get_desc.am_medical_team (facility_id,team_id,'"+locale+"',2) team_desc from am_pract_for_team  where facility_id = '"+facilityId+"' and team_id = (select to_pract_team_id from ip_adt_trn where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" and srl_no = (select max(srl_no) from ip_adt_trn where facility_id = '"+facilityId+"' and encounter_id= '"+encounterid+"')) and practitioner_id='"+frpractitionerid+"' "); 
            
			stmt = con.createStatement();
			rset = stmt.executeQuery(sqlSb.toString());

			if(rset!=null)
			{
				if(rset.next())
				{
					frmeddesc	= checkForNull(rset.getString("team_desc"));
					frteamid	= checkForNull(rset.getString("team_id"));
				}	
			}
			if (rset != null)   rset.close();
			if (stmt != null)   stmt.close();
			
			if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());

			sqlSb.append(" Select specialty_code from ip_nursing_unit_bed ");
			sqlSb.append(" where facility_id = '"+facilityId+"' and nursing_unit_code = '"+frnursingunitcode+"' and bed_no = '"+frbedno+"' ");

			stmt = con.createStatement();
			rset = stmt.executeQuery(sqlSb.toString());
			if(rset!=null)
			{
				if(rset.next())
				{
					Bed_Speciality = checkForNull(rset.getString("specialty_code"));
				}	
			}
			if (rset != null)   rset.close();
			if (stmt != null)   stmt.close();
			if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());
			
			Commented for PE and merged with IP_OPEN_ENCOUNTER on 11/05/2010
			sqlSb.append("Select service_code from pr_encounter where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"' ");
			
			stmt	= con.createStatement();
			rset	= stmt.executeQuery(sqlSb.toString());
			if(rset!=null)
			{
				if(rset.next())
				{
					Enc_Service = checkForNull(rset.getString("service_code"));
				}	
				
			}
			if (rset != null)	rset.close();
			if (stmt != null)	stmt.close();
			*/
%>

<form name="TransferPractitioner_form" id="TransferPractitioner_form"  method="post" action="../../servlet/eIP.TransferPractitionerServlet" target="parent.frames[1]">

	<table border=0 width="100%" cellpadding=3 cellspacing=0>
	<!--IN017603 Wednesday, December 23, 2009<tr><td class="PATIENTLINECOLOROTHLANG"><%=Nationality%></td></tr>-->
	<!--Below line modified for this incident HSA-SCF-0138 [IN:051211]-->
	<tr><td class="COLUMNHEADER"><fmt:message key="Common.AdmissionDetails.label" bundle="${common_labels}"/></td></tr>
	</table>

	<table border=0 width="100%" cellpadding=3 cellspacing=0>
		<tr>
			<td  class="label" width="20%"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
			 <td width="30%" class='querydata'><input type="hidden" name="admission_date" id="admission_date" value="<%=admissiondate%>" ><%=admissiondate_converted%></td>
			<td  class="label" width="20%"><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
			<td width="35%" class='querydata'><input type="hidden" name="admission_type" id="admission_type" value="<%=admissiontype%>" ><%=admissiontype%></td> 
		</tr>
		<tr>
			<td class="label" width="20%"><fmt:message key="Common.transferdate.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="30%"><input type="hidden" name="transfer_date" id="transfer_date"  value="<%=d%>"> <%=d_converted%> </td>
			<td class="label" width="15%"><fmt:message key="eIP.TransferType.label" bundle="${ip_labels}"/></td>
			<td width="35%" class="fields">
				<select name="transfer_type" id="transfer_type">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---
					<%
							stmt = con.createStatement();
							rset = stmt.executeQuery(" select transfer_type_code,short_desc from ip_transfer_type_lang_vw where language_id= '"+locale+"' and eff_status = 'E' order by short_desc ");
							while(rset.next())
							{
								String desc = rset.getString("short_desc");
								String code = rset.getString("transfer_type_code");

								out.print("<option value=\""+code+"\" >"+desc );
							}
							if (rset != null)   rset.close();
							if (stmt != null)   stmt.close();
					%>
				</select><img  src="../../eCommon/images/mandatory.gif">
			</td>
		</tr>
	</table>

	<table border=0 width="100%" cellpadding=3 cellspacing=0>
		<tr>
			<td colspan=4 class='CAGROUPHEADING'><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
		</tr> 
		<tr>
			<td  class="label" width="20%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td width="30%" class='querydata'><%=frnursingunitdesc%>
				<input type="hidden" name="nursing_unit" id="nursing_unit" value="<%=frnursingunitcode%>"></td>
			<td  class="label" width="15%"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td class="fields" width="35%"><select name="service" id="service">
			<%
				if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());

				String sel = "";
				String serv_code = "";
				String serv_desc = "";

				sqlSb.append(" select service_code ,am_get_desc.am_service(service_code,'"+locale+"',2) service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id ='"+facilityId+"'and nursing_unit_code = '"+frnursingunitcode+"' union select service_code, am_get_desc.am_service(service_code,'"+locale+"',2) service_short_desc from ip_nursing_unit where facility_id = '"+facilityId+"' and nursing_unit_code = '"+frnursingunitcode+"' order by 2 "); 
              
				stmt = con.createStatement();
				rset = stmt.executeQuery(sqlSb.toString());

				if(rset!=null )
				{
					while(rset.next()){
						serv_code  = rset.getString("service_code");
						serv_desc = rset.getString("service_short_desc");

						if (serv_code.equals(Enc_Service))
							sel = "selected";
						else
							sel = "";
						out.println("<option value='"+serv_code+"' "+sel+">"+serv_desc+"");
					}
				if (rset != null)   rset.close();
				if (stmt != null)   stmt.close();
				}
			%>
			</select>
			</td>
		</tr>
		<tr>
			<td class="label" width="20%"><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="30%"><%=frbedclassdesc%></td>
			<td class="label" width="15%"></td>
			<td class='querydata' width="35%"></td>
		</tr>
		<tr>
			<td class="label" width="20%"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="30%"><%=frbedno%></td>
			<td  class="label" width="20%"><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="35%"><%=frroomno%></td>
		</tr>
		<tr>
			<td colspan=2 width="50%"  align=center class="COLUMNHEADER"><fmt:message key="eIP.CurrentOccupancy.label" bundle="${ip_labels}"/></td>
			<td colspan=2 width="50%" align=center class="COLUMNHEADER"><fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td colspan=4 class='CAGROUPHEADING'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td class="label" width="20%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='querydata' width="30%"><%=frspecialitydesc%>
				<input type="hidden" name="fr_speciality_code" id="fr_speciality_code" value="<%=frspecialitycode%>">
			</td>
			<td class="label" width="15%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class="fields" nowrap width="35%"><input type=text name='Splcode_desc' id='Splcode_desc' <%if(!Bed_Speciality.equals("")){%> readOnly <%}%> maxlength='15' size='15' width="15%" value="<%=frspecialitydesc%>" onblur="BeforeGetSpecialty(Splcode_desc, '<%=facilityId%>');"><input type=hidden name='Splcode' id='Splcode' width="15" value="<%=frspecialitycode%>"><input type=button name='Splcode_lookup' id='Splcode_lookup' <%if(!Bed_Speciality.equals("")){%> disabled <%}%> value='?' class=button onClick="checkSpecTxtVal(Splcode_desc,'<%=facilityId%>');"><img src='../../eCommon/images/mandatory.gif'></img><input type=hidden name="spec_desc_hid" id="spec_desc_hid" value="<%=frspecialitycode%>"></td>			
		</tr>
		<tr>
			
			<td class="label" width="20%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='querydata' id="PractDesc" width="30%" nowrap><%=frpractdesc%>
				<input type="hidden" name="fr_practitioner_id" id="fr_practitioner_id" value="<%=frpractitionerid%>">
			</td>
			<td class="label" width="15%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td nowrap width="35%">
			<!-- <input type='hidden' name='practid' id='practid' value="<%=frpractitionerid%>" readonly> -->
			<input type='hidden' name='practid' id='practid' value="" readonly><input type='text' name='pract_desc' id='pract_desc' value="" size='15' maxlength='15'width='15' onFocus="checkForValues();" onblur="BeforGetPractitioner(document.forms[0].practid,pract_desc, '<%=facilityId%>');" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onFocus="checkForValues();" onclick="checkPractTxtVal(document.forms[0].practid,pract_desc, '<%=facilityId%>');" ><img  src="../../eCommon/images/mandatory.gif"><input type=hidden name="pract_desc_hid" id="pract_desc_hid" value="<%=frpractdesc%>"> 
			</td>			
		</tr>
		<tr>
			<td class="label" width="20%"><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
			<td width="30%" class='querydata' id="MedTeamDesc"><%=frmeddesc%>
			<input type="hidden" name="fr_team_id" id="fr_team_id" value="<%=frpractteamid%>">
			</td>
			<td class="label" width="15%"><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
			<td class="fields" width="35%">
				<select name="team_id" id="team_id" onChange="getMedicalTeamHead(this);">
					<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---						
<%

					if(sqlSb.length() > 0) sqlSb.delete(0,sqlSb.length());

		sqlSb.append(" select team_id,am_get_desc.am_medical_team(facility_id,team_id,'"+locale+"',2)team_short_desc from am_pract_for_team  where facility_id = '"+facilityId+"' and practitioner_id ='"+frpractitionerid+"' ");


         
    				stmt = con.createStatement();
					rset = stmt.executeQuery(sqlSb.toString());
					if(rset!= null)
					{
						while(rset.next())
						{				
							medcode = checkForNull(rset.getString("team_id"));
							meddesc = rset.getString("team_short_desc");
							String optSelected="";
							if(medcode.equals(frpractteamid))
								optSelected="selected";
							else
								optSelected="";
							out.println("<option value=\""+medcode+"\"" +optSelected+">"+meddesc+"</option>");							
						}			
					if (rset != null)		rset.close();
					if (stmt != null)		stmt.close();
					}					
%>					
				</select>
				<input type="hidden" name="selecTeam" id="selecTeam">
			</td>
		</tr>		
		<tr>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
			<td class="fields" ><input type="button" class="button"  name = "transfer" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")%>" onclick="submitForm();"><input type="button" class="button" name= "close" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="cancel();"></td>
		</tr>
	</table>	

	<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
	<input type="hidden" name="bed_type_code" id="bed_type_code" value="<%=frbedtype%>">
	<input type="hidden" name="bed_class_code" id="bed_class_code" value="<%=frbedclass%>">
	<input type="hidden" name="service_code" id="service_code" value="<%=frservicecode%>">
	<input type="hidden" name="room_no" id="room_no" value="<%=frroomno%>">
	<input type="hidden" name="bed_no" id="bed_no" value="<%=frbedno%>">
	<input type="hidden" name="gender" id="gender" value="<%=gender%>">
	<input type="hidden" name="age" id="age" value="<%=age%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facilityId%>">
	<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
	<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>"> 
	<input type='hidden' name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value="<%=entitlement_by_pat_cat_yn%>"> 
	<script>document.forms[0].team_id.value="<%=frteamid%>";</script>
	
	</form>
<%	
		if(rset	  != null)			rset.close();
		if(stmt   != null)			stmt.close();

	}catch(Exception e){
		//out.print("Exception :"+e);
		e.printStackTrace();
	}
	finally 
	{
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

