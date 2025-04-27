<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.sql.*,java.net.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="ForSplChars.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<script language="JavaScript">
<!--
async function showEncounterDetails(enc,patid)
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
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<%
	Connection con = null;
	Statement stmt = null;
	//PreparedStatement pstmt = null;
	//PreparedStatement pstmt_count = null;
	ResultSet rs =null;
	//ResultSet rs_count =null;
	//int total_count=0;
	StringBuffer sql = new StringBuffer();
//	StringBuffer sql_count = new StringBuffer();
	StringBuffer whereClause = new StringBuffer();
	int start=1;
	int end=0;
	int records_to_show=14;

	String facilityid	= (String)session.getValue("facility_id");
	String locale		= (String)session.getAttribute("LOCALE");
	String from			= request.getParameter("from");
	String to			= request.getParameter("to");
	String condition	= checkForNull(request.getParameter("whereclause"));
	String nursingunit	= checkForNull(request.getParameter("nursing_unit"));
	String specialty	= checkForNull(request.getParameter("specialty"));
	String practitioner = checkForNull(request.getParameter("practitioner"));
	String fromdate		= checkForNull(request.getParameter("from_date"));
	String todate		= checkForNull(request.getParameter("to_date"));
	String gender		= checkForNull(request.getParameter("gender"));
	String display		= checkForNull(request.getParameter("display"));
	String patientno	= checkForNull(request.getParameter("patient_no"));
	String encounterid	= checkForNull(request.getParameter("encounter_id"));
	String leavefromdate= checkForNull(request.getParameter("leave_from_date"));
	String leavetodate	= checkForNull(request.getParameter("leave_to_date"));
	String className	= "";
	int p_max_rec_cnt = 0;
	int nextOfRes = 1;
	int i = 0;
	//Added by Devang for Spl. Chars.
	nursingunit=singleToDoubleQuotes(nursingunit);
	specialty=singleToDoubleQuotes(specialty);
	practitioner=singleToDoubleQuotes(practitioner);
	whereClause.append(condition);

	if(!nursingunit.equals(""))
		//whereClause.append(" and assign_care_locn_code = '"+nursingunit+"' ");
		whereClause.append(" and B.NURSING_UNIT_CODE = '"+nursingunit+"' ");		
	if(!specialty.equals(""))
		//whereClause.append(" and specialty_code = '"+specialty+"' ");
		whereClause.append(" and B.specialty_code = '"+specialty+"' ");
	if(!practitioner.equals(""))
		//whereClause.append(" and attend_practitioner_id = '"+practitioner+"' ");
		whereClause.append(" and B.attend_practitioner_id = '"+practitioner+"' ");
	if(!fromdate.equals("") || !todate.equals(""))
			//whereClause.append(" and trunc(admission_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
			whereClause.append(" and trunc(B.admission_date_time) between to_date(nvl('"+fromdate+"','1/1/1111'),'dd/mm/rrrr') and to_date(nvl('"+todate+"','9/9/9999'),'dd/mm/rrrr') ");
	if(!gender.equals(""))
		//whereClause.append(" and sex = '"+gender+"' ");
		whereClause.append(" and C.sex = '"+gender+"' ");
	if(display.equals("0"))
		//whereClause.append(" and  (leave_to_date < SYSDATE AND leave_status IN ('1') OR leave_status = '4')");
		whereClause.append(" and  (A.leave_to_date < SYSDATE AND A.leave_status IN ('1') OR A.leave_status = '4')");
	else if(display.equals("1"))
		//whereClause.append("and leave_to_date < SYSDATE AND leave_status IN ('1')");
		whereClause.append("and A.leave_to_date < SYSDATE AND A.leave_status IN ('1')");
	else if(display.equals("2"))
		//whereClause.append("AND leave_status = '4'");
		whereClause.append("AND A.leave_status = '4'");
	if(!patientno.equals(""))
		//whereClause.append(" and patient_id = '"+patientno+"' ");
		whereClause.append(" and B.patient_id = '"+patientno+"' ");
	if(!encounterid.equals(""))
		//whereClause.append(" and encounter_id = '"+encounterid+"' ");
		whereClause.append(" and A.encounter_id = '"+encounterid+"' ");
	if(!leavefromdate.equals(""))
	//whereClause.append(" and trunc(leave_fr_date) >=  to_date(nvl('"+leavefromdate+"','1/1/1111'),'dd/mm/rrrr')");
		whereClause.append(" and trunc(A.leave_fr_date) >=  to_date(nvl('"+leavefromdate+"','1/1/1111'),'dd/mm/rrrr')");
	if(!leavetodate.equals(""))
		//whereClause.append(" and trunc(leave_to_date) <= to_date(nvl('"+leavetodate+"','9/9/9999'),'dd/mm/rrrr') ");
		whereClause.append(" and trunc(A.leave_to_date) <= to_date(nvl('"+leavetodate+"','9/9/9999'),'dd/mm/rrrr') ");
