/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import java.net.URLEncoder;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;

public class MDRServlet extends  javax.servlet.http.HttpServlet{


	
	PrintWriter out;
	Properties p;
	Connection con						= null;
	PreparedStatement ins_pstmt	= null;
	PreparedStatement updt_pstmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs							= null;
	ResultSet rs2						= null;
	HttpSession session				= null;

	String facility_id		      = "";
	String client_ip_address = "";
	String addedById			 = "";
	String locale					 = "";

	String attend_pract		 = "";
	String patient_id			 = "";
	String encounter_id		 = "";
	String certify_pract		 = "";
	String designation			 = "";
	String citizen_id_num	 = "";
	String brought_in_dead	 = "";
	String registration_no	=  "";
	String year					=  "";
	String month					=  "";
	String date					=  "";
	String hours					=  "";
	String remarks		        = "";
	String preg_gestnl_prd		  = "";
	String deceased_date_time = "";
	String preg_status				=  "";				
	String gestational_unit		=	"";
	String preg_deliver_wks	=	"";
	String mlc							=	"";
	String mlc_police_rept_no	 =	"";
	String mlc_police_station	=	"";
	String mlc_id						=	"";
	String Finalize					=	"";
	String mode						=	"";
	String addl_field1				=	"";
	String addl_field2				=	"";
	String addl_field3				=	"";
	String addl_field4				=	"";
	String addl_field5				=	"";
	int hdr_updt_yn=0;
	int dtls_updt_yn=0;
	boolean updateDtls=false;
	boolean updateHdr=false;


	HashMap combined_map		= new HashMap(); 
	HashMap diag_dates_map	= new HashMap(); 
	HashMap diag_desc_map	 	= new HashMap(); 

	ArrayList cause_of_dthlist  = new  ArrayList();
	ArrayList other_comlic_list = new ArrayList();
	ArrayList general_list		  = new ArrayList();

	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
		public synchronized void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		session		= req.getSession(true);

