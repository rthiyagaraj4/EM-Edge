<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.text.*" %>


<%! String getFrameHeaderData(String p_locn_id, String p_pract_id,Connection con,String fid,boolean multi,String roomnum)
  {
	StringBuffer headers=new StringBuffer();
	PreparedStatement stmt =null ; 
	ResultSet rset =null;
	StringBuffer sql=new StringBuffer();		
	try
	{

		sql.append("SELECT SUM(DECODE(APPT_OR_WALK_IN_IND,'A',1,0)) Appt, SUM(CASE WHEN QUEUE_STATUS IN ('01','02') THEN 1 ELSE 0 END ) INR, SUM(CASE WHEN VITAL_SIGNS_DATE_TIME IS NOT NULL THEN 1 ELSE 0 END) VITAL, SUM(CASE WHEN CONS_SRVC_START_DATE_TIME IS NOT NULL AND CONS_SRVC_END_DATE_TIME IS NULL THEN 1 ELSE 0 END) SEEN, SUM(CASE WHEN CONS_SRVC_START_DATE_TIME IS NULL AND QUEUE_STATUS IN ('01','02') THEN 1 ELSE 0 END ) WAIT FROM OP_CURRENT_PATIENT ");
		sql.append("WHERE locn_code =nvl('"+p_locn_id+"',locn_code) and practitioner_id = nvl('"+p_pract_id+"','*ALL')  ");
		sql.append("and facility_id='"+fid+"'  and trunc(queue_date) = trunc(sysdate)"); 
 	  
		stmt=con.prepareStatement(sql.toString());		
		rset=stmt.executeQuery();
		
		headers.setLength(0);

		while(rset.next())
		{
			headers.append((rset.getString("Appt")==null?"0":rset.getString("Appt"))+";");
			headers.append((rset.getString("INR")==null?"0":rset.getString("INR"))+";");
			headers.append((rset.getString("Vital")==null?"0":rset.getString("Vital"))+";");
			if(multi)
				headers.append((rset.getString("Seen")==null?"0":rset.getString("Seen"))+";");

			headers.append((rset.getString("Wait")==null?"0":rset.getString("Wait"))+";~");
		}

		sql.setLength(0);
	}
	catch(Exception e)
	{
		//headers=e.toString()+"&nbsp;&nbsp;&nbsp;"+sql.toString();	
	}
	finally
	{
		try
		{
		if(rset!=null)	rset.close();
		if(stmt!=null) 	stmt.close();
		
		}
		catch(Exception e){}
	}
	
	return(headers.toString());
  }
