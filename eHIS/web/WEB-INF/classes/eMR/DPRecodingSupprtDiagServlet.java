/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
//import eMR.RecDiagnosis.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import java.net.URLEncoder;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

public class DPRecodingSupprtDiagServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	Properties p;
	PreparedStatement pstmt		= null;
	ResultSet rs							= null;
	HttpSession session				= null;
	String facility_id		      = "";
	String client_ip_address = "";
	String addedById			 = "";
	String locale					 = "";
	String encounter_id		 = "";
	String patient_id			 = "";
	String term_set				 = "";
	String term_code			 = "";
	String occur_srl_no		 = "";
	String stage_no_disp		 = "";
	String support_seq_no	 = "";
	String Group_seq_no	 = "";
	String group_YN			 = "";
	String insert_unlinked_diag	= "";
	String delete_linked_diag		= "";
	String hdr_modified_dt			= "";
	int updt_cnt	=0;

	public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}
		public synchronized void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		Connection con	 =null;
		con	= ConnectionManager.getConnection(req);

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		session		= req.getSession(true);

		this.facility_id		= (String)session.getValue("facility_id") ;
		this.p					= (Properties) session.getValue( "jdbc" ) ;
		locale					= p.getProperty("LOCALE");
		this.client_ip_address	= this.p.getProperty("client_ip_address");
		addedById		 = p.getProperty( "login_user" ) ;
		
		encounter_id				=	checkForNull(req.getParameter("encounter_id"));
		patient_id					=	checkForNull(req.getParameter("patient_id"));
		term_set					=	checkForNull(req.getParameter("term_set"));
		term_code				=	checkForNull(req.getParameter("term_code"));
		occur_srl_no				=	checkForNull(req.getParameter("occur_srl_no"));
		stage_no_disp			=	checkForNull(req.getParameter("stage_no_disp"));
		support_seq_no		=	checkForNull(req.getParameter("support_seq_no"));
		Group_seq_no			=	checkForNull(req.getParameter("Group_seq_no"));
		group_YN					=	checkForNull(req.getParameter("group_YN"));
		insert_unlinked_diag	=	checkForNull(req.getParameter("insert_unlinked_diag"));
		delete_linked_diag	=	checkForNull(req.getParameter("delete_linked_diag"));
		hdr_modified_dt		=	checkForNull(req.getParameter("hdr_modified_dt"));
		String allow_single_user	 =	restrictMultiuser(encounter_id,hdr_modified_dt,req);
		String multi_user_error	= "";
		if(allow_single_user.equals("00")){
			try{
				int upt_cnt=0;
				int int_cnt=0;
				this.out = res.getWriter();
				if(!delete_linked_diag.equals("")){
					upt_cnt=UpdateLinkedDiagnosis(req,res,con);
				} 
				if(!insert_unlinked_diag.equals("")){
					int_cnt=InsertUnlinkedDiagnosis(req,res,con);
				}
				String  error="";
				if(upt_cnt>0||int_cnt>0){
					con.commit();
					Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					error = (String)hashtable1.get("message");
					out.print("<script>alert('"+error+"')</script>");
					out.print("<script>parent.frames(1).window.returnValue='00'</script>");
					out.print("<script>parent.frames(1).window.close();</script>");
				}else{
					con.rollback();
				}
			}catch(Exception ex){
				//out.println("Exception in DPRecodingSupprtDiagServlet doPost()"+ex.toString());
				ex.printStackTrace();
			}finally{
				if(con != null)
				ConnectionManager.returnConnection(con,p);
			}
		}else if(allow_single_user.equals("01")){
			/*F.Y.I:The Below JS function will Displays the Error message and reload the respective pages. */
			out.print("<script>parent.frames(1).getSupperrormsg()</script>");
		}else if(allow_single_user.equals("02")){
			multi_user_error	="Exception While restricting multiusers acessing the same encounter.";
			out.println("<html><script>parent.frames(3).location.href =\"../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( multi_user_error, "UTF-8" )+"&err_value=0"+"\";</script><body class='message'></html>");
		}
	}
		private int  UpdateLinkedDiagnosis(HttpServletRequest req, HttpServletResponse res,Connection con){
			int updt_cnt=0;
			int updt_hdr=0;
				try{
					con.setAutoCommit(false);
					String addl_criteria	=	"";
					if(group_YN.equals("Y")){
						addl_criteria	="AND GROUP_SEQ_NO='"+Group_seq_no+"' ";
					}else{
						addl_criteria	="AND SUPPORT_SEQ_NO='"+support_seq_no+"' ";
					}
					String UPDATE_SQL	=	"UPDATE MR_RECODE_SUPPORT_DIAG SET STATUS='N',STAGE_NO='"+stage_no_disp+"',ADDED_BY_ID='"+addedById+"',ADDED_DATE=SYSDATE,ADDED_AT_WS_NO='"+client_ip_address+"',ADDED_FACILITY_ID='"+facility_id+"', MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID='"+facility_id+"' WHERE PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+facility_id+"' AND TERM_CODE='"+term_code+"' AND TERM_SET_ID='"+term_set+"' AND SUPP_TERM_CODE IN("+delete_linked_diag+") "+addl_criteria+" ";
					pstmt			= con.prepareStatement(UPDATE_SQL);
					updt_cnt		= pstmt.executeUpdate();
					if(pstmt!=null)pstmt.close();
					if(updt_cnt != 0){  // updating header with status and the current stage.
					String sql_update_hdr="";
						if(stage_no_disp.equals("1")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no_disp+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+facility_id+"' where FACILITY_ID= '"+facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}else if(stage_no_disp.equals("2")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no_disp+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+facility_id+"' where FACILITY_ID= '"+facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}else if(stage_no_disp.equals("3")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no_disp+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+facility_id+"' where FACILITY_ID= '"+facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}
						pstmt = con.prepareStatement( sql_update_hdr );
						updt_hdr = pstmt.executeUpdate();
						if(pstmt!=null)pstmt.close();
					}
				}catch(Exception ex){
						ex.printStackTrace();
					}finally{
						try{
							if(pstmt!=null)pstmt.close();
						}catch(Exception e){}
					}
						return updt_hdr;
				}
		private int InsertUnlinkedDiagnosis(HttpServletRequest req, HttpServletResponse res,Connection con){
			int ins_cnt=0;
			int ins_hdr=0;
			try{
				con.setAutoCommit(false);
//				String addl_criteria	=	"";
				String coln_to_insert =	"";
				int srl_no					= 0;
				int k							= 0;
				int	 record_cnt			= 0;
				String SQL_SRL_NO ="SELECT NVL(MAX(SRL_NO),0)+1 SRL_NO FROM MR_RECODE_SUPPORT_DIAG WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID= '"+facility_id+"' ";
				pstmt		= con.prepareStatement(SQL_SRL_NO );
				rs				= pstmt.executeQuery(); 
				while(rs.next()){
					srl_no	=rs.getInt("srl_no");
				}
				if(pstmt!=null)pstmt.close();
				if(rs!=null)rs.close();
				if(group_YN.equals("Y") && !Group_seq_no.equals("")){
					String SQL_STAGE_SRL_NO ="SELECT SUPPORT_SEQ_NO FROM MR_RECODE_SUPPORT_DIAG WHERE ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID= '"+facility_id+"' AND GROUP_SEQ_NO='"+Group_seq_no+"'  ";
					pstmt		= con.prepareStatement(SQL_STAGE_SRL_NO );
					rs				= pstmt.executeQuery(); 
					while(rs.next()){
						if(k==0){
							coln_to_insert	= rs.getString("SUPPORT_SEQ_NO");
						}else{
							break;
						}
						k++;
					}
					if(pstmt!=null)pstmt.close();
					if(rs!=null)rs.close();
				}else{
					coln_to_insert	= support_seq_no;
				}
					String Group_seq_no_criteria="";
					if(!Group_seq_no.equals("")){
							Group_seq_no_criteria="AND GROUP_SEQ_NO ='"+Group_seq_no+"'";
					}
					StringTokenizer  str_ary= new StringTokenizer(insert_unlinked_diag,"|@");
					while(str_ary.hasMoreTokens()){
						String	code_buf =str_ary.nextToken();
						StringTokenizer  str_ary_code= new StringTokenizer(code_buf,"$*");
						while(str_ary_code.hasMoreTokens()){
							String supp_code				=	str_ary_code.nextToken();
							String supp_code_set		=	str_ary_code.nextToken();
							String supp_code_desc		=	str_ary_code.nextToken();
							String EXCITS_RECORD_SQL	 ="SELECT COUNT(*) COUNT FROM MR_RECODE_SUPPORT_DIAG WHERE SUPP_TERM_CODE ='"+supp_code+"' AND SUPP_TERM_SET_ID ='"+supp_code_set+"' "+Group_seq_no_criteria+"  AND SUPPORT_SEQ_NO='"+coln_to_insert+"' AND TERM_CODE='"+term_code+"' AND TERM_SET_ID='"+term_set+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID= '"+facility_id+"' ";
							pstmt		= con.prepareStatement(EXCITS_RECORD_SQL );
							rs				= pstmt.executeQuery(); 
							while(rs.next()){
								record_cnt	= rs.getInt("COUNT");
							}
							if(pstmt!=null)pstmt.close();
							if(rs!=null)rs.close();
							if(record_cnt>0){
								String INS_UPDT_SQL	=	"UPDATE MR_RECODE_SUPPORT_DIAG SET STATUS='Y',ADDED_BY_ID='"+addedById+"',ADDED_DATE=SYSDATE,ADDED_AT_WS_NO='"+client_ip_address+"',ADDED_FACILITY_ID='"+facility_id+"', MODIFIED_BY_ID='"+addedById+"', MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID='"+facility_id+"' WHERE PATIENT_ID='"+patient_id+"' AND ENCOUNTER_ID='"+encounter_id+"' AND FACILITY_ID='"+facility_id+"' AND TERM_CODE='"+term_code+"' AND TERM_SET_ID='"+term_set+"' AND SUPP_TERM_CODE ='"+supp_code+"' "+Group_seq_no_criteria+" AND SUPPORT_SEQ_NO='"+coln_to_insert+"' ";
								pstmt			= con.prepareStatement(INS_UPDT_SQL);
								ins_cnt			= pstmt.executeUpdate();
								if(pstmt!=null)pstmt.close();
							}else{
								String INSERT_SQL="insert into MR_RECODE_SUPPORT_DIAG (PATIENT_ID,FACILITY_ID, ENCOUNTER_ID, OCCUR_SRL_NO,TERM_SET_ID,TERM_CODE,SUPP_TERM_CODE,SUPP_TERM_SET_ID,TERM_CODE_SHORT_DESC, STAGE_NO, SUPPORT_SEQ_NO,SRL_NO,STATUS,GROUP_SEQ_NO,TRX_NO,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
								pstmt			= con.prepareStatement( INSERT_SQL );
								 pstmt.setString(1,patient_id);
								 pstmt.setString(2,facility_id);
								 pstmt.setString(3,encounter_id);
								 pstmt.setString(4,occur_srl_no);
								 pstmt.setString(5,term_set);
								 pstmt.setString(6,term_code);
								 pstmt.setString(7,supp_code);
								 pstmt.setString(8,supp_code_set);
								 pstmt.setString(9,supp_code_desc);
								 pstmt.setString(10,stage_no_disp);
								 pstmt.setString(11,coln_to_insert);
								 pstmt.setInt(12,srl_no);
								 pstmt.setString(13,"Y");
								 pstmt.setString(14,Group_seq_no);
								 pstmt.setString(15,"");
								 pstmt.setString(16,addedById);
								 pstmt.setString(17,client_ip_address);
								 pstmt.setString(18,facility_id);
								 pstmt.setString(19,addedById);
								 pstmt.setString(20,client_ip_address);
								 pstmt.setString(21,facility_id);
								 ins_cnt	= pstmt.executeUpdate(); 
								srl_no++;
						}
					}
				}
					if(ins_cnt != 0){  // updating header with status and the current stage.
					String sql_update_hdr="";
						if(stage_no_disp.equals("1")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL1_STATUS='S',CURR_LEVEL= '"+stage_no_disp+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+facility_id+"' where FACILITY_ID= '"+facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}else if(stage_no_disp.equals("2")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL2_STATUS='S',CURR_LEVEL= '"+stage_no_disp+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+facility_id+"' where FACILITY_ID= '"+facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}else if(stage_no_disp.equals("3")){
							sql_update_hdr="update MR_DIAG_PROC_RECODING_HDR set LEVEL3_STATUS='S',CURR_LEVEL= '"+stage_no_disp+"',MODIFIED_BY_ID='"+addedById+"',MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+facility_id+"' where FACILITY_ID= '"+facility_id+"' and  ENCOUNTER_ID='"+encounter_id+"'";
						}
						pstmt	= con.prepareStatement( sql_update_hdr );
						ins_hdr = pstmt.executeUpdate();
						if(pstmt!=null)pstmt.close();
					}
					/*if(ins_cnt>0){
						con.commit();
					}else{
						con.rollback();
					}*/
					if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(pstmt!=null)pstmt.close();
					if(rs!=null)rs.close();
				}catch(Exception e){}
			}
			return ins_hdr;
		}
	public String restrictMultiuser(String class_encounter_id,String hdr_modified_dt,HttpServletRequest req){
		Connection con	 =null;
		con = ConnectionManager.getConnection(req);
		String proceed	 = "00";//To Allow only Single User
		try{
				String HDR_MODIFY_DT_SQL	= "UPDATE MR_DIAG_PROC_RECODING_HDR SET MODIFIED_DATE=SYSDATE ,MODIFIED_BY_ID='"+addedById+"',MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_FACILITY_ID ='"+facility_id+"'  WHERE ENCOUNTER_ID='"+class_encounter_id+"' AND FACILITY_ID ='"+facility_id+"' AND MODIFIED_DATE=to_date('"+hdr_modified_dt+"','dd/mm/yyyy hh24:mi:sssss')";
				pstmt =con.prepareStatement(HDR_MODIFY_DT_SQL);
				int dummy_hdr =pstmt.executeUpdate();
				if(pstmt!=null){
					pstmt.close();
				}
				if(dummy_hdr>0){
					proceed = "00";//To Allow only Single User
					con.commit();
				}else{
					proceed	= "01";//To Allow only Single User
				}
			}catch(Exception ex){
				proceed="02";//Some exception was occured.
				ex.printStackTrace();
				try{
				con.rollback();
			}catch(Exception ee){}
		}finally{
			if(con != null){
			ConnectionManager.returnConnection(con,p);
			}
		}
		return proceed;
	}
	public static String checkForNull(String s){
		return s != null && !s.equals("null") ? s : "";
	}
	public static String checkForNull(String inputString, String defaultValue) {
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? defaultValue : inputString );
	}

}	
