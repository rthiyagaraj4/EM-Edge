<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>
<HTML>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
  Connection con = null;	
  Statement stmt = null;
  ResultSet rs = null;
  Statement stmt1 = null;
 
  StringBuffer sql = new StringBuffer("");

try {
con = ConnectionManager.getConnection(request);	
	stmt1 = con.createStatement();
	stmt = con.createStatement();

	 String locale = (String)session.getAttribute("LOCALE");
     String care_locn = request.getParameter("care_locn");
	 String clinic_code = request.getParameter("clinic_code");
	 String resource_type = request.getParameter("resource_type");
     String practitioner_id = request.getParameter("practitioner_id");
     String clinic_day_no = request.getParameter("clinic_day_no");
     String from_date = request.getParameter("from_date");
     String to_date = request.getParameter("to_date");
     String facilityId = request.getParameter("facilityId");
     String speciality = request.getParameter("speciality");
     String slot_appt_ctrl = "";
	 String classValue = "" ;

	 from_date=DateUtils.convertDate(from_date,"DMY",locale,"en");
	to_date=DateUtils.convertDate(to_date,"DMY",locale,"en");
	
	
	if(care_locn == null || care_locn.equals("null")) care_locn = "";
	if(clinic_code == null || clinic_code.equals("null")) clinic_code = "";
	if(resource_type == null || resource_type.equals("null")) resource_type = "";
	if(practitioner_id == null || practitioner_id.equals("null")) practitioner_id = "";
	if(clinic_day_no == null || clinic_day_no.equals("null")) clinic_day_no = "";
	if(from_date == null || from_date.equals("null")) from_date = "";
	if(to_date == null || to_date.equals("null")) to_date = "";
	if(facilityId == null || facilityId.equals("null")) facilityId = "";
	if(speciality == null || speciality.equals("null")) speciality = "";

	
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
/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
    sql.append(" where facility_id ='"+facilityId+"' and clinic_code=nvl('"+clinic_code+"',clinic_code)  and nvl(practitioner_id,'X') = nvl('"+practitioner_id+"',nvl(practitioner_id,'X')) and (SELECT day_no FROM sm_day_of_week WHERE RTRIM (day_of_week) = RTRIM (TO_CHAR (oa_clinic_schedule_vw.clinic_date, 'DAY')))=NVL('"+clinic_day_no+"',(SELECT day_no FROM sm_day_of_week WHERE RTRIM (day_of_week) = RTRIM (TO_CHAR (oa_clinic_schedule_vw.clinic_date, 'DAY')))) and  CARE_LOCN_TYPE_IND=nvl('"+care_locn+"',CARE_LOCN_TYPE_IND) and RESOURCE_CLASS=nvl('"+resource_type+"',RESOURCE_CLASS) and ");

if(!speciality.equals(""))
	{
	   sql.append(" SPECIALITY_CODE=nvl('"+speciality+"',SPECIALITY_CODE) and ");
	}
if(!from_date.equals("") || !to_date.equals(""))
	{
    sql.append(" clinic_date between to_date(nvl('"+from_date+"','01/01/1800'),'dd/mm/yyyy') and to_date(nvl('"+to_date+"','31/12/5000'),'dd/mm/yyyy') and nvl(schedule_status,'X') != nvl('B','X') ");
	}else
	{
		sql.append(" clinic_date >=sysdate and nvl(schedule_status,'X') != nvl('B','X') ");	
	}


	rs = stmt.executeQuery("select slot_appt_ctrl from oa_param");

    if(rs.next())
	{
	   slot_appt_ctrl   = rs.getString("slot_appt_ctrl");
	}
if(rs !=null) rs.close();
	int maxRecord = 0;

		
	    sql.append("  AND (eff_status != 'D' OR eff_status IS NULL) order by to_date(clinic_date,'dd/mm/yyyy'),3,4");
	
		

		if (rs!=null) rs.close();
		/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
String sql1="Select clinic_code, CARE_LOCN_TYPE_IND, RESOURCE_CLASS ,  time_table_type,practitioner_id, time_table_type, to_char(clinic_date,'dd/mm/yyyy') clinic_date, TO_CHAR (oa_clinic_schedule_vw.clinic_date, 'DAY') clinic_day, OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, PRIMARY_RESOURCE_YN,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_full_name, to_char(start_time,'hh24:mi') start_time, to_char(end_time,'hh24:mi') end_time, nvl(total_first_visit,0) total_first_visit, nvl(total_follow_up,0) total_follow_up, nvl(total_routine,0) total_routine, nvl(total_series,0) total_series,nvl(total_consult,0) total_consult, nvl(total_emergency,0) total_emergency, nvl(total_slots_overbooked,0) total_slots_overbooked,  nvl(max_patients_per_day,0) max_patients_per_day,nvl(total_slots_booked,0) total_slots_booked, alcn_criteria,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,'"+locale+"','2')  SPECIALITY_DESC from oa_clinic_schedule_vw "+sql.toString();

	rs = stmt1.executeQuery(sql1);

		
			if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
			  rs.next() ;
			}
			if (rs != null)	{

				
				while ( i<=end && rs.next()){
					if(maxRecord==0)
					{
		%>
		<P>
		<table align='right'>
		<tr>
		<%

		if ( !(start <= 1) ) { %>
			<td align ='right' id='prev'><A HREF='../../eOA/jsp/QueryLocnScheduleResult.jsp?clinic_code=<%=clinic_code%>&practitioner_id=<%=practitioner_id%>&care_locn=<%=care_locn%>&resource_type=<%=resource_type%>&clinic_day_no=<%=clinic_day_no%>&from_date=<%=from_date%>&to_date=<%=to_date%>&facilityId=<%=facilityId%>&from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A></td>
			<% }
		//if ( !( (start+14) > maxRecord ) )
			{ %>
			<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/QueryLocnScheduleResult.jsp?clinic_code=<%=clinic_code%>&care_locn=<%=care_locn%>&resource_type=<%=resource_type%>&practitioner_id=<%=practitioner_id%>&clinic_day_no=<%=clinic_day_no%>&from_date=<%=from_date%>&to_date=<%=to_date%>&facilityId=<%=facilityId%>&from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
			<% }
		%>
			<%sql.setLength(0);%>
		</tr>
		</table><br>
		</P>
		<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
	 <div>
	   
		<table cellspacing='0' cellpadding='0' border='1' width='100%'>
		<tr>
		<td width='12%' class='COLUMNHEADER' rowspan='2' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td width='10%' class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
		<td width='12%' class='COLUMNHEADER' rowspan='2' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td width='10%' class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td width='10%' class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td width='12%' class='COLUMNHEADER' rowspan='2' nowrap ><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></td>
		<td width='15%' class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
		<td width='15%' class='COLUMNHEADER' rowspan='2'><fmt:message key="eOA.PrimaryResource.label" bundle="${oa_labels}"/></td>
		<td width='7%' class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
		<td width='7%' class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' colspan='7'><fmt:message key="Common.booked.label" bundle="${common_labels}"/></td>
		<td width='10%' class='COLUMNHEADER' rowspan='2'><fmt:message key="Common.available.label" bundle="${common_labels}"/></td>
		   </tr>
		   <tr>
			<th width='5%' align='center' ><fmt:message key="eOA.FI.label" bundle="${oa_labels}"/></th>
			<th width='5%' align='center' ><fmt:message key="eOA.FU.label" bundle="${oa_labels}"/></th>
			<th width='5%' align='center' ><fmt:message key="Common.RT.label" bundle="${common_labels}"/></th>
			<th width='5%' align='center' ><fmt:message key="eOA.SR.label" bundle="${oa_labels}"/></th>
			<th width='5%' align='center' ><fmt:message key="eOA.CS.label" bundle="${oa_labels}"/></th>
			<th width='5%' align='center' ><fmt:message key="eMP.EM.label" bundle="${mp_labels}"/></th>
			<th width='5%' align='center' ><fmt:message key="eOA.OB.label" bundle="${oa_labels}"/></th>
		   </tr>

			<% }
			
	

						if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
						else
						classValue = "QRYODD" ;

						String practname=rs.getString("practitioner_full_name");
						if(practname==null || practname.equals("null"))
						practname="&nbsp;";
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
			String primary_resource_yn =rs.getString("PRIMARY_RESOURCE_YN");
			if(primary_resource_yn ==null) primary_resource_yn="";
			
			String primary_resource_yn_desc="";
			if(primary_resource_yn.equals("Y"))
			{
				primary_resource_yn_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
			}else if(primary_resource_yn.equals("N"))
			{
				primary_resource_yn_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
			}

			
			String clinic_day_code= rs.getString("clinic_day");
			clinic_day_code=clinic_day_code.trim();
			String clinic_day_desc="";


			if(clinic_day_code.equals("MONDAY"))
				{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
					}else if(clinic_day_code.equals("TUESDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
					}else if(clinic_day_code.equals("WEDNESDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
					}else if(clinic_day_code.equals("THURSDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
					}else if(clinic_day_code.equals("FRIDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
					}else if(clinic_day_code.equals("SATURDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
					}else  if(clinic_day_code.equals("SUNDAY"))
					{
				clinic_day_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
					}

				
				String clinic_date=rs.getString("clinic_date");
				String clinic_date_disp=DateUtils.convertDate(clinic_date,"DMY","en",locale);
				
				/*Rameez for OA - IN#35850 on 23-10-2012 -Begins*/
					//Removed 'CARE_LOCN_TYPE_DESC' from the query
					String CARE_LOCN2 = rs.getString("CARE_LOCN_TYPE_IND"); 
					String CARE_LOCTYPE="";
					if(CARE_LOCN2.equals("C"))
						CARE_LOCTYPE = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
					else if(CARE_LOCN2.equals("E"))
						CARE_LOCTYPE = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
					else if(CARE_LOCN2.equals("D"))
						CARE_LOCTYPE = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
				/*Rameez for OA - IN#35850 on 23-10-2012 -Ends*/	
						%>
						<tr><td nowrap align='center' class='<%=classValue%>'>
						<%=clinic_date_disp%>
						
						</td><td nowrap  align='left' class='<%=classValue%>'>
						<%=clinic_day_desc%>
						
						</td><td nowrap  align='left' class='<%=classValue%>'>
						<!--Rameez for OA - IN#35850 on 23-10-2012 - Removed 'rs.getString("CARE_LOCN_TYPE_DESC")' and added below line-->
						<%=CARE_LOCTYPE%>
						
						</td><td nowrap  align='left' class='<%=classValue%>'>
						<%=rs.getString("clinic_name")%>
						</td><td nowrap  align='left' class='<%=classValue%>'>
						<%=rs.getString("SPECIALITY_DESC")%>
						
						</td><td nowrap  align='left' class='<%=classValue%>'>
						<%=res_class_desc%>
						
						</td><td nowrap  align='left' class='<%=classValue%>'>
						<%=practname%>

						</td><td nowrap  align='left' class='<%=classValue%>'>
						<%=primary_resource_yn_desc%>

						</td><td nowrap  align='center' class='<%=classValue%>'>
						<%=rs.getString("start_time")%>

						</td><td nowrap  align='center' class='<%=classValue%>'>
						<%=rs.getString("end_time")%>

						</td><td nowrap  align='right' class='<%=classValue%>'>
						<%=rs.getString("total_first_visit")%>&nbsp;

						</td><td nowrap  align='right' class='<%=classValue%> '>
						<%=rs.getString("total_follow_up")%>&nbsp;

						</td><td nowrap  align='right' class='<%=classValue%>'>
						<%=rs.getString("total_routine")%>&nbsp;

						</td><td nowrap  align='right' class='<%=classValue%>'>
						<%=rs.getString("total_series")%>&nbsp;

						</td><td nowrap  align='right' class='<%=classValue%>'>
						<%=rs.getString("total_consult")%>&nbsp;

						</td><td nowrap  align='right' class='<%=classValue%>'>
						<%=rs.getString("total_emergency")%>&nbsp;

						</td><td nowrap  align='right' class='<%=classValue%>'>
						<%=rs.getString("total_slots_overbooked")%>&nbsp;
						<%
					 String alcn_criteria=rs.getString("alcn_criteria");
					 String p_clinic_code=rs.getString("clinic_code");
					 String p_practitioner_id=rs.getString("practitioner_id");
					 String p_clinic_date=rs.getString("clinic_date");
					 String time_table_type=rs.getString("time_table_type");
					
					 
					%>
					</td><td nowrap  align='right' class='<%=classValue%>'>
					<%
					String available =String.valueOf(rs.getInt("max_patients_per_day")-rs.getInt("total_slots_booked"));
					
					if (rs.getString("time_table_type").equals("1")&& slot_appt_ctrl.equals("P")){
						available = 	String.valueOf(rs.getInt("max_patients_per_day")-(rs.getInt("total_first_visit")+rs.getInt("total_follow_up")+rs.getInt("total_routine")+rs.getInt("total_series")+rs.getInt("total_consult")+rs.getInt("total_emergency")));
					}

					if(alcn_criteria !=null && !(alcn_criteria.equals(""))){
						%>
						<a href="javascript:show_allocation_details('<%=alcn_criteria%>','<%=p_clinic_code%>','<%=p_practitioner_id%>','<%=p_clinic_date%>','<%=time_table_type%>')" >  


						<%=available%></a>&nbsp;
						<% 
					}else{
						%>
						<%=available%></a>&nbsp;

						<%
					}	
					%></td></tr><%

					i++;
					maxRecord++;

				}//end of while

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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%}

	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (stmt1 != null) stmt1.close();	

} catch(Exception e) {
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	//out.println(e.toString());
}finally {

	ConnectionManager.returnConnection(con,request);
}

	%>
</table>
</div>
<script>
parent.frames[1].document.forms[0].select.disabled=false;
</script>
</body>
</html>