		this.facility_id		= (String)session.getValue("facility_id") ;
		this.p					= (Properties) session.getValue( "jdbc" ) ;
		locale					= p.getProperty("LOCALE");
		this.client_ip_address	= this.p.getProperty("client_ip_address");
		addedById		 = p.getProperty( "login_user" ) ;
		patient_id				  = checkForNull(req.getParameter("patient_id"));
		encounter_id			 = checkForNull(req.getParameter("encounter_id"));
		attend_pract			 = checkForNull(req.getParameter("attend_pract"));
		certify_pract		 = checkForNull(req.getParameter("certify_pract"));
		designation			 = checkForNull(req.getParameter("designation"));
		citizen_id_num		 = checkForNull(req.getParameter("citizen_id_num"));
		brought_in_dead	 = checkForNull(req.getParameter("brought_in_dead"));
		registration_no		 = checkForNull(req.getParameter("registration_no"));
		year						 = checkForNull(req.getParameter("year")); 
		month				     = checkForNull(req.getParameter("month")); 
		date						 = checkForNull(req.getParameter("date")); 
		hours					 = checkForNull(req.getParameter("hours")); 
		preg_gestnl_prd	 = checkForNull(req.getParameter("preg_gestational_prd"));
		remarks				 = checkForNull(req.getParameter("remarks"));
//		deceased_date_time	=checkForNull( req.getParameter("deceased_date_time"));
//		deceased_date_time=DateUtils.convertDate(deceased_date_time,"DMYHM" ,locale,"en");
		preg_status				=  checkForNull(req.getParameter("preg_status"));        
		gestational_unit			=	checkForNull(req.getParameter("gestational_unit"));       
		preg_deliver_wks	 	=	checkForNull(req.getParameter("preg_deliver_wks"));          
		mlc							=	checkForNull(req.getParameter("mlc"));    
		mlc_police_rept_no	=	checkForNull(req.getParameter("mlc_police_rept_no")); 
		mlc_police_station	=	checkForNull(req.getParameter("mlc_police_station"));    
		mlc_id						=	checkForNull(req.getParameter("mlc_id"));                    
		Finalize						=	checkForNull(req.getParameter("Finalize"));                 
		mode						=	checkForNull(req.getParameter("mode"));
		addl_field1				=	checkForNull(req.getParameter("addl_field1"));
		addl_field2				=	checkForNull(req.getParameter("addl_field2"));
		addl_field3				=	checkForNull(req.getParameter("addl_field3"));
		addl_field4			    =	checkForNull(req.getParameter("addl_field4"));
		addl_field5				=	checkForNull(req.getParameter("addl_field5"));
	try{
			combined_map = (HashMap)session.getAttribute("combined_map");
			diag_dates_map = (HashMap)session.getAttribute("diag_dates_map");
			diag_desc_map = (HashMap)session.getAttribute("diag_desc_map");
			if(combined_map.containsKey("C")){
				cause_of_dthlist=(ArrayList)combined_map.get("C");
			}
			if(combined_map.containsKey("O")){
				other_comlic_list=(ArrayList)combined_map.get("O");
			}
			if(combined_map.containsKey("R")){
				general_list=(ArrayList)combined_map.get("R");
			}
			saveDeathRegisterDetails(req,res);
		}catch(Exception ex){
//			con.rollback();
			ex.printStackTrace();
		}finally{
				if(con != null){
					ConnectionManager.returnConnection(con,p);
				}
	}
}
/*
	FYI;Inserting and Updating of the values into the Respective tables done here.
		1.All diagnosis codes from the Diagnosis section will get from the session as a Hashmap.
		2.Getting the respective list of respective group, looping  with size of the list.
		3.Every element of the list contains delimiter as a string .The second item in the String Represents either insert(A) or update(E)
		4.Last item in the String reperesents either the diagnosis is added from the Add Diagnosis Button(I) or not(X).
		5.All the values from the Header section,Female patient Section,MLC details will be updated ino HDR Tables.
		6.Finally Removing the Session Objects once committed.
*/
 private void saveDeathRegisterDetails(HttpServletRequest req, HttpServletResponse res) throws SQLException{
		try{
				con = ConnectionManager.getConnection(req);
				con.setAutoCommit(false);
					int other_dth_cnt	=0;
					int gen_dth_cnt		=0;
					int cause_dth_cnt =0;
					int k=0;
					int j=0;
					int i=0;
			if(cause_of_dthlist!=null&&cause_of_dthlist.size()>0){
					String insert_diag_yn="";
					String cause_of_dthlist_record	="";
					StringTokenizer st_causedth_tkn	 = null;
					int causedth_index					 = 0;
					String causedth_sts					 = "";
					String causedth_code				 = "";
					String causedth_tm_set_id		 = "";
					String causedth_ocur_srlno		 =	"";
					String short_desc						 = "";
					String ad_new_diag					 = "";
					String causedth_onset_dt			 ="";

					String INSERT_DIAG_DTLS_SQL="INSERT INTO MR_DEATH_REGISTER_DIAG_DTL (PATIENT_ID,ENCOUNTER_ID,FACILITY_ID,SRL_NO,TERM_SET_ID,TERM_CODE,TERM_CODE_SHORT_DESC,OCCUR_SRL_NO,ONSET_DATE,SEQ_NO,DIAGNOSIS_GROUP,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,RECORDED_FROM_MDR_YN) VALUES(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:MI'),?,?,?,sysdate,?,?,?,sysdate,?,?,?) " ;
					 ins_pstmt = con.prepareStatement(INSERT_DIAG_DTLS_SQL);

					String UPDATE_DIAG_DTLS_SQL="UPDATE  MR_DEATH_REGISTER_DIAG_DTL SET TERM_SET_ID=?,TERM_CODE=?,TERM_CODE_SHORT_DESC=?,OCCUR_SRL_NO=?,ONSET_DATE=to_date(?,'dd/mm/yyyy hh24:MI'),SEQ_NO=?,DIAGNOSIS_GROUP=?,ADDED_BY_ID=?,ADDED_DATE=sysdate,ADDED_AT_WS_NO=?,ADDED_FACILITY_ID=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE  TERM_SET_ID=? AND TERM_CODE=? AND OCCUR_SRL_NO=? AND PATIENT_ID=? AND ENCOUNTER_ID=? AND FACILITY_ID=? AND SRL_NO=? " ;

					updt_pstmt = con.prepareStatement(UPDATE_DIAG_DTLS_SQL);	
					
					while(k<cause_of_dthlist.size()){
					 insert_diag_yn="";
					 cause_of_dthlist_record	=(String)cause_of_dthlist.get(k);
					 st_causedth_tkn			= new StringTokenizer(cause_of_dthlist_record,"#");
					 causedth_index			= Integer.parseInt(st_causedth_tkn.nextToken());
					 causedth_sts				= st_causedth_tkn.nextToken();
					 causedth_code			= st_causedth_tkn.nextToken();
					 causedth_tm_set_id		= st_causedth_tkn.nextToken();
					 causedth_ocur_srlno	=	st_causedth_tkn.nextToken();
					 short_desc					= st_causedth_tkn.nextToken();
					 ad_new_diag				= st_causedth_tkn.nextToken();
					if(ad_new_diag.equals("I")){//diagnosis is added from the Add Diagnosis Button(I) or not(X).
						insert_diag_yn	= "Y";
					}else{
						insert_diag_yn	= "N";
					}
					causedth_onset_dt	="";

					/*if(diag_desc_map.containsKey(cause_of_dthlist_record)){
						short_desc=(String)diag_desc_map.get(cause_of_dthlist_record);
					}*/

					if(diag_dates_map.containsKey(cause_of_dthlist_record)){
						causedth_onset_dt=(String)diag_dates_map.get(cause_of_dthlist_record);
						causedth_onset_dt=DateUtils.convertDate(causedth_onset_dt,"DMYHM" ,locale,"en");
					}
				if(causedth_sts.equals("A")){
					int seq_no	 = k+1;
					 ins_pstmt.setString(1,patient_id);
					 ins_pstmt.setString(2,encounter_id);
					 ins_pstmt.setString(3,facility_id);
					 ins_pstmt.setInt(4,causedth_index);//Positioning Value;
					 ins_pstmt.setString(5,causedth_tm_set_id);
					 ins_pstmt.setString(6,causedth_code);
					 ins_pstmt.setString(7,short_desc);
					 ins_pstmt.setString(8,causedth_ocur_srlno);
					 ins_pstmt.setString(9,causedth_onset_dt);
					 ins_pstmt.setInt(10,seq_no);
					 ins_pstmt.setString(11,"C");
					 ins_pstmt.setString(12,addedById);
					 ins_pstmt.setString(13,client_ip_address);
					 ins_pstmt.setString(14,facility_id);
					 ins_pstmt.setString(15,addedById);
					 ins_pstmt.setString(16,client_ip_address);
					 ins_pstmt.setString(17,facility_id);
					 ins_pstmt.setString(18,insert_diag_yn);
					ins_pstmt.addBatch();
					/*int c_cnt = pstmt.executeUpdate();
					if(c_cnt>0){
						updateDtls=true;
					}else{
						updateDtls=false;
					}*/
//				srl_no=srl_no+1;
				}else if(causedth_sts.equals("E")){
					int seq_no	 = k+1;
					 updt_pstmt.setString(1,causedth_tm_set_id);
					 updt_pstmt.setString(2,causedth_code);
					 updt_pstmt.setString(3,short_desc);
					 updt_pstmt.setString(4,causedth_ocur_srlno);
					 updt_pstmt.setString(5,causedth_onset_dt);
					 updt_pstmt.setInt(6,seq_no);
					 updt_pstmt.setString(7,"C");
					 updt_pstmt.setString(8,addedById);
					 updt_pstmt.setString(9,client_ip_address);
					 updt_pstmt.setString(10,facility_id);
					 updt_pstmt.setString(11,addedById);
					 updt_pstmt.setString(12,client_ip_address);
					 updt_pstmt.setString(13,facility_id);
					 updt_pstmt.setString(14,causedth_tm_set_id);
					 updt_pstmt.setString(15,causedth_code);
					 updt_pstmt.setString(16,causedth_ocur_srlno);
					 updt_pstmt.setString(17,patient_id);
					 updt_pstmt.setString(18,encounter_id);
					 updt_pstmt.setString(19,facility_id);
					 updt_pstmt.setInt(20,causedth_index);//Positioning Value For Update
					 updt_pstmt.addBatch();
//					 pstmt.setInt(4,srl_no);
				}
	k++;}
				int insert_cnt=0;
				int [] InsertCounts = ins_pstmt.executeBatch();
					insert_cnt=1;
				for (int m=0;m<InsertCounts.length ;m++ ){
					if(InsertCounts[m]<0  && InsertCounts[m] != -2 ){
						insert_cnt=0;
						break;
				}
			}
			int updt_cnt=0;
			int [] UpdateCounts = updt_pstmt.executeBatch();
				updt_cnt=1;
			for (int m=0;m<UpdateCounts.length ;m++ ){
				if(UpdateCounts[m]<0  && UpdateCounts[m] != -2 ){
					updt_cnt=0;
					break;
			}
		}
				if(insert_cnt>0 || updt_cnt>0){
					cause_dth_cnt=1;
				}else{
					cause_dth_cnt=0;
				}
				if(ins_pstmt!=null){
					ins_pstmt.close();
				}
				if(updt_pstmt!=null){
					updt_pstmt.close();
				}

	}
	if(other_comlic_list!=null&&other_comlic_list.size()>0){
					String insert_diag_yn			="";
					String others_list_record	="";
					StringTokenizer st_otherdth_tkn	 = null;
					int other_index				     = 0;
					String other_sts					 = "";
					String other_code				 = "";
					String other_tm_set_id		 = "";
					String other_ocur_srlno		 =	"";
					String short_desc				 = "";
					String ad_new_diag			 = "";
					String other_onset_dt		 ="";

					String INSERT_DIAG_DTLS_SQL="INSERT INTO MR_DEATH_REGISTER_DIAG_DTL (PATIENT_ID,ENCOUNTER_ID,FACILITY_ID,SRL_NO,TERM_SET_ID,TERM_CODE,TERM_CODE_SHORT_DESC,OCCUR_SRL_NO,ONSET_DATE,DIAGNOSIS_GROUP,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,RECORDED_FROM_MDR_YN) VALUES(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:MI'),?,?,sysdate,?,?,?,sysdate,?,?,?) " ;
					 ins_pstmt = con.prepareStatement(INSERT_DIAG_DTLS_SQL);

					String UPDATE_DIAG_DTLS_SQL="UPDATE  MR_DEATH_REGISTER_DIAG_DTL SET TERM_SET_ID=?,TERM_CODE=?,TERM_CODE_SHORT_DESC=?,OCCUR_SRL_NO=?,ONSET_DATE=to_date(?,'dd/mm/yyyy hh24:MI'),SEQ_NO='',DIAGNOSIS_GROUP=?,ADDED_BY_ID=?,ADDED_DATE=sysdate,ADDED_AT_WS_NO=?,ADDED_FACILITY_ID=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE  TERM_SET_ID=? AND TERM_CODE=? AND OCCUR_SRL_NO=? AND PATIENT_ID=? AND ENCOUNTER_ID=? AND FACILITY_ID=? AND SRL_NO=? " ;
					updt_pstmt = con.prepareStatement(UPDATE_DIAG_DTLS_SQL);	
					while(j<other_comlic_list.size()){
//					int seq_no	 = j+1;
					 insert_diag_yn="";
					 others_list_record	=(String)other_comlic_list.get(j);
					 st_otherdth_tkn		 = new StringTokenizer(others_list_record,"#");
					 other_index				  = Integer.parseInt(st_otherdth_tkn.nextToken());
					 other_sts					  = st_otherdth_tkn.nextToken();
					 other_code				 = st_otherdth_tkn.nextToken();
					 other_tm_set_id		 = st_otherdth_tkn.nextToken();
					 other_ocur_srlno		 =	st_otherdth_tkn.nextToken();
					 short_desc				 = st_otherdth_tkn.nextToken();
					 ad_new_diag			 = st_otherdth_tkn.nextToken();
					if(ad_new_diag.equals("I")){//diagnosis is added from the Add Diagnosis Button(I) or not(X).
						insert_diag_yn	= "Y";
					}else{
						insert_diag_yn	= "N";
					}
					 other_onset_dt		="";

					/*if(diag_desc_map.containsKey(others_list_record)){
						short_desc=(String)diag_desc_map.get(others_list_record);
					}*/

					if(diag_dates_map.containsKey(others_list_record)){
						other_onset_dt=(String)diag_dates_map.get(others_list_record);
						other_onset_dt=DateUtils.convertDate(other_onset_dt,"DMYHM" ,locale,"en");
					}
				if(other_sts.equals("A")){
					 ins_pstmt.setString(1,patient_id);
					 ins_pstmt.setString(2,encounter_id);
					 ins_pstmt.setString(3,facility_id);
					 ins_pstmt.setInt(4,other_index);//Positioning Value;
					 ins_pstmt.setString(5,other_tm_set_id);
					 ins_pstmt.setString(6,other_code);
					 ins_pstmt.setString(7,short_desc);
					 ins_pstmt.setString(8,other_ocur_srlno);
					 ins_pstmt.setString(9,other_onset_dt);
//					 pstmt.setInt(10,seq_no);
					 ins_pstmt.setString(10,"O");
					 ins_pstmt.setString(11,addedById);
					 ins_pstmt.setString(12,client_ip_address);
					 ins_pstmt.setString(13,facility_id);
					 ins_pstmt.setString(14,addedById);
					 ins_pstmt.setString(15,client_ip_address);
					 ins_pstmt.setString(16,facility_id);
					 ins_pstmt.setString(17,insert_diag_yn);
					 ins_pstmt.addBatch();
				}else if(other_sts.equals("E")){
					 updt_pstmt.setString(1,other_tm_set_id);
					 updt_pstmt.setString(2,other_code);
					 updt_pstmt.setString(3,short_desc);
					 updt_pstmt.setString(4,other_ocur_srlno);
					 updt_pstmt.setString(5,other_onset_dt);
//					 pstmt.setInt(6,seq_no);
					 updt_pstmt.setString(6,"O");
					 updt_pstmt.setString(7,addedById);
					 updt_pstmt.setString(8,client_ip_address);
					 updt_pstmt.setString(9,facility_id);
					 updt_pstmt.setString(10,addedById);
					 updt_pstmt.setString(11,client_ip_address);
					 updt_pstmt.setString(12,facility_id);
					 updt_pstmt.setString(13,other_tm_set_id);
					 updt_pstmt.setString(14,other_code);
					 updt_pstmt.setString(15,other_ocur_srlno);
					 updt_pstmt.setString(16,patient_id);
					 updt_pstmt.setString(17,encounter_id);
					 updt_pstmt.setString(18,facility_id);
					 updt_pstmt.setInt(19,other_index);//Positioning Value For Update
					 updt_pstmt.addBatch();

				}
//					srl_no=srl_no+1;
					j++;
				}
			int insert_cnt=0;
				int [] InsertCounts = ins_pstmt.executeBatch();
					insert_cnt=1;
				for (int m=0;m<InsertCounts.length ;m++ ){
					if(InsertCounts[m]<0  && InsertCounts[m] != -2 ){
						insert_cnt=0;
						break;
				}
			}
			int updt_cnt=0;
			int [] UpdateCounts = updt_pstmt.executeBatch();
				updt_cnt=1;
			for (int m=0;m<UpdateCounts.length ;m++ ){
				if(UpdateCounts[m]<0  && UpdateCounts[m] != -2 ){
					updt_cnt=0;
					break;
			}
		}
				if(insert_cnt>0 || updt_cnt>0){
					other_dth_cnt=1;
				}else{
					other_dth_cnt=0;
				}
				if(ins_pstmt!=null){
					ins_pstmt.close();
				}
				if(updt_pstmt!=null){
					updt_pstmt.close();
				}


	}
		if(general_list!=null&&general_list.size()>0){
					String insert_diag_yn="";
					String general_list_record	="";
					StringTokenizer st_genral_tkn	 = null;
					int gen_index				= 0;
					String gen_sts				= "";
					String gen_diag_code	= "";
					String gen_tm_set_id	= "";
					String gen_ocur_srlno	= "";
					String short_desc			= "";
					String ad_new_diag		= "";
					String gen_onset_dt		= "";

				String INSERT_DIAG_DTLS_SQL="INSERT INTO MR_DEATH_REGISTER_DIAG_DTL (PATIENT_ID,ENCOUNTER_ID,FACILITY_ID,SRL_NO,TERM_SET_ID,TERM_CODE,TERM_CODE_SHORT_DESC,OCCUR_SRL_NO,ONSET_DATE,DIAGNOSIS_GROUP,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,RECORDED_FROM_MDR_YN) VALUES(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy hh24:MI'),?,?,sysdate,?,?,?,sysdate,?,?,?) " ;
				ins_pstmt = con.prepareStatement(INSERT_DIAG_DTLS_SQL);					 
				String UPDATE_DIAG_DTLS_SQL="UPDATE  MR_DEATH_REGISTER_DIAG_DTL SET TERM_SET_ID=?,TERM_CODE=?,TERM_CODE_SHORT_DESC=?,OCCUR_SRL_NO=?,ONSET_DATE=to_date(?,'dd/mm/yyyy hh24:MI'),SEQ_NO='',DIAGNOSIS_GROUP=?,ADDED_BY_ID=?,ADDED_DATE=sysdate,ADDED_AT_WS_NO=?,ADDED_FACILITY_ID=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?  WHERE  TERM_SET_ID=? AND TERM_CODE=? AND OCCUR_SRL_NO=? AND PATIENT_ID=? AND ENCOUNTER_ID=? AND FACILITY_ID=? AND SRL_NO=? " ;
				updt_pstmt = con.prepareStatement(UPDATE_DIAG_DTLS_SQL);		
				
				while(i<general_list.size()){
//					int seq_no	 = i+1;
					 insert_diag_yn="";
					 general_list_record	=(String)general_list.get(i);
					 st_genral_tkn		= new StringTokenizer(general_list_record,"#");
					 gen_index			= Integer.parseInt(st_genral_tkn.nextToken());
					 gen_sts				= st_genral_tkn.nextToken();
					 gen_diag_code	= st_genral_tkn.nextToken();
					 gen_tm_set_id		= st_genral_tkn.nextToken();
					 gen_ocur_srlno	= st_genral_tkn.nextToken();
					 short_desc			= st_genral_tkn.nextToken();
					 ad_new_diag		= st_genral_tkn.nextToken();
					if(ad_new_diag.equals("I")){//diagnosis is added from the Add Diagnosis Button(I) or not(X).
						insert_diag_yn	= "Y";
					}else{
						insert_diag_yn	= "N";
					}
					 gen_onset_dt		= "";

					/*if(diag_desc_map.containsKey(general_list_record)){
						short_desc=(String)diag_desc_map.get(general_list_record);
					}*/

					if(diag_dates_map.containsKey(general_list_record)){
						gen_onset_dt=(String)diag_dates_map.get(general_list_record);
						gen_onset_dt=DateUtils.convertDate(gen_onset_dt,"DMYHM" ,locale,"en");

					}
				if(gen_sts.equals("A")){
					 ins_pstmt.setString(1,patient_id);
					 ins_pstmt.setString(2,encounter_id);
					 ins_pstmt.setString(3,facility_id);
					 ins_pstmt.setInt(4,gen_index);//Positining Value;
					 ins_pstmt.setString(5,gen_tm_set_id);
					 ins_pstmt.setString(6,gen_diag_code);
					 ins_pstmt.setString(7,short_desc);
					 ins_pstmt.setString(8,gen_ocur_srlno);
					 ins_pstmt.setString(9,gen_onset_dt);
//					 pstmt.setInt(10,seq_no);
					 ins_pstmt.setString(10,"R");
					 ins_pstmt.setString(11,addedById);
					 ins_pstmt.setString(12,client_ip_address);
					 ins_pstmt.setString(13,facility_id);
					 ins_pstmt.setString(14,addedById);
					 ins_pstmt.setString(15,client_ip_address);
					 ins_pstmt.setString(16,facility_id);
					 ins_pstmt.setString(17,insert_diag_yn);
					 ins_pstmt.addBatch();
				}else if(gen_sts.equals("E")){
					 updt_pstmt.setString(1,gen_tm_set_id);
					 updt_pstmt.setString(2,gen_diag_code);
					 updt_pstmt.setString(3,short_desc);
					 updt_pstmt.setString(4,gen_ocur_srlno);
					 updt_pstmt.setString(5,gen_onset_dt);
//					 pstmt.setInt(6,seq_no);
					 updt_pstmt.setString(6,"R");
					 updt_pstmt.setString(7,addedById);
					 updt_pstmt.setString(8,client_ip_address);
					 updt_pstmt.setString(9,facility_id);
					 updt_pstmt.setString(10,addedById);
					 updt_pstmt.setString(11,client_ip_address);
					 updt_pstmt.setString(12,facility_id);
					 updt_pstmt.setString(13,gen_tm_set_id);
					 updt_pstmt.setString(14,gen_diag_code);
					 updt_pstmt.setString(15,gen_ocur_srlno);
					 updt_pstmt.setString(16,patient_id);
					 updt_pstmt.setString(17,encounter_id);
					 updt_pstmt.setString(18,facility_id);
					 updt_pstmt.setInt(19,gen_index);//Positioning Value For Update
					 updt_pstmt.addBatch();

				}
//					srl_no=srl_no+1;
				i++;
			}
				int insert_cnt=0;
					int [] InsertCounts = ins_pstmt.executeBatch();
						insert_cnt=1;
					for (int m=0;m<InsertCounts.length ;m++ ){
						if(InsertCounts[m]<0  && InsertCounts[m] != -2 ){
							insert_cnt=0;
							break;
					}
				}
				int updt_cnt=0;
				int [] UpdateCounts = updt_pstmt.executeBatch();
					updt_cnt=1;
				for (int m=0;m<UpdateCounts.length ;m++ ){
					if(UpdateCounts[m]<0  && UpdateCounts[m] != -2 ){
						updt_cnt=0;
						break;
				}
			}
					if(insert_cnt>0 || updt_cnt>0){
						gen_dth_cnt=1;
					}else{
						gen_dth_cnt=0;
					}
		}
				if(ins_pstmt!=null){
					ins_pstmt.close();
				}
				if(updt_pstmt!=null){
					updt_pstmt.close();
				}

			if(gen_dth_cnt==1||other_dth_cnt==1||cause_dth_cnt==1){
				updateDtls=true;
			}else{
				updateDtls=false;
			}

			if(updateDtls){
				String UPDATE_HDR_DTLS_SQL="UPDATE MR_DEATH_REGISTER_HDR SET ATTEND_PRACTITIONER_ID=?,AUTH_PRACTITIONER_ID=?,AUTOPSY_YN='N', BROUGHT_DEAD_YN=?, DEATH_BY_PREGNANCY_YN=?,FINALIZE_YN=?,GESTATIONAL_PERIOD=?, GESTATIONAL_UNIT=?,MEDICAL_LEGAL_CASE_YN=?,NATIONAL_ID_NO=?,POL_ID=?,POL_REP_NO=?,POL_STN_ID=?, PRACT_REG_NO=?,REMARKS=?,ADDL_FIELD1=?,ADDL_FIELD2=?,ADDL_FIELD3=?,ADDL_FIELD4=?,ADDL_FIELD5=?, DELIVERED_LESS_THAN_6_WEEKS_YN=?,ADDED_AT_WS_NO=?,ADDED_BY_ID=?,ADDED_DATE=sysdate,ADDED_FACILITY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_FACILITY_ID=? WHERE PATIENT_ID=? AND ENCOUNTER_ID=? AND FACILITY_ID=?";
					pstmt = con.prepareStatement(UPDATE_HDR_DTLS_SQL);
					 pstmt.setString(1,attend_pract);
					 pstmt.setString(2,certify_pract);
					 pstmt.setString(3,brought_in_dead);
					 pstmt.setString(4,preg_status);
//					 pstmt.setString(5,deceased_date_time);
					 pstmt.setString(5,Finalize);
					 pstmt.setString(6,preg_gestnl_prd);
					 pstmt.setString(7,gestational_unit);
					 pstmt.setString(8,mlc);
					 pstmt.setString(9,citizen_id_num);
					 pstmt.setString(10,mlc_id);
					 pstmt.setString(11,mlc_police_rept_no);
					 pstmt.setString(12,mlc_police_station);
					 pstmt.setString(13,registration_no);
					 pstmt.setString(14,remarks);
					 pstmt.setString(15,addl_field1);
					 pstmt.setString(16,addl_field2);
					 pstmt.setString(17,addl_field3);
					 pstmt.setString(18,addl_field4);
					 pstmt.setString(19,addl_field5);
					 pstmt.setString(20,preg_deliver_wks);
					 pstmt.setString(21,client_ip_address);
					 pstmt.setString(22,addedById);
					 pstmt.setString(23,facility_id);
					 pstmt.setString(24,client_ip_address);
					 pstmt.setString(25,addedById);
					 pstmt.setString(26,facility_id);
					 pstmt.setString(27,patient_id);
					 pstmt.setString(28,encounter_id);
					 pstmt.setString(29,facility_id);
				int updt_cnt = pstmt.executeUpdate();
				if(updt_cnt>0){
					hdr_updt_yn=1;
				}else{
					hdr_updt_yn=0;
				}
				if(pstmt!=null){
					pstmt.close();
				}
			if(hdr_updt_yn>0){
//				con = ConnectionManager.getConnection(req);
				con.commit();
				Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM");
				String error = (String)message.get("message");
				out.print(error+"~"+"RECORD_INSERTED");
//				out.print(error);
//				out.println(error);
			}else{
				con.rollback();
				Hashtable message = MessageManager.getMessage(locale,"ERROR_INSERTING","SM");
				String error = (String)message.get("message");
				error=error+""+"MR_DEATH_REGISTER_HDR";
				out.print(error+"~"+"ERROR_INSERTING");
//				out.print(error);
			}
		}else{
				con.rollback();
				Hashtable message = MessageManager.getMessage(locale, "ERROR_INSERTING","SM");
				String error = (String)message.get("message");
				error=error+""+"MR_DEATH_REGISTER_DIAG_DTL";
				out.print(error+"~"+"ERROR_INSERTING");
//				out.print(error);
		}

}catch(Exception ex){
				con.rollback();
				Hashtable message = MessageManager.getMessage(locale, "ERROR_INSERTING","SM");
				String error = (String)message.get("message");
				error=error+""+"MR_DEATH_REGISTER_DIAG_DTL";
				out.print(error+"~"+"ERROR_INSERTING");
//				out.print(error);
				ex.printStackTrace();
}finally{
	session.removeAttribute("combined_map");
	session.removeAttribute("diag_dates_map");
	if(ins_pstmt!=null){
		ins_pstmt.close();
	}
	if(updt_pstmt!=null){
		updt_pstmt.close();
	}
	if(pstmt!=null){
		pstmt.close();
	}
//	session.removeAttribute("diag_desc_map");
	if(con != null){
		ConnectionManager.returnConnection(con,p);
	 }
  }
}

	public static String checkForNull(String s){
	return s != null && !s.equals("null") ? s : "";
	}
	public static String checkForNull(String inputString, String defaultValue) {
	return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? defaultValue : inputString );
	}
}
