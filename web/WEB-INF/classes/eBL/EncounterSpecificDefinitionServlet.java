/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;  //V230228
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ehis.eslp.ServiceLocator;
import eCommon.Common.CommonAdapter;
import com.ehis.persist.PersistenceHelper;

import blPolicy.EncounterSpecificDefinitionBean;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

import webbeans.eCommon.ConnectionManager;




public class EncounterSpecificDefinitionServlet extends javax.servlet.http.HttpServlet
{
	java.util.Properties p;
	String facilityId="";
	String client_ip_address="";
	String login_user="";
	String slmt_ind="",adm_rec_flag="";
	String locale = "";
	String facility_id = "";
	HttpSession session;
	String mode="";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String str_error_level = "", str_sysmesage_id="", str_error_text="";
	Connection con;

	CallableStatement cstmt = null;
	ResultSet rst = null;
	//SessionContext ctx;
	
	Locale loc = null;
	ResourceBundle rb = null;
	ResourceBundle rb1 = null;
	ResourceBundle rb2 = null;  //V230228
	boolean insertable = false;
	
	EncounterSpecificDefinitionBean outPatBean = null;
	EncounterSpecificDefinitionBean inPatBean = null;
	EncounterSpecificDefinitionBean externalBean = null;	
	EncSpecMFDRBean encSpecMFDRBean = null;  //V230228
	
