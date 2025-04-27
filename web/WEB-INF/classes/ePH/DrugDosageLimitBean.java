/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law. 
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
26/06/2019	IN:070451        Haribabu	     								ML-MMOH-CRF-1408
--------------------------------------------------------------------------------------------------------------------
*/ 

package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class DrugDosageLimitBean extends PhAdapter implements Serializable {

	protected String drug_code				= "" ;
	protected String age_group_code			= "" ;
	protected String low_of_unit_dosage		= "" ;
	protected String high_of_unit_dosage	= "";
	protected String low_celling_of_unit_dosage		= "" ;//Added for IN:070451
	protected String high_celling_of_unit_dosage	= "";//Added for IN:070451
	protected String std_unit_dosage		= "";
	protected String low_of_daily_dosage	= "";
	protected String high_of_daily_dosage	= "";
	protected String low_celling_of_daily_dosage	= "";//Added for IN:070451
	protected String high_celling_of_daily_dosage	= "";//Added for IN:070451
	protected String monograph				= "";
	protected String limit_ind				= "";
	protected String calc_dosage_by			= "";
	protected String std_unit				= "";

    //new variables
	protected String age_unit				= "";
	protected String gender 				= "";
	protected String min_age				= "";
	protected String max_age				= "";
	//finished

	//get methods

	public String getDrugCode(){
		return this.drug_code;
	}
	public String getAgeGroupCode(){
		return this.age_group_code;
	}
	public String getLowOfUnitDosage(){
		return this.low_of_unit_dosage;
	}
	public String getHighOfUnitDosage(){
		return this.high_of_unit_dosage;
	}
	public String getLowOfDailyDosage(){
		return this.low_of_daily_dosage;
	}
	public String getHighOfDailyDosage(){
		return this.high_of_daily_dosage;
	}
	public String getMonograph(){
		return this.monograph;
	}
	public String getLimitInd(){
		return this.limit_ind;
	}

	public String getStandardUnitDose(){
		return this.std_unit_dosage;
	}

	public String getStandardUnit(){
		return this.std_unit;
	}

	public String getCalculateDosageBy(){
		return this.calc_dosage_by;
	}

	//new changes
	public String getMinAge(){
        return this.min_age;
	}
	public String getMaxAge(){
        return this.max_age;
	}
	public String getGender(){
        return this.gender;
	}
	public String getAgeUnit(){
        return this.age_unit;
	}
	//Added for IN:070451 Start
	public String getLowCellingOfUnitDosage(){
		return this.low_celling_of_unit_dosage;
	}
	public String getHighCellingOfUnitDosage(){
		return this.high_celling_of_unit_dosage;
	}
	public String getLowCellingOfDailyDosage(){
		return this.low_celling_of_daily_dosage;
	}
	public String getHighCellingOfDailyDosage(){
		return this.high_celling_of_daily_dosage;
	}
	//Added for IN:070451 end
	//finished
	

	//set methods
	public void setDrugCode(String drug_code){
		this.drug_code=drug_code;
	}
	public void setAgeGroupCode(String age_group_code){
		this.age_group_code=age_group_code;
	}
	public void setLowOfUnitDosage(String low_of_unit_dosage){
		this.low_of_unit_dosage=low_of_unit_dosage;
	}
	public void setHighOfUnitDosage(String high_of_unit_dosage){
		this.high_of_unit_dosage=high_of_unit_dosage;
	}

	public void setStandardUnitDose(String std_unit_dosage){
		this.std_unit_dosage=std_unit_dosage;
	}

	public void setStandardUnit(String std_unit){
		this.std_unit=std_unit;
	}

	public void setLowOfDailyDosage(String low_of_daily_dosage){
		this.low_of_daily_dosage=low_of_daily_dosage;
	}
	//new changes
	public void setMinAge(String min_age){
		this.min_age=min_age;
	}
	public void setMaxAge(String max_age){
		this.max_age=max_age;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public void setAgeUnit(String age_unit){
		this.age_unit=age_unit;
	}
	//finished

	public void setHighOfDailyDosage(String high_of_daily_dosage){
		this.high_of_daily_dosage=high_of_daily_dosage;
	}
	public void setCalculateDosageBy(String calc_dosage_by){
		this.calc_dosage_by=calc_dosage_by;
	}

	public void setMonograph(String monograph){
		this.monograph=monograph;
	}
	public void setLimitInd(String limit_ind){
		this.limit_ind=limit_ind;
	}
	//Added for IN:070451 start
	public void setLowCellingOfUnitDosage(String low_celling_of_unit_dosage){
		this.low_celling_of_unit_dosage=low_celling_of_unit_dosage;
	}
	public void setHighCellingOfUnitDosage(String high_celling_of_unit_dosage){
		this.high_celling_of_unit_dosage=high_celling_of_unit_dosage;
	}
	public void setHighCellingOfDailyDosage(String high_celling_of_daily_dosage){
		this.high_celling_of_daily_dosage=high_celling_of_daily_dosage;
	}
	public void setLowCellingOfDailyDosage(String low_celling_of_daily_dosage){
		this.low_celling_of_daily_dosage=low_celling_of_daily_dosage;
	}
	//Added for IN:070451 end

	public DrugDosageLimitBean() 
	{
        try 
		{
            doCommon();
        }
        catch(Exception e) 
		{
			System.out.println("Exception in constructor"+e.toString());
		}
    }

    public void clear() {
        super.clear() ;
    }

    private void doCommon() throws Exception {
    }

	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		if(recordSet.containsKey("drug_code"))
			setDrugCode((String)recordSet.get("drug_code")) ;
		if(recordSet.containsKey("age_group_code"))
			setAgeGroupCode((String)recordSet.get("age_group_code")) ;
		if(recordSet.containsKey("low_of_unit_dosage"))
			setLowOfUnitDosage((String)recordSet.get("low_of_unit_dosage")) ;
		if(recordSet.containsKey("high_of_unit_dosage"))
			setHighOfUnitDosage((String)recordSet.get("high_of_unit_dosage")) ;
		if(recordSet.containsKey("low_of_daily_dosage"))
			setLowOfDailyDosage((String)recordSet.get("low_of_daily_dosage")) ;
		if(recordSet.containsKey("high_of_daily_dosage"))
			setHighOfDailyDosage((String)recordSet.get("high_of_daily_dosage")) ;
		if(recordSet.containsKey("monograph"))
			setMonograph((String)recordSet.get("monograph")==""?".":(String)recordSet.get("monograph")) ;//Added . for ML-MMOH-SCF-0863

		if (recordSet.containsKey("limit_ind")){
			setLimitInd((String)recordSet.get("limit_ind")) ;
		}
		if (recordSet.containsKey("std_unit_dosage")){
			setStandardUnitDose((String)recordSet.get("std_unit_dosage")) ;
		}
		if (recordSet.containsKey("std_unit")){
			setStandardUnit((String)recordSet.get("std_unit")) ;
		}
		if (recordSet.containsKey("calc_dosage_by")){
			setCalculateDosageBy((String)recordSet.get("calc_dosage_by")) ;
		}

		//new changes
		if(recordSet.containsKey("min_age")){
			setMinAge((String)recordSet.get("min_age"));
		}

		if(recordSet.containsKey("max_age")){
			setMaxAge((String)recordSet.get("max_age"));
		}

		if(recordSet.containsKey("gender")){
			 gender=(String)recordSet.get("gender");
			if(gender.equalsIgnoreCase("Male")){
				gender="M";
			}
			else if(gender.equalsIgnoreCase("Female"))
			{
				gender="F";
			}
			else if(gender.equalsIgnoreCase("Unknown"))
			{
				gender="U";

			}

			setGender((String)gender);

		}

	if(recordSet.containsKey("age_unit")){
         age_unit=(String)recordSet.get("age_unit");

			if(age_unit.equals("Days")){
				age_unit="D";
            }
			else if(age_unit.equalsIgnoreCase("Weeks")){
				age_unit="W";
			}
			else if(age_unit.equalsIgnoreCase("Months")){
				age_unit="M";
			}
	    	else if(age_unit.equalsIgnoreCase("Years")){
				age_unit="Y";
		
			}else if(age_unit.equalsIgnoreCase("Hours")){//Added for ML-MMOH-SCF-1974
				age_unit="H";
		
			}
			else if(age_unit.equalsIgnoreCase("Minutes")){
				 age_unit="N";
		
			}//Adding end for ML-MMOH-SCF-1974
				setAgeUnit((String)age_unit);
		//finished
		}
		//Added for IN:070451 start
	if(recordSet.containsKey("low_celling_of_unit_dosage"))
		setLowCellingOfUnitDosage((String)recordSet.get("low_celling_of_unit_dosage")) ;
	if(recordSet.containsKey("high_celling_of_unit_dosage"))
		setHighCellingOfUnitDosage((String)recordSet.get("high_celling_of_unit_dosage")) ;
	if(recordSet.containsKey("low_celling_of_daily_dosage"))
		setLowCellingOfDailyDosage((String)recordSet.get("low_celling_of_daily_dosage")) ;
	if(recordSet.containsKey("high_celling_of_daily_dosage"))
		setHighCellingOfDailyDosage((String)recordSet.get("high_celling_of_daily_dosage")) ;
		//Added for IN:070451 end
	}

//	Get the Drug code ralted info
	public ArrayList getDrugCodeRelatedInfo(String drug_code) throws Exception
	{
		
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;

		ArrayList record=new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_SELECT1") );
			pstmt.setString(1,drug_code);
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,getLanguageId());
			pstmt.setString(4,getLanguageId());
			pstmt.setString(5,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet.next() ){
				record.add(	resultSet.getString("DRUG_CODE"));
				record.add(	resultSet.getString("DRUG_DESC"));
				record.add(	resultSet.getString("GENERIC_ID"));
				record.add(	resultSet.getString("GENERIC_NAME"));
				record.add(	resultSet.getString("FORM_CODE"));
				record.add(	resultSet.getString("FORM_DESC"));
				record.add(	resultSet.getString("STRENGTH_VALUE"));
				record.add(	resultSet.getString("PRES_BASE_UOM"));
				record.add(	resultSet.getString("SHORT_DESC"));
				//record.add(	resultSet.getString("STRENGTH_UOM"));
				record.add(	getUomDisplay(login_facility_id,checkForNull(resultSet.getString("STRENGTH_UOM"))));
				//System.out.println( "record-------->"+record) ;
			}
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				System.out.println("Exception while closing the statements and resultsets"+es.toString());
			}
		}
		return record;
	}

