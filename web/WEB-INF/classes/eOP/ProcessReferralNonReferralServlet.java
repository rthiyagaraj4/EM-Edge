package eOP;

import java.sql.*;
import java.sql.Date;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;

public class ProcessReferralNonReferralServlet extends javax.servlet.http.HttpServlet	
{
PrintWriter out;
java.util.Properties p;

String episode_id;
String patient_id;
String referral_yn;
String referral_id;
String ref_locn_code;
String encounter_id;
String service_code;
String visit_id;
String patient_class;

String client_ip_address ;
String facilityId="";



//Connection con;
//PreparedStatement pstmt;
String addedById = "";
String addedDate = "";
String modifiedById = "";
String modifiedDate = "";
String modifiedFacilityId = "";
String modifiedAtWorkstation = "";
Date added_date = null;
Date modified_date = null;
java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
		"yyyy-MM-dd");



public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	
	
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		System.err.println("Inside Process Referral Servlet Check1");
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;

		client_ip_address = p.getProperty("client_ip_address");

		try {
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		if ( operation.equals("link") ){
			System.err.println("Inside ProcessReferralNonReferral Link Servlet file Check2");
			processLinkReferral(req, res);
		}
		else if ( operation.equals("delink") )
			{
			System.err.println("Inside ProcessReferralNonReferral Delink Servlet file Check2");
				processDelinkReferral(req, res);
			}
		}
		catch (Exception e)	{
			out.println(e.toString());
			}
		}
	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
		{
		res.setContentType("text/html;charset=UTF-8");
		doPost(req,res);			
		}
	boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}

// Method for de-linking referral id operation	
	public void processDelinkReferral(HttpServletRequest req, HttpServletResponse res)throws Exception{

	int res3=0;
	int res1=0;
	Connection con=null;
	Statement pstmt=null;
	Statement pstmt1=null;
	StringBuffer sql= new StringBuffer();
	String sql1=" ";
	try{
		System.err.println("Inside ProcessReferralNonReferral deLink Servlet file Check4");
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			episode_id = req.getParameter("episode_id")==null ? "":req.getParameter("episode_id");
			referral_yn = req.getParameter("referred_yn")==null ? "":req.getParameter("referred_yn");
			referral_id = req.getParameter("referral_id")==null ? "":req.getParameter("referral_id");
			patient_id = req.getParameter("patient_id")==null ? "":req.getParameter("patient_id");
			ref_locn_code = req.getParameter("ref_locn_code")==null ? "":req.getParameter("ref_locn_code");
			encounter_id = req.getParameter("encounter_id")==null ? "":req.getParameter("encounter_id");
			service_code = req.getParameter("service_code")==null ? "":req.getParameter("service_code");
			visit_id = req.getParameter("visit_id")==null ? "":req.getParameter("visit_id");
			patient_class = req.getParameter("patient_class")==null ? "":req.getParameter("patient_class");
//			System.err.println("hi in servlet visit_id ===================>"+visit_id);
//			System.err.println("hi in servlet patient_class ===================>"+patient_class);
			//System.out.println("Episode_id:"+episode_id+" Referral_id: "+ referral_id+" Referral_YN: "+referral_yn+" Patient_id: "+patient_id+"Ref_Locn_Code: "+ ref_locn_code);
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;	
	
			HashMap tabdata=new HashMap();
			tabdata.put("callfunc","link");
			tabdata.put("referred_yn",referral_yn);
			tabdata.put("referral_id",referral_id);
			tabdata.put("encounter_id",encounter_id);
			tabdata.put("service_code",service_code);
			tabdata.put("visit_id",visit_id);
			tabdata.put("patient_class",patient_class);
			tabdata.put("patient_id",patient_id);
			tabdata.put("episode_id",episode_id);
			tabdata.put("ref_locn_code",ref_locn_code);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			tabdata.put("modified_facility_id",facilityId);
			
			//System.err.println("Inside ProcessReferralNonReferral deLink Servlet file Check5");
			java.util.HashMap results =delinkOPProcessReferral(p, tabdata,con);
			//System.err.println("Inside ProcessReferralNonReferral deLink Servlet file Check6");
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;

	if ( inserted ){
		error_value = "1" ;
		out.println("<script>onSuccess('true');</script>");
	}
	else
	{
		out.println("<script>onSuccess('false');</script>");
	}
				if (pstmt != null)
					pstmt.close();
				if (pstmt1 != null)
					pstmt1.close();
				
					tabdata.clear();
	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="
	+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
	+ error_value);			
}
		catch(Exception e){	
			e.printStackTrace();
	}
	finally{
		System.err.println("Inside ProcessReferralNonReferral Servlet Delink file Check7");
		ConnectionManager.returnConnection(con,req);
	}	
}
	
	
	
	// Delink ProcessReferral method
	public java.util.HashMap delinkOPProcessReferral(java.util.Properties p,
			java.util.HashMap tabdata,Connection con) {

		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		StringBuffer sb = new StringBuffer();
        String locale = p.getProperty("LOCALE");
		String callfunc = (String) tabdata.get("callfunc");
		StringBuffer sql = new StringBuffer();
		StringBuffer sqlPE = new StringBuffer();
		StringBuffer sqlPR = new StringBuffer();
		StringBuffer sqlOPL =  new StringBuffer();

        
	//	System.err.println("Process referral delink===========");
		
		
		sql.append("UPDATE op_patient_queue set REFERRAL_ID = '', REFERRED_YN = 'N', ");
		sql.append("MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ? ");
		sql.append("WHERE EPISODE_ID = ? AND PATIENT_ID = ? ");
		
		sqlPE.append("UPDATE PR_ENCOUNTER set REFERRED_LOCN_CODE='', REFERRAL_ID = '', REFERRED_YN = '', ");
		sqlPE.append("MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ? ");
		sqlPE.append("WHERE EPISODE_ID = ? AND PATIENT_ID = ? ");
		
		sqlPR.append("UPDATE pr_referral_register set STATUS='O', REFERRED_IN_FUNC = null , CLOSE_ENCOUNTER_ID= '', ");
		sqlPR.append("MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ? ");
		sqlPR.append("WHERE referral_id = ? ");
		
		sqlOPL.append("UPDATE op_last_visit_for_service set REFERRAL_ID = '',  ");
		sqlOPL.append("MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ? ");
		sqlOPL.append("WHERE operating_facility_id=? and service_code=? and patient_id=? ");


		addedById = p.getProperty("login_user");
		addedDate = dateFormat.format(new java.util.Date());
		modifiedById = addedById;
		modifiedDate = addedDate;
		modifiedFacilityId = (String) tabdata.get("modified_facility_id");
		modifiedAtWorkstation = (String) tabdata.get("modified_at_ws_no");

		added_date = Date.valueOf(addedDate);
		modified_date = Date.valueOf(modifiedDate);

		

		try {
		//	con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			delinkHistDTL(tabdata,con);	//updating the OP_PAT_REFERRAL_HIST_DTL for existing patient's
			int res = UpdateDelinkData(callfunc, tabdata, sql, sqlPE, sqlPR, sqlOPL,con); 
			if (res != 0) {
				result = true;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));

				message.clear();
			} else {
				result = false;
				con.rollback();
java.util.Hashtable message = MessageManager.getMessage(locale,
						"ERROR_IN_UPDATING", "SM");
				sb.append((String) message.get("message"));
				message.clear();
			}

			sql.setLength(0);
			tabdata.clear();
		} catch (Exception e) {
            e.printStackTrace();
			try {
               con.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			sb.append(e.getMessage() + "<br>");
			e.printStackTrace();
		
		
		} 
		//finally {
		//	if (con != null)
		//		ConnectionManager.returnConnection(con, p);
		//}
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());

		return results;
	}
	
