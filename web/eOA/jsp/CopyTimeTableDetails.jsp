<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.*, eCommon.XSSRequestWrapper " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%

String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eOA/js/CopyTimeTable.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest();" onKeyDown ='lockKey()'>

<form name='TimeTableDetails' id='TimeTableDetails' action="../../servlet/eOA.TimeTableServlet" method="post" target=messageFrame>

 <%
		Connection con = null;
		Statement newstmt	= null;
		ResultSet rset	= null ;
		PreparedStatement pstmt=null;
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		String locale			= (String)session.getAttribute("LOCALE");
		String facility = (String) session.getAttribute( "facility_id" ) ;	
		String pract_id	=(request.getParameter("pract_id")==null)?"":request.getParameter("pract_id");
		String time_table_type	=(request.getParameter("time_table_type")==null)?"":request.getParameter("time_table_type") ;
		String day_no	=(request.getParameter("day_no")==null)?"":request.getParameter("day_no");
		String clinic_code	=(request.getParameter("clinic_code")==null)?"":request.getParameter("clinic_code");
		String resource_class	=(request.getParameter("resource_class")==null)?"":request.getParameter("resource_class");		
		String sql				= "" ;
		String classValue		="";	
		String start_time = "";
try
	{
		con = ConnectionManager.getConnection(request);
		// sql="select clinic_code,clinic_name,CARE_LOCN_TYPE_IND,CARE_LOCN_TYPE_DESC,resource_class,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,day_no,initCap(day_of_week) day_of_week,practitioner_id,nvl(practitioner_full_name,'')practitioner_name,time_table_type, to_char(start_time,'hh24:mi')start_time,to_char(end_time,'hh24:mi')end_time,nvl(to_char(time_per_patient,'hh24:mi'),'') time_per_patient, nvl(max_patients_per_day,'')max_patients_per_day,nvl(to_char(time_per_slab,'hh24:mi'),'')time_per_slab,nvl(max_patients_per_slab,'')max_patients_per_slab, nvl(max_first_visits,'')max_first_visits,nvl(max_over_booking,'')max_over_booking,nvl(max_slots_for_first_visit,'')max_slots_for_first_visit, NVL(phys_roster_reqd_yn,'N')phys_roster_reqd_yn,nvl(remarks,'')remarks,max_slots_per_day,max_other_visits,RESOURCE_CLASS,NO_OF_GLOBAL_APPT_FOR_REF,NO_OF_FORCED_IN_APPT,ALLOW_FORCED_IN_APPT_YN,MAX_NEW_PATIENTS, MAX_OLD_PATIENTS,ALCN_CRITERIA,VISIT_LIMIT_RULE,VISIT_LIMIT_RULE,(select VISIT_LIMIT_RULE from oa_param where module_id = 'OA') visitLimtRuleParam from oa_clinic_time_table_vw where facility_id ='"+facility+"' and clinic_code = '"+clinic_code+"'  and day_no='"+day_no+"' and time_table_type='"+time_table_type+"' and practitioner_id='"+pract_id+"' ";		
		 sql="select clinic_code,clinic_name,CARE_LOCN_TYPE_IND,CARE_LOCN_TYPE_DESC,resource_class,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,day_no,initCap(day_of_week) day_of_week, practitioner_id, nvl(practitioner_full_name,'')practitioner_name, time_table_type, to_char(start_time,'hh24:mi')start_time,to_char(end_time,'hh24:mi')end_time,nvl(to_char(time_per_patient,'hh24:mi'),'') time_per_patient, nvl(max_patients_per_day,'')max_patients_per_day, nvl(to_char(time_per_slab,'hh24:mi'),'')time_per_slab, nvl(max_patients_per_slab,'')max_patients_per_slab, nvl(max_first_visits,'')max_first_visits, nvl(max_over_booking,'')max_over_booking, nvl(max_slots_for_first_visit,'')max_slots_for_first_visit, NVL(phys_roster_reqd_yn,'N')phys_roster_reqd_yn, nvl(remarks,'')remarks, max_slots_per_day, max_other_visits,RESOURCE_CLASS,NO_OF_GLOBAL_APPT_FOR_REF,NO_OF_FORCED_IN_APPT,ALLOW_FORCED_IN_APPT_YN,MAX_NEW_PATIENTS, MAX_OLD_PATIENTS, ALCN_CRITERIA,VISIT_LIMIT_RULE,VISIT_LIMIT_RULE,(select VISIT_LIMIT_RULE from oa_param where module_id = 'OA') visitLimtRuleParam from oa_clinic_time_table_vw where facility_id =? and clinic_code = ?  and day_no=? and time_table_type=? and practitioner_id=? ";		
		newstmt=con.createStatement();
		//rset=newstmt.executeQuery(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,facility);
		pstmt.setString(2,clinic_code);
		pstmt.setString(3,day_no);
		pstmt.setString(4,time_table_type);
		pstmt.setString(5,pract_id);
		rset = pstmt.executeQuery();
		%>
	
		<table border="0" cellspacing='0' cellpadding='0' width='100%'  >
		<tr>		
		<td  width='50px'  class="COLUMNHEADER"><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
		<td  width='50px'  class="COLUMNHEADER"><fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>		
		<td  width='80px'  class="COLUMNHEADER"><fmt:message key="eOA.maxpatperday.label" bundle="${oa_labels}"/></td>
		<td  width='75px'  class="COLUMNHEADER"><fmt:message key="eOA.TimeperSlot.label" bundle="${oa_labels}"/></td>
		<td  width='75px'  class="COLUMNHEADER"><fmt:message key="eOA.timeperslab.label" bundle="${oa_labels}"/></td>
		<td  width='80px'  class="COLUMNHEADER"><fmt:message key="eOA.maxpatperslab.label" bundle="${oa_labels}"/></td>
		<td  width='75px'  class="COLUMNHEADER"><fmt:message key="eOA.maxfirstvisits.label" bundle="${oa_labels}"/></td>
		<td  width='75px'  class="COLUMNHEADER"><fmt:message key="eOA.MaxOtherVisits.label" bundle="${oa_labels}"/></td>
		<td  width='90px'  class="COLUMNHEADER"><fmt:message key="eOA.maxob.label" bundle="${oa_labels}"/></td>		
		<td  width='90px'  class="COLUMNHEADER"><fmt:message key="eOA.NoOfForcedAppointment.label" bundle="${oa_labels}"/></td>
		<td  width='90px'  class="COLUMNHEADER"><fmt:message key="eOA.noofglobalbookingperday.label" bundle="${oa_labels}"/></td>
		<td  width='90px'  class="COLUMNHEADER"><fmt:message key="eOA.RosterRequired.label" bundle="${oa_labels}"/></td>
		</tr>		
	</table>
		</div>
		
<table border='0' cellspacing='0' cellpadding='0' width='100%'   >
<%
		String olStr="";
		//String breakTimeSql="SELECT to_char(BREAK_START_TIME,'hh24:mi')BREAK_START_TIME,to_char(BREAK_END_TIME,'hh24:mi')BREAK_END_TIME FROM OA_CLINIC_BREAK WHERE clinic_code = '"+clinic_code+"' AND day_no = '"+day_no+"' AND practitioner_id = '"+pract_id+"' AND facility_id = '"+facility+"'";
		String breakTimeSql="SELECT to_char(BREAK_START_TIME,'hh24:mi')BREAK_START_TIME,to_char(BREAK_END_TIME,'hh24:mi')BREAK_END_TIME FROM OA_CLINIC_BREAK WHERE clinic_code = ? AND day_no = ? AND practitioner_id = ? AND facility_id = ?";
		

		Statement stmt=con.createStatement();
		String breakTimes[]=new String[5];
		int breaktimeIndex=0;
	
		//ResultSet rsetBr=stmt.executeQuery(breakTimeSql);
		ResultSet rsetBr=null;
		pstmt = con.prepareStatement(breakTimeSql);
		pstmt.setString(1,clinic_code);
		pstmt.setString(2,day_no);
		pstmt.setString(3,pract_id);
		pstmt.setString(4,facility);
		rsetBr = pstmt.executeQuery();
		while (rsetBr.next()){
			
			if(rsetBr.getString("break_start_time") != null && !rsetBr.getString("break_start_time").equals("null")){
				breakTimes[breaktimeIndex]=rsetBr.getString("break_start_time")+" - "+rsetBr.getString("break_end_time");
			}
			olStr=olStr + rsetBr.getString("break_start_time")+rsetBr.getString("break_end_time")+",";
			breaktimeIndex++;
			
		}
	
		int i = 1;
		int counter = 0;
		while(rset.next()) 
		{		 
		counter++ ;
		if ( counter % 2 == 0 )
		  	classValue = "QRYODD" ;
		else
		  	classValue = "QRYEVEN" ;		
		%>
		<tr>
			
			<td width='50px' align='left' nowrap class='<%=classValue%>'><font size='1'><%=(rset.getString("start_time")==null)?"&nbsp;":rset.getString("start_time")%></td>
			<td  width='50px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("end_time")==null)?"&nbsp;":rset.getString("end_time")%></td>
			<td  width='80px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("max_patients_per_day")==null)?"&nbsp;":rset.getString("max_patients_per_day")%></td>
			<td  width='75px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("time_per_patient")==null)?"&nbsp;":rset.getString("time_per_patient")%></td>
			<td  width='75px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("time_per_slab")==null)?"&nbsp;":rset.getString("time_per_slab")%></td>
			<td  width='80px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("max_patients_per_slab")==null)?"&nbsp;":rset.getString("max_patients_per_slab")%></td>
			<td  width='75px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("max_first_visits")==null)?"&nbsp;":rset.getString("max_first_visits")%></td>
			<td  width='75px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("max_other_visits")==null)?"&nbsp;":rset.getString("max_other_visits")%></td>
			<td  width='90px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("max_over_booking")==null)?"&nbsp;":rset.getString("max_over_booking")%></td>			
			<td  width='90px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("no_of_forced_in_appt")==null)?"&nbsp;":rset.getString("no_of_forced_in_appt")%></td>
			<td  width='90px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("no_of_global_appt_for_ref")==null)?"&nbsp;":rset.getString("no_of_global_appt_for_ref")%></td>
			<td  width='90px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(rset.getString("PHYS_ROSTER_REQD_YN")==null)?"&nbsp;":rset.getString("PHYS_ROSTER_REQD_YN")%></td>
			
			  <input type='hidden' name='final_alcn_criteria' id='final_alcn_criteria' value=''>  
			  <input type='hidden' name='time_table_type' id='time_table_type' value='<%=rset.getString("time_table_type")==null?"":rset.getString("time_table_type")%>'>  
			  <input type='hidden' name='remarks' id='remarks' value='<%=rset.getString("remarks")==null?"":rset.getString("remarks")%>'>  
			  <input type='hidden' name='start_time' id='start_time' value='<%=rset.getString("start_time")==null?"":rset.getString("start_time")%>'>  
			  <input type='hidden' name='end_time' id='end_time' value='<%=rset.getString("end_time")==null?"":rset.getString("end_time")%>'>
			  <input type='hidden' name='time_per_patient' id='time_per_patient' value='<%=rset.getString("time_per_patient")==null?"":rset.getString("time_per_patient")%>'>  
			  <input type='hidden' name='max_patients_per_day' id='max_patients_per_day' value='<%=rset.getString("max_patients_per_day")==null?"":rset.getString("max_patients_per_day")%>'>  
			  <input type='hidden' name='time_per_slab' id='time_per_slab' value='<%=rset.getString("time_per_slab")==null?"":rset.getString("time_per_slab")%>'>  
			  <input type='hidden' name='max_patients_per_slab' id='max_patients_per_slab' value='<%=rset.getString("max_patients_per_slab")==null?"":rset.getString("max_patients_per_slab")%>'>  
			  <input type='hidden' name='max_first_visit' id='max_first_visit' value='<%=rset.getString("max_first_visits")==null?"":rset.getString("max_first_visits")%>'>  
			  <input type='hidden' name='max_over_bookings' id='max_over_bookings' value='<%=rset.getString("max_over_booking")==null?"":rset.getString("max_over_booking")%>'>  
			  <input type='hidden' name='phys_roster_reqd_yn' id='phys_roster_reqd_yn' value='<%=rset.getString("phys_roster_reqd_yn")==null?"":rset.getString("phys_roster_reqd_yn")%>'>  
			  <input type='hidden' name='b_max_slots_for_first_visit' id='b_max_slots_for_first_visit' value='<%=rset.getString("max_slots_for_first_visit")==null?"":rset.getString("max_slots_for_first_visit")%>'>  
			  <input type='hidden' name='l_max_pat_per_slot' id='l_max_pat_per_slot' value='<%=rset.getString("max_slots_per_day")==null?"":rset.getString("max_slots_per_day")%>'>  
			  <input type='hidden' name='max_other_visits' id='max_other_visits' value='<%=rset.getString("max_other_visits")==null?"":rset.getString("max_other_visits")%>'>  
			  <input type='hidden' name='max_new_patients' id='max_new_patients' value='<%=rset.getString("max_new_patients")==null?"0":rset.getString("max_new_patients")%>'>  
			  <input type='hidden' name='max_old_patients' id='max_old_patients' value='<%=rset.getString("max_old_patients")==null?"0":rset.getString("max_old_patients")%>'>  
			  <input type='hidden' name='no_of_forced_booking' id='no_of_forced_booking' value='<%=rset.getString("no_of_forced_in_appt")==null?"":rset.getString("no_of_forced_in_appt")%>'>  			
			  <input type='hidden' name='ftotstr' id='ftotstr' value='<%=olStr%>'>  <!--BREAK TIME INTERVALS -->		
			  <input type='hidden' name='final_string' id='final_string' value=''>  
			  <input type='hidden' name='alcn_criteria' id='alcn_criteria' value=''>  		
			  <input type='hidden' name='forced_book_YN' id='forced_book_YN' value='<%=rset.getString("allow_forced_in_appt_yn")%>'> 			
			  <input type='hidden' name='no_of_global_booking' id='no_of_global_booking' value='<%=rset.getString("no_of_global_appt_for_ref")==null?"":rset.getString("no_of_global_appt_for_ref")%>'>  		
			  <input type='hidden' name='location_type' id='location_type' value='<%=rset.getString("CARE_LOCN_TYPE_IND")%>'>  
			  <input type='hidden' name='visit_limit_rule' id='visit_limit_rule' value='<%=rset.getString("VISIT_LIMIT_RULE")==null?"":rset.getString("VISIT_LIMIT_RULE")%>'>  
			  <input type='hidden' name='visitLimtRuleParam' id='visitLimtRuleParam' value='<%=rset.getString("visitLimtRuleParam")==null?"":rset.getString("visitLimtRuleParam")%>'>  
			  <input type='hidden' name='fmode' id='fmode' value='COPY'>  
			  <input type='hidden' name='day_no_modify' id='day_no_modify' value='<%=day_no%>'>  
			  <input type='hidden' name='b_day' id='b_day' value=''>
			  <input type='hidden' name='finalPractList' id='finalPractList' value=''>
			  <input type='hidden' name='clinic_code' id='clinic_code' value='<%=clinic_code%>'>
			  <input type='hidden' name='resourceType' id='resourceType' value='<%=resource_class%>'>
			  <input type='hidden' name='location_type' id='location_type' value='<%=resource_class%>'>
			
				<%}%>
			</tr><%
					
					if(olStr !=null && !olStr.equals("null") && !olStr.equals("")){

					%><tr></table><br>
					 <div  style="margin-left:15px;margin-right:0px"> 
					<table border='0' cellpadding='0' cellspacing='0' align='center' width='615px'>
	<tr><th  colspan='5' nowrap class="columnheader"><fmt:message key="eOA.BreakTime.label" bundle="${oa_labels}"/></td>
	</tr>
	<tr><%
		for(breaktimeIndex=0;breaktimeIndex<breakTimes.length;breaktimeIndex++){
						
		%>
		<td  width='120px' align='left' nowrap class='<%=classValue%>' ><font size=1> <%=(breakTimes[breaktimeIndex]==null)?"&nbsp;":breakTimes[breaktimeIndex]%></td>
		<%
	}
				}
  	i++;	  
	%>
		
	</tr>
	</table>
	</div>
 <%}catch(Exception e){%>
		 <% //out.println("Exception while fetching connection :" + e) ;
	e.printStackTrace();%>
 <%}finally{
		try{
	if(rset!=null)
	rset.close();
	if(newstmt!=null)
	newstmt.close();
		}catch(Exception e){}
	 if( con != null) ConnectionManager.returnConnection(con, request);%>
 <%}%>
 </form>
 </body>
 </html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : 
inputString);
	}
%>

