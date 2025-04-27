/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//***** Last Modified Date Time : 12/5/2005 3:48 PM *******//

package eMP; 

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eMP.NewbornRegistration.*;
import eCommon.Common.CommonBean;
import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;
import eCommon.SingleTabHandler.SingleTabHandlerManagerRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ehis.util.*;
import java.util.Iterator; 

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

public class NewbornRegistrationServlet extends javax.servlet.http.HttpServlet {

	
	
    PrintWriter out	= null;
    Properties p	= null;
	
    //Connection con					= null;
    //PreparedStatement pstmt			= null;
	//PreparedStatement pstmt_father	= null;
	//PreparedStatement pstmt_query	= null;
	//PreparedStatement pstmt_1		= null;
    //Statement stmt					= null;
    //ResultSet rset					= null;
	//ResultSet rset_1				= null;
   
    //String sql						= "";
   // String numberOfBirths			= "";
	String client_ip_address		= "";
    String addedById				= "";
    String facilityId				= "";
	String parent_details			= "";
	String mode						= "";
	String bl_install_yn			= "";
	String dflt_nb_regn_blng_class	= "";
	String MRN_function_id			= "";
	String MRN_multiple_birth_yn	= "";
	String sStyle					= "";
	String maintain_doc_or_file		= "";
	String name_dervn_logic			= "";
	String name_dervn_logic_oth_lang = "";
	String pat_name_as_multipart_yn	= "";
	String accessRights				= "";
	HashMap fin_dtls				=	null;
	String regnb="";
	String newBornOutCome="";
	String finalized_yn="";
	//String called_from_mothercare = "";	
	String bl_success_msg = "";
	String single_stage_nb_reg_appl_yn = "";
	String mother_encounter_id		= "";
	String mother_nursing_unit		= "";

	Boolean isRemoveReport = false;	// Added By Dharma on May 26th 2015 against HSA-CRF-0228 [IN:050965]

	int tempflag	= 0;
	int numOfbaby	= 0;
	int noOfBirths	= 0;

	//String noofbirths_value			= "";
	//String multiplebirthyn_value	= "";
	//String gestation_value			= "";
	//String gestation_days_value			= "";
	//String gravida_values			= "";
	//String parity_values			= "";
	//String fatherpatientid_value	= "";
	//String fathername_value			= "";
	//String fathernricno_value		= "";
	//String fatherothaltid_value		= "";
	//String fatherothaltiddesc_value	= "";
	//String fathernationality_value	= "";
	//String fatherrace_value			= "";
	//String fathergovtemp_value		= "";
	//String fatherreligion_value		= "";
	//String fartheroccuclass_value	= "";
	//String fatheroccu_value			= "";
	//String fatheroccudesc_value		= "";
	//String mother_patient_id		= "";
	
    
   // String birth_place_code			= "";
	//String birth_place_desc			= "";
	
	
	
   
	
	
	//String mother_bed_no			= "";
	
	//String called_from				= "";
	
	//String invoke_chg_pat_dtls_fm_nb_yn	= "";
	
	//String function_id = "";
	

	java.util.HashMap MRNResults	= null;
	HttpSession session				= null;

	public void init(ServletConfig config) throws ServletException{
        super.init(config);
    }
	
    public synchronized void doPost(HttpServletRequest request, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		//ResultSet rset2 = null;
		//ResultSet rset3 = null;
		String locale = "";	
		single_stage_nb_reg_appl_yn="";
		//called_from_mothercare="";
		 /* this line was commmanted by VenkateshS,Reason is this is "unused variable" while generate checkstyle report */
		//String called_from_mothercare = "";
		session					= request.getSession(false);
        this.p						= (java.util.Properties) session.getValue( "jdbc" ) ;
        this.facilityId			= (String) session.getValue( "facility_id" ) ;
		fin_dtls=(HashMap)session.getAttribute("financial_details");
        this.client_ip_address  = p.getProperty("client_ip_address");
		request.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		request = new XSSRequestWrapper(request);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
		//sStyle	= (String)session.getAttribute("PREFERRED_STYLE") == null ? "IeStyle.css" : (String)session.getAttribute("PREFERRED_STYLE");
		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
				.getAttribute("PREFERRED_STYLE")
				: "IeStyle.css";
		locale = p.getProperty("LOCALE");
		regnb = request.getParameter("function_name_nb");
		if(regnb == null)
				regnb ="";		
		bl_install_yn			= request.getParameter("bl_install_yn") == null ? "N" : request.getParameter("bl_install_yn");
		dflt_nb_regn_blng_class = request.getParameter("dflt_nb_regn_blng_class") == null ? "" : request.getParameter("dflt_nb_regn_blng_class");		
		try{
			//con	= ConnectionManager.getConnection(request);
			res.setContentType("text/html");
            this.out = res.getWriter();	
            // code changed by KaviN for Edge Conversion
            out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
     		out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
     		out.println("async function callNewbornRegistrationServletHTML() { ");
			//int father_age		= 0;
			//int father_min_age	= 0;			
			//String father_patientid	= request.getParameter("father_patient_id") == null ? "" : request.getParameter("father_patient_id");	

			//father_min_age = Integer.parseInt(request.getParameter("nb_father_min_age") == null ? "" : request.getParameter("nb_father_min_age"));	

			name_dervn_logic = request.getParameter("name_drvn_logic") == null ? "" : request.getParameter("name_drvn_logic");	

			pat_name_as_multipart_yn = request.getParameter("pat_name_as_multipart_yn") == null ? "Y" : request.getParameter("pat_name_as_multipart_yn");	

			name_dervn_logic_oth_lang = request.getParameter("name_drvn_logic_oth_lang") == null ? "Y" : request.getParameter("name_drvn_logic_oth_lang");
			
			mode = request.getParameter("mode");
            if(mode == null) mode="";

			/*	
			
			String sql_check = "select nvl(NB_FATHER_MIN_AGE,0) NB_FATHER_MIN_AGE, invoke_chg_pat_dtls_fm_nb_yn, name_dervn_logic, pat_name_as_multipart_yn,name_dervn_logic_oth_lang from mp_param_lang_vw where language_id='"+locale+"'";			
			pstmt_query = con.prepareStatement(sql_check);
			rset3=pstmt_query.executeQuery();			
			if(rset3.next()){
				father_min_age = rset3.getInt("NB_FATHER_MIN_AGE");
				invoke_chg_pat_dtls_fm_nb_yn = rset3.getString("invoke_chg_pat_dtls_fm_nb_yn");
				name_dervn_logic = rset3.getString("name_dervn_logic");
				pat_name_as_multipart_yn = rset3.getString("pat_name_as_multipart_yn");
				name_dervn_logic_oth_lang= rset3.getString("name_dervn_logic_oth_lang");
				if(invoke_chg_pat_dtls_fm_nb_yn == null || invoke_chg_pat_dtls_fm_nb_yn.equals("null"))
					invoke_chg_pat_dtls_fm_nb_yn = "";
				if(name_dervn_logic == null || name_dervn_logic.equals("null"))
					name_dervn_logic = "";
				if(pat_name_as_multipart_yn == null || pat_name_as_multipart_yn.equals("null"))
					pat_name_as_multipart_yn = "Y";
				if(name_dervn_logic_oth_lang==null)
					name_dervn_logic_oth_lang="";				
			}
			
			if(!father_patientid.equals("")){ 
				String sql1 = "SELECT patient_name,SEX FROM mp_patient WHERE patient_id = ? ";
                pstmt_1 = con.prepareStatement(sql1);
                pstmt_1.setString(1,father_patientid);
                rset_1 = pstmt_1.executeQuery();
                boolean flag = true;
                if(rset_1.next()){ 
                    if(!rset_1.getString(2).equals("M")){
						MessageManager mm = new MessageManager();
				        final java.util.Hashtable mesg = mm.getMessage(locale, "GENDER_MISMATCH", "MP") ;
						String msg1=(String)mesg.get("message");
					    flag = false;
   						out.println("<html><head><script language = 'javascript' src = '../eCommon/js/common.js' ></script></head><body><script language = 'javascript'>var error = '"+msg1+"'");
						out.println("document.location.href = '../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';</script></body></html>");
                    }
                }else{
					MessageManager mm = new MessageManager();
				    final java.util.Hashtable mesg = mm.getMessage(locale, "FATHER_PATID_INVALID", "MP") ;
					String msg1=(String)mesg.get("message");
					flag = false;
					out.println("<html><head><script language = 'javascript' src = '../eCommon/js/common.js' ></script></head><body><script language = 'javascript'>var error ='"+msg1+"'");
					out.println("document.location.href = '../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';</script></body></html>");
                }
				if(rset_1 != null) rset_1.close();
                if(flag){ 
					String sql_query = "select calculate_age(to_char(date_of_birth,'dd/mm/yyyy'), 1) from mp_patient where patient_id=?";
					pstmt_father = con.prepareStatement(sql_query);
					pstmt_father.setString(1,father_patientid);
					rset2 = pstmt_father.executeQuery();
					if(rset2.next()){
						father_age = rset2.getInt(1);
					}					
					if(father_age < father_min_age){
						MessageManager mm = new MessageManager();
						final java.util.Hashtable mesg = mm.getMessage(locale, "FATHER_AGE_PARAM", "MP") ;
						String msg1=(String)mesg.get("message");
					    out.println("<html><head><script language = 'javascript' src = '../eCommon/js/common.js' ></script></head><body><script language = 'javascript'>var error ='"+msg1+"'");
						out.println("document.location.href = '../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';</script></body></html>");
					}
                }
			}
		
			String value2 = request.getParameter("date_of_birth") == null ? "" : request.getParameter("date_of_birth");
			if(!value2.equals("")){
				if(!locale.equals("en")){ 	
					value2= DateUtils.convertDate(value2,"DMYHM",locale,"en");
				}
			}
			String value3 = request.getParameter("BDVal1") == null ? "" : request.getParameter("BDVal1");
			if(!value2.equals("")){
				String d1=value2.substring(0,value2.indexOf(" "));
				String d3=value3.substring(0,value3.indexOf("*"));
				String d4=value3.substring(value3.indexOf("*" )+1);
				if(d3.equals("H")){
					sql="SELECT (TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi')";
					sql=sql +" - ";
					sql=sql +"TO_DATE('"+value2+"','dd/mm/yyyy hh24:mi'))* 100 FROM dual";
				}else{
					sql="SELECT (TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy')";
					sql=sql +" - ";
					sql=sql +"TO_DATE('"+d1+"','dd/mm/yyyy')) FROM dual";
				}				
				pstmt = con.prepareStatement(sql);
                rset  = pstmt.executeQuery();
				double diff = 0;
                if(rset != null){
					while(rset.next()){
						diff = rset.getDouble(1);
					}
				}
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				double d44	= Double.parseDouble(d4);

				if(!mode.equals("Query")){
					if(d3.equals("H")){
						if(diff > (d44*4.1666667)){
							MessageManager mm = new MessageManager();
							final java.util.Hashtable mesg = mm.getMessage(locale, "REGN_RESTRICTED_FOR_NB", "MP") ;
							String msg1=(String)mesg.get("message");					    
							out.println("<html><head><script language = 'javascript' src = '../eCommon/js/common.js' ></script></head><body><script language = 'javascript'>var error = '"+msg1+"'");
							out.println("document.location.href = '../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';</script></body></html>");
						}
					}else
					{
						if(diff > d44)
						{    MessageManager mm = new MessageManager();
				         final java.util.Hashtable mesg = mm.getMessage(locale, "REGN_RESTRICTED_FOR_NB", "MP") ;
						     
						 String msg1=(String)mesg.get("message");
					     
							out.println("<html><head><script language = 'javascript' src = '../eCommon/js/common.js' ></script></head><body><script language = 'javascript'>var error = var error = '"+msg1+"'");
							out.println("document.location.href = '../eCommon/jsp/error.jsp?err_num='+error+'&err_value=0';</script></body></html>");
						}
					}
				} //end of mode check. Should be done only if called from NewBornRegistration.jsp
			}			
			*/ 			

            String operation = request.getParameter("function_name");
			if(operation == null) operation = "";

			/*
            if(operation.equals("Generate_File")) {
				String patId		= request.getParameter("father_patient_id");
				mother_patient_id	= request.getParameter("mother_patient_id") == null ? "" : request.getParameter("mother_patient_id");
				String fatherPatsql = " select patient_name, SEX from mp_patient where PATIENT_ID = ? ";
				pstmt = con.prepareStatement(fatherPatsql);
				pstmt.setString(1,patId) ;
				rset = pstmt.executeQuery();
				if(!rset.next() && !patId.equals("")){ 
					MessageManager mm = new MessageManager();
					final java.util.Hashtable mesg = mm.getMessage(locale, "FATHER_PATID_INVALID", "MP") ;
				    String msg1=(String)mesg.get("message");
				  	String disp = "<script>alert('"+msg1+"');</script>";
					out.println("<script>location.href =\"../eCommon/jsp/error.jsp?home_required_yn=Y&err_num=" +java.net.URLEncoder.encode( disp , "UTF-8")+ "\"</script>");
				}else{
					patId		= request.getParameter("mother_patient_id");
					operation	= promptFileGen(request, res);
				}
				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
            }
			*/

			
            if(mode.equals("Query")){
				updateNewbornRegistration(request, res);
			}else if(operation.equals("insert")){
				insertNewbornRegistration(request, res);
			}else if( operation.equals("update_file_no") ){
				updateFileNumber(request);
			}            
			//if(pstmt_1 != null) pstmt_1.close(); pstmt_1=null;
			//if(pstmt_father != null) pstmt_father.close(); pstmt_father = null;
			//if(pstmt_query != null) pstmt_query.close(); pstmt_query = null;
			//if(stmt != null) stmt.close(); stmt = null;
            out.println("} callNewbornRegistrationServletHTML();</script></body></html>");
			out = null;
			//sql = null;
			//if(rset_1 != null) rset_1.close();rset_1 = null;
			//if(rset2 != null) rset2.close();rset2 = null;
			//if(rset3 != null) rset3.close();rset3 = null;
			
        }catch(Exception e){
            //out.println(e.toString());
			e.printStackTrace();
        }finally{
			//ConnectionManager.returnConnection(con,request);
			//con = null;
		}
	}

