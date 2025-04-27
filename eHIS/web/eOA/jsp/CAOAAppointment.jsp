<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
      
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<head><title><fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/></title>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		boolean allow_inside=true;
		String facilityid=(String)(session.getValue("facility_id")==null?"":session.getValue("facility_id"));
		String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user"));

		String s=request.getQueryString();
		String from_wait_list=request.getParameter("from_wait_list");

		String order_id=request.getParameter("order_id");
		if(order_id==null) order_id="";
		String order_line_num=request.getParameter("order_line_num");
		if(order_line_num==null) order_line_num="";
		//String web_request_yn=request.getParameter("web_request_yn")==null?"N":request.getParameter("web_request_yn");
		//String patientId1=request.getParameter("patientId1")==null?"":request.getParameter("patientId1");
		String order_catalog_code=request.getParameter("order_catalog_code");
		if(order_catalog_code==null) order_catalog_code="";
		String specialty_code1= request.getParameter("specialty_code");
		if(from_wait_list==null) from_wait_list="";
		String callingMode=request.getParameter("callingMode");

		if(callingMode==null || callingMode.equals("null") )
		callingMode="";
		String from_OR=request.getParameter("from_OR");
		if(from_OR ==null) from_OR="N";
		String visit_flag_OP=request.getParameter("visit_flag_OP");
		//String option_id=request.getParameter("option_id")==null?"":request.getParameter("option_id");
		if(visit_flag_OP==null) visit_flag_OP="N";	
		String loc_type_OP= request.getParameter("loc_type");

		//Added by S.Sathish for IN021901 on Friday, June 11, 2010 starts here
		String resourceId=request.getParameter("i_practitioner_id")==null?"":request.getParameter("i_practitioner_id");
		String resourceDesc=request.getParameter("resourceDesc")==null?"":request.getParameter("resourceDesc");
		String clinicDesc=request.getParameter("clinicDesc")==null?"":request.getParameter("clinicDesc");
		String clinic_code_new=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
		String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
		String order_category=request.getParameter("order_category")==null?"":request.getParameter("order_category");
		//Ends here		
		if(order_category.equals(""))order_category="";
		String oper_stn_id="";
		String book_appt_yn="";
		String create_wait_list_yn="";
		String install_yn_val="";
		String open_to_all_pract_yn="";
		//String order_category="";
		

		if(loc_type_OP ==null) loc_type_OP="";
		try{
			con = ConnectionManager.getConnection(request);
			stmt=con.createStatement();
			//Query modified by S.Sathish for IN021901 on Friday, June 11, 2010 
			//String sql2="SELECT (   select Operational_yn from sm_modules_facility where facility_id = '"+facilityid+"' and module_id = 'OR') or_oper_yn,nvl(CREATE_WAIT_LIST_YN,'N') creat_wt_lst_yn,a.oper_stn_id, nvl(canc_appt_yn,'N') canc_appt_yn, nvl(tfr_appt_yn,'N') tfr_appt_yn, nvl(book_appt_yn,'N') book_appt_yn, to_char(sysdate,'dd/mm/yyyy') dt, (select OPEN_TO_ALL_PRACT_YN from op_clinic WHERE facility_id='"+facilityid+"' and clinic_code='"+clinic_code_new+"') open_to_all_pract_yn FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"'	AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			String sql2="SELECT (   select Operational_yn from sm_modules_facility where facility_id = ? and module_id = 'OR') or_oper_yn,nvl(CREATE_WAIT_LIST_YN,'N') creat_wt_lst_yn,a.oper_stn_id, nvl(canc_appt_yn,'N') canc_appt_yn, nvl(tfr_appt_yn,'N') tfr_appt_yn, nvl(book_appt_yn,'N') book_appt_yn, to_char(sysdate,'dd/mm/yyyy') dt, (select OPEN_TO_ALL_PRACT_YN from op_clinic WHERE facility_id=? and clinic_code=?) open_to_all_pract_yn FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
			if (rs!=null) rs.close();				
			//rs=stmt.executeQuery(sql2);
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,facilityid);
			pstmt.setString(3,clinic_code_new);
			pstmt.setString(4,facilityid);
			pstmt.setString(5,globaluser);
			rs = pstmt.executeQuery();
			if (rs!=null && rs.next()){
				oper_stn_id=rs.getString("oper_stn_id");
				book_appt_yn=rs.getString("book_appt_yn");
				create_wait_list_yn=rs.getString("creat_wt_lst_yn");
				install_yn_val=rs.getString("or_oper_yn");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"Y":rs.getString("open_to_all_pract_yn");
				

			}
			if(oper_stn_id.equals("")){
				allow_inside=false;
				%>
				<script>
					alert(getMessage("NO_OPER_STN_FOR_USER","Common"));	
					location.href='../../eCommon/jsp/home.jsp?called_from=CA';
				</script>				
				<%
			}else if(book_appt_yn.equals("N")){%>
				<script>alert(getMessage('SCH_NOT_ALLOW','OA'));
					location.href='../../eCommon/jsp/home.jsp?called_from=CA';
				</script>			
			<%}

