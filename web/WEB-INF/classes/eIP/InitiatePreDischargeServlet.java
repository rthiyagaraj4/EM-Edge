/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIP;
 

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import java.net.URLEncoder;
import com.ehis.util.*;

public class InitiatePreDischargeServlet extends javax.servlet.http.HttpServlet	{

	PrintWriter out;
    Properties p;
    String facilityId;
    String login_user;
    String client_ip_address;
    String mode;
    boolean inserted;
    Connection con;
	//Added for this CRF GHL-CRF-0468
	HttpSession httpsession ;
    
	public void init(ServletConfig config) throws ServletException	{ 
		super.init(config);
	}
	public  void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
	        throws javax.servlet.ServletException,IOException
		{
			try {
			    
					httpsession = httpservletrequest.getSession(false);
		            facilityId = (String)httpsession.getValue("facility_id");
		            
		            p = (Properties)httpsession.getValue("jdbc");
		            client_ip_address = p.getProperty("client_ip_address");
		            login_user = p.getProperty("login_user");
		            out = httpservletresponse.getWriter();
		            mode	= httpservletrequest.getParameter("mode");
		            if(mode.equals("update")){
		            	FnInitiatePreDischargeUpdate(httpservletrequest, httpservletresponse);	
		            }
		            
			}
			catch (Exception e){
				//out.println(e.toString());
				e.printStackTrace();
		
			}
		}
	private void FnInitiatePreDischargeUpdate(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)	{
		StringBuffer updateSQL		= new StringBuffer("");	
		try{
			con = ConnectionManager.getConnection(httpservletrequest);
			String AllEncounterIds					= httpservletrequest.getParameter("selectedenc_id");
			String AllPatientIds					= httpservletrequest.getParameter("selectedpat_id");
			String p_called_from_ca					= httpservletrequest.getParameter("p_called_from_ca");
		
			String locale 							= p.getProperty("LOCALE");
			ArrayList<String> EncounterIdList	 	= new ArrayList<String>(); 
			ArrayList<String> PatientIdList	 		= new ArrayList<String>();
			int executableCount=0;
			int result=0;
			int result1=0;
			//Below line added for this CRF GHL-CRF-0468
			int result2=0;
			int result3=0;
			
			String res_nursing_unit			= (httpservletrequest.getParameter("res_nursing_unit")==null || httpservletrequest.getParameter("res_nursing_unit").equals(""))?"":httpservletrequest.getParameter("res_nursing_unit");
			String res_dis_date_from		= (httpservletrequest.getParameter("res_dis_date_from")==null || httpservletrequest.getParameter("res_dis_date_from").equals(""))?"":httpservletrequest.getParameter("res_dis_date_from");
			String res_dis_date_to			= (httpservletrequest.getParameter("res_dis_date_to")==null || httpservletrequest.getParameter("res_dis_date_to").equals(""))?"":httpservletrequest.getParameter("res_dis_date_to");                                                                                                                                                                                                                                                                                               
			String res_Splcode				= (httpservletrequest.getParameter("res_Splcode")==null || httpservletrequest.getParameter("res_Splcode").equals(""))?"":httpservletrequest.getParameter("res_Splcode");                                                                                                                                                                                                                                                                                               
			String res_practid				= (httpservletrequest.getParameter("res_practid")==null || httpservletrequest.getParameter("res_practid").equals(""))?"":httpservletrequest.getParameter("res_practid");                                                                                                                                                                                                                                                                                               
			String res_patient_id			= (httpservletrequest.getParameter("res_patient_id")==null || httpservletrequest.getParameter("res_patient_id").equals(""))?"":httpservletrequest.getParameter("res_patient_id");                                                                                                                                                                                                                                                                                               
			String res_encounter_id			= (httpservletrequest.getParameter("res_encounter_id")==null || httpservletrequest.getParameter("res_encounter_id").equals(""))?"":httpservletrequest.getParameter("res_encounter_id");
			StringBuffer where_criteria = new StringBuffer();
			
			/*Below line added for this CRF GHL-CRF-0468*/
			for(StringTokenizer stringtokenizer = new StringTokenizer(AllEncounterIds, "|#|"); stringtokenizer.hasMoreTokens();)	{
				EncounterIdList.add(stringtokenizer.nextToken());
			}	
          
		    ArrayList alist=(ArrayList)httpsession.getAttribute("encounterList");
			//where_criteria.append(" and facility_id='"+facilityId+"'");

			if(!res_nursing_unit.equals("")){
				where_criteria.append(" and nursing_unit_code='"+res_nursing_unit+"'");
			}
			if(!res_dis_date_from.equals("")){
				where_criteria.append(" and trunc(admission_date_time) >= to_date('");
				where_criteria.append(res_dis_date_from);
				where_criteria.append("' , 'dd/mm/rrrr') ");
			}
			if(!res_dis_date_to.equals("")){
				where_criteria.append(" and trunc(admission_date_time) <= to_date('");
				where_criteria.append(res_dis_date_to);
				where_criteria.append("' , 'dd/mm/rrrr') ");
			}
			if(!res_Splcode.equals("")){
				where_criteria.append(" and specialty_code='"+res_Splcode+"'");
			}
			if(!res_practid.equals("")){
				where_criteria.append(" and attend_practitioner_id='"+res_practid+"'");
			}
			if(!res_patient_id.equals("")){
				where_criteria.append(" and patient_id like '%"+res_patient_id+"%'");
			}
			if(!res_encounter_id.equals("")){
				where_criteria.append(" and encounter_id='"+res_encounter_id+"'");
			}
			
			
			//String sql1	="update ip_open_encounter set pre_dis_initiate_yn='N' " +
			updateSQL.delete(0, updateSQL.length());
			updateSQL.append("update ip_open_encounter set pre_dis_initiate_yn='N' ");
			//updating audit columns
			updateSQL.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
			//updateSQL.append(" where ENCOUNTER_ID is not null " + where_criteria.toString());
			/*Below line added for this CRF GHL-CRF-0468*/
			updateSQL.append(" where facility_id =? and ENCOUNTER_ID =? " + where_criteria.toString());
			
		   String sql1 = updateSQL.toString();
						
		   PreparedStatement prep1 =  con.prepareStatement(sql1);
			
		   Iterator openenounterItr=alist.iterator();  
		   while(openenounterItr.hasNext()){  
		   String old_openencounterId = (String)openenounterItr.next();   
		   String existsopenEncounterId="";
		   if(!EncounterIdList.contains(old_openencounterId)){
			  existsopenEncounterId=old_openencounterId;
			  
		    }
			/*else{
			   existsopenEncounterId=old_openencounterId;			   
			}*/		
			if(!existsopenEncounterId.equals("")){			
			prep1.setString	( 1, facilityId) ;
			prep1.setString	( 2, login_user);
			prep1.setString	( 3, client_ip_address);
			prep1.setString	( 4, facilityId);
			prep1.setString	( 5, existsopenEncounterId);						
			//result1 = prep1.executeUpdate();
			prep1.addBatch();
			}
         }
			
			int[] predisCount = prep1.executeBatch();
			result1	 = predisCount.length;
			
					
		/*Below line added for this CRF GHL-CRF-0468*/
		updateSQL.delete(0, updateSQL.length());
		where_criteria.delete(0, where_criteria.length());
				  		
			if(!res_nursing_unit.equals("")){
				where_criteria.append(" and assign_care_locn_code='"+res_nursing_unit+"'");
			}
			if(!res_dis_date_from.equals("")){
				where_criteria.append(" and trunc(visit_adm_date_time) >= to_date('");
				where_criteria.append(res_dis_date_from);
				where_criteria.append("' , 'dd/mm/rrrr') ");
			}
			if(!res_dis_date_to.equals("")){
				where_criteria.append(" and trunc(visit_adm_date_time) <= to_date('");
				where_criteria.append(res_dis_date_to);
				where_criteria.append("' , 'dd/mm/rrrr') ");
			}
			if(!res_Splcode.equals("")){
				where_criteria.append(" and specialty_code='"+res_Splcode+"'");
			}
			if(!res_practid.equals("")){
				where_criteria.append(" and attend_practitioner_id='"+res_practid+"'");
			}
			if(!res_patient_id.equals("")){
				where_criteria.append(" and patient_id like '%"+res_patient_id+"%'");
			}
			if(!res_encounter_id.equals("")){
				where_criteria.append(" and encounter_id='"+res_encounter_id+"'");
			}
           			
			updateSQL.append("update pr_encounter set pre_dis_initiated_date_time = ? , pre_dis_initiated_user =? ");
			updateSQL.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
			//updateSQL.append(" where ENCOUNTER_ID is not null " + where_criteria.toString());
			/*Below line added for this CRF GHL-CRF-0468*/
			updateSQL.append(" where facility_id =? and  ENCOUNTER_ID =? " + where_criteria.toString());
         	  
			
		PreparedStatement prep2 =  con.prepareStatement(updateSQL.toString());
	  
		
		Iterator itr=alist.iterator();  
		while(itr.hasNext()){  
		   String old_encounterId = (String)itr.next();   
		   String existsEncounterId="";
		   if(!EncounterIdList.contains(old_encounterId)){
		      //System.err.println("If contains");
			  existsEncounterId=old_encounterId;
			  
		    }
			/*else{
			   existsEncounterId=old_encounterId;
			   System.err.println("InitiatePreDischargeServlet.java existsEncounterId===>"+existsEncounterId);
			}*/			
			if(!existsEncounterId.equals("")){			
				prep2.setString	( 1, "") ;
				prep2.setString	( 2, "") ;
				//prep2.setString	( 2, login_user);
				prep2.setString	( 3, facilityId) ;
				prep2.setString	( 4, login_user);
				prep2.setString	( 5, client_ip_address);
				prep2.setString	( 6, facilityId);
				prep2.setString	( 7, existsEncounterId);           
				prep2.addBatch();
            } 
        }
          		
			int[] predisCount1 = prep2.executeBatch();
			result3	 = predisCount1.length;
			           
		//End this CRF GHL-CRF-0468
			
			//Below line modified for this GHL-CRF-0468
			
			if(result1 > 0 || result3 > 0){  
				con.commit();
			}
			prep1.close();
			if(prep2!=null) prep2.close();
					
			
			
			for(StringTokenizer stringtokenizer1 = new StringTokenizer(AllPatientIds, "|#|"); stringtokenizer1.hasMoreTokens();)	{
				PatientIdList.add(stringtokenizer1.nextToken());
			}
		
		     
			httpservletrequest.setCharacterEncoding("UTF-8");
			httpservletresponse.setContentType("text/html;charset=UTF-8");
			
			
			//String sql	="update ip_open_encounter set pre_dis_initiate_yn='Y' where ENCOUNTER_ID=? and PATIENT_ID=? and FACILITY_ID=?";
			//PreparedStatement prep =  con.prepareStatement(sql);
						
					
			updateSQL.delete(0, updateSQL.length());
			updateSQL.append("update ip_open_encounter set pre_dis_initiate_yn='Y' ");
			//updating audit columns
			updateSQL.append(", modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ? ");
			updateSQL.append(" where ENCOUNTER_ID=? and PATIENT_ID=? and FACILITY_ID=?");
			PreparedStatement prep =  con.prepareStatement(updateSQL.toString());
			
			
			for (int i = 0; i < EncounterIdList.size(); i++){
				String enc_id = EncounterIdList.get(i);
				String pat_id = PatientIdList.get(i);
				if(!enc_id.equals("") && !pat_id.equals("")){
					executableCount++;
					prep.setString(1, facilityId) ;
					prep.setString(2, login_user);
					prep.setString(3, client_ip_address);
					prep.setString(4, enc_id);
					prep.setString(5, pat_id);
					prep.setString(6, facilityId);
					prep.addBatch();
				}
				
			}
			
			if(executableCount >0){
				int[] no = prep.executeBatch();
				result	 = no.length;
			}
			prep.close();
			
		/*Below line added for this CRF GHL-CRF-0468*/
			updateSQL.delete(0, updateSQL.length());
			updateSQL.append("update pr_encounter set pre_dis_initiated_date_time = sysdate, modified_date = sysdate, modified_facility_id = ?, modified_by_id = ?, modified_at_ws_no = ?, pre_dis_initiated_user = ? where FACILITY_ID=? and ENCOUNTER_ID=?");
			prep =  con.prepareStatement(updateSQL.toString());	
            for (int j = 0; j < EncounterIdList.size(); j++){
				String encounterId = EncounterIdList.get(j);				
				  if(!encounterId.equals("")){
						prep.setString(1, facilityId) ;
						prep.setString(2, login_user);
						prep.setString(3, client_ip_address);
						prep.setString(4, login_user);
						prep.setString(5, facilityId);
						prep.setString(6, encounterId);					
						prep.addBatch();
				  }
		    }
           int[] prEncounterUpdate = prep.executeBatch();
		   result2	 = prEncounterUpdate.length;			
		   if(prep!=null) prep.close();           
		/*End this CRF GHL-CRF-0468*/			
			if(result > 0 || result2 > 0){ 
				con.commit();
			}
			
		//Added for this CRF GHL-CRF-0468
		httpsession.removeAttribute("encounterList");
			
			if((result > 0 || result2 > 0) || (result1 > 0 || result3 > 0)){
				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED", "SM");
				String error = ((String) message.get("message"));
				out.println("<html><script>parent.frames[1].location.href ='../eIP/jsp/InitiatePreDischargeCriteria.jsp?p_called_from_ca="+p_called_from_ca+"';parent.frames[2].location.href ='../eCommon/jsp/error.jsp?err_num="+error+"';</script><body class='message'></html>");
				
			}else{ 
				con.rollback();
				java.util.Hashtable message = MessageManager.getMessage(locale, "FAILED_TRANSACTION", "SM");
				String error =((String) message.get("message"));
				out.println("<html><script>parent.frames[1].location.href ='../eIP/jsp/InitiatePreDischargeCriteria.jsp?p_called_from_ca="+p_called_from_ca+"';parent.frames[2].location.href ='../eCommon/jsp/error.jsp?err_num="+error+"';</script><body class='message'></html>");
			}
			
			
		}catch ( Exception e ) {
			e.printStackTrace();
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ; */
		}finally{
			if(con != null)  ConnectionManager.returnConnection(con, httpservletrequest);
		}
		
	}
} // end class
