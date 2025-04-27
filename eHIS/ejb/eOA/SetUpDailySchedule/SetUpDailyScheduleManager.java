/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA.SetUpDailySchedule ;
import webbeans.eCommon.*;

import java.rmi.* ;
import java.util.* ;
import javax.ejb.* ;

import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import java.text.DecimalFormat; //Added by munisekhar for IN35356 on Thursday, Sep 27, 2012

/**
*
* @ejb.bean
*	name="SetUpDailySchedule"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SetUpDailySchedule"
*	local-jndi-name="SetUpDailySchedule"
*	impl-class-name="eOA.SetUpDailySchedule.SetUpDailyScheduleManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eOA.SetUpDailySchedule.SetUpDailyScheduleLocal"
*	remote-class="eOA.SetUpDailySchedule.SetUpDailyScheduleRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eOA.SetUpDailySchedule.SetUpDailyScheduleLocalHome"
*	remote-class="eOA.SetUpDailySchedule.SetUpDailyScheduleHome"
*	generate= "local,remote"
*
*
*/
public class SetUpDailyScheduleManager implements SessionBean
{
		//Connection con  =null;
		PreparedStatement	pstmt = null;
		PreparedStatement	pstmt_new0=null;
		PreparedStatement	pstmt_new=null;
		PreparedStatement	pstmt_new1=null;
		PreparedStatement	pstmt_new2=null;
		PreparedStatement	pstmt_new3=null;
		PreparedStatement	pstmt_new4=null;
	//	PreparedStatement pstmt_sql_max_num=null;
	//	PreparedStatement pstmt_insertsql_OA_CLINIC_SCHEDULE_DTL=null;
		ResultSet rs_new=null;
		ResultSet rs=null;
		ResultSet rs_other=null;
		
		PreparedStatement pstmt1 = null;
		Statement stmt = null;
		ResultSet rs1=null;
		CallableStatement calabl=null;
		CallableStatement clblstmt=null;
		ResultSet rss=null;

//     String modified_by_id = "";

		String sql ="";

		SessionContext ctx;

		public final String RECORD_INSERTED = "RECORD_INSERTED";
		public final String RECORD_MODIFIED = "RECORD_MODIFIED";
		public final String RECORD_DELETED  = "RECORD_DELETED";



