/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DrugInfoEnquiry.*;

public class PhDrugInfoEnqBean extends PhAdapter implements Serializable {
	private String sys_date_with_out_time		=	"";
	private int resp_days						=	0;
	private	int resp_hours						=	0;
	private int resp_minutes					=	0;
	private String mode							=	"";
	private String SignedBy						=	"";
	private String Signedverify_remarks			=   "";
	private	String SignedDateTime				=	"";
	private	String EnquiryDate					=	"";
	private ArrayList Enq_Dtl					= new ArrayList();
	private ArrayList Reqcatg_Dtl				= new ArrayList();
	private ArrayList InfoSrc_Dtl				= new ArrayList();
	
	 public PhDrugInfoEnqBean(){
        try {
            doCommon();
        }
        catch(Exception e){
			e.printStackTrace();
		}
    }
	
	private void doCommon() throws Exception {
	}

	public void clear(){
		super.clear() ;
		//resp_days			=	0;
		//resp_hours			=	0;
		//resp_minutes		=	0;
		mode				=	"";
		SignedBy			=	"";
		SignedDateTime		=	"";
		Signedverify_remarks=   "";
	}
	
	//Start of Set Methods
	public void setResp_days(int resp_days ) {
		this.resp_days=resp_days;
	}
	public void setResp_hours(int resp_hours ){
		this.resp_hours=resp_hours;
	}
	public void setResp_minutes(int resp_minutes ){
		this.resp_minutes=resp_minutes;
	}
	public void setMode(String mode ){
		this.mode=mode;
	}
	public void setSignedBy(String SignedBy ){
		this.SignedBy=SignedBy;
	}
	public void setEnquiryDate(String EnquiryDate ){
		this.EnquiryDate=EnquiryDate;
	}

	public void setSignedDateTime(String SignedDateTime ){
		this.SignedDateTime=SignedDateTime;
	}

	public void setSignedverify_remarks(String Signedverify_remarks ){
		this.Signedverify_remarks=Signedverify_remarks;
	}

	public void setSysDateWithoutTime(String sys_date_with_out_time ){
		this.sys_date_with_out_time=sys_date_with_out_time;
	}
	
	public void setEnquirerDetails(ArrayList Enq_Dtl ){
		this.Enq_Dtl=Enq_Dtl;
	}
	
	public void setReqCatgDetails(ArrayList Reqcatg_Dtl ){
		this.Reqcatg_Dtl=Reqcatg_Dtl;
	}

	public void setInfoSrcDetails(ArrayList InfoSrc_Dtl ){
		this.InfoSrc_Dtl=InfoSrc_Dtl;
	}
	
	public String getEnquiryDate(){
		return this.EnquiryDate;
	}
	public ArrayList getEnquirerDetails(){
		return this.Enq_Dtl;
	}
	public ArrayList getReqCatgDetails(){
		return this.Reqcatg_Dtl;
	}
	public ArrayList getInfoSrcDetails(){
		return this.InfoSrc_Dtl;
	}
	public String getSignedBy(){
		return this.SignedBy;
	}

	public String getSignedDateTime(){
		return this.SignedDateTime;
	}
	public String getSignedverify_remarks(){
		return this.Signedverify_remarks;
	}

	public String getMode(){
		return this.mode;
	}
	public int getResp_days(){
		return this.resp_days;
	}
	public int getResp_hours(){
		return this.resp_hours;
	}
	public int getResp_minutes(){
		return this.resp_minutes;
	}
	public String getLoggedInFacility(){
		return login_facility_id;
	}
	public String getSysDateWithoutTime(){
		return sys_date_with_out_time;
	}
	
	public ArrayList getFacilities() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList facilities = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ALT_DISP_LOCN_SELECT1" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				facilities.add(resultSet.getString("FACILITY_ID"));
				facilities.add(resultSet.getString("FACILITY_NAME"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { }
		}
		return facilities;
	}

