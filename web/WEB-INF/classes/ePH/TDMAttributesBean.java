/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved  on 08/11/2005
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
//import javax.rmi.* ;
//import javax.naming.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;
import ePH.TDMAttributes.*;

public class TDMAttributesBean extends PhAdapter implements Serializable {

	HashMap samplingTypes    = new HashMap();
	HashMap tempsamplingTypes    = new HashMap();
	HashMap finalsamplingTypes    = new HashMap();
	HashMap samplingDetails	= new HashMap();
	ArrayList selectrecord	= new ArrayList();
	ArrayList temprecords= new ArrayList();


	String drugCode	="";
	String ageGrp	="";
	String minAge		="";
	String maxAge		="";
	String gender			="";
	String ageUnit		="";
	String steadyState="";
	String steadyStateType="";
	String peakSampleTime="";
	String troughSampleTime="";
	String extendSampleTime="";
	String peakSampleTimeType="";
	String troughSampleTimeType="";
	String extendSampleTimeType="";
	String peakFlag="";
	String troughFlag="";
	String extendFlag="";
	String randomFlag="";
	
	protected String peakremarks="";
	protected String troughremarks="";
	protected String extendremarks="";
	protected String randomremarks="";

	public TDMAttributesBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
		samplingTypes  = new HashMap();
		tempsamplingTypes  = new HashMap();
		finalsamplingTypes  = new HashMap();
		samplingDetails	= new HashMap();
		peakremarks="";
		troughremarks="";
		extendremarks="";
		randomremarks="";
	}

	//Start of Set methods.
	public void setDrugCode(String drugCode){
		this.drugCode=drugCode;
	}
	
	public void setAgeGrp(String ageGrp){
		this.ageGrp=ageGrp;
	}
	public void setMinAge(String minAge){
		this.minAge=minAge;
	}
	public void setMaxAge(String maxAge){
		this.maxAge=maxAge;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public void setAgeUnit(String ageUnit){
		this.ageUnit=ageUnit;
	}
	public void setSteadyState(String steadyState){
		this.steadyState=steadyState;
	}
	public void setSteadyStateType(String steadyStateType){
		this.steadyStateType=steadyStateType;
	}

	public void setPeakSampleTime(String peakSampleTime){
		this.peakSampleTime=peakSampleTime;
	}
	public void setPeakSampleTimeType(String peakSampleTimeType){
		this.peakSampleTimeType=peakSampleTimeType;
	}

	public void setTroughSampleTime(String troughSampleTime){
		this.troughSampleTime=troughSampleTime;
	}
	public void setTroughSampleTimeType(String troughSampleTimeType){
		this.troughSampleTimeType=troughSampleTimeType;
	}
	public void setExtendSampleTime(String extendSampleTime){
		this.extendSampleTime=extendSampleTime;
	}
	public void setExtendSampleTimeType(String extendSampleTimeType){
		this.extendSampleTimeType=extendSampleTimeType;
	}

	public void setPeakFlag(String peakFlag ){
		this.peakFlag=peakFlag;
	}
	public void setTroughFlag(String troughFlag ){
		this.troughFlag=troughFlag;
	}
	public void setExtendFlag(String extendFlag ){
		this.extendFlag=extendFlag;
	}
	public void setRandomFlag(String randomFlag ){
		this.randomFlag=randomFlag;
	}
	
	public void setPeakRemarks(String peakremarks ){
		
		this.peakremarks=peakremarks;
	}
	public void setTroughRemarks(String troughremarks ){
		this.troughremarks=troughremarks;
	}
	public void setExtendRemarks(String extendremarks ){
		this.extendremarks=extendremarks;
	}
	public void setRandomRemarks(String randomremarks ){
		this.randomremarks=randomremarks;
	}







	//End of Set methods
	//Start of Get methods
	public String getDrugCode(){
		return this.drugCode;
	}
	
	public String getAgeGrp(){
		return this.ageGrp;
	}
	public String getMinAge(){
		return this.minAge;
	}
	public String getMaxAge(){
		return this.maxAge;
	}
	public String getAgeUnit(){
		return this.ageUnit;
	}
	public String getGender(){
		return this.gender;
	}
	public String getSteadyState(){
		return this.steadyState;
	}
	public String getSteadyStateType(){
		return this.steadyStateType;
	}
	
	public String getPeakSampleTime(){
		return this.peakSampleTime;
	}
	public String getPeakSampleTimeType(){
		return this.peakSampleTimeType;
	}

	public String getTroughSampleTime(){
		return this.troughSampleTime;
	}
	public String getTroughSampleTimeType(){
		return this.troughSampleTimeType;
	}
	public String getExtendSampleTime(){
		return this.extendSampleTime;
	}
	public String getExtendSampleTimeType(){
		return this.extendSampleTimeType;
	}

	public String getPeakFlag(){
		return this.peakFlag;
	}
	public String getTroughFlag(){
		return this.troughFlag;
	}
	public String getExtendFlag(){
		return this.extendFlag;
	}
	public String getRandomFlag(){
		return this.randomFlag;
	}

	public String getPeakRemarks()
	{
		return peakremarks;
	}
	public String getTroughRemarks(){
	  return troughremarks;
	}
	public String getExtendRemarks(){
		return extendremarks;
	}
	public String getRandomRemarks(){
	   return this.randomremarks;
	}
   
//End of Get methods	

	//Validate Method
	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}
 //SetAll method
	public void setAll( Hashtable recordSet ) {

		if(recordSet.containsKey("mode"))
			setMode(CommonRepository.getCommonKeyValue("MODE_INSERT")) ;
		if(recordSet.containsKey("drugCode"))
			setDrugCode((String)recordSet.get("drugCode")) ;
		if(recordSet.containsKey("ageGrp"))
			setAgeGrp((String)recordSet.get("ageGrp")) ;

		setSteadyState((String)recordSet.get("steadyState")) ;

		if(recordSet.containsKey("steadyStateType"))
			setSteadyStateType((String)recordSet.get("steadyStateType"));
		if(recordSet.containsKey("peakSampleTime"))
			setPeakSampleTime((String)recordSet.get("peakSampleTime"));
		if(recordSet.containsKey("peakSampleTimeType"))
			setPeakSampleTimeType((String)recordSet.get("peakSampleTimeType")) ;
		if(recordSet.containsKey("troughSampleTime"))
			setTroughSampleTime((String)recordSet.get("troughSampleTime")) ;
		if(recordSet.containsKey("troughSampleTimeType"))
			setTroughSampleTimeType((String)recordSet.get("troughSampleTimeType"));
		if(recordSet.containsKey("extendSampleTime"))
			setExtendSampleTime((String)recordSet.get("extendSampleTime"));
		if(recordSet.containsKey("extendSampleTimeType"))
			setExtendSampleTimeType((String)recordSet.get("extendSampleTimeType"));
		if(recordSet.containsKey("peakFlag"))
			setPeakFlag((String)recordSet.get("peakFlag"));
		if(recordSet.containsKey("troughFlag"))
			setTroughFlag((String)recordSet.get("troughFlag"));
		if(recordSet.containsKey("extendFlag"))
			setExtendFlag((String)recordSet.get("extendFlag"));
		if(recordSet.containsKey("randomFlag"))
			setRandomFlag((String)recordSet.get("randomFlag"));
	}

	//Insert Method
	public HashMap insert() {
		
//		int flag=0;
		HashMap map=new HashMap();
		map.put( "result", new Boolean( false ) ) ;
        map.put("flag", "0");
		HashMap commonData = new HashMap() ;
		commonData.put("drugCode",drugCode);
		commonData.put("ageGrp",ageGrp);

		commonData.put("steadyState",steadyState);
		commonData.put("steadyStateType",steadyStateType);
		commonData.put("peakSampleTime",peakSampleTime);
		commonData.put("peakSampleTimeType",peakSampleTimeType);
		commonData.put("troughSampleTime",troughSampleTime);
		commonData.put("troughSampleTimeType",troughSampleTimeType);
		commonData.put("extendSampleTime",extendSampleTime);
		commonData.put("extendSampleTimeType",extendSampleTimeType);

		commonData.put("peakFlag",peakFlag);
		commonData.put("troughFlag",troughFlag);
		commonData.put("extendFlag",extendFlag);
		commonData.put("randomFlag",randomFlag);

		commonData.put( "login_by_id",			login_by_id ) ;
		commonData.put( "login_at_ws_no",		login_at_ws_no ) ;
		commonData.put( "login_facility_id",	login_facility_id ) ;

	    commonData.put( "peakremarks",          peakremarks ) ;
        commonData.put( "troughremarks",        troughremarks ) ;
        commonData.put( "extendremarks",        extendremarks ) ;
        commonData.put( "randomremarks",        randomremarks ) ;


		HashMap tabData = new HashMap() ;
		try{
			tabData.put( "COMMONDATA", commonData ) ;
			tabData.put( "INSERTDATA", finalsamplingTypes ) ;
			tabData.put( "properties", getProperties());
			String SQL_PH_TDM_INSERT1="INSERT INTO PH_TDM_ATTR (DRUG_CODE, AGE_GROUP_CODE, STEADY_STATE_DURN, STEADY_STATE_DURN_TYPE, SAMPLING_TYPE, SAMPLING_TIME, SAMPLING_TIME_DURN_TYPE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,TDM_ATTR_REMARKS) VALUES(?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?)";
			HashMap sqlMap = new HashMap() ;
			try {
				//sqlMap.put( "INSERTSQL1", PhRepository.getPhKeyValue( "SQL_PH_TDM_INSERT1" ) ) ;
				sqlMap.put( "INSERTSQL1",SQL_PH_TDM_INSERT1) ;
				sqlMap.put( "INSERTSQL2", PhRepository.getPhKeyValue( "SQL_PH_TDM_INSERT2" ) );
				sqlMap.put( "DELETESQL1", PhRepository.getPhKeyValue( "SQL_PH_TDM_DELETE1" ) ) ;
				sqlMap.put( "DELETESQL2", PhRepository.getPhKeyValue( "SQL_PH_TDM_DELETE2" ) );
			}catch(Exception e){
				e.printStackTrace() ;
			}
	
		
			/*TDMAttributesHome home = null;
			TDMAttributesRemote remote = null;

			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_TDM_ATTRIBUTES")) ;
			home  = (TDMAttributesHome) PortableRemoteObject.narrow( object, TDMAttributesHome.class ) ;
			remote = home.create() ;
			map = remote.insert( tabData, sqlMap ) ;*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TDM_ATTRIBUTES" ),TDMAttributesHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		}catch(Exception e)	{
			map.put("flag",e.toString());	
		}
		try {
		   if( ((Boolean) map.get( "result" )).booleanValue() ){
			map.put( "message", getMessage(getLanguageId(),(String) map.get( "message" ),"PH") ) ;
		   }
			else{
			map.put( "message", (map.get("message"))) ;
			}
		} catch(Exception e) {
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		} 
		return map;
	}
	
//Modify Method
	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put("flag", "0");
		return map ;
	}
	

	//	Get the Age Group Related Information(AGE_GROUP_CODE,SHORT_DESC,GENDER,AGE_UNIT,MIN_AGE,MAX_AGE) on load of the screen...
	public ArrayList getAgeGroupRelatedInfo() throws Exception	{
		Connection connection		  =	null ;
		PreparedStatement pstmt		  =	null ;
		ResultSet resultSet			  =	null ;

		ArrayList records				  =	new ArrayList();
		try {
			String[] strArr		 =   new String[7];
			String gender		 =    "";	
			connection			 =	  getConnection() ;
			pstmt				 =	  connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_SELECT2") );
			pstmt.setString(1,getLanguageId());
			resultSet			 =	  pstmt.executeQuery() ;
			while ( resultSet.next() ){
                strArr		        =  new String[7];  	
				strArr[0]			=	resultSet.getString("AGE_GROUP_CODE");
				strArr[1]			=	resultSet.getString("SHORT_DESC");
				
				gender=resultSet.getString("GENDER");
				if(gender==null||gender.equals("")){
                  gender="All";
				}
                strArr[2]			=	gender;

				strArr[3]			=	resultSet.getString("AGE_UNIT");
				strArr[4]			=	resultSet.getString("MIN_AGE");
				strArr[5]			=	resultSet.getString("MAX_AGE");
				strArr[6]			=	resultSet.getString("AGE_UNIT_MAX");
				
				records.add(strArr);
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return records;
	}

//	Get the List of Order Catalog Information(CODE,SHORT_DESC) on load of the screen...
	public ArrayList getLabOrders(){
		Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList labOrdersArraylist =		new ArrayList();
			try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TDM_SELECT2" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet      = pstmt.executeQuery() ;

			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("ORDER_CATALOG_CODE");
				desc					=	resultSet.getString("SHORT_DESC");
				rec.put("code",code);
				rec.put("desc",desc);
				rec.put("flag","N");
				labOrdersArraylist.add(rec);
			}
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
		return labOrdersArraylist;
	}

	public ArrayList searchLabOrders(String sqlData){
		Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		String sql_query="";
		ArrayList labOrdersArraylist1 =		new ArrayList();
		
		try {
			
			 sql_query="SELECT ORDER_CATALOG_CODE,SHORT_DESC FROM  OR_ORDER_CATALOG_LANG_VW WHERE language_id=? and ORDER_CATEGORY='LB' AND EFF_STATUS='E' "+ sqlData;
			
			connection	 = getConnection() ;
			pstmt				= connection.prepareStatement(sql_query) ;
			pstmt.setString(1, getLanguageId());
			resultSet      = pstmt.executeQuery() ;
			while (resultSet.next()) {
				HashMap rec1	=	new HashMap();
				String code1,desc1;
				code1				=	resultSet.getString("ORDER_CATALOG_CODE");
				desc1				=	resultSet.getString("SHORT_DESC");
				rec1.put("code",code1);
				rec1.put("desc",desc1);
				rec1.put("flag","N");
				labOrdersArraylist1.add(rec1);
			}
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
		return labOrdersArraylist1;
	}

//Set the list of Order Catalog corresponding  to the Sampe Type
	public void  setSelectLabOrder(String code,String desc,String flag,String sampleType){
		int found								  =	0	;
		HashMap record				  =	null;
		temprecords = null;
		temprecords =(ArrayList) tempsamplingTypes.get(sampleType);
		if(temprecords == null){
			temprecords = new ArrayList();
		}
		if(flag.equals("Y")){
			record = new HashMap();
			record.put("code",code);
			record.put("desc",desc);
			record.put("flag",flag);
			temprecords.add(record);
		}
		else{
			for(int i=0; i<temprecords.size(); i++){
				record =  (HashMap)temprecords.get(i);
				if( ((String)record.get("code")).equals(code)) {
					record.put("flag",flag);
					found=i;
					break;
				}
			}
			temprecords.remove(found);
		}
		tempsamplingTypes.put(sampleType, temprecords);
	}

//modified on 2/11/2006
	public void  setSelectLabOrderFinal(String sample){
		if(tempsamplingTypes.get(sample) != null)
			finalsamplingTypes.put(sample,new ArrayList((ArrayList)tempsamplingTypes.get(sample)));
		//tempsamplingTypes = finalsamplingTypes;
	}
		
	public void  setSelectLabOrderReset(String sample){		
		//tempsamplingTypes=new HashMap(finalsamplingTypes);
		tempsamplingTypes.put(sample, (ArrayList)finalsamplingTypes.get(sample));
	}

//Get the list of OrderCatalog corresponding to Sample Type
	public ArrayList getSelectedOrderList(String sampleType, String called_from){
		ArrayList selectedRecords = null;
		if(tempsamplingTypes.containsKey(sampleType)) {
			if(called_from.equals("Result")){
				selectedRecords=(ArrayList)finalsamplingTypes.get(sampleType);
			}
			else{
				selectedRecords=(ArrayList)tempsamplingTypes.get(sampleType);
			}
		}
		return selectedRecords;
	}

	public ArrayList getSelectedOrderList12(String sampleType){

		ArrayList selectrecord = null;
		if(samplingTypes.containsKey(sampleType)) {
			selectrecord=(ArrayList)samplingTypes.get(sampleType);
		}
		return selectrecord;
	}

//Clear the corresponding sampletype list
	public void clearSampleList(String sampleType){
		
		if(samplingTypes.containsKey(sampleType)) {
			samplingTypes.remove(sampleType);
		}
	}

//Check for duplicate insertion at the header level table
	public int checkforvalid(String drugCode,String ageGrpCode){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		int flag										 =		0;
		int count									 =		0;

		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TDM_SELECT3" )) ;
			pstmt.setString(1,drugCode);
			pstmt.setString(2,ageGrpCode);
			resultSet      = pstmt.executeQuery() ;
			if(resultSet.next()){
				 count	    =	resultSet.getInt("COUNT");
			}
			if(count>0)
				flag=1;
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
			return flag;
	}

//this method is used check age range overlapping
	public String CheckForOverlap(String drug_code,String age_group_code){
	    Connection connection			 =		null ;
		PreparedStatement pstmt1		 =		null ;
		ResultSet resultSet1			 =		null ;
		PreparedStatement pstmt			=		null ;
		ResultSet resultSet				 =		null ;
		//int flag						 =		0;
		String exists_yn				 =		"N";
		int  min_age_in_Days			 =		0;	
		int max_age_in_Days				 =		0;	
		String gender					 =		"";	

		try {
			connection			= getConnection() ;
			pstmt			    = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_LIMIT_HDR_SELECT2" )) ;
			pstmt.setString(1,age_group_code);
			resultSet      = pstmt.executeQuery() ;
			if(resultSet.next()){
				min_age_in_Days	    =	resultSet.getInt("MIN_AGE_IN_DAYS");
				max_age_in_Days	    =	resultSet.getInt("MAX_AGE_IN_DAYS");
				gender				=	resultSet.getString("SEL_GENDER");
			}


			pstmt1	 = connection.prepareStatement("SELECT 'Y'  EXISTS_YN FROM DUAL WHERE EXISTS ( SELECT 1 FROM AM_AGE_GROUP WHERE AGE_GROUP_CODE IN (SELECT DISTINCT AGE_GROUP_CODE FROM PH_TDM_ATTR WHERE DRUG_CODE = ? AND AGE_GROUP_CODE != ?) AND ( ( (? IS NULL) OR ( ? IS NOT NULL AND ( GENDER IS NULL OR GENDER = ? ))) AND ( ? BETWEEN MIN_AGE * DECODE(AGE_UNIT,'D',1,'M',30,'Y',360) AND MAX_AGE * DECODE(AGE_UNIT_MAX,'D',1,'M',30,'Y',360) OR ?  BETWEEN MIN_AGE * DECODE(AGE_UNIT,'D',1,'M',30,'Y',360) AND MAX_AGE * DECODE(AGE_UNIT_MAX,'D',1,'M',30,'Y',360) OR min_age * DECODE (age_unit,'D', 1,'M', 30,'Y', 360) BETWEEN ? AND ? OR max_age * DECODE (age_unit_max,'D',1,'M',30,'Y',360) BETWEEN ? AND ? )))") ;
			pstmt1.setString(1,drug_code.trim());
			pstmt1.setString(2,age_group_code.trim());
			pstmt1.setString(3,gender.trim());
			pstmt1.setString(4,gender.trim());
			pstmt1.setString(5,gender.trim());
			pstmt1.setInt(6,min_age_in_Days);
			pstmt1.setInt(7,max_age_in_Days);
			pstmt1.setInt(8,min_age_in_Days);
			pstmt1.setInt(9,max_age_in_Days);
			pstmt1.setInt(10,min_age_in_Days);
			pstmt1.setInt(11,max_age_in_Days);	



			resultSet1      = pstmt1.executeQuery() ;
			
			if(resultSet1.next()){
				 exists_yn	    =	resultSet1.getString("EXISTS_YN");
				
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1 ) ;
				closeConnection( connection );
			}catch(Exception es) { 
				es.printStackTrace() ;
			}
	   }	
	   return exists_yn;
	}

//Get the details from the header level table corresponding to drugcode and agegroupcode

	public HashMap loadHeaderValues(String drugCode,String ageGrpCode){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		HashMap result						= new HashMap();
		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TDM_SELECT6" )) ;

			pstmt.setString(1,drugCode);
			pstmt.setString(2,ageGrpCode);
			pstmt.setString(3,getLanguageId());
			resultSet      = pstmt.executeQuery() ;
			if(resultSet.next()){
			result.put("drugCode",resultSet.getString("DRUG_CODE"));
			result.put("ageGrpCode",resultSet.getString("AGE_GROUP_CODE"));
			result.put("minAge",resultSet.getString("MIN_AGE"));
			result.put("maxAge",resultSet.getString("MAX_AGE"));
			result.put("ageUnit",resultSet.getString("AGE_UNIT"));
			result.put("maxageUnit",resultSet.getString("age_unit_max"));
			result.put("gender",resultSet.getString("GENDER"));
			result.put("steadyState",resultSet.getString("STEADY_STATE_DURN"));
			result.put("steadyStateType",resultSet.getString("STEADY_STATE_DURN_TYPE"));
			result.put("drugDesc",resultSet.getString("DRUG_DESC"));
			}
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
		return result;
	}

//Get the details from the detailed table corresponding to the drugcode and agegroupcode
	public ArrayList loadIntialValues(String drugCode,String ageGrpCode){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		HashMap result						 =		null;
		ArrayList records					 =		new ArrayList();
		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TDM_SELECT7" )) ;

			pstmt.setString(1,drugCode);
			pstmt.setString(2,ageGrpCode);
			pstmt.setString(3,getLanguageId());
			resultSet      = pstmt.executeQuery() ;
			while(resultSet.next()){
				result						 =		new HashMap();
			result.put("samplingType",resultSet.getString("SAMPLING_TYPE"));
			result.put("orderCatalogCode",resultSet.getString("ORDER_CATALOG_CODE"));
			result.put("orderCatalogDesc",resultSet.getString("SHORT_DESC"));
			records.add(result);
			}
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
		return records;
	}

//Get the details of the SamplingTime and SamplingTimeType corresponding to SamplingType 
	public HashMap loadSampleDetails(String drugCode,String ageGrpCode){
	    Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		HashMap result						 =		null;
		try {
			connection	 = getConnection() ;
			//pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TDM_SELECT8" )) ;
			pstmt			 = connection.prepareStatement("SELECT  SAMPLING_TYPE,SAMPLING_TIME, SAMPLING_TIME_DURN_TYPE,TDM_ATTR_REMARKS FROM PH_TDM_ATTR WHERE DRUG_CODE=? AND AGE_GROUP_CODE=?") ;

			pstmt.setString(1,drugCode);
			pstmt.setString(2,ageGrpCode);
			resultSet      = pstmt.executeQuery() ;
			while(resultSet.next()){
				result						 =		new HashMap();
				String sampleType	=resultSet.getString("SAMPLING_TYPE");
				result.put("samplingTime",resultSet.getString("SAMPLING_TIME"));
				result.put("samplingTimeType",resultSet.getString("SAMPLING_TIME_DURN_TYPE"));
				result.put("tdmattrremarks",resultSet.getString("TDM_ATTR_REMARKS")==null?"":resultSet.getString("TDM_ATTR_REMARKS"));
				samplingDetails.put(sampleType,result);
			}
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
		return samplingDetails;
	}

	//Set the SamplingTime and SamplingTimeType corresponding to SampleType
	public void setSamplingDetails(String sampleType,String sampleTime,String sampleTimeType){
		clearSamplingDetails(sampleType);
		HashMap result						 =		new HashMap();
		result.put("samplingTime",sampleTime);
		result.put("samplingTimeType",sampleTimeType);
		samplingDetails.put(sampleType,result);
		
	}

	//Returns the SamplingTimeDetails
	public HashMap getSamplingDetails(){
		return samplingDetails;
	}

	//Clears the SamplingTimeDetails corresponding to SampleType
	public void clearSamplingDetails(String sampleType){
		if(samplingDetails.containsKey(sampleType)) {
				samplingDetails.remove(sampleType);
		}
	}
 }
