/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1			 			 		30618			PMG2021-COMN-CRF-0076.2			Manivel N
-----------------------------------------------------------------------------------------------
*/
package eBL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;

/**
 * Servlet implementation class BLMaintainTrtServlet
 */
public class BLMaintainTrtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;

	java.util.Properties p;

	HttpSession session;

	Connection con;

	PreparedStatement pstmt;

	ResultSet rs;	

	HashMap support_data = new HashMap();
	
	HashMap ind_reimb_dtls = new HashMap();
	Hashtable messageHashtable=new Hashtable();
	String msg="";

	StringBuffer sb = new StringBuffer();

	String str_facility_id, str_client_ip_address, str_user_id ;

	String locale;

	String sStyle = "";

	String str_module_id = "", str_function_id = "", str_audit_no = "", str_trx_doc_ref = "" , str_trx_doc_ref_line_num = "", str_trx_doc_ref_seq_num = ""; String str_episode_type = "", str_patient_id = "", str_encounter_id = "";
	// str_episode_id = "", str_visit_id = "",
	String str_bill_doc_type = "", str_bill_doc_num = "", str_query_string = "";//, str_blng_serv_code = "";
//	String str_reimbursable_yn_old = "", str_reimbursable_yn = "", str_reimbursable_ind_old = "", str_reimbursable_ind = "";
//	String str_old_reim_amt = "", str_rev_amt = "", str_reason_code = "";

	String str_tot_rec="";

	String str_error_level = "", str_error_text = "", str_sys_message_id = "";
	
	int totalRecords=0;
	HashMap<String, ArrayList<String>> ManagePatientEncountersMap = new HashMap<String, ArrayList<String>>();
	ArrayList<String> ManagePatientEncountersArray;
	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLMaintainTrtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.err.println("Entered in do post of BLMaintainTrtServlet.java");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");

		this.str_facility_id = (String) session.getValue("facility_id");
		if(str_facility_id == null) str_facility_id="";
		
		System.err.println("str_facility_id.........................................."+str_facility_id);

		str_user_id      = (String) session.getValue("login_user");
		if(str_user_id == null) str_user_id="";

		str_client_ip_address = p.getProperty("client_ip_address");
		if(str_client_ip_address == null) str_client_ip_address="";

		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
				.getAttribute("PREFERRED_STYLE")
				: "IeStyle.css";

		//String attributes[] = session.getValueNames();
		locale = p.getProperty("LOCALE");

		try 
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			
			MaintainTreatmentServiceDtls(req, res);

		} 
		catch (Exception e) 
		{
			System.err.println("Exception in doPost=" + e.toString());
			e.printStackTrace();
			out.println(e.toString());
		} 
	}



	private void MaintainTreatmentServiceDtls(HttpServletRequest req,HttpServletResponse res) throws SQLException
	{
		try 
		{
			con	=	ConnectionManager.getConnection(req);

			java.util.Locale loc = new java.util.Locale(locale);
//			java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
			java.util.ResourceBundle sm_messages = java.util.ResourceBundle.getBundle("eSM.resources.Messages",loc);
//			String gen_receipt = (String)bl_labels.getString("eBL.DOC_GEN.label");
			String rec_mod_mess = (String) sm_messages.getString("RECORD_MODIFIED");

			String sys_error = "";
			String str_error_level = "", str_error_text = "", str_sys_message_id = "" , errorRecordChanged="" ,hdrRecordChanged="";
			int cnt = 0;
			
//			System.err.println("Main 1");
			//getData(req);
//			System.err.println("Main 2");
			//InsertSupportdata();
//			System.err.println("Main 3");	
			String patientid= req.getParameter("patientid1");
			String str_visit_id=req.getParameter("visit_id");
			String str_episode_id=req.getParameter("episode_id");
			String str_episode_type=req.getParameter("episode_type");
			String count= req.getParameter("cnt");
			System.err.println("count  "+count);
			System.err.println("str_episode_id  "+str_episode_id);
			System.err.println("str_visit_id  "+str_visit_id);
			System.err.println("str_episode_type  "+str_episode_type);
			
			String pkgServDtlsAuthStr=req.getParameter("pkgServDtlsAuthStr");
			if(pkgServDtlsAuthStr.equals("") || pkgServDtlsAuthStr.equals("null") || pkgServDtlsAuthStr == null || pkgServDtlsAuthStr.equals(" ")) pkgServDtlsAuthStr = "";
			System.err.println("pkgServDtlsAuthStr in Dtls :: "+pkgServDtlsAuthStr);
			
			String pkgServLmtDtlsPrivYN = req.getParameter("pkgServLmtDtlsPrivYN");
			if(pkgServLmtDtlsPrivYN.equals("") || pkgServLmtDtlsPrivYN.equals("null") || pkgServLmtDtlsPrivYN == null) pkgServLmtDtlsPrivYN="N";
			System.err.println("pkgServLmtDtlsPrivYN in Dtls :: "+pkgServLmtDtlsPrivYN);
			
			try{
				cnt=Integer.parseInt(count) ;
				System.err.println("cnt 158--->"+cnt); 
			}
			catch (NumberFormatException ex){
				ex.printStackTrace();
			}
			
			//String packagecode= req.getParameter("package_code");
			//String packageseqno= req.getParameter("package_seq_no");
			//int packageseqno_int=Integer.parseInt(packageseqno);  
			//String efffromdate= req.getParameter("eff_from_date");
			System.err.println("patientid"+patientid);
			//System.err.println("packagecode"+packagecode);
			
			//System.err.println("packageseqno"+packageseqno);
		//String count=session.getAttribute("dbcount");
			System.err.println("cnt  "+cnt);
			
			
			boolean inserted = true;
			boolean updated = true;
			boolean inserted_rec = true;
			
			int isAnyDtlsRecMod = 0, isAnyDtlsExclRecMod = 0;
			String gbl_package_code = "";
			int gbl_pack_seq_no = 0;
			
			CallableStatement call = null;
			int extra=0;
			ManagePatientEncountersMap = (HashMap<String, ArrayList<String>>) session.getAttribute("PKGSERVICEDETAILSENCOUNTERS");
			System.err.println("ManagePatientEncountersMap"+ManagePatientEncountersMap);
			ArrayList<String> ManagePatientList=ManagePatientEncountersMap.get(patientid);
			
			System.err.println("ManagePatientList : : "+ManagePatientList);
			System.err.println("ManagePatientList : : "+ManagePatientList.size());
			int ManagePatientListsize=ManagePatientList.size();
			System.err.println("ManagePatientListsize : : "+ManagePatientListsize);
			//ManagePatientEncountersMap =	 session.getAttribute("PKGSERVICEDETAILSENCOUNTERS");
			
			for (int i=0;i<ManagePatientList.size();i++)
				
			{
				boolean insert = false;
				boolean update = false;
				boolean delete = false;
			
				if(i<cnt){
					update = true;
					System.err.println("207 : : update");
				}else{
					insert = true;
					System.err.println("211 : :insert ");
				}
										
				StringTokenizer stEncList=new StringTokenizer(ManagePatientList.get(i),"|");
				System.err.println("stEncList===>>"+stEncList);
				
				String hdn_pkg_serv_ind=stEncList.hasMoreTokens()?stEncList.nextToken():""; //
			
				if(hdn_pkg_serv_ind.equals("") || hdn_pkg_serv_ind.equals("null") ) hdn_pkg_serv_ind="";

				System.err.println("hdn_pkg_serv_ind 1:: "+hdn_pkg_serv_ind);				
				
				String hdn_pkg_serv_code=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
			
				if(hdn_pkg_serv_code.equals("") || hdn_pkg_serv_code.equals("null")  ) hdn_pkg_serv_code="";
				System.err.println("hdn_pkg_serv_code 2:: "+hdn_pkg_serv_code);
				
				String hdn_rate_charge_ind=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				System.err.println("hdn_rate_charge_ind before3:: "+hdn_rate_charge_ind);
				if(hdn_rate_charge_ind == null || hdn_rate_charge_ind.equals("null") ) hdn_rate_charge_ind="";
				System.err.println("hdn_rate_charge_ind 3:: "+hdn_rate_charge_ind);				
				
				String hdn_order_catalog_code=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				System.err.println("hdn_order_catalog_code 4:: "+hdn_order_catalog_code);
				if(hdn_order_catalog_code.equals("") || hdn_order_catalog_code.equals("null")) 
				{
					System.err.println("hdn_order_catalog_code===============================================================+++++++++"+hdn_order_catalog_code);
					hdn_order_catalog_code="";
				}
				System.err.println("hdn_order_catalog_code before 4:: "+hdn_order_catalog_code);				
				
				String hdn_factor_rate_ind=stEncList.hasMoreTokens()?stEncList.nextToken():"";//				
				System.err.println("hdn_factor_rate_ind 5 before:: "+hdn_factor_rate_ind);//==>>
				if(hdn_factor_rate_ind.equals("") || hdn_factor_rate_ind.equals("null")  ) hdn_factor_rate_ind="";
				System.err.println("hdn_factor_rate_ind 5:: "+hdn_factor_rate_ind);//==>>		
				
				String hdn_factor_rate=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				System.err.println("hdn_factor_rate 6::before "+hdn_factor_rate);//==>>
				if(hdn_factor_rate.equals("") || hdn_factor_rate.equals("null")) hdn_factor_rate="";
				System.err.println("hdn_factor_rate 6:: "+hdn_factor_rate);//==>>

				String hdn_qty_limit=stEncList.hasMoreTokens()?stEncList.nextToken():"";//						
				if(hdn_qty_limit.equals("") || hdn_qty_limit.equals("null") ) hdn_qty_limit="";				
				System.err.println("hdn_qty_limit 7:: "+hdn_qty_limit);

				String hdn_amt_limit_ind=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				
				if(hdn_amt_limit_ind.equals("") || hdn_amt_limit_ind.equals("null") ) hdn_amt_limit_ind="";
				System.err.println("hdn_amt_limit_ind 8:: "+hdn_amt_limit_ind);				
				
				String hdn_amt_limit=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				
				if(hdn_amt_limit.equals("") || hdn_amt_limit.equals("null") ) hdn_amt_limit="";
				System.err.println("hdn_amt_limit 9:: "+hdn_amt_limit);				
				
				String hdn_group_service_ind=stEncList.hasMoreTokens()?stEncList.nextToken():"";//*not in fd
				if(hdn_group_service_ind.equals("B")) hdn_group_service_ind="";
				if(hdn_group_service_ind.equals("") || hdn_group_service_ind.equals("null") ) hdn_group_service_ind="";
				System.err.println("hdn_group_service_ind 10:: "+hdn_group_service_ind);				
				
				String hdn_incl_home_medication_yn=stEncList.hasMoreTokens()?stEncList.nextToken():"";//			
				if(hdn_incl_home_medication_yn.equals("") || hdn_incl_home_medication_yn.equals("null") ) hdn_incl_home_medication_yn="";
				System.err.println("hdn_incl_home_medication_yn 11:: "+hdn_incl_home_medication_yn);
				
				String hdn_replaceable_yn=stEncList.hasMoreTokens()?stEncList.nextToken():"";//			
				if(hdn_replaceable_yn.equals("") || hdn_replaceable_yn.equals("null") ) hdn_replaceable_yn="N";
				System.err.println("hdn_replaceable_yn 12:: "+hdn_replaceable_yn);
				
				
				String hdn_replaceable_serv_code=stEncList.hasMoreTokens()?stEncList.nextToken():"";//				
				if(hdn_replaceable_serv_code.equals("") || hdn_replaceable_serv_code.equals("null") ) hdn_replaceable_serv_code="";
				System.err.println("hdn_replaceable_serv_code 13:: "+hdn_replaceable_serv_code);
				
				String hdn_rep_serv_ord_cat_code=stEncList.hasMoreTokens()?stEncList.nextToken():"";//							
				if(hdn_rep_serv_ord_cat_code.equals("")|| hdn_rep_serv_ord_cat_code.equals("null") ) hdn_rep_serv_ord_cat_code="";
				System.err.println("hdn_rep_serv_ord_cat_code 14:: "+hdn_rep_serv_ord_cat_code);				
			
				String hdn_daily_limit_ind=stEncList.hasMoreTokens()?stEncList.nextToken():"";//				
				if(hdn_daily_limit_ind.equals("") || hdn_daily_limit_ind.equals("null") ) hdn_daily_limit_ind="";
				System.err.println("hdn_daily_limit_ind 15:: "+hdn_daily_limit_ind);
			
				String hdn_daily_qty_limit=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				
				if(hdn_daily_qty_limit.equals("") || hdn_daily_qty_limit.equals("null")  ) hdn_daily_qty_limit="";
				System.err.println("hdn_daily_qty_limit 16:: "+hdn_daily_qty_limit);
				
				String hdn_daily_amt_limit=stEncList.hasMoreTokens()?stEncList.nextToken():"";//			
				if(hdn_daily_amt_limit.equals("") || hdn_daily_amt_limit.equals("null") ) hdn_daily_amt_limit="";
				System.err.println("hdn_daily_amt_limit 17:: "+hdn_daily_amt_limit);
				
				String hdn_daily_amt_limit_gross_net=stEncList.hasMoreTokens()?stEncList.nextToken():"";//			
				if(hdn_daily_amt_limit_gross_net.equals("") || hdn_daily_amt_limit_gross_net.equals("null") ) hdn_daily_amt_limit_gross_net="G";
				System.err.println("hdn_daily_amt_limit_gross_net 18:: "+hdn_daily_amt_limit_gross_net);				
			
				String hdn_refund_yn=stEncList.hasMoreTokens()?stEncList.nextToken():"";//	
				if(hdn_refund_yn.equals("") || hdn_refund_yn.equals("null") ) hdn_refund_yn="";
				System.err.println("hdn_refund_yn 19:: "+hdn_refund_yn);				
				
				String hdn_refund_rate=stEncList.hasMoreTokens()?stEncList.nextToken():"";//				
				if(hdn_refund_rate.equals("") || hdn_refund_rate.equals("null") ) hdn_refund_rate="";
				System.err.println("hdn_refund_rate 20:: "+hdn_refund_rate);
				
				String hdn_auto_refund_yn=stEncList.hasMoreTokens()?stEncList.nextToken():"";//					
				if(hdn_auto_refund_yn.equals("") || hdn_auto_refund_yn.equals("null") ) hdn_auto_refund_yn="";
				System.err.println("hdn_auto_refund_yn 21:: "+hdn_auto_refund_yn);				
				
				String hdn_close_package_yn=stEncList.hasMoreTokens()?stEncList.nextToken():"";//				
				if(hdn_close_package_yn.equals("") || hdn_close_package_yn.equals("null") ) hdn_close_package_yn="";
				System.err.println("hdn_close_package_yn 22:: "+hdn_close_package_yn);
				
				String hdn_utilized_serv_qty=stEncList.hasMoreTokens()?stEncList.nextToken():"";//				
				if(hdn_utilized_serv_qty.equals("") || hdn_utilized_serv_qty.equals("null") ) hdn_utilized_serv_qty="";
				System.err.println("hdn_utilized_serv_qty 23:: "+hdn_utilized_serv_qty);	
				
				String hdn_utilized_serv_amt=stEncList.hasMoreTokens()?stEncList.nextToken():"";//				
				if(hdn_utilized_serv_amt.equals("") || hdn_utilized_serv_amt.equals("null") ) hdn_utilized_serv_amt="";
				System.err.println("hdn_utilized_serv_amt 24:: "+hdn_utilized_serv_amt);
				
				String hdn_apply_fact_for_srv_lmt_yn=stEncList.hasMoreTokens()?stEncList.nextToken():"";//			
				if(hdn_apply_fact_for_srv_lmt_yn.equals("") || hdn_apply_fact_for_srv_lmt_yn.equals("null") ) hdn_apply_fact_for_srv_lmt_yn="";
				System.err.println("hdn_apply_fact_for_srv_lmt_yn 25:: "+hdn_apply_fact_for_srv_lmt_yn);

				String hdn_split_allowed_yn=stEncList.hasMoreTokens()?stEncList.nextToken():"";//				
				if(hdn_split_allowed_yn.equals("") || hdn_split_allowed_yn.equals("null") ) hdn_split_allowed_yn="";
				System.err.println("hdn_split_allowed_yn 26:: "+hdn_split_allowed_yn);
				
				String packagecode=stEncList.hasMoreTokens()?stEncList.nextToken():"";//								
				if(packagecode.equals("") || packagecode.equals("null") ) packagecode="";
				System.err.println("packagecode :: "+packagecode);
				
				gbl_package_code = packagecode;

			 	String package_seq_no=stEncList.hasMoreTokens()?stEncList.nextToken():"";//				
				int packageseqno=0;
				if("".equals(package_seq_no)){
					packageseqno=0;
				}		
				else
				{
					try
					{
						packageseqno=Integer.parseInt(package_seq_no);	
						gbl_pack_seq_no = packageseqno;
					}catch(Exception e)
					{
						packageseqno=0;
					}
				}
				
				System.err.println("package_seq_no 27:: "+package_seq_no);
				System.err.println("packageseqno="+packageseqno);					
			
				String eff_from_date=stEncList.hasMoreTokens()?stEncList.nextToken():"";//					
				//String hdn_split_allowed_yn =  msgArr[14];
				if(eff_from_date.equals("") || eff_from_date.equals("null") ) eff_from_date="";
				System.err.println("eff_from_date 28::===== "+eff_from_date);
				
				//eff_from_date = com.ehis.util.DateUtils.convertDate(eff_from_date,"DMYHMS","en",locale);
				//System.err.println("eff_from_date 28::=====new "+eff_from_date);

				String hdn_rowid=stEncList.hasMoreTokens()?stEncList.nextToken():"";//			
				//String hdn_split_allowed_yn =  msgArr[14];
				if(hdn_rowid == "" || hdn_rowid == null || "null".equals(hdn_rowid)) hdn_rowid = "";
				System.err.println("hdn_rowid 29:: ====="+hdn_rowid);
				
				String isRowMarkedForDeletionYN = stEncList.hasMoreTokens()?stEncList.nextToken():"";//	
				if(isRowMarkedForDeletionYN == null || isRowMarkedForDeletionYN.equals("null") || isRowMarkedForDeletionYN.equals("")) isRowMarkedForDeletionYN = "N"; 
				System.err.println("isRowMarkedForDeletionYN:"+isRowMarkedForDeletionYN);
				delete = "Y".equals(isRowMarkedForDeletionYN) ? true : false;
				
				String isRowAddedNewlyYN = stEncList.hasMoreTokens()?stEncList.nextToken():"";//	
				if(isRowAddedNewlyYN == null || isRowAddedNewlyYN.equals("null") || isRowAddedNewlyYN.equals("")) isRowAddedNewlyYN = "N"; 
				System.err.println("isRowAddedNewlyYN:"+isRowAddedNewlyYN);
				
				String is_excl_mod_YN = stEncList.hasMoreTokens()?stEncList.nextToken():"";//	
				if(is_excl_mod_YN == null || is_excl_mod_YN.equals("null") || is_excl_mod_YN.equals("")) is_excl_mod_YN = "N"; 
				System.err.println("is_excl_mod_YN:"+is_excl_mod_YN);	

				String exclString = stEncList.hasMoreTokens()?stEncList.nextToken():"";//	
				if(exclString == null || exclString.equals("null") || exclString.equals("")) exclString = "N"; 
				System.err.println("exclString:"+exclString);				
				
				if("Y".equals(isRowAddedNewlyYN) && "Y".equals(isRowMarkedForDeletionYN)){
					insert = false;
					update = false;
					delete = false;
				}
			
				//if(inserted)
				if(update && !delete && inserted)
				{
					try
					{
						System.err.println("Params:"+str_facility_id+"/"+patientid+"/"+packagecode+"/"+packageseqno+"/"+hdn_rowid+"/"+hdn_pkg_serv_ind+"/"+hdn_pkg_serv_code+"/"+hdn_rate_charge_ind+"/"+hdn_order_catalog_code+"/"+hdn_factor_rate_ind+"/"+hdn_factor_rate+"/"+hdn_qty_limit+"/"+hdn_amt_limit_ind+"/"+hdn_amt_limit+"/"+hdn_group_service_ind+"/"+hdn_incl_home_medication_yn+"/"+hdn_replaceable_yn+"/"+hdn_replaceable_serv_code+"/"+hdn_rep_serv_ord_cat_code+"/"+hdn_daily_limit_ind+"/"+hdn_daily_qty_limit+"/"+hdn_daily_amt_limit+"/"+hdn_daily_amt_limit_gross_net+"/"+hdn_refund_yn+"/"+hdn_refund_rate+"/"+hdn_auto_refund_yn+"/"+hdn_close_package_yn+"/"+hdn_apply_fact_for_srv_lmt_yn+"/"+hdn_split_allowed_yn+"/");		
						
						call = con.prepareCall("{ call blpackage.ispkgsubdtlsrecordchanged_3t(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }");	
						
						call.setString(1,str_facility_id);
						call.setString(2,patientid);
						call.setString(3,packagecode);//
						call.setInt(4,packageseqno );//
						call.setString(5,hdn_rowid );//
						call.setString(6,hdn_pkg_serv_ind);
						call.setString(7,hdn_rate_charge_ind);
						call.setString(8,hdn_order_catalog_code);
						call.setString(9,hdn_factor_rate_ind);
						call.setString(10,hdn_factor_rate);
						call.setString(11,hdn_qty_limit);
						call.setString(12,hdn_amt_limit_ind);
						call.setString(13,hdn_amt_limit);
						call.setString(14,hdn_group_service_ind);//* not in fd
						call.setString(15,hdn_incl_home_medication_yn);
						call.setString(16,hdn_replaceable_yn);
						call.setString(17,hdn_replaceable_serv_code);
						call.setString(18,hdn_rep_serv_ord_cat_code);
						call.setString(19,hdn_daily_limit_ind);
						call.setString(20,hdn_daily_qty_limit);
						call.setString(21,hdn_daily_amt_limit);
						call.setString(22,hdn_daily_amt_limit_gross_net);//new
						call.setString(23,hdn_refund_yn);//
						call.setString(24,hdn_refund_rate);
						call.setString(25,hdn_auto_refund_yn);
						call.setString(26,hdn_close_package_yn);
						call.setString(27,hdn_apply_fact_for_srv_lmt_yn);
						call.setString(28,hdn_split_allowed_yn);
					
						
						call.registerOutParameter(29, java.sql.Types.VARCHAR);
						call.registerOutParameter(30, java.sql.Types.VARCHAR);
						call.registerOutParameter(31, java.sql.Types.VARCHAR);
						call.registerOutParameter(32, java.sql.Types.VARCHAR);
				
						call.setString(33,hdn_pkg_serv_code);
					
						call.execute();
						errorRecordChanged  = call.getString(29);
						str_error_level = call.getString(30);
						str_error_text = call.getString(31);
						str_sys_message_id = call.getString(32);
						
						System.err.println("errorRecordChanged 472::"+errorRecordChanged);
						System.err.println("Error CODE:::"+str_error_level);
						System.err.println("Error TEXT:::"+str_error_text);
						System.err.println("Error MSG:::"+str_sys_message_id);
						
						if(errorRecordChanged == null) errorRecordChanged="";
						if(str_error_level == null) str_error_level="";
						if(str_error_text == null) str_error_text="";
						if(str_sys_message_id == null) str_sys_message_id="";
						
						
						if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
						{
							if(!str_error_level.equals("") && !str_error_text.equals(""))
							{
								System.err.println("****Inside Error Text Loop 487*");
								inserted = false;
								inserted_rec = false;
							}
							else if(!str_sys_message_id.equals(""))
							{
								System.err.println("****Inside Sys Message Loop 493*");
								inserted = false;
								inserted_rec = false;
							}
						}
						else
						{
						System.err.println("****Inside Rec Success Loop 500");
							inserted = true;
							inserted_rec = true;
						}
					
						
						
						
						call.close();

						
					}
					catch (Exception e)
					{
						inserted = false;
						System.err.println("Error while ispkgsubdtlsrecordchanged_3t 491:"+e);
						sys_error = "Error while ispkgsubdtlsrecordchanged_3t 492:"+e;
					}
				}
				System.err.println("errorRecordChanged:"+errorRecordChanged);
				if(errorRecordChanged.equals("Y") && inserted)
				{
					try
					{
						isAnyDtlsRecMod++;
						call = con.prepareCall("{ call blpackage.updateblpkgsubdtls_3t (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(?,'DD/MM/YYYY HH24:MI:SS')) }");	
					
						call.setString(1,str_facility_id);
						call.setString(2,patientid);
						call.setString(3,packagecode);//
						call.setInt(4,packageseqno );//
						call.setString(5,hdn_rowid );//
						
						call.setString(6,hdn_pkg_serv_ind);
						call.setString(7,hdn_pkg_serv_code);
						call.setString(8,hdn_rate_charge_ind);
						
						call.setString(9,hdn_order_catalog_code);
						call.setString(10,hdn_factor_rate_ind);
						call.setString(11,hdn_factor_rate);
						
						call.setString(12,hdn_qty_limit);
						call.setString(13,hdn_amt_limit_ind);
						call.setString(14,hdn_amt_limit);
						
						call.setString(15,hdn_group_service_ind);//* not in fd
						call.setString(16,hdn_incl_home_medication_yn);
						call.setString(17,hdn_replaceable_yn);
						
						call.setString(18,hdn_replaceable_serv_code);
						call.setString(19,hdn_rep_serv_ord_cat_code);
						call.setString(20,hdn_daily_limit_ind);
						
						call.setString(21,hdn_daily_qty_limit);
						call.setString(22,hdn_daily_amt_limit);
						call.setString(23,hdn_daily_amt_limit_gross_net);//new
						
						call.setString(24,hdn_refund_yn);//
						call.setString(25,hdn_refund_rate);
						call.setString(26,hdn_auto_refund_yn);
						
						call.setString(27,hdn_close_package_yn);
						call.setString(28,hdn_apply_fact_for_srv_lmt_yn);
						call.setString(29,hdn_split_allowed_yn);
						
						call.setString(30,str_user_id);
						call.setString(31,str_client_ip_address);
					
						
						call.registerOutParameter(32, java.sql.Types.VARCHAR);//error level
						call.registerOutParameter(33, java.sql.Types.VARCHAR);//sys messageid
						call.registerOutParameter(34, java.sql.Types.VARCHAR);//error text
						
						call.setString(35,str_episode_type);
						System.err.println("========================571==> before");
						call.setString(36,str_episode_id);
						call.setString(37,str_visit_id);
						call.setString(38,eff_from_date);
						System.err.println("========================573==> after");
						call.execute();
						str_error_level = 	call.getString(32);		
						if(str_error_level == null) str_error_level="";
						
						str_sys_message_id = 	call.getString(33);		
						if(str_sys_message_id == null) str_sys_message_id="";
						
						str_error_text = 	call.getString(34);		
						if(str_error_text == null) str_error_text="";
						
						System.err.println("****str_error_level 583:"+str_error_level);
						System.err.println("****str_sys_message_id 584:"+str_sys_message_id);
						System.err.println("****str_error_text 585:"+str_error_text);

						call.close();
						
						if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
						{
							if(!str_error_level.equals("") && !str_error_text.equals(""))
							{
								System.err.println("str_error_level in blmaintreatpkg msg");
								out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
								System.err.println("****Inside Error Text Loop 593");
								inserted = false;
								//inserted_rec = false;
							}
							else if(!str_sys_message_id.equals(""))
							{
								System.err.println("sysid in blmaintreatpkg msg");
								messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
								msg=(String)messageHashtable.get("message");
								System.err.println("sysid in blmaintreatpkg msg="+msg);
								//out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) );
								
								System.err.println("****Inside Sys Message Loop 599");
								inserted = false;
								//inserted_rec = false;
							}
						}
						else
						{
						System.err.println("****Inside Rec Success Loop 606");
							inserted = true;
							//inserted_rec = true;
						}
					}
					catch(Exception e)
					{
						inserted = false;
						inserted_rec = false;
						System.err.println(" Err: updateblpkgsubdtls_3t 615: "+e);
						sys_error = sys_error + " Err: updateblpkgsubdtls_3t: "+e;
					}
				}//update if end

				System.err.println("inserted===>>819 :: "+inserted);
				
			//	if(errorRecordChanged == null || errorRecordChanged.equals(""))
				if(insert && !delete && inserted)
				{					
					try
					{
						isAnyDtlsRecMod++;
						call = con.prepareCall("{ call blpackage.insertblpkgsubdtls_3t (?, ?, ?, ?, TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");	
					
						call.setString(1,str_facility_id);
						call.setString(2,patientid);
						call.setString(3,packagecode);//
						call.setInt(4,packageseqno );//
						call.setString(5,eff_from_date );//
						call.setString(6,hdn_pkg_serv_ind);
						call.setString(7,hdn_pkg_serv_code);
						call.setString(8,hdn_rate_charge_ind);
						call.setString(9,hdn_order_catalog_code);
						call.setString(10,hdn_factor_rate_ind);
						call.setString(11,hdn_factor_rate);
						call.setString(12,hdn_qty_limit);
						call.setString(13,hdn_amt_limit_ind);
						call.setString(14,hdn_amt_limit);
						call.setString(15,hdn_group_service_ind);//* not in fd
						call.setString(16,hdn_incl_home_medication_yn);
						call.setString(17,hdn_replaceable_yn);
						call.setString(18,hdn_replaceable_serv_code);
						call.setString(19,hdn_rep_serv_ord_cat_code);
						call.setString(20,hdn_daily_limit_ind);
						call.setString(21,hdn_daily_qty_limit);
						call.setString(22,hdn_daily_amt_limit);
						call.setString(23,hdn_daily_amt_limit_gross_net);//new
						call.setString(24,hdn_refund_yn);//
						call.setString(25,hdn_refund_rate);
						call.setString(26,hdn_auto_refund_yn);
						call.setString(27,hdn_close_package_yn);
						call.setString(28,hdn_apply_fact_for_srv_lmt_yn);
						call.setString(29,hdn_split_allowed_yn);
						call.setString(30,str_user_id);
						call.setString(31,str_client_ip_address);
						call.registerOutParameter(32, java.sql.Types.VARCHAR);//error level
						call.registerOutParameter(33, java.sql.Types.VARCHAR);//sys messageid
						call.registerOutParameter(34, java.sql.Types.VARCHAR);//error text
						call.setString(35,str_episode_type);		
						call.setString(36,str_episode_id);
						call.setString(37,str_visit_id);
						System.err.println("==========================861>> before");
						call.execute();
						System.err.println("==========================863>> after");
						str_error_level = 	call.getString(32);		
						if(str_error_level == null) str_error_level="";
						
						str_sys_message_id = 	call.getString(33);		
						if(str_sys_message_id == null) str_sys_message_id="";
						
						str_error_text = 	call.getString(34);		
						if(str_error_text == null) str_error_text="";
						
						System.err.println("****str_error_level 873:"+str_error_level);
						System.err.println("****str_sys_message_id 874:"+str_sys_message_id);
						System.err.println("****str_error_text 875:"+str_error_text);

						call.close();
						
						if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
						{
							if(!str_error_level.equals("") && !str_error_text.equals(""))
							{
								System.err.println("str_error_level in blmaintreatpkg msg");
								out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
								System.err.println("****Inside Error Text Loop 883");
								inserted = false;
								//inserted_rec = false;
							}
							else if(!str_sys_message_id.equals(""))
							{
								System.err.println("sysid in blmaintreatpkg msg");
								messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
								msg=(String)messageHashtable.get("message");
								System.err.println("sysid in blmaintreatpkg msg="+msg);
								//out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) );
								
								System.err.println("****Inside Sys Message Loop 889");
								inserted = false;
								//inserted_rec = false;
							}
						}
						else
						{
						System.err.println("****Inside Rec Success Loop 896");
							inserted = true;
							//inserted_rec = true;
						}
					}
					catch(Exception e)
					{
						inserted = false;
						inserted_rec = false;
						System.err.println(" Err:Insert blpkgsubdtls_3t 905: "+e);
						sys_error = sys_error + " Err: Insertblpkgsubdtls_3t: "+e;
					}
				}//update if end
				
				if(delete && inserted)
				{					
					try
					{
						isAnyDtlsRecMod++;
						call = con.prepareCall("{ call blpackage.deleteblpkgsubdtls_3t (?,?,?,?,?,?,?,?,?,?,?,?,?) }");
						call.setString(1,str_facility_id);
						call.setString(2,patientid);
						call.setString(3,packagecode);
						call.setInt(4,packageseqno);
						call.setString(5,hdn_pkg_serv_code);
						call.setString(6,str_user_id);
						call.setString(7,str_client_ip_address);
						call.registerOutParameter(8,java.sql.Types.VARCHAR);
						call.registerOutParameter(9,java.sql.Types.VARCHAR);
						call.registerOutParameter(10,java.sql.Types.VARCHAR);
						call.setString(11,str_episode_type);
						call.setString(12,str_episode_id);
						call.setString(13,str_visit_id);
						
						call.execute();

						str_error_level = 	call.getString(8);		
						if(str_error_level == null) str_error_level="";
						
						str_sys_message_id = 	call.getString(9);		
						if(str_sys_message_id == null) str_sys_message_id="";
						
						str_error_text = 	call.getString(10);		
						if(str_error_text == null) str_error_text="";
						
						System.err.println("****str_error_level 924:"+str_error_level);
						System.err.println("****str_sys_message_id 925:"+str_sys_message_id);
						System.err.println("****str_error_text 926:"+str_error_text);

						call.close();
						
						if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
						{
							if(!str_error_level.equals("") && !str_error_text.equals(""))
							{
								System.err.println("str_error_level in deleteblpkgsubdtls_3t msg");
								out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
								System.err.println("****Inside Error Text Loop 934");
								inserted = false;
							}
							else if(!str_sys_message_id.equals(""))
							{
								System.err.println("sysid in deleteblpkgsubdtls_3t msg");
								messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
								msg=(String)messageHashtable.get("message");
								System.err.println("sysid in deleteblpkgsubdtls_3t msg="+msg);
								//out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) );
								
								System.err.println("****Inside Sys Message Loop 946");
								inserted = false;
							}
						}
						else
						{
						System.err.println("****Inside Rec Success Loop deleteblpkgsubdtls_3t");
							inserted = true;
						}
					}						
					catch(Exception e)
					{
						inserted = false;
						inserted_rec = false;
						System.err.println(" Err:Insert deleteblpkgsubdtls_3t: "+e);
						sys_error = sys_error + " Err: deleteblpkgsubdtls_3t: "+e;
					}					
				}
				System.err.println("is_excl_mod_YN:"+is_excl_mod_YN);
				System.err.println("inserted:"+inserted);
				// Logic to handle Exclusion I/M/D for each line
				if("Y".equals(is_excl_mod_YN) && inserted){
					boolean insertExcl = false;
					boolean updateExcl = false;
					boolean deleteExcl = false;
					/*
					int dbcount = 0;
					try
					{
						dbcount=Integer.parseInt(dbcnt) ;
						System.err.println("dbcount 882--->"+dbcount); 
					}
					catch (NumberFormatException ex){
						ex.printStackTrace();
					}					
					*/
					String[] exclRecordsArr = exclString.split("::");
					System.err.println("exclRecordsArr:"+exclRecordsArr.length);
					for(int j=0;j<exclRecordsArr.length;j++){
						System.err.println("exclRecordsArr:"+exclRecordsArr[j]);
						String[] exclRow = exclRecordsArr[j].split("~~");
						
						for(int temp=0;temp<exclRow.length;temp++){
							System.err.println("exclRow:["+temp+"]:"+exclRow[temp]);
						}
						String rate_charge_ind = exclRow[0];
						if(rate_charge_ind == null || rate_charge_ind.equals(" ")) rate_charge_ind = "";
						
						String excl_serv_code = exclRow[1];
						if(excl_serv_code == null || excl_serv_code.equals(" ")) excl_serv_code = "";
						
						String excl_serv_ind = exclRow[2];
						if(excl_serv_ind == null || excl_serv_ind.equals(" ")) excl_serv_ind = "";

						String exclude_yn = exclRow[3];
						if(exclude_yn == null || exclude_yn.equals(" ")) exclude_yn = "N";
						
						String amt_limit_ind = exclRow[4];
						if(amt_limit_ind == null || amt_limit_ind.equals(" ")) amt_limit_ind = "";
						
						String qty_limit = exclRow[5];
						if(qty_limit == null || qty_limit.equals(" ")) qty_limit = "";
						
						String amt_limit = exclRow[6];
						if(amt_limit == null || amt_limit.equals(" ")) amt_limit = "";

						String replaceable_yn = exclRow[7];
						if(replaceable_yn == null || replaceable_yn.equals(" ")) replaceable_yn = "N";
						
						String replaceable_serv_code = exclRow[8];
						if(replaceable_serv_code == null || replaceable_serv_code.equals(" ")) replaceable_serv_code = "";
						
						String refund_yn = exclRow[9];
						if(refund_yn == null || refund_yn.equals(" ")) refund_yn = "N";
						
						String refund_rate = exclRow[10];
						if(refund_rate == null || refund_rate.equals(" ")) refund_rate = "";

						String auto_refund_yn = exclRow[11];
						if(auto_refund_yn == null || auto_refund_yn.equals(" ")) auto_refund_yn = "N";
						//rounding_by_integer,
						//rounding_option, 
						String apply_fact_for_srv_lmt_yn = exclRow[12];
						if(apply_fact_for_srv_lmt_yn == null || apply_fact_for_srv_lmt_yn.equals(" ")) apply_fact_for_srv_lmt_yn = "N";
						//added_by_id,added_date, modified_by_id, modified_date, added_at_ws_no,
						//added_facility_id, modified_at_ws_no, modified_facility_id,
						
						String split_allowed_yn = exclRow[13];
						if(split_allowed_yn == null || split_allowed_yn.equals(" ")) split_allowed_yn = "N";
						
						String incl_home_medication_yn = exclRow[14];
						if(incl_home_medication_yn == null || incl_home_medication_yn.equals(" ")) incl_home_medication_yn = "N";

						String daily_amt_limit_yn = exclRow[15]; // not available
						if(daily_amt_limit_yn == null || daily_amt_limit_yn.equals(" ")) daily_amt_limit_yn = "N";
						
						String daily_amt_limit = exclRow[16];
						if(daily_amt_limit == null || daily_amt_limit.equals(" ")) daily_amt_limit = "";
						
						String daily_amt_limit_gross_net = exclRow[17];
						if(daily_amt_limit_gross_net == null || daily_amt_limit_gross_net.equals(" ")) daily_amt_limit_gross_net = "";
						
						String daily_limit_ind = exclRow[18];
						if(daily_limit_ind == null || daily_limit_ind.equals(" ")) daily_limit_ind = "";

						String daily_qty_limit = exclRow[19];
						if(daily_qty_limit == null || daily_qty_limit.equals(" ")) daily_qty_limit = "";
						
						String hdn_is_newly_added_row_YN = exclRow[20];
						if(hdn_is_newly_added_row_YN == null || hdn_is_newly_added_row_YN.equals(" ")) hdn_is_newly_added_row_YN = "N";

						String hdn_row_marked_for_del = exclRow[21];
						if(hdn_row_marked_for_del == null || hdn_row_marked_for_del.equals(" ")) hdn_row_marked_for_del = "N";
						deleteExcl = "Y".equals(hdn_row_marked_for_del) ? true : false;
						
						String hdn_exclrowid = exclRow[22];
						if(hdn_exclrowid == null || hdn_exclrowid.equals(" ")) hdn_exclrowid = "";
						
						//String dbcnt = exclRow[23];
						//if(dbcnt == null || dbcnt.equals(" ")) dbcnt = "0";
						
						if(!"".equals(hdn_exclrowid)){
							updateExcl = true;
							insertExcl = false;
							System.err.println("890 : : updateExcl");
						}else{
							insertExcl = true;
							updateExcl = false;
							System.err.println("893 : :insertExcl ");
						}						
						
						if("Y".equals(hdn_is_newly_added_row_YN) && "Y".equals(hdn_row_marked_for_del)){
							insertExcl = false;
							updateExcl = false;
							deleteExcl = false;
						}	
							
						if(updateExcl && !deleteExcl){							
							try
							{
								isAnyDtlsExclRecMod++;
								System.err.println("906 : :inside Update ");
								call = con.prepareCall("{ call blpackage.updatepackagesubexcl (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");	
							
								call.setString(1,str_facility_id);
								call.setString(2,patientid);
								call.setString(3,packagecode);//
								call.setInt(4,packageseqno );//
								call.setString(5,hdn_pkg_serv_code);
								call.setString(6,hdn_pkg_serv_ind);
								call.setString(7,rate_charge_ind);
								call.setString(8,excl_serv_code);
								call.setString(9,excl_serv_ind);
								call.setString(10,exclude_yn);
								call.setString(11,amt_limit_ind);
								call.setString(12,qty_limit);
								call.setString(13,amt_limit );
								call.setString(14,replaceable_yn);
								call.setString(15,replaceable_serv_code);//* not in fd
								call.setString(16,refund_yn );
								call.setString(17,refund_rate);
								call.setString(18,auto_refund_yn);
								call.setString(19,null);
								call.setString(20,null);
								call.setString(21,apply_fact_for_srv_lmt_yn);
								call.setString(22,str_user_id);
								//call.setString(23,added_date);
								call.setString(23,str_client_ip_address);
								call.setString(24,str_facility_id);
								call.setString(25,split_allowed_yn);
								call.setString(26,incl_home_medication_yn);//new
								call.registerOutParameter(27, java.sql.Types.VARCHAR);//error level
								call.registerOutParameter(28, java.sql.Types.VARCHAR);//sys messageid
								call.registerOutParameter(29, java.sql.Types.VARCHAR);//error text							
								call.setString(30,daily_amt_limit_yn);//
								call.setString(31,daily_amt_limit);
								call.setString(32,daily_amt_limit_gross_net);
								call.setString(33,daily_limit_ind);
								call.setString(34,daily_qty_limit);
								System.err.println("==========================944>> before");
								call.execute();
								System.err.println("==========================946>> after");
								str_error_level = 	call.getString(27);		
								if(str_error_level == null) str_error_level="";
								
								str_sys_message_id = 	call.getString(28);		
								if(str_sys_message_id == null) str_sys_message_id="";
								
								str_error_text = 	call.getString(29);		
								if(str_error_text == null) str_error_text="";
								
								System.err.println("****str_error_level 946:"+str_error_level);
								System.err.println("****str_sys_message_id 957:"+str_sys_message_id);
								System.err.println("****str_error_text 958:"+str_error_text);

								call.close();
								
								if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
								{
									if(!str_error_level.equals("") && !str_error_text.equals(""))
									{
										System.err.println("str_error_level in exclusion msg");
										out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
										System.err.println("****Inside Error Text Loop 935");
										inserted = false;
										//inserted_rec = false;
									}
									else if(!str_sys_message_id.equals(""))
									{
										System.err.println("sysid in exclusion msg");
										messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
										msg=(String)messageHashtable.get("message");
										System.err.println("sysid in exclusion msg="+msg);
										//out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
										res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) );
										
										System.err.println("****Inside Sys Message Loop 948");
										inserted = false;
										//inserted_rec = false;
									}
								}
								else
								{
								System.err.println("****Inside Rec Success Loop 896");
									inserted = true;
									//inserted_rec = true;
								}
							}
							catch(Exception e)
							{
								inserted = false;
								inserted_rec = false;
								System.err.println(" Err:Insert blpackage.insertpackagesubexcl 964: "+e);
								sys_error = sys_error + " Err: blpackage.insertpackagesubexcl: "+e;
							}							
						}
						
						if(insertExcl && !deleteExcl){
							try
							{
								isAnyDtlsExclRecMod++;
								System.err.println("906 : :inside insert ");								
								call = con.prepareCall("{ call blpackage.insertpackagesubexcl (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");	
							
								call.setString(1,str_facility_id);
								call.setString(2,patientid);
								call.setString(3,packagecode);//
								call.setInt(4,packageseqno );//
								call.setString(5,hdn_pkg_serv_code);
								call.setString(6,hdn_pkg_serv_ind);
								call.setString(7,rate_charge_ind);
								call.setString(8,excl_serv_code);
								call.setString(9,excl_serv_ind);
								call.setString(10,exclude_yn);
								call.setString(11,amt_limit_ind);
								call.setString(12,qty_limit);
								call.setString(13,amt_limit );
								call.setString(14,replaceable_yn);
								call.setString(15,replaceable_serv_code);//* not in fd
								call.setString(16,refund_yn );
								call.setString(17,refund_rate);
								call.setString(18,auto_refund_yn);
								call.setString(19,null);
								call.setString(20,null);
								call.setString(21,apply_fact_for_srv_lmt_yn);
								call.setString(22,str_user_id);
								//call.setString(23,added_date);
								call.setString(23,str_user_id);
								//call.setString(24,modified_date);							
								call.setString(24,str_client_ip_address);
								call.setString(25,str_facility_id);
								call.setString(26,str_client_ip_address);
								call.setString(27,str_facility_id);
								call.setString(28,split_allowed_yn);
								call.setString(29,incl_home_medication_yn);//new
								call.registerOutParameter(30, java.sql.Types.VARCHAR);//error level
								call.registerOutParameter(31, java.sql.Types.VARCHAR);//sys messageid
								call.registerOutParameter(32, java.sql.Types.VARCHAR);//error text							
								call.setString(33,daily_amt_limit_yn);//
								call.setString(34,daily_amt_limit);
								call.setString(35,daily_amt_limit_gross_net);
								call.setString(36,daily_limit_ind);
								call.setString(37,daily_qty_limit);
								System.err.println("==========================1047>> before");
								call.execute();
								System.err.println("==========================1049>> after");
								str_error_level = 	call.getString(30);		
								if(str_error_level == null) str_error_level="";
								
								str_sys_message_id = 	call.getString(31);		
								if(str_sys_message_id == null) str_sys_message_id="";
								
								str_error_text = 	call.getString(32);		
								if(str_error_text == null) str_error_text="";
								
								System.err.println("****str_error_level 923:"+str_error_level);
								System.err.println("****str_sys_message_id 924:"+str_sys_message_id);
								System.err.println("****str_error_text 925:"+str_error_text);

								call.close();
								
								if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
								{
									if(!str_error_level.equals("") && !str_error_text.equals(""))
									{
										System.err.println("str_error_level in exclusion msg");
										out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
										System.err.println("****Inside Error Text Loop 935");
										inserted = false;
										//inserted_rec = false;
									}
									else if(!str_sys_message_id.equals(""))
									{
										System.err.println("sysid in exclusion msg");
										messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
										msg=(String)messageHashtable.get("message");
										System.err.println("sysid in exclusion msg="+msg);
										//out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
										res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) );
										
										System.err.println("****Inside Sys Message Loop 948");
										inserted = false;
										//inserted_rec = false;
									}
								}
								else
								{
								System.err.println("****Inside Rec Success Loop 896");
									inserted = true;
									//inserted_rec = true;
								}
							}
							catch(Exception e)
							{
								inserted = false;
								inserted_rec = false;
								System.err.println(" Err:Insert blpackage.insertpackagesubexcl 964: "+e);
								sys_error = sys_error + " Err: blpackage.insertpackagesubexcl: "+e;
							}
						}
						
						if(deleteExcl){
							try
							{
								isAnyDtlsExclRecMod++;
								System.err.println("906 : :inside delete ");								
								call = con.prepareCall("{ call blpackage.deletepackagesubexcl (?,?,?,?,?,?,?,?,?) }");
								call.setString(1,str_facility_id);
								call.setString(2,patientid);
								call.setString(3,packagecode);
								call.setInt(4,packageseqno );
								call.setString(5,hdn_pkg_serv_code);
								call.setString(6,excl_serv_code);
								call.registerOutParameter(7,java.sql.Types.VARCHAR);
								call.registerOutParameter(8,java.sql.Types.VARCHAR);
								call.registerOutParameter(9,java.sql.Types.VARCHAR);
								
								call.execute();

								str_error_level = 	call.getString(7);		
								if(str_error_level == null) str_error_level="";
								
								str_sys_message_id = 	call.getString(8);		
								if(str_sys_message_id == null) str_sys_message_id="";
								
								str_error_text = 	call.getString(9);		
								if(str_error_text == null) str_error_text="";
								
								System.err.println("****str_error_level 1131:"+str_error_level);
								System.err.println("****str_sys_message_id 1132:"+str_sys_message_id);
								System.err.println("****str_error_text 1133:"+str_error_text);

								call.close();
								
								if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
								{
									if(!str_error_level.equals("") && !str_error_text.equals(""))
									{
										System.err.println("str_error_level in deletepackagesubexcl msg");
										out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
										System.err.println("****Inside Error Text Loop 934");
										inserted = false;
									}
									else if(!str_sys_message_id.equals(""))
									{
										System.err.println("sysid in deletepackagesubexcl msg");
										messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
										msg=(String)messageHashtable.get("message");
										System.err.println("sysid in deletepackagesubexcl msg="+msg);
										//out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
										res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) );
										
										System.err.println("****Inside Sys Message Loop 946");
										inserted = false;
									}
								}
								else
								{
								System.err.println("****Inside Rec Success Loop deletepackagesubexcl");
									inserted = true;
								}
							}						
							catch(Exception e)
							{
								inserted = false;
								inserted_rec = false;
								System.err.println(" Err:Insert deletepackagesubexcl: "+e);
								sys_error = sys_error + " Err: deletepackagesubexcl: "+e;
							}
						}
					}	// Exclusion looping ends				
				}				
			}
			
			/* ************************************ Authorization Audit Begins ********************************* */
			if("Y".equals(pkgServLmtDtlsPrivYN) && inserted){
				//Privilege audit for header gets inserted when either of the hdr data is modified
				HashMap<String, ArrayList<String>> ManagePatientHdrEncountersMap = new HashMap<String, ArrayList<String>>();

				ManagePatientHdrEncountersMap = (HashMap<String, ArrayList<String>>) session.getAttribute("PKGHDRDETAILSENCOUNTERS");
				System.err.println("ManagePatientHdrEncountersMap in dtls "+ManagePatientHdrEncountersMap);
				ArrayList<String> ManagePatientHdrList=ManagePatientHdrEncountersMap.get(patientid);
				
				System.err.println("ManagePatienthdrList in dtls: : "+ManagePatientHdrList);
				System.err.println("ManagePatienthdrList in dtls: : "+ManagePatientHdrList.size());
				int ManagePatientHdrListsize=ManagePatientHdrList.size();
				System.err.println("ManagePatientHdrListsize in dtls: : "+ManagePatientHdrListsize);
			
				for (int i=0;i<ManagePatientHdrListsize;i++)				
				{
					StringTokenizer hdrList=new StringTokenizer(ManagePatientHdrList.get(i),"|");
					System.err.println("hdrList===>>"+hdrList);
					
					String hdr_package_code=hdrList.hasMoreTokens()?hdrList.nextToken():""; //
				
					if(hdr_package_code.equals("") || hdr_package_code.equals("null") ) hdr_package_code="";

					System.err.println("hdr_package_code 1:: "+hdr_package_code);				
					
					String hdr_package_seq_no=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
				
					if(hdr_package_seq_no.equals("") || hdr_package_seq_no.equals("null")  ) hdr_package_seq_no="";
					System.err.println("hdr_package_seq_no 2:: "+hdr_package_seq_no);
					
					int hdrpackageseqno=0;
					if("".equals(hdr_package_seq_no)){
						hdrpackageseqno=0;
					}		
					else
					{
						try
						{
							hdrpackageseqno=Integer.parseInt(hdr_package_seq_no);	
						}catch(Exception e)
						{
							hdrpackageseqno=0;
						}
					}
					
					String hdr_eff_from_date=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					System.err.println("hdr_eff_from_date before3:: "+hdr_eff_from_date);
					if(hdr_eff_from_date == null || hdr_eff_from_date.equals("null") ) hdr_eff_from_date="";
					System.err.println("hdr_eff_from_date 3:: "+hdr_eff_from_date);				
					
					String hdr_cust_group_code=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					System.err.println("hdr_cust_group_code 4:: "+hdr_cust_group_code);
					 if(hdr_cust_group_code.equals("") || hdr_cust_group_code.equals("null")) 
					 {
						 System.err.println("hdr_cust_group_code===============================================================+++++++++"+hdr_cust_group_code);
						 hdr_cust_group_code="";
					 }
					System.err.println("hdr_cust_group_code before 4:: "+hdr_cust_group_code);				
					
					String hdr_cust_code=hdrList.hasMoreTokens()?hdrList.nextToken():"";//				
					System.err.println("hdr_cust_code 5 before:: "+hdr_cust_code);//==>>
					if(hdr_cust_code.equals("") || hdr_cust_code.equals("null")  ) hdr_cust_code="";
					System.err.println("hdr_cust_code 5:: "+hdr_cust_code);//==>>		
					
					String hdr_deposit_amt=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					 System.err.println("hdr_deposit_amt 6::before "+hdr_deposit_amt);//==>>
					if(hdr_deposit_amt.equals("") || hdr_deposit_amt.equals("null")) hdr_deposit_amt="";
					System.err.println("hdr_deposit_amt 6:: "+hdr_deposit_amt);//==>>

					String hdr_prac_code=hdrList.hasMoreTokens()?hdrList.nextToken():"";//					
					if(hdr_prac_code.equals("") || hdr_prac_code.equals("null") ) hdr_prac_code="";				
					System.err.println("hdr_prac_code 7:: "+hdr_prac_code);

					String hdr_userid=hdrList.hasMoreTokens()?hdrList.nextToken():"";//				
					if(hdr_userid.equals("") || hdr_userid.equals("null") ) hdr_userid="";
					System.err.println("hdr_userid 8:: "+hdr_userid);				
					
					String hdr_ws_no=hdrList.hasMoreTokens()?hdrList.nextToken():"";//				
					if(hdr_ws_no.equals("") || hdr_ws_no.equals("null") ) hdr_ws_no="";
					System.err.println("hdr_ws_no 9:: "+hdr_ws_no);				
					
					String hdr_visit_id=hdrList.hasMoreTokens()?hdrList.nextToken():"";//*not in fd
					if(hdr_visit_id.equals("") || hdr_visit_id.equals("null") ) hdr_visit_id="";
					System.err.println("hdr_visit_id 10:: "+hdr_visit_id);				
					
					String hdr_episode_id=hdrList.hasMoreTokens()?hdrList.nextToken():"";//			
					if(hdr_episode_id.equals("") || hdr_episode_id.equals("null") ) hdr_episode_id="";
					System.err.println("hdr_episode_id 11:: "+hdr_episode_id);
					
					String hdr_episode_type=hdrList.hasMoreTokens()?hdrList.nextToken():"";//				
					if(hdr_episode_type.equals("") || hdr_episode_type.equals("null") ) hdr_episode_type="";
					System.err.println("hdr_episode_type 12:: "+hdr_episode_type);
					
					String isAdhocDiscountMod=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(isAdhocDiscountMod.equals("") || isAdhocDiscountMod.equals("null") ) isAdhocDiscountMod="N";
					System.err.println("isAdhocDiscountMod 13:: "+isAdhocDiscountMod);				
					
					String adhocDiscString=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(adhocDiscString.equals("") || adhocDiscString.equals("null") ) adhocDiscString="";
					System.err.println("adhocDiscString 14:: "+adhocDiscString);	
					
					String isPackageCancelYN=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(isPackageCancelYN == null || isPackageCancelYN.equals("") || isPackageCancelYN.equals("null") ) isPackageCancelYN="N";
					System.err.println("isPackageCancelYN 15:: "+isPackageCancelYN);

					String cancelPkgReasonCode=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(cancelPkgReasonCode.equals("") || cancelPkgReasonCode.equals("null") ) cancelPkgReasonCode="";
					System.err.println("cancelPkgReasonCode 16:: "+cancelPkgReasonCode);	

					String isEncounterAssYN=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(isEncounterAssYN.equals("") || isEncounterAssYN.equals("null") ) isEncounterAssYN="N";
					System.err.println("isEncounterAssYN 17:: "+isEncounterAssYN);				
					
					String encAssString=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(encAssString == null || encAssString.equals("") || encAssString.equals("null") ) encAssString="";
					System.err.println("encAssString 18:: "+encAssString);					
					
					String isEncounterDeAssYN=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(isEncounterDeAssYN.equals("") || isEncounterDeAssYN.equals("null") ) isEncounterDeAssYN="N";
					System.err.println("isEncounterDeAssYN 19:: "+isEncounterDeAssYN);		

					String isCancelUnProcessOrdersYN=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(isCancelUnProcessOrdersYN.equals("") || isCancelUnProcessOrdersYN.equals("null") ) isCancelUnProcessOrdersYN="N";
					System.err.println("isCancelUnProcessOrdersYN 20:: "+isCancelUnProcessOrdersYN);	

					String effDateAuthStr=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(effDateAuthStr.equals("") || effDateAuthStr.equals("null") ) effDateAuthStr="";
					System.err.println("effDateAuthStr 21:: "+effDateAuthStr);	

					String adhocDiscAuthStr=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(adhocDiscAuthStr.equals("") || adhocDiscAuthStr.equals("null") ) adhocDiscAuthStr="";
					System.err.println("adhocDiscAuthStr 22:: "+adhocDiscAuthStr);

					String cnclPackAuthStr=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(cnclPackAuthStr.equals("") || cnclPackAuthStr.equals("null") ) cnclPackAuthStr="";
					System.err.println("cnclPackAuthStr 23:: "+cnclPackAuthStr);

					String assDeassAuthStr=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(assDeassAuthStr.equals("") || assDeassAuthStr.equals("null") ) assDeassAuthStr="";
					System.err.println("assDeassAuthStr 24:: "+assDeassAuthStr);

					String hdr_temp=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(hdr_temp.equals("") || hdr_temp.equals("null") ) hdr_temp="N";
					System.err.println("hdr_temp 25:: "+hdr_temp);	
					
					String db_eff_from_date=hdrList.hasMoreTokens()?hdrList.nextToken():"";//
					if(db_eff_from_date.equals("") || db_eff_from_date.equals("null") ) db_eff_from_date="";
					System.err.println("db_eff_from_date 26:: "+db_eff_from_date);					
					
					String isEffDateMod = "N"; 
					
					if(!"".equals(db_eff_from_date) && !db_eff_from_date.equals(hdr_eff_from_date)) isEffDateMod = "Y";
					System.err.println("isEffDateMod in dtl:: "+isEffDateMod);
				
					if("Y".equals(isEffDateMod) && inserted && !"".equals(effDateAuthStr)){
						try{
							System.err.println("effDateAuthStr inside insert dtls:"+effDateAuthStr);
							String[] effDateAuthStrArr = effDateAuthStr.split("##");
							String authUserID = effDateAuthStrArr[0];
							String authResnCode = effDateAuthStrArr[1];
							String isSelfAuth = effDateAuthStrArr[2];
							
							String sqlInsertforAuth = "insert into bl_package_authorized_audit(patient_id, package_code, package_seq_no, privilege_id, Authorized_User_ID, Reason_Code, Authorized_Date, self_authorized_yn) values(?, ?, ?, ?, ?, ?, sysdate, ?)";
							
							pstmt	= con.prepareStatement(sqlInsertforAuth);
							pstmt.setString(1, patientid);
							pstmt.setString(2, hdr_package_code);
							pstmt.setInt(3, hdrpackageseqno);
							pstmt.setString(4, "EFF_DATE");
							pstmt.setString(5, authUserID);
							pstmt.setString(6, authResnCode);
							pstmt.setString(7, isSelfAuth);
							
							int result = pstmt.executeUpdate();
							if (result != 0)
								inserted = true;
							else
								inserted = false;

							if (pstmt != null)
								pstmt.close();
							
						} catch (Exception e) 
						{
							System.err.println("Exception in Effective Date Auth=" + e.toString());
							e.printStackTrace();
							inserted = false;
						} 
					}

					if("Y".equals(isAdhocDiscountMod) && inserted && !"".equals(adhocDiscAuthStr)){
						try{
							System.err.println("adhocDiscAuthStr inside pkg details:"+adhocDiscAuthStr);
							String[] adhocDiscAuthStrArr = adhocDiscAuthStr.split("##");
							String authUserID = adhocDiscAuthStrArr[0];
							String authResnCode = adhocDiscAuthStrArr[1];
							String isSelfAuth = adhocDiscAuthStrArr[2];
							
							String sqlInsertforAuth = "insert into bl_package_authorized_audit(patient_id, package_code, package_seq_no, privilege_id, Authorized_User_ID, Reason_Code, Authorized_Date, self_authorized_yn) values(?, ?, ?, ?, ?, ?, sysdate, ?)";
							
							pstmt	= con.prepareStatement(sqlInsertforAuth);
							pstmt.setString(1, patientid);
							pstmt.setString(2, hdr_package_code);
							pstmt.setInt(3, hdrpackageseqno);
							pstmt.setString(4, "ADHOC_DISCOUNT");
							pstmt.setString(5, authUserID);
							pstmt.setString(6, authResnCode);
							pstmt.setString(7, isSelfAuth);
							
							int result = pstmt.executeUpdate();
							if (result != 0)
								inserted = true;
							else
								inserted = false;

							if (pstmt != null)
								pstmt.close();
							
						} catch (Exception e) 
						{
							System.err.println("Exception in adhoc discount authorization in dtls=" + e.toString());
							e.printStackTrace();
							inserted = false;
						} 
					}
					
					if("Y".equals(isPackageCancelYN) && inserted && !"".equals(cnclPackAuthStr)){
						try{
							System.err.println("cnclPackAuthStr dtls inside insert:"+cnclPackAuthStr);
							String[] cnclPackAuthStrArr = cnclPackAuthStr.split("##");
							String authUserID = cnclPackAuthStrArr[0];
							String authResnCode = cnclPackAuthStrArr[1];
							String isSelfAuth = cnclPackAuthStrArr[2];
							
							String sqlInsertforAuth = "insert into bl_package_authorized_audit(patient_id, package_code, package_seq_no, privilege_id, Authorized_User_ID, Reason_Code, Authorized_Date, self_authorized_yn) values(?, ?, ?, ?, ?, ?, sysdate, ?)";
							
							pstmt	= con.prepareStatement(sqlInsertforAuth);
							pstmt.setString(1, patientid);
							pstmt.setString(2, hdr_package_code);
							pstmt.setInt(3, hdrpackageseqno);
							pstmt.setString(4, "CANCEL_PACKAGE");
							pstmt.setString(5, authUserID);
							pstmt.setString(6, authResnCode);
							pstmt.setString(7, isSelfAuth);
							
							int result = pstmt.executeUpdate();
							if (result != 0)
								inserted = true;
							else
								inserted = false;

							if (pstmt != null)
								pstmt.close();
							
						} catch (Exception e) 
						{
							System.err.println("Exception in cancel package authorization in dtls=" + e.toString());
							e.printStackTrace();
							inserted = false;
						}
					}
					
					if( ( ("Y".equals(isEncounterAssYN) && !"".equals(encAssString)) || "Y".equals(isEncounterDeAssYN)) && inserted && !"".equals(assDeassAuthStr) ) {
						try{
							System.err.println("assDeassAuthStr inside insert:"+assDeassAuthStr);
							String priv_code = "";
							if("Y".equals(isEncounterAssYN)){
								priv_code = "ASSOCIATE_PACKAGE";
							} else if("Y".equals(isEncounterDeAssYN)){
								priv_code = "DEASSOCIATE_PACKAGE";
							}
							String[] assDeassAuthStrArr = assDeassAuthStr.split("##");
							String authUserID = assDeassAuthStrArr[0];
							String authResnCode = assDeassAuthStrArr[1];
							String isSelfAuth = assDeassAuthStrArr[2];
							
							String sqlInsertforAuth = "insert into bl_package_authorized_audit(patient_id, package_code, package_seq_no, privilege_id, Authorized_User_ID, Reason_Code, Authorized_Date, self_authorized_yn) values(?, ?, ?, ?, ?, ?, sysdate, ?)";
							
							pstmt	= con.prepareStatement(sqlInsertforAuth);
							pstmt.setString(1, patientid);
							pstmt.setString(2, hdr_package_code);
							pstmt.setInt(3, hdrpackageseqno);
							pstmt.setString(4, priv_code);
							pstmt.setString(5, authUserID);
							pstmt.setString(6, authResnCode);
							pstmt.setString(7, isSelfAuth);
							
							int result = pstmt.executeUpdate();
							if (result != 0)
								inserted = true;
							else
								inserted = false;

							if (pstmt != null)
								pstmt.close();
							
						} catch (Exception e) 
						{
							System.err.println("Exception in Associate package authorization in dtls=" + e.toString());
							e.printStackTrace();
							inserted = false;
						}
					}
				}
			}
			// Privilege audit for details gets inserted when either dtls or excl dtls gets I/M/D
			System.err.println("isAnyDtlsRecMod:"+isAnyDtlsRecMod);
			System.err.println("isAnyDtlsExclRecMod:"+isAnyDtlsExclRecMod);
			System.err.println("pkgServDtlsAuthStr:"+pkgServDtlsAuthStr);
			System.err.println("inserted:"+inserted);
			if((isAnyDtlsRecMod > 0 || isAnyDtlsExclRecMod > 0) && inserted && !"".equals(pkgServDtlsAuthStr)){
				try
				{
					String[] pkgServDtlsAuthStrArr = pkgServDtlsAuthStr.split("##");
					String authUserID = pkgServDtlsAuthStrArr[0];
					String authResnCode = pkgServDtlsAuthStrArr[1];
					String isSelfAuth = pkgServDtlsAuthStrArr[2];
					
					String sqlInsertforAuth = "insert into bl_package_authorized_audit(patient_id, package_code, package_seq_no, privilege_id, Authorized_User_ID, Reason_Code, Authorized_Date, self_authorized_yn) values(?, ?, ?, ?, ?, ?, sysdate, ?)";
					
					pstmt	= con.prepareStatement(sqlInsertforAuth);
					pstmt.setString(1, patientid);
					pstmt.setString(2, gbl_package_code);
					pstmt.setInt(3, gbl_pack_seq_no);
					pstmt.setString(4, "PKG_SERV_DTLS");
					pstmt.setString(5, authUserID);
					pstmt.setString(6, authResnCode);
					pstmt.setString(7, isSelfAuth);
					
					int result = pstmt.executeUpdate();
					if (result != 0)
						inserted = true;
					else
						inserted = false;

					if (pstmt != null)
						pstmt.close();
							
				} catch (Exception e) 
				{
					System.err.println("Exception in Package Details authorization=" + e.toString());
					e.printStackTrace();
					inserted = false;
				}
			}
			
			/* ************************************ Authorization Audit Ends ********************************* */
