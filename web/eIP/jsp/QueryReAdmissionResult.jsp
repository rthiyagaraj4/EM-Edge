<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,com.ehis.util.*,java.sql.*,java.net.*" %>
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

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	//PreparedStatement pstmt = null;
	//PreparedStatement pstmt_count = null;
	Statement stmt = null;
	ResultSet rs =null;
	//ResultSet rs_count =null;
	//int total_count=0;
	String sql = "";
//	String sql_count = "";
	int start=1;
	int end=0;
	int records_to_show=14;

	int nextOfRes = 1;
	int cnt = 0;
	
	String facilityid = (String)session.getValue("facility_id");
	String from = request.getParameter("from");
	String to = request.getParameter("to");
	StringBuffer whereClause = new StringBuffer();
	whereClause.append(checkForNull(request.getParameter("whereclause")));
	String nursingunit = request.getParameter("nursing_unit")==null?"":request.getParameter("nursing_unit");
	String specialty = request.getParameter("specialty")==null?"":request.getParameter("specialty");
	String practitioner = request.getParameter("practitioner")==null?"":request.getParameter("practitioner");
	String fromdate = request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String todate = request.getParameter("to_date")==null?"":request.getParameter("to_date");
	String gender = request.getParameter("gender")==null?"":request.getParameter("gender");
	String patientno = request.getParameter("patient_no")==null?"":request.getParameter("patient_no");
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	//Added by Devang for Spl. Chars.

	nursingunit=singleToDoubleQuotes(nursingunit);
	specialty=singleToDoubleQuotes(specialty);
	practitioner=singleToDoubleQuotes(practitioner);
	String className = "";

	int i = 0;

	if(!nursingunit.equals(""))
		whereClause.append(" and a.assign_care_locn_code = '"+nursingunit+"' ");
	if(!specialty.equals(""))
		whereClause.append(" and a.specialty_code = '"+specialty+"' ");
	if(!practitioner.equals(""))
		whereClause.append(" and a.attend_practitioner_id = '"+practitioner+"' ");
	if(!fromdate.equals("") || !todate.equals(""))
		whereClause.append(" and trunc(a.visit_adm_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
	if(!gender.equals(""))
		whereClause.append(" and e.sex = '"+gender+"' ");
	if(!patientno.equals(""))
		whereClause.append(" and a.patient_id = '"+patientno+"' ");
	if(!encounterid.equals(""))
		whereClause.append(" and a.encounter_id = '"+encounterid+"' ");
%>

</head>							
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<%
			try{
				con =ConnectionManager.getConnection(request);

				/*sql_count ="SELECT count(1) FROM PR_ENCOUNTER a , MP_PATIENT e "+
				" WHERE a.facility_id='"+facilityid+"' AND a.patient_id=e.patient_id and a.adt_status != '09' AND "+
				" a.encounter_id = (CASE WHEN ((TRUNC(discharge_date_time)=(select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = a.patient_id)) "+
				" OR (TRUNC(visit_adm_date_time) IS NOT NULL AND TRUNC(discharge_date_time) IS NULL)) "+ 
				" THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' "+
				" AND a.patient_id IN (SELECT b.patient_id FROM PR_ENCOUNTER b "+
				" WHERE b.facility_id='"+facilityid+"' AND b.adt_status != '09' and b.encounter_id = "+
				" (CASE WHEN ((TRUNC(discharge_date_time) = (select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = b.patient_id)) OR "+
				" (TRUNC(visit_adm_date_time) IS NOT NULL AND  TRUNC(discharge_date_time) IS NULL)) "+
				" THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' "+
				" GROUP BY b.patient_id HAVING COUNT(*) > 1 ) "+whereClause.toString();


				pstmt_count = con.prepareStatement(sql_count);
				rs_count = pstmt_count.executeQuery();
				
				if(rs_count.next())
				{
					total_count=rs_count.getInt(1);
				}
					
			if (total_count>0)
			{
				*/
				/*sql="SELECT a.patient_id,patient_name,decode(sex,'M','Male','F','Female','U','Unknown') sex, a.encounter_id,to_char(a.visit_adm_date_time,'dd/mm/rrrr hh24:mi') admn_date_time,adt_status, "+
				" to_char(a.Discharge_date_time,'dd/mm/rrrr hh24:mi') disc_date_time FROM PR_ENCOUNTER a , MP_PATIENT e "+
				" WHERE a.facility_id='"+facilityid+"' AND a.patient_id=e.patient_id AND a.adt_status != '09' and "+
				" a.encounter_id = (CASE WHEN ((TRUNC(discharge_date_time)=(select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = a.patient_id)) "+
				" OR (TRUNC(visit_adm_date_time) IS NOT NULL AND TRUNC(discharge_date_time) IS NULL)) "+ 
				" THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' "+
				" AND a.patient_id IN (SELECT b.patient_id FROM PR_ENCOUNTER b "+
				" WHERE b.facility_id='"+facilityid+"' AND b.adt_status != '09' and b.encounter_id = "+
				" (CASE WHEN ((TRUNC(discharge_date_time) = (select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = b.patient_id)) OR "+
				" (TRUNC(visit_adm_date_time) IS NOT NULL AND TRUNC(discharge_date_time) IS NULL)) "+
				" THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' "+
				" GROUP BY b.patient_id HAVING COUNT(*) > 1 ) "+whereClause.toString() ;*/


				sql="SELECT a.patient_id, decode('"+localeName+"','en',E.patient_name,nvl(E.patient_name_loc_lang, E.patient_name)) patient_name, E.sex sex, a.encounter_id, to_char(a.visit_adm_date_time,'dd/mm/rrrr hh24:mi') admn_date_time,adt_status, AM_GET_DESC.AM_PRACTITIONER(a.admit_practitioner_id,'"+localeName+"','1') practitioner_name, IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.ASSIGN_CARE_LOCN_code,'"+localeName+"','2') nursing_unit, AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+localeName+"','1')specialty_code, to_char(a.Discharge_date_time,'dd/mm/rrrr hh24:mi') disc_date_time FROM PR_ENCOUNTER a, MP_PATIENT e WHERE a.facility_id='"+facilityid+"'  AND a.patient_id=e.patient_id AND a.adt_status != '09' and  a.encounter_id = (CASE WHEN ((TRUNC(discharge_date_time)=(select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = a.patient_id)) OR (TRUNC(visit_adm_date_time) IS NOT NULL AND TRUNC(discharge_date_time) IS NULL)) THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' AND a.patient_id IN (SELECT b.patient_id FROM PR_ENCOUNTER b  WHERE b.facility_id='"+facilityid+"' AND b.adt_status != '09' and b.encounter_id =  (CASE WHEN ((TRUNC(discharge_date_time) = (select TRUNC(max(visit_adm_date_time)) from pr_encounter where facility_id='"+facilityid+"' and patient_id = b.patient_id)) OR (TRUNC(visit_adm_date_time) IS NOT NULL AND TRUNC(discharge_date_time) IS NULL)) THEN encounter_id ELSE 0 END ) AND assign_care_locn_type='N' GROUP BY b.patient_id HAVING COUNT(*) > 1 ) "+whereClause.toString() + " order by a.visit_adm_date_time desc" ;

				/*stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				//pstmt = con.prepareStatement(sql);
				//rs = pstmt.executeQuery();

				rs = stmt.executeQuery(sql);

				if ( (rs != null) )
				{
						rs.last();
						total_count = rs.getRow();
						rs.beforeFirst();
				}

				if (total_count>0)
				{		*/
						//out.println(sql);
						stmt = con.createStatement();
						rs = stmt.executeQuery(sql);
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
							if(cnt == 0) 
							{
						out.println("<p><table align='right'><tr><td>");
						if ( !(start <= 0) )
								out.println("<A HREF='../jsp/QueryReAdmissionResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
								" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

							if ( nextOfRes == 1 )
								out.println("<A id='nextval' HREF='../jsp/QueryReAdmissionResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
								+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
						out.println("</td></tr></table></p>");
						out.println("<br><br>");
						
						/*out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");
						out.println("<tr><th nowrap>&nbsp;</th><th nowrap>Admission Date/Time</th><th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th><th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th><th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th><th nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th><th nowrap><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></th></tr>");
						*/
						%>
						<table  cellpadding=0 cellspacing=0 border=1 width='100%'>
						<tr><th nowrap>&nbsp;</th><th nowrap><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/>&nbsp;</th><th nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</th><th nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</th><th nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</th><th nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;</th><th nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;</th><th nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;</th><th nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</th><th nowrap><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/>&nbsp;</th></tr>
						<%
						}
						/*int z=0;		
						while(rs.next() && (z < records_to_show))
						{*/
							z++;
							if(i%2 == 0)
								className = "QRYEVEN";
							else
								className = "QRYODD";
							
							String adt_status=rs.getString("adt_status");
							if(adt_status == null) adt_status	= "";

							String sex = rs.getString("sex");

							if(sex.equalsIgnoreCase("M"))
								sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							else if(sex.equalsIgnoreCase("F"))
								sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							else
								sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");


							if(adt_status.equals("01"))
							out.println("<tr><td class='"+className+"'><a href=\"javascript:showEncounterDetails('"+rs.getString("encounter_id")+"','"+rs.getString("patient_id")+"')\">+</a></td>");
							else
							out.println("<td class='"+className+"'>&nbsp;</td>");

							String admn_date_time_display = rs.getString("admn_date_time");
							if(admn_date_time_display == null)
								admn_date_time_display = "&nbsp;";
							else
								admn_date_time_display = DateUtils.convertDate(admn_date_time_display,"DMYHM","en",localeName);

							String disc_date_time_display = rs.getString("disc_date_time");
							if(disc_date_time_display == null)
								disc_date_time_display = "&nbsp;";
							else
								disc_date_time_display = DateUtils.convertDate(disc_date_time_display,"DMYHM","en",localeName);

							
							out.println("<td nowrap class='"+className+"'>"+admn_date_time_display+"</td>");
							out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_id")+"</td>");
							out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_name")+"</td>");
							out.println("<td nowrap class='"+className+"'>"+sex+"</td>");
							out.println("<td nowrap class='"+className+"'>"+rs.getString("encounter_id")+"</td>");
							out.println("<td nowrap class='"+className+"'>"+rs.getString("nursing_unit")+"</td>");
							out.println("<td nowrap class='"+className+"'>"+rs.getString("practitioner_name")+"</td>"); out.println("<td nowrap class='"+className+"'>"+rs.getString("specialty_code")+"</td>");
							out.println("<td nowrap class='"+className+"'>"+disc_date_time_display+"</td></tr>");
							i++;
							cnt++;
						}
						out.println("</table>");
			 /*}
			 else
			 {
				 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			 }*/

			 if(cnt == 0)
				 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			 
			 if( !rs.next() && cnt!=0 )
			{
				nextOfRes=0;
			%>
			<script>
				document.getElementById('nextval').innerHTML = " ";
			</script>
			<%
			}

			}catch(Exception e) {out.println(e.toString());}
			finally
			{
				if (rs != null) rs.close();
				//if (pstmt != null) pstmt.close();
				if (stmt != null) stmt.close();
				//if (rs_count != null) rs_count.close();
				//if (pstmt_count != null) pstmt_count.close();
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

