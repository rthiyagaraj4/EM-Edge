/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;
//package eSS.Common;

import java.io.Serializable;
import javax.servlet.http.HttpSession;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import eSS.Common.*;
import eSS.Packing.*;
import javax.servlet.* ;
import javax.servlet.http.*;


public class PackingBean extends eSS.Common.SsTransaction implements Serializable { 

	private String doc_ref;
	private String wash_yn;
	private String doc_type_code;
	private String doc_date;
	private String service_location_code;
	private String doc_no;
	private String pack_yn;
	private String store_code;
	private String sterilize_yn;
	private HttpSession session;
	private HashMap hmSsParameter =null;
	private String records_to_pack;

	private String PDocNo = "" ;
	private String PgetDoc_type_code = "";
	private String PgetStore_codess = "";
	public String reportserver = "";
	public String report_connect_string = "";

	public void setPrintDocNo(String Pdoc_no){
		PDocNo = Pdoc_no;
	}

	public String getPrintDocNo(){
		return PDocNo;
	}


	public void setRecords_to_pack(String records_to_pack) {
		 this.records_to_pack =  records_to_pack;
	}

	public String getRecords_to_pack() {
		 return records_to_pack;
	}

	public void setReport_Server(String reportserver) {
		 this.reportserver= reportserver;
 	}

	public String  getReport_Server( ) {
		 return reportserver;
	}
	
	public void setReport_Connect_String(String report_connect_string) {
		 this.report_connect_string= report_connect_string;

	}

	public String getReport_Connect_String( ) {
		 return report_connect_string;
	}

	public void initSsParameter() throws Exception {
		hmSsParameter=getSSParameter();
	}

	public void initDoc_type_code() {
		doc_type_code=checkForNull((String)hmSsParameter.get("DEF_ROF_DOC_TYPE_CODE")) ;
	}

	public void initService_location_code() {
		service_location_code=checkForNull((String)hmSsParameter.get("DEF_SERVICE_LOCATION_CODE")) ;
	}

	public void initDoc_date() {
		doc_date=hmSsParameter.get("SYS_DATE").toString() ;
	}

	public String getDoc_type_code_List(){
		return getDoc_type_code_ListOptions("ROF",getDoc_type_code());
	}

	public String getStore_code_List(){
		String default_store_code = "";
		try {
				java.util.HashMap defaultParameter = getSSParameter();
				default_store_code = (String)defaultParameter.get("DEF_STORE_CODE_FOR_PRE");
				defaultParameter = null;
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_ROF_SELECT_LIST"), alParam), default_store_code);
	}

	public String getService_location_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_SERVICE_LOCATION_SELECT_LIST"),alParam),getService_location_code());
		
	}

	public void setSterilize_yn(String sterilize_yn) {
		 this.sterilize_yn = checkForNull(sterilize_yn,"N");
	}

	public String getSterilize_yn() {
		 return sterilize_yn;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = checkForNull(doc_ref);
	}

	public String getDoc_ref( ) {
		 return doc_ref;
	}

	public void setWash_yn(String wash_yn) {
		 this.wash_yn = checkForNull(wash_yn,"N");
	}

