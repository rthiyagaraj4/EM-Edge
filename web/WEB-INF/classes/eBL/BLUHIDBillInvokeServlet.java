/**
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           Mohana Priya K
 */
 
package eBL;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.PersistenceHelper;
import com.ehis.util.DateUtils;
//import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

import eCommon.Common.CommonBean;
import eBL.BLInsuranceImageBean;
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
//import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BLUHIDBillInvokeServlet
 */


public class BLUHIDBillInvokeServlet extends javax.servlet.http.HttpServlet 
{
	//private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException 
	{
	//	super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	// TODO Auto-generated method stub
	
	Connection con=null;
	CallableStatement statement = null;
	Hashtable results = new Hashtable();
	Hashtable messageHashtable = new Hashtable();
	PrintWriter out;
	HttpSession httpsession = request.getSession(false);
	String sStyle = request.getParameter("sStyle") != null ? request.getParameter("sStyle") : "IeStyle.css";
	out = response.getWriter();
	Statement st = null;
	ResultSet rs = null;
	Properties p;
	String locale;
	String mode="I";
	p = (Properties)httpsession.getValue("jdbc");
	locale = p.getProperty("LOCALE");
	String AddedAtWsNo = p.getProperty("client_ip_address");
	String added_by_id = p.getProperty("login_user");
	String modifiedAtWsNo = p.getProperty("client_ip_address");
	String modifiedById = p.getProperty("login_user");
	String facility_id = (String)httpsession.getValue("facility_id");
	String patient_id=request.getParameter("patient_id");
	String strFunctionId =request.getParameter("function_id");
	String str_pat_ser_code =request.getParameter("str_pat_ser_code");
	String module_id = request.getParameter("module_id");
	
	boolean insertable = true;
	String proc_success = "N";
	String strNull = "";
	String str_blng_grp = "";		

	String str_ins_cust_priority = "";
	String str_ins_policy_type_code = "";
	String str_ins_policy_no = "";
	String str_ins_policy_start_date = "";
	String str_ins_policy_expiry_date = "";
	String str_ins_credit_auth_ref = "";
	String str_ins_credit_auth_date = "";
	String str_ins_credit_approval_days = "";
	String str_ins_credit_approval_amount = "";
	String str_ins_policy_eff_from_date = "";
	String str_ins_policy_eff_to_date = "";
	String str_non_ins_blng_grp = "";
	String str_non_ins_cust_group_code = "";
	String str_non_ins_cust_code = "";
	String str_cust_group_code = "";
	String str_cust_code = "";
	String err_level = "";
	String sys_message_id = "";
	String err_text = "";
	String episode_type="R";
	int noofdecimal = 2;
	
	HashMap hosp_dtls = null;
	String hosp_serv_panel_ind = "";
	String hosp_serv_panel_code = "";
	String hosp_serv_panel_str = "";
	String hosp_serv_panel_qty = "1.0";
	String hosp_serv_charge_amt = "";
	String strNewHospChrgCreate = "Y";
	String str_pat_reg_charged_YN = "N";
	String str_total_chrg_amt = "";
	String str_total_pat_chrg_amt = "";
	double total_chrg_amt = 0.0;
	double total_pat_chrg_amt = 0.0;
	String hosp_charge_YN = "";
	double hosp_chrg_amt = 0.0;
	double hosp_chrg_pat_amt = 0.0;
	String str_hosp_chrg_amt = "";
	String str_hosp_chrg_pat_amt = "";
	String strFinalMessage = "";
	String bill_gen_yn = "";
	String bill_doc_type = "";
	String bill_doc_number = "";
	String str_bill_later_YN = "N";
	String str_bill_gen_later = "N";
	String str_total_bill_amt = "";
	String str_bill_prt_format_YN = "N";
	String str_bill_prt_format_vals = "";
	String pgm_id = "";
	String session_id = "";
	String pgm_date = "";
	String mpi_id_rep = "";

	try 
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession(false);
		PreparedStatement pstmt=null;
		ResultSet rsm=null;
		con = ConnectionManager.getConnection(request);			
			
	try {
			String bill_gen_later_YN_qry = "select nvl(ADHOC_DISCOUNT_ALLOWED_YN,'N') from  bl_parameters where operating_facility_id='"
			+facility_id+ "'";
			st = con.createStatement();
			rs = st.executeQuery(bill_gen_later_YN_qry);
			if (rs != null) {
				while (rs.next()) {
				str_bill_later_YN = rs.getString(1);
				}
			}
			if (str_bill_later_YN == null)
				str_bill_later_YN = "N";
				st.close();
				if (rs != null)
				rs.close();
		} catch (Exception e) {
			System.out.println("Exception in bill_gen_later_YN_qry Query="+ e.toString());
			e.printStackTrace();
		}			

	try{		
			String sql="SELECT NVL (a.blng_grp_id, ' ') blng_grp_id, NVL (a.cust_group_code, ' ') cust_group_code, NVL (a.cust_code, ' ') cust_code,NVL (TO_CHAR (a.priority), ' ') priority, NVL (a.policy_type_code, ' ') policy_type_code,NVL (a.policy_number, ' ') policy_number, NVL (TO_CHAR (a.policy_start_date, 'dd/mm/yyyy'),' '  ) policy_start_date, NVL (TO_CHAR (a.policy_expiry_date, 'dd/mm/yyyy'), ' ' ) policy_expiry_date,NVL (a.credit_auth_ref, ' ') credit_auth_ref, NVL (TO_CHAR (a.credit_auth_date, 'dd/mm/yyyy'), ' ' ) credit_auth_date,  NVL (TO_CHAR (a.effective_from, 'dd/mm/yyyy'), ' ') effective_from, NVL (TO_CHAR (a.effective_to, 'dd/mm/yyyy'), ' ') effective_to, NVL (TO_CHAR (a.approved_amt), ' ') approved_amt, NVL (TO_CHAR (a.approved_days), ' ') approved_days,  b.non_ins_blng_grp_id, b.non_ins_cust_group_code,  b.non_ins_cust_code   FROM bl_encounter_payer_priority a, bl_patient_fin_dtls b WHERE a.operating_facility_id = DECODE ('R','R', a.operating_facility_id,'"+facility_id+"') AND a.episode_type ='R'   AND a.patient_id = '"+patient_id+"' AND a.patient_id = b.patient_id  AND a.acct_seq_no = b.cur_acct_seq_no ORDER BY A.priority ";
			pstmt= con.prepareStatement(sql);
			
			rsm = pstmt.executeQuery() ;
			while( rsm.next() )
			{				
				str_blng_grp = rsm.getString("blng_grp_id");
				str_cust_code = rsm.getString("cust_code");
				str_cust_group_code = rsm.getString("cust_group_code");						
				str_ins_policy_type_code=rsm.getString("policy_type_code");	
				str_ins_policy_no = rsm.getString("policy_number");
				str_ins_policy_start_date = rsm.getString("policy_start_date");
				str_ins_policy_expiry_date = rsm.getString("policy_expiry_date");
				str_ins_credit_auth_ref = rsm.getString("credit_auth_ref");
				str_ins_credit_auth_date = rsm.getString("credit_auth_date");
				str_non_ins_blng_grp = rsm.getString("non_ins_blng_grp_id");
				str_non_ins_cust_group_code = rsm.getString("non_ins_cust_group_code");
				str_non_ins_cust_code = rsm.getString("non_ins_cust_code");
				str_ins_cust_priority = rsm.getString("priority");
				str_ins_policy_eff_from_date = rsm.getString("effective_from");
				str_ins_policy_eff_to_date = rsm.getString("effective_to");
				str_ins_credit_approval_amount = rsm.getString("APPROVED_AMT");
				str_ins_credit_approval_days = rsm.getString("approved_days");
				
				if (str_non_ins_blng_grp == null)
						str_non_ins_blng_grp = "";
					
					if (str_non_ins_cust_group_code == null)
						str_non_ins_cust_group_code = "";				
					}
			}			
			catch(Exception ex){				
				ex.printStackTrace();
				System.out.println("UHID"+ex);
			}
			//Added against V210416
			finally{			
				if(pstmt != null) pstmt.close();
				if(con!=null) con.close();
				if(rsm!=null) rsm.close();	
			}
			
		if (hosp_dtls == null) {
			try {
					String main_blng_grp_id = "";
					String main_cust_grp_code = "";
					String main_cust_code = "";
				
					main_blng_grp_id = str_blng_grp;
					main_cust_grp_code = str_cust_group_code;
					main_cust_code = str_cust_code;			

					CallableStatement call = con.prepareCall("{ call BLPATIENTREGNCHARGE.GETPATREGNSERVDTL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

					call.setString(1, facility_id);
					call.setString(2, str_pat_ser_code);// P_pat_ser_grp_code
					call.setString(3, str_blng_grp);
					call.setString(4, str_cust_group_code);
					call.setString(5, str_cust_code);

					call.registerOutParameter(6,java.sql.Types.VARCHAR);
					call.registerOutParameter(7,java.sql.Types.VARCHAR);
					call.registerOutParameter(8,java.sql.Types.VARCHAR);
					call.registerOutParameter(9,java.sql.Types.VARCHAR);
					call.registerOutParameter(10,java.sql.Types.VARCHAR);
					call.registerOutParameter(11,java.sql.Types.VARCHAR);
					call.registerOutParameter(12,java.sql.Types.VARCHAR);
					call.registerOutParameter(13,java.sql.Types.VARCHAR);
					call.registerOutParameter(14,java.sql.Types.VARCHAR);
					
					call.execute();
					
					String regn_charge_YN = call.getString(6);
					if (regn_charge_YN == null)
						regn_charge_YN = "N";

					String regn_charge_dur_enc_YN = call
							.getString(7);
					if (regn_charge_dur_enc_YN == null)
						regn_charge_dur_enc_YN = "N";

					hosp_serv_panel_ind = call.getString(8);
					if (hosp_serv_panel_ind == null)
						hosp_serv_panel_ind = "";
					hosp_serv_panel_code = call.getString(9);
					if (hosp_serv_panel_code == null)
						hosp_serv_panel_code = "";

					err_level = call.getString(10);
					sys_message_id = call.getString(11);
					err_text = call.getString(12);

					if (err_level == null)
						err_level = "";
					if (sys_message_id == null)
						sys_message_id = "";
					if (err_text == null)
						err_text = "";

					call.close();

					if ((!sys_message_id.equals(""))
							|| (err_level.equals("10") && !err_text
									.equals(""))) {
						insertable = false;
						proc_success = "N";

					out.println("Y"+"::"+sys_message_id+"::"+err_text);
						call.close();
					} else {
						proc_success = "Y";
					}
					sys_message_id = "";
					err_level = "";
					err_text = "";

					call.close();
			} catch (Exception e) {
				insertable = false;
				System.err.println("Exception in GET_VISIT_RULE_BY_CLINIC:"+ e);
				e.printStackTrace();
				}
			}		
		
	if(insertable){		
		String sql_pat_reg = "{call BLPatientRegnCharge.Main('"
		+ mode
		+ "','"
		+ strFunctionId
		+ "','"
		+ facility_id
		+ "','"
		+ module_id
		+ "','"
		+ patient_id
		+ "','"
		+ str_pat_ser_code
		+ "','"
		+ episode_type
		+ "',sysdate,'"
		+ strNull
		+ "','"
		+ strNull
		+ "','"
		+ str_blng_grp
		+ "','"
		+ str_cust_group_code
		+ "','"
		+ str_cust_code
		+ "','"
		+ str_ins_policy_type_code
		+ "','"
		+ str_ins_cust_priority
		+ "','"
		+ str_ins_policy_no
		+ "','"
		+ str_ins_policy_start_date
		+ "','"	
		+ str_ins_policy_expiry_date
		+ "','"
		+ str_ins_credit_auth_ref
		+ "','"
		+ str_ins_credit_auth_date
		+ "','"
		+ str_ins_policy_eff_from_date
		+ "','"
		+ str_ins_policy_eff_to_date
		+ "','"
		+ str_ins_credit_approval_amount
		+ "','"
		+ str_ins_credit_approval_days
		+ "','"
		+ str_non_ins_blng_grp
		+ "','"
		+ str_non_ins_cust_group_code
		+ "','"
		+ str_non_ins_cust_code
		+ "','"
		+ strNewHospChrgCreate
		+ "','"
		+ hosp_serv_panel_ind
		+ "','"
		+ hosp_serv_panel_code
		+ "','"
		+ hosp_serv_panel_str
		+ "','"
		+ hosp_serv_panel_qty
		+ "','"
		+ hosp_serv_charge_amt
		+ "','"
		+ str_bill_later_YN
		+ "','"
		+ added_by_id
		+ "','"
		+ AddedAtWsNo
		+ "','"
		+ AddedAtWsNo
		+ "','"
		+ strNull
		+ "','"
		+ strNull
		+ "','"
		+ locale
		+ "',?,'"
		+ strNull
		+ "','"
		+ strNull
		+ "','"
		+ strNull
		+ "','"
		+ strNull
		+ "','"
		+ strNull
		+ "',?,?,?,?,?,?,?,?,?,?,?,?)}";
		// System.err.println("sql:"+sql_pat_reg);
		statement = con.prepareCall(sql_pat_reg);

		statement.setString(1, "Y");

		statement.registerOutParameter(1,java.sql.Types.VARCHAR);
		statement.registerOutParameter(2,java.sql.Types.VARCHAR);
		statement.registerOutParameter(3,java.sql.Types.VARCHAR);
		statement.registerOutParameter(4,java.sql.Types.VARCHAR);
		statement.registerOutParameter(5,java.sql.Types.VARCHAR);
		statement.registerOutParameter(6,java.sql.Types.VARCHAR);
		statement.registerOutParameter(7,java.sql.Types.VARCHAR);
		statement.registerOutParameter(8,java.sql.Types.VARCHAR);
		statement.registerOutParameter(9,java.sql.Types.VARCHAR);
		statement.registerOutParameter(10,java.sql.Types.VARCHAR);
		statement.registerOutParameter(11,java.sql.Types.VARCHAR);
		statement.registerOutParameter(12,java.sql.Types.VARCHAR);
		statement.registerOutParameter(13,java.sql.Types.VARCHAR);

		statement.execute();

		insertable = true;

		hosp_charge_YN = statement.getString(1);
		if (hosp_charge_YN == null
				|| hosp_charge_YN.equals(""))
			hosp_charge_YN = "N";

		str_hosp_chrg_amt = statement.getString(2);
		if (str_hosp_chrg_amt == null
				|| str_hosp_chrg_amt.equals(""))
			str_hosp_chrg_amt = "0.0";
		hosp_chrg_amt = Double
				.parseDouble(str_hosp_chrg_amt);

		str_hosp_chrg_pat_amt = statement.getString(3);
		if (str_hosp_chrg_pat_amt == null
				|| str_hosp_chrg_pat_amt.equals(""))
			str_hosp_chrg_pat_amt = "0.0";
		hosp_chrg_pat_amt = Double
				.parseDouble(str_hosp_chrg_pat_amt);

		bill_gen_yn = statement.getString(4);
		if (bill_gen_yn == null)
			bill_gen_yn = "N";
		bill_doc_type = statement.getString(5);
		if (bill_doc_type == null)
			bill_doc_type = "";
		bill_doc_number = statement.getString(6);
		if (bill_doc_number == null)
			bill_doc_number = "";
		str_bill_gen_later = statement.getString(7);
		if (str_bill_gen_later == null
				|| str_bill_gen_later.equals(""))
			str_bill_gen_later = "N";
		str_total_bill_amt = statement.getString(8);
		if (str_total_bill_amt == null
				|| str_total_bill_amt.equals(""))
			str_total_bill_amt = "";

		str_bill_prt_format_YN = statement.getString(9);
		if (str_bill_prt_format_YN == null
				|| str_bill_prt_format_YN.equals(""))
			str_bill_prt_format_YN = "N";

		str_bill_prt_format_vals = statement.getString(10);
		if (str_bill_prt_format_vals == null
				|| str_bill_prt_format_vals.equals(""))
			str_bill_prt_format_vals = "";

		err_level = statement.getString(11);
		sys_message_id = statement.getString(12);
		err_text = statement.getString(13);

		if (err_level == null)
			err_level = "";
		if (sys_message_id == null)
			sys_message_id = "";
		if (err_text == null)
			err_text = "";

		total_chrg_amt = hosp_chrg_amt;
		total_pat_chrg_amt = hosp_chrg_pat_amt;

		str_total_chrg_amt = String.valueOf(total_chrg_amt);
		str_total_pat_chrg_amt = String
				.valueOf(total_pat_chrg_amt);

		if (total_chrg_amt > 0)
			str_pat_reg_charged_YN = "Y";
		else
			str_pat_reg_charged_YN = "N";

		try {
			CurrencyFormat cf1 = new CurrencyFormat();

			if (str_hosp_chrg_amt != null)
				str_hosp_chrg_amt = cf1.formatCurrency(
						str_hosp_chrg_amt, noofdecimal);

			if (str_total_chrg_amt != null)
				str_total_chrg_amt = cf1.formatCurrency(
						str_total_chrg_amt, noofdecimal);

			if (str_total_pat_chrg_amt != null)
				str_total_pat_chrg_amt = cf1.formatCurrency(
								str_total_pat_chrg_amt,
								noofdecimal);

			if (str_hosp_chrg_pat_amt != null)
				str_hosp_chrg_pat_amt = cf1.formatCurrency(
						str_hosp_chrg_pat_amt, noofdecimal);
		}catch(Exception e){					
				e.printStackTrace();
				System.out.println("Exception in UHIDBillInvokeServlet"+e);
			}
			if ((!sys_message_id.equals(""))
					|| (err_level.equals("10") && !err_text
							.equals(""))) {
				insertable = false;
				proc_success = "N";
				con.rollback();
				out.println("Y"+"::"+sys_message_id+"::"+err_text);			
			} else {
				proc_success = "Y";
				
				String allowCloseRegnBillGeneration = BLReportIdMapper.allowCloseRegnBillGeneration(facility_id);
				out.println("N"+"::"+str_bill_gen_later+"::"+str_blng_grp+"::"+"OTH_MOD"+patient_id+"::"+module_id+"::"+bill_doc_type+"::"+bill_doc_number);
				con.commit();
			}
			sys_message_id = "";
			err_level = "";
			err_text = "";				
		}	
	}catch(Exception e){			
			e.printStackTrace();
			System.out.println("Exception in UHIDBillInvokeServlet"+e);
		}		
	}	
}
