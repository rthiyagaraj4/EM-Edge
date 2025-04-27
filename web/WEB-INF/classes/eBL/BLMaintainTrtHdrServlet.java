/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1			 			 		30618			PMG2021-COMN-CRF-0076.2			Manivel N
-----------------------------------------------------------------------------------------------
*/

package eBL;

import java.lang.reflect.Method;
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.StringTokenizer;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import eBL.PkgParameters.*;
import eBL.*;
import com.ehis.persist.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.ArrayList ;
import eCommon.Common.*;
import com.ehis.eslp.ServiceLocator;
import eBL.PkgAdhocDiscountBean.*;



/**
 * Servlet implementation class BLMaintainTrtHdrServlet
 */
public class BLMaintainTrtHdrServlet extends HttpServlet {
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
	HashMap<String, ArrayList<String>> ManagePatientHdrEncountersMap = new HashMap<String, ArrayList<String>>();
	ArrayList<String> ManagePatientEncountersArray;
	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BLMaintainTrtHdrServlet() {
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
		System.err.println("Entered in do post of BLMaintainTrthdrServlet.java");
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
			
			MaintainTreatmentHdrDtls(req, res);

		} 
		catch (Exception e) 
		{
			System.err.println("Exception in doPost=" + e.toString());
			e.printStackTrace();
			out.println(e.toString());
		} 
	}



	private void MaintainTreatmentHdrDtls(HttpServletRequest req,HttpServletResponse res) throws SQLException
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
			String str_error_level = "", str_error_text = "", str_sys_message_id = "" , hdrRecordChanged="";
			HashMap tabdata=new HashMap();
			java.util.HashMap results = new HashMap();
			
			
		//	int cnt = 0;
//			System.err.println("Main 1");
			//getData(req);
//			System.err.println("Main 2");
			//InsertSupportdata();	