	Boolean siteSpecDiagBasedCopay = false;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{	
		try{
		int reqId = 0;
		HttpSession session=req.getSession(false);
		locale = (String)session.getAttribute("LOCALE");
		loc = new Locale(locale);
		rb = ResourceBundle.getBundle("eSM.resources.Messages",loc);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		login_user = this.p.getProperty( "login_user" ) ;
		boolean local_ejbs = false;
		String mode = req.getParameter("mode");
		String locale = this.p.getProperty("LOCALE") ;
		facility_id = (String) session.getValue( "facility_id" ) ;
		client_ip_address = this.p.getProperty("client_ip_address") ;
		if ((getServletConfig().getServletContext().getInitParameter(
				"LOCAL_EJBS") != null)
				&& (getServletConfig().getServletContext()
						.getInitParameter("LOCAL_EJBS")
						.equalsIgnoreCase("TRUE"))) {
			local_ejbs = true;
		}
		

		//Object home = ServiceLocator.getInstance().getHome(
				//"java:comp/env/PkgEncounterDefinition",eBL.PkgEncounterDefinition.PkgEncounterDefinitionLocalHome.class, local_ejbs);
		
		//Object busObj = (home.getClass().getMethod("create")).invoke(home);
		HashMap results = new HashMap();
		HashMap tabData = new HashMap();
		
		//
		String beanId = "bl_EncounterSpecificDefinitionBean" ;
		String beanName = "blPolicy.EncounterSpecificDefinitionBean";
		EncounterSpecificDefinitionBean policyBean = (EncounterSpecificDefinitionBean)PersistenceHelper.getBeanObject(beanId, beanName, req) ;
		
		String beanId1 = "bl_EncSpecMFDRBean" ;
		String beanName1 = "eBL.EncSpecMFDRBean";
		EncSpecMFDRBean policyBean1 = (EncSpecMFDRBean)PersistenceHelper.getBeanObject(beanId1, beanName1, req) ;  //V230228
		
		//
		tabData.put("facility_id", facility_id);
		tabData.put("login_user", login_user);
		tabData.put("client_ip_address", client_ip_address);
		tabData.put("mode",mode);
		
		String startDate=req.getParameter("startDate");
		if(policyBean.getStartDate()==null || policyBean.getStartDate().equals("")){
			policyBean.setStartDate(startDate);
		}
		tabData.put("bean_details",policyBean);
		
		/*Object argArray[]  = new Object[2];
		   argArray[0] = tabData;	
		   argArray[1] = p;

		Class [] paramArray	   = new Class[2];
			 paramArray[0] = tabData.getClass();
			 paramArray[1] = p.getClass();
		results=(HashMap) (busObj.getClass().getMethod("insertEncounterDetails",paramArray)).invoke(busObj, argArray);*/
		results = insertEncounterDetails(req,res,tabData,p,policyBean1);  //V230228
		if(results.containsKey("requestId")){
			try{
				reqId = (Integer) results.get("requestId");
			}
			catch(Exception e){
				reqId = 0;
				System.err.println("The Exception in getting Req Id->"+e);
			}
			results.remove("requestId");
		}
		String error = "";
		String mapValue = "";
		int err_val = 1;
		for (Iterator iterator = results.keySet().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			if(!("status".equals(type))){
				mapValue = (String) results.get(type);
				if(mapValue != null){
					error = error+mapValue+"<br/>";
					err_val = 2;
				//}				
				}
			}
		}
		if(error.length()==0){
			try{
				error = rb.getString("RECORD_INSERTED");
			}
			catch(Exception rbException){
				System.err.println("Exception in RB ->"+rbException);  //V230228
				error = "APP-SM0070 Operation Completed Successfully ....";
			}
			//error = "Operation Completed Sucessfully";
		}
		else{
			error = "Record not saved"+"<br/>"+error;
		}
		res.sendRedirect("../eBL/jsp/BLProgressError.jsp?reqId="+reqId+"&err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
		}
		catch(Exception e){
			System.err.println("Exception in CardSubscription Servlet->"+e);
		}

	}
	
	public java.util.HashMap insertEncounterDetails(HttpServletRequest request,
			HttpServletResponse response,java.util.HashMap tabdata,java.util.Properties p, EncSpecMFDRBean policyBean1)  //V230228
	{		
		HashMap returnMap = new HashMap();
		HashMap returnMap1 = new HashMap();   //V230228
		HashMap returnMapAll = new HashMap();	
		
		try{
			con = ConnectionManager.getConnection(p);
			locale = p.getProperty("LOCALE") ;
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			rb1 = ResourceBundle.getBundle("eBL.resources.MessagesExtOne",loc);
			EncounterSpecificDefinitionBean policyBean = new EncounterSpecificDefinitionBean();
			policyBean = (EncounterSpecificDefinitionBean) tabdata.get("bean_details");
			mode = (String) tabdata.get("mode");
			login_user = (String) tabdata.get("login_user");
			facilityId = (String) tabdata.get("facilityId");
			client_ip_address = (String) tabdata.get("client_ip_address");
			
			siteSpecDiagBasedCopay = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DIAG_BASED_COPAY_DEFN");//MOHE-CRF-0114
			
			System.err.println(" before insertHeaderDetails()  policyBean in EJB" + policyBean);
			returnMap=insertHeaderDetails(policyBean,mode);			
			
			System.err.println(" before insertPolicyDetails()" + returnMap.toString() );
			if(((Boolean) returnMap.get("status")).booleanValue()){
				returnMap=insertPolicyDetails(policyBean,mode);
			}
			
			System.err.println(" before insertPreApprovalDetails()" + returnMap.toString() );
			if(((Boolean) returnMap.get("status")).booleanValue()){
				returnMap=insertPreApprovalDetails(policyBean,mode);
			}
			
			System.err.println(" before recalculation()" + returnMap.toString() );
			if("Y".equals(policyBean.getRecalcCharges())){
				if(((Boolean) returnMap.get("status")).booleanValue()){
					returnMap=recalculation(policyBean);
				}
			}
			
			
			//V230228
			if(((Boolean) returnMap.get("status")).booleanValue()){
			HashMap<String, List<EncSpecMFDRBean> > servicesAndItemsCat = policyBean1.getPolicyMap();  
				servicesAndItemsCat.get("ServicesAndItemsCatDtlsPageInfo"); //ServicesAndItemsCatDtlsPageInfo
				if(!servicesAndItemsCat.isEmpty()){
					returnMap=insertServicesAndItemsCategoryDetails(request,response,policyBean1);
				}else{
					returnMap.put("status", true);
				}
			}
			System.err.println(" before commit/rollback" + returnMap.toString() );
			if (((Boolean) returnMap.get("status")).booleanValue())  //V230228
			{
				con.commit();
			}
			else 
			{
				con.rollback();
				
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
		return returnMap;
	}
	
	private HashMap recalculation(EncounterSpecificDefinitionBean policyBean) {
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		int reqId = 0;
		try{
			
			//String reclac = "{ call   bl_recalc_process.proc_recalculation (?,?,?,?,?,?,?,?,?,?) }";
			String reclac = "{ call   bl_recalc_process.proc_recalc (?,?,?,?,?,?,?,?,?,?,?,?) }";
			cstmt = con.prepareCall(reclac);

			cstmt.setString(1, policyBean.getFacilityId());
			cstmt.setString(2, policyBean.getPatientId());
			cstmt.setString(3, policyBean.getEpisodeType());
			cstmt.setString(4, policyBean.getEpisodeId());
			cstmt.setString(5, policyBean.getVisitId());
			cstmt.setString(6, client_ip_address);
			cstmt.setString(7, login_user);
			cstmt.setString(8, "ENCOUNTER_DEFINITION");
			cstmt.registerOutParameter(9, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(12, java.sql.Types.INTEGER);
			
			
			System.err.println("fac-"+policyBean.getFacilityId()+"pat-"+policyBean.getPatientId()+	"EP TYpe-"+policyBean.getEpisodeType()+"EP ID-"+policyBean.getEpisodeId()+
			"Cl IP="+client_ip_address+"uswer-"+login_user+"visit-"+policyBean.getVisitId());
			cstmt.execute();
			str_error_level = cstmt.getString(10);
			str_sysmesage_id = cstmt.getString(9);
			str_error_text = cstmt.getString(11);
			reqId = cstmt.getInt(12);
			System.err.println("str_error_level-"+str_error_level+"str_sysmesage_id-"+str_sysmesage_id+
					"str_error_text-"+str_error_text);
			if(str_error_level!=null || str_error_text!=null){
				returnMap.put("recalcHdr", str_error_level+"-"+str_error_text);
			}

			if(str_sysmesage_id!=null){
				String msgAdd = "";
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){
					msgAdd = "recalcMsg"+"-"+l;

					try{
						msgArr[l] = rb.getString(msgArr[l]);
					}
					catch(Exception rbException){
						System.err.println("Exception in recalculation 217 ->"+rbException);
						rbException.printStackTrace();
					}
					returnMap.put(msgAdd, msgArr[l]);
					}
				}else{
					msgAdd = "recalcMsg";

					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						System.err.println("Exception in recalculation 229 ->"+rbException);
						rbException.printStackTrace();
					}
					returnMap.put(msgAdd, str_sysmesage_id);
				}
			}


			if (!returnMap.isEmpty()) {
				insertable = false;
			} else {
				insertable = true;
			}

			returnMap.put("requestId", reqId);
			cstmt.close();

		}
		catch(Exception e){
			System.err.println("Exception iss2 "+e);
			e.printStackTrace();
			returnMap.put("internalError", "Internal Error");
			insertable = false;
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
		
	}

	// Policy Definition Methods
	
	private HashMap insertPreApprovalDetails(EncounterSpecificDefinitionBean policyBean, String mode2) {
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		try{
			HashMap<String,List<EncounterSpecificDefinitionBean>> policyMap = policyBean.getPolicyMap();
			con.setAutoCommit(false);
			List<EncounterSpecificDefinitionBean> preAppList = null; 
			if(!(policyMap == null || policyMap.isEmpty())){
				preAppList = policyMap.get("preApproval");
				if(preAppList == null){
					preAppList = new ArrayList<EncounterSpecificDefinitionBean>();
					outPatBean = new EncounterSpecificDefinitionBean();
					preAppList.add(outPatBean);
				}
			}
			else{
				policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
				preAppList = new ArrayList<EncounterSpecificDefinitionBean>();
				outPatBean = new EncounterSpecificDefinitionBean();
				preAppList.add(outPatBean);		
			}
			//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020  ADDED ONE PARAMETER CALLED GroupRservice TO INSERT AND UPDATE
			String preAppQueryIns = "{ call   BLINSTRANSACTIONS.insert_enc_spec_preapp_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String preAppQueryUpd = "{ call   BLINSTRANSACTIONS.update_enc_spec_preapp_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			String preAppQueryDel = "{ call   BLINSTRANSACTIONS.delete_enc_spec_preapp_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			int i=1;
			for(EncounterSpecificDefinitionBean outPatBean : preAppList)
			{
				if("N".equals(outPatBean.getDelFlag())){
					if("I".equals(checkForNull(outPatBean.getStatus()))){
						if(("".equals(checkForNull(outPatBean.getEpisodeEncounter())) && "".equals(checkForNull(outPatBean.getPatClass())) && "".equals(checkForNull(outPatBean.getAgeGroup())) && "".equals(checkForNull(outPatBean.getGender()))  && "".equals(checkForNull(outPatBean.getClinicNursCode())) && "".equals(checkForNull(outPatBean.getSpecCode())) && "".equals(checkForNull(outPatBean.getBillServCode())))){
						}
						else{
							if(!("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getAgeGroup())) || "".equals(checkForNull(outPatBean.getGender()))  || "".equals(checkForNull(outPatBean.getClinicNursCode())) || "".equals(checkForNull(outPatBean.getSpecCode())) || "".equals(checkForNull(outPatBean.getBillServCode())) || "".equals(checkForNull(outPatBean.getStartDate())))){
								cstmt = con.prepareCall(preAppQueryIns);
								
								cstmt.setString(1, policyBean.getFacilityId());
								cstmt.setString(2, policyBean.getPatientId());
								cstmt.setString(3, policyBean.getEpisodeType());
								cstmt.setString(4, policyBean.getEpisodeId());
								cstmt.setString(5, policyBean.getVisitId());
								cstmt.setString(6, policyBean.getEncounterId());
								cstmt.setString(7, policyBean.getAccEntityID());
								cstmt.setString(8, policyBean.getPriority());
								cstmt.setString(9, policyBean.getPayerGroupCode());
								cstmt.setString(10, policyBean.getPolicyTypeCode());
								cstmt.setString(11, policyBean.getPayerCode());
								cstmt.setString(12, outPatBean.getBillServCode());
								cstmt.setString(13, outPatBean.getType());
								cstmt.setString(14, outPatBean.getPatClass());
								cstmt.setString(15, outPatBean.getEpisodeEncounter());
								cstmt.setString(16, outPatBean.getClinicNurs());
								cstmt.setString(17, outPatBean.getClinicNursCode());
								cstmt.setString(18, outPatBean.getSpecCode());
								cstmt.setString(19, outPatBean.getServLimit());
								cstmt.setString(20, outPatBean.getPreApprAmtCapping());
								cstmt.setString(21, outPatBean.getPreApprQtyCapping());
								if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
									cstmt.setString(22, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
									cstmt.setDate(22, fromDt);
								}
								
								if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
									cstmt.setString(23, null);
								}
								else{
									Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
									cstmt.setDate(23, toDate);
								}
								cstmt.setString(24, outPatBean.getAmtGrossNet());	
								cstmt.setString(25, login_user);
								cstmt.setString(26, login_user);
								cstmt.setString(27, client_ip_address);
								cstmt.setString(28, policyBean.getFacilityId());
								cstmt.setString(29, client_ip_address);
								cstmt.setString(30, policyBean.getFacilityId());
								cstmt.setString(31, outPatBean.getGender());	
								cstmt.setString(32, outPatBean.getAgeGroup());	
								cstmt.registerOutParameter(33, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(34, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(35, java.sql.Types.VARCHAR);
								cstmt.setString(36, outPatBean.getPreApprDurCapping());	//Added V180725-Gayathri/MMS-DM-CRF-0126
								cstmt.setString(37, outPatBean.getPreacrossenc());	//Added V190326-Dhananjay/MMS-DM-CRF-0158
								cstmt.setString(38, outPatBean.getGroupRservice());//ADDED FOR MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 
								cstmt.execute();
								str_error_level = cstmt.getString(33);
								str_sysmesage_id = cstmt.getString(34);
								str_error_text = cstmt.getString(35);
							}
							else{
								str_error_text = "Pre Approval Details Tab. Row Number "+i+". Please Enter all mandatory fields";
							}
						}
					}
					else if("U".equals(checkForNull(outPatBean.getStatus()))){
							cstmt = con.prepareCall(preAppQueryUpd);
							
							cstmt.setString(1, policyBean.getFacilityId());
							cstmt.setString(2, policyBean.getPatientId());
							cstmt.setString(3, policyBean.getEpisodeType());
							cstmt.setString(4, policyBean.getEpisodeId());
							cstmt.setString(5, policyBean.getVisitId());
							cstmt.setString(6, policyBean.getEncounterId());
							cstmt.setString(7, policyBean.getAccEntityID());
							cstmt.setString(8, policyBean.getPriority());
							cstmt.setString(9, policyBean.getPayerGroupCode());
							cstmt.setString(10, policyBean.getPolicyTypeCode());
							cstmt.setString(11, policyBean.getPayerCode());
							cstmt.setString(12, outPatBean.getBillServCode());
							cstmt.setString(13, outPatBean.getType());
							cstmt.setString(14, outPatBean.getPatClass());
							cstmt.setString(15, outPatBean.getEpisodeEncounter());
							cstmt.setString(16, outPatBean.getClinicNurs());
							cstmt.setString(17, outPatBean.getClinicNursCode());
							cstmt.setString(18, outPatBean.getSpecCode());
							cstmt.setString(19, outPatBean.getServLimit());
							cstmt.setString(20, outPatBean.getPreApprAmtCapping());
							cstmt.setString(21, outPatBean.getPreApprQtyCapping());
							if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
								cstmt.setString(22, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
								cstmt.setDate(22, fromDt);
							}
							
							if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
								cstmt.setString(23, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
								cstmt.setDate(23, toDate);
							}
							cstmt.setString(24, outPatBean.getAmtGrossNet());	
							cstmt.setString(25, login_user);
							cstmt.setString(26, client_ip_address);
							cstmt.setString(27, policyBean.getFacilityId());
							cstmt.setString(28, outPatBean.getGender());	
							cstmt.setString(29, outPatBean.getAgeGroup());	
							cstmt.registerOutParameter(30, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(31, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(32, java.sql.Types.VARCHAR);
							cstmt.setString(33, null);	
							cstmt.setDate(34, null);	
							cstmt.setDate(35, null);	
							cstmt.setString(36, null);	
							cstmt.setString(37, null);	
							cstmt.setString(38, null);	
							cstmt.setString(39, null);	
							cstmt.setString(40, null);	
							cstmt.setString(41, outPatBean.getPreApprDurCapping());	//Added V180725-Gayathri/MMS-DM-CRF-0126
							cstmt.setString(42, null);	
							cstmt.setString(43, outPatBean.getPreacrossenc());	//Added V190326-Dhananjay/MMS-DM-CRF-0158
							cstmt.setString(44, outPatBean.getGroupRservice()); //MMS-QH-CRF-0170-US-4  Ram kuamr S 28/08/2020 
							cstmt.execute();
							str_error_level = cstmt.getString(30);
							str_sysmesage_id = cstmt.getString(31);
							str_error_text = cstmt.getString(32);						
					}
				}
				else if("Y".equals(outPatBean.getDelFlag())){
					cstmt = con.prepareCall(preAppQueryDel);		
					
					cstmt.setString(1, policyBean.getFacilityId());
					cstmt.setString(2, policyBean.getPatientId());
					cstmt.setString(3, policyBean.getEpisodeType());
					cstmt.setString(4, policyBean.getEpisodeId());
					cstmt.setString(5, policyBean.getVisitId());
					cstmt.setString(6, policyBean.getAccEntityID());
					cstmt.setString(7, policyBean.getPriority());
					cstmt.setString(8, outPatBean.getBillServCode());
					cstmt.setString(9, outPatBean.getType());
					cstmt.setString(10, outPatBean.getPatClass());
					cstmt.setString(11, outPatBean.getEpisodeEncounter());
					cstmt.setString(12, outPatBean.getClinicNurs());
					cstmt.setString(13, outPatBean.getClinicNursCode());
					cstmt.setString(14, outPatBean.getSpecCode());
					if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
						cstmt.setString(15, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
						cstmt.setDate(15, fromDt);
					}
					cstmt.setString(16, outPatBean.getGender());	
					cstmt.setString(17, outPatBean.getAgeGroup());	
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
								System.err.println("Exception in insertPreApprovalDetails ->"+rbException);
								rbException.printStackTrace();
							}
							returnMap.put(msgAdd, msgArr[l]);
						}
					}else{
						msgAdd = "msgAdd"+i;
						
						try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							System.err.println("Exception in insertPreApprovalDetails 491 ->"+rbException);
							rbException.printStackTrace();
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
			System.err.println("Exception iss3 "+e);
			e.printStackTrace();
			returnMap.put("internalError", "Internal Error");
			insertable = false;
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
		
	}

	private HashMap insertPolicyDetails(EncounterSpecificDefinitionBean policyBean, String mode2) {
		HashMap returnMap = new HashMap();
		HashMap returnPopup = new HashMap();
		boolean insertable = false;
		try{
			HashMap<String,List<EncounterSpecificDefinitionBean>> policyMap = policyBean.getPolicyMap();
			con.setAutoCommit(false);
			List<EncounterSpecificDefinitionBean> inclList = null; 
			if(!(policyMap == null || policyMap.isEmpty())){
				inclList = policyMap.get("inclExclCoverage");
				if(inclList == null){
					inclList = new ArrayList<EncounterSpecificDefinitionBean>();
					outPatBean = new EncounterSpecificDefinitionBean();
					inclList.add(outPatBean);
				}
			}
			else{
				policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
				inclList = new ArrayList<EncounterSpecificDefinitionBean>();
				outPatBean = new EncounterSpecificDefinitionBean();
				inclList.add(outPatBean);		
			}
			
			//Added V181003-Aravindh/AAKH-CRF-0107/if-else conidition
			String preAppQueryIns = "", preAppQueryUpd = "", preAppQueryDel = "";
			//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020  ADDED TWO PARAMETER CALLED GROUP SERVICE TO INSERT AND UPDATE
			preAppQueryIns = "{ call   BLINSTRANSACTIONS.insert_enc_spec_policy_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null,null,null,?,?,?,?,?,?,?,?) }";
			preAppQueryUpd = "{ call   BLINSTRANSACTIONS.update_enc_spec_policy_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			preAppQueryDel = "{ call   BLINSTRANSACTIONS.delete_enc_spec_policy_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			int i=1;
			for(EncounterSpecificDefinitionBean outPatBean : inclList)
			{
				if("N".equals(outPatBean.getDelFlag())){
					if(("I".equals(checkForNull(outPatBean.getStatus()))) || ("U".equals(checkForNull(outPatBean.getStatus())))){
						if("I".equals(checkForNull(outPatBean.getStatus()))){
							if(("".equals(checkForNull(outPatBean.getEpisodeEncounter())) && "".equals(checkForNull(outPatBean.getPatClass())) && "".equals(checkForNull(outPatBean.getAgeGroup())) && "".equals(checkForNull(outPatBean.getGender()))  && "".equals(checkForNull(outPatBean.getClinicNursCode())) && "".equals(checkForNull(outPatBean.getSpecCode())) && "".equals(checkForNull(outPatBean.getBillServCode())))){
							}
							else{
								if(!("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getAgeGroup())) || "".equals(checkForNull(outPatBean.getGender()))  || "".equals(checkForNull(outPatBean.getClinicNursCode())) || "".equals(checkForNull(outPatBean.getSpecCode())) || "".equals(checkForNull(outPatBean.getBillServCode())) || "".equals(checkForNull(outPatBean.getStartDate())))){
									cstmt = con.prepareCall(preAppQueryIns);
									cstmt.setString(1, policyBean.getFacilityId());
									cstmt.setString(2, policyBean.getPatientId());
									cstmt.setString(3, policyBean.getEpisodeType());
									cstmt.setString(4, policyBean.getEpisodeId());
									cstmt.setString(5, policyBean.getVisitId());
									cstmt.setString(6, policyBean.getEncounterId());
									cstmt.setString(7, policyBean.getAccEntityID());
									cstmt.setString(8, policyBean.getPayerCode());
									cstmt.setString(9, policyBean.getPriority());
		
									
									cstmt.setString(10, outPatBean.getInclExclCriteria());
									cstmt.setString(11, outPatBean.getBillServChk());
									cstmt.setString(12, outPatBean.getValueChk1());
									cstmt.setString(13, outPatBean.getInclExclIndChk());
									cstmt.setString(14, policyBean.getPolicyTypeCode());
									cstmt.setString(15, outPatBean.getBillServCode());
									cstmt.setString(16, outPatBean.getInclExclInd());
									cstmt.setString(17, outPatBean.getInclusionBasis());
									cstmt.setString(18, outPatBean.getValue());
									cstmt.setString(19, null);
									cstmt.setString(20, null);
									cstmt.setString(21, null);
		
									if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
										cstmt.setString(22, null);
									}
									else{
										Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
										cstmt.setDate(22, fromDt);
									}
									cstmt.setString(23, login_user);
									cstmt.setString(24, login_user);
									cstmt.setString(25, client_ip_address);
									cstmt.setString(26, policyBean.getFacilityId());
									cstmt.setString(27, client_ip_address);
									cstmt.setString(28, policyBean.getFacilityId());
		
									cstmt.setString(29, policyBean.getPayerGroupCode());
									cstmt.setString(30, policyBean.getPolRefCustCode());
									cstmt.setString(31, outPatBean.getValueChk4());
									cstmt.setString(32, outPatBean.getValueChk3());
									cstmt.setString(33, policyBean.getBlngGrpid());
									cstmt.setString(34, policyBean.getPolicyNo());
									
									
									if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
										cstmt.setString(35, null);
									}
									else{
										Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
										cstmt.setDate(35, fromDt);
									}
									cstmt.setString(36, outPatBean.getPatClass());
									cstmt.setString(37, outPatBean.getAmtPerVisit());
									cstmt.setString(38, outPatBean.getServItemQty());
									cstmt.setString(39, outPatBean.getAmtPerIPDay());
									cstmt.setString(40, outPatBean.getNoOfDays());
								
									
									
									cstmt.setString(41, outPatBean.getEpisodeEncounter());
									cstmt.setString(42, outPatBean.getClinicNurs());
									cstmt.setString(43, outPatBean.getClinicNursCode());
									cstmt.setString(44, outPatBean.getSpecCode());
		
									if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
										cstmt.setString(45, null);
									}
									else{
										Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
										cstmt.setDate(45, toDate);
									}
									
									cstmt.setString(46, outPatBean.getAmtGrossNet());	
									cstmt.setString(47, outPatBean.getGender());	
									cstmt.setString(48, outPatBean.getAgeGroup());
									
									
									System.err.println(" IncludeHomeMedication :::::: "+outPatBean.getPreApprDurCapping());
									
									cstmt.setString(49, outPatBean.getPatCopay());
									cstmt.setString(50, outPatBean.getPatLimitAmt());

									cstmt.setString(51, outPatBean.getIncludeHomeMedication());//deep
									System.err.println("after home med incl");
									cstmt.registerOutParameter(52, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(53, java.sql.Types.VARCHAR);									
									cstmt.registerOutParameter(54, java.sql.Types.VARCHAR);
								//	cstmt.setString(55,outPatBean.getPreApprDurCapping());
									//System.err.println("in insert in enc "+outPatBean.getPreApprDurCapping());
									if(null == outPatBean.getCoverRefPrice() || !(outPatBean.getCoverRefPrice().equals("Y"))) {
										cstmt.setString(55, "N");
									} else {
										cstmt.setString(55, outPatBean.getCoverRefPrice());//Added V181008-Aravindh/AAKH-CRF-0107
									}
									cstmt.setString(56, outPatBean.getExlinclacrossenc());//Added V190326-Dhananjay/MMS-DM-CRF-0158
									//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->									
									if((outPatBean.getGroupRservice() == null) || ("".equals(outPatBean.getGroupRservice()))){
										cstmt.setString(57, null);
									}
									else{										
										cstmt.setString(57, outPatBean.getGroupRservice());
									}									
									//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 ENDS-->
									
									// MOHE-CRF-0114 starts
									if(siteSpecDiagBasedCopay){
										if((outPatBean.getDiagCopaySetup() == null) || ("".equals(outPatBean.getDiagCopaySetup()))){
											cstmt.setString(58, null);
										}
										else{										
											cstmt.setString(58, outPatBean.getDiagCopaySetup());
										}	
									}		
									else	
									{							
										cstmt.setString(58, null);
									}
									// MOHE-CRF-0114 Ends									
									cstmt.execute();
									str_error_level = cstmt.getString(52);
									str_sysmesage_id = cstmt.getString(53);
									str_error_text = cstmt.getString(54);
									
									System.err.println(" str_error_level / str_sysmesage_id /str_error_text::::::::: "+str_error_level+"/"+str_sysmesage_id+"/"+str_error_text );
								}
								else{
									str_error_text = "Include/ Exclude Coverage Tab. Row Number "+i+". Please Enter all mandatory fields";
								}
							}
						}
						else if("U".equals(checkForNull(outPatBean.getStatus()))){
							cstmt = con.prepareCall(preAppQueryUpd);
							cstmt.setString(1, policyBean.getFacilityId());
							cstmt.setString(2, policyBean.getPatientId());
							cstmt.setString(3, policyBean.getEpisodeType());
							cstmt.setString(4, policyBean.getEpisodeId());
							cstmt.setString(5, policyBean.getVisitId());
							cstmt.setString(6, policyBean.getEncounterId());
							cstmt.setString(7, policyBean.getAccEntityID());
							cstmt.setString(8, policyBean.getPayerCode());
							cstmt.setString(9, policyBean.getPriority());

							
							cstmt.setString(10, outPatBean.getInclExclCriteria());
							cstmt.setString(11, outPatBean.getBillServChk());
							cstmt.setString(12, outPatBean.getValueChk1());
							cstmt.setString(13, outPatBean.getInclExclIndChk());
							cstmt.setString(14, policyBean.getPolicyTypeCode());
							cstmt.setString(15, outPatBean.getBillServCode());
							cstmt.setString(16, outPatBean.getInclExclInd());
							cstmt.setString(17, outPatBean.getInclusionBasis());
							cstmt.setString(18, outPatBean.getValue());
							cstmt.setString(19, null);
							cstmt.setString(20, null);
							cstmt.setString(21, null);

							if((outPatBean.getEffectiveDate() == null) || ("".equals(outPatBean.getEffectiveDate()))){
								cstmt.setString(22, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getEffectiveDate()).getTime());
								cstmt.setDate(22, fromDt);
							}
							cstmt.setString(23, login_user);
							cstmt.setString(24, client_ip_address);
							cstmt.setString(25, policyBean.getFacilityId());

							cstmt.setString(26, policyBean.getPayerGroupCode());
							cstmt.setString(27, policyBean.getPolRefCustCode());
							cstmt.setString(28, outPatBean.getValueChk4());
							cstmt.setString(29, outPatBean.getValueChk3());
							cstmt.setString(30, policyBean.getBlngGrpid());
							cstmt.setString(31, policyBean.getPolicyNo());
							
							if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
								cstmt.setString(32, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
								cstmt.setDate(32, fromDt);
							}
							cstmt.setString(33, outPatBean.getPatClass());
							cstmt.setString(34, outPatBean.getAmtPerVisit());
							cstmt.setString(35, outPatBean.getServItemQty());
							cstmt.setString(36, outPatBean.getAmtPerIPDay());
							cstmt.setString(37, outPatBean.getNoOfDays());
						
							
							
							cstmt.setString(38, outPatBean.getEpisodeEncounter());
							cstmt.setString(39, outPatBean.getClinicNurs());
							cstmt.setString(40, outPatBean.getClinicNursCode());
							cstmt.setString(41, outPatBean.getSpecCode());

							if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
								cstmt.setString(42, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
								cstmt.setDate(42, toDate);
							}
							
							cstmt.setString(43, outPatBean.getAmtGrossNet());	
							cstmt.setString(44, outPatBean.getGender());	
							cstmt.setString(45, outPatBean.getAgeGroup());	

							cstmt.setString(46, outPatBean.getPatCopay());
							cstmt.setString(47, outPatBean.getPatLimitAmt());
							System.err.println(" IncludeHomeMedication ::::: "+ outPatBean.getIncludeHomeMedication());
							System.err.println(" IncludeHomeMedication :::::: "+outPatBean.getPreApprDurCapping());
							cstmt.setString(48, outPatBean.getIncludeHomeMedication()); //deep
							cstmt.registerOutParameter(49, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(50, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(51, java.sql.Types.VARCHAR);
						//	cstmt.setString(52,outPatBean.getPreApprDurCapping());
						//	System.err.println("in update encl "+outPatBean.getPreApprDurCapping());
							if(null == outPatBean.getCoverRefPrice() || !(outPatBean.getCoverRefPrice().equals("Y"))) {
								cstmt.setString(52, "N");
							} else {
								cstmt.setString(52, outPatBean.getCoverRefPrice());//Added V181008-Aravindh/AAKH-CRF-0107
							}
							cstmt.setString(53, outPatBean.getExlinclacrossenc());//Added V190326-Dhananjay/MMS-DM-CRF-0158
							//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->							
							if((outPatBean.getGroupRservice() == null) || ("".equals(outPatBean.getGroupRservice()))){
								cstmt.setString(54, null);
							}
							else{									
								cstmt.setString(54, outPatBean.getGroupRservice());
							} 
							//MMS-QH-CRF-0170-US-4  Ram kumar S 28/08/2020 STARTS-->
							
							// MOHE-CRF-0114 starts
							if(siteSpecDiagBasedCopay){
								if((outPatBean.getDiagCopaySetup() == null) || ("".equals(outPatBean.getDiagCopaySetup()))){
									cstmt.setString(55, null);
								}
								else{										
									cstmt.setString(55, outPatBean.getDiagCopaySetup());
								}	
							}		
							else	
							{							
								cstmt.setString(55, null);
							}
							// MOHE-CRF-0114 Ends							
							cstmt.execute();
							str_error_level = cstmt.getString(49);
							str_sysmesage_id = cstmt.getString(50);
							str_error_text = cstmt.getString(51);
						}
						
					
						
						if(str_error_level==null && str_error_text==null){
							if("Y".equals(outPatBean.getServLimit())){
								returnPopup = insertPolictDetailsPopup(outPatBean,policyBean,mode);
								if(!(((Boolean) returnPopup.get("status")).booleanValue())){
									returnMap.putAll(returnPopup);
								}	
							}
							System.err.println("outPatBean.getDiagCopaySetup() inside enc spec PD update:"+outPatBean.getDiagCopaySetup());
							if("Y".equals(outPatBean.getDiagCopaySetup())){
								returnPopup = insertPolictDetailsDiagCopayPopup(outPatBean,policyBean);
								if(!(((Boolean) returnPopup.get("status")).booleanValue())){
									returnMap.putAll(returnPopup);
								}	
							}							
						}
					}
				}
				else if("Y".equals(outPatBean.getDelFlag())){
					cstmt = con.prepareCall(preAppQueryDel);
					cstmt.setString(1, policyBean.getFacilityId());
					cstmt.setString(2, policyBean.getPatientId());
					cstmt.setString(3, policyBean.getEpisodeType());
					cstmt.setString(4, policyBean.getEpisodeId());
					cstmt.setString(5, policyBean.getVisitId());
					cstmt.setString(6, policyBean.getAccEntityID());
					cstmt.setString(7, policyBean.getPriority());
					cstmt.setString(8, outPatBean.getPatClass());
					cstmt.setString(9, outPatBean.getInclExclCriteria());
					cstmt.setString(10, outPatBean.getBillServCode());
					cstmt.setString(11, outPatBean.getEpisodeEncounter());
					cstmt.setString(12, outPatBean.getClinicNurs());
					cstmt.setString(13, outPatBean.getClinicNursCode());
					
					cstmt.setString(14, outPatBean.getSpecCode());

					if((outPatBean.getEffectiveDate() == null) || ("".equals(outPatBean.getEffectiveDate()))){
						cstmt.setString(15, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getEffectiveDate()).getTime());
						cstmt.setDate(15, fromDt);
					}
					
					cstmt.setString(16, outPatBean.getGender());	
					cstmt.setString(17, outPatBean.getAgeGroup());	
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
								System.err.println("Exception in insertPolicyDetails ->"+rbException);
								try{
									msgArr[l] = rb1.getString(msgArr[l]);
								}
								catch(Exception rbException1){
									rbException.printStackTrace();
									rbException1.printStackTrace();
									System.err.println("Exception in ESPD Dtls  1 ->"+rbException);
									System.err.println("Exception in ESPD Dtls  2 ->"+rbException1);
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
							System.err.println("Exception in insertPolicyDetails 862 ->"+rbException);
							try{
								str_sysmesage_id = rb1.getString(str_sysmesage_id);
							}
							catch(Exception rbException1){
								rbException.printStackTrace();
								rbException1.printStackTrace();
								System.err.println("Exception in ESPD Dtls  3 ->"+rbException);
								System.err.println("Exception in ESPD Dtls  4 ->"+rbException1);
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
			System.err.println("Exception iss1 "+e);
			e.printStackTrace();
			insertable = false;
			returnMap.put("internalError", "Internal Error");
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
	}

	private HashMap insertPolictDetailsPopup(EncounterSpecificDefinitionBean outPatBean2, EncounterSpecificDefinitionBean policyBean, String mode2) {
		
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		try{
			HashMap<String,List<EncounterSpecificDefinitionBean>> policyMap = policyBean.getPopupMap();
			con.setAutoCommit(false);
			List<EncounterSpecificDefinitionBean> preAppList = null; 
			if(!(policyMap == null || policyMap.isEmpty())){
				preAppList = policyMap.get(outPatBean2.getRowNumber());
				if(preAppList == null){
					preAppList = new ArrayList<EncounterSpecificDefinitionBean>();
					outPatBean = new EncounterSpecificDefinitionBean();
					preAppList.add(outPatBean);
				}
			}
			else{
				policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
				preAppList = new ArrayList<EncounterSpecificDefinitionBean>();
				outPatBean = new EncounterSpecificDefinitionBean();
				preAppList.add(outPatBean);		
			}
			
			//Added V181003-Aravindh/AAKH-CRF-0107/if-else conidition
			String preAppQueryIns = "", preAppQueryUpd = "", preAppQueryDel = "";
			
			preAppQueryIns = "{ call   BLINSTRANSACTIONS.insert_enc_spec_policy_excl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,null,null,null,?,?,?,?,?) }";
			preAppQueryUpd = "{ call   BLINSTRANSACTIONS.update_enc_spec_policy_excl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			preAppQueryDel = "{ call    BLINSTRANSACTIONS.delete_enc_spec_policy_excl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			
			int i=1;
			for(EncounterSpecificDefinitionBean outPatBean : preAppList)
			{
				if("N".equals(outPatBean.getDelFlag())){
					if(("I".equals(checkForNull(outPatBean.getStatus()))) || ("U".equals(checkForNull(outPatBean.getStatus())))){
						if("I".equals(checkForNull(outPatBean.getStatus()))){
							if("".equals(checkForNull(outPatBean.getBillServCode()))){
							}
							else{
								cstmt = con.prepareCall(preAppQueryIns);
								cstmt.setString(1, policyBean.getFacilityId());
								cstmt.setString(2, policyBean.getPatientId());
								cstmt.setString(3, policyBean.getEpisodeType());
								cstmt.setString(4, policyBean.getEpisodeId());
								cstmt.setString(5, policyBean.getVisitId());
								cstmt.setString(6, policyBean.getEncounterId());
								cstmt.setString(7, policyBean.getAccEntityID());
								cstmt.setString(8, policyBean.getPayerCode());
								cstmt.setString(9, policyBean.getPriority());
	
								
								cstmt.setString(10, outPatBean2.getInclExclCriteria());
								cstmt.setString(11, outPatBean2.getBillServChk());
								cstmt.setString(12, outPatBean2.getValueChk1());
								cstmt.setString(13, outPatBean2.getInclExclIndChk());
								cstmt.setString(14, policyBean.getPolicyTypeCode());
								cstmt.setString(15, outPatBean2.getBillServCode());
								cstmt.setString(16, outPatBean.getInclExclInd());
								cstmt.setString(17, outPatBean.getInclusionBasis());
								cstmt.setString(18, outPatBean.getValue());
								cstmt.setString(19, null);
								cstmt.setString(20, null);
								cstmt.setString(21, null);
								
								
								if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
									cstmt.setString(22, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
									cstmt.setDate(22, fromDt);
								}
								cstmt.setString(23, login_user);
								cstmt.setString(24, login_user);
								cstmt.setString(25, client_ip_address);
								cstmt.setString(26, policyBean.getFacilityId());
								cstmt.setString(27, client_ip_address);
								cstmt.setString(28, policyBean.getFacilityId());
	
								cstmt.setString(29, policyBean.getPayerGroupCode());
								cstmt.setString(30, policyBean.getPolRefCustCode());
								cstmt.setString(31, outPatBean2.getValueChk4());
								cstmt.setString(32, outPatBean2.getValueChk3());
								cstmt.setString(33, policyBean.getBlngGrpid());
								cstmt.setString(34, policyBean.getPolicyNo());
								
								if((outPatBean2.getStartDate() == null) || ("".equals(outPatBean2.getStartDate()))){
									cstmt.setString(35, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(outPatBean2.getStartDate()).getTime());
									cstmt.setDate(35, fromDt);
								}
								cstmt.setString(36, outPatBean2.getPatClass());
								cstmt.setString(37, outPatBean.getAmtPerVisit());
								cstmt.setString(38, outPatBean.getServItemQty());
								cstmt.setString(39, outPatBean.getAmtPerIPDay());
								cstmt.setString(40, outPatBean.getNoOfDays());
							
								
								
								cstmt.setString(41, outPatBean2.getEpisodeEncounter());
								cstmt.setString(42, outPatBean2.getClinicNurs());
								cstmt.setString(43, outPatBean2.getClinicNursCode());
								cstmt.setString(44, outPatBean2.getSpecCode());
	
								if((outPatBean2.getEndDate() == null) || ("".equals(outPatBean2.getEndDate())) ){
									cstmt.setString(45, null);
								}
								else{
									Date toDate = new Date(sdf.parse(outPatBean2.getEndDate()).getTime());
									cstmt.setDate(45, toDate);
								}
								
								cstmt.setString(46, outPatBean.getAmtGrossNet());	
								cstmt.setString(47, outPatBean.getInclExclCriteria());
								cstmt.setString(48, outPatBean.getBillServCode());
						
								if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
									cstmt.setString(49, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
									cstmt.setDate(49, fromDt);
								}
								if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
									cstmt.setString(50, null);
								}
								else{
									Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
									cstmt.setDate(50, toDate);
								}
	
								cstmt.setString(51, outPatBean2.getGender());	
								cstmt.setString(52, outPatBean2.getAgeGroup());	
								cstmt.setString(53, outPatBean.getPatCopay());
								cstmt.setString(54, outPatBean.getPatLimitAmt());
								
								cstmt.registerOutParameter(55, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(56, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(57, java.sql.Types.VARCHAR);
								if(null == outPatBean.getCoverRefPrice() || !(outPatBean.getCoverRefPrice().equals("Y"))) {
									cstmt.setString(58, "N");
								} else {
									cstmt.setString(58, outPatBean.getCoverRefPrice());
								}//Added V181003-Aravindh/AAKH-CRF-0107
								cstmt.setString(59, outPatBean.getExlinclacrossenc());//Added V190326-Dhananjay/MMS-DM-CRF-0158
								cstmt.execute();
								str_error_level = cstmt.getString(55);
								str_sysmesage_id = cstmt.getString(56);
								str_error_text = cstmt.getString(57);
							}
						}
						else if("U".equals(checkForNull(outPatBean.getStatus()))){
							cstmt = con.prepareCall(preAppQueryUpd);
							cstmt.setString(1, policyBean.getFacilityId());
							cstmt.setString(2, policyBean.getPatientId());
							cstmt.setString(3, policyBean.getEpisodeType());
							cstmt.setString(4, policyBean.getEpisodeId());
							cstmt.setString(5, policyBean.getVisitId());
							cstmt.setString(6, policyBean.getEncounterId());
							cstmt.setString(7, policyBean.getAccEntityID());
							cstmt.setString(8, policyBean.getPayerCode());
							cstmt.setString(9, policyBean.getPriority());

							
							cstmt.setString(10, outPatBean2.getInclExclCriteria());
							cstmt.setString(11, outPatBean2.getBillServChk());
							cstmt.setString(12, outPatBean2.getValueChk1());
							cstmt.setString(13, outPatBean2.getInclExclIndChk());
							cstmt.setString(14, policyBean.getPolicyTypeCode());
							cstmt.setString(15, outPatBean2.getBillServCode());
							cstmt.setString(16, outPatBean.getInclExclInd());
							cstmt.setString(17, outPatBean.getInclusionBasis());
							cstmt.setString(18, outPatBean.getValue());
							cstmt.setString(19, null);
							cstmt.setString(20, null);
							cstmt.setString(21, null);
							
							
							if((outPatBean.getEffectiveDate() == null) || ("".equals(outPatBean.getEffectiveDate()))){
								cstmt.setString(22, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getEffectiveDate()).getTime());
								cstmt.setDate(22, fromDt);
							}
							cstmt.setString(23, login_user);
							cstmt.setString(24, client_ip_address);
							cstmt.setString(25, policyBean.getFacilityId());

							cstmt.setString(26, policyBean.getPayerGroupCode());
							cstmt.setString(27, policyBean.getPolRefCustCode());
							cstmt.setString(28, outPatBean2.getValueChk4());
							cstmt.setString(29, outPatBean2.getValueChk3());
							cstmt.setString(30, policyBean.getBlngGrpid());
							cstmt.setString(31, policyBean.getPolicyNo());
							
							if((outPatBean2.getStartDate() == null) || ("".equals(outPatBean2.getStartDate()))){
								cstmt.setString(32, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean2.getStartDate()).getTime());
								cstmt.setDate(32, fromDt);
							}
							cstmt.setString(33, outPatBean2.getPatClass());
							cstmt.setString(34, outPatBean.getAmtPerVisit());
							cstmt.setString(35, outPatBean.getServItemQty());
							cstmt.setString(36, outPatBean.getAmtPerIPDay());
							cstmt.setString(37, outPatBean.getNoOfDays());
						
							
							
							cstmt.setString(38, outPatBean2.getEpisodeEncounter());
							cstmt.setString(39, outPatBean2.getClinicNurs());
							cstmt.setString(40, outPatBean2.getClinicNursCode());
							cstmt.setString(41, outPatBean2.getSpecCode());

							if((outPatBean2.getEndDate() == null) || ("".equals(outPatBean2.getEndDate())) ){
								cstmt.setString(42, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean2.getEndDate()).getTime());
								cstmt.setDate(42, toDate);
							}
							
							cstmt.setString(43, outPatBean.getAmtGrossNet());	
							cstmt.setString(44, outPatBean.getInclExclCriteria());
							cstmt.setString(45, outPatBean.getBillServCode());
						
							if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
								cstmt.setString(46, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
								cstmt.setDate(46, fromDt);
							}
							if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
								cstmt.setString(47, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
								cstmt.setDate(47, toDate);
							}
							cstmt.setString(48, outPatBean2.getGender());	
							cstmt.setString(49, outPatBean2.getAgeGroup());	

							cstmt.setString(50, outPatBean.getPatCopay());
							cstmt.setString(51, outPatBean.getPatLimitAmt());
							cstmt.registerOutParameter(52, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(53, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(54, java.sql.Types.VARCHAR);
							if(null == outPatBean.getCoverRefPrice() || !(outPatBean.getCoverRefPrice().equals("Y"))) {
								cstmt.setString(55, "N");
							} else {
								cstmt.setString(55, outPatBean.getCoverRefPrice());
							}//Added V181003-Aravindh/AAKH-CRF-0107
							cstmt.setString(56, outPatBean.getExlinclacrossenc());//Added V190326-Dhananjay/MMS-DM-CRF-0158
							cstmt.execute();
							str_error_level = cstmt.getString(52);
							str_sysmesage_id = cstmt.getString(53);
							str_error_text = cstmt.getString(54);
						}
						
						
						
					}
				}
				else if("Y".equals(outPatBean.getDelFlag())){
					cstmt = con.prepareCall(preAppQueryDel);
					cstmt.setString(1, policyBean.getFacilityId());
					cstmt.setString(2, policyBean.getPatientId());
					cstmt.setString(3, policyBean.getEpisodeType());
					cstmt.setString(4, policyBean.getEpisodeId());
					cstmt.setString(5, policyBean.getVisitId());
					cstmt.setString(6, policyBean.getAccEntityID());
					cstmt.setString(7, policyBean.getPriority());
					
					cstmt.setString(8, outPatBean2.getInclExclCriteria());
					cstmt.setString(9, outPatBean2.getBillServCode());


					if((outPatBean.getEffectiveDate() == null) || ("".equals(outPatBean.getEffectiveDate()))){
						cstmt.setString(10, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getEffectiveDate()).getTime());
						cstmt.setDate(10, fromDt);
					}
					
					cstmt.setString(11, outPatBean2.getPatClass());
					cstmt.setString(12, outPatBean2.getEpisodeEncounter());
					cstmt.setString(13, outPatBean2.getClinicNurs());
					cstmt.setString(14, outPatBean2.getClinicNursCode());
					
					cstmt.setString(15, outPatBean2.getSpecCode());
					cstmt.setString(16, outPatBean.getInclExclCriteria());
					cstmt.setString(17, outPatBean.getBillServCode());

					if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
						cstmt.setString(18, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
						cstmt.setDate(18, fromDt);
					}
					cstmt.setString(19, outPatBean2.getGender());	
					cstmt.setString(20, outPatBean2.getAgeGroup());	
					cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(22, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(23, java.sql.Types.VARCHAR);
					cstmt.execute();
					str_error_level = cstmt.getString(21);
					str_sysmesage_id = cstmt.getString(22);
					str_error_text = cstmt.getString(23);
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
								System.err.println("Exception in insertPolictDetailsPopup ->"+rbException);
								rbException.printStackTrace();
							}
							returnMap.put(msgAdd, msgArr[l]);
						}
					}else{
						msgAdd = "msgAdd"+i;
						
						try{
							str_sysmesage_id = rb.getString(str_sysmesage_id);
						}
						catch(Exception rbException){
							System.err.println("Exception in insertPolictDetailsPopup 1238 ->"+rbException);
							rbException.printStackTrace();
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
			System.err.println("Exception iss4 "+e);
			e.printStackTrace();
			returnMap.put("internalError", "Internal Error");
			insertable = false;
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
			
	}
	
	private HashMap insertPolictDetailsDiagCopayPopup(EncounterSpecificDefinitionBean outPatBean2, EncounterSpecificDefinitionBean policyBean) {
		
		HashMap returnMap = new HashMap();
		boolean insertable = false;
		try{
			HashMap<String,List<EncounterSpecificDefinitionBean>> policyMap = policyBean.getDiagPopupMap();
			con.setAutoCommit(false);
			List<EncounterSpecificDefinitionBean> preAppList = null; 
			if(!(policyMap == null || policyMap.isEmpty())){
				preAppList = policyMap.get(outPatBean2.getRowNumber());
				if(preAppList == null){
					preAppList = new ArrayList<EncounterSpecificDefinitionBean>();
					outPatBean = new EncounterSpecificDefinitionBean();
					preAppList.add(outPatBean);
				}
			}
			else{
				policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
				preAppList = new ArrayList<EncounterSpecificDefinitionBean>();
				outPatBean = new EncounterSpecificDefinitionBean();
				preAppList.add(outPatBean);		
			}
			
			//Added V181003-Aravindh/AAKH-CRF-0107/if-else conidition
			String preAppQueryIns = "", preAppQueryUpd = "", preAppQueryDel = "";
			
			preAppQueryIns = "{ call   BLINSTRANSACTIONS.insert_enc_spec_policy_diag (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			preAppQueryUpd = "{ call   BLINSTRANSACTIONS.update_enc_spec_policy_diag (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			preAppQueryDel = "{ call   BLINSTRANSACTIONS.delete_enc_spec_policy_diag (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			
			int i=1;
			for(EncounterSpecificDefinitionBean outPatBean : preAppList)
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
								System.err.println("ESPD - Diag Insert");
								System.err.println(policyBean.getFacilityId()+"/"+policyBean.getPayerGroupCode()+"/"+policyBean.getPayerCode()+"/"+policyBean.getPolicyTypeCode()+"/"+outPatBean2.getInclExclCriteria()+"/"+outPatBean2.getPatClass()+"/"+outPatBean2.getGender()+"/"+outPatBean2.getAgeGroup()+"/"+outPatBean2.getBillServCode()+"/"+outPatBean2.getEpisodeEncounter()+"/"+outPatBean2.getClinicNurs()+"/"+outPatBean2.getClinicNursCode()+"/"+outPatBean2.getSpecCode()+"/"+outPatBean2.getStartDate());
								System.err.println(outPatBean.getDiagType()+"/"+outPatBean.getDiagPatCopay()+"/"+outPatBean.getDiagStartDate()+"/"+outPatBean.getDiagEndDate());								
								cstmt = con.prepareCall(preAppQueryIns);
								cstmt.setString(1, policyBean.getFacilityId());
								cstmt.setString(2, policyBean.getPatientId());
								cstmt.setString(3, policyBean.getEpisodeType());
								cstmt.setString(4, policyBean.getEpisodeId());
								cstmt.setString(5, policyBean.getVisitId());
								cstmt.setString(6, policyBean.getEncounterId());
								cstmt.setString(7, policyBean.getAccEntityID());
								cstmt.setString(8, policyBean.getPayerCode());
								cstmt.setString(9, policyBean.getPriority());								
								cstmt.setString(10, outPatBean2.getInclExclCriteria());
								cstmt.setString(11, policyBean.getPolicyTypeCode());
								cstmt.setString(12, outPatBean2.getBillServCode());
								
								if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
									cstmt.setString(13, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
									cstmt.setDate(13, fromDt);
								}
								cstmt.setString(14, login_user);
								cstmt.setString(15, login_user);
								cstmt.setString(16, client_ip_address);
								cstmt.setString(17, policyBean.getFacilityId());
								cstmt.setString(18, client_ip_address);
								cstmt.setString(19, policyBean.getFacilityId());	
								cstmt.setString(20, policyBean.getPayerGroupCode());
								cstmt.setString(21, policyBean.getPolRefCustCode());
								cstmt.setString(22, policyBean.getBlngGrpid());
								cstmt.setString(23, policyBean.getPolicyNo());								
								if((outPatBean2.getStartDate() == null) || ("".equals(outPatBean2.getStartDate()))){
									cstmt.setString(24, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(outPatBean2.getStartDate()).getTime());
									cstmt.setDate(24, fromDt);
								}
								cstmt.setString(25, outPatBean2.getPatClass());
								cstmt.setString(26, outPatBean2.getEpisodeEncounter());
								cstmt.setString(27, outPatBean2.getClinicNurs());
								cstmt.setString(28, outPatBean2.getClinicNursCode());
								cstmt.setString(29, outPatBean2.getSpecCode());	
								if((outPatBean2.getEndDate() == null) || ("".equals(outPatBean2.getEndDate())) ){
									cstmt.setString(30, null);
								}
								else{
									Date toDate = new Date(sdf.parse(outPatBean2.getEndDate()).getTime());
									cstmt.setDate(30, toDate);
								}								
								cstmt.setString(31, outPatBean.getDiagType());	
								if((outPatBean.getDiagStartDate() == null) || ("".equals(outPatBean.getDiagStartDate()))){
									cstmt.setString(32, null);
								}
								else{
									Date fromDt = new Date(sdf.parse(outPatBean.getDiagStartDate()).getTime());
									cstmt.setDate(32, fromDt);
								}
								if((outPatBean.getDiagEndDate() == null) || ("".equals(outPatBean.getDiagEndDate())) ){
									cstmt.setString(33, null);
								}
								else{
									Date toDate = new Date(sdf.parse(outPatBean.getDiagEndDate()).getTime());
									cstmt.setDate(33, toDate);
								}	
								cstmt.setString(34, outPatBean2.getGender());	
								cstmt.setString(35, outPatBean2.getAgeGroup());	
								cstmt.setString(36, outPatBean.getDiagPatCopay());								
								cstmt.registerOutParameter(37, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(38, java.sql.Types.VARCHAR);
								cstmt.registerOutParameter(39, java.sql.Types.VARCHAR);
								
								cstmt.execute();
								str_error_level = cstmt.getString(37);
								str_sysmesage_id = cstmt.getString(38);
								str_error_text = cstmt.getString(39);
							}
						}
						else if("U".equals(checkForNull(outPatBean.getDiagStatus())))
						{
							System.err.println("ESPD - Diag Update");
							System.err.println(policyBean.getFacilityId()+"/"+policyBean.getPayerGroupCode()+"/"+policyBean.getPayerCode()+"/"+policyBean.getPolicyTypeCode()+"/"+outPatBean2.getInclExclCriteria()+"/"+outPatBean2.getPatClass()+"/"+outPatBean2.getGender()+"/"+outPatBean2.getAgeGroup()+"/"+outPatBean2.getBillServCode()+"/"+outPatBean2.getEpisodeEncounter()+"/"+outPatBean2.getClinicNurs()+"/"+outPatBean2.getClinicNursCode()+"/"+outPatBean2.getSpecCode()+"/"+outPatBean2.getStartDate());
							System.err.println(outPatBean.getDiagType()+"/"+outPatBean.getDiagPatCopay()+"/"+outPatBean.getDiagStartDate()+"/"+outPatBean.getDiagEndDate());															
							cstmt = con.prepareCall(preAppQueryUpd);
							cstmt.setString(1, policyBean.getFacilityId());
							cstmt.setString(2, policyBean.getPatientId());
							cstmt.setString(3, policyBean.getEpisodeType());
							cstmt.setString(4, policyBean.getEpisodeId());
							cstmt.setString(5, policyBean.getVisitId());
							cstmt.setString(6, policyBean.getEncounterId());
							cstmt.setString(7, policyBean.getAccEntityID());
							cstmt.setString(8, policyBean.getPayerCode());
							cstmt.setString(9, policyBean.getPriority());								
							cstmt.setString(10, outPatBean2.getInclExclCriteria());
							cstmt.setString(11, policyBean.getPolicyTypeCode());
							cstmt.setString(12, outPatBean2.getBillServCode());
							
							if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
								cstmt.setString(13, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
								cstmt.setDate(13, fromDt);
							}
							cstmt.setString(14, login_user);
							cstmt.setString(15, client_ip_address);
							cstmt.setString(16, policyBean.getFacilityId());
							cstmt.setString(17, policyBean.getPayerGroupCode());
							cstmt.setString(18, policyBean.getPolRefCustCode());
							cstmt.setString(19, policyBean.getBlngGrpid());
							cstmt.setString(20, policyBean.getPolicyNo());								
							if((outPatBean2.getStartDate() == null) || ("".equals(outPatBean2.getStartDate()))){
								cstmt.setString(21, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean2.getStartDate()).getTime());
								cstmt.setDate(21, fromDt);
							}
							cstmt.setString(22, outPatBean2.getPatClass());
							cstmt.setString(23, outPatBean2.getEpisodeEncounter());
							cstmt.setString(24, outPatBean2.getClinicNurs());
							cstmt.setString(25, outPatBean2.getClinicNursCode());
							cstmt.setString(26, outPatBean2.getSpecCode());	
							if((outPatBean2.getEndDate() == null) || ("".equals(outPatBean2.getEndDate())) ){
								cstmt.setString(27, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean2.getEndDate()).getTime());
								cstmt.setDate(27, toDate);
							}								
							cstmt.setString(28, outPatBean.getDiagType());	
							if((outPatBean.getDiagStartDate() == null) || ("".equals(outPatBean.getDiagStartDate()))){
								cstmt.setString(29, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getDiagStartDate()).getTime());
								cstmt.setDate(29, fromDt);
							}
							if((outPatBean.getDiagEndDate() == null) || ("".equals(outPatBean.getDiagEndDate())) ){
								cstmt.setString(30, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean.getDiagEndDate()).getTime());
								cstmt.setDate(30, toDate);
							}	
							cstmt.setString(31, outPatBean2.getGender());	
							cstmt.setString(32, outPatBean2.getAgeGroup());	
							cstmt.setString(33, outPatBean.getDiagPatCopay());								
							cstmt.registerOutParameter(34, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(35, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(36, java.sql.Types.VARCHAR);
							
							cstmt.execute();
							str_error_level = cstmt.getString(34);
							str_sysmesage_id = cstmt.getString(35);
							str_error_text = cstmt.getString(36);
						}					
					}
				}
				else if("Y".equals(outPatBean.getDiagDelFlag())){
					System.err.println("ESPD - Diag Delete");
					System.err.println(policyBean.getFacilityId()+"/"+policyBean.getPayerGroupCode()+"/"+policyBean.getPayerCode()+"/"+policyBean.getPolicyTypeCode()+"/"+outPatBean2.getInclExclCriteria()+"/"+outPatBean2.getPatClass()+"/"+outPatBean2.getGender()+"/"+outPatBean2.getAgeGroup()+"/"+outPatBean2.getBillServCode()+"/"+outPatBean2.getEpisodeEncounter()+"/"+outPatBean2.getClinicNurs()+"/"+outPatBean2.getClinicNursCode()+"/"+outPatBean2.getSpecCode()+"/"+outPatBean2.getStartDate());
					System.err.println(outPatBean.getDiagType()+"/"+outPatBean.getDiagPatCopay()+"/"+outPatBean.getDiagStartDate()+"/"+outPatBean.getDiagEndDate());													
					cstmt = con.prepareCall(preAppQueryDel);
					cstmt.setString(1, policyBean.getFacilityId());
					cstmt.setString(2, policyBean.getPatientId());
					cstmt.setString(3, policyBean.getEpisodeType());
					cstmt.setString(4, policyBean.getEpisodeId());
					cstmt.setString(5, policyBean.getVisitId());
					cstmt.setString(6, policyBean.getAccEntityID());
					cstmt.setString(7, policyBean.getPriority());
					cstmt.setString(8, outPatBean2.getInclExclCriteria());
					cstmt.setString(9, outPatBean2.getBillServCode());
					
					System.err.println("outPatBean.getEffectiveDate():"+outPatBean2.getEffectiveDate());					
					System.err.println("outPatBean.getStartDate():"+outPatBean2.getStartDate());
					System.err.println("outPatBean2.getEndDate():"+outPatBean2.getEndDate());
					System.err.println("outPatBean2.getEndDate():"+outPatBean.getDiagStartDate());					
					System.err.println("outPatBean2.getEndDate():"+outPatBean.getDiagEndDate());	
					
					if((outPatBean2.getEffectiveDate() == null) || ("".equals(outPatBean2.getEffectiveDate()))){
						cstmt.setString(10, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean2.getEffectiveDate()).getTime());
						cstmt.setDate(10, fromDt);
					}
					cstmt.setString(11, outPatBean2.getPatClass());
					cstmt.setString(12, outPatBean2.getEpisodeEncounter());
					cstmt.setString(13, outPatBean2.getClinicNurs());
					cstmt.setString(14, outPatBean2.getClinicNursCode());
					cstmt.setString(15, outPatBean2.getSpecCode());
					cstmt.setString(16, outPatBean.getDiagType());
					if((outPatBean.getDiagStartDate() == null) || ("".equals(outPatBean.getDiagStartDate()))){
						cstmt.setString(17, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getDiagStartDate()).getTime());
						cstmt.setDate(17, fromDt);
					}
					cstmt.setString(18, outPatBean2.getGender());	
					cstmt.setString(19, outPatBean2.getAgeGroup());	
					cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(22, java.sql.Types.VARCHAR);
					cstmt.execute();
					str_error_level = cstmt.getString(20);
					str_sysmesage_id = cstmt.getString(21);
					str_error_text = cstmt.getString(22);
				}

				String errAdd = "errAdd"+i;
				String errTextAdd = "errTextAdd"+i;
				
				if(str_error_level!=null || str_error_text!=null){
					returnMap.put(errAdd, str_error_level+"-"+str_error_text);
				}
				System.err.println("str_sysmesage_id in ESPD Diag:"+str_sysmesage_id);
				System.err.println("str_error_level in ESPD Diag:"+str_error_level);
				System.err.println("str_error_text in ESPD Diag:"+str_error_text);
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
									System.err.println("msgArr[l] inside try:"+msgArr[l]);
									msgArr[l] = rb1.getString(msgArr[l]);
								}
								catch(Exception rbException1){
									rbException.printStackTrace();
									rbException1.printStackTrace();
									System.err.println("Exception in ESPD Diag Popup 1 ->"+rbException);
									System.err.println("Exception in ESPD Diag Popup 2 ->"+rbException1);
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
								str_sysmesage_id = rb1.getString(str_sysmesage_id);
							}
							catch(Exception rbException1){
								rbException.printStackTrace();
								rbException1.printStackTrace();
								System.err.println("Exception in ESPD Diag Popup 1 ->"+rbException);
								System.err.println("Exception in ESPD Diag Popup 2 ->"+rbException1);
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
			System.err.println("Exception iss4 "+e);
			e.printStackTrace();
			returnMap.put("internalError", "Internal Error");
			insertable = false;
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
			
	}	

/* V230228 starts */	
	private HashMap insertServicesAndItemsCategoryDetails(HttpServletRequest request,
		HttpServletResponse response, EncSpecMFDRBean policyBean) {
			System.err.println("Inside Services and Items function");
	HashMap returnMap = new HashMap();
	HashMap returnPopup = new HashMap();
	boolean insertable = false;
	try{
		HashMap<String,List<EncSpecMFDRBean>> policyMap = policyBean.getPolicyMap();
		con.setAutoCommit(false);
		List<EncSpecMFDRBean> inclList = null; 
		
		System.err.println("facilityId id: "+facility_id);
		System.err.println("client_ip_address: "+client_ip_address);
		System.err.println("login_user: "+login_user);
		
		if(!(policyMap == null || policyMap.isEmpty())){
			inclList = policyMap.get("ServicesAndItemsCatDtlsPageInfo");  
			System.err.println("Policy map is called..");
			System.err.println("inclList contains:"+inclList);
			if(inclList == null){
				inclList = new ArrayList<EncSpecMFDRBean>();
				encSpecMFDRBean = new EncSpecMFDRBean();
				inclList.add(encSpecMFDRBean);
			}
		}
		else{
			policyMap = new HashMap<String,List<EncSpecMFDRBean>>();
			inclList = new ArrayList<EncSpecMFDRBean>();
			encSpecMFDRBean = new EncSpecMFDRBean();
			inclList.add(encSpecMFDRBean);		
		}
		
		String preAppQueryIns = "", preAppQueryUpd = "", preAppQueryDel = "";
		preAppQueryIns = "{ call   blinstransactions.insert_enc_spec_serv_item_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  
		preAppQueryUpd = "{ call   blinstransactions.update_enc_spec_serv_item_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  
	//	preAppQueryDel = "{ call   blinspolicycoverage.delete_ins_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  
		
		int i=1;
		
		for(EncSpecMFDRBean outPatBean : inclList)
		{
			System.err.println("Policy Details outPatBean.getStatus():"+outPatBean.getStatus());
			if(!(outPatBean.getStatus() == null)){
			if(("I".equals(checkForNull(outPatBean.getStatus()))) || ("U".equals(checkForNull(outPatBean.getStatus())))){
				System.err.println("Inside loop 1 in Services and Items");
		
				if("I".equals(checkForNull(outPatBean.getStatus()))){
					System.err.println(" Inside loop 2 in Services and Items");
		
					if("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getPayerGroup())) || "".equals(checkForNull(outPatBean.getPayerGroupCode()))  || "".equals(checkForNull(outPatBean.getPayer())) || "".equals(checkForNull(outPatBean.getPayerCode())) || "".equals(checkForNull(outPatBean.getPolicyType())) || "".equals(checkForNull(outPatBean.getPolicyTypeCode())) || "".equals(checkForNull(outPatBean.getClinicCat())) || "".equals(checkForNull(outPatBean.getClinicProc())) || "".equals(checkForNull(outPatBean.getClinicProcCode())) || "".equals(checkForNull(outPatBean.getClinicProcDesc())) || 
					"".equals(checkForNull(outPatBean.getInclExclCriteria())) || "".equals(checkForNull(outPatBean.getServiceDetailsDesc())) || "".equals(checkForNull(outPatBean.getServiceDetailsCode())) || "".equals(checkForNull(outPatBean.getReferral())) || "".equals(checkForNull(outPatBean.getPatCopay())) || "".equals(checkForNull(outPatBean.getPatLimitAmt())) || "".equals(checkForNull(outPatBean.getAmtGrossNet())) || "".equals(checkForNull(outPatBean.getStartDate())) ){
					}
					else{
						System.err.println("Inside loop 3 in Services and Items");
		
						if(!("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getPayerGroup())) || "".equals(checkForNull(outPatBean.getPayerGroupCode()))  || "".equals(checkForNull(outPatBean.getPayer())) || "".equals(checkForNull(outPatBean.getPayerCode())) || "".equals(checkForNull(outPatBean.getPolicyType())) || "".equals(checkForNull(outPatBean.getPolicyTypeCode())) || "".equals(checkForNull(outPatBean.getClinicCat())) || "".equals(checkForNull(outPatBean.getClinicProc())) || "".equals(checkForNull(outPatBean.getClinicProcCode())) || "".equals(checkForNull(outPatBean.getClinicProcDesc())) || "".equals(checkForNull(outPatBean.getInclExclCriteria())) || "".equals(checkForNull(outPatBean.getServiceDetailsDesc())) || "".equals(checkForNull(outPatBean.getServiceDetailsCode())) || "".equals(checkForNull(outPatBean.getReferral())) || "".equals(checkForNull(outPatBean.getPatCopay())) || "".equals(checkForNull(outPatBean.getPatLimitAmt())) || "".equals(checkForNull(outPatBean.getAmtGrossNet())) || "".equals(checkForNull(outPatBean.getStartDate())) )){
							
							cstmt = con.prepareCall(preAppQueryIns);							
							cstmt.setString(1, outPatBean.getFacilityId());  
							System.err.println("Facility id: "+outPatBean.getFacilityId());
							cstmt.setString(2, outPatBean.getPatientId());  
							System.err.println("Episode is: "+outPatBean.getPatientId());  
							cstmt.setString(3, outPatBean.getEpisodeType());  
							System.err.println("Payer Group is:"+outPatBean.getEpisodeType());
							cstmt.setString(4, outPatBean.getEpisodeId());  
							System.err.println("Payer code is:"+outPatBean.getEpisodeId());
							cstmt.setString(5, outPatBean.getVisitId());  
							System.err.println("Policy type code is:"+outPatBean.getVisitId());
							cstmt.setString(6, outPatBean.getEncounterId());  
							System.err.println("Services and Items category is:"+outPatBean.getEncounterId());
							cstmt.setString(7, outPatBean.getAccSeqNo());  
							System.err.println("Services and Items category is:"+outPatBean.getAccSeqNo());
							cstmt.setString(8, outPatBean.getPriority());  
							System.err.println("priority is:"+outPatBean.getPriority());
							cstmt.setString(9, outPatBean.getPayerGroupCode());  
							System.err.println("Payer Group is:"+outPatBean.getPayerGroupCode());
							cstmt.setString(10, outPatBean.getPayerCode());  
							System.err.println("Payer code is:"+outPatBean.getPayerCode());
							cstmt.setString(11, outPatBean.getPolicyTypeCode());  
							System.err.println("Policy type code is:"+outPatBean.getPolicyTypeCode());
							cstmt.setString(12, outPatBean.getClinicCat());  
							System.err.println("Services and Items category is:"+outPatBean.getClinicCat());
							cstmt.setString(13, outPatBean.getClinicProc());  
							System.err.println("Services and Items category is:"+outPatBean.getClinicProc());
							cstmt.setString(14, outPatBean.getClinicProcCode());  
							System.err.println("Services and Items category is:"+outPatBean.getClinicProcCode());
							cstmt.setString(15, outPatBean.getInclExclCriteria());  
							System.err.println("Services and Items category is:"+outPatBean.getInclExclCriteria());
							cstmt.setString(16, outPatBean.getServiceDetailsCode());  
							System.err.println("Services and Items category is:"+outPatBean.getServiceDetailsCode());
							cstmt.setString(17, outPatBean.getReferral());  
							System.err.println("Services and Items category is:"+outPatBean.getReferral());
							cstmt.setString(18, outPatBean.getPatCopay());
							System.err.println("Patient copay is:"+outPatBean.getPatCopay());
							cstmt.setString(19, outPatBean.getPatLimitAmt());
							System.err.println("Patient amount limit:"+outPatBean.getPatLimitAmt());
							cstmt.setString(20, outPatBean.getAmtGrossNet());
							System.err.println("Gross/Net"+outPatBean.getAmtGrossNet());									
							if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
								cstmt.setString(21, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
								cstmt.setDate(21, fromDt);
								System.err.println("Start Date:"+fromDt);									
							
							}
							if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
								cstmt.setString(22, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
								cstmt.setDate(22, toDate);
								System.err.println("End Date:"+toDate);
							}
							cstmt.setString(23, login_user);
							System.err.println("Value is: "+login_user);
							cstmt.setString(24, client_ip_address);
							System.err.println("Value is: "+client_ip_address);
							cstmt.setString(25, facilityId);
							System.err.println("Value is: "+facilityId);
							cstmt.registerOutParameter(26, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(27, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(28, java.sql.Types.VARCHAR);
							cstmt.setString(29, outPatBean.getAcrossEncYN());  //V230801
							cstmt.execute();
							str_error_level = cstmt.getString(26);
							System.err.println("str_error_level is: "+str_error_level);
							str_sysmesage_id = cstmt.getString(27);
							System.err.println("str_sysmesage_id is: "+str_sysmesage_id);
							str_error_text = cstmt.getString(28);
							System.err.println("str_error_text is: "+str_error_text);
							
							if(str_error_level==null && str_error_text==null){
								System.err.println("Record Savedd");
							}
						}
						else{
							str_error_text = "Services and Items Tab. Row Number "+i+". Please Enter all mandatory fields";
						}
					}
				}
				else if("U".equals(checkForNull(outPatBean.getStatus()))){
					cstmt = con.prepareCall(preAppQueryUpd);

					cstmt.setString(1, outPatBean.getFacilityId());  
					System.err.println("Facility id: "+outPatBean.getFacilityId());
					cstmt.setString(2, outPatBean.getPatientId());  
					System.err.println("Episode is: "+outPatBean.getPatientId());  
					cstmt.setString(3, outPatBean.getEpisodeType());  
					System.err.println("Payer Group is:"+outPatBean.getEpisodeType());
					cstmt.setString(4, outPatBean.getEpisodeId());  
					System.err.println("Payer code is:"+outPatBean.getEpisodeId());
					cstmt.setString(5, outPatBean.getVisitId());  
					System.err.println("Policy type code is:"+outPatBean.getVisitId());
					cstmt.setString(6, outPatBean.getEncounterId());  
					System.err.println("Services and Items category is:"+outPatBean.getEncounterId());
					cstmt.setString(7, outPatBean.getAccSeqNo());  
					System.err.println("Services and Items category is:"+outPatBean.getAccSeqNo());
					cstmt.setString(8, outPatBean.getPriority());  
					System.err.println("priority is:"+outPatBean.getPriority());
					cstmt.setString(9, outPatBean.getPayerGroupCode());  
					System.err.println("Payer Group is:"+outPatBean.getPayerGroupCode());
					cstmt.setString(10, outPatBean.getPayerCode());  
					System.err.println("Payer code is:"+outPatBean.getPayerCode());
					cstmt.setString(11, outPatBean.getPolicyTypeCode());  
					System.err.println("Policy type code is:"+outPatBean.getPolicyTypeCode());
					cstmt.setString(12, outPatBean.getClinicCat());  
					System.err.println("Services and Items category is:"+outPatBean.getClinicCat());
					cstmt.setString(13, outPatBean.getClinicProc());  
					System.err.println("Services and Items category is:"+outPatBean.getClinicProc());
					cstmt.setString(14, outPatBean.getClinicProcCode());  
					System.err.println("Services and Items category is:"+outPatBean.getClinicProcCode());
					cstmt.setString(15, outPatBean.getInclExclCriteria());  
					System.err.println("Services and Items category is:"+outPatBean.getInclExclCriteria());
					cstmt.setString(16, outPatBean.getServiceDetailsCode());  
					System.err.println("Services and Items category is:"+outPatBean.getServiceDetailsCode());
					cstmt.setString(17, outPatBean.getReferral());  
					System.err.println("Services and Items category is:"+outPatBean.getReferral());
					cstmt.setString(18, outPatBean.getPatCopay());
					System.err.println("Patient copay is:"+outPatBean.getPatCopay());
					cstmt.setString(19, outPatBean.getPatLimitAmt());
					System.err.println("Patient amount limit:"+outPatBean.getPatLimitAmt());
					cstmt.setString(20, outPatBean.getAmtGrossNet());
					System.err.println("Gross/Net"+outPatBean.getAmtGrossNet());									
					if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
						cstmt.setString(21, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
						cstmt.setDate(21, fromDt);
						System.err.println("Start Date:"+fromDt);									
					
					}
					if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
						cstmt.setString(22, null);
					}
					else{
						Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
						cstmt.setDate(22, toDate);
						System.err.println("End Date:"+toDate);
					}
					cstmt.setString(23, login_user);
					System.err.println("Value is: "+login_user);
					cstmt.setString(24, client_ip_address);
					System.err.println("Value is: "+client_ip_address);
					cstmt.setString(25, facilityId);
					System.err.println("Value is: "+facilityId);
					cstmt.registerOutParameter(26, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(27, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(28, java.sql.Types.VARCHAR);
					cstmt.setString(29, outPatBean.getAcrossEncYN());  //V230801		
					cstmt.execute();
					str_error_level = cstmt.getString(26);
					System.err.println("str_error_level is: "+str_error_level);
					str_sysmesage_id = cstmt.getString(27);
					System.err.println("str_sysmesage_id is: "+str_sysmesage_id);
					str_error_text = cstmt.getString(28);
					System.err.println("str_error_text is: "+str_error_text);
							
					if(str_error_level==null && str_error_text==null){
						System.err.println("Record Updated");
					}	
					
				}  
					
			}
		}
		String errAdd = "errAdd"+i;
		String errTextAdd = "errTextAdd"+i;
		
		if(str_error_level!=null && str_error_text!=null && str_error_level!="" && str_error_text!=""){
			returnMap.put(errAdd, str_error_text);
		}
		System.err.println("str_sysmesage_id in PD Details:"+str_sysmesage_id);
		System.err.println("str_error_level in PD Details:"+str_error_level);
		System.err.println("str_error_text in PD Details:"+str_error_text);
		if(str_sysmesage_id!=null && str_sysmesage_id != ""){
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
	if(cstmt!=null)  
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
/* V230228 ends */

	@SuppressWarnings("finally")
	private HashMap<String, String> insertHeaderDetails(EncounterSpecificDefinitionBean policyBean, String mode) {
		
		HashMap returnMap = new HashMap();
		String partSql = "";
		try{
			HashMap<String,List<EncounterSpecificDefinitionBean>> policyMap = policyBean.getPolicyMap();
			con.setAutoCommit(false);
			
			if(("I".equals(policyBean.getEpisodeType())) || ("D".equals(policyBean.getEpisodeType()))){
				partSql = " and hdr.episode_type = ? and hdr.episode_id = ?  and hdr.acct_seq_no = ? and hdr.priority = ? and hdr.policy_number = ?";
			}
			else if(("O".equals(policyBean.getEpisodeType())) || ("E".equals(policyBean.getEpisodeType()))){
				partSql = " and hdr.episode_type = ? and hdr.episode_id = ? and hdr.visit_id =? and hdr.acct_seq_no = ? and hdr.priority = ? and hdr.policy_number = ?";
			}
			else if("R".equals(policyBean.getEpisodeType())){
				partSql = " and hdr.episode_type = ?  and hdr.acct_seq_no = ? and hdr.priority = ? and hdr.policy_number = ?";
			}
			
			PreparedStatement pstmt = null;
			
			List<EncounterSpecificDefinitionBean> outPatList = null; 
			List<EncounterSpecificDefinitionBean> inPatList = null; 
			List<EncounterSpecificDefinitionBean> externalList = null; 
			
			String sqlCoverage = "";
			
			if(!(policyMap == null || policyMap.isEmpty())){
				outPatList = policyMap.get("Outpatient");
				if(outPatList == null){
					outPatList = new ArrayList<EncounterSpecificDefinitionBean>();
					outPatBean = new EncounterSpecificDefinitionBean();
					outPatList.add(outPatBean);
				}
				inPatList = policyMap.get("Inpatient");
				if(inPatList == null){
					inPatList = new ArrayList<EncounterSpecificDefinitionBean>();
					inPatBean = new EncounterSpecificDefinitionBean();
					if("modify".equals(mode)){
						sqlCoverage = "select ip_cred_auth_req_yn,ip_cred_auth_mand_to_capt_yn,ip_dflt_auth_ref_as_pol_no_yn,"+
						"inpatient_covered,inpatient_limit_type,ip_approved_days_limit_type,ip_approved_no_of_days,"+
						"ip_approved_amt_limit_type,ip_approved_amt_limit,mand_bill_gen_check_ind_ip,mand_inv_gen_check_ind_ip, "+
						"IP_PATIENT_COPAY,IP_PATIENT_AMOUNT_LIMIT,IP_APPROVED_AMT_GROSS_NET "+
						"from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.patient_id = ? "+partSql;
						pstmt = con.prepareStatement(sqlCoverage);
						pstmt.setString(1,policyBean.getFacilityId());
						pstmt.setString(2,policyBean.getPayerGroupCode());
						pstmt.setString(3,policyBean.getPayerCode());
						pstmt.setString(4,policyBean.getPolicyTypeCode());
						pstmt.setString(5,policyBean.getPatientId());
						if(("I".equals(policyBean.getEpisodeType())) || ("D".equals(policyBean.getEpisodeType()))){
							pstmt.setString(6,policyBean.getEpisodeType());
							pstmt.setString(7,policyBean.getEpisodeId());
							pstmt.setString(8,policyBean.getAccEntityID());
							pstmt.setString(9,policyBean.getPriority());
							pstmt.setString(10,policyBean.getPolicyNo());
						}
						else if(("O".equals(policyBean.getEpisodeType())) || ("E".equals(policyBean.getEpisodeType()))){
							pstmt.setString(6,policyBean.getEpisodeType());
							pstmt.setString(7,policyBean.getEpisodeId());
							pstmt.setString(8,policyBean.getVisitId());
							pstmt.setString(9,policyBean.getAccEntityID());
							pstmt.setString(10,policyBean.getPriority());
							pstmt.setString(11,policyBean.getPolicyNo());
						}
						else if("R".equals(policyBean.getEpisodeType())){
							pstmt.setString(6,policyBean.getEpisodeType());
							pstmt.setString(7,policyBean.getAccEntityID());
							pstmt.setString(8,policyBean.getPriority());
							pstmt.setString(9,policyBean.getPolicyNo());
						}

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
								inPatBean.setPatCopay(rst.getString("IP_PATIENT_COPAY"));
								inPatBean.setPatLimitAmt(rst.getString("IP_PATIENT_AMOUNT_LIMIT"));
								inPatBean.setAmtGrossNet(rst.getString("IP_APPROVED_AMT_GROSS_NET"));
								inPatList.add(inPatBean);
								
							}
						}
						else{

							inPatList.add(inPatBean);
						}
						pstmt.close();//V210413
						rst.close();//V210413
					}
					else{
						inPatList.add(inPatBean);
					}
				}
				externalList = policyMap.get("External");
				if (externalList == null || externalList.size() == 0) { // Karthik Added Extra Validation here
					externalList = new ArrayList<EncounterSpecificDefinitionBean>();
					externalBean = new EncounterSpecificDefinitionBean();
					if("modify".equals(mode)){
						sqlCoverage = "select ex_cred_auth_req_yn,ex_cred_auth_mand_to_capt_yn,ex_dflt_auth_ref_as_pol_no_yn,"+
						"external_covered,external_limit_type,ex_approved_days_limit_type,ex_approved_no_of_days,"+
						"ex_approved_amt_limit_type,ex_approved_amt_limit,mand_bill_gen_check_ind_ex,mand_inv_gen_check_ind_ex, "+
						"EX_PATIENT_COPAY,EX_PATIENT_AMOUNT_LIMIT,EX_APPROVED_AMT_GROSS_NET "+
						"from bl_ins_policy_addl_hdr hdr where hdr.operating_facility_id = ? and hdr.CUST_GROUP_CODE = ? and  hdr.CUST_CODE = ? and hdr.POLICY_TYPE_CODE = ? and hdr.patient_id = ? "+partSql;
						pstmt = con.prepareStatement(sqlCoverage);
						pstmt.setString(1,policyBean.getFacilityId());
						pstmt.setString(2,policyBean.getPayerGroupCode());
						pstmt.setString(3,policyBean.getPayerCode());
						pstmt.setString(4,policyBean.getPolicyTypeCode());
						pstmt.setString(5,policyBean.getPatientId());
						if(("I".equals(policyBean.getEpisodeType())) || ("D".equals(policyBean.getEpisodeType()))){
							pstmt.setString(6,policyBean.getEpisodeType());
							pstmt.setString(7,policyBean.getEpisodeId());
							pstmt.setString(8,policyBean.getAccEntityID());
							pstmt.setString(9,policyBean.getPriority());
							pstmt.setString(10,policyBean.getPolicyNo());
						}
						else if(("O".equals(policyBean.getEpisodeType())) || ("E".equals(policyBean.getEpisodeType()))){
							pstmt.setString(6,policyBean.getEpisodeType());
							pstmt.setString(7,policyBean.getEpisodeId());
							pstmt.setString(8,policyBean.getVisitId());
							pstmt.setString(9,policyBean.getAccEntityID());
							pstmt.setString(10,policyBean.getPriority());
							pstmt.setString(11,policyBean.getPolicyNo());
						}
						else if("R".equals(policyBean.getEpisodeType())){
							pstmt.setString(6,policyBean.getEpisodeType());
							pstmt.setString(7,policyBean.getAccEntityID());
							pstmt.setString(8,policyBean.getPriority());
							pstmt.setString(9,policyBean.getPolicyNo());
						}

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
								externalBean.setPatCopay(rst.getString("EX_PATIENT_COPAY"));
								externalBean.setPatLimitAmt(rst.getString("EX_PATIENT_AMOUNT_LIMIT"));
								externalBean.setAmtGrossNet(rst.getString("EX_APPROVED_AMT_GROSS_NET"));
								externalList.add(externalBean);
								
							}							
						}
						else{

							externalList.add(externalBean);
						}
						pstmt.close();//V210413
						rst.close();//V210413						
					}
					else{
						externalList.add(externalBean);
					}
				}
			}
			else{
				policyMap = new HashMap<String,List<EncounterSpecificDefinitionBean>>();
				outPatList = new ArrayList<EncounterSpecificDefinitionBean>();
				outPatBean = new EncounterSpecificDefinitionBean();
				outPatList.add(outPatBean);
				inPatList = new ArrayList<EncounterSpecificDefinitionBean>();
				inPatBean = new EncounterSpecificDefinitionBean();
				inPatList.add(inPatBean);
				externalList = new ArrayList<EncounterSpecificDefinitionBean>();
				externalBean = new EncounterSpecificDefinitionBean();
				externalList.add(externalBean);
			}
			String headerQuery = "";
			

			if(outPatList==null || outPatList.size()==0){
				outPatList = new ArrayList<EncounterSpecificDefinitionBean>();
				outPatBean = new EncounterSpecificDefinitionBean();
				outPatList.add(outPatBean);
			}
			if(inPatList==null || inPatList.size()==0){
				inPatList = new ArrayList<EncounterSpecificDefinitionBean>();
				inPatBean = new EncounterSpecificDefinitionBean();
				inPatList.add(inPatBean);
			}
			if(externalList==null || externalList.size()==0){
				externalList = new ArrayList<EncounterSpecificDefinitionBean>();
				externalBean = new EncounterSpecificDefinitionBean();
				externalList.add(externalBean);
			}

			
			outPatBean = outPatList.get(0);
			inPatBean = inPatList.get(0);
			externalBean = externalList.get(0);
			if("insert".equals(mode)){
				//Modified V181003-Aravindh/AAKH-CRF-0107/if-else condition
				//Modified V190517-Aravindh/NMC-JD-CRF-0010/added 1 parameter
				//Added V190530 MuthuN/NMC-JD-CRF-0002.1/Added 1 Parameter
				headerQuery = "{ call  BLINSTRANSACTIONS.insert_enc_spec_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,null,?,?,?,?,?) }";
				cstmt = con.prepareCall(headerQuery);
				cstmt.setString(1, policyBean.getFacilityId());
				cstmt.setString(2, policyBean.getPatientId());
				cstmt.setString(3, policyBean.getEpisodeType());
				cstmt.setString(4, policyBean.getEpisodeId());
				cstmt.setString(5, policyBean.getVisitId());
				cstmt.setString(6, policyBean.getEncounterId());
				cstmt.setString(7, policyBean.getPolicyTypeCode());
				
				cstmt.setString(8, login_user);
				cstmt.setString(9, login_user);
				cstmt.setString(10, client_ip_address);
				cstmt.setString(11, policyBean.getFacilityId());
				cstmt.setString(12, client_ip_address);
				cstmt.setString(13, policyBean.getFacilityId());
				
				
				cstmt.setString(14, policyBean.getStatus());
				cstmt.setString(15, policyBean.getIllDedAmt());
				cstmt.setString(16, policyBean.getVstDedAmt());
				cstmt.setString(17, policyBean.getAccEntityID());
				cstmt.setString(18, policyBean.getPayerCode());
				cstmt.setString(19, policyBean.getPriority());
				cstmt.setString(20, policyBean.getPayerGroupCode());
				cstmt.setString(21, policyBean.getPolRefCustCode());
				cstmt.setString(22, policyBean.getBlngGrpid());
				cstmt.setString(23, policyBean.getPolicyNo());

				if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
					cstmt.setString(24, null);
				}
				else{
					Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
					cstmt.setDate(24, fromDt);
				}
				cstmt.setString(25, policyBean.getDefInclExclCriteria());
				cstmt.setString(26, policyBean.getOverRideInclExcl());
				cstmt.setString(27, policyBean.getLastPayer());
				cstmt.setString(28, policyBean.getCovInclOthPayers());
				cstmt.setString(29, outPatBean.getCreditAuthReq());
				cstmt.setString(30, inPatBean.getCreditAuthReq());
				cstmt.setString(31, externalBean.getCreditAuthReq());
				cstmt.setString(32, outPatBean.getCreditAuthMand());
				cstmt.setString(33, inPatBean.getCreditAuthMand());
				cstmt.setString(34, externalBean.getCreditAuthMand());
				cstmt.setString(35, outPatBean.getCreditAuthRef());
				cstmt.setString(36, inPatBean.getCreditAuthRef());
				cstmt.setString(37, externalBean.getCreditAuthRef());			
				cstmt.setString(38, outPatBean.getCovered());
				cstmt.setString(39, returnVal(inPatBean.getCovered(),"N"));
				cstmt.setString(40, externalBean.getCovered());
				cstmt.setString(41, outPatBean.getCoverageLimitType());
				cstmt.setString(42, inPatBean.getCoverageLimitType());
				cstmt.setString(43, externalBean.getCoverageLimitType());
				cstmt.setString(44, outPatBean.getApprovedDays());
				cstmt.setString(45, inPatBean.getApprovedDays());
				cstmt.setString(46, externalBean.getApprovedDays());
				cstmt.setString(47, (outPatBean.getNoOfDays()));
				cstmt.setString(48, (inPatBean.getNoOfDays()));
				cstmt.setString(49, (externalBean.getNoOfDays()));
				cstmt.setString(50, (outPatBean.getLimitAmt()));
				cstmt.setString(51, (inPatBean.getLimitAmt()));
				cstmt.setString(52, (externalBean.getLimitAmt()));	
				
				cstmt.setString(53, (outPatBean.getApprovedAmt()));
				cstmt.setString(54, (inPatBean.getApprovedAmt()));
				cstmt.setString(55, (externalBean.getApprovedAmt()));
				
				
				cstmt.setString(56, outPatBean.getMandChkBillGen());
				cstmt.setString(57, inPatBean.getMandChkBillGen());
				cstmt.setString(58, externalBean.getMandChkBillGen());
				cstmt.setString(59, outPatBean.getMandChkInvoiceGen());
				cstmt.setString(60, inPatBean.getMandChkInvoiceGen());
				cstmt.setString(61, externalBean.getMandChkInvoiceGen());
				cstmt.setString(62, (outPatBean.getAmtGrossNet()));
				cstmt.setString(63, (inPatBean.getAmtGrossNet()));
				cstmt.setString(64, (externalBean.getAmtGrossNet()));
				cstmt.setString(65, (policyBean.getCoveragePer()));
				cstmt.setString(66, (policyBean.getCoverageBasis()));
				cstmt.setString(67, (policyBean.getCoverageRules()));

				cstmt.setString(68, outPatBean.getPatCopay());
				cstmt.setString(69, inPatBean.getPatCopay());
				cstmt.setString(70, externalBean.getPatCopay());
				cstmt.setString(71, outPatBean.getPatLimitAmt());
				cstmt.setString(72, inPatBean.getPatLimitAmt());
				cstmt.setString(73, externalBean.getPatLimitAmt());
				cstmt.registerOutParameter(74, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(75, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(76, java.sql.Types.VARCHAR);
				//Added V181008-Aravindh/AAKH-CRF-0107
				if(null == policyBean.getCoverRefPrice() || !(policyBean.getCoverRefPrice().equals("Y"))) {
					cstmt.setString(77, "N");
				} else {
					cstmt.setString(77, policyBean.getCoverRefPrice());
				}
				if(null == policyBean.getPolicyApproved() || !("Y".equals(policyBean.getPolicyApproved()))) {
					cstmt.setString(78, "N");
				} else {
					cstmt.setString(78, policyBean.getPolicyApproved());
				}//Added V190517-Aravindh/NMC-JD-CRF-0010
				//Added V190530 MuthuN/NMC-JD-CRF-0002.1
				if(null == policyBean.getclaimsAgrmtExts() || !("Y".equals(policyBean.getclaimsAgrmtExts()))) {
					cstmt.setString(79, "N");
				} else {
					cstmt.setString(79, policyBean.getclaimsAgrmtExts());
				}
				//Added V190530 MuthuN/NMC-JD-CRF-0002.1
				cstmt.execute();
				str_error_level = cstmt.getString(74);
				str_sysmesage_id = cstmt.getString(75);
				str_error_text = cstmt.getString(76);
			}
			else if("modify".equals(mode)){
				//Modified V181003-Aravindh/AAKH-CRF-0107/if-else condition
				//Modified V190517-Aravindh/NMC-JD-CRF-0010/added 1 parameter
				//Added V190530 MuthuN/NMC-JD-CRF-0002.1/Added 1 Parameter
				headerQuery = "{ call  BLINSTRANSACTIONS.update_enc_spec_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
				cstmt = con.prepareCall(headerQuery);
				cstmt.setString(1, policyBean.getFacilityId());
				cstmt.setString(2, policyBean.getPatientId());
				cstmt.setString(3, policyBean.getEpisodeType());
				cstmt.setString(4, policyBean.getEpisodeId());
				cstmt.setString(5, policyBean.getVisitId());
				cstmt.setString(6, policyBean.getEncounterId());
				cstmt.setString(7, policyBean.getPolicyTypeCode());
				
				cstmt.setString(8, login_user);
				cstmt.setString(9, client_ip_address);
				cstmt.setString(10, policyBean.getFacilityId());
				
				cstmt.setString(11, policyBean.getStatus());
				cstmt.setString(12, policyBean.getIllDedAmt());
				cstmt.setString(13, policyBean.getVisitId());
				cstmt.setString(14, policyBean.getAccEntityID());
				cstmt.setString(15, policyBean.getPayerCode());
				cstmt.setString(16, policyBean.getPriority());
				cstmt.setString(17, policyBean.getPayerGroupCode());
				cstmt.setString(18, policyBean.getPolRefCustCode());
				cstmt.setString(19, policyBean.getBlngGrpid());
				cstmt.setString(20, policyBean.getPolicyNo());

				if((policyBean.getStartDate() == null) || ("".equals(policyBean.getStartDate()))){
					cstmt.setString(21, null);
				}
				else{
					Date fromDt = new Date(sdf.parse(policyBean.getStartDate()).getTime());
					cstmt.setDate(21, fromDt);
				}
				cstmt.setString(22, policyBean.getDefInclExclCriteria());
				cstmt.setString(23, policyBean.getOverRideInclExcl());
				cstmt.setString(24, policyBean.getLastPayer());
				cstmt.setString(25, policyBean.getCovInclOthPayers());
				cstmt.setString(26, outPatBean.getCreditAuthReq());
				cstmt.setString(27, inPatBean.getCreditAuthReq());
				cstmt.setString(28, externalBean.getCreditAuthReq());
				cstmt.setString(29, outPatBean.getCreditAuthMand());
				cstmt.setString(30, inPatBean.getCreditAuthMand());
				cstmt.setString(31, externalBean.getCreditAuthMand());
				cstmt.setString(32, outPatBean.getCreditAuthRef());
				cstmt.setString(33, inPatBean.getCreditAuthRef());
				cstmt.setString(34, externalBean.getCreditAuthRef());			
				cstmt.setString(35, outPatBean.getCovered());
				cstmt.setString(36, returnVal(inPatBean.getCovered(),"N"));
				cstmt.setString(37, externalBean.getCovered());
				cstmt.setString(38, outPatBean.getCoverageLimitType());
				cstmt.setString(39, inPatBean.getCoverageLimitType());
				cstmt.setString(40, externalBean.getCoverageLimitType());
				cstmt.setString(41, outPatBean.getApprovedDays());
				cstmt.setString(42, inPatBean.getApprovedDays());
				cstmt.setString(43, externalBean.getApprovedDays());
				cstmt.setString(44, (outPatBean.getNoOfDays()));
				cstmt.setString(45, (inPatBean.getNoOfDays()));
				cstmt.setString(46, (externalBean.getNoOfDays()));
				cstmt.setString(47, (outPatBean.getLimitAmt()));
				cstmt.setString(48, (inPatBean.getLimitAmt()));
				cstmt.setString(49, (externalBean.getLimitAmt()));				
				cstmt.setString(50, (outPatBean.getApprovedAmt()));
				cstmt.setString(51, (inPatBean.getApprovedAmt()));
				cstmt.setString(52, (externalBean.getApprovedAmt()));				
				cstmt.setString(53, outPatBean.getMandChkBillGen());
				cstmt.setString(54, inPatBean.getMandChkBillGen());
				cstmt.setString(55, externalBean.getMandChkBillGen());
				cstmt.setString(56, outPatBean.getMandChkInvoiceGen());
				cstmt.setString(57, inPatBean.getMandChkInvoiceGen());
				cstmt.setString(58, externalBean.getMandChkInvoiceGen());
				cstmt.setString(59, (outPatBean.getAmtGrossNet()));
				cstmt.setString(60, (inPatBean.getAmtGrossNet()));
				cstmt.setString(61, (externalBean.getAmtGrossNet()));
				cstmt.setString(62, (policyBean.getCoveragePer()));
				cstmt.setString(63, (policyBean.getCoverageBasis()));
				cstmt.setString(64, (policyBean.getCoverageRules()));
				cstmt.setString(65, outPatBean.getPatCopay());
				cstmt.setString(66, inPatBean.getPatCopay());
				cstmt.setString(67, externalBean.getPatCopay());
				cstmt.setString(68, outPatBean.getPatLimitAmt());
				cstmt.setString(69, inPatBean.getPatLimitAmt());
				cstmt.setString(70, externalBean.getPatLimitAmt());
				cstmt.setString(71, policyBean.getAcrossGroupId());
				cstmt.registerOutParameter(72, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(73, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(74, java.sql.Types.VARCHAR);
				if(null == policyBean.getCoverRefPrice() || !(policyBean.getCoverRefPrice().equals("Y"))) {
					cstmt.setString(75, "N");
				} else {
					cstmt.setString(75, policyBean.getCoverRefPrice());
				}
				//Added V190517-Aravindh/NMC-JD-CRF-0010
				if(null == policyBean.getPolicyApproved() || !("Y".equals(policyBean.getPolicyApproved()))) {
					cstmt.setString(76, "N");
				} else {
					cstmt.setString(76, policyBean.getPolicyApproved());
				}
				//Added V190517-Aravindh/NMC-JD-CRF-0010

				//Added V190530 MuthuN/NMC-JD-CRF-0002.1
				if(null == policyBean.getclaimsAgrmtExts() || !("Y".equals(policyBean.getclaimsAgrmtExts()))) {
					cstmt.setString(77, "N");
				} else {
					cstmt.setString(77, policyBean.getclaimsAgrmtExts());
				}
				//Added V190530 MuthuN/NMC-JD-CRF-0002.1
				cstmt.execute();
				str_error_level = cstmt.getString(72);
				str_sysmesage_id = cstmt.getString(73);
				str_error_text = cstmt.getString(74);
			}
			
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
							System.err.println("Exception in insertHeaderDetails ->"+rbException);
							rbException.printStackTrace();
						}
						returnMap.put(msgAdd, msgArr[l]);
					}
				}else{
					msgAdd = "msgHdr";
					
					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						System.err.println("Exception in insertHeaderDetails  1739->"+rbException);
						rbException.printStackTrace();
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
			pstmt.close();//V210413
			rst.close();//V210413
			
		}
		catch(Exception e){
			System.err.println("Exception iss5 "+e);
			e.printStackTrace();
			returnMap.put("internalError", "Internal Error");
			returnMap.put("status", new Boolean(false));
		}
		finally{
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}		
	}
	
	private String checkForNull(String inputString) {
 		return (inputString == null) ? "I" : inputString;
 	}
	
    private String returnVal(String inputString,String outputString) {
		return (inputString == null) ? outputString : inputString;
	}
	// Policy Definition Methods	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		doPost(req,res);
	}


	
}