	public String getWash_yn( ) {
		 return wash_yn;
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code( ) {
		 return doc_type_code;
	}

	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public String getDoc_date( ) {
		 return doc_date;
	}

	public void setSession(HttpSession session) {
		 this.session = session;
	}

	public HttpSession getSession( ) {
		 return session;
	}

	public void setService_location_code(String service_location_code) {
		 this.service_location_code = checkForNull(service_location_code);
	}

	public String getService_location_code( ) {
		 return service_location_code;
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no( ) {
		 return doc_no;
	}

	public void setPack_yn(String pack_yn) {
		 this.pack_yn = checkForNull(pack_yn,"N");
	}

	public String getPack_yn( ) {
		 return pack_yn;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code( ) {
		 java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		 return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_ROF_SELECT_LIST"), alParam), store_code);
	}

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setDoc_ref((String) htRecordSet.get("doc_ref"));
		setWash_yn((String) htRecordSet.get("wash_yn"));
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_date((String) htRecordSet.get("doc_date"));
		setService_location_code((String) htRecordSet.get("service_location_code"));
		setDoc_no((String) htRecordSet.get("doc_no"));
		setPack_yn((String) htRecordSet.get("pack_yn"));
		setStore_code((String) htRecordSet.get("store_code")) ;
		setSterilize_yn((String) htRecordSet.get("sterilize_yn"));
		setRecords_to_pack((String) htRecordSet.get("records_to_pack"));
		
	}

	public void clear(){
		super.clear();
		doc_ref="";
		wash_yn="N";
		doc_type_code="";
		doc_date="";
		session=null;
		service_location_code="";
		doc_no="";
		pack_yn="Y";
		store_code="";
		records_to_pack="";
		sterilize_yn="N";
	}
	
	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		ArrayList alPackingList;
		hmReturn.put(RESULT,TRUE);
		try { 
			alPackingList	=	(ArrayList)session.getAttribute("alPackingList");
			if((alPackingList.size()==0)||(getRecords_to_pack().indexOf("Y")==-1)){
				throw new Exception("MIN_ONE_DETAIL_REQUIRED");
			}
		}
		catch (Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
		}
		return hmReturn;
	}

	public HashMap insert(){
		return getMessageHashMap(false);
	}
	
	public HashMap modify() {
		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrModifyData		=	new ArrayList()	;
		ArrayList	alDtlModifyData		=	new ArrayList()	;
		ArrayList	alDiscDtlInsertData	=	new ArrayList()	;
		ArrayList	alPackingList		=	null			;
		ArrayList	alPackingDiscrepancyList	=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		StringTokenizer stRecordsToPack	=	new StringTokenizer(getRecords_to_pack(),",");


		alHdrModifyData.add(getLoginById()		);      
		alHdrModifyData.add(getLoginAtWsNo()	);    
		alHdrModifyData.add(getLoginFacilityId());

		alHdrModifyData.add(getLoginFacilityId());      
		alHdrModifyData.add(getDoc_type_code()  );
		alHdrModifyData.add(new Long (getDoc_no()));
		System.out.println("alHdrModifyData"+alHdrModifyData);

		alPackingList	=	(ArrayList)session.getAttribute("alPackingList");
		for (int i=0;i<alPackingList.size() ;i++ ) {
			HashMap hmRecord	=	(HashMap)alPackingList.get(i);
			if((String) hmRecord.get("PACK_ITEM_QTY")==null){hmRecord.put("PACK_ITEM_QTY","");}
			if((String) hmRecord.get("PACK_ITEM_CODE")==null){hmRecord.put("PACK_ITEM_CODE","");}
			if((String) hmRecord.get("PACK_COST")==null){hmRecord.put("PACK_COST","");}
			if(stRecordsToPack.nextToken().equals("N")){
				continue;
			}
		
			alDtlModifyData.add(hmRecord);
		}

		alPackingDiscrepancyList	=	(ArrayList)session.getAttribute("alPackingDiscrepancyList");

		for (int i=0;i<alPackingDiscrepancyList.size() ;i++ ) {
			HashMap hmRecord	=	(HashMap)alPackingDiscrepancyList.get(i);
			System.out.println("hmRecord"+hmRecord);
			if(hmRecord.get("markedAsDelete").toString().equals("Y")){
				continue;
			}
			alDiscDtlInsertData.add(hmRecord);		
		}

		hmSQLMap.put( "HdrModifySQL", getSsRepositoryValue("SQL_SS_ROF_HDR_UPDATE_FOR_PACKING")	);
		hmSQLMap.put( "DtlModifySQL", getSsRepositoryValue("SQL_SS_ROF_DTL_UPDATE_FOR_PACKING")		);
		hmSQLMap.put( "DiscDtlInsertSQL", getSsRepositoryValue("SQL_SS_ROF_DISCREPANCY_DTL_INSERT")		);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "HdrModifyData",		alHdrModifyData	);
		hmTableData.put( "DtlModifyData",		alDtlModifyData	);
		hmTableData.put( "DiscDtlInsertData",	alDiscDtlInsertData	);
		return packingMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}


