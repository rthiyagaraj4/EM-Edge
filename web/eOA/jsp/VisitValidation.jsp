
     
<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
<% 
Connection con = null;
ResultSet rs=null;
Statement stmt =null;
PreparedStatement pstmt =null;
try{
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	CallableStatement cstmt = null;
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String facilityId				=(String) session.getValue("facility_id");
	String clinic_code				=(String) hash.get("clinic_code");
	String practitioner_id			=(String) hash.get("practitioner_id");
	String clinic_date				=(String) hash.get("clinic_date");
	
	String steps					=(String) hash.get("steps");
		
	String fromTime					=(String) hash.get("fromTime");


	String toTime					=(String) hash.get("toTime");
	String no_of_slots				=(String) hash.get("no_of_slots");
	String firstvisit				=(String) hash.get("firstvisit");
	String overbookedyn				=(String) hash.get("overbookedyn");
	String calling_from				=(String) hash.get("calling_from");
	String appt_ref_no				=(String) hash.get("appt_ref_no");
	String patient_id				=(String) hash.get("patient_id");
	String visit_limit_rule			=(String) hash.get("visit_limit_rule");
	String slot_appt_ctrl			=(String) hash.get("slot_appt_ctrl");
	String Forced					=(String) hash.get("Forced");
	String visit_type_ind				=(String) hash.get("visit_type_ind");	
	String from_appt_date 			= (String) hash.get("from_appt_date");
	String from_practitioner_id		= (String) hash.get("from_practitioner_id");
	String from_clinic_code			= (String) hash.get("from_clinic_code");

	if (steps==null)		steps="";
	
	if (patient_id==null)		patient_id="";
	if (calling_from==null) calling_from="";
	if (no_of_slots==null)	no_of_slots="";
	if (firstvisit==null)	firstvisit="";
	if (clinic_code==null)	clinic_code="";
	if (fromTime==null)	fromTime="";
	if (toTime==null)	toTime="";
	if (overbookedyn==null)	overbookedyn="";
	if (calling_from==null)	calling_from="";
	if (practitioner_id==null)	practitioner_id ="";
	if (appt_ref_no==null)	appt_ref_no ="";
	if (visit_limit_rule==null)	visit_limit_rule ="";
	if (visit_type_ind==null)	visit_type_ind="";
	
	if (from_appt_date==null)	from_appt_date="";
	if (from_practitioner_id==null)	from_practitioner_id="";
	if (from_clinic_code==null)	from_clinic_code="";

	if(Forced==null || Forced.equals("null") || Forced.equals("")){
		Forced="N";
	}

	String wd1="0";
	String wd2="0";
	String max_slots_for_first_visit="";
	String time_table_type="",max_other_visits="",total_other_visits="";
	String total_first_visit="";
	boolean alert_flag=true;
	if (no_of_slots==""||no_of_slots.equals("")) no_of_slots="0";
	int end_time_value =0,total_other_visits_value=0,max_other_visits_value=0;
	int max_visit=0,tot_first=0;


	int no_of_slots_value = Integer.parseInt(no_of_slots);
	String function=(String) hash.get("function");
	if(function==null || function.equals("null")){
		function="";
	}

	/* Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1 */
	cstmt = con.prepareCall("{? = call OA_CONT_SLT_YN(?,?,?,?,?,?)}");

	cstmt.registerOutParameter( 1, Types.VARCHAR );
	cstmt.setString( 2, facilityId );
	cstmt.setString( 3, clinic_code );
	cstmt.setString( 4, practitioner_id );
	cstmt.setString( 5, clinic_date );
	cstmt.setString( 6, fromTime );
	cstmt.setInt( 7, no_of_slots_value );

	cstmt.execute() ;

	String cont_slt_yn = cstmt.getString( 1 ); 
	if(cont_slt_yn == null) cont_slt_yn = "";
	
	/* End ML-BRU-CRF-0628.1 */
	
	if (steps.equals("1") && function.equals("RuleBasedTransfer")){

			StringBuffer sql1=new StringBuffer("");
			sql1.append("select count(1) total from oa_appt  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and appt_date=to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and appt_slab_from_time >= to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and appt_slab_from_time+(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') ");
			rs = stmt.executeQuery(sql1.toString());
			sql1.setLength(0);
			String total="";
			while(rs.next()){
				total = rs.getString("total");
				if (!(total.equals("0"))){
					alert_flag=false; 
					no_of_slots="1";%>
					alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
					<%if (!(calling_from.equals("TRANSFER")))%>
					   document.forms[0].no_slots.value=<%=no_of_slots%>;
					<%
				}
			}
			if (rs!=null) rs.close();
			
			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag){

				if ((cont_slt_yn.equals("N"))){
					alert_flag=false; 
					no_of_slots="1";%>
					alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
					<%if (!(calling_from.equals("TRANSFER")))%>
					   document.forms[0].no_slots.value=<%=no_of_slots%>;
					<%
				}
			}

			if (alert_flag){
				String sql2="select SIGN(end_time -((to_date(to_char(end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))) end_time,nvl(max_first_visits,0) max_first_visits ,nvl(total_first_visit,0)+nvl(TOTAL_FIRST_VISITS_BLOCKED,0) total_first_visit ,nvl(max_other_visits,0) max_other_visits ,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(TOTAL_OTHER_VISITS_BLOCKED,0) total_other_visits from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X')";
				rs = stmt.executeQuery(sql2);
				while(rs.next()){
					end_time_value= rs.getInt("end_time");
					wd1 = rs.getString("max_first_visits");
					wd2=rs.getString("total_first_visit");
					max_other_visits=rs.getString("max_other_visits");
					total_other_visits=rs.getString("total_other_visits");		
				}
				max_visit=Integer.parseInt(wd1);
				tot_first=Integer.parseInt(wd2);
				max_other_visits_value=Integer.parseInt(max_other_visits);
				total_other_visits_value=Integer.parseInt(total_other_visits);

				if (max_visit > 0) {
					if((from_appt_date.equals(clinic_date) && from_clinic_code.equals(clinic_code)) && (from_practitioner_id.equals(practitioner_id))){
					}else if(visit_type_ind.equals("F")&&((tot_first+no_of_slots_value) > max_visit)&&slot_appt_ctrl.equals("S")){%>
						 alert(getMessage('MAX_FIRST_VISITS_REACHED','OA'));
					  <% if (!(calling_from.equals("TRANSFER")))%>
							document.forms[0].no_slots.value='';
						   
					  
					   <%alert_flag=false;
					}	
				}	   					
				if (max_other_visits_value>0){			   					
					if((from_appt_date.equals(clinic_date) && from_clinic_code.equals(clinic_code)) && (from_practitioner_id.equals(practitioner_id))){
					}else if((!visit_type_ind.equals("F"))&&((total_other_visits_value+no_of_slots_value) > max_other_visits_value)&&slot_appt_ctrl.equals("S")){ no_of_slots="1";%>
					alert(getMessage('MAX_OTHER_VISITS_REACHED','OA'));
					  <% if (!(calling_from.equals("TRANSFER")))%>
						   document.forms[0].no_slots.value=<%=no_of_slots%>;
					   
					   <%alert_flag=false;
					}	
				}
				if (end_time_value<0 && alert_flag){
					alert_flag=false;
					no_of_slots="1";%>
				  alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
				   <%if (!(calling_from.equals("TRANSFER")))%>
					   document.forms[0].no_slots.value=<%=no_of_slots%>;
				   <%
				}

				//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if (alert_flag){

					if ((cont_slt_yn.equals("N"))){
						alert_flag=false; 
						no_of_slots="1";%>
						  alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
						   <%if (!(calling_from.equals("TRANSFER")))%>
							   document.forms[0].no_slots.value=<%=no_of_slots%>;
						   <%
					}
				}

				if (alert_flag){
					if (rs!=null) rs.close();
					String sql12="select count(1) total from OA_CLINIC_SCHEDULE_BREAK  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and break_start_time >= to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and break_start_time+(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')  ";
					rs = stmt.executeQuery(sql12);
					String total2="";
					while(rs.next()){
						total2 = rs.getString("total");
						if (!(total2.equals("0"))){		 
							alert_flag =false;
							no_of_slots="1";%>
								alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
							 <%
							if (!(calling_from.equals("TRANSFER")))%>
							   document.forms[0].no_slots.value=<%=no_of_slots%>;
							 <%
						}
					}
			  }

			    //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if (alert_flag){

					if ((cont_slt_yn.equals("N"))){
						alert_flag =false;
						no_of_slots="1";%>
							alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
						 <%
						if (!(calling_from.equals("TRANSFER")))%>
						   document.forms[0].no_slots.value=<%=no_of_slots%>;
						 <%
					}
				}
		}

	   if (alert_flag){
			if (rs!=null) rs.close();
   		   String sql11="select count(1) total from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and block_date =to_date('"+clinic_date+"','dd/mm/yyyy') and effective_from_date_time >= to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and effective_from_date_time+(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')";
			rs = stmt.executeQuery(sql11);
			String total1="";
			while(rs.next()){
			 total1 = rs.getString("total");
			 if (!(total1.equals("0"))){		 
			 alert_flag =false;		
				no_of_slots="1";
			 %>
			 alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
		     <%
             if (!(calling_from.equals("TRANSFER")))
              %>
		       document.forms[0].no_slots.value==<%=no_of_slots%>;
		     <%
			 }
			}
		  }

		  //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag){

				if ((cont_slt_yn.equals("N"))){
					alert_flag =false;		
					no_of_slots="1";
					 %>
					 alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
					 <%
					 if (!(calling_from.equals("TRANSFER")))
					  %>
					   document.forms[0].no_slots.value==<%=no_of_slots%>;
					 <%
				}
			}

}else if (steps.equals("1")){
	
		if (no_of_slots_value>1){
			StringBuffer sql1=new StringBuffer("");
				sql1.append("select count(1) total from oa_appt  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and appt_date=to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and appt_slab_from_time >= to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and appt_slab_from_time+(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') ");
		
			rs = stmt.executeQuery(sql1.toString());
			sql1.setLength(0);
			String total="";
			while(rs.next()){
				total = rs.getString("total");
				if (!(total.equals("0"))){
					alert_flag=false; 
					no_of_slots="1";//Modified Against 43188%>
					alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
					<%if (!(calling_from.equals("TRANSFER")))%>
					   document.forms[0].no_slots.value=<%=no_of_slots%>;
					<%
				}
			}
			if (rs!=null) rs.close();

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag){

				if ((cont_slt_yn.equals("N"))){
					alert_flag=false; 
					no_of_slots="1";%>
					alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
					<%if (!(calling_from.equals("TRANSFER")))%>
					   document.forms[0].no_slots.value=<%=no_of_slots%>;
					<%
				}
			}

			if (alert_flag){
				String sql2="select SIGN(end_time -((to_date(to_char(end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))) end_time,nvl(max_first_visits,0) max_first_visits ,nvl(total_first_visit,0) total_first_visit ,nvl(max_other_visits,0) max_other_visits ,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and TIME_TABLE_TYPE='1'";
				rs = stmt.executeQuery(sql2);
				while(rs.next()){
					end_time_value= rs.getInt("end_time");
					wd1 = rs.getString("max_first_visits");
					wd2=rs.getString("total_first_visit");
					max_other_visits=rs.getString("max_other_visits");
					total_other_visits=rs.getString("total_other_visits");		
				}
				max_visit=Integer.parseInt(wd1);
				tot_first=Integer.parseInt(wd2);
				max_other_visits_value=Integer.parseInt(max_other_visits);
				total_other_visits_value=Integer.parseInt(total_other_visits);

				if (max_visit>0) {
					if((from_appt_date.equals(clinic_date) && from_clinic_code.equals(clinic_code)) && (from_practitioner_id.equals(practitioner_id))){
					}else if(visit_type_ind.equals("F")&&((tot_first+no_of_slots_value) > max_visit)&&slot_appt_ctrl.equals("S")){
					   if (!(calling_from.equals("TRANSFER")))%>
						   document.forms[0].no_slots.value='';
					   alert(getMessage('MAX_FIRST_VISITS_REACHED','OA'));
					   <%alert_flag=false;
					}	
				}
				//if (visit_limit_rule.equals("E")&&max_other_visits_value>0) {			   					
				if (max_other_visits_value>0){			   					
					if((from_appt_date.equals(clinic_date) && from_clinic_code.equals(clinic_code)) && (from_practitioner_id.equals(practitioner_id))){
					}else if((!visit_type_ind.equals("F"))&&((total_other_visits_value+no_of_slots_value) > max_other_visits_value)&&slot_appt_ctrl.equals("S")){
					   if (!(calling_from.equals("TRANSFER")))%>
						   document.forms[0].no_slots.value='';
					   alert(getMessage('MAX_OTHER_VISITS_REACHED','OA'));
					   <%alert_flag=false;
					}	
				}
				if (end_time_value<0 && alert_flag){
					alert_flag=false;
					no_of_slots="1"; // Modified Against 43188%>
				  alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
				   <%if (!(calling_from.equals("TRANSFER"))) %>
					   document.forms[0].no_slots.value=<%=no_of_slots%>;
				   <%
				}

				//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if (alert_flag){

					if ((cont_slt_yn.equals("N"))){
						alert_flag=false; 
						no_of_slots="1"; %>
						  alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
						   <%if (!(calling_from.equals("TRANSFER"))) %>
							   document.forms[0].no_slots.value=<%=no_of_slots%>;
						   <%
					}
				}

				if (alert_flag){
					if (rs!=null) rs.close();
					String sql12="select count(1) total from OA_CLINIC_SCHEDULE_BREAK  where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy') and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and break_start_time >= to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and break_start_time+(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')  ";
				
					rs = stmt.executeQuery(sql12);
					String total2="";
					while(rs.next()){
						total2 = rs.getString("total");
						if (!(total2.equals("0"))){		 
							alert_flag =false;
							no_of_slots="1";%>
							alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
							 <%
							if (!(calling_from.equals("TRANSFER")))%>
							   document.forms[0].no_slots.value=<%=no_of_slots%>;
							 <%
						}
					}
			  }

			    //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if (alert_flag){

					if ((cont_slt_yn.equals("N"))){
						alert_flag =false;
						no_of_slots="1";%>
						alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
						 <%
						if (!(calling_from.equals("TRANSFER")))%>
						   document.forms[0].no_slots.value=<%=no_of_slots%>;
						 <%
					}
				}
		}

	   if (alert_flag){
			if (rs!=null) rs.close();
   		   String sql11="select count(1) total from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and block_date =to_date('"+clinic_date+"','dd/mm/yyyy') and effective_from_date_time >= to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and effective_from_date_time+(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')";
			rs = stmt.executeQuery(sql11);
			String total1="";
			while(rs.next()){
			 total1 = rs.getString("total");
			 if (!(total1.equals("0"))){		 
			 alert_flag =false;
				no_of_slots="1";
			 %>
			alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
		     <%
             if (!(calling_from.equals("TRANSFER")))
              %>
		       document.forms[0].no_slots.value=<%=no_of_slots%>;
		     <%
			 }
			}
		  }

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag){

				if ((cont_slt_yn.equals("N"))){
					alert_flag =false;
					no_of_slots="1";
					 %>
					alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
					 <%
					 if (!(calling_from.equals("TRANSFER")))
					  %>
					   document.forms[0].no_slots.value=<%=no_of_slots%>;
					 <%
				}
			}
	 }
	 //modified by kamatchi S PAS-COMN-OA-Schedule Appointments-Book Appointment screen
	if ((alert_flag && (!(calling_from.equals("TRANSFER")))) || (no_of_slots.equals("1") && !(calling_from.equals("TRANSFER"))))
		{
		if (no_of_slots.equals("0")) no_of_slots="1";
				 String sql12="select to_char((to_date(to_char(sysdate,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi') -to_date(to_char(sysdate,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(sysdate,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'),'hh24:mi') tm from dual";
                 if (rs!=null) rs.close();
				 rs=stmt.executeQuery(sql12);
				 String to_time_value = "";
				 while(rs!=null&&rs.next())
				{
                 to_time_value = rs.getString("tm");
				 %>
				 document.forms[0].To_timeval.value='<%=to_time_value%>';
				 <%
				}		
		} 

	}else if (steps.equals("2")){
	 String pract_id=(String) hash.get("pract_id");
	 String clinic_code1=(String) hash.get("clinic_code");
	 String speciality_code="";
	 if (pract_id==null) pract_id="";
	 String pract_desc ="";
	 if (!clinic_code1.equals(""))
	 {	 if (rs!=null) rs.close();
		 String sql1 = "select speciality_code from op_clinic where facility_id = ? and clinic_code =?";
		 pstmt=con.prepareStatement(sql1);
		 pstmt.setString(1,facilityId);
		 pstmt.setString(2,clinic_code1);
		 rs=pstmt.executeQuery();
		 while(rs!=null && rs.next())
			{
			 speciality_code= rs.getString("speciality_code");   
			}
	 }
	 if(rs!=null) rs.close();
	 String sql =  "SELECT b.DESC_USERDEF descusrdef FROM am_practitioner a, AM_PRACT_TYPE b where a.pract_type = b.pract_type and a.practitioner_id  = ?";
	 if (pstmt!=null) pstmt.close();
	 pstmt=con.prepareStatement(sql);
	 pstmt.setString(1,pract_id);
	 rs=pstmt.executeQuery();
	 if (rs!=null){
	    if (rs.next())
		 {
			pract_desc= rs.getString("descusrdef");
		  %>
			document.forms[0].pract_type1.innerHTML="&nbsp;<%=pract_desc%>";
		  <%
		 }
        else
		 {
		  %>
		    document.forms[0].pract_type1.innerHTML=="";
		  <%
		 }
	 }
	 else
		{
		  %>
			document.forms[0].pract_type1.innerHTML="";
		  <%
		}
     if(!(clinic_code1.equals("")))
		{
		  %>
			document.forms[0].speciality.value="<%=speciality_code%>";
		    document.forms[0].disp_next.checked=true;
			document.forms[0].disp_next.disabled=false;
			if (document.forms[0].speciality.value=="")
			{
				document.forms[0].speciality.value="";
		        document.forms[0].disp_next.checked=false;
			    document.forms[0].disp_next.disabled=true;
			}
		  <%		
		}
	}else if (steps.equals("3")){
	 String nationality=(String) hash.get("nationality_code");
	 if (nationality==null) nationality="";
	 String pat_cat_code ="";
	 String sql =  "SELECT STAT_GRP_ID FROM AM_STAT_GRP_DETAIL WHERE MEMBER_ID = ?";
	 if (pstmt!=null) pstmt.close();
	 if (rs!=null) rs.close();
	 pstmt=con.prepareStatement(sql);
	 pstmt.setString(1,nationality);
	 rs=pstmt.executeQuery();
	 if (rs!=null){
	    if (rs.next())
		 {
			pat_cat_code = rs.getString("STAT_GRP_ID");
		  %>
			document.forms[0].pat_cat.value="<%=pat_cat_code%>";
			document.forms[0].pat_cat.disabled=true;
		  <%
		 }
        else
		 {
		  %>
			document.forms[0].pat_cat.value="*O";
			document.forms[0].pat_cat.disabled=true;
		  <%
		 }
	 }
	 else
		{
		  %>
	     	document.forms[0].pat_cat.value="*O";
			document.forms[0].pat_cat.disabled=true;
		  <%
		}    
		  %>
			if (document.forms[0].pat_cat.value=="")
				{		
				document.forms[0].pat_cat.value="*O";
				document.forms[0].pat_cat.disabled=true;
		 		}
		  <%

	}else if (steps.equals("4")){
	   
		String chk_overlap1= "select '1' from oa_appt where (appt_slab_from_time between to_date('"+fromTime+"','hh24:mi') and to_date('"+fromTime+"','hh24:mi') or appt_slab_to_time between to_date('"+toTime+"','hh24:mi') and to_date('"+toTime+"','hh24:mi'))and appt_date = to_date('"+clinic_date+"','dd/mm/yyyy') and patient_id='"+patient_id+"' and appt_ref_no !='"+appt_ref_no+"'";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(chk_overlap1) ;
		if(rs !=null){
		  if(rs.next())		{	
			%>
			alert(getMessage('APPT_OVERLAP_NOT_PROCEED','OA'));
			<%
			}
		}
	
	}else{
	if(!Forced.equals("Y")){
	String sql="select SIGN(end_time -((to_date(to_char(end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))) end_time,nvl(max_first_visits,0) max_first_visits ,nvl(total_first_visit,0) total_first_visit,nvl(max_slots_for_first_visit,0) max_slots_for_first_visit,time_table_type,nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked,nvl(max_other_visits,0) max_other_visits,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) total_other_visits  from oa_clinic_schedule "+
			" where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"','dd/mm/yyyy')"+
			" and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X')";
		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);
		while(rs.next()){
				end_time_value= rs.getInt("end_time");
				wd1 = rs.getString("max_first_visits");
				wd2=rs.getString("total_first_visit");
				max_slots_for_first_visit=rs.getString("max_slots_for_first_visit");
				time_table_type=rs.getString("time_table_type");
				total_first_visit=rs.getString("total_first_visit_slots_booked");
				total_other_visits =  rs.getString("total_other_visits");
				max_other_visits   =  rs.getString("max_other_visits");
		}
		max_visit=Integer.parseInt(wd1);
		tot_first=Integer.parseInt(wd2);
		max_other_visits_value = Integer.parseInt(max_other_visits);
		total_other_visits_value = Integer.parseInt(total_other_visits);		
	  if (visit_type_ind.equals("F")){
		if(max_visit > 0 )
		{
			if(tot_first >= max_visit)
				{
			   %>               
			   alert(getMessage('MAX_FIRST_VISITS_REACHED','OA'));
			   document.forms[0].visit_type_short_desc.value=''
			   document.forms[0].first_visit_flag.value='Y';
			   document.forms[0].no_slots.value='' ;
			   <%
				alert_flag=false;
				}				
      }
	  }
	  if (!(visit_type_ind.equals("F"))){
		if(visit_limit_rule.equals("E")&&max_other_visits_value > 0 )
		{
			if(total_other_visits_value >= max_other_visits_value)
				{
			   %>
			   alert(getMessage('MAX_OTHER_VISITS_REACHED','OA'));
			   document.forms[0].visit_type_short_desc.value=''
			   document.forms[0].other_visit_flag.value='Y';
			   document.forms[0].no_slots.value='' ;
			   <%
				alert_flag=false;
				}				
      }
	  }
	  if (!no_of_slots.equals("")&&overbookedyn.equals("N")){
	  if (Integer.parseInt(no_of_slots)>1 &&time_table_type.equals("1")&&alert_flag&&overbookedyn.equals("N"))
		{
		   rs.close();
   		   String sql2="select count(1) total from oa_appt "+
			" where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and appt_date=to_date('"+clinic_date+"','dd/mm/yyyy')"+
			" and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and appt_slab_from_time >= to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and appt_slab_from_time+(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(appt_slab_to_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(appt_slab_from_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') ";
			rs = stmt.executeQuery(sql2);
		    String total="";
			while(rs.next()){
			 total = rs.getString("total");
			 if (!(total.equals("0"))){		 
			  alert_flag =false;
			  no_of_slots="1";
		      %>
		   alert(getMessage('CONTINUOUS_SLOT_ERROR','OA')); 
		       document.forms[0].no_slots.value=<%=no_of_slots%>;
		      <%	
			 }
			else
				{
				if(max_visit > 0 && slot_appt_ctrl.equals("S"))
				{
						if((tot_first+Integer.parseInt(no_of_slots)) > max_visit&&visit_type_ind.equals("F")&&overbookedyn.equals("N"))
						{
						   alert_flag = false;
						   %>
						   alert(getMessage('MAX_FIRST_VISITS_REACHED','OA'));
						   document.forms[0].no_slots.value='' ;
						   <%
						}				
			       }//max_visit
				if(visit_limit_rule.equals("E")&&max_other_visits_value > 0 && slot_appt_ctrl.equals("S") )
				{
						if((total_other_visits_value+Integer.parseInt(no_of_slots)) > max_other_visits_value&&(!visit_type_ind.equals("F"))&&overbookedyn.equals("N"))
						{
						   alert_flag = false;
						   %>
						   alert(getMessage('MAX_OTHER_VISITS_REACHED','OA'));
						   document.forms[0].no_slots.value='' ;
						   <%
						}				
			       }				

				}
			}

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag){

				if ((cont_slt_yn.equals("N"))){
					alert_flag =false;
					  no_of_slots="1";
					  %>
				      alert(getMessage('CONTINUOUS_SLOT_ERROR','OA')); 
					   document.forms[0].no_slots.value=<%=no_of_slots%>;
					  <%	
				}
			}
		}
	   if (end_time_value<0 && alert_flag&&overbookedyn.equals("N"))
		{ 
		   alert_flag =false;
		   no_of_slots="1";
		   %>
		   alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
		   document.forms[0].no_slots.value=<%=no_of_slots%> ;
		   <%	
		}

		//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		if (alert_flag && overbookedyn.equals("N")){

			if ((cont_slt_yn.equals("N"))){
				alert_flag=false; 
				no_of_slots="1";
			   %>
			   alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
			   document.forms[0].no_slots.value=<%=no_of_slots%> ;
			   <%
			}
		}

	   if (alert_flag&&overbookedyn.equals("N"))
		  {
		   if (rs!=null) rs.close();
			String sql11="select count(1) total from oa_clinic_schedule_break where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"','dd/mm/yyyy')"+
			" and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and break_start_time >= to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and break_start_time+(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(break_end_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(break_start_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')  ";
			 rs = stmt.executeQuery(sql11);
		     String total1="";
			 while(rs.next()){
			 total1 = rs.getString("total");
			 if (!(total1.equals("0"))){		 
			 alert_flag =false;	
				no_of_slots="1";
			 %>
			 alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
			 document.forms[0].no_slots.value=<%=no_of_slots%>;
			 <%	
			 }
			}
		  }

		  //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag && overbookedyn.equals("N")){

				if ((cont_slt_yn.equals("N"))){
					alert_flag =false;	
					no_of_slots="1";
					 %>
					 alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
					 document.forms[0].no_slots.value=<%=no_of_slots%>;
					 <%
				}
			}

	   if (alert_flag&&overbookedyn.equals("N"))
		  {
		   if (rs!=null) rs.close();
   		   String sql11="select count(1) total from oa_block_appt where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X')=nvl('"+practitioner_id+"','X') and block_date =to_date('"+clinic_date+"','dd/mm/yyyy') and effective_from_date_time >= to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi') and effective_from_date_time+(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"', 'dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"', 'dd/mm/yyyy hh24:mi')) <=(to_date(to_char(effective_to_date_time,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi')-to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(effective_from_date_time,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi')  ";
			rs = stmt.executeQuery(sql11);
			String total1="";
			while(rs.next()){
			 total1 = rs.getString("total");
			 if (!(total1.equals("0"))){		 
			 alert_flag =false;	
			 no_of_slots="1";
			 %>
			 alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
		     document.forms[0].no_slots.value=<%=no_of_slots%>;
		     <%
			 }
			}
		  }

		  //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			if (alert_flag && overbookedyn.equals("N")){

				if ((cont_slt_yn.equals("N"))){
					alert_flag =false;	
					 no_of_slots="1";
					 %>
					 alert(getMessage('CONTINUOUS_SLOT_ERROR','OA'));
					 document.forms[0].no_slots.value=<%=no_of_slots%>;
					 <%
				}
			}
		}		
    if (alert_flag)
		{
		if (no_of_slots.equals("0")) no_of_slots="1";
				 String sql12="select to_char((to_date(to_char(sysdate,'dd/mm/yyyy')||'"+toTime+"','dd/mm/yyyy hh24:mi') -to_date(to_char(sysdate,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'))*"+no_of_slots+"+to_date(to_char(sysdate,'dd/mm/yyyy')||'"+fromTime+"','dd/mm/yyyy hh24:mi'),'hh24:mi') dttmm from dual";
                 if (rs!=null) rs.close();
				 rs=stmt.executeQuery(sql12);
				 String to_time_value = "";
				 while(rs!=null&&rs.next())
				{
                 to_time_value = rs.getString("dttmm");
				 %>
				 document.forms[0].To_timeval.value='<%=to_time_value%>';
				 <%
				}
		
		}
	}// end forced 
	}

	
	
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	if(pstmt!=null) pstmt.close();
	if (cstmt != null) cstmt.close();

hash.clear();
}
catch( Exception e ){
	e.printStackTrace();
	out.println(e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>		