//			System.err.println("Main 3");	
//	str_episode_id = "", str_visit_id = "", str_encounter_id = ""
			String patientid= req.getParameter("patid");
			String pkgServLmtDtlsPrivYN = req.getParameter("pkgServLmtDtlsPrivYN");
			if(pkgServLmtDtlsPrivYN == null || "".equals(pkgServLmtDtlsPrivYN)) pkgServLmtDtlsPrivYN = "N";
		/*	String str_visit_id=req.getParameter("visit_id");
			String str_episode_id=req.getParameter("episode_id");
			String str_episode_type=req.getParameter("episode_type");
			System.err.println("str_episode_id  "+str_episode_id);
			System.err.println("str_visit_id  "+str_visit_id);
			System.err.println("str_episode_type  "+str_episode_type);
		*/
			//String packagecode= req.getParameter("package_code");
			//String packageseqno= req.getParameter("package_seq_no");
			//int packageseqno_int=Integer.parseInt(packageseqno);  
			//String efffromdate= req.getParameter("eff_from_date");
			System.err.println("patientid"+patientid);
			//System.err.println("packagecode"+packagecode);
			
			//System.err.println("packageseqno"+packageseqno);
			//String count=session.getAttribute("dbcount");
			
			
			//boolean updated = true;
			
			CallableStatement call = null;
		//	int extra=0;
			ManagePatientHdrEncountersMap = (HashMap<String, ArrayList<String>>) session.getAttribute("PKGHDRDETAILSENCOUNTERS");
			System.err.println("ManagePatientHdrEncountersMap "+ManagePatientHdrEncountersMap);
			ArrayList<String> ManagePatientHdrList=ManagePatientHdrEncountersMap.get(patientid);
			
			System.err.println("ManagePatienthdrList : : "+ManagePatientHdrList);
			System.err.println("ManagePatienthdrList : : "+ManagePatientHdrList.size());
			int ManagePatientHdrListsize=ManagePatientHdrList.size();
			System.err.println("ManagePatientHdrListsize : : "+ManagePatientHdrListsize);
			//ManagePatientEncountersMap =	 session.getAttribute("PKGSERVICEDETAILSENCOUNTERS");
		/*	if(cnt<ManagePatientListsize){
				boolean insert = true;
				extra=ManagePatientListsize-cnt;
			}	*/
			//System.err.println("extra : : "+extra);
			boolean inserted = true;
			
			for (int i=0;i<ManagePatientHdrListsize;i++)
				
			{
				
				boolean update = false;
			//	boolean updatehdr = false;
			
										
				StringTokenizer stEncList=new StringTokenizer(ManagePatientHdrList.get(i),"|");
				System.err.println("stEncList===>>"+stEncList);
				
				String package_code=stEncList.hasMoreTokens()?stEncList.nextToken():""; //
			
				if(package_code.equals("") || package_code.equals("null") ) package_code="";

				System.out.println("package_code 1:: "+package_code);
				
				
				String package_seq_no=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
			
				if(package_seq_no.equals("") || package_seq_no.equals("null")  ) package_seq_no="";
				System.out.println("package_seq_no 2:: "+package_seq_no);
				
				int packageseqno=0;
				if("".equals(package_seq_no)){
					packageseqno=0;
				}		
				else
				{
					try
					{
						packageseqno=Integer.parseInt(package_seq_no);	
					}catch(Exception e)
					{
						packageseqno=0;
					}
				}
				
				String eff_from_date=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				System.out.println("eff_from_date before3:: "+eff_from_date);
				if(eff_from_date == null || eff_from_date.equals("null") ) eff_from_date="";
				System.out.println("eff_from_date 3:: "+eff_from_date);				
				
				String cust_group_code=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				System.out.println("cust_group_code 4:: "+cust_group_code);
				 if(cust_group_code.equals("") || cust_group_code.equals("null")) 
				 {
					 System.err.println("cust_group_code===============================================================+++++++++"+cust_group_code);
					 cust_group_code="";
				 }
				System.out.println("cust_group_code before 4:: "+cust_group_code);
				
				
				String cust_code=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				
				System.out.println("cust_code 5 before:: "+cust_code);//==>>
				if(cust_code.equals("") || cust_code.equals("null")  ) cust_code="";
				System.out.println("cust_code 5:: "+cust_code);//==>>
		
				
				String deposit_amt=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				 System.out.println("deposit_amt 6::before "+deposit_amt);//==>>
				if(deposit_amt.equals("") || deposit_amt.equals("null")) deposit_amt="";
				System.out.println("deposit_amt 6:: "+deposit_amt);//==>>

				String prac_code=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
			
				
				if(prac_code.equals("") || prac_code.equals("null") ) prac_code="";
				
				System.out.println("prac_code 7:: "+prac_code);

				String userid=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				
				if(userid.equals("") || userid.equals("null") ) userid="";
				System.out.println("userid 8:: "+userid);
				
				
				String ws_no=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				
				if(ws_no.equals("") || ws_no.equals("null") ) ws_no="";
				System.out.println("ws_no 9:: "+ws_no);
				
				
				String visit_id=stEncList.hasMoreTokens()?stEncList.nextToken():"";//*not in fd
				if(visit_id.equals("") || visit_id.equals("null") ) visit_id="";
				System.out.println("visit_id 10:: "+visit_id);
				
				
				String episode_id=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
			
				if(episode_id.equals("") || episode_id.equals("null") ) episode_id="";
				System.out.println("episode_id 11:: "+episode_id);
				
				String episode_type=stEncList.hasMoreTokens()?stEncList.nextToken():"";//			
			
				if(episode_type.equals("") || episode_type.equals("null") ) episode_type="";
				System.out.println("episode_type 12:: "+episode_type);
				
				String isAdhocDiscountMod=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(isAdhocDiscountMod.equals("") || isAdhocDiscountMod.equals("null") ) isAdhocDiscountMod="N";
				System.err.println("isAdhocDiscountMod 13:: "+isAdhocDiscountMod);				
				
				String adhocDiscString=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(adhocDiscString.equals("") || adhocDiscString.equals("null") ) adhocDiscString="";
				System.err.println("adhocDiscString 14:: "+adhocDiscString);	
				
				String isPackageCancelYN=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(isPackageCancelYN == null || isPackageCancelYN.equals("") || isPackageCancelYN.equals("null") ) isPackageCancelYN="N";
				System.err.println("isPackageCancelYN 15:: "+isPackageCancelYN);

				String cancelPkgReasonCode=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(cancelPkgReasonCode.equals("") || cancelPkgReasonCode.equals("null") ) cancelPkgReasonCode="";
				System.err.println("cancelPkgReasonCode 16:: "+cancelPkgReasonCode);	

				String isEncounterAssYN=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(isEncounterAssYN.equals("") || isEncounterAssYN.equals("null") ) isEncounterAssYN="N";
				System.err.println("isEncounterAssYN 17:: "+isEncounterAssYN);				
				
				String encAssString=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(encAssString.equals("") || encAssString.equals("null") ) encAssString="";
				System.err.println("encAssString 18:: "+encAssString);					
				
				String isEncounterDeAssYN=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(isEncounterDeAssYN.equals("") || isEncounterDeAssYN.equals("null") ) isEncounterDeAssYN="N";
				System.err.println("isEncounterDeAssYN 19:: "+isEncounterDeAssYN);		

				String isCancelUnProcessOrdersYN=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(isCancelUnProcessOrdersYN.equals("") || isCancelUnProcessOrdersYN.equals("null") ) isCancelUnProcessOrdersYN="N";
				System.err.println("isCancelUnProcessOrdersYN 20:: "+isCancelUnProcessOrdersYN);	

				String effDateAuthStr=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(effDateAuthStr.equals("") || effDateAuthStr.equals("null") ) effDateAuthStr="";
				System.err.println("effDateAuthStr 21:: "+effDateAuthStr);	

				String adhocDiscAuthStr=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(adhocDiscAuthStr.equals("") || adhocDiscAuthStr.equals("null") ) adhocDiscAuthStr="";
				System.err.println("adhocDiscAuthStr 22:: "+adhocDiscAuthStr);

				String cnclPackAuthStr=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(cnclPackAuthStr.equals("") || cnclPackAuthStr.equals("null") ) cnclPackAuthStr="";
				System.err.println("cnclPackAuthStr 23:: "+cnclPackAuthStr);

				String assDeassAuthStr=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(assDeassAuthStr.equals("") || assDeassAuthStr.equals("null") ) assDeassAuthStr="";
				System.err.println("assDeassAuthStr 24:: "+assDeassAuthStr);

				String pkgServDtlsAuthStr=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(pkgServDtlsAuthStr.equals("") || pkgServDtlsAuthStr.equals("null") ) pkgServDtlsAuthStr="";
				System.err.println("pkgServDtlsAuthStr 25:: "+pkgServDtlsAuthStr);		

				String db_eff_from_date=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
				if(db_eff_from_date.equals("") || db_eff_from_date.equals("null") ) db_eff_from_date="";
				System.err.println("db_eff_from_date 25:: "+db_eff_from_date);	

				String isEffDateMod = "N";
				
				if(!db_eff_from_date.equals(eff_from_date)) isEffDateMod = "Y";	
				System.err.println("isEffDateMod in hdr:"+isEffDateMod);				
				
				if("Y".equals(isAdhocDiscountMod) && "N".equals(isPackageCancelYN)){
				
					tabdata = populateTabData(req, res, package_seq_no, adhocDiscString, episode_id, episode_type, visit_id);
					results = modify(p,tabdata) ;
					
					// 76.1 Changes Begins
					
					/* boolean local_ejbs = false;
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
						local_ejbs = true;
					Object home =ServiceLocator.getInstance().getHome("java:comp/env/PkgAdhocDiscount",eBL.PkgAdhocDiscount.PkgAdhocDiscountHome.class, local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
					Object argArray[] = new Object[2];
					argArray[0] = p;
					argArray[1] = tabdata;
					Class[] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					paramArray[1] = tabdata.getClass();		
					java.util.HashMap results = (java.util.HashMap) (busObj.getClass().getMethod("modify", paramArray)).invoke(busObj, argArray);	
					(busObj.getClass().getMethod("remove", null)).invoke(busObj, null); */
					inserted = (((Boolean) results.get("status")).booleanValue());
					String errorForAdhocDisc = results.get("error").toString();
					System.err.println("inserted in Package Adhoc Discount : " + inserted);
					System.err.println("error in Package Adhoc Discount : " + errorForAdhocDisc);
					
					//Adding the audit for adhoc discount authorization
					if(inserted && "N".equals(pkgServLmtDtlsPrivYN)){
						try{
							System.err.println("adhocDiscAuthStr inside insert:"+adhocDiscAuthStr);
							String[] adhocDiscAuthStrArr = adhocDiscAuthStr.split("##");
							String authUserID = adhocDiscAuthStrArr[0];
							String authResnCode = adhocDiscAuthStrArr[1];
							String isSelfAuth = adhocDiscAuthStrArr[2];
							
							String sqlInsertforAuth = "insert into bl_package_authorized_audit(patient_id, package_code, package_seq_no, privilege_id, Authorized_User_ID, Reason_Code, Authorized_Date, self_authorized_yn) values(?, ?, ?, ?, ?, ?, sysdate, ?)";
							
							pstmt	= con.prepareStatement(sqlInsertforAuth);
							pstmt.setString(1, patientid);
							pstmt.setString(2, package_code);
							pstmt.setInt(3, packageseqno);
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
							System.err.println("Exception in adhoc discount authorization=" + e.toString());
							e.printStackTrace();
							inserted = false;
						} 							
					}						
				}					
				// 76.1 Changes Ends						
				
				System.err.println("inserted after package adhoc disc call:" +inserted);
				//System.err.println("Error Message after package  adhoc disc call:" +results.get("error").toString());				
				
				if(inserted && "Y".equals(isPackageCancelYN)){
					call = con.prepareCall("{ call blpackage.cancel_package(?,?,?,?,?,?,?,?,?,?,?,?) }");
			
					call.setString(1, str_facility_id);
					call.setString(2, patientid);
					call.setString(3, package_code);
					call.setString(4, package_seq_no);
					call.setString(5, cancelPkgReasonCode);
					call.setString(6, userid);
					call.setString(7, ws_no);
					call.setString(8, locale);
					call.setString(9, isCancelUnProcessOrdersYN);
					call.registerOutParameter(10, java.sql.Types.VARCHAR);
					call.registerOutParameter(11, java.sql.Types.VARCHAR);
					call.registerOutParameter(12, java.sql.Types.VARCHAR);
					call.execute();

					str_error_level = call.getString(10);
					str_error_text = call.getString(11);
					str_sys_message_id = call.getString(12);
					
					if(str_error_level == null) str_error_level="";
					if(str_error_text == null) str_error_text="";
					if(str_sys_message_id == null) str_sys_message_id="";
					
					
					if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
					{
						if(!str_error_level.equals("") && !str_error_text.equals(""))
						{
							System.err.println("****Inside Error Text Cancel Package:" + str_error_text);
							inserted = false;
							//inserted_rec = false;
						}
						else if(!str_sys_message_id.equals(""))
						{
							System.err.println("****Inside Sys Message Cancel Package*:"+str_sys_message_id);
							inserted = false;
							//inserted_rec = false;
						}
					}
					else
					{
						System.err.println("****Inside Rec Success Cancel Package");
						inserted = true;
					} 
					
					call.close();
					
					if(inserted && "N".equals(pkgServLmtDtlsPrivYN)){
						try{
							System.err.println("cnclPackAuthStr inside insert:"+cnclPackAuthStr);
							String[] cnclPackAuthStrArr = cnclPackAuthStr.split("##");
							String authUserID = cnclPackAuthStrArr[0];
							String authResnCode = cnclPackAuthStrArr[1];
							String isSelfAuth = cnclPackAuthStrArr[2];
							
							String sqlInsertforAuth = "insert into bl_package_authorized_audit(patient_id, package_code, package_seq_no, privilege_id, Authorized_User_ID, Reason_Code, Authorized_Date, self_authorized_yn) values(?, ?, ?, ?, ?, ?, sysdate, ?)";
							
							pstmt	= con.prepareStatement(sqlInsertforAuth);
							pstmt.setString(1, patientid);
							pstmt.setString(2, package_code);
							pstmt.setInt(3, packageseqno);
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
							System.err.println("Exception in cancel package authorization=" + e.toString());
							e.printStackTrace();
							inserted = false;
						} 
					}
				}
				System.err.println("inserted after package cancel call:" +inserted);
				System.err.println("Error Message after package cancel call:" +str_error_level+":"+str_error_text+":"+str_sys_message_id);				
				
				if(inserted && "Y".equals(isEncounterAssYN) && "N".equals(isPackageCancelYN)){
					// Logic for encounter association to be called				
						
					//HashMap<String,ArrayList<String>>  packageSubscriptionAssociationEncounters=new HashMap<String,ArrayList<String>>();
					//ArrayList<String> encounterCombinationArray=new ArrayList<String>();
					//String patientId=(String)tabdata.get("patientId");

					//packageSubscriptionAssociationEncounters=(HashMap<String,ArrayList<String>>)session.getAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
					if(encAssString != null && !"".equals(encAssString)){
						//encounterCombinationArray=packageSubscriptionAssociationEncounters.get(patientid);	


						//for(int encCount=0;encCount<encounterCombinationArray.size();encCount++){					

							//StringTokenizer stEncList=new StringTokenizer(encounterCombinationArray.get(encCount),"|");					
							String headerEpisodeType = "";
							String encounterId = "";
							String episodeId = "";
							String visitId = "";
							String packageSeqno = "";
							String packageCode = "";
							String fromDate = "";
							
							/*functionId=(String)tabdata.get("functionId");
							if(functionId==null) functionId="";			
							String login_user=(String)tabdata.get("login_user");
							if(login_user==null) login_user="";	
							String client_ip_address=(String)tabdata.get("client_ip_address");
							if(client_ip_address==null) client_ip_address="";
							*/
							
							String[] strArr = encAssString.split("~~");

							System.err.println("strArr.length:"+strArr.length);
							headerEpisodeType=strArr[0];
							encounterId=strArr[1];
							episodeId=strArr[2];
							visitId=strArr[3];
							packageSeqno=strArr[4];
							packageCode=strArr[5];
							fromDate=strArr[6];	
							System.err.println("strArr:"+headerEpisodeType+"/"+encounterId+"/"+episodeId+"/"+visitId+"/"+packageSeqno+"/"+packageCode+"/"+fromDate);

							if( encounterId.equals("") == false || ( episodeId.equals("") == false && visitId.equals("") == false) ){

								HashMap pkgAssociationMap=AssociatePackage(con,str_facility_id,"EBL_TRAN_PACKAGE_MAINTAIN",patientid,episodeId,headerEpisodeType,encounterId,visitId,packageCode,packageSeqno,userid,ws_no,fromDate);
								
								inserted = (Boolean) pkgAssociationMap.get("status");				
								System.err.println("inserted:"+inserted);
								if(inserted == false) {
									str_error_text=(String) pkgAssociationMap.get("assocPackageErr");
									System.err.println("str_error_text:"+str_error_text);
									break;
								}
								
								if(inserted && "N".equals(pkgServLmtDtlsPrivYN)){
									try{
										System.err.println("assDeassAuthStr inside insert:"+assDeassAuthStr);
										String[] assDeassAuthStrArr = assDeassAuthStr.split("##");
										String authUserID = assDeassAuthStrArr[0];
										String authResnCode = assDeassAuthStrArr[1];
										String isSelfAuth = assDeassAuthStrArr[2];
										
										String sqlInsertforAuth = "insert into bl_package_authorized_audit(patient_id, package_code, package_seq_no, privilege_id, Authorized_User_ID, Reason_Code, Authorized_Date, self_authorized_yn) values(?, ?, ?, ?, ?, ?, sysdate, ?)";
										
										pstmt	= con.prepareStatement(sqlInsertforAuth);
										pstmt.setString(1, patientid);
										pstmt.setString(2, package_code);
										pstmt.setInt(3, packageseqno);
										pstmt.setString(4, "ASSOCIATE_PACKAGE");
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
										System.err.println("Exception in Associate package authorization=" + e.toString());
										e.printStackTrace();
										inserted = false;
									} 
								}

								/* HashMap recalculationMap=recalculation(con,str_facility_id,patientid,headerEpisodeType,episodeId,visitId);

								//Added for Adding Request ID
								int reqId = 0;
								if(recalculationMap.containsKey("requestId")){
									try{
									reqId = (Integer) recalculationMap.get("requestId");
									}
									catch(Exception e){
									reqId = 0;
									e.printStackTrace();
									System.err.println("The Exception in getting Req Id->"+e);
									}
								}

								return_mess.put("requestId", reqId);
								//Added for Adding Request ID
								inserted=(Boolean) recalculationMap.get("status");				
								if(inserted==false) {
									str_error_text=(String) recalculationMap.get("recalcHdr");
									break;
								}*/	
							}
						//}
					}		
				}
				System.err.println("inserted after package associate call:" +inserted);
				System.err.println("Error Message after package associate call:" +str_error_level+":"+str_error_text+":"+str_sys_message_id);
				
				if(inserted && "Y".equals(isEncounterDeAssYN) && "N".equals(isPackageCancelYN)){
					
					String lcl_episode_id= "";
					String lcl_visit_id= "";
					String lcl_episode_type= "";
					
					String lcl_sql = "select b.encounter_id episode_id,b.visit_id,b.episode_type  from bl_package_encounter_dtls b "+
									"where b.operating_facility_id = '"+str_facility_id+"' and b.patient_id = '"+patientid+"' and b.package_code = '"+package_code+"' and b.package_seq_no = '"+package_seq_no+"'";
									
					System.err.println("lcl_sql:"+lcl_sql);
							
					pstmt = con.prepareStatement(lcl_sql);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						lcl_episode_id = rs.getString(1);
						lcl_visit_id = rs.getString(2);
						lcl_episode_type = rs.getString(3);					
					}
					
					rs.close();
					pstmt.close();
						
					call = con.prepareCall("{ call blpackage.deassociateencounter(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
					call.setString(1, str_facility_id);
					call.setString(2, "EBL_TRAN_PACKAGE_MAINTAIN");
					call.setString(3, patientid);
					call.setString(4, lcl_episode_id);
					call.setString(5, lcl_episode_type);
					call.setString(6, lcl_episode_id);
					call.setString(7, lcl_visit_id);
					call.setString(8, package_code);
					call.setString(9, package_seq_no);
					call.setString(10, userid); 
					call.setString(11, ws_no);
					call.registerOutParameter(12, java.sql.Types.VARCHAR);
					call.registerOutParameter(13, java.sql.Types.VARCHAR);
					call.registerOutParameter(14, java.sql.Types.VARCHAR);
					
					call.execute();
					
					str_error_level = call.getString(12);
					str_error_text = call.getString(13);
					str_sys_message_id = call.getString(14);
					
					if(str_error_level == null) str_error_level="";
					if(str_error_text == null) str_error_text="";
					if(str_sys_message_id == null) str_sys_message_id="";
					
					
					if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
					{
						if(!str_error_level.equals("") && !str_error_text.equals(""))
						{
							System.err.println("****Inside Error Text Deassociate Package:" + str_error_text);
							inserted = false;
							//inserted_rec = false;
						}
						else if(!str_sys_message_id.equals(""))
						{
							System.err.println("****Inside Sys Message Deassociate Package*:"+str_sys_message_id);
							inserted = false;
							//inserted_rec = false;
						}
					}
					else
					{
						System.err.println("****Inside Rec Success Deassociate Package");
						inserted = true;
					} 
					call.close();	
					
					if(inserted && "N".equals(pkgServLmtDtlsPrivYN)){
						try{
							System.err.println("assDeassAuthStr inside insert:"+assDeassAuthStr);
							String[] assDeassAuthStrArr = assDeassAuthStr.split("##");
							String authUserID = assDeassAuthStrArr[0];
							String authResnCode = assDeassAuthStrArr[1];
							String isSelfAuth = assDeassAuthStrArr[2];
							
							String sqlInsertforAuth = "insert into bl_package_authorized_audit(patient_id, package_code, package_seq_no, privilege_id, Authorized_User_ID, Reason_Code, Authorized_Date, self_authorized_yn) values(?, ?, ?, ?, ?, ?, sysdate, ?)";
							
							pstmt	= con.prepareStatement(sqlInsertforAuth);
							pstmt.setString(1, patientid);
							pstmt.setString(2, package_code);
							pstmt.setInt(3, packageseqno);
							pstmt.setString(4, "DEASSOCIATE_PACKAGE");
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
							System.err.println("Exception in De-Associate package authorization=" + e.toString());
							e.printStackTrace();
							inserted = false;
						} 
					}
				}
				System.err.println("inserted after package deassociate call:" +inserted);
				System.err.println("Error Message after package deassociate call:" +str_error_level+":"+str_error_text+":"+str_sys_message_id);
				
				// 76.1 Changes Ends				
				
				int depositamt=0;
				if("".equals(deposit_amt)){
					depositamt=0;
				}		
				else
				{
					try
					{
						depositamt=Integer.parseInt(deposit_amt);	
					}catch(Exception e)
					{
						depositamt=0;
					}
				}
				System.out.println("depositamt 391:: "+depositamt);
				System.out.println("packageseqno="+packageseqno);
				
				
				int episodeid=0;
				if("".equals(episode_id)){
					episodeid=0;
				}		
				else
				{
					try
					{
						episodeid=Integer.parseInt(episode_id);	
					}catch(Exception e)
					{
						episodeid=0;
					}
				}
				int visitid=0;
				if("".equals(visit_id)){
					visitid=0;
				}		
				else
				{
					try
					{
						visitid=Integer.parseInt(visit_id);	
					}catch(Exception e)
					{
						visitid=0;
					}
				}
			
			
				//eff_from_date = com.ehis.util.DateUtils.convertDate(eff_from_date,"DMYHMS","en",locale);
				//System.out.println("eff_from_date 28::=====new "+eff_from_date);

				//String hdn_rowid=stEncList.hasMoreTokens()?stEncList.nextToken():"";//
			
				//String hdn_split_allowed_yn =  msgArr[14];
				//if(hdn_rowid == "") hdn_rowid="";
				if(inserted) {
				//check header values
					try
					{
						call = con.prepareCall("{ call blpackage.ispkgsubhdrrecordchanged_3t(?, ?, ?, ?, TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), ?, ?, ?, ?, ? ) }");	
						System.err.println("400");
						System.err.println("str_facility_id hdr==>"+str_facility_id);
						System.err.println("patientid==>"+patientid);

						call.setString(1,str_facility_id);
						call.setString(2,patientid);
						call.setString(3,package_code);//
						//call.setString(4,package_seq_no );//
						call.setInt(4,packageseqno );//
						System.err.println("eff_from_date,befre==>"+eff_from_date);

						//		call.setDate(5,new Date(getDateIntLong(eff_from_date)));
						//call.setDate(5,eff_from_date );//
						call.setString(5,eff_from_date);
						System.err.println("eff_from_date,aftr==>"+eff_from_date);
						call.setString(6,prac_code);

						call.registerOutParameter(7, java.sql.Types.VARCHAR);
						call.registerOutParameter(8, java.sql.Types.VARCHAR);
						call.registerOutParameter(9, java.sql.Types.VARCHAR);
						call.registerOutParameter(10, java.sql.Types.VARCHAR);


						call.execute();
						hdrRecordChanged  = call.getString(7);
						str_error_level = call.getString(8);
						str_error_text = call.getString(10);
						str_sys_message_id = call.getString(9);

						System.err.println("hdrRecordChanged ::"+hdrRecordChanged);
						System.err.println("Error CODE:::"+str_error_level);
						System.err.println("Error TEXT:::"+str_error_text);
						System.err.println("Error MSG:::"+str_sys_message_id);

						if(hdrRecordChanged == null) hdrRecordChanged="";
						if(str_error_level == null) str_error_level="";
						if(str_error_text == null) str_error_text="";
						if(str_sys_message_id == null) str_sys_message_id="";


						if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
						{
							if(!str_error_level.equals("") && !str_error_text.equals(""))
							{
								System.err.println("****Inside Error Text Loop hdr*");
								inserted = false;
								//inserted_rec = false;
							}
							else if(!str_sys_message_id.equals(""))
							{
								System.err.println("****Inside Sys Message Loop hdr*");
								inserted = false;
								//inserted_rec = false;
							}
						}
						else
						{
							System.err.println("****Inside Rec Success Loop hdr");
							inserted = true;
							//inserted_rec = true;
						}
						call.close();
					}
					catch (Exception e)
					{
						inserted = false;
						System.err.println("Error while ispkgsubhdrrecordchanged_3t:"+e);
						sys_error = "Error while ispkgsubhdrrecordchanged_3t:"+e;
					}
				}
					
				if( hdrRecordChanged.equals("Y"))
				{
					try
					{
						call = con.prepareCall("{ call blpackage.updateblpkgsubhdr_3t (?, ?, ?, ?,  TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?) }");	
				
						System.err.println("str_facility_id==>"+str_facility_id);
						call.setString(1,str_facility_id);
						call.setString(2,patientid);
						call.setString(3,package_code);//
						call.setInt(4,packageseqno );//
						//System.err.println("patientid==>"+patientid);
						call.setString(5,eff_from_date );//
						System.err.println("cust_group_code==>"+cust_group_code);
						
						call.setString(6,cust_group_code);
						call.setString(7,cust_code);
						call.setInt(8,depositamt);
						
						call.setString(9,prac_code);
						call.setString(10,userid);
						call.setString(11,ws_no);
						
						call.setString(15,episode_type);
						
						call.setInt(16,episodeid);
						call.setInt(17,visitid);
						//call.setString(17,episode_type);
					
						
						call.registerOutParameter(12, java.sql.Types.VARCHAR);//error level
						call.registerOutParameter(13, java.sql.Types.VARCHAR);//sys messageid
						call.registerOutParameter(14, java.sql.Types.VARCHAR);//error text
						
						
						call.execute();
						str_error_level = 	call.getString(12);		
						if(str_error_level == null) str_error_level="";
						
						str_sys_message_id = 	call.getString(13);		
						if(str_sys_message_id == null) str_sys_message_id="";
						
						str_error_text = 	call.getString(14);		
						if(str_error_text == null) str_error_text="";
						
						System.err.println("****str_error_level hdr :"+str_error_level);
						System.err.println("****str_sys_message_id 584:"+str_sys_message_id);
						System.err.println("****str_error_text 585:"+str_error_text);

						call.close();
						
						if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
						{
							if(!str_error_level.equals("") && !str_error_text.equals(""))
							{
								System.err.println("str_error_level hdr in blmaintreatpkg msg");
								out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
								System.err.println("****Inside hdr Error Text Loop 593");
								inserted = false;
								//inserted_rec = false;
							}
							else if(!str_sys_message_id.equals(""))
							{
								System.err.println("sysid in hdr blmaintreatpkg msg");
								messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
								msg=(String)messageHashtable.get("message");
								System.err.println("sysid in hdr blmaintreatpkg msg="+msg);
								//out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) );
								
								System.err.println("****Inside Sys Message Loop ");
								inserted = false;
								//inserted_rec = false;
							}
						}
						else
						{
						System.err.println("****Inside Rec Success Loop hdr");
							inserted = true;
							//inserted_rec = true;
						}
						
						if(inserted && "Y".equals(isEffDateMod) && "N".equals(pkgServLmtDtlsPrivYN)){
							try{
								System.err.println("effDateAuthStr inside insert:"+effDateAuthStr);
								String[] effDateAuthStrArr = effDateAuthStr.split("##");
								String authUserID = effDateAuthStrArr[0];
								String authResnCode = effDateAuthStrArr[1];
								String isSelfAuth = effDateAuthStrArr[2];
								
								String sqlInsertforAuth = "insert into bl_package_authorized_audit(patient_id, package_code, package_seq_no, privilege_id, Authorized_User_ID, Reason_Code, Authorized_Date, self_authorized_yn) values(?, ?, ?, ?, ?, ?, sysdate, ?)";
								
								pstmt	= con.prepareStatement(sqlInsertforAuth);
								pstmt.setString(1, patientid);
								pstmt.setString(2, package_code);
								pstmt.setInt(3, packageseqno);
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
					}
					catch(Exception e)
					{
						inserted = false;
						//inserted_rec = false;
						System.err.println(" Err: updateblpkgsubhdr_3t : "+e);
						sys_error = sys_error + " Err: updateblpkgsubhdr_3t: "+e;
					}
				}//update hdr if end
				//header value check ends	

				// Calling the recalculation as a job so that the save can finish immediately and recalculation can happen as background job				
				if(inserted){					
					System.err.println("Calling RECALCULATEPACKAGE JOB Procedure:"+str_facility_id+"/"+patientid+"/"+packageseqno+"/"+userid+"/"+ws_no);
					if(("").equals(visit_id)) visit_id =null;

					String qryrecalcpkg   ="{ call   BLPACKAGE.recalculatepackage_for_job(?,?,?,?,?,?,?,?,?,?,?,?)}";
					call = con.prepareCall(qryrecalcpkg);	
					call.setString(1,str_facility_id);
					call.setString(2,patientid);
					call.setString(3,"EBL_TRAN_PACKAGE_MAINTAIN");
					call.setInt(4,packageseqno);
					call.setString(5,userid);
					call.setString(6,ws_no);
					call.registerOutParameter(7,java.sql.Types.VARCHAR);
					call.registerOutParameter(8,java.sql.Types.VARCHAR);
					call.registerOutParameter(9,java.sql.Types.VARCHAR);
					call.setString(10,episode_type);
					call.setInt(11,episodeid);					
					call.setInt(12,visitid);
					
					call.execute();
					
					str_error_level = call.getString(7);		
					if(str_error_level == null) str_error_level="";
					
					str_sys_message_id = call.getString(8);		
					if(str_sys_message_id == null) str_sys_message_id="";
					
					str_error_text = call.getString(9);		
					if(str_error_text == null) str_error_text="";
					
					System.err.println("****str_error_level hdr 937:"+str_error_level);
					System.err.println("****str_sys_message_id 938:"+str_sys_message_id);
					System.err.println("****str_error_text 939:"+str_error_text);

					call.close();
					
					if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
					{
						if(!str_error_level.equals("") && !str_error_text.equals(""))
						{
							System.err.println("str_error_level hdr in recalculation msg");
							out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( str_error_text.toString(), "UTF-8" )+ "<br>'</script>");
							System.err.println("****Inside hdr Error Text Loop 950");
							inserted = false;
							//inserted_rec = false;
						}
						else if(!str_sys_message_id.equals(""))
						{
							System.err.println("sysid in hdr recalculation msg");
							messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
							msg=(String)messageHashtable.get("message");
							System.err.println("sysid in hdr recalculation msg="+msg);
							//out.println("<script>parent.parent.frames(2).frames(4).location.href='../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( msg, "UTF-8" )+ "<br>'</script>");
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg,"UTF-8" ) );
							
							System.err.println("****Inside Sys Message Loop ");
							inserted = false;
							//inserted_rec = false;
						}
					}
					else
					{
						System.err.println("****Inside Rec Success Loop recalculation");
						inserted = true;
						//inserted_rec = true;
					}	
				}
			}