    private synchronized void updateFileNumber(HttpServletRequest request){
		String old_file_no	= request.getParameter("old_file_no") == null ?"" : request.getParameter("old_file_no");
        if(old_file_no.equals("null") || old_file_no.equals(" ") )  old_file_no = "" ;
        String birth_place_code = "";
        String birth_place_desc = "";
		String fs_locn_code = request.getParameter("fs_locn_code") ;
        if(fs_locn_code == null) fs_locn_code ="";
        if(fs_locn_code.equals("null") || fs_locn_code.equals(" ")) fs_locn_code = "" ;
		single_stage_nb_reg_appl_yn="";
		String called_from_mothercare = "";			 
		String mother_bed_no				= request.getParameter("mother_bed_no");
		String called_from				= request.getParameter("called_from");
		//System.out.println("called_from servlet--->"+called_from);
		String mother_id				= request.getParameter("mother_id");
		String pat_id				= request.getParameter("patient_id");
        String facility_id			= request.getParameter("facility_id");
        String gen_file_no			= request.getParameter("gen_file_no");
        String pat_ser_grp_code		= request.getParameter("pat_ser_grp_code");
		//String function_id			= request.getParameter("function_id");
		String function_id_mg		= request.getParameter("function_id_mg");
		single_stage_nb_reg_appl_yn	= request.getParameter("single_stage_nb_reg_appl_yn");
		called_from_mothercare	= request.getParameter("called_from_mothercare");

		String nbUseMotherSer = request.getParameter("nb_use_mother_ser") == null ? "" : request.getParameter("nb_use_mother_ser");
		String patIidLength = request.getParameter("maxLength") == null ? "" : request.getParameter("maxLength");
		String nbPatSerGrp = request.getParameter("newborn_pat_ser_grp") == null ? "" : request.getParameter("newborn_pat_ser_grp");		
		String invkAdmFrmNBYn = request.getParameter("invoke_adm_from_newborn_yn") == null ? "" : request.getParameter("invoke_adm_from_newborn_yn");
		String ipInstallYn = request.getParameter("ip_install_yn") == null ? "" : request.getParameter("ip_install_yn");
		String siteId = request.getParameter("siteId") == null ? "" : request.getParameter("siteId"); 		
		
         boolean err = false;

        Connection con_mrn = null;
        Statement stmt_mrn = null;
        ResultSet rset_mrn = null;

        try
        {
			con_mrn = ConnectionManager.getConnection(request);
			stmt_mrn = con_mrn.createStatement() ;
			/*Below query modified by venkatesh.s against Auditing columns updating */
			String  sql = "update mr_pat_file_index set old_file_no='"+old_file_no+"',fs_locn_code = '"+fs_locn_code+"', MODIFIED_AT_WS_NO='"+p.getProperty("client_ip_address")+"' ,MODIFIED_BY_ID='"+p.getProperty( "login_user" )+"',MODIFIED_FACILITY_ID='"+facility_id+"',MODIFIED_DATE=sysdate  where facility_id='"+facility_id+"' and patient_id='"+pat_id+"' and file_no='"+gen_file_no+"' ";
			
			
			stmt_mrn.executeUpdate(sql);
			 if(rset_mrn != null)    rset_mrn.close ();
			if(stmt_mrn != null)    stmt_mrn.close();
		}
        catch(Exception e)
        {
            err = true;
			e.printStackTrace();
        }
        finally
        {
           if(con_mrn != null) ConnectionManager.returnConnection(con_mrn,request);
        }
		
		if(!err)
		{
			doOnlineReports(request, pat_id, pat_ser_grp_code,function_id_mg);			
			callChangePatDetails(request, MRNResults, true, MRN_function_id, MRN_multiple_birth_yn, pat_id,birth_place_code,birth_place_desc,called_from_mothercare,mother_id, nbUseMotherSer, patIidLength, nbPatSerGrp, invkAdmFrmNBYn, ipInstallYn, siteId,called_from,mother_bed_no, mother_encounter_id);//Rameez for SKR-SCF-0668 [IN:035813] on 22-Nov-12 -added 'mother_encounter_id' param
			
		}
	}

private synchronized void insertNewbornRegistration(HttpServletRequest request, HttpServletResponse res){
	String locale="";
	String numberOfBirths			= "";
	String noofbirths_value			= "";
	String called_from_mothercare			= "";
	try{		
		res.setContentType("text/html");
		locale = p.getProperty("LOCALE");
		HashMap tabdata = new HashMap() ;
		tabdata.put("fin_dtls",(HashMap)fin_dtls);
		String bcg_datetime		= request.getParameter("bcg_datetime") == null ? "" : request.getParameter("bcg_datetime");
		if(!bcg_datetime.equals("")){
			if(!locale.equals("en")){ 	
				bcg_datetime= DateUtils.convertDate(bcg_datetime,"DMYHM",locale,"en");
			}
		}
		String vitk_datetime	= request.getParameter("vitk_datetime") == null ? "" : request.getParameter("vitk_datetime");
		if(!vitk_datetime.equals("")){
			if(!locale.equals("en")){ 	
				vitk_datetime= DateUtils.convertDate(vitk_datetime,"DMYHM",locale,"en");
			}
		}
		String hepb_datetime     = request.getParameter("hepb_datetime")==null?"":request.getParameter("hepb_datetime");
		if(!hepb_datetime.equals("")){
			if(!locale.equals("en")){ 	
				hepb_datetime= DateUtils.convertDate(hepb_datetime,"DMYHM",locale,"en");
			}
		}

		String function_id_mg = (request.getParameter("function_id_mg")==null?"":request.getParameter("function_id_mg"));

		String sel_accession_num = request.getParameter("sel_accession_num")==null?"":request.getParameter("sel_accession_num"); //Added by Ashwini on 24-oct-2016 for MO-CRF-20108
		
		/*
		boolean flag = false;
		float val = 0.0f;
		String Diffsql = "";
		String sysDateTime = "";
		Statement stmtDt = null;
		ResultSet rs = null;
		
		if (!bcg_datetime.equals("")){
			stmtDt = con.createStatement();
			Diffsql = "SELECT (TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi'))-TO_DATE ('"+bcg_datetime+"','dd/mm/yyyy hh24:mi') FROM DUAL"	;
			rs =  stmtDt.executeQuery(Diffsql);
			if (rs.next()){
				sysDateTime = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(stmtDt!=null) stmtDt.close();
			val = new Float(sysDateTime).floatValue();
			if ( val < 0.0 ){
				flag = true;
			}
		}

		if (!vitk_datetime.equals("")){			
			stmtDt = con.createStatement();
			Diffsql = "SELECT (TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi'))-TO_DATE ('"+vitk_datetime+"','dd/mm/yyyy hh24:mi') FROM DUAL";
			rs =  stmtDt.executeQuery(Diffsql);
			if (rs.next()){
				sysDateTime = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(stmtDt!=null) stmtDt.close();
			val = new Float(sysDateTime).floatValue();
			if (val < 0.0 ){
				flag = true;
			}
		}
		if (!hepb_datetime.equals("")){
			stmtDt = con.createStatement();
			Diffsql = "SELECT (TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi'))-TO_DATE ('"+hepb_datetime+"','dd/mm/yyyy hh24:mi') FROM DUAL";
			rs =  stmtDt.executeQuery(Diffsql);
			if (rs.next()){
				  sysDateTime = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(stmtDt!=null) stmtDt.close();
			val = new Float(sysDateTime).floatValue();
			if ( val < 0.0 ){
				flag = true;
			}
		}
		if ( flag == true){  MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "CANNOT_GREATER", "MP") ;				
			String       msg1=(String)mesg.get("message");				
			String disp="<script> var str = '"+msg1+ "' str = str.replace('#', 'Adm Date/Time');str = str.replace('$', 'System Date/Time'); alert(str);</script>";
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?home_required_yn=Y&err_num=" +java.net.URLEncoder.encode( disp , "UTF-8")+ "\"</script>");
		}else{
		*/

			String nbUseMotherSer = request.getParameter("nb_use_mother_ser") == null ? "" : request.getParameter("nb_use_mother_ser");
			String patIidLength = request.getParameter("maxLength") == null ? "" : request.getParameter("maxLength");
			String nbPatSerGrp = request.getParameter("newborn_pat_ser_grp") == null ? "" : request.getParameter("newborn_pat_ser_grp");
			String invkAdmFrmNBYn = request.getParameter("invoke_adm_from_newborn_yn") == null ? "" : request.getParameter("invoke_adm_from_newborn_yn");
			String ipInstallYn = request.getParameter("ip_install_yn") == null ? "" : request.getParameter("ip_install_yn");
			String siteId = request.getParameter("siteId") == null ? "" : request.getParameter("siteId");			
			
			String nb_dflt_relnship_code = request.getParameter("nb_dflt_relnship_code") == null ? "" : request.getParameter("nb_dflt_relnship_code");
			String mother_witnessed_by1			= request.getParameter("mother_witnessed_by1") == null ? "" : request.getParameter("mother_witnessed_by1");
			String mother_witnessed_by2			= request.getParameter("mother_witnessed_by2") == null ? "" : request.getParameter("mother_witnessed_by2");
			String mother_alive_yn				= request.getParameter("mother_alive_yn") == null ? "Y" : request.getParameter("mother_alive_yn");
			
			/*
			tabdata.put("nb_use_mother_ser", (request.getParameter("nb_use_mother_ser") == null ? "" : request.getParameter("nb_use_mother_ser"))) ;
			tabdata.put("maxLength", (request.getParameter("maxLength") == null ? "" : request.getParameter("maxLength"))) ;
			tabdata.put("newborn_pat_ser_grp", (request.getParameter("newborn_pat_ser_grp") == null ? "" : request.getParameter("newborn_pat_ser_grp"))) ;
			tabdata.put("invoke_adm_from_newborn_yn", (request.getParameter("invoke_adm_from_newborn_yn") == null ? "" : request.getParameter("invoke_adm_from_newborn_yn"))) ;
			tabdata.put("siteId",(request.getParameter("siteId") == null ? "" : request.getParameter("siteId")));
			*/

			tabdata.put("nb_use_mother_ser", nbUseMotherSer);
			tabdata.put("maxLength", patIidLength);
			tabdata.put("newborn_pat_ser_grp", nbPatSerGrp);
			tabdata.put("nb_dflt_relnship_code", nb_dflt_relnship_code);
			tabdata.put("invoke_adm_from_newborn_yn", invkAdmFrmNBYn);
			tabdata.put("siteId",siteId);
			tabdata.put("ip_install_yn", ipInstallYn);

			tabdata.put("bcg_datetime",bcg_datetime) ;
			tabdata.put("vitk_datetime",vitk_datetime) ;
			tabdata.put("hepb_datetime",hepb_datetime) ;
			//Newly added for Category fields
			/*Added by Dharma on 4th June 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
			tabdata.put("mother_witnessed_by1", mother_witnessed_by1);
			tabdata.put("mother_witnessed_by2", mother_witnessed_by2);
			tabdata.put("mother_alive_yn", mother_alive_yn);
			/*Added by Dharma on 4th June 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/

			tabdata.put("mthr_alt_id1_no", (request.getParameter("mthr_alt_id1_no") == null ? "" : request.getParameter("mthr_alt_id1_no")));
			tabdata.put("mthr_alt_id2_no", (request.getParameter("mthr_alt_id2_no") == null ? "" : request.getParameter("mthr_alt_id2_no")));
			tabdata.put("mthr_alt_id3_no", (request.getParameter("mthr_alt_id3_no") == null ? "" : request.getParameter("mthr_alt_id3_no")));
			tabdata.put("mthr_alt_id4_no", (request.getParameter("mthr_alt_id4_no") == null ? "" : request.getParameter("mthr_alt_id4_no")));
			tabdata.put("mthr_alt_id1_type", (request.getParameter("mthr_alt_id1_type") == null ? "" : request.getParameter("mthr_alt_id1_type")));
			tabdata.put("mthr_nat_id_no", (request.getParameter("mthr_nat_id_no") == null ? "" : request.getParameter("mthr_nat_id_no")));
			tabdata.put("mthr_oth_alt_id_No", (request.getParameter("mthr_oth_alt_id_No") == null ? "" : request.getParameter("mthr_oth_alt_id_No")));
			tabdata.put("oth_alt_id_type", (request.getParameter("oth_alt_id_type") == null ? "" : request.getParameter("oth_alt_id_type")));

			tabdata.put("name_prefix_male_nb", (request.getParameter("name_prefix_male_nb") == null ? "" : request.getParameter("name_prefix_male_nb")));
			tabdata.put("name_prefix_female_nb", (request.getParameter("name_prefix_female_nb") == null ? "" : request.getParameter("name_prefix_female_nb")));
			tabdata.put("name_prefix_unknown_nb", (request.getParameter("name_prefix_unknown_nb") == null ? "" : request.getParameter("name_prefix_unknown_nb")));  //Added by Afruddin for ML-MMOH-CRF-1520 US 0002
			tabdata.put("name_suffix_male_nb", (request.getParameter("name_suffix_male_nb") == null ? "" : request.getParameter("name_suffix_male_nb")));
			tabdata.put("name_suffix_female_nb", (request.getParameter("name_suffix_female_nb") == null ? "" : request.getParameter("name_suffix_female_nb")));

			tabdata.put("nb_female_relnship", (request.getParameter("def_nb_female_relationship") == null ? "" : request.getParameter("def_nb_female_relationship")));
			tabdata.put("nb_male_relnship", (request.getParameter("def_nb_male_relationship") == null ? "" : request.getParameter("def_nb_male_relationship")));
			tabdata.put("nb_unknown_relnship", (request.getParameter("def_nb_unknown_relationship") == null ? "" : request.getParameter("def_nb_unknown_relationship")));

			tabdata.put("dflt_race_nat_setup", (request.getParameter("dflt_race_nat_setup") == null ? "" : request.getParameter("dflt_race_nat_setup")));
			tabdata.put("citizen_nationality_code", (request.getParameter("citizen_nationality_code") == null ? "" : request.getParameter("citizen_nationality_code")));
			tabdata.put("default_race_code", (request.getParameter("default_race_code") == null ? "" : request.getParameter("default_race_code")));

			tabdata.put("name_pfx_loc_lang_male_nb", (request.getParameter("name_pfx_loc_lang_male_nb") == null ? "" : request.getParameter("name_pfx_loc_lang_male_nb")));
			tabdata.put("name_pfx_loc_lang_female_nb", (request.getParameter("name_pfx_loc_lang_female_nb") == null ? "" : request.getParameter("name_pfx_loc_lang_female_nb")));
			tabdata.put("name_pfx_loc_lang_unknown_nb", (request.getParameter("name_pfx_loc_lang_unknown_nb") == null ? "" : request.getParameter("name_pfx_loc_lang_unknown_nb"))); //Added by Afruddin for ML-MMOH-CRF-1520 US 0002
			tabdata.put("name_sfx_loc_lang_male_nb", (request.getParameter("name_sfx_loc_lang_male_nb") == null ? "" : request.getParameter("name_sfx_loc_lang_male_nb")));
			tabdata.put("name_sfx_loc_lang_female_nb", (request.getParameter("name_sfx_loc_lang_female_nb") == null ? "" : request.getParameter("name_sfx_loc_lang_female_nb")));

			//tabdata.put("mother_rel_code", (request.getParameter("mother_rel_code") == null ? "" : request.getParameter("mother_rel_code")));
			tabdata.put("relation_child", (request.getParameter("relation_child") == null ? "" : request.getParameter("relation_child"))) ;
			tabdata.put("relation_child11", (request.getParameter("relation_child11") == null ? "" : request.getParameter("relation_child11"))) ;
			tabdata.put("exp_cat_date", (request.getParameter("exp_cat_date") == null ? "" : request.getParameter("exp_cat_date"))) ;
			tabdata.put("sltRelationship", (request.getParameter("sltRelationship") == null ? "" : request.getParameter("sltRelationship"))) ;

			String family_org_id_accept_yn_hd=request.getParameter("family_org_id_accept_yn_hd"); 
			if(family_org_id_accept_yn_hd==null)
				family_org_id_accept_yn_hd="";
			String family_org_id=request.getParameter("family_org_id") == null ? "" : request.getParameter("family_org_id") ;
			String family_org_sub_id=request.getParameter("family_org_sub_id") == null ? "" : request.getParameter("family_org_sub_id") ;
			String family_org_membership=request.getParameter("family_org_membership") == null ? "" : request.getParameter("family_org_membership") ;
			String alt_id1_no=request.getParameter("alt_id1_no") == null ? "" : request.getParameter("alt_id1_no") ;

			if(family_org_id_accept_yn_hd.equals("N")){
				family_org_id="";
				family_org_membership="";
				family_org_sub_id="";
				
			}
			tabdata.put("family_org_id",family_org_id);
			tabdata.put("family_org_membership",family_org_membership);
			tabdata.put("alt_id1_no",alt_id1_no);
			tabdata.put("family_org_sub_id",family_org_sub_id);
			tabdata.put("family_org_id_accept_yn_hd",family_org_id_accept_yn_hd);
			String family_no_link_yn_hd=request.getParameter("family_no_link_yn_hd"); 
			if(family_no_link_yn_hd==null)
				family_no_link_yn_hd="";
			String HeadPatientid=request.getParameter("HeadPatientid") == null ? "" : request.getParameter("HeadPatientid") ;
			if(family_no_link_yn_hd.equals("N")){
				HeadPatientid="";
			}
			tabdata.put("HeadPatientid",HeadPatientid); 
			//tabdata.put("family_org_id_accept_yn_hd",family_org_id_accept_yn_hd); 
			tabdata.put("family_no_link_yn_hd",family_no_link_yn_hd);
			String mother_patient_id = "";
			
			String called_from = "";
			called_from = request.getParameter("called_function")==null?"":request.getParameter("called_function");	
			//Added by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start
			String emer_regn_nb_yn	= "N";
	
			if("AE".equals(called_from)){
				emer_regn_nb_yn	= "Y";
			}
			tabdata.put("emer_regn_nb_yn",emer_regn_nb_yn);	
			//Added by Dharma on Aug 14th 2017 against ML-MMOH-CRF-0631 [IN:062148] End
		
			String mother_bed_no = "";
			mother_encounter_id = request.getParameter("mother_encounter_id") == null ? "" : request.getParameter("mother_encounter_id");
			tabdata.put("patient_id", (request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id")));
			tabdata.put("pat_ser_grp_code", (request.getParameter("pat_ser_grp_code") == null ? "" : request.getParameter("pat_ser_grp_code"))) ;
			tabdata.put("mother_patient_id", (request.getParameter("mother_patient_id") == null ? "" : request.getParameter("mother_patient_id"))) ;
			tabdata.put("mother_encounter_id", (request.getParameter("mother_encounter_id") == null ? "" : request.getParameter("mother_encounter_id"))) ;
			tabdata.put("nb_sex", (request.getParameter("new_born_sex") == null ? "" : request.getParameter("new_born_sex"))) ;
			tabdata.put("bbayn", (request.getParameter("born_where") == null ? "" : request.getParameter("born_where"))) ;
			tabdata.put("born_at", (request.getParameter("born_at") == null ? "" : request.getParameter("born_at"))) ;			
			tabdata.put("outcome", (request.getParameter("outcome") == null ? "" : request.getParameter("outcome"))) ;
			newBornOutCome=request.getParameter("outcome") == null ? "" : request.getParameter("outcome");
			tabdata.put("indicator_mark", (request.getParameter("indicator_mark") == null ? "" : request.getParameter("indicator_mark"))) ;
			tabdata.put("maintain_doc_or_file", (request.getParameter("maintain_doc_or_file") == null ? "F" : request.getParameter("maintain_doc_or_file"))) ;			
			//tabdata.put("ip_install_yn", (request.getParameter("ip_install_yn")==null?"":request.getParameter("ip_install_yn"))) ;
			tabdata.put("mother_nursing_unit_code", (request.getParameter("mother_nursing_unit_code")==null?"":request.getParameter("mother_nursing_unit_code")));
			tabdata.put("mother_bed_no", (request.getParameter("mother_bed_no") == null ? "" : request.getParameter("mother_bed_no")));
			tabdata.put("bed_number", (request.getParameter("bed_number")==null?"":request.getParameter("bed_number"))) ;
			
			tabdata.put("called_function", (request.getParameter("called_function") == null ? "" : request.getParameter("called_function")));
		
			String dateofbirth	= request.getParameter("date_of_birth") == null ? "" : request.getParameter("date_of_birth");
			if(!dateofbirth.equals("")){
				if(!locale.equals("en")){ 	
					dateofbirth= DateUtils.convertDate(dateofbirth,"DMYHM",locale,"en");
				}
			}
			String timeofbirth	= request.getParameter("time_of_birth") == null ? "" : request.getParameter("time_of_birth");
			String datetimeofbirth	= dateofbirth+" "+timeofbirth;			
			tabdata.put("date_of_birth", dateofbirth) ;
			tabdata.put("time_of_birth", datetimeofbirth) ;
			tabdata.put("weight", (request.getParameter("weight") == null ? "" : request.getParameter("weight"))) ;
			tabdata.put("weight_unit", (request.getParameter("weight_unit") == null ? "" : request.getParameter("weight_unit")));
			tabdata.put("circumference", (request.getParameter("circumference") == null ? "" : request.getParameter("circumference"))) ;
			tabdata.put("circumference_unit", (request.getParameter("circumference_unit") == null ? "" : request.getParameter("circumference_unit")));
			tabdata.put("chest_circumference_unit", (request.getParameter("chest_circumference_unit") == null ? "" : request.getParameter("chest_circumference_unit"))) ;
			tabdata.put("length", (request.getParameter("length1") == null ? "" : request.getParameter("length1")));
			tabdata.put("no_marital_status", (request.getParameter("no_marital_status") == null ? "N" : request.getParameter("no_marital_status")));//Added by Kamatchi S for ML-MMOH-CRF-2097
			tabdata.put("length_unit", (request.getParameter("length_unit") == null ? "" : request.getParameter("length_unit")));
			tabdata.put("gestational_period", (request.getParameter("gestational_period") == null ? "" : request.getParameter("gestational_period")));
			tabdata.put("gestational_period_days", (request.getParameter("gestational_period_days") == null ? "" : request.getParameter("gestational_period_days")));
			tabdata.put("gestational_unit", (request.getParameter("gestational_unit") == null ? "" : request.getParameter("gestational_unit")));
			tabdata.put("apgar_score", (request.getParameter("apgar_score") == null ? "" : request.getParameter("apgar_score")));
			tabdata.put("umbilical_cord_status", (request.getParameter("umbilical_cord_status") == null ? "" : request.getParameter("umbilical_cord_status")));
			tabdata.put("born_at_locn_type", (request.getParameter("born_at_locn_type")==null?"":request.getParameter("born_at_locn_type"))) ;
			tabdata.put("born_at_locn_code", (request.getParameter("born_at_locn_code")==null?"":request.getParameter("born_at_locn_code"))) ;

			String patency_chk = request.getParameter("patency_of_anus_yn")==null?"":request.getParameter("patency_of_anus_yn"); 	

			String patency_of_anus_checked_by_id = request.getParameter("pract_id_search_patency_hidden")==null?"":request.getParameter("pract_id_search_patency_hidden"); //Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382
			String prev_patency_prac_hidden = request.getParameter("prev_patency_prac_hidden")==null?"":request.getParameter("prev_patency_prac_hidden"); //Added by Rameswar on 17-Feb-16 for ML-MMOH-CRF-0383


			if(patency_chk.equals("")) { 
				patency_chk = ""; 
			}
			tabdata.put("patency_of_anus_yn", patency_chk);
			
			tabdata.put("patency_of_anus_checked_by_id", patency_of_anus_checked_by_id);//Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382

			tabdata.put("sel_accession_num", sel_accession_num);//Added by Ashwini on 24-oct-2016 for MO-CRF-20108
			
			tabdata.put("prev_patency_prac_hidden", prev_patency_prac_hidden);//Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0383

			tabdata.put("multiple_birth_yn", (request.getParameter("multiple_birth_yn") == null ? "N" : request.getParameter("multiple_birth_yn"))) ;
			tabdata.put("no_of_birth", (request.getParameter("noOfBirths")==null?"":request.getParameter("noOfBirths"))) ;
			tabdata.put("name_suffix", (request.getParameter("name_suffix")==null?"":request.getParameter("name_suffix"))) ;

			String nod_type = request.getParameter("nod_type")== null?"":request.getParameter("nod_type");

			if(!nod_type.equals("")) {					
				StringTokenizer nodToken = new StringTokenizer(nod_type,"$"); 
				if(nodToken.hasMoreTokens()) {
					nod_type = 	nodToken.nextToken();
				}
			}

			tabdata.put("nod_type", nod_type) ;
			tabdata.put("gravida", (request.getParameter("gravida")==null?"":request.getParameter("gravida"))) ;
			tabdata.put("parity", (request.getParameter("parity")==null?"":request.getParameter("parity"))) ;
			tabdata.put("parity1", (request.getParameter("parity1")==null?"":request.getParameter("parity1"))) ; //tttttt
			tabdata.put("feeding", (request.getParameter("feeding")==null?"":request.getParameter("feeding"))) ;
			tabdata.put("stools", (request.getParameter("stools")==null?"":request.getParameter("stools"))) ;
			tabdata.put("complications", (request.getParameter("complications")==null?"":request.getParameter("complications"))) ;
			tabdata.put("attend_physician_id", (request.getParameter("attend_physician_id")==null?"":request.getParameter("attend_physician_id"))) ;
			tabdata.put("attend_midwife_id", (request.getParameter("attend_midwife_id")==null?"":request.getParameter("attend_midwife_id"))) ;

			String father_patient_id= request.getParameter("father_patient_id")==null?"":request.getParameter("father_patient_id") ;
			mother_patient_id = 
			request.getParameter("mother_patient_id")==null?"":request.getParameter("mother_patient_id");
			tabdata.put("father_patient_id", father_patient_id ) ;
			
			String father_patient_name=(request.getParameter("father_patient_name") == null ? "" : request.getParameter("father_patient_name"));
			if(father_patient_name !=null && father_patient_name.length()>100){
				father_patient_name=father_patient_name.substring(0,100);
			}
			
			String father_patient_long_name=(request.getParameter("father_patient_long_name") == null ? "" : request.getParameter("father_patient_long_name"));
			if(father_patient_long_name !=null && father_patient_long_name.length()>300){
				father_patient_long_name=father_patient_long_name.substring(0,300);
			}

			String father_patient_long_name_loc_lang=(request.getParameter("father_patient_long_name_loc_lang") == null ? "" : request.getParameter("father_patient_long_name_loc_lang"));
			if(father_patient_long_name_loc_lang !=null && father_patient_long_name_loc_lang.length()>300){
				father_patient_long_name_loc_lang=father_patient_long_name_loc_lang.substring(0,300);
			}

			tabdata.put("father_name", father_patient_name) ;
			tabdata.put("father_pat_long_name", father_patient_long_name) ;
			tabdata.put("father_pat_long_name_loc_lang", father_patient_long_name_loc_lang) ;
			tabdata.put("fatherRemarks", (request.getParameter("fatherRemarks")==null?"":request.getParameter("fatherRemarks"))) ;
			tabdata.put("inhouse_birth_yn", (request.getParameter("inhouse_birth_yn")==null?"":request.getParameter("inhouse_birth_yn"))) ;
			tabdata.put("pat_no_gen_yn", (request.getParameter("pat_no_gen_yn")==null?"":request.getParameter("pat_no_gen_yn"))) ;
			tabdata.put("chest_circumference", (request.getParameter("chest_circumference")==null?"":request.getParameter("chest_circumference"))) ;
			tabdata.put("bcg_given_yn", (request.getParameter("bcg_given_yn")==null?"N":request.getParameter("bcg_given_yn"))) ;
			tabdata.put("vitak_given_yn", (request.getParameter("vitak_given_yn") == null ? "N" : request.getParameter("vitak_given_yn"))) ;
			tabdata.put("hep_given_yn", (request.getParameter("hep_given_yn")==null?"N":request.getParameter("hep_given_yn"))) ;
			tabdata.put("vaccination_site", (request.getParameter("txtVaccSite")==null?"":request.getParameter("txtVaccSite"))) ;
			tabdata.put("vitak_vacc_site", (request.getParameter("vitak_VaccSite")==null?"":request.getParameter("vitak_VaccSite"))) ;
			tabdata.put("hepb_vacc_site", (request.getParameter("hepb_VaccSite")==null?"":request.getParameter("hepb_VaccSite"))) ;
			tabdata.put("remarks", (request.getParameter("remarks")==null?"":request.getParameter("remarks"))) ;
			tabdata.put("apgar_score_in_5_mins", (request.getParameter("apgar_score_five_min")==null?"":request.getParameter("apgar_score_five_min"))) ;
			tabdata.put("apgar_score_in_10_mins", (request.getParameter("apgar_score_ten_min")==null?"":request.getParameter("apgar_score_ten_min"))) ;
			/*Adding for CRF-689 & 695 Starts*/
			tabdata.put("heart_rate_in_1_min", (request.getParameter("heart_rate_in_1_min")==null?"":request.getParameter("heart_rate_in_1_min"))) ;
			tabdata.put("breathing_in_1_min", (request.getParameter("breathing_in_1_min")==null?"":request.getParameter("breathing_in_1_min"))) ;
			tabdata.put("grimace_in_1_min", (request.getParameter("grimace_in_1_min")==null?"":request.getParameter("grimace_in_1_min"))) ;
			tabdata.put("activity_in_1_min", (request.getParameter("activity_in_1_min")==null?"":request.getParameter("activity_in_1_min"))) ;
			tabdata.put("appearance_in_1_min", (request.getParameter("appearance_in_1_min")==null?"":request.getParameter("appearance_in_1_min"))) ;

			tabdata.put("heart_rate_in_5_min", (request.getParameter("heart_rate_in_5_min")==null?"":request.getParameter("heart_rate_in_5_min"))) ;
			tabdata.put("breathing_in_5_min", (request.getParameter("breathing_in_5_min")==null?"":request.getParameter("breathing_in_5_min"))) ;
			tabdata.put("grimace_in_5_min", (request.getParameter("grimace_in_5_min")==null?"":request.getParameter("grimace_in_5_min"))) ;
			tabdata.put("activity_in_5_min", (request.getParameter("activity_in_5_min")==null?"":request.getParameter("activity_in_5_min"))) ;
			tabdata.put("appearance_in_5_min", (request.getParameter("appearance_in_5_min")==null?"":request.getParameter("appearance_in_5_min"))) ;

			tabdata.put("heart_rate_in_10_min", (request.getParameter("heart_rate_in_10_min")==null?"":request.getParameter("heart_rate_in_10_min"))) ;
			tabdata.put("breathing_in_10_min", (request.getParameter("breathing_in_10_min")==null?"":request.getParameter("breathing_in_10_min"))) ;
			tabdata.put("grimace_in_10_min", (request.getParameter("grimace_in_10_min")==null?"":request.getParameter("grimace_in_10_min"))) ;
			tabdata.put("activity_in_10_min", (request.getParameter("activity_in_10_min")==null?"":request.getParameter("activity_in_10_min"))) ;
			tabdata.put("appearance_in_10_min", (request.getParameter("appearance_in_10_min")==null?"":request.getParameter("appearance_in_10_min"))) ;

			tabdata.put("pract_id_still_birth", (request.getParameter("pract_id_still_birth")==null?"":request.getParameter("pract_id_still_birth"))) ;
			tabdata.put("attendant_at_birth", (request.getParameter("attendant_at_birth")==null?"":request.getParameter("attendant_at_birth"))) ;
			tabdata.put("autopsy_reqd_yn", (request.getParameter("autopsy_reqd_yn")==null?"":request.getParameter("autopsy_reqd_yn"))) ;
			tabdata.put("mate_cond_main_cod", (request.getParameter("mate_cond_main_cod")==null?"":request.getParameter("mate_cond_main_cod"))) ;
			tabdata.put("mate_cond_main_cod_dur", (request.getParameter("mate_cond_main_cod_dur")==null?"":request.getParameter("mate_cond_main_cod_dur"))) ;
			tabdata.put("mate_cond_oth_cod", (request.getParameter("mate_cond_oth_cod")==null?"":request.getParameter("mate_cond_oth_cod"))) ;
			tabdata.put("mate_cond_oth_cod_dur", (request.getParameter("mate_cond_oth_cod_dur")==null?"":request.getParameter("mate_cond_oth_cod_dur"))) ;
			tabdata.put("mate_cond_preexist_cod", (request.getParameter("mate_cond_preexist_cod")==null?"":request.getParameter("mate_cond_preexist_cod"))) ;
			tabdata.put("mate_cond_preexist_cod_dur", (request.getParameter("mate_cond_preexist_cod_dur")==null?"":request.getParameter("mate_cond_preexist_cod_dur"))) ;
			tabdata.put("oth_rel_mate_cond_rel_cod", (request.getParameter("oth_rel_mate_cond_rel_cod")==null?"":request.getParameter("oth_rel_mate_cond_rel_cod"))) ;
			tabdata.put("oth_rel_mate_cond_rel_cod_dur", (request.getParameter("oth_rel_mate_cond_rel_cod_dur")==null?"":request.getParameter("oth_rel_mate_cond_rel_cod_dur"))) ;
			tabdata.put("cond_cau_dea_main_cod", (request.getParameter("cond_cau_dea_main_cod")==null?"":request.getParameter("cond_cau_dea_main_cod"))) ;
			tabdata.put("cond_cau_dea_main_cod_dur", (request.getParameter("cond_cau_dea_main_cod_dur")==null?"":request.getParameter("cond_cau_dea_main_cod_dur"))) ;
			tabdata.put("cond_cau_dea_oth_cod", (request.getParameter("cond_cau_dea_oth_cod")==null?"":request.getParameter("cond_cau_dea_oth_cod"))) ;
			tabdata.put("cond_cau_dea_oth_cod_dur", (request.getParameter("cond_cau_dea_oth_cod_dur")==null?"":request.getParameter("cond_cau_dea_oth_cod_dur"))) ;
			tabdata.put("cond_cau_dea_preexist_cod", (request.getParameter("cond_cau_dea_preexist_cod")==null?"":request.getParameter("cond_cau_dea_preexist_cod"))) ;
			tabdata.put("cond_cau_dea_preexist_cod_dur", (request.getParameter("cond_cau_dea_preexist_cod_dur")==null?"":request.getParameter("cond_cau_dea_preexist_cod_dur"))) ;
			tabdata.put("rel_cond_cau_dea_rel_cod", (request.getParameter("rel_cond_cau_dea_rel_cod")==null?"":request.getParameter("rel_cond_cau_dea_rel_cod"))) ;
			tabdata.put("rel_cond_cau_dea_rel_cod_dur", (request.getParameter("rel_cond_cau_dea_rel_cod_dur")==null?"":request.getParameter("rel_cond_cau_dea_rel_cod_dur"))) ;
			tabdata.put("lmp_ca", (request.getParameter("lmp_ca")==null?"":request.getParameter("lmp_ca"))) ;
			tabdata.put("mc_cycle_no", (request.getParameter("mc_cycle_no")==null?"":request.getParameter("mc_cycle_no"))) ;
			tabdata.put("function_id_mg", (request.getParameter("function_id_mg")==null?"":request.getParameter("function_id_mg"))) ;
			called_from_mothercare =request.getParameter("called_from_mothercare")==null?"":request.getParameter("called_from_mothercare");
			single_stage_nb_reg_appl_yn =request.getParameter("single_stage_nb_reg_appl_yn")==null?"":request.getParameter("single_stage_nb_reg_appl_yn");
			tabdata.put("called_from_mothercare",called_from_mothercare) ;
			tabdata.put("called_from",called_from) ;
			tabdata.put("single_stage_nb_reg_appl_yn",single_stage_nb_reg_appl_yn) ;
			/*Adding for CRF-689 & 695 Ends*/
			String bWhere=(String) tabdata.get("bbayn");
			if(bWhere.equals("B")){
				tabdata.put("Umb_cord_cut_by", (request.getParameter("Umb_cord_cut_by")==null?"":request.getParameter("Umb_cord_cut_by"))) ;
			}else{
				tabdata.put("Umb_cord_cut_by", (request.getParameter("Umb_cord_cut_by_physician_id")==null?"":request.getParameter("Umb_cord_cut_by_physician_id"))) ;
			}
			String birth_place_code = "";
			String birth_place_desc			= "";
			tabdata.put("community_nurse", (request.getParameter("community_nurse")==null?"":request.getParameter("community_nurse"))) ;
			tabdata.put("complications_delivery", (request.getParameter("complications_delivery")==null?"":request.getParameter("complications_delivery"))) ;
			tabdata.put("nb_complication_delivery", (request.getParameter("complications_delivery_nb")==null?"":request.getParameter("complications_delivery_nb"))) ;
			tabdata.put("Congenital_Anomalies", (request.getParameter("Congenital_Anomalies")==null?"":request.getParameter("Congenital_Anomalies"))) ;
			tabdata.put("administeredBy", (request.getParameter("administeredBy")==null?"":request.getParameter("administeredBy"))) ;
			tabdata.put("vitak_administered_By", (request.getParameter("vitak_administeredBy")==null?"":request.getParameter("vitak_administeredBy"))) ;
			tabdata.put("hepb_administered_By", (request.getParameter("hepb_administeredBy")==null?"":request.getParameter("hepb_administeredBy"))) ;
			tabdata.put("Designation", (request.getParameter("Designation")==null?"":request.getParameter("Designation"))) ;
			tabdata.put("hepb_administered_Designation", (request.getParameter("hepb_Designation")==null?"":request.getParameter("hepb_Designation"))) ;
			tabdata.put("vitak_administered_Designation", (request.getParameter("vitak_Designation")==null?"":request.getParameter("vitak_Designation"))) ;
			tabdata.put("National_id", (request.getParameter("National_id")==null?"":request.getParameter("National_id"))) ;
			tabdata.put("cboOtherAltID", (request.getParameter("cboOtherAltID")==null?"":request.getParameter("cboOtherAltID"))) ;
			tabdata.put("txtOtherAltID", (request.getParameter("txtOtherAltID")==null?"":request.getParameter("txtOtherAltID"))) ;
			tabdata.put("cboNationality", (request.getParameter("cboNationality")==null?"":request.getParameter("cboNationality"))) ;
			tabdata.put("cboEthnicGroup", (request.getParameter("cboEthnicGroup")==null?"":request.getParameter("cboEthnicGroup"))) ;
			tabdata.put("cboReligion", (request.getParameter("cboReligion")==null?"":request.getParameter("cboReligion"))) ;
			tabdata.put("cboOccupationClass", (request.getParameter("cboOccupationClass")==null?"":request.getParameter("cboOccupationClass"))) ;
			tabdata.put("cboOccupation", (request.getParameter("cboOccupation")==null?"":request.getParameter("cboOccupation"))) ;
			tabdata.put("Occupation_Desc", (request.getParameter("Occupation_Desc")==null?"":request.getParameter("Occupation_Desc"))) ;
			tabdata.put("fatherRemarks", (request.getParameter("fatherRemarks")==null?"":request.getParameter("fatherRemarks"))) ;
			tabdata.put("fthGovtEmpl", (request.getParameter("fthGovtEmpl")==null?"N":request.getParameter("fthGovtEmpl"))) ;
			tabdata.put("Mother_Pmi_no", (request.getParameter("mother_pmi_no")==null?"":request.getParameter("mother_pmi_no"))) ;
			tabdata.put("Dely_ind_code", (request.getParameter("delivery_indication")==null?"":request.getParameter("delivery_indication"))) ;
			tabdata.put("Proc_class_Code", (request.getParameter("proc_class_code")==null?"":request.getParameter("proc_class_code"))) ;
			tabdata.put("Vaginal_dely_type_code", (request.getParameter("vaginal_del_type_code")==null?"":request.getParameter("vaginal_del_type_code"))) ;
			tabdata.put("Dely_surg_class_code", (request.getParameter("del_serv_class")==null?"":request.getParameter("del_serv_class"))) ;
			tabdata.put("birth_place_code", (request.getParameter("Birth_place_code")==null?"":request.getParameter("Birth_place_code"))) ;
			birth_place_code = request.getParameter("Birth_place_code")==null?"":request.getParameter("Birth_place_code");
			birth_place_desc = request.getParameter("Birth_place_desc")==null?"":request.getParameter("Birth_place_desc");
			tabdata.put("birth_certificate_no", (request.getParameter("birth_cert_no")==null?"":request.getParameter("birth_cert_no"))) ;
			tabdata.put("blood_group", (request.getParameter("blood_group")==null?"":request.getParameter("blood_group"))) ;
			tabdata.put("rf_code", (request.getParameter("rf_code")==null?"":request.getParameter("rf_code"))) ;
			
			/*Below line added for this CRF 0621*/
			tabdata.put("parity_on_admission", (request.getParameter("parity_on_admission")==null?"":request.getParameter("parity_on_admission"))) ;
			tabdata.put("resuscit_attend_pract_id", (request.getParameter("resuscit_attend_pract_id")==null?"":request.getParameter("resuscit_attend_pract_id"))) ;

			String gvt=(String) tabdata.get("fthGovtEmpl");

			if(!gvt.equals("N")){
				tabdata.put("fthGovtEmpl","Y") ;
			}
		 
			numberOfBirths =request.getParameter("noOfBirths");
			if(numberOfBirths == null || numberOfBirths.equals("")) numberOfBirths="0";
			noOfBirths = Integer.parseInt(numberOfBirths);
			accessRights = request.getParameter("accessRights");
			if(accessRights == null) accessRights="";
			addedById   = p.getProperty( "login_user" ) ;

			parent_details="";
			noofbirths_value=request.getParameter("noOfBirths")==null?"":request.getParameter("noOfBirths");
			if(noofbirths_value == null || noofbirths_value.equals("")) noofbirths_value="0";
			parent_details=parent_details+":"+noofbirths_value;
			String multiplebirthyn_value = "";
			String gestation_value			= "";
			String gestation_days_value			= "";
			String gravida_values			= "";
			String parity_values			= "";
			String fatherpatientid_value			= "";
			String fathername_value			= "";
			String fathernricno_value			= "";
			String fatherothaltid_value			= "";
			String fatherothaltiddesc_value			= "";
			String fathernationality_value			= "";
			String fatherrace_value			= "";
			String fathergovtemp_value			= "";
			String fatherreligion_value			= "";
			String fartheroccuclass_value			= "";
			String fatheroccu_value			= "";
			String fatheroccudesc_value			= "";
			multiplebirthyn_value=request.getParameter("multiple_birth_yn")==null?"":request.getParameter("multiple_birth_yn");
			if(multiplebirthyn_value == null || multiplebirthyn_value.equals("")) multiplebirthyn_value="N";
			parent_details=parent_details+":"+multiplebirthyn_value;
			gestation_value=request.getParameter("gestational_period")==null?"":request.getParameter("gestational_period");

			gestation_days_value = request.getParameter("gestational_period_days")== null?"":request.getParameter("gestational_period_days");

			if(gestation_value == null || gestation_value.equals("")) gestation_value="0";
			parent_details=parent_details+":"+gestation_value;

			if(gestation_days_value == null || gestation_days_value.equals("")) gestation_days_value="0";
			parent_details=parent_details+":"+gestation_days_value;

			gravida_values=request.getParameter("gravida")==null?"":request.getParameter("gravida");
			if(gravida_values == null || gravida_values.equals("")) gravida_values="0";
			parent_details=parent_details+":"+gravida_values;
			parity_values=request.getParameter("parity")==null?"":request.getParameter("parity");
			if(parity_values == null || parity_values.equals("")) parity_values="0";
			parent_details=parent_details+":"+parity_values;
			fatherpatientid_value=request.getParameter("father_patient_id")==null?"":request.getParameter("father_patient_id");
			if(fatherpatientid_value == null || fatherpatientid_value.equals("")) 
			fatherpatientid_value="0";
			parent_details=parent_details+":"+fatherpatientid_value;
			fathername_value=father_patient_name;
			if(fathername_value == null || fathername_value.equals("")) fathername_value="0";
			parent_details=parent_details+":"+fathername_value;
			fathernricno_value=request.getParameter("National_id")==null?"":request.getParameter("faNational_id");
			if(fathernricno_value == null || fathernricno_value.equals("")) fathernricno_value="0";
			parent_details=parent_details+":"+fathernricno_value;
			fatherothaltid_value=request.getParameter("cboOtherAltID")==null?"":request.getParameter("cboOtherAltID");
			if(fatherothaltid_value == null || fatherothaltid_value.equals("")) 
			fatherothaltid_value="0";
			parent_details=parent_details+":"+fatherothaltid_value;
			fatherothaltiddesc_value=request.getParameter("txtOtherAltID")==null?"":request.getParameter("txtOtherAltID");
			if(fatherothaltiddesc_value == null || fatherothaltiddesc_value.equals("")) 
			fatherothaltiddesc_value="0";
			parent_details=parent_details+":"+fatherothaltiddesc_value;
			fathernationality_value=request.getParameter("cboNationality")==null?"":request.getParameter("cboNationality");
			if(fathernationality_value == null || fathernationality_value.equals("")) 
			fathernationality_value="0";
			parent_details=parent_details+":"+fathernationality_value;
			fatherrace_value=request.getParameter("cboEthnicGroup")==null?"":request.getParameter("cboEthnicGroup");
			if(fatherrace_value == null || fatherrace_value.equals("")) fatherrace_value="0";
			parent_details=parent_details+":"+fatherrace_value;
			fathergovtemp_value=request.getParameter("fthGovtEmpl")==null?"":request.getParameter("fthGovtEmpl");
			if(fathergovtemp_value == null || fathergovtemp_value.equals("")) fathergovtemp_value="N";
			parent_details=parent_details+":"+fathergovtemp_value;
			fatherreligion_value=request.getParameter("cboReligion")==null?"":request.getParameter("cboReligion");
			if(fatherreligion_value == null || fatherreligion_value.equals("")) fatherreligion_value="0";
			parent_details=parent_details+":"+fatherreligion_value;
			fartheroccuclass_value=request.getParameter("cboOccupationClass")==null?"":request.getParameter("cboOccupationClass");
			if(fartheroccuclass_value == null || fartheroccuclass_value.equals("")) fartheroccuclass_value="0";
			parent_details=parent_details+":"+fartheroccuclass_value;
			fatheroccu_value=request.getParameter("cboOccupation")==null?"":request.getParameter("cbcboOccupation");
			if(fatheroccu_value == null || fatheroccu_value.equals("")) fatheroccu_value="0";
			parent_details=parent_details+":"+fatheroccu_value;
			fatheroccudesc_value=request.getParameter("Occupation_Desc")==null?"":request.getParameter("Occupation_Desc");
			if(fatheroccudesc_value == null || fatheroccudesc_value.equals("")) fatheroccudesc_value="0";
			parent_details=parent_details+":"+fatheroccudesc_value;
			tabdata.put("added_by_id",addedById) ;
			tabdata.put("added_at_ws_no",client_ip_address) ;
			tabdata.put("added_facility_id",facilityId) ;
			tabdata.put("facilityId",facilityId) ;
			tabdata.put("name_dervn_logic",name_dervn_logic) ;
			tabdata.put("name_dervn_logic_oth_lang",name_dervn_logic_oth_lang) ;
			tabdata.put("pat_name_as_multipart_yn",pat_name_as_multipart_yn) ;

			String generate_file = request.getParameter("generate_file") ; if(generate_file == null)generate_file= "";

			tabdata.put("sStyle",sStyle) ;
			tabdata.put("generate_file",generate_file) ;
			tabdata.put("bl_install_yn",bl_install_yn);
			tabdata.put("dflt_nb_regn_blng_class",dflt_nb_regn_blng_class);
			//added code for PMG2014-HSA-CRF-0001 [IN:050020]
			tabdata.put("father_alt_id1_no", (request.getParameter("father_alt_id1_no")==null?"":request.getParameter("father_alt_id1_no")));
			tabdata.put("father_alt_id2_no", (request.getParameter("father_alt_id2_no")==null?"":request.getParameter("father_alt_id2_no")));
			tabdata.put("father_alt_id3_no", (request.getParameter("father_alt_id3_no")==null?"":request.getParameter("father_alt_id3_no")));
			tabdata.put("father_alt_id4_no", (request.getParameter("father_alt_id4_no")==null?"":request.getParameter("father_alt_id4_no")));
			tabdata.put("father_alt_id1_desc", (request.getParameter("father_alt_id1_desc")==null?"":request.getParameter("father_alt_id1_desc")));
			tabdata.put("father_alt_id2_desc", (request.getParameter("father_alt_id2_desc")==null?"":request.getParameter("father_alt_id2_desc")));
			tabdata.put("father_alt_id3_desc", (request.getParameter("father_alt_id3_desc")==null?"":request.getParameter("father_alt_id3_desc")));
			tabdata.put("father_alt_id4_desc", (request.getParameter("father_alt_id4_desc")==null?"":request.getParameter("father_alt_id4_desc")));

			String pd_father_alt_id1_desc = request.getParameter("father_alt_id1_desc")==null?"":request.getParameter("father_alt_id1_desc");	
			parent_details=parent_details+":"+pd_father_alt_id1_desc;
		
			String pd_father_alt_id1_no = request.getParameter("father_alt_id1_no")==null?"":request.getParameter("father_alt_id1_no");	
			parent_details=parent_details+":"+pd_father_alt_id1_no;	

			tabdata.put("antenatal_care", (request.getParameter("antenatal_care") == null ? "N" : request.getParameter("antenatal_care")));
			//Newly added for NewBornRegistration when coming From IP
			tabdata.put("ate_born_where", (request.getParameter("ate_born_where") == null ? "" : request.getParameter("ate_born_where")));
			tabdata.put("ate_born_at_locn_type", (request.getParameter("ate_born_at_locn_type") == null ? "" : request.getParameter("ate_born_at_locn_type")));
			tabdata.put("ate_born_at_locn_code", (request.getParameter("ate_born_at_locn_code") == null ? "" : request.getParameter("ate_born_at_locn_code")));
			tabdata.put("function_name_nb",request.getParameter("function_name_nb")) ;	

			tabdata.put("nb_name_prefix", (request.getParameter("nb_name_prefix") == null ? "" : request.getParameter("nb_name_prefix")));
			tabdata.put("nb_first_name", (request.getParameter("nb_first_name") == null ? "" : request.getParameter("nb_first_name")));
			tabdata.put("nb_second_name", (request.getParameter("nb_second_name") == null ? "" : request.getParameter("nb_second_name")));
			tabdata.put("nb_third_name", (request.getParameter("nb_third_name") == null ? "" : request.getParameter("nb_third_name")));
			tabdata.put("nb_family_name_prefix", (request.getParameter("nb_family_name_prefix") == null ? "" : request.getParameter("nb_family_name_prefix")));
			tabdata.put("nb_family_name", (request.getParameter("nb_family_name") == null ? "" : request.getParameter("nb_family_name")));
			tabdata.put("nb_name_suffix", (request.getParameter("nb_name_suffix") == null ? "" : request.getParameter("nb_name_suffix")));
			
			//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
			tabdata.put("nb_derv_logic_appl", (request.getParameter("nb_derv_logic_appl") == null ? "N" : request.getParameter("nb_derv_logic_appl")));
			
			String nb_patient_name=(request.getParameter("nb_patient_name") == null ? "" : request.getParameter("nb_patient_name"));
			if(nb_patient_name !=null && nb_patient_name.length()>100){
				nb_patient_name=nb_patient_name.substring(0,100);
			}
			
			String nb_patient_name_loc_lang_long=(request.getParameter("nb_patient_name_loc_lang_long") == null ? "" : request.getParameter("nb_patient_name_loc_lang_long"));
			if(nb_patient_name_loc_lang_long !=null && nb_patient_name_loc_lang_long.length()>300){
				nb_patient_name_loc_lang_long=nb_patient_name_loc_lang_long.substring(0,300);
			}
			
			String nb_patient_name_long =(request.getParameter("nb_patient_name_long") == null ? "" : request.getParameter("nb_patient_name_long"));
			if(nb_patient_name_long !=null && nb_patient_name_long .length()>300){
				nb_patient_name_long =nb_patient_name_long.substring(0,300);
			}

			tabdata.put("nb_patient_name", nb_patient_name);
			tabdata.put("nb_patient_long_name_loc_lang", nb_patient_name_loc_lang_long);
			tabdata.put("nb_patient_long_name",nb_patient_name_long);
			tabdata.put("nb_name_prefix_loc_lang", (request.getParameter("nb_name_prefix_loc_lang") == null ? "" : request.getParameter("nb_name_prefix_loc_lang")));
			tabdata.put("nb_first_name_loc_lang", (request.getParameter("nb_first_name_loc_lang") == null ? "" : request.getParameter("nb_first_name_loc_lang")));
			tabdata.put("nb_second_name_loc_lang", (request.getParameter("nb_second_name_loc_lang") == null ? "" : request.getParameter("nb_second_name_loc_lang")));
			tabdata.put("nb_third_name_loc_lang", (request.getParameter("nb_third_name_loc_lang") == null ? "" : request.getParameter("nb_third_name_loc_lang")));
			tabdata.put("nb_family_name_loc_lang", (request.getParameter("nb_family_name_loc_lang") == null ? "" : request.getParameter("nb_family_name_loc_lang")));
			tabdata.put("nb_name_suffix_loc_lang", (request.getParameter("nb_name_suffix_loc_lang") == null ? "" : request.getParameter("nb_name_suffix_loc_lang")));
			
			String nb_patient_name_loc_lang=(request.getParameter("nb_patient_name_loc_lang") == null ? "" : request.getParameter("nb_patient_name_loc_lang"));
			if(nb_patient_name_loc_lang !=null && nb_patient_name_loc_lang.length()>100){
				nb_patient_name_loc_lang=nb_patient_name_loc_lang.substring(0,100);
			}
			
			tabdata.put("nb_patient_name_loc_lang", nb_patient_name_loc_lang);
			tabdata.put("father_name_prefix", (request.getParameter("father_name_prefix") == null ? "" : request.getParameter("father_name_prefix")));
			tabdata.put("father_first_name", (request.getParameter("father_first_name") == null ? "" : request.getParameter("father_first_name")));
			tabdata.put("father_second_name", (request.getParameter("father_second_name") == null ? "" : request.getParameter("father_second_name")));
			tabdata.put("father_third_name", (request.getParameter("father_third_name") == null ? "" : request.getParameter("father_third_name")));
			tabdata.put("father_family_name_prefix", (request.getParameter("father_family_name_prefix") == null ? "" : request.getParameter("father_family_name_prefix")));
			tabdata.put("father_family_name", (request.getParameter("father_family_name") == null ? "" : request.getParameter("father_family_name")));
			tabdata.put("father_name_suffix", (request.getParameter("father_name_suffix") == null ? "" : request.getParameter("father_name_suffix")));
			
			
			
			tabdata.put("father_patient_name",father_patient_name);
			tabdata.put("father_name_prefix_loc_lang", (request.getParameter("father_name_prefix_loc_lang") == null ? "" : request.getParameter("father_name_prefix_loc_lang")));
			tabdata.put("father_first_name_loc_lang", (request.getParameter("father_first_name_loc_lang") == null ? "" : request.getParameter("father_first_name_loc_lang")));
			tabdata.put("father_second_name_loc_lang", (request.getParameter("father_second_name_loc_lang") == null ? "" : request.getParameter("father_second_name_loc_lang")));
			tabdata.put("father_third_name_loc_lang", (request.getParameter("father_third_name_loc_lang") == null ? "" : request.getParameter("father_third_name_loc_lang")));
			tabdata.put("father_family_name_loc_lang", (request.getParameter("father_family_name_loc_lang") == null ? "" : request.getParameter("father_family_name_loc_lang")));
			tabdata.put("father_name_suffix_loc_lang", (request.getParameter("father_name_suffix_loc_lang") == null ? "" : request.getParameter("father_name_suffix_loc_lang")));
			
			String father_patient_name_loc_lang=(request.getParameter("father_patient_name_loc_lang") == null ? "" : request.getParameter("father_patient_name_loc_lang"));
			if(father_patient_name_loc_lang !=null && father_patient_name_loc_lang.length()>100){
				father_patient_name_loc_lang=father_patient_name_loc_lang.substring(0,100);
			}
			
			tabdata.put("father_patient_name_loc_lang", father_patient_name_loc_lang);	

			tabdata.put("finalized_yn", (request.getParameter("finalized_yn") == null ? "N" : request.getParameter("finalized_yn")));
			finalized_yn=request.getParameter("finalized_yn") == null ? "N" : request.getParameter("finalized_yn");
			tabdata.put("complns_1st_stage_labour_code", (request.getParameter("complns_1st_stage_labour_code") == null ? "" : request.getParameter("complns_1st_stage_labour_code")));			
			tabdata.put("complns_2nd_stage_labour_code", (request.getParameter("complns_2nd_stage_labour_code") == null ? "" : request.getParameter("complns_2nd_stage_labour_code")));			
			tabdata.put("complns_3rd_stage_labour_code", (request.getParameter("complns_3rd_stage_labour_code") == null ? "" : request.getParameter("complns_3rd_stage_labour_code")));			
			tabdata.put("compln_pregnancy_code", (request.getParameter("compln_pregnancy_code") == null ? "" : request.getParameter("compln_pregnancy_code")));
			tabdata.put("compln_nr_pregnancy_code", (request.getParameter("compln_nr_pregnancy_code") == null ? "" : request.getParameter("compln_nr_pregnancy_code")));


			tabdata.put("date_of_birth_hj", (request.getParameter("date_of_birth_hj") == null ? "" : request.getParameter("date_of_birth_hj")));//Added MMS-QH-CRF-0145.1 [IN:047497]
			//end of addition
			
			
			//Added for this CRF MMS-ME-CRF-0006
			tabdata.put("multiple_birth_patname", (request.getParameter("multiple_birth_patname") == null ? "" : request.getParameter("multiple_birth_patname")));
			tabdata.put("nameprefix", (request.getParameter("nameprefix") == null ? "" : request.getParameter("nameprefix")));
			tabdata.put("firstNamederieved", (request.getParameter("firstNamederieved") == null ? "" : request.getParameter("firstNamederieved"))); 
			tabdata.put("familyderievedName", (request.getParameter("familyderievedName") == null ? "" : request.getParameter("familyderievedName")));
			//End this CRF MMS-ME-CRF-0006
			

			String pd_antenatal_care = request.getParameter("antenatal_care")==null?"":request.getParameter("antenatal_care");	
			parent_details=parent_details+":"+pd_antenatal_care;


			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/NewbornRegistration", NewbornRegistrationHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertNewbornRegistration",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String function_id = (request.getParameter("function_id")==null?"":request.getParameter("function_id"));

			String patientid = (String) results.get("patient");
			if(patientid==null)patientid="";

			String mother_id = (String) results.get("mother_id");
			if(mother_id==null)mother_id="";

			mother_nursing_unit = (String) results.get("mother_nursing_unit");
			if(mother_nursing_unit==null)mother_nursing_unit="";

			mother_bed_no = (String) results.get("mother_bed_no");
			if(mother_bed_no==null)mother_bed_no="";

			String birthorder = (String) results.get("birthorder");
			if(birthorder==null)birthorder="";

			numOfbaby = ((Integer) results.get("numOfbaby")).intValue();
			tempflag = ((Integer) results.get("tempflag")).intValue();

			String multiple_birth_yn = request.getParameter("multiple_birth_yn");
			if (multiple_birth_yn == null) multiple_birth_yn = "N";

			MRNResults = new HashMap();
			MRNResults = results;
			MRN_function_id = function_id;
			MRN_multiple_birth_yn = multiple_birth_yn;
			
			
		if(inserted){
			
			
			
			String function_invoked = request.getParameter("function_invoked")==null?"":request.getParameter("function_invoked");
			if(function_invoked.equals("")){
				function_invoked = function_id;
			}
			bl_success_msg = (String)results.get("bl_success_msg"); 
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale,"RECORD_INSERTED", "SM") ;					
			String         msg1=(String)mesg.get("message");
			out.println("alert('"+bl_success_msg+"\\n"+msg1+"');");		
			mesg.clear();
			
			if(generate_file.equals("Y")){
				if(results.get("MRNPrompt") != null){
					out.println(results.get("MRNPrompt")) ;
				}else{ 
					String pat_ser_grp_code = request.getParameter("pat_ser_grp_code")==null?"":request.getParameter("pat_ser_grp_code");
					doOnlineReports(request, patientid, pat_ser_grp_code,function_id_mg);
					callChangePatDetails(request, results, inserted, function_id, multiple_birth_yn, patientid,birth_place_code,birth_place_desc,called_from_mothercare,mother_id, nbUseMotherSer, patIidLength, nbPatSerGrp, invkAdmFrmNBYn, ipInstallYn, siteId,called_from,mother_bed_no,mother_encounter_id);//Rameez for SKR-SCF-0668 [IN:035813] on 22-Nov-12 -added 'mother_encounter_id' param
					
				}
			}else{ 
				String pat_ser_grp_code = request.getParameter("pat_ser_grp_code")==null?"":request.getParameter("pat_ser_grp_code");
				doOnlineReports(request, patientid, pat_ser_grp_code,function_id_mg);
				callChangePatDetails(request, results, inserted, function_id, multiple_birth_yn, patientid,birth_place_code,birth_place_desc,called_from_mothercare,mother_id, nbUseMotherSer, patIidLength, nbPatSerGrp, invkAdmFrmNBYn, ipInstallYn, siteId,called_from,mother_bed_no,mother_encounter_id);//Rameez for SKR-SCF-0668 [IN:035813]on 22-Nov-12 -added 'mother_encounter_id' param
			}
		}else{ 
			
			callChangePatDetails(request, results, inserted, function_id, multiple_birth_yn, patientid,birth_place_code,birth_place_desc,called_from_mothercare,mother_id, nbUseMotherSer, patIidLength, nbPatSerGrp, invkAdmFrmNBYn, ipInstallYn, siteId,called_from,mother_bed_no,mother_encounter_id);//Rameez for SKR-SCF-0668 [IN:035813]on 22-Nov-12 -added 'mother_encounter_id' param
		}
		results.clear();
	//}//Validate 		bcg_datetime	 vitk_datetime	   hepb_datetime
		tabdata.clear();
	}catch(Exception e){
		e.printStackTrace(System.out);
		//out.println("Error In Servlet:"+e.toString());
	}
}

