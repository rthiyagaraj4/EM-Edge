/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.* ;
import eCommon.Common.*;

import javax.servlet.http.*;
import webbeans.eCommon.*;

import eOR.OROrderSet.*;


public class  CareSetBean1  extends OrAdapter implements Serializable{
	protected String which_place = "";
	protected Hashtable allValues = new Hashtable();
	protected String total_records = "";
	public    StringBuffer  tempChk = new StringBuffer();

/*****************STORES(TO STORE ALL THE TABS VALUE)**********/

	public  ArrayList					synonymsRecStr ;
	public  ArrayList					explanatoryRecStr ;

	public  ArrayList					settingsRecStr ;
	public  HashMap						settingsFreqStr ;//
	public  HashMap						settingsDurnStr ;//
	public  HashMap						settingsFreqStrMapper ;

	public  HashMap						careSetHeaderStr ;

	public	eOR.Common.MultiRecordBean1			componentStr ;

	public  String						action ;	  //Component tab
	public  String						detailPageMode;//Component tab
	public  HashMap						orderTypeStr  ;//Component tab
	public  HashMap						orderFreqStr ;//Component tab


	public StringBuffer validateMessage = null;

/***************Get Methods*******************************/
public ArrayList getsynonymsRecStr(){return synonymsRecStr ;}
public ArrayList getExplanatoryRecStr(){return explanatoryRecStr ;}
public ArrayList getSettingsRecStr(){return settingsRecStr ;}
public HashMap	 getSettingsFreqStr(){return settingsFreqStr ;}
public HashMap	 getSettingsDurnStr(){return settingsDurnStr ;}
public HashMap	 getCareSetHeaderStr(){return careSetHeaderStr ;}
public String    getAction(){return action;}
public String    getDetailPageMode(){return detailPageMode;}
public HashMap	 getOrderFreqStr(){return orderFreqStr ;}
public HashMap	 getOrderTypeStr(){return orderTypeStr ;}
public void setWhichType(String which_place){	this.which_place = which_place;	}
public String getWhichType(){					return which_place;	}
public Hashtable getAllValues() {
        return allValues;
    }
	public void setTotalRecs(String total_records){	this.total_records = total_records;	}
	public String getTotalRecs(){			return total_records;	}


/******************Clear ALL*******************************/
public void clearALL(){//Called when combo Option for OrderCategory is Changed

	if(!synonymsRecStr.isEmpty())
		synonymsRecStr.clear() ;

	if(!explanatoryRecStr.isEmpty())
		explanatoryRecStr.clear() ;


	if(!settingsRecStr.isEmpty())
		settingsRecStr.clear() ;


	if(!careSetHeaderStr.isEmpty())
		careSetHeaderStr.clear() ;

	clearComponentStr();

	action = "";

	detailPageMode ="";
}

/*********************Constructor *************************/
public CareSetBean1(){

	 		 careSetHeaderStr				= new HashMap();

			 synonymsRecStr					= new ArrayList();
			 explanatoryRecStr				= new ArrayList();
			 settingsRecStr					= new ArrayList();
 			 settingsFreqStr                = null ;
			 validateMessage				= new StringBuffer();


			 componentStr					= new eOR.Common.MultiRecordBean1();
			 orderTypeStr					= new HashMap();
 			 orderFreqStr					= new HashMap();

	}

/*********************Validate *************************/

public HashMap validate() throws Exception {
	
	HashMap map = new HashMap();
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." );
	boolean  finalFlag = true ;
	boolean routeFlag = true ;
	boolean seqFlag = true ;
	validateMessage  =  new StringBuffer();
	int int_total_records = Integer.parseInt(total_records);
	String iv_prep_yn=allValues.get("iv_prep_yn").toString();
	String route_code="";
	String seq_no="";

	
	for(int i=1; i<=int_total_records; i++)
	{
			if(allValues.containsKey("include"+i))
			{
					if(((String)allValues.get("include"+i)).equalsIgnoreCase("Y"))
					{
						route_code=allValues.get("route_code"+i).toString();
						if(iv_prep_yn.equalsIgnoreCase("C")&&route_code.equalsIgnoreCase(""))
						{
							routeFlag=false;										
						}
						seq_no=allValues.get("order_set_seq_num"+i).toString();
						if(seq_no.equalsIgnoreCase(""))
						{
							seqFlag=false;										
						}
					}
			}
	}
	if(!routeFlag)  
	{
		 validateMessage.append(getMessage(language_id,"ORDER_SET_ADMIN_ROUTE","OR"));
		 finalFlag = false ;
	}
	if(!seqFlag)  
	{
		String seq_msg=getMessage("MANDATORY_SEQNO");
		int r= seq_msg.indexOf("<br>");
		if(r==-1)
		  seq_msg = seq_msg.substring(0,seq_msg.length()) ;
		else
		  seq_msg = seq_msg.substring(0,r) ;
		if(validateMessage.length()>0)
		{
				validateMessage.append("\n");
				validateMessage.append(seq_msg);
		}
		else
		{
				validateMessage.append(seq_msg);
		}

		 finalFlag = false ;
	}
	if(!finalFlag)
	{
		String msg=validateMessage.toString();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", msg );
	}
	
	return map;
}


/****************Concanate Function ************************************/
private String concat(String varMsg,String msgNotBlank){
		String temp = "Cannot be Blank" ;
		int indx = msgNotBlank.indexOf(temp);
		return  msgNotBlank.substring(0,indx) + " "  + varMsg + " " + msgNotBlank.substring(indx,msgNotBlank.length());
}
/*************Over riding get Message**************************************/
public String getMessage( String msgId ){

String msg ="";

	if(msgId.equals("Validate")){
		msg = validateMessage.toString();
		validateMessage =  new StringBuffer() ;
		return msg ;
	}else{
		return super.getMessage(msgId) ;
	}

}
/*****************MAX DURN VAL CHK *******************************************/
 private boolean chkRequiredAll(ArrayList store, String key , String mandatory ) throws Exception{
try{
		int size =  store.size();
		boolean flag  = true ;

		if(size == 0)
		return true;

		for (int i = 0 ; i < size ; i++ ){
		flag = chkRequiredEmpty(store,i,key,mandatory)	;
		if(!flag)
			return false ;
		}

		return true;
	}catch(Exception e){
		throw e;
	}
}
/*****************************************************************************/

  private boolean chkRequired(ArrayList store, int position , String key ,  String keyVal , String mandatory ) throws Exception{

	int size =  store.size();
	
	if(size == 0)
	return true;

	if(size < position )
		throw new Exception("Chk position passed and the size of Store") ;


	HashMap currRec = (HashMap)store.get(position);

	if(!(currRec.containsKey( key.trim() ))) //key should be there
		return true ;

	if(!currRec.containsKey(mandatory.trim())) //mandatory should be there
		return true ;


	String currKeyVal = (String)currRec.get(key.trim()) ;
	String mandatoryVal  = (String)currRec.get(mandatory.trim());

	if(currKeyVal.trim().equalsIgnoreCase(keyVal.trim())){
		if(mandatoryVal.trim().equalsIgnoreCase(""))
			return false ;
	}else{
			return true;
	}


	return true ;

}
/**************************************************************************/
  private boolean chkRequiredEmpty(ArrayList store, int position , String key , String mandatory ) throws Exception{

	int size =  store.size();

	if(size == 0)
	return true;

	if(size < position )
		throw new Exception("Chk position passed and the size of Store") ;


	HashMap currRec = (HashMap)store.get(position);

	if(!(currRec.containsKey( key.trim() ))) //key should be there
		return true ;

	if(!currRec.containsKey(mandatory.trim())) //mandatory should be there
		return true ;


	String currKeyVal = (String)currRec.get(key.trim()) ;
	String mandatoryVal  = (String)currRec.get(mandatory.trim());

	if(!currKeyVal.trim().equalsIgnoreCase("")){
		if(mandatoryVal.trim().equalsIgnoreCase(""))
			return false ;
	}else{
			return true;
	}


	return true ;

}

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/
 public void setAll( Hashtable recordSet ) {
	allValues = recordSet;
	/*careset Header*/
	if(recordSet.containsKey("order_set_code"))
		 careSetHeaderStr.put("order_set_code",(String)recordSet.get("order_set_code"));
	if(recordSet.containsKey("long_desc"))
		 careSetHeaderStr.put("long_desc",(String)recordSet.get("long_desc"));
	if(recordSet.containsKey("short_desc"))
		 careSetHeaderStr.put("short_desc",(String)recordSet.get("short_desc"));
	if(recordSet.containsKey("order_category"))
		 careSetHeaderStr.put("order_category",(String)recordSet.get("order_category"));
	if(recordSet.containsKey("order_type_code"))
		 careSetHeaderStr.put("order_type_code",checkForNull((String)recordSet.get("order_type_code")));
	if(recordSet.containsKey("activity_type"))
		 careSetHeaderStr.put("activity_type",checkForNull((String)recordSet.get("activity_type")));
	if(recordSet.containsKey("security_level"))
		 careSetHeaderStr.put("security_level",checkForNull((String)recordSet.get("security_level")));
	if(recordSet.containsKey("eff_status"))
		 careSetHeaderStr.put("eff_status"	  ,checkForNull((String)recordSet.get("eff_status"),"D"));
	if(recordSet.containsKey("indexed_yn")){
		careSetHeaderStr.put("indexed_yn"	  ,checkForNull((String)recordSet.get("indexed_yn"),"N"));
	}
	if(recordSet.containsKey("iv_prep_yn")){
		careSetHeaderStr.put("iv_prep_yn"	  ,checkForNull((String)recordSet.get("iv_prep_yn"),""));
	}
	if(recordSet.containsKey("discharge_indicator")){
		careSetHeaderStr.put("discharge_indicator"	  ,checkForNull((String)recordSet.get("discharge_indicator"),"N"));
	}
	if(recordSet.containsKey("which_place")){	setWhichType(((String)recordSet.get("which_place")));}
	if(recordSet.containsKey("total_recs")){
			setTotalRecs((String)recordSet.get("total_recs"));
		}
	this.mode = (String)recordSet.get("mode");
 }

/*********************METHOD TO Reset the Class variable*************************/

	public void clear() {
		which_place = "";
	}

/*********************METHOD TO Insert*************************/

public HashMap insert(){
try{
	

	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( false ) ) ;
	

		map=AdditionalRecord();
	
	
return map;

	}catch(Exception e){
		e.printStackTrace();
		logErrorMessage(e);
		return null;
	}


}
/**************************************************************************/
/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap ) {
	HashMap map  = new HashMap() ;
	try
		{

			  Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_ORDERSET_JNDI"), OROrderSetHome.class, getLocalEJB());
			  Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			 
			HashMap tabDataParam =  new HashMap() ;
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "tabData",     record );
			
			Object argArray[]	= new Object[2];
			argArray[0]		= tabDataParam;
			argArray[1]		= sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0]	= tabDataParam.getClass();
			paramArray[1]	= sqlMap.getClass();		
						
			
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				// map = remote.insert(tabDataParam, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
					//map = remote.modify(tabDataParam, sqlMap )    ;
					map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
			 
			  argArray		= null;
			  paramArray	= null;

			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
				}

	  //return map;

	 }catch(Exception e){
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		
	}
return map ;
 }//End of Method


/************************LOAD DATA FOR UPDATION *****************************/
public void defaultLoadForUpdation(String[] Code){
try{
		Hashtable ht_catalog =	getSqlResultParamLoad("SQL_OR_ORDERSET_LOAD_ORDERSET",Code,-1);
		setAll(ht_catalog);//for header
       
	    // ExplanatoryText
		explanatorySync(ht_catalog);
		
		
		//Synonms
		Hashtable ht_syn	 =	getSqlResultParamLoad("SQL_OR_ORDERSET_LOAD_CATALOG_BY_SYNONYM",Code,1);
		Integer	size_syn_obj = (Integer)ht_syn.get("noRec") ;
		int size_syn		 =  size_syn_obj.intValue();

		String Str1="";
		String Str2 ="";
		String syn_type="";
		String syn_desc="";

		for (int i = 1; i <= size_syn ; i++){


		 Str1 = 	"catalog_synonym_type"+ i ;
 		 Str2 = 	"catalog_synonym"+ i ;

 		 syn_type = (String)ht_syn.get(Str1.trim());
		 syn_desc = (String)ht_syn.get(Str2.trim());

			if(syn_type.trim().equalsIgnoreCase("PR")){
				ht_catalog.put("catalog_synonym_primary",syn_desc);
				ht_catalog.put("effective_status_primary","Y");
			}

			if(syn_type.trim().equalsIgnoreCase("DC")){
				ht_catalog.put("catalog_synonym_directCare",syn_desc);
				ht_catalog.put("effective_status_directCare","Y");
			}

			if(syn_type.trim().equalsIgnoreCase("AD")){
				ht_catalog.put("catalog_synonym_ancillaryDept",syn_desc);
				ht_catalog.put("effective_status_ancillaryDept","Y");
			}
		}


			synonymsSync(ht_catalog);

}catch (Exception e){
		e.printStackTrace();
		logErrorMessage(e);
	}
}

