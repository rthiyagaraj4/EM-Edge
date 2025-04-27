<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> 										 
---------------------------------------------------------------------------------------------------------------
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<html>   
<head>  
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eOA/js/ApptDiary.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
</script>
</head> 
<%

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null; 
	ResultSet rs=null;
	ResultSet rsps=null; 
	Statement stmt=null;
	Statement stmtsd=null;
	PreparedStatement pstmt=null;
	CallableStatement cstmt = null;

	CallableStatement statement_bru = null; 
	PreparedStatement pstmt_label = null;
	ResultSet rs32 = null;

	PreparedStatement stmtps=null;
	String locale = (String)session.getAttribute("LOCALE");
	String new_date=(String)request.getParameter("new_appt_date"); 
	String clinic_code=(String)request.getParameter("i_clinic_code");
	String obook_appt_yn=(String)request.getParameter("obook_appt_yn");
	if( obook_appt_yn == null || obook_appt_yn.equals("null")) obook_appt_yn="";
	String overbook1=(String)request.getParameter("overbook1");
	if( overbook1 == null || overbook1.equals("null")) overbook1="";
	String practitioner_id=(String)request.getParameter("i_practitioner_id");
	String new_alcn_criteria="";
	if( practitioner_id == null || practitioner_id.equals("null")) practitioner_id="";	
	String facilityid=(String)session.getValue("facility_id");
	String old_date=(String)request.getParameter("i_appt_date"); //System.out.println("old_date"+old_date);
	if(old_date  == null || old_date.equals("null")) old_date="";
	String old_from_time=(String)request.getParameter("i_from_time");
