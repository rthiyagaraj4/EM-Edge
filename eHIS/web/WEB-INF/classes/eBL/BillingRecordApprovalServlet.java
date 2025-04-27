/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210416             17021        	Common-ICN-0009-TF	           Mohana Priya K
2	      	V220404			27973			MMS-ME-SCF-0046-TF			Mohana Priya K
3			V220905				  33891		         TH-KW-CRF-0093                     Mohanapriya K
4			V230824									NMC-JD-CRF-0102.2			  Mohanapriya K
*/
package eBL;

import java.io.File;
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
import java.util.Hashtable;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.DefaultFileItemFactory;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

import com.ehis.eslp.ServiceLocator;
import com.ehis.persist.PersistenceHelper;

import eCommon.XSSRequestWrapper;

/**
 * Servlet implementation class BillingRecordApprovalServlet
 */
public class BillingRecordApprovalServlet extends HttpServlet {
	PrintWriter out;
	java.util.Properties p;
	HashMap results;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String slmt_ind="",adm_rec_flag="";
	String locale = "";
	HashMap tabdata=null;
	HttpSession session;
	String mode												=	"";
	String tab 												=	null;
	String bean_id											= 	null;
	String bean_name										= 	null;
	String operation										=	"";
	/*V230824 NMC-JD-CRF-0102.2*/
	boolean isMultipart = false;
	DefaultFileItemFactory defaultfileitemfactory=null;
	DiskFileUpload upload=null;
	FileItem Item	 = null;
	FileItem  fileItem = null;
	List items;
	Iterator iter=null;
	String fileName="";
	String fileExt="";
	String interfaceFileId="";
	String name = "";
	String value = "";
	long docSrlNo=0;
	/*V230824 NMC-JD-CRF-0102.2*/
	boolean siteSpecUploadDoc = false;//V230814
	String billApprovedYn="";
	Connection con2=null;
	String existReqID="";
	String isHeaderProcReqd="N";
	String ins_mode="N",upd_mode="N",membershipNo="";
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public BillingRecordApprovalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//V220404
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		//V220404
		session = request.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		System.out.println("facilityId "+facilityId);
		client_ip_address = this.p.getProperty("client_ip_address"); 
		login_user = this.p.getProperty( "login_user" ) ;
		locale = this.p.getProperty("LOCALE") ;
		System.out.println("login_user "+login_user);
		try {
			con2 = ConnectionManager.getConnection();
			siteSpecUploadDoc = eCommon.Common.CommonBean.isSiteSpecific(con2, "BL","REC_APPR_EXT_INT_ENABLED");
			System.out.println("siteSpecUploadDoc ,servlet-->"+siteSpecUploadDoc);
		} catch(Exception e) {
			System.err.println("Error in BillingRecordApprovalServlet.java for getting siteSpecUploadDoc Connection: "+e);
			e.printStackTrace();
		}finally{
			if(con2!=null){
				ConnectionManager.returnConnection(con2);
			}
		}/*V231010 NMC-JD-CRF-0102.2*/
		System.out.println("siteSpecUploadDoc 140,servlet-->"+siteSpecUploadDoc);
		