	public HashMap packingMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){


		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_PACKING"),PackingHome.class,getLocalEJB());
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();



			
			switch (functionID)
			{
				case FUNCTION_INSERT:
					hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					break;
				
				case FUNCTION_UPDATE:
					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					//(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					System.out.println("PackingBean.java,340, = > "+hmResult);
					break;
				
				case FUNCTION_DELETE:
					hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to packingMethodCall()") ;
					
			}

		
			if( ((Boolean) hmResult.get("result")).booleanValue() )	
			{
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			}
			else if( hmResult.get("msgid")!=null  )
			{
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			}
			else
			{
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
			}
		} 
		catch(Exception exception) {
			hmResult.put( "message", "Bean 383: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		}
		System.out.println("hmResult"+hmResult);
		System.out.println("result"+hmResult.get("result"));
		System.out.println("BooleanValue result"+((Boolean)hmResult.get("result")).booleanValue());

			String doc_no	=	getDoc_no();
			//System.out.println("doc_no"+doc_no);
			PgetStore_codess  = store_code;
			PgetDoc_type_code = getDoc_type_code();

			System.out.println("PgetDoc_type_code"+PgetDoc_type_code);
			System.out.println("PgetStore_codess"+PgetStore_codess);
			setPrintDocNo(doc_no);
			

		if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (isInternalRequest("SS","SSBTRDIS")&& isInternalRequest("SS","SSBPKCHK")) {//
				//doOnlineReportPrinting();				
			}
		}
		return hmResult;

	}

	public void loadData() throws Exception {

		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(new Long(getDoc_no()));

		HashMap hmRecord		= 	fetchRecord(getSsRepositoryValue("SQL_SS_ROF_HDR_SELECT_SINGLE"),alParameters);
		setDoc_date				((String) hmRecord.get("DOC_DATE")				);      
		setDoc_ref				((String) hmRecord.get("DOC_REF")				);       
		setStore_code			((String) hmRecord.get("STORE_CODE")			);
		setSterilize_yn			((String) hmRecord.get("STERILIZE_YN")			);
		setWash_yn				((String) hmRecord.get("WASH_YN")				);  
		setService_location_code((String) hmRecord.get("SERVICE_LOCATION_CODE")	);  
	}


		/*public void doOnlineReportPrinting(String P_fm_doc_no, String P_to_doc_no) {
		try{
			String reportid = "SSBPKLBL";
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","SS");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("P_fm_doc_no",P_fm_doc_no);
			hmReportParameter.put("P_to_doc_no",P_to_doc_no);

			System.out.println("hmReportParameter"+hmReportParameter);


			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());
			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codess);
			System.out.println("hmParameters"+hmParameters);
			//String url = getURLString(hmParameters);
			new eSS.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();   
		}							   
	}*/

	     //ML-MMOH-CRF-1821 - STARTS
		public String getReportId(String p_doc_no, String p_doc_type_code) {
 	
			String reportid					= "SSBPKLBL"; // Default report type
			String group_type				= "";
			String report_size				= "";
			try{

System.err.println("-----getReportId Method====="+p_doc_no+"==p_doc_type_code"+p_doc_type_code+"facility"+getLoginFacilityId());
					
					//print_packed_label_yn, linen_group_label_type, set_group_label_type,single_group_label_type, soft_pack_group_lael_type, tray_group_label_type, allow_multi_group_types_yn
					//String sql						= "select nvl(print_packed_label_yn,'N'), linen_group_label_type, set_group_label_type,single_group_label_type, soft_pack_group_label_type, tray_group_label_type, nvl(allow_multi_group_types_yn,'N') from ss_facility_param where facility_id= ?";

					ArrayList alParameters=new ArrayList();
					alParameters.add(getLoginFacilityId());// pass the facility id

					HashMap hmRecord	= new HashMap();
 					
					//ArrayList optionParameterValues =(ArrayList) getListOptionArrayList(sql, parameter);
					ArrayList optionParameterValues		=	fetchRecords(getSsRepositoryValue("SQL_PACK_LABEL_PARAMETER_FACILITY_SELECT"), alParameters);

					System.err.println("optionParameterValues"+optionParameterValues);
					System.err.println("optionParameterValues.size()"+optionParameterValues.size());
					
					if(optionParameterValues!=null && optionParameterValues.size()>0) {

						hmRecord	=	(HashMap)optionParameterValues.get(0);  //Only one record for facility in setup
System.err.println("===hmRecord====="+hmRecord);
					 
						String linen_group_label_type		= checkForNull((String)hmRecord.get("LINEN_GROUP_LABEL_TYPE"));
						String set_group_label_type			= checkForNull((String)hmRecord.get("SET_GROUP_LABEL_TYPE"));	
						String single_group_label_type		= checkForNull((String)hmRecord.get("SINGLE_GROUP_LABEL_TYPE"));
						String soft_pack_group_label_type	= checkForNull((String)hmRecord.get("SOFT_PACK_GROUP_LABEL_TYPE"));	
						String tray_group_label_type		= checkForNull((String)hmRecord.get("TRAY_GROUP_LABEL_TYPE"));	
						String allow_multi_group_types_yn	= checkForNull((String)hmRecord.get("ALLOW_MULTI_GROUP_TYPES_YN"));	

						if(allow_multi_group_types_yn!=null && allow_multi_group_types_yn.equalsIgnoreCase("Y")) {  //Existing flow/report
							reportid = "SSBPKLBL"; // Default Report ID
						} else { //ML-MMOH-CRF-1821 functionality //for single group type and for ML-MMOH-CRF-1821 logic to find the appropriate report
							//select distinct group_type from ss_rof_dtl where doc_no=pdocno//from and to doc_no is passed as same doc_no
							//Get Parameter for Facility based on doc_no/group type
							//"select distinct group_type from ss_rof_dtl where doc_no=";//from and to doc_no is passed as same doc_no			
							alParameters=new ArrayList();
							alParameters.add(p_doc_no);// pass the doc_no id
							alParameters.add(p_doc_type_code);// pass the doc_type_code
							alParameters.add(getLoginFacilityId());// pass the facility id
							group_type						= (String)fetchRecord(getSsRepositoryValue("SQL_PACK_LABEL_ROF_DTL_GROUP_TYPE_SELECT"),alParameters).get("GROUP_TYPE");
System.err.println("==group_type"+group_type);
							if(group_type!=null && group_type.equalsIgnoreCase("E")) {  // b.group_type,'E', 'Set', 'T', 'Tray', 'P', 'SoftPack', 'S', 'single','L','Linen'
									report_size = set_group_label_type;
							} else if(group_type!=null && group_type.equalsIgnoreCase("T")) {  // Tray
									report_size = tray_group_label_type;
							} else if(group_type!=null && group_type.equalsIgnoreCase("P")) {  // Soft Pack
									report_size	= soft_pack_group_label_type;
							} else if(group_type!=null && group_type.equalsIgnoreCase("S")) {  // Single
									report_size	= single_group_label_type;
							} else if(group_type!=null && group_type.equalsIgnoreCase("L")) {  // Linen
									report_size = linen_group_label_type;
							} 
System.err.println("==report_size"+report_size);
							if(report_size!=null && report_size.equalsIgnoreCase("6X9")){
								reportid = "SSBPKLBL1"; //
							} else if(report_size!=null && report_size.equalsIgnoreCase("3X5")) {
								reportid = "SSBPKLBL2"; //
							} else { // Incase setup is not there then default report id 
								reportid = "SSBPKLBL"; //
							}
System.err.println("==reportid"+reportid);
						}
					}
				}catch ( Exception ex) {
					ex.printStackTrace();
				}
				return reportid;
		}
	     //ML-MMOH-CRF-1821 - ENDS
				
		//if(report!=null && report.equalsIgnoreCase("SS_PACK_LABEL_6X9")) {
		//	report_id				= "SSBPKLBL1"; //ML-MMOH-CRF-1821
		//} else if(report!=null && report.equalsIgnoreCase("SS_PACK_LABEL_3X5")) {
		//	report_id				= "SSBPKLBL2";			//ML-MMOH-CRF-1821				//Till here for ML-MMOH-CRF-621
		//}

			public void doOnlineReportPrinting(String P_fm_doc_no, String P_to_doc_no,Object request,Object response) {
 	
			try{
	
				//String reportid					= "SSBPKLBL"; // Default report type
				//String copies					=(String)(fetchRecord("select NO_OF_COPIES from sm_print_routing where report_id=?",reportid).get("NO_OF_COPIES"));

				String reportid					= getReportId(P_fm_doc_no, PgetDoc_type_code); //ML-MMOH-CRF-1821 

				
				ecis.utils.OnlineReports onlineReports 	= null;
				ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "SS", reportid) ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "SS", reportid, "S", "") ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "SS") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("P_fm_doc_no",P_fm_doc_no);
				report2.addParameter("P_to_doc_no",P_to_doc_no);
				//report2.addParameter("copies",checkForNull(copies,"1"));
				onlineReports.add( report2) ;

				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}

  

}