//for end
			/*
			if(inserted){					
				System.err.println("Calling RECALCULATEPACKAGE JOB Procedure in dtl:"+str_facility_id+"/"+patientid+"/"+gbl_pack_seq_no+"/"+str_user_id+"/"+str_client_ip_address);
				
				String qryrecalcpkg = "{ call BLPACKAGE.recalculatepackage_for_job(?,?,?,?,?,?,?,?,?,?,?,?)}";
				call = con.prepareCall(qryrecalcpkg);	
				call.setString(1,str_facility_id);
				call.setString(2,patientid);
				call.setString(3,"EBL_TRAN_PACKAGE_MAINTAIN");
				call.setInt(4,gbl_pack_seq_no); // in a single transaction only one package seq related details can be saved, so can take the seq from inside loop and use 
				call.setString(5,str_user_id);
				call.setString(6,str_client_ip_address);
				call.registerOutParameter(7,java.sql.Types.VARCHAR);
				call.registerOutParameter(8,java.sql.Types.VARCHAR);
				call.registerOutParameter(9,java.sql.Types.VARCHAR);
				call.setString(10,str_episode_type);
				call.setString(11,str_episode_id);					
				call.setString(12,str_visit_id);
				
				call.execute();
				
				str_error_level = call.getString(7);		
				if(str_error_level == null) str_error_level="";
				
				str_sys_message_id = call.getString(8);		
				if(str_sys_message_id == null) str_sys_message_id="";
				
				str_error_text = call.getString(9);		
				if(str_error_text == null) str_error_text="";
				
				System.err.println("****str_error_level hdr 1011:"+str_error_level);
				System.err.println("****str_sys_message_id 1012:"+str_sys_message_id);
				System.err.println("****str_error_text 1013:"+str_error_text);

				call.close();
				
				if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
				{
					if(!str_error_level.equals("") && !str_error_text.equals(""))
					{
						System.err.println("str_error_level dtl in recalculation msg");
						out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
						System.err.println("****Inside hdr Error Text Loop 950");
						inserted = false;
						//inserted_rec = false;
					}
					else if(!str_sys_message_id.equals(""))
					{
						System.err.println("sysid in dtl recalculation msg");
						messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
						msg=(String)messageHashtable.get("message");
						System.err.println("sysid in dtl recalculation msg="+msg);
						//out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) );
						
						System.err.println("****Inside Sys Message Loop ");
						inserted = false;
						//inserted_rec = false;
					}
				}
				else
				{
					System.err.println("****Inside Rec Success Loop recalculation-dtl");
					inserted = true;
					//inserted_rec = true;
				}	
			}
			*/
			String error_value="0";
			if(inserted )
			{
				
			//out.println("<script>alert('success')</script>");				
				//out.println("<script>window.close();</script>");				
				error_value = "1" ;		
				con.commit();
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(success_msg,"UTF-8"  )+"&err_value="+error_value );		

		//	res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value="+error_value);
			
			/*	con.commit();
				System.err.println(" 927 ");
//				String final_message=gen_receipt+" "+final_msg_doc_type_code;

//				out.println("<script>alert('"+final_message+"')</script>");
				out.println("<script>alert('operation completed sucessfully')</script>");
				out.println("<script>window.close();</script>");
				*/
			}
			else
			{
				con.rollback();
				if(!str_error_level.equals("") && !str_error_text.equals(""))
				{
				/*	System.err.println("str_error_level in blmaintreatpkg msg");
					out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
					*/
				}
				else if(!str_sys_message_id.equals(""))
				{
				/*	System.err.println("sysid in blmaintreatpkg msg");
					messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
					msg=(String)messageHashtable.get("message");
					System.err.println("sysid in blmaintreatpkg msg="+msg);
				//	out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) );
					*/
				}

				if(!sys_error.equals(""))
				{
					System.err.println("sys_error in blmaintreatpkg msg");
					out.println("<script>parent.parent.frames(0).location.href='../eCommon/jsp/commonToolbar.jsp?"+str_query_string+"';parent.parent.frames(2).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( sys_error.toString(), "UTF-8" )+ "<br>'</script>");
					System.err.println("syserr in blmaintreatpkg");
				}
			}
			ConnectionManager.returnConnection(con, req);
		} //main try
		catch (Exception e) 
		{
			System.err.println("exception in blmaintreatpkg=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() + sb.toString());
			out.println("Values sent are : <br>");
		} 
	}
		
	
}