//session.setAttribute( "ss_old_from_time", old_from_time );
	//System.out.println("old_from_time"+old_from_time);
	if(old_from_time  == null || old_from_time.equals("null")) old_from_time="";
	String old_to_time=(String)request.getParameter("i_to_time");
		//System.out.println("old_to_time"+old_to_time);
	String order_id=(String)request.getParameter("order_id");	//--[IN027165]--
	if(order_id  == null || order_id.equals("null")) order_id="";//--[IN027165]--
	if(old_to_time  == null || old_to_time.equals("null")) old_to_time="";
	String appt_ref_no=(String)request.getParameter("i_appt_ref_no");
	if(appt_ref_no  == null || appt_ref_no.equals("null")) appt_ref_no="";
	String overbooked_yn=(String)request.getParameter("over_booked");
	if(overbooked_yn  == null || overbooked_yn.equals("null")) overbooked_yn="";
	String old_alcn_catg_code=(String)request.getParameter("old_alcn_catg_code");
	if(old_alcn_catg_code  == null || old_alcn_catg_code.equals("null")) old_alcn_catg_code="";
	String alcn_criteria=(String)request.getParameter("alcn_criteria");
	if(alcn_criteria  == null || alcn_criteria.equals("null")) alcn_criteria="";
	String tfr_appt_across_catg_yn=(String)request.getParameter("tfr_appt_across_catg_yn");
	String Forced=request.getParameter("Forced");
	String clinic_type=request.getParameter("clinic_type");
	String res_type=request.getParameter("res_type");
	if (clinic_type==null) clinic_type = "C";
	if (res_type==null) res_type = "P";
	String sys_date="";
	String sys_time="";
	String old_visit_type_ind="";
	String patient_id="";
	int new_max_fv=0;
	String new_max_fvStr="";
	int tot_fv=0,tot_ov=0,new_max_ov=0;
	int total_overbooked=0;
	int max_over_booking=0;
	boolean chk_for_fv=true,chk_for_ov=true;
	if(tfr_appt_across_catg_yn==null || tfr_appt_across_catg_yn.equals(""))tfr_appt_across_catg_yn="N";
	int max_patient			=0;
	int total_booked		=0;
	int no_of_slots_value   =0;
	int total_no_slots   =0;
	int total_no_slots_booked   =0;
	String new_day = "";
	boolean allow_revise=true,other_cat=true;
	boolean chk_alcn=true;
	String  fv_for_ob="N";
	if(new_date==null || new_date.equals("")) new_date=old_date;
	String visit_limit_rule=request.getParameter("visit_limit_rule");
	String  slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
	String total_booked1="";
	String max_patients_per_day="";
	String old_pract_id="";
	String old_clinic_code="";
	boolean normal_booking_allow_flag = true;
	old_visit_type_ind =request.getParameter("old_visit_type_ind1");
	old_alcn_catg_code=request.getParameter("old_alcn_catg_code1");
	no_of_slots_value=Integer.parseInt(request.getParameter("no_of_slots_value1"));
	patient_id=request.getParameter("patient_id1");
	old_pract_id=request.getParameter("old_pract_id1");
	if(patient_id==null) patient_id="";
	if(old_pract_id==null) old_pract_id="";	
	old_clinic_code=request.getParameter("old_clinic_code")==null?"":request.getParameter("old_clinic_code");
	String active_yn="";
	String suspend_yn="";
	String deceased_yn="";
	//request.setAttribute("my_old_date",old_date);//my added
	String schedule_status="";
	String pract_query="";

	//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	String schedule_extend_yn="N";

	//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
	 Boolean isSlotStartMidEndAppl = false;
	 String p_o_ext_slot_status = "";
	 String p_o_reserved_slot_dtls = "";
	 String p_o_appt_slot_dtls = "";
	 String p_o_block_slot_dtls = "";
	 String p_o_break_slot_dtls = "";
	 String max_patients_per_slab = "";
	 String P_O_MAX_FORCED_BOOK = "";
	 String P_O_FORCED_BOOK = "";


	 CallableStatement statement=null;


	try{
	
	con = ConnectionManager.getConnection(request);

	isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1

		stmtsd=con.createStatement();
		stmt=con.createStatement();
		StringBuffer clinic_sch=new StringBuffer();

			clinic_sch.append("select schedule_extend_yn from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date =to_date('"+new_date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"'  and ");
			
			if(practitioner_id.equals("")){
				clinic_sch.append(" Practitioner_id is null  ");
			}else{
				clinic_sch.append(" Practitioner_id ='"+practitioner_id+"' ");
			}
			
			rs = stmt.executeQuery(clinic_sch.toString());
			clinic_sch=null;

			if(rs !=null){
				while ( rs.next() ){
					schedule_extend_yn = rs.getString("schedule_extend_yn");
					if(schedule_extend_yn==null) schedule_extend_yn="N";
				}
			
			}
			
			if(rs !=null) rs.close();

		StringBuffer alcn_crit=new StringBuffer();
		if (slot_appt_ctrl.equals("P")){
			alcn_crit.append("select nvl(max_patients_per_day,0) max_patients_per_day, nvl(total_first_visit,0)+nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0) +nvl(total_first_visits_blocked,0)+ nvl(total_other_visits_blocked,0) total_booked from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date =to_date('"+new_date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"'  and ");
			
			if(practitioner_id.equals("")){
				alcn_crit.append(" Practitioner_id is null  ");
			}else{
				alcn_crit.append(" Practitioner_id ='"+practitioner_id+"' ");
			}
				
				
				
				
				
				
				
				
				
				
				
			
			rs = stmt.executeQuery(alcn_crit.toString());
			alcn_crit=null;
			if(rs !=null){
				while ( rs.next() ){
					max_patients_per_day= rs.getString("max_patients_per_day");
					total_booked1		= rs.getString("total_booked");
				}
			
			}
			if (max_patients_per_day.equals(total_booked1))
				normal_booking_allow_flag=false;
			if(rs !=null) rs.close();
		}

		if(practitioner_id.equals("")){
			pract_query=pract_query+" and Practitioner_id is null  ";
		}else{
			pract_query=pract_query+" and Practitioner_id ='"+practitioner_id+"' ";
		}
		String day_qry="select to_char(to_date('"+new_date+"','dd/mm/yyyy'),'Day') dy,to_char(sysdate,'dd/mm/yyyy') sysdt,to_char(sysdate,'hh24:mi') systm,(select schedule_status from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date =to_date('"+new_date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"' "+pract_query+" ) schedule_status from dual";
		rs = stmt.executeQuery(day_qry);
		rs.next();
		new_day=rs.getString("dy");
		sys_date=rs.getString("sysdt");
		sys_time=rs.getString("systm");
		schedule_status=rs.getString("schedule_status");
		
		/*String get_old_catg_code="select a.practitioner_id,a.patient_id,a.alcn_catg_code,b.visit_type_ind,a.no_of_slots from oa_appt a, op_visit_type b where a.facility_id = '"+facilityid+"' and a.appt_ref_no='"+appt_ref_no+"' and b.facility_id = a.facility_id and b.visit_type_code = a.appt_type_code ";

		rs = stmt.executeQuery(get_old_catg_code);
			if(rs !=null){
				while ( rs.next()){
						old_visit_type_ind = rs.getString("visit_type_ind");
						old_alcn_catg_code=rs.getString("alcn_catg_code");
						no_of_slots_value=rs.getInt("no_of_slots");
						patient_id=rs.getString("patient_id");
						if(patient_id==null) patient_id="";
						old_pract_id=rs.getString("practitioner_id");
						if(old_pract_id==null) old_pract_id="";

				}
			}
		*/
		if(rs !=null) rs.close();
		//if((!(new_date.equals(old_date)))||(!(old_pract_id.equals(practitioner_id)))){	It is commented as logic inside should execute for all Transfers irrespective of overbooking or normal booking STARTS
			/*	if(!alcn_criteria.equals("")){
					String alcn_crit_qry="select alcn_criteria from oa_clinic_schedule_dtl where facility_id='"+facilityid+"' and clinic_code='"+clinic_code+"' and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date('"+new_date+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl('"+practitioner_id+"','|') ";
					rs = stmt.executeQuery(alcn_crit_qry);
					if(rs !=null){
					 while ( rs.next() )
						new_alcn_criteria= rs.getString("alcn_criteria");
					}
				}     */
			if(rs !=null) rs.close();
			if(!visit_limit_rule.equals("N")){
				StringBuffer chk_fv=new StringBuffer();
				
				chk_fv.append("select nvl(max_first_visits,'') max_first_visits,nvl(total_overbooked,0) total_overbooked,nvl(max_over_booking,0) max_over_booking,nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit,nvl(max_other_visits,0) max_other_visits,nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits,MAX_PATIENTS_PER_DAY,TOTAL_SLOTS_BOOKED from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_code='"+clinic_code+"' and trunc(clinic_date)= to_date('"+new_date+"','DD/MM/YYYY')  and ");
				
				if(practitioner_id.equals("")){
					chk_fv.append(" practitioner_id is  null");
				}else{
					chk_fv.append("  practitioner_id= '"+practitioner_id+"'");
				}				



				rs = stmt.executeQuery(chk_fv.toString());
				chk_fv=null;
				if(rs !=null){
					while ( rs.next()){
						new_max_fvStr=rs.getString("max_first_visits");
						tot_fv=rs.getInt("total_first_visit");
						new_max_ov=rs.getInt("max_other_visits");
						tot_ov=rs.getInt("total_other_visits");
						max_over_booking=rs.getInt("max_over_booking");
						total_overbooked=rs.getInt("total_overbooked");
						total_no_slots=rs.getInt("MAX_PATIENTS_PER_DAY");
						total_no_slots_booked=rs.getInt("TOTAL_SLOTS_BOOKED");
					}
				}
				if(rs !=null) rs.close();

				if(old_visit_type_ind!=null && old_visit_type_ind.equals("F")){ //This is for first visit
					if(! (new_max_fvStr==null || new_max_fvStr.equals("null"))){
						new_max_fv=Integer.parseInt(new_max_fvStr);
						if (new_max_fv>0){
							if (no_of_slots_value>0&&slot_appt_ctrl.equals("S")){
							  if(new_max_fv>=(tot_fv+no_of_slots_value))
									chk_for_fv=true;
							  /*else if added by Sathish.S for IN019815 on Monday, March 15, 2010*/
							  else if((total_no_slots > total_no_slots_booked) && (old_date.equals(new_date)) && (old_pract_id.equals(practitioner_id)) && (old_clinic_code.equals(clinic_code)))								  
									chk_for_fv=true;
							  else if(new_max_fv > tot_fv)
								  chk_for_fv=true;
							  else
								  chk_for_fv=false;									  
							 }
								else{
									if(new_max_fv>tot_fv)
										chk_for_fv=true;
									 /*else if added by Sathish.S for IN019815 on Monday, March 15, 2010*/
									else if((total_no_slots > total_no_slots_booked) && (old_date.equals(new_date)) && (old_pract_id.equals(practitioner_id)) && (old_clinic_code.equals(clinic_code)))								  
										chk_for_fv=true;
									else
										chk_for_fv=false;
										
								}
						}else{
							if (new_max_fv==0&&(visit_limit_rule.equals("E")))
								chk_for_fv=false;
						}
					}else{
						chk_for_fv=true;
					}
				}
				if(old_visit_type_ind!=null && (!old_visit_type_ind.equals("F"))){//This is for other visit
					if(new_max_ov>0){
						if (no_of_slots_value>0&&slot_appt_ctrl.equals("S")){
							if(new_max_ov>=(tot_ov+no_of_slots_value))
								chk_for_ov=true;
							 /*else if added by Sathish.S for IN019815 on Monday, March 15, 2010*/
							else if((total_no_slots > total_no_slots_booked) && (old_date.equals(new_date)) && (old_pract_id.equals(practitioner_id)) && (old_clinic_code.equals(clinic_code)))		
								chk_for_ov=true;
							else if(new_max_ov > tot_ov)
								  chk_for_ov=true;
							else	
								chk_for_ov=false;		
						}else{
							if(new_max_ov>tot_ov)
								chk_for_ov=true;
							 /*else if added by Sathish.S for IN019815 on Monday, March 15, 2010*/
							else if((total_no_slots > total_no_slots_booked) && (old_date.equals(new_date)) && (old_pract_id.equals(practitioner_id)) && (old_clinic_code.equals(clinic_code)))		
								chk_for_ov=true;
							else
								chk_for_ov=false;			
						}
					}else{
						if (new_max_ov==0&&(visit_limit_rule.equals("E")))
							chk_for_ov=false;
					}
				}
			}
			
			if (!chk_for_fv){
				if (max_over_booking > total_overbooked){
					 /*if condition added by Sathish.S for IN019815 on Monday, March 15, 2010*/
					if(no_of_slots_value > 1 && !(old_date.equals(new_date) &&  old_pract_id.equals(practitioner_id) && old_clinic_code.equals(clinic_code)) && (Integer.parseInt(new_max_fvStr) == tot_fv)){
						chk_alcn=false;
						allow_revise=false;
						out.println("<script>alert(getMessage('MAX_FIRST_VISITS_REACHED','OA'));</script>");
					}else{
						allow_revise=true;
						fv_for_ob="Y";
						chk_alcn=false;
					}
				}else if((old_date.equals(new_date))){ /*else if condition added by Sathish.S for IN019815 on Monday, March 15, 2010*/
					if(!(old_pract_id.equals(practitioner_id)) || !(old_clinic_code.equals(clinic_code))){
						chk_alcn=false;
						allow_revise=false;
						out.println("<script>alert(getMessage('MAX_FIRST_VISITS_REACHED','OA'));</script>");
					}
				}else{
					chk_alcn=false;
					allow_revise=false;
					out.println("<script>alert(getMessage('MAX_FIRST_VISITS_REACHED','OA'));</script>");
				}
			}
			if (!(visit_limit_rule.equals("N"))&&fv_for_ob!="Y"){
				if (allow_revise){
					if(!chk_for_ov){
						if (max_over_booking > total_overbooked){
							 /*if condition added by Sathish.S for IN019815 on Monday, March 15, 2010*/
							if(no_of_slots_value > 1 && !(old_date.equals(new_date) &&  old_pract_id.equals(practitioner_id) && old_clinic_code.equals(clinic_code)) && (new_max_ov == tot_ov)){
								chk_alcn=false;
								allow_revise=false;
								out.println("<script>alert(getMessage('MAX_OTHER_VISITS_REACHED','OA'));</script>");
							}else{
								allow_revise=true;
								fv_for_ob="Y";
							}
						}else if((old_date.equals(new_date))){  /*else if condition added by Sathish.S for IN019815 on Monday, March 15, 2010*/
							if(!(old_pract_id.equals(practitioner_id)) || !(old_clinic_code.equals(clinic_code))){
						chk_alcn=false;
						allow_revise=false;
						out.println("<script>alert(getMessage('MAX_OTHER_VISITS_REACHED','OA'));</script>");
					}
				}else{
					chk_alcn=false;
					allow_revise=false;
					out.println("<script>alert(getMessage('MAX_OTHER_VISITS_REACHED','OA'));</script>");
						}
					 }
					}
				}			
			if(chk_for_fv && fv_for_ob!="Y"){
				if(chk_alcn){
					if( ((alcn_criteria!=null || !(alcn_criteria.equals(""))) &&  (new_alcn_criteria!=null || !(new_alcn_criteria.equals(""))) ) ||((new_alcn_criteria!=null || !(new_alcn_criteria.equals(""))) && (new_alcn_criteria!=null || !(new_alcn_criteria.equals(""))) )){
							if(!(new_alcn_criteria.equals(alcn_criteria)))
								chk_alcn=true;
							else
								chk_alcn=true;
							
					   }
					else{
						out.println("<script> alert(getMessage('TRANS_ACROSS_NOT_ALLOWED','OA')); </script>");
						chk_alcn=false;
					}
				}
				
			/*		if(chk_alcn){
						if(alcn_criteria!=null && (alcn_criteria.equals("NG") || alcn_criteria.equals("BG") || alcn_criteria.equals("PC") )){
						String chk_revise="select a.alcn_criteria,a.max_patients,a.total_booked_patients,a.total_blocked_slots from oa_clinic_schedule_dtl a where a.facility_id='"+facilityid+"'  and a.clinic_code='"+clinic_code+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+new_date+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitioner_id+"','|') and a.alcn_catg_code='"+old_alcn_catg_code+"' ";
						rs = stmt.executeQuery(chk_revise);
						if(rs !=null)
							 {
							 while ( rs.next() )
								{
									max_patient			=rs.getInt("max_patients");
									total_booked		=rs.getInt("total_booked_patients");

								}
							 } 

							 if(rs !=null) rs.close();
						}
					}
						*/
			}
		//} It is commented as logic inside should execute for all Transfers irrespective of overbooking or normal booking ENDS

if (!(fv_for_ob.equals("Y")))
{
	if(chk_alcn){
	if(max_patient!=0){
			if(max_patient==total_booked){
				if(overbook1.equals("Y")){
					}
				else if(tfr_appt_across_catg_yn!=null && tfr_appt_across_catg_yn.equalsIgnoreCase("N")){
					allow_revise=false;
					out.println("<script>alert(getMessage('APPT_CAN_NOT_TRANS_OTH_CAT','OA'));</script>");
				}
				else{			
					out.println("<script>alert(getMessage('APPT_TRANS_OTH_CAT','OA'));</script>");
					allow_revise=true;
					other_cat =false;

				}
			}
			if ((allow_revise && no_of_slots_value>0 )&& (max_patient < (total_booked+no_of_slots_value)))
			{
				if(tfr_appt_across_catg_yn!=null && tfr_appt_across_catg_yn.equalsIgnoreCase("N")){
				allow_revise=false;
				out.println("<script>alert(getMessage('APPT_CAN_NOT_TRANS_OTH_CAT','OA'));</script>");
				}
				else
				{
				/*String chk_revise1="select a.max_patients,a.total_booked_patients,a.total_blocked_slots from oa_clinic_schedule_dtl a where a.facility_id='"+facilityid+"'  and a.clinic_code='"+clinic_code+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+new_date+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitioner_id+"','|') and a.alcn_catg_code!='"+old_alcn_catg_code+"' ";
				if (rs!=null) rs.close();
				rs = stmt.executeQuery(chk_revise1);
						if(rs !=null){
							while ( rs.next() )
							{
								max_patient			=rs.getInt("max_patients");
								total_booked		=rs.getInt("total_booked_patients");

							}
						}
				
				if(rs !=null) rs.close();
					if (!(overbook1.equals("Y"))&&slot_appt_ctrl.equals("S"))
					{
					if (max_patient < (total_booked+no_of_slots_value-1))
					{
					allow_revise=false;
					out.println("<script>alert(getMessage('MULTI_SLOT_NOT_AVAILABLE','OA'));</script>");
					}
					else
					{
					if (other_cat)
						out.println("<script>alert(getMessage('APPT_TRANS_OTH_CAT','OA'));</script>");
					}
					}*/
				}
			}
			}
			else
			allow_revise=true;
			
	}
	else	
	  allow_revise=false;
}

String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
String dispdate=(String)request.getParameter("i_appt_date");
StringTokenizer DispDate= new StringTokenizer(dispdate,"/");
String dt=DispDate.nextToken();
String mon=months[Integer.parseInt(DispDate.nextToken())-1];
String yr=DispDate.nextToken();
dispdate=dt +"&nbsp"+mon+"&nbsp"+yr;
String decide="";
String P_FACILITY_ID   =facilityid;
String P_CLINIC_DATE   =new_date;
String P_CLINIC_CODE   =clinic_code;
String P_PRACTITIONER_ID=practitioner_id;
String P_O_CLINIC             ="";
String P_O_PRACTITIONER       ="";
String P_O_MAX_PAT            ="";
String P_O_MAX_OVER_BOOK      ="";
String P_O_BOOKED             ="";
String P_O_OVER_BOOKED        ="";
String P_O_OVER_BOOKING       ="N";
String P_O_TIME_TAB_TYPE     ="";
String P_O_STATUS             ="";
String P_O_FROM_TIME          ="";
String P_O_TO_TIME            ="";
String P_O_APPT_REF_NO        ="";
String P_O_PATIENT_NAME       ="";
String P_O_AGE                ="";
String P_O_GENDER             ="";
String P_O_REASON_FOR_CON    ="";
String P_O_VISIT_TYPE         ="";
String P_O_CONTACT            ="";
String P_O_VISIT_TYPE_IND     ="";
String P_O_NO_OF_SLOTS= "";
String P_O_Max_Forced= "";
String P_O_Total_Forced= "";
String P_O_PATIENT_ID       ="";
String P_APPT_OTH_DTL       ="";

//Below variable declare for this  [Bru-HIMS-CRF-177]	
	String colour_indicator="", P_O_VISIT_TYPE_CODE=""; 
	
// End [Bru-HIMS-CRF-177]	



//String sql="";

/* Added for ML-BRU-CRF-0628.1 */
if(isSlotStartMidEndAppl){
	cstmt = con.prepareCall("{call oa_external_slots_BRU(?,?,?,?,?,?,?,?,?)}");
	cstmt.setString( 1, P_FACILITY_ID );
	cstmt.setString( 2, P_CLINIC_CODE );
	cstmt.setString( 3, P_PRACTITIONER_ID );
	cstmt.setString( 4, P_CLINIC_DATE );
	cstmt.registerOutParameter( 5, Types.VARCHAR );
	cstmt.registerOutParameter( 6, Types.VARCHAR );
	cstmt.registerOutParameter( 7, Types.VARCHAR );
	cstmt.registerOutParameter( 8, Types.VARCHAR );
	cstmt.registerOutParameter( 9, Types.VARCHAR );

	cstmt.execute() ;

	p_o_ext_slot_status = cstmt.getString( 5 ); 
	if(p_o_ext_slot_status == null) p_o_ext_slot_status = "";
	
	p_o_reserved_slot_dtls = cstmt.getString( 6 );
	if(p_o_reserved_slot_dtls == null) p_o_reserved_slot_dtls = "";

	p_o_appt_slot_dtls = cstmt.getString( 7 );
	if(p_o_appt_slot_dtls == null) p_o_appt_slot_dtls = "";

	p_o_block_slot_dtls = cstmt.getString( 8 );
	if(p_o_block_slot_dtls == null) p_o_block_slot_dtls = "";

	p_o_break_slot_dtls = cstmt.getString( 9 );
	if(p_o_break_slot_dtls == null) p_o_break_slot_dtls = "";
}

if(isSlotStartMidEndAppl){
			
	StringBuffer sql_label = new StringBuffer();

	sql_label.append("select time_table_type, max_patients_per_slab, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, nvl(total_slots_booked,0) total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, to_char(end_time,'hh24:mi')end_time, nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING, nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING, nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=?  and care_locn_type_ind =? and resource_class=? and ");

	if(P_PRACTITIONER_ID.equals("")){
		sql_label.append("practitioner_id is null ");
	}else{
		sql_label.append("practitioner_id = ?");
	}

	pstmt_label = con.prepareStatement(sql_label.toString());

	pstmt_label.setString(1,P_FACILITY_ID);
	pstmt_label.setString(2,P_CLINIC_DATE);
	pstmt_label.setString(3,P_CLINIC_CODE);
	pstmt_label.setString(4,clinic_type);
	pstmt_label.setString(5,res_type);
	if(!P_PRACTITIONER_ID.equals("")){
		pstmt_label.setString(6,P_PRACTITIONER_ID);
	}

	rs32 = pstmt_label.executeQuery();
	sql_label=null;

	if( rs32 !=null && rs32.next() ){

		P_O_TIME_TAB_TYPE = rs32.getString("time_table_type" );   

		max_patients_per_slab = rs32.getString("max_patients_per_slab");
		if(max_patients_per_slab==null) max_patients_per_slab="";

		P_O_MAX_PAT = rs32.getString("max_patients_per_day");
		if(P_O_MAX_PAT==null) P_O_MAX_PAT="";

		P_O_MAX_OVER_BOOK = rs32.getString("max_over_booking" );        
		if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";

		P_O_BOOKED = rs32.getString("total_slots_booked" );   
		if(P_O_BOOKED ==null) P_O_BOOKED="";

		P_O_OVER_BOOKED = rs32.getString( "total_slots_overbooked" );    
		if(P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";	

		P_O_MAX_FORCED_BOOK = rs32.getString("MAX_FORCED_IN_BOOKING");
		if(P_O_MAX_FORCED_BOOK==null)P_O_MAX_FORCED_BOOK="";

		P_O_FORCED_BOOK	= rs32.getString("TOTAL_FORCED_IN_BOOKED");
		if(P_O_FORCED_BOOK==null)P_O_FORCED_BOOK="";
	}
}

if(isSlotStartMidEndAppl && P_O_TIME_TAB_TYPE.equals("2") && !max_patients_per_slab.equals("1")){



	statement_bru = con.prepareCall("{call oa_slabs_BRU(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

	statement_bru.setString( 1, P_FACILITY_ID);
	statement_bru.setString( 2, P_CLINIC_CODE);
	statement_bru.setString( 3, P_PRACTITIONER_ID);
	statement_bru.setString( 4, P_CLINIC_DATE);
	statement_bru.registerOutParameter( 5, Types.CLOB );
	statement_bru.registerOutParameter( 6, Types.CLOB );
	statement_bru.registerOutParameter( 7, Types.CLOB );
	statement_bru.registerOutParameter( 8, Types.CLOB );
	statement_bru.registerOutParameter( 9, Types.CLOB );
	statement_bru.registerOutParameter(10, Types.CLOB );
	statement_bru.registerOutParameter(11, Types.CLOB );
	statement_bru.registerOutParameter(12, Types.CLOB );
	statement_bru.registerOutParameter(13, Types.CLOB );
	statement_bru.registerOutParameter(14, Types.CLOB );
	statement_bru.registerOutParameter(15, Types.CLOB );
	statement_bru.registerOutParameter(16, Types.CLOB );
	statement_bru.registerOutParameter(17, Types.CLOB );
	statement_bru.registerOutParameter(18, Types.CLOB );
	statement_bru.registerOutParameter(19, Types.CLOB );
	statement_bru.registerOutParameter(20, Types.CLOB );
	statement_bru.registerOutParameter(21, Types.CLOB );
	statement_bru.registerOutParameter(22, Types.CLOB );
	statement_bru.registerOutParameter(23, Types.CLOB );
	statement_bru.registerOutParameter(24, Types.CLOB );
	statement_bru.registerOutParameter(25, Types.CLOB );
	statement_bru.registerOutParameter(26, Types.CLOB );

	statement_bru.execute() ;

	
	P_O_CLINIC = P_CLINIC_CODE;

	P_O_PRACTITIONER = P_PRACTITIONER_ID;

	P_O_Max_Forced = P_O_MAX_FORCED_BOOK;

	P_O_Total_Forced = P_O_FORCED_BOOK;

	P_O_STATUS = statement_bru.getString(6); 
	if( P_O_STATUS == null) P_O_STATUS="";

	P_O_APPT_REF_NO = statement_bru.getString(7); 
	if( P_O_APPT_REF_NO == null) P_O_APPT_REF_NO="";

	P_O_PATIENT_NAME = statement_bru.getString(8); 
	if( P_O_PATIENT_NAME == null) P_O_PATIENT_NAME="";

	P_O_AGE = statement_bru.getString(9); 
	if( P_O_AGE == null) P_O_AGE="";

	P_O_GENDER = statement_bru.getString(10); 
	if( P_O_GENDER == null) P_O_GENDER="";

	P_O_REASON_FOR_CON = statement_bru.getString(12); 
	if( P_O_REASON_FOR_CON == null) P_O_REASON_FOR_CON="";

	P_O_VISIT_TYPE = statement_bru.getString(17); 
	if( P_O_VISIT_TYPE == null) P_O_VISIT_TYPE="";

	P_O_CONTACT = statement_bru.getString(13); 
	if( P_O_CONTACT == null) P_O_CONTACT="";

	P_O_VISIT_TYPE_IND = statement_bru.getString(14); 
	if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";

	P_O_PATIENT_ID = statement_bru.getString(15); 
	if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";

	P_APPT_OTH_DTL = statement_bru.getString(22); 
	if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";

	P_O_VISIT_TYPE_CODE = statement_bru.getString(11); 
	if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";

	P_O_FROM_TIME = statement_bru.getString(24);     
	if(P_O_FROM_TIME == null) P_O_FROM_TIME="";

	P_O_TO_TIME = statement_bru.getString(25);	
	if(P_O_TO_TIME == null) P_O_TO_TIME="";

	P_O_NO_OF_SLOTS = statement_bru.getString(26); 
	if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

}else{
/* End ML-BRU-CRF-0628.1 */



System.err.println("Before execute get_day_status---in Param---P_FACILITY_ID-->"+P_FACILITY_ID+"  P_CLINIC_CODE-->"+P_CLINIC_CODE+"  P_PRACTITIONER_ID-->"+P_PRACTITIONER_ID+"  P_CLINIC_DATE-->"+P_CLINIC_DATE);

statement=con.prepareCall("{call oa_schedules.get_day_status( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

statement.setString( 1, P_FACILITY_ID);
statement.setString( 2, P_CLINIC_DATE);
statement.setString( 3, P_CLINIC_CODE);
statement.setString( 4, P_PRACTITIONER_ID);
statement.setString( 5, clinic_type);
statement.setString( 6, res_type);

statement.registerOutParameter(7, Types.VARCHAR );
statement.registerOutParameter(8, Types.VARCHAR );
/*
statement.registerOutParameter(7, Types.CLOB );
statement.registerOutParameter(8, Types.CLOB );
*/


statement.registerOutParameter(9, Types.INTEGER);
statement.registerOutParameter(10, Types.INTEGER);
statement.registerOutParameter(11, Types.INTEGER);
statement.registerOutParameter(12, Types.INTEGER);

statement.registerOutParameter(13, Types.VARCHAR );
statement.registerOutParameter(14, Types.VARCHAR );
statement.registerOutParameter(15, Types.VARCHAR );
statement.registerOutParameter(16, Types.VARCHAR );
statement.registerOutParameter(17, Types.VARCHAR );
statement.registerOutParameter(18, Types.VARCHAR );
statement.registerOutParameter(19, Types.VARCHAR );
statement.registerOutParameter(20, Types.VARCHAR );
statement.registerOutParameter(21, Types.VARCHAR );
statement.registerOutParameter(22, Types.VARCHAR );
statement.registerOutParameter(23, Types.VARCHAR );
statement.registerOutParameter(24 ,Types.VARCHAR );
statement.registerOutParameter(25 ,Types.VARCHAR );
statement.registerOutParameter(26 ,Types.VARCHAR );
statement.registerOutParameter(27 ,Types.VARCHAR );
statement.registerOutParameter(28 ,Types.VARCHAR );
statement.registerOutParameter(29 ,Types.VARCHAR );
statement.registerOutParameter(30 ,Types.VARCHAR );
statement.registerOutParameter(31 ,Types.VARCHAR );
statement.registerOutParameter(32 ,Types.VARCHAR );
statement.registerOutParameter(33 ,Types.VARCHAR );

/*
statement.registerOutParameter(13, Types.CLOB );
statement.registerOutParameter(14, Types.CLOB );
statement.registerOutParameter(15, Types.CLOB );
statement.registerOutParameter(16, Types.CLOB );
statement.registerOutParameter(17, Types.CLOB );
statement.registerOutParameter(18, Types.CLOB );
statement.registerOutParameter(19, Types.CLOB );
statement.registerOutParameter(20, Types.CLOB );
statement.registerOutParameter(21, Types.CLOB );
statement.registerOutParameter(22, Types.CLOB );
statement.registerOutParameter(23, Types.CLOB );
statement.registerOutParameter(24 ,Types.CLOB );
statement.registerOutParameter(25 ,Types.CLOB );
statement.registerOutParameter(26 ,Types.CLOB );
statement.registerOutParameter(27 ,Types.CLOB );
statement.registerOutParameter(28 ,Types.INTEGER );
statement.registerOutParameter(29 ,Types.INTEGER);
statement.registerOutParameter(30 ,Types.INTEGER );
statement.registerOutParameter(31 ,Types.INTEGER );
statement.registerOutParameter(32 ,Types.CLOB );
statement.registerOutParameter(33 ,Types.CLOB );
*/
statement.setString( 34, locale);

statement.registerOutParameter(35 ,Types.VARCHAR );
statement.registerOutParameter(36 ,Types.VARCHAR );
statement.registerOutParameter(37 ,Types.VARCHAR );
statement.registerOutParameter(38 ,Types.VARCHAR );
statement.registerOutParameter(39 ,Types.VARCHAR );
statement.registerOutParameter(40 ,Types.VARCHAR );
statement.registerOutParameter(41 ,Types.VARCHAR );

/*
statement.registerOutParameter(35 ,Types.CLOB );
statement.registerOutParameter(36 ,Types.CLOB );
statement.registerOutParameter(37 ,Types.CLOB );
statement.registerOutParameter(38 ,Types.CLOB );
statement.registerOutParameter(39 ,Types.CLOB );
statement.registerOutParameter(40 ,Types.CLOB );
*/


statement.execute() ;

System.err.println("After execute get_day_status---in Param---P_FACILITY_ID-->"+P_FACILITY_ID+"  P_CLINIC_CODE-->"+P_CLINIC_CODE+"  P_PRACTITIONER_ID-->"+P_PRACTITIONER_ID+"  P_CLINIC_DATE-->"+P_CLINIC_DATE);

P_O_CLINIC			=statement.getString( 7 );		if(P_O_CLINIC == null) P_O_CLINIC="";
P_O_PRACTITIONER	=statement.getString( 8 );		if(P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
P_O_MAX_PAT			=statement.getString( 9 );		if(P_O_MAX_PAT == null) P_O_MAX_PAT="";
P_O_MAX_OVER_BOOK   =statement.getString( 10 );      if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
P_O_BOOKED          =statement.getString(11 );		if( P_O_BOOKED ==null) P_O_BOOKED="";
P_O_OVER_BOOKED     =statement.getString( 12 );     if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
P_O_OVER_BOOKING    =statement.getString( 13 );     if(P_O_OVER_BOOKING == null) P_O_OVER_BOOKING="";

P_O_TIME_TAB_TYPE   =statement.getString( 14 );	
if(P_O_TIME_TAB_TYPE == null) P_O_TIME_TAB_TYPE="";
P_O_STATUS          =statement.getString(15);
 if(P_O_STATUS == null) P_O_STATUS=""; 

P_O_FROM_TIME       =statement.getString( 16 );      if(P_O_FROM_TIME == null) P_O_FROM_TIME="";
P_O_TO_TIME         =statement.getString( 17 );		if(P_O_TO_TIME == null) P_O_TO_TIME="";
P_O_APPT_REF_NO     =statement.getString(18 );      if(P_O_APPT_REF_NO ==null) P_O_APPT_REF_NO="";
P_O_PATIENT_NAME    =statement.getString( 19 );     if(P_O_PATIENT_NAME ==null) P_O_PATIENT_NAME="";
P_O_AGE             =statement.getString( 20 );		if(P_O_AGE ==null) P_O_AGE="";
P_O_GENDER          =statement.getString( 21 );	    if(P_O_GENDER ==null) P_O_GENDER="";
P_O_REASON_FOR_CON  =statement.getString( 22 );     if(P_O_REASON_FOR_CON ==null) P_O_REASON_FOR_CON	="";
P_O_VISIT_TYPE      =statement.getString( 23 );		if(P_O_VISIT_TYPE ==null) P_O_VISIT_TYPE="";
P_O_CONTACT       =statement.getString( 24 );		if(P_O_CONTACT == null) P_O_CONTACT="";
P_O_VISIT_TYPE_IND = statement.getString(26); if( P_O_VISIT_TYPE_IND == null) P_O_VISIT_TYPE_IND="";
P_O_NO_OF_SLOTS = statement.getString(27); if( P_O_NO_OF_SLOTS == null) P_O_NO_OF_SLOTS="";

P_O_Max_Forced=statement.getString(28); if( P_O_Max_Forced == null) P_O_Max_Forced="";
P_O_Total_Forced=statement.getString(29); if( P_O_Total_Forced == null) P_O_Total_Forced="";

P_O_PATIENT_ID=statement.getString(32); if( P_O_PATIENT_ID == null) P_O_PATIENT_ID="";
P_APPT_OTH_DTL= statement.getString(40); if( P_APPT_OTH_DTL == null) P_APPT_OTH_DTL="";
/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/
P_O_VISIT_TYPE_CODE = statement.getString(35);
if( P_O_VISIT_TYPE_CODE == null) P_O_VISIT_TYPE_CODE="";
//End[Bru-HIMS-CRF-177]

}

		
		System.err.println("P_O_CLINIC-------->"+P_O_CLINIC);
		System.err.println("P_O_PRACTITIONER-------->"+P_O_PRACTITIONER);
		System.err.println("P_O_MAX_PAT-------->"+P_O_MAX_PAT);
		System.err.println("P_O_MAX_OVER_BOOK-------->"+P_O_MAX_OVER_BOOK);
		System.err.println("P_O_BOOKED-------->"+P_O_BOOKED);
		System.err.println("P_O_OVER_BOOKED-------->"+P_O_OVER_BOOKED);
		System.err.println("P_O_OVER_BOOKING-------->"+P_O_OVER_BOOKING);
		System.err.println("P_O_TIME_TAB_TYPE-------->"+P_O_TIME_TAB_TYPE);
		System.err.println("P_O_STATUS-------->"+P_O_STATUS);
		System.err.println("P_O_FROM_TIME-------->"+P_O_FROM_TIME);
		System.err.println("P_O_TO_TIME-------->"+P_O_TO_TIME);
		System.err.println("P_O_APPT_REF_NO-------->"+P_O_APPT_REF_NO);
		System.err.println("P_O_PATIENT_NAME-------->"+P_O_PATIENT_NAME);
		System.err.println("P_O_AGE-------->"+P_O_AGE);
		System.err.println("P_O_GENDER-------->"+P_O_GENDER);
		System.err.println("P_O_REASON_FOR_CON-------->"+P_O_REASON_FOR_CON);
		System.err.println("P_O_VISIT_TYPE-------->"+P_O_VISIT_TYPE);
		System.err.println("P_O_CONTACT-------->"+P_O_CONTACT);	
		System.err.println("P_O_VISIT_TYPE_IND-------->"+P_O_VISIT_TYPE_IND);
		System.err.println("P_O_NO_OF_SLOTS-------->"+P_O_NO_OF_SLOTS);
		System.err.println("P_O_Max_Forced-------->"+P_O_Max_Forced);
		System.err.println("P_O_Total_Forced-------->"+P_O_Total_Forced);
		System.err.println("P_O_PATIENT_ID-------->"+P_O_PATIENT_ID);
		System.err.println("P_APPT_OTH_DTL-------->"+P_APPT_OTH_DTL);
		System.err.println("P_O_VISIT_TYPE_CODE-------->"+P_O_VISIT_TYPE_CODE);
		

			StringTokenizer token = new StringTokenizer(P_O_FROM_TIME, "|");
			int counter=token.countTokens();

			String from_time[]=new String[counter];
			int track=0;
			while (token.hasMoreTokens())
				{
				from_time[track]=token.nextToken();
				track++;
				}

			StringTokenizer token1 = new StringTokenizer(P_O_TO_TIME, "|");
			String to_time[]=new String[counter];
			int track1=0;
			String end_time ="";
			int tot_token= token1.countTokens();

			while (token1.hasMoreTokens())
			{
				end_time=token1.nextToken();

				if(schedule_extend_yn.equals("Y") && P_O_TIME_TAB_TYPE.equals("1")) { // to handle last slot for extended

					if (tot_token-track1 == 1) {					
						end_time="00:00";
					}
				}
				
				to_time[track1]=end_time;

				track1++;
			}

		StringTokenizer token2 = new StringTokenizer(P_O_PATIENT_NAME, "|");
		//String new_pat[]=new String[counter];

			String patient_name[]=new String[counter];
			int track2=0;
			String s = null;
			while (token2.hasMoreTokens())
				{
				s = token2.nextToken();
				patient_name[track2]=s;
				track2++;
				}


		StringTokenizer token21 = new StringTokenizer(P_O_PATIENT_ID, "|");

			String patient_id1[]=new String[counter];
			int track21=0;
			while (token21.hasMoreTokens())
				{
				patient_id1[track21]=token21.nextToken();
				track21++;
				}






		StringTokenizer token3 = new StringTokenizer(P_O_AGE, "|");

			String age[]=new String[counter];
			int track3=0;
			while (token3.hasMoreTokens())
				{
				age[track3]=token3.nextToken();
				track3++;
				}

		StringTokenizer token4 = new StringTokenizer(P_O_GENDER, "|");

			String gender[]=new String[counter];
			int track4=0;
			while (token4.hasMoreTokens())
				{
				gender[track4]=token4.nextToken();
				track4++;
				}


	StringTokenizer token5 = new StringTokenizer(P_O_REASON_FOR_CON, "|") ;

			String reason_for_contact[]=new String[counter];
			int track5=0;
			while (token5.hasMoreTokens())
				{
				reason_for_contact[track5]=token5.nextToken();
				track5++;
				}

		StringTokenizer token6 = new StringTokenizer(P_O_VISIT_TYPE, "|");

			String visit_type[]=new String[counter];
			int track6=0;
			while (token6.hasMoreTokens())
				{
				visit_type[track6]=token6.nextToken();
				track6++;
				}


	StringTokenizer token7 = new StringTokenizer(P_O_CONTACT, "|");

			String contact[]=new String[counter];
			int track7=0;
			while (token7.hasMoreTokens())
				{
				contact[track7]=token7.nextToken();
				track7++;
				}

			StringTokenizer token8 = new StringTokenizer(P_O_APPT_REF_NO, "|");

				String o_appt_ref_no[]=new String[counter];
				int track8=0;
				while (token8.hasMoreTokens())
				{
				o_appt_ref_no[track8]=token8.nextToken();
				track8++;
				}

				StringTokenizer token811 = new StringTokenizer(P_APPT_OTH_DTL, "|");

				String appt_ot_dtl[]=new String[counter];
				int track811=0;
				while (token811.hasMoreTokens())
				{
				appt_ot_dtl[track811]=token811.nextToken();
				track811++;
				}

		StringTokenizer token9 = new StringTokenizer(P_O_STATUS, "|");

				String status[]=new String[counter];
				String status1[]=new String[counter];
				int track9=0;
				while (token9.hasMoreTokens())
				{
				status[track9]=token9.nextToken();
				status1[track9]=status[track9];
				track9++;
				}
	StringTokenizer token10 = new StringTokenizer(P_O_VISIT_TYPE_IND, "|");
		

				String visit_type_ind[]=new String[counter];
				int track10=0;
				while (token10.hasMoreTokens())
				{
				visit_type_ind[track10]=token10.nextToken();
				track10++;
				}

		StringTokenizer token11 = new StringTokenizer(P_O_NO_OF_SLOTS, "|");
		

				String no_of_slots[]=new String[counter];
				int track11=0;
				while (token11.hasMoreTokens())
				{
				no_of_slots[track11]=token11.nextToken();
				track11++;
				}
				
				
			/*Below Line Added for this CRF [Bru-HIMS-CRF-177]*/
			token=null;
			track=0;
			token = new StringTokenizer(P_O_VISIT_TYPE_CODE, "|");
			String visit_type_code[]=new String[counter];
			while (token.hasMoreTokens())
			{   
				visit_type_code[track]=token.nextToken();
				track++;
				
			}
		//End [Bru-HIMS-CRF-177]	
			


if(no_of_slots_value>1)
{
  if (P_O_TIME_TAB_TYPE.equals("2")||P_O_TIME_TAB_TYPE.equals("3"))
	{
	allow_revise=false;
	out.println("<script> alert(getMessage('TRANS_NOT_FOR_MULTI_TO_OTHER','OA')); </script>");
	}
}
if(schedule_status!=null && schedule_status.equals("B")){
	allow_revise=false;
	%><script> alert(getMessage('SCHEDULE_BLOCK','OA')+' '+'<%=new_date%>'); </script><%
}
	if(allow_revise){
	
	%>
	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload="checkPatientStatus();"><!--modified for the CRF Bru-HIMS-CRF 169 -->
	<form name='displayresults' id='displayresults'>
	<input type='hidden' name='help_function_id' id='help_function_id' value='RESCHEDULE_APPOINTMENT'>
	<table border="1" width="100%" cellspacing='0' cellpadding='0' id='results'>
		<th align='left' width='5%'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></th>
		<th align='left' width='5%'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></th>
		<th align='left' width='23%'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
		<th align='left' width='11%'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></th>
		<th align='left' width='30%'><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></th>
		<th align='left' width='23%'><fmt:message key="Common.ContactDetails.label" bundle="${common_labels}"/></th>
		<th align='left' width='11%'><fmt:message key="eOA.SelectedResource.label" bundle="${oa_labels}"/></th>


	<%
	
 /*Below Code Added for this CRF [Bru-HIMS-CRF-177] */	               	
java.util.HashMap hm=eMP.ChangePatientDetails.getColorCode(con,facilityid);
int maxval=0; String appt_ref_assign_value="";
  for (int maxchk = 0; maxchk < o_appt_ref_no.length; maxchk++) 
{
   appt_ref_assign_value=o_appt_ref_no[maxchk];   
   if(!appt_ref_assign_value.equals("~")){
       while(Integer.parseInt(appt_ref_assign_value)>maxval)
       { 
          maxval=Integer.parseInt(appt_ref_assign_value);
       }
   } 
}			
   // End [Bru-HIMS-CRF-177] 
	
	
	
	String classValue="";
	int slots = 0;
	String same_appt = "N";
	String pat_name = "";
	for(int init=0;init<counter;init++)
	{

	same_appt = "N";

	if( !(no_of_slots[init].equals("~")) && (Integer.parseInt(no_of_slots[init]) > 1) ) 
	{
		slots = Integer.parseInt(no_of_slots[init]);  // slots is number of slot
		pat_name = patient_name[init];
	}

	if ( init % 2 == 0 )
			classValue = "OAQRYEVEN" ;
				else
			classValue = "OAQRYODD" ;

	out.println("<tr onClick='row(this)'>");
	String u=from_time[init];
	String z=status[init];
	
	String reason ="";
	String z1=status1[init];

	String reason1=z.substring(0,2);
	if( z.length() > 2)
		reason=z.substring(2,z.length());
		
	else
		reason="";
	z=reason1;
	String chk_link=patient_name[init]; // this value is "~" AND  "AA"
	
	String from_time_send=from_time[init];
	String to_time_send=to_time[init];


	if(decide.equals("Query"))
	{
		if(z!=null && (z.equals("FL") || z.equals("OL") || z.equals("VL")|| z.equals("VT") || z.equals("FN"))){
		out.println("<td width=5% class="+classValue+">"+ u+" <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' > </td>");
			}
			else
			out.println("<td width=5% class='oabrown'>"+ u+" <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' ></td>");
	}
	else
	{
	if( ! u .equals("~"))
	{	 
		if(chk_link.equals("~"))
		{			
			if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT"))  // z value is 'OL' AND 'FL'
			{  
				if(slots > 0) // slot value is -1
				{
					out.println("<td width=5% class="+classValue+" >"+u+"<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' > </td>");
					slots--;
					same_appt = "Y";
				}
				else
				{					
					if (fv_for_ob.equals("Y"))
					{
						out.println("<td width=5% class="+classValue+" >"+u+"<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' > </td>");				
					}
					else
					{
						if (z.equals("FL")&&(!normal_booking_allow_flag)){
							out.println("<td width=5% class="+classValue+" >"+u+" <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' > </td>");
						}
						else{
							out.println("<td width=5% class="+classValue+" ><a href= javascript:callBookAppointmentDetails('"+from_time_send+"','"+to_time_send+"');>"+u+"</a> <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' > </td>");
						}

					}
				}
			}
			else
			{
				if(z.equals("BN")) 
				{
					out.println("<td width=5% class='oared' title =\""+reason+"\">"+ u+" <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' ></td>");
				}
				else if(z.equals("RN")) 
				{
					out.println("<td width=5% class='oablock' >"+ u+" <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' ></td>");
				}

				else
				{
					out.println("<td width=5% class='oablock' >"+ u+" <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' ></td>");
				}
			}
		}
		else
		{
			if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT"))
			{
				if(z1.equals("OL*F")){
					out.println("<td title='Forced Appointment' width=5% class=OAFORCED>"+ u+"<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' ></td>");
				}else{
					out.println("<td width=5% class="+classValue+">"+ u+"<input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' ></td>");
				}
			}
			else
			{
				if(z.equals("BN")) 
				{
					out.println("<td width=5% class='oared' title =\""+reason+"\" >"+ u+" <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' ></td>");
				}
				else if(z.equals("RN")) 
				{
					out.println("<td width=5% class='oablock'>"+ u+" <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' ></td>");
				}

				else

				{
					out.println("<td width=5% class='oablock'>"+ u+" <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' ></td>");
				}
			}

					slots--;
		}
	}
			else
			out.println("<td width=5% class="+classValue+">&nbsp; <input type='hidden' name='o_appt_ref_no' name='o_appt_ref_no"+init+"' id='o_appt_ref_no"+init+"' value='"+o_appt_ref_no[init]+"' ></td>");

	}
	String u1=to_time[init];

	//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
	if(u1.equals("00:00")){
		u1 = "23:59";
	}

	if( ! u1 .equals("~"))
	{
		if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT"))
		{
			if(z1.equals("OL*F")){
				out.println("<td title='Forced Appointment' width=5% class=OAFORCED>"+ u1+"</td>");
			}else{
				out.println("<td width=5% class="+classValue+">"+ u1+"</td>");
			}
		}
		else
		{
			if(z.equals("BN")) 
			{
				out.println("<td width=5% class='oared' title =\""+reason+"\">"+ u1+"</td>");
			}
			else
			{
				out.println("<td width=5% class='oablock'>"+ u1+"</td>");
			}
		}
	}
	else
		out.println("<td width=5% class="+classValue+">&nbsp;</td>");


	String u2=patient_name[init];
	String pat_id=patient_id1[init];
	String u3=age[init];
	String u4=gender[init];


	if(pat_id.equals("~"))
		pat_id="";
	else
		pat_id=pat_id+" , ";

		if( ! u2 .equals("~")){
			if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){%>
				<td width='23%' class="<%=classValue%>"><%=pat_id%> <%=u2%>,&nbsp;<%=u4%>,&nbsp;<%=u3%></td>
			<%}else{
				if(same_appt.equals("Y")){
					out.println("<td width=23% class="+classValue+">***</td>");
				}else{
					out.println("<td width=23% class='oabrown'>&nbsp;</td>");
				}
			}
		}else{
			if(same_appt.equals("Y")){%>
				<td width=23%  class="<%=classValue%>"><%=pat_name%></td>
			<%}	else{
				if(z.equals("BN")){%>
					<td width=23% class="<%=classValue%>"><fmt:message key="Common.blocked.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.reason.label" bundle="${common_labels}"/>:<b><%=reason%></b></td>
				<%}else{%>				 
					<td width=23% class="<%=classValue%>">&nbsp;</td>
				<%}
				
			}
		}
			

	String u6=visit_type[init];
		if( ! u6 .equals("~"))
			{
			if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
			
			String vist_code=checkForNull(visit_type_code[init]);       //this line Added for this CRF [Bru-HIMS-CRF-177]        
		   colour_indicator =checkForNull((String)hm.get(vist_code)); 			
			
			 if(colour_indicator.equals("") && o_appt_ref_no[init].equals(Integer.toString(maxval))){
			     colour_indicator="ORANGE";
			   }
			
			%>
			<td nowrap style="background-color:<%=colour_indicator%>;FONT-SIZE:8pt;"><%=u6%></td>
			<%
			}
			else
			out.println("<td width=11% class='oabrown'>&nbsp;</td>");
			}
			else
			out.println("<td width=11% class="+classValue+">&nbsp;</td>");


	String u5=reason_for_contact[init];
		if( ! u5 .equals("~"))
			{
			if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
			out.println("<td width=30% class="+classValue+">"+ u5+"</td>");
			}
			else
			out.println("<td width=30% class='oabrown'>&nbsp;</td>");
			}
			else
			out.println("<td width=30% class="+classValue+">&nbsp;</td>");



	String u7=contact[init];
		if( ! u7 .equals("~"))
			{
			if(z.equals("FL") || z.equals("OL") || z.equals("VL") || z.equals("FN")|| z.equals("VT")){
			out.println("<td width=23% class="+classValue+">"+ u7+"</td>");
			}
			else
			out.println("<td width=23% class='oabrown'>&nbsp;</td>");
			}
			else
			out.println("<td width=23% class="+classValue+">&nbsp;</td>");


	String tmp_ref_no=o_appt_ref_no[init];
	String oth_dtls=appt_ot_dtl[init];

	int sec_cnt=0;


	if(tmp_ref_no.equals("~")) tmp_ref_no="";
	StringTokenizer tmp_oth_dtl = new StringTokenizer(oth_dtls, "*");
	while (tmp_oth_dtl.hasMoreTokens())	{
		sec_cnt=Integer.parseInt(tmp_oth_dtl.nextToken());
		tmp_oth_dtl.nextToken();
		tmp_oth_dtl.nextToken();		
	}


	/*if(!tmp_ref_no.equals("")){
		sql="select count(appt_ref_no) cnt from oa_resource_for_appt where appt_ref_no = '"+tmp_ref_no+"' and FACILITY_ID='"+facilityid+"'";
			out.println("sec cnt sql " + sql);
			stmtps=con.prepareStatement(sql);
			rsps=stmtps.executeQuery();
			if ( rsps != null && rsps.next()){	
					sec_cnt=rsps.getInt("cnt");	
				
			}
	}
	if(stmtps !=null) stmtps.close();
	if(rsps !=null) rsps.close();
	*/
	%>
	<td width='5%' class="<%=classValue%>">
		<%if(sec_cnt>0){%>
			<a href="javascript:show_Reference_details('<%=tmp_ref_no%>','<%=facilityid%>')">
				<fmt:message key="Common.details.label" bundle="${common_labels}"/>
			</a>
		<%}%>&nbsp;</td>
	<%

	out.println("</tr>");
	}
	if(!P_O_PATIENT_ID.equals("")){
		
		//rs = stmt.executeQuery("select  ACTIVE_YN,SUSPEND_YN,DECEASED_YN from mp_patient where  patient_id='"+patient_id+"'");
		String sql1 = "select  ACTIVE_YN,SUSPEND_YN,DECEASED_YN from mp_patient where  patient_id=?";
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,patient_id);
		rs = pstmt.executeQuery();
		if(rs !=null){
			while ( rs.next() ){
				active_yn=rs.getString("ACTIVE_YN");
				suspend_yn=rs.getString("SUSPEND_YN");
				deceased_yn=rs.getString("DECEASED_YN");
			}
		}
	}
	%>
	</table>

	<input type='hidden' name='r_appt_status' id='r_appt_status' value='null' >
	<input type='hidden' name='clinic_code' id='clinic_code' value='<%= clinic_code %>' >
	<input type='hidden' name='clinic_name' id='clinic_name' value='<%=P_O_CLINIC %>' >
	<input type='hidden' name='pract_id' id='pract_id' value='<%=practitioner_id %>' >
	<input type='hidden' name='pract_name' id='pract_name' value='<%=P_O_PRACTITIONER %>' >
	<input type='hidden' name='old_date' id='old_date' value='<%=old_date%>' >
	<input type='hidden' name='appt_ref_no' id='appt_ref_no' value='<%=appt_ref_no%>' >
	<input type='hidden' name='appt_date' id='appt_date' value='<%=new_date%>' >
	<input type='hidden' name='over_booked' id='over_booked' value='<%=P_O_OVER_BOOKED%>' >
	<input type='hidden' name='overbooked_yn' id='overbooked_yn' value='<%=overbooked_yn%>' >
	<input type='hidden' name='P_O_TIME_TAB_TYPE' id='P_O_TIME_TAB_TYPE' value='<%=P_O_TIME_TAB_TYPE%>' >
	<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>' >
	<input type='hidden' name='sys_time' id='sys_time' value='<%=sys_time%>' >
	<input type='hidden' name='no_of_slots_value' id='no_of_slots_value' value='<%=no_of_slots_value%>' >
	<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>' >
	<input type='hidden' name='new_day' id='new_day' value='<%=new_day%>' >
	<input type='hidden' name='Forced' id='Forced' value='<%=Forced%>' >
	<input type='hidden' name='order_id' id='order_id' value='<%=order_id%>' > <!--[IN027165] -->
	<input type="hidden" name="clinic_type" id="clinic_type" value="<%=clinic_type%>">
	<input type="hidden" name="res_type" id="res_type" value="<%=res_type%>">
	<input type="hidden" name="alcn_criteria" id="alcn_criteria" value="<%=alcn_criteria%>">
	<input type='hidden' name='active_yn' id='active_yn' value="<%=active_yn%>">
	<input type='hidden' name='suspend_yn' id='suspend_yn' value="<%=suspend_yn%>">
	<input type='hidden' name='deceased_yn' id='deceased_yn' value="<%=deceased_yn%>">
	
	<!-- Added for ML-BRU-CRF-0628.1 -->
	<input type="hidden" name="p_o_ext_slot_status" id="p_o_ext_slot_status" value="<%=p_o_ext_slot_status%>">
	<input type="hidden" name="p_o_reserved_slot_dtls" id="p_o_reserved_slot_dtls" value="<%=p_o_reserved_slot_dtls%>">
	<input type="hidden" name="p_o_appt_slot_dtls" id="p_o_appt_slot_dtls" value="<%=p_o_appt_slot_dtls%>">
	<input type="hidden" name="p_o_block_slot_dtls" id="p_o_block_slot_dtls" value="<%=p_o_block_slot_dtls%>">
	<input type="hidden" name="p_o_break_slot_dtls" id="p_o_break_slot_dtls" value="<%=p_o_break_slot_dtls%>">
	<input type="hidden" name="isSlotStartMidEndAppl" id="isSlotStartMidEndAppl" value="<%=isSlotStartMidEndAppl%>">
	<!-- End ML-BRU-CRF-0628.1 -->

	</form>

	<script>
	
	/* Added for ML-BRU-CRF-0628.1 */
	if (document.forms[0].isSlotStartMidEndAppl.value=='true'){
	
		var ext_slt=document.forms[0].p_o_ext_slot_status.value;
		var res_slt=document.forms[0].p_o_reserved_slot_dtls.value;
		var appt_slt=document.forms[0].p_o_appt_slot_dtls.value;
		var blk_slt=document.forms[0].p_o_block_slot_dtls.value;
		var brk_slt=document.forms[0].p_o_break_slot_dtls.value;


		var ext_slot_arr=ext_slt.split("|");
		var res_slot_arr=res_slt.split("|");
		var appt_slot_arr=appt_slt.split("|");
		var blk_slot_arr=blk_slt.split("|");
		var brk_slot_arr=brk_slt.split("|");


		for(var i=0;i<=ext_slot_arr.length;i++){
			
			if(ext_slot_arr[i]=='Y') {

				if(blk_slot_arr[i]=='N' && brk_slot_arr[i]=='N') {
					if(res_slot_arr[i] !='N'){
					
						document.getElementById("results").rows(i+1).cells(0).style.backgroundColor = "Bisque";
						document.getElementById("results").rows(i+1).cells(1).style.backgroundColor = "Bisque";
						document.getElementById("results").rows(i+1).cells(0).style.Color = "Black";
						document.getElementById("results").rows(i+1).cells(1).style.Color = "Black";
						document.getElementById("results").rows(i+1).cells(2).style.backgroundColor = "Bisque";
						document.getElementById("results").rows(i+1).cells(2).innerText = "BRU Health Reservation : "+res_slot_arr[i];

					}else {
						document.getElementById("results").rows(i+1).cells(0).style.backgroundColor = "Bisque";
						document.getElementById("results").rows(i+1).cells(1).style.backgroundColor = "Bisque";
					}
				}

				
			}
				
		}
	}
	/* End ML-BRU-CRF-0628.1 */
	</script>

	<%
	}
	if(rs!=null) rs.close();
	if(stmtps !=null) stmtps.close();
	if(statement!=null) statement.close();
	if(stmtsd!=null) stmtsd.close();
	if(stmt!=null) stmt.close();
	if(rsps !=null)rsps.close();
	if (cstmt != null) cstmt.close();
	if (pstmt_label != null) pstmt_label.close();
	if (rs32 != null) rs32.close();
	if (statement_bru != null) statement_bru.close();
}
catch(Exception e){
	e.printStackTrace();
	//out.println(e);
}
finally{
	ConnectionManager.returnConnection(con,request);
}

%>

</body>
</html>

<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}


%>