//	Get the Age Group Related Information(AGE_GROUP_CODE,SHORT_DESC,GENDER,AGE_UNIT,MIN_AGE,MAX_AGE) on load of the screen...
	public ArrayList getAgeGroupRelatedInfo() throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		ArrayList records=new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_SELECT2") );
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while ( resultSet.next() ){
				String[] strArr = new String[6];
				strArr[0]	=	resultSet.getString("AGE_GROUP_CODE");
				strArr[1]	=	resultSet.getString("SHORT_DESC");
				strArr[2]	=	resultSet.getString("GENDER");
				strArr[3]	=	resultSet.getString("AGE_UNIT");
				strArr[4]	=	resultSet.getString("MIN_AGE");
				strArr[5]	=	resultSet.getString("MAX_AGE");
				records.add(strArr);
			}
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				System.out.println("Exception while closing the statements and resultsets"+es.toString());
			}
		}
		return records;
	}

	// Get the pres base uom/strength uom based on the input
	public String getDosageUOM(String drug_code,String dosage_type) throws Exception
	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String dosage_unit		=	"";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_SELECT9") );
			pstmt.setString(1,drug_code);
			resultSet = pstmt.executeQuery() ;
			if ( resultSet.next() ){
				if(dosage_type.equals("S")) {
					dosage_unit	=	resultSet.getString("STRENGTH_UOM");			
				} else {
					dosage_unit	=	resultSet.getString("PRES_BASE_UOM");			
				}
			}
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet(resultSet) ;
				closeStatement(pstmt) ;
				closeConnection(connection);
			}catch(Exception es){
			System.out.println("Exception while closing the statements and resultsets"+es.toString());
			}
		}
		return dosage_unit;
	}
	public HashMap insert() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		ArrayList insertData = new ArrayList() ;
		ArrayList whereData  = new ArrayList() ;
		try{

			insertData.add( drug_code.trim() ) ;
			insertData.add( age_group_code ) ;
			insertData.add( low_of_unit_dosage ) ;
			insertData.add( high_of_unit_dosage ) ;
			insertData.add( low_of_daily_dosage ) ;
			insertData.add( high_of_daily_dosage ) ;
			insertData.add( monograph ) ;
			insertData.add( limit_ind ) ;

			std_unit	=	getDosageUOM(drug_code.trim(),limit_ind.trim());

			insertData.add( calc_dosage_by ) ;
			insertData.add( std_unit_dosage ) ;
			insertData.add( std_unit ) ;

			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;


			insertData.add( login_by_id.trim() ) ;
			insertData.add( login_at_ws_no.trim() ) ;
			insertData.add( login_facility_id.trim() ) ;

//new changes

			insertData.add( min_age.trim());
			insertData.add( max_age.trim());
			insertData.add( getAgeUnit());
			insertData.add( getGender());
			//Added for IN:070451 Start
			insertData.add( getLowCellingOfUnitDosage());
			insertData.add( getHighCellingOfUnitDosage());
			insertData.add( getLowCellingOfDailyDosage());
			insertData.add( getHighCellingOfDailyDosage());
			//Added for IN:070451 End
//finished
			whereData.add( drug_code.trim() ) ;
			whereData.add( age_group_code.trim() ) ;
			whereData.add( calc_dosage_by.trim() ) ;

			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);

			HashMap sqlMap = new HashMap() ;
			//sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_SELECT5") );
			sqlMap.put( "SelectSQL", "SELECT COUNT(ROWID) FROM PH_DOSAGE_LIMIT_FOR_AGE_GROUP WHERE DRUG_CODE = ? AND AGE_GROUP_CODE = ? AND CALC_BY_IND=?" );
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_INSERT") );