public int delinkHistDTL(java.util.HashMap tabdata,Connection con){

		ResultSet rs1 = null;
	ResultSet rs2 = null;
	ResultSet rs3 = null;
	PreparedStatement pstmt=null;
		StringBuffer sbf = new StringBuffer();
	int seqNum = 0;
	int rset = 0;
	int i = 0;
	String sql3="SELECT count(*) from OP_PAT_REFERRAL_HIST_DTL where patient_id = '"+(String) tabdata.get("patient_id")+"' and encounter_id = '"+(String) tabdata.get("encounter_id")+"'";
	try{
	pstmt = con.prepareStatement(sql3);
	rs2 = pstmt.executeQuery();
	rs2.next();
	i = rs2.getInt(1);
	if (pstmt != null) pstmt.close(); //CheckStyle issue 19-05-2023
	if (rs2 != null) rs2.close(); //CheckStyle issue DEC23
	}catch(Exception e){
		e.printStackTrace();
	}
	if(i==0){
		try{
		pstmt = con.prepareStatement("select * from op_patient_queue where patient_id = '"+(String) tabdata.get("patient_id")+"' and episode_id = '"+(String) tabdata.get("episode_id")+"' ");
		rs2 = pstmt.executeQuery();
		while(rs2.next()){
			try {
				pstmt = con.prepareStatement("SELECT op_pat_referral_hist_SEQ.NEXTVAL counter FROM DUAL");
				rs3 = pstmt.executeQuery();
				rs3.next();
				seqNum = rs3.getInt("counter");
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sbf.append("INSERT INTO OP_PAT_REFERRAL_HIST_DTL (HIST_REF_ID, ENCOUNTER_ID, PATIENT_ID, REFERRAL_BEFORE, REFERRAL_AFTER, MODULE_ID, FUNCTION_ID, MODIFIED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, VISIT_TYPE_IND)");
			sbf.append(" VALUES(?,?,?,?,?,?,?,?,?,sysdate,?,?,sysdate,?,?,?)");
			pstmt = con.prepareStatement(sbf.toString());
			pstmt.setInt(1,seqNum);
			pstmt.setString(2, rs2.getString("encounter_id"));
			pstmt.setString(3, (String) tabdata.get("patient_id"));
			pstmt.setString(4, (String) tabdata.get("referral_id"));
			pstmt.setString(5, "");
			pstmt.setString(6, "OP");
			pstmt.setString(7, "PROC_REF");
			pstmt.setString(8, modifiedFacilityId);
			pstmt.setString(9, modifiedById);
			pstmt.setString(10, modifiedAtWorkstation);
			pstmt.setString(11, modifiedById);
			pstmt.setString(12, modifiedAtWorkstation);
			pstmt.setString(13, modifiedFacilityId);
			pstmt.setString(14, rs2.getString("VISIT_TYPE_IND"));
			rset = pstmt.executeUpdate();
			if (pstmt != null)
				pstmt.close();
			if(rs3 != null)
				rs3.close();
			sbf.setLength(0);
		}
		if(rs2!=null)rs2.close();//Checkstyle Issue DEC23
		}catch(Exception e){
			e.printStackTrace();
			rset = 0;
		}
		return 1;
	}else{
		String sql = "select * from OP_PAT_REFERRAL_HIST_DTL where patient_id = '"+(String) tabdata.get("patient_id")+"' and REFERRAL_AFTER = '"+(String) tabdata.get("referral_id")+"'";
		try {
			if (pstmt != null) //CheckStyle issue 19-05-2023
				pstmt.close();
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, (String) tabdata.get("patient_id"));
			rs1 = pstmt.executeQuery();
			
			
			while(rs1.next()){
				
				sbf.append("UPDATE OP_PAT_REFERRAL_HIST_DTL set REFERRAL_BEFORE=?, REFERRAL_AFTER='', ");
				sbf.append("MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ? ");
				sbf.append("WHERE HIST_REF_ID = ? ");
				

				
				pstmt = con.prepareStatement(sbf.toString());
				
				//pstmt.setString(1, (String)tabdata.get("referral_id"));
				pstmt.setString(1, rs1.getString("referral_after"));
				pstmt.setString(2, modifiedById);
				pstmt.setString(3, modifiedFacilityId);
				pstmt.setString(4, modifiedAtWorkstation);
				pstmt.setInt(5, rs1.getInt("HIST_REF_ID"));
				//pstmt.setString(6, rs1.getString("encounter_id"));
				
				pstmt.executeUpdate();
				
				sbf.setLength(0);

				
			}
			
			if (pstmt != null)
				pstmt.close();
			
			if(rs1 != null) //CheckStyle issue 19-05-2023
				rs1.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return 1;
	}
	}
	public int UpdateDelinkData(String callfunc, java.util.HashMap tabdata,
			StringBuffer sql, StringBuffer sqlPE, StringBuffer sqlPR, StringBuffer sqlOPL,Connection con) {
		PreparedStatement pstmt=null;
		CallableStatement cstmt = null;
		int rest = 0;
		try {
			try{
			String reclac = "{ call   bl_recalc_process.proc_recalc (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			cstmt = con.prepareCall(reclac);
		//	System.err.println("hi in UpdateDelinkData modified_facility_id===>"+(String) tabdata.get("modified_facility_id"));
		//	System.err.println("hi in UpdateDelinkData patient_id===>"+(String) tabdata.get("patient_id"));
		//	System.err.println("hi in UpdateDelinkData patient_class===>"+(String) tabdata.get("patient_class"));
		//	System.err.println("hi in UpdateDelinkData episode_id===>"+(String) tabdata.get("episode_id"));
		//	System.err.println("hi in UpdateDelinkData visit_id===>"+(String) tabdata.get("visit_id"));
		//	System.err.println("hi in UpdateDelinkData modified_at_ws_no===>"+(String) tabdata.get("modified_at_ws_no"));
		//	System.err.println("hi in UpdateDelinkData modified_by_id===>"+(String) tabdata.get("modified_by_id"));
			//System.err.println("417 procedured called");
			String patient_class = ((String) tabdata.get("patient_class"));
			patient_class = patient_class.equalsIgnoreCase("IP")?"I":patient_class.equalsIgnoreCase("OP")?"O":patient_class.equalsIgnoreCase("XT")?"R":patient_class.equalsIgnoreCase("DC")?"D":patient_class.equalsIgnoreCase("EM")?"E":patient_class;
			//System.err.println("patient_class="+patient_class);
            cstmt.setString(1, (String) tabdata.get("modified_facility_id"));
            cstmt.setString(2, (String) tabdata.get("patient_id"));
            cstmt.setString(3, patient_class);
            cstmt.setString(4, (String) tabdata.get("episode_id"));
            cstmt.setString(5, (String) tabdata.get("visit_id"));
            cstmt.setString(6, (String) tabdata.get("modified_at_ws_no"));
            cstmt.setString(7, (String) tabdata.get("modified_by_id"));
			cstmt.setString(8, "ENCOUNTER_DEFINITION");//hard coded
			
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.registerOutParameter(12, Types.INTEGER);
			
			cstmt.setString(13, "");
			cstmt.setString(14, "");
			cstmt.setString(15, "");
			cstmt.execute();
			} catch (Exception e1) {
				System.err.println("Exception on call bl_recalc_process.proc_recalc procedure 437");
			e1.printStackTrace();
			} finally {
			cstmt.close();
			}

//System.err.println("444 procedured call executed");
//			System.err.println("443======="+sql.toString());
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, modifiedById);
			pstmt.setString(2, modifiedFacilityId);
			pstmt.setString(3, modifiedAtWorkstation);
			
			pstmt.setString(4, (String) tabdata.get("episode_id"));
			pstmt.setString(5, (String) tabdata.get("patient_id"));

			System.out.println("CheckFinal Episode_id:"+(String) tabdata.get("episode_id")+" Referral_id: "+ (String) tabdata.get("referral_id") +" Referral_YN: "+(String) tabdata.get("referred_yn")+" Patient_id: "+(String) tabdata.get("patient_id"));
			
			rest = pstmt.executeUpdate();
			if (pstmt != null)
				pstmt.close();
			if(rest != 0){
				try{
				//	System.out.println("op_patient_queue delink updated");
					pstmt = con.prepareStatement(sqlPE.toString());

					pstmt.setString(1, modifiedById);
					pstmt.setString(2, modifiedFacilityId);
					pstmt.setString(3, modifiedAtWorkstation);
					
					pstmt.setString(4, (String) tabdata.get("episode_id"));
					pstmt.setString(5, (String) tabdata.get("patient_id"));

					//System.out.println("CheckFinal Episode_id:"+(String) tabdata.get("episode_id")+" Referral_id: "+ (String) tabdata.get("referral_id") +" Referral_YN: "+(String) tabdata.get("referred_yn")+" Patient_id: "+(String) tabdata.get("patient_id"));
					
					rest = pstmt.executeUpdate();
					if (pstmt != null)
						pstmt.close();
					if(rest != 0){
						try{
					//		System.out.println("pr_encounter delink updated");
							pstmt = con.prepareStatement(sqlPR.toString());
							
							pstmt.setString(1, modifiedById);
							pstmt.setString(2, modifiedFacilityId);
							pstmt.setString(3, modifiedAtWorkstation);
							pstmt.setString(4, (String) tabdata.get("referral_id"));
							
							rest = pstmt.executeUpdate();
							if (pstmt != null)
								pstmt.close();
							if(rest != 0){
								
								try{
							//		System.out.println("referral_register delink updated");
									pstmt = con.prepareStatement(sqlOPL.toString());
									pstmt.setString(1, modifiedById);
									pstmt.setString(2, modifiedAtWorkstation);
									pstmt.setString(3, facilityId);
									pstmt.setString(4, (String) tabdata.get("service_code"));
									pstmt.setString(5, (String) tabdata.get("patient_id"));
									
									rest = pstmt.executeUpdate();
									if(rest!=0){
								//		System.out.println("op_last_visit_for_service delink updated");
									}
									if (pstmt != null)
										pstmt.close();
								}catch(Exception e){
									e.printStackTrace();
									rest = 0;
								}
								
							}
							
						}catch(Exception e){
							e.printStackTrace();
							rest = 0;
						}
					}
					
				}catch(Exception e){
					e.printStackTrace();
					rest = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			rest = 0;
		}
		tabdata.clear();
		return rest;
		
	}
	
	
	
	
	//Method for linking Referral ID operation.
		public void processLinkReferral(HttpServletRequest req, HttpServletResponse res)throws Exception{

		//	System.err.println("Inside ProcessReferralNonReferral Servlet file Check3");
		int res3=0;
		int res1=0;
		Connection con=null;
		Statement pstmt=null;
		Statement pstmt1=null;
		StringBuffer sql= new StringBuffer();
		String sql1=" ";
		try{
			//System.err.println("Inside ProcessReferralNonReferral Servlet file Check4");
				con = ConnectionManager.getConnection(req);
				con.setAutoCommit(false);
				episode_id = req.getParameter("episode_id")==null ? "":req.getParameter("episode_id");
				referral_yn = req.getParameter("referred_yn")==null ? "":req.getParameter("referred_yn");
				referral_id = req.getParameter("referral_id")==null ? "":req.getParameter("referral_id");
				patient_id = req.getParameter("patient_id")==null ? "":req.getParameter("patient_id");
				ref_locn_code = req.getParameter("ref_locn_code")==null ? "":req.getParameter("ref_locn_code");
				encounter_id = req.getParameter("encounter_id")==null ? "":req.getParameter("encounter_id");
				service_code = req.getParameter("service_code")==null ? "":req.getParameter("service_code");
				visit_id = req.getParameter("visit_id")==null ? "":req.getParameter("visit_id");
				patient_class = req.getParameter("patient_class")==null ? "":req.getParameter("patient_class");
			//	System.err.println("hi in servlet visit_id ===================>"+visit_id);
			//	System.err.println("hi in servlet patient_class ===================>"+patient_class);
			//	System.out.println("Episode_id:"+episode_id+" Referral_id: "+ referral_id+" Referral_YN: "+referral_yn+" Patient_id: "+patient_id+"Ref_Locn_Code: "+ ref_locn_code);
				
				String addedById = p.getProperty( "login_user" ) ;
				String modifiedById = addedById ;
				String addedAtWorkstation=client_ip_address;
				String modifiedAtWorkstation = addedAtWorkstation ;							
				HashMap tabdata=new HashMap();
				tabdata.put("callfunc","link");				
				tabdata.put("referred_yn",referral_yn);
				tabdata.put("referral_id",referral_id);
				tabdata.put("encounter_id",encounter_id);
				tabdata.put("service_code",service_code);				
				tabdata.put("patient_id",patient_id);
				tabdata.put("episode_id",episode_id);
				tabdata.put("ref_locn_code",ref_locn_code);	
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("modified_facility_id",facilityId);
				tabdata.put("visit_id",visit_id);
				tabdata.put("patient_class",patient_class);
			//	System.err.println("Inside ProcessReferralNonReferral Servlet file Check5");
				java.util.HashMap results =linkOPProcessReferral(p, tabdata,con);
		//		System.err.println("Inside ProcessReferralNonReferral Servlet file Check6");
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

		if ( inserted ){
			error_value = "1" ;
			out.println("<script>onSuccess('true');</script>");
		}
		else
		{
			//error = (String) results.get("error");
			out.println("<script>onSuccess('false');</script>");
		}
					if (pstmt != null)
						pstmt.close();
					if (pstmt1 != null)
						pstmt1.close();
					
						tabdata.clear();

		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="
		+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
		+ error_value);	
	}
			catch(Exception e){	
				e.printStackTrace();
		}
		finally{
			if(pstmt !=null) pstmt.close();  
			if(pstmt1 !=null) pstmt1.close();   			 
			//System.err.println("Inside ProcessReferralNonReferral Servlet file Check7");
			ConnectionManager.returnConnection(con,req);
		}	
	}
	
	
	
	public java.util.HashMap linkOPProcessReferral(java.util.Properties p,
			java.util.HashMap tabdata,Connection con) {
		java.util.HashMap results = new java.util.HashMap();
		boolean result = false;
		StringBuffer sb = new StringBuffer();
        String locale = p.getProperty("LOCALE");
		String callfunc = (String) tabdata.get("callfunc");
		StringBuffer sql = new StringBuffer();
		StringBuffer sqlPE = new StringBuffer();
		StringBuffer sqlPR = new StringBuffer();
		StringBuffer sqlOPL = new StringBuffer();
		sql.append("UPDATE op_patient_queue set REFERRAL_ID = ?, REFERRED_YN = ?, ");
		sql.append("MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ? ");
		sql.append("WHERE EPISODE_ID = ? AND PATIENT_ID = ? ");
		
		sqlPE.append("UPDATE PR_ENCOUNTER set REFERRED_LOCN_CODE=?, REFERRAL_ID = ?, REFERRED_YN = ?, ");
		sqlPE.append("MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ? ");
		sqlPE.append("WHERE ENCOUNTER_ID = ? AND PATIENT_ID = ? ");
		
		sqlPR.append("UPDATE pr_referral_register set STATUS='C', REFERRED_IN_FUNC = 2 , CLOSE_ENCOUNTER_ID= ?, ");
		sqlPR.append("MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ? ");
		sqlPR.append("WHERE referral_id = ? ");
		
		sqlOPL.append("UPDATE op_last_visit_for_service set REFERRAL_ID = ?,  ");
		sqlOPL.append("MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_AT_WS_NO = ? ");
		sqlOPL.append("WHERE operating_facility_id=? and service_code=? and patient_id=? ");	

		addedById = p.getProperty("login_user");
		addedDate = dateFormat.format(new java.util.Date());
		modifiedById = addedById;
		modifiedDate = addedDate;
		modifiedFacilityId = (String) tabdata.get("modified_facility_id");
		modifiedAtWorkstation = (String) tabdata.get("modified_at_ws_no");
		added_date = Date.valueOf(addedDate);
		modified_date = Date.valueOf(modifiedDate);
		try {
		//	con = ConnectionManager.getConnection(p);
			con.setAutoCommit(false);
			int res = UpdateLinkData(callfunc, tabdata, sql, sqlPE, sqlPR, sqlOPL,con); 
			if (res != 0) {
				result = true;
				con.commit();
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				sb.append((String) message.get("message"));

				message.clear();
			} else {
				result = false;
				con.rollback();
				java.util.Hashtable message = MessageManager.getMessage(locale,"ERROR_IN_UPDATING", "SM");
				sb.append((String) message.get("message"));
				message.clear();
			}

			sql.setLength(0);
			tabdata.clear();
		} catch (Exception e) {
            e.printStackTrace();
			try {
               con.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			sb.append(e.getMessage() + "<br>");
			e.printStackTrace();
		} 
		//finally {
		//	if (con != null)
		//		ConnectionManager.returnConnection(con, p);
		//}
		results.put("status", new Boolean(result));
		results.put("error", sb.toString());

		return results;
	}
	public int UpdateLinkData(String callfunc, java.util.HashMap tabdata,
			StringBuffer sql, StringBuffer sqlPE, StringBuffer sqlPR, StringBuffer sqlOPL,Connection con) {
StringBuffer sb = new StringBuffer();
		StringBuffer sbf = new StringBuffer();
		ResultSet rs2=null;
		ResultSet rs3 = null;
		PreparedStatement pstmt1=null;
		int seqNum=1;
		int rest = 0;
try{			
			
			int i = 0;
			String sql3="SELECT count(*) from OP_PAT_REFERRAL_HIST_DTL where patient_id = '"+(String) tabdata.get("patient_id")+"' and encounter_id = '"+(String) tabdata.get("encounter_id")+"'";
			pstmt1 = con.prepareStatement(sql3);
			
			rs2 = pstmt1.executeQuery();
			rs2.next();
			i = rs2.getInt(1);
			//alert
						if(rs2!= null)
							rs2.close();
						if(pstmt1 != null)
							pstmt1.close();	
			if(i==0){
				//Start of Insertion block
				

				
				pstmt1 = con.prepareStatement("select * from op_patient_queue where patient_id = '"+(String) tabdata.get("patient_id")+"' and episode_id = '"+(String) tabdata.get("episode_id")+"' and visit_type_ind = 'L'");
				rs2 = pstmt1.executeQuery();				
				
				while(rs2.next()){
					
					
					try {
						
						pstmt1 = con.prepareStatement("SELECT op_pat_referral_hist_SEQ.NEXTVAL counter FROM DUAL");
						rs3 = pstmt1.executeQuery();
						rs3.next();
						seqNum = rs3.getInt("counter");
						

						if (pstmt1 != null)
							pstmt1.close();						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					sb.append("INSERT INTO OP_PAT_REFERRAL_HIST_DTL (HIST_REF_ID, ENCOUNTER_ID, PATIENT_ID, REFERRAL_BEFORE, REFERRAL_AFTER, MODULE_ID, FUNCTION_ID, MODIFIED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, VISIT_TYPE_IND)");
					sb.append(" VALUES(?,?,?,?,?,?,?,?,?,sysdate,?,?,sysdate,?,?,?)");
					

					
					pstmt1 = con.prepareStatement(sb.toString());
					pstmt1.setInt(1,seqNum);
					pstmt1.setString(2, rs2.getString("encounter_id"));
					pstmt1.setString(3, (String) tabdata.get("patient_id"));
					pstmt1.setString(4, "");
					pstmt1.setString(5, (String) tabdata.get("referral_id"));
					pstmt1.setString(6, "OP");
					pstmt1.setString(7, "PROC_REF");
					pstmt1.setString(8, modifiedFacilityId);
					pstmt1.setString(9, modifiedById);
					pstmt1.setString(10, modifiedAtWorkstation);
					pstmt1.setString(11, modifiedById);
					pstmt1.setString(12, modifiedAtWorkstation);
					pstmt1.setString(13, modifiedFacilityId);
					pstmt1.setString(14, rs2.getString("VISIT_TYPE_IND"));					
					
					rest = pstmt1.executeUpdate();					
					
					if (pstmt1 != null)
						pstmt1.close();
					if(rs3 != null)
						rs3.close();
					sb.setLength(0);
				}

				if(pstmt1 !=null) pstmt1.close();//Added for Check Style Issue
				int seqNum1=0;
try {
					
					pstmt1 = con.prepareStatement("SELECT op_pat_referral_hist_SEQ.NEXTVAL counter FROM DUAL");
					rs3 = pstmt1.executeQuery();
					rs3.next();
					seqNum1 = rs3.getInt("counter");
					

					if (pstmt1 != null)
						pstmt1.close();
					if(rs3 != null) //CheckStyle issue 19-05-2023
						rs3.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				sb.setLength(0);
				sb.append("INSERT INTO OP_PAT_REFERRAL_HIST_DTL (HIST_REF_ID, ENCOUNTER_ID, PATIENT_ID, REFERRAL_BEFORE, REFERRAL_AFTER, MODULE_ID, FUNCTION_ID, MODIFIED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, VISIT_TYPE_IND)");
				sb.append(" VALUES(?,?,?,?,?,?,?,?,?,sysdate,?,?,sysdate,?,?,?)");
				

				
				pstmt1 = con.prepareStatement(sb.toString());
				pstmt1.setInt(1,seqNum1);
				pstmt1.setString(2, (String) tabdata.get("encounter_id"));
				pstmt1.setString(3, (String) tabdata.get("patient_id"));
				pstmt1.setString(4, "");
				pstmt1.setString(5, (String) tabdata.get("referral_id"));
				pstmt1.setString(6, "OP");
				pstmt1.setString(7, "PROC_REF");
				pstmt1.setString(8, modifiedFacilityId);
				pstmt1.setString(9, modifiedById);
				pstmt1.setString(10, modifiedAtWorkstation);
				pstmt1.setString(11, modifiedById);
				pstmt1.setString(12, modifiedAtWorkstation);
				pstmt1.setString(13, modifiedFacilityId);
				pstmt1.setString(14, "F");				
				
				rest = pstmt1.executeUpdate();				
				
				if (pstmt1 != null)
					pstmt1.close();		
		
				if(rs2 != null)
					rs2.close();
			//End of Insertion block
			}else{
				//if(rs2!= null)
				//	rs2.close();
				pstmt1 = con.prepareStatement("SELECT * from OP_PAT_REFERRAL_HIST_DTL where patient_id = '"+(String) tabdata.get("patient_id")+"' and encounter_id = '"+(String) tabdata.get("encounter_id")+"'");
				rs2 = pstmt1.executeQuery();
				while(rs2.next()){
					sbf.setLength(0);
					sbf.append("UPDATE OP_PAT_REFERRAL_HIST_DTL set REFERRAL_BEFORE='', REFERRAL_AFTER=?, ");
					sbf.append("MODIFIED_BY_ID = ?, MODIFIED_DATE = sysdate, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ? ");
					sbf.append("WHERE HIST_REF_ID = ?");
					

					
					pstmt1 = con.prepareStatement(sbf.toString());					
					
					//pstmt.setString(1, (String) tabdata.get("referral_id"));
					pstmt1.setString(1, rs2.getString("referral_before"));
					pstmt1.setString(2, modifiedById);
					pstmt1.setString(3, modifiedFacilityId);
					pstmt1.setString(4, modifiedAtWorkstation);
					pstmt1.setString(5, rs2.getString("HIST_REF_ID"));
					//pstmt.setString(6, rs2.getString("encounter_id"));

					pstmt1.executeUpdate();					
					
					if (pstmt1 != null)
					pstmt1.close();	
					sbf.setLength(0);
				}	
			}
		//	System.err.println("procedured call 860");
			CallableStatement cstmt = null;
			try{
				String reclac = "{ call   bl_recalc_process.proc_recalc (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
				cstmt = con.prepareCall(reclac);
			//	System.err.println("hi in UpdateDelinkData modified_facility_id===>"+(String) tabdata.get("modified_facility_id"));
			//	System.err.println("hi in UpdateDelinkData patient_id===>"+(String) tabdata.get("patient_id"));
			//	System.err.println("hi in UpdateDelinkData patient_class===>"+(String) tabdata.get("patient_class"));
			//	System.err.println("hi in UpdateDelinkData episode_id===>"+(String) tabdata.get("episode_id"));
			//	System.err.println("hi in UpdateDelinkData visit_id===>"+(String) tabdata.get("visit_id"));
			//	System.err.println("hi in UpdateDelinkData modified_at_ws_no===>"+(String) tabdata.get("modified_at_ws_no"));
			//	System.err.println("hi in UpdateDelinkData modified_by_id===>"+(String) tabdata.get("modified_by_id"));
				//System.err.println("729 procedured called");
				String patient_class = ((String) tabdata.get("patient_class"));
				patient_class = patient_class.equalsIgnoreCase("IP")?"I":patient_class.equalsIgnoreCase("OP")?"O":patient_class.equalsIgnoreCase("XT")?"R":patient_class.equalsIgnoreCase("DC")?"D":patient_class.equalsIgnoreCase("EM")?"E":patient_class;
				//System.err.println("patient_class="+patient_class);
				cstmt.setString(1, (String) tabdata.get("modified_facility_id"));
				cstmt.setString(2, (String) tabdata.get("patient_id"));
				cstmt.setString(3, patient_class);
				cstmt.setString(4, (String) tabdata.get("episode_id"));
				cstmt.setString(5, (String) tabdata.get("visit_id"));
				cstmt.setString(6, (String) tabdata.get("modified_at_ws_no"));
				cstmt.setString(7, (String) tabdata.get("modified_by_id"));
				cstmt.setString(8, "ENCOUNTER_DEFINITION");//hard coded
				
				cstmt.registerOutParameter(9, Types.VARCHAR);
				cstmt.registerOutParameter(10, Types.VARCHAR);
				cstmt.registerOutParameter(11, Types.VARCHAR);
				cstmt.registerOutParameter(12, Types.INTEGER);
				
				cstmt.setString(13, "");
				cstmt.setString(14, "");
				cstmt.setString(15, "");
				
				cstmt.execute();
			} catch (Exception e1) {
				System.err.println("Exception on call bl_recalc_process.proc_recalc procedure");
			e1.printStackTrace();
			} finally {
			cstmt.close();
			}
		//	System.err.println("procedured call executed 899");
		}catch (Exception e) {
			e.printStackTrace();
			//rest = 0;
		}
		
		try {
			System.err.println(sql.toString());
			pstmt1 = con.prepareStatement(sql.toString());
			
			pstmt1.setString(1, (String) tabdata.get("referral_id"));
			pstmt1.setString(2, (String) tabdata.get("referred_yn"));
			
			pstmt1.setString(3, modifiedById);
			//pstmt.setDate(4, (Date) tabdata.get("modified_date"));
			pstmt1.setString(4, modifiedFacilityId);
			pstmt1.setString(5, modifiedAtWorkstation);
			
			pstmt1.setString(6, (String) tabdata.get("episode_id"));
			pstmt1.setString(7, (String) tabdata.get("patient_id"));

			System.out.println("CheckFinal Episode_id:"+(String) tabdata.get("episode_id")+" Referral_id: "+ (String) tabdata.get("referral_id") +" Referral_YN: "+(String) tabdata.get("referred_yn")+" Patient_id: "+(String) tabdata.get("patient_id"));
			
			rest = pstmt1.executeUpdate();
			if (pstmt1 != null)
				pstmt1.close();
			if(rest != 0){
				try{
				//	System.out.println("op_patient_queue updated");
					pstmt1 = con.prepareStatement(sqlPE.toString());
					pstmt1.setString(1, (String) tabdata.get("ref_locn_code"));
					pstmt1.setString(2, (String) tabdata.get("referral_id"));
					pstmt1.setString(3, (String) tabdata.get("referred_yn"));
					
					pstmt1.setString(4, modifiedById);
					//pstmt.setDate(5, (Date) tabdata.get("modified_date"));
					pstmt1.setString(5, modifiedFacilityId);
					pstmt1.setString(6, modifiedAtWorkstation);
					
					pstmt1.setString(7, (String) tabdata.get("encounter_id"));
					pstmt1.setString(8, (String) tabdata.get("patient_id"));

					//System.out.println("CheckFinal Episode_id:"+(String) tabdata.get("episode_id")+" Referral_id: "+ (String) tabdata.get("referral_id") +" Referral_YN: "+(String) tabdata.get("referred_yn")+" Patient_id: "+(String) tabdata.get("patient_id"));
					
					rest = pstmt1.executeUpdate();
					if (pstmt1 != null)
						pstmt1.close();
					if(rest != 0){
						try{
						//	System.out.println("pr_encounter updated");
							pstmt1 = con.prepareStatement(sqlPR.toString());
							pstmt1.setString(1, (String) tabdata.get("encounter_id"));
							pstmt1.setString(2, modifiedById);
							pstmt1.setString(3, modifiedFacilityId);
							pstmt1.setString(4, modifiedAtWorkstation);
							pstmt1.setString(5, (String) tabdata.get("referral_id"));							
							
							rest = pstmt1.executeUpdate();
							if (pstmt1 != null)
								pstmt1.close();
							if(rest != 0){
								
								try{
								//	System.out.println("referral_register updated");
									pstmt1 = con.prepareStatement(sqlOPL.toString());
									pstmt1.setString(1, (String) tabdata.get("referral_id"));
									pstmt1.setString(2, modifiedById);
									pstmt1.setString(3, modifiedAtWorkstation);
									pstmt1.setString(4, facilityId);
									pstmt1.setString(5, (String) tabdata.get("service_code"));
									pstmt1.setString(6, (String) tabdata.get("patient_id"));
									
									rest = pstmt1.executeUpdate();
									if(rest!=0){
									//	System.out.println("op_last_visit_for_service updated");
									}
									if (pstmt1 != null)
										pstmt1.close();
								}catch(Exception e){
									e.printStackTrace();
									rest = 0;
								}
								
							}
							
						}catch(Exception e){
							e.printStackTrace();
							rest = 0;
						}
					}
					
				}catch(Exception e){
					e.printStackTrace();
					rest = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			rest = 0;
		}
		tabdata.clear();
		return rest;
	}
	
	
	
	
	
	
	
	

}