/*************************just get the result as Hash table for UPdation***************/
public  Hashtable getSqlResultParamLoad(String key , String[] params ,int indStart) throws Exception{
Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet rs			= null;
ResultSetMetaData rsmd	= null ;
String 	columnName		= null ;
int 	columnCount		= -1 ;

Hashtable result = new Hashtable();

int paramslen  = params.length ;

try
{
	connection = getConnection();


	String sql = OrRepository.getOrKeyValue(key.trim());

	pstmt	   = connection.prepareStatement(sql);


	for (int i = 0; i < paramslen ; i++ ){
		pstmt.setString(i+1, (params[i]).trim());
	}

	rs		   = pstmt.executeQuery()  ;
	rsmd	   = rs.getMetaData()      ;
	columnCount= rsmd.getColumnCount() ;
	int counter= 0 ;

	while (rs.next()){

		counter++;
		for(int i = 1; i <= columnCount ; i++){
				columnName	= rsmd.getColumnName(i)  ;
			if(indStart == -1 )
				result.put((columnName.toLowerCase()),ChkDef.defaultString(rs.getString(columnName)));
			else
				result.put(((columnName.toLowerCase()+counter).trim()),ChkDef.defaultString(rs.getString(columnName)));
		}

	}
	result.put("noRec",new Integer(counter));


	return result ;
}catch(Exception e){
	e.printStackTrace();
	throw new Exception(e.getMessage());
}finally{
	try{
		closeResultSet(rs);
		closeStatement(pstmt);
		closeConnection(connection);
	 }catch(Exception e){e.printStackTrace() ; }
}

}

/******************Default Intailise the str if tab not visted ***************/
private void defaultInitailiseStr(){

//Default Intialise only if store's are is empty
Hashtable def = new Hashtable();

	if(synonymsRecStr.isEmpty()){
		def.put("catalog_synonym_type" ,"PR");
		def.put("catalog_synonym_primary",(String)careSetHeaderStr.get("short_desc"));
		def.put("effective_status_primary","Y");
		synonymsSync(def);
		def.clear() ;
	}

		if(explanatoryRecStr.isEmpty()){
		def.put("explanatory_text" ,"");	
//		def.put("explanatory_text" ,(String)careSetHeaderStr.get("explanatory_text"));	
		explanatorySync(def);
		def.clear() ;
	}   


	if(settingsRecStr.isEmpty()){
		def.put("patient_class0" ,"*A");
		def.put("setting_applicability0","A");
		def.put("noOfRecords","0");
		settingsSync(def);
		def.clear() ;
	}

//	ComponentRecStr -------- it has to be mandatorly filled chk in validation


}
/*********************METHOD TO Update*************************/