		public void ejbCreate() {}
		public void ejbRemove() {}
		public void ejbActivate() {}
		public void ejbPassivate() {}
		public void setSessionContext (SessionContext sessioncontext)
		  {
			 ctx = sessioncontext;
		  }


/**
* @ejb.interface-method
*	 view-type="both"
*/
	public HashMap insertSetUpDailySchedule(Properties p,HashMap tabdata)  
	{

				HashMap results = new HashMap() ;
				StringBuffer sb  = new StringBuffer();
				StringBuffer sbMessage = new StringBuffer("");
				boolean result = false;

			   
				Connection  con = null;
	   
			
			String clinic_code = (String)tabdata.get("clinic_code") ;
			String clinic_date = (String)tabdata.get("clinic_date") ;  
			
			String practitioner_id = (String)tabdata.get("p_practitioner_id")==null?"":(String)tabdata.get("p_practitioner_id");
			String location_Type = (String)tabdata.get("location_Type") ;
			String resource_Type = (String)tabdata.get("resource_Type") ;
			String time_table_type = (String)tabdata.get("p_time_table_type") ;
		    String modified_by_id = (String)tabdata.get("modified_by_id");
			String remarks = (String)tabdata.get("p_remarks");
			String start_time = (String)tabdata.get("p_start_time");
			String end_time = (String)tabdata.get("p_end_time");
			String time_per_patient = (String)tabdata.get("p_time_per_patient"); 
			
			String max_patients_per_day = (String)tabdata.get("p_max_patients_per_day");
			String time_per_slab = (String)tabdata.get("p_time_per_slab");
			String max_patients_per_slab = (String)tabdata.get("p_max_patients_per_slab");
			String max_first_visits = (String)tabdata.get("p_max_first_visit");
			String max_over_bookings = (String)tabdata.get("p_max_over_bookings");
			String break_time_intervals = (String)tabdata.get("p_break_time_intervals");
			String final_string = (String)tabdata.get("final_string");
			String day_no = (String)tabdata.get("day_no");
			String facilityId = (String)tabdata.get("added_facility_id");
			String added_by_id = (String)tabdata.get("added_by_id");
			String client_ip_address = (String)tabdata.get("added_at_ws_no");
			String 	p_max_other_visits = (String)	tabdata.get("p_max_other_visits");
			String 	p_max_slots_per_day = (String)	tabdata.get("p_max_slots_per_day");
			String 	alcncriteria = (String)	tabdata.get("alcn_criteria");
			//String resourceType=(String)tabdata.get("resourceType");
			String no_of_forced_booking=(String)tabdata.get("no_of_forced_booking");
			String no_of_global_booking=(String)tabdata.get("no_of_global_booking");
			String visit_limit_rule=(String)tabdata.get("visit_limit_rule");
			String max_new_patients=(String)tabdata.get("max_new_patients");
			String max_old_patients=(String)tabdata.get("max_old_patients");

			//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
			String schedule_extend_yn = (String)tabdata.get("schedule_extend_yn");

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			Boolean isSlotStartMidEndAppl = false;
			String ext_all_slots_yn = (String)tabdata.get("ext_all_slots_yn");
			String ext_start_slots = (String)tabdata.get("ext_start_slots");
			String ext_mid_slots = (String)tabdata.get("ext_mid_slots");
			String ext_end_slots = (String)tabdata.get("ext_end_slots");

			String primary_recource_yn="N";

			String locale = p.getProperty("LOCALE");
			


			java.util.StringTokenizer toks = new java.util.StringTokenizer (break_time_intervals,",") ;

			String strVar = "" ;
			String break_end_time="";
			String break_start_time ="";
			String res_type="";
			String tmp_pr_res="";
			String tmp_pr_res_pract_typ="";
			String brk_str="";
			String mess="";
			String from="";
			String to="";
			String dur="";
			String sql_oa_c_b="";
			String speciality_code="";
			String min_slot_slab_end_time="";

			int maxnum_sch=0;
			int maxnum_sch_brk=0;
			int res =0;
			int strlen=0;
			int pat_rem = 0;
			int max_pat_slab=0;
			
			boolean insertable = true;


			 try
				{

				con=ConnectionManager.getConnection(p);

				isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

				if(resource_Type.equals("P")){
					sql  = "select pract_type res_type from am_practitioner where nvl(practitioner_id,'x')=nvl('"+practitioner_id+"','x')" ;
				}else if(resource_Type.equals("R")){
					sql  = "select room_type res_type from am_facility_room where nvl(room_num,'x')=nvl('"+practitioner_id+"','x') and OPERATING_FACILITY_ID='"+facilityId+"'" ;
				}else{
					sql  = "select resource_type res_type from am_resource where nvl(resource_id,'x')=nvl('"+practitioner_id+"','x') and facility_id= '"+facilityId+"' and resource_Class='"+resource_Type+"'" ;
				}
				
				pstmt = con.prepareStatement(sql) ;
				rs   = pstmt.executeQuery();
				while (rs.next()){
					res_type = rs.getString("res_type") ;
					if(res_type==null) res_type="";
				}				
				if (rs !=null) rs.close();
				sql  = "select primary_resource_class,pract_type,speciality_code,(select nvl(max(srl_no),0)+1 from oa_clinic_schedule where  facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and trunc(clinic_date)=to_date('"+clinic_date+"','dd/mm/yyyy')) maxnum,(select nvl(max(srl_no),0)+1 from oa_clinic_schedule_break where  facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and trunc(clinic_date)=to_date('"+clinic_date+"','dd/mm/yyyy')) maxnum1,decode('"+time_table_type+"','1',To_Char (to_date('"+start_time+"','hh24:mi')+to_number((nvl(to_char(to_date('"+time_per_patient+"','hh24:mi'),'hh24'),0) * 60 + nvl(to_char(to_date('"+time_per_patient+"','hh24:mi'),'mi'),0))/1440),'hh24:mi'),'2',To_Char(to_date('"+start_time+"','hh24:mi')+to_number((nvl(to_char(to_date('"+time_per_slab+"','hh24:mi'),'hh24'),0) * 60 + nvl(to_char(to_date('"+time_per_slab+"','hh24:mi'),'mi'),0))/1440),'hh24:mi'),To_Char(to_date('"+end_time+"','hh24:mi'),'hh24:mi')) endtime1 from op_clinic where  facility_id= '"+facilityId+"' and clinic_code='"+clinic_code+"'";
				
				
				if (pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql) ;
				rs   = pstmt.executeQuery();
				if(rs!=null && rs.next()){
					tmp_pr_res = rs.getString("primary_resource_class") ;
					tmp_pr_res_pract_typ= rs.getString("pract_type") ;
					speciality_code=rs.getString("speciality_code");
					maxnum_sch = rs.getInt("maxnum") ;
					maxnum_sch_brk = rs.getInt("maxnum1") ;
					min_slot_slab_end_time = rs.getString("endtime1");
					if(tmp_pr_res==null) tmp_pr_res="";
					if(tmp_pr_res_pract_typ==null) tmp_pr_res_pract_typ="";
					if(speciality_code ==null) speciality_code="";

					}else{
					tmp_pr_res="";
					tmp_pr_res_pract_typ="";
					}
				if (rs !=null) rs.close();
				if (pstmt !=null) pstmt.close();
						if(resource_Type.equals(tmp_pr_res))
						{
							if(! tmp_pr_res_pract_typ.equals(""))
							{
								if(tmp_pr_res_pract_typ.equals(res_type))
								{
									primary_recource_yn="Y";
								}else
								{
								  primary_recource_yn="N";
								}
							}else{
								primary_recource_yn="Y";
								}
						}else
						{
						  primary_recource_yn="N";
						}
						if (rs !=null) rs.close();
				
				/* The below queries are merged with above query for PE by Suresh M on 24/06/2010		

				sql  = "select nvl(max(srl_no),0)+1 as maxnum from oa_clinic_schedule where  facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and trunc(clinic_date)=to_date('"+clinic_date+"','dd/mm/yyyy') " ;
				if (pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql) ;
				rs   = pstmt.executeQuery();
				while (rs.next()){
					maxnum_sch = rs.getInt("maxnum") ;
				}	
				if (pstmt!=null) pstmt.close();				
				if (rs !=null) rs.close();
				sql  = "select nvl(max(srl_no),0)+1 as maxnum from oa_clinic_schedule_break where  facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and trunc(clinic_date)=to_date('"+clinic_date+"','dd/mm/yyyy') " ;
				if (pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql) ;
				rs   = pstmt.executeQuery();
				while (rs.next())
				{
				maxnum_sch_brk = rs.getInt("maxnum") ;
				}	
				if (pstmt!=null) pstmt.close();
				if (rs !=null) rs.close();
				sql="select decode('"+time_table_type+"','1',To_Char (to_date('"+start_time+"','hh24:mi')+to_number((nvl(to_char(to_date('"+time_per_patient+"','hh24:mi'),'hh24'),0) * 60 + nvl(to_char(to_date('"+time_per_patient+"','hh24:mi'),'mi'),0))/1440),'hh24:mi'),'2',To_Char(to_date('"+start_time+"','hh24:mi')+to_number((nvl(to_char(to_date('"+time_per_slab+"','hh24:mi'),'hh24'),0) * 60 + nvl(to_char(to_date('"+time_per_slab+"','hh24:mi'),'mi'),0))/1440),'hh24:mi'),To_Char(to_date('"+end_time+"','hh24:mi'),'hh24:mi')) endtime1	from dual";
				if (pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql) ;
				rs   = pstmt.executeQuery();
				while(rs.next())
					{
					 min_slot_slab_end_time = rs.getString("endtime1");
					}				
				if (rs !=null) rs.close();

			*/

			if(insertable)
				{

				if(!time_table_type.equals("2"))
					{
					
						sql= " insert into oa_clinic_schedule (facility_id,clinic_code,clinic_date,srl_no,practitioner_id, time_table_type, remarks, start_time, end_time,time_per_patient,max_patients_per_day,time_per_slab, max_patients_per_slab,max_first_visits,max_over_booking,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,max_slots_per_day, max_other_visits, MAX_FORCED_IN_BOOKING, TOTAL_FORCED_IN_BOOKED, MAX_GLOBAL_BOOKING, TOTAL_GLOBAL_BOOKED,RESOURCE_TYPE,alcn_criteria,care_locn_type_ind,resource_class,primary_resource_yn ,visit_limit_rule ,MIN_SLOT_SLAB_START_TIME,MIN_SLOT_SLAB_END_TIME,speciality_code,MAX_NEW_PATIENTS,MAX_OLD_PATIENTS, schedule_extend_yn, ext_all_slots_yn, ext_start_slots, ext_mid_slots, ext_end_slots ) values ('"+facilityId+"','"+clinic_code+"',to_date('"+clinic_date+"','dd/mm/yyyy') ,"+maxnum_sch+",'"+practitioner_id+"' ,'"+time_table_type+"','"+remarks+"', to_date('"+start_time+"','hh24:mi'), to_date('"+end_time+"','hh24:mi'), to_date('"+time_per_patient+"','hh24:mi'),'"+max_patients_per_day+"' ,to_date('"+time_per_slab+"','hh24:mi'),'"+max_patients_per_slab+"','"+max_first_visits+"','"+max_over_bookings+"','"+added_by_id+"',sysdate,'"+client_ip_address+"','"+facilityId+"','"+added_by_id+"',sysdate,'"+client_ip_address+"', '"+facilityId+"','"+p_max_slots_per_day+"','"+p_max_other_visits+"',"+no_of_forced_booking+",0,"+no_of_global_booking+",0,'"+res_type+"','"+alcncriteria+"','"+location_Type+"','"+resource_Type+"','"+primary_recource_yn+"','"+visit_limit_rule+"',to_date('"+start_time+"','hh24:mi'),to_date('"+min_slot_slab_end_time+"','hh24:mi'),'"+speciality_code+"','"+max_new_patients+"','"+max_old_patients+"', '"+schedule_extend_yn+"', '"+ext_all_slots_yn+"', '"+ext_start_slots+"', '"+ext_mid_slots+"', '"+ext_end_slots+"')";

					}else
					{

						sql= " insert into oa_clinic_schedule (facility_id,clinic_code,clinic_date,srl_no,practitioner_id, time_table_type, remarks, start_time, end_time,time_per_patient,max_patients_per_day,time_per_slab, max_patients_per_slab,max_first_visits,max_over_booking,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no, modified_facility_id,max_slots_per_day, max_other_visits, MAX_FORCED_IN_BOOKING, TOTAL_FORCED_IN_BOOKED, MAX_GLOBAL_BOOKING, TOTAL_GLOBAL_BOOKED,RESOURCE_TYPE,alcn_criteria,care_locn_type_ind,resource_class,primary_resource_yn ,visit_limit_rule ,MIN_SLOT_SLAB_START_TIME,MIN_SLOT_SLAB_END_TIME,speciality_code,MAX_NEW_PATIENTS,MAX_OLD_PATIENTS, schedule_extend_yn, ext_all_slots_yn, ext_start_slots, ext_mid_slots, ext_end_slots ) values ('"+facilityId+"','"+clinic_code+"',to_date('"+clinic_date+"','dd/mm/yyyy') ,"+maxnum_sch+",'"+practitioner_id+"' ,'"+time_table_type+"','"+remarks+"', to_date('"+start_time+"','hh24:mi'), to_date('"+end_time+"','hh24:mi'), to_date('"+time_per_patient+"','hh24:mi'),'"+max_patients_per_day+"' ,to_date('"+time_per_slab+"','hh24:mi'),'"+max_patients_per_slab+"','"+max_first_visits+"','"+max_over_bookings+"','"+added_by_id+"',sysdate,'"+client_ip_address+"','"+facilityId+"','"+added_by_id+"',sysdate,'"+client_ip_address+"', '"+facilityId+"','"+p_max_slots_per_day+"','"+p_max_other_visits+"',"+no_of_forced_booking+",0,"+no_of_global_booking+",0,'"+res_type+"','"+alcncriteria+"','"+location_Type+"','"+resource_Type+"','"+primary_recource_yn+"','"+visit_limit_rule+"',to_date('"+start_time+"','hh24:mi'),to_date('"+min_slot_slab_end_time+"','hh24:mi'),'"+speciality_code+"','"+max_new_patients+"','"+max_old_patients+"', '"+schedule_extend_yn+"', '"+ext_all_slots_yn+"', '"+ext_start_slots+"', '"+ext_mid_slots+"', '"+ext_end_slots+"')";


					}

							if (pstmt!=null) pstmt.close();


							pstmt = con.prepareStatement(sql);

							res = pstmt.executeUpdate();
							if(pstmt!=null)pstmt.close();


							if(res !=0)
							{
							insertable = true;
							while (toks.hasMoreTokens()) 
								{
									strVar = toks.nextToken() ;
									strlen = strVar.length();
									if(strlen > 1)
									{
										brk_str=brk_str+strVar.substring(0,5)+"-" ;
										brk_str=brk_str+strVar.substring(5,strVar.length())+","  ;
									}
								}
							if(brk_str.length()>0)
							brk_str=brk_str.substring(0,brk_str.length()-1);
							calabl=con.prepareCall("{call Split_Resource_Schedule( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
								if(time_table_type.equals("1") )
								{
									 from=start_time;
									 to=end_time;
									 dur=time_per_patient;
                                    
									
									
									calabl.setString( 1, facilityId);
									calabl.setString( 2, clinic_code);
									calabl.setString( 3, location_Type);
									calabl.setString( 4, resource_Type);
									calabl.setString( 5, res_type);
									calabl.setString( 6, time_table_type);
									calabl.setString( 7, practitioner_id);
									calabl.setString( 8, clinic_date);
									calabl.setString( 9, from);
									calabl.setString( 10, to);
									calabl.setString( 11, dur);
									calabl.setString( 12, brk_str);
									calabl.setString( 13, "S");
									calabl.setString( 14, added_by_id);
									calabl.setString( 15, client_ip_address);
									calabl.setString( 16, added_by_id);
									calabl.setString( 17, client_ip_address);
									calabl.registerOutParameter(18, Types.VARCHAR );
							
									calabl.execute() ;

									mess=calabl.getString( 18 ); if(mess == null) mess="";

									if(!mess.equals("SUCCESS"))
									{
									insertable = false;
									sb.append(" Insert into OA_CLINIC_SCHEDULE_SLOT_SLAB has failed ");
									}
							}else if (time_table_type.equals("2"))
								{
									 from=start_time;
									 to=end_time;
									 dur=time_per_slab;
									 max_pat_slab=Integer.parseInt(max_patients_per_slab);
							
								

									for(int xy=0;xy<max_pat_slab;xy++)
									{						
										calabl.setString( 1, facilityId);
										calabl.setString( 2, clinic_code);
										calabl.setString( 3, location_Type);
										calabl.setString( 4, resource_Type);
										calabl.setString( 5, res_type);
										calabl.setString( 6, time_table_type);
										calabl.setString( 7, practitioner_id);
										calabl.setString( 8, clinic_date);
										calabl.setString( 9, from);
										calabl.setString( 10, to);
										calabl.setString( 11, dur);
										calabl.setString( 12, brk_str);
										calabl.setString( 13, "S");
										calabl.setString( 14, added_by_id);
										calabl.setString( 15, client_ip_address);
										calabl.setString( 16, added_by_id);
										calabl.setString( 17, client_ip_address);

										calabl.registerOutParameter(18, Types.VARCHAR );

										calabl.execute() ;

										mess=calabl.getString( 18 ); if(mess == null) mess="";
										
										if(!mess.equals("SUCCESS"))
										{

										insertable = false;
										sb.append(" Insert into OA_CLINIC_SCHEDULE_SLOT_SLAB has failed ");
										}

									}
								}
								}else{
										insertable = false;
										sb.append(" Insert into OA_CLINIC_SCHEDULE has failed ");
									 }

			
				if(!final_string.equals("") && !final_string.equals("null")) 
				{
					if (insertable)
					{
						pat_rem = Integer.parseInt(max_patients_per_day);    
						java.util.StringTokenizer str 	= new java.util.StringTokenizer(final_string,"|");
						while(str.hasMoreTokens()){
							String s1=str.nextToken();
							java.util.StringTokenizer str1= new java.util.StringTokenizer(s1,"$");
							while(str1.hasMoreTokens()){
								String sts_grp_code=str1.nextToken();
								if(sts_grp_code.equalsIgnoreCase("OTH"))
								{
									sts_grp_code ="*O";
								}
								int str_grp = 0;
								String sts_grp_slt_No=str1.nextToken();
								str_grp = Integer.parseInt(sts_grp_slt_No);

								str1.nextToken();
									
							
							String new_insert_sql = "INSERT INTO oa_clinic_Schedule_dtl(facility_id,clinic_code,clinic_date,srl_no,alcn_criteria,alcn_catg_code,practitioner_id,max_patients, total_booked_patients,total_blocked_slots,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values('"+facilityId+"','"+clinic_code+"',to_date('"+clinic_date+"','dd/mm/yyyy'),"+maxnum_sch+",'"+alcncriteria+"','"+sts_grp_code+"','"+practitioner_id+"',"+str_grp+",0,0,'"+added_by_id+"',sysdate,'"+client_ip_address+"','"+facilityId+"','"+modified_by_id+"',sysdate,'"+client_ip_address+"','"+facilityId+"')";


						     int res_new = 0;
                         	if (pstmt!=null) pstmt.close();

							pstmt = con.prepareStatement(new_insert_sql);
							res_new = pstmt.executeUpdate();

							if(res_new !=0){
                                insertable = true;
							}
							else{
								sb.append(" Insert into OA_CLINIC_SCHEDULE_BREAK_DTL has failed@432 ");
							}
							if (pstmt!=null) pstmt.close();
						}	
						
						/*String category[]		        = new String[10];
						int    i						= 0;


						//String sql_max_num  = "select nvl(max(srl_no),0)+1 as maxnum from oa_clinic_schedule_dtl where  facility_id = ? and clinic_code =? and trunc(clinic_date)=to_date(?,'dd/mm/yyyy') and alcn_criteria=? and alcn_catg_code=?" ;
						
					//	pstmt_sql_max_num = con.prepareStatement(sql_max_num) ;

					//	String insertsql_OA_CLINIC_SCHEDULE_DTL = " insert into OA_CLINIC_SCHEDULE_DTL (facility_id, clinic_code,clinic_date,srl_no,practitioner_id,alcn_criteria,alcn_catg_code,max_patients,total_booked_patients,total_blocked_slots,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id ,care_locn_type_ind,resource_class) values ('"+facilityId+"',?,to_date(?,'dd/mm/yyyy'), ?,'"+practitioner_id+"','"+alcncriteria+"',?,?,0,0,'"+added_by_id+"',sysdate,'"+client_ip_address+"','"+facilityId+"','"+added_by_id+"',sysdate,'"+client_ip_address+"','"+facilityId+"','"+location_Type+"','"+resource_Type+"') ";    
						
						//	pstmt_insertsql_OA_CLINIC_SCHEDULE_DTL = con.prepareStatement(insertsql_OA_CLINIC_SCHEDULE_DTL);
								


						while(str.hasMoreTokens())
						{
							category[i] = str.nextToken();
							if (!(category[i].substring(0,2).equals("*O")))
							{
								java.util.StringTokenizer str1 	= new java.util.StringTokenizer(category[i],"~");
								cat_code		= str1.nextToken();
												  str1.nextToken();
								cat_code_value	= str1.nextToken();

							}
							else
							{
								java.util.StringTokenizer str2 	= new java.util.StringTokenizer(category[i],"~");
								cat_code		= str2.nextToken();
								cat_code_value  = str2.nextToken();			
							}
							i++;
							if (!(cat_code.equals("*O")))
							{
								
							if (alcncriteria.equals("PC"))
							  alcn_pat = Math.round((Integer.parseInt(cat_code_value)*Integer.parseInt(max_patients_per_day))/100);
							else
							  alcn_pat = Integer.parseInt(cat_code_value);

							 pat_rem = pat_rem - alcn_pat;
							}
							else
							  alcn_pat = pat_rem;
							
					
								
						}//end of while*/
					}
				}

				

				}
					

	if(insertable)
	{
	  
			java.util.StringTokenizer toks1 = new java.util.StringTokenizer (break_time_intervals,",") ;

			sql_oa_c_b  = "INSERT into oa_clinic_schedule_break (facility_id,clinic_code,clinic_date,day_no,srl_no,practitioner_id,break_start_time,break_end_time, added_by_id,added_date,added_at_ws_no,added_facility_id, modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,care_locn_type_ind,resource_class ) values (?,?,to_date(?,'dd/mm/yyyy') ,?,?,?,to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),?,sysdate,?,?,?,sysdate,?,?,?,?)";
			
			
			pstmt_new0 = con.prepareStatement(sql_oa_c_b);

			while (toks1.hasMoreTokens())
			{
				
				strVar = toks1.nextToken() ;
				strlen = strVar.length();
				if(strlen > 1)
				{
					break_start_time = strVar.substring(0,5) ;
					break_end_time = strVar.substring(5,strVar.length()) ;

							pstmt_new0.setString(1, facilityId);
							pstmt_new0.setString	( 2, clinic_code ) ;
							pstmt_new0.setString	( 3, clinic_date) ;
							pstmt_new0.setString	( 4, day_no) ;
							pstmt_new0.setInt	( 5,maxnum_sch_brk );
							pstmt_new0.setString	( 6, practitioner_id ) ;
							pstmt_new0.setString (7,break_start_time);
							pstmt_new0.setString( 8, break_end_time ) ;
							pstmt_new0.setString( 9, added_by_id ) ;
							pstmt_new0.setString( 10, client_ip_address ) ;
							pstmt_new0.setString( 11, facilityId ) ;
							pstmt_new0.setString( 12, added_by_id ) ;
							pstmt_new0.setString( 13, client_ip_address ) ;
							pstmt_new0.setString( 14, facilityId ) ;	
							pstmt_new0.setString( 15, location_Type ) ;	
							pstmt_new0.setString( 16, resource_Type ) ;	
					
						res = pstmt_new0.executeUpdate();
					if(res !=0)
					 insertable = true;
					else
					{
					 insertable = false;
					 sb.append(" Insert into OA_CLINIC_SCHEDULE_BREAK has failed ");
					}
					   maxnum_sch_brk++;
				}
			}

		 }

		 /*Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112*/
		 if (insertable)
		 {
			if(schedule_extend_yn.equals("Y"))
			{
				try{

					if(clblstmt!=null) clblstmt.close();

					clblstmt = con.prepareCall("{call oa_generate_schedule_extnd(?,?,?,?,?,?)}");

					clblstmt.setString( 1, facilityId);
					clblstmt.setString( 2, clinic_code);
					clblstmt.setString( 3, practitioner_id);
					clblstmt.setString( 4, clinic_date);
					clblstmt.setString( 5, time_table_type);
					clblstmt.setString( 6, "2");
			
					clblstmt.execute() ;

				}catch(Exception ex){
					ex.printStackTrace();
				}finally{
					try{
						if(clblstmt!=null)clblstmt.close();
					}catch(Exception ex){
						System.err.println("Exception in oa_generate_schedule_extnd - "+ex.getMessage());
						ex.printStackTrace();
					}
				}
			}
		 }
		 /*End NMC-JD-CRF-0112*/

		 /*Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1*/
		 if (insertable && isSlotStartMidEndAppl)
		 {
			try{

				if(clblstmt!=null) clblstmt.close();

				clblstmt = con.prepareCall("{call oa_schedule_external_ind(?,?,?,?)}");

				clblstmt.setString( 1, facilityId);
				clblstmt.setString( 2, clinic_code);
				clblstmt.setString( 3, practitioner_id);
				clblstmt.setString( 4, clinic_date);
		
				clblstmt.execute() ;

			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(clblstmt!=null)clblstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in oa_schedule_external_ind - "+ex.getMessage());
					ex.printStackTrace();
				}
			}
		 }
		 /*End ML-BRU-CRF-0628.1*/

		 MessageManager mess1 = new MessageManager();
		 if ( insertable )
		  {
			result = true ;
			con.commit();  

			 final java.util.Hashtable message = mess1.getMessage( locale,"RECORD_INSERTED","SM" ) ;
			 sbMessage.append( (String) message.get("message") );
			 message.clear();
		   }else
		   {
			 con.rollback();
			 sb.append("Transaction Failed");
			}
			
			if (rs1!=null) rs1.close();
			if (rs!=null) rs.close();
			if (rs_new!=null) rs_new.close();
			if (rs_other!=null) rs_other.close(); 
			if (rs_new!=null) rs_new.close();
			if (rs_other!=null) rs_other.close();
			if(stmt != null) stmt.close();
			if (pstmt!=null) pstmt.close();
			if(clblstmt!=null) clblstmt.close();
			if(calabl!=null) calabl.close();
			if (pstmt!=null) pstmt.close();
			if (pstmt1!=null) pstmt1.close();
			//if (pstmt_sql_max_num !=null) pstmt_sql_max_num.close();
			//if(pstmt_insertsql_OA_CLINIC_SCHEDULE_DTL !=null) pstmt_insertsql_OA_CLINIC_SCHEDULE_DTL.close();
			if(rss!=null) rss.close();
			if (pstmt_new0 !=null)pstmt_new0.close();
			
			tabdata.clear();	
	  }
	}
	  catch ( Exception e )
	  {
		 sb.append("Catch :"+e.toString());
		 insertable = false;
		 e.printStackTrace();
		
		 
	  }finally
	  {
		 if(con != null) ConnectionManager.returnConnection(con,p);
	  }
		 results.put("status",new Boolean(result));
		 results.put("error",sb.toString());
		 results.put("ResultFromMessageManager", sbMessage.toString());
		 sb.setLength(0);
		 sbMessage.setLength(0);
		 return results;
	}//Method

/**
* @ejb.interface-method
*	 view-type="both"
*/
public HashMap modifySetUpDailySchedule(Properties p,HashMap tabdata){
	HashMap results = new HashMap() ;
	StringBuffer sb  = new StringBuffer();
	StringBuffer sbMessage = new StringBuffer("");
	boolean result = false;
	int maxnum_sch=0;
	Connection  con =null;
	String speciality_code="";
	String schedule_status = "";//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	String clinic_code = (String)tabdata.get("clinic_code") ;
	String clinic_date = (String)tabdata.get("clinic_date") ;
	String practitioner_id = (String)tabdata.get("p_practitioner_id")==null?"":(String)tabdata.get("p_practitioner_id");
	String time_table_type = (String)tabdata.get("p_time_table_type") ;
	String remarks = (String)tabdata.get("p_remarks");
	String start_time = (String)tabdata.get("p_start_time");	
	String end_time = (String)tabdata.get("p_end_time");		
	String time_per_patient = (String)tabdata.get("p_time_per_patient");	
	String max_patients_per_day = (String)tabdata.get("p_max_patients_per_day");	
	String time_per_slab = (String)tabdata.get("p_time_per_slab");	
	String max_patients_per_slab = (String)tabdata.get("p_max_patients_per_slab");	
	String max_first_visits = (String)tabdata.get("p_max_first_visit")==null?"":(String)tabdata.get("p_max_first_visit");
	if(max_first_visits.equals("null")) max_first_visits = "";
	String max_over_bookings = (String)tabdata.get("p_max_over_bookings");
	String break_time_intervals = (String)tabdata.get("p_break_time_intervals");
	String final_string = (String)tabdata.get("final_string");
	String facilityId = (String)tabdata.get("added_facility_id");
	String modified_by_id = (String)tabdata.get("modified_by_id");
	String client_ip_address = (String)tabdata.get("modified_at_ws_no");
	String 	alcncriteria = (String)	tabdata.get("alcn_criteria");
	String insertdetail = (String)	tabdata.get("p_insert_detail");
	String 	finalvalues = (String)	tabdata.get("p_final_values");
	String 	p_max_other_visits = (String)	tabdata.get("p_max_other_visits");	
	String 	p_max_slots_per_day = (String)	tabdata.get("p_max_slots_per_day");
	
	String no_of_forced_booking=(String)tabdata.get("no_of_forced_booking");
	String no_of_global_booking=(String)tabdata.get("no_of_global_booking");
	String location_Type = (String)tabdata.get("location_Type") ;
	String resource_Type = (String)tabdata.get("resource_Type") ;
	String max_new_patients=(String)tabdata.get("max_new_patients");
	String max_old_patients=(String)tabdata.get("max_old_patients");

	//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	String schedule_extend_yn = (String)tabdata.get("schedule_extend_yn");

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	Boolean isSlotStartMidEndAppl = false; 
	String ext_all_slots_yn = (String)tabdata.get("ext_all_slots_yn");
	String ext_start_slots = (String)tabdata.get("ext_start_slots");
	String ext_mid_slots = (String)tabdata.get("ext_mid_slots");
	String ext_end_slots = (String)tabdata.get("ext_end_slots");

	String locale = p.getProperty("LOCALE");
	java.util.ArrayList arrlst_brk = new java.util.ArrayList() ;
	java.util.StringTokenizer toks = new java.util.StringTokenizer (break_time_intervals,",") ;
	String strVar = "" ;
	String day_no ="";
	String res_type="";
	String from="";
	String to="";
	String dur="";
	int res=0;
	int others=0;
	boolean updatable = true;
	try{
		con= ConnectionManager.getConnection(p);

		isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1



		/*
		

		sql  = "select nvl(max(srl_no),0) as maxnum from oa_clinic_schedule where  facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and trunc(clinic_date)=to_date('"+clinic_date+"','dd/mm/yyyy')" ;
		if(pstmt!=null) pstmt.close();
	    pstmt = con.prepareStatement(sql);
		rs   = pstmt.executeQuery();
		while(rs !=null && rs.next()){
			maxnum_sch = rs.getInt("maxnum") ;			
		}
		if (rs !=null) rs.close();
		if (pstmt !=null) pstmt.close();
		//Double Dfr=new Double("");
		//Double Dto=new Double("");
		sql = "select to_char(to_date('"+clinic_date+"','dd/mm/yyyy'),'d') from dual ";
		pstmt = con.prepareStatement(sql);
		rs   = pstmt.executeQuery();
		while( rs !=null && rs.next()){
			day_no= rs.getString(1);
		}
		if (rs !=null) rs.close();
		
		sql="select decode('"+time_table_type+"','1',To_Char (to_date('"+start_time+"','hh24:mi')+to_number((nvl(to_char(to_date('"+time_per_patient+"','hh24:mi'),'hh24'),0) * 60 + nvl(to_char(to_date('"+time_per_patient+"','hh24:mi'),'mi'),0))/1440),'hh24:mi'),'2',To_Char(to_date('"+start_time+"','hh24:mi')+to_number((nvl(to_char(to_date('"+time_per_slab+"','hh24:mi'),'hh24'),0) * 60 + nvl(to_char(to_date('"+time_per_slab+"','hh24:mi'),'mi'),0))/1440),'hh24:mi'),To_Char(to_date('"+end_time+"','hh24:mi'),'hh24:mi')) endtime1	from dual";
		if (pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(sql) ;
		rs   = pstmt.executeQuery();
		while(rs.next()){
			min_slot_slab_end_time = rs.getString("endtime1");
		}
		if(rs !=null) rs.close();

		The above queries are merged with below query for PE by Suresh M on 24/06/2010		
		*/
		String min_slot_slab_end_time="";
		try{
			if(pstmt != null)pstmt.close();
			if(rs != null)rs.close();	

			sql  = "select (select nvl(max(srl_no),0) from oa_clinic_schedule where  facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and trunc(clinic_date)=to_date('"+clinic_date+"','dd/mm/yyyy')) maxnum,decode('"+time_table_type+"','1',To_Char (to_date('"+start_time+"','hh24:mi')+to_number((nvl(to_char(to_date('"+time_per_patient+"','hh24:mi'),'hh24'),0) * 60 + nvl(to_char(to_date('"+time_per_patient+"','hh24:mi'),'mi'),0))/1440),'hh24:mi'),'2',To_Char(to_date('"+start_time+"','hh24:mi')+to_number((nvl(to_char(to_date('"+time_per_slab+"','hh24:mi'),'hh24'),0) * 60 + nvl(to_char(to_date('"+time_per_slab+"','hh24:mi'),'mi'),0))/1440),'hh24:mi'),To_Char(to_date('"+end_time+"','hh24:mi'),'hh24:mi')) endtime1,to_char(to_date('"+clinic_date+"','dd/mm/yyyy'),'d') day_no,speciality_code from op_clinic where  facility_id= '"+facilityId+"' and clinic_code='"+clinic_code+"'";
			
			pstmt = con.prepareStatement(sql) ;
			rs   = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				maxnum_sch = rs.getInt("maxnum") ;		
				speciality_code=rs.getString("speciality_code");
				day_no= rs.getString("day_no");
				min_slot_slab_end_time = rs.getString("endtime1");
			}
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		if(updatable){
			if(!time_table_type.equals("2")){
				sql="Update oa_clinic_schedule Set remarks =?,start_time  =to_date('"+start_time+"','hh24:mi'),end_time   =to_date('"+end_time+"','hh24:mi'),time_per_patient =to_date('"+time_per_patient+"','hh24:mi'),max_patients_per_day ='"+max_patients_per_day+"',time_per_slab    =to_date('"+time_per_slab+"','hh24:mi'),max_patients_per_slab ='"+max_patients_per_slab+"', max_first_visits  ='"+max_first_visits+"',max_over_booking ='"+max_over_bookings+"', max_other_visits ='"+p_max_other_visits+"',max_slots_per_day ='"+p_max_slots_per_day+"', modified_by_id ='"+modified_by_id+"',modified_date = sysdate, modified_at_ws_no ='"+client_ip_address+"', modified_facility_id ='"+facilityId +"' ,MAX_FORCED_IN_BOOKING ='"+no_of_forced_booking +"' ,MAX_GLOBAL_BOOKING ='"+no_of_global_booking +"',MIN_SLOT_SLAB_START_TIME=to_date('"+start_time+"','hh24:mi'),MIN_SLOT_SLAB_END_TIME=to_date('"+min_slot_slab_end_time+"','hh24:mi'),SPECIALITY_CODE='"+speciality_code+"',MAX_NEW_PATIENTS='"+max_new_patients+"' ,MAX_OLD_PATIENTS='"+max_old_patients+"', schedule_extend_yn='"+schedule_extend_yn+"', ext_all_slots_yn='"+ext_all_slots_yn+"', ext_start_slots='"+ext_start_slots+"', ext_mid_slots='"+ext_mid_slots+"', ext_end_slots='"+ext_end_slots+"' where facility_id='"+facilityId+"' and  Clinic_code='"+clinic_code+"' and Clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy') and Nvl(Practitioner_id,'X')= nvl( '"+practitioner_id+"','X') and care_locn_type_ind='"+location_Type+"'  and resource_class='"+resource_Type+"' ";
			}else{
				sql="Update oa_clinic_schedule Set remarks =?,start_time  =to_date('"+start_time+"','hh24:mi'),end_time   =to_date('"+end_time+"','hh24:mi'),time_per_patient =to_date('"+time_per_patient+"','hh24:mi'),max_patients_per_day ='"+max_patients_per_day+"',time_per_slab    =to_date('"+time_per_slab+"','hh24:mi'),max_patients_per_slab ='"+max_patients_per_slab+"', max_first_visits  ='"+max_first_visits+"',max_over_booking ='"+max_over_bookings+"', max_other_visits ='"+p_max_other_visits+"',max_slots_per_day ='"+p_max_slots_per_day+"', modified_by_id ='"+modified_by_id+"',modified_date = sysdate, modified_at_ws_no ='"+client_ip_address+"', modified_facility_id ='"+facilityId +"' ,MAX_FORCED_IN_BOOKING ='"+no_of_forced_booking +"' ,MAX_GLOBAL_BOOKING ='"+no_of_global_booking +"',MIN_SLOT_SLAB_START_TIME=to_date('"+start_time+"','hh24:mi'),MIN_SLOT_SLAB_END_TIME=to_date('"+min_slot_slab_end_time+"','hh24:mi'),SPECIALITY_CODE='"+speciality_code+"' ,MAX_NEW_PATIENTS='"+max_new_patients+"' ,MAX_OLD_PATIENTS='"+max_old_patients+"', schedule_extend_yn='"+schedule_extend_yn+"', ext_all_slots_yn='"+ext_all_slots_yn+"', ext_start_slots='"+ext_start_slots+"', ext_mid_slots='"+ext_mid_slots+"', ext_end_slots='"+ext_end_slots+"' where facility_id='"+facilityId+"' and  Clinic_code='"+clinic_code+"' and Clinic_date =to_date('"+clinic_date+"','dd/mm/yyyy') and Nvl(Practitioner_id,'X')= nvl( '"+practitioner_id+"','X') and care_locn_type_ind='"+location_Type+"'  and resource_class='"+resource_Type+"' ";
			}
			if (pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement(sql) ;
			pstmt.setString	( 1, remarks) ;
			res =pstmt.executeUpdate();
			if(res !=0){
				updatable = true;
			}else{
				updatable = false;
				sb.append(" update in OA_CLINIC_SCHEDULE has failed ");
			}

			if(updatable){
				//sql="delete from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"', 'dd/mm/yyyy') and  nvl(practitioner_id,'X') =nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+location_Type+"' and nvl(schedule_status,'x')=nvl('','x') and resource_class='"+resource_Type+"'";
				
				//Modified by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				sql="delete from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"', 'dd/mm/yyyy') and  nvl(practitioner_id,'X') =nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+location_Type+"' and resource_class='"+resource_Type+"'";

				if (pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql) ;
				res =pstmt.executeUpdate();			
				sql  = "select nvl(max(srl_no),0)+1 as maxnum from oa_clinic_schedule_slot_slab  where  facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and trunc(clinic_date)=to_date('"+clinic_date+"','dd/mm/yyyy')" ;
				if (pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql) ;
				rss=null;
				rss   = pstmt.executeQuery();
				int maxsrlNo=1;
				if(rss!=null){
					while (rss.next()){
						maxsrlNo = rss.getInt("maxnum") ;
					}	
				}
				if(rss !=null) rss.close();
				if(resource_Type.equals("P")){
					sql  = "select pract_type res_type from am_practitioner where nvl(practitioner_id,'x')=nvl('"+practitioner_id+"','x')" ;			
				}else if(resource_Type.equals("R")){
					sql  = "select room_type res_type from am_facility_room where nvl(room_num,'x')=nvl('"+practitioner_id+"','x') and OPERATING_FACILITY_ID='"+facilityId+"'" ;
				}else{
					sql  = "select resource_type res_type from am_resource where nvl(resource_id,'x')=nvl('"+practitioner_id+"','x') and facility_id= '"+facilityId+"' and resource_Class='"+resource_Type+"'" ;
				}
				if (pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql) ;
				rss   = pstmt.executeQuery();
				while (rss.next()){
					res_type = rss.getString("res_type") ;
				}	
				java.util.StringTokenizer toks1 = new java.util.StringTokenizer (break_time_intervals,",") ;
				int strlen=0;
				while(toks1.hasMoreTokens()){
					strVar = toks1.nextToken() ;
					strlen = strVar.length();
					if(strlen > 1){
						arrlst_brk.add(strVar.substring(0,5)) ;
						arrlst_brk.add(strVar.substring(5,strVar.length())) ;
					}
				}
				//	Double Dfr=new Double("");
				//	Double Dto=new Double("");
				if(time_table_type.equals("1")){
					from=start_time;
					to=end_time;
					dur=time_per_patient;            
                    int i_from=(Integer.parseInt(from.substring(0,2))*60)+Integer.parseInt(from.substring(3));
					int i_to=(Integer.parseInt(to.substring(0,2))*60)+Integer.parseInt(to.substring(3));
					int i_dur=(Integer.parseInt(dur.substring(0,2))*60)+Integer.parseInt(dur.substring(3));
					
					//schedule_status Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
                    String sql_oa_clinic_schedule_slot_slab  ="INSERT into oa_clinic_schedule_slot_slab ( facility_id,care_locn_type_ind,clinic_code,clinic_date,srl_no,resource_class,resource_type,practitioner_id,time_table_type,slot_slab_start_time,slot_slab_end_time,available_appts,added_by_id,added_date ,added_at_ws_no ,added_facility_id,modified_by_id,modified_date , modified_at_ws_no , modified_facility_id,SPECIALITY_CODE,schedule_status) values ( ?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),1,?,sysdate,?,?,?,sysdate, ?,?,?,?)";
					pstmt_new3 = con.prepareStatement(sql_oa_clinic_schedule_slot_slab);

					int ij = 0;

					for (int ip=i_from;ip<i_to;ip+=i_dur){
							int i_to_temp=ip+i_dur;
					
							boolean brk_flg=false;
						
						//Modified by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
						//for(int ij=0;ij<arrlst_brk.size();ij+=2)
						if(ij<arrlst_brk.size())
						{
							String frmbrk=(String) arrlst_brk.get(ij);
							String tobrk=(String) arrlst_brk.get(ij+1);
							int br_frm=(Integer.parseInt(frmbrk.substring(0,2))*60)+Integer.parseInt(frmbrk.substring(3));
							int br_to=(Integer.parseInt(tobrk.substring(0,2))*60)+Integer.parseInt(tobrk.substring(3));
							
							if(ip >= br_frm &&  i_to_temp<=br_to)
							{
								//Modified by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
								//brk_flg=true;
								schedule_status = "X";
								ij+=2;
							}else
							{
								schedule_status = "";
							}
						}else
						{
							schedule_status = "";
						}
                  
					if(! brk_flg)
					{
                        DecimalFormat decim = new DecimalFormat("0.00"); //Added by munisekhar for IN35356 on Thursday, Sep 27, 2012				 		
						double mod_fr=ip % 60;
						int mod_fr1 = (int)mod_fr; //Added by munisekhar for IN35356 on Thursday, Sep 27, 2012
						double mod_to=i_to_temp % 60;
					    int mod_to1 = (int)mod_to; //Added by munisekhar for IN35356 on Thursday, Sep 27, 2012
						double ret_fr1=(ip/60) + (mod_fr/100);
						Double ret_fr = Double.parseDouble(decim.format(ret_fr1)); //Added by munisekhar for IN35356 on Thursday, Sep 27, 201
						double ret_to1=(i_to_temp/60) + (mod_to/100) ;
						Double ret_to = Double.parseDouble(decim.format(ret_to1)); //Added by munisekhar for IN35356 on Thursday, Sep 27, 2012
                       
								 

						// Dfr=new Double(ret_fr);
						// Dto=new Double(ret_to);

						String SDfr=new Double(ret_fr).toString();
						String SDto=new Double(ret_to).toString();
						 						 
						 StringTokenizer SDfrtoken=new StringTokenizer(SDfr,".");
						 String SDfr1=SDfrtoken.nextToken();
						 String SDfr2=SDfrtoken.nextToken();
						 int SDfr1int1=Integer.parseInt(SDfr1);
						 int SDfr1int2=Integer.parseInt(SDfr2);
						  if(SDfr1int1>9 && SDfr1int2>9){
							 SDfr=Integer.toString(SDfr1int1)+":"+Integer.toString(SDfr1int2);
						//modified by munisekhar for IN35356 on Thursday, Sep 27, 2012	   
						  }else if(SDfr1int1<=9 && SDfr1int2 <=9 && mod_fr1 >9){
							   SDfr="0"+Integer.toString(SDfr1int1)+":"+Integer.toString(SDfr1int2)+"0";
							    
						  }else if(SDfr1int1<=9 && SDfr1int2 <=9 && mod_fr1 <=9){
							   SDfr="0"+Integer.toString(SDfr1int1)+":"+"0"+Integer.toString(SDfr1int2);
						//End of IN35356 
						
						  }else if(SDfr1int1<=9 && SDfr1int2 >9){
							   SDfr="0"+Integer.toString(SDfr1int1)+":"+Integer.toString(SDfr1int2);
						//modified by munisekhar for IN35356 on Thursday, Sep 27, 2012    
						  }else if(SDfr1int1>9 && SDfr1int2 <=9 && mod_fr1 >9){
							   SDfr=Integer.toString(SDfr1int1)+":"+Integer.toString(SDfr1int2)+"0";
							   
						  }else if(SDfr1int1>9 && SDfr1int2 <=9 && mod_fr1 <=9){
							   SDfr=Integer.toString(SDfr1int1)+":"+"0"+Integer.toString(SDfr1int2);
							   }
							//End of IN35356   
						 StringTokenizer SDtotoken=new StringTokenizer(SDto,".");
						 String SDto1=SDtotoken.nextToken();
						 String SDto2=SDtotoken.nextToken();
						 						 
						 int SDtoint1=Integer.parseInt(SDto1);
	   				     int SDtoint2=Integer.parseInt(SDto2);
	
	
						  if(SDtoint1>9 && SDtoint2>9){
							  SDto=Integer.toString(SDtoint1)+":"+Integer.toString(SDtoint2);
							//modified by munisekhar for IN35356 on Thursday, Sep 27, 2012
						  }else if(SDtoint1<=9 && SDtoint2 <=9 && mod_to1 >9){
							   SDto="0"+Integer.toString(SDtoint1)+":"+Integer.toString(SDtoint2)+"0";
							   
						  }else if(SDtoint1<=9 && SDtoint2 <=9  && mod_to1 <=9){
							   SDto="0"+Integer.toString(SDtoint1)+":"+"0"+Integer.toString(SDtoint2);
							  //End of IN35356   
						  }else if(SDtoint1<=9 && SDtoint2 >9){
							   SDto="0"+Integer.toString(SDtoint1)+":"+Integer.toString(SDtoint2);
							  //Added by munisekhar for IN35356 on Thursday, Sep 27, 2012
						  }else if(SDtoint1>9 && SDtoint2 <=9 && mod_to1 >9){
							   SDto=Integer.toString(SDtoint1)+":"+Integer.toString(SDtoint2)+"0";
							  
						  }else if(SDtoint1>9 && SDtoint2 <=9 && mod_to1 <=9){
							   SDto=Integer.toString(SDtoint1)+":"+"0"+Integer.toString(SDtoint2);
							  
						  }
						  //End of IN35356 
						  
						 

						/*if(SDfr.length()==3)
							{
							SDfr="0"+SDfr.substring(0,1)+SDfr.substring(2)+"0";
							SDfr=SDfr.substring(0,2)+":"+SDfr.substring(2);
							}

						if(SDto.length()==3)
							{
							SDto="0"+SDto.substring(0,1)+SDto.substring(2)+"0";
							SDto=SDto.substring(0,2)+":"+SDto.substring(2);

							}

						if(SDfr.length()==4)
							{
							SDfr=SDfr.substring(0,2)+":"+SDfr.substring(3);
							SDfr=SDfr+"0";
							}

						if(SDto.length()==4)
							{
							SDto=SDto.substring(0,2)+":"+SDto.substring(3);
							SDto=SDto+"0";

							}*/
						
							
							
							pstmt_new3.setString(1, facilityId);
							pstmt_new3.setString	( 2, location_Type ) ;
							pstmt_new3.setString	( 3, clinic_code) ;
							pstmt_new3.setString	( 4, clinic_date) ;
							pstmt_new3.setInt	( 5,maxsrlNo );
							pstmt_new3.setString	( 6, resource_Type ) ;
							pstmt_new3.setString (7,res_type);
							pstmt_new3.setString( 8, practitioner_id ) ;
							pstmt_new3.setString( 9, time_table_type ) ;
							pstmt_new3.setString( 10, SDfr ) ;
							pstmt_new3.setString( 11, SDto ) ;
							pstmt_new3.setString( 12, modified_by_id ) ;
							pstmt_new3.setString( 13, client_ip_address ) ;
							pstmt_new3.setString( 14, facilityId ) ;	
							pstmt_new3.setString( 15, modified_by_id ) ;	
							pstmt_new3.setString( 16, client_ip_address ) ;	
							pstmt_new3.setString( 17, facilityId ) ;	
							pstmt_new3.setString( 18, speciality_code ) ;	
							pstmt_new3.setString( 19, schedule_status ) ;//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
						   

							res = pstmt_new3.executeUpdate();
							

						if(res !=0){
							updatable = true;
						}else{
							updatable = false;
							sb.append(" Insert into OA_CLINIC_SCHEDULE_SLOT_SLAB has failed ");
						}
						maxsrlNo++;
					}//if loop

				}// for loop

			}else if (time_table_type.equals("2"))
			{

				from=start_time;
				to=end_time;
				dur=time_per_slab;
				int max_pat_slab=Integer.parseInt(max_patients_per_slab);
				int i_from=(Integer.parseInt(from.substring(0,2))*60)+Integer.parseInt(from.substring(3));
				int i_to=(Integer.parseInt(to.substring(0,2))*60)+Integer.parseInt(to.substring(3));
				int i_dur=(Integer.parseInt(dur.substring(0,2))*60)+Integer.parseInt(dur.substring(3));				
				
				//schedule_status Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				String sql_oa_clinic_schedule_slot_slab_1  ="INSERT into oa_clinic_schedule_slot_slab ( facility_id,care_locn_type_ind,clinic_code,clinic_date,srl_no,resource_class,resource_type,practitioner_id,time_table_type,slot_slab_start_time,slot_slab_end_time,available_appts,added_by_id,added_date ,added_at_ws_no ,added_facility_id,modified_by_id,modified_date , modified_at_ws_no , modified_facility_id,SPECIALITY_CODE,schedule_status) values(?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,to_date(?,'hh24:mi'),to_date(?,'hh24:mi'),1,?,sysdate,?,?,?,sysdate,?,?,?,?)";

				pstmt_new4 = con.prepareStatement(sql_oa_clinic_schedule_slot_slab_1);

				int ij = 0;

				for (int ip=i_from;ip<i_to;ip+=i_dur){

				for(int xy=0;xy<max_pat_slab;xy++)
				{
						int i_to_temp=ip+i_dur;
						boolean brk_flg=false;
					
					//Modified by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
					//for(int ij=0;ij<arrlst_brk.size();ij+=2)

					if(ij<arrlst_brk.size())
					{
							String frmbrk=(String) arrlst_brk.get(ij);
							String tobrk=(String) arrlst_brk.get(ij+1);
							int br_frm=(Integer.parseInt(frmbrk.substring(0,2))*60)+Integer.parseInt(frmbrk.substring(3));
							int br_to=(Integer.parseInt(tobrk.substring(0,2))*60)+Integer.parseInt(tobrk.substring(3));
					
							if(ip >= br_frm &&  i_to_temp<=br_to)
							{
								//Modified by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
								//brk_flg=true;
								schedule_status = "X";

							}else
							{
								schedule_status = "";
							}
					 }else
					 {
						 schedule_status = "";
					 }
					 
						if(! brk_flg)
						{
						  double mod_fr=ip % 60;
						  double mod_to=i_to_temp % 60;
						  double ret_fr=(ip/60) + (mod_fr/100);
						  double ret_to=(i_to_temp/60) + (mod_to/100) ;
						  int a=0;
						  int b=0;
									
						 //  Dfr=new Double(ret_fr);
						//  Dto=new Double(ret_to);

						  String SDfr=new Double(ret_fr).toString();
						  String SDto=new Double(ret_to).toString(); 

										
						if(SDfr.length()==5) //Added by S.Sathish for IN020308 on Thursday, April 01, 2010
						{							
							SDfr=SDfr.substring(0,2)+":"+SDfr.substring(3,5);							  
						}

						if(SDto.length()==5) //Added by S.Sathish for IN020308 on Thursday, April 01, 2010
						{							
							SDto=SDto.substring(0,2)+":"+SDto.substring(3,5);							  
						}
						
						if(SDfr.length()==3)
							{
							SDfr="0"+SDfr.substring(0,1)+SDfr.substring(2)+"0";
							SDfr=SDfr.substring(0,2)+":"+SDfr.substring(2);
							}

						if(SDto.length()==3)
							{
							SDto="0"+SDto.substring(0,1)+SDto.substring(2)+"0";
							SDto=SDto.substring(0,2)+":"+SDto.substring(2);
							}

						if(SDfr.length()==4)
						{
							   a=SDfr.indexOf("."); //Added by S.Sathish for IN020308 on Thursday, April 01, 2010 starts here
							   b=SDfr.substring(a+1,SDfr.length()).length();
							   if(b==2){
								   SDfr="0"+SDfr.substring(0,1)+SDfr.substring(2,4);
								   SDfr=SDfr.substring(0,2)+":"+SDfr.substring(2,4); //Ends here
							   }else{								
									SDfr=SDfr.substring(0,2)+":"+SDfr.substring(3);
									SDfr=SDfr+"0";
							   }
						}

						if(SDto.length()==4)
						{
							   a=SDto.indexOf("."); //Added by S.Sathish for IN020308 on Thursday, April 01, 2010 starts here
							   b=SDto.substring(a+1,SDto.length()).length();
							   if(b==2){
								   SDto="0"+SDto.substring(0,1)+SDto.substring(2,4);
								   SDto=SDto.substring(0,2)+":"+SDto.substring(2,4); //Ends here
							   }else{								
									SDto=SDto.substring(0,2)+":"+SDto.substring(3);
									SDto=SDto+"0";
							   }							
						}		
 


								
							pstmt_new4.setString(1, facilityId);
							pstmt_new4.setString	( 2, location_Type ) ;
							pstmt_new4.setString	( 3, clinic_code) ;
							pstmt_new4.setString	( 4, clinic_date) ;
							pstmt_new4.setInt	( 5,maxsrlNo );
							pstmt_new4.setString	( 6, resource_Type ) ;
							pstmt_new4.setString (7,res_type);
							pstmt_new4.setString( 8, practitioner_id ) ;
							pstmt_new4.setString( 9, time_table_type ) ;
							pstmt_new4.setString( 10, SDfr ) ;
							pstmt_new4.setString( 11, SDto ) ;
							pstmt_new4.setString( 12, modified_by_id ) ;
							pstmt_new4.setString( 13, client_ip_address ) ;
							pstmt_new4.setString( 14, facilityId ) ;	
							pstmt_new4.setString( 15, modified_by_id ) ;	
							pstmt_new4.setString( 16, client_ip_address ) ;	
							pstmt_new4.setString( 17, facilityId ) ;
							pstmt_new4.setString( 18, speciality_code ) ;
							pstmt_new4.setString( 19, schedule_status ) ;//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
							

						res = pstmt_new4.executeUpdate();
						if(res !=0){
							updatable = true;
						}else{
							updatable = false;
							sb.append(" Insert into OA_CLINIC_SCHEDULE_SLOT_SLAB has failed ");
						}

						maxsrlNo++;
					}//if loop

				}// slab loop(outer for loop)
											 
						//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
						if(schedule_status.equals("X")){
							ij+=2;
						}

						}//loop
					}


				}// end insertable


				// slot_slab

			if(insertdetail.equals("Y"))
			{
		

				StringTokenizer st = new StringTokenizer(finalvalues,"#");
				while(st.hasMoreTokens())
				{
					String str = st.nextToken();
					StringTokenizer st1 = new StringTokenizer(str,"`");
					while(st1.hasMoreTokens())
					{
						String finalslots   = st1.nextToken();
						alcncriteria        = st1.nextToken();
						st1.nextToken();
						String slots        = st1.nextToken();
						String incdec       = st1.nextToken();
						 st1.nextToken();
						 st1.nextToken();
						int maxpat = 0; 
						if(incdec.equalsIgnoreCase("Increased"))
							maxpat = Integer.parseInt(finalslots)+Integer.parseInt(slots);
						else
							maxpat = Integer.parseInt(finalslots)-Integer.parseInt(slots);
						
					

					}//while loop
				}//while loop
			}// if loop
			else 	if(insertdetail.equals("A"))
			{
			  if (finalvalues.equals(""))
			  {
					  
			  }
			  else
			  {			
	
				
				others = Integer.parseInt(max_patients_per_day);


		
																				
				StringTokenizer st = new StringTokenizer(finalvalues,"|");
				while(st.hasMoreTokens())
				{
					String str = st.nextToken();
					StringTokenizer st1 = new StringTokenizer(str,"~");
					while(st1.hasMoreTokens())
					{
						st1.nextToken();
											  st1.nextToken();
						String slots        = st1.nextToken();
						st1.nextToken();
						st1.nextToken();
						others = others-Integer.parseInt(slots);
				
					}//while loop
				}//while loop
			   
				sb.append(others);
						
			}
		}
			
	  }


	  // Added on 12/24/2008
	  if(!final_string.equals("") && !final_string.equals("null")) 
		{		  

					if (updatable)
					{

						sql=" Delete from oa_clinic_Schedule_dtl where  nvl('"+practitioner_id+"','X') = nvl('','X') and  facility_id= '"+facilityId+"' and Clinic_code='"+clinic_code+"' and Clinic_date =to_date('"+clinic_date+"', 'dd/mm/yyyy') ";

						if (pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement(sql) ;
						res =pstmt.executeUpdate();


						//pat_rem = Integer.parseInt(max_patients_per_day);    
						java.util.StringTokenizer str 	= new java.util.StringTokenizer(final_string,"|");
						while(str.hasMoreTokens()){
							String s1=str.nextToken();
							java.util.StringTokenizer str1= new java.util.StringTokenizer(s1,"$");
							while(str1.hasMoreTokens()){
								String sts_grp_code=str1.nextToken();
								if(sts_grp_code.equalsIgnoreCase("OTH"))
								{
									sts_grp_code ="*O";
								}
								int str_grp = 0;
								String sts_grp_slt_No=str1.nextToken();
								str_grp = Integer.parseInt(sts_grp_slt_No);

								str1.nextToken();
									
							
							String new_insert_sql = "INSERT INTO oa_clinic_Schedule_dtl(facility_id,clinic_code,clinic_date,srl_no,alcn_criteria,alcn_catg_code,practitioner_id,max_patients, total_booked_patients,total_blocked_slots,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) values('"+facilityId+"','"+clinic_code+"',to_date('"+clinic_date+"','dd/mm/yyyy'),"+maxnum_sch+",'"+alcncriteria+"','"+sts_grp_code+"','"+practitioner_id+"',"+str_grp+",0,0,'"+modified_by_id+"',sysdate,'"+client_ip_address+"','"+facilityId+"','"+modified_by_id+"',sysdate,'"+client_ip_address+"','"+facilityId+"')";

								

						     int res_new = 0;
                         	if (pstmt!=null) pstmt.close();

							pstmt = con.prepareStatement(new_insert_sql);
							res_new = pstmt.executeUpdate();

							if(res_new !=0){
                                updatable = true;
							}
							else{
								sb.append(" Insert into OA_CLINIC_SCHEDULE_BREAK_DTL has failed@432 ");
							}
						}	
						
					
					}
				}

				

				}
		  //Added on 12/24/2008
		
	if (updatable)
	{
	   
				sql=" Delete from oa_clinic_schedule_break where  facility_id= '"+facilityId+"' and Clinic_code='"+clinic_code+"' and Clinic_date =to_date('"+clinic_date+"', 'dd/mm/yyyy')  and Nvl(Practitioner_id,'X')= nvl( '"+practitioner_id+"','X') and care_locn_type_ind='"+location_Type+"'  and resource_class='"+resource_Type+"'";
				
				if (pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql) ;
				res =pstmt.executeUpdate();
				if(pstmt!=null)pstmt.close();

			
		  }
	if (updatable)
	{
			  int maxnum=0;
		
			sql  = "select nvl(max(srl_no),0)+1 as maxnum from oa_clinic_schedule_break where  facility_id = '"+facilityId+"' and clinic_code = '"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"','dd/mm/yyyy') ";
			if (pstmt!=null) pstmt.close();	
			pstmt = con.prepareStatement(sql) ;
			rs=pstmt.executeQuery() ;
			if (rs.next())
			{
				maxnum = rs.getInt("maxnum") ;
			}
			String break_end_time="";
			String break_start_time ="";
			
			sql  = "insert into oa_clinic_schedule_break(facility_id,clinic_code,clinic_date,day_no,srl_no,practitioner_id,break_start_time,break_end_time,added_by_id,added_date,added_at_ws_no,added_facility_id, modified_by_id, modified_date,modified_at_ws_no,modified_facility_id,care_locn_type_ind,resource_class)values(?,?,to_date(?,'dd/mm/yyyy') ,?,?,?,to_date(?,'hh24:mi'), to_date(?,'hh24:mi'),?, sysdate,?,?,?,sysdate,?,?,?,? )";

					pstmt_new2 = con.prepareStatement(sql);

			while (toks.hasMoreTokens())
			{
				strVar = toks.nextToken() ;
				if( strVar.length() > 1)
				 {
					break_start_time = strVar.substring(0,5) ;
					break_end_time = strVar.substring(5,strVar.length()) ;

							pstmt_new2.setString(1, facilityId);
							pstmt_new2.setString	( 2, clinic_code ) ;
							pstmt_new2.setString	( 3, clinic_date) ;
							pstmt_new2.setString	( 4, day_no) ;
							pstmt_new2.setInt		( 5,maxnum );
							pstmt_new2.setString	( 6, practitioner_id ) ;
							pstmt_new2.setString (7,break_start_time);
							pstmt_new2.setString( 8, break_end_time ) ;
							pstmt_new2.setString( 9, modified_by_id ) ;
							pstmt_new2.setString( 10, client_ip_address ) ;
							pstmt_new2.setString( 11, facilityId ) ;
							pstmt_new2.setString( 12, modified_by_id ) ;
							pstmt_new2.setString( 13, client_ip_address ) ;
							pstmt_new2.setString( 14, facilityId ) ;
							pstmt_new2.setString( 15, location_Type ) ;	
							pstmt_new2.setString( 16, resource_Type ) ;	
							
				
							res = pstmt_new2.executeUpdate();

					if(res !=0)
						updatable = true;
					else
						{
							updatable = false;
							sb.append(" Insert into OA_CLINIC_SCHEDULE_BREAK has failed ");
						}
						maxnum++;
					}//while loop
				}//if loop
			
			
			
		  }

		/*Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112*/
		if (updatable)
		{
			if(schedule_extend_yn.equals("Y"))
			{
				try{

					if(clblstmt!=null) clblstmt.close();

					clblstmt = con.prepareCall("{call oa_generate_schedule_extnd(?,?,?,?,?,?)}");

					clblstmt.setString( 1, facilityId);
					clblstmt.setString( 2, clinic_code);
					clblstmt.setString( 3, practitioner_id);
					clblstmt.setString( 4, clinic_date);
					clblstmt.setString( 5, time_table_type);
					clblstmt.setString( 6, "2");

					clblstmt.execute() ;

				}catch(Exception ex){
					ex.printStackTrace();
				}finally{
					try{
						if(clblstmt!=null)clblstmt.close();
					}catch(Exception ex){
						System.err.println("Exception in oa_generate_schedule_extnd - "+ex.getMessage());
						ex.printStackTrace();
					}
				}
			}
		}
		/*End NMC-JD-CRF-0112*/

		/*Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1*/
		 if (updatable && isSlotStartMidEndAppl)
		 {
			try{

				if(clblstmt!=null) clblstmt.close();

				clblstmt = con.prepareCall("{call oa_schedule_external_ind(?,?,?,?)}");

				clblstmt.setString( 1, facilityId);
				clblstmt.setString( 2, clinic_code);
				clblstmt.setString( 3, practitioner_id);
				clblstmt.setString( 4, clinic_date);
		
				clblstmt.execute() ;

			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(clblstmt!=null)clblstmt.close();
				}catch(Exception ex){
					System.err.println("Exception in oa_schedule_external_ind - "+ex.getMessage());
					ex.printStackTrace();
				}
			}
		 }
		 /*End ML-BRU-CRF-0628.1*/
		
		MessageManager mess1 = new MessageManager();
		
			if ( updatable )
			{
			result = true ;
			con.commit();
			final java.util.Hashtable message = mess1.getMessage( locale,"RECORD_MODIFIED","SM" ) ;
			sbMessage.append( (String) message.get("message") );
			 message.clear();
			}
			else
			{
			con.rollback();
			sb.append("Transaction Failed");
			}
			if(rs !=null) rs.close();
			if (rs_new!=null) rs_new.close();
			if (rs_other!=null) rs_other.close();
			if(rs!=null) rs.close();
			if(rss!=null) rss.close();
			if(pstmt !=null) pstmt.close();
			if(pstmt_new3!=null) pstmt_new3.close();
			if (pstmt!=null) pstmt.close();
			if(pstmt_new3!=null) pstmt_new3.close();
			if(pstmt !=null) pstmt.close();
			if (pstmt_new4 !=null) pstmt_new4.close();
			if (pstmt_new !=null) pstmt_new.close();
			if (pstmt_new1 !=null) pstmt_new1.close();
			if (pstmt_new2 !=null) pstmt_new2.close();
			if(clblstmt!=null)clblstmt.close();
		
			tabdata.clear();
			arrlst_brk.clear();
		}	
		catch ( Exception e )
		{
			updatable= false;
			e.printStackTrace();
		  sb.append("Catch :"+e.toString());
		}
		finally
		{
		  if(con != null) ConnectionManager.returnConnection(con,p);
		}
		 results.put("status",new Boolean(result));
		 results.put("error",sb.toString());
		 results.put("ResultFromMessageManager", sbMessage.toString());
		 sb.setLength(0);
		 sbMessage.setLength(0);
		 return results;

	}//Method

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap deleteSetUpDailySchedule(Properties p,HashMap tabdata){
		HashMap results = new HashMap() ;
		StringBuffer sb  = new StringBuffer();
		StringBuffer sbMessage = new StringBuffer("");
		boolean result = false;
		Connection  con =null;
		String clinic_code = (String)tabdata.get("clinic_code") ;
		String clinic_date = (String)tabdata.get("clinic_date") ;
		String practitioner_id = (String)tabdata.get("p_practitioner_id")==null?"":(String)tabdata.get("p_practitioner_id");
		String facilityId = (String)tabdata.get("facilityId") ;
		String 	alcncriteria = (String)	tabdata.get("alcn_criteria");
		String location_Type = (String)tabdata.get("location_Type") ;
		String resource_Type = (String)tabdata.get("resource_Type") ;
		String time_table_type =(String)tabdata.get("time_table_type");
		String locale = p.getProperty("LOCALE");
		boolean deletable = true;
		boolean appt_exist = false;
		int res =0;
		try{
			con= ConnectionManager.getConnection(p);
			sql=" Delete from oa_clinic_Schedule_dtl where  nvl('"+practitioner_id+"','X') = nvl('','X') and  facility_id= '"+facilityId+"' and Clinic_code='"+clinic_code+"' and Clinic_date =to_date('"+clinic_date+"', 'dd/mm/yyyy') ";
			if (pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement(sql) ;
			res =pstmt.executeUpdate();
			sql="select '1' from oa_clinic_schedule_slot_slab where clinic_code='"+clinic_code+"' and nvl(practitioner_id,'X') =nvl('"+practitioner_id+"','X')  and clinic_date=to_date('"+clinic_date+"', 'dd/mm/yyyy') and care_locn_type_ind='"+location_Type+"'  and resource_class='"+resource_Type+"' and pri_appt_ref_no is not null";
			if (pstmt!=null) pstmt.close();
			pstmt = con.prepareStatement(sql);
			rs   = pstmt.executeQuery() ;
			if(rs.next()){
				deletable=false;
				appt_exist = true;
			}else{
				if (pstmt!=null) pstmt.close();
				sql="delete from oa_clinic_schedule where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"', 'dd/mm/yyyy') and  nvl(practitioner_id,'X') =nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+location_Type+"'  and resource_class='"+resource_Type+"'";
				pstmt = con.prepareStatement(sql) ;
				res =pstmt.executeUpdate();
				if(res !=0){
					deletable = true;
				}else{
					deletable = false;
					sb.append("Delete OA_CLINIC_SCHEDULE has failed");
				}
				if(deletable){
					if(time_table_type.equals("1") || time_table_type.equals("2")){
						 sql=" delete from oa_clinic_schedule_slot_slab where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"', 'dd/mm/yyyy') and  nvl(practitioner_id,'X') =nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+location_Type+"'  and resource_class='"+resource_Type+"'";
						if (pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement(sql) ;
						res =pstmt.executeUpdate();
						if(res !=0){
							deletable = true;
						}else{
							deletable = false;
							sb.append("Delete OA_CLINIC_SCHEDULE_Slot_slab has failed.");
						}
					}
				}	
				if(!alcncriteria.equals("")){	
					//	sql=" delete from OA_CLINIC_SCHEDULE_DTL where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"', 'dd/mm/yyyy') and  nvl(practitioner_id,'X') =nvl('"+practitioner_id+"','X')  and ALCN_CRITERIA = '"+alcncriteria+"' and care_locn_type_ind='"+location_Type+"'  and resource_class='"+resource_Type+"'";
					//	 if (pstmt!=null) pstmt.close();
					//	 pstmt = con.prepareStatement(sql) ;
					//	 res =pstmt.executeUpdate();
						deletable = true;
				}
				if(deletable){
					try{
						sql=" delete from oa_clinic_schedule_break where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and clinic_date=to_date('"+clinic_date+"', 'dd/mm/yyyy') and  nvl(practitioner_id,'X') =nvl('"+practitioner_id+"','X') and care_locn_type_ind='"+location_Type+"'  and resource_class='"+resource_Type+"'";
						if (pstmt!=null) pstmt.close();
						pstmt = con.prepareStatement(sql) ;
						res =pstmt.executeUpdate();
						/*if(res!=0){
							deletable=true;
						}else{
							deletable = false;
						}*/
					}catch(Exception ex){
						deletable = false;
						sb.append("Delete OA_CLINIC_SCHEDULE_BREAK has failed.");
						ex.printStackTrace();
					}
				}
				if(deletable){
					try{
						String sql_del_oa_block_appt = "delete from oa_block_appt where facility_id = ? and clinic_code = ?  and nvl(practitioner_id,'X') =nvl(?,'X') and block_date =to_date(?,'dd/mm/yyyy')  " ;
						pstmt = con.prepareStatement(sql_del_oa_block_appt) ;
						pstmt.setString(1,facilityId);
						pstmt.setString(2,clinic_code);
						pstmt.setString(3,practitioner_id);
						pstmt.setString(4,clinic_date);
						res =pstmt.executeUpdate();
					}catch(Exception ex){
						deletable = false;
						sb.append("Delete OA_BLOCK_APPT has failed.");
						ex.printStackTrace();
					}
				}
			}
			if (pstmt!=null) pstmt.close();
			if (rs_new!=null) rs_new.close();
			if (rs_other!=null) rs_other.close();
			if(rs!=null) rs.close();
			if(pstmt !=null) pstmt.close();
			MessageManager mess1 = new MessageManager();
			if ( deletable ){
				result = true ;
				con.commit();
				final java.util.Hashtable message = mess1.getMessage( locale,"RECORD_DELETED","SM" ) ;
				sbMessage.append( (String) message.get("message") );
				message.clear();
			}else{
				con.rollback();
				if (appt_exist){
					final java.util.Hashtable message = mess1.getMessage( locale, "APPT_EXIST_CAN_NOT_DELETE","OA" ) ;
					sb.append( (String) message.get("message") );
					message.clear();
				}
			}
			tabdata.clear();
		}catch ( Exception e ){
			e.printStackTrace();
			deletable= false;
		   sb.append("Catch :"+e.toString());
		}finally{
			  if(con != null) ConnectionManager.returnConnection(con,p);
		}
		 results.put("status",new Boolean(result));
		 results.put("error",sb.toString());
		 results.put("ResultFromMessageManager", sbMessage.toString());
		 sb.setLength(0);
		 sbMessage.setLength(0);
		 return results;
		 }
	}		 //Method