		try
		{
			this.out = response.getWriter();
			System.out.println("130 BillingRecordApprovalServlet");
			if(siteSpecUploadDoc){/*V231010 NMC-JD-CRF-0102.2*/
				tabdata =populateTabDataExtInt(request,response); //upload document changes 
			}else{
				tabdata = populateTabData(request,response);
			}
			System.out.println("132 tabdata "+tabdata);
			modifyData(request, response,tabdata);
		}
		catch(Exception e)
		{
			out.println("Exception in BillingRecordApprovalServlet - DoPost:: "+e.toString());
			System.err.println("Exception in BillingRecordApprovalServlet - DoPost:: "+e);
			e.printStackTrace();
		}		
	
		}

	private void modifyData(HttpServletRequest request, HttpServletResponse response, HashMap tabdata2) {
		// TODO Auto-generated method stub
		String error 		=   "";
		String error_value  =   "";
		String inserted		=	"";
		int reqId = 0;
		try 
		{	
			boolean local_ejbs = false;
			System.out.println("tabdata modifydata "+tabdata);
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") != null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			Object home =ServiceLocator.getInstance().getHome("java:comp/env/BillingRecordApprovalRequest",eBL.BillingRecordApprovalRequest.BillingRecordApprovalRequestLocalHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home, null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();	
			HashMap results = (HashMap) (busObj.getClass().getMethod("insert", paramArray)).invoke(busObj, argArray);	 
			System.out.println("INSIDE SERVLET MNAGER results RSPINSE::::: "+results);
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			inserted = (String) results.get("status");
			if(results.containsKey("requestId")){
				try{
					reqId = (Integer) results.get("requestId");
				}
				catch(Exception e){
					reqId = 0;
					System.err.println("The Exception in getting Req Id->"+e);
					e.printStackTrace();
				}
				results.remove("requestId");
			}
			String mapValue = "";
			int err_val = 1;
			for (Iterator iterator = results.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				System.out.println("type in servlet from results:::: "+type);
				if(!type.equalsIgnoreCase("status"))
				{
					mapValue = (String) results.get(type);
				}
				System.out.println("mapValue in servlet from results:::: "+mapValue);
				if(mapValue != null){
						error = error+mapValue+"<br/>";
						err_val = 2;
				}
			}
			System.out.println("error aftrer servlet response from ejb:: "+error);
			if(inserted.equalsIgnoreCase("true"))
			{ 
				error_value = "1" ;		
				Hashtable messageHashtable=new Hashtable();
				messageHashtable=MessageManager.getMessage(locale,"RECORD_INSERTED","SM");
				String success_msg=(String)messageHashtable.get("message");
				response.sendRedirect("../eBL/jsp/BLProgressErr.jsp?reqId="+reqId+"&err_num=" + java.net.URLEncoder.encode( success_msg,"UTF-8" ) +"&err_value="+error_value);
			}
			else
			{
				error_value = "2" ;	
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
			}
	
		}  
		catch (Exception e) 
		{
			System.err.println("exception in insertData - BillingRecordApprovalServlet-InsertData=" + e.toString());
			e.printStackTrace();
			out.println("<h3> Exception raise by BillingRecordApprovalServlet-InsertData  ...So Record Not inserted </h3> Foll: Error Received : "
							+ e.toString() );
			out.println("Values sent are : <br>");
			e.printStackTrace();
		} 	
	}

	private HashMap populateTabData(HttpServletRequest request, HttpServletResponse response)
	{		
		String 		patientId											= 	"";                
		String 		episodeType											=	"";
		String 		episodeId											=	"";                
		String 		visitId												=	"";                
		String 		encounterId											=	"";                
		//String 		billingGroupId									=	"";         //commented V210416
		String 		policyTypeCode										=	"";
		String 		custGroupCode										=	"";                
		String 		custCode											=	"";                
		String 		accountSeqNo										=	"";
		String 		priority											= 	"";
		String 		policyNumber										=	"";                
		String 		billingServiceCode									= 	"";                        
		String 		includedExcluded									= 	"";
		String 		preApprovalNumber									=	"";                
		String 		approvalRequiredDate								=	"";                        
		String 		approvalGivenDate									=	"";   
		String 		approvalStatus										=	"";
		String 		approvalremarks										=	"";
		//String 		status												=	""; //commented V210416
		String 		effectiveFrom										=	"";		
		String 		availableServiceAmount								=	"";
		String 		availableServiceQty									=	"";
		
		String 		reasonCode											=	"";
		String 		patientClass										=	"";                                                                                                                                                              
		String 		episodeEncounterFlag								=	"";                                                                                                                                                                      
		String 		clinicNursingIndicator								=	"";                                                                                                                                                                      
		String 		clinicNursingCode									=	"";                                                                                                                                                              
		String 		specialiltyCode										=	"";                                                                                                                                                              
		String 		sex													=	"";                                                                                                                                              
		String 		ageGroupCode										=	"";                                                                                                                                                              
		String 		effectiveTo											=	"";                                                                                                                                                      
		String 		approvalAmountCapping								=	"";                                                                                                                                                                      
		String 		approvalQuantityCapping								=	"";                                                                                                                                                                      
		String 		approvalGrossNetAmount								=	"";                                                                                                                                                                      
		String 		serviceLevelApprovalFlag							=	"";    
		String 		primaryKeyFacilityId								=	"";             
		String 		primaryKeyModuleId									=	"";     
		String 		primaryKeyMain										=	"";     
		String 		primaryKeyLineNo									=	"";     
		String 		primaryKeyBillingServiceCode						=	"";                     
		String 		primaryKeyBillingServiceItemCode					=	"";
		String  recalcCharges = "";
		String      approvedQty											=   "";
		String      approvedAmount										=   "";
		String 		expiryDate="";// Record approval   -  MMS-QH-CRF-0165 
		
		
		String p_preApprovalNumber								=	"";
		String p_approvalGivenDate								=	"";
		String p_approvalStatus									=	"";
		String p_approvalremarks								=	"";
		String p_approvalRequiredDate							=	"";
		String p_approvedQty									=	"";					
		String p_approvedAmount									=	"";
		String p_reasonCode										=	"";
		String effectiveToDate									=	""; 		//pradeepa - CRF 0165 Record approval
		String 		approvalDurationCapping								=	""; //Added V180725-Gayathri/MMS-DM-CRF-0126
		String 		approvedDurationQty								=	""; //Added V180725-Gayathri/MMS-DM-CRF-0126
		
		String encounterIdNew="";
		String p_Mcn_Number ="";//V220905
		String Mcn_Number ="";//V220905
		String service_loc ="";//V221027                                                                                                                                         
		String encIdStrNonServLevel  	="";
		String  insuranceClr = "";//V221216/TH-KW-CRF-0084.1
		String requestID="";//102.2
		String curSrlno="";//102.2
		String seqNo="";
		String[]	arr													= 	null;
		
		
		
		  
		                
		                                                                                                                                                   

		int 	rowCount												=	0;
		
		ArrayList<String[]> 	preApprovalRequestSpecPatientList		=	null;
		//ArrayList<String[]> 	preApprovalRequestDeletePatientList		=	null; //commented V210416
		ArrayList<String[]> 	preApprovalRequestServiceLevelPatientList=	null;
		//ArrayList 	previlageCardHeaderPatientList					=	null;
		
		Set<String> encounterIdset=new HashSet<String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String authorizedUserId = "";
		
		CallableStatement cstmt = null;

		
		try
		{
			con = ConnectionManager.getConnection();
			this.out = response.getWriter();
			tabdata														=	new HashMap();  
			rowCount													= 	Integer.parseInt(request.getParameter("rowCount"));	 
		//	rowCount													= 	Integer.parseInt(request.getParameter("rows"));	 
			preApprovalRequestServiceLevelPatientList					=	new ArrayList();	
			preApprovalRequestSpecPatientList							=	new ArrayList();
			bean_id 													= "PreApprovalRequestDetailsBean";
			bean_name 													= "eBL.PreApprovalRequestDetailsBean";
			PreApprovalRequestDetailsBean preApprovalRequestDetailsBean =  (PreApprovalRequestDetailsBean)PersistenceHelper.getBeanObject(bean_id, bean_name, request);

			
			
			System.err.println("IN BillingRecordApprovalServlet:::populateTabData:::: rowCount"+rowCount);
			
			
			patientId										=	checkForNull(request.getParameter("patinetId"));
			episodeType										=	checkForNull(request.getParameter("episodeType"));
			episodeId										=	checkForNull(request.getParameter("episodeId"));
			visitId											=	checkForNull(request.getParameter("visitId"));
			encounterId										=	checkForNull(request.getParameter("encounterId"));
			policyTypeCode									=	checkForNull(request.getParameter("policyTypeCode"));
			custGroupCode									=	checkForNull(request.getParameter("custGroupCode"));
			custCode										=	checkForNull(request.getParameter("custCode"));
			accountSeqNo									=	checkForNull(request.getParameter("acctSeqNo"));
			priority										=	checkForNull(request.getParameter("priority"));
			policyNumber									=	checkForNull(request.getParameter("policyNumber"));
			expiryDate										=	checkForNull(request.getParameter("expiryDate"));// Record approval   -  MMS-QH-CRF-0165
			effectiveToDate									=	checkForNull(request.getParameter("effectiveTo"));
			//pradeepa - CRF 0165 Record approval
			membershipNo=checkForNull(request.getParameter("membershipNo"));//102.2
			
			authorizedUserId = checkForNull(request.getParameter("authorizedUserId"));
			String sysDateTime	= checkForNull(request.getParameter("sysDateTime"));
			String siteId = checkForNull(request.getParameter("siteId"));
			int afterUpdCnt = 0;
			boolean addToArr = true;
			String billApproved = "";
			//Added V200228 SHIKHA 3TierAlmoFeature & AAKH-SCF-0404.1
			boolean site3TierAlmoFeature = false;
			boolean enableMCNNumber = false;//V220905
			boolean enableQueuePKID = false;//new 20.7
			String locationStr ="";//new 20.7
			try {
				site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");//Added V200228 SHIKHA 3TierAlmoFeature
			} catch(Exception ex) {
				System.err.println("Error in BillingRecordApprovalServlet.java for getting site3TierAlmoFeature Connection: "+ex);
				ex.printStackTrace();
			}
			//Added V200228 SHIKHA 3TierAlmoFeature & AAKH-SCF-0404.1
			
			try {
				enableMCNNumber = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENB_MCN_REQ_NUM_FOR_SERV_APPR");
				System.err.println("enableMCNNumber ,servlet-->"+enableMCNNumber);
			} catch(Exception e) {
				System.err.println("Error in BillingRecordApprovalServlet.java for getting enableMCNNumber Connection: "+e);
				e.printStackTrace();
			}//V220905
			try {
				enableQueuePKID = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENB_QMS_IN_BILL_GEN");
				System.err.println("enableQueuePKID ,servlet-->"+enableMCNNumber);
			} catch(Exception e) {
				System.err.println("Error in BillingRecordApprovalServlet.java for getting enableQueuePKID Connection: "+e);
				e.printStackTrace();
			}//V220905
			
			try{				
				pstmt = con.prepareStatement("Select count(*) total_cnt from BL_INS_PAYER_APPR_DTL where patient_id = ? "+ 
											" and added_date > to_date(?,'dd/mm/yyyy HH24:MI:SS')");
				pstmt.setString(1, patientId);
				pstmt.setString(2, sysDateTime);
				rst = pstmt.executeQuery();
				if(rst != null && rst.next()){
					afterUpdCnt = rst.getInt("total_cnt");
				}
			}
			catch(Exception e){
				afterUpdCnt = 0;
				e.printStackTrace();
			}

						
			for(int i=0;i<(rowCount-2);i++)
			{
				System.out.println("IN service_level_approval:::::::::::: "+request.getParameter("service_level_approval"+i)); 
					arr 											= 	new String[50];//V220905 102.2
					
					
					//billingGroupId									=	checkForNull(request.getParameter("billing_grp_id"+i));
					billingServiceCode								=	checkForNull(request.getParameter("billing_service_code"+i));
					includedExcluded								=	checkForNull(request.getParameter("included_excluded"+i));
					
					
					preApprovalNumber								=	checkForNull(request.getParameter("approval_number"+i));
					approvalGivenDate								=	checkForNull(request.getParameter("approved_date"+i));
					approvalStatus									=	checkForNull(request.getParameter("approval_status"+i));
					approvalremarks									=	checkForNull(request.getParameter("approval_remarks"+i));
					approvalRequiredDate							=	checkForNull(request.getParameter("app_req_date"+i));
					approvedQty										=	checkForNull(request.getParameter("approvedQty"+i));					
					approvedAmount									=	checkForNull(request.getParameter("approvedAmount"+i));
					reasonCode										=	checkForNull(request.getParameter("reason"+i));
					
					System.err.println("preApprovalNumber "+preApprovalNumber);
										
					
					p_preApprovalNumber								=	checkForNull(request.getParameter("p_approval_number"+i));
					p_approvalGivenDate								=	checkForNull(request.getParameter("p_approved_date"+i));
					p_approvalStatus									=	checkForNull(request.getParameter("p_approval_status"+i));
					p_approvalremarks									=	checkForNull(request.getParameter("p_approval_remarks"+i));
					p_approvalRequiredDate							=	checkForNull(request.getParameter("p_app_req_date"+i));
					p_approvedQty										=	checkForNull(request.getParameter("p_approvedQty"+i));					
					p_approvedAmount									=	checkForNull(request.getParameter("p_approvedAmount"+i));
					p_reasonCode										=	checkForNull(request.getParameter("p_reason"+i));
					if(enableMCNNumber == true){
						p_Mcn_Number										=	checkForNull(request.getParameter("p_MCN_number"+i)); 
						Mcn_Number										=	checkForNull(request.getParameter("MCN_number"+i));//V220905
						System.err.println("Mcn_Number ,servlet-->>"+Mcn_Number);
						System.err.println("p_Mcn_Number ,servlet-->>"+p_Mcn_Number);
					}
					
					
					//status											=	checkForNull(request.getParameter("status"));
					effectiveFrom									=	checkForNull(request.getParameter("effective_from"+i));
					availableServiceAmount							=	checkForNull(request.getParameter("available_service_amount"+i));
					availableServiceQty								=	checkForNull(request.getParameter("available_service_qty"+i));
					
					
					patientClass									=	checkForNull(request.getParameter("patient_class"+i));
					episodeEncounterFlag							=	checkForNull(request.getParameter("episode_encounter_flag"+i));
					clinicNursingIndicator							=	checkForNull(request.getParameter("clinic_nursing_ind"+i));
					clinicNursingCode								=	checkForNull(request.getParameter("clinic_nursing_code"+i));
					specialiltyCode									=	checkForNull(request.getParameter("specilaity_code"+i));
					sex												=	checkForNull(request.getParameter("sex"+i));
					ageGroupCode									=	checkForNull(request.getParameter("age_group_code"+i));
					effectiveTo										=	checkForNull(request.getParameter("effective_to"+i));   
					approvalAmountCapping							=	checkForNull(request.getParameter("preapproval_amt_capping"+i));
					approvalQuantityCapping							=	checkForNull(request.getParameter("preapproval_qty_capping"+i));
					approvalGrossNetAmount							=	checkForNull(request.getParameter("preapproval_amt_gross_net"+i));
					serviceLevelApprovalFlag						=	checkForNull(request.getParameter("service_level_approval"+i));
					primaryKeyFacilityId							=	checkForNull(request.getParameter("primary_key_facility_id"+i));
					primaryKeyModuleId								=	checkForNull(request.getParameter("primary_key_module_id"+i));
					primaryKeyMain									=	checkForNull(request.getParameter("primary_key_main"+i));
					primaryKeyLineNo								=	checkForNull(request.getParameter("primary_key_line_no"+i));
					primaryKeyBillingServiceCode					=	checkForNull(request.getParameter("primary_key_bling_service_code"+i));
					primaryKeyBillingServiceItemCode				=	checkForNull(request.getParameter("primary_key_service_item_code"+i));
					encounterIdNew=checkForNull(request.getParameter("encounter_id"+i));
					approvalDurationCapping							=	checkForNull(request.getParameter("preapproval_dur_capping"+i)); //Added V180725-Gayathri/MMS-DM-CRF-0126
					approvedDurationQty							=	checkForNull(request.getParameter("approved_dur_qty"+i)); //Added V180725-Gayathri/MMS-DM-CRF-0126
					System.out. println("encounterIdNew "+encounterIdNew); 
					service_loc							=	checkForNull(request.getParameter("p_Loc_code"+i)); //V221027
					//102.2
					requestID							=	checkForNull(request.getParameter("requestID"+i)); 
					curSrlno							=	checkForNull(request.getParameter("curSrlno"+i)); 
					seqNo							=	checkForNull(request.getParameter("seqNo"+i)); 
					//102.2
					System.out. println("service_loc "+service_loc); 
					System.out. println("i==> "+i); 
					
recalcCharges = checkForNull(request.getParameter("recalc_charges"));
					if("on".equals(recalcCharges)){
						recalcCharges = "Y";
					}
					else{
						recalcCharges = "N";
					}
					
					insuranceClr=checkForNull(request.getParameter("insurance_clr")); //V221216
					System.err.println("serv insuranceClr:::: "+insuranceClr);
					
					System.err.println("IN app_req_date:::: "+request.getParameter("app_req_date"+i));
					System.err.println("IN approved_date::: "+request.getParameter("approved_date"+i));
					System.err.println("IN effective_from@@@@:: "+request.getParameter("effective_from"+i)); 
					System.err.println("IN effective_to@@@@:: "+request.getParameter("effective_to"+i)); 
					
					System.err.println("IN approvalRequiredDate::: "+approvalRequiredDate+" ::: approvalRequiredDate.length():::: "+approvalRequiredDate.length());
					System.err.println("IN approvalGivenDate@@@@:: "+approvalGivenDate+" ::: approvalGivenDate.length():::: "+approvalGivenDate.length()); 
					System.err.println("IN preApprovalNumber@@@@:: "+preApprovalNumber+" ::: preApprovalNumber.length():::: "+preApprovalNumber.length()); 
					
		/*		if((approvalRequiredDate!=null && approvalRequiredDate.length()>0)
						&& (approvalGivenDate!=null && approvalGivenDate.length()>0)
						&& (preApprovalNumber!=null && preApprovalNumber.length()>0) )
						*/
					
					 if((approvalRequiredDate.length() > 0 &&	approvalRequiredDate.equals(p_approvalRequiredDate)== false)||
								(approvalGivenDate.length()    > 0 &&	approvalGivenDate.equals(p_approvalGivenDate)== false)||
								(preApprovalNumber.length()    > 0 &&	preApprovalNumber.equals(p_preApprovalNumber)== false)||
								(approvalStatus.length()       > 0 &&	approvalStatus.equals(p_approvalStatus)== false)||		
								(approvedQty.equals(p_approvedQty)== false)||	
								(approvedAmount.equals(p_approvedAmount)== false)||	
								(reasonCode.length()           > 0 &&	reasonCode.equals(p_reasonCode)== false)||	
								(approvalremarks.length()      > 0 &&	approvalremarks.equals(p_approvalremarks)== false) ||
								(Mcn_Number.length()      > 0 &&	Mcn_Number.equals(p_Mcn_Number)== false))
					
						
				{
						 addToArr = true;
					if(afterUpdCnt >0 && ("ALMO".equalsIgnoreCase(siteId) || site3TierAlmoFeature == true)){//Added V200228 SHIKHA 3TierAlmoFeature & AAKH-SCF-0404.1
						pstmt = con.prepareStatement("Select bl_charge.bl_get_bill_approved_yn(?,?,?,?,?) bill_approved_yn from dual");
						pstmt.setString(1, facilityId);
						pstmt.setString(2, primaryKeyModuleId);
						pstmt.setString(3, primaryKeyMain);
						pstmt.setString(4, primaryKeyLineNo);
						pstmt.setString(5, primaryKeyBillingServiceCode);
						rst = pstmt.executeQuery();
						if(rst != null && rst.next()){
							billApproved = rst.getString("bill_approved_yn");
							if("Y".equals(billApproved)){
								addToArr = false;
							}
						}
					}
					
					if("Y".equals(checkForNull(request.getParameter("billApprovedYn"+i)))){
						addToArr = false;
					}
					
					if(addToArr){
					  if(request.getParameter("service_level_approval"+i)!=null && request.getParameter("service_level_approval"+i).equalsIgnoreCase("Y")) 
					  {
							arr[0]											=	patientId;
							arr[1]											=	episodeType;
							arr[2]											=	episodeId;
							arr[3]											=	visitId;
							arr[4]											=	encounterId;
							arr[5]											=	policyTypeCode;
							arr[6]											=	custGroupCode;
							arr[7]											=	custCode;
							arr[8]											=	accountSeqNo;
							arr[9]											=	priority;
							arr[10]											=	policyNumber;
							arr[11]											=	billingServiceCode;
							arr[12]											=	includedExcluded;
							arr[13]											=	preApprovalNumber;
							arr[14]											=	approvalRequiredDate;
							arr[15]											=	approvalGivenDate;
							arr[16]											=	approvalStatus;
							arr[17]											=	approvalremarks;
							arr[18]											=	effectiveFrom;
							arr[19]											=	availableServiceAmount;
							arr[20]											=	reasonCode;
							arr[21]											=	patientClass;
							arr[22]											=	episodeEncounterFlag;
							arr[23]											=	clinicNursingIndicator;
							arr[24]											=	clinicNursingCode;
							arr[25]											=	specialiltyCode;
							arr[26]											=	sex;
							arr[27]											=	ageGroupCode;
							arr[28]											=	effectiveTo;
							arr[29]											=	approvalAmountCapping;
							arr[30]											=	approvalQuantityCapping;
							arr[31]											=	approvalGrossNetAmount;
							arr[32]											=	serviceLevelApprovalFlag;
							arr[33]											=	primaryKeyFacilityId;
							arr[34]											=	primaryKeyModuleId;
							arr[35]											=	primaryKeyMain;
							arr[36]											=	primaryKeyLineNo;
							arr[37]											=	primaryKeyBillingServiceCode;
							arr[38]											=	primaryKeyBillingServiceItemCode;
							arr[39]											=	approvedQty;
							arr[40]											=	approvedAmount;
							arr[41]											=	availableServiceQty;
							arr[42]											=	encounterIdNew;
							arr[43]											=	approvalDurationCapping; //Added V180725-Gayathri/MMS-DM-CRF-0126
							arr[44]											=	approvedDurationQty; //Added V180725-Gayathri/MMS-DM-CRF-0126
							
							arr[45]											=	Mcn_Number; //V220905
							arr[46]											=	requestID; //102.2
							arr[47]											=	curSrlno; //102.2
							arr[48]											=	seqNo; //102.2
							arr[49]											=   interfaceFileId;//102.2
							locationStr+=service_loc+"~";
							System.out.println("service_loc,456-> "+service_loc);
							System.out.println("p_Mcn_Number,456-> "+Mcn_Number);
							System.out.println("encounterIdNew "+encounterIdNew);
							
							preApprovalRequestSpecPatientList.add(arr);
							encounterIdset.add(encounterIdNew);
							System.out.println("encounterIdset "+encounterIdset);
							System.out.println("preApprovalRequestSpecPatientList "+preApprovalRequestSpecPatientList);
					  	}
						else					
						{
						 	arr[0]											=	patientId;
							arr[1]											=	episodeType;
							arr[2]											=	episodeId;
							arr[3]											=	visitId;
							arr[4]											=	encounterId;
							arr[5]											=	policyTypeCode;
							arr[6]											=	custGroupCode;
							arr[7]											=	custCode;
							arr[8]											=	accountSeqNo;
							arr[9]											=	priority;
							arr[10]											=	policyNumber;
							arr[11]											=	billingServiceCode;
							arr[12]											=	includedExcluded;
							arr[13]											=	preApprovalNumber;
							arr[14]											=	approvalRequiredDate;
							arr[15]											=	approvalGivenDate;
							arr[16]											=	approvalStatus;
							arr[17]											=	approvalremarks;
							arr[18]											=	effectiveFrom;
							arr[19]											=	availableServiceAmount;
							arr[20]											=	reasonCode;
							arr[21]											=	patientClass;
							arr[22]											=	episodeEncounterFlag;
							arr[23]											=	clinicNursingIndicator;
							arr[24]											=	clinicNursingCode;
							arr[25]											=	specialiltyCode;
							arr[26]											=	sex;
							arr[27]											=	ageGroupCode;
							arr[28]											=	effectiveTo;
							arr[29]											=	approvalAmountCapping;
							arr[30]											=	approvalQuantityCapping;
							arr[31]											=	approvalGrossNetAmount;
							arr[32]											=	serviceLevelApprovalFlag;
							arr[33]											=	primaryKeyFacilityId;
							arr[34]											=	primaryKeyModuleId;
							arr[35]											=	primaryKeyMain;
							arr[36]											=	primaryKeyLineNo;
							arr[37]											=	primaryKeyBillingServiceCode;
							arr[38]											=	primaryKeyBillingServiceItemCode;
							arr[39]											=	approvedQty;
							arr[40]											=	approvedAmount;
							arr[41]											=	availableServiceQty;							
							arr[42]											= 	encounterIdNew;
							arr[43]											=	approvalDurationCapping; //Added V180725-Gayathri/MMS-DM-CRF-0126
							arr[44]											=	approvedDurationQty; //Added V180725-Gayathri/MMS-DM-CRF-0126
							arr[45]											=	Mcn_Number; //V220905
							arr[46]											=	requestID; //102.2
							arr[47]											=	curSrlno; //102.2
							arr[48]											=	seqNo; //102.2
							arr[49]											=   interfaceFileId;//102.2
							
							System.err.println("IN p_Mcn_Number 2:::: "+Mcn_Number);
							System.err.println("IN service_loc 2:::: "+service_loc);
							locationStr+=service_loc+"~";
							preApprovalRequestServiceLevelPatientList.add(arr);
							encounterIdset.add(encounterIdNew);
							System.out.println("encounterIdset "+encounterIdset);
			System.out.println("preApprovalRequestServiceLevelPatientList "+preApprovalRequestServiceLevelPatientList);
			
		
					 }
					}
				}
					
					
					
				

			}
			
			//new  crf-20.7
			
			
			System.err.println("enableQueuePKID "+enableQueuePKID);
			 if(enableQueuePKID){
				  String finalLocStr="";
				// CallableStatement cstmt =null;
					try{
						String[] servloc=locationStr.split("~");
						 Set al = new HashSet();
						for(int k=0;k<servloc.length;k++){
							al.add(servloc[k]);
							}
						System.err.println("al"+al);
						String[] locCode= (String[]) al.toArray(new String[al.size()]);
						for(int j=0;j<locCode.length;j++){
							finalLocStr+=locCode[j]+"~";
						}
						System.err.println(facilityId+" facilityId");
						System.err.println(patientId+" patientId");
						System.err.println(episodeId+" episodeId");
						System.err.println(episodeType+" episodeType");
						System.err.println(visitId+" visitId");
						System.err.println(finalLocStr+" finalLocStr");
						
							cstmt = con.prepareCall("{ call bl_release_qms_token(?,?,?,?,?,?)}");
							cstmt.setString(1, facilityId);
							cstmt.setString(2, patientId);
							cstmt.setString(3, episodeType);
							cstmt.setString(4, episodeId);
							cstmt.setString(5, visitId);
							cstmt.setString(6, finalLocStr);
							System.err.println("release_token before exec ");
							cstmt.execute();
							System.err.println("release_token after exec ");
				
					}catch(Exception e){
						System.err.println("The Exception in release_token->"+e);
					}finally{
						//cstmt.close();
					}
			 }
		
			if(encounterIdNew.length()>0){
			Iterator iterator=encounterIdset.iterator();
			while(iterator.hasNext())
			
			{
				
				encIdStrNonServLevel=iterator.next()+"/"+encIdStrNonServLevel;

			}
			}
			System.out.println("encounter id str "+encIdStrNonServLevel);
		
			
			 tabdata.put("preApprovalRequestSpecPatientList", preApprovalRequestSpecPatientList);
			 tabdata.put("preApprovalRequestServiceLevelPatientList", preApprovalRequestServiceLevelPatientList); 
			 tabdata.put("FACILITY_ID",facilityId);
			 tabdata.put("client_ip_address",client_ip_address);
			 if(!"".equals(authorizedUserId)){
				 tabdata.put("login_user",authorizedUserId);
				 System.err.println("Authorized ID -> "+authorizedUserId);
			 }
			 else{
				 tabdata.put("login_user",login_user);
				 System.err.println("Login ID -> "+login_user);
			 }
			 
			 tabdata.put("locale",locale);
			 tabdata.put("recalcCharges",recalcCharges);
			 tabdata.put("insuranceClr",insuranceClr);//V221216
			 
			 tabdata.put("patientId",patientId);
			 tabdata.put("episodeType",episodeType);
			 tabdata.put("episodeId",episodeId);
			 tabdata.put("visitId",visitId);
			 tabdata.put("encounterId",encounterId);
			 tabdata.put("expiryDate",expiryDate);	// Record approval   -  MMS-QH-CRF-0165 Starts
			 tabdata.put("accountSeqNo",accountSeqNo);	
			 tabdata.put("policyTypeCode",policyTypeCode);	
			 tabdata.put("policyNumber",policyNumber);	
			 tabdata.put("custCode",custCode);	
			 tabdata.put("custGroupCode",custGroupCode);	// Record approval   -  MMS-QH-CRF-0165 Ends
			 tabdata.put("effectiveToDate",effectiveToDate); 		//pradeepa - CRF 0165 Record approval
			 tabdata.put("encIdStrNonServLevel",encIdStrNonServLevel);
			 //Added by Rajesh V MMS-SCF-422.1
			 tabdata.put("priority",priority);
			 
			//102.2
			 tabdata.put("isHeaderProcReqd",isHeaderProcReqd);
			 tabdata.put("ins_mode",ins_mode);
			 tabdata.put("upd_mode",upd_mode);
			 tabdata.put("existReqID",existReqID);
			 tabdata.put("membershipNo",membershipNo);
			 //System.out.println("Data in  TABDATA::: "+tabdata); 
			 preApprovalRequestDetailsBean.clearBean();
			 
		}
		catch(Exception e)
		{
			System.out.println("EXCEPTION IN MaintainPrevilageCardServlet TABDATA::: "+e);
			e.printStackTrace();			
		}
		finally{
			/*
			//pstmt = null;
			
			//rst = null; */ //Commented  V210416
			try{//Added  V210416 starts
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();//Added V210416
			}
			catch(Exception e)
			{
				System.out.println("Exception in Billrecapprvalservlet:"+e);
				e.printStackTrace();
			}
			ConnectionManager.returnConnection(con);
		}
		return tabdata;
	}
	
	private HashMap populateTabDataExtInt(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String 		patientId											= 	"";                
		String 		episodeType											=	"";
		String 		episodeId											=	"";                
		String 		visitId												=	"";                
		String 		encounterId											=	"";                
		String 		policyTypeCode										=	"";
		String 		custGroupCode										=	"";                
		String 		custCode											=	"";                
		String 		accountSeqNo										=	"";
		String 		priority											= 	"";
		String 		policyNumber										=	"";                
		String 		billingServiceCode									= 	"";                        
		String 		includedExcluded									= 	"";
		String 		preApprovalNumber									=	"";                
		String 		approvalRequiredDate								=	"";                        
		String 		approvalGivenDate									=	"";   
		String 		approvalStatus										=	"";
		String 		approvalremarks										=	"";
		String 		effectiveFrom										=	"";		
		String 		availableServiceAmount								=	"";
		String 		availableServiceQty									=	"";
		
		String 		reasonCode											=	"";
		String 		patientClass										=	"";                                                                                                                                                              
		String 		episodeEncounterFlag								=	"";                                                                                                                                                                      
		String 		clinicNursingIndicator								=	"";                                                                                                                                                                      
		String 		clinicNursingCode									=	"";                                                                                                                                                              
		String 		specialiltyCode										=	"";                                                                                                                                                              
		String 		sex													=	"";                                                                                                                                              
		String 		ageGroupCode										=	"";                                                                                                                                                              
		String 		effectiveTo											=	"";                                                                                                                                                      
		String 		approvalAmountCapping								=	"";                                                                                                                                                                      
		String 		approvalQuantityCapping								=	"";                                                                                                                                                                      
		String 		approvalGrossNetAmount								=	"";                                                                                                                                                                      
		String 		serviceLevelApprovalFlag							=	"";    
		String 		primaryKeyFacilityId								=	"";             
		String 		primaryKeyModuleId									=	"";     
		String 		primaryKeyMain										=	"";     
		String 		primaryKeyLineNo									=	"";     
		String 		primaryKeyBillingServiceCode						=	"";                     
		String 		primaryKeyBillingServiceItemCode					=	"";
		String  	recalcCharges = "";
		String      approvedQty											=   "";
		String      approvedAmount										=   "";
		String 		expiryDate="";// Record approval   -  MMS-QH-CRF-0165 
		
		String p_preApprovalNumber								=	"";
		String p_approvalGivenDate								=	"";
		String p_approvalStatus									=	"";
		String p_approvalremarks								=	"";
		String p_approvalRequiredDate							=	"";
		String p_approvedQty									=	"";					
		String p_approvedAmount									=	"";
		String p_reasonCode										=	"";
		String effectiveToDate									=	""; 		//pradeepa - CRF 0165 Record approval
		String 	approvalDurationCapping							=	""; //Added V180725-Gayathri/MMS-DM-CRF-0126
		String 	approvedDurationQty								=	""; //Added V180725-Gayathri/MMS-DM-CRF-0126
		String encounterIdNew="";
		String p_Mcn_Number ="";//V220905
		String Mcn_Number ="";//V220905
		String service_loc ="";//V221027                                                                                                                                         
		String encIdStrNonServLevel  	="";
		String  insuranceClr = "";//V221216/TH-KW-CRF-0084.1
		/*V230824 NMC-JD-CRF-0102.2*/
		String filePath="";
		int insert_result=0;
		 String DocUplYN="N";
		 String requestID="";
		 String curSrlno="";
		 String seqNo="";
		 /*V230824 NMC-JD-CRF-0102.2*/
		
		 String[]	arr													= 	null;
		int 	rowCount												=	0;
		
		ArrayList<String[]> 	preApprovalRequestSpecPatientList		=	null;
		//ArrayList<String[]> 	preApprovalRequestDeletePatientList		=	null; //commented V210416
		ArrayList<String[]> 	preApprovalRequestServiceLevelPatientList=	null;
		//ArrayList 	previlageCardHeaderPatientList					=	null;
		Set<String> encounterIdset=new HashSet<String>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt2 = null;
		ResultSet res2=null;
		ResultSet rst = null;
		String authorizedUserId = "";
		
		CallableStatement cstmt = null;
		String sysDateTime="";
		String siteId ="";
		try
		{
			con = ConnectionManager.getConnection();
			preApprovalRequestServiceLevelPatientList					=	new ArrayList();	
			preApprovalRequestSpecPatientList							=	new ArrayList();
			bean_id 													= "PreApprovalRequestDetailsBean";
			bean_name 													= "eBL.PreApprovalRequestDetailsBean";
			PreApprovalRequestDetailsBean preApprovalRequestDetailsBean =  (PreApprovalRequestDetailsBean)PersistenceHelper.getBeanObject(bean_id, bean_name, request);
			filePath=request.getParameter("filePath"); 
			System.out.println("247 filePath "+filePath);
			rowCount=Integer.parseInt(request.getParameter("rows")); 
			System.out.println("247 rowCount "+rowCount);
			patientId										=	checkForNull(request.getParameter("patientId"));
			episodeType										=	checkForNull(request.getParameter("episodeType"));
			episodeId										=	checkForNull(request.getParameter("episodeId"));
			visitId											=	checkForNull(request.getParameter("visitId"));
			encounterId										=	checkForNull(request.getParameter("encounterId"));
			policyTypeCode									=	checkForNull(request.getParameter("policyTypeCode"));
			custGroupCode									=	checkForNull(request.getParameter("custGroupCode"));
			custCode										=	checkForNull(request.getParameter("custCode"));
			accountSeqNo									=	checkForNull(request.getParameter("accountSeqNo"));
			priority										=	checkForNull(request.getParameter("priority"));
			policyNumber									=	checkForNull(request.getParameter("policyNumber"));
			expiryDate										=	checkForNull(request.getParameter("expiryDate"));// Record approval   -  MMS-QH-CRF-0165
			effectiveToDate									=	checkForNull(request.getParameter("effectiveToDate"));		//pradeepa - CRF 0165 Record approval
			authorizedUserId								= 	checkForNull(request.getParameter("authorizedUserId"));
			sysDateTime										= 	checkForNull(request.getParameter("sysDateTime"));
			siteId 											= 	checkForNull(request.getParameter("siteId"));
			recalcCharges       							= 	checkForNull(request.getParameter("recalc_charges"));
			insuranceClr 									=	checkForNull(request.getParameter("insuranceClr"));
			membershipNo									=   checkForNull(request.getParameter("membershipNo"));
			System.out.println("341 recalcCharges "+recalcCharges);
			if("on".equals(recalcCharges)){
				recalcCharges = "Y";
			}
			else{
				recalcCharges = "N";
			}
			System.out.println("345 recalcCharges "+recalcCharges);
			System.out.println("249 patientId "+patientId);
			System.out.println("249 visitId "+visitId);
			System.out.println("249 episodeId "+episodeId);
			System.out.println("249 policyNumber "+policyNumber);
			System.out.println("249 encounterId "+encounterId);
			System.out.println("249 policyTypeCode "+policyTypeCode);
			System.out.println("249 custGroupCode "+custGroupCode);
			System.out.println("249 custCode "+custCode);
			System.out.println("249 accountSeqNo "+accountSeqNo);
			System.out.println("249 priority "+priority);
			
			System.out.println("249 expiryDate "+expiryDate);
			System.out.println("249 effectiveToDate "+effectiveToDate);
			System.out.println("249 authorizedUserId "+authorizedUserId);
			System.out.println("249 sysDateTime "+sysDateTime);
			System.out.println("249 siteId "+siteId);
			
			defaultfileitemfactory = new DefaultFileItemFactory(100,new File(filePath));
			upload = new DiskFileUpload(defaultfileitemfactory);
			isMultipart =  FileUpload.isMultipartContent(request);
			
			
			int afterUpdCnt = 0; 
			boolean addToArr = true;
			String billApproved = "";
			boolean site3TierAlmoFeature = false;
			boolean enableMCNNumber = false;//V220905
			boolean enableQueuePKID = false;//new 20.7
			String locationStr ="";//new 20.7
			String sFileSeparator = "";//V230814
			try {
				site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");//Added V200228 SHIKHA 3TierAlmoFeature
			} catch(Exception ex) {
				System.err.println("Error in BillingRecordApprovalServlet.java for getting site3TierAlmoFeature Connection: "+ex);
				ex.printStackTrace();
			}
			//Added V200228 SHIKHA 3TierAlmoFeature & AAKH-SCF-0404.1
			
			try {
				enableMCNNumber = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENB_MCN_REQ_NUM_FOR_SERV_APPR");
				System.out.println("enableMCNNumber ,servlet-->"+enableMCNNumber);
			} catch(Exception e) {
				System.err.println("Error in BillingRecordApprovalServlet.java for getting enableMCNNumber Connection: "+e);
				e.printStackTrace();
			}//V220905
			try {
				enableQueuePKID = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","ENB_QMS_IN_BILL_GEN");
				System.out.println("enableQueuePKID ,servlet-->"+enableMCNNumber);
			} catch(Exception e) {
				System.err.println("Error in BillingRecordApprovalServlet.java for getting enableQueuePKID Connection: "+e);
				e.printStackTrace();
			}/*V230824 NMC-JD-CRF-0102.2*/
			
			try{				
				pstmt = con.prepareStatement("Select count(*) total_cnt from BL_INS_PAYER_APPR_DTL where patient_id = ? "+ 
											" and added_date > to_date(?,'dd/mm/yyyy HH24:MI:SS')");
				pstmt.setString(1, patientId);
				pstmt.setString(2, sysDateTime);
				rst = pstmt.executeQuery();
				if(rst != null && rst.next()){
					afterUpdCnt = rst.getInt("total_cnt");
				}
			}
			catch(Exception e){
				afterUpdCnt = 0;
				e.printStackTrace();
				System.err.println("Error in BillingRecordApprovalServlet.java for getting afterUpdCnt Connection: "+e);
			}
			
			//arr 											= 	new String[46];//V220905
			try{
				this.out = response.getWriter();
				tabdata														=	new HashMap();
				int count=0;
				int i=0;
			//	if(isMultipart){
					items = upload.parseRequest(request);
					int column=(items.size()/(rowCount-2))+(items.size()%(rowCount-2));
					iter = items.iterator();				
					System.out.println("256");
					while(iter.hasNext())
					{
						Item = (FileItem) iter.next();	
						System.out.println("260 column "+column); 
						System.out.println("count "+count); 
						System.out.println("i "+i); 
						if(Item.isFormField())
						{
							System.out.println("263 ");
							name = (String) Item.getFieldName();	
							System.out.println("265 name=>"+name);
							value = (String) Item.getString();
							System.out.println("265 value=>"+value); 
							
							if(name.equals("rowCount")){ 
								rowCount = Integer.parseInt(checkForNull(value));
								System.out.println("274 rowCount "+rowCount);
							}
							else if(name.equals("billing_service_code"+i)){
								billingServiceCode = checkForNull(value);
								System.out.println("274 billingServiceCode "+billingServiceCode);
							}
							else if(name.equals("included_excluded"+i)){
								includedExcluded = checkForNull(value);
							}
							else if(name.equals("approval_number"+i)) {
								preApprovalNumber = checkForNull(value);
							}
							else if(name.equals("approved_date"+i)) {
								approvalGivenDate = checkForNull(value);
							}
							else if(name.equals("approval_status"+i)){
								approvalStatus = checkForNull(value);
							}
							else if(name.equals("approval_remarks"+i)) {
								approvalremarks = checkForNull(value);
							}
							else if(name.equals("app_req_date"+i)) {
								approvalRequiredDate = checkForNull(value);
							}
							else if(name.equals("approvedQty"+i)) {
								approvedQty = checkForNull(value);
							}
							else if(name.equals("approvedAmount"+i)) {
								approvedAmount = checkForNull(value);
							}
							else if(name.equals("reason"+i)){
								reasonCode = checkForNull(value);
							}
							else if(name.equals("p_approval_number"+i)) {
								p_preApprovalNumber = checkForNull(value);
							}
							else if(name.equals("p_approved_date"+i)) {
								p_approvalGivenDate = checkForNull(value);
							}
							else if(name.equals("p_approval_status"+i)) {
								p_approvalStatus =checkForNull(value);
							}
							else if(name.equals("p_approval_remarks"+i)){
								p_approvalremarks = checkForNull(value);
							}
							else if(name.equals("p_app_req_date"+i)){
								p_approvalRequiredDate =checkForNull(value);
							}
							else if(name.equals("p_approvedQty"+i)){
								p_approvedQty = checkForNull(value);
							}
							else if(name.equals("p_approvedAmount"+i)){
								p_approvedAmount = checkForNull(value);
							}
							else if(name.equals("p_reason"+i)) {
								p_reasonCode = checkForNull(value);
							}
							else if(name.equals("p_MCN_number"+i)){
								p_Mcn_Number = checkForNull(value);
							}
							else if(name.equals("MCN_number"+i)){
								Mcn_Number = checkForNull(value);
							}
							else if(name.equals("effective_from"+i)) {
								effectiveFrom = checkForNull(value);
							}
							else if(name.equals("available_service_amount"+i)) {
								availableServiceAmount	= checkForNull(value);
							}
							else if(name.equals("available_service_qty"+i)) {
								availableServiceQty		=checkForNull(value);
							}
							else if(name.equals("patient_class"+i)) {
								patientClass	= checkForNull(value);
							}
							else if(name.equals("episode_encounter_flag"+i)){
								episodeEncounterFlag		= checkForNull(value);
							}
							else if(name.equals("clinic_nursing_ind"+i)) {
								clinicNursingIndicator	= checkForNull(value);
							}
							else if(name.equals("clinic_nursing_code"+i)) {
								clinicNursingCode	=checkForNull(value);
							}
							else if(name.equals("specilaity_code"+i)) {
								specialiltyCode	= checkForNull(value);
							}
							else if(name.equals("sex"+i)) {
								sex	= checkForNull(value);
							}
							else if(name.equals("age_group_code"+i)){
								ageGroupCode	= checkForNull(value);
							}
							else if(name.equals("effective_to"+i)) {
								effectiveTo	= checkForNull(value);
							}
							else if(name.equals("preapproval_amt_capping"+i))  {
								approvalAmountCapping	= checkForNull(value);
							}
							else if(name.equals("preapproval_qty_capping"+i)){
								approvalQuantityCapping	=checkForNull(value);
							}
							else if(name.equals("preapproval_amt_gross_net"+i)){
								approvalGrossNetAmount = checkForNull(value);
							}
							else if(name.equals("service_level_approval"+i))  {
								serviceLevelApprovalFlag = checkForNull(value);
								System.out.println("547 serviceLevelApprovalFlag=>"+serviceLevelApprovalFlag); 
							}
							else if(name.equals("primary_key_facility_id"+i)){
								primaryKeyFacilityId	= checkForNull(value);
							}
							else if(name.equals("primary_key_module_id"+i)) {
								primaryKeyModuleId = checkForNull(value);
								System.out.println("274 primaryKeyModuleId "+primaryKeyModuleId);
							}
							else if(name.equals("primary_key_main"+i)) {
								primaryKeyMain	= checkForNull(value);
							}
							else if(name.equals("primary_key_line_no"+i)) {
								primaryKeyLineNo	=checkForNull(value);
							}
							else if(name.equals("primary_key_bling_service_code"+i)){
								primaryKeyBillingServiceCode		= checkForNull(value);
							}
							else if(name.equals("primary_key_service_item_code"+i)) {
								primaryKeyBillingServiceItemCode	= checkForNull(value);
							}
							else if(name.equals("encounter_id"+i)){
								encounterIdNew= checkForNull(value);
							}
							else if(name.equals("preapproval_dur_capping"+i))  {
								approvalDurationCapping= checkForNull(value);
							}
							else if(name.equals("approved_dur_qty"+i)) {
								approvedDurationQty=checkForNull(value);
							}else if(name.equals("seqNo"+i)) {
								seqNo=checkForNull(value);
							} 
							else if(name.equals("requestID"+i))  {
								requestID= checkForNull(value);
								System.out.println("approvalStatus "+approvalStatus +" requestID "+requestID);
								if(!requestID.equals("") && approvalStatus.equalsIgnoreCase("C")){
									if(!existReqID.contains(requestID)){
										existReqID=requestID+"~";
									}
									isHeaderProcReqd = "Y";
									upd_mode = "Y";
									//P_REQUEST_TYPE = "SRPREAUTHCLA";
									System.out.println("existReqID "+existReqID);
								}else if(requestID.equals("") && approvalStatus.equalsIgnoreCase("S")){
									isHeaderProcReqd = "Y";
									ins_mode="Y";
								//	P_REQUEST_TYPE = "SRPREAUTHREQ";
								}
								System.out.println("isHeaderProcReqd "+isHeaderProcReqd +" upd_mode "+upd_mode+" ins_mode"+ins_mode);
								
							}
							else if(name.equals("curSrlno"+i)) {
								curSrlno=checkForNull(value);
							}//102.2 requestID/curSrlno field
							else if(name.equals("p_Loc_code"+i)) {
								service_loc = checkForNull(value);
								i++;
							}
							else if(name.equals("billApprovedYn"+i)) {
								billApprovedYn= checkForNull(value);
							}
							else if(name.equals("DocUplYN"+i)) {
								DocUplYN= checkForNull(value);
							}
						
							
							if(i > count){
								arr 											= 	new String[49];//V220905 //102.2
								
								System.out.println("595 count "+count);
								/*if("on".equals(recalcCharges)){
									recalcCharges = "Y";
								}
								else{
									recalcCharges = "N";
								}*/
								System.out.println("595 recalcCharges "+recalcCharges);
								
								 if((approvalRequiredDate.length() > 0 &&	approvalRequiredDate.equals(p_approvalRequiredDate)== false)||
											(approvalGivenDate.length()    > 0 &&	approvalGivenDate.equals(p_approvalGivenDate)== false)||
											(preApprovalNumber.length()    > 0 &&	preApprovalNumber.equals(p_preApprovalNumber)== false)||
											(approvalStatus.length()       > 0 &&	approvalStatus.equals(p_approvalStatus)== false)||		
											(approvedQty.equals(p_approvedQty)== false)||	
											(approvedAmount.equals(p_approvedAmount)== false)||	
											(reasonCode.length()           > 0 &&	reasonCode.equals(p_reasonCode)== false)||	
											(approvalremarks.length()      > 0 &&	approvalremarks.equals(p_approvalremarks)== false) ||
											(Mcn_Number.length()      > 0 &&	Mcn_Number.equals(p_Mcn_Number)== false) ||(DocUplYN.equals("Y")))
								
									
							{
									 System.out.println("615  ");
									 System.out.println("siteId  "+siteId);
									 System.out.println("afterUpdCnt  "+afterUpdCnt);
									 System.out.println("site3TierAlmoFeature  "+site3TierAlmoFeature);
											
									 addToArr = true;
								if(afterUpdCnt >0 && ("ALMO".equalsIgnoreCase(siteId) || site3TierAlmoFeature == true)){//Added V200228 SHIKHA 3TierAlmoFeature & AAKH-SCF-0404.1
									pstmt = con.prepareStatement("Select bl_charge.bl_get_bill_approved_yn(?,?,?,?,?) bill_approved_yn from dual");
									pstmt.setString(1, facilityId);
									pstmt.setString(2, primaryKeyModuleId);
									pstmt.setString(3, primaryKeyMain);
									pstmt.setString(4, primaryKeyLineNo);
									pstmt.setString(5, primaryKeyBillingServiceCode);
									rst = pstmt.executeQuery();
									if(rst != null && rst.next()){
										billApproved = rst.getString("bill_approved_yn");
										if("Y".equals(billApproved)){
											addToArr = false;
										}
									}
								}
								
								if("Y".equals(billApprovedYn)){
									addToArr = false;
								}
								System.out.println("addToArr 641 "+addToArr);
								System.out.println("serviceLevelApprovalFlag 641 "+serviceLevelApprovalFlag);
								if(addToArr){
								if(serviceLevelApprovalFlag!=null && serviceLevelApprovalFlag.equalsIgnoreCase("Y")) 
								 {
									System.out.println("patientId  "+patientId);
									System.out.println("episodeType  "+episodeType);
									System.out.println("709 policyTypeCode "+policyTypeCode);
									System.out.println("709 custGroupCode "+custGroupCode);
									System.out.println("709 custCode "+custCode);
										
										arr[0]											=	patientId;
										arr[1]											=	episodeType;
										arr[2]											=	episodeId;
										arr[3]											=	visitId;
										arr[4]											=	encounterId;
										arr[5]											=	policyTypeCode;
										arr[6]											=	custGroupCode;
										arr[7]											=	custCode;
										arr[8]											=	accountSeqNo;
										arr[9]											=	priority;
										arr[10]											=	policyNumber;
										arr[11]											=	billingServiceCode;
										arr[12]											=	includedExcluded;
										arr[13]											=	preApprovalNumber;
										arr[14]											=	approvalRequiredDate;
										arr[15]											=	approvalGivenDate;
										arr[16]											=	approvalStatus;
										arr[17]											=	approvalremarks;
										arr[18]											=	effectiveFrom;
										arr[19]											=	availableServiceAmount;
										arr[20]											=	reasonCode;
										arr[21]											=	patientClass;
										arr[22]											=	episodeEncounterFlag;
										arr[23]											=	clinicNursingIndicator;
										arr[24]											=	clinicNursingCode;
										arr[25]											=	specialiltyCode;
										arr[26]											=	sex;
										arr[27]											=	ageGroupCode;
										arr[28]											=	effectiveTo;
										arr[29]											=	approvalAmountCapping;
										arr[30]											=	approvalQuantityCapping;
										arr[31]											=	approvalGrossNetAmount;
										arr[32]											=	serviceLevelApprovalFlag;
										arr[33]											=	primaryKeyFacilityId;
										arr[34]											=	primaryKeyModuleId;
										arr[35]											=	primaryKeyMain;
										arr[36]											=	primaryKeyLineNo;
										arr[37]											=	primaryKeyBillingServiceCode;
										arr[38]											=	primaryKeyBillingServiceItemCode;
										arr[39]											=	approvedQty;
										arr[40]											=	approvedAmount;
										arr[41]											=	availableServiceQty;
										arr[42]											=	encounterIdNew;
										arr[43]											=	approvalDurationCapping; //Added V180725-Gayathri/MMS-DM-CRF-0126
										arr[44]											=	approvedDurationQty; //Added V180725-Gayathri/MMS-DM-CRF-0126
										arr[45]											=	Mcn_Number; //V220905
										arr[46]											=	requestID; //102.2
										arr[47]											=	curSrlno; //102.2
										arr[48]											=	seqNo; //102.2
										
										locationStr+=service_loc+"~";
										System.out.println("service_loc,456-> "+service_loc);
										System.out.println("encounterIdNew "+encounterIdNew);
										System.out.println("705 arr "+arr[0]+" arr[1] "+arr[1]+" arr[2] "+arr[2]);
										System.out.println(arr[3]+" ~ "+arr[4]+" ~ "+arr[5]+" ~ "+arr[6]+" ~ "+arr[7]+" ~ "+arr[8]);
										System.out.println(arr[9]+" ~ "+arr[10]+" ~ "+arr[11]+" ~ "+arr[12]+" ~ "+arr[13]+" ~ "+arr[14]);
										System.out.println(arr[15]+" ~ "+arr[16]+" ~ "+arr[17]+" ~ "+arr[18]+" ~ "+arr[19]+" ~ "+arr[20]);
										System.out.println(arr[21]+" ~ "+arr[22]+" ~ "+arr[23]+" ~ "+arr[24]+" ~ "+arr[25]+" ~ "+arr[26]);
										
										System.out.println(arr[27]+" ~ "+arr[28]+" ~ "+arr[29]+" ~ "+arr[30]+" ~ "+arr[31]+" ~ "+arr[32]);
										System.out.println(arr[33]+" ~ "+arr[34]+" ~ "+arr[35]+" ~ "+arr[36]+" ~ "+arr[37]+" ~ "+arr[38]);
										System.out.println(arr[39]+" ~ "+arr[40]+" ~ "+arr[41]+" ~ "+arr[42]+" ~ "+arr[43]+" ~ "+arr[44]);
										System.out.println(arr[45]+"~"+arr[46]+"~"+arr[47]+"~"+arr[48]);
										
										System.out.println("720 arr "+arr);
										preApprovalRequestSpecPatientList.add(arr);
										encounterIdset.add(encounterIdNew);
										System.out.println("encounterIdset "+encounterIdset);
										System.out.println("preApprovalRequestSpecPatientList "+preApprovalRequestSpecPatientList);
								 	}
								else					
								 {
									 	arr[0]											=	patientId;
										arr[1]											=	episodeType;
										arr[2]											=	episodeId;
										arr[3]											=	visitId;
										arr[4]											=	encounterId;
										arr[5]											=	policyTypeCode;
										arr[6]											=	custGroupCode;
										arr[7]											=	custCode;
										arr[8]											=	accountSeqNo;
										arr[9]											=	priority;
										arr[10]											=	policyNumber;
										arr[11]											=	billingServiceCode;
										arr[12]											=	includedExcluded;
										arr[13]											=	preApprovalNumber;
										arr[14]											=	approvalRequiredDate;
										arr[15]											=	approvalGivenDate;
										arr[16]											=	approvalStatus;
										arr[17]											=	approvalremarks;
										arr[18]											=	effectiveFrom;
										arr[19]											=	availableServiceAmount;
										arr[20]											=	reasonCode;
										arr[21]											=	patientClass;
										arr[22]											=	episodeEncounterFlag;
										arr[23]											=	clinicNursingIndicator;
										arr[24]											=	clinicNursingCode;
										arr[25]											=	specialiltyCode;
										arr[26]											=	sex;
										arr[27]											=	ageGroupCode;
										arr[28]											=	effectiveTo;
										arr[29]											=	approvalAmountCapping;
										arr[30]											=	approvalQuantityCapping;
										arr[31]											=	approvalGrossNetAmount;
										arr[32]											=	serviceLevelApprovalFlag;
										arr[33]											=	primaryKeyFacilityId;
										arr[34]											=	primaryKeyModuleId;
										arr[35]											=	primaryKeyMain;
										arr[36]											=	primaryKeyLineNo;
										arr[37]											=	primaryKeyBillingServiceCode;
										arr[38]											=	primaryKeyBillingServiceItemCode;
										arr[39]											=	approvedQty;
										arr[40]											=	approvedAmount;
										arr[41]											=	availableServiceQty;							
										arr[42]											= encounterIdNew;
										arr[43]											=	approvalDurationCapping; //Added V180725-Gayathri/MMS-DM-CRF-0126
										arr[44]											=	approvedDurationQty; //Added V180725-Gayathri/MMS-DM-CRF-0126
										arr[45]											=	Mcn_Number; //V220905
										arr[46]											=	requestID; //102.2
										arr[47]											=	curSrlno; //102.2
										arr[48]											=	seqNo; //102.2
										
										System.out.println("IN service_loc 2:::: "+service_loc);
										locationStr+=service_loc+"~";
										System.out.println("772 arr "+arr[0]+" arr[1] "+arr[1]+" arr[2] "+arr[2]);
										System.out.println(arr[3]+" ~ "+arr[4]+" ~ "+arr[5]+" ~ "+arr[6]+" ~ "+arr[7]+" ~ "+arr[8]);
										System.out.println(arr[9]+" ~ "+arr[10]+" ~ "+arr[11]+" ~ "+arr[12]+" ~ "+arr[13]+" ~ "+arr[14]);
										System.out.println(arr[15]+" ~ "+arr[16]+" ~ "+arr[17]+" ~ "+arr[18]+" ~ "+arr[19]+" ~ "+arr[20]);
										System.out.println(arr[21]+" ~ "+arr[22]+" ~ "+arr[23]+" ~ "+arr[24]+" ~ "+arr[25]+" ~ "+arr[26]);
										
										System.out.println(arr[27]+" ~ "+arr[28]+" ~ "+arr[29]+" ~ "+arr[30]+" ~ "+arr[31]+" ~ "+arr[32]);
										System.out.println(arr[33]+" ~ "+arr[34]+" ~ "+arr[35]+" ~ "+arr[36]+" ~ "+arr[37]+" ~ "+arr[38]);
										System.out.println(arr[39]+" ~ "+arr[40]+" ~ "+arr[41]+" ~ "+arr[42]+" ~ "+arr[43]+" ~ "+arr[44]);
										System.out.println(arr[45]+"~"+arr[46]+"~"+arr[47]+"~"+arr[48]);
										System.out.println("777 arr "+arr);
										preApprovalRequestServiceLevelPatientList.add(arr);
										encounterIdset.add(encounterIdNew);
										System.out.println("encounterIdset 2 "+encounterIdset);
										System.out.println("preApprovalRequestServiceLevelPatientList "+preApprovalRequestServiceLevelPatientList);
						
								 	}
								}
							}
								count++;
							}
						}else{/*V230824 NMC-JD-CRF-0102.2*/
							if(siteSpecUploadDoc){
							  fileItem = Item;						
							  fileName = fileItem.getName();	
							  if(!fileName.equals("")){
								System.out.println("fileName 456-"+fileName);
								StringTokenizer strTok = new StringTokenizer(fileName,".");
								while(strTok.hasMoreTokens())
								{
									fileExt = strTok.nextToken();
									System.out.println("fileExt 469-"+fileExt);
								}
								
								cstmt2 = con.prepareCall("{?=call blcommon.bl_get_upld_filename(?,?,?,?)}");
								cstmt2.registerOutParameter(1,java.sql.Types.VARCHAR);
								cstmt2.setString(2, facilityId);
								cstmt2.setString(3, episodeId);
								cstmt2.setString(4, visitId);
								cstmt2.registerOutParameter(5,java.sql.Types.NUMERIC);
								cstmt2.execute();
								//String filename="";
								//filename=cstmt2.getString(1);
								interfaceFileId=cstmt2.getString(1);
								docSrlNo=cstmt2.getLong(5);
								System.out.println("docSrlNo " + docSrlNo);
								
								cstmt2 = null;
								res2 = null;
								
								//interfaceFileId=episodeId+"_"+visitId+"_"+billingServiceCode+"_"+docSrlNo+"."+fileExt;
								//interfaceFileId=filename;
								System.out.println("513 primaryKeyLineNo "+primaryKeyLineNo);
								System.out.println("513 primaryKeyMain "+primaryKeyMain);
								System.out.println("513 approvalStatus "+approvalStatus);
								System.out.println("513 rowCount "+rowCount);
								System.out.println("513 interfaceFileId "+interfaceFileId);
								sFileSeparator=System.getProperty("file.separator");
								System.out.println("513 filePath "+filePath);
								java.io.File uploadFile = new File(filePath + sFileSeparator +interfaceFileId);
								System.out.println("514 before write");
								Item.write(uploadFile);
								System.out.println("514 after write");
								System.out.println("uploadfile len1 "+uploadFile.length());

								if(uploadFile.length()>0){
									pstmt=con.prepareStatement("UPDATE BL_INS_REC_APPR_TRK SET SRLNO=?,DOCUMENT_PATH=?,FILE_NAME=?,UPLOAD_STATUS=?,PRE_APP_STATUS='C',MODIFIED_BY_ID=?" +
													",MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE  operating_facility_id=? and patient_id=? and BLNG_SERV_CODE=? and requestid=? and ITEM_SEQNO=?");
									
									pstmt.setString(1,String.valueOf(docSrlNo));
									pstmt.setString(2,filePath);
									pstmt.setString(3,interfaceFileId);
									pstmt.setString(4,"Y");
									pstmt.setString(5,login_user);
									pstmt.setString(6,client_ip_address);
									pstmt.setString(7,facilityId);
									pstmt.setString(8,facilityId);
									pstmt.setString(9,patientId);
									pstmt.setString(10,billingServiceCode);
									pstmt.setString(11,requestID);
									pstmt.setString(12,seqNo);
									System.out.println("before execute upl");
									insert_result = pstmt.executeUpdate();
									System.out.println("after execute upl "+insert_result);
								}
							}
						}
					}
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			//new  crf-20.7
			System.out.println("enableQueuePKID "+enableQueuePKID);
			 if(enableQueuePKID){
				  String finalLocStr="";
					try{
						String[] servloc=locationStr.split("~");
						 Set al = new HashSet();
						for(int k=0;k<servloc.length;k++){
							al.add(servloc[k]);
							}
						System.out.println("al"+al);
						String[] locCode= (String[]) al.toArray(new String[al.size()]);
						for(int j=0;j<locCode.length;j++){
							finalLocStr+=locCode[j]+"~";
						}
						System.out.println(facilityId+" facilityId");
						System.out.println(patientId+" patientId");
						System.out.println(episodeId+" episodeId");
						System.out.println(episodeType+" episodeType");
						System.out.println(visitId+" visitId");
						System.out.println(finalLocStr+" finalLocStr");
						
							cstmt = con.prepareCall("{ call bl_release_qms_token(?,?,?,?,?,?)}");
							cstmt.setString(1, facilityId);
							cstmt.setString(2, patientId);
							cstmt.setString(3, episodeType);
							cstmt.setString(4, episodeId);
							cstmt.setString(5, visitId);
							cstmt.setString(6, finalLocStr);
							System.out.println("release_token before exec ");
							cstmt.execute();
							System.out.println("release_token after exec ");
				
					}catch(Exception e){
						System.err.println("The Exception in release_token->"+e);
					}finally{
						//cstmt.close();
					}
			 }
			 
			 
			if(encounterIdNew.length()>0){
			Iterator iterator=encounterIdset.iterator();
			while(iterator.hasNext())
			
			{
				
				encIdStrNonServLevel=iterator.next()+"/"+encIdStrNonServLevel;

			}
			}
			System.out.println("encounter id str "+encIdStrNonServLevel);


			 tabdata.put("preApprovalRequestSpecPatientList", preApprovalRequestSpecPatientList);
			 tabdata.put("preApprovalRequestServiceLevelPatientList", preApprovalRequestServiceLevelPatientList); 
			 tabdata.put("FACILITY_ID",facilityId);
			 tabdata.put("client_ip_address",client_ip_address);
			 if(!"".equals(authorizedUserId)){
				 tabdata.put("login_user",authorizedUserId);
				 System.out.println("Authorized ID -> "+authorizedUserId);
			 }
			 else{
				 tabdata.put("login_user",login_user);
				 System.out.println("Login ID -> "+login_user);
			 }
			 
			 tabdata.put("locale",locale);
			 tabdata.put("recalcCharges",recalcCharges);
			 tabdata.put("insuranceClr",insuranceClr);//V221216
			 
			 tabdata.put("patientId",patientId);
			 tabdata.put("episodeType",episodeType);
			 tabdata.put("episodeId",episodeId);
			 tabdata.put("visitId",visitId);
			 tabdata.put("encounterId",encounterId);
			 tabdata.put("expiryDate",expiryDate);	// Record approval   -  MMS-QH-CRF-0165 Starts
			 tabdata.put("accountSeqNo",accountSeqNo);	
			 tabdata.put("policyTypeCode",policyTypeCode);	
			 tabdata.put("policyNumber",policyNumber);	
			 tabdata.put("custCode",custCode);	
			 tabdata.put("custGroupCode",custGroupCode);	// Record approval   -  MMS-QH-CRF-0165 Ends
			 tabdata.put("effectiveToDate",effectiveToDate); 		//pradeepa - CRF 0165 Record approval
			 tabdata.put("encIdStrNonServLevel",encIdStrNonServLevel);
			 tabdata.put("priority",priority);
			 //102.2
			 tabdata.put("isHeaderProcReqd",isHeaderProcReqd);
			 tabdata.put("ins_mode",ins_mode);
			 tabdata.put("upd_mode",upd_mode);
			 tabdata.put("existReqID",existReqID);
			 tabdata.put("membershipNo",membershipNo);
			 System.out.println("tabdata 993 -> "+tabdata);
			 preApprovalRequestDetailsBean.clearBean();
			
		}catch(Exception e)
		{
			System.err.println("EXCEPTION IN MaintainPrevilageCardServlet TABDATA::: "+e);
			e.printStackTrace();			
		}
		finally{
			try{
				if(con!=null) con.commit();
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in Billrecapprvalservlet:"+e);
				e.printStackTrace();
			}
			ConnectionManager.returnConnection(con);
		}
		return tabdata;
	}
	/**
	 * @param str
	 * @return
	 */
	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	/**
	 * @param str
	 * @param defaultVal
	 * @return
	 */
	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}

	/**
	 * @return
	 */
	private boolean isLocalEJB(){
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
			return false;
	}
	
	private String formatDate(String inputDate){
		if(inputDate==null || inputDate.equals("")){
			return "";
		}
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Timestamp inputTimeStamp = null;
	    String outputDate=inputDate;
	    long longTimeStamp = 0;
	    inputTimeStamp = Timestamp.valueOf(inputDate);
	    longTimeStamp = inputTimeStamp.getTime();
	    outputDate=sdf.format(longTimeStamp);
	    return outputDate;
	}
}
