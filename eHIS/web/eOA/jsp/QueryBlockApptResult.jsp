<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" %>
<html>
<head>

	 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script language='javascript' src='../../eCommon/js/common.js'></script>

	
</head>
<%
  Connection con = null;
  Statement stmt = null;
  ResultSet rs = null;
  Statement stmt1 = null;
  request.setCharacterEncoding("UTF-8");
  StringBuffer sql = new StringBuffer("");
  StringBuffer sql1 = new StringBuffer("");

try {
	con = ConnectionManager.getConnection(request);

	Boolean isRemarksFieldAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "REMARKS_FOR_OTHERS"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	 String locale = (String)session.getAttribute("LOCALE");	
     String clinic_code = request.getParameter("clinic_code");
     String speciality = request.getParameter("speciality");
	// out.println("speciality-->"+speciality);
	 String practitioner_id = request.getParameter("practitioner_id");
     String clinic_day_no = request.getParameter("clinic_day_no");
     String from_date = request.getParameter("from_date");
     String to_date = request.getParameter("to_date");
     String facilityId = request.getParameter("facilityId");
	 String locntype =request.getParameter("locn_type");
	 String resource_class =request.getParameter("resource_class");
	if(locntype == null || locntype.equals("null") ) locntype="";
	if(resource_class == null || resource_class.equals("null")) resource_class="";
	if(clinic_code == null || clinic_code.equals("null")) clinic_code = "";
	if(speciality == null || speciality.equals("null")) speciality = "";
	if(practitioner_id == null || practitioner_id.equals("null")) practitioner_id = "";
	if(clinic_day_no == null || clinic_day_no.equals("null")) clinic_day_no = "";
	if(from_date == null || from_date.equals("null")) from_date = "";
	if(to_date == null || to_date.equals("null")) to_date = "";
	if(facilityId == null || facilityId.equals("null")) facilityId = "";

	 from_date=DateUtils.convertDate(from_date,"DMY",locale,"en");
	to_date=DateUtils.convertDate(to_date,"DMY",locale,"en");
	
	
	String classValue = "" ;
	
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	int start = 0 ;
	int end = 0 ;
    int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
		end = 14 ;
	else
		end = Integer.parseInt( to ) ;

     sql.append("  WHERE  facility_id = '"+facilityId +"' and speciality_code='"+speciality+"' and clinic_code=nvl('"+clinic_code+"',clinic_code) and   CARE_LOCN_TYPE_IND=nvl('"+locntype+"',CARE_LOCN_TYPE_IND) and RESOURCE_CLASS=nvl('"+resource_class+"',RESOURCE_CLASS) AND nvl(practitioner_id,'X') =nvl('"+practitioner_id+"',nvl(practitioner_id,'X')) and (SELECT day_no FROM sm_day_of_week WHERE RTRIM (day_of_week) = RTRIM (TO_CHAR (oa_clinic_schedule.clinic_date, 'DAY')                     ))=nvl('"+clinic_day_no+"',(SELECT day_no FROM sm_day_of_week WHERE RTRIM (day_of_week) = RTRIM (TO_CHAR (oa_clinic_schedule.clinic_date, 'DAY')))) and ");

     sql = sql.append("clinic_date between to_date(nvl('"+from_date+"','01/01/1800'),'dd/mm/yyyy') and to_date(nvl('"+to_date+"','31/12/5000'),'dd/mm/yyyy') and schedule_status = 'B'  ");

     sql1.append("where facility_id = '"+facilityId +"' and clinic_code=nvl('"+clinic_code+"',clinic_code) and CARE_LOCN_TYPE_IND=nvl('"+locntype+"',CARE_LOCN_TYPE_IND) and RESOURCE_CLASS=nvl('"+resource_class+"',RESOURCE_CLASS)      and nvl(practitioner_id,'X') = nvl('"+practitioner_id+"',nvl(practitioner_id,'X')) and trim(upper( TO_CHAR (block_date, 'DAY')))=nvl((select trim(upper(day_of_week)) from sm_day_of_week where day_no ='"+clinic_day_no+"'),trim(TO_CHAR (block_date, 'DAY')))       and ");

     sql1.append(" block_date between to_date(nvl('"+from_date+"','01/01/1800'),'dd/mm/yyyy') and to_date(nvl('"+to_date+"','31/12/5000'),'dd/mm/yyyy') ");



	stmt = con.createStatement();
	int maxRecord = 0;
   
     StringBuffer Strsql = new StringBuffer("");
	 Strsql.append("select AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')  SPECIALITY_DESC,CARE_LOCN_TYPE_IND,AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,'"+locale+"','1')CARE_LOCN_TYPE_DESC,RESOURCE_CLASS, to_char(clinic_date,'dd/mm/rrrr') clinic_date,TO_CHAR (clinic_date, 'DAY') clinic_day, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R',  AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E',  AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_full_name,   to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi') end_time,    nvl(total_first_visit,0) total_first_visit, nvl(total_follow_up,0) total_follow_up,    nvl(total_routine,0) total_routine, nvl(total_series,0) total_series, nvl(total_consult,0)    total_consult, nvl(total_emergency,0) total_emergency, nvl(total_slots_overbooked,0)    total_slots_overbooked, (NVL (max_patients_per_day, 0) - NVL (decode(SCHEDULE_STATUS,'B',max_patients_per_day,total_slots_booked), 0)) available,    AM_GET_DESC.AM_CONTACT_REASON(REASON_CODE,'"+locale+"','1') CONTACT_REASON,REMARKS remarks from oa_clinic_schedule"); //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	 Strsql.append(sql);
     Strsql.append("union select (select AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2') from op_clinic where facility_id = oa_block_appt.facility_id and clinic_code = oa_block_appt.clinic_code) SPECIALITY_DESC,CARE_LOCN_TYPE_IND,AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,'"+locale+"','1')CARE_LOCN_TYPE_DESC,RESOURCE_CLASS, to_char(block_date,'dd/mm/rrrr') clinic_date, TO_CHAR (block_date, 'DAY') block_day, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1')  clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'),  'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E',   AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_full_name,    to_char(effective_from_date_time,'hh24:mi') start_time,     to_char(effective_to_date_time,'hh24:mi') end_time, 0 total_first_visit, 0 total_follow_up,     0 total_routine, 0 total_series, 0 total_consult, 0 total_emergency,     0 total_slots_overbooked, 0 available,     AM_GET_DESC.AM_CONTACT_REASON(REASON_FOR_BLOCK,'"+locale+"','1') CONTACT_REASON,REMARKS_FOR_BLOCK remarks from oa_block_appt  "); //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	 Strsql.append(sql1);

	 rs = stmt.executeQuery(Strsql.toString());  
	 //out.println("Query ==>"+Strsql.toString());
	
					
				if ( start != 1 )
				 for( int j=1; j<start; i++,j++ ){
				  rs.next() ;

				}
				if (rs != null) {
				while ( i<=end && rs.next()){
					if(maxRecord==0)
					{
			%>
			<P>
			<table align='right' >
			<tr>
			<%

			if ( !(start <= 1) ) { %>
                  <!--modified by N Munisekhar against JD-CRF-0185 [IN041355]-->
				<td align ='right' id='prev'><A HREF='../../eOA/jsp/QueryBlockApptResult.jsp?clinic_code=<%=clinic_code%>&locn_type=<%=locntype%>&resource_class=<%=resource_class%>&speciality=<%=speciality%>&practitioner_id=<%=practitioner_id%>&clinic_day_no=<%=clinic_day_no%>&from_date=<%=from_date%>&to_date=<%=to_date%>&facilityId=<%=facilityId%>&from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>
				<% }

			//if ( !( (start+14) > maxRecord ) )
				{ %>
                  <!--modified by N Munisekhar against JD-CRF-0185 [IN041355]-->
				<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/QueryBlockApptResult.jsp?clinic_code=<%=clinic_code%>&locn_type=<%=locntype%>&speciality=<%=speciality%>&resource_class=<%=resource_class%>&practitioner_id=<%=practitioner_id%>&clinic_day_no=<%=clinic_day_no%>&from_date=<%=from_date%>&to_date=<%=to_date%>&facilityId=<%=facilityId%>&from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
				<% }

			sql.setLength(0);
			sql1.setLength(0);
			
			Strsql.setLength(0);

			%>
			</tr>
			</table><br>
			</P>
			<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
			<div>
			<table cellspacing='0' cellpadding='0' border='1' frame='box'>
			<thead>
			<tr>
			<td width='12%' class='COLUMNHEADER' nowrap rowspan='2'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
			<td width='10%' class='COLUMNHEADER' nowrap ><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
			<td width='10%' class='COLUMNHEADER' nowrap ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td width='10%' class='COLUMNHEADER' nowrap ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td width='10%' class='COLUMNHEADER' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td width='10%' class='COLUMNHEADER' nowrap ><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
			<td width='15%' class='COLUMNHEADER' nowrap ><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></td>
			<td width='7%' class='COLUMNHEADER'  nowrap ><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
			<td width='7%' class='COLUMNHEADER'  nowrap ><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
			<td width='7%' class='COLUMNHEADER'  nowrap ><fmt:message key="eOA.ReasonForBlock.label" bundle="${oa_labels}"/></td>
			<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
			<%if(isRemarksFieldAppl){%>
			<td width='10%' class='COLUMNHEADER'  nowrap ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<%}%>
			</tr>

			<tbody>

			<%  }
			 
		
					if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
					else
					classValue = "QRYODD" ;


					String resource_code=rs.getString("RESOURCE_CLASS");
					String res_class_desc="";
			if(resource_code.equals("P"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(resource_code.equals("E"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(resource_code.equals("R"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(resource_code.equals("O"))
			{
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}


			String clinic_date= rs.getString("clinic_date");
			String clinic_date_disp=DateUtils.convertDate(clinic_date,"DMY","en",locale);

			String clinic_day=rs.getString("clinic_day");
			clinic_day=clinic_day.trim();
			String clinic_day_desc="";
			//String speciality_desc="";
			String locn_type_desc="";

			if(clinic_day.equals("MONDAY"))
				{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
					}else if(clinic_day.equals("TUESDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
					}else if(clinic_day.equals("WEDNESDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
					}else if(clinic_day.equals("THURSDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
					}else if(clinic_day.equals("FRIDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
					}else if(clinic_day.equals("SATURDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
					}else  if(clinic_day.equals("SUNDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
					}


					%><tr><td align='left' class='<%=classValue%>'nowrap><%
					out.println(clinic_date_disp);

					%></td><td align='left' class='<%=classValue%>'nowrap><%
					out.println(clinic_day_desc);

					%></td><td align='left' class='<%=classValue%>'nowrap><%
					
					if(rs.getString("CARE_LOCN_TYPE_DESC") == null && locntype.equals("D")) //modified by Shanmukh against ML-MMOH-SCF-0951
					{
					locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
					out.println(locn_type_desc);
					}else{
					out.println(rs.getString("CARE_LOCN_TYPE_DESC"));
					}

					%></td><td align='left' class='<%=classValue%>'nowrap><%
					out.println(rs.getString("clinic_name"));
					
					%></td><td align='left' class='<%=classValue%>'nowrap><%
						if(rs.getString("speciality_desc")==null) {%>
						&nbsp;
					<%}else{
					out.println(rs.getString("speciality_desc"));
					}
					%></td><td align='left' class='<%=classValue%>'nowrap><%
					out.println(res_class_desc);


					%></td><td align='left' class='<%=classValue%>' nowrap><%
					if(rs.getString("practitioner_full_name") == null)
					out.println("");
					else
					out.println(rs.getString("practitioner_full_name"));

					%></td><td align='left' class='<%=classValue%>'nowrap><%
					out.println(rs.getString("start_time"));

					%></td><td align='left' class='<%=classValue%>'nowrap><%
					out.println(rs.getString("end_time"));

					%></td><td align='left' class='<%=classValue%>' nowrap><%
						if(rs.getString("contact_reason")==null){%>
						&nbsp;
					<%}else{
					out.println(rs.getString("contact_reason"));
					}
					
					if(isRemarksFieldAppl){
					//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
					%></td><td align='left' class='<%=classValue%>'nowrap><%
						if(rs.getString("remarks")==null){%>
						&nbsp;
					<%}else{
					out.println(rs.getString("remarks"));
					}
					}

					%>&nbsp;</td></tr><%

					i++;
					maxRecord++;
				}// while

			}

	
	if(maxRecord == 0)
	{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
	<%}

	if ( maxRecord < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% 
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}

		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (stmt1 != null) stmt1.close();

	} catch(Exception e) {
		 out.println(e.toString());
		 
	}finally {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

%>
   </table>
 </div>
 <script>
 parent.frames[1].document.forms[0].select.disabled=false;
 </script>
</body>
</html>