private synchronized void updateNewbornRegistration(HttpServletRequest request, HttpServletResponse res){
	try{
		res.setContentType("text/html");
		 
		String locale = p.getProperty("LOCALE");
		String error1 = ""; 
		String numberOfBirths			= "";
		String called_from_mothercare = "";	
		HashMap tabdata = new HashMap() ;
		String bcg_datetime		= request.getParameter("bcg_datetime") == null ? "" : request.getParameter("bcg_datetime");
		String multiple_birth_yn = request.getParameter("multiple_birth_yn")==null?"N":request.getParameter("multiple_birth_yn");
		String function_id = (request.getParameter("function_id")==null?"":request.getParameter("function_id"));
		String function_id_mg = (request.getParameter("function_id_mg")==null?"":request.getParameter("function_id_mg"));
		String accession_num_nb_note = (request.getParameter("accession_num_nb_note")==null?"":request.getParameter("accession_num_nb_note"));
		called_from_mothercare =request.getParameter("called_from_mothercare")==null?"":request.getParameter("called_from_mothercare");
		if (!function_id_mg.equals("NEWBORN_REG")){
			function_id_mg ="MP_MAIN_NB_REG";
		}
		if(!bcg_datetime.equals("")){
			if(!locale.equals("en")){ 	
				bcg_datetime= DateUtils.convertDate(bcg_datetime,"DMYHM",locale,"en");
			}
		}
		String vitk_datetime	= request.getParameter("vitk_datetime") == null ? "" : request.getParameter("vitk_datetime");
		if(!vitk_datetime.equals("")){
			if(!locale.equals("en")){ 	
				vitk_datetime= DateUtils.convertDate(vitk_datetime,"DMYHM",locale,"en");
			}
		}
		String hepb_datetime     = request.getParameter("hepb_datetime")==null?"":request.getParameter("hepb_datetime");
		if(!hepb_datetime.equals("")){
			if(!locale.equals("en")){ 	
				hepb_datetime= DateUtils.convertDate(hepb_datetime,"DMYHM",locale,"en");
			}
		}


		
		/*
		boolean flag = false;
		float val = 0.0f;
		String Diffsql = "";
		String sysDateTime = "";
		Statement stmtDt = null;
		ResultSet rs = null;
		if (!bcg_datetime.equals("")){
			stmtDt = con.createStatement();
			Diffsql = "SELECT (TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi'))-TO_DATE ('"+bcg_datetime+"','dd/mm/yyyy hh24:mi') FROM DUAL"	;
			rs =  stmtDt.executeQuery(Diffsql);
			if (rs.next()){
				sysDateTime = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(stmtDt!=null) stmtDt.close();
			val = new Float(sysDateTime).floatValue();
			if ( val < 0.0 ){
				flag = true;
			}
		}
		if (!vitk_datetime.equals("")){			
			stmtDt = con.createStatement();
			Diffsql = "SELECT (TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi'))-TO_DATE ('"+vitk_datetime+"','dd/mm/yyyy hh24:mi') FROM DUAL";
			rs =  stmtDt.executeQuery(Diffsql);
			if(rs.next()){
				sysDateTime = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(stmtDt!=null) stmtDt.close();
			val = new Float(sysDateTime).floatValue();
			if ( val < 0.0 ){
				flag = true;
			}
		}
		if (!hepb_datetime.equals("")){
			stmtDt = con.createStatement();
			Diffsql = "SELECT (TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi'))-TO_DATE ('"+hepb_datetime+"','dd/mm/yyyy hh24:mi') FROM DUAL";
			rs =  stmtDt.executeQuery(Diffsql);
			if (rs.next()){
				sysDateTime = rs.getString(1);
			}
			if(rs != null) rs.close();
			if(stmtDt!=null) stmtDt.close();
			val = new Float(sysDateTime).floatValue();
			if ( val < 0.0 ){
				flag = true;
			}
		}
		if ( flag == true){
			MessageManager mm = new MessageManager();
			final java.util.Hashtable mesg = mm.getMessage(locale, "CANNOT_GREATER", "MP") ;
			String           msg1=(String)mesg.get("message");
			String disp="<script> var str ='"+msg1+"';str = str.replace('#', 'Adm Date');str = str.replace('$', 'System Date'); alert(str);</script>";
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?home_required_yn=Y&err_num=" +java.net.URLEncoder.encode( disp , "UTF-8")+ "\"</script>");
		}else{
		*/

			//Newly added for Organization

			String nbUseMotherSer = request.getParameter("nb_use_mother_ser") == null ? "" : request.getParameter("nb_use_mother_ser");
			String patIidLength = request.getParameter("maxLength") == null ? "" : request.getParameter("maxLength");
			String nbPatSerGrp = request.getParameter("newborn_pat_ser_grp") == null ? "" : request.getParameter("newborn_pat_ser_grp");
			String invkAdmFrmNBYn = request.getParameter("invoke_adm_from_newborn_yn") == null ? "" : request.getParameter("invoke_adm_from_newborn_yn");
			String ipInstallYn = request.getParameter("ip_install_yn") == null ? "" : request.getParameter("ip_install_yn");
			String siteId = request.getParameter("siteId") == null ? "" : request.getParameter("siteId");

			String mother_witnessed_by1			= request.getParameter("mother_witnessed_by1") == null ? "" : request.getParameter("mother_witnessed_by1");
			String mother_witnessed_by2			= request.getParameter("mother_witnessed_by2") == null ? "" : request.getParameter("mother_witnessed_by2");
			String mother_alive_yn				= request.getParameter("mother_alive_yn") == null ? "Y" : request.getParameter("mother_alive_yn");
			tabdata.put("nb_use_mother_ser", nbUseMotherSer);
			tabdata.put("maxLength", patIidLength);
			tabdata.put("newborn_pat_ser_grp", nbPatSerGrp);
			tabdata.put("invoke_adm_from_newborn_yn", invkAdmFrmNBYn);
			tabdata.put("siteId",siteId);
			tabdata.put("ip_install_yn", ipInstallYn);			


			/*
			tabdata.put("nb_use_mother_ser", (request.getParameter("nb_use_mother_ser") == null ? "" : request.getParameter("nb_use_mother_ser"))) ;
			tabdata.put("maxLength", (request.getParameter("maxLength") == null ? "" : request.getParameter("maxLength"))) ;
			tabdata.put("newborn_pat_ser_grp", (request.getParameter("newborn_pat_ser_grp") == null ? "" : request.getParameter("newborn_pat_ser_grp"))) ;
			tabdata.put("invoke_adm_from_newborn_yn", (request.getParameter("invoke_adm_from_newborn_yn") == null ? "" : request.getParameter("invoke_adm_from_newborn_yn"))) ;
			tabdata.put("siteId",(request.getParameter("siteId") == null ? "" : request.getParameter("siteId")));
			*/

			tabdata.put("family_org_id_accept_yn", (request.getParameter("family_org_id_accept_yn_hd") == null ? "" : request.getParameter("family_org_id_accept_yn_hd")));	
			tabdata.put("family_no_link_yn", (request.getParameter("family_no_link_yn_hd") == null ? "" : request.getParameter("family_no_link_yn_hd")));
			tabdata.put("no_marital_status", (request.getParameter("no_marital_status") == null ? "N" : request.getParameter("no_marital_status")));//Added by Kamatchi S for ML-MMOH-CRF-2097
			tabdata.put("nb_female_relnship", (request.getParameter("def_nb_female_relationship") == null ? "" : request.getParameter("def_nb_female_relationship")));
			tabdata.put("nb_male_relnship", (request.getParameter("def_nb_male_relationship") == null ? "" : request.getParameter("def_nb_male_relationship")));
			tabdata.put("nb_unknown_relnship", (request.getParameter("def_nb_unknown_relationship") == null ? "" : request.getParameter("def_nb_unknown_relationship")));
			
			tabdata.put("relation_child", (request.getParameter("relation_child") == null ? "" : request.getParameter("relation_child"))) ;			
			tabdata.put("relation_child11", (request.getParameter("relation_child11") == null ? "" : request.getParameter("relation_child11"))) ;
			tabdata.put("exp_cat_date", (request.getParameter("exp_cat_date") == null ? "" : request.getParameter("exp_cat_date"))) ;
			tabdata.put("sltRelationship", (request.getParameter("sltRelationship") == null ? "" : request.getParameter("sltRelationship")));
		  //end
		  String mother_patient_id		= "";		
		  String mother_bed_no		= "";
			String refreshFramesYN = request.getParameter("refreshFramesYN")==null?"N":request.getParameter("refreshFramesYN");
			tabdata.put("patient_id",(request.getParameter("patient_id")==null?"":request.getParameter("patient_id")));
            tabdata.put("pat_ser_grp_code", (request.getParameter("pat_ser_grp_code")==null?"":request.getParameter("pat_ser_grp_code"))) ;
            tabdata.put("mother_patient_id", (request.getParameter("mother_patient_id")==null?"":request.getParameter("mother_patient_id"))) ;
            tabdata.put("mother_encounter_id", (request.getParameter("mother_encounter_id")==null?"":request.getParameter("mother_encounter_id"))) ;
            tabdata.put("nb_sex", (request.getParameter("new_born_sex")==null?"":request.getParameter("new_born_sex"))) ;
            tabdata.put("bbayn", (request.getParameter("born_where")==null?"":request.getParameter("born_where"))) ;
			tabdata.put("outcome", (request.getParameter("outcome")==null?"":request.getParameter("outcome"))) ;
			newBornOutCome=request.getParameter("outcome") == null ? "" : request.getParameter("outcome");
			tabdata.put("indicator_mark", (request.getParameter("q_indicator_mark")==null?"":request.getParameter("q_indicator_mark"))) ;
			tabdata.put("bcg_datetime",bcg_datetime) ;
			tabdata.put("vitk_datetime",vitk_datetime) ;
			tabdata.put("hepb_datetime",hepb_datetime) ;
			tabdata.put("sStyle",sStyle) ;
			tabdata.put("ip_install_yn", (request.getParameter("ip_install_yn")==null?"":request.getParameter("ip_install_yn"))) ;
			tabdata.put("mother_nursing_unit_code", (request.getParameter("mother_nursing_unit_code")==null?"":request.getParameter("mother_nursing_unit_code"))) ;
			tabdata.put("mother_bed_no", (request.getParameter("mother_bed_no")==null?"":request.getParameter("mother_bed_no"))) ;
			tabdata.put("bed_number", (request.getParameter("bed_number")==null?"":request.getParameter("bed_number"))) ;
			tabdata.put("old_bed_number", (request.getParameter("old_bed_number")==null?"":request.getParameter("old_bed_number"))) ;
			
			tabdata.put("called_function", (request.getParameter("called_function")==null?"":request.getParameter("called_function"))) ;
			String dateofbirth              = request.getParameter("date_of_birth")==null?"":request.getParameter("date_of_birth");
			if(!dateofbirth.equals("")){
				if(!locale.equals("en")){ 	
					dateofbirth= DateUtils.convertDate(dateofbirth,"DMYHM",locale,"en");
				}
			}		 
			tabdata.put("time_of_birth",dateofbirth) ;
			tabdata.put("weight", (request.getParameter("weight")==null?"":request.getParameter("weight"))) ;
			tabdata.put("weight_unit", (request.getParameter("weight_unit")==null?"":request.getParameter("weight_unit"))) ;
			tabdata.put("circumference", (request.getParameter("circumference")==null?"":request.getParameter("circumference"))) ;
			tabdata.put("circumference_unit", (request.getParameter("circumference_unit")==null?"":request.getParameter("circumference_unit"))) ;
			tabdata.put("chest_circumference_unit", (request.getParameter("chest_circumference_unit")==null?"":request.getParameter("chest_circumference_unit"))) ;
			tabdata.put("length", (request.getParameter("length1")==null?"":request.getParameter("length1"))) ;
			tabdata.put("length_unit", (request.getParameter("length_unit")==null?"":request.getParameter("length_unit"))) ;
			tabdata.put("gestational_period", (request.getParameter("gestational_period")==null?"":request.getParameter("gestational_period"))) ;
			tabdata.put("gestational_period_days", (request.getParameter("gestational_period_days")==null?"":request.getParameter("gestational_period_days"))) ;
			tabdata.put("gestational_unit", (request.getParameter("gestational_unit")==null?"":request.getParameter("gestational_unit"))) ;
			tabdata.put("apgar_score", (request.getParameter("apgar_score")==null?"":request.getParameter("apgar_score"))) ;
			tabdata.put("umbilical_cord_status", (request.getParameter("umbilical_cord_status")==null?"":request.getParameter("umbilical_cord_status"))) ;
			tabdata.put("born_at_locn_type", (request.getParameter("born_at_locn_type")==null?"":request.getParameter("born_at_locn_type"))) ;
			tabdata.put("born_at_locn_code", (request.getParameter("born_at_locn_code")==null?"":request.getParameter("born_at_locn_code"))) ;

			String patency_chk = request.getParameter("patency_of_anus_yn")==null?"":request.getParameter("patency_of_anus_yn");
			
			String patency_of_anus_checked_by_id = request.getParameter("pract_id_search_patency_hidden")==null?"":request.getParameter("pract_id_search_patency_hidden"); //Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382

			String sel_accession_num = request.getParameter("sel_accession_num")==null?"":request.getParameter("sel_accession_num"); //Added by Ashwini on 03-Nov-2016 for MO-CRF-20108


			String prev_patency_prac_hidden = request.getParameter("prev_patency_prac_hidden")==null?"":request.getParameter("prev_patency_prac_hidden"); //Added by Rameswar on 17-Feb-16 for ML-MMOH-CRF-0383

			/*Below line added for this CRF ML-MMOH-CRF-0621*/
			tabdata.put("parity_on_admission", (request.getParameter("parity_on_admission")==null?"":request.getParameter("parity_on_admission"))) ;
			tabdata.put("resuscit_attend_pract_id", (request.getParameter("resuscit_attend_pract_id")==null?"":request.getParameter("resuscit_attend_pract_id"))) ;

			if(patency_chk.equals("")){patency_chk="";}
			tabdata.put("patency_of_anus_yn",patency_chk);

			tabdata.put("patency_of_anus_checked_by_id", patency_of_anus_checked_by_id);//Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0382

			tabdata.put("sel_accession_num", sel_accession_num);//Added by Ashwini on 03-Nov-2016 for MO-CRF-20108
			
			tabdata.put("prev_patency_prac_hidden", prev_patency_prac_hidden);//Added by Rameswar on 20-Jan-16 for ML-MMOH-CRF-0383

			tabdata.put("multiple_birth_yn", multiple_birth_yn) ;
			tabdata.put("no_of_birth", (request.getParameter("noOfBirths")==null?"":request.getParameter("noOfBirths"))) ;
			tabdata.put("name_suffix", (request.getParameter("name_suffix")==null?"":request.getParameter("name_suffix"))) ;  
			String nod_type = request.getParameter("nod_type")== null?"":request.getParameter("nod_type");
			if(!nod_type.equals("")) { 
				StringTokenizer nodToken = new StringTokenizer(nod_type,"$"); 
				if(nodToken.hasMoreTokens()) {
					nod_type = 	nodToken.nextToken();
				}
			}
			tabdata.put("nod_type",nod_type);
			tabdata.put("gravida", (request.getParameter("gravida")==null?"":request.getParameter("gravida"))) ;
			tabdata.put("parity", (request.getParameter("parity")==null?"":request.getParameter("parity"))) ;
			tabdata.put("feeding", (request.getParameter("feeding")==null?"":request.getParameter("feeding"))) ;
			tabdata.put("stools", (request.getParameter("stools")==null?"":request.getParameter("stools"))) ;
			tabdata.put("complications", (request.getParameter("complications")==null?"":request.getParameter("complications"))) ;
			tabdata.put("attend_physician_id", (request.getParameter("attend_physician_id")==null?"":request.getParameter("attend_physician_id"))) ;
			tabdata.put("attend_midwife_id", (request.getParameter("attend_midwife_id")==null?"":request.getParameter("attend_midwife_id"))) ;
			String father_patient_id= request.getParameter("father_patient_id")==null?"":request.getParameter("father_patient_id") ;
			mother_patient_id = request.getParameter("mother_patient_id")==null?"":request.getParameter("mother_patient_id");
			tabdata.put("father_patient_id", father_patient_id ) ;

						
			String father_patient_long_name=(request.getParameter("father_patient_long_name") == null ? "" : request.getParameter("father_patient_long_name"));
			if(father_patient_long_name !=null && father_patient_long_name.length()>300){
				father_patient_long_name=father_patient_long_name.substring(0,300);
			}

			String father_patient_long_name_loc_lang=(request.getParameter("father_patient_long_name_loc_lang") == null ? "" : request.getParameter("father_patient_long_name_loc_lang"));
			if(father_patient_long_name_loc_lang !=null && father_patient_long_name_loc_lang.length()>300){
				father_patient_long_name_loc_lang=father_patient_long_name_loc_lang.substring(0,300);
			}

			//tabdata.put("father_name", father_patient_name) ;
			tabdata.put("father_pat_long_name", father_patient_long_name) ;
			tabdata.put("father_pat_long_name_loc_lang", father_patient_long_name_loc_lang) ;

			tabdata.put("father_name", (request.getParameter("father_patient_name")==null?"":request.getParameter("father_patient_name"))) ;
			tabdata.put("remarks", (request.getParameter("remarks")==null?"":request.getParameter("remarks"))) ;
			tabdata.put("inhouse_birth_yn", (request.getParameter("inhouse_birth_yn")==null?"":request.getParameter("inhouse_birth_yn"))) ;
			tabdata.put("pat_no_gen_yn", (request.getParameter("pat_no_gen_yn")==null?"":request.getParameter("pat_no_gen_yn"))) ;
			tabdata.put("chest_circumference", (request.getParameter("chest_circumference")==null?"":request.getParameter("chest_circumference"))) ;
			tabdata.put("bcg_given_yn", (request.getParameter("bcg_given_yn")==null?"N":request.getParameter("bcg_given_yn"))) ;
			tabdata.put("vitak_given_yn", (request.getParameter("vitak_given_yn")==null?"N":request.getParameter("vitak_given_yn"))) ;
			tabdata.put("hep_given_yn", (request.getParameter("hep_given_yn")==null?"N":request.getParameter("hep_given_yn"))) ;
			tabdata.put("vaccination_site", (request.getParameter("txtVaccSite")==null?"":request.getParameter("txtVaccSite"))) ;
			tabdata.put("vitak_vacc_site", (request.getParameter("vitak_VaccSite")==null?"":request.getParameter("vitak_VaccSite"))) ;
			tabdata.put("hepb_vacc_site", (request.getParameter("hepb_VaccSite")==null?"":request.getParameter("hepb_VaccSite"))) ;

			tabdata.put("apgar_score_in_5_mins", (request.getParameter("apgar_score_five_min")==null?"":request.getParameter("apgar_score_five_min"))) ;

			tabdata.put("apgar_score_in_10_mins", (request.getParameter("apgar_score_ten_min")==null?"":request.getParameter("apgar_score_ten_min"))) ;
			/*Adding for CRF-689 & 695 Starts*/
			tabdata.put("heart_rate_in_1_min", (request.getParameter("heart_rate_in_1_min")==null?"":request.getParameter("heart_rate_in_1_min"))) ;
			tabdata.put("breathing_in_1_min", (request.getParameter("breathing_in_1_min")==null?"":request.getParameter("breathing_in_1_min"))) ;
			tabdata.put("grimace_in_1_min", (request.getParameter("grimace_in_1_min")==null?"":request.getParameter("grimace_in_1_min"))) ;
			tabdata.put("activity_in_1_min", (request.getParameter("activity_in_1_min")==null?"":request.getParameter("activity_in_1_min"))) ;
			tabdata.put("appearance_in_1_min", (request.getParameter("appearance_in_1_min")==null?"":request.getParameter("appearance_in_1_min"))) ;

			tabdata.put("heart_rate_in_5_min", (request.getParameter("heart_rate_in_5_min")==null?"":request.getParameter("heart_rate_in_5_min"))) ;
			tabdata.put("breathing_in_5_min", (request.getParameter("breathing_in_5_min")==null?"":request.getParameter("breathing_in_5_min"))) ;
			tabdata.put("grimace_in_5_min", (request.getParameter("grimace_in_5_min")==null?"":request.getParameter("grimace_in_5_min"))) ;
			tabdata.put("activity_in_5_min", (request.getParameter("activity_in_5_min")==null?"":request.getParameter("activity_in_5_min"))) ;
			tabdata.put("appearance_in_5_min", (request.getParameter("appearance_in_5_min")==null?"":request.getParameter("appearance_in_5_min"))) ;

			tabdata.put("heart_rate_in_10_min", (request.getParameter("heart_rate_in_10_min")==null?"":request.getParameter("heart_rate_in_10_min"))) ;
			tabdata.put("breathing_in_10_min", (request.getParameter("breathing_in_10_min")==null?"":request.getParameter("breathing_in_10_min"))) ;
			tabdata.put("grimace_in_10_min", (request.getParameter("grimace_in_10_min")==null?"":request.getParameter("grimace_in_10_min"))) ;
			tabdata.put("activity_in_10_min", (request.getParameter("activity_in_10_min")==null?"":request.getParameter("activity_in_10_min"))) ;
			tabdata.put("appearance_in_10_min", (request.getParameter("appearance_in_10_min")==null?"":request.getParameter("appearance_in_10_min"))) ;

			tabdata.put("pract_id_still_birth", (request.getParameter("pract_id_still_birth")==null?"":request.getParameter("pract_id_still_birth"))) ;
			tabdata.put("attendant_at_birth", (request.getParameter("attendant_at_birth")==null?"":request.getParameter("attendant_at_birth"))) ;
			tabdata.put("autopsy_reqd_yn", (request.getParameter("autopsy_reqd_yn")==null?"":request.getParameter("autopsy_reqd_yn"))) ;
			tabdata.put("mate_cond_main_cod", (request.getParameter("mate_cond_main_cod")==null?"":request.getParameter("mate_cond_main_cod"))) ;
			tabdata.put("mate_cond_main_cod_dur", (request.getParameter("mate_cond_main_cod_dur")==null?"":request.getParameter("mate_cond_main_cod_dur"))) ;
			tabdata.put("mate_cond_oth_cod", (request.getParameter("mate_cond_oth_cod")==null?"":request.getParameter("mate_cond_oth_cod"))) ;
			tabdata.put("mate_cond_oth_cod_dur", (request.getParameter("mate_cond_oth_cod_dur")==null?"":request.getParameter("mate_cond_oth_cod_dur"))) ;
			tabdata.put("mate_cond_preexist_cod", (request.getParameter("mate_cond_preexist_cod")==null?"":request.getParameter("mate_cond_preexist_cod"))) ;
			tabdata.put("mate_cond_preexist_cod_dur", (request.getParameter("mate_cond_preexist_cod_dur")==null?"":request.getParameter("mate_cond_preexist_cod_dur"))) ;
			tabdata.put("oth_rel_mate_cond_rel_cod", (request.getParameter("oth_rel_mate_cond_rel_cod")==null?"":request.getParameter("oth_rel_mate_cond_rel_cod"))) ;
			tabdata.put("oth_rel_mate_cond_rel_cod_dur", (request.getParameter("oth_rel_mate_cond_rel_cod_dur")==null?"":request.getParameter("oth_rel_mate_cond_rel_cod_dur"))) ;
			tabdata.put("cond_cau_dea_main_cod", (request.getParameter("cond_cau_dea_main_cod")==null?"":request.getParameter("cond_cau_dea_main_cod"))) ;
			tabdata.put("cond_cau_dea_main_cod_dur", (request.getParameter("cond_cau_dea_main_cod_dur")==null?"":request.getParameter("cond_cau_dea_main_cod_dur"))) ;
			tabdata.put("cond_cau_dea_oth_cod", (request.getParameter("cond_cau_dea_oth_cod")==null?"":request.getParameter("cond_cau_dea_oth_cod"))) ;
			tabdata.put("cond_cau_dea_oth_cod_dur", (request.getParameter("cond_cau_dea_oth_cod_dur")==null?"":request.getParameter("cond_cau_dea_oth_cod_dur"))) ;
			tabdata.put("cond_cau_dea_preexist_cod", (request.getParameter("cond_cau_dea_preexist_cod")==null?"":request.getParameter("cond_cau_dea_preexist_cod"))) ;
			tabdata.put("cond_cau_dea_preexist_cod_dur", (request.getParameter("cond_cau_dea_preexist_cod_dur")==null?"":request.getParameter("cond_cau_dea_preexist_cod_dur"))) ;
			tabdata.put("rel_cond_cau_dea_rel_cod", (request.getParameter("rel_cond_cau_dea_rel_cod")==null?"":request.getParameter("rel_cond_cau_dea_rel_cod"))) ;
			tabdata.put("rel_cond_cau_dea_rel_cod_dur", (request.getParameter("rel_cond_cau_dea_rel_cod_dur")==null?"":request.getParameter("rel_cond_cau_dea_rel_cod_dur"))) ;

			/*Adding for CRF-689 & 695 Ends*/


			String bWhere=(String) tabdata.get("bbayn");
			if(bWhere.equals("B")){
				tabdata.put("Umb_cord_cut_by", (request.getParameter("Umb_cord_cut_by")==null?"":request.getParameter("Umb_cord_cut_by"))) ;
			}else{
				tabdata.put("Umb_cord_cut_by", (request.getParameter("Umb_cord_cut_by_physician_id")==null?"":request.getParameter("Umb_cord_cut_by_physician_id"))) ;
			}
			
			tabdata.put("community_nurse", (request.getParameter("community_nurse")==null?"":request.getParameter("community_nurse"))) ;
			tabdata.put("complications_delivery", (request.getParameter("complications_delivery")==null?"":request.getParameter("complications_delivery"))) ;
			tabdata.put("nb_complication_delivery", (request.getParameter("complications_delivery_nb")==null?"":request.getParameter("complications_delivery_nb"))) ;
			tabdata.put("Congenital_Anomalies", (request.getParameter("Congenital_Anomalies")==null?"":request.getParameter("Congenital_Anomalies"))) ;
			tabdata.put("administeredBy", (request.getParameter("administeredBy")==null?"":request.getParameter("administeredBy"))) ;
			tabdata.put("vitak_administered_By", (request.getParameter("vitak_administeredBy")==null?"":request.getParameter("vitak_administeredBy"))) ;
			tabdata.put("hepb_administered_By", (request.getParameter("hepb_administeredBy")==null?"":request.getParameter("hepb_administeredBy"))) ;
			tabdata.put("Designation", (request.getParameter("Designation")==null?"":request.getParameter("Designation"))) ;
			tabdata.put("vitak_administered_Designation", (request.getParameter("vitak_Designation")==null?"":request.getParameter("vitak_Designation"))) ;
			tabdata.put("hepb_administered_Designation", (request.getParameter("hepb_Designation")==null?"":request.getParameter("hepb_Designation"))) ;
			tabdata.put("National_id", (request.getParameter("National_id")==null?"":request.getParameter("National_id"))) ;
			tabdata.put("cboOtherAltID", (request.getParameter("cboOtherAltID")==null?"":request.getParameter("cboOtherAltID"))) ;
			tabdata.put("txtOtherAltID", (request.getParameter("txtOtherAltID")==null?"":request.getParameter("txtOtherAltID"))) ;
			tabdata.put("cboNationality", (request.getParameter("cboNationality")==null?"":request.getParameter("cboNationality"))) ;
			tabdata.put("cboEthnicGroup", (request.getParameter("cboEthnicGroup")==null?"":request.getParameter("cboEthnicGroup"))) ;
			tabdata.put("cboReligion", (request.getParameter("cboReligion")==null?"":request.getParameter("cboReligion"))) ;
			tabdata.put("cboOccupationClass", (request.getParameter("cboOccupationClass")==null?"":request.getParameter("cboOccupationClass"))) ;
			tabdata.put("cboOccupation", (request.getParameter("cboOccupation")==null?"":request.getParameter("cboOccupation"))) ;
			tabdata.put("Occupation_Desc", (request.getParameter("Occupation_Desc")==null?"":request.getParameter("Occupation_Desc"))) ;
			tabdata.put("fatherRemarks", (request.getParameter("fatherRemarks")==null?"":request.getParameter("fatherRemarks"))) ;
			tabdata.put("fthGovtEmpl", (request.getParameter("fthGovtEmpl")==null?"N":request.getParameter("fthGovtEmpl"))) ;

			tabdata.put("antenatal_care", (request.getParameter("antenatal_care") == null ? "N" : request.getParameter("antenatal_care")));
			//Newly added for NewBornRegistration when coming From IP
			tabdata.put("ate_born_where", (request.getParameter("ate_born_where") == null ? "" : request.getParameter("ate_born_where")));
			tabdata.put("ate_born_at_locn_type", (request.getParameter("ate_born_at_locn_type") == null ? "" : request.getParameter("ate_born_at_locn_type")));
			tabdata.put("ate_born_at_locn_code", (request.getParameter("ate_born_at_locn_code") == null ? "" : request.getParameter("ate_born_at_locn_code")));


			String gvt = (String) tabdata.get("fthGovtEmpl");

			if(!gvt.equals("N")) {
				tabdata.put("fthGovtEmpl","Y") ;
			}
			tabdata.put("Mother_Pmi_no", (request.getParameter("mother_pmi_no")==null?"":request.getParameter("mother_pmi_no"))) ;
			tabdata.put("Dely_ind_code", (request.getParameter("delivery_indication")==null?"":request.getParameter("delivery_indication"))) ;
			tabdata.put("Proc_class_Code", (request.getParameter("proc_class_code")==null?"":request.getParameter("proc_class_code"))) ;
			tabdata.put("Vaginal_dely_type_code", (request.getParameter("vaginal_del_type_code")==null?"":request.getParameter("vaginal_del_type_code"))) ;
			tabdata.put("Dely_surg_class_code", (request.getParameter("del_serv_class")==null?"":request.getParameter("del_serv_class"))) ;
			String birth_place_code = "";
			String birth_place_desc			= "";
			birth_place_code = request.getParameter("Birth_place_code")==null?"":request.getParameter("Birth_place_code");

			tabdata.put("birth_place_code", birth_place_code);		

			birth_place_desc = request.getParameter("Birth_place_desc")==null?"":request.getParameter("Birth_place_desc");
			
			tabdata.put("birth_certificate_no", (request.getParameter("birth_cert_no")==null?"":request.getParameter("birth_cert_no"))) ;

			tabdata.put("blood_group", (request.getParameter("blood_group")==null?"":request.getParameter("blood_group"))) ;
			tabdata.put("rf_code", (request.getParameter("rf_code")==null?"":request.getParameter("rf_code"))) ;

			/*
            String fatherPatsql ="select patient_name,SEX from mp_patient where PATIENT_ID=?";
            PreparedStatement stmt = con.prepareStatement(fatherPatsql);
            stmt.setString(1,father_patient_id) ;
            ResultSet rset = stmt.executeQuery();
            if(!rset.next() && !father_patient_id.equals(""))
            {   MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "FATHER_PATID_INVALID", "MP") ;
				
				String         msg1=(String)mesg.get("message");
			    
                String disp="<script>alert('"+msg1+"');</script>";
              	out.println("<script>location.href =\"../eCommon/jsp/error.jsp?home_required_yn=Y&err_num=" +java.net.URLEncoder.encode( disp , "UTF-8")+ "\"</script>");
            }else{
				*/
                numberOfBirths =request.getParameter("noOfBirths");
                if(numberOfBirths == null || numberOfBirths.equals(""))  numberOfBirths="0";
                noOfBirths = Integer.parseInt(numberOfBirths);
				 
                accessRights = request.getParameter("accessRights");
                if(accessRights == null) accessRights="";

                addedById   = p.getProperty( "login_user" ) ;

                tabdata.put("added_by_id",addedById) ;
                tabdata.put("added_at_ws_no",client_ip_address) ;
                tabdata.put("added_facility_id",facilityId) ;
	            tabdata.put("facilityId",facilityId) ;
				/*Added by Dharma on 4th June 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
				tabdata.put("mother_witnessed_by1", mother_witnessed_by1);
				tabdata.put("mother_witnessed_by2", mother_witnessed_by2);
				tabdata.put("mother_alive_yn", mother_alive_yn);
				tabdata.put("accession_num_nb_note", accession_num_nb_note);
				/*Added by Dharma on 4th June 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/
	          //added code for PMG2014-HSA-CRF-0001 [IN:050020]
	                        tabdata.put("mthr_alt_id1_no", (request.getParameter("mthr_alt_id1_no") == null ? "" : request.getParameter("mthr_alt_id1_no")));
				tabdata.put("mthr_alt_id2_no", (request.getParameter("mthr_alt_id2_no") == null ? "" : request.getParameter("mthr_alt_id2_no")));
				tabdata.put("mthr_alt_id3_no", (request.getParameter("mthr_alt_id3_no") == null ? "" : request.getParameter("mthr_alt_id3_no")));
				tabdata.put("mthr_alt_id4_no", (request.getParameter("mthr_alt_id4_no") == null ? "" : request.getParameter("mthr_alt_id4_no")));
				tabdata.put("mthr_alt_id1_type", (request.getParameter("mthr_alt_id1_type") == null ? "" : request.getParameter("mthr_alt_id1_type")));
				tabdata.put("mthr_nat_id_no", (request.getParameter("mthr_nat_id_no") == null ? "" : request.getParameter("mthr_nat_id_no")));
				tabdata.put("mthr_oth_alt_id_No", (request.getParameter("mthr_oth_alt_id_No") == null ? "" : request.getParameter("mthr_oth_alt_id_No")));
				tabdata.put("oth_alt_id_type", (request.getParameter("oth_alt_id_type") == null ? "" : request.getParameter("oth_alt_id_type")));
				tabdata.put("father_alt_id1_no", (request.getParameter("father_alt_id1_no")==null?"":request.getParameter("father_alt_id1_no")));
				tabdata.put("father_alt_id2_no", (request.getParameter("father_alt_id2_no")==null?"":request.getParameter("father_alt_id2_no")));
				tabdata.put("father_alt_id3_no", (request.getParameter("father_alt_id3_no")==null?"":request.getParameter("father_alt_id3_no")));
				tabdata.put("father_alt_id4_no", (request.getParameter("father_alt_id4_no")==null?"":request.getParameter("father_alt_id4_no")));
				tabdata.put("father_alt_id1_desc", (request.getParameter("father_alt_id1_desc")==null?"":request.getParameter("father_alt_id1_desc")));
				tabdata.put("father_alt_id2_desc", (request.getParameter("father_alt_id2_desc")==null?"":request.getParameter("father_alt_id2_desc")));
				tabdata.put("father_alt_id3_desc", (request.getParameter("father_alt_id3_desc")==null?"":request.getParameter("father_alt_id3_desc")));
				tabdata.put("father_alt_id4_desc", (request.getParameter("father_alt_id4_desc")==null?"":request.getParameter("father_alt_id4_desc")));

                String generate_file = request.getParameter("generate_file") ; if(generate_file == null)generate_file= "";
                tabdata.put("generate_file",generate_file) ;
                tabdata.put("function_name_nb",request.getParameter("function_name_nb")) ;

				tabdata.put("nb_name_prefix", (request.getParameter("nb_name_prefix") == null ? "" : request.getParameter("nb_name_prefix")));
				tabdata.put("nb_first_name", (request.getParameter("nb_first_name") == null ? "" : request.getParameter("nb_first_name")));
				tabdata.put("nb_second_name", (request.getParameter("nb_second_name") == null ? "" : request.getParameter("nb_second_name")));
				tabdata.put("nb_third_name", (request.getParameter("nb_third_name") == null ? "" : request.getParameter("nb_third_name")));
				tabdata.put("nb_family_name_prefix", (request.getParameter("nb_family_name_prefix") == null ? "" : request.getParameter("nb_family_name_prefix")));
				tabdata.put("nb_family_name", (request.getParameter("nb_family_name") == null ? "" : request.getParameter("nb_family_name")));
				tabdata.put("nb_name_suffix", (request.getParameter("nb_name_suffix") == null ? "" : request.getParameter("nb_name_suffix")));

				//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
				tabdata.put("nb_derv_logic_appl", (request.getParameter("nb_derv_logic_appl") == null ? "N" : request.getParameter("nb_derv_logic_appl")));
				
				String nb_patient_name=(request.getParameter("nb_patient_name") == null ? "" : request.getParameter("nb_patient_name"));
				
				if(nb_patient_name !=null && nb_patient_name.length()>100){
					nb_patient_name=nb_patient_name.substring(0,100);
				}
				/*Below line added for this CRF MMS-ME-CRF-0006*/
				String multiple_birth_patname=(request.getParameter("multiple_birth_patname") == null ? "" : request.getParameter("multiple_birth_patname")); 
				String nameprefix=(request.getParameter("nameprefix") == null ? "" : request.getParameter("nameprefix"));
				String firstNamederieved=(request.getParameter("firstNamederieved") == null ? "" : request.getParameter("firstNamederieved"));	
                String familyderievedName=(request.getParameter("familyderievedName") == null ? "" : request.getParameter("familyderievedName"));			
				//End  MMS-ME-CRF-0006
				
				String nb_patient_name_loc_lang_long=(request.getParameter("nb_patient_name_loc_lang_long") == null ? "" : request.getParameter("nb_patient_name_loc_lang_long"));
				if(nb_patient_name_loc_lang_long !=null && nb_patient_name_loc_lang_long.length()>300){
					nb_patient_name_loc_lang_long=nb_patient_name_loc_lang_long.substring(0,300);
				}
				
				String nb_patient_name_long =(request.getParameter("nb_patient_name_long ") == null ? "" : request.getParameter("nb_patient_name_long "));
				if(nb_patient_name_long !=null && nb_patient_name_long .length()>300){
					nb_patient_name_long =nb_patient_name_long.substring(0,300);
				}
				
				//Added for this CRF MMS-ME-CRF-0006
				tabdata.put("multiple_birth_patname", multiple_birth_patname);
				tabdata.put("nameprefix", nameprefix);
				tabdata.put("firstNamederieved", firstNamederieved); 
				tabdata.put("familyderievedName", familyderievedName); 
				//End this CRF MMS-ME-CRF-0006
				
				tabdata.put("nb_patient_name", nb_patient_name);
				tabdata.put("nb_patient_long_name_loc_lang", nb_patient_name_loc_lang_long);
				tabdata.put("nb_patient_long_name",nb_patient_name_long);
				tabdata.put("nb_name_prefix_loc_lang", (request.getParameter("nb_name_prefix_loc_lang") == null ? "" : request.getParameter("nb_name_prefix_loc_lang")));
				tabdata.put("nb_first_name_loc_lang", (request.getParameter("nb_first_name_loc_lang") == null ? "" : request.getParameter("nb_first_name_loc_lang")));
				tabdata.put("nb_second_name_loc_lang", (request.getParameter("nb_second_name_loc_lang") == null ? "" : request.getParameter("nb_second_name_loc_lang")));
				tabdata.put("nb_third_name_loc_lang", (request.getParameter("nb_third_name_loc_lang") == null ? "" : request.getParameter("nb_third_name_loc_lang")));
				tabdata.put("nb_family_name_loc_lang", (request.getParameter("nb_family_name_loc_lang") == null ? "" : request.getParameter("nb_family_name_loc_lang")));
				tabdata.put("nb_name_suffix_loc_lang", (request.getParameter("nb_name_suffix_loc_lang") == null ? "" : request.getParameter("nb_name_suffix_loc_lang")));
				
				String nb_patient_name_loc_lang=(request.getParameter("nb_patient_name_loc_lang") == null ? "" : request.getParameter("nb_patient_name_loc_lang"));
				if(nb_patient_name_loc_lang !=null && nb_patient_name_loc_lang.length()>100){
					nb_patient_name_loc_lang=nb_patient_name_loc_lang.substring(0,100);
				}
				
				tabdata.put("nb_patient_name_loc_lang",nb_patient_name_loc_lang);
				tabdata.put("father_name_prefix", (request.getParameter("father_name_prefix") == null ? "" : request.getParameter("father_name_prefix")));
				tabdata.put("father_first_name", (request.getParameter("father_first_name") == null ? "" : request.getParameter("father_first_name")));
				tabdata.put("father_second_name", (request.getParameter("father_second_name") == null ? "" : request.getParameter("father_second_name")));
				tabdata.put("father_third_name", (request.getParameter("father_third_name") == null ? "" : request.getParameter("father_third_name")));
				tabdata.put("father_family_name_prefix", (request.getParameter("father_family_name_prefix") == null ? "" : request.getParameter("father_family_name_prefix")));
				tabdata.put("father_family_name", (request.getParameter("father_family_name") == null ? "" : request.getParameter("father_family_name")));
				tabdata.put("father_name_suffix", (request.getParameter("father_name_suffix") == null ? "" : request.getParameter("father_name_suffix")));				
				String father_patient_name=(request.getParameter("father_patient_name") == null ? "" : request.getParameter("father_patient_name"));
				if(father_patient_name !=null && father_patient_name.length()>100){
					father_patient_name=father_patient_name.substring(0,100);
				}				
				tabdata.put("father_patient_name", father_patient_name);
				tabdata.put("father_name_prefix_loc_lang", (request.getParameter("father_name_prefix_loc_lang") == null ? "" : request.getParameter("father_name_prefix_loc_lang")));
				tabdata.put("father_first_name_loc_lang", (request.getParameter("father_first_name_loc_lang") == null ? "" : request.getParameter("father_first_name_loc_lang")));
				tabdata.put("father_second_name_loc_lang", (request.getParameter("father_second_name_loc_lang") == null ? "" : request.getParameter("father_second_name_loc_lang")));
				tabdata.put("father_third_name_loc_lang", (request.getParameter("father_third_name_loc_lang") == null ? "" : request.getParameter("father_third_name_loc_lang")));
				tabdata.put("father_family_name_loc_lang", (request.getParameter("father_family_name_loc_lang") == null ? "" : request.getParameter("father_family_name_loc_lang")));
				tabdata.put("father_name_suffix_loc_lang", (request.getParameter("father_name_suffix_loc_lang") == null ? "" : request.getParameter("father_name_suffix_loc_lang")));
				
				String father_patient_name_loc_lang=(request.getParameter("father_patient_name_loc_lang") == null ? "" : request.getParameter("father_patient_name_loc_lang"));
				if(father_patient_name_loc_lang !=null && father_patient_name_loc_lang.length()>100){
					father_patient_name_loc_lang=father_patient_name_loc_lang.substring(0,100);
				}
				
				tabdata.put("father_patient_name_loc_lang", father_patient_name_loc_lang);	
				
				tabdata.put("finalized_yn", (request.getParameter("finalized_yn") == null ? "N" : request.getParameter("finalized_yn")));			
				tabdata.put("complns_1st_stage_labour_code", (request.getParameter("complns_1st_stage_labour_code") == null ? "" : request.getParameter("complns_1st_stage_labour_code")));			
				tabdata.put("complns_2nd_stage_labour_code", (request.getParameter("complns_2nd_stage_labour_code") == null ? "" : request.getParameter("complns_2nd_stage_labour_code")));			
				tabdata.put("complns_3rd_stage_labour_code", (request.getParameter("complns_3rd_stage_labour_code") == null ? "" : request.getParameter("complns_3rd_stage_labour_code")));			
				tabdata.put("compln_pregnancy_code", (request.getParameter("compln_pregnancy_code") == null ? "" : request.getParameter("compln_pregnancy_code")));
				tabdata.put("compln_nr_pregnancy_code", (request.getParameter("compln_nr_pregnancy_code") == null ? "" : request.getParameter("compln_nr_pregnancy_code")));

				tabdata.put("date_of_birth_hj", (request.getParameter("date_of_birth_hjiri") == null ? "" : request.getParameter("date_of_birth_hjiri")));//Added MMS-QH-CRF-0145.1 [IN:047497]
				tabdata.put("parity1", (request.getParameter("parity1")==null?"":request.getParameter("parity1"))) ; //ttttttt

				boolean local_ejbs = false;
			
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
		
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/NewbornRegistration", NewbornRegistrationHome.class,local_ejbs);
				
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = tabdata;
			
				Class [] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();

				java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("updateNewbornRegistration",paramArray)).invoke(busObj,argArray);

				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
				boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue()); 				

          		String patientid = (String) results.get("patient");
				if(patientid==null)patientid="";   

				String mother_id = (String) results.get("mother_id");
				if(mother_id==null)mother_id="";
				String called_from = "";
				called_from = request.getParameter("called_function")==null?"":request.getParameter("called_function");
				if(inserted)
				{
					MessageManager mm = new MessageManager();
				    final java.util.Hashtable mesg = mm.getMessage(locale, "PAT_UPD_SUCCESS", "MP") ;
					
				    String msg1=(String)mesg.get("message");			
		
					out.println("alert('"+msg1+"');");
					mesg.clear();
					String pat_ser_grp_code = request.getParameter("pat_ser_grp_code") == null ? "" : request.getParameter("pat_ser_grp_code");

					doOnlineReports(request, request.getParameter("patient_id"), pat_ser_grp_code,function_id_mg);
					
					if(refreshFramesYN.equals("Y")) { 
						
						callChangePatDetails(request, results, inserted, function_id, multiple_birth_yn, patientid,birth_place_code,birth_place_desc,called_from_mothercare,mother_id, nbUseMotherSer, patIidLength, nbPatSerGrp, invkAdmFrmNBYn, ipInstallYn, siteId,called_from,mother_bed_no,mother_encounter_id);//Rameez for SKR-SCF-0668 [IN:035813] on 22-Nov-12 -added 'mother_encounter_id' param
					}else{
						out.println("location.href=\"../eCommon/jsp/error.jsp?home_required_yn=Y&err_num=&err_value=1\"");	
					}  				    
				} else {
					error1 = (String) results.get("error") ;
					out.println("location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error1 )+ "\"");	
				}
				results.clear();
			//}
			//if(rset != null) rset.close();
			//if(stmt!=null) stmt.close();
		 //}  //Validate 	bcg_datetime	vitk_datetime	hepb_datetime			
		tabdata.clear();
		}
		catch(Exception e)
		{
			//out.println("Error In Servlet of UPdate:"+e.toString());
			e.printStackTrace();
		}
	}

	/*
    private String promptFileGen(HttpServletRequest req, HttpServletResponse res)
    {
        String create_file_at_regn_yn	= "N" ;
        String retVal					= "" ;
		regnb = req.getParameter("function_name_nb");
		if(regnb == null)
				regnb ="";
		
		try
        {
			stmt = con.createStatement();
           	sql = "SELECT create_file_at_pat_regn_yn FROM MP_PARAM";

            rset = stmt.executeQuery(sql);
            if(rset.next())
            {
                create_file_at_regn_yn = rset.getString(1);
            }

            if(create_file_at_regn_yn.equals("Y"))
            {
				res.setContentType("text/html");
                String s = " <html><head>  <link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link><Script src='../eCommon/js/common.js' language='JavaScript'></Script> </head><body class='message'> <form name='f' method='post' action='../servlet/eMP.NewbornRegistrationServlet'> \n" ;

                java.util.Enumeration enumarator = req.getParameterNames() ;

                while(enumarator.hasMoreElements())
                {
					String name = (String)enumarator.nextElement() ;
                    s= s+"<input type='hidden' name='"+name+"' value=\""+req.getParameter(name)+"\">\n" ;
				}
                s= s+"<input type='hidden' name='generate_file' value='Y'> \n"     ;
                s= s+"<input type='hidden' name='function_name_nb' value='"+regnb+"'> \n"     ;
                s=  s+" </form><script>document.all.generate_file.value='Y'; ";
                s=s+"document.all.function_name.value='insert';document.forms(0).submit();</script></body></html> ";

                out.println(s) ;
               
                retVal = "" ;
            }
            else retVal = "insert" ;

			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
        }
        catch(Exception e)
        {
            out.println(e);
			e.printStackTrace();
        }
        return retVal ;
    }

	*/

	private void callChangePatDetails(HttpServletRequest request, HashMap results, boolean inserted, String function_id, String multiple_birth_yn, String patientid, String birth_place_code, String birth_place_desc, String called_from_mothercare, String mother_id, String nbUseMotherSer, String patIidLength, String nbPatSerGrp, String invkAdmFrmNBYn, String ipInstallYn, String siteId,String called_from,String mother_bed_no, String mother_encounter_id){ //Rameez for SKR-SCF-0668 [IN:035813] on 22-Nov-12 -added 'mother_encounter_id' param

		String function_invoked = request.getParameter("function_invoked") == null ? "" : request.getParameter("function_invoked");
		
		/*
		String nbUseMotherSer = request.getParameter("nb_use_mother_ser") == null ? "" : request.getParameter("nb_use_mother_ser");
		String patIidLength = request.getParameter("maxLength") == null ? "" : request.getParameter("maxLength");
		String nbPatSerGrp = request.getParameter("newborn_pat_ser_grp") == null ? "" : request.getParameter("newborn_pat_ser_grp");
		String invkAdmFrmNBYn = request.getParameter("invoke_adm_from_newborn_yn") == null ? "" : request.getParameter("invoke_adm_from_newborn_yn");
		String ipInstallYn = request.getParameter("ip_install_yn") == null ? "" : request.getParameter("ip_install_yn");
		String siteId = request.getParameter("siteId") == null ? "" : request.getParameter("siteId");	
		*/
		
		//&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"
		
		

		if(tempflag > 0){
			numOfbaby = tempflag;
		}		
		if(function_invoked.equals("")){
			function_invoked = function_id;
		}		
		regnb = request.getParameter("function_name_nb");
		if(regnb == null)
				regnb ="";	
		try{
			String errors = "";
			String errors1 = "";
			String error_value  = "0" ;		
//	System.out.println("function_id--->"+function_id)		;
//	System.out.println("function_invoked--->"+function_invoked)		;
	
			if(function_id.equals("")||function_invoked.equals("PAT_REG")||function_id.equals("NEWBORN_REG")){
		
				if(inserted){
					errors = (String) results.get("ResultFromMessageManager") ;
                    if(errors == null)errors = "";
                    error_value = "1" ;
					String outcome = request.getParameter("outcome");
					if(outcome == null)outcome = "N";
				    String active = (String) results.get("active");
                    if(active == null)active = "N";
                    String multi_birth = multiple_birth_yn;
                    if(multi_birth==null)multi_birth="N";					
					if(called_from_mothercare.equals("MC")){
						out.println("if(parent && parent && parent.parent.frames[2] && parent.parent.frames[2].frames[0]){parent.parent.frames[2].frames[0].location.reload();};");//If New Born called from CA, CA frames are getting refreshed.
						out.println("if(parent && parent && parent.parent.frames[2] && parent.parent.frames[2].frames[1]){parent.parent.frames[2].frames[1].location.reload();};");//If New Born called from CA, CA frames are getting refreshed.
					}
	/*
		System.out.println("active--->"+active)		;
		System.out.println("multi_birth--->"+multi_birth)		;
		System.out.println("noOfBirths--->"+noOfBirths)		;
		System.out.println("numOfbaby--->"+numOfbaby)		;
		System.out.println("called_from_mothercare--->"+called_from_mothercare)		;
		System.out.println("called_from--->"+called_from)		;
		*/
					if(active.equals("Y")){
						if(!function_invoked.equals("PAT_REG")){ 
							if(!multi_birth.equals("Y")){	
								if(called_from_mothercare.equals("MC")){
									//out.println("<script>parent.parent.frames[2].frames[0].location.reload();</script>");
									//out.println("<script>parent.parent.frames[2].frames[1].location.reload();</script>");
								}
								out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&disable_add_yn=Y&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");
								out.println("self.location.href='../eCommon/jsp/error.jsp?err_num=';");
							}
						}
						if(multi_birth.equals("Y")){
							if(noOfBirths - numOfbaby >= 1){
								if(function_invoked.equals("PAT_REG")){
									out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&parent_details= "+java.net.URLEncoder.encode(parent_details)+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&disable_add_yn=N&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&multi_birth=Y&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");
									out.println("self.location.href='../eCommon/jsp/error.jsp?err_num=';");
								}else{    
									if(called_from_mothercare.equals("MC")){
										//out.println("<script>parent.parent.frames[2].frames[0].location.reload();</script>");
										//out.println("<script>parent.parent.frames[2].frames[1].location.reload();</script>");
									}
									out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&parent_details= "+java.net.URLEncoder.encode(parent_details)+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&disable_add_yn=N&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&multi_birth=Y&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");
									out.println("self.location.href='../eCommon/jsp/error.jsp?err_num=';");															
								}
							}else{
								if(!function_invoked.equals("PAT_REG")){
									if(called_from_mothercare.equals("MC")){
										//out.println("<script>parent.parent.frames[2].frames[0].location.reload();</script>");
										//out.println("<script>parent.parent.frames[2].frames[1].location.reload();</script>");
									}
									out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&disable_add_yn=Y&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");
									out.println("self.location.href='../eCommon/jsp/error.jsp';");									
								}
								if(function_invoked.equals("PAT_REG")){
									out.println("self.close();");
								}
							}
						}else{  
							if(!function_invoked.equals("PAT_REG")){ 								
							    /*
								out.println("<script>");	
								out.println("parent.location.href='../eMP/jsp/NewbornRegistration.jsp?function_id=NEWBORN_REG&function_name="+regnb+"&access=NYNNYN&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"");
								*/
							}
							if(function_invoked.equals("PAT_REG")){   
								if(called_from.equals("IP") || called_from.equals("AE")){
									out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&disable_add_yn=Y&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");	
									out.println("self.location.href='../eCommon/jsp/error.jsp';");
								}else{
								out.println("self.close();");
								}
							}
						}
					}else{
						if(!function_invoked.equals("PAT_REG")){
							if(!multi_birth.equals("Y")){
								if(called_from_mothercare.equals("MC")){
									//out.println("<script>parent.parent.frames[2].frames[0].location.reload();</script>");
									//out.println("<script>parent.parent.frames[2].frames[1].location.reload();</script>");
								}
								out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&disable_add_yn=Y&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");	
								out.println("self.location.href='../eCommon/jsp/error.jsp?err_num=';");								
							}
						}
						if(multi_birth.equals("Y")){
							if(noOfBirths - numOfbaby >= 1){
								if(function_invoked.equals("PAT_REG")){
									out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&disable_add_yn=N&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&multi_birth=Y&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");
									out.println("self.location.href='../eCommon/jsp/error.jsp?err_num=';");
								}else{   
									if(called_from_mothercare.equals("MC")){
										//out.println("<script>parent.parent.frames[2].frames[0].location.reload();</script>");
										//out.println("<script>parent.parent.frames[2].frames[1].location.reload();</script>");
									}
									
									
									out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&mother_encounter_id="+mother_encounter_id+"&new_born_id="+patientid+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&disable_add_yn=N&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&multi_birth=Y&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");		
									out.println("self.location.href='../eCommon/jsp/error.jsp?err_num=';");//Rameez for SKR-SCF-0668 [IN:035813] on 22-Nov-12 -added 'mother_encounter_id' param									
								}
							}else{
								if(called_from.equals("IP") || called_from.equals("AE")){
									out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&disable_add_yn=Y&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");		
									out.println("self.location.href='../eCommon/jsp/error.jsp';");
								}else{
									if(called_from_mothercare.equals("MC")){
										//out.println("<script>parent.parent.frames[2].frames[0].location.reload();</script>");
										//out.println("<script>parent.parent.frames[2].frames[1].location.reload();</script>");
									}
									out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&disable_add_yn=Y&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");		
									out.println("self.location.href='../eCommon/jsp/error.jsp';");									
								}
						   }
						}else{
							if(called_from.equals("IP") || called_from.equals("AE")){
								out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&disable_add_yn=Y&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");
								out.println("self.location.href='../eCommon/jsp/error.jsp';");
							}else{
								//out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( errors )+"&err_value="+error_value+ "\"</script>");
							}
						}
					}
				}else{
					// Added the below code for SRR20056-SCF-5747 [IN:024592] by Suresh M on 26.10.2010	
					// Changed the global var as Local var for SRR20056-SCF-5970 [IN:025034] by Suresh M on 22.11.2010	
					errors1 = (String) results.get("error1") ;					
					
					if(!errors1.equals("")){
						errors1 = errors1.replace("$",mother_id);						
						if(called_from.equals("IP") || called_from.equals("AE")){  
						out.println("var errors1='"+errors1+"'; alert(errors1);window.close();");
						} else { 
						out.println("var errors1='"+errors1+"'; alert(errors1);parent.frames[1].location.href='../eCommon/html/blank.html'");
						}
					// Ends Suresh M
					} else {	
						out.println("if(parent.f_query_add_mod.newbornheader_frame.document.all.add_records){parent.f_query_add_mod.newbornheader_frame.document.all.add_records.disabled=false;}");
						errors = (String) results.get("error") ;					
						out.println("location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( errors )+ "\"");
					}
				}
			}else{ 
				if(inserted){
					errors = (String) results.get("ResultFromMessageManager");
					if(errors == null) errors = "";
					if (errors!=null) errors = errors.substring(0,errors.indexOf("<br>"));
					error_value = "1";
					String outcome = request.getParameter("outcome");
					if(outcome == null) outcome = "N";
					String active = (String) results.get("active");
					if(active == null) active = "N";
					String multi_birth = multiple_birth_yn;
					if(multi_birth == null) multi_birth = "N";
					out.println("if(parent.parent.frames[2].frames[0]){parent.parent.frames[2].frames[0].location.reload();};");//If New Born called from CA, CA frames are getting refreshed.
					out.println("if(parent.parent.frames[2].frames[1]){parent.parent.frames[2].frames[1].location.reload();};");//If New Born called from CA, CA frames are getting refreshed.
					 
					if(multi_birth.equals("Y")){ 
						if(noOfBirths - numOfbaby >= 1){
							out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?module_id=MP&mother_id="+mother_id+"&new_born_id="+patientid+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&disable_add_yn=N&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"function_type=F&accessRights="+accessRights+"&multi_birth=Y&parent_details= "+java.net.URLEncoder.encode(parent_details)+"&noOfBirths="+noOfBirths+"&numOfbaby="+numOfbaby+"&function_invoked="+function_invoked+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");
							out.println("self.location.href='../eCommon/jsp/error.jsp';");
						}else{
							out.println("parent.frames[1].location.href='../eMP/jsp/NewbornRegistrationFrames.jsp?mother_id="+mother_id+"&new_born_id="+patientid+"&disable_add_yn=Y&dflt_parent_dtls_yn=Y&function_id=NEWBORN_REG&function_name="+regnb+"&accessRights="+accessRights+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&invoked_from=servlet&calling_module_id="+called_from+"&called_from_mothercare="+called_from_mothercare+"&nbUseMotherSer="+nbUseMotherSer+"&patIidLength="+patIidLength+"&nbPatSerGrp="+nbPatSerGrp+"&invkAdmFrmNBYn="+invkAdmFrmNBYn+"&ipInstallYn="+ipInstallYn+"&siteId="+siteId+"'");
							out.println("self.location.href='../eCommon/jsp/error.jsp';");							
						}
					}else{
						out.println("alert('"+errors+"');");
					}
				}else{
					out.println("if(parent.f_query_add_mod.newbornheader_frame.document.all.add_records){parent.f_query_add_mod.newbornheader_frame.document.all.add_records.disabled=false;}");
					errors = (String) results.get("error") ;
					if(errors==null)errors="";
					error_value="0";
					out.println("self.location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( errors )+ "&err_value=" + error_value+ "\"");
				}
			}
			results.clear();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void doOnlineReports(HttpServletRequest request, String patientid,String patsergrpcode,String function_id)
    {
		//Connection con_olrep = null;
		Connection con = null;
		try
		{			
			String locale = "";	
			String sqlString = "";
			locale = p.getProperty("LOCALE");
			String sfunctionid="NEWBORN_REG";
			con 	= ConnectionManager.getConnection(request);

			isRemoveReport = CommonBean.isSiteSpecific(con, "MP","REMOVE_REP_FROM_NEWBORN");		// Added By Dharma on May 26th 2015 against HSA-CRF-0228 [IN:050965]
			
		
			
			sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where A.pat_ser_grp_code = '"+patsergrpcode+"' and A.print_reqd_yn='Y' AND B.language_id='"+locale+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facilityId+"')='"+facilityId+"' and ";
			//System.out.println("mode ==>"+mode);
			//System.out.println("newBornOutCome ==>"+newBornOutCome);
			//System.out.println("finalized_yn ==>"+finalized_yn);
			//System.out.println("single_stage_nb_reg_appl_yn ==>"+single_stage_nb_reg_appl_yn);
			
			//Modified the validations against HSA-SCF-0059  - Start
			if(mode.equals("Query")) { 
				sfunctionid="MP_MAIN_NB_REG";
				if(newBornOutCome.equals("L")){
					//sqlString = sqlString + "A.report_id in ('MPBNBFRM', 'MPBWBLBL', 'MPBIRCER') order by 2";
					//sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBIRCER','MPBFRNST','MPBFLLBL','MPBIDLBL','MPBWBLBL') order by 2";
					//sqlString = sqlString + "A.report_id in ('MPBIRCER','MPBFRNST','MPBFLLBL','MPBIDLBL','MPBPTLBL','MPBWBLBL','MPBNBFRM','MPBNBWBL') order by 2";
					sqlString = sqlString + "A.report_id in ('MPBIRCER','MPBPTLBL','MPBWBLBL','MPBNBFRM','MPBNBWBL' ";
				}else{
					//sqlString = sqlString + "A.report_id in ('MPSTBCER') order by 2";
					//sqlString = sqlString + "A.report_id in ('MPSTBCER','MPBFRNST','MPBFLLBL','MPBIDLBL','MPBPTLBL','MPBWBLBL','MPBNBFRM','MPBNBWBL') order by 2";
					sqlString = sqlString + "A.report_id in ('MPSTBCER','MPBPTLBL','MPBWBLBL','MPBNBFRM','MPBNBWBL' ";
				}
			}else{
				sfunctionid="NEWBORN_REG";
				if(newBornOutCome.equals("L")){
					//sqlString = sqlString + "A.report_id in ('MPBNBFRM', 'MPBWBLBL') order by 2";
					if(finalized_yn.equals("Y")){
						if(single_stage_nb_reg_appl_yn.equals("Y")){
							//sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBIRCER','MPBFRNST','MPBPTLBL','MPBFLLBL','MPBIDLBL','MPBWBLBL','MPBNBWBL') order by 2";
							sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBIRCER','MPBPTLBL','MPBWBLBL','MPBNBWBL' ";
						}else{
							//sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBFRNST','MPBFLLBL','MPBPTLBL','MPBIDLBL','MPBWBLBL','MPBNBWBL') order by 2";
							sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBPTLBL','MPBWBLBL','MPBNBWBL' ";
						}
					}else{
						//sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBFRNST','MPBFLLBL','MPBPTLBL','MPBIDLBL','MPBWBLBL','MPBNBWBL') order by 2";
						sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBPTLBL','MPBWBLBL','MPBNBWBL' ";
					}
				}else{
					//sqlString = sqlString + "A.report_id in ('MPSTBCER') order by 2";
					if(finalized_yn.equals("Y")){
						if(single_stage_nb_reg_appl_yn.equals("Y")){
							//sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPSTBCER','MPBFRNST','MPBPTLBL','MPBFLLBL','MPBIDLBL','MPBWBLBL','MPBNBWBL') order by 2";
							//sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPSTBCER','MPBFRNST','MPBPTLBL','MPBIDLBL','MPBWBLBL','MPBNBWBL') order by 2";
							/*Modified by Dharma on 24th Dec 2014 against IN:053139 --------- */
							sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPSTBCER','MPBPTLBL','MPBWBLBL','MPBNBWBL' ";
						}else{
							//sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBFRNST','MPBFLLBL','MPBPTLBL','MPBIDLBL','MPBWBLBL','MPBNBWBL') order by 2";
							//sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBFRNST','MPBPTLBL','MPBIDLBL','MPBWBLBL','MPBNBWBL') order by 2";
							/*Modified by Dharma on 24th Dec 2014 against IN:053139*/
							sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBPTLBL','MPBWBLBL','MPBNBWBL' ";
						}
					}else{
						//sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBFRNST','MPBFLLBL','MPBPTLBL','MPBIDLBL','MPBWBLBL','MPBNBWBL') order by 2";
						//sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBFRNST','MPBPTLBL','MPBIDLBL','MPBWBLBL','MPBNBWBL') order by 2";
						/*Modified by Dharma on 24th Dec 2014 against IN:053139*/
						sqlString = sqlString + "A.report_id in ('MPBNBFRM','MPBPTLBL','MPBWBLBL','MPBNBWBL' ";
					}
				}
			}	
			/*Added by Dharma on May 26th 2015 aginst against HSA-CRF-0228 [IN:050965] Start*/
			/*Removed MPBFRNST, MPBIDLBL report ids from above sqlString variable*/
			if(!isRemoveReport){
				sqlString	= sqlString + " , 'MPBFRNST' , 'MPBIDLBL' ";
			}
			/*Added by Dharma on May 26th 2015 aginst against HSA-CRF-0228 [IN:050965] End*/
			
			boolean blocPatientFileExists = CommonBean.isPatientFileExists(con, patientid, facilityId);
			if(blocPatientFileExists)
				sqlString = sqlString + " ,'MPBFLLBL') order by 2";
			else
				sqlString = sqlString + ") order by 2";
			//Modified the validations against HSA-SCF-0059  - End
			if(mother_encounter_id==null || mother_encounter_id.equals("")){
				mother_encounter_id="TEMP*12*";
			}
		
			
			String reportParamNames	 = "p_patient_id,p_facility_id,p_encounter_id,p_function_id,p_language_id";
		    String reportParamValues = ""+patientid+","+facilityId+","+mother_encounter_id+","+function_id+","+locale+"";			
			String htmlFor = "";		
			htmlFor = htmlFor +" var dialogHeight    = '50vh' ;";
			htmlFor = htmlFor + " var dialogWidth = '50vw' ;";
			htmlFor = htmlFor +"  var arguments =   ''; ";
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			htmlFor = htmlFor +"  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id="+ sfunctionid +"&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&Patient_ID="+patientid+"&P_function_id="+function_id+"&dest_locn_type=N&dest_locn_code="+mother_nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';";
			//htmlFor = htmlFor +"  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&Patient_ID="+patientid+"&P_function_id="+function_id+"&dest_locn_type=N&dest_locn_code="+mother_nursing_unit+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';";
			htmlFor = htmlFor +" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;";
			htmlFor = htmlFor +"  retVal            =   await window.showModalDialog(getUrl,arguments,features); ";
			out.println(htmlFor);
			//if(rset!=null) rset.close();
			//if(stmt!=null) stmt.close();
		}
		catch(Exception e) {
		e.printStackTrace();}
		finally
		{
			//if(con_olrep != null) ConnectionManager.returnConnection(con_olrep, request);
			if(con != null) ConnectionManager.returnConnection(con, request);
		}
    }
}//1.0