//for end
			System.err.println(" inserted value hdr 907: "+inserted);
			
			
			
			String error_value="0";
			if(inserted)
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
					System.err.println("sys_error in blmaintreathdrpkg msg");
					out.println("<script>parent.parent.frames(0).location.href='../eCommon/jsp/commonToolbar.jsp?"+str_query_string+"';parent.parent.frames(2).location.href='../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( sys_error.toString(), "UTF-8" )+ "<br>'</script>");
					System.err.println("syserr in blmaintreathdrpkg");
				}
			}
			//ConnectionManager.returnConnection(con, req);
		} //main try
		catch (Exception e) 
		{
			System.err.println("exception in blmaintreatpkghdrservlet=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Records Not inserted </h3> Foll: Error Received : "
							+ e.toString() + sb.toString());
			out.println("Values sent are : <br>");
			System.err.println("709,exception in blmaintreatpkghdrservlet" );
			if(con!=null) con.close();
				//ConnectionManager.returnConnection(con, req);
		} 
	}
		
	private HashMap populateTabData(HttpServletRequest req,HttpServletResponse res, String package_seq_no, String adhocDiscString, String episode_id, String episode_type, String visit_id)
	{
		System.err.println("Data passed to populateTabData:" + package_seq_no + "/" + adhocDiscString + "/" + episode_id + "/" + episode_type + "/" + visit_id);
		//System.out.println("tabdata servlet 1");
		//String bean_id		= "bl_PkgAdhocDiscountBean" ;
		//String bean_name	= "eBL.PkgAdhocDiscountBean";
		//PkgAdhocDiscountBean bean	= (PkgAdhocDiscountBean)PersistenceHelper.getBeanObject( bean_id, bean_name, req ) ;
		String patientId = req.getParameter("patid");
		if ((patientId == null) ||(patientId.equals("")) ) patientId="";
		
		ArrayList encounterDtls		= new ArrayList();
		HashMap tabdata=new HashMap();
		
		int totalRecords		= 0;
		HashMap adhocDiscountDtls = new HashMap();
		ArrayList packageSeqNoList	= new ArrayList();
		
		String blnggrp=req.getParameter("blnggrp");
		if ((blnggrp == null) ||(blnggrp.equals("")) ) blnggrp="";

		String billdoctype=req.getParameter("billdoctype");
		if ((billdoctype == null) ||(billdoctype.equals("")) ) billdoctype="";

		String billdocnum=req.getParameter("billdocnum");
		if ((billdocnum == null) ||(billdocnum.equals("")) ) billdocnum="";
		
		String[] strArr = adhocDiscString.split("::");

		System.err.println("strArr.length:"+strArr.length);
		for(int i=0;i<strArr.length;i++)
		{
			ArrayList dtlsNew			= new ArrayList();
			String[] discLine = strArr[i].split("~~");
			if(!(packageSeqNoList.contains(discLine[1])))
					packageSeqNoList.add(discLine[1]);
			// packageCode[0] +"~~"+ packageSeqNo[1] +"~~"+ custGrpCode[2] +"~~"+ custCode[3] +"~~"+ discountAsPerSetup[4] +"~~"+  discType[5]+"~~"+adhocDiscount[6]+"~~"+reason_desc[7]+"~~"+reason_code[8]+"~~"+del_rec[9]+"~~"+to_update[10];

			dtlsNew.add(discLine[2]); //(String) hash.get( "cust_group_code"+i ));
			dtlsNew.add(discLine[2]); //(String) hash.get( "cust_group_desc"+i ));
			dtlsNew.add(discLine[3]); //(String) hash.get( "cust_code"+i ));
			dtlsNew.add(discLine[3]); //(String) hash.get( "cust_desc"+i ));
			dtlsNew.add(discLine[4]); //(String) hash.get( "discountAsPerSetup_"+i ));
			dtlsNew.add(discLine[5]); //(String) hash.get( "type_"+i ));
			dtlsNew.add(discLine[6]); //(String) hash.get( "adhocDiscount_"+i ));
			dtlsNew.add(discLine[10]); //(String) hash.get( "to_update"+i ));					
			dtlsNew.add(discLine[0]); //(String) hash.get( "packageCode" ));					
			dtlsNew.add(discLine[8]); //(String) hash.get( "reason_code"+i ));
			dtlsNew.add(discLine[7]); //(String) hash.get( "reason_desc"+i ));
			dtlsNew.add(discLine[9]); //(String) hash.get( "del_rec_YN"+i ));
			encounterDtls.add(dtlsNew);
		}
		
		adhocDiscountDtls.put(package_seq_no,encounterDtls);

		tabdata.put("FACILITY_ID",str_facility_id);
		tabdata.put("patientId",patientId);
		tabdata.put("packageSeqNoList",packageSeqNoList);
		tabdata.put("adhocDiscountDtls",adhocDiscountDtls);
		tabdata.put("client_ip_address",str_client_ip_address);
		tabdata.put("login_user",str_user_id);
		tabdata.put("called_from","EBL_TRAN_PACKAGE_MAINTAIN");
		tabdata.put("episode_type",episode_type);
		tabdata.put("episode_id",episode_id);
		tabdata.put("visit_id",visit_id);
		tabdata.put("blnggrp",blnggrp);
		tabdata.put("billdoctype",billdoctype);
		tabdata.put("billdocnum",billdocnum);
		System.err.println("populateTabData-> MPP Hdr Servlet: "+tabdata);
		return tabdata;
	}
	
	public java.util.HashMap modify(java.util.Properties p,java.util.HashMap tabdata) 
	{		
		//Removed the usage of below variable which was declared as Global and added as a Local varaiable
		//By Rajesh V for MMS-ICN-008
		StringBuffer sys_err = new StringBuffer("") ;
		Connection con;
		CallableStatement cstmt = null;
		
		boolean insertable = false;

		con = ConnectionManager.getConnection(p);
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;//muthu
		String err_level="",sys_message_id="",err_text="";//muthu

		HashMap return_mess = new HashMap();		
		int result = 0;
		//String locale = "";//V210413
		String client_ip_address=(String)tabdata.get("client_ip_address");
		if(client_ip_address==null) client_ip_address="";
		
		String user_id=(String)tabdata.get("login_user");
		if(user_id==null) user_id="";
		//locale = (String) tabdata.get("locale");
		if(locale==null) locale="en";
		String facility_id = (String) tabdata.get("FACILITY_ID");
		facility_id = facility_id==null?"": facility_id;
		String patientId = (String) tabdata.get("patientId");
		patientId = patientId==null?"": patientId;
		String called_from = (String) tabdata.get("called_from");
		called_from = called_from==null?"": called_from;
	//Added V171219-Gayathri/65499/Starts

		String episode_type=(String)tabdata.get("episode_type");
		if(episode_type==null) episode_type="";	
		String episode_id=(String)tabdata.get("episode_id");
		if(episode_id==null) episode_id="";	
		String visit_id=(String)tabdata.get("visit_id");
		if(visit_id==null) visit_id="";	
			//Added V171219-Gayathri/65499/Ends
		String blnggrp=(String)tabdata.get("blnggrp");
		if(blnggrp==null) blnggrp="";

		String billdoctype=(String)tabdata.get("billdoctype");
		if(billdoctype==null) billdoctype="";
		String billdocnum=(String)tabdata.get("billdocnum");
		if(billdocnum==null) billdocnum="";

		String packageSeqNo = "";
		String cust_group_code	=	"";
		String cust_code	=	"";
		String discount_as_per_setup	=	"";
		String type	=	"";
		String adhocDiscount	=	"";								
		String to_update	=	"";								
		String packageCode	=	"";								
		//int episodeId = 0;
		//int accSeqNo = 0;
		//String custCode = "";
		//String encounterId = "";
		String reason_code="";//muthu
		String reason_desc="";//muthu
		int totRec = 0;
		String del_rec_YN="N";
		HashMap adhocDiscountDtls	= (HashMap) tabdata.get("adhocDiscountDtls");
		ArrayList packageSeqNoList	= (ArrayList) tabdata.get("packageSeqNoList");
		if(packageSeqNoList!=null && packageSeqNoList.size()>0)
			totRec = packageSeqNoList.size();
		System.err.println("totRec from pkgadhocdiscmanager :"+totRec);
		System.err.println("packageSeqNoList from pkgadhocdiscmanager :"+packageSeqNoList);
		System.err.println("adhocDiscountDtls from pkgadhocdiscmanager :"+adhocDiscountDtls);

		ArrayList enconterDtls		= new ArrayList();
		ArrayList dtls				= new ArrayList();
		//String sqlInsert			="insert into bl_package_adhoc_discount values(?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?)";
		String sqlInsert			=	"insert into bl_package_adhoc_discount(OPERATING_FACILITY_ID,PACKAGE_CODE,PACKAGE_SEQ_NO,PATIENT_ID,CUST_GROUP_CODE,CUST_CODE,DISCOUNT,DISCOUNT_TYPE,ADDED_BY_ID,ADDED_DATE,MODIFIED_BY_ID,MODIFIED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,DISC_REASON_DESC,DISC_REASON_CODE) values(?,?,?,?,?,?,?,?,?,sysdate,?,sysdate,?,?,?,?,?,?)";
		String sqlUpdate			=   "update bl_package_adhoc_discount set discount_type=? , discount=?,modified_by_id=? , modified_at_ws_no=? , modified_date=sysdate  , modified_facility_id=?, disc_reason_desc=? ,disc_reason_code=? where operating_facility_id=? and patient_id=? and package_seq_no=? and package_code=? and nvl(cust_group_code,'$')= nvl(?,'$')and nvl(cust_code,'$')=nvl(?,'$')  ";

	//  String sqlUpdate1		=     "update bl_package_adhoc_discount set disc_reason_desc=? ,disc_reason_code=?,discount_type=? , discount=?,modified_by_id=? , modified_at_ws_no=? , modified_date=sysdate  , modified_facility_id=?  where operating_facility_id=? and patient_id=? and package_seq_no=? and package_code=? and nvl(cust_group_code,'$')= nvl(?,'$')and nvl(cust_code,'$')=nvl(?,'$')  ";
	//	String sqlUpdate		="update bl_package_adhoc_discount set discount_type=? , discount=?,modified_by_id=? , modified_at_ws_no=? , modified_date=sysdate  , modified_facility_id=? ,DISC_REASON_CODE = ?  where operating_facility_id=? and patient_id=? and package_seq_no=? and package_code=? and nvl(cust_group_code,'#')= nvl(?,'#')and nvl(cust_code,'#')=nvl(?,'#')  ";

		String sqlDelete        ="delete from bl_package_adhoc_discount where operating_facility_id=? and patient_id=? and package_seq_no=? and package_code=? and nvl(cust_group_code,'#')= nvl(?,'#')and nvl(cust_code,'#')=nvl(?,'#')";//muthu
	//	String sqlHdrUpdate			="";
		boolean insertFlag			= false;
	//	boolean updateHdrFlag			= false;
		boolean updateFlag= false;
		boolean deleteFlag = false;//muthu

		try
		{
			con.setAutoCommit( false ) ;			
			insertable = true;
			if(insertable && totRec>0)
			{
				//sqlUpdate="update bl_encounter_payer_for_pkg set ADHOC_DISCOUNT=?, ADHOC_DISCOUNT_TYPE=?,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_DATE=sysdate where OPERATING_FACILITY_ID = ? and PACKAGE_SEQ_NO=? and PACKAGE_CODE=? and EPISODE_TYPE = ? and nvl(EPISODE_ID,0)=nvl(?,0) and	   nvl(VISIT_ID,0)=nvl(?,0) and	   nvl(APPT_BOOK_REF_NUM,'X')=nvl(?,'X') and ACCT_SEQ_NO = ? and PATIENT_ID=? and ENCOUNTER_ID =? and BLNG_GRP_ID=? and CUST_GROUP_CODE=? and  CUST_CODE=?";
				//sqlHdrUpdate="update bl_package_sub_hdr set ADHOC_DISC_TO_PATIENT=?, ADHOC_DISC_TYPE_TO_PATIENT=?,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_DATE=sysdate where OPERATING_FACILITY_ID = ? and PACKAGE_SEQ_NO=? and PACKAGE_CODE=? and PATIENT_ID=?";
				pstmt	= con.prepareStatement(sqlInsert);
				pstmt1	= con.prepareStatement(sqlUpdate);
				pstmt2	= con.prepareStatement(sqlDelete);//muthu

				for(int k=0;k<totRec;k++)
				{
					packageSeqNo = (String)packageSeqNoList.get(k);
					System.err.println("packageSeqNo from bean :"+packageSeqNo);

					if(insertable && adhocDiscountDtls!=null && adhocDiscountDtls.containsKey(packageSeqNo))
					{
						enconterDtls = (ArrayList) adhocDiscountDtls.get(packageSeqNo);
						if(enconterDtls!=null && enconterDtls.size()>0)
						{
							for(int i=0;i<enconterDtls.size(); i++)
							{
								dtls	= (ArrayList)enconterDtls.get(i);
							//	adhocDiscount = (String)dtls.get(16); 
							
	
								cust_group_code=(String)dtls.get(0);
								cust_code=(String)dtls.get(2);
								if(dtls.get(3) == null || (((String)dtls.get(3)).equals("")))
									cust_code="";		
								if(cust_group_code == null || "".equals(cust_group_code))
									cust_code = "";	
								discount_as_per_setup=(String)dtls.get(4);
								type=(String)dtls.get(5);
								adhocDiscount = (String)dtls.get(6); 
								to_update = (String)dtls.get(7); 
								packageCode = (String)dtls.get(8);
								//muthu
								reason_desc = (String)dtls.get(10); 
								reason_code = (String)dtls.get(9); 

								del_rec_YN = (String)dtls.get(11); 

								if(del_rec_YN.equals("Y"))
								{
									to_update = "D";
								}
								//muthu
								if(cust_group_code==null || cust_group_code.equals(""))	cust_group_code=null;
								if(cust_code==null ||  cust_code.equals(""))	cust_code=null;
								//custCode = (String)dtls.get(4);			
								System.err.println(" cust_group_code:"+cust_group_code);								
								System.err.println(" cust_group_desc:"+(String)dtls.get(1));								
								System.err.println(" cust_code:"+cust_code);								
								System.err.println(" cust_desc:"+(String)dtls.get(3));								
								System.err.println(" discount_as_per_setup:"+discount_as_per_setup);								
								System.err.println(" type:"+type);								
								System.err.println(" adhocDiscount:"+adhocDiscount);								
								System.err.println(" to_update:"+to_update);								
								System.err.println(" packageCode:"+packageCode);							
								if(adhocDiscount!=null && !(adhocDiscount.equals("")))
								{	
									//try
									//{
									if(to_update.equals("I")){
										System.err.println("Insert Operation");
										pstmt.setString(1,facility_id);
										pstmt.setString(2,packageCode);
										pstmt.setString(3,packageSeqNo);
										pstmt.setString(4,patientId);
										pstmt.setString(5,cust_group_code);
										pstmt.setString(6,cust_code);
										pstmt.setDouble(7,Double.parseDouble(adhocDiscount));
										pstmt.setString(8,type);										
										pstmt.setString(9,user_id);
										pstmt.setString(10,user_id);
										pstmt.setString(11,client_ip_address);
										pstmt.setString(12,facility_id);
										pstmt.setString(13,client_ip_address);
										pstmt.setString(14,facility_id);
										pstmt.setString(15,reason_desc);
										pstmt.setString(16,reason_code);

										pstmt.addBatch();



										insertFlag = true;
									}
									else if(to_update.equals("U")){								
									
										System.err.println("Update Operation");
								
									
										pstmt1.setString(1,type);
										pstmt1.setDouble(2,Double.parseDouble(adhocDiscount));
										pstmt1.setString(3,user_id);										
										pstmt1.setString(4,client_ip_address);
										pstmt1.setString(5,facility_id);		
										pstmt1.setString(6,reason_desc);
										pstmt1.setString(7,reason_code);
										pstmt1.setString(8,facility_id);
										pstmt1.setString(9,patientId);										
										pstmt1.setString(10,packageSeqNo);
										pstmt1.setString(11,packageCode);										
										pstmt1.setString(12,cust_group_code);
										pstmt1.setString(13,cust_code);		

										pstmt1.addBatch();

										updateFlag = true;
									}										
								}
								if(to_update.equals("D"))
								{
									System.err.println("Inside Delete Batch Loop");
									pstmt2.setString(1,facility_id);
									pstmt2.setString(2,patientId);										
									pstmt2.setString(3,packageSeqNo);
									pstmt2.setString(4,packageCode);										
									pstmt2.setString(5,cust_group_code);
									pstmt2.setString(6,cust_code);	
														
									pstmt2.addBatch();
									deleteFlag = true;
								}
							}
													
						}
					}	
				}
				System.err.println("insertFlag="+insertFlag);
				System.err.println("updateFlag="+updateFlag);
				if(insertFlag)
				{
					try
					{
						System.err.println("pstmt :"+pstmt);
						
						int[] updatebatchResult = pstmt.executeBatch();
						
						for (int j=0;j<updatebatchResult.length ;j++ )
						{
							System.err.println("updatebatchResult[j] :"+updatebatchResult[j]);
							if(updatebatchResult[j] !=-2 && updatebatchResult[j] < 0) 
							{
								result=updatebatchResult[j];
								insertable = false;
								con.rollback();
								break;
							}
							else
							{
								insertable=true;
								result=1;
							}
						}
					}
					catch(BatchUpdateException e)
					{
						System.err.println("PkgAdhocDiscountManager Exception from batch update pstmt:"+e);
						System.err.println("PkgAdhocDiscountManager SQLState:  " + e.getSQLState());
						System.err.println("PkgAdhocDiscountManager Message:  " + e.getMessage());
			            System.err.println("PkgAdhocDiscountManager Vendor:  " + e.getErrorCode());	
						e.printStackTrace();
						insertable = false;
						con.rollback();	
						
            		}
				catch(Exception  e)
					{
						System.err.println("PkgAdhocDiscountManager Message:2  " + e.getMessage());
						insertable = false;
						con.rollback();
						e.printStackTrace();					
            		}
					finally
					{
						if (pstmt!=null)   pstmt.close();
					}
				}

				if(updateFlag && insertable)
				{
					try
					{						
						int[] updatebatchResult = pstmt1.executeBatch();
						
						for (int j=0;j<updatebatchResult.length ;j++ )
						{
							System.err.println("updatebatchResult[j] :"+updatebatchResult[j]);
							if(updatebatchResult[j] !=-2 && updatebatchResult[j] < 0) 
							{
								result=updatebatchResult[j];
								insertable = false;
								con.rollback();
								break;
							}
							else
							{
								insertable=true;
								result=1;
							}
						}
					}
					catch(BatchUpdateException e)
					{
						/*System.out.println("Exception from batch update pstmt1 :"+e);
						System.out.println("SQLState:  " + e.getSQLState());
						System.out.println("Message:  " + e.getMessage());
						System.out.println("Vendor:  " + e.getErrorCode());*/
						insertable = false;						
						con.rollback();
						e.printStackTrace();						
					}
					finally
					{
						if (pstmt1!=null)   pstmt1.close();
					}
				}
				if(deleteFlag && insertable)
				{
					try
					{
						int[] updatebatchResult = pstmt2.executeBatch();
						System.err.println("updatebatchResult :"+updatebatchResult);
						for (int j=0;j<updatebatchResult.length ;j++ )
						{
							System.err.println("updatebatchResult[j]-delete:"+updatebatchResult[j]);
							if(updatebatchResult[j] !=-2 && updatebatchResult[j] < 0) 
							{
								result=updatebatchResult[j];
								insertable = false;
								con.rollback();
								break;
							}
							else
							{
								insertable=true;
								result=1;
							}
						}
					}
					catch(BatchUpdateException e)
					{
						/*System.out.println("Exception from batch update pstmt1 :"+e);
						System.out.println("SQLState:  " + e.getSQLState());
						System.out.println("Message:  " + e.getMessage());
						System.out.println("Vendor:  " + e.getErrorCode());*/
						insertable = false;						
						con.rollback();
						e.printStackTrace();
						
					}
					finally
					{
						if (pstmt2!=null)   pstmt2.close();
					}
				}
				
				/* recalculation will be happening as a job hence this call is not required
				if(insertable)
				{
					for(int k=0;k<totRec;k++)
					{
						packageSeqNo = (String)packageSeqNoList.get(k);
						// Added Recalculation proc as per instructions from karupps on 11/20/2010
						System.err.println("Calling RECALCULATEPACKAGE Procedure:"+facility_id+"/"+patientId+"/"+packageSeqNo+"/"+user_id+"/"+client_ip_address);
						//Added new parameters V171219-Gayathri/65499
						String qryrecalcpkg   ="{ call   BLPACKAGE.RECALCULATEPACKAGE(?,?,?,?,?,?,?,?,?,?,?,?)}";
						cstmt = con.prepareCall(qryrecalcpkg);	
						cstmt.setString(1,facility_id);
						cstmt.setString(2,patientId);
						cstmt.setString(3,"BL_TRAN_PACKAGE_ADHOC_DISC");
						cstmt.setString(4,packageSeqNo);
						cstmt.setString(5,user_id);
						cstmt.setString(6,client_ip_address);
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
						//Added new parameters V171219-Gayathri/65499/Starts	
						cstmt.setString(10,episode_type);
						cstmt.setString(11,episode_id);
						if(("").equals(visit_id)) visit_id=null;
						cstmt.setString(12,visit_id);
						//Added new parameters V171219-Gayathri/65499/Ends
						cstmt.execute();	

						err_text=cstmt.getString(7)==null?"":cstmt.getString(7);
						err_level=cstmt.getString(8)==null?"":cstmt.getString(8);
						sys_message_id=cstmt.getString(9)==null?"":cstmt.getString(9);

						//System.err.println("Called RECALCULATEPACKAGE Procedure:"+err_level+"/"+sys_message_id+"/"+err_text);
						//Added By Gayathri for 65499
						Locale loc = new Locale(locale);
						ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);

						if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
						{
							if(!("").equals(sys_message_id)){ 
								try{
									sys_message_id = rb.getString(sys_message_id);
								}
								catch(Exception rbException){
									sys_message_id = getMessageString(sys_message_id,con);
									rbException.printStackTrace();
								}
								sys_err.append(sys_message_id);	
							}
							if((sys_message_id.equals(""))  && !err_text.equals("")){
							sys_err.append(err_text);
							}
							insertable = false;
							cstmt.close();
							con.rollback();
							break;
						}
						else
						{
							insertable=true;
							result=1;
						}
						sys_message_id="";
						err_level="";
						err_text="";
						if (cstmt!=null)   cstmt.close();

						// Calling the recalculation as a job so that the save can finish immediately and recalculation can happen as background job
						
						
						
					}
				}
				*/
			}

			
			if(insertable)	con.commit();
		}
		catch (Exception e)
		{
			insertable=false;

			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			sys_err.append("Main Exception:"+e);
			System.out.println("Main Exception modify:"+e);
			e.printStackTrace();
		}
		finally
		{  
			//V210413 Starts
			adhocDiscountDtls=null;
			packageSeqNoList=null;
			packageSeqNoList=null;
			dtls=null;
			//V210413 Ends
			if (con != null) ConnectionManager.returnConnection(con, p);
		}
		return_mess.put("status",new Boolean(insertable));
		//Modified below. Instead of passing result passing sys_err Rajesh v ICN-008
		return_mess.put("error",sys_err.toString());
		return return_mess;	
	}

	public String getMessageString(String messageId, Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String output = "";
		String messageQuery = "select message_text_sysdef from sm_message where message_id = ?";
		try{
			pstmt = con.prepareStatement(messageQuery);
			pstmt.setString(1, messageId);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				output = messageId+"-"+rst.getString("message_text_sysdef");
			}						
		}
		catch(Exception e){
			System.err.println("Exception in getting Message String ->"+e);
			e.printStackTrace();
			output = messageId;
			e.printStackTrace();
		}
		finally{
			//V210413 Starts
			try
			{
				if(pstmt != null)
				{
					pstmt.close();
				}         
				if(rst != null)
				{
					rst.close();
				}      
			}
			catch(Exception e)
			{
				System.err.println("Errorin getMessageString::"+e);
				e.printStackTrace();
			}
			//pstmt = null;
			//rst = null;
			//V210413 Ends
		}
		return output;
	}
	
	public HashMap AssociatePackage(Connection con,String facility_id, String function_id, String patient_id,String episode_id,String episode_type,String encounter_id,String visit_id,
			String pkg_code,String pkg_seq_no,String login_user,String client_ip_address,String fromDateModified){
		/********************* insert Associated Pkgs********start************/
		HashMap returnMap = new HashMap();
		boolean insertable=false;
		try{
				String pkg_dtls="";
				String pkg_desc="";
				String str_error_level="",str_sysmesage_id="",str_error_text="";
				String str_ws_by_ip_name1 = "";
				
				StringTokenizer pkgSt=null;
				String sqlIpAdd="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facility_id+"'";
				PreparedStatement pst12=con.prepareStatement(sqlIpAdd);
				ResultSet rst12 = pst12.executeQuery();
				if (rst12!=null)
				{
				   if (rst12.next())
				   {
						 str_ws_by_ip_name1 = rst12.getString("ws_by_ip_name");
				   }
				}
				if(rst12 != null) rst12.close();
				if(pst12 != null) pst12.close();
				if ( str_ws_by_ip_name1 == null ) str_ws_by_ip_name1 ="";

				// End for WS Identification by IP Adress/Name
				String p_machine_name1 = "";
				if (str_ws_by_ip_name1.equals("I"))
				{						
					p_machine_name1 = InetAddress.getByName(client_ip_address).getHostName() ;
				}
				else
				{
					p_machine_name1 = (client_ip_address);
				}
				System.err.println("in AssociatePackage:" + facility_id+":"+function_id+":"+patient_id+":"+episode_id+":"+episode_type+":"+encounter_id+":"+visit_id+":"+pkg_code+":"+pkg_seq_no+":"+login_user+":"+p_machine_name1+":"+fromDateModified);
				String	sqlPkgAssociation   ="{ call   blpackage.AssociateEncounter(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

				CallableStatement pkgAssociate_cstmt = con.prepareCall(sqlPkgAssociation);			
				pkgAssociate_cstmt.setString(1,facility_id);
				pkgAssociate_cstmt.setString(2,function_id);
				pkgAssociate_cstmt.setString(3,patient_id);	
				pkgAssociate_cstmt.setString(4,episode_id);
				pkgAssociate_cstmt.setString(5,episode_type);			
				pkgAssociate_cstmt.setString(6,encounter_id);	
				
				if(visit_id==null || (visit_id.trim()).equals("")){
					pkgAssociate_cstmt.setString(7,null);	
				}else{
					pkgAssociate_cstmt.setInt(7,Integer.parseInt(visit_id.trim()));	
				}
				
				pkgAssociate_cstmt.setString(8,pkg_code);
				
				if(pkg_seq_no==null || (pkg_seq_no.trim()).equals(""))	{		
					pkgAssociate_cstmt.setString(9,null);	
				}else{
					pkgAssociate_cstmt.setLong(9,Long.parseLong(pkg_seq_no.trim()));
				}
				
				pkgAssociate_cstmt.setString(10,login_user);//sysdate	
				pkgAssociate_cstmt.setString(11,p_machine_name1);				
				pkgAssociate_cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
				pkgAssociate_cstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
				pkgAssociate_cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
				pkgAssociate_cstmt.setString(15,fromDateModified);
				
				pkgAssociate_cstmt.execute();						
				
				str_error_level=pkgAssociate_cstmt.getString(12);
				str_sysmesage_id=pkgAssociate_cstmt.getString(13);					
				str_error_text=pkgAssociate_cstmt.getString(14);
				
				if(str_error_level==null) str_error_level="";
				if(str_sysmesage_id==null) str_sysmesage_id="";
				if(str_error_text==null) str_error_text="";		

				if( str_sysmesage_id.equals("")  &&  str_error_text.equals("") &&  str_error_level.equals("") )
				{
					insertable=true;
				}else{
					insertable=false;
					returnMap.put("assocPackageErr", str_error_level+"-"+str_error_text);
				}		
				
				if(pkgAssociate_cstmt!=null) pkgAssociate_cstmt.close();//V210413
				
				System.err.println("error in associate:"+str_error_level+"-"+str_error_text+"-"+str_sysmesage_id);
			}
			catch(Exception e)
			{
				insertable=false;
				System.err.println("Exception while inserting package associations="+e);
				e.printStackTrace();
			}
		
		returnMap.put("status", new Boolean(insertable));
		return returnMap;
	}

}

