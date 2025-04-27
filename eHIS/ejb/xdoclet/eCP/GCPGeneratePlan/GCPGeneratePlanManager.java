/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This File is saved on 18/10/2005.
/*
*	Copyright MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Filename		:	
*	Purpose 		:	
*	Created By	:	
	Modified By : 
*	Created On	:
*/
package eCP.GCPGeneratePlan;
import java.sql.*;
import java.util.*;
import javax.ejb.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
/**
*
* @ejb.bean
*	name="GCPGeneratePlan"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="GCPGeneratePlan"
*	local-jndi-name="GCPGeneratePlan"
*	impl-class-name="eCP.GCPGeneratePlan.GCPGeneratePlanManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCP.GCPGeneratePlan.GCPGeneratePlanLocal"
*	remote-class="eCP.GCPGeneratePlan.GCPGeneratePlanRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCP.GCPGeneratePlan.GCPGeneratePlanLocalHome"
*	remote-class="eCP.GCPGeneratePlan.GCPGeneratePlanHome"
*	generate= "local,remote"
*
*
*/
public class GCPGeneratePlanManager implements SessionBean{
Connection con;
PreparedStatement ps,pstmt,ps1,ps2,ps3,pstmt1;
CallableStatement cstmt 		= null;
ResultSet rs;
HashMap hashTable = new HashMap();
String addedId ="";
String facilityId = "" ;
String client_ip_addr="";
String errorMsg			= "";

public GCPGeneratePlanManager() {
        ps = null;ps1 = null;ps2 = null;ps3  = null ;pstmt=null;pstmt1=null;rs=null;
    }
public void ejbCreate() throws  CreateException {
    }
public void ejbRemove() {
    }
public void ejbActivate() {
    }
public void ejbPassivate() {
    }
public void setSessionContext(SessionContext sessioncontext) {
}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/	
public HashMap generateCarePlan(Properties properties, HashMap tabData)
{
	boolean flag = false;
	boolean	commit_flag	=	true;
	String locale;
	try
	{
		con = ConnectionManager.getConnection(properties);
	   
		addedId			= (String)tabData.get("added_by_id");
		facilityId		= (String)tabData.get("added_facility_id");
		client_ip_addr	= (String)tabData.get("added_at_ws_no");
		locale=(String)tabData.get("locale");
		String patient_id		= "";
		long encounter_id		= 0;
		int count=0, srl_no=0, goal_srl_no=0, outcome_srl_no=0, i=0, duration=0, intervention_srlno=0, version_no=0, tcode_cnt=0;
		int cp_mdcp_seq = 0, cp_care_plan_seq = 0;
		
	
		String cm_pract_id		= "";
		String curr_care_manager_id = "";
		String case_type_code	= "";
		String outcome_code		= "", target_date="", goal_target_date="", outcome_target_date="";
		String library_id		= "";
		String term_set_id		= "",term_code="",goal_code="";
		String care_plan_start_date="",care_plan_end_date="",start_date="",end_date="";
		String intervention_code = "",intervention_type = "", freq_code = "",durn_type = "",durn="",i_cnt="",priority="",position_code="",role_type="",stage_code="";
		Long encount_id		= 		new Long(1);
		Integer cnt			= 		new Integer(1);
		Integer ver_no		= 		new Integer(1);
		String goal_stmt	= "";
		int inserted =0;
		ArrayList term_array=new ArrayList();
		boolean term_flag=false;
		//System.err.println("hello1");
		try
		{	

			cnt						= 	(Integer)	tabData.get("tcode_cnt");
			tcode_cnt				=	cnt.intValue();
			patient_id				=  	(String)	tabData.get("patient_id");
			encount_id				= 	(Long)	tabData.get("encounter_id");
			encounter_id			=	encount_id.longValue();
			cm_pract_id				= 	(String)	tabData.get("cm_pract_id");
			curr_care_manager_id	=	(String)	tabData.get("curr_care_manager");
			care_plan_start_date	=	(String)	tabData.get("care_plan_start_date");
			care_plan_end_date		=	(String)	tabData.get("care_plan_end_date"); 
			goal_stmt				= 	(String)	tabData.get("goal_stmt");
			srl_no=1;
			//System.err.println("tcode_cnt+patient_id+encounter_id+cm_pract_id+curr_care_manager_id+care_plan_start_date+care_plan_end_date+goal_stmt==>"+tcode_cnt+":="+patient_id+":="+encounter_id+":="+cm_pract_id+":="+curr_care_manager_id+":="+care_plan_start_date+":="+care_plan_end_date+":="+goal_stmt);
			try
			{
				ps = con.prepareStatement("SELECT MD_CARE_PLAN_ID FROM CP_PAT_MD_CARE_PLAN WHERE PATIENT_ID= ? AND STATUS='A' ");
				ps.setString(1,patient_id);
				//System.err.println("hello2 : patient_id="+patient_id);
				rs = ps.executeQuery();
				//System.err.println("hello3");
				if(rs.next())
				{					
					cp_mdcp_seq = rs.getInt(1);
					inserted=1;
					//System.err.println("hello3="+cp_mdcp_seq);
				}
				else
				{
					if(ps != null)
					{
						ps.close();						
					}
					if(rs!= null)
					{
						rs.close();						
					}
					ps = con.prepareStatement("SELECT CP_MDCP_SEQ.NEXTVAL FROM DUAL");
					//System.err.println("hello4");
					rs = ps.executeQuery();
					//System.err.println("hello5");
					if(rs.next())
					{					
						cp_mdcp_seq = rs.getInt(1);
					}
					//System.err.println("hello5 : cp_mdcp_seq="+cp_mdcp_seq);							
					ps = con.prepareStatement("INSERT INTO CP_PAT_MD_CARE_PLAN (MD_CARE_PLAN_ID, PATIENT_ID, STATUS,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)VALUES (?,?,?,?,sysdate,?,?,?, sysdate,?,?)");
					
					ps.setInt(1,cp_mdcp_seq);
					ps.setString(2,patient_id);
					ps.setString(3,"A");
					ps.setString(4,addedId);
					ps.setString(5,client_ip_addr);
					ps.setString(6,facilityId);
					ps.setString(7,addedId);
					ps.setString(8,client_ip_addr);
					ps.setString(9,facilityId);
					//System.err.println("hello6 ");
					inserted = ps.executeUpdate();
					//System.err.println("hello7+inserted=>"+inserted);
				}
				if(ps != null)
				{
						ps.close();
						
				}
				if(rs!= null)
				{
						rs.close();
						
				}
				if(cp_mdcp_seq > 0)
				{

					ps = con.prepareStatement("SELECT CP_CARE_PLAN_SEQ.NEXTVAL FROM DUAL ");
					//System.err.println("hello8");
					rs = ps.executeQuery();
					//System.err.println("hello9");
					if(rs.next())
					{
						cp_care_plan_seq = rs.getInt(1);
					}
					//System.err.println("cp_care_plan_seq="+cp_care_plan_seq);
					if(ps != null)
					{
						ps.close();
						
					}
					if(rs!= null)
					{
						rs.close();
						
					}
					if(inserted>0)
					{
						ps = con.prepareStatement("INSERT INTO CP_PAT_CARE_PLAN (MD_CARE_PLAN_ID,CARE_PLAN_ID,PATIENT_ID, CREATED_FACILITY_ID,CREATED_ENCOUNTER_ID, CREATED_PRACT_ID,CREATED_DATE,FINALIZED_PRACT_ID,FINALIZED_DATE,CARE_PLAN_START_DATE,CARE_PLAN_TARGET_DATE,CURRENT_FACILITY_ID,CURRENT_ENCOUNTER_ID,CURRENT_STATUS,STATUS_FACILITY_ID,STATUS_ENCOUNTER_ID,STATUS_PRACT_ID,STATUS_DATE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID, GOAL_STATEMENT,CURRENT_CARE_MANAGER_ID)VALUES (?,?,?,?,?,?,sysdate,?,?,To_date(?,'dd/mm/yyyy hh24:mi'),To_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,sysdate,?,sysdate,?,?,?, sysdate,?,?,?,?)");

						ps.setInt(1,cp_mdcp_seq);
						ps.setInt(2,cp_care_plan_seq);
						ps.setString(3,patient_id);
						ps.setString(4,facilityId);
						ps.setLong(5,encounter_id);
						ps.setString(6,cm_pract_id);
						ps.setString(7,"");
						ps.setString(8,"");
						ps.setString(9,care_plan_start_date);
						ps.setString(10,care_plan_end_date);
						ps.setString(11,facilityId);
						ps.setLong(12,encounter_id);
						ps.setString(13,"O");
						ps.setString(14,facilityId);
						ps.setLong(15,encounter_id);
						ps.setString(16,cm_pract_id);
						ps.setString(17,addedId);
						ps.setString(18,client_ip_addr);
						ps.setString(19,facilityId);
						ps.setString(20,addedId);
						ps.setString(21,client_ip_addr);
						ps.setString(22,facilityId);  
						ps.setString(23,goal_stmt);
						ps.setString(24,curr_care_manager_id);
						try
						{
							//System.err.println("hello10");
							inserted = ps.executeUpdate();
							//System.err.println("hello11+inserted=>"+inserted);
							if(ps!= null)
							{
								ps.close();
								
							}
						}
						catch(Exception ee)
						{
						ee.printStackTrace();
						}
					}
					if(inserted>0)
					{
						ps = con.prepareStatement("INSERT INTO CP_PAT_CARE_PLAN_MANAGER (MD_CARE_PLAN_ID, CARE_PLAN_ID, CARE_MANAGER_ID, EFF_DATE_FROM, EFF_DATE_TO, PATIENT_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE,MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, SRL_NO)VALUES (?,?,?,sysdate,sysdate,?,?,sysdate,?,?,?, sysdate,?,?,?)");					
						ps.setInt(1,cp_mdcp_seq);
						ps.setInt(2,cp_care_plan_seq);
						ps.setString(3,cm_pract_id);
						ps.setString(4,patient_id);
						ps.setString(5,addedId);
						ps.setString(6,client_ip_addr);
						ps.setString(7,facilityId);
						ps.setString(8,addedId);
						ps.setString(9,client_ip_addr);
						ps.setString(10,facilityId);
						ps.setInt(11,srl_no);
						//System.err.println("srl_no="+srl_no);
						//System.err.println("hello12");
						inserted = ps.executeUpdate();
						//System.err.println("hello13+inserted=>"+inserted);
						if(ps!= null)
						{
							ps.close();
							
						}
					}
					String grp_id="";int out_cnt=0,intvn_cnt=0,group_id=0;
					String tmp_chk="";
					Integer out_cnt2=new Integer(1);
					Integer intvn_cnt2=new Integer(1);
					ps = con.prepareStatement("INSERT INTO CP_PAT_CARE_PLAN_TERM_CODE(MD_CARE_PLAN_ID,CARE_PLAN_ID,TERM_SET_ID, TERM_CODE,TERM_CODE_SRL_NO,PATIENT_ID, CASE_TYPE_CODE, LIBRARY_ID,VERSION_NO,REVISION_YN,REVISION_ID,STATUS,TARGET_DATE,ADDED_BY_ID,ADDED_DATE ,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,APPL_YN)VALUES (?,?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,sysdate,?,?,?,sysdate,?,?,?)");
					ps1 = con.prepareStatement("INSERT INTO CP_PAT_CARE_PLAN_GOAL (MD_CARE_PLAN_ID, CARE_PLAN_ID, TERM_SET_ID, TERM_CODE, TERM_CODE_SRL_NO, GOAL_CODE, GOAL_TARGET_DATE, PATIENT_ID, REVISION_YN, REVISION_ID, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, GOAL_SRL_NO, STATUS_DATE,APPL_YN)VALUES(?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?)");	
					ps2 = con.prepareStatement("INSERT INTO CP_PAT_CARE_PLAN_OUTCOME(MD_CARE_PLAN_ID, CARE_PLAN_ID, TERM_SET_ID, TERM_CODE, TERM_CODE_SRL_NO, GOAL_CODE, OUTCOME_CODE, OUTCOME_TARGET_DATE, PATIENT_ID, REVISION_YN, REVISION_ID, STATUS, STATUS_DATE, REASON_CODE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, GOAL_SRL_NO, OUTCOME_SRL_NO,GROUP_ID,APPL_YN)VALUES (?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?)");
					ps3 = con.prepareStatement("INSERT INTO CP_PAT_CARE_PLAN_INTVN(MD_CARE_PLAN_ID, CARE_PLAN_ID, TERM_SET_ID, TERM_CODE, TERM_CODE_SRL_NO, GOAL_CODE, INTERVENTION_CODE, PATIENT_ID, INTERVENTION_TYPE, REVISION_YN, REVISION_ID, STATUS, STATUS_DATE, REASON_CODE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, GOAL_SRL_NO, INTERVENTION_SRL_NO,GROUP_ID,APPL_YN)VALUES (?,?,?,?,?,?,?,?,(SELECT A.INTERVENTION_TYPE FROM CA_INTERVENTION A WHERE A.INTERVENTION_CODE Like (?)),?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?)");
					for (int tc=0 ;tc < tcode_cnt ;tc++ )
					{
						try{
						srl_no=1;goal_srl_no=1;intervention_srlno=1;outcome_srl_no=1;
						term_set_id			 = (String)tabData.get("term_set_id"+tc);
						term_code			 = (String)tabData.get("term_code"+tc);
						library_id			 = (String)tabData.get("library_id"+tc);
						ver_no			 = (Integer)tabData.get("version_no"+tc);
						version_no			 = ver_no.intValue();	
						target_date			 = (String)tabData.get("target_date"+tc);
						goal_code			 = (String)tabData.get("goal_code"+tc);
						out_cnt2			 = (Integer)tabData.get("out_cnt"+tc);
						out_cnt				 = out_cnt2.intValue();	
						intvn_cnt2			 = (Integer)tabData.get("intvn_cnt"+tc);
						intvn_cnt			 = intvn_cnt2.intValue();	
						tmp_chk = term_set_id+","+term_code ;
						//System.err.println("tmp_chk:="+tmp_chk);
						if(term_array.contains(tmp_chk)){
							term_flag = true;
						}else{
							term_array.add(tmp_chk);
							term_flag = false;
						}
						//System.err.println("term_flag:="+term_flag);
						if(inserted>0)
						{
							if(!term_code.equals(""))
							{
								if(term_flag == false)
								{
									ps.setInt(1,cp_mdcp_seq);
									ps.setInt(2,cp_care_plan_seq);
									ps.setString(3,term_set_id);
									ps.setString(4,term_code);
									ps.setInt(5,srl_no);
									//System.err.println("srl_no2:="+srl_no);
									ps.setString(6,patient_id);
									ps.setString(7,case_type_code);
									ps.setString(8,library_id);
									ps.setInt(9,version_no);
									ps.setString(10,"N");
									ps.setNull(11,Types.NUMERIC);   // REVISION_ID
									ps.setString(12,"O");
									ps.setString(13,target_date);
									ps.setString(14,addedId);
									ps.setString(15,client_ip_addr);
									ps.setString(16,facilityId);
									ps.setString(17,addedId);
									ps.setString(18,client_ip_addr);
									ps.setString(19,facilityId);  
									ps.setString(20,"Y");  
									try
									{
										//System.err.println("hello14");
										inserted = ps.executeUpdate();
										//System.err.println("hello15+inserted=>"+inserted);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}						
								}  //ends the term_flag lup
							}
						}
						if(inserted>0)
						{                    
							goal_target_date = target_date;
							ps1.setInt(1,cp_mdcp_seq);
							ps1.setInt(2,cp_care_plan_seq);
							ps1.setString(3,term_set_id);
							ps1.setString(4,term_code);
							ps1.setInt(5,srl_no);
							ps1.setString(6,goal_code);
							ps1.setString(7,goal_target_date);
							//System.err.println("goal_target_date:="+goal_target_date);
							ps1.setString(8,patient_id);
							ps1.setString(9,"N");
							ps1.setNull(10,Types.NUMERIC); // REVISION_ID
							ps1.setString(11,"O");  
							ps1.setString(12,addedId);
							ps1.setString(13,client_ip_addr);
							ps1.setString(14,facilityId);
							ps1.setString(15,addedId);
							ps1.setString(16,client_ip_addr);
							ps1.setString(17,facilityId);  
							ps1.setInt(18,goal_srl_no);
							//System.err.println("goal_srl_no:="+goal_srl_no);
							ps1.setString(19,"Y");									
							try
							{
							//	System.err.println("hello16");
								inserted = ps1.executeUpdate();
							//	System.err.println("hello17+inserted=>"+inserted);
							}
							catch(Exception e)
							{
								e.printStackTrace();
								//System.err.println("hello171");
								if(ps1 != null)
									ps1.close();
							}
						}
						if(inserted>0)
						{
							for(int out_tmp=0;out_tmp<out_cnt;out_tmp++)
							{						
								outcome_code = (String)tabData.get("outcome_code"+out_tmp+tc);
								grp_id		 = (String)tabData.get("out_group_id"+out_tmp+tc);
								group_id	 = Integer.parseInt(grp_id);
								//System.err.println("outcome_code+group_id==> "+outcome_code+":="+group_id);
								if(!outcome_code.equals(""))
								{								
									outcome_target_date = target_date;
									ps2.setInt(1,cp_mdcp_seq);
									ps2.setInt(2,cp_care_plan_seq);
									ps2.setString(3,term_set_id);
									ps2.setString(4,term_code);
									ps2.setInt(5,srl_no);
									ps2.setString(6,goal_code);
									ps2.setString(7,outcome_code);
									ps2.setString(8,outcome_target_date);
									ps2.setString(9,patient_id);
									ps2.setString(10,"N");
									ps2.setNull(11,Types.NUMERIC);
									ps2.setString(12,"O");
									ps2.setString(13,"");//status_date
									ps2.setString(14,"");//reason_code
									ps2.setString(15,"");//remarks
									ps2.setString(16,addedId);
									ps2.setString(17,client_ip_addr);
									ps2.setString(18,facilityId);
									ps2.setString(19,addedId);
									ps2.setString(20,client_ip_addr);
									ps2.setString(21,facilityId); 
									ps2.setInt(22,goal_srl_no); 
									ps2.setInt(23,outcome_srl_no); 
									ps2.setInt(24,group_id); //GROUP_ID
									ps2.setString(25,"Y");
									try
									{	
										//System.err.println("hello18");
										inserted = ps2.executeUpdate();
										//System.err.println("hello19+inserted=>"+inserted);
									}
									catch(Exception e)
									{
										//System.err.println("hello191");
										if(ps2 != null)
										{
											ps2.close();											
										}
										e.printStackTrace();
									}		
								}
							}
						}
						if(inserted>0)
						{
							for(int inv_tmp=0;inv_tmp<intvn_cnt;inv_tmp++)
							{						
								intervention_code = (String)tabData.get("intervent_code"+inv_tmp+tc);
								grp_id		 = (String)tabData.get("int_group_id"+inv_tmp+tc);
								group_id	 = Integer.parseInt(grp_id);
								//System.err.println("intervention_code+group_id==> "+intervention_code+":="+group_id);
								if(!intervention_code.equals(""))
								{

									ps3.setInt(1,cp_mdcp_seq);
									ps3.setInt(2,cp_care_plan_seq);
									ps3.setString(3,term_set_id);
									ps3.setString(4,term_code);
									ps3.setInt(5,srl_no);
									//System.err.println("srl_no3:="+srl_no);
									ps3.setString(6,goal_code);
									ps3.setString(7,intervention_code.trim());
									ps3.setString(8,patient_id);
									ps3.setString(9,intervention_code.trim());//intervention_type
									ps3.setString(10,"N");
									ps3.setNull(11,Types.NUMERIC);
									ps3.setString(12,"O");
									ps3.setString(13,"");//status_date
									ps3.setString(14,"");//remarks//reason_code
									ps3.setString(15,"");//remarks
									ps3.setString(16,addedId);
									ps3.setString(17,client_ip_addr);
									ps3.setString(18,facilityId);
									ps3.setString(19,addedId);
									ps3.setString(20,client_ip_addr);
									ps3.setString(21,facilityId); 
									ps3.setInt(22,goal_srl_no);
									//System.err.println("goal_srl_no:="+goal_srl_no);
									ps3.setInt(23,intervention_srlno); 
									//System.err.println("intervention_srlno:="+intervention_srlno);
									ps3.setInt(24,group_id); 
									ps3.setString(25,"Y"); 

									try
									{
										//System.err.println("hello20");
										inserted = ps3.executeUpdate();
										//System.err.println("hello21+inserted=>"+inserted);
									}
									catch(Exception e)
									{
										//System.err.println("hello211");
										if(ps3 != null)
										{
											ps3.close();											
										}
										e.printStackTrace();
									}										
								}
							}	
							inserted++;
						}
					
					}
					catch(Exception e)
					{
							if(ps != null){
								ps.close();
								
							}
							if(ps1 != null){
								ps1.close();
								
							}
							if(ps2 != null){
								ps2.close();
								
							}
							if(ps3 != null){
								ps3.close();
								
							}
							e.printStackTrace();
						}
					}	//TO insert in to intervention detail
					if(ps != null)
					{
						ps.close();
						
					}
					if(ps1 != null)
					{
						ps1.close();
						
					}
					if(ps2 != null)
					{
						ps2.close();
						
					}
					if(ps3 != null)
					{
						ps3.close();
						
					}
					//System.err.println("hello22 :inserted==>"+inserted);			
					ps = con.prepareStatement("INSERT INTO CP_PAT_CARE_PLAN_INTVN_DTL(MD_CARE_PLAN_ID, CARE_PLAN_ID, INTERVENTION_CODE, INTERVENTION_SRL_NO, PATIENT_ID, INTERVENTION_TYPE, FREQ_CODE, DURATION, DURN_TYPE, START_DATE, END_DATE, STATUS, STATUS_DATE, REASON_CODE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,POSITION_CODE, ROLE_TYPE, PRIORITY, STAGE_CODE) VALUES(?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),to_date(?,'dd/mm/yyyy hh24:mi'),?,sysdate,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?)");

					i_cnt = (String) tabData.get("count");
					count= Integer.parseInt(i_cnt);
					//System.err.println("count:="+count);
					for(int icnt=0;icnt<count;icnt++)
					{
						try
						{	
							intervention_code	= (String) tabData.get("intervention_code"+icnt);
							intervention_type	= (String) tabData.get("intervention_type"+icnt);
							freq_code			= (String) tabData.get("freq_code"+icnt);
							durn				= (String) tabData.get("duration"+icnt);
							duration			= Integer.parseInt(durn);
							durn_type			= (String) tabData.get("durn_type"+icnt);
							start_date			= (String) tabData.get("start_date"+icnt);
							end_date			= (String) tabData.get("end_date"+icnt);
							position_code		= (String) tabData.get("position_code"+icnt);
							role_type			= (String) tabData.get("role_type"+icnt);
							priority			= (String) tabData.get("priority"+icnt);
							stage_code			= (String) tabData.get("stage_code"+icnt);
							//System.err.println("intervention_code+intervention_type+freq_code+duration+durn_type+start_date+end_date+position_code+role_type+priority+stage_code==>"+intervention_code+":="+intervention_type+":="+freq_code+":="+duration+":="+durn_type+":="+start_date+":="+end_date+":="+position_code+":="+role_type+":="+priority+":="+stage_code);
							if(inserted>0)
							{
								if(!intervention_code.equals(""))
								{							
									ps.setInt(1,cp_mdcp_seq);
									ps.setInt(2,cp_care_plan_seq);
									ps.setString(3,intervention_code);
									ps.setInt(4,intervention_srlno);
									ps.setString(5,patient_id);
									ps.setString(6,intervention_type);
									ps.setString(7,freq_code);
									ps.setInt(8,duration);
									ps.setString(9,durn_type);
									ps.setString(10,start_date);
									ps.setString(11,end_date);
									ps.setString(12,"O");
									ps.setNull(13,Types.VARCHAR);//REASON_CODE
									ps.setNull(14,Types.VARCHAR);//REMARKS
									ps.setString(15,addedId);
									ps.setString(16,client_ip_addr);
									ps.setString(17,facilityId);
									ps.setString(18,addedId);
									ps.setString(19,client_ip_addr);
									ps.setString(20,facilityId); 
									ps.setString(21,position_code);//POSITION_CODE
									ps.setString(22,role_type);//ROLE_TYPE
									ps.setString(23,priority);//PRIORITY
									ps.setString(24,stage_code);//STAGE_CODE
									//System.err.println("hello23");
									inserted = ps.executeUpdate();
									//System.err.println("hello24+inserted=>"+inserted);
								}
							}
						}
					catch(Exception e)
					{
							//System.err.println("hello241");
							if(ps != null)
								ps.close();
							e.printStackTrace();
					}
				}
				if(ps != null)
				{
						ps.close();
						
				}
				if(inserted>0)
				{
					cstmt =con.prepareCall("{ CALL CP_POST_TASK_LIST (?,?,?,?,?,?,'') } ");
					cstmt.setString(1, facilityId);	 
					cstmt.setLong(2, encounter_id);	
					cstmt.setString(3, patient_id);	
					cstmt.setInt(4, cp_mdcp_seq);		
					cstmt.setInt(5, cp_care_plan_seq); 		
					cstmt.registerOutParameter( 6,  Types.VARCHAR ) ;
					try{
						cstmt.execute();
						errorMsg = cstmt.getString(6);
						//System.err.println("errorMsg==>"+errorMsg);
					}catch(Exception e){
						//System.err.println("hello242");
						if(cstmt!= null){
							cstmt.close();
							
						}
						e.printStackTrace();
					}
					if(cstmt != null){
						cstmt.close();
						
					}
				//System.err.println("hello25");
					if(errorMsg == null)
						inserted = 1;
					else
						inserted = 0;	
				}
				//System.err.println("hello251+inserted=>"+inserted);
					ps	= con.prepareStatement("select TERM_SET_ID,TERM_CODE,1 TERM_CODE_SRL_NO,GOAL_CODE,Decode(GOAL_TARGET_DURN_UNIT,'D',TO_CHAR(SYSDATE+GOAL_TARGET_DURN,'DD/MM/YYYY HH24:MI'),'H',TO_CHAR(SYSDATE+GOAL_TARGET_DURN/24 , 'DD/MM/YYYY HH24:MI'),'M',TO_CHAR(SYSDATE+(GOAL_TARGET_DURN/(24*60)),'DD/MM/YYYY HH24:MI'),'L',TO_CHAR(ADD_MONTHS(SYSDATE,GOAL_TARGET_DURN) , 'DD/MM/YYYY HH24:MI'),'W',TO_CHAR(SYSDATE+GOAL_TARGET_DURN*7 , 'DD/MM/YYYY HH24:MI'),'')GOAL_TARGET_DATE,'N' REVISION_YN,NULL REVISION_ID,'0' STATUS,1 GOAL_SRL_NO,to_char(sysdate,'DD/MM/YYYY HH24:MI')STATUS_DATE,'N' APPL_YN from cp_library_goal a where library_id= ? and VERSION_NO = ? and term_set_id= ? and term_code= ? and not exists (select 1 from cp_pat_care_plan_goal where MD_CARE_PLAN_ID= ? and CARE_PLAN_ID= ? and TERM_SET_ID=a.TERM_SET_ID and TERM_CODE =a.TERM_CODE AND TERM_CODE_SRL_NO=1 AND GOAL_CODE=A.GOAL_CODE AND GOAL_SRL_NO=1 )");
					pstmt = con.prepareStatement("INSERT INTO CP_PAT_CARE_PLAN_GOAL (MD_CARE_PLAN_ID, CARE_PLAN_ID, TERM_SET_ID, TERM_CODE, TERM_CODE_SRL_NO, GOAL_CODE, GOAL_TARGET_DATE, PATIENT_ID, REVISION_YN, REVISION_ID, STATUS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, GOAL_SRL_NO, STATUS_DATE,APPL_YN)VALUES(?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,sysdate,?,?,?, sysdate,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?)");	
					ps1	= con.prepareStatement("select TERM_SET_ID,TERM_CODE ,1 TERM_CODE_SRL_NO ,GOAL_CODE,OUTCOME_CODE,'N' REVISION_YN ,NULL REVISION_ID ,'O' STATUS ,NULL STATUS_DATE,NULL REASON_CODE ,NULL REMARKS ,1 GOAL_SRL_NO,1 OUTCOME_SRL_NO ,GROUP_ID ,'N' APPL_YN from cp_library_outcome a where  library_id =? and version_no = ? and term_set_id= ? and term_code= ? and not exists (select 1 from cp_pat_care_plan_outcome where MD_CARE_PLAN_ID  = ? and CARE_PLAN_ID = ? and TERM_SET_ID =a.TERM_SET_ID and TERM_CODE =a.TERM_CODE and TERM_CODE_SRL_NO = 1 and GOAL_CODE =a.GOAL_CODE and GOAL_SRL_NO =1 and OUTCOME_CODE=a.OUTCOME_CODE and outcome_SRL_NO =1 and GROUP_ID =A.GROUP_ID )");
					pstmt1 = con.prepareStatement("INSERT INTO CP_PAT_CARE_PLAN_OUTCOME(MD_CARE_PLAN_ID, CARE_PLAN_ID, TERM_SET_ID, TERM_CODE, TERM_CODE_SRL_NO, GOAL_CODE, OUTCOME_CODE, OUTCOME_TARGET_DATE, PATIENT_ID, REVISION_YN, REVISION_ID, STATUS, STATUS_DATE, REASON_CODE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, GOAL_SRL_NO, OUTCOME_SRL_NO,GROUP_ID,APPL_YN)VALUES (?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?)");
					ps2	= con.prepareStatement("select TERM_SET_ID,TERM_CODE ,1 TERM_CODE_SRL_NO ,GOAL_CODE ,INTERVENTION_CODE,INTERVENTION_TYPE ,'N' REVISION_YN ,NULL REVISION_ID ,'O' STATUS ,NULL STATUS_DATE ,NULL REASON_CODE ,NULL REMARKS,1 GOAL_SRL_NO ,1 INTERVENTION_SRL_NO ,GROUP_ID ,'N' APPL_YN from cp_library_intervention a where library_id =? and version_no = ? and term_set_id= ? and term_code= ?and not exists (select 1 from cp_pat_care_plan_intvn  where MD_CARE_PLAN_ID  = ? and CARE_PLAN_ID = ? and TERM_SET_ID =a.TERM_SET_ID and TERM_CODE = a.TERM_CODE and TERM_CODE_SRL_NO = 1 and GOAL_CODE =a.GOAL_CODE and GOAL_SRL_NO =1 and INTERVENTION_CODE=a.INTERVENTION_CODE and INTERVENTION_SRL_NO =1 and GROUP_ID =A.GROUP_ID )");
					ps3 = con.prepareStatement("INSERT INTO CP_PAT_CARE_PLAN_INTVN(MD_CARE_PLAN_ID, CARE_PLAN_ID, TERM_SET_ID, TERM_CODE, TERM_CODE_SRL_NO, GOAL_CODE, INTERVENTION_CODE, PATIENT_ID, INTERVENTION_TYPE, REVISION_YN, REVISION_ID, STATUS, STATUS_DATE, REASON_CODE, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID, GOAL_SRL_NO, INTERVENTION_SRL_NO,GROUP_ID,APPL_YN)VALUES (?,?,?,?,?,?,?,?,(SELECT A.INTERVENTION_TYPE FROM CA_INTERVENTION A WHERE A.INTERVENTION_CODE Like (?)),?,?,?,to_date(?,'dd/mm/yyyy hh24:mi'),?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?)"); 

					for (int tc=0 ;tc < tcode_cnt ;tc++ )
					{
						library_id			 = (String)tabData.get("library_id"+tc);
						ver_no				 = (Integer)tabData.get("version_no"+tc);
						version_no			 = ver_no.intValue();	
						term_set_id			 = (String)tabData.get("term_set_id"+tc);
						term_code			 = (String)tabData.get("term_code"+tc);
						//System.err.println("library_id+version_no+term_set_id+term_code+cp_mdcp_seq+cp_care_plan_seq==>"+library_id+":="+version_no+":="+term_set_id+":="+term_code+":="+cp_mdcp_seq+":="+cp_care_plan_seq);
						ps.setString(1,library_id);
						ps.setInt(2,version_no);
						ps.setString(3,term_set_id);
						ps.setString(4,term_code);
						ps.setInt(5,cp_mdcp_seq);
						ps.setInt(6,cp_care_plan_seq);
						//System.err.println("hello26");
						rs = ps.executeQuery();
						//System.err.println("hello27");
						i = 0;
						if(inserted>0)
						{
						while(rs.next()){
							try{
								pstmt.setInt(1,cp_mdcp_seq);
								pstmt.setInt(2,cp_care_plan_seq);
								pstmt.setString(3,rs.getString(1));//term_set_id
								//System.err.println("rs.getString(1)=>"+rs.getString(1));
								pstmt.setString(4,rs.getString(2));//term_code
								//System.err.println("rs.getString(2)=>"+rs.getString(2));
								pstmt.setInt(5,rs.getInt(3));//srl_no
								//System.err.println("rs.getInt(3)=>"+rs.getInt(3));
								pstmt.setString(6,rs.getString(4));//goal_code
								//System.err.println("rs.getString(4)=>"+rs.getString(4));
								pstmt.setString(7,rs.getString(5));//goal_target_date
								//System.err.println("rs.getString(5)=>"+rs.getString(5));
								pstmt.setString(8,patient_id);
								pstmt.setString(9,"N");//rs.getString(6)
								pstmt.setNull(10,Types.NUMERIC); // REVISION_ID rs.getString(7)
								pstmt.setString(11,"O");  //rs.getString(8)
								pstmt.setString(12,addedId);
								pstmt.setString(13,client_ip_addr);
								pstmt.setString(14,facilityId);
								pstmt.setString(15,addedId);
								pstmt.setString(16,client_ip_addr);
								pstmt.setString(17,facilityId);  
								pstmt.setInt(18,rs.getInt(9));//goal_srl_no
								pstmt.setString(19,rs.getString(10));//status_date
								//System.err.println("rs.getString(10)=>"+rs.getString(10));
								pstmt.setString(20,"N");//rs.getString(11)
								//System.err.println("hello28");			
								inserted = pstmt.executeUpdate();
								//System.err.println("hello29+inserted=>"+inserted);
							}
							catch(Exception ex){								
								ex.printStackTrace();
							}
							i++;
						}
						}						
						if(rs != null)
							rs.close();
						ps1.setString(1,library_id);
						ps1.setInt(2,version_no);
						ps1.setString(3,term_set_id);
						ps1.setString(4,term_code);
						ps1.setInt(5,cp_mdcp_seq);
						ps1.setInt(6,cp_care_plan_seq);
						//System.err.println("hello30");
						rs = ps1.executeQuery();
						//System.err.println("hello31");
						i=0;
						if(inserted>0)
						{
						while(rs.next()){
							try{
							
								pstmt1.setInt(1,cp_mdcp_seq);
								pstmt1.setInt(2,cp_care_plan_seq);
								pstmt1.setString(3,rs.getString(1));//term_set_id
								//System.err.println("2rs.getString(1)=>"+rs.getString(1));
								pstmt1.setString(4,rs.getString(2));//term_code
								//System.err.println("2rs.getString(2)=>"+rs.getString(2));
								pstmt1.setInt(5,rs.getInt(3));//srl_no
								//System.err.println("2rs.getInt(3)=>"+rs.getInt(3));
								pstmt1.setString(6,rs.getString(4));//goal_code
								//System.err.println("2rs.getString(4)=>"+rs.getString(4));
								pstmt1.setString(7,rs.getString(5));//outcome_code
								//System.err.println("2rs.getString(5)=>"+rs.getString(5));
								pstmt1.setString(8,outcome_target_date);
								pstmt1.setString(9,patient_id);
								pstmt1.setString(10,"N");//rs.getString(6)
								pstmt1.setNull(11,Types.NUMERIC);//rs.getString(7)
								pstmt1.setString(12,"O");//rs.getString(8)
								pstmt1.setString(13,rs.getString(9));//status_date
								//System.err.println("2rs.getString(9)=>"+rs.getString(9));
								pstmt1.setString(14,"");//reason_code rs.getString(10)
								pstmt1.setString(15,"");//remarks rs.getString(11)
								pstmt1.setString(16,addedId);
								pstmt1.setString(17,client_ip_addr);
								pstmt1.setString(18,facilityId);
								pstmt1.setString(19,addedId);
								pstmt1.setString(20,client_ip_addr);
								pstmt1.setString(21,facilityId); 
								pstmt1.setInt(22,rs.getInt(12));// goal_srl_no
								//System.err.println("2rs.getInt(12)=>"+rs.getInt(12));
								pstmt1.setInt(23, rs.getInt(13));//outcome_srl_no
								//System.err.println("2rs.getInt(13)=>"+rs.getInt(13));
								pstmt1.setInt(24,rs.getInt(14)); //group_id
								//System.err.println("2rs.getInt(14)=>"+rs.getInt(14));
								pstmt1.setString(25,"N");//rs.getString(15)
								//System.err.println("hello32");
								inserted = pstmt1.executeUpdate();
								//System.err.println("hello33+inserted=>"+inserted);
							}catch(Exception ex){
								ex.printStackTrace();								
							}
							i++;
						}
						}
						
						if(rs!=null){
							rs.close();
							
						}
						//System.err.println("hello34");
						ps2.setString(1,library_id);
						ps2.setInt(2,version_no);
						ps2.setString(3,term_set_id);
						ps2.setString(4,term_code);
						ps2.setInt(5,cp_mdcp_seq);
						ps2.setInt(6,cp_care_plan_seq);
						//System.err.println("hello35");
						rs		= ps2.executeQuery();
						//System.err.println("hello36");
						i = 0;
						if(inserted>0)
						{
						while(rs.next()){
							try{
								//System.out.println("inside 36");
								ps3.setInt(1,cp_mdcp_seq);
								ps3.setInt(2,cp_care_plan_seq);
								ps3.setString(3,rs.getString(1));//term_set_id
								//System.err.println("3rs.getString(1)=>"+rs.getString(1));
								ps3.setString(4,rs.getString(2));//term_code
								//System.err.println("3rs.getString(2)=>"+rs.getString(2));
								ps3.setInt(5,rs.getInt(3));//srl_no
								//System.err.println("3rs.getInt(3)=>"+rs.getInt(3));
								//System.out.println("inside361");
								ps3.setString(6,rs.getString(4));//goal_code
								//System.err.println("3rs.getString(4)=>"+rs.getString(4));
								ps3.setString(7,rs.getString(5).trim());//intervention_code
								//System.err.println("3rs.getString(5)=>"+rs.getString(5));
								ps3.setString(8,patient_id);
								ps3.setString(9,rs.getString(6).trim());//intervention_type
								//System.err.println("3rs.getString(6)=>"+rs.getString(6));
								ps3.setString(10,"N");//rs.getString(7)
								ps3.setNull(11,Types.NUMERIC);//rs.getString(8)
								ps3.setString(12,"O");//rs.getString(9)
								ps3.setString(13,rs.getString(10));//status_date
								//System.err.println("3rs.getString(10)=>"+rs.getString(10));
								ps3.setString(14,"");//remarks//reason_code rs.getString(11)
								ps3.setString(15,"");//remarks rs.getString(12)
								ps3.setString(16,addedId);
								ps3.setString(17,client_ip_addr);
								ps3.setString(18,facilityId);
								ps3.setString(19,addedId);
								ps3.setString(20,client_ip_addr);
								ps3.setString(21,facilityId); 
								ps3.setInt(22,rs.getInt(13));//goal_srl_no
								//System.err.println("3rs.getInt(13)=>"+rs.getInt(13));
								ps3.setInt(23,rs.getInt(14));// intervention_srlno
								//System.err.println("3rs.getInt(14)=>"+rs.getInt(14));
								ps3.setInt(24,rs.getInt(15)); //group_id
								//System.err.println("3rs.getInt(15)=>"+rs.getInt(15));
								ps3.setString(25,"N"); //rs.getString(16)
								//System.err.println("hello37");
								inserted = ps3.executeUpdate();
								//System.err.println("hello38+inserted=>"+inserted);
							}catch(Exception ex){
								//System.err.println("Exception inside 381"+ex);
							
							}
							i++;
						}
					}
						//System.err.println("hello 382");
						if(rs != null)
						rs.close();
						//System.err.println("inside383");
					}
					//System.err.println("hello39");
					if(ps != null){
						ps.close();
						
					}
					if(ps1 != null){
						ps1.close();
						
					}
					if(ps2 != null){
						ps2.close();
						
					}
					if(ps3 != null){
						ps3.close();
						
					}
					if(pstmt != null){
						pstmt.close();
						
					}
					if(pstmt1 != null){
						pstmt1.close();
						
					}

					}	//if lup ends
					//System.err.println("hello40+ inserted=>"+inserted);
					Hashtable errdata;
					if(inserted > 0){
						//System.err.println("hello401" );
						con.commit() ;
						errdata		 = MessageManager.getMessage(locale, "RECORD_INSERTED","CP");
						errorMsg	 = (String) errdata.get("message");
						commit_flag		=	true;
					}
					else{
						//System.err.println("hello402");
						con.rollback() ;					
						errdata= MessageManager.getMessage(locale, "TRANSACTION_FAILED","CP");
						errorMsg	 = (String) errdata.get("message");
						//System.err.println("errorMsg==>"+errorMsg );
						hashTable.put("error", (String)errdata.get("message"));						
						commit_flag		=	false;
					}
					
					//System.err.println("hello41");
				}
				catch(Exception e){
					hashTable.put("Exception in generateCarePlan Function", "Transaction failed: "+e);
					e.printStackTrace();
				}
				if(commit_flag)
				{
					//System.err.println("inside if(commit flag)");
					Hashtable errorTable = MessageManager.getMessage(locale, "RECORD_INSERTED","CP");
					hashTable.put("error", (String)errorTable.get("message"));
					flag = true;
					con.commit();
				}
				else{
					//System.err.println("inside if(rollback flag)");
					con.rollback();
				}
			//System.err.println("hello42");
			}catch(Exception exception2){
			   hashTable.put("er2", exception2);
			}
		} 
		catch(Exception exception) {
			hashTable.put("er3", exception);
		}finally {
			try{
				if(rs!=null){
					rs.close();
					
				}
				if(ps!=null){
					ps.close();
					
				}
				if(ps1!=null){
					ps1.close();
					
				}
				if(ps2!=null){
					ps2.close();
					
				}
				if(ps3!=null){
					ps3.close();
					

				}
				if(pstmt!=null){
					pstmt.close();
					

				}
				if(pstmt1!=null){
					pstmt1.close();
					
				}
				if(con != null)
					ConnectionManager.returnConnection(con, properties);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		hashTable.put("status", new Boolean(flag));
		return hashTable;
	}
}