//OPCheckout
		String from_facility_id= request.getParameter("from_facility_id");
		if(from_facility_id ==null) from_facility_id="";
		String from_encounter_id= request.getParameter("from_encounter_id");
		if(from_encounter_id ==null) from_encounter_id="";
		//session.setAttribute("calledFromSchAppt","N");

	if(allow_inside){
	if(from_wait_list.equals("Y"))
	{
	/*Row size changed(52% to 27%) by Dharma on 11th Jan 2016 against ML-MMOH-SCF-0300 [IN:057970]*/
		
	%>
		
			<iframe name='image' id='image' src='../../eOA/jsp/DisplayImage.jsp?callingMode=<%=callingMode%>&from_OR=<%=from_OR%>&oper_stn_id=<%=oper_stn_id%>&book_appt_yn=<%=book_appt_yn%>&create_wait_list_yn=<%=create_wait_list_yn%>&install_yn_val=<%=install_yn_val%>&rd_appt_yn=<%=rd_appt_yn%>'  scrolling=no noresize style="height:3vh;width:98vw;border='1'"></iframe>
			<iframe name='querying' id='querying' src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&specialty_codema=<%=specialty_code1%>&from_OR=<%=from_OR%>&visit_flag_OP=<%=visit_flag_OP%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&oper_stn_id=<%=oper_stn_id%>&book_appt_yn=<%=book_appt_yn%>&create_wait_list_yn=<%=create_wait_list_yn%>&install_yn_val=<%=install_yn_val%>&rd_appt_yn=<%=rd_appt_yn%>&order_category=<%=order_category%>&order_catalog_code=<%=order_catalog_code%>'  scrolling=no style="height:27.6vh;width:98vw;border='1'"></iframe>
			<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html'  noresize scrolling=no style='height:0vh;width:98vw'></iframe>
			<iframe name='result' id='result' src='../../eCommon/html/blank.html'  noresize scrolling=auto style="height:70vh;width:98vw;border='1'"></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html'  noresize scrolling='auto' style="height:0vh;width:98vw;border='1'"></iframe>
		

	<%

	}else{
			

			int no_record=0;
			String ref_id="N";
			String from_CA=request.getParameter("CA");
			

			if(from_CA==null || from_CA.equals("") || from_CA.equals("null") )
				from_CA="N";

			ref_id=request.getParameter("referral_id");
			if(ref_id==null || ref_id.equals("") || ref_id.equals("null") )
					ref_id="N"; 

			session.putValue("ref_id",ref_id);
			session.putValue("CallMode",callingMode);
			
			session.putValue("Pat_id","N");
			String practitioner_id = request.getParameter("practitioner_id");
			if (practitioner_id==null || practitioner_id.equals("") || practitioner_id.equals("null")) 	practitioner_id="";

			String clinic_code=request.getParameter("clinic_code");
			String recall_date=request.getParameter("recall_date");
			if (recall_date==null ) recall_date="";
			
			if(recall_date.length()==9) 
				recall_date="0"+recall_date;

			if(recall_date.length()>10) 
				recall_date=recall_date.substring(0,10);



			String direct_ip=request.getParameter("DirectIP");
			if(direct_ip==null) direct_ip="N";

		try
		{
				
			if(direct_ip.equals("N"))
			{

				if(! ref_id.equals("N"))
				{  // Referral 
					clinic_code_new=open_to_all_pract_yn+"$"+clinic_code_new;	

				%>
				<!--	<frameset id=appt_page rows='3%,27%,0%,*,0' border='1'>
						<frame name='image' src='../../eOA/jsp/DisplayImage.jsp?callingMode=<%=callingMode%>&from_OR=<%=from_OR%>&rd_appt_yn=<%=rd_appt_yn%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize>
						<frame name='querying'src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&specialty_codema=<%=specialty_code1%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&visit_flag_OP=<%=visit_flag_OP%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&locn_code=<%=clinic_code_new%>&locnDesc=<%=clinicDesc%>&resourceId=<%=resourceId%>&resourceDesc=<%=resourceDesc%>&install_yn_val=<%=install_yn_val%>&order_category=<%=order_category%>'frameborder=no scrolling=no noresize>
						<frame name='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no>
						<frame name='result' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto>
						<frame name='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'>
					</frameset> -->
						<iframe name='image' id='image' src='../../eOA/jsp/DisplayImage.jsp?callingMode=<%=callingMode%>&from_OR=<%=from_OR%>&rd_appt_yn=<%=rd_appt_yn%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize style="height:3vh;width:98vw;border:'1'"></iframe>
						<iframe name='querying' id='querying' src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&specialty_codema=<%=specialty_code1%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&visit_flag_OP=<%=visit_flag_OP%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&locn_code=<%=clinic_code_new%>&locnDesc=<%=clinicDesc%>&resourceId=<%=resourceId%>&resourceDesc=<%=resourceDesc%>&install_yn_val=<%=install_yn_val%>&order_category=<%=order_category%>'frameborder=no scrolling=no noresize style="height:30vh;width:98vw;border:'1'"></iframe>
						<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no style="height:0vh;width:98vw;border:'1'"></iframe>
						<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto style="height:70vh;width:98vw;border:'1'"></iframe>
						<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder='0' noresize scrolling='auto' style="height:0vh;width:98vw;border:'1'"></iframe>

				<%}else{ // Recall or CA
				if(from_CA.equals("N") ){ // RECALL

					String pat_id=request.getParameter("patient_id");
						session.putValue("Pat_id",pat_id);
					if(practitioner_id.equals(""))
					{ // No pract ID
						if(!callingMode.equals("OR") && !callingMode.equals("MR"))
						{
							int i=s.indexOf("specialty_code");
							s=s.substring(0,i)+"cc"+s.substring(i);
						//	String speciality_code="select speciality_code from op_clinic where facility_id ='"+facilityid+"' and CLINIC_CODE='"+clinic_code+"'";
							String speciality_code="select speciality_code from op_clinic where facility_id =? and CLINIC_CODE=? ";

							//rs = stmt.executeQuery(speciality_code);
							pstmt = con.prepareStatement(speciality_code);
							pstmt.setString(1,facilityid);
							pstmt.setString(2,clinic_code);
							rs = pstmt.executeQuery();
							if(rs !=null)
							{
								while ( rs.next() )
								{
									speciality_code=rs.getString(1);	
								}
							}
								s=s+"&specialty_code="+ speciality_code;
						}
						if(rs !=null) rs.close();	

						%>
						<!-- <frameset id=appt_page rows='3%,27%,0%,*,0' border='1'>
							<frame name='image' src='../../eOA/jsp/DisplayImage.jsp?callingMode=<%=callingMode%>&from_OR=<%=from_OR%>&rd_appt_yn=<%=rd_appt_yn%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize>
							<frame name='querying' src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&specialty_codema=<%=specialty_code1%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&visit_flag_OP=<%=visit_flag_OP%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&install_yn_val=<%=install_yn_val%>&order_category=<%=order_category%>' frameborder=no scrolling=no noresize>
							<frame name='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no>
							<frame name='result' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto>
							<frame name='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'>
						</frameset> -->
							<iframe name='image' id='image' src='../../eOA/jsp/DisplayImage.jsp?callingMode=<%=callingMode%>&from_OR=<%=from_OR%>&rd_appt_yn=<%=rd_appt_yn%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize style="height:3vh;width:98vw;border:'1'"></iframe>
							<iframe name='querying' id='querying' src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&specialty_codema=<%=specialty_code1%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&visit_flag_OP=<%=visit_flag_OP%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&install_yn_val=<%=install_yn_val%>&order_category=<%=order_category%>' frameborder=no scrolling=no noresize style="height:27.4vh;width:98vw;border:'1'"></iframe>
							<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no style="height:0vh;width:98vw;border:'1'"></iframe>
							<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto style="height:70vh;width:98vw;border:'1'"></iframe>
							<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder='0' noresize scrolling='auto' style="height:0vh;width:98vw;border:'1'"></iframe>

					<%}else{ // WITH pRACT id

//add this condition for speciality code in OP with pract Id

	  		if(callingMode.equals("OP"))
						{
							int i=s.indexOf("specialty_code");
							s=s.substring(0,i)+"cc"+s.substring(i);
							//String speciality_code="select speciality_code from op_clinic where facility_id ='"+facilityid+"' and CLINIC_CODE='"+clinic_code+"'";
							String speciality_code="select speciality_code from op_clinic where facility_id =? and CLINIC_CODE=?";

							//rs = stmt.executeQuery(speciality_code);
							pstmt = con.prepareStatement(speciality_code);
							pstmt.setString(1,facilityid);
							pstmt.setString(2,clinic_code);
							rs = pstmt.executeQuery();
							if(rs !=null)
							{
								while ( rs.next() )
								{
									speciality_code=rs.getString(1);	
								}
							}
								s=s+"&specialty_code="+ speciality_code;
						}


						%>
						<!-- <frameset id=appt_page rows='3%,27%,0%,*,0' border='1'>
							<frame name='image' src='../../eOA/jsp/DisplayImage.jsp?callingMode=<%=callingMode%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize>
							<frame name='querying'src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&specialty_codema=<%=specialty_code1%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&visit_flag_OP=<%=visit_flag_OP%>&order_category=<%=order_category%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize>
							<frame name='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no>
							<frame name='result' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto>
							<frame name='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'>
						</frameset> -->
							<iframe name='image' id='image' src='../../eOA/jsp/DisplayImage.jsp?callingMode=<%=callingMode%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize style="height:3vh;width:98vw;border:'1'"></iframe>
							<iframe name='querying' id='querying'src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&specialty_codema=<%=specialty_code1%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&visit_flag_OP=<%=visit_flag_OP%>&order_category=<%=order_category%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize style="height:29vh;width:98vw;border:'1'"></iframe>
							<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no style="height:0vh;width:98vw;border:'1'"></iframe>
							<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto style="height:64vh;width:98vw;border:'1'"></iframe>
							<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style="height:0vh;width:98vw;border:'1'"></iframe>
					<%
					}
					
				}else{  // From CA	
				
					practitioner_id =(String)session.getValue("ca_practitioner_id");
					String pract_str="select Count(*) from oa_clinic_schedule where facility_id ='"+facilityid+"' and PRACTITIONER_ID = '"+practitioner_id+"' and trunc(CLINIC_DATE) >= trunc(sysdate) and PRIMARY_RESOURCE_YN='Y'";
					rs = stmt.executeQuery(pract_str);
					if(rs !=null)
					{
						while ( rs.next() )
						{
							no_record=rs.getInt(1);	
						}
					}
						if(rs !=null) rs.close();
						if(callingMode.equals("OP_RV"))
					{
							no_record=0;
					}

					if(no_record!=0)
					{ // Schedule Aval. Show Diary

						 %>
						<!-- <frameset rows='*,8%,0' frameborder=0>
							<frameset cols='32.5%,*'>
								<frame name='apptdairy' src='../../eOA/jsp/CAOAApptDairy.jsp?<%=s%>' noresize frameborder=0 x-scroll='YES'>
								<frame name='dummy' src='../../eCommon/html/blank.html' noresize frameborder=0 scrolling='yes'>
							</frameset>
							<frame name='DispOAResultCB' src='../../eOA/jsp/CheckBoxDisplay.jsp' noresize frameborder='0' scrolling='no'>
							<frame name='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'>							
						</frameset> -->
								<iframe name='apptdairy' id='apptdairy' src='../../eOA/jsp/CAOAApptDairy.jsp?<%=s%>' noresize frameborder=0 x-scroll='YES' style="height:100vh;width:32.5vw"></iframe>
								<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' noresize frameborder=0 scrolling='yes' style="height:100vh;width:67.5vw"></iframe>		<iframe name='DispOAResultCB' id='DispOAResultCB' src='../../eOA/jsp/CheckBoxDisplay.jsp' noresize frameborder='0' scrolling='no' style="height:8vh;width:98vw"></iframe>
								<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style="height:0vh;width:98vw"></iframe>
					<%}else{ // show OA Book Appt

						session.putValue("qStr",s);
						%>
							<!-- <frameset id=appt_page rows='3%,27%,0%,*,0' border='1'>
								<frame name='image' src='../../eOA/jsp/DisplayImage.jsp?CA=Y&callingMode=<%=callingMode%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize>
								<frame name='querying'src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&CA=Y&specialty_codema=<%=specialty_code1%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&order_category=<%=order_category%>&visit_flag_OP=<%=visit_flag_OP%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&install_yn_val=<%=install_yn_val%>&order_category=<%=order_category%>' frameborder=no scrolling=no noresize>
								<frame name='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no>
								<frame name='result' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto>
								<frame name='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'>
							</frameset> -->
								<iframe name='image' id='image' src='../../eOA/jsp/DisplayImage.jsp?CA=Y&callingMode=<%=callingMode%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize style="height:3vh;width:98vw;border:'1'"></iframe>
								<iframe name='querying' id='querying' src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&CA=Y&specialty_codema=<%=specialty_code1%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&order_category=<%=order_category%>&visit_flag_OP=<%=visit_flag_OP%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&install_yn_val=<%=install_yn_val%>&order_category=<%=order_category%>' frameborder=no scrolling=no noresize style="height:31vh;width:98vw;border:'1'"></iframe>
								<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no style="height:0vh;width:98vw;border:'1'"></iframe>
								<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto style="height:60vh;width:98vw;border:'1'"></iframe>
								<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder='0' noresize scrolling='auto' style="height:0vh;width:98vw;border:'1'"></iframe>
						<%
					}

					
				}// End CA
				

			}
		}else{ // Direct from IP 
		
			String pat_id=request.getParameter("patient_id");
			session.putValue("Pat_id",pat_id);

			%>
				<!-- <frameset id=appt_page rows='3%,27%,0%,*,0' border='1'> -->
					<iframe name='image' id='image' src='../../eOA/jsp/DisplayImage.jsp?callingMode=<%=callingMode%>&from_OR=<%=from_OR%>&rd_appt_yn=<%=rd_appt_yn%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize style="height:3vh;width:98vw;border:'1'"></iframe>
					<iframe name='querying' id='querying' src='../../eOA/jsp/ScheduleAppointment.jsp?<%=s%>&specialty_codema=<%=specialty_code1%>&rd_appt_yn=<%=rd_appt_yn%>&from_OR=<%=from_OR%>&visit_flag_OP=<%=visit_flag_OP%>&order_category=<%=order_category%>&from_facility_id=<%=from_facility_id%>&from_encounter_id=<%=from_encounter_id%>&install_yn_val=<%=install_yn_val%>' frameborder=no scrolling=no noresize style="height:31vh;width:98vw;border:'1'"></iframe>
					<iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=no style="height:0vh;width:98vw;border:'1'"></iframe>
					<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=no noresize scrolling=auto style="height:60vh;width:98vw;border:'1'"></iframe>
					<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style="height:0vh;width:98vw;border:'1'"></iframe>
				<!-- </frameset> -->
			<%
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		
	}catch(Exception es){
		//out.println("Exception :"+es);
		es.printStackTrace();
	}

}
}
}catch(Exception e){
	e.printStackTrace();  
}finally{
		
		ConnectionManager.returnConnection(con,request);		 
	}
%>
</head>
</html>