%>
</head>							
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<%
			try{
				con =ConnectionManager.getConnection(request);
				//Added by Devang for Previous/Next logic

				/*sql_count.append(" SELECT count(*) ");
				sql_count.append(" FROM ip_leave_detail_vw ");
				sql_count.append(" WHERE facility_id= ? ");
				sql_count.append(" "+whereClause.toString()+" ");
				sql_count.append(" ORDER BY encounter_id ");
				
				// out.println("First:"+ sql_count.toString());
				pstmt_count = con.prepareStatement(sql_count.toString());
				pstmt_count.setString(1,facilityid);

				rs_count = pstmt_count.executeQuery();
				if(rs_count.next())
				{
					total_count=rs_count.getInt(1);
				}
				*/	

				sql.append("SELECT TO_CHAR(b.admission_date_time,'dd/mm/rrrr hh24:mi') adm_date_time,a.encounter_id, c.patient_id, decode('"+locale+"','en',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name)) patient_name, c.SEX gender, a.leave_status, IP_GET_DESC.IP_NURSING_UNIT(b.facility_id, b.nursing_unit_CODE,'"+locale+"','2') nursing_unit, AM_GET_DESC.AM_PRACTITIONER(B.attend_practitioner_id,'"+localeName+"','1') practitioner_name, AM_GET_DESC.AM_SPECIALITY(B.specialty_code,'"+localeName+"','1')specialty_code, TO_CHAR(a.leave_fr_date,'dd/mm/rrrr hh:mi') leave_fr_date, TO_CHAR(a.leave_to_date,'dd/mm/rrrr hh:mi') leave_to_date, NVL(a.release_bed_yn,'N') release_bed_yn, b.bed_num bed_no FROM ip_leave_detail a, ip_open_encounter b, mp_patient c WHERE a.facility_id= '"+facilityid+"' and a.facility_id= b.facility_id and a.encounter_id = b.encounter_id and b.patient_id = c.patient_id "+whereClause.toString()+" ORDER BY a.encounter_id");
					
				/*stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
				rs = stmt.executeQuery(sql.toString());

				if ( (rs != null) )
				{
				   rs.last();
				   total_count = rs.getRow();
				   rs.beforeFirst();
				}*/
				//out.println(sql.toString());
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

				while((z < records_to_show) &&  rs.next())
				{
					if(p_max_rec_cnt==0)
					{
				
					out.println("<p><table align='right'><tr><td>");
					if ( !(start <= 0) )
                        out.println("<A HREF='../jsp/QueryPatientsNotReturnedFmLeaveResult.jsp?from="+(start-records_to_show)+"&to="+(end-records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'" +
						" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

                    if ( nextOfRes == 1 )
                        out.println("<A id='nextval' HREF='../jsp/QueryPatientsNotReturnedFmLeaveResult.jsp?from="+(start+records_to_show)+"&to="+(end+records_to_show)+"&whereclause="+URLEncoder.encode(whereClause.toString())+"'"
						+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				out.println("</td></tr></table></p>");
                out.println("<br><br>");
				
				out.println("<table  cellpadding=0 cellspacing=0 border=1 width='100%'>");

				/*sql.append(" SELECT TO_CHAR(admission_date_time,'dd/mm/rrrr hh24:mi') adm_date_time, ");
				sql.append(" encounter_id,patient_id,patient_name,DECODE(SEX,'M','Male','F','Female','U','Unknown') gender,leave_status,NURSING_UNIT_SHORT_DESC nursing_unit, ");
				sql.append(" TO_CHAR(leave_fr_date,'dd/mm/rrrr hh:mi') leave_fr_date, ");
				sql.append(" TO_CHAR(leave_to_date,'dd/mm/rrrr hh:mi') leave_to_date, ");
				sql.append(" NVL(release_bed_yn,'N') release_bed_yn, bed_no ");
				sql.append(" FROM ip_leave_detail_vw ");
				sql.append(" WHERE facility_id= ? ");
				sql.append(""+whereClause.toString()+"");
				sql.append(" ORDER BY encounter_id ");*/

				/*sql.append("SELECT TO_CHAR(b.admission_date_time,'dd/mm/rrrr hh24:mi') adm_date_time,		a.encounter_id, c.patient_id, decode('"+locale+"','"+locale+"',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name)) patient_name, c.SEX gender, a.leave_status, IP_GET_DESC.IP_NURSING_UNIT(b.facility_id, b.nursing_unit_CODE,'"+locale+"','2') nursing_unit, TO_CHAR(a.leave_fr_date,'dd/mm/rrrr hh:mi') leave_fr_date, TO_CHAR(a.leave_to_date,'dd/mm/rrrr hh:mi') leave_to_date, NVL(a.release_bed_yn,'N') release_bed_yn, b.bed_num bed_no FROM ip_leave_detail a, ip_open_encounter b, mp_patient c WHERE a.facility_id= ? and a.facility_id= b.facility_id and a.encounter_id = b.encounter_id and b.patient_id = c.patient_id and a.leave_to_date < SYSDATE AND a.leave_status IN ('1') and trunc(a.leave_fr_date) >= to_date(nvl('29/11/2005','1/1/1111'),'dd/mm/rrrr') and trunc(a.leave_to_date) <= to_date(nvl('29/11/2006','9/9/9999'),'dd/mm/rrrr') ORDER BY a.encounter_id");*/

				//out.println("Second:"+ sql.toString());

				//pstmt = con.prepareStatement(sql.toString());
				//pstmt.setString(1,facilityid);
				out.println("<tr><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fromdatetime.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ToDateTime.label","ip_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReleaseBed.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th><th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+"</th></tr>");
				}
						
				//rs = pstmt.executeQuery();
				/*if(start > 1)
				{
					for(int k=0; k < start ;k++)
						rs.next();
				}
				int z=0;
				while(rs.next()&& (z < records_to_show))
				{*/
					z++;
					if(i%2 == 0)
						className = "QRYEVEN";
					else
						className = "QRYODD";

					String sex = rs.getString("gender");

					if(sex.equalsIgnoreCase("M"))
						sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(sex.equalsIgnoreCase("F"))
						sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			
					String adm_date_time_display = rs.getString("adm_date_time");
					if(adm_date_time_display == null)
						adm_date_time_display = "";
					else
						adm_date_time_display = DateUtils.convertDate(adm_date_time_display,"DMYHM","en",locale);

					String leave_fr_date_display = rs.getString("leave_fr_date");
					if(leave_fr_date_display == null)
						leave_fr_date_display = "";
					else
						leave_fr_date_display = DateUtils.convertDate(leave_fr_date_display,"DMYHM","en",locale);

					String leave_to_date_display = rs.getString("leave_to_date");
					if(leave_to_date_display == null)
						leave_to_date_display = "";
					else
						leave_to_date_display = DateUtils.convertDate(leave_to_date_display,"DMYHM","en",locale);

					String img = "<img src='../../eCommon/images/enabled.gif'></img>";
					String img1 = "<img src='../../eCommon/images/disabled.gif'></img>";
					out.println("<tr><td nowrap class='"+className+"'>"+rs.getLong("encounter_id")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_id")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("patient_name")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+sex+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+adm_date_time_display+"&nbsp;</td>");
					String disp = rs.getString("leave_status");
					if (disp.equals("1"))
						disp= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels");
					else
						disp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abscond.label","common_labels");
					out.println("<td nowrap class='"+className+"'>"+disp+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+leave_fr_date_display+"&nbsp;</td>");			
					out.println("<td nowrap class='"+className+"'>"+leave_to_date_display+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("nursing_unit")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("practitioner_name")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+rs.getString("specialty_code")+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"' align=center>"+(rs.getString("release_bed_yn").equals("Y")?img:img1)+"&nbsp;</td>");
					out.println("<td nowrap class='"+className+"'>"+(rs.getString("bed_no")==null?"&nbsp;":rs.getString("bed_no"))+"&nbsp;</td></tr>");
					i++;
					p_max_rec_cnt++;
				}
				%>
				<script>
				if (parseInt('<%=p_max_rec_cnt%>')==0)
				{
					alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
					parent.frames[2].document.location.href = '../../eCommon/html/blank.html';
					parent.frames[1].document.forms[0].search.disabled
					=false;
				}
				</script>
				<%
				out.println("</table>");
				if( !rs.next() && p_max_rec_cnt!=0 )
				{
					nextOfRes=0;
				%>
				<script>
					document.getElementById('nextval').innerHTML = " ";
				</script>
				<%
				}
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				//if (pstmt != null) pstmt.close();
				//if (rs_count != null) rs_count.close();
				//if (pstmt_count != null) pstmt_count.close();

			}catch(Exception e) {out.println(e.toString());}
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

