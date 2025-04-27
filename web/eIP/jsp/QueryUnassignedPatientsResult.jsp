<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,com.ehis.util.*,java.net.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="ForSplChars.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<script language="JavaScript">

async function showEncounterDetails(enc,patid)
{
	var retVal = 	new String();
	var dialogHeight= "80vh";
	var dialogWidth = "70vw";
	var dialogTop	= "0vh";
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eIP/jsp/CurrentEncounterMain.jsp?encounterId="+enc+"&patientId="+patid,arguments,features);
}
</script>

	<link rel="stylesheet" type="text/css" href='../../eCommon/html/<%=sStyle%>'></link>
	

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>

	<%
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		Statement ParamStmt = null;
        ResultSet ParamRS	= null;
		StringBuffer sql = new StringBuffer();
		String pat_check_in_allowed_yn = "";
		int start=1;
		int end=0;
		int nextOfRes = 1;
		int records_to_show	= 14;
		int p_max_record	= 0;
		String facilityid	= (String)session.getAttribute("facility_id");
		String from			= request.getParameter("from");
		String to			= request.getParameter("to");
		StringBuffer whereClause	= new StringBuffer();
		whereClause.append(checkForNull(request.getParameter("whereclause")));
		String nursingunit	= checkForNull(request.getParameter("nursing_unit"));
		String specialty	= checkForNull(request.getParameter("specialty"));
		String practitioner = checkForNull(request.getParameter("practitioner"));
		String fromdate		= checkForNull(request.getParameter("from_date"));
		String todate		= checkForNull(request.getParameter("to_date"));
		String gender		= checkForNull(request.getParameter("gender"));
		String patientno	= checkForNull(request.getParameter("patient_no"));
		String encounterid	= checkForNull(request.getParameter("encounter_id"));
		String fromquery	= checkForNull(request.getParameter("fromquery"));
		String transferred_from_date	= checkForNull(request.getParameter("transferred_from_date"));
		String transferred_to_date	= checkForNull(request.getParameter("transferred_to_date"));
		String user = request.getParameter("user")==null?"":request.getParameter("user");

		nursingunit=singleToDoubleQuotes(nursingunit);
		specialty=singleToDoubleQuotes(specialty);
		practitioner=singleToDoubleQuotes(practitioner);
		user=singleToDoubleQuotes(user);
		String className = "";
		int i = 0;
		

		if(fromquery.equals("CE")){
			if(!nursingunit.equals(""))
				whereClause.append(" and a.to_nursing_unit = '"+nursingunit+"' ");
			if(!specialty.equals(""))
				whereClause.append(" and a.to_specialty_code = '"+specialty+"' ");
			if(!practitioner.equals(""))
				whereClause.append(" and a.to_practitioner_id = '"+practitioner+"' ");
			if(!fromdate.equals("") || !todate.equals(""))
				whereClause.append(" and trunc(a.admission_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!gender.equals(""))
				whereClause.append(" and b.sex = '"+gender+"' ");
			if(!patientno.equals(""))
				whereClause.append(" and a.patient_id = '"+patientno+"' ");
			if(!encounterid.equals(""))
				whereClause.append(" and a.encounter_id = '"+encounterid+"' ");
			if(!transferred_from_date.equals("") || !transferred_to_date.equals(""))
				whereClause.append(" and trunc(a.trn_date_time) between to_date(nvl('"+transferred_from_date+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+transferred_to_date+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!user.equals(""))
				whereClause.append(" and a.modified_by_id = '"+user+"' ");
		}else
		{
			if(!nursingunit.equals(""))
				whereClause.append(" and a.nursing_unit_code = '"+nursingunit+"' ");
			if(!specialty.equals(""))
				whereClause.append(" and a.specialty_code = '"+specialty+"' ");
			if(!practitioner.equals(""))
				whereClause.append(" and a.ATTEND_PRACTITIONER_ID = '"+practitioner+"' ");
			if(!fromdate.equals("") || !todate.equals(""))
				whereClause.append(" and trunc(a.admission_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!gender.equals(""))
				whereClause.append(" and b.sex = '"+gender+"' ");
			if(!patientno.equals(""))
				whereClause.append(" and a.patient_id = '"+patientno+"' ");
			if(!encounterid.equals(""))
				whereClause.append(" and a.encounter_id = '"+encounterid+"' ");
		}
	%>
</head>							
<body  onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<%
	try
	{
		con =ConnectionManager.getConnection(request);
		try
		{
			String paramSql="select PAT_CHECK_IN_ALLOWED_YN from ip_param where facility_ID='"+facilityid+"'";
			ParamStmt = con.createStatement();
			ParamRS = ParamStmt.executeQuery( paramSql );
			if(ParamRS!=null)
			{
				if( ParamRS.next())
				{
					pat_check_in_allowed_yn = ParamRS.getString("PAT_CHECK_IN_ALLOWED_YN");
				}
			}
			if (ParamRS != null)	ParamRS.close();
			if (ParamStmt != null)	ParamStmt.close();	
		}catch(Exception e) 
		{
			//out.println("Exp in Param : "+e.toString());
			e.printStackTrace();
		}
		
		//Added by Devang for Previous/Next logic
		/*sql_count.append("select count(*) from ");
		sql_count.append(" ip_open_encounter_vw ");
		sql_count.append(" where facility_id=?  ");
		sql_count.append(""+whereClause.toString()+"");

		if(pat_check_in_allowed_yn.equals("Y"))
			sql_count.append(" and ADT_STATUS = '00' ");
		else
			sql_count.append(" and bed_no is null ");
		
		sql_count.append(" order by admission_date_time desc ");

		pstmt_count = con.prepareStatement(sql_count.toString());
		pstmt_count.setString(1,facilityid);
		rs_count = pstmt_count.executeQuery();
		if(rs_count.next())
		{
			total_count=rs_count.getInt(1);
		}*/
		/*sql.append(" select to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admn_date_time,encounter_id, ");
		sql.append(" patient_id,patient_name, decode(gender,'M','Male','F','Female','U','Unknown') gender, nursing_unit_short_desc nursing_unit, ");
		sql.append(" bed_class_short_desc bed_class,specialty_short_desc, practitioner_name practitioner_short_name from ip_open_encounter_vw ");
		sql.append(" where facility_id=?  ");
		sql.append(" "+whereClause.toString()+" ");*/

			if(fromquery.equals("CE")){
			sql.append("select a.encounter_id, a.patient_id, b.patient_name, b.sex gender, to_char(a.trn_date_time,'dd/mm/rrrr hh24:mi')trn_date_time, IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.to_nursing_unit,'"+localeName+"','2') to_nursing_unit_short_desc, AM_GET_DESC.AM_SPECIALITY(a.to_SPECIALTY_CODE,'"+localeName+"','2') to_specialty_short_desc, AM_GET_DESC.AM_PRACTITIONER(a.to_PRACTITIONER_ID,'"+localeName+"','1') to_practitioner_short_name, a.to_room_no, a.trn_code, ip_get_desc.ip_transfer_type(a.trn_code,'"+localeName+"','2') trn_code_desc, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi')admission_date_time, a.modified_by_id, ip_get_desc.ip_admission_type((select visit_adm_type from pr_encounter where facility_id=a.facility_id and encounter_id=a.encounter_id),'"+localeName+"','2') adm_type_desc from ip_adt_trn a, mp_patient b where a.facility_id='"+facilityid+"' and a.tfr_type = 'I' and a.patient_id = b.patient_id ");

			sql.append(" "+whereClause.toString()+" ");
			sql.append(" order by a.admission_date_time desc ");
		}else{
		
		sql.append(" select to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admn_date_time,a.encounter_id, a.patient_id, decode('"+localeName+"','en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, b.sex gender,IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.nursing_unit_code,'"+localeName+"','2') nursing_unit,IP_GET_DESC.IP_BED_CLASS(a.BED_CLASS_CODE,'"+localeName+"','2') bed_class, AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,'"+localeName+"','2') specialty_short_desc, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_short_name from    ip_open_encounter a, mp_patient b where a.facility_id='"+facilityid+"' and a.patient_id = b.patient_id  ");
		sql.append(" "+whereClause.toString()+" ");
			

		if(pat_check_in_allowed_yn.equals("Y"))
			//sql.append(" and ADT_STATUS = '00' ");
			sql.append(" and a.ADT_STATUS = '00' ");
		else
			//sql.append(" and bed_no is null ");
		sql.append(" and a.bed_num is null ");
		sql.append(" order by a.admission_date_time desc ");
		}
	
		stmt = con.createStatement();

		
		rs = stmt.executeQuery(sql.toString());

		if ( from == null )
            start = 0 ;
        else
            start = Integer.parseInt( from ) ;
        if ( to == null )
            end = records_to_show ;
        else
            end = Integer.parseInt( to ) ;
		if(start > 1)
		{
			for(int k=0; k < start ;k++)
				rs.next();
		}
		int z=0;		
		while( (z < records_to_show) && rs.next() )
		{
			if( p_max_record == 0 )
			{	

		out.println("<p><table align='right'><tr><td>");
		if ( !(start <= 0) )
                out.println("<A HREF='../jsp/QueryUnassignedPatientsResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"&fromquery="+fromquery+"'" +
				" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
            if ( nextOfRes == 1 )
                out.println("<A id='nextval' HREF='../jsp/QueryUnassignedPatientsResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"&fromquery="+fromquery+"'"
				+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td></tr></table></p>
			<br><br>

			<table  cellpadding=0 cellspacing=0 border=1 width='100%'>
				<tr>
					
					<%if(fromquery.equals("CE")){%>
						<th>&nbsp;</th>
						<th nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="eIP.Transferred.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.datetime.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</th>
						<th nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.TransferredBy.label" bundle="${common_labels}"/>&nbsp;</th>
						<th nowrap><fmt:message key="Common.TransferTo.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;</th>
						<!--<th nowrap><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></th>-->
					<%}else{%>
						<th>&nbsp;</th>
						<th><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/>&nbsp;</th>
						<th><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</th>
						<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</th>
						<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</th>
						<th><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</th>
						<th><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</th>
						<th><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</th>
						<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;</th>
					<%}%>
			</tr>
			<%
			}
		/*int z=0;		
		while(rs.next() && (z < records_to_show))
		{*/
			z++;
			if(i%2 == 0)
				className = "QRYEVENSMALL";
			else
				className = "QRYODDSMALL";
			String sex = rs.getString("gender");
			if(sex.equalsIgnoreCase("M"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(sex.equalsIgnoreCase("F"))
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else
				sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			
			if(fromquery.equals("CE")){
				String admission_date_time = rs.getString("admission_date_time");
				if(admission_date_time == null)
					admission_date_time = "";
				else
					admission_date_time = DateUtils.convertDate(admission_date_time,"DMYHM","en",localeName);
				
				String trn_date_time_display = rs.getString("trn_date_time");
				if(trn_date_time_display == null)
					trn_date_time_display = "";
				else
					trn_date_time_display = DateUtils.convertDate(trn_date_time_display,"DMYHM","en",localeName);
					
					out.println("<tr><td class='"+className+"'><a href=\"javascript:showEncounterDetails('"+rs.getString("encounter_id")+"','"+rs.getString("patient_id")+"')\">+</a></td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getLong("encounter_id")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_id")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_name")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+admission_date_time+"</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("adm_type_desc")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+sex+"</td>");
					out.println("<td nowrap class='"+className+"'>"+trn_date_time_display+"</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("to_nursing_unit_short_desc")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("to_specialty_short_desc")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("to_practitioner_short_name")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("to_room_no")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("modified_by_id")+"</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("to_nursing_unit_short_desc")+"</td>");
						
					//out.println("<td nowrap class='"+className+"'>"+(rs.getString("trn_code_desc")==null?"&nbsp;":rs.getString("trn_code_desc"))+"</td></tr>");

			}else{
				out.println("<tr><td class='"+className+"'><a href=\"javascript:showEncounterDetails('"+rs.getString("encounter_id")+"','"+rs.getString("patient_id")+"')\">+</a></td>");
			
			
			String admn_date_time_display = rs.getString("admn_date_time");
			if(admn_date_time_display == null)
				admn_date_time_display = "";
			else
				admn_date_time_display = DateUtils.convertDate(admn_date_time_display,"DMYHM","en",localeName);

			out.println("<td nowrap class='"+className+"'>"+admn_date_time_display+"</td>");
			out.println("<td nowrap class='"+className+"'>"+rs.getLong("encounter_id")+"</td>");
			out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_id")+"</td>");
			out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_name")+"</td>");
			out.println("<td nowrap class='"+className+"'>"+sex+"</td>");
			out.println("<td nowrap class='"+className+"'>"+rs.getString("nursing_unit")+"</td>");
			out.println("<td nowrap class='"+className+"'>"+(rs.getString("specialty_short_desc")==null?"&nbsp;":rs.getString("specialty_short_desc"))+"</td><td nowrap class='"+className+"'>"+(rs.getString("practitioner_short_name")==null?"&nbsp;":rs.getString("practitioner_short_name"))+"</td>");
			out.println("</tr>");
			}
			i++;
			p_max_record++;
		}

		%>
			<script>
				if (parseInt('<%=p_max_record%>')== 0)
				{
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
					if(parent.frames[1].document.forms[0] != null) 
						parent.frames[1].document.forms[0].search.disabled = false;
					parent.frames[2].document.location.href = '../../eCommon/html/blank.html';
					
				}
			</script>
		<%
		out.println("</table>");

			if( !rs.next() && p_max_record!=0 )
			{
				nextOfRes=0;
			%>
			<script>
				document.getElementById("nextval").innerHTML = " ";
			</script>
			<%
			}
	
		if (rs != null) rs.close();
		//if (pstmt != null) pstmt.close();
		if (stmt != null) stmt.close();
		//if (rs_count != null) rs_count.close();
		//if (pstmt_count != null) pstmt_count.close();
	
	}catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
	finally
	{
		ConnectionManager.returnConnection(con,request);
		out.println("<script>if(parent.frames[1].document.forms[0] != null) parent.frames[1].document.forms[0].search.disabled = false;</script>");
	}
	%>
</body>
</html>

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