public HashMap modify(){
try{

	HashMap map = new HashMap() ;
	HashMap sqlMap = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	HashMap recordStoreParam = new HashMap() ;


	recordStoreParam.put("careSetHeaderStr"	,careSetHeaderStr);

	recordStoreParam.put("synonymsStr"		,synonymsRecStr);
	recordStoreParam.put("explanatoryStr"	,explanatoryRecStr);


	if(settingsRecStr.isEmpty()){//That means there is no  visit to  this page (Tab)
	//Fill the records in the store as if there is visted to the page
		Hashtable   dummpPageSettings=  new  Hashtable();
		String order_set_code =
		(String)careSetHeaderStr.get("order_set_code");
		 String sqlParam[]  = {order_set_code.trim()};

		 Hashtable defVal1 = settingsDefault("SQL_OR_ORDERSET_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);

		 HashMap pat_class		 =	getSqlResult("SQL_OR_PATIENT_CLASS_LIST");
		 Integer noOfRecordsTemp = (Integer)pat_class.get("noRec");
		 int noOfRecords1		 = noOfRecordsTemp.intValue() ;
		 int fm_disp1			 = 0 ;
		 int to_disp1			 = noOfRecords1 ;

	
		 if(noOfRecords1!= 0){	
			dummpPageSettings.put("noOfRecords",String.valueOf(noOfRecords1));
			String 	patient_class="";
			HashMap currRecSettings=null;
			String setting_applicability_default="";
			 for(int j=fm_disp1; j<= to_disp1;j++){

				patient_class	= "";
				boolean contVal			= false ;

				if(j==0){
					contVal =true ;//always the all patient class(*A)  will  be present in the DataBase
					patient_class = "*A";
				}else{
					patient_class  = (String)pat_class.get("PATIENT_CLASS"+j);
					contVal = defVal1.containsKey(patient_class.trim()) ;
				}

				if(contVal){//Value form the DataBase
					currRecSettings			=(HashMap)defVal1.get(patient_class.trim());
					setting_applicability_default   =(String)currRecSettings.get("setting_applicability");
						if(setting_applicability_default.trim().equalsIgnoreCase("A")){
						    dummpPageSettings.put("patient_class"+j				,patient_class.trim());
							dummpPageSettings.put("setting_applicability"+j		,setting_applicability_default);
							continue ;
						}
				  }

					dummpPageSettings.put("patient_class"+j				,patient_class.trim());
					dummpPageSettings.put("setting_applicability"+j		,"X");
				 }

			}

			settingsSync(dummpPageSettings)	; //Syn if the str is empty
		}
			recordStoreParam.put("settingsStr"		,settingsRecStr);
			recordStoreParam.put("componentStr"		,componentStr.getAllDBRecords());
			recordStoreParam.put("login_by_id"		,login_by_id) ;
			recordStoreParam.put("login_at_ws_no"	,login_at_ws_no ) ;
			recordStoreParam.put("login_facility_id",login_facility_id ) ;


	sqlMap.put("SQL_OR_ORDERSET_UPDATE"				,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_UPDATE"));
	sqlMap.put("SQL_OR_ORDERSET_INSERT_SYNONYM"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_SYNONYM"));
	sqlMap.put("SQL_OR_ORDERSET_INSERT_BY_PTCL"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_BY_PTCL"));
	sqlMap.put("SQL_OR_ORDERSET_INSERT_COMP"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_COMP"));
	sqlMap.put("SQL_OR_ORDERSET_SYNONYM_DELETE"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_SYNONYM_DELETE"));
	sqlMap.put("SQL_OR_ORDERSET_COMP_DELETE"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_DELETE"));
	sqlMap.put("SQL_OR_ORDERSET_PTCL_DELETE"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_PTCL_DELETE"));
	sqlMap.put("SQL_OR_ORDERSET_EFF_STATUS_SELECT"	,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_EFF_STATUS_SELECT"));
	sqlMap.put("SQL_OR_ORDERSET_EFF_STATUS_UPDATE"	,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_EFF_STATUS_UPDATE"));


	map.put("recordStoreParam",recordStoreParam);
	map.put("////sqlMap",sqlMap);
	return getResult(recordStoreParam,sqlMap );


	}catch(Exception e){
		tempChk.append(e.getMessage());
		logErrorMessage(e);
		e.printStackTrace();
		return null;
	}

}

/*********************METHOD TO Delete*************************/

public HashMap delete(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." );
	return map;
}

/*********************DoCommon*************************/
private void doCommon() throws Exception {
}
/****************GET RESULT******************************/
public String getComboOptions(String opt,String defaultval , String sqlParams) throws Exception{


	Connection connection =null ;
	PreparedStatement pstmt=null;
	String Ph_installed="N";
	ResultSet rs=null;
	String str = "";
	String sql = "";
	String[] language_id_param = new String[1];


		if(opt.trim().equalsIgnoreCase(""))
		return "";

try{
		language_id_param[0] = language_id;
		connection = getConnection();
		if(opt.trim().equalsIgnoreCase("OrderCategory")){
		str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST"),connection,"ORDER_CATEGORY","SHORT_DESC",defaultval.trim(),language_id_param);
		}else if(opt.trim().equalsIgnoreCase("OrderType")){
			if(!sqlParams.trim().equals("")){//called will painting only jsp if OrderCategory is passed
		sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ORDER_TYPE") ;
		String sqlParam[] = {sqlParams};
		str = Populate.getComboOptions(sql,connection,"ORDER_TYPE_CODE","SHORT_DESC",defaultval.trim(),sqlParam); }
		}else if(opt.trim().equalsIgnoreCase("ActivityType")){

			
			
			String param[] = new String[3];
			StringTokenizer stktok = new StringTokenizer(sqlParams,",");
			int i=0;
			while(stktok.hasMoreTokens()){				
				param[i] = stktok.nextToken();
				i++;
			}

			str = Populate.getComboOptions_sp(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ACTIVITY_TYPE"),connection,"ACTIVITY_TYPE","SHORT_DESC",defaultval.trim(),param);
		}else if(opt.trim().equalsIgnoreCase("iv_prep_yn")){
	try{	
		pstmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
		pstmt.setString(1,"PH");
		rs=pstmt.executeQuery();
		if(rs.next()){
			Ph_installed=rs.getString(1);
		}

		if (Ph_installed.equalsIgnoreCase("Y")){
			
		str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_IV_PREP_YN"),connection,"Code","Short_Desc",defaultval.trim());
		}
	}catch(Exception e){
		e.printStackTrace();}
		}else {//directly sql is passed
		str = Populate.getComboOptions(opt,connection ,"code" ,"short_desc",defaultval.trim());
		}

		return str;
}catch(Exception e){
		e.printStackTrace();
		logErrorMessage(e);
		throw new Exception(e.getMessage());
}
finally{
		try
		 {
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
			
		 }catch(Exception e){e.printStackTrace() ;
					}
	  }
}
/*************get Combo Options Dynamic Population(Header Frame)***********/
public String getComboBoxHtml(Hashtable ht) throws Exception {
	String optionString = "";
	String comboBoxString = "";
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String ph_installed="N";
try
	{
		if( ht == null )
			return "Hashtable Passed to  this method is null";

		connection = getConnection();
	 	String  type = (String)ht.get("type");
		if(type.trim().equalsIgnoreCase("OrderCategory")){
			String sqlParams[] = {(String)ht.get("order_category")};
			optionString  = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ORDER_TYPE"),connection,"ORDER_TYPE_CODE","SHORT_DESC",sqlParams);
		   	comboBoxString="<select name='order_type_code' onChange='parent.parent.fillComboOptions(this);parent.parent.display(\\\"S\\\")' ><option>-------------Select----------</option>"+optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
		}else if(type.trim().equalsIgnoreCase("OrderType"))
		{
			String[] sqlparam=new String[3];
			sqlparam[0]=(String)ht.get("order_category");
			sqlparam[1]=(String)ht.get("order_type_code");
			sqlparam[2]=(String)ht.get("order_category");
			
			optionString  = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ACTIVITY_TYPE"),connection,"ACTIVITY_TYPE","SHORT_DESC",sqlparam);

			comboBoxString="<select name='activity_type'  ><option>-------------Select----------</option>"+optionString + "</select>" ;

		//	tempChk = "";
		}else if(type.trim().equalsIgnoreCase("iv_prep_yn")){
			try{
				pstmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
			pstmt.setString(1,"PH");
			rs=pstmt.executeQuery();
			if(rs.next())
				ph_installed=rs.getString(1);

			if(ph_installed.equalsIgnoreCase("Y")){
			//String sqlParams[] = {(String)ht.get("order_category")};
			optionString  = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_IV_PREP_YN"),connection,"Code","Short_Desc ");
		   	comboBoxString="<select name='iv_prep_yn' ><option value=''>-------------Select----------</option>"+optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}else
			throw new Exception("Exception :-in Bean getComboBoxHtml function Hashtable Passed should contain order_category  only");
		}
	catch(Exception e){
		e.printStackTrace();
		throw e;
	}
	finally
	{
		try
		 {
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;

		 }
	}

	return comboBoxString;

}/****METHOD TO load OrderCategory code-desc for Query Page********/

public String getComboString() {
Connection 	connection  = null;
java.sql.PreparedStatement pstmt = null;
java.sql.ResultSet rs	= null;
try
	{
		connection  		= getConnection();
		pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST"));
		pstmt.setString(1,language_id);
		rs					= pstmt.executeQuery();
	    StringBuffer sb		= new StringBuffer();
		String  codeCol="";
		String  codeDesc="";
		while (rs.next())
			{
				codeCol			    = ChkDef.defaultString(rs.getString(1));
				codeDesc			= ChkDef.defaultString(rs.getString(2));
			    sb.append(codeDesc + "," + codeCol + ",");
			}

		 String str =   sb.toString() ;
		 sb.setLength(0);
		 return str.substring(0, str.length()-1);
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	finally
	{
		try
		 {
		 	closeResultSet(rs);
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;

		 }
	}
}

/*************************just get the result as Hash table WHEN SQL IS PASSED***************/
public  Hashtable getSqlResultParamModule(String sql , String[] params ,int indStart) throws Exception{
Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet rs			= null;
ResultSetMetaData rsmd	= null ;
String 	columnName		= null ;
int 	columnCount		= -1 ;

Hashtable result = new Hashtable();

int paramslen  = params.length ;

try
{
	connection = getConnection();
	pstmt	   = connection.prepareStatement(sql);
	for (int i = 0; i < paramslen ; i++ ){
		pstmt.setString(i+1, (params[i]).trim());
	}

	rs		   = pstmt.executeQuery()  ;
	rsmd	   = rs.getMetaData()      ;
	columnCount= rsmd.getColumnCount() ;
	int counter= 0 ;

	while (rs.next()){

		counter++;
		for(int i = 1; i <= columnCount ; i++){
				columnName	= rsmd.getColumnName(i)  ;
			if(indStart == -1 )
				result.put((columnName.toLowerCase()),ChkDef.defaultString(rs.getString(columnName)));
			else
				result.put(((columnName.toLowerCase()+counter).trim()),ChkDef.defaultString(rs.getString(columnName)));
		}

	}
	result.put("noRec",new Integer(counter));


	return result ;
}catch(Exception e){
	throw new Exception(e.getMessage());
}finally{
	try{
		closeResultSet(rs);
		closeStatement(pstmt);
		closeConnection(connection);
	 }catch(Exception e){e.printStackTrace() ;}
}

}

/***************rewiews Syn************************************/
private void settingsSync(Hashtable request){
HashMap record= null;
boolean flag = settingsRecStr.isEmpty() ;//to Chk  whether  the client has visited this tab before


int noOfRecords = Integer.parseInt(chkPresent(request,"noOfRecords","-1")) ;

for (int i = 0 ; i <= noOfRecords ; i++){//0th rec for ALL patient  class which is hard coded

		if(!flag)
			record = (HashMap)settingsRecStr.get(i);
		else
			record = new HashMap();

		record.put("patient_class"				,chkPresent(request,"patient_class"+i,""));
		record.put("setting_applicability"		,chkPresent(request,"setting_applicability"+i,"X"));

		if(flag)//only when str was empty
		settingsRecStr.add(record);

	}

}

/*****Default Load for settings tab/for other module defaults or modify*****/
public Hashtable settingsDefault(String sql , String defaultFor ,String sqlParam[]){

Hashtable retVal =   new Hashtable();
Hashtable result =   null;

try{

	 if(defaultFor.trim().equalsIgnoreCase("update")){
		sql     =  OrRepository.getOrKeyValue(sql.trim());
		result  =  getSqlResultParamModule(sql,sqlParam , 1);
	 }


	Integer	size_res = (Integer)result.get("noRec") ;
	int size		 =  size_res.intValue();

	if(size == 0)
		return retVal;
HashMap	record=null;
String 	patient_class="";
	for (int i = 1 ; i <= size ; i++){

		record = new HashMap();
		record.put("patient_class"				,chkPresent(result,"patient_class"+i,""));
		record.put("setting_applicability"		,chkPresent(result,"setting_applicability"+i,"A"));	
		record.put("qty_uom"					,chkPresent(result,"qty_uom"+i,""));
        //In case of other module calling

		patient_class =	chkPresent(result,"patient_class"+i,"-1")	;

		retVal.put(patient_class.trim(),record);
	}

		return  retVal ;
  }catch(Exception e){
		e.printStackTrace();
		return null;
  }
}

/***************rewiews Syn************************************/
private void synonymsSync(Hashtable request){
	HashMap record= null;

	if(!synonymsRecStr.isEmpty())
		record = (HashMap)synonymsRecStr.get(0);
	else
		record = new HashMap();

	record.put("catalog_synonym_primary"		,chkPresent(request,"catalog_synonym_primary",""));
	record.put("effective_status_primary"		,chkPresent(request,"effective_status_primary","N"));
	record.put("catalog_synonym_directCare"		,chkPresent(request,"catalog_synonym_directCare",""));
	record.put("effective_status_directCare"	,chkPresent(request,"effective_status_directCare","N"));
	record.put("catalog_synonym_ancillaryDept"	,chkPresent(request,"catalog_synonym_ancillaryDept",""));
	record.put("effective_status_ancillaryDept"	,chkPresent(request,"effective_status_ancillaryDept","N"));


	if(synonymsRecStr.isEmpty())
		synonymsRecStr.add(record);

}

/********componentSyn************************************************************/
private void componentSyn(Hashtable request){


String detailPageMode_p	=(String)request.get("detailPageMode") ;
this.action				=(String)request.get("action") ;




if(detailPageMode_p.equalsIgnoreCase("S")){//i:e if detail page mode was selected
	updateCurrentPageForAsscStore(request);
}

if(detailPageMode_p.equalsIgnoreCase("A")){
	synAsscStore(request);
}

}
/**************************explanatorySyn********************/

private void explanatorySync(Hashtable request){

	HashMap record= null;
	if(!explanatoryRecStr.isEmpty())
		record = (HashMap)explanatoryRecStr.get(0);
	else
		record = new HashMap();  

//    careSetHeaderStr.put("explanatory_text",chkPresent(request,"explanatory_text",""));

	record.put("explanatory_text"		,chkPresent(request,"explanatory_text",""));	

	if(explanatoryRecStr.isEmpty())
		explanatoryRecStr.add(record);   

}

/******************Update   Records  *********************/
private void updateCurrentPageForAsscStore(Hashtable request){

	int fm_disp  =ChkDef.defaultInt(((String)request.get("previousRecord")));
	int to_disp	 =ChkDef.defaultInt(((String)request.get("nextRecord")));
try{
	String ascc="";
	HashMap ht=null;

	for (int i = fm_disp-1; i <to_disp ; i++){

		ascc = checkForNull(((String)request.get("include" + i)),"N");

		ht  =(HashMap)componentStr.getListObject(i);

		String pk[] ={(String)ht.get("order_catalog_code")};//Primary Key

		ht = Validaty(ht); //this will give the inserted record if already present in the  ascc  str

		if(((String)ht.get("valid")).trim().equalsIgnoreCase("Y"))//if the curr rec is database rec then return	since we won't change it
		continue ;

		if(ascc.trim().equalsIgnoreCase("Y")){

      
        String d_t = ((String)request.get("durn_type" + i));

		if(d_t.equals("null") || d_t.equals(" ") || d_t==null)
		{
          d_t = "";
		}

			ht.put("order_set_seq_num"		,ChkDef.defaultString(((String)request.get("order_set_seq_num" + i))));
			ht.put("order_type_code"		,ChkDef.defaultString(((String)request.get("order_type_code" + i))));
			ht.put("qty_unit"				,checkForNull((String)request.get("qty_unit" + i),"1"));
			ht.put("qty_value"				,checkForNull((String)request.get("qty_uom" + i),""));		
			ht.put("freq_code"				,ChkDef.defaultString(((String)request.get("freq_code" + i))));
			ht.put("durn_value"				,ChkDef.defaultString(((String)request.get("durn_value" + i))));
			ht.put("durn_type"				,ChkDef.defaultString(((String)request.get("durn_type" + i))));
			ht.put("rel_start_date_time"	,ChkDef.defaultString(((String)request.get("rel_start_date_time" + i))));
			ht.put("reqd_or_opt_ind"		,ChkDef.defaultString(((String)request.get("reqd_or_opt_ind" + i))));
			ht.put("item_narration"			,""); //Not used in 2nd phase
			ht.put("route_code"				,""); //Not used in 2nd phase
		   	ht.put("valid"					,"N");
			ht.put("associate_yn"			,"y");
			ht.put("status"					,"y");
			ht.put("prompt_msg"				,ChkDef.defaultString(((String)request.get("prompt_msg" + i))));

			componentStr.setObject(pk,ht);//Will add or set depending upon the primary key match
		}else{//remove form assoc list if alreay asccociated
			int indx = componentStr.containsElement(pk);
			if(indx != -1 )
			componentStr.removeObject(indx);
		}

	}
}catch(Exception e){
	logErrorMessage(e);
}
}
/**************************Synchronize in Associated Mode****************/
private void  synAsscStore(Hashtable request){

int fm_disp  =ChkDef.defaultInt(((String)request.get("previousRecord")));
int to_disp	 =ChkDef.defaultInt(((String)request.get("nextRecord")));

  try{
	  Hashtable ht =null;
	for (int i = fm_disp-1;i<to_disp;i++){
		ht  = new Hashtable();
		ht.put("order_set_seq_num"		,ChkDef.defaultString(((String)request.get("order_set_seq_num" + i))));
		ht.put("order_type_code"		,ChkDef.defaultString(((String)request.get("order_type_code" + i))));
		ht.put("qty_unit"				,checkForNull((String)request.get("qty_unit" + i),"1"));
		ht.put("qty_value"				,checkForNull((String)request.get("qty_uom" + i),"")); 
		ht.put("freq_code"				,ChkDef.defaultString(((String)request.get("freq_code" + i))));
		ht.put("durn_value"				,ChkDef.defaultString(((String)request.get("durn_value" + i))));
		ht.put("rel_start_date_time"	,ChkDef.defaultString(((String)request.get("rel_start_date_time" + i))));
		ht.put("durn_type"				,ChkDef.defaultString(((String)request.get("durn_type" + i))));
		ht.put("reqd_or_opt_ind"		,ChkDef.defaultString(((String)request.get("reqd_or_opt_ind" + i))));
		ht.put("prompt_msg"		,ChkDef.defaultString(((String)request.get("prompt_msg" + i))));
		ht.put("item_narration"			,""); //Not used in 2nd phase
		ht.put("route_code"				,""); //Not used in 2nd phase
		ht.put("include"				,checkForNull((String)request.get("include" + i),"N"));


		componentStr.setDBBeanValue(i,ht);
		}
   }catch(Exception e){
			e.printStackTrace();
	logErrorMessage(e);
	}

}


/*****************************************/
public String getqty_uom_desc(String uom_code) {
	
Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet rs			= null;
String result="N";

try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_QTY_UOM_DESC") ) ;
			pstmt.setString(1, uom_code);
			rs = pstmt.executeQuery() ;
			while (rs.next()){			
			result=rs.getString(1);
			}

}
catch( Exception e )
	{
		e.printStackTrace() ;
	}
finally
	{
	try{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		} catch (Exception ee) {
				ee.printStackTrace() ;
		}
	}
	return result;
}
/*******************************************/


/********Gives the DataBase Record if already  present or for Ascc /else Original DataBase record***********/
public synchronized HashMap Validaty(HashMap record ){
try{


	String pk[] ={(String)record.get("order_catalog_code")};//Primary Key

	int index =	componentStr.containsElement(pk) ;


	 if(index != -1){//Rec is there in Ascc store

		HashMap tempChk	 =(HashMap)componentStr.getObject(index);
		String valid = (String)tempChk.get("valid");


		if(valid.trim().equalsIgnoreCase("Y")){//if it was form DataBase
			int indexOriginal = componentStr.containsElementInOriginalDB(pk);
			if(indexOriginal != -1)
				return (HashMap)componentStr.getObjectOriginal(indexOriginal) ;//DataBase record
			else
				return null ;//Some Error Condition Chk it
		}else
			return (HashMap)componentStr.getObject(index) ;//Ascc record

	 }else{ //not in ascc store

		return record;
	  }	 //return Original
	}catch(Exception e){
	 e.printStackTrace();
	 return null ;
	}
}
/**********************Handle Action in all scenario's***********************/
public synchronized  void handleAction(HttpServletRequest request){


  String detailPageMode_p	=request.getParameter("detailPageMode") ;
  this.action				=request.getParameter("action") ;

//All sync done js--Sync method and not here
//Scenario will be called in apply Method

//No mode
  if(detailPageMode_p.equalsIgnoreCase("N")){

	if(action.equalsIgnoreCase("IndexSelect")) {//scenario
	loadIndexData(request);

	this.detailPageMode = "S" ;
	}

	if(action.equalsIgnoreCase("select")) //scenario
	this.detailPageMode = "S" ;

	if(action.equalsIgnoreCase("associated"))//scenario
	this.detailPageMode = "A" ;

	//loadRecordedData(request);//scenario   DB records already ascc
	loadRecordedData();//scenario   DB records already ascc

 }

 //Select mode
 if(detailPageMode_p.equalsIgnoreCase("S")){
//	updateCurrentPageForAsscStore(request);//scenario  --even in case of next prev

	if(action.equalsIgnoreCase("indexSelect")){//scenario
	loadIndexData(request);
	this.detailPageMode = "S" ;
	}

	if(action.equalsIgnoreCase("associated")){//Scenario
	this.detailPageMode = "A" ;
	}
}
 //Ass mode
 if(detailPageMode_p.equalsIgnoreCase("A")){
//	synAsscStore(request);//scenario --even in case of next prev
  	this.detailPageMode = "A" ;
}

}//End of Handle Method
 /******************************************************************************/
// public synchronized int  loadRecordedData(HttpServletRequest request){
public synchronized int  loadRecordedData(){



//Used in  update mode only

if(careSetHeaderStr.isEmpty()) //i:e in the insert mode
	return 0 ;


if(componentStr.getSize("DB")>0)
	return componentStr.getSize("DB");

Connection connection		  = null ;
PreparedStatement pstmt		  = null ;
ResultSet rs				  = null;
String sql		 ="";


try
{
		connection	 =  getConnection();
		sql			 = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_LOAD_COMPONENT") ;
		pstmt		 = connection.prepareStatement(sql);
		pstmt.setString(1,(String)careSetHeaderStr.get("order_set_code"));

	    rs           = pstmt.executeQuery();


		while(rs.next()){
		HashMap tempHash = new HashMap();//Represents each record
			HashMap tempHashO = new HashMap();//Represents each record

	    loadOrderTypeCodeFreq(rs.getString("order_category"),rs.getString("order_catalog_code"));

		HashMap orderFreqStr = getOrderFreqStr();
		ArrayList freq_val	   =(ArrayList)orderFreqStr.get("value") ;
		ArrayList freq_desc    =(ArrayList)orderFreqStr.get("Description") ;

		HashMap  orderTypeStr = getOrderTypeStr();
		ArrayList order_val	   =(ArrayList)orderTypeStr.get("value") ;
		ArrayList order_desc   =(ArrayList)orderTypeStr.get("Description") ;


		tempHash.put("order_category"		,rs.getString("order_category"));
		tempHash.put("order_catalog_code"	,rs.getString("order_catalog_code"));
		tempHash.put("order_catalog_desc"	,rs.getString("short_desc"));
		tempHash.put("order_type_code"		,rs.getString("order_type_code"));
		tempHash.put("order_type_desc"		,rs.getString("order_type_desc"));
		tempHash.put("order_set_seq_num"	,rs.getString("order_set_seq_num"));
		tempHash.put("prompt_msg"		 ,rs.getString("item_narration")); //Not used in 2nd phase
		tempHash.put("qty_value"	         ,checkForNull(rs.getString("qty_unit"),"1"));
//		tempHash.put("qty_value"	         ,""); //Not used in 2nd phase
		tempHash.put("route_code"	         ,""); //Not used in 2nd phase
		tempHash.put("qty_unit"				 ,checkForNull(rs.getString("qty_value"),""));
 
 
		tempHash.put("qty_reqd_yn"		     ,checkForNull(rs.getString("qty_reqd_yn"),"N"));
		tempHash.put("freq_applicable_yn"	 ,checkForNull(rs.getString("freq_applicable_yn"),"N"));
		tempHash.put("freq_code"			 ,checkForNull(rs.getString("freq_code")));
		tempHash.put("durn_value"			 ,checkForNull(rs.getString("durn_value")));
		tempHash.put("durn_type"			 ,checkForNull(rs.getString("durn_type")));
		tempHash.put("freq_val_opts"		 ,freq_val);
		tempHash.put("freq_desc_opts"		 ,freq_desc);
		tempHash.put("order_val_opts"		 ,order_val);
		tempHash.put("order_desc_opts"		 ,order_desc);
		tempHash.put("rel_start_date_time"	 ,checkForNull(rs.getString("rel_start_date_time")));
		tempHash.put("reqd_or_opt_ind"		 ,checkForNull(rs.getString("reqd_or_opt_ind")));
		tempHash.put("valid"				,"Y");
		tempHash.put("associate_yn"			,"Y");
		tempHash.put("status"				,"Y");


		tempHashO.put("order_category"	,rs.getString("order_category"));
		tempHashO.put("order_catalog_code"	,rs.getString("order_catalog_code"));
		tempHashO.put("order_catalog_desc"	,rs.getString("short_desc"));
		tempHashO.put("order_type_code"		,rs.getString("order_type_code"));
		tempHashO.put("order_type_desc"		,rs.getString("order_type_desc"));
		tempHashO.put("order_set_seq_num"	,rs.getString("order_set_seq_num"));
		tempHashO.put("prompt_msg"		 ,rs.getString("item_narration"));//Not used in 2nd phase
		tempHashO.put("qty_value"	         ,checkForNull(rs.getString("qty_unit"),"1")); //Not used in 2nd phase
	//	tempHashO.put("qty_value"	         ,""); //Not used in 2nd phase
		tempHashO.put("route_code"	         ,""); //Not used in 2nd phase
		tempHashO.put("qty_unit"			 ,checkForNull(rs.getString("qty_value"),""));
		tempHashO.put("qty_reqd_yn"			 ,checkForNull(rs.getString("qty_reqd_yn"),"N"));
		tempHashO.put("freq_applicable_yn"	 ,checkForNull(rs.getString("freq_applicable_yn"),"N"));
		tempHashO.put("freq_code"			 ,checkForNull(rs.getString("freq_code")));
		tempHashO.put("durn_value"			 ,checkForNull(rs.getString("durn_value")));
		tempHashO.put("durn_type"			 ,checkForNull(rs.getString("durn_type")));
		tempHashO.put("freq_val_opts"		 ,freq_val);
		tempHashO.put("freq_desc_opts"		 ,freq_desc);
		tempHashO.put("order_val_opts"		 ,order_val);
		tempHashO.put("order_desc_opts"		 ,order_desc);
		tempHashO.put("rel_start_date_time"	 ,checkForNull(rs.getString("rel_start_date_time")));
		tempHashO.put("reqd_or_opt_ind"		 ,checkForNull(rs.getString("reqd_or_opt_ind")));
		tempHashO.put("valid"				,"Y");
		tempHashO.put("associate_yn"		,"Y");
		tempHashO.put("status"				,"Y");

		componentStr.putObject(tempHash);
		componentStr.putObjectOriginal(tempHashO);
	} //End of while loop


  }catch(Exception e){

			e.printStackTrace();
			tempChk.append("in loadRecordedData exception="+e);
  }finally{
		try
		 {
		 	closeResultSet( rs );
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){

             e.printStackTrace() ;

		 }
  }

   return componentStr.getSize("DB");

}
/***********************************************************************/
private int  loadIndexData(HttpServletRequest request){

	Connection connection		  = null ;
	PreparedStatement pstmt		  = null ;
	PreparedStatement pstmt1	  = null;
	ResultSet rs				  = null;
	ResultSet rs1				  = null;
	String order_category		  = request.getParameter("order_category");
	String OrderCatalogIndex	  = request.getParameter("OrderCatalogIndex");

	String sql					  = "";


try
{
	connection	 = getConnection();
	if(!order_category.trim().equalsIgnoreCase("CS")){
		if(!OrderCatalogIndex.trim().equalsIgnoreCase("others")){

		  sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_CATALOG_CODE") ;
		  pstmt = connection.prepareStatement(sql);
		  pstmt.setString(1,order_category.trim());
  		  pstmt.setString(2,order_category.trim());
  		  pstmt.setString(3,OrderCatalogIndex.trim() + "%");
		}else{
  		  sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_CATALOG_CODE_OTHRS") ;
		  pstmt = connection.prepareStatement(sql);
		  pstmt.setString(1,order_category.trim());
  		  pstmt.setString(2,order_category.trim());
		}
	}else{//Load all catalog's
		if(!OrderCatalogIndex.trim().equalsIgnoreCase("others")){
		  sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_CATALOG_CODE_ALL") ;
		  pstmt = connection.prepareStatement(sql);
		  pstmt.setString(1,OrderCatalogIndex.trim() + "%");
		}else{
  		 sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_CATALOG_CODE_OTHRS_ALL") ;
		  pstmt = connection.prepareStatement(sql);
		 }
	}


	rs = pstmt.executeQuery();

	componentStr.clearSelectRec();//first clear  the  prevoius record.
HashMap tempHash=null;
String sql1="";
String freq_code ="";
String qty_unit ="";
String durn_value = "";
String durn_type = "";
HashMap orderFreqStr = null;
ArrayList freq_val	   = null;
ArrayList freq_desc    = null;

HashMap  orderTypeStr =  null;
ArrayList order_val	   = null;
ArrayList order_desc   = null;
	while(rs.next()){
		tempHash = new HashMap();//Represents each record

		loadOrderTypeCodeFreq(rs.getString("order_category"),rs.getString("order_catalog_code"));

		rs1			  = null;
		pstmt1	  = null ;

		sql1 = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_PTCL_ALL") ;
		pstmt1		= connection.prepareStatement(sql1);
		pstmt1.setString(1,rs.getString("order_catalog_code"));
		rs1 = pstmt1.executeQuery();

		while(rs1.next()){
			freq_code =	 checkForNull(rs1.getString("FREQ_CODE"),"")  ;
			qty_unit  =  checkForNull( rs1.getString("QTY_VALUE"),"1")  ;
			durn_value = checkForNull(rs1.getString("DURN_VALUE"),"")  ;

	//		durn_type  = checkForNull( rs1.getString("durn_type"),"1")  ;

			durn_type  = checkForNull( rs1.getString("durn_type"),"")  ;

			if(freq_code.trim().equals("")){
			   durn_value = "";
  			   durn_type = "";
			}


			if(qty_unit.trim().equals("0") || qty_unit.trim().equals(""))
			qty_unit = "1";

		}

		closeResultSet(rs1);	
		closeStatement(pstmt1);
		//if(rs1!=null)rs1.close();
		//if(pstmt1!=null)pstmt1.close();

		 orderFreqStr = getOrderFreqStr();
		 freq_val	   =(ArrayList)orderFreqStr.get("value") ;
		 freq_desc    =(ArrayList)orderFreqStr.get("Description") ;

		 orderTypeStr = getOrderTypeStr();
		 order_val	   =(ArrayList)orderTypeStr.get("value") ;
		 order_desc   =(ArrayList)orderTypeStr.get("Description") ;



		tempHash.put("order_category"		 ,rs.getString("order_category"));
		tempHash.put("order_catalog_code"	 ,rs.getString("order_catalog_code"));
		tempHash.put("order_catalog_desc"	 ,rs.getString("short_desc"));
		tempHash.put("order_type_code"		 ,rs.getString("order_type_code"));
		tempHash.put("order_type_desc"		 ,rs.getString("order_type_desc"));
		tempHash.put("order_set_seq_num"	 ,"");
		tempHash.put("item_narration"		 ,""); //Not used in 2nd phase
		tempHash.put("qty_value"	         ,""); //Not used in 2nd phase
		tempHash.put("route_code"	         ,""); //Not used in 2nd phase
		tempHash.put("qty_unit"				 ,qty_unit);
		tempHash.put("qty_reqd_yn"			 ,checkForNull(rs.getString("qty_reqd_yn"),"N"));
		tempHash.put("freq_applicable_yn"	 ,checkForNull(rs.getString("freq_applicable_yn"),"N"));
		tempHash.put("freq_code"			 ,freq_code);
		tempHash.put("durn_value"			 ,durn_value);
		tempHash.put("durn_type"			 ,durn_type);
		tempHash.put("freq_val_opts"		 ,freq_val);
		tempHash.put("freq_desc_opts"		 ,freq_desc);
		tempHash.put("order_val_opts"		 ,order_val);
		tempHash.put("order_desc_opts"		 ,order_desc);
		tempHash.put("rel_start_date_time"	 ,"");
		tempHash.put("reqd_or_opt_ind"		 ,"");
		tempHash.put("valid"				 ,"N");
		tempHash.put("associate_yn"			 ,"N");
		tempHash.put("status"				 ,"N");

		componentStr.putListObject(tempHash);
	}



	}catch(Exception e){

			e.printStackTrace();
			tempChk.append("Exception in sQL" + e);
	}finally{
		try
		 {
		 	closeResultSet(rs1);
		 	closeStatement(pstmt1);
		 	closeResultSet(rs);
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){

			 e.printStackTrace() ;

		 }
	}
	return componentStr.getSize("SELECT");
}


/**********Deerag ADDDED AND USED ***************************/
public synchronized void loadOrderTypeCodeFreq(String  order_category, String order_catalog){
  	Connection connection			= null ;
	PreparedStatement pstmt			= null ;
	ResultSet rs					= null;
	orderTypeStr					= new HashMap();

	try{

		String sqlFreq				  = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_FREQ_CODE");
		String sqlOrderType			  = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ORDER_TYPE_CODE1");


		connection   =	getConnection();

		String sqlParamOrder[] ={order_category.trim(),order_catalog.trim()};
		String sqlParamFreq[]  ={order_category.trim(), order_catalog.trim()};


		orderTypeStr =	Populate.getAsHashArray(sqlOrderType,connection,"order_type_code","short_desc",sqlParamOrder) ;
		orderFreqStr =	Populate.getAsHashArray(sqlFreq,connection,"freq_code","freq_desc",sqlParamFreq) ;

	}catch(Exception e){

			e.printStackTrace();
			tempChk.append("Exception in sQL" + e);
	}finally{
		try
		 {
					closeResultSet(rs);
					closeStatement(pstmt);
					closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;

		 }
	}
}
/********************************************************************/
public synchronized int getRecordsNo(){
if(detailPageMode.equalsIgnoreCase("A"))
	return componentStr.getSize("DB") ;
else
	return componentStr.getSize("SELECT") ;
}
/*******************************************************************/
public synchronized Object getRecord( int i){
try{
	if(detailPageMode.equalsIgnoreCase("A")){
	return componentStr.getObject(i) ;
	}else{
	return componentStr.getListObject(i) ;}
}catch(Exception e){
	return null ;
}
}
 /************Methos to Short Record for Associate mode*************/
 public  synchronized void SortedArrayListAscc(){


  java.util.ArrayList tempRef		= componentStr.getAllDBRecords();
  java.util.TreeMap sorter			= new java.util.TreeMap();
  java.util.ArrayList holdDuplicate = new java.util.ArrayList();

  int sizeAscc = tempRef.size(); //ref of the Object DB Array List
	HashMap tempHash=null;
	String seqNoStr="";
	Integer seqNo=null;
  for(int i=0 ; i < sizeAscc ; i++){
	   tempHash = (java.util.HashMap)tempRef.get(i);
	  seqNoStr = checkForNull(((String)tempHash.get("order_set_seq_num")),"8888");
      seqNo   = new Integer( Integer.parseInt(seqNoStr));
	  if(!sorter.containsKey(seqNo)){
		  sorter.put(seqNo,tempHash);
	  }else{
		  holdDuplicate.add(tempHash);//array List of Dup records
	  }
 }

	tempRef.clear();//Clear  the  DB  records

	Collection  coll = sorter.values();
	Iterator iter    = coll.iterator();

	int dupSize = holdDuplicate.size();
	HashMap tempSrt	 =null;
	String  seqNoStr1  ="";
	 HashMap tempDup=null;
	  String seqNoStr2="";

	while(iter.hasNext()){
	  tempSrt	 =(java.util.HashMap)iter.next();
	 seqNoStr1  =checkForNull(((String)tempSrt.get("order_set_seq_num")),"8888");
      int     seqNoSrt   =Integer.parseInt(seqNoStr1);

	  for(int j=0;j<dupSize;j++){
	  tempDup	= (java.util.HashMap)holdDuplicate.get(j);
	   seqNoStr2	= checkForNull(((String)tempDup.get("order_set_seq_num")),"8888");
      int  seqNoDup		=Integer.parseInt(seqNoStr2);
	  if(seqNoSrt == seqNoDup)
	  tempRef.add(tempDup);	//inserting Dup Values
	  }
  	  tempRef.add(tempSrt);
	}
}
/***************************************************************************/
public void clearComponentStr(){
	componentStr.clearDBRec();
	componentStr.clearSelectRec();
	componentStr.clearDBRecOriginal();
}
/****chk whether parameter is coming from the client*******UTILTIY METHOD***/
private String  chkPresent(Hashtable ht,String param , String defaultVal){
	if(ht.containsKey(param))
	return	checkForNull((String)ht.get(param),defaultVal);
	else
	return  defaultVal ;
}
/***********UTILITY METHOD This is method called from jsp for get rec in a particular array list at given index ----
if not retrun  the  default value******/
public String getdefaultArrListValue(ArrayList ar ,int recIndex ,String  key , String defaultVal){

	boolean flag = ar.isEmpty();
	int size	 = ar.size() ;

	if( (recIndex >= size) || flag )
		return defaultVal;


	HashMap currRec = (HashMap)ar.get(recIndex);

	if(currRec.containsKey(key))
	return	checkForNull((String)currRec.get(key),defaultVal);
	else
	return   defaultVal ;

}

/*****************Synchronization*****************************/
public synchronized boolean doSync(Hashtable request) throws Exception{
try
{
	String tabType  = "";


	if(request.containsKey("tabType"))
		tabType = (String)request.get("tabType");


	if(tabType.trim().equalsIgnoreCase("S"))
		synonymsSync(request);

	if(tabType.trim().equalsIgnoreCase("Se"))
		settingsSync(request);

	if(tabType.trim().equalsIgnoreCase("C"))
		componentSyn(request);

	if(tabType.trim().equalsIgnoreCase("E"))
		explanatorySync(request);
	
	return true;

    }catch(Exception e){
			e.printStackTrace();
	   throw new Exception(e.getMessage());
  }
}
/**********************Store the Freq,dura type,value for Components Tab********/
//public synchronized void setSettingsFreqStr(String OrderCategory){
public synchronized void setSettingsFreqStr(){
try
	{
		String param[] =  {};


		if(settingsFreqStr == null)//Only for the first time
		settingsFreqStr  = getSqlResultParam("SQL_OR_ORDERSET_FREQ_CODE_MAP",param);

		Integer	noOfRecTemp			 = (Integer)settingsFreqStr.get("noRec");
		int noOfRecordsFreq			 = noOfRecTemp.intValue() ;


		settingsFreqStrMapper = new HashMap() ;
		if(noOfRecordsFreq != 0){
			HashMap temp=null;
		  for(int i=1 ; i <= noOfRecordsFreq; i++){
			temp = new HashMap();
			temp.put("durn_value",checkForNull((String)settingsFreqStr.get("DURN_VALUE"+i)));	temp.put("durn_type" ,checkForNull((String)settingsFreqStr.get("DURN_TYPE"+i)));	temp.put("durn_desc" ,checkForNull((String)settingsFreqStr.get("DURN_DESC"+i)));	settingsFreqStrMapper.put(checkForNull((String)settingsFreqStr.get("FREQ_CODE"+i)),temp);
		  }
        }


	}catch (Exception e){
		 tempChk.append("Exception in setSettingsFreqStr =" + e.getMessage());

	}

}
/**********************Store the Freq,dura type,value for Setting Tab********/
public synchronized void setSettingsDurnStr(){
	try
	{
		if(settingsDurnStr == null)//Only for the first time
			settingsDurnStr  = getSqlResult("SQL_OR_CATALOG_DURATIONS");
}catch(Exception e){e.printStackTrace() ;
}
}
/************************************************************************/
public HashMap getFreqRec(String freq_code) throws Exception{

if(freq_code == null )
	throw new Exception("freq_code passed is null");

try{
    	Object objTemp  = settingsFreqStrMapper.get(freq_code.trim());


		if(objTemp == null)
			throw new Exception("Cannot find Freq_code in settingsFreqStr..exc raised in  getFreqRec function in OrdercatalogBean ");
		else
			return (HashMap)objTemp ;

}catch (Exception e){
	throw new Exception(e.getMessage());
}

}

/*************************just get the result***************/
public  HashMap getSqlResult(String key) throws Exception{
Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet rs			= null;
ResultSetMetaData rsmd	= null ;
String 	columnName		= null ;
int 	columnCount		= -1 ;

HashMap result = new HashMap();
String sql = "";
try
{
	connection = getConnection();
	sql = OrRepository.getOrKeyValue(key.trim());
	pstmt	   = connection.prepareStatement(sql);
	if(key.trim().equals("SQL_OR_PATIENT_CLASS_LIST"))
	pstmt.setString(1,language_id);
	rs		   = pstmt.executeQuery()  ;
	rsmd	   = rs.getMetaData()      ;
	columnCount= rsmd.getColumnCount() ;
	int counter= 0 ;


	while (rs.next()){
		counter++;
		for(int i = 1; i <= columnCount ; i++){
		columnName	= rsmd.getColumnName(i)  ;
		result.put((columnName+counter),ChkDef.defaultString(rs.getString(columnName)));
		}

	}

	result.put("noRec",new Integer(counter));


	return result ;
}catch(Exception e){
		e.printStackTrace();
	    throw new Exception(e.getMessage());
}finally{
	try{
		closeResultSet(rs);
		closeStatement(pstmt);
		closeConnection(connection);
	 }catch(Exception e){e.printStackTrace() ;}
}

}
/*************************just get the result***************/
public  HashMap getSqlResultParam(String key , String[] params) throws Exception{
Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet rs			= null;
ResultSetMetaData rsmd	= null ;
String 	columnName		= null ;
int 	columnCount		= -1 ;

HashMap result = new HashMap();

int paramslen  = params.length ;

try
{
	connection = getConnection();
	String sql = OrRepository.getOrKeyValue(key.trim());

	pstmt	   = connection.prepareStatement(sql);

	for (int i = 0; i < paramslen ; i++ ){
	pstmt.setString(i+1, (params[i]).trim());
	}

	rs		   = pstmt.executeQuery()  ;
	rsmd	   = rs.getMetaData()      ;
	columnCount= rsmd.getColumnCount() ;
	int counter= 0 ;

	while (rs.next()){
		counter++;
		for(int i = 1; i <= columnCount ; i++){
		columnName	= rsmd.getColumnName(i)  ;
		result.put((columnName+counter),ChkDef.defaultString(rs.getString(columnName)));
		}
	}

	result.put("noRec",new Integer(counter));

	return result ;
}catch(Exception e){
	e.printStackTrace();
	throw new Exception(e.getMessage());
}finally{
	try{
		closeResultSet(rs);
		closeStatement(pstmt);
		closeConnection(connection);
	 }catch(Exception e){e.printStackTrace() ;}
}

}


/******************INSERTION LOGIC For EJB****************************/

/*******************this method give range of duplicates******************/
private boolean chkDuplicate(String sql,Connection con , String arr[]) throws Exception{
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
	PreparedStatement pstmt = null;
	ResultSet rs	         = null ;
try{


		boolean dupFlag = false ;

		pstmt = con.prepareStatement(sql);

		
		int size				= arr.length ;



		for(int i =0 ; i < size ; i++){
			pstmt.setString(i+1,arr[i]);
		}



		rs = pstmt.executeQuery();

		int count = 0;

		if(rs.next())
			count = rs.getInt(1);

		if(count > 0)
		dupFlag = true ;


		return dupFlag;

		}catch(Exception e){
				e.printStackTrace();
				traceVal.append(e);
				messages.append(e.getMessage());
				throw e;
	 }
	 finally{
		 	closeResultSet(rs);
			closeStatement(pstmt);
 }

}//End of dulicate chk




public HashMap insert(HashMap tabDataParam , HashMap sqlMap ){




StringBuffer messages =  null ;
StringBuffer traceVal =  null ;
HashMap map =null;
Connection connection =  null ;
PreparedStatement pstmt_cr	    	= null ;
PreparedStatement pstmt_comp	    = null ;
PreparedStatement pstmt_syn		= null ;
PreparedStatement pstmt_ptcl		= null ;
try {
		messages = new StringBuffer() ;
		traceVal = new StringBuffer() ;
		map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "flag" ) ;



		HashMap tabData_p			=(HashMap)tabDataParam.get("tabData");

		HashMap	 careSetHeaderStr	=(HashMap)tabData_p.get("careSetHeaderStr");

		ArrayList componentStr		=(ArrayList)tabData_p.get("componentStr");

		ArrayList synonymsRec		=(ArrayList)tabData_p.get("synonymsStr");//passed as arrayList
		HashMap synonymsStr			=(HashMap)synonymsRec.get(0);
		ArrayList settingsStr		=(ArrayList)tabData_p.get("settingsStr");


		String login_by_id			=(String)tabData_p.get("login_by_id" ) ;
		String login_at_ws_no		=(String)tabData_p.get("login_at_ws_no" ) ;
		String login_facility_id	=(String)tabData_p.get("login_facility_id" ) ;


	 	 connection = getConnection() ;
		 
		 String SQL_OR_ORDERSET_DUP_CHK					= (String)sqlMap.get("SQL_OR_ORDERSET_DUP_CHK");
		 String SQL_OR_ORDERSET_INSERT					= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT");
		 String SQL_OR_ORDERSET_INSERT_SYNONYM			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_SYNONYM");
		 String SQL_OR_ORDERSET_INSERT_BY_PTCL			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_BY_PTCL");
		 String SQL_OR_ORDERSET_INSERT_COMP				= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_COMP");


		 String order_set_code							=(String)careSetHeaderStr.get("order_set_code") ;
		 traceVal.append("order_set_code="+order_set_code)	   ;
		 String	order_category							=(String)careSetHeaderStr.get("order_category") ;
		 String order_type_code							=(String)careSetHeaderStr.get("order_type_code") ;


		/********DUPLICATE CHK*****************************************/
		String arrChkDup[]  =  new String[1] ;

		arrChkDup[0] = order_set_code ;

		traceVal.append("Before dup chk");

		boolean duplicate = chkDuplicate(SQL_OR_ORDERSET_DUP_CHK,connection,arrChkDup);

		traceVal.append("After dup chk");

		if(duplicate){
		  String msg  =	 "CODE_ALREADY_EXISTS";
		  map.put( "message", msg ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;
		}

		/*************************************************************/

		pstmt_cr										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT);
		pstmt_syn										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_SYNONYM);
		pstmt_ptcl										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_BY_PTCL);
		pstmt_comp										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_COMP);


		int	insert_cr		= -1 ;
		int	insert_syn[]	= {} ;
		int	insert_ptcl[]	= {} ;
		int	insert_comp[]	= {} ;

		/******************INSERT INTO ORDER_CATALOG*************/


		pstmt_cr.setString(1	,order_set_code);
		pstmt_cr.setString(2	,(String)careSetHeaderStr.get("long_desc"));
		pstmt_cr.setString(3	,(String)careSetHeaderStr.get("short_desc"));
		pstmt_cr.setString(4	,(String)careSetHeaderStr.get("order_category"));
		pstmt_cr.setString(5	,order_type_code);
		pstmt_cr.setString(6	,(String)careSetHeaderStr.get("security_level"));
		pstmt_cr.setString(7	,(String)careSetHeaderStr.get("explanatory_text"));
		pstmt_cr.setString(8	,"S");
		pstmt_cr.setString(9	,"N");
		pstmt_cr.setString(10	,"");
		pstmt_cr.setString(11	,"N");
		pstmt_cr.setString(12	,"");
		pstmt_cr.setString(13	,"N");
		pstmt_cr.setString(14	,"");
		pstmt_cr.setString(15	,"N");
		pstmt_cr.setString(16	,"N");
		pstmt_cr.setString(17	,"N");
		pstmt_cr.setString(18	,"N");
		pstmt_cr.setString(19	,"N");
		pstmt_cr.setString(20	,"N");
		pstmt_cr.setString(21	,"");
		pstmt_cr.setString(22	,"N");
		pstmt_cr.setString(23	,"");
		pstmt_cr.setString(24	,"");
		pstmt_cr.setString(25	,"");
		pstmt_cr.setString(26	,"");
		pstmt_cr.setString(27	,"");
		pstmt_cr.setString(28	,"");
		pstmt_cr.setString(29	,"");
		pstmt_cr.setString(30	,"");
		pstmt_cr.setString(31	,"");
		pstmt_cr.setString(32	,"");
		pstmt_cr.setString(33	,"N");
		pstmt_cr.setString(34	,"");
		pstmt_cr.setString(35	,"N");
		pstmt_cr.setString(36	,"N");
		pstmt_cr.setString(37	,"N");
		pstmt_cr.setString(38	,"N");
		pstmt_cr.setString(39	,"N");
		pstmt_cr.setString(40	,"N");
		pstmt_cr.setString(41	,"");
		pstmt_cr.setString(42	,"");
		pstmt_cr.setString(43	,"");
		pstmt_cr.setString(44	,"");
		pstmt_cr.setString(45	,"");
		pstmt_cr.setString(46	,(String)careSetHeaderStr.get("indexed_yn"));
		pstmt_cr.setString(47	,(String)careSetHeaderStr.get("eff_status"));
		pstmt_cr.setString(48	,login_by_id);
		pstmt_cr.setString(49	,login_at_ws_no);
		pstmt_cr.setString(50	,login_facility_id);
		pstmt_cr.setString(51	,login_by_id);
		pstmt_cr.setString(52	,login_at_ws_no);
		pstmt_cr.setString(53	,login_facility_id);
		pstmt_cr.setString(54	,"");//Little differnce in database name and bean name
   		pstmt_cr.setString(55	,"");//FROM SQL


		insert_cr = pstmt_cr.executeUpdate();

		traceVal.append("ORDER_CATALOG after Insetion insert_cr="+insert_cr) ;

		/**************INSERT INTO ORDER CATALOG SYNONYM**************/


		String 	effective_status_primary		= (String)synonymsStr.get("effective_status_primary") ;
		String 	effective_status_directCare		= (String)synonymsStr.get("effective_status_directCare") ;
		String 	effective_status_ancillaryDept	= (String)synonymsStr.get("effective_status_ancillaryDept") ;

		if(effective_status_primary.trim().equalsIgnoreCase("Y")){//This insertion is Mandatory
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"PR");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_primary"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_primary);//*************
			pstmt_syn.addBatch() ;

		}

		if(effective_status_directCare.trim().equalsIgnoreCase("Y")){
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"DC");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_directCare"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_directCare);//*************
			pstmt_syn.addBatch() ;
		}

		if(effective_status_ancillaryDept.trim().equalsIgnoreCase("Y")){
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"AD");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_ancillaryDept"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_ancillaryDept);//*************
			pstmt_syn.addBatch();
		
		}

			insert_syn = pstmt_syn.executeBatch();

			traceVal.append("after insertion sysn="+insert_syn.length);

	/**************INSERT INTO OR_ORDER BY PTCL*******************/

			int sizeSettings			=settingsStr.size()  ;
			int iterateVal				=0;

			 traceVal.append("Settings="+sizeSettings + "   //////");


			iterateVal = sizeSettings ;

			HashMap tempSetting=null;
			String setting_applicability="";
			String patient_class="";

///Assumption that corresponding Index of a particular Patient Class is same in Both the tabs is  same
	for(int i = 0; i < iterateVal ; i++){//0 for the default

			    tempSetting = (HashMap)settingsStr.get(i);
				setting_applicability	    =(String)tempSetting.get("setting_applicability");

				if(setting_applicability.trim().equalsIgnoreCase("A") || i== 0 ){

				patient_class	=(String)tempSetting.get("patient_class");

				pstmt_ptcl.setString(1	 ,order_set_code);
				pstmt_ptcl.setString(2	 ,patient_class);
				pstmt_ptcl.setString(3	 ,"X");
				pstmt_ptcl.setString(4	 ,"N");
				pstmt_ptcl.setString(5	 ,"N");
				pstmt_ptcl.setString(6	 ,"N");
				pstmt_ptcl.setString(7	 ,"A");
				pstmt_ptcl.setString(8	 ,"");
				pstmt_ptcl.setString(9	 ,"");
				pstmt_ptcl.setString(10	 ,"");
				pstmt_ptcl.setString(11	 ,"");
				pstmt_ptcl.setString(12	 ,"");
				pstmt_ptcl.setString(13	 ,"");
				pstmt_ptcl.setString(14	 ,"");
				pstmt_ptcl.setString(15	 ,"");
				pstmt_ptcl.setString(16  ,"");
				pstmt_ptcl.setString(17	 ,login_by_id);
				pstmt_ptcl.setString(18	 ,login_at_ws_no);
				pstmt_ptcl.setString(19  ,login_facility_id);
				pstmt_ptcl.setString(20  ,login_by_id);
				pstmt_ptcl.setString(21  ,login_at_ws_no);
				pstmt_ptcl.setString(22  ,login_facility_id);
				pstmt_ptcl.setString(23  ,"");
				pstmt_ptcl.addBatch();
		   	}//end of For Loop for PTCL INSERTION
	}

				insert_ptcl = pstmt_ptcl.executeBatch();

				traceVal.append("afterInsertion="+insert_ptcl.length);
				
/*****************INSERTION FOR OR ORDER Set Component************/

		 int noOfRecords = componentStr.size() ;
		 HashMap currData=null;
		 String  associate_yn="";

		 for(int k=0 ; k< noOfRecords ; k++){
	     currData	     =(HashMap)componentStr.get(k);
		 associate_yn	 =(String)currData.get("associate_yn");

		traceVal.append("order_category="+order_category);

		 if(associate_yn.trim().equalsIgnoreCase("Y")){
			pstmt_comp.setString(1	,order_set_code);
			pstmt_comp.setString(2	,(String)currData.get("order_set_seq_num"));
			pstmt_comp.setString(3	,(String)currData.get("order_catalog_code"));
			pstmt_comp.setString(4	,(String)currData.get("order_type_code"));
			pstmt_comp.setString(5	,(String)currData.get("order_category"));//order_category
			pstmt_comp.setString(6	,(String)currData.get("reqd_or_opt_ind"));
			pstmt_comp.setString(7	,(String)currData.get("rel_start_date_time"));
			pstmt_comp.setString(8	,(String)currData.get("route_code"));
			pstmt_comp.setString(9	,(String)currData.get("qty_unit"));	 //Not in sec phase
	
			pstmt_comp.setString(10 ,(String)currData.get("qty_value"));		 //Not in sec phase*/
			pstmt_comp.setString(11 ,(String)currData.get("freq_code"));
			pstmt_comp.setString(12 ,(String)currData.get("durn_value"));
			pstmt_comp.setString(13 ,(String)currData.get("durn_type"));
			pstmt_comp.setString(14 ,(String)currData.get("prompt_msg"));//Not in sec phase		

			pstmt_comp.setString(15 ,login_by_id);
			pstmt_comp.setString(16 ,login_at_ws_no);
			pstmt_comp.setString(17 ,login_facility_id);
			pstmt_comp.setString(18 ,login_by_id);
			pstmt_comp.setString(19 ,login_at_ws_no);
			pstmt_comp.setString(20 ,login_facility_id);
			pstmt_comp.setInt(21 ,1);

			pstmt_comp.addBatch();

		 }//End of if


		 } //End of For loop

		insert_comp = pstmt_comp.executeBatch();

		traceVal.append("insert_comp="+insert_comp.length);

		boolean insert_cmp	=  false ;
		boolean insert_ptl	=  false ;
		boolean insert_sy	=  false ;


		 if((insert_comp.length > 0)){ //check updation in Component
					insert_cmp= true ;
		 }else if((insert_comp.length == (-3))){
					insert_cmp= false ;
		 }


		 if((insert_ptcl.length > 0)){ //check updation in PTCL
					insert_ptl= true ;
		 }else if((insert_ptcl.length == (-3))){
					insert_ptl= false ;
		 }


		 if((insert_syn.length > 0)){ //check updation in SYN
					insert_sy= true ;
		 }else if((insert_syn.length == (-3))){
					insert_sy= false ;
		 }


		if (insert_cr > 0  && insert_sy  && insert_cmp && insert_ptl){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_INSERTED") ;
		}else{
				connection.rollback();
				messages.append( "Insert Failed" ) ;
		}

	}catch( Exception e ){
					traceVal.append("In Exception==");
					e.printStackTrace();
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;

			try {
						connection.rollback();
						//closeConnection(connection);
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}
				messages.append( e.getMessage() ) ;
				e.printStackTrace() ;
    		  } finally{
	            	try {
						closeStatement(pstmt_cr);
						closeStatement(pstmt_comp);
						closeStatement(pstmt_syn);
						closeStatement(pstmt_ptcl);
						closeConnection(connection);
					} catch ( Exception fe ) {

					   	fe.printStackTrace() ;
			        }
	    	    }

			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			return map ;
}

/*****************MODIFY MODE ******************************/
public HashMap modify(HashMap tabDataParam , HashMap sqlMap ){

StringBuffer messages =  null ;
StringBuffer traceVal =  null ;
HashMap map =null;
Connection connection =  null ;
PreparedStatement del_pstmt_syn		= null ;
PreparedStatement del_pstmt_ptcl		= null ;
PreparedStatement del_pstmt_comp		= null ;
PreparedStatement pstmt_eff		= null ;
ResultSet	rs_eff					= null;
PreparedStatement pstmt_cr	    	= null ;
PreparedStatement pstmt_comp	    = null ;
PreparedStatement pstmt_syn		= null ;
PreparedStatement pstmt_ptcl		= null ;

try {
		messages = new StringBuffer() ;
		traceVal = new StringBuffer() ;
		map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "flag" ) ;



		HashMap tabData_p			=(HashMap)tabDataParam.get("tabData");

		HashMap	 careSetHeaderStr	=(HashMap)tabData_p.get("careSetHeaderStr");

		ArrayList componentStr		=(ArrayList)tabData_p.get("componentStr");
		ArrayList synonymsRec		=(ArrayList)tabData_p.get("synonymsStr");//passed as arrayList
		HashMap synonymsStr			=(HashMap)synonymsRec.get(0);
		ArrayList settingsStr		=(ArrayList)tabData_p.get("settingsStr");


		String login_by_id			=(String)tabData_p.get("login_by_id" ) ;
		String login_at_ws_no		=(String)tabData_p.get("login_at_ws_no" ) ;
		String login_facility_id	=(String)tabData_p.get("login_facility_id" ) ;


	 	 connection = getConnection() ;
		 pstmt_cr	    	= null ;
 		 pstmt_comp	    = null ;
 		 pstmt_syn		= null ;
  		 pstmt_ptcl		= null ;

		 String SQL_OR_ORDERSET_UPDATE					= (String)sqlMap.get("SQL_OR_ORDERSET_UPDATE");
		 String SQL_OR_ORDERSET_EFF_STATUS_SELECT		= (String)sqlMap.get("SQL_OR_ORDERSET_EFF_STATUS_SELECT");
		 String SQL_OR_ORDERSET_EFF_STATUS_UPDATE		= (String)sqlMap.get("SQL_OR_ORDERSET_EFF_STATUS_UPDATE");


		 String SQL_OR_ORDERSET_INSERT_SYNONYM			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_SYNONYM");
		 String SQL_OR_ORDERSET_INSERT_BY_PTCL			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_BY_PTCL");
		 String SQL_OR_ORDERSET_INSERT_COMP				= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_COMP");

		 String SQL_OR_ORDERSET_SYNONYM_DELETE			= (String)sqlMap.get("SQL_OR_ORDERSET_SYNONYM_DELETE");
		 String SQL_OR_ORDERSET_COMP_DELETE				= (String)sqlMap.get("SQL_OR_ORDERSET_COMP_DELETE");
		 String SQL_OR_ORDERSET_PTCL_DELETE				= (String)sqlMap.get("SQL_OR_ORDERSET_PTCL_DELETE");


		 String order_set_code							=(String)careSetHeaderStr.get("order_set_code") ;
		 traceVal.append("order_set_code="+order_set_code)	   ;
		 String	order_category							=(String)careSetHeaderStr.get("order_category") ;
		 String order_type_code							=(String)careSetHeaderStr.get("order_type_code") ;

		/*****EFFECTIVE STATUS CHK AND UPDATION*****************/
		 pstmt_eff		= null ;
		 rs_eff					= null;
		 String eff_status					= "";

		 pstmt_eff = connection.prepareStatement(SQL_OR_ORDERSET_EFF_STATUS_SELECT);

		 pstmt_eff.setString(1,order_set_code.trim());
		 rs_eff	= pstmt_eff.executeQuery();

		 if(rs_eff.next())
			eff_status =   rs_eff.getString("eff_status");

		
		 closeStatement( pstmt_eff ) ;

		 if(eff_status.trim().equalsIgnoreCase("D")){//Update only the Eff Status and return

			pstmt_eff = connection.prepareStatement(SQL_OR_ORDERSET_EFF_STATUS_UPDATE);

			pstmt_eff.setString(1 ,(String)careSetHeaderStr.get("eff_status"));
			pstmt_eff.setString(2 ,login_by_id);
			pstmt_eff.setString(3 ,login_at_ws_no);
			pstmt_eff.setString(4 ,login_facility_id);
			pstmt_eff.setString(5 ,order_set_code.trim());


			int update_eff_status = pstmt_eff.executeUpdate();

			if(update_eff_status > 0){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_INSERTED") ;

				map.put( "message", messages.toString() ) ;
				map.put( "traceVal", traceVal.toString() ) ;
				return map ;
			}

	     }

		/****************DELETE RECORD IN THREE TABLES*****************/

		 del_pstmt_syn		= null ;
  		 del_pstmt_ptcl		= null ;
		 del_pstmt_comp		= null ;

		 int update_syn_del_status =  0;
		 int update_ptcl_del_status =  0;
		 int update_comp_del_status =  0;

		 del_pstmt_syn = connection.prepareStatement(SQL_OR_ORDERSET_SYNONYM_DELETE);
		 del_pstmt_syn.setString(1,order_set_code.trim());
		 update_syn_del_status = del_pstmt_syn.executeUpdate();


  		traceVal.append("del=syn");


		 del_pstmt_ptcl = connection.prepareStatement(SQL_OR_ORDERSET_PTCL_DELETE);
		 del_pstmt_ptcl.setString(1,order_set_code.trim());
		 update_ptcl_del_status = del_pstmt_ptcl.executeUpdate();

 		traceVal.append("del=ptcl");

		 del_pstmt_comp = connection.prepareStatement(SQL_OR_ORDERSET_COMP_DELETE);
		 del_pstmt_comp.setString(1,order_set_code.trim());
		 update_comp_del_status = del_pstmt_comp.executeUpdate();

 		traceVal.append("del=inst");

		 if(update_syn_del_status < 0 || update_ptcl_del_status < 0  || update_comp_del_status < 0  ){
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				messages.append("Faliure") ;
				map.put( "message", "Some prob in delete" ) ;
				map.put( "traceVal", "Some prob in delete" ) ;
				return map ;
			}

		traceVal.append("delete done");



		/*************************************************************/

		pstmt_cr										= connection.prepareStatement(SQL_OR_ORDERSET_UPDATE);
		pstmt_syn										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_SYNONYM);
		pstmt_ptcl										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_BY_PTCL);
		pstmt_comp										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_COMP);


		int	update_cr	= -1 ;
		int	insert_syn[]	= {} ;
		int	insert_ptcl[]	= {} ;
		int	insert_comp[]	= {} ;

		/******************UPDATE INTO ORDER_CATALOG*************/


		pstmt_cr.setString(1	,(String)careSetHeaderStr.get("long_desc"));
		pstmt_cr.setString(2	,(String)careSetHeaderStr.get("short_desc"));
		pstmt_cr.setString(3	,(String)careSetHeaderStr.get("order_category"));
		pstmt_cr.setString(4	,order_type_code);
		pstmt_cr.setString(5	,(String)careSetHeaderStr.get("security_level"));
		pstmt_cr.setString(6	,(String)careSetHeaderStr.get("explanatory_text"));
		pstmt_cr.setString(7	,"S");
		pstmt_cr.setString(8	,"N");
		pstmt_cr.setString(9	,"");
		pstmt_cr.setString(10	,"N");
		pstmt_cr.setString(11	,"");
		pstmt_cr.setString(12	,"N");
		pstmt_cr.setString(13	,"");
		pstmt_cr.setString(14	,"N");
		pstmt_cr.setString(15	,"N");
		pstmt_cr.setString(16	,"N");
		pstmt_cr.setString(17	,"N");
		pstmt_cr.setString(18	,"N");
		pstmt_cr.setString(19	,"N");
		pstmt_cr.setString(20	,""); //from sql
		pstmt_cr.setString(21	,"N");
		pstmt_cr.setString(22	,"");
		pstmt_cr.setString(23	,"");
		pstmt_cr.setString(24	,"");
		pstmt_cr.setString(25	,"");
		pstmt_cr.setString(26	,"");
		pstmt_cr.setString(27	,"");
		pstmt_cr.setString(28	,"");
		pstmt_cr.setString(29	,"");
		pstmt_cr.setString(30	,"");
		pstmt_cr.setString(31	,"");
		pstmt_cr.setString(32	,"N");
		pstmt_cr.setString(33	,"");
		pstmt_cr.setString(34	,"N");
		pstmt_cr.setString(35	,"N");
		pstmt_cr.setString(36	,"N");
		pstmt_cr.setString(37	,"N");
		pstmt_cr.setString(38	,"N");
		pstmt_cr.setString(39	,"N");
		pstmt_cr.setString(40	,"");
		pstmt_cr.setString(41	,"");
		pstmt_cr.setString(42	,"");
		pstmt_cr.setString(43	,"");
		pstmt_cr.setString(44	,"");
		pstmt_cr.setString(45	,(String)careSetHeaderStr.get("indexed_yn"));
		pstmt_cr.setString(46	,(String)careSetHeaderStr.get("eff_status"));
		pstmt_cr.setString(47	,"");
		pstmt_cr.setString(48	,login_by_id);
		pstmt_cr.setString(49	,login_at_ws_no);
		pstmt_cr.setString(50	,login_facility_id);
		pstmt_cr.setString(51	,"");
		pstmt_cr.setString(52	,order_set_code.trim());

		update_cr			= pstmt_cr.executeUpdate();


		/**************INSERT INTO ORDER CATALOG SYNONYM**************/


		String 	effective_status_primary		= (String)synonymsStr.get("effective_status_primary") ;
		String 	effective_status_directCare		= (String)synonymsStr.get("effective_status_directCare") ;
		String 	effective_status_ancillaryDept	= (String)synonymsStr.get("effective_status_ancillaryDept") ;


		if(effective_status_primary.trim().equalsIgnoreCase("Y")){//This insertion is Mandatory
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"PR");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_primary"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_primary);//*************
			pstmt_syn.addBatch() ;

		}


		if(effective_status_directCare.trim().equalsIgnoreCase("Y")){
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"DC");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_directCare"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_directCare);//*************
			pstmt_syn.addBatch() ;
		}



		if(effective_status_ancillaryDept.trim().equalsIgnoreCase("Y")){
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"AD");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_ancillaryDept"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_ancillaryDept);//*************
			pstmt_syn.addBatch();
		}


			insert_syn = pstmt_syn.executeBatch();


	/**************INSERT INTO OR_ORDER BY PTCL*******************/

			int sizeSettings			=settingsStr.size()  ;
			int iterateVal				=0;

			 traceVal.append("Settings="+sizeSettings + "   //////");


			iterateVal = sizeSettings ;



if(sizeSettings > 0){ //i:e page is visited in  update mode
///Assumption that corresponding Index of a particular Patient Class is same in Both the tabs is  same
	HashMap tempSetting=null;
	String setting_applicability="";
	String patient_class="";
	
	for(int i = 0; i < iterateVal ; i++){//0 for the default

			    tempSetting = (HashMap)settingsStr.get(i);
				setting_applicability	    =(String)tempSetting.get("setting_applicability");

				if(setting_applicability.trim().equalsIgnoreCase("A") || i== 0 ){

				patient_class	=(String)tempSetting.get("patient_class");

				pstmt_ptcl.setString(1	 ,order_set_code);
				pstmt_ptcl.setString(2	 ,patient_class);
				pstmt_ptcl.setString(3	 ,"X");
				pstmt_ptcl.setString(4	 ,"N");
				pstmt_ptcl.setString(5	 ,"N");
				pstmt_ptcl.setString(6	 ,"N");
				pstmt_ptcl.setString(7	 ,"A");
				pstmt_ptcl.setString(8	 ,"");
				pstmt_ptcl.setString(9	 ,"");
				pstmt_ptcl.setString(10	 ,"");
				pstmt_ptcl.setString(11	 ,"");
				pstmt_ptcl.setString(12	 ,"");
				pstmt_ptcl.setString(13	 ,"");
				pstmt_ptcl.setString(14	 ,"");
				pstmt_ptcl.setString(15	 ,"");
				pstmt_ptcl.setString(16  ,"");
				pstmt_ptcl.setString(17	 ,login_by_id);
				pstmt_ptcl.setString(18	 ,login_at_ws_no);
				pstmt_ptcl.setString(19  ,login_facility_id);
				pstmt_ptcl.setString(20  ,login_by_id);
				pstmt_ptcl.setString(21  ,login_at_ws_no);
				pstmt_ptcl.setString(22  ,login_facility_id);
				pstmt_ptcl.setString(23  ,"");
				pstmt_ptcl.addBatch();
		   	}//end of For Loop for PTCL INSERTION
	}

				insert_ptcl = pstmt_ptcl.executeBatch();

	}else{ //Page not visisted in update mode

			   traceVal.append("Before assign insert_ptcl.length");
			   insert_ptcl = new int[1];
	}

			traceVal.append("afterInsertion="+insert_ptcl.length);


/*****************INSERTION FOR OR ORDER Set Component************/

		 int noOfRecords = componentStr.size() ;

	 if(noOfRecords > 0){ //i:e page is visited in  update mode
HashMap currData=null;
String  associate_yn="";
		 for(int k=0 ; k< noOfRecords ; k++){
	   currData	     =(HashMap)componentStr.get(k);
		associate_yn	 =(String)currData.get("associate_yn");

		traceVal.append("order_category="+order_category);

		 if(associate_yn.trim().equalsIgnoreCase("Y")){
			pstmt_comp.setString(1	,order_set_code);
			pstmt_comp.setString(2	,(String)currData.get("order_set_seq_num"));
			pstmt_comp.setString(3	,(String)currData.get("order_catalog_code"));
			pstmt_comp.setString(4	,(String)currData.get("order_type_code"));
			pstmt_comp.setString(5	,(String)currData.get("order_category"));
			pstmt_comp.setString(6	,(String)currData.get("reqd_or_opt_ind"));
			pstmt_comp.setString(7	,(String)currData.get("rel_start_date_time"));
			pstmt_comp.setString(8	,(String)currData.get("route_code"));
			pstmt_comp.setString(9	,(String)currData.get("qty_unit"));	 //Not in sec phase
			pstmt_comp.setString(10 ,(String)currData.get("qty_value")); //Not in sec phase
			pstmt_comp.setString(11 ,(String)currData.get("freq_code"));
			pstmt_comp.setString(12 ,(String)currData.get("durn_value"));
			pstmt_comp.setString(13 ,(String)currData.get("durn_type"));
			pstmt_comp.setString(14 ,(String)currData.get("prompt_msg"));//Not in sec phase
			pstmt_comp.setString(15 ,login_by_id);
			pstmt_comp.setString(16 ,login_at_ws_no);
			pstmt_comp.setString(17 ,login_facility_id);
			pstmt_comp.setString(18 ,login_by_id);
			pstmt_comp.setString(19 ,login_at_ws_no);
			pstmt_comp.setString(20 ,login_facility_id);
			pstmt_comp.setInt(21 ,1);

			pstmt_comp.addBatch();

		 }//End of if


		 } //End of For loop
		   	insert_comp = pstmt_comp.executeBatch();
		 }else{//In case page is not visited the no Updation required
		    insert_comp = new int[1];
		 }

		traceVal.append("insert_comp="+insert_comp.length);

		boolean insert_cmp	=  false ;
		boolean insert_ptl	=  false ;
		boolean insert_sy	=  false ;


		 if((insert_comp.length > 0)){ //check updation in Component
					insert_cmp= true ;
		 }else if((insert_comp.length == (-3))){
					insert_cmp= false ;
		 }


		 if((insert_ptcl.length > 0)){ //check updation in PTCL
					insert_ptl= true ;
		 }else if((insert_ptcl.length == (-3))){
					insert_ptl= false ;
		 }


		 if((insert_syn.length > 0)){ //check updation in SYN
					insert_sy= true ;
		 }else if((insert_syn.length == (-3))){
					insert_sy= false ;
		 }


		if (update_cr > 0  && insert_sy  && insert_cmp && insert_ptl){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_INSERTED") ;
	}else{
				connection.rollback();
				messages.append( "Insert Failed" ) ;
	}

	}catch( Exception e ){
					traceVal.append("In Exception==");
					e.printStackTrace();
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;

			try {
						connection.rollback();
						//closeConnection(connection);
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}
				messages.append( e.getMessage() ) ;

				e.printStackTrace() ;
    		  }finally{
	            	try {

						closeResultSet(rs_eff);
						closeStatement(del_pstmt_syn);
						closeStatement(del_pstmt_ptcl);
						closeStatement(del_pstmt_comp);
						closeStatement(pstmt_eff);
						closeStatement(pstmt_cr);
						closeStatement(pstmt_comp);
						closeStatement(pstmt_syn);
						closeStatement(pstmt_ptcl);
						closeConnection(connection);
					} catch ( Exception fe ) {

					   	fe.printStackTrace() ;
			        }
	    	    }

			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			return map ;
}

