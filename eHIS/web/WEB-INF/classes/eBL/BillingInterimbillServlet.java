/*
Sr No           Version             Incident			SCF/CRF              Developer Name
1               V201218             IN73702         MMS-DM-CRF-0100.1      Palani Narayanan
2               V210228				15233			MMS-DM-CRF-0100.1      Ram kumar S
*/

package eBL;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Arrays;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.PersistenceHelper;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class BillingInterimbillServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId = "";
	String client_ip_address = "";
	String login_user = "";
	String slmt_ind = "", adm_rec_flag = "";
	String locale = "";
	HashMap tabdata = null;
	HttpSession session;
	String mode = "";
	String tab = null;
	String bean_id = null;
	String bean_name = null;
	String operation = "";
	String sysdate = "";
	String auth_date = "";
	String added_date = "";
	public String episode_type = ""; //Added V210228
	Connection con = null;
	PreparedStatement pstmt = null;
	// ResultSet rst = null;
	ResultSet rs = null;

	public  String authorizedUserName="";
	public BillingInterimbillServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside dopost method");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		session = request.getSession(false);
		authorizedUserName=request.getParameter("authorizedUserId");
		episode_type = request.getParameter("episodeType"); // Added V210228
		this.p = (java.util.Properties) session.getValue("jdbc");
		facilityId = (String) session.getValue("facility_id");
		System.err.println("facilityId===>>71" + facilityId);
		client_ip_address = checkForNull(this.p.getProperty("client_ip_address"));
		if (client_ip_address.equals(null))
			client_ip_address = "";
		login_user = checkForNull(this.p.getProperty("login_user"));
		if (login_user.equals(null))
			login_user = "";
		locale = this.p.getProperty("LOCALE");
		con = ConnectionManager.getConnection();
		try {

			String sqlsysdate = "select to_char(sysdate, 'DD/MM/YYYY')  sysday from dual";
			pstmt = con.prepareStatement(sqlsysdate);

			rs = pstmt.executeQuery();

			if (rs != null) {

				if (rs.next()) {

					added_date = rs.getString("sysday");
				}
			}

			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (added_date == null || added_date == null) {
				added_date = "";
			}
		} catch (Exception ws) {
			System.out.println("date exp" + ws);
			ws.printStackTrace();
		}

		try {
			String sqlsysdate1 = "select to_char(sysdate, 'DD/MM/YYYY ') from dual";
			pstmt = con.prepareStatement(sqlsysdate1);
			rs = pstmt.executeQuery();
			if (rs != null) {
				if (rs.next()) {
					auth_date = rs.getString(1);
				}
			}

			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (added_date == null || added_date == null) {
				auth_date = "";
			}
		} catch (Exception ws) {
			System.out.println("date exp" + ws);
			ws.printStackTrace();
		}

		try {
			this.out = response.getWriter();
			tabdata = populateTabData(request, response);
			modifyData(request, response, tabdata);
		} catch (Exception e) {
			out.println("Exception in BillingRecordApprovalServlet - DoPost:: " + e.toString());
			System.out.println("Exception in BillingRecordApprovalServlet - DoPost:: " + e);
		}

	}

	private HashMap populateTabData(HttpServletRequest request, HttpServletResponse response) {
		String srl_no = "";
		String patient_id = "";
		String patient_name = "";
		String episode_id = "";
		String admissiondate = "";
		String policy = "";
		String payer_group = "";
		String payer = "";
		String unbuiledamount = "";
		String billnumber = "";
		String billdate = "";
		String selectall = "";
		String[] arr = null;
		String[] valuesKeys = null;
		String Header_select_all = "";
		int rowCount = 0;
		String facilityId = "";

		String locale = "";
		String episodeType = "";
		String patientName = "";
		String encounterId = "";
		String customerGroupCode = "";
		String customerCode = "";
		String policyCode = "";
		String speciality = "";

		rowCount = Integer.parseInt(request.getParameter("rowCount"));
		//ArrayList<String[]> interimbillDetailsList = null;
		ArrayList preApprovalRequestSpecPatientList = new ArrayList();
		//Set<String> encounterIdset = new HashSet<String>();
		LinkedHashMap recordPreApprovalDataMap = null;
		int index = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String facilityIdnew = request.getParameter("facilityId");
			String finalIndexArr = request.getParameter("finalIndexArr");
			String finalUnselectindex = request.getParameter("finalUnselectindex");
			System.err.println("facilityIdnew " + facilityIdnew);
			Header_select_all = checkForNull(request.getParameter("Header_select_all"));

			locale = (String) session.getAttribute("LOCALE");
			facilityId = (String) session.getValue("facility_id");
			patient_id = checkForNull(request.getParameter("patinetId"));
			patientName = checkForNull(request.getParameter("patientName"));
			episodeType = checkForNull(request.getParameter("episodeType"));

			encounterId = checkForNull(request.getParameter("encounterId"));
			customerGroupCode = checkForNull(request.getParameter("customerGroupCode"));
			customerCode = checkForNull(request.getParameter("customerCode"));
			policyCode = checkForNull(request.getParameter("policyCode"));
			speciality = checkForNull(request.getParameter("speciality"));

			if (Header_select_all.equals("Y")) {
				System.err.println("In Header_select_all " + Header_select_all);
				bean_id = "RecordApprovalPatientDataBean";
				bean_name = "eBL.RecordApprovalPatientDataBean";
				RecordApprovalPatientDataBean recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) PersistenceHelper
						.getBeanObject(bean_id, bean_name, request);
				recordPreApprovalDataMap = recordApprovalPatientDataBean.getrPatSearchValues();
				Iterator iterator = recordPreApprovalDataMap.keySet().iterator();
				rowCount = recordPreApprovalDataMap.size();
				System.err.println("rowCount recordPreApprovalDataMap  " + rowCount);
				tabdata = new HashMap();
				Connection	connection 	= ConnectionManager.getConnection();
				while (iterator.hasNext()) {
					index = (Integer) iterator.next();
					// for(int i=0;i<=rowCount;i++)
					// {
					try {
						recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) recordPreApprovalDataMap
								.get(index);
						arr = new String[30];
						String BilledDate = "";
						String AdmissionDate = "";

						BilledDate = recordApprovalPatientDataBean.getBillDate();
						if (BilledDate != null && !(BilledDate.equals(""))) {
							SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
							SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
							BilledDate = sdf2.format(sdf1.parse(BilledDate));
						}
						AdmissionDate = recordApprovalPatientDataBean.getAdmissionDate();
						if (AdmissionDate != null && !(AdmissionDate.equals(""))) {
							SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
							SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
							AdmissionDate = sdf2.format(sdf1.parse(AdmissionDate));
						}
						// String strIndex=(String)index;

						srl_no = String.valueOf(index);

						patient_id = checkForNull(recordApprovalPatientDataBean.getPatientId());

						patient_name = checkForNull(recordApprovalPatientDataBean.getPatientName());
						episode_id = checkForNull(recordApprovalPatientDataBean.getEpisodeId());
						admissiondate = checkForNull((AdmissionDate));
						payer_group = checkForNull(recordApprovalPatientDataBean.getPayerGroup());
						payer = checkForNull(recordApprovalPatientDataBean.getPayer());
						policy = checkForNull(recordApprovalPatientDataBean.getPolicy());
						unbuiledamount = checkForNull(recordApprovalPatientDataBean.getUnBuiledAmount());
						billnumber = checkForNull(recordApprovalPatientDataBean.getBillNumber());
						billdate = checkForNull(BilledDate);
						selectall = "Y";
						// authorizedUserId =
						// checkForNull(request.getParameter("authorizedUserId"+i));
						String cust_group_name = "";
						String cust_short_name = "";
						String policy_short_desc = "";
						if ((payer_group.equals(null) || payer_group.equals(""))
								|| (payer.equals(null) || payer.equals(""))
								|| (policy.equals(null) || policy.equals(""))) {
							if (payer_group != null || payer_group != "") {
								String cust_grp_desc_qry = "select short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id='"
										+ locale + "' and cust_group_code = '" + payer_group + "'";
								pstmt = connection.prepareStatement(cust_grp_desc_qry);
								rs = pstmt.executeQuery();
								if (rs != null) {
									while (rs.next()) {
										cust_group_name = rs.getString(1);
									}
								}
							}
							if (cust_group_name.equals(null))
								cust_group_name = "";
							if (payer != null || payer != "") {
								String cust_desc_qry = "select DECODE('" + payer
										+ "','**',NULL, short_name) cust_short_name from ar_customer_lang_vw  where language_id='"
										+ locale + "' and cust_code = '" + payer + "'";
								pstmt = connection.prepareStatement(cust_desc_qry);
								pstmt = connection.prepareStatement(cust_desc_qry);
								rs = pstmt.executeQuery();
								if (rs != null) {
									while (rs.next()) {
										cust_short_name = rs.getString(1);
									}
								}
							}
							if (cust_short_name == null)
								cust_short_name = "";
							if (policy != null || policy != "") {
								String policy_type_desc_qry = "select short_desc policy_short_desc from bl_ins_policy_types_lang_vw  where language_id='"
										+ locale + "' and policy_type_code = '" + policy + "'";
								pstmt = connection.prepareStatement(policy_type_desc_qry);
								rs = pstmt.executeQuery();
								if (rs != null) {
									while (rs.next()) {
										policy_short_desc = rs.getString(1);
									}
								}
							}
							if (policy_short_desc == null)
								policy_short_desc = "";
							arr[12] = cust_group_name;
							arr[13] = cust_short_name;
							arr[14] = policy_short_desc;

						} else {
							cust_group_name = "";
							cust_short_name = "";
							policy_short_desc = "";
							arr[12] = cust_group_name;
							arr[13] = cust_short_name;
							arr[14] = policy_short_desc;
						}
						String p_privilege_val ="";
						String p_allowed_yn="";
						
						try{
							System.out.println("Inside Try");
						CallableStatement cstmt = connection.prepareCall("{ call blpolicyuseraccessdtls.get_bl_policy_privlege_yn(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?)}");
						System.out.println("After Callable Try");
						cstmt.setString(1, facilityId);
						cstmt.setString(2, authorizedUserName);
						cstmt.setString(3, "");
						cstmt.setString(4, "INTERIM_BILL_AUTH");
						cstmt.setString(5, payer_group);
						cstmt.setString(6, payer);
						cstmt.setString(7, policy);
						cstmt.setString(8, "BILL_AUTHORIZATION");
						cstmt.setString(9, new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
						cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
						cstmt.execute();	
						p_privilege_val = cstmt.getString(10);
						p_allowed_yn = cstmt.getString(11);
						System.out.println("password check in servlet "+p_privilege_val+"::"+p_allowed_yn);
						cstmt.close();
						if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y")){

							arr[0] = srl_no;
							arr[1] = patient_id;
							arr[2] = patient_name;
							arr[3] = episode_id;
							arr[4] = admissiondate;
							arr[5] = payer_group;
							arr[6] = payer;
							arr[7] = policy;
							arr[8] = unbuiledamount;
							arr[9] = billnumber;
							arr[10] = billdate;
							arr[11] = selectall;
							arr[15] = login_user;
							arr[16] = added_date;
							arr[17] = client_ip_address;
							arr[18] = auth_date;
							preApprovalRequestSpecPatientList.add(arr);
						}
						}
						catch(Exception ee)
						{
							connection.close();
							ee.printStackTrace();
						}	
					}

					catch (Exception e) {
						connection.close();
						System.err.println("Exception in BillingInterimbillServlet.java" + e);
						e.printStackTrace();
					}
				}
				connection.close();
			} else if (!finalIndexArr.equals("")) {
				System.err.println("In finalIndexArr " + finalIndexArr);
				bean_id = "RecordApprovalPatientDataBean";
				bean_name = "eBL.RecordApprovalPatientDataBean";
				RecordApprovalPatientDataBean recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) PersistenceHelper
						.getBeanObject(bean_id, bean_name, request);
				recordPreApprovalDataMap = recordApprovalPatientDataBean.getrPatSearchValues();
				con = ConnectionManager.getConnection();
				this.out = response.getWriter();
				tabdata = new HashMap();
				String finalJSONArr = request.getParameter("finalJSONArr");
				JSONParser parser = new JSONParser();
				JSONObject json = (JSONObject) parser.parse(finalJSONArr);
				preApprovalRequestSpecPatientList = new ArrayList();
				String[] finalIndex = finalIndexArr.split(",");
				for (Object key : json.keySet()) {
					String keyStr = (String) key;
					if (Arrays.asList(finalIndex).contains(keyStr)) {
						String keyvalue = (String) json.get(keyStr);
						valuesKeys = keyvalue.split("~");
						try {
							arr = new String[20];
							srl_no = checkForNull(valuesKeys[0]);
							patient_id = checkForNull(valuesKeys[1]);
							patient_name = checkForNull(valuesKeys[2]);
							episode_id = checkForNull(valuesKeys[3]);
							admissiondate = checkForNull(valuesKeys[4]);
							payer_group = checkForNull(valuesKeys[5]);
							payer = checkForNull(valuesKeys[6]);
							policy = checkForNull(valuesKeys[7]);
							unbuiledamount = checkForNull(valuesKeys[8]);
							billnumber = checkForNull(valuesKeys[9]);
							billdate = checkForNull(valuesKeys[10]);
							selectall = checkForNull(valuesKeys[11]);
							String cust_group_name = "";
							String cust_short_name = "";
							String policy_short_desc = "";
							if ((payer_group.equals(null) || payer_group.equals(""))
									|| (payer.equals(null) || payer.equals(""))
									|| (policy.equals(null) || policy.equals(""))) {
								if (payer_group != null || payer_group != "") {
									String cust_grp_desc_qry = "select short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id='"
											+ locale + "' and cust_group_code = '" + payer_group + "'";
									pstmt = con.prepareStatement(cust_grp_desc_qry);
									rs = pstmt.executeQuery();
									if (rs != null) {
										while (rs.next()) {
											cust_group_name = rs.getString(1);
										}
									}
								}
								if (cust_group_name.equals(null))
									cust_group_name = "";
								if (payer != null || payer != "") {
									String cust_desc_qry = "select DECODE('" + payer
											+ "','**',NULL, short_name) cust_short_name from ar_customer_lang_vw  where language_id='"
											+ locale + "' and cust_code = '" + payer + "'";
									pstmt = con.prepareStatement(cust_desc_qry);
									pstmt = con.prepareStatement(cust_desc_qry);
									rs = pstmt.executeQuery();
									if (rs != null) {
										while (rs.next()) {
											cust_short_name = rs.getString(1);
										}
									}
								}
								if (cust_short_name == null)
									cust_short_name = "";
								if (policy != null || policy != "") {
									String policy_type_desc_qry = "select short_desc policy_short_desc from bl_ins_policy_types_lang_vw  where language_id='"
											+ locale + "' and policy_type_code = '" + policy + "'";
									pstmt = con.prepareStatement(policy_type_desc_qry);
									rs = pstmt.executeQuery();
									if (rs != null) {
										while (rs.next()) {
											policy_short_desc = rs.getString(1);
										}
									}
								}
								if (policy_short_desc == null)
									policy_short_desc = "";
								arr[12] = cust_group_name;
								arr[13] = cust_short_name;
								arr[14] = policy_short_desc;

							} else {
								cust_group_name = "";
								cust_short_name = "";
								policy_short_desc = "";
								arr[12] = cust_group_name;
								arr[13] = cust_short_name;
								arr[14] = policy_short_desc;
							}
							arr[0] = srl_no;
							arr[1] = patient_id;
							arr[2] = patient_name;
							arr[3] = episode_id;
							arr[4] = admissiondate;
							arr[5] = payer_group;
							arr[6] = payer;
							arr[7] = policy;
							arr[8] = unbuiledamount;
							arr[9] = billnumber;
							arr[10] = billdate;
							arr[11] = selectall;
							arr[15] = login_user;
							arr[16] = added_date;
							arr[17] = client_ip_address;
							arr[18] = auth_date;

							preApprovalRequestSpecPatientList.add(arr);
							System.err.println("keyStr  "+keyStr);
							recordPreApprovalDataMap.remove(keyStr);

						}

						catch (Exception e) {
							System.out.println("exception   " + e);
							e.printStackTrace();
						}
					}
				}
				recordApprovalPatientDataBean.setrPatSearchValue(recordPreApprovalDataMap);
			} else if (!finalUnselectindex.equals("")) {
				System.err.println("In finalUnselectindex " + finalUnselectindex);
				bean_id = "RecordApprovalPatientDataBean";
				bean_name = "eBL.RecordApprovalPatientDataBean";
				RecordApprovalPatientDataBean recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) PersistenceHelper
						.getBeanObject(bean_id, bean_name, request);
				recordPreApprovalDataMap = recordApprovalPatientDataBean.getrPatSearchValues();
				Iterator iterator = recordPreApprovalDataMap.keySet().iterator();
				rowCount = recordPreApprovalDataMap.size();
				tabdata = new HashMap();
				String[] arrOfStr = finalUnselectindex.split(",");
				Connection	connection 	= ConnectionManager.getConnection();
				while (iterator.hasNext()) {
					index = (Integer) iterator.next();
					boolean foundIndex = Arrays.asList(arrOfStr).contains(Integer.toString(index));
					if (foundIndex == false) {
						System.err.println("index not containing " + index);

						try {
							recordApprovalPatientDataBean = (RecordApprovalPatientDataBean) recordPreApprovalDataMap
									.get(index);
							arr = new String[30];
							String BilledDate = "";
							String AdmissionDate = "";

							BilledDate = recordApprovalPatientDataBean.getBillDate();
							if (BilledDate != null && !(BilledDate.equals(""))) {
								SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
								SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
								BilledDate = sdf2.format(sdf1.parse(BilledDate));
							}
							AdmissionDate = recordApprovalPatientDataBean.getAdmissionDate();
							if (AdmissionDate != null && !(AdmissionDate.equals(""))) {
								SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
								SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
								AdmissionDate = sdf2.format(sdf1.parse(AdmissionDate));
							}
							// String strIndex=(String)index;

							srl_no = String.valueOf(index);

							patient_id = checkForNull(recordApprovalPatientDataBean.getPatientId());

							patient_name = checkForNull(recordApprovalPatientDataBean.getPatientName());
							episode_id = checkForNull(recordApprovalPatientDataBean.getEpisodeId());
							admissiondate = checkForNull((AdmissionDate));
							payer_group = checkForNull(recordApprovalPatientDataBean.getPayerGroup());
							payer = checkForNull(recordApprovalPatientDataBean.getPayer());
							policy = checkForNull(recordApprovalPatientDataBean.getPolicy());
							unbuiledamount = checkForNull(recordApprovalPatientDataBean.getUnBuiledAmount());
							billnumber = checkForNull(recordApprovalPatientDataBean.getBillNumber());
							billdate = checkForNull(BilledDate);
							selectall = "Y";
							// authorizedUserId =
							// checkForNull(request.getParameter("authorizedUserId"+i));
							String cust_group_name = "";
							String cust_short_name = "";
							String policy_short_desc = "";
							if ((payer_group.equals(null) || payer_group.equals(""))
									|| (payer.equals(null) || payer.equals(""))
									|| (policy.equals(null) || policy.equals(""))) {
								if (payer_group != null || payer_group != "") {
									String cust_grp_desc_qry = "select short_desc SHORT_NAME from ar_cust_group_lang_vw  where  language_id='"
											+ locale + "' and cust_group_code = '" + payer_group + "'";
									pstmt = con.prepareStatement(cust_grp_desc_qry);
									rs = pstmt.executeQuery();
									if (rs != null) {
										while (rs.next()) {
											cust_group_name = rs.getString(1);
										}
									}
								}
								if (cust_group_name.equals(null))
									cust_group_name = "";
								if (payer != null || payer != "") {
									String cust_desc_qry = "select DECODE('" + payer
											+ "','**',NULL, short_name) cust_short_name from ar_customer_lang_vw  where language_id='"
											+ locale + "' and cust_code = '" + payer + "'";
									pstmt = con.prepareStatement(cust_desc_qry);
									pstmt = con.prepareStatement(cust_desc_qry);
									rs = pstmt.executeQuery();
									if (rs != null) {
										while (rs.next()) {
											cust_short_name = rs.getString(1);
										}
									}
								}
								if (cust_short_name == null)
									cust_short_name = "";
								if (policy != null || policy != "") {
									String policy_type_desc_qry = "select short_desc policy_short_desc from bl_ins_policy_types_lang_vw  where language_id='"
											+ locale + "' and policy_type_code = '" + policy + "'";
									pstmt = con.prepareStatement(policy_type_desc_qry);
									rs = pstmt.executeQuery();
									if (rs != null) {
										while (rs.next()) {
											policy_short_desc = rs.getString(1);
										}
									}
								}
								if (policy_short_desc == null)
									policy_short_desc = "";
								arr[12] = cust_group_name;
								arr[13] = cust_short_name;
								arr[14] = policy_short_desc;

							} else {
								cust_group_name = "";
								cust_short_name = "";
								policy_short_desc = "";
								arr[12] = cust_group_name;
								arr[13] = cust_short_name;
								arr[14] = policy_short_desc;
							}
							String p_privilege_val ="";
							String p_allowed_yn="";
							try{
								System.out.println("Inside Try");
							CallableStatement cstmt = connection.prepareCall("{ call blpolicyuseraccessdtls.get_bl_policy_privlege_yn(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?)}");
							System.out.println("After Callable Try");
							cstmt.setString(1, facilityId);
							cstmt.setString(2, authorizedUserName);
							cstmt.setString(3, "");
							cstmt.setString(4, "INTERIM_BILL_AUTH");
							cstmt.setString(5, payer_group);
							cstmt.setString(6, payer);
							cstmt.setString(7, policy);
							cstmt.setString(8, "BILL_AUTHORIZATION");
							cstmt.setString(9, new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
							cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
							cstmt.execute();	
							p_privilege_val = cstmt.getString(10);
							p_allowed_yn = cstmt.getString(11);
							System.out.println("password check in servlet "+p_privilege_val+"::"+p_allowed_yn);
							cstmt.close();
							if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y")){

								arr[0] = srl_no;
								arr[1] = patient_id;
								arr[2] = patient_name;
								arr[3] = episode_id;
								arr[4] = admissiondate;
								arr[5] = payer_group;
								arr[6] = payer;
								arr[7] = policy;
								arr[8] = unbuiledamount;
								arr[9] = billnumber;
								arr[10] = billdate;
								arr[11] = selectall;
								arr[15] = login_user;
								arr[16] = added_date;
								arr[17] = client_ip_address;
								arr[18] = auth_date;

								preApprovalRequestSpecPatientList.add(arr);
								
							}
							}
							catch(Exception ee)
							{
								connection.close();
								ee.printStackTrace();
							}	

						}

						catch (Exception e) {
							System.err.println("Exception in BillingInterimbillServlet.java" + e);
							e.printStackTrace();
						}
					}
				}
				connection.close();
			}
			tabdata.put("preApprovalRequestSpecPatientList", preApprovalRequestSpecPatientList);

		} catch (Exception e) {
			System.out.println("EXCEPTION IN MaintainPrevilageCardServlet TABDATA::: " + e);
			e.printStackTrace();

		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
				if(con != null)
					con.close();
			} catch (Exception e) {
				System.err.println("Exception in  getCustDtls" + e);
				e.printStackTrace();
			}
		}
		return tabdata;
	}

	private void modifyData(HttpServletRequest request, HttpServletResponse response, HashMap tabdata) {
		ArrayList preApprovalRequestSpecPatientList = new ArrayList();
		//String str_error_level = "";
		//String str_error_text = "";
		//String str_sysmesage_id = "";
		String locale = "";
		String billdate1 = "";
		String admissiondate1 = "";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		if (locale == null)
			locale = "en";
		String facility_id = (String) tabdata.get("FACILITY_ID");
		if (facility_id == null)
			facility_id = "";
		client_ip_address = (String) tabdata.get("client_ip_address");
		if (client_ip_address == null)
			client_ip_address = "";
		locale = (String) tabdata.get("locale");
		if (locale == null)
			locale = "en";
		Connection con = null;
		con = ConnectionManager.getConnection();
		preApprovalRequestSpecPatientList = (ArrayList) tabdata.get("preApprovalRequestSpecPatientList");
		try {
			for (int index = 0; index < preApprovalRequestSpecPatientList.size(); index++) {
				String[] arr = new String[30];
				arr = (String[]) preApprovalRequestSpecPatientList.get(index);

				String srl_no = arr[0];
				String patient_id = arr[1];
				String patient_name = arr[2];
				String episode_id = arr[3];
				// String ds1 = "2007-06-30";

				String admissiondate = arr[4];
				if (admissiondate == null || admissiondate.equals("")) {
					admissiondate1 = "";
				} else {
					admissiondate1 = sdf2.format(sdf1.parse(admissiondate));
				}
				String payer_group = arr[5];
				String payer = arr[6];
				String policy = arr[7];
				String unbuiledamount = arr[8];
				String billnumber = arr[9];
				String billdate = arr[10];
				if (billdate == null || billdate.equals("")) {
					billdate1 = "";
				} else {
					SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
					billdate1 = sdf3.format(sdf1.parse(billdate));
				}
				String selectall = arr[11];
				String cust_group_name = arr[12];
				String cust_short_name = arr[13];
				String policy_short_desc = arr[14];
				String added_by_id = arr[15];
				String added_date = arr[16];
				String added_at_ws_no = arr[17];
				String auth_date = arr[18];
				String reason_code = "IA";
				String added_facility_id = facilityId;
				String operating_facility_id = facilityId;
				System.err.println("While Submit  "+srl_no + "" + patient_id + "" + patient_name + "" + episode_id + ""
						+ admissiondate + "" + payer_group + "" + payer + "" + policy + "" + unbuiledamount
						+ "" + billnumber + "" + billdate + "" + selectall);
				String sql = "insert into bl_int_bill_auth_encounters (operating_facility_id,patient_id,patient_name,episode_type,episode_id,admission_date,cust_grp_code,cust_grp_sname,cust_code,cust_sname,policy_type_code,policy_sname,unbilled_amt,bill_number,bill_date,auth_date,reason_code,added_by_id,added_date,added_at_ws_no,added_facility_id) values (?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,to_date(?,'dd/mm/yyyy'),?,?)";
				PreparedStatement pstmt = null;

				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, operating_facility_id);
					pstmt.setString(2, patient_id);
					pstmt.setString(3, patient_name);
					pstmt.setString(4, episode_type);
					pstmt.setString(5, episode_id);
					pstmt.setString(6, admissiondate1);
					pstmt.setString(7, payer_group);
					pstmt.setString(8, cust_group_name);
					pstmt.setString(9, payer);
					pstmt.setString(10, cust_short_name);
					pstmt.setString(11, policy);
					pstmt.setString(12, policy_short_desc);
					pstmt.setString(13, unbuiledamount);
					pstmt.setString(14, billnumber);
					pstmt.setString(15, billdate1);
					pstmt.setString(16, auth_date);
					pstmt.setString(17, reason_code);
					pstmt.setString(18, added_by_id);
					pstmt.setString(19, added_date);
					pstmt.setString(20, added_at_ws_no);
					pstmt.setString(21, added_facility_id);
					pstmt.executeUpdate();
					pstmt.close();
					con.commit();

				} catch (Exception e) {
					System.err.println("Exception in getting Message String ->" + e);
					e.printStackTrace();
				} finally {
					pstmt.close();
				}
			}

			System.err.println("before sendRedirect");
			response.sendRedirect("../eCommon/jsp/error.jsp?err_num="
					+ java.net.URLEncoder.encode("APP-BL1008 process completed successfully..", "UTF-8") + "&err_value="
					+ 0);
		} catch (Exception ex) {
			System.out.println("exception while printing value" + ex);
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception e) {
				System.err.println("Exception in modifyData BillingInterimbillServlet.java" + e);
				e.printStackTrace();
			}	
		}
	}

	private String checkForNull(String str) {
		return (str != null && str.intern() != "null") ? str : "";
	}

	private String checkForNull(String str, String defaultVal) {
		return (!checkForNull(str).equals("")) ? str : defaultVal;
	}

	private boolean isLocalEJB() {
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS") != null)
				&& (servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
			return true;
		return false;
	}

	private String formatDate(String inputDate) {
		if (inputDate == null || inputDate.equals("")) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Timestamp inputTimeStamp = null;
		String outputDate = inputDate;
		long longTimeStamp = 0;
		inputTimeStamp = Timestamp.valueOf(inputDate);
		longTimeStamp = inputTimeStamp.getTime();
		outputDate = sdf.format(longTimeStamp);
		return outputDate;
	}

}