	public ArrayList getEthnicGrp() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList EthnicGrp = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_AM_ETHNIC_GROUP_SELECT" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				EthnicGrp.add(resultSet.getString("ETHNIC_GROUP_CODE"));
				EthnicGrp.add(resultSet.getString("SHORT_DESC"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { }
		}
		return EthnicGrp;
	}

	public String validatePharmacist() {
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String valid				= "";
		String practype			= null;
		try {
			connection = getConnection() ;
			//this query returns the practioner type
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRACT_SELECT" )) ;
			pstmt.setString(1,login_by_id);
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				practype=resultSet.getString("PRACT_TYPE");
				if (practype.equals("PH"))
					valid="Y";
				else 
					valid="N";
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return "N";
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return valid;
	}

	public String getSysdate(){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String sys_date				= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date=resultSet.getString(1);
				sys_date_with_out_time	= resultSet.getString("SYS_DATE");
				setSysDateWithoutTime(sys_date_with_out_time);
			}
			closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
		}
		catch ( Exception e ) {
			sys_date+=e.toString();
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return sys_date;
	}

	public String getPatientIDLength(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
			}	
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
			pat_txt_length	=e.toString();
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return pat_txt_length;	
	}

	public ArrayList getPatientDtl(String patient_id) {
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList	ptdtls	=	new ArrayList() ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MP_PATIENT_SELECT") ) ;
			pstmt.setString(1,patient_id);
			resultSet	= pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {
				//System.err.println("result 1955");
				ptdtls.add(checkForNull(resultSet.getString("PATIENT_NAME")));
				ptdtls.add(checkForNull(resultSet.getString("AGE")));
				ptdtls.add(checkForNull(resultSet.getString("SEX")));
				ptdtls.add(checkForNull(resultSet.getString("ETHNIC_GRP_CODE")));
			}						
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		//System.err.println("Return result ::"+ptdtls);
		return ptdtls;	

	}

	public ArrayList getPractType(String pract_id) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList pract_type = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_AM_PRACT_TYPE_SELECT" )) ;
			pstmt.setString(1,pract_id);
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				pract_type.add(resultSet.getString("PRACT_TYPE"));
				pract_type.add(resultSet.getString("PRACT_DESC"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		//System.err.println("returned pract_type :;"+pract_type);
		return pract_type;
	}

	public ArrayList getPractType() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList pract_type = new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_AM_PRACT_TYPE_SELECT1" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				pract_type.add(resultSet.getString("PRACT_TYPE"));
				pract_type.add(resultSet.getString("PRACT_DESC"));
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return pract_type;
	}

	public ArrayList getRequestCatg() {
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList	RequestCatg	=	new ArrayList() ;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_REQ_ENQ_SELECT") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {
				RequestCatg.add(checkForNull(resultSet.getString("REQ_CAT_CODE"))+"**"+checkForNull(resultSet.getString("SYSTEM_DEFINED_YN")));
				RequestCatg.add(checkForNull(resultSet.getString("SHORT_DESC")));
				//System.err.println("RequestCatg "+RequestCatg);
			}						
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
				e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return RequestCatg;	

	}

	public String getRespondTime(String resp_date,String enq_date ) {
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		String resp_time			=	"" ;
		int days					=	0;
		int hours					=	0;
		int minutes					=	0;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_DATE_DIFF_SELECT") ) ;
			pstmt.setString(1,resp_date);
			pstmt.setString(2,enq_date);
			resultSet	= pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {
				days=resultSet.getInt("DD");
				hours=resultSet.getInt("HH");
				minutes=resultSet.getInt("MM");
				resp_time=(String)checkForNull(resultSet.getString("FULL"));
    	        setResp_days(days);  
	    		setResp_hours(hours);
			    setResp_minutes(minutes);
    		}						
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return resp_time;	
	}

	public HashMap insertDtl(HashMap  tabData ) {
		HashMap map			= new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "In Insert ") ;
		map.put("msgid","INSERT");

		tabData.put( "login_facility_id", login_facility_id.trim());
		tabData.put( "login_by_id", login_by_id.trim());
		tabData.put( "login_at_ws_no",login_at_ws_no.trim());
		tabData.put( "properties", getProperties());
		tabData.put("Signed_by",getSignedBy());
		tabData.put("Signed_Date_Time",getSignedDateTime());
		tabData.put("Signed_verify_remarks",getSignedverify_remarks());
		tabData.put( "Resp_Days",(getResp_days()+"").toString());
		tabData.put( "Resp_Hrs", (getResp_hours()+"").toString());
		tabData.put( "Resp_Mins",(getResp_minutes()+"").toString());
	
		try{		
			sqlMap.put("SQL_PH_DRUG_ENQ_INFO_HDR_SEQ_NO_SELECT",PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_HDR_SEQ_NO_SELECT"));
			sqlMap.put("SQL_PH_DRUG_ENQ_INFO_HDR_INSERT",PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_HDR_INSERT"));
			sqlMap.put("SQL_PH_DRUG_ENQ_INFO_REQ_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_REQ_DTL_INSERT"));
			sqlMap.put("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_INSERT"));
		

			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_DRUG_INFO_ENQUIRY") ) ;
			home  = (DrugInfoEnquiryHome) PortableRemoteObject.narrow( object, DrugInfoEnquiryHome.class ) ;
			remote = home.create() ;
			HashMap result = remote.insert( tabData, sqlMap ) ;  */
		
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_DRUG_INFO_ENQUIRY" ),DrugInfoEnquiryHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null); 

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				map.put("flag","0");
				setSignedBy("");	
				setSignedDateTime("");
				setResp_days(0);
				setResp_minutes(0);
				setResp_hours(0);
			}
			else{
				map.put( "message", result.get("msgid") ) ;
				map.put("flag","0");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		return map;
	}

	public HashMap getInfoSource() {
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;   
		String flag					= "1";
		String SHORT_DESC			= "";
		String INFO_CAT_CODE		= "";
		String TEMP_INFO_CAT_CODE	= "";
		HashMap InfoDtl				= new HashMap();
		ArrayList	InfoSource	=	new ArrayList() ;
		ArrayList	InfoSourceDtl	=	new ArrayList() ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_INFO_ENQ_HDR_DTL_SELECT") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery();
			
			if( resultSet != null && resultSet.next() ) {
				INFO_CAT_CODE = checkForNull(resultSet.getString("INFO_CAT_CODE"));
				SHORT_DESC = checkForNull(resultSet.getString("SHORT_DESC"));
				TEMP_INFO_CAT_CODE = INFO_CAT_CODE;
				//int i=0;
				while (flag.equals("1")){
					InfoSource.add(INFO_CAT_CODE);
					InfoSource.add(SHORT_DESC);
					while (TEMP_INFO_CAT_CODE.equals(INFO_CAT_CODE) && flag.equals("1")){ 
						InfoSourceDtl.add(checkForNull(resultSet.getString("INFO_CAT_CODE")));
						InfoSourceDtl.add(checkForNull(resultSet.getString("INFO_CODE")));
						InfoSourceDtl.add(checkForNull(resultSet.getString("INFO_DESC")));
						if (resultSet.next()){
							INFO_CAT_CODE = checkForNull(resultSet.getString("INFO_CAT_CODE"));
							SHORT_DESC = checkForNull(resultSet.getString("SHORT_DESC"));
						}
						else{
							flag = "0";		
						}
					}
					TEMP_INFO_CAT_CODE = INFO_CAT_CODE;
				}
			}
			InfoDtl.put("INFO_CAT_CODE",InfoSource);
			InfoDtl.put("INFO_CODE",InfoSourceDtl);
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return InfoDtl;	
	}

	public ArrayList getEnquiryDetails(String enq_date_from,String enq_date_to,String respond_date_from, String respond_date_to,String source,String designation,String priority, String request_mode,String response_status,String verify_yn,String Enq_num,String req_catg){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;      
		String sqlQry			=	"";
		ArrayList	records		=	new ArrayList();
		String Res=validatePharmacist();
		System.err.println("THE RESULT VALUE IS "+Res);
		try{
			connection			= getConnection() ;
			if(req_catg.equals(""))
				sqlQry				= PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_REQ_HDR_SELECT");
			else
				sqlQry				= PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_REQ_HDR_SELECT1");

			if (!verify_yn.equals("*A"))
				sqlQry = sqlQry+"AND NVL (hdr.verified_by, 'NULL') LIKE DECODE (?,'U', 'NULL','V', hdr.verified_by ) ";
			if(!response_status.equals("*A"))
				sqlQry =sqlQry +"AND NVL (hdr.replied_by, 'NULL') LIKE DECODE (?,'P', 'NULL','R', hdr.replied_by ) ";			
			if(designation.equals("O"))
				sqlQry =sqlQry+"AND hdr.enquirer_type_code is null and hdr.enquirer_oth is not null ";	
			
			if(request_mode.equals("O"))
				sqlQry =sqlQry+"AND hdr.request_mode is null and hdr.request_mode_desc is not null ";	
			if(priority.equals("O"))
				sqlQry =sqlQry+"AND hdr.request_priority is null and hdr.request_oth is not null ";	
			if(Res.equals("N"))
				sqlQry =sqlQry+"AND Confidential_YN='N' ";	
			//sqlQry+="order by hdr.enquiry_no desc";
	  
			int k=11;
			pstmt				= connection.prepareStatement(sqlQry);
			pstmt.setString(1,enq_date_from);
			pstmt.setString(2,enq_date_to);
			pstmt.setString(3,respond_date_from);
			pstmt.setString(4,respond_date_to);
			pstmt.setString(5,source); 
			if(!priority.equals("O"))
				pstmt.setString(6,priority); 
			else
				pstmt.setString(6,""); 
			
			if(!designation.equals("O"))
				pstmt.setString(7,designation);
			else
				pstmt.setString(7,"");
			
			if(!request_mode.equals("O"))
				pstmt.setString(8,request_mode); 
			else
				pstmt.setString(8,""); 
			
			pstmt.setString(9,Enq_num); 
			pstmt.setString(10,Enq_num);
			if(!req_catg.equals(""))
				pstmt.setString(k++,req_catg);
			
			if (!verify_yn.equals("*A"))
				pstmt.setString(k++,verify_yn);
			
			if(!response_status.equals("*A"))
				pstmt.setString(k++,response_status);
			
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(checkForNull(resultSet.getString("enquiry_no")));
				records.add(checkForNull(resultSet.getString("enquiry_date_time1")));
				records.add(checkForNull(resultSet.getString("response_date_time1")));
				records.add(checkForNull(resultSet.getString("VERIFIED_BY")));
				records.add(checkForNull(resultSet.getString("SOURCE_OF_REQUEST")));
				records.add(checkForNull(resultSet.getString("SOURCE_OF_REQUEST_DESC")));
				records.add(checkForNull(resultSet.getString("request_priority")));
				records.add(checkForNull(resultSet.getString("req_priority_desc")));
				records.add(checkForNull(resultSet.getString("enquirer_type_code")));
				records.add(checkForNull(resultSet.getString("ENQUIRER_TYPE_DESC")));
				//records.add(checkForNull(resultSet.getString("Confidential_YN")));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}
		catch(Exception e){
			e.printStackTrace();
			records.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;	
	}

	public void EnquirerDetails(String Enq_num){
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;      
		PreparedStatement pstmt1	=	null ;
		ResultSet resultSet1		=	null ;      
		PreparedStatement pstmt2	=	null ;
		ResultSet resultSet2		=	null ;  
		
		String sqlQry				=	"";
		String sqlQry1				=	"";
		String sqlQry2				=	"";
		
		ArrayList	EnquirerDetails		=	new ArrayList();
		ArrayList	ReqCatgDetails		=	new ArrayList();
		ArrayList	InfoSrcDetails		=	new ArrayList();
		try{
			connection			= getConnection() ;
			sqlQry				= PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_REQ_HDR_SELECT2")  ;
			sqlQry1				= PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_REQ_DTL_SELECT1")  ;
			sqlQry2				= PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_SELECT1")  ;
			
			pstmt				= connection.prepareStatement(sqlQry);
			pstmt.setString(1,Enq_num);

			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				EnquirerDetails.add(checkForNull(resultSet.getString("modified_facility_id")));//0
				EnquirerDetails.add(checkForNull(resultSet.getString("source_of_request")));//1
				EnquirerDetails.add(checkForNull(resultSet.getString("enquirer_id")));//2
				EnquirerDetails.add(checkForNull(resultSet.getString("enquirer_name")));//3
				EnquirerDetails.add(checkForNull(resultSet.getString("enquirer_type_code")));//4
				EnquirerDetails.add(checkForNull(resultSet.getString("enquirer_type_desc")));//5
				EnquirerDetails.add(checkForNull(resultSet.getString("enquirer_oth")));//6
				EnquirerDetails.add(checkForNull(resultSet.getString("request_priority")));//7
				EnquirerDetails.add(checkForNull(resultSet.getString("request_oth")));//8

				EnquirerDetails.add(checkForNull(resultSet.getString("enquiry_date_time1")));//9
				setEnquiryDate(checkForNull(resultSet.getString("enquiry_date_time1")));

				EnquirerDetails.add(checkForNull(resultSet.getString("request_mode")));//10
				EnquirerDetails.add(checkForNull(resultSet.getString("contact_addr1")));//11
				EnquirerDetails.add(checkForNull(resultSet.getString("contact_addr2")));//12
				EnquirerDetails.add(checkForNull(resultSet.getString("contact_addr3")));//13
				EnquirerDetails.add(checkForNull(resultSet.getString("contact_addr4")));//14
				EnquirerDetails.add(checkForNull(resultSet.getString("contact_tel")));//15
				EnquirerDetails.add(checkForNull(resultSet.getString("contact_fax")));//16
				EnquirerDetails.add(checkForNull(resultSet.getString("contact_email")));//17

				EnquirerDetails.add(checkForNull(resultSet.getString("reply_addr1")));//18
				EnquirerDetails.add(checkForNull(resultSet.getString("reply_addr2")));//19

				EnquirerDetails.add(checkForNull(resultSet.getString("reply_addr3")));//20
				EnquirerDetails.add(checkForNull(resultSet.getString("reply_addr4")));//21
				EnquirerDetails.add(checkForNull(resultSet.getString("reply_tel")));//22
				EnquirerDetails.add(checkForNull(resultSet.getString("reply_fax")));//23
				EnquirerDetails.add(checkForNull(resultSet.getString("reply_email")));//24
				EnquirerDetails.add(checkForNull(resultSet.getString("request_dtls")));//25
				EnquirerDetails.add(checkForNull(resultSet.getString("enquiry_recd_by")));//26
				EnquirerDetails.add(checkForNull(resultSet.getString("patient_id")));//27
				EnquirerDetails.add(checkForNull(resultSet.getString("patient_name")));//28
				EnquirerDetails.add(checkForNull(resultSet.getString("patient_age")));//29
				EnquirerDetails.add(checkForNull(resultSet.getString("patient_age_unit")));//30
				EnquirerDetails.add(checkForNull(resultSet.getString("patient_gender")));//31
				EnquirerDetails.add(checkForNull(resultSet.getString("patient_ethnic_grp")));//32
				EnquirerDetails.add(checkForNull(resultSet.getString("allergy_drug")));//33
				EnquirerDetails.add(checkForNull(resultSet.getString("allergy_food")));//34
				EnquirerDetails.add(checkForNull(resultSet.getString("allergy_oth")));//35

				EnquirerDetails.add(checkForNull(resultSet.getString("response_dtls")));//36
				EnquirerDetails.add(checkForNull(resultSet.getString("remarks")));//37
				EnquirerDetails.add(checkForNull(resultSet.getString("response_date_time1")));//38
				EnquirerDetails.add(checkForNull(resultSet.getString("replied_by")));//39
				EnquirerDetails.add(checkForNull(resultSet.getString("verified_by")));//40
				EnquirerDetails.add(checkForNull(resultSet.getString("verified_date_time1")));//41
				EnquirerDetails.add(checkForNull(resultSet.getString("responde_days")));//42
				EnquirerDetails.add(checkForNull(resultSet.getString("response_hours")));//43
				EnquirerDetails.add(checkForNull(resultSet.getString("response_minutes")));//44
				EnquirerDetails.add(checkForNull(resultSet.getString("REQUEST_MODE_DESC")));//45
				EnquirerDetails.add(checkForNull(resultSet.getString("SOURCE_OF_REQUEST_DESC")));//46
				EnquirerDetails.add(checkForNull(resultSet.getString("Confidential_YN")));//47
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			setEnquirerDetails(EnquirerDetails);
		
			pstmt1				= connection.prepareStatement(sqlQry1);
			pstmt1.setString(1,Enq_num);
			resultSet1	= pstmt1.executeQuery(); 
			while( resultSet1 != null && resultSet1.next() ) {
				ReqCatgDetails.add(checkForNull(resultSet1.getString("REQUEST_CAT_CODE")));
			} 
			closeResultSet( resultSet1 ) ;
			closeStatement( pstmt1) ;

			setReqCatgDetails(ReqCatgDetails); 
			pstmt2				= connection.prepareStatement(sqlQry2);
			pstmt2.setString(1,Enq_num);
			resultSet2	= pstmt2.executeQuery(); 
			while( resultSet2 != null && resultSet2.next() ) {
				InfoSrcDetails.add(checkForNull(resultSet2.getString("INFO_CATE_CODE")));
				InfoSrcDetails.add(checkForNull(resultSet2.getString("INFO_CODE")));
			}
			setInfoSrcDetails(InfoSrcDetails);
			closeResultSet( resultSet2 ) ;
			closeStatement( pstmt2 ) ;
		}
		catch(Exception e){
			e.printStackTrace();
			EnquirerDetails.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt2 ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	}

	public HashMap updateDtl(HashMap  tabData ) {
	
		HashMap map			= new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "In Modify ") ;
		map.put("msgid","INSERT");

		tabData.put( "login_facility_id", login_facility_id.trim());
		tabData.put( "login_by_id", login_by_id.trim());
		tabData.put( "login_at_ws_no",login_at_ws_no.trim());
		tabData.put( "properties", getProperties());
		tabData.put("Signed_by",getSignedBy());
		tabData.put("prev_enquiry_date",getEnquiryDate());
		tabData.put("Signed_Date_Time",getSignedDateTime());
		tabData.put("Signed_verify_remarks",getSignedverify_remarks());
		tabData.put( "Resp_Days",(getResp_days()+"").toString());
		tabData.put( "Resp_Hrs", (getResp_hours()+"").toString());
		tabData.put( "Resp_Mins",(getResp_minutes()+"").toString());
	
		try{		
			sqlMap.put("SQL_PH_DRUG_ENQ_INFO_HDR_UPDATE",PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_HDR_UPDATE"));
			sqlMap.put("SQL_PH_DRUG_ENQ_INFO_REQ_DTL_DELETE",PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_REQ_DTL_DELETE"));
			sqlMap.put("SQL_PH_DRUG_ENQ_INFO_REQ_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_REQ_DTL_INSERT"));
			sqlMap.put("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_SELECT1",PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_SELECT1"));
			sqlMap.put("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_DELETE",PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_DELETE"));
			sqlMap.put("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_INSERT",PhRepository.getPhKeyValue("SQL_PH_DRUG_ENQ_INFO_SOURCE_DTL_INSERT"));
		
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_DRUG_INFO_ENQUIRY") ) ;
			home  = (DrugInfoEnquiryHome) PortableRemoteObject.narrow( object, DrugInfoEnquiryHome.class ) ;
			remote = home.create() ;
			HashMap result = remote.modify( tabData, sqlMap ) ;
			//object.getClass().getMethod("remove", null).invoke(object, null);			*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_DRUG_INFO_ENQUIRY" ),DrugInfoEnquiryHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			HashMap result = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH") ) ;
				map.put("flag","0");
			}
			else{
				map.put( "message", result.get("msgid") ) ;
				map.put("flag","0");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		return map;
	}
	
    public ArrayList getQuickLinkDesc(String resp_id){ //Added New Method for  Bru-HIMS-CRF-078 [IN:029944] - Start
	   	Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet		=	null ;      
		String sqlQry			=	"";
		ArrayList getList = new ArrayList();
		try{
			connection		= getConnection() ;		
		
			sqlQry			= "SELECT B.QUICK_LINK_DESCRIPTION, B.EXTERNAL_URL_APPL FROM SM_QUICK_LINK_RESP A,SM_QUICK_LINK_LIST B WHERE A.QUICK_LINK_REF = B.QUICK_LINK_REF AND A.RESP_ID = ? AND A.LINK_TYPE = ? AND B.EFF_STATUS=? AND B.GLOBAL_YN=? and  B.QUICK_LINK_TYPE='EX'";
			pstmt			= connection.prepareStatement(sqlQry);
			if(resp_id!=null && !resp_id.equals("") )
			    pstmt.setString(1,resp_id);
			else
			    pstmt.setString(1,"PH");
			
			pstmt.setString(2,"Q");
			pstmt.setString(3,"E");
			pstmt.setString(4,"Y");

			resultSet		= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
			    if(resultSet.getString(1)!=null && !resultSet.getString(1).equals("") && (resultSet.getString(2)!=null && !resultSet.getString(2).equals("") )){
				    getList.add(checkForNull(resultSet.getString("QUICK_LINK_DESCRIPTION")));
					getList.add(checkForNull(resultSet.getString("EXTERNAL_URL_APPL")));
			    }
			}
		}
		catch ( Exception e ) {
		    e.printStackTrace() ;
		}
		finally{
		    try{
				pstmt.close();
				resultSet.close();
				connection.close();
		    }
			catch(Exception e1){
				e1.printStackTrace();
		    }
		}
	    return getList;
    } //Added New Method for  Bru-HIMS-CRF-078 [IN:029944] - End
	
	public String getFacilityName(String facility_id) throws Exception{ //code added for IN:048274 --Start
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String facility_name	= "";	
		try {
            connection	= getConnection() ;           
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT10")) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				facility_name = resultSet.getString("FACILITY_NAME");
			}			
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return facility_name;
	}//code added for IN:048274 --End

  public HashMap getPractDetails(String login_user) throws Exception{ //code added for IN:049077 --Start
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		HashMap pract_details	= new HashMap();	
		try {
            connection	= getConnection() ;           
			pstmt		= connection.prepareStatement("SELECT p.PRACTITIONER_ID, p.PRACTITIONER_NAME FROM AM_PRACTITIONER_LANG_VW p, sm_appl_user a WHERE p.PRACTITIONER_ID = a.func_role_id and a.APPL_USER_ID=? and p.LANGUAGE_ID = ? ") ;
			pstmt.setString(1,login_user);
			pstmt.setString(2,getLanguageId());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				pract_details.put("LOGIN_PRACT_ID",checkForNull(resultSet.getString("PRACTITIONER_ID")));
				pract_details.put("LOGIN_PRACT_NAME",checkForNull(resultSet.getString("PRACTITIONER_NAME")));
			}			
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return pract_details;
	}//code added for IN:049077 --End
}