public HashMap AdditionalRecord() throws Exception 
{
	
	HashMap map = new HashMap() ;
	HashMap sqlMap = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	

	Connection connection 		= null;
	PreparedStatement pstmt1 	= null;
	PreparedStatement pstmt2 	= null;
	PreparedStatement pstmt3 	= null;
	ResultSet rs=null;
	String order_set_code="";
	String order_catalog_code="";
	String order_set_seq_num	  ="";
	String order_type_code		="";
	String order_category		 ="";
	String reqd_or_opt_ind		="";
	String rel_start_date_time	="";
	String route_code		="";		
	String qty_unit		="";			
	String qty_value		="";			
	String freq_code	="";				
	String durn_value	="";			
	String durn_type		="";		
	String prompt_msg	="";			
	String OCURRANCE_NUM	   ="";



	HashMap recordStoreParam = new HashMap() ;
	//HashMap orderset_detail	 = new HashMap() ;
	int int_total_records = Integer.parseInt(total_records);
	//int cnt=0;
		try {
		connection = getConnection() ;

		try{
			sqlMap.put("SQL_OR_ORDERSET_INSERT_COMP"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_COMP"));
			
		}catch(Exception e){
				e.printStackTrace();
			map.put( "message", e.getMessage() ) ;
		}
			 pstmt1										= connection.prepareStatement( (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_COMP"));
		   	 pstmt3               = connection.prepareStatement("select Order_Type_code from OR_ORDER_Catalog where Order_catalog_code=? ");

		for(int i=1; i<=int_total_records; i++)
		{
				if(allValues.containsKey("include"+i))
				{
						if(((String)allValues.get("include"+i)).equalsIgnoreCase("Y"))
						{
							  order_set_code=(String)allValues.get("order_set_code");
							  order_catalog_code=(String)allValues.get("order_catalog_code"+i);
								

				 
							  pstmt2										= connection.prepareStatement( "delete from or_order_set_component where order_set_code=? and  order_catalog_code=? and OCURRANCE_NUM > 1");
							  pstmt2.setString(1	,order_set_code.trim());
							  pstmt2.setString(2	,order_catalog_code.trim());
							  pstmt2.executeUpdate();
							  closeStatement( pstmt2 ) ;
							  pstmt3.setString(1, order_catalog_code.trim());
							  rs= pstmt3.executeQuery() ;
			
							if(rs.next())
							{
								 order_type_code=rs.getString("order_type_code");
							}
							rs.close();
				
				
							order_set_seq_num	=(String)allValues.get("order_set_seq_num"+i);
							order_category			=(String)allValues.get("order_category");
							reqd_or_opt_ind			=(String)allValues.get("reqd_or_opt_ind"+i);
							rel_start_date_time		=(String)allValues.get("rel_start_date_time"+i);
							route_code					=(String)allValues.get("route_code"+i);
							qty_unit						=(String)allValues.get("qty_unit"+i);
							qty_value						="";
							freq_code						=(String)allValues.get("freq_code"+i);
							durn_value					=(String)allValues.get("durn_value"+i);
							durn_type					=(String)allValues.get("durn_type"+i);
							prompt_msg					=(String)allValues.get("prompt_msg"+i);
							OCURRANCE_NUM		=(String)allValues.get("occurance"+i);
				
							pstmt1.setString(1	,order_set_code.trim());
							pstmt1.setString(2	,order_set_seq_num.trim());
							pstmt1.setString(3	,order_catalog_code.trim());
							pstmt1.setString(4	,order_type_code.trim());
							pstmt1.setString(5	,order_category.trim());//order_category
							pstmt1.setString(6	,reqd_or_opt_ind.trim());
							pstmt1.setString(7	,rel_start_date_time.trim());
							pstmt1.setString(8	,route_code.trim());
							pstmt1.setString(9	,qty_unit.trim());	 //Not in sec phase
					
							pstmt1.setString(10 ,qty_value.trim());		 //Not in sec phase*/
							pstmt1.setString(11 ,freq_code.trim());
							pstmt1.setString(12 ,durn_value.trim());
							pstmt1.setString(13 ,durn_type.trim());
							pstmt1.setString(14 ,prompt_msg.trim());//Not in sec phase		

							pstmt1.setString(15 ,login_by_id);
							pstmt1.setString(16 ,login_at_ws_no);

							pstmt1.setString(17 ,login_facility_id);
							pstmt1.setString(18 ,login_by_id);

							pstmt1.setString(19 ,login_at_ws_no);
							pstmt1.setString(20 ,login_facility_id);
							
							pstmt1.setInt(21 ,Integer.parseInt(OCURRANCE_NUM));

							pstmt1.addBatch();
	
					
					}
				}
		}
		

	int insert_comp[] = pstmt1.executeBatch();
		boolean insert_cmp	=  false ;
		 if((insert_comp.length > 0)){ //check updation in Component
					insert_cmp= true ;
		 }else if((insert_comp.length == (-3))){
					insert_cmp= false ;
		 }
		 if (insert_cmp){
			 	closeStatement( pstmt2 ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt3 ) ;
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", "RECORD_MODIFIED" ) ;
		}else{
				connection.rollback();
				map.put( "message", "Operation failure ..." ) ;
		}
		
	} catch ( Exception e )	{
		connection.rollback();
			e.printStackTrace() ;
		throw e ;
		
	} finally {
		
		closeStatement( pstmt2) ;
		closeStatement( pstmt1) ;
		closeConnection(connection);
	}
	

	map.put("recordStoreParam",recordStoreParam);
	map.put("////sqlMap",sqlMap);

	try {
				recordStoreParam.put( "properties", getProperties() );
				

			} catch(Exception e) {
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
				
			}
			return map;
}
   
   public ArrayList getFrequency(String category,String catalogcode)  throws Exception
	{

	  
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
	try {
			connection			= getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDERSET_FREQ_CODE")  ) ;
			pstmt.setString( 1, category);
			pstmt.setString( 2, catalogcode);
			resultSet = pstmt.executeQuery() ;
		
		  while (  resultSet!=null && resultSet.next()) {
  				 		String[] record = new String[36];
						record[0] = checkForNull(resultSet.getString( "FREQ_CODE" ),"")   ;
						record[1] = checkForNull(resultSet.getString( "freq_desc" ),"")  ;
						OrderCat.add(record) ;
						
 				}
				
	} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return OrderCat;
	}


	

}//ENd of the class
