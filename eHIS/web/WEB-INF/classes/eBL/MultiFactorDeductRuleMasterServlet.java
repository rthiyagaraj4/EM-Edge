/*
Sr No        Version           Incident        SCF/CRF                     		Developer Name
-----------------------------------------------------------------------------------------------
 1			V230210								MMS-DM-CRF-0209.5			Namrata Charate
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
import eBL.Common.*;
import eCommon.XSSRequestWrapper; //V220324

/**
 * Servlet implementation class PolicyDefinitionMasterServlet
 */
public class MultiFactorDeductRuleMasterServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L; // commented against V210416.
	Connection con = null;
	CallableStatement cstmt = null;
	ResultSet rst = null;
	MultiFactorDeductRuleBean outPatBean = null;
	MFDRDiagCatBean outPatBean1 = null;
	MFDRServicesAndItemsBean outPatBean2 = null;  //V230210
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

	String payerRefCode  = ""; //V211027
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiFactorDeductRuleMasterServlet() {
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
		System.err.println("Inside doPost method");
		con = ConnectionManager.getConnection(request);
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		try{
			System.err.println("Inside doPost method1");
			session = request.getSession(false);
			locale = (String)session.getAttribute("LOCALE");
			loc = new Locale(locale);
			System.err.println("Inside doPost method2");
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			rb1 = ResourceBundle.getBundle("eSM.resources.Messages",loc);
			rb2 = ResourceBundle.getBundle("eBL.resources.MessagesExtOne",loc);
			System.err.println("Inside doPost method2");
			oldEndDate = checkForNull(request.getParameter("oldEndDate"));
			HashMap returnMap = new HashMap();
			HashMap returnMap1 = new HashMap();
			HashMap returnMap2 = new HashMap();  //V230210
			System.err.println("Inside doPost method3");
			String beanId = "bl_MultiFactorDeductRuleBean";
			String beanName = "eBL.MultiFactorDeductRuleBean";
			System.err.println("Inside doPost method4");
			
			String beanID1 = "bl_MFDRDiagCatBean";
			String beanName1 = "eBL.MFDRDiagCatBean";
			
			String beanID2 = "bl_MFDRServicesAndItemsBean";  //V230210
			String beanName2 = "eBL.MFDRServicesAndItemsBean";  //V230210
			
			MultiFactorDeductRuleBean policyBean = (MultiFactorDeductRuleBean)PersistenceHelper.getBeanObject(beanId, beanName, request);	
			MFDRDiagCatBean policyBean1 = (MFDRDiagCatBean)PersistenceHelper.getBeanObject(beanID1, beanName1, request);
			MFDRServicesAndItemsBean policyBean2 = (MFDRServicesAndItemsBean)PersistenceHelper.getBeanObject(beanID2, beanName2, request);  //V230210
			
			System.err.println("Inside doPost method5");
			try{
				System.err.println("Inside doPost method6");
				HashMap<String, List<MultiFactorDeductRuleBean> > drugCat = policyBean.getPolicyMap();
				drugCat.get("DrugCategoryDetailsPageInfo");
				if(!drugCat.isEmpty()){
					returnMap=insertDrugCategoryDetails(request,response,policyBean);
				}else{
					returnMap.put("status", true);
				}
				HashMap<String, List<MFDRDiagCatBean> > diagCat = policyBean1.getPolicyMap();
				diagCat.get("DiagCatDtlsPageInfo");
				if(!diagCat.isEmpty()){
					returnMap1=insertDiagnosisCategoryDetails(request,response,policyBean1);
				}else{
					returnMap1.put("status", true);
				}
				/* V230210 starts */
				HashMap<String, List<MFDRServicesAndItemsBean> > servicesAndItemsCat = policyBean2.getPolicyMap();
				servicesAndItemsCat.get("ServicesAndItemsCatDtlsPageInfo");
				if(!servicesAndItemsCat.isEmpty()){
					System.err.println("service and items category get called...");
					returnMap2=insertservicesAndItemsCategoryDetails(request,response,policyBean2);
				}else{
					returnMap2.put("status", true);
				}
					/* V230210 ends */
				System.err.println("Returned map:"+returnMap);
				System.err.println("Returned map1:"+returnMap1);
				System.err.println("Returned map2:"+returnMap2); //V230210
				
			}catch(Exception ex){
				System.err.println("Exception here is : "+ex);
			}
		   
			System.err.println("Returned map:");
			
			if (((Boolean) returnMap.get("status")).booleanValue()  && ((Boolean) returnMap1.get("status")).booleanValue() && ((Boolean) returnMap2.get("status")).booleanValue())   //V230210
			{
				con.commit();
			}
			else 
			{
				con.rollback();				
			}	
			
			String error_msg = "";
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
			
			String mapValue1 = "";
			String error1 = "";
		//	int err_val = 1;
			for (Iterator iterator = returnMap1.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				if(!("status".equals(type))){
					mapValue1 = (String) returnMap1.get(type);
					if(mapValue1 != null){
						//if(mapValue.contains("Error")){
							error1 = error1+mapValue1+"<br/>";
							err_val = 2;
						//}				
					}
				}				
			}
			
			/*  V230210 starts */
			String mapValue2 = "";
			String error2 = "";
		//	int err_val = 1;
			for (Iterator iterator = returnMap2.keySet().iterator(); iterator.hasNext();) {
				String type = (String) iterator.next();
				if(!("status".equals(type))){
					mapValue2 = (String) returnMap2.get(type);
					if(mapValue2 != null){
						//if(mapValue.contains("Error")){
							error2 = error2+mapValue2+"<br/>";
							err_val = 2;
						//}				
					}
				}				
			}
			/*  V230210 ends */
			//V230210
			if(error.length()==0 && error1.length()==0 && error2.length()==0){    
				try{
					error = rb1.getString("RECORD_INSERTED");
				}
				catch(Exception rbException){
					rbException.printStackTrace();
					System.err.println("Exceprion in RB ->"+rbException);
					error = "APP-SM0070 Operation Completed Successfully ....";					
				}
			}
			else{
				error_msg = "Record not saved";
				if(error.length()!=0)
					error_msg += "<br/>"+error;    
				if(error1.length()!=0)
					error_msg += "<br/>"+error1;
				if(error2.length()!=0) 
					error_msg += "<br/>"+error2;  //V230210
				error = error_msg;
			}
			
			System.err.println("error is: "+error);
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+err_val);
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
	
	// MultiFactorDeductRule Details Insertion starts here
	private HashMap insertDrugCategoryDetails(HttpServletRequest request,
			HttpServletResponse response, MultiFactorDeductRuleBean policyBean) {
				System.err.println("Inside drug category details function");
		HashMap returnMap = new HashMap();
		HashMap returnPopup = new HashMap();
		boolean insertable = false;
		try{
			HashMap<String,List<MultiFactorDeductRuleBean>> policyMap = policyBean.getPolicyMap();
			con.setAutoCommit(false);
			List<MultiFactorDeductRuleBean> inclList = null; 
			
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ; //V221004
			facilityId = (String) session.getValue( "facility_id" ) ;  //V221004
			client_ip_address = this.p.getProperty("client_ip_address"); //V221004
			login_user = this.p.getProperty( "login_user" ) ; //V221004
			System.err.println("facilityId id: "+facilityId);
			System.err.println("client_ip_address: "+client_ip_address);
			System.err.println("login_user: "+login_user);
			
			if(!(policyMap == null || policyMap.isEmpty())){
				inclList = policyMap.get("DrugCategoryDetailsPageInfo");  //V221004
				System.err.println("Policy map is called..");
				System.err.println("inclList contains:"+inclList);
				if(inclList == null){
					inclList = new ArrayList<MultiFactorDeductRuleBean>();
					outPatBean = new MultiFactorDeductRuleBean();
					inclList.add(outPatBean);
				}
			}
			else{
				policyMap = new HashMap<String,List<MultiFactorDeductRuleBean>>();
				inclList = new ArrayList<MultiFactorDeductRuleBean>();
				outPatBean = new MultiFactorDeductRuleBean();
				inclList.add(outPatBean);		
			}
			
			String preAppQueryIns = "", preAppQueryUpd = "", preAppQueryDel = "";
			preAppQueryIns = "{ call   blinsdrug.insert_ins_drug_deduct_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  //V221004
			preAppQueryUpd = "{ call   blinsdrug.update_ins_drug_deduct_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  //V221004
		//	preAppQueryDel = "{ call   blinspolicycoverage.delete_ins_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			
			int i=1;
			
			for(MultiFactorDeductRuleBean outPatBean : inclList)
			{
				System.err.println("Policy Details outPatBean.getStatus():"+outPatBean.getStatus());
				if(!(outPatBean.getStatus() == null)){
					if(("I".equals(checkForNull(outPatBean.getStatus()))) || ("U".equals(checkForNull(outPatBean.getStatus())))){
						System.err.println("Inside loop 1");
				
						if("I".equals(checkForNull(outPatBean.getStatus()))){
							System.err.println(" Inside loop 2");
				
							if("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getPayerGroup())) || "".equals(checkForNull(outPatBean.getPayerGroupCode()))  || "".equals(checkForNull(outPatBean.getPayer())) || "".equals(checkForNull(outPatBean.getPayerCode())) || "".equals(checkForNull(outPatBean.getPolicyType())) || "".equals(checkForNull(outPatBean.getPolicyTypeCode())) || "".equals(checkForNull(outPatBean.getDrugCategory())) || "".equals(checkForNull(outPatBean.getPatCopay())) || "".equals(checkForNull(outPatBean.getPatLimitAmt())) || "".equals(checkForNull(outPatBean.getAmtGrossNet())) || "".equals(checkForNull(outPatBean.getStartDate())) ){
							}
							else{
								System.err.println("Inside loop 3");
				
								if(!("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getPayerGroup())) || "".equals(checkForNull(outPatBean.getPayerGroupCode()))  || "".equals(checkForNull(outPatBean.getPayer())) || "".equals(checkForNull(outPatBean.getPayerCode())) || "".equals(checkForNull(outPatBean.getPolicyType())) || "".equals(checkForNull(outPatBean.getPolicyTypeCode())) || "".equals(checkForNull(outPatBean.getDrugCategory())) || "".equals(checkForNull(outPatBean.getPatCopay())) || "".equals(checkForNull(outPatBean.getPatLimitAmt())) || "".equals(checkForNull(outPatBean.getAmtGrossNet())) || "".equals(checkForNull(outPatBean.getStartDate())) )){
									
									cstmt = con.prepareCall(preAppQueryIns);							
									cstmt.setString(1, outPatBean.getFacilityId());  //V221004
									System.err.println("Facility id: "+outPatBean.getFacilityId());
									cstmt.setString(2, outPatBean.getPatClass());  //V221113
									System.err.println("Episode is: "+outPatBean.getPatClass());  //V221113
									cstmt.setString(3, outPatBean.getPayerGroupCode());  //V221004
									System.err.println("Payer Group is:"+outPatBean.getPayerGroupCode());
									cstmt.setString(4, outPatBean.getPayerCode());  //V221004
									System.err.println("Payer code is:"+outPatBean.getPayerCode());
									cstmt.setString(5, outPatBean.getPolicyTypeCode());  //V221004
									System.err.println("Policy type code is:"+outPatBean.getPolicyTypeCode());
									cstmt.setString(6, outPatBean.getDrugCategory());  //V221004
									System.err.println("Drug category is:"+outPatBean.getDrugCategory());
									cstmt.setString(7, outPatBean.getPatCopay());
									System.err.println("Patient copay is:"+outPatBean.getPatCopay());
									cstmt.setString(8, outPatBean.getPatLimitAmt());
									System.err.println("Patient amount limit:"+outPatBean.getPatLimitAmt());
									System.err.println("Accross Encounter Value is: "+outPatBean.getAcrossEncYN());   //V230801
									cstmt.setString(9, null);
									cstmt.setString(10, outPatBean.getAmtGrossNet());
									System.err.println("Gross/Net"+outPatBean.getAmtGrossNet());									
									
									
							//		cstmt.setString(7, outPatBean.getPatClass());
									
									if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
										cstmt.setString(11, null);
									}
									else{
										Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
										cstmt.setDate(11, fromDt);
										System.err.println("Start Date:"+fromDt);									
									
									}
									if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
										cstmt.setString(12, null);
									}
									else{
										Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
										cstmt.setDate(12, toDate);
										System.err.println("End Date:"+toDate);
									}
									cstmt.setString(13, login_user);
									System.err.println("Value is: "+login_user);
									cstmt.setString(14, client_ip_address);
									System.err.println("Value is: "+client_ip_address);
									cstmt.setString(15, facilityId);
									System.err.println("Value is: "+facilityId);
									cstmt.setString(16, login_user);
									System.err.println("Value is: "+login_user);
									cstmt.setString(17, client_ip_address);
									System.err.println("Value is: "+client_ip_address);
									cstmt.setString(18, facilityId);
									System.err.println("Value is: "+facilityId);
									cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
									cstmt.setString(22, outPatBean.getEpisodeEncounter()); //V221113
									cstmt.setString(23, outPatBean.getAcrossEncYN()); //V230801
									System.err.println("Value is: "+outPatBean.getEpisodeEncounter());  //V221113
									cstmt.execute();
									str_error_level = cstmt.getString(19);
									System.err.println("str_error_level is: "+str_error_level);
									str_sysmesage_id = cstmt.getString(20);
									System.err.println("str_sysmesage_id is: "+str_sysmesage_id);
									str_error_text = cstmt.getString(21);
									System.err.println("str_error_text is: "+str_error_text);
									
									if(str_error_level==null && str_error_text==null){
										System.err.println("Record Savedd");
									}
								}
								else{
									str_error_text = "Drug Category Tab Row Number "+i+". Please Enter all mandatory fields";
								}
								
							}
						}
						else if("U".equals(checkForNull(outPatBean.getStatus()))){
							cstmt = con.prepareCall(preAppQueryUpd);

							cstmt.setString(1, outPatBean.getFacilityId());  //V221004
							System.err.println("Facility id: "+outPatBean.getFacilityId());
							cstmt.setString(2, outPatBean.getPatClass());  //V221113
							System.err.println("Episode is: "+outPatBean.getPatClass());  //V221113
							cstmt.setString(3, outPatBean.getPayerGroupCode());  //V221004
							System.err.println("Payer Group is:"+outPatBean.getPayerGroupCode());
							cstmt.setString(4, outPatBean.getPayerCode());  //V221004
							System.err.println("Payer code is:"+outPatBean.getPayerCode());
							cstmt.setString(5, outPatBean.getPolicyTypeCode());  //V221004
							System.err.println("Policy type code is:"+outPatBean.getPolicyTypeCode());
							cstmt.setString(6, outPatBean.getDrugCategory());  //V221004
							System.err.println("Drug category is:"+outPatBean.getDrugCategory());
							cstmt.setString(7, outPatBean.getPatCopay());
							System.err.println("Patient copay is:"+outPatBean.getPatCopay());
							cstmt.setString(8, outPatBean.getPatLimitAmt());
							System.err.println("Patient amount limit:"+outPatBean.getPatLimitAmt());
							cstmt.setString(9, null);
							cstmt.setString(10, outPatBean.getAmtGrossNet());
							System.err.println("Gross/Net"+outPatBean.getAmtGrossNet());	
					//		cstmt.setString(7, outPatBean.getPatClass());
							if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
								cstmt.setString(11, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
								cstmt.setDate(11, fromDt);
								System.err.println("Start Date:"+fromDt);	
							}
							if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
								cstmt.setString(12, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
								cstmt.setDate(12, toDate);
								System.err.println("End Date:"+toDate);	
							}
							cstmt.setString(13, login_user);
							System.err.println("Value is: "+login_user);
							cstmt.setString(14, client_ip_address);
							System.err.println("Value is: "+client_ip_address);
							cstmt.setString(15, facilityId);
							System.err.println("Value is: "+facilityId);
							cstmt.setString(16, login_user);
							System.err.println("Value is: "+login_user);
							cstmt.setString(17, client_ip_address);
							System.err.println("Value is: "+client_ip_address);
							cstmt.setString(18, facilityId);
							System.err.println("Value is: "+facilityId);
							cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
							cstmt.setString(22, outPatBean.getEpisodeEncounter());   //V221113  
							cstmt.setString(23, outPatBean.getAcrossEncYN()); //V230801
							System.err.println("Value is: "+outPatBean.getEpisodeEncounter());   //V221113
									
							cstmt.execute();
							str_error_level = cstmt.getString(19);
							str_sysmesage_id = cstmt.getString(20);
							str_error_text = cstmt.getString(21);
							
							if(str_error_level==null && str_error_text==null){
							System.err.println("Records Updated..");
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
			System.err.println("returnMap is: "+returnMap.isEmpty());
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
			
			System.err.println("Value of insertable is: "+insertable);
			returnMap.put("status", new Boolean(insertable));
			return returnMap;
		}
	}


private HashMap insertDiagnosisCategoryDetails(HttpServletRequest request,
		HttpServletResponse response, MFDRDiagCatBean policyBean) {
			System.err.println("Inside Diagnosis Category details function");
	HashMap returnMap = new HashMap();
	HashMap returnPopup = new HashMap();
	boolean insertable = false;
	try{
		HashMap<String,List<MFDRDiagCatBean>> policyMap = policyBean.getPolicyMap();
		con.setAutoCommit(false);
		List<MFDRDiagCatBean> inclList = null; 
		
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ; //V221004
		facilityId = (String) session.getValue( "facility_id" ) ;  //V221004
		client_ip_address = this.p.getProperty("client_ip_address"); //V221004
		login_user = this.p.getProperty( "login_user" ) ; //V221004
		System.err.println("facilityId id: "+facilityId);
		System.err.println("client_ip_address: "+client_ip_address);
		System.err.println("login_user: "+login_user);
		
		if(!(policyMap == null || policyMap.isEmpty())){
			inclList = policyMap.get("DiagCatDtlsPageInfo");  //V221004
			System.err.println("Policy map is called..");
			System.err.println("inclList contains:"+inclList);
			if(inclList == null){
				inclList = new ArrayList<MFDRDiagCatBean>();
				outPatBean1 = new MFDRDiagCatBean();
				inclList.add(outPatBean1);
			}
		}
		else{
			policyMap = new HashMap<String,List<MFDRDiagCatBean>>();
			inclList = new ArrayList<MFDRDiagCatBean>();
			outPatBean1 = new MFDRDiagCatBean();
			inclList.add(outPatBean1);		
		}
		
		String preAppQueryIns = "", preAppQueryUpd = "", preAppQueryDel = "";
		preAppQueryIns = "{ call   blinsdrug.insert_ins_diag_deduct_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  //V221004
		preAppQueryUpd = "{ call   blinsdrug.update_ins_diag_deduct_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  //V221004
	//	preAppQueryDel = "{ call   blinspolicycoverage.delete_ins_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
		
		int i=1;
		
		for(MFDRDiagCatBean outPatBean : inclList)
		{
			System.err.println("Policy Details outPatBean.getStatus():"+outPatBean.getStatus());
			if(!(outPatBean.getStatus() == null)){
			if(("I".equals(checkForNull(outPatBean.getStatus()))) || ("U".equals(checkForNull(outPatBean.getStatus())))){
				System.err.println("Inside loop 1 in DiagnosisCategory");
		
				if("I".equals(checkForNull(outPatBean.getStatus()))){
					System.err.println(" Inside loop 2 in DiagnosisCategory");
		
					if("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getPayerGroup())) || "".equals(checkForNull(outPatBean.getPayerGroupCode()))  || "".equals(checkForNull(outPatBean.getPayer())) || "".equals(checkForNull(outPatBean.getPayerCode())) || "".equals(checkForNull(outPatBean.getPolicyType())) || "".equals(checkForNull(outPatBean.getPolicyTypeCode())) || "".equals(checkForNull(outPatBean.getDiagCat())) || "".equals(checkForNull(outPatBean.getPatCopay())) || "".equals(checkForNull(outPatBean.getPatLimitAmt())) || "".equals(checkForNull(outPatBean.getAmtGrossNet())) || "".equals(checkForNull(outPatBean.getStartDate())) ){
					}
					else{
						System.err.println("Inside loop 3 in DiagnosisCategory");
		
						if(!("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getPayerGroup())) || "".equals(checkForNull(outPatBean.getPayerGroupCode()))  || "".equals(checkForNull(outPatBean.getPayer())) || "".equals(checkForNull(outPatBean.getPayerCode())) || "".equals(checkForNull(outPatBean.getPolicyType())) || "".equals(checkForNull(outPatBean.getPolicyTypeCode())) || "".equals(checkForNull(outPatBean.getDiagCat())) || "".equals(checkForNull(outPatBean.getPatCopay())) || "".equals(checkForNull(outPatBean.getPatLimitAmt())) || "".equals(checkForNull(outPatBean.getAmtGrossNet())) || "".equals(checkForNull(outPatBean.getStartDate())) )){
							
							cstmt = con.prepareCall(preAppQueryIns);							
							cstmt.setString(1, outPatBean.getFacilityId());  //V221004
							System.err.println("Facility id: "+outPatBean.getFacilityId());
							cstmt.setString(2, outPatBean.getPatClass());  //V221113
							System.err.println("Episode is: "+outPatBean.getPatClass());  //V221113
							cstmt.setString(3, outPatBean.getPayerGroupCode());  //V221004
							System.err.println("Payer Group is:"+outPatBean.getPayerGroupCode());
							cstmt.setString(4, outPatBean.getPayerCode());  //V221004
							System.err.println("Payer code is:"+outPatBean.getPayerCode());
							cstmt.setString(5, outPatBean.getPolicyTypeCode());  //V221004
							System.err.println("Policy type code is:"+outPatBean.getPolicyTypeCode());
							cstmt.setString(6, outPatBean.getDiagCat());  //V221004
							System.err.println("Drug category is:"+outPatBean.getDiagCat());
							cstmt.setString(7, outPatBean.getPatCopay());
							System.err.println("Patient copay is:"+outPatBean.getPatCopay());
							cstmt.setString(8, outPatBean.getPatLimitAmt());
					//		cstmt.setInt(8, 12);
							System.err.println("Patient amount limit:"+outPatBean.getPatLimitAmt());
							cstmt.setString(9, null);
							cstmt.setString(10, outPatBean.getAmtGrossNet());
							System.err.println("Gross/Net"+outPatBean.getAmtGrossNet());									
							
							
					//		cstmt.setString(7, outPatBean1.getPatClass());
							
							if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
								cstmt.setString(11, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
								cstmt.setDate(11, fromDt);
								System.err.println("Start Date:"+fromDt);									
							
							}
							if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
								cstmt.setString(12, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
								cstmt.setDate(12, toDate);
								System.err.println("End Date:"+toDate);
							}
							cstmt.setString(13, login_user);
							System.err.println("Value is: "+login_user);
							cstmt.setString(14, client_ip_address);
							System.err.println("Value is: "+client_ip_address);
							cstmt.setString(15, facilityId);
							System.err.println("Value is: "+facilityId);
							cstmt.setString(16, login_user);
							System.err.println("Value is: "+login_user);
							cstmt.setString(17, client_ip_address);
							System.err.println("Value is: "+client_ip_address);
							cstmt.setString(18, facilityId);
							System.err.println("Value is: "+facilityId);
							cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
							cstmt.setString(22, outPatBean.getEpisodeEncounter()); //V221113
							System.err.println("Value is: "+outPatBean.getEpisodeEncounter());  //V221113
							cstmt.execute();
							str_error_level = cstmt.getString(19);
							System.err.println("str_error_level is: "+str_error_level);
							str_sysmesage_id = cstmt.getString(20);
							System.err.println("str_sysmesage_id is: "+str_sysmesage_id);
							str_error_text = cstmt.getString(21);
							System.err.println("str_error_text is: "+str_error_text);
							
							if(str_error_level==null && str_error_text==null){
								System.err.println("Record Savedd");
							}
						}
						else{
							str_error_text = "Diagnosis Category Tab. Row Number "+i+". Please Enter all mandatory fields";
						}
					}
				}
				else if("U".equals(checkForNull(outPatBean.getStatus()))){
					cstmt = con.prepareCall(preAppQueryUpd);

					cstmt.setString(1, outPatBean.getFacilityId());  //V221004
					System.err.println("Facility id: "+outPatBean.getFacilityId());
					cstmt.setString(2, outPatBean.getPatClass());  //V221113
					System.err.println("Episode is: "+outPatBean.getPatClass());  //V221113
					cstmt.setString(3, outPatBean.getPayerGroupCode());  //V221004
					System.err.println("Payer Group is:"+outPatBean.getPayerGroupCode());
					cstmt.setString(4, outPatBean.getPayerCode());  //V221004
					System.err.println("Payer code is:"+outPatBean.getPayerCode());
					cstmt.setString(5, outPatBean.getPolicyTypeCode());  //V221004
					System.err.println("Policy type code is:"+outPatBean.getPolicyTypeCode());
					cstmt.setString(6, outPatBean.getDiagCat());  //V221004
					System.err.println("Drug category is:"+outPatBean.getDiagCat());
					cstmt.setString(7, outPatBean.getPatCopay());
					System.err.println("Patient copay is:"+outPatBean.getPatCopay());
					cstmt.setString(8, outPatBean.getPatLimitAmt());
				//	cstmt.setInt(8, 12);
					System.err.println("Patient amount limit:"+outPatBean.getPatLimitAmt());
					cstmt.setString(9, null);
					cstmt.setString(10, outPatBean.getAmtGrossNet());
					System.err.println("Gross/Net"+outPatBean.getAmtGrossNet());	
			//		cstmt.setString(7, outPatBean1.getPatClass());
					if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
						cstmt.setString(11, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
						cstmt.setDate(11, fromDt);
						System.err.println("Start Date:"+fromDt);	
					}
					if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
						cstmt.setString(12, null);
					}
					else{
						Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
						cstmt.setDate(12, toDate);
						System.err.println("End Date:"+toDate);	
					}
					cstmt.setString(13, login_user);
					System.err.println("Value is: "+login_user);
					cstmt.setString(14, client_ip_address);
					System.err.println("Value is: "+client_ip_address);
					cstmt.setString(15, facilityId);
					System.err.println("Value is: "+facilityId);
					cstmt.setString(16, login_user);
					System.err.println("Value is: "+login_user);
					cstmt.setString(17, client_ip_address);
					System.err.println("Value is: "+client_ip_address);
					cstmt.setString(18, facilityId);
					System.err.println("Value is: "+facilityId);
					cstmt.registerOutParameter(19, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(20, java.sql.Types.VARCHAR);
					cstmt.registerOutParameter(21, java.sql.Types.VARCHAR);
					cstmt.setString(22, outPatBean.getEpisodeEncounter());   //V221113  
					System.err.println("Value is: "+outPatBean.getEpisodeEncounter());   //V221113
							
					cstmt.execute();
					str_error_level = cstmt.getString(19);
					str_sysmesage_id = cstmt.getString(20);
					str_error_text = cstmt.getString(21);
					
					if(str_error_level==null && str_error_text==null){
					System.err.println("Records Updated..");
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

/*  V230210 starts */
private HashMap insertservicesAndItemsCategoryDetails(HttpServletRequest request,
		HttpServletResponse response, MFDRServicesAndItemsBean policyBean) {
			System.err.println("Inside Services and Items function");
	HashMap returnMap = new HashMap();
	HashMap returnPopup = new HashMap();
	boolean insertable = false;
	try{
		HashMap<String,List<MFDRServicesAndItemsBean>> policyMap = policyBean.getPolicyMap();
		con.setAutoCommit(false);
		List<MFDRServicesAndItemsBean> inclList = null; 
		
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ; 
		facilityId = (String) session.getValue( "facility_id" ) ;  
		client_ip_address = this.p.getProperty("client_ip_address"); 
		login_user = this.p.getProperty( "login_user" ) ; 
		System.err.println("facilityId id: "+facilityId);
		System.err.println("client_ip_address: "+client_ip_address);
		System.err.println("login_user: "+login_user);
		
		if(!(policyMap == null || policyMap.isEmpty())){
			inclList = policyMap.get("ServicesAndItemsCatDtlsPageInfo");  
			System.err.println("Policy map is called..");
			System.err.println("inclList contains:"+inclList);
			if(inclList == null){
				inclList = new ArrayList<MFDRServicesAndItemsBean>();
				outPatBean2 = new MFDRServicesAndItemsBean();
				inclList.add(outPatBean2);
			}
		}
		else{
			policyMap = new HashMap<String,List<MFDRServicesAndItemsBean>>();
			inclList = new ArrayList<MFDRServicesAndItemsBean>();
			outPatBean2 = new MFDRServicesAndItemsBean();
			inclList.add(outPatBean2);		
		}
		
		String preAppQueryIns = "", preAppQueryUpd = "", preAppQueryDel = "";
		preAppQueryIns = "{ call   blinsdrug.insert_serv_item_deduct_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  
		preAppQueryUpd = "{ call   blinsdrug.update_serv_item_deduct_dtl (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  
	//	preAppQueryDel = "{ call   blinspolicycoverage.delete_ins_policy_hdr (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";  
		
		int i=1;
		
		for(MFDRServicesAndItemsBean outPatBean : inclList)
		{
			System.err.println("Policy Details outPatBean.getStatus():"+outPatBean.getStatus());
			if(!(outPatBean.getStatus() == null)){
			if(("I".equals(checkForNull(outPatBean.getStatus()))) || ("U".equals(checkForNull(outPatBean.getStatus())))){
				System.err.println("Inside loop 1 in Services and Items");
		
				if("I".equals(checkForNull(outPatBean.getStatus()))){
					System.err.println(" Inside loop 2 in Services and Items");
		
					if("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getPayerGroup())) || "".equals(checkForNull(outPatBean.getPayerGroupCode()))  || "".equals(checkForNull(outPatBean.getPayer())) || "".equals(checkForNull(outPatBean.getPayerCode())) || "".equals(checkForNull(outPatBean.getPolicyType())) || "".equals(checkForNull(outPatBean.getPolicyTypeCode())) || "".equals(checkForNull(outPatBean.getClinicCat())) || "".equals(checkForNull(outPatBean.getInclExclCriteria())) || "".equals(checkForNull(outPatBean.getServiceDetailsDesc())) || "".equals(checkForNull(outPatBean.getServiceDetailsCode())) || "".equals(checkForNull(outPatBean.getReferral())) || "".equals(checkForNull(outPatBean.getPatCopay())) || "".equals(checkForNull(outPatBean.getPatLimitAmt())) || "".equals(checkForNull(outPatBean.getAmtGrossNet())) || "".equals(checkForNull(outPatBean.getStartDate())) ){
					}
					else{
						System.err.println("Inside loop 3 in Services and Items");
		
						if(!("".equals(checkForNull(outPatBean.getEpisodeEncounter())) || "".equals(checkForNull(outPatBean.getPatClass())) || "".equals(checkForNull(outPatBean.getPayerGroup())) || "".equals(checkForNull(outPatBean.getPayerGroupCode()))  || "".equals(checkForNull(outPatBean.getPayer())) || "".equals(checkForNull(outPatBean.getPayerCode())) || "".equals(checkForNull(outPatBean.getPolicyType())) || "".equals(checkForNull(outPatBean.getPolicyTypeCode())) || "".equals(checkForNull(outPatBean.getClinicCat())) || "".equals(checkForNull(outPatBean.getInclExclCriteria())) || "".equals(checkForNull(outPatBean.getServiceDetailsDesc())) || "".equals(checkForNull(outPatBean.getServiceDetailsCode())) || "".equals(checkForNull(outPatBean.getReferral())) || "".equals(checkForNull(outPatBean.getPatCopay())) || "".equals(checkForNull(outPatBean.getPatLimitAmt())) || "".equals(checkForNull(outPatBean.getAmtGrossNet())) || "".equals(checkForNull(outPatBean.getStartDate())) )){
							
							cstmt = con.prepareCall(preAppQueryIns);							
							cstmt.setString(1, outPatBean.getFacilityId());  
							System.err.println("Facility id: "+outPatBean.getFacilityId());
							cstmt.setString(2, outPatBean.getPatClass());  
							System.err.println("Episode is: "+outPatBean.getPatClass());  
							cstmt.setString(3, outPatBean.getPayerGroupCode());  
							System.err.println("Payer Group is:"+outPatBean.getPayerGroupCode());
							cstmt.setString(4, outPatBean.getPayerCode());  
							System.err.println("Payer code is:"+outPatBean.getPayerCode());
							cstmt.setString(5, outPatBean.getPolicyTypeCode());  
							System.err.println("Policy type code is:"+outPatBean.getPolicyTypeCode());
							cstmt.setString(6, outPatBean.getClinicCat());  
							System.err.println("Services and Items category is:"+outPatBean.getClinicCat());
							cstmt.setString(7, outPatBean.getClinicProc());  
							System.err.println("Services and Items category is:"+outPatBean.getClinicProc());
							cstmt.setString(8, outPatBean.getClinicProcCode());  
							System.err.println("Services and Items category is:"+outPatBean.getClinicProcCode());
							
							cstmt.setString(9, outPatBean.getInclExclCriteria());  
							System.err.println("Services and Items category is:"+outPatBean.getInclExclCriteria());
						//	cstmt.setString(8, outPatBean.getServiceDetailsDesc());  
							System.err.println("Services and Items category is:"+outPatBean.getServiceDetailsDesc());
							cstmt.setString(10, outPatBean.getServiceDetailsCode());  
							System.err.println("Services and Items category is:"+outPatBean.getServiceDetailsCode());
							cstmt.setString(11, outPatBean.getReferral());  
							System.err.println("Services and Items category is:"+outPatBean.getReferral());
							cstmt.setString(12, outPatBean.getPatCopay());
							System.err.println("Patient copay is:"+outPatBean.getPatCopay());
							cstmt.setString(13, outPatBean.getPatLimitAmt());
					//		cstmt.setInt(8, 12);
							System.err.println("Patient amount limit:"+outPatBean.getPatLimitAmt());
							cstmt.setString(14, null);
							cstmt.setString(15, outPatBean.getAmtGrossNet());
							System.err.println("Gross/Net"+outPatBean.getAmtGrossNet());									
							
							
					//		cstmt.setString(7, outPatBean1.getPatClass());
							
							if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
								cstmt.setString(16, null);
							}
							else{
								Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
								cstmt.setDate(16, fromDt);
								System.err.println("Start Date:"+fromDt);									
							
							}
							if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
								cstmt.setString(17, null);
							}
							else{
								Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
								cstmt.setDate(17, toDate);
								System.err.println("End Date:"+toDate);
							}
							cstmt.setString(18, login_user);
							System.err.println("Value is: "+login_user);
							cstmt.setString(19, client_ip_address);
							System.err.println("Value is: "+client_ip_address);
							cstmt.setString(20, facilityId);
							System.err.println("Value is: "+facilityId);
							cstmt.setString(21, login_user);
							System.err.println("Value is: "+login_user);
							cstmt.setString(22, client_ip_address);
							System.err.println("Value is: "+client_ip_address);
							cstmt.setString(23, facilityId);
							System.err.println("Value is: "+facilityId);
							cstmt.registerOutParameter(24, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(25, java.sql.Types.VARCHAR);
							cstmt.registerOutParameter(26, java.sql.Types.VARCHAR);
							cstmt.setString(27, outPatBean.getEpisodeEncounter()); //V221113
							cstmt.setString(28, outPatBean.getAcrossEncYN()); //V230801
							System.err.println("Value is: "+outPatBean.getEpisodeEncounter());  //V221113
							cstmt.execute();
							str_error_level = cstmt.getString(24);
							System.err.println("str_error_level is: "+str_error_level);
							str_sysmesage_id = cstmt.getString(25);
							System.err.println("str_sysmesage_id is: "+str_sysmesage_id);
							str_error_text = cstmt.getString(26);
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
					cstmt.setString(2, outPatBean.getPatClass());  
					System.err.println("Episode is: "+outPatBean.getPatClass());  
					cstmt.setString(3, outPatBean.getPayerGroupCode());  
					System.err.println("Payer Group is:"+outPatBean.getPayerGroupCode());
					cstmt.setString(4, outPatBean.getPayerCode());  
					System.err.println("Payer code is:"+outPatBean.getPayerCode());
					cstmt.setString(5, outPatBean.getPolicyTypeCode());  
					System.err.println("Policy type code is:"+outPatBean.getPolicyTypeCode());
					cstmt.setString(6, outPatBean.getClinicCat());  
					System.err.println("Services and Items category is:"+outPatBean.getClinicCat());
					cstmt.setString(7, outPatBean.getClinicProc());  
					System.err.println("Services and Items category is:"+outPatBean.getClinicProc());
					cstmt.setString(8, outPatBean.getClinicProcCode());  
					System.err.println("Services and Items category is:"+outPatBean.getClinicProcCode());
					
					
					cstmt.setString(9, outPatBean.getInclExclCriteria());  
					System.err.println("Services and Items category is:"+outPatBean.getInclExclCriteria());
					System.err.println("Services and Items category is:"+outPatBean.getServiceDetailsDesc());
					cstmt.setString(10, outPatBean.getServiceDetailsCode());  
					System.err.println("Services and Items category is:"+outPatBean.getServiceDetailsCode());
					cstmt.setString(11, outPatBean.getReferral());  
					System.err.println("Services and Items category is:"+outPatBean.getReferral());
					cstmt.setString(12, outPatBean.getPatCopay());
					System.err.println("Patient copay is:"+outPatBean.getPatCopay());
					cstmt.setString(13, outPatBean.getPatLimitAmt());
					System.err.println("Patient amount limit:"+outPatBean.getPatLimitAmt());
					cstmt.setString(14, null);
					cstmt.setString(15, outPatBean.getAmtGrossNet());
					System.err.println("Gross/Net"+outPatBean.getAmtGrossNet());									
									
					if((outPatBean.getStartDate() == null) || ("".equals(outPatBean.getStartDate()))){
						cstmt.setString(16, null);
					}
					else{
						Date fromDt = new Date(sdf.parse(outPatBean.getStartDate()).getTime());
						cstmt.setDate(16, fromDt);
						System.err.println("Start Date:"+fromDt);									
							
					}
					if((outPatBean.getEndDate() == null) || ("".equals(outPatBean.getEndDate())) ){
						cstmt.setString(17, null);
					}
					else{
						Date toDate = new Date(sdf.parse(outPatBean.getEndDate()).getTime());
						cstmt.setDate(17, toDate);
						System.err.println("End Date:"+toDate);
					}
						cstmt.setString(18, login_user);
						System.err.println("Value is: "+login_user);
						cstmt.setString(19, client_ip_address);
						System.err.println("Value is: "+client_ip_address);
						cstmt.setString(20, facilityId);
						System.err.println("Value is: "+facilityId);
						cstmt.setString(21, login_user);
						System.err.println("Value is: "+login_user);
						cstmt.setString(22, client_ip_address);
						System.err.println("Value is: "+client_ip_address);
						cstmt.setString(23, facilityId);
						System.err.println("Value is: "+facilityId);
						cstmt.registerOutParameter(24, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(25, java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(26, java.sql.Types.VARCHAR);
						cstmt.setString(27, outPatBean.getEpisodeEncounter()); //V221113
						cstmt.setString(28, outPatBean.getAcrossEncYN()); //V230801
						System.err.println("Value is: "+outPatBean.getEpisodeEncounter());  //V221113
						cstmt.execute();
						str_error_level = cstmt.getString(24);
						System.err.println("str_error_level is: "+str_error_level);
						str_sysmesage_id = cstmt.getString(25);
						System.err.println("str_sysmesage_id is: "+str_sysmesage_id);
						str_error_text = cstmt.getString(26);
						System.err.println("str_error_text is: "+str_error_text);
						
						if(str_error_level==null && str_error_text==null){
							System.err.println("Record Savedd");
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
/* V230210 ends */
}




