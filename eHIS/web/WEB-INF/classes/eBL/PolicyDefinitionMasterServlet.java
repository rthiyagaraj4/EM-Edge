
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
1            V210416             17021        	Common-ICN-0009-TF	           Nandhini M
2			 V211027			 18595	        MMS-DM-CRF-0185			      Mohana Priya K
3			 V220223			 28931		BL-Regression-Policy Definition   Mohana Priya K
4			 V220324			 27973			MMS-ME-SCF-0046-TF			  Mohana Priya K
5 			 V221017				 				MMS-DM-CRF-0209 			  Namrata Charate
-----------------------------------------------------------------------------------------------
 */
package eBL;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.PersistenceHelper;
import eBL.Common.BlRepository;
import eCommon.XSSRequestWrapper; //V220324

/**
 * Servlet implementation class PolicyDefinitionMasterServlet
 */
public class PolicyDefinitionMasterServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; // commented against V210416.
	Connection con = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;
	PolicyInsuranceMasterBean outPatBean = null;
	PolicyInsuranceMasterBean inPatBean = null;
	PolicyInsuranceMasterBean externalBean = null;
	java.util.Properties p;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String str_error_level = "", str_sysmesage_id="", str_error_text="";
	HttpSession session; 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String oldEndDate="";
	String userChangedEndDate = "";
	String locale = "";
	Locale loc = null;
	ResourceBundle rb = null;
	ResourceBundle rb1 = null;
	ResourceBundle rb2 = null;
	Boolean siteSpecPolDefIncExc=false;//Added against NMC-JD-CRF-0045
	Boolean SiteSpecGroupService=false; //073838
	Boolean siteSpecDiagBasedCopay = false; // MOHE-CRF-0114

	String gppolicy  = "";
	String payerRefCode  = ""; //V211027
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PolicyDefinitionMasterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	private String checkForNull(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
	
    private String returnVal(String inputString,String outputString) {
		return (inputString == null) ? outputString : inputString;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		con = ConnectionManager.getConnection(request);
		//V220324 Starts
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		//V220324 ends
		//Added against NMC-JD-CRF-0045
		siteSpecPolDefIncExc = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_DEF_REMARKS_ALLOWED");//Added against NMC-JD-CRF-0045
		SiteSpecGroupService = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_GROUP_SRVICE_IND");//073838
		siteSpecDiagBasedCopay = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DIAG_BASED_COPAY_DEFN");//MOHE-CRF-0114
	
		if(siteSpecPolDefIncExc){
			gppolicy=request.getParameter("GroupPolicy1");//Added against NMC-JD-CRF-0045 --20-08-2020
		}
			
		try{
			session = request.getSession(false);
			locale = (String)session.getAttribute("LOCALE");
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			rb1 = ResourceBundle.getBundle("eSM.resources.Messages",loc);
			rb2 = ResourceBundle.getBundle("eBL.resources.MessagesExtOne",loc);
			oldEndDate = checkForNull(request.getParameter("oldEndDate"));
			HashMap returnMap = new HashMap();
			//HashMap returnMapAll = new HashMap(); // commented against V210416
			String beanId = "bl_PolicyInsuranceMasterBean";
			String beanName = "eBL.PolicyInsuranceMasterBean";
			
			PolicyInsuranceMasterBean policyBean = (PolicyInsuranceMasterBean)PersistenceHelper.getBeanObject(beanId, beanName, request);	
			
			returnMap=insertHeaderDetails(request,response,policyBean);
			
			if(((Boolean) returnMap.get("status")).booleanValue()){
				returnMap=insertPolicyDetails(request,response,policyBean);
			}
			
			if(((Boolean) returnMap.get("status")).booleanValue()){
				returnMap=insertPreApprovalDetails(request,response,policyBean);
			}
			
			if (((Boolean) returnMap.get("status")).booleanValue()) 
			{
				con.commit();
			}
			else 
			{
				con.rollback();				
			}
			
			String mapValue = "";
			String error = "";
			int err_val = 1;
			for (Iterator iterator = returnMap.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				if(!("status".equals(type))){
					mapValue = (String) returnMap.get(type);
					if(mapValue != null){
						//if(mapValue.contains("Error")){
							error = error+mapValue+"<br/>";
							err_val = 2;
						//}				
					}
				}				
			}
			if(error.length()==0){
				try{
					error = rb1.getString("RECORD_INSERTED");
				}
				catch(Exception rbException){
					rbException.printStackTrace();
					System.err.println("Exceprion in RB ->"+rbException);
					error = "APP-SM0070 Operation Completed Successfully ....";	
				}
				//error = "Operation Completed Sucessfully";
			}
			else{
				error = "Record not saved"+"<br/>"+error;
			}
			String calledForm = request.getParameter("calledForm") == null ? "" : request.getParameter("calledForm");//Added V191016-Aravindh/NMC-JD-CRF-0010.2
			if("policyApproval".equals(calledForm)) {
				response.sendRedirect("../eCommon/jsp/error.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ));
			} else {
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
			}
		}
		catch(Exception e){
			try{
				con.rollback();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
	}

	private HashMap insertPreApprovalDetails(HttpServletRequest request,
			HttpServletResponse response, PolicyInsuranceMasterBean policyBean) 
	{
		HashMap returnMap = new HashMap();
		boolean insertable = false;
	try{
		HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = policyBean.getPolicyMap();
		con.setAutoCommit(false);
		List<PolicyInsuranceMasterBean> preAppList = null; 
		if(!(policyMap == null || policyMap.isEmpty())){
			preAppList = policyMap.get("preApproval");
			if(preAppList == null){
				preAppList = new ArrayList<PolicyInsuranceMasterBean>();
				outPatBean = new PolicyInsuranceMasterBean();
				preAppList.add(outPatBean);
			}
		}
		else{
			policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
			preAppList = new ArrayList<PolicyInsuranceMasterBean>();
			outPatBean = new PolicyInsuranceMasterBean();
			preAppList.add(outPatBean);		
		}
		//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020  ADDED ONE PARAMETER CALLED GroupRservice TO INSERT AND UPDATE
		String preAppQueryIns = "{ call   blinspolicycoverage.insert_preapproval_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
		String preAppQueryUpd = "{ call   blinspolicycoverage.update_preapproval_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
		String preAppQueryDel = "{ call   blinspolicycoverage.delete_preapproval_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
		int i=1;
		for(PolicyInsuranceMasterBean outPatBean : preAppList)
		{
			if("N".equals(outPatBean.getDelFlag())){
				if("I".equals(checkForNull(outPatBean.getStatus()))){						
					if(("".equals(checkForNull(outPatBean.getEpisodeEncounter())) && "".equals(checkForNull(outPatBean.getPatClass())) && "".equals(checkForNull(outPatBean.getAgeGroup())) && "".equals(checkForNull(outPatBean.getGender()))  && "".equals(checkForNull(outPatBean.getClinicNursCode())) && "".equals(checkForNull(outPatBean.getSpecCode())) && "".equals(checkForNull(outPatBean.getBillServCode())))){
					}
					else{
						if(!("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getAgeGroup())) || "".equals(checkForNull(outPatBean.getGender()))  || "".equals(checkForNull(outPatBean.getClinicNursCode())) || "".equals(checkForNull(outPatBean.getSpecCode())) || "".equals(checkForNull(outPatBean.getBillServCode())) || "".equals(checkForNull(outPatBean.getStartDate())))){
							cstmt = con.prepareCall(preAppQueryIns);
							
							cstmt.setString(1, policyBean.getFacilityId());
							cstmt.setString(2, policyBean.getPayerGroupCode());
							cstmt.setString(3, policyBean.getPolicyTypeCode());
							cstmt.setString(4, policyBean.getPayerCode());
							cstmt.setString(5, outPatBean.getBillServCode());
							cstmt.setString(6, outPatBean.getType());
							cstmt.setString(7, outPatBean.getPatClass());
							cstmt.setString(8, outPatBean.getEpisodeEncounter());
							cstmt.setString(9, outPatBean.getClinicNurs());
							cstmt.setString(10, outPatBean.getClinicNursCode());
							cstmt.setString(11, outPatBean.getSpecCode());
							cstmt.setString(12, outPatBean.getServLimit());								
							cstmt.setString(13, outPatBean.getPreApprAmtCapping());
							cstmt.setString(14, outPatBean.getPreApprQtyCapping());
							
							if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
								
								cstmt.setString(15, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
								cstmt.setDate(15, fromDt);
								
							}
							if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
								//Added against NMC-JD-CRF-0045 --20-08-2020
								if(siteSpecPolDefIncExc && "Y".equals(gppolicy)){
									cstmt.setString(16, null);
								}else{
								//cstmt.setString(16, null); //Commented V182704-Subha/AAKH-SCF-0358
								//Added V182704-Subha/AAKH-SCF-0358/Starts
									
									Date toDate = new Date(sdf.parse(policyBean.getEndDate()).getTime());
									cstmt.setDate(16, toDate);
									
								//Added V182704-Subha/AAKH-SCF-0358/Ends
								}
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
								cstmt.setDate(16, toDate);
							}
							cstmt.setString(17, outPatBean.getAmtGrossNet());
							cstmt.setString(18, outPatBean.getGender());	
							cstmt.setString(19, outPatBean.getAgeGroup());	
							cstmt.setString(20, outPatBean.getSplitReqd());
							cstmt.setString(21, login_user);
							cstmt.setString(22, login_user);
							cstmt.setString(23, client_ip_address);
							cstmt.setString(24, facilityId);
							cstmt.setString(25, client_ip_address);
							cstmt.setString(26, facilityId);
				
							cstmt.registerOutParameter(27, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(28, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(29, java.sql.Types.VARCHAR);
							cstmt.setString(30, outPatBean.getPreApprDurCapping()); //Added V180725-Gayathri/MMS-DM-CRF-0126
							cstmt.setString(31, outPatBean.getPreacrossenc()); //Added V190326-Dhananjay/MMS-DM-CRF-0158
							//01-09-2020 start
							if(SiteSpecGroupService){//073838
							if((null == outPatBean.getGroupRservice() || ("".equals(outPatBean.getGroupRservice()))) ) {
								cstmt.setString(32, null);//073838
							}
							else
								cstmt.setString(32, outPatBean.getGroupRservice());//ADDED FOR MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 
							}
							else
							{
								cstmt.setString(32, null);//073838
							}
							//01-09-2020 end
							cstmt.execute();
							str_error_level = cstmt.getString(27);
							str_sysmesage_id = cstmt.getString(28);
							str_error_text = cstmt.getString(29);
						}
						else{
							str_error_text = "Pre Approval Details Tab. Row Number "+i+". Please Enter all mandatory fields";
						}
					}
					
				}
				else if("U".equals(checkForNull(outPatBean.getStatus()))){
						cstmt = con.prepareCall(preAppQueryUpd);
						
						cstmt.setString(1, policyBean.getFacilityId());
						
						cstmt.setString(2, policyBean.getPayerGroupCode());
						cstmt.setString(3, policyBean.getPolicyTypeCode());
						cstmt.setString(4, policyBean.getPayerCode());
						cstmt.setString(5, outPatBean.getBillServCode());
						cstmt.setString(6, outPatBean.getType());
						cstmt.setString(7, outPatBean.getPatClass());
						cstmt.setString(8, outPatBean.getEpisodeEncounter());
						cstmt.setString(9, outPatBean.getClinicNurs());
						cstmt.setString(10, outPatBean.getClinicNursCode());
						cstmt.setString(11, outPatBean.getSpecCode());
						cstmt.setString(12, outPatBean.getServLimit());
						
						cstmt.setString(13, outPatBean.getPreApprAmtCapping());
						cstmt.setString(14, outPatBean.getPreApprQtyCapping());
						
						if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
							cstmt.setString(15, null);
						}
						else{
							Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
							cstmt.setDate(15, fromDt);
						}
						
						if("Y".equals(userChangedEndDate) && oldEndDate.equals(checkForNull(outPatBean.getEndDate()))){
							if((policyBean.getEndDate() == null) || ("".equals(policyBean.getEndDate())) ){
								cstmt.setString(16, null);
							}
							else{
								Date toDate = new Date(sdf.parse(policyBean.getEndDate()).getTime());
								cstmt.setDate(16, toDate);
							}
						}
						else{
							if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
								cstmt.setString(16, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
								cstmt.setDate(16, toDate);
							}
						}
						
						cstmt.setString(17, outPatBean.getAmtGrossNet());
						cstmt.setString(18, outPatBean.getGender());	
						cstmt.setString(19, outPatBean.getAgeGroup());	
						cstmt.setString(20, outPatBean.getSplitReqd());
						cstmt.setString(21, login_user);
						cstmt.setString(22, client_ip_address);
						cstmt.setString(23, facilityId);
	
			
						cstmt.registerOutParameter(24, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(25, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(26, java.sql.Types.VARCHAR);
						cstmt.setString(27, outPatBean.getPreApprDurCapping()); //Added V180725-Gayathri/MMS-DM-CRF-0126
						cstmt.setString(28, outPatBean.getPreacrossenc()); //Added V190326-Dhananjay/MMS-DM-CRF-0158
					
						//01-09-2020 start
						if(SiteSpecGroupService){//073838
							if((null == outPatBean.getGroupRservice() || ("".equals(outPatBean.getGroupRservice()))) ) {
								cstmt.setString(29, null);//073838
							}
							else
								cstmt.setString(29, outPatBean.getGroupRservice());//ADDED FOR MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 
							}
							else
							{
								cstmt.setString(29, null);//073838
							}
							//01-09-2020 end
						cstmt.execute();
						str_error_level = cstmt.getString(24);
						str_sysmesage_id = cstmt.getString(25);
						str_error_text = cstmt.getString(26);
				}
			}
			else if("Y".equals(outPatBean.getDelFlag())){
				cstmt = con.prepareCall(preAppQueryDel);

				cstmt.setString(1, policyBean.getFacilityId());
				cstmt.setString(2, policyBean.getPayerGroupCode());
				cstmt.setString(3, policyBean.getPolicyTypeCode());
				cstmt.setString(4, policyBean.getPayerCode());
				cstmt.setString(5, outPatBean.getBillServCode());
				cstmt.setString(6, outPatBean.getType());
				cstmt.setString(7, outPatBean.getPatClass());
				cstmt.setString(8, outPatBean.getEpisodeEncounter());
				cstmt.setString(9, outPatBean.getClinicNurs());
				cstmt.setString(10, outPatBean.getClinicNursCode());
				cstmt.setString(11, outPatBean.getSpecCode());
				//cstmt.setString(12, outPatBean.getServLimit());
				if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
					cstmt.setString(12, null);
				}
				else{
					Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
					cstmt.setDate(12, fromDt);
				}
				cstmt.setString(13, outPatBean.getGender());	
				cstmt.setString(14, outPatBean.getAgeGroup());	
				cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(16, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(17, java.sql.Types.VARCHAR);
				cstmt.execute();
				str_error_level = cstmt.getString(15);
				str_sysmesage_id = cstmt.getString(16);
				str_error_text = cstmt.getString(17);
			}
			
			String errAdd = "errAdd"+i;
			String errTextAdd = "errTextAdd"+i;
			
			if(str_error_level!=null || str_error_text!=null){
				returnMap.put(errAdd, str_error_text);
			}
			
			if(str_sysmesage_id!=null){
				String msgAdd = "";
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){
						msgAdd = "msgAdd"+i+"-"+l;
						try{
							msgArr[l] = rb.getString(msgArr[l]);
						}
						catch(Exception rbException){
							rbException.printStackTrace();
							System.err.println("Exceprion in RB ->"+rbException);
						}							
						returnMap.put(msgAdd, msgArr[l]);
					}
				}else{
					msgAdd = "msgAdd"+i;
					
					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						rbException.printStackTrace();
						System.err.println("Exceprion in RB ->"+rbException);							
					}
					returnMap.put(msgAdd, str_sysmesage_id);
				}
			}
			i++;
		}
		cstmt.close();
		if (!returnMap.isEmpty()) {
			insertable = false;
		} else {
			insertable = true;
		}
	}
	catch(Exception e){
		e.printStackTrace();
		System.err.println("Exception is "+e);
		returnMap.put("internalError", "Internal Error");
		insertable = false;
	}
	finally{
		returnMap.put("status", new Boolean(insertable));
		return returnMap;
	}		
	}

	private HashMap insertPolicyDetails(HttpServletRequest request,
			HttpServletResponse response, PolicyInsuranceMasterBean policyBean) {
		HashMap returnMap = new HashMap();
		HashMap returnPopup = new HashMap();
		boolean insertable = false;
		try{
			HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = policyBean.getPolicyMap();
			con.setAutoCommit(false);
			List<PolicyInsuranceMasterBean> inclList = null; 
			if(!(policyMap == null || policyMap.isEmpty())){
				inclList = policyMap.get("inclExclCoverage");
				if(inclList == null){
					inclList = new ArrayList<PolicyInsuranceMasterBean>();
					outPatBean = new PolicyInsuranceMasterBean();
					inclList.add(outPatBean);
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				inclList = new ArrayList<PolicyInsuranceMasterBean>();
				outPatBean = new PolicyInsuranceMasterBean();
				inclList.add(outPatBean);		
			}
			
			//Added V181003-Aravindh/AAKH-CRF-0107/if-else conidition
			String preAppQueryIns = "", preAppQueryUpd = "", preAppQueryDel = "";
			//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020  ADDED TWO PARAMETER CALLED GroupRservice TO INSERT AND UPDATE
			preAppQueryIns = "{ call   blinspolicycoverage.insert_ins_policy_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			preAppQueryUpd = "{ call   blinspolicycoverage.update_ins_policy_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			preAppQueryDel = "{ call   blinspolicycoverage.delete_ins_policy_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			
			int i=1;
			for(PolicyInsuranceMasterBean outPatBean : inclList)
			{
				System.err.println("Policy Details outPatBean.getStatus():"+outPatBean.getStatus());
				System.err.println("Policy Details outPatBean.getDelFlag():"+outPatBean.getDelFlag());
				if("N".equals(outPatBean.getDelFlag())){
					if(("I".equals(checkForNull(outPatBean.getStatus()))) || ("U".equals(checkForNull(outPatBean.getStatus())))){
						if("I".equals(checkForNull(outPatBean.getStatus()))){
							if(("".equals(checkForNull(outPatBean.getEpisodeEncounter())) && "".equals(checkForNull(outPatBean.getPatClass())) && "".equals(checkForNull(outPatBean.getAgeGroup())) && "".equals(checkForNull(outPatBean.getGender()))  && "".equals(checkForNull(outPatBean.getClinicNursCode())) && "".equals(checkForNull(outPatBean.getSpecCode())) && "".equals(checkForNull(outPatBean.getBillServCode())))){
							}
							else{
								if(!("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getAgeGroup())) || "".equals(checkForNull(outPatBean.getGender()))  || "".equals(checkForNull(outPatBean.getClinicNursCode())) || "".equals(checkForNull(outPatBean.getSpecCode())) || "".equals(checkForNull(outPatBean.getBillServCode())) || "".equals(checkForNull(outPatBean.getStartDate())))){
									cstmt = con.prepareCall(preAppQueryIns);							
									cstmt.setString(1, policyBean.getFacilityId());
									cstmt.setString(2, policyBean.getPayerGroupCode());
									cstmt.setString(3, policyBean.getPayerCode());
									cstmt.setString(4, policyBean.getPolicyTypeCode());
									cstmt.setString(5, outPatBean.getInclExclCriteria());
									//cstmt.setString(6, returnVal(outPatBean.getBillServCode(),"**"));
									cstmt.setString(6, outPatBean.getBillServCode());
									cstmt.setString(7, outPatBean.getPatClass());
									cstmt.setString(8, outPatBean.getInclExclInd());
									cstmt.setString(9, outPatBean.getInclusionBasis());
									cstmt.setString(10, outPatBean.getValue());
									cstmt.setString(11, outPatBean.getBillServChk());
									cstmt.setString(12, outPatBean.getValueChk1());
									cstmt.setString(13, outPatBean.getInclExclIndChk());
									cstmt.setString(14, outPatBean.getValueChk4());
									cstmt.setString(15, outPatBean.getValueChk3());
									
									cstmt.setString(16, outPatBean.getAmtPerVisit());
									cstmt.setString(17, outPatBean.getServItemQty());
									cstmt.setString(18, outPatBean.getAmtPerIPDay());
									cstmt.setString(19, outPatBean.getNoOfDays());
									cstmt.setString(20, outPatBean.getEpisodeEncounter());
									cstmt.setString(21, outPatBean.getClinicNurs());
									cstmt.setString(22, outPatBean.getClinicNursCode());
									cstmt.setString(23, outPatBean.getSpecCode());
									
									if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
										cstmt.setString(24, null);
									}
									else{
										Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
										cstmt.setDate(24, fromDt);
									}
									if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
										if(siteSpecPolDefIncExc && "Y".equals(gppolicy)){//Added against NMC-JD-CRF-0045 --20-08-2020
										cstmt.setString(25, null);
										}else{
										//cstmt.setString(25, null); //Commented V182704-Subha/AAKH-SCF-0358
									    //Added V182704-Subha/AAKH-SCF-0358/Starts
											if((policyBean.getEndDate() == null) || ("".equals(policyBean.getEndDate())) ){
												cstmt.setString(25, null);
											}else{
											Date toDate = new Date(sdf.parse(policyBean.getEndDate()).getTime());
											cstmt.setDate(25, toDate);
										    //Added V182704-Subha/AAKH-SCF-0358/Ends
										}
										}
									}
									else{
										Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
										cstmt.setDate(25, toDate);
									}
				
									cstmt.setString(26, outPatBean.getAmtGrossNet());	
									cstmt.setString(27, outPatBean.getGender());	
									cstmt.setString(28, outPatBean.getAgeGroup());	
									//New Fields Added
									cstmt.setString(29, outPatBean.getPolicyApplicability());
									cstmt.setString(30, outPatBean.getEncGrpIdSameEpsd());
									if("".equals(checkForNull(outPatBean.getTimeLimitValue()))){
										outPatBean.setTimeLimitType("");
									}
									cstmt.setString(31, outPatBean.getTimeLimitType());
									cstmt.setString(32, outPatBean.getTimeLimitValue());
									//New Fields Added
									cstmt.setString(33, login_user);
									cstmt.setString(34, login_user);
									cstmt.setString(35, client_ip_address);
									cstmt.setString(36, facilityId);
									cstmt.setString(37, client_ip_address);
									cstmt.setString(38, facilityId);
						
									cstmt.setString(39, outPatBean.getPatCopay());
									cstmt.setString(40, outPatBean.getPatLimitAmt());
									if(outPatBean.getInclhomeMedi() == null || ("".equals(outPatBean.getInclhomeMedi())))
									{
										cstmt.setString(41, "Y");
									}
									else{
									cstmt.setString(41, outPatBean.getInclhomeMedi());
									}
									cstmt.registerOutParameter(42, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(43, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(44, java.sql.Types.VARCHAR);
									if(null == outPatBean.getCoverRefPrice() || !(outPatBean.getCoverRefPrice().equals("Y"))) {
										cstmt.setString(45, "N");
									} else {
										cstmt.setString(45, outPatBean.getCoverRefPrice());//Added V181003-Aravindh/AAKH-CRF-0107
									}
									//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
									if(null == outPatBean.getExlinclacrossenc() || !(outPatBean.getExlinclacrossenc().equals("Y"))) {
										cstmt.setString(46, "N");
									} else {
										cstmt.setString(46, outPatBean.getExlinclacrossenc());
									}
									//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
									
									//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS-->
									//01-09-2020 start
									if(SiteSpecGroupService){									
									if((outPatBean.getGroupRservice() == null) || ("".equals(outPatBean.getGroupRservice()))){
										cstmt.setString(47, null);
									}
									else{										
										cstmt.setString(47, outPatBean.getGroupRservice());
										}	
									}		
									else	
									{							
										cstmt.setString(47, null);
									}
									//01-09-2020 end
									//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 ENDS-->
									
									// MOHE-CRF-0114 starts
									if(siteSpecDiagBasedCopay){
										if((outPatBean.getDiagCopaySetup() == null) || ("".equals(outPatBean.getDiagCopaySetup()))){
											cstmt.setString(48, null);
										}
										else{										
											cstmt.setString(48, outPatBean.getDiagCopaySetup());
										}	
									}		
									else	
									{							
										cstmt.setString(48, null);
									}
									// MOHE-CRF-0114 Ends
								
									cstmt.execute();
									str_error_level = cstmt.getString(42);
									str_sysmesage_id = cstmt.getString(43);
									str_error_text = cstmt.getString(44);
									
									if(str_error_level==null && str_error_text==null){
										System.err.println("Record Savedd");
										if("Y".equals(outPatBean.getServLimit())){
											returnPopup = insertPolictDetailsPopup(request,response,outPatBean,policyBean);
											if(!(((Boolean) returnPopup.get("status")).booleanValue())){
												returnMap.putAll(returnPopup);
											}	
										}
										System.err.println("outPatBean.getDiagCopaySetup() inside insert:"+outPatBean.getDiagCopaySetup());
										if("Y".equals(outPatBean.getDiagCopaySetup())){
											returnPopup = insertPolictDetailsDiagCopayPopup(request,response,outPatBean,policyBean);
											if(!(((Boolean) returnPopup.get("status")).booleanValue())){
												returnMap.putAll(returnPopup);
											}	
										}
									}
								}
								else{
									str_error_text = "Include/ Exclude Coverage Tab. Row Number "+i+". Please Enter all mandatory fields";
								}
							}
						}
						else if("U".equals(checkForNull(outPatBean.getStatus()))){
							cstmt = con.prepareCall(preAppQueryUpd);							

							cstmt.setString(1, policyBean.getFacilityId());
							cstmt.setString(2, policyBean.getPayerGroupCode());
							cstmt.setString(3, policyBean.getPayerCode());
							cstmt.setString(4, policyBean.getPolicyTypeCode());
							cstmt.setString(5, outPatBean.getInclExclCriteria());
							//cstmt.setString(6, returnVal(outPatBean.getBillServCode(),"**"));
							cstmt.setString(6, outPatBean.getBillServCode());
							cstmt.setString(7, outPatBean.getPatClass());
							cstmt.setString(8, outPatBean.getInclExclInd());
							cstmt.setString(9, outPatBean.getInclusionBasis());
							cstmt.setString(10, outPatBean.getValue());
							cstmt.setString(11, outPatBean.getBillServChk());
							cstmt.setString(12, outPatBean.getValueChk1());
							cstmt.setString(13, outPatBean.getInclExclIndChk());
							cstmt.setString(14, outPatBean.getValueChk4());
							cstmt.setString(15, outPatBean.getValueChk3());
							
							cstmt.setString(16, outPatBean.getAmtPerVisit());
							cstmt.setString(17, outPatBean.getServItemQty());
							cstmt.setString(18, outPatBean.getAmtPerIPDay());
							cstmt.setString(19, outPatBean.getNoOfDays());
							cstmt.setString(20, outPatBean.getEpisodeEncounter());
							cstmt.setString(21, outPatBean.getClinicNurs());
							cstmt.setString(22, outPatBean.getClinicNursCode());
							cstmt.setString(23, outPatBean.getSpecCode());
							
							if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
								cstmt.setString(24, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
								cstmt.setDate(24, fromDt);
							}
							
							if("Y".equals(userChangedEndDate) && oldEndDate.equals(checkForNull(outPatBean.getEndDate()))){
								if((policyBean.getEndDate() == null) || ("".equals(policyBean.getEndDate())) ){
									cstmt.setString(25, null);
									outPatBean.setEndDate(policyBean.getEndDate());
								}
								else{
									Date toDate = new Date(sdf.parse(policyBean.getEndDate()).getTime());
									cstmt.setDate(25, toDate);
									outPatBean.setEndDate(policyBean.getEndDate());
								}
							}
							else{
								if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
									cstmt.setString(25, null);
								}
								else{
									Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
									cstmt.setDate(25, toDate);
								}
							}							
		
							cstmt.setString(26, outPatBean.getAmtGrossNet());	
							cstmt.setString(27, outPatBean.getGender());	
							cstmt.setString(28, outPatBean.getAgeGroup());	
							//New Fields Added
							cstmt.setString(29, outPatBean.getPolicyApplicability());
							cstmt.setString(30, outPatBean.getEncGrpIdSameEpsd());
							if("".equals(checkForNull(outPatBean.getTimeLimitValue()))){
								outPatBean.setTimeLimitType("");
							}
							cstmt.setString(31, outPatBean.getTimeLimitType());
							cstmt.setString(32, outPatBean.getTimeLimitValue());
							//New Fields Added
							cstmt.setString(33, login_user);
							cstmt.setString(34, login_user);
							cstmt.setString(35, client_ip_address);
							cstmt.setString(36, facilityId);
							cstmt.setString(37, client_ip_address);
							cstmt.setString(38, facilityId);
							cstmt.setString(39, outPatBean.getPatCopay());
							cstmt.setString(40, outPatBean.getPatLimitAmt());
							if(outPatBean.getInclhomeMedi() == null || ("".equals(outPatBean.getInclhomeMedi())))
							{
								cstmt.setString(41, "Y");
							}
							else{
							cstmt.setString(41, outPatBean.getInclhomeMedi());
							}
							
							cstmt.registerOutParameter(42, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(43, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(44, java.sql.Types.VARCHAR);
							if(null == outPatBean.getCoverRefPrice() || !(outPatBean.getCoverRefPrice().equals("Y"))) {
								cstmt.setString(45, "N");
							} else {
								cstmt.setString(45, outPatBean.getCoverRefPrice());
							}//Added V181003-Aravindh/AAKH-CRF-0107
							//Added V190326-Dhananjay/MMS-DM-CRF-0158/Starts
							if(null == outPatBean.getExlinclacrossenc() || !(outPatBean.getExlinclacrossenc().equals("Y"))) {
								cstmt.setString(46, "N");
							} else {
								cstmt.setString(46, outPatBean.getExlinclacrossenc());
							}
							//Added V190326-Dhananjay/MMS-DM-CRF-0158/Ends
							
							//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS-->
							//01-09-2020 start
							if(SiteSpecGroupService){
								if((outPatBean.getGroupRservice() == null) || ("".equals(outPatBean.getGroupRservice()))){
									cstmt.setString(47, null);
								}
								else{									
									cstmt.setString(47, outPatBean.getGroupRservice());
								} 
							}
							else{
								cstmt.setString(47, null);
							}
							//01-09-2020 end
								//MMS-QH-CRF-0170-US-4  PALANINARAYANAN 9/7/2020 STARTS-->
							
							// MOHE-CRF-0114 starts
							if(siteSpecDiagBasedCopay){
								if((outPatBean.getDiagCopaySetup() == null) || ("".equals(outPatBean.getDiagCopaySetup()))){
									cstmt.setString(48, null);
								}
								else{										
									cstmt.setString(48, outPatBean.getDiagCopaySetup());
								}	
							}		
							else	
							{							
								cstmt.setString(48, null);
							}
							// MOHE-CRF-0114 Ends
									
							cstmt.execute();
							str_error_level = cstmt.getString(42);
							str_sysmesage_id = cstmt.getString(43);
							str_error_text = cstmt.getString(44);
							
							if(str_error_level==null && str_error_text==null){
								if("Y".equals(outPatBean.getServLimit())){
									returnPopup = insertPolictDetailsPopup(request,response,outPatBean,policyBean);
									if(!(((Boolean) returnPopup.get("status")).booleanValue())){
										returnMap.putAll(returnPopup);
									}	
								}
								System.err.println("outPatBean.getDiagCopaySetup() inside update:"+outPatBean.getDiagCopaySetup());
								if("Y".equals(outPatBean.getDiagCopaySetup())){
									returnPopup = insertPolictDetailsDiagCopayPopup(request,response,outPatBean,policyBean);
									if(!(((Boolean) returnPopup.get("status")).booleanValue())){
										returnMap.putAll(returnPopup);
									}	
								}
							}
						}						
					}
				}
				else if("Y".equals(outPatBean.getDelFlag())){
					cstmt = con.prepareCall(preAppQueryDel);
					cstmt.setString(1, policyBean.getFacilityId());
					cstmt.setString(2, policyBean.getPayerGroupCode());
					cstmt.setString(3, policyBean.getPayerCode());
					cstmt.setString(4, policyBean.getPolicyTypeCode());
					cstmt.setString(5, outPatBean.getInclExclCriteria());
					cstmt.setString(6, outPatBean.getPatClass());
					cstmt.setString(7, outPatBean.getBillServCode());
					
					cstmt.setString(8, outPatBean.getEpisodeEncounter());
					cstmt.setString(9, outPatBean.getClinicNurs());
					cstmt.setString(10, outPatBean.getClinicNursCode());
					cstmt.setString(11, outPatBean.getSpecCode());
					
					if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
						cstmt.setString(12, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
						cstmt.setDate(12, fromDt);
					}
					cstmt.setString(13, outPatBean.getGender());
					cstmt.setString(14, outPatBean.getAgeGroup());
					cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(16, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(17, java.sql.Types.VARCHAR);
					cstmt.execute();
					str_error_level = cstmt.getString(15);
					str_sysmesage_id = cstmt.getString(16);
					str_error_text = cstmt.getString(17);
				}

				String errAdd = "errAdd"+i;
				String errTextAdd = "errTextAdd"+i;
				
				if(str_error_level!=null || str_error_text!=null){
					returnMap.put(errAdd, str_error_text);
				}
				System.err.println("str_sysmesage_id in PD Details:"+str_sysmesage_id);
				System.err.println("str_error_level in PD Details:"+str_error_level);
				System.err.println("str_error_text in PD Details:"+str_error_text);
				if(str_sysmesage_id!=null){
					String msgAdd = "";
					if(str_sysmesage_id.contains("|")){
						String msgArr[] = str_sysmesage_id.split("\\|");
						for(int l=0;l<msgArr.length;l++){
							msgAdd = "msgAdd"+i+"-"+l;
							
							try{
								msgArr[l] = rb.getString(msgArr[l]);
							}
							catch(Exception rbException){
								try{
									System.err.println("msgArr[l] inside PD try:"+msgArr[l]);
									msgArr[l] = rb2.getString(msgArr[l]);
								}
								catch(Exception rbException1){
									rbException.printStackTrace();
									rbException1.printStackTrace();
									System.err.println("Exceprion in RB PD->"+rbException);
									System.err.println("Exceprion in RB PD ->"+rbException1);
								}	
							}
							returnMap.put(msgAdd, msgArr[l]);
						}
					}else{
						msgAdd = "msgAdd"+i;
						
						try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							try{
								str_sysmesage_id = rb2.getString(str_sysmesage_id);
							}
							catch(Exception rbException1){
								rbException.printStackTrace();
								rbException1.printStackTrace();
								System.err.println("Exceprion in RB ->"+rbException);
								System.err.println("Exceprion in RB ->"+rbException1);
							}
						}
						returnMap.put(msgAdd, str_sysmesage_id);
					}
				}
				i++;
			}
			cstmt.close();
			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception is "+e);
			insertable = false;
			returnMap.put("internalError", "Internal Error");
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
	}

	private HashMap insertPolictDetailsPopup(HttpServletRequest request, HttpServletResponse response, PolicyInsuranceMasterBean outPatBean2, PolicyInsuranceMasterBean policyBean) {
		
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		try{
			HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = policyBean.getPopupMap();
			con.setAutoCommit(false);
			List<PolicyInsuranceMasterBean> preAppList = null; 
			if(!(policyMap == null || policyMap.isEmpty())){
				preAppList = policyMap.get(outPatBean2.getRowNumber());
				if(preAppList == null){
					preAppList = new ArrayList<PolicyInsuranceMasterBean>();
					outPatBean = new PolicyInsuranceMasterBean();
					preAppList.add(outPatBean);
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				preAppList = new ArrayList<PolicyInsuranceMasterBean>();
				outPatBean = new PolicyInsuranceMasterBean();
				preAppList.add(outPatBean);		
			}
			
			//Added V181003-Aravindh/AAKH-CRF-0107/if-else conidition
			String preAppQueryIns = "", preAppQueryUpd = "", preAppQueryDel = "";
			//added one parameter 01-09-2020  both  insertion and updation
			preAppQueryIns = "{ call   blinspolicycoverage.insert_ins_policy_excl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			preAppQueryUpd = "{ call   blinspolicycoverage.update_ins_policy_excl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			preAppQueryDel = "{ call   blinspolicycoverage.delete_ins_policy_excl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			
			int i=1;
			for(PolicyInsuranceMasterBean outPatBean : preAppList)
			{
				
				if("N".equals(outPatBean.getDelFlag())){
					if(("I".equals(checkForNull(outPatBean.getStatus()))) || ("U".equals(checkForNull(outPatBean.getStatus())))){
						if("I".equals(checkForNull(outPatBean.getStatus()))){
							if("".equals(checkForNull(outPatBean.getBillServCode()))){
							}
							else{
									cstmt = con.prepareCall(preAppQueryIns);
									cstmt.setString(1, policyBean.getFacilityId());
									cstmt.setString(2, policyBean.getPayerGroupCode());
									cstmt.setString(3, policyBean.getPayerCode());
									cstmt.setString(4, policyBean.getPolicyTypeCode());
									cstmt.setString(5, outPatBean2.getInclExclCriteria());
									cstmt.setString(6, outPatBean2.getBillServCode());
									cstmt.setString(7, outPatBean2.getPatClass());
									cstmt.setString(8, outPatBean.getInclExclInd());
									cstmt.setString(9, outPatBean.getInclusionBasis());
									cstmt.setString(10, outPatBean.getValue());
									cstmt.setString(11, outPatBean2.getBillServChk());
									cstmt.setString(12, outPatBean2.getValueChk1());
									cstmt.setString(13, outPatBean2.getInclExclIndChk());
									cstmt.setString(14, outPatBean2.getValueChk4());
									cstmt.setString(15, outPatBean2.getValueChk3());
									
									cstmt.setString(16, outPatBean.getAmtPerVisit());
									cstmt.setString(17, outPatBean.getServItemQty());
									cstmt.setString(18, outPatBean.getAmtPerIPDay());
									cstmt.setString(19, outPatBean.getNoOfDays());
									cstmt.setString(20, outPatBean2.getEpisodeEncounter());
									cstmt.setString(21, outPatBean2.getClinicNurs());
									cstmt.setString(22, outPatBean2.getClinicNursCode());
									cstmt.setString(23, outPatBean2.getSpecCode());
									cstmt.setString(24, outPatBean.getInclExclCriteria());
									cstmt.setString(25, outPatBean.getBillServCode());
									
									if((outPatBean2.getStartDate() == null) || ("".equals(outPatBean2.getStartDate()))){
										cstmt.setString(26, null);
									}
									else{
										Date fromDt = new Date(sdf.parse(outPatBean2.getStartDate()).getTime());
										cstmt.setDate(26, fromDt);
									}
									

									if((outPatBean2.getEndDate() == null) || ("".equals(outPatBean2.getEndDate())) ){
										cstmt.setString(27, null);
									}
									else{
										Date toDate = new Date(sdf.parse(outPatBean2.getEndDate()).getTime());
										cstmt.setDate(27, toDate);
									}
									
									cstmt.setString(28, outPatBean.getAmtGrossNet());	
									
									if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
										cstmt.setString(29, null);
									}
									else{
										Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
										cstmt.setDate(29, fromDt);
									}
									
									if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
										cstmt.setString(30, null);
									}
									else{
										Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
										cstmt.setDate(30, toDate);
									}
									
									cstmt.setString(31, outPatBean2.getGender());	
									cstmt.setString(32, outPatBean2.getAgeGroup());	
									//New Fields Added
									cstmt.setString(33, outPatBean.getPolicyApplicability());
									cstmt.setString(34, outPatBean.getEncGrpIdSameEpsd());
									if("".equals(checkForNull(outPatBean.getTimeLimitValue()))){
										outPatBean.setTimeLimitType("");
									}
									cstmt.setString(35, outPatBean.getTimeLimitType());
									cstmt.setString(36, outPatBean.getTimeLimitValue());
									//New Fields Added
									cstmt.setString(37, login_user);
									cstmt.setString(38, login_user);
									cstmt.setString(39, client_ip_address);
									cstmt.setString(40, facilityId);
									cstmt.setString(41, client_ip_address);
									cstmt.setString(42, facilityId);
		
									cstmt.setString(43, outPatBean.getPatCopay());
									cstmt.setString(44, outPatBean.getPatLimitAmt());
									if(outPatBean.getInclhomeMedi() == null || ("".equals(outPatBean.getInclhomeMedi())))
									{
										cstmt.setString(45, "Y");
									}
									else{
									cstmt.setString(45, outPatBean.getInclhomeMedi());
									}
									cstmt.registerOutParameter(46, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(47, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(48, java.sql.Types.VARCHAR);
									if(null == outPatBean.getCoverRefPrice() || !(outPatBean.getCoverRefPrice().equals("Y"))) {
										cstmt.setString(49, "N");
									} else {
										cstmt.setString(49, outPatBean.getCoverRefPrice());
									}//Added V181003-Aravindh/AAKH-CRF-0107
									
									if(null == outPatBean.getExlinclacrossenc() || !(outPatBean.getExlinclacrossenc().equals("Y"))) {
										cstmt.setString(50, "N");
									} else {
										cstmt.setString(50, outPatBean.getExlinclacrossenc());//Added V181003-Aravindh/AAKH-CRF-0107
									}//Added V190328-Dhananjay/MMS-DM-CRF-0158
									cstmt.execute();
									str_error_level = cstmt.getString(46);
									str_sysmesage_id = cstmt.getString(47);
									str_error_text = cstmt.getString(48);
							}
						}
						else if("U".equals(checkForNull(outPatBean.getStatus()))){
							cstmt = con.prepareCall(preAppQueryUpd);
							cstmt.setString(1, policyBean.getFacilityId());
							cstmt.setString(2, policyBean.getPayerGroupCode());
							cstmt.setString(3, policyBean.getPayerCode());
							cstmt.setString(4, policyBean.getPolicyTypeCode());
							cstmt.setString(5, outPatBean2.getInclExclCriteria());
							cstmt.setString(6, outPatBean2.getBillServCode());
							cstmt.setString(7, outPatBean2.getPatClass());
							cstmt.setString(8, outPatBean.getInclExclInd());
							cstmt.setString(9, outPatBean.getInclusionBasis());
							cstmt.setString(10, outPatBean.getValue());
							cstmt.setString(11, outPatBean2.getBillServChk());
							cstmt.setString(12, outPatBean2.getValueChk1());
							cstmt.setString(13, outPatBean2.getInclExclIndChk());
							cstmt.setString(14, outPatBean2.getValueChk4());
							cstmt.setString(15, outPatBean2.getValueChk3());
							
							cstmt.setString(16, outPatBean.getAmtPerVisit());
							cstmt.setString(17, outPatBean.getServItemQty());
							cstmt.setString(18, outPatBean.getAmtPerIPDay());
							cstmt.setString(19, outPatBean.getNoOfDays());
							cstmt.setString(20, outPatBean2.getEpisodeEncounter());
							cstmt.setString(21, outPatBean2.getClinicNurs());
							cstmt.setString(22, outPatBean2.getClinicNursCode());
							cstmt.setString(23, outPatBean2.getSpecCode());
							cstmt.setString(24, outPatBean.getInclExclCriteria());
							cstmt.setString(25, outPatBean.getBillServCode());
							
							if((outPatBean2.getStartDate() == null) || ("".equals(outPatBean2.getStartDate()))){
								cstmt.setString(26, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean2.getStartDate()).getTime());
								cstmt.setDate(26, fromDt);
							}
							
							if("Y".equals(userChangedEndDate) && oldEndDate.equals(checkForNull(outPatBean2.getEndDate()))){
								if((policyBean.getEndDate() == null) || ("".equals(policyBean.getEndDate())) ){
									cstmt.setString(27, null);
								}
								else{
									Date toDate = new Date(sdf.parse(policyBean.getEndDate()).getTime());
									cstmt.setDate(27, toDate);
								}
							}
							else{
								if((outPatBean2.getEndDate() == null) || ("".equals(outPatBean2.getEndDate())) ){
									cstmt.setString(27, null);
								}
								else{
									Date toDate = new Date(sdf.parse(outPatBean2.getEndDate()).getTime());
									cstmt.setDate(27, toDate);
								}
							}
		
							cstmt.setString(28, outPatBean.getAmtGrossNet());	
							
							if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
								cstmt.setString(29, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
								cstmt.setDate(29, fromDt);
							}							
							
							if(!(checkForNull(outPatBean2.getEndDate()).equals(checkForNull(outPatBean2.getOldEndDate()))) && checkForNull(outPatBean2.getOldEndDate()).equals(checkForNull(outPatBean.getEndDate()))){
								if((outPatBean2.getEndDate() == null) || ("".equals(outPatBean2.getEndDate())) ){
									cstmt.setString(30, null);
								}
								else{
									Date toDate = new Date(sdf.parse(outPatBean2.getEndDate()).getTime());
									cstmt.setDate(30, toDate);
								}
							}
							else{
								if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
									cstmt.setString(30, null);
								}
								else{
									Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
									cstmt.setDate(30, toDate);
								}
							}
							
							cstmt.setString(31, outPatBean2.getGender());	
							cstmt.setString(32, outPatBean2.getAgeGroup());	
							//New Fields Added
							cstmt.setString(33, outPatBean.getPolicyApplicability());
							cstmt.setString(34, outPatBean.getEncGrpIdSameEpsd());
							if("".equals(checkForNull(outPatBean.getTimeLimitValue()))){
								outPatBean.setTimeLimitType("");
							}
							cstmt.setString(35, outPatBean.getTimeLimitType());
							cstmt.setString(36, outPatBean.getTimeLimitValue());
							//New Fields Added
							cstmt.setString(37, login_user);
							cstmt.setString(38, login_user);
							cstmt.setString(39, client_ip_address);
							cstmt.setString(40, facilityId);
							cstmt.setString(41, client_ip_address);
							cstmt.setString(42, facilityId);

							cstmt.setString(43, outPatBean.getPatCopay());
							cstmt.setString(44, outPatBean.getPatLimitAmt());
							cstmt.setString(45, outPatBean.getInclhomeMedi());
							cstmt.registerOutParameter(46, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(47, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(48, java.sql.Types.VARCHAR);
							if(null == outPatBean.getCoverRefPrice() || !(outPatBean.getCoverRefPrice().equals("Y"))) {
								cstmt.setString(49, "N");
							} else {
								cstmt.setString(49, outPatBean.getCoverRefPrice());
							}//Added V181003-Aravindh/AAKH-CRF-0107
							
							if(null == outPatBean.getPreacrossenc() || !(outPatBean.getPreacrossenc().equals("Y"))) {
								cstmt.setString(50, "N");
							} else {
								cstmt.setString(50, outPatBean.getPreacrossenc());//Added V190328-Dhananjay/MMS-DM-CRF-0158
							}
							cstmt.execute();
							str_error_level = cstmt.getString(46);
							str_sysmesage_id = cstmt.getString(47);
							str_error_text = cstmt.getString(48);
						}						
					}
				}
				else if("Y".equals(outPatBean.getDelFlag())){
					cstmt = con.prepareCall(preAppQueryDel);
					cstmt.setString(1, policyBean.getFacilityId());
					cstmt.setString(2, policyBean.getPayerGroupCode());
					cstmt.setString(3, policyBean.getPayerCode());
					cstmt.setString(4, policyBean.getPolicyTypeCode());
					cstmt.setString(5, outPatBean2.getInclExclCriteria());
					cstmt.setString(6, outPatBean2.getPatClass());
					cstmt.setString(7, outPatBean2.getBillServCode());
					
					cstmt.setString(8, outPatBean2.getEpisodeEncounter());
					cstmt.setString(9, outPatBean2.getClinicNurs());
					cstmt.setString(10, outPatBean2.getClinicNursCode());
					cstmt.setString(11, outPatBean2.getSpecCode());

					if((outPatBean2.getStartDate() == null) || ("".equals(outPatBean2.getStartDate()))){
						cstmt.setString(12, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean2.getStartDate()).getTime());
						cstmt.setDate(12, fromDt);
					}
					
					cstmt.setString(13, outPatBean.getInclExclCriteria());
					cstmt.setString(14, outPatBean.getBillServCode());

					if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
						cstmt.setString(15, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
						cstmt.setDate(15, fromDt);
					}
					
					cstmt.setString(16, outPatBean2.getGender());	
					cstmt.setString(17, outPatBean2.getAgeGroup());	
					cstmt.registerOutParameter(18, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
					cstmt.execute();
					str_error_level = cstmt.getString(18);
					str_sysmesage_id = cstmt.getString(19);
					str_error_text = cstmt.getString(20);
				}

				String errAdd = "errAdd"+i;
				String errTextAdd = "errTextAdd"+i;
				
				if(str_error_level!=null || str_error_text!=null){
					returnMap.put(errAdd, str_error_level+"-"+str_error_text);
				}
				
				if(str_sysmesage_id!=null){
					String msgAdd = "";
					if(str_sysmesage_id.contains("|")){
						String msgArr[] = str_sysmesage_id.split("\\|");
						for(int l=0;l<msgArr.length;l++){
							msgAdd = "msgAdd"+i+"-"+l;
							
							try{
								msgArr[l] = rb.getString(msgArr[l]);
							}
							catch(Exception rbException){
								rbException.printStackTrace();
								System.err.println("Exceprion in RB ->"+rbException);
							}
							returnMap.put(msgAdd, msgArr[l]);
						}
					}else{
						msgAdd = "msgAdd"+i;
						
						try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							rbException.printStackTrace();
							System.err.println("Exceprion in RB ->"+rbException);
						}
						returnMap.put(msgAdd, str_sysmesage_id);
					}
				}
				i++;
			}
			cstmt.close();
			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception is "+e);
			returnMap.put("internalError", "Internal Error");
			insertable = false;
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
			
	}

	@SuppressWarnings("finally")
	private HashMap<String, String> insertHeaderDetails(HttpServletRequest request,
			HttpServletResponse response, PolicyInsuranceMasterBean policyBean) {
		boolean insertable = false;
		HashMap returnMap = new HashMap();
		try{
			HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = policyBean.getPolicyMap();
			con.setAutoCommit(false);
			List<PolicyInsuranceMasterBean> outPatList = null; 
			List<PolicyInsuranceMasterBean> inPatList = null; 
			List<PolicyInsuranceMasterBean> externalList = null; 
			PreparedStatement pstmt = null;
			String mode = request.getParameter("mode");
			String sqlCoverage = "";
			session = request.getSession(false);
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			facilityId = (String) session.getValue( "facility_id" ) ;
			client_ip_address = this.p.getProperty("client_ip_address");
			login_user = this.p.getProperty( "login_user" ) ;
			
			if(oldEndDate.equals(policyBean.getEndDate())){
				userChangedEndDate = "N";
			}
			else{
				userChangedEndDate = "Y";
			}
			
			if(!(policyMap == null || policyMap.isEmpty())){
				outPatList = policyMap.get("Outpatient");
				if(outPatList == null){
					outPatList = new ArrayList<PolicyInsuranceMasterBean>();
					outPatBean = new PolicyInsuranceMasterBean();
					outPatList.add(outPatBean);
				}
				inPatList = policyMap.get("Inpatient");
				if(inPatList == null){
					inPatList = new ArrayList<PolicyInsuranceMasterBean>();
					inPatBean = new PolicyInsuranceMasterBean();
					if("modify".equals(mode)){
						sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_INPAT_LOAD");
						pstmt = con.prepareStatement(sqlCoverage);
						pstmt.setString(1, policyBean.getPolicyTypeCode());
						pstmt.setString(2, policyBean.getPayerCode());
						pstmt.setString(3, policyBean.getPayerGroupCode());
						pstmt.setString(4, policyBean.getFacilityId());
						rst = pstmt.executeQuery();
						
						if(rst!=null){
							while (rst.next()) {
								inPatBean.setCreditAuthReq(rst.getString("ip_cred_auth_req_yn"));
								inPatBean.setCreditAuthMand(rst.getString("ip_cred_auth_mand_to_capt_yn"));
								inPatBean.setCreditAuthRef(rst.getString("ip_dflt_auth_ref_as_pol_no_yn"));
								inPatBean.setCovered(rst.getString("inpatient_covered"));
								inPatBean.setCoverageLimitType(rst.getString("inpatient_limit_type"));
								inPatBean.setApprovedDays(rst.getString("ip_approved_days_limit_type"));
								inPatBean.setNoOfDays(rst.getString("ip_approved_no_of_days"));
								inPatBean.setApprovedAmt(rst.getString("ip_approved_amt_limit_type"));
								inPatBean.setLimitAmt(rst.getString("ip_approved_amt_limit"));
								inPatBean.setMandChkBillGen(rst.getString("mand_bill_gen_check_ind_ip"));
								inPatBean.setMandChkInvoiceGen(rst.getString("mand_inv_gen_check_ind_ip"));
								inPatBean.setPolicyApplicability(rst.getString("ip_across_encounters_yn"));
								inPatBean.setPatCopay(rst.getString("ip_patient_copay"));
								inPatBean.setPatLimitAmt(rst.getString("ip_patient_amount_limit"));
								inPatBean.setAmtGrossNet(rst.getString("ip_approved_amt_gross_net"));
								inPatBean.setTimeLimitValue(rst.getString("duration_value"));
								inPatBean.setTimeLimitType(rst.getString("duration_type"));
								inPatList.add(inPatBean);								
							}
						}
						else{
							inPatList.add(inPatBean);
						}		
					}
					else{
						inPatList.add(inPatBean);
					}
				}
				externalList = policyMap.get("External");
				if(externalList == null){
					externalList = new ArrayList<PolicyInsuranceMasterBean>();
					externalBean = new PolicyInsuranceMasterBean();
					if("modify".equals(mode)){
						sqlCoverage = BlRepository.getBlKeyValue("POLICY_DEF_EXTERNAL_LOAD");
						pstmt = con.prepareStatement(sqlCoverage);
						pstmt.setString(1, policyBean.getPolicyTypeCode());
						pstmt.setString(2, policyBean.getPayerCode());
						pstmt.setString(3, policyBean.getPayerGroupCode());
						pstmt.setString(4, policyBean.getFacilityId());
						rst = pstmt.executeQuery();
						
						if(rst!=null){
							while (rst.next()) {
								externalBean.setCreditAuthReq(rst.getString("ex_cred_auth_req_yn"));
								externalBean.setCreditAuthMand(rst.getString("ex_cred_auth_mand_to_capt_yn"));
								externalBean.setCreditAuthRef(rst.getString("ex_dflt_auth_ref_as_pol_no_yn"));
								externalBean.setCovered(rst.getString("external_covered"));
								externalBean.setCoverageLimitType(rst.getString("external_limit_type"));
								externalBean.setApprovedDays(rst.getString("ex_approved_days_limit_type"));
								externalBean.setNoOfDays(rst.getString("ex_approved_no_of_days"));
								externalBean.setApprovedAmt(rst.getString("ex_approved_amt_limit_type"));
								externalBean.setLimitAmt(rst.getString("ex_approved_amt_limit"));
								externalBean.setMandChkBillGen(rst.getString("mand_bill_gen_check_ind_ex"));
								externalBean.setMandChkInvoiceGen(rst.getString("mand_inv_gen_check_ind_ex"));
								externalBean.setPolicyApplicability(rst.getString("ex_across_encounters_yn"));
								externalBean.setPatCopay(rst.getString("ex_patient_copay"));
								externalBean.setPatLimitAmt(rst.getString("ex_patient_amount_limit"));
								externalBean.setAmtGrossNet(rst.getString("ex_approved_amt_gross_net"));
								externalList.add(externalBean);								
							}
						}
						else{
							externalList.add(externalBean);
						}						
					}
					else{
						externalList.add(externalBean);
					}
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				outPatList = new ArrayList<PolicyInsuranceMasterBean>();
				outPatBean = new PolicyInsuranceMasterBean();
				outPatList.add(outPatBean);
				inPatList = new ArrayList<PolicyInsuranceMasterBean>();
				inPatBean = new PolicyInsuranceMasterBean();
				inPatList.add(inPatBean);
				externalList = new ArrayList<PolicyInsuranceMasterBean>();
				externalBean = new PolicyInsuranceMasterBean();
				externalList.add(externalBean);
			}
			String headerQuery = "";
			mode = request.getParameter("mode");
			System.err.println("inside PolicyDefinitionMasterServlet mode::"+mode);
			if("insert".equals(mode)){
				//Modified V181003-Aravindh/AAKH-CRF-0107/if-else condition
				//Modified V190517-Aravindh/NMC-JD-CRF-0010/added 2 parameters
			    // NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan/added 1 parameter
				// Added 1 parameter for NMC-JD-CRF-0045 
				if(siteSpecPolDefIncExc){
					headerQuery = "{ call   blinspolicycoverage.insert_ins_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"; //V220223
				}
				else{
					headerQuery = "{ call   blinspolicycoverage.insert_ins_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";//V211027 Added one param for ref code //073838
				}
			}
			else if("modify".equals(mode)){
				//Modified V181003-Aravindh/AAKH-CRF-0107/if-else condition
				//Modified V190517-Aravindh/NMC-JD-CRF-0010/added 2 parameters
				// NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan/added 1 parameter  
				// Added 1 parameter for NMC-JD-CRF-0045 
				if(siteSpecPolDefIncExc){
					headerQuery = "{ call   blinspolicycoverage.update_ins_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }"; //V220223
				}else{
					headerQuery = "{ call   blinspolicycoverage.update_ins_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";//073838 //V211027 Added one param for ref code
				}
			}
			
			outPatBean = outPatList.get(0);
			inPatBean = inPatList.get(0);
			externalBean = externalList.get(0);
			cstmt = con.prepareCall(headerQuery);
			cstmt.setString(1, policyBean.getFacilityId());
			cstmt.setString(2, policyBean.getPolicyTypeCode());
			cstmt.setString(3, policyBean.getPayerGroupCode());
			cstmt.setString(4, policyBean.getPayerCode());
			cstmt.setString(5, policyBean.getDefInclExclCriteria());
			cstmt.setString(6, (policyBean.getCoveragePer()));
			cstmt.setString(7, outPatBean.getCovered());
			cstmt.setString(8, inPatBean.getCoverageLimitType());
			cstmt.setString(9, null);
			cstmt.setString(10, policyBean.getCoverageBasis());
			cstmt.setString(11, policyBean.getCoverageRules());
			cstmt.setString(12, returnVal(inPatBean.getCovered(),"N"));
			cstmt.setString(13, outPatBean.getCoverageLimitType());
			cstmt.setString(14, null);
			cstmt.setString(15, "B");
			cstmt.setString(16, policyBean.getOverRideInclExcl());
			cstmt.setString(17, outPatBean.getMandChkBillGen());
			cstmt.setString(18, outPatBean.getMandChkInvoiceGen());
			cstmt.setString(19, inPatBean.getMandChkInvoiceGen());
			cstmt.setString(20, inPatBean.getMandChkBillGen());
			cstmt.setString(21, outPatBean.getApprovedDays());
			cstmt.setString(22, inPatBean.getApprovedDays());
			cstmt.setString(23, outPatBean.getApprovedAmt());
			cstmt.setString(24, inPatBean.getApprovedAmt());
			cstmt.setString(25, outPatBean.getCreditAuthRef());
			cstmt.setString(26, inPatBean.getCreditAuthRef());
			cstmt.setString(27, outPatBean.getCreditAuthReq());
			cstmt.setString(28, inPatBean.getCreditAuthReq());
			cstmt.setString(29, externalBean.getCovered());
			cstmt.setString(30, externalBean.getCoverageLimitType());
			cstmt.setString(31, externalBean.getApprovedDays());
			cstmt.setString(32, externalBean.getApprovedAmt());
			cstmt.setString(33, externalBean.getCreditAuthReq());
			cstmt.setString(34, externalBean.getCreditAuthRef());
			cstmt.setString(35, externalBean.getMandChkBillGen());
			cstmt.setString(36, externalBean.getMandChkInvoiceGen());
			cstmt.setString(37, policyBean.getLastPayer());
			cstmt.setString(38, policyBean.getCovInclOthPayers());
			cstmt.setString(39, policyBean.getStartDateChk());
			cstmt.setString(40, (policyBean.getExpiryDays()));
			cstmt.setString(41, outPatBean.getCreditAuthMand());
			cstmt.setString(42, inPatBean.getCreditAuthMand());
			cstmt.setString(43, externalBean.getCreditAuthMand());
			cstmt.setString(44, (outPatBean.getNoOfDays()));
			cstmt.setString(45, (inPatBean.getNoOfDays()));
			cstmt.setString(46, (externalBean.getNoOfDays()));
			cstmt.setString(47, (outPatBean.getLimitAmt()));
			cstmt.setString(48, (inPatBean.getLimitAmt()));
			cstmt.setString(49, (externalBean.getLimitAmt()));
			
			cstmt.setString(50, (outPatBean.getPolicyApplicability()));
			cstmt.setString(51, (inPatBean.getPolicyApplicability()));
			cstmt.setString(52, (externalBean.getPolicyApplicability()));
			
			cstmt.setString(53, (policyBean.getPolicySettlementApplicability()));
			
			if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
				cstmt.setString(54, null);
			}
			else{
				Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
				cstmt.setDate(54, fromDt);
			}
			if((policyBean.getEndDate() == null) || ("".equals(policyBean.getEndDate())) ){
				cstmt.setString(55, null);
			}
			else{
				Date toDate = new Date(sdf.parse(policyBean.getEndDate()).getTime());
				cstmt.setDate(55, toDate);
			}
			
			cstmt.setString(56, (outPatBean.getAmtGrossNet()));
			cstmt.setString(57, (inPatBean.getAmtGrossNet()));
			cstmt.setString(58, (externalBean.getAmtGrossNet()));
			
			cstmt.setString(59, login_user);
			cstmt.setString(60, login_user);
			cstmt.setString(61, client_ip_address);
			cstmt.setString(62, facilityId);
			cstmt.setString(63, client_ip_address);
			cstmt.setString(64, facilityId);
			cstmt.setString(65, policyBean.getScreeningPolicy());

			cstmt.setString(66, outPatBean.getPatCopay());
			cstmt.setString(67, inPatBean.getPatCopay());
			cstmt.setString(68, externalBean.getPatCopay());
			cstmt.setString(69, outPatBean.getPatLimitAmt());
			cstmt.setString(70, inPatBean.getPatLimitAmt());
			cstmt.setString(71, externalBean.getPatLimitAmt());
			cstmt.setString(72, outPatBean.getEncGrpIdSameEpsd());
			cstmt.setString(73, outPatBean.getTimeLimitValue());
			cstmt.setString(74, outPatBean.getTimeLimitType());
			cstmt.setString(75, inPatBean.getTimeLimitValue());
			cstmt.setString(76, inPatBean.getTimeLimitType());
			cstmt.registerOutParameter(77, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(78, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(79, java.sql.Types.VARCHAR);
			
							
			if(null == policyBean.getCoverRefPrice() || !(policyBean.getCoverRefPrice().equals("Y"))) {
				cstmt.setString(80, "N");
			} else {
				cstmt.setString(80, policyBean.getCoverRefPrice());
			}//Added V181003-Aravindh/AAKH-CRF-0107
			if(null == policyBean.getPolicyApproved() || !("Y".equals(policyBean.getPolicyApproved()))) {
				cstmt.setString(81, "N");
			} else {
				cstmt.setString(81, policyBean.getPolicyApproved());
			}//Added V190517-Aravindh/NMC-JD-CRF-0010
			if(null != policyBean.getAuthenticatedUser() && !"".equals(policyBean.getAuthenticatedUser())) {//Added V190517-Aravindh/NMC-JD-CRF-0010
				cstmt.setString(82, policyBean.getAuthenticatedUser());
			} else {
				cstmt.setString(82, login_user);
			}//Added V190517-Aravindh/NMC-JD-CRF-0010
			
			//Added V190701 MuthuN/NMC-JD-CRF-0002.1 Starts
			if(null == policyBean.getclaimsAgrmtExts() || !(policyBean.getclaimsAgrmtExts().equals("Y"))) {
				cstmt.setString(83, "N");
			} else {
				cstmt.setString(83, policyBean.getclaimsAgrmtExts());
			}
			//Added V190701 MuthuN/NMC-JD-CRF-0002.1 Ends
			// NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Starts--->
			if(siteSpecPolDefIncExc){
				if((null == policyBean.getRemarks()) || ("".equals(policyBean.getRemarks())) ) {
					cstmt.setString(84, null);
				} else {
					cstmt.setString(84, policyBean.getRemarks());
				}
			}else{//073838
				cstmt.setString(84, null);
			}
			// NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Ends--->
			//Added against NMC-JD-CRF-0045 & 073838
			System.err.println("siteSpecPolDefIncExc==>>1486");
			if(siteSpecPolDefIncExc){
				cstmt.setString(85, policyBean.getGroupPolicy());
			}else{
				cstmt.setString(85, "N");
			}//073838
			//V211027
			System.err.println("policyBean.getPayerReferenceCode() "+policyBean.getPayerReferenceCode());
			if((null == policyBean.getPayerReferenceCode()) || ("".equals(policyBean.getPayerReferenceCode())) ) {
					cstmt.setString(86, null);
				}
				else{									
					cstmt.setString(86, policyBean.getPayerReferenceCode());
				} 
			//V211027
			System.err.println("OP MultiFactorDeductRuleYN value is: "+outPatBean.getMultiFactorDeductRuleYN());
			cstmt.setString(87, outPatBean.getMultiFactorDeductRuleYN());  //V221017
			System.err.println("MFDRPatLimitAmt value is: "+outPatBean.getMFDRPatLimitAmt());
			cstmt.setString(88, outPatBean.getMFDRPatLimitAmt());       //V221017
			System.err.println("MultiFactorDeductRuleYN value is: "+inPatBean.getMultiFactorDeductRuleYN());
			
			cstmt.setString(89, inPatBean.getMultiFactorDeductRuleYN());  //V230108
			System.err.println("IP MultiFactorDeductRuleYN value is: "+outPatBean.getMultiFactorDeductRuleYN());
			
			cstmt.execute();
			
			str_error_level = cstmt.getString(77);
			str_sysmesage_id = cstmt.getString(78);
			str_error_text = cstmt.getString(79);
			
			if(str_error_level!=null || str_error_text!=null){
				returnMap.put("hdrText", str_error_level+"-"+str_error_text);
			}
			
			if(str_sysmesage_id!=null){
				String msgAdd = "";
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){
						msgAdd = "msgHdr"+"-"+l;
						
						try{
							msgArr[l] = rb.getString(msgArr[l]);
						}
						catch(Exception rbException){
							rbException.printStackTrace();
							System.err.println("Exceprion in RB ->"+rbException);
						}
						finally{			
								try{
								if(pstmt!=null) pstmt.close(); 
								if(rst!=null) rst.close();
								}
								catch(Exception e)
								{
									System.err.println("Exception in insertHeaderDetails:"+e);
									e.printStackTrace();
								}
							}		
						
						returnMap.put(msgAdd, msgArr[l]);
					}
				}else{
					msgAdd = "msgHdr";
					
					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						rbException.printStackTrace();
						System.err.println("Exceprion in RB ->"+rbException);
					}
					returnMap.put(msgAdd, str_sysmesage_id);
				}
			}			
			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}			
			cstmt.close();			
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception is "+e);
			returnMap.put("internalError", "Internal Error");
			returnMap.put("status", new Boolean(false));
		}
		//Added against V210416
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}		
	}
	
	private HashMap insertPolictDetailsDiagCopayPopup(HttpServletRequest request, HttpServletResponse response, PolicyInsuranceMasterBean outPatBean2, PolicyInsuranceMasterBean policyBean) {
		
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		try{
			HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = policyBean.getDiagPopupMap();
			con.setAutoCommit(false);
			List<PolicyInsuranceMasterBean> preAppList = null; 
			if(!(policyMap == null || policyMap.isEmpty())){
				preAppList = policyMap.get(outPatBean2.getRowNumber());
				if(preAppList == null){
					preAppList = new ArrayList<PolicyInsuranceMasterBean>();
					outPatBean = new PolicyInsuranceMasterBean();
					preAppList.add(outPatBean);
				}
			}
			else{
				policyMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
				preAppList = new ArrayList<PolicyInsuranceMasterBean>();
				outPatBean = new PolicyInsuranceMasterBean();
				preAppList.add(outPatBean);		
			}
			
			//Added V181003-Aravindh/AAKH-CRF-0107/if-else conidition
			String preAppQueryIns = "", preAppQueryUpd = "", preAppQueryDel = "";
			//added one parameter 01-09-2020  both  insertion and updation
			preAppQueryIns = "{ call   blinspolicycoverage.insert_ins_policy_diagnosis (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			preAppQueryUpd = "{ call   blinspolicycoverage.update_ins_policy_diag (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			preAppQueryDel = "{ call   blinspolicycoverage.delete_ins_policy_diag (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			
			int i=1;
			for(PolicyInsuranceMasterBean outPatBean : preAppList)
			{
				System.err.println("Diag Status:"+outPatBean.getDiagStatus());
				System.err.println("Diag Del Status:"+outPatBean.getDiagDelFlag());
				if("N".equals(outPatBean.getDiagDelFlag())){
					if(("I".equals(checkForNull(outPatBean.getDiagStatus()))) || ("U".equals(checkForNull(outPatBean.getDiagStatus())))){
						if("I".equals(checkForNull(outPatBean.getDiagStatus()))){
							if("".equals(checkForNull(outPatBean.getBillServCode()))){
							}
							else
							{
								System.err.println("Diag Insert");
								System.err.println(policyBean.getFacilityId()+"/"+policyBean.getPayerGroupCode()+"/"+policyBean.getPayerCode()+"/"+policyBean.getPolicyTypeCode()+"/"+outPatBean2.getInclExclCriteria()+"/"+outPatBean2.getPatClass()+"/"+outPatBean2.getGender()+"/"+outPatBean2.getAgeGroup()+"/"+outPatBean2.getBillServCode()+"/"+outPatBean2.getEpisodeEncounter()+"/"+outPatBean2.getClinicNurs()+"/"+outPatBean2.getClinicNursCode()+"/"+outPatBean2.getSpecCode()+"/"+outPatBean2.getStartDate());
								System.err.println(outPatBean.getDiagType()+"/"+outPatBean.getDiagPatCopay()+"/"+outPatBean.getDiagStartDate()+"/"+outPatBean.getDiagEndDate());
								cstmt = con.prepareCall(preAppQueryIns);
								cstmt.setString(1, policyBean.getFacilityId());
								cstmt.setString(2, policyBean.getPayerGroupCode());
								cstmt.setString(3, policyBean.getPayerCode());
								cstmt.setString(4, policyBean.getPolicyTypeCode());
								cstmt.setString(5, outPatBean2.getInclExclCriteria());
								cstmt.setString(6, outPatBean2.getPatClass());
								cstmt.setString(7, outPatBean2.getGender());
								cstmt.setString(8, outPatBean2.getAgeGroup());	
								cstmt.setString(9, outPatBean2.getBillServCode());
								cstmt.setString(10, outPatBean2.getEpisodeEncounter());
								cstmt.setString(11, outPatBean2.getClinicNurs());
								cstmt.setString(12, outPatBean2.getClinicNursCode());
								cstmt.setString(13, outPatBean2.getSpecCode());
								if((outPatBean2.getStartDate() == null) || ("".equals(outPatBean2.getStartDate()))){
									cstmt.setString(14, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(outPatBean2.getStartDate()).getTime());
									System.err.println("fromDt:"+fromDt);
									cstmt.setDate(14, fromDt);
								}	
								if((outPatBean2.getEndDate() == null) || ("".equals(outPatBean2.getEndDate())) ){
									cstmt.setString(15, null);
								}
								else{
									Date toDate = new Date(sdf.parse(outPatBean2.getEndDate()).getTime());
									cstmt.setDate(15, toDate);
								}								
								cstmt.setString(16, outPatBean.getDiagType());
								cstmt.setInt(17, Integer.parseInt(outPatBean.getDiagPatCopay()));
								//cstmt.setString(17, outPatBean.getDiagStartDate());
								if((outPatBean.getDiagStartDate() == null) || ("".equals(outPatBean.getDiagStartDate()))){
									cstmt.setString(18, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(outPatBean.getDiagStartDate()).getTime());
									System.err.println("fromDt1:"+fromDt);
									cstmt.setDate(18, fromDt);
								}
								//cstmt.setString(18, outPatBean.getDiagEndDate());
								if((outPatBean.getDiagEndDate() == null) || ("".equals(outPatBean.getDiagEndDate()))){
									cstmt.setString(19, null);
								}
								else{
									Date toDt = new Date(sdf.parse(outPatBean.getDiagEndDate()).getTime());
									System.err.println("toDt:"+toDt);
									cstmt.setDate(19, toDt);
								}

								cstmt.setString(20, login_user);
								cstmt.setString(21, client_ip_address);
								cstmt.setString(22, facilityId);
								cstmt.setString(23, login_user);								
								cstmt.setString(24, client_ip_address);
								cstmt.setString(25, facilityId);
	
								cstmt.registerOutParameter(26, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(27, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(28, java.sql.Types.VARCHAR);
								
								cstmt.execute();
								str_error_level = cstmt.getString(26);
								str_sysmesage_id = cstmt.getString(27);
								str_error_text = cstmt.getString(28);
							}
						}
						else if("U".equals(checkForNull(outPatBean.getDiagStatus()))){
							System.err.println("Diag Update");
							System.err.println(policyBean.getFacilityId()+"/"+policyBean.getPayerGroupCode()+"/"+policyBean.getPayerCode()+"/"+policyBean.getPolicyTypeCode()+"/"+outPatBean2.getInclExclCriteria()+"/"+outPatBean2.getPatClass()+"/"+outPatBean2.getGender()+"/"+outPatBean2.getAgeGroup()+"/"+outPatBean2.getBillServCode()+"/"+outPatBean2.getEpisodeEncounter()+"/"+outPatBean2.getClinicNurs()+"/"+outPatBean2.getClinicNursCode()+"/"+outPatBean2.getSpecCode()+"/"+outPatBean2.getStartDate());
							System.err.println(outPatBean.getDiagType()+"/"+outPatBean.getDiagPatCopay()+"/"+outPatBean.getDiagStartDate()+"/"+outPatBean.getDiagEndDate());
							cstmt = con.prepareCall(preAppQueryUpd);
							cstmt.setString(1, policyBean.getFacilityId());
							cstmt.setString(2, policyBean.getPayerGroupCode());
							cstmt.setString(3, policyBean.getPayerCode());
							cstmt.setString(4, policyBean.getPolicyTypeCode());
							cstmt.setString(5, outPatBean2.getInclExclCriteria());
							cstmt.setString(6, outPatBean2.getPatClass());
							cstmt.setString(7, outPatBean2.getGender());
							cstmt.setString(8, outPatBean2.getAgeGroup());	
							cstmt.setString(9, outPatBean2.getBillServCode());
							cstmt.setString(10, outPatBean2.getEpisodeEncounter());
							cstmt.setString(11, outPatBean2.getClinicNurs());
							cstmt.setString(12, outPatBean2.getClinicNursCode());
							cstmt.setString(13, outPatBean2.getSpecCode());
							if((outPatBean2.getStartDate() == null) || ("".equals(outPatBean2.getStartDate()))){
								cstmt.setString(14, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean2.getStartDate()).getTime());
								System.err.println("in update diag fromDt:"+fromDt);
								cstmt.setDate(14, fromDt);
							}	
							if((outPatBean2.getEndDate() == null) || ("".equals(outPatBean2.getEndDate())) ){
								cstmt.setString(15, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean2.getEndDate()).getTime());
								cstmt.setDate(15, toDate);
							}							
							cstmt.setString(16, outPatBean.getDiagType());
							cstmt.setInt(17, Integer.parseInt(outPatBean.getDiagPatCopay()));
							//cstmt.setString(17, outPatBean.getDiagStartDate());
							if((outPatBean.getDiagStartDate() == null) || ("".equals(outPatBean.getDiagStartDate()))){
								cstmt.setString(18, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getDiagStartDate()).getTime());
								System.err.println("in update diag fromDt1:"+fromDt);
								cstmt.setDate(18, fromDt);
							}
							//cstmt.setString(18, outPatBean.getDiagEndDate());
							if((outPatBean.getDiagEndDate() == null) || ("".equals(outPatBean.getDiagEndDate()))){
								cstmt.setString(19, null);
							}
							else{
								Date toDt = new Date(sdf.parse(outPatBean.getDiagEndDate()).getTime());
								System.err.println("in update diag toDt:"+toDt);
								cstmt.setDate(19, toDt);
							}

							cstmt.setString(20, login_user);
							cstmt.setString(21, client_ip_address);
							cstmt.setString(22, facilityId);
							cstmt.setString(23, login_user);								
							cstmt.setString(24, client_ip_address);
							cstmt.setString(25, facilityId);

							cstmt.registerOutParameter(26, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(27, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(28, java.sql.Types.VARCHAR);
							
							cstmt.execute();
							str_error_level = cstmt.getString(26);
							str_sysmesage_id = cstmt.getString(27);
							str_error_text = cstmt.getString(28);						
						}						
					}
				}
				else if("Y".equals(outPatBean.getDiagDelFlag())){
					cstmt = con.prepareCall(preAppQueryDel);
					cstmt.setString(1, policyBean.getFacilityId());
					cstmt.setString(2, policyBean.getPayerGroupCode());
					cstmt.setString(3, policyBean.getPayerCode());
					cstmt.setString(4, policyBean.getPolicyTypeCode());
					cstmt.setString(5, outPatBean2.getInclExclCriteria());
					cstmt.setString(6, outPatBean2.getPatClass());
					cstmt.setString(7, outPatBean2.getGender());	
					cstmt.setString(8, outPatBean2.getAgeGroup());				
					cstmt.setString(9, outPatBean2.getBillServCode());					
					cstmt.setString(10, outPatBean2.getEpisodeEncounter());
					cstmt.setString(11, outPatBean2.getClinicNurs());
					cstmt.setString(12, outPatBean2.getClinicNursCode());
					cstmt.setString(13, outPatBean2.getSpecCode());
					if((outPatBean2.getStartDate() == null) || ("".equals(outPatBean2.getStartDate()))){
						cstmt.setString(14, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean2.getStartDate()).getTime());
						System.err.println("in delete diag fromDt1:"+fromDt);
						cstmt.setDate(14, fromDt);
					}

					cstmt.setString(15, outPatBean.getDiagType());
					if((outPatBean.getDiagStartDate() == null) || ("".equals(outPatBean.getDiagStartDate()))){
						cstmt.setString(16, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getDiagStartDate()).getTime());
						System.err.println("in delete diag fromDt1:"+fromDt);
						cstmt.setDate(16, fromDt);
					}
					cstmt.registerOutParameter(17, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(18, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
					cstmt.execute();
					str_error_level = cstmt.getString(17);
					str_sysmesage_id = cstmt.getString(18);
					str_error_text = cstmt.getString(19);					
				}

				String errAdd = "errAdd"+i;
				String errTextAdd = "errTextAdd"+i;
				
				if(str_error_level!=null || str_error_text!=null){
					returnMap.put(errAdd, str_error_level+"-"+str_error_text);
				}
				System.err.println("str_sysmesage_id:"+str_sysmesage_id);
				System.err.println("str_error_level:"+str_error_level);
				System.err.println("str_error_text:"+str_error_text);
				if(str_sysmesage_id!=null){
					String msgAdd = "";
					if(str_sysmesage_id.contains("|")){
						String msgArr[] = str_sysmesage_id.split("\\|");
						for(int l=0;l<msgArr.length;l++){
							msgAdd = "msgAdd"+i+"-"+l;
							
							try{
								System.err.println("msgArr[l]:"+msgArr[l]);
								msgArr[l] = rb.getString(msgArr[l]);
							}
							catch(Exception rbException){
								try{
									System.err.println("msgArr[l] inside try:"+msgArr[l]);
									msgArr[l] = rb2.getString(msgArr[l]);
								}
								catch(Exception rbException1){
									rbException.printStackTrace();
									rbException1.printStackTrace();
									System.err.println("Exceprion in RB ->"+rbException);
									System.err.println("Exceprion in RB ->"+rbException1);
								}								
							}
							returnMap.put(msgAdd, msgArr[l]);
						}
					}else{
						msgAdd = "msgAdd"+i;
						
						try{
							System.err.println("msgArr[l]:"+str_sysmesage_id);
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							try{
								str_sysmesage_id = rb2.getString(str_sysmesage_id);
							}
							catch(Exception rbException1){
								rbException.printStackTrace();
								rbException1.printStackTrace();
								System.err.println("Exceprion in RB ->"+rbException);
								System.err.println("Exceprion in RB ->"+rbException1);
							}								
						}
						returnMap.put(msgAdd, str_sysmesage_id);
					}
				}
				i++;
			}
			cstmt.close();
			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception is "+e);
			returnMap.put("internalError", "Internal Error");
			insertable = false;
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
			
	}
}
