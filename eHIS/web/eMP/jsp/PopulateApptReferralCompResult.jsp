<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 11:30 AM -->
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.Connection, java.sql.Statement, java.sql.ResultSet, webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script language="JavaScript" src="../../eCommon/js/ValidateControl.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<Script language='javascript' src='../../eMP/js/PopulateApptReferralComp.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown = 'lockKey()'>
<%
	Connection con				= null;
	java.sql.Statement stmt1	= null;
	ResultSet rst1				= null;
	request.setCharacterEncoding("UTF-8");
	String facility_id			= "";
	String refrlAappt			= "";
	String referenceNo			= "";
	String apptDate				= "";
	String patient_name			= "";
	String gender				= "";
	String dob					= "";
	String location				= "";
	String selectedLocation		= "";
	String patName				= "";
	String genderValue			= "";
	String refNo				= "";
	String periodFrom			= "";
	String periodTo				= "";
	String locationValue		= "";
	String RDinstall_yn			= "";
	String national_id_no		= "";
	String alt_id1_no			= "";
	String alt_id2_no			= "";
	String alt_id3_no			= "";
	String alt_id4_no			= "";
	String other_alt_type		= "";
	String other_alt_Id			= "";
	String from					= "";
	String to					= "";
	String classValue			= "QRYEVEN";

	StringBuffer selectQuery = null;
	selectQuery = new StringBuffer();

	int count		= 0;
	int maxRecord	= 0;
    int start		= 0;
    int end			= 0;
    int i			= 1;
	
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		facility_id = (String) session.getValue("facility_id");
		
		from	= request.getParameter("from");
		to		= request.getParameter("to");

		if (from == null){ start = 0; } else { start = Integer.parseInt(from); }
		if (to == null){ end = 14; } else { end = Integer.parseInt(to); }

		refrlAappt			= request.getParameter("refrlAappt");
		selectedLocation	= request.getParameter("selectedLocation");
		patName				= request.getParameter("patName");
		genderValue			= request.getParameter("genderValue");
		refNo				= request.getParameter("refNo");
		periodFrom			= request.getParameter("periodFrom");
		periodTo			= request.getParameter("periodTo");
		locationValue		= request.getParameter("locationValue");
		RDinstall_yn		= request.getParameter("RDinstall_yn");
		national_id_no		= request.getParameter("national_id_no");
		alt_id1_no			= request.getParameter("alt_id1_no");
		alt_id2_no			= request.getParameter("alt_id2_no");
		alt_id3_no			= request.getParameter("alt_id3_no");
		alt_id4_no			= request.getParameter("alt_id4_no");
		other_alt_type		= request.getParameter("other_alt_type");
		other_alt_Id		= request.getParameter("other_alt_Id");
	
		if(refrlAappt == null) refrlAappt = "";
		if(selectedLocation == null) selectedLocation = "";
		if(patName == null) patName = "";
		if(genderValue == null) genderValue = "";
		if(refNo == null) refNo = "";
		if(periodFrom == null) periodFrom = "";
		if(periodTo == null) periodTo = "";
		if(locationValue == null) locationValue = "";
		if(national_id_no == null) national_id_no = "";
		if(alt_id1_no == null) alt_id1_no = "";
		if(alt_id2_no == null) alt_id2_no = "";
		if(alt_id3_no == null) alt_id3_no = "";
		if(alt_id4_no == null) alt_id4_no = "";
		if(other_alt_type == null) other_alt_type = "";
		if(other_alt_Id == null) other_alt_Id = "";
		if(RDinstall_yn == null) RDinstall_yn = "N";
		
		%>
		<form name='popAppRefCriteriaForm' id='popAppRefCriteriaForm' action='../../eMP/jsp/PopulateApptReferralCompResult.jsp' method='past'>
			<%
			if(refrlAappt.equals("A"))
			{
				selectQuery.append(" SELECT a.appt_ref_no referenceNo, to_char(a.appt_date, 'dd/mm/yyyy')  apptDate, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.gender patGender, to_char(a.date_of_birth, 'dd/mm/yyyy') dob, (decode(a.care_locn_type_ind, 'C','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+"','E','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels")+"','D','"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+"')|| '/' || b.long_desc) long_desc FROM oa_appt a, op_clinic_lang_vw b WHERE a.facility_id = '"+facility_id+"' and b.language_id='"+localeName+"' AND trunc(a.appt_date) >= trunc(sysdate) AND a.facility_id = b.facility_id AND a.clinic_code = b.clinic_code AND a.patient_id IS NULL AND a.appt_status = '1' ");

				if(!national_id_no.equals(""))
				{
					selectQuery.append(" AND a.national_id_no = '"+national_id_no+"' ");
				}
				if(!alt_id1_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id1_no = '"+alt_id1_no+"' ");
				}
				if(!alt_id2_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id2_no = '"+alt_id2_no+"' ");
				}
				if(!alt_id3_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id3_no = '"+alt_id3_no+"' ");
				}
				if(!alt_id4_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id4_no = '"+alt_id4_no+"' ");
				}
				if(!other_alt_type.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_type  = '"+other_alt_type+"' ");
				}
				if(!other_alt_Id.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_no = '"+other_alt_Id+"' ");

				}
				if(!patName.equals(""))
				{
					if (localeName.equals("en"))
					{
						selectQuery.append(" AND UPPER(a.patient_name) LIKE UPPER('%"+patName+"%') ");
					}
					else
					{
						selectQuery.append(" AND UPPER(a.patient_name_loc_lang) LIKE UPPER('%"+patName+"%') ");
					}
				}
				if(!genderValue.equals(""))
				{
					selectQuery.append(" AND a.gender = '"+genderValue+"' ");
				}
				if(!refNo.equals(""))
				{
					selectQuery.append(" AND a.appt_ref_no = '"+refNo+"' ");
				} 
				if(!selectedLocation.equals(""))
				{
					selectQuery.append(" AND a.care_locn_type_ind = '"+selectedLocation+"' ");
				}
				if(!locationValue.equals(""))
				{
					selectQuery.append(" AND a.clinic_code = '"+locationValue+"' ");
				}

				if(!periodFrom.equals(""))
				{
					selectQuery.append(" AND trunc(a.appt_date) >= to_date('"+periodFrom+"', 'dd/mm/yyyy') ");
				}
				if(!periodTo.equals(""))
				{
					selectQuery.append(" AND trunc(a.appt_date) <= to_date('"+periodTo+"','dd/mm/yyyy') ");
				}
				
				selectQuery.append(" ORDER BY 2, 1");

			}
			else if(refrlAappt.equals("R"))
			{
				selectQuery.append(" SELECT a.appt_ref_num referenceNo, to_char(a.appt_date, 'dd/mm/yyyy')  apptDate, 	decode('"+localeName+"', 'en', a.short_name, nvl(a.SECOND_NAME_LOC_LANG, a.short_name)) patient_name, a.sex patGender, to_char(a.date_of_birth, 'dd/mm/yyyy') dob, c.short_desc long_desc FROM rd_appt a, rd_clinic b, rd_wings c WHERE a.operating_facility_id = '"+facility_id+"' AND trunc(a.appt_date) >= trunc(sysdate) AND a.operating_facility_id = b.operating_facility_id AND a.clinic_code = b.clinic_code AND b.operating_facility_id = c.operating_facility_id AND b.wing_code = c.wing_code AND a.patient_id IS NULL AND a.appt_status = '1' ");
				
				if(!national_id_no.equals(""))
				{
					selectQuery.append(" AND a.national_id_num = '"+national_id_no+"' ");
				}

				if(!patName.equals(""))
				{
					if (localeName.equals("en"))
					{
						selectQuery.append(" AND UPPER(a.short_name) LIKE UPPER('%"+patName+"%') ");
					}
					else
					{
						selectQuery.append(" AND UPPER(a.short_name_loc_lang) LIKE UPPER('%"+patName+"%') ");
					}
				}
				if(!genderValue.equals(""))
				{
					selectQuery.append(" AND a.sex = '"+genderValue+"' ");
				}
				if(!refNo.equals(""))
				{
					selectQuery.append(" AND a.appt_ref_num = '"+refNo+"' ");
				} 
				if(!locationValue.equals(""))
				{
				//selectQuery.append(" AND a.wing_code = '"+locationValue+"' "); Modified By Venkat S against IN016973 (08.12.09)
					selectQuery.append(" AND c.wing_code = '"+locationValue+"' ");
				}

				if(!periodFrom.equals(""))
				{
					selectQuery.append(" AND trunc(a.appt_date) >= to_date('"+periodFrom+"', 'dd/mm/yyyy') ");
				}
				if(!periodTo.equals(""))
				{
					selectQuery.append(" AND trunc(a.appt_date) <= to_date('"+periodTo+"', 'dd/mm/yyyy') ");
				} 		

				selectQuery.append(" ORDER BY 2, 1");
			}
			else if(refrlAappt.equals("I"))
			{
				selectQuery.append(" SELECT a.bkg_lst_ref_no referenceNo, to_char(a.preferred_date, 'dd/mm/yyyy') apptDate, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.gender patGender, to_char(a.date_of_birth, 'dd/mm/yyyy') dob, b.long_desc long_desc FROM ip_booking_list a, ip_nursing_unit b WHERE a.facility_id = '"+facility_id+"' AND trunc(a.preferred_date) >= trunc(sysdate) AND a.facility_id = b.facility_id (+) AND a.nursing_unit_code = b.nursing_unit_code(+) AND a.patient_id IS NULL AND a.booking_status = '1' ");
				
				if(!national_id_no.equals(""))
				{
					selectQuery.append(" AND a.national_id_no = '"+national_id_no+"' ");
				}
				if(!alt_id1_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id1_no = '"+alt_id1_no+"' ");
				}
				if(!alt_id2_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id2_no = '"+alt_id2_no+"' ");
				}
				if(!alt_id3_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id3_no = '"+alt_id3_no+"' ");
				}
				if(!alt_id4_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id4_no = '"+alt_id4_no+"' ");
				}
				if(!other_alt_type.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_type  = '"+other_alt_type+"' ");
				}
				if(!other_alt_Id.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_no = '"+other_alt_Id+"' ");
				}
				if(!patName.equals(""))
				{
					if (localeName.equals("en"))
					{
						selectQuery.append(" AND UPPER(a.patient_name) LIKE UPPER('%"+patName+"%') ");
					}
					else
					{
						selectQuery.append(" AND UPPER(a.patient_name_loc_lang) LIKE UPPER('%"+patName+"%') ");
					}
				}
				if(!genderValue.equals(""))
				{
					selectQuery.append(" AND a.gender = '"+genderValue+"' ");
				}
				if(!refNo.equals(""))
				{
					selectQuery.append(" AND a.bkg_lst_ref_no = '"+refNo+"' ");
				} 
				if(!locationValue.equals(""))
				{
					selectQuery.append(" AND a.nursing_unit_code = '"+locationValue+"' ");
				}

				if(!periodFrom.equals(""))
				{
					selectQuery.append(" AND trunc(a.preferred_date) >= to_date('"+periodFrom+"', 'dd/mm/yyyy') ");
				}
				if(!periodTo.equals(""))
				{
					selectQuery.append(" AND trunc(a.preferred_date) <= to_date('"+periodTo+"', 'dd/mm/yyyy') ");
				}			

				selectQuery.append(" ORDER BY 2, 1");
			}
			else if(refrlAappt.equals("L"))
			{
				if(!selectedLocation.equals(""))
				{
					selectQuery.append(" SELECT a.referral_id referenceNo, to_char(a.preferred_treatment_date, 'dd/mm/yyyy') apptDate, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name))  patient_name,a.sex patGender, to_char(a.date_of_birth, 'dd/mm/yyy') dob, b.long_desc long_desc FROM pr_referral_register a, ");
					if(selectedLocation.equals("N"))
					{
						selectQuery.append(" ip_nursing_unit b WHERE a.to_facility_id = '"+facility_id+"' AND ( a.preferred_treatment_date IS NULL OR trunc(a.preferred_treatment_date) >= trunc(sysdate)) AND a.to_facility_id = b.facility_id AND a.TO_LOCN_CODE = b.nursing_unit_code(+) AND a.patient_id IS NULL AND a.status = 'O' ");
					}
					if(selectedLocation.equals("C") || selectedLocation.equals("E") || selectedLocation.equals("Y") )
					{
						selectQuery.append(" op_clinic b WHERE a.to_facility_id = '"+facility_id+"' AND ( a.preferred_treatment_date IS NULL OR trunc(a.preferred_treatment_date) >= trunc(sysdate)) AND a.to_facility_id = b.facility_id AND a.to_locn_code = b.clinic_code AND a.patient_id IS NULL AND a.status = 'O' ");
					}
					if(selectedLocation.equals("W"))
					{
						selectQuery.append(" rd_wings b WHERE a.to_facility_id = '"+facility_id+"' AND ( a.preferred_treatment_date IS NULL OR trunc(a.preferred_treatment_date) >= trunc(sysdate)) AND a.to_facility_id = b.operating_facility_id AND a.to_locn_code = b.wing_code AND a.patient_id IS NULL AND a.status = 'O' ");
					}
				}
				else if(selectedLocation.equals(""))
				{
					if(RDinstall_yn.equals("N"))
					{
						selectQuery.append(" SELECT a.referral_id referenceNo, to_char(a.preferred_treatment_date, 'dd/mm/yyyy') apptDate, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.sex patGender, to_char(a.date_of_birth, 'dd/mm/yyyy') dob, (CASE WHEN to_locn_type = 'N' THEN (SELECT long_desc FROM ip_nursing_unit WHERE facility_id = a.to_facility_id AND nursing_unit_code = a.to_locn_code) ELSE (SELECT long_desc FROM op_clinic WHERE facility_id = a.to_facility_id AND clinic_code = a.to_locn_code) END ) long_desc FROM pr_referral_register a WHERE a.to_facility_id = '"+facility_id+"' AND a.patient_id IS NULL AND ( a.preferred_treatment_date IS NULL OR trunc(a.preferred_treatment_date) >= trunc(sysdate)) AND a.status = 'O' ");
					}
					else if(RDinstall_yn.equals("Y"))
					{
						selectQuery.append(" SELECT a.referral_id referenceNo, to_char(a.preferred_treatment_date, 'dd/mm/yyyy') apptDate, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name))  patient_name, a.sex patGender, to_char(a.date_of_birth, 'dd/mm/yyyy') dob, (CASE WHEN to_locn_type = 'N' THEN (SELECT long_desc FROM ip_nursing_unit WHERE facility_id = a.to_facility_id AND nursing_unit_code = a.to_locn_code) when to_locn_type = 'W' then (select short_Desc FROM rd_wings WHERE operating_facility_id = a.to_facility_id AND wing_code = a.to_locn_code) ELSE (SELECT long_desc FROM op_clinic WHERE facility_id = a.to_facility_id AND clinic_code = a.to_locn_code) END ) long_desc FROM pr_referral_register a WHERE a.to_facility_id = '"+facility_id+"' AND a.patient_id IS NULL AND ( a.preferred_treatment_date IS NULL OR trunc(a.preferred_treatment_date ) >= trunc(sysdate)) AND a.status = 'O' ");
					}
				}

				if(!national_id_no.equals(""))
				{
					selectQuery.append(" AND a.national_id_no = '"+national_id_no+"' ");
				}
				if(!alt_id1_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id1_no = '"+alt_id1_no+"' ");
				}
				if(!alt_id2_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id2_no = '"+alt_id2_no+"' ");
				}
				if(!alt_id3_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id3_no = '"+alt_id3_no+"' ");
				}
				if(!alt_id4_no.equals(""))
				{
					selectQuery.append(" AND a.alt_id4_no = '"+alt_id4_no+"' ");
				}
				if(!other_alt_type.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_type  = '"+other_alt_type+"' ");

				}
				if(!other_alt_Id.equals(""))
				{
					selectQuery.append(" AND a.oth_alt_id_no = '"+other_alt_Id+"' ");
				}
				if(!patName.equals(""))
				{
					if (localeName.equals("en"))
					{
						selectQuery.append(" AND UPPER(a.patient_name) LIKE UPPER('%"+patName+"%') ");
					}
					else
					{
						selectQuery.append(" AND UPPER(a.patient_name_loc_lang) LIKE UPPER('%"+patName+"%') ");
					}
				}
				if(!genderValue.equals(""))
				{
					selectQuery.append(" AND a.sex = '"+genderValue+"' ");
				}
				if(!refNo.equals(""))
				{
					selectQuery.append(" AND a.referral_id = '"+refNo+"' ");
				}
				if(!selectedLocation.equals(""))
				{
					selectQuery.append(" AND a.to_locn_type = '"+selectedLocation+"' ");
				}
				if(!locationValue.equals(""))
				{
					selectQuery.append(" AND a.to_locn_code = '"+locationValue+"' ");
				}

				if(!periodFrom.equals(""))
				{
					selectQuery.append(" AND trunc(a.preferred_treatment_date) >= to_date('"+periodFrom+"', 'dd/mm/yyyy') ");
				}
				if(!periodTo.equals(""))
				{
					selectQuery.append(" AND trunc(a.preferred_treatment_date) <= to_date('"+periodTo+"', 'dd/mm/yyyy') ");
				}
				
				selectQuery.append(" ORDER BY 2, 1");
			}
			
			rst1 = stmt1.executeQuery(selectQuery.toString());
			rst1.last();
			maxRecord = rst1.getRow();
			rst1.beforeFirst();
			%>
			<table  width='100%' border='0' align='center'>
				<tr>
					<td align='right' nowrap>
					<%
					if(!(start <= 1))
					{
						%>
						<A href='javascript:submitPrevNext(<%=(start-14)%>,<%=(end-14)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
						<%
					}
					if (!((start+14) >= maxRecord))
					{
						%>
						<A href='javascript:submitPrevNext(<%=(start+14)%>,<%=(end+14)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
						<%
					}
					%>
					</td>
				</tr>
			</table>

			<table border='1' cellpadding='0' cellspacing='0' width='100%' id='pat_details'>
			<tr>
				<th width='15%'><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></th>
				<th width='12%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
				<th width='33%' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
				<th width='8%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
				<th width='12%'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></th>
				<th width='20%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			</tr>
			<%
			if (start != 0)
			{
				for(int j=1; j<=start; i++,j++)
				{
					rst1.next() ;
				}
			}
			while(rst1.next() && i<=end)
			{	
				
				referenceNo		= rst1.getString("referenceNo");
				apptDate			= rst1.getString("apptDate");
				patient_name	= rst1.getString("patient_name");
				gender			= rst1.getString("patGender");
				dob				= rst1.getString("dob");
				location			= rst1.getString("long_desc");

				if(apptDate == null)
					apptDate ="";
				if(dob == null)
					dob ="";
				
				if(!gender.equals(""))
				{
				switch(gender.charAt(0))
							{
								case 'M' : gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels"); break;
								case 'F' : gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels"); break;
								default : gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
							}
				}


				if(referenceNo == null) referenceNo = "";
				if (apptDate != "") 
				{
					apptDate= DateUtils.convertDate(apptDate,"DMY","en",localeName);
				}
				else
					apptDate = "&nbsp;";

				if (dob != "") 
				{
					dob= DateUtils.convertDate(dob,"DMY","en",localeName);
				}
				else
					dob = "&nbsp;";

				if(patient_name == null) patient_name = "&nbsp;";
				if(gender == null) gender = "&nbsp;";
				if(location == null) location = "&nbsp;";

				%>
				<tr>
					 <td align='left' class='<%=classValue%>' width='15%'><a href="javascript:dispRefNum('<%=referenceNo%>')"><FONT SIZE="1" ><%=referenceNo%></FONT></a></TD>
					 <td align='left' class='<%=classValue%>' width='12%'><FONT SIZE="1"><%=apptDate%></FONT></TD>
					 <td align='left' class='<%=classValue%>' width='33%' nowrap><FONT SIZE="1"><%=patient_name%></FONT></TD>
					 <td align='left' class='<%=classValue%>' width='8%'><FONT SIZE="1"><%=gender%></FONT></TD>
					 <td align='left' class='<%=classValue%>' width='12%'><FONT SIZE="1"><%=dob%></FONT></TD>
					 <td align='left' class='<%=classValue%>' width='20%'><FONT SIZE="1"><%=location%></FONT></TD>
				</tr>
				<%
				if(classValue.equals("QRYEVEN")) classValue = "QRYODD";
				else classValue = "QRYEVEN";

				count++;
				i++;
			}
			if(count == 0)
			{%>
				<script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				parent.frames[2].location.href="../../eCommon/html/blank.html";
				document.getElementById('pat_details').style.visibility='hidden';
				</script>
			<%}
			%>
			</table>
			<input type='hidden' name='max_record' id='max_record' value='maxRecord'>
			<input type='hidden' name='from' id='from' value='<%=start%>'>
			<input type='hidden' name='to' id='to' value='<%=end%>'>
			<input type='hidden' name='start' id='start' value='<%=start%>'>
			<input type='hidden' name='end' id='end' value='<%=end%>'>
			<input type='hidden' name='refrlAappt' id='refrlAappt' value='<%=refrlAappt%>'>
			<input type='hidden' name='selectedLocation' id='selectedLocation' value='<%=selectedLocation%>'>
			<input type='hidden' name='patName' id='patName' value='<%=patName%>'>
			<input type='hidden' name='genderValue' id='genderValue' value='<%=genderValue%>'>
			<input type='hidden' name='refNo' id='refNo' value='<%=refNo%>'>
			<input type='hidden' name='periodFrom' id='periodFrom' value='<%=periodFrom%>'>
			<input type='hidden' name='periodTo' id='periodTo' value='<%=periodTo%>'>
			<input type='hidden' name='locationValue' id='locationValue' value='<%=locationValue%>'>
			<input type='hidden' name='RDinstall_yn' id='RDinstall_yn' value='<%=RDinstall_yn%>'>
		</form>
		<%
		if(selectQuery != null && selectQuery.length() > 0)
		{
			selectQuery.delete(0,selectQuery.length());
		}
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e.getMessage());
	}
	finally
	{
		 if(con!=null) ConnectionManager.returnConnection(con, request);
	}
%>
</body>
</html>
<%!
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>