/*			SingleTableHandlerHome home = null;
			SingleTableHandlerRemote remote = null;*/
			try {
/*				InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ) ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/

				Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				if( ((Boolean) map.get( "result" )).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;

				else{
					if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					else
						map.put( "message", (map.get("msgid"))) ;
				}
			}
			catch(Exception e) {
				System.err.println( "Error Calling EJB (FIRST): "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
		}
		catch(Exception e){
			System.err.println( "Error Calling EJB (SECOND): "+e ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
			e.printStackTrace() ;
		}
/*		finally {
			try {}
			catch( Exception ee ){
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}//finally */
		return map ;
	}//insert ends

	public ArrayList getDataForLink(String calc_by_ind) throws Exception {

		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList arrList=new ArrayList();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_SELECT4") );
			pstmt = connection.prepareStatement( " SELECT a.drug_code, b.drug_desc, a.age_group_code, c.short_desc, TO_CHAR (a.low_of_unit_dosage, '999999999.999') low_of_unit_dosage, TO_CHAR (a.high_of_unit_dosage, '999999999.999') high_of_unit_dosage, TO_CHAR (a.dosage_std, '999999999.999') dosage_std, TO_CHAR (a.low_of_daily_dosage, '999999999.999') low_of_daily_dosage, a.calc_by_ind, a.dosage_unit, TO_CHAR (a.high_of_daily_dosage, '999999999.999') high_of_daily_dosage, b.form_code, d.form_desc, e.generic_name, b.strength_value, DECODE (a.gender, 'M', 'male', 'F', 'female', 'U', 'unknown') gender, b.pres_base_uom, f.short_desc pres_base_desc, a.min_age, a.max_age, a.age_unit, a.monograph, a.limit_ind, TO_CHAR (a.low_celling_of_unit_dosage, '999999999.999') low_celling_of_unit_dosage, TO_CHAR (a.high_celling_of_unit_dosage, '999999999.999') high_celling_of_unit_dosage, TO_CHAR (a.low_celling_of_daily_dosage, '999999999.999') low_celling_of_daily_dosage, TO_CHAR (a.high_celling_of_daily_dosage, '999999999.999') high_celling_of_daily_dosage FROM ph_dosage_limit_for_age_group a, ph_drug_lang_vw b, am_age_group_lang_vw c, ph_form_lang_vw d, ph_generic_name_lang_vw e, am_uom_lang_vw f WHERE a.drug_code = b.drug_code AND a.age_group_code = c.age_group_code AND b.form_code = d.form_code(+) AND b.generic_id = e.generic_id(+) AND b.pres_base_uom = f.uom_code(+) AND a.drug_code = ? AND a.age_group_code = ? AND b.language_id = c.language_id AND b.language_id = ? AND d.language_id(+) = ? AND e.language_id(+) = ? AND f.language_id(+) = ? AND a.calc_by_ind = ?" ); //Modified for IN:070451
			pstmt.setString( 1, drug_code.trim() ) ;
			pstmt.setString( 2, age_group_code.trim() ) ;
			pstmt.setString( 3, getLanguageId() ) ;
			pstmt.setString( 4, getLanguageId() ) ;
			pstmt.setString( 5, getLanguageId() ) ;
			pstmt.setString( 6, getLanguageId() ) ;
			pstmt.setString( 7, calc_by_ind ) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				arrList.add(checkForNull(resultSet.getString("DRUG_CODE")));
				arrList.add(checkForNull(resultSet.getString("DRUG_DESC")));
				arrList.add(checkForNull(resultSet.getString("GENERIC_NAME")));
				arrList.add(checkForNull(resultSet.getString("STRENGTH_VALUE")));
				arrList.add(checkForNull(resultSet.getString("FORM_DESC")));
				arrList.add(checkForNull(resultSet.getString("PRES_BASE_UOM")));
				arrList.add(checkForNull(resultSet.getString("SHORT_DESC")));
				arrList.add(checkForNull(resultSet.getString("GENDER")));
				arrList.add(checkForNull(resultSet.getString("AGE_UNIT")));
				arrList.add(checkForNull(resultSet.getString("MIN_AGE")));
				arrList.add(checkForNull(resultSet.getString("MAX_AGE")));
				arrList.add(checkForNull(resultSet.getString("LOW_OF_UNIT_DOSAGE")));
				arrList.add(checkForNull(resultSet.getString("HIGH_OF_UNIT_DOSAGE")));
				arrList.add(checkForNull(resultSet.getString("LOW_OF_DAILY_DOSAGE")));
				arrList.add(checkForNull(resultSet.getString("HIGH_OF_DAILY_DOSAGE")));
				arrList.add(checkForNull(resultSet.getString("MONOGRAPH")));
				arrList.add(checkForNull(resultSet.getString("LIMIT_IND")));
				arrList.add(checkForNull(resultSet.getString("CALC_BY_IND")));
				arrList.add(checkForNull(resultSet.getString("DOSAGE_STD")));
				arrList.add(checkForNull(resultSet.getString("DOSAGE_UNIT")));
				//Added for IN:070451 start
				arrList.add(checkForNull(resultSet.getString("low_celling_of_unit_dosage")));
				arrList.add(checkForNull(resultSet.getString("high_celling_of_unit_dosage")));
				arrList.add(checkForNull(resultSet.getString("low_celling_of_daily_dosage")));
				arrList.add(checkForNull(resultSet.getString("high_celling_of_daily_dosage")));
				//Added for IN:070451 end
			}

		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				System.out.println("Exception while closing the statements and resultsets"+es.toString());
			}
		}
		return arrList;
	}

	public HashMap modify() {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		
/*		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;*/

		try {

		ArrayList modifyData = new ArrayList() ;

		modifyData.add( getLowOfUnitDosage().trim()) ;
		modifyData.add( getHighOfUnitDosage().trim()) ;
		modifyData.add( getLowOfDailyDosage().trim()) ;
		modifyData.add( getHighOfDailyDosage().trim()) ;
		modifyData.add( getMonograph().trim()) ;
		modifyData.add( getLimitInd().trim()) ;		
		modifyData.add( getStandardUnitDose().trim()) ;
		String std_unit	=	getDosageUOM(getDrugCode().trim(),getLimitInd().trim());

		modifyData.add( std_unit ) ;

		modifyData.add( login_by_id.trim() ) ;
		modifyData.add( login_at_ws_no.trim() ) ;
		modifyData.add( login_facility_id.trim() ) ;
		//new changes
		modifyData.add( getMinAge().trim());
		modifyData.add( getMaxAge().trim());		
		modifyData.add( getAgeUnit().trim());
		modifyData.add( getGender().trim());
		//Added for IN:070451 start
		modifyData.add( getLowCellingOfUnitDosage().trim());
		modifyData.add( getHighCellingOfUnitDosage().trim());
		modifyData.add( getLowCellingOfDailyDosage().trim());
		modifyData.add( getHighCellingOfDailyDosage().trim());
		//Added for IN:070451 end
      //finished
		modifyData.add( getDrugCode().trim() ) ;
		modifyData.add( getAgeGroupCode().trim() ) ;
		modifyData.add( getCalculateDosageBy().trim()) ;

		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",modifyData);

		HashMap sqlMap = new HashMap() ;
	
		//sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_UPDATE") );
		sqlMap.put( "ModifySQL", "UPDATE ph_dosage_limit_for_age_group SET low_of_unit_dosage = ?, high_of_unit_dosage = ?, low_of_daily_dosage = ?, high_of_daily_dosage = ?, monograph = ?, limit_ind = ?, dosage_std = ?, dosage_unit = ?, modified_by_id = ?, modified_date = SYSDATE, modified_at_ws_no = ?, modified_facility_id = ?, min_age = ?, max_age = ?, age_unit = ?, gender = ?, low_celling_of_unit_dosage = ?, high_celling_of_unit_dosage = ?, low_celling_of_daily_dosage = ?, high_celling_of_daily_dosage = ? WHERE drug_code = ? AND age_group_code = ? AND calc_by_ind = ?" );//Modified for IN:070451

	
/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

			home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote = home.create() ;
			map = remote.modify( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) map.get( "result" )).booleanValue() )
			{
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				map.put( "flag","0");
			}
			else{
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", (map.get("msgid"))) ;
				map.put( "flag","0");
			}
		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put( "flag","0");
			e.printStackTrace() ;
		} 
		/*finally {
			try{
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		return map ;
	}

	public HashMap delete() {

		StringBuffer sb=new StringBuffer();

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList deleteData = new ArrayList() ;

		deleteData.add( drug_code.trim() ) ;

		sb.append(drug_code.trim());

		deleteData.add( age_group_code.trim() ) ;

		sb.append(age_group_code.trim());

		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "DeleteData",deleteData);

		HashMap sqlMap = new HashMap() ;
		try{
			sqlMap.put( "DeleteSQL", PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_DELETE") );
		}catch(Exception e){
			e.printStackTrace();
		}

/*		SingleTableHandlerHome home = null;
		SingleTableHandlerRemote remote = null;*/
		try {
/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

			home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote = home.create() ;
			map = remote.delete( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			map=(HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put( "message", (map.get("msgid"))) ;


		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
		} finally {
			try {
/*				if( remote != null )
					remote.remove() ;*/
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}
		map.put("flag",sb.toString());
		return map ;
	}

public int checkforvalid(String drug_code,String age_group_code,String calc_by_ind) throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String gender="";
		String age_unit="";
		String min_age="";
		String max_age="";

		String gender1="";
		String age_unit1="";
		String min_age1="";
		String max_age1="";
		int count=0;
		int flag=0;

		try {
           	connection = getConnection() ;

            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_SELECT8") );
			pstmt.setString(1,drug_code.trim());
			resultSet = pstmt.executeQuery() ;
			if(resultSet.next())
			{
             count	    =	resultSet.getInt("COUNT1");
			}
             if(count>0)
			{
            pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_SELECT6") );			
			pstmt.setString(1,age_group_code.trim());
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet.next() ){
				
				gender1	    =	resultSet.getString("GENDER");
				 if(gender1==null)gender1="";
				age_unit1	=	resultSet.getString("AGE_UNIT");
				 if(age_unit1==null)age_unit1="";
				min_age1	=	resultSet.getString("MIN_AGE");
                 if(min_age1==null)min_age1="";
				max_age1	=	resultSet.getString("MAX_AGE");
				 if(max_age1==null)max_age1="";
				
			}
			
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DOSG_LMT_SELECT7") );
			pstmt =connection.prepareStatement("SELECT MIN_AGE, MAX_AGE, AGE_UNIT, GENDER FROM PH_DOSAGE_LIMIT_FOR_AGE_GROUP WHERE DRUG_CODE=? AND CALC_BY_IND=?");
			pstmt.setString(1,drug_code.trim());
			pstmt.setString(2,calc_by_ind.trim());
			resultSet = pstmt.executeQuery() ;
			while ( resultSet.next() ){
                gender="";
				age_unit="";
				min_age="";
				max_age="";
				
				gender	    =	resultSet.getString("GENDER");
				 if(gender==null)gender="";
				age_unit	=	resultSet.getString("AGE_UNIT");
				 if(age_unit==null)age_unit="";
				min_age	    =	resultSet.getString("MIN_AGE");
				 if(min_age==null)min_age="";
				max_age	    =	resultSet.getString("MAX_AGE");
				 if(max_age==null)max_age="";

				if(gender.equals(gender1) && age_unit.equals(age_unit1)&&( (Integer.parseInt(min_age)>=Integer.parseInt(min_age1)&& Integer.parseInt(min_age)<=Integer.parseInt(max_age1))||Integer.parseInt(max_age)>= Integer.parseInt(min_age1)&& Integer.parseInt(max_age)<=Integer.parseInt(max_age1) ))
			    {
				flag=1;
				break;
			   }
			}
		}else
		{
			flag=0;
		}

		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				System.out.println("Exception while closing the statements and resultsets"+es.toString());
			}
		}
		return flag;
	}
}