%>
<%! String getFrameDetailData(String p_locn_id, String p_pract_id,String starttime, Connection con,String fid,boolean count, String order,String roomnum,String localeName,String login_user,String p_operator_station,PageContext pageContext)
     {
        
    StringBuffer headers=new StringBuffer();
	PreparedStatement stmt   =null ;
	ResultSet rset   =null;
	StringBuffer sql=new StringBuffer();
	String queue_status = "";
	String p_status = "";

	if(roomnum.equals(""))
		roomnum = "X";
	
   	try
	{
		
		
		sql.append("SELECT to_char(appt_time,'hh24:mi') Appt_time, queue_num, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, arrival_status, no_show,queue_status queue_status , appt_confirm_yn, case_type ,waiting_time, visit_type,op_get_desc.OP_VISIT_TYPE(facility_id,visit_adm_type,'"+localeName+"',2) visit_type_desc,encounter_id , patient_id, visit_adm_type, pat_curr_locn_code locn_code, pat_curr_locn_type, practitioner_id, care_locn_type_ind, sex, date_of_birth, room_num, appt_id, TO_CHAR(queue_date,'dd/mm/yyyy') queue_date, TO_CHAR(arrive_date_time,'dd/mm/yyyy hh24:mi') arrive_date_time, op_get_desc.op_clinic(facility_id,locn_code,'"+localeName+"',1) current_location, visit_adm_type_ind, appt_case_yn, vital_signs_date_time, other_res_class, queue_id, queue_status  p_status, queue_status queue_status1, to_char(decode(Queue_status,'01',check_in_date_time,'02',arrive_date_time,'03',vital_signs_date_time,'04',cons_srvc_start_date_time,'05',null,'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') dt, other_resource_id other_res_code, case_type appt_walk_ind, service_code, referral_id, contact_reason_code, am_get_desc.am_contact_reason(contact_reason_code,'"+localeName+"',1) contact_reason_desc, a.resource_class res_class,a.qms_call_count,episode_id,op_episode_visit_num  ");
		sql.append("FROM  OP_CURRENT_PATIENT_VW  A ");
	
		sql.append("WHERE locn_code=? and nvl(practitioner_id,'X')=nvl(?,'X')  AND EXISTS (SELECT locn_code  FROM am_os_user_locn_access_vw   WHERE facility_id = a.facility_id AND locn_code = a.locn_code AND LOCN_TYPE=a.LOCN_TYPE and oper_stn_id = '"+p_operator_station+"'  AND appl_user_id = '"+login_user+"')");
			
		sql.append(" and queue_status < decode('N','Y','08','07') and facility_id=?  ");
		sql.append(" and level_of_care_ind='A' and trunc(queue_date) = trunc(sysdate) ");
		sql.append(" and to_date(to_char(queue_date,'HH24:MI'),'HH24:MI') >= to_date(?,'HH24:MI') and nvl(room_num,'X') = '"+roomnum+"' ");
		
		if(order.equals("yes"))
			sql.append( " ORDER BY  visit_type ,case_type, appt_time,queue_num ");
		else
		sql.append(" ORDER BY  case_type, appt_time,queue_num ");

		stmt=con.prepareStatement(sql.toString());
		stmt.setString(1,p_locn_id);		
		stmt.setString(2,p_pract_id);		
		stmt.setString(3,fid);		
		stmt.setString(4,starttime);	 
		rset=stmt.executeQuery();
		
		headers.setLength(0);

		while(rset.next())
		{
			if(count)
			{
			headers.append(rset.getString(1));
				break;
			}		
			else
			{
				headers.append(rset.getString("Appt_time")+";" );
				headers.append(rset.getString("queue_num")+";" );
				headers.append(rset.getString("arrival_status")+";" );
				queue_status = rset.getString("queue_status");
						
				if(queue_status.equals("01"))
				{				queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.in.label","common_labels");
				}
				else if(queue_status.equals("02"))	
				{
				queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.NS.label","op_labels");
				}
				else if(queue_status.equals("03"))	
				{	queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VS.label","op_labels");
				}
				else if(queue_status.equals("04"))																
				{					queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.PR.label","op_labels");
				}
				else if(queue_status.equals("05"))	
				{	
				queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.TR.label","op_labels");
				}
				else if(queue_status.equals("06"))	
				{	
				queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.WT.label","op_labels");
				}
				else if(queue_status.equals("07"))	
				{	
				queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.XT.label","op_labels");
				}

				headers.append(queue_status+";" );

				headers.append(rset.getString("patient_name")+";" );
				headers.append(rset.getString("waiting_time")+";");
				
				headers.append(rset.getString("no_show")+";");
				headers.append(rset.getString("appt_confirm_yn")+";"); 
				headers.append(rset.getString("case_type")+";");
			
				headers.append(rset.getString("visit_type")+";");
				
				headers.append(rset.getString("visit_type_desc")+";");				
				headers.append(String.valueOf(rset.getLong("encounter_id"))+";");
				headers.append(rset.getString("patient_id")+";");
				headers.append(rset.getString("visit_adm_type")+";");
				headers.append(rset.getString("locn_code")+";");
				headers.append(rset.getString("pat_curr_locn_type")+";");
				headers.append(rset.getString("practitioner_id")+";");
				headers.append(rset.getString("care_locn_type_ind")+";");
				headers.append(rset.getString("sex")+";");
				headers.append(rset.getString("date_of_birth")+";");
				headers.append(rset.getString("room_num")+";");
				headers.append(rset.getString("appt_id")+";");
				headers.append(rset.getString("queue_date")+";");
				headers.append(rset.getString("arrive_date_time")+";");
				headers.append(rset.getString("current_location")+";");
				headers.append(rset.getString("visit_adm_type_ind")+";");
				headers.append(rset.getString("appt_case_yn")+";");
				headers.append(rset.getString("vital_signs_date_time")+";");
				headers.append(rset.getString("other_res_class")+";");
				headers.append(rset.getString("other_res_code")+";");
				headers.append(rset.getString("appt_walk_ind")+";");
				headers.append(rset.getString("queue_id")+";");
				headers.append(rset.getString("queue_status1")+";");
				headers.append(rset.getString("dt")+";");
				p_status = rset.getString("p_status");
				
				if(p_status.equals("01"))
				{				 p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckedIn.label","op_labels");
				}
				else if(p_status.equals("02"))	
				{				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ArrivedAtNursStn.label","op_labels");
				}
				else if(p_status.equals("03"))	
				{				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.InitChkUpORVtlSgnRec.label","op_labels");
				}
				else if(p_status.equals("04"))		
				{				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
				}
				else if(p_status.equals("05"))	
				{				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.UndergoingTrtORInvst.label","op_labels");
				}
				else if(p_status.equals("06"))	
				{				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RetFrmInvest.label","op_labels");
				}					

				headers.append(rset.getString("service_code")+";");
				headers.append(rset.getString("referral_id")+";");
				headers.append(rset.getString("contact_reason_code")+";");
				headers.append(rset.getString("contact_reason_desc")+";");
				headers.append(rset.getString("res_class")+";" );
				headers.append(rset.getString("qms_call_count")+";" );
				headers.append(rset.getString("episode_id")+";" );
				headers.append(rset.getString("op_episode_visit_num")+";" );
				headers.append(p_status+"~");
				
			}
		}
		sql.setLength(0);
	}
	catch(Exception e){}
	
	finally
	{
		try
		{
		if(rset!=null)	rset.close();
		if(stmt!=null) 	stmt.close();
		
		}
		catch(Exception e){}
	}	
	return(headers.toString());
     }
%>
