<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,com.ehis.util.*,java.sql.*,java.net.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<%@ include file="ForSplChars.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<script language="JavaScript">

	async function showEncounterDetails(enc,patid,changefunc)
	{

		var retVal = 	new String();
		var dialogHeight= "80vh" ;
		var dialogWidth	= "70vw" ;
		var dialogTop = "0vh" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		retVal = await window.showModalDialog("../../eIP/jsp/CurrentEncounterMain.jsp?encounterId="+enc+"&patientId="+patid,arguments,features);
	}
	</script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../../eCommon/js/common.js' language='javascript'></script>
	
    <script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
			Connection con			= null;
			//PreparedStatement pstmt = null;
			Statement stmt			= null;
			ResultSet rs			= null;
			//int total_count=0;
			int start=1;
			int end=0;
			int records_to_show=14;
			
			String facilityid	= (String)session.getValue("facility_id");
			String locale       =(String) session.getAttribute("LOCALE"); 
			String from			= request.getParameter("from");
			String to			= request.getParameter("to");
			String whereclause = request.getParameter("whereclause");
			String nursingunit	= checkForNull(request.getParameter("nursing_unit"));
			String specialty	= checkForNull(request.getParameter("specialty"));
			String practitioner = checkForNull(request.getParameter("practitioner"));
			String fromdate		= checkForNull(request.getParameter("from_date"));
			String todate		= checkForNull(request.getParameter("to_date"));
			String gender		= checkForNull(request.getParameter("gender"));
			String patientno	= checkForNull(request.getParameter("patient_no"));
			String encounterid	= checkForNull(request.getParameter("encounter_id"));
			String expdisdate	= checkForNull(request.getParameter("exp_dis_date"));
			nursingunit			= singleToDoubleQuotes(nursingunit);
			specialty			= singleToDoubleQuotes(specialty);
			practitioner		= singleToDoubleQuotes(practitioner);
			String className	= "";
			StringBuffer whereClause = new StringBuffer();
			StringBuffer sqlQuery	 = new StringBuffer();
			int i = 0;
			int nextOfRes =1;
			int cnt = 0;
			if(whereclause==null)
			{
			if(!nursingunit.equals(""))
				whereClause.append(" and a.nursing_unit_code = '"+nursingunit+"' ");
			if(!specialty.equals(""))
				whereClause.append(" and a.specialty_code = '"+specialty+"' ");
			if(!practitioner.equals(""))
				//whereClause.append(" and a.practitioner_id = '"+practitioner+"' ");
				whereClause.append(" and a.attend_practitioner_id = '"+practitioner+"' ");				
			if(!fromdate.equals("") || !todate.equals(""))
				whereClause.append(" and trunc(A.admission_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
			if(!gender.equals(""))
				//whereClause.append(" and a.gender = '"+gender+"' ");
				whereClause.append(" and c.sex = '"+gender+"' ");
			if(!patientno.equals(""))
				whereClause.append(" and A.patient_id = '"+patientno+"' ");
			if(!encounterid.equals(""))
				whereClause.append(" and A.encounter_id = '"+encounterid+"' ");
			if(!expdisdate.equals(""))
				whereClause.append(" and trunc(a.EXP_DISCHARGE_DATE_TIME) = to_date('"+expdisdate+"','dd/mm/rrrr') ");
			}else{
				if(whereClause.length() > 0) whereClause.delete(0,whereClause.length());
					whereClause.append(whereclause) ;
			}
				
		%>
</head>							
<body onMouseDown="CodeArrest()" onKeyDown = "lockKey()">
	<%
			try{
				con =ConnectionManager.getConnection(request);
				
				/*sqlQuery.append("select count(*) cnt from IP_OPEN_ENCOUNTER_VW A,PR_ENCOUNTER_OTHER_DETAIL b  WHERE A.facility_id= ?  ");
				sqlQuery.append(" "+whereClause.toString()+" ");
				sqlQuery.append(" AND A.facility_id=b.operating_facility_id ");
				sqlQuery.append(" AND A.encounter_id=b.encounter_id ");
				sqlQuery.append(" AND NVL(EXP_DISCHARGE_DATE_TIME,SYSDATE)<SYSDATE ");
				pstmt = con.prepareStatement(sqlQuery.toString());
				pstmt.setString(1,facilityid);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					total_count=rs.getInt("cnt");
						
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(sqlQuery.length()>0)  sqlQuery.delete(0,sqlQuery.length());
				if(total_count==0)
				{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}else{*/
				
				/*sqlQuery.append(" SELECT (trunc(sysdate)-trunc(b.expected_discharge_date))excess_date, TO_CHAR(A.ADMISSION_DATE_TIME,'dd/mm/rrrr hh24:mi') admn_date_time, ");
				sqlQuery.append(" A.encounter_id,A.patient_id, A.patient_name,decode(a.gender,'M','Male','F','Female','U','Unknown') gender, ");
				sqlQuery.append(" TO_CHAR(b.expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date, ");
				sqlQuery.append(" A.nursing_unit_short_desc nursing_unit, a.specialty_short_desc,a.practitioner_name,A.bed_no ,A.room_no ");
				sqlQuery.append(" FROM IP_OPEN_ENCOUNTER_VW A,IP_ADT_TRN b ");
				sqlQuery.append(" WHERE A.facility_id= ?  ");
				sqlQuery.append(""+whereClause.toString()+"");
				sqlQuery.append(" AND A.facility_id=b.facility_id ");
				sqlQuery.append(" AND A.encounter_id=b.encounter_id ");
				sqlQuery.append(" AND NVL(expected_discharge_date,SYSDATE)<SYSDATE order by excess_date desc");*/

				/*sqlQuery.append(" SELECT (trunc(sysdate)-trunc(b.EXP_DISCHARGE_DATE_TIME))excess_date,TO_CHAR(A.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') admn_date_time, A.encounter_id,A.patient_id, A.patient_name,decode(a.gender,'M','Male','F','Female','U','Unknown') gender, TO_CHAR(b.EXP_DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') expected_discharge_date, A.nursing_unit_short_desc nursing_unit,a.specialty_short_desc,a.practitioner_name,A.bed_no ,A.room_no FROM IP_OPEN_ENCOUNTER_VW A, PR_ENCOUNTER_OTHER_DETAIL b WHERE A.facility_id= ? ");
				sqlQuery.append(whereClause.toString());
				sqlQuery.append(" AND A.facility_id=b.operating_facility_id  AND A.encounter_id=b.encounter_id AND NVL(EXP_DISCHARGE_DATE_TIME,SYSDATE)<SYSDATE order by excess_date desc ");*/


				sqlQuery.append("SELECT  (trunc(sysdate)-trunc(a.EXP_DISCHARGE_DATE_TIME))excess_date, TO_CHAR(A.ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi') admn_date_time,A.encounter_id, A.patient_id, decode('"+localeName+"','en',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name))  patient_name, c.sex gender, TO_CHAR(a.EXP_DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') expected_discharge_date,IP_GET_DESC.IP_NURSING_UNIT(A.facility_id,A.nursing_unit_Code,'"+localeName+"','2') nursing_unit, AM_GET_DESC.AM_SPECIALITY(A.Specialty_Code,'"+localeName+"','2') specialty_short_desc, AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,'"+localeName+"','1') practitioner_name, A.bed_num bed_no, A.room_num  room_no FROM IP_OPEN_ENCOUNTER A, mp_patient c WHERE A.facility_id= '"+facilityid+"' "+whereClause.toString()+" AND NVL(a.EXP_DISCHARGE_DATE_TIME,SYSDATE)<SYSDATE and a.patient_id = c.patient_id  order by excess_date desc"); 				
				//pstmt = con.prepareStatement(sqlQuery.toString());
				//pstmt.setString(1,facilityid);
				/*stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				//rs = pstmt.executeQuery();
				rs = stmt.executeQuery(sqlQuery.toString());

				if ( (rs != null) )
				{
						rs.last();
						total_count = rs.getRow();
						rs.beforeFirst();
				}

				if(total_count==0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				}
				else
				{*/
				//out.println(sqlQuery.toString());
				stmt = con.createStatement();
				rs = stmt.executeQuery(sqlQuery.toString());

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
				
				while((z < records_to_show) && rs.next())
				{
					if(cnt == 0)
					{
				out.println("<p><table align='right'><tr><td>");
				if ( !(start <= 1) )
                        out.println("<A HREF='../jsp/QueryOverstayPatientsResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
						" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

                    if ( nextOfRes == 1 )
                        out.println("<A id='nextval' HREF='../jsp/QueryOverstayPatientsResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
						+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				out.println("</td></tr></table></p>");
                out.println("<br><br>");
				


				out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");
				out.println("<tr><th nowrap>&nbsp;</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ExpectedDischargeDateTime.label","ip_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.OverstayDays.label","ip_labels")+"&nbsp;"+"</th><th  nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+"</th></tr>");
				}
				/*int z=0;		
				while(rs.next() && (z < records_to_show))
				{*/
					z++;
					
					if(i%2 == 0)
						className = "QRYEVEN";
					else
						className = "QRYODD";

					String sex = rs.getString("gender");

					if(sex.equalsIgnoreCase("M"))
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(sex.equalsIgnoreCase("F"))
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			
					String admn_date_time_display = rs.getString("admn_date_time");
					if(admn_date_time_display == null)
						admn_date_time_display = "";
					else
						admn_date_time_display = DateUtils.convertDate(admn_date_time_display,"DMYHM","en",locale);

					String expected_discharge_date_display = rs.getString("expected_discharge_date");
					if(expected_discharge_date_display == null)
						expected_discharge_date_display = "";
					else
						expected_discharge_date_display = DateUtils.convertDate(expected_discharge_date_display,"DMYHM","en",locale);

					out.println("<tr><td class='"+className+"' ><a href=\"javascript:showEncounterDetails('"+rs.getString("encounter_id")+"','"+rs.getString("patient_id")+"','N')\">+</a></td>");
					out.println("<td nowrap class='"+className+"'>"+admn_date_time_display+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+expected_discharge_date_display+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("excess_date")==null?"&nbsp;":rs.getString("excess_date"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("encounter_id")==null?"&nbsp;":rs.getString("encounter_id"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("patient_id")==null?"&nbsp;":rs.getString("patient_id"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("patient_name")==null?"&nbsp;":rs.getString("patient_name"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("gender")==null?"&nbsp;":sex)+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("nursing_unit")==null?"&nbsp;":rs.getString("nursing_unit"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("specialty_short_desc")==null?"&nbsp;":rs.getString("specialty_short_desc"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("practitioner_name")==null?"&nbsp;":rs.getString("practitioner_name"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("room_no")==null?"&nbsp;":rs.getString("room_no"))+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("bed_no")==null?"&nbsp;":rs.getString("bed_no"))+"&nbsp;</td></tr>");

					i++;
					cnt++;
				}
				out.println("</table>");

				if( !rs.next() && cnt!=0 )
				{
					nextOfRes=0;
				%>
				<script>
					document.getElementById('nextval').innerHTML = " ";
				</script>
				<%
				} 
				if( cnt == 0) {																					        out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
				}
				//}
			}catch(Exception e) {out.println(e.toString());e.printStackTrace();
			}
			finally
			{
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
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

