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
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;



public class SpecimenLblGenerationBean extends eOR.Common.OrAdapter implements Serializable
{
	protected String       contr_sys_id;
	protected String       ordering_facility_id;
	protected String       source_type;
	protected String       source_code;
	protected String       specimen_type;
	protected String       nurse_collect_yn;
	protected String       urgency_indicator;
	protected String       label_gen_on_order_yn;
	protected int		   look_ahead_min;

	public String				tempChk		;

/*********************Constructor *************************/

 public SpecimenLblGenerationBean()
{
			 contr_sys_id						="";
			 ordering_facility_id				= "";
			 source_type						= "";
			 source_code						= "";
			 specimen_type						= "";
			 nurse_collect_yn					= "";
			 urgency_indicator					= "";
			 label_gen_on_order_yn				= "";
			 look_ahead_min						= 0 ;
			try {
				doCommon();
			}catch(Exception e) {e.printStackTrace();}
	}

/*********************Validate *************************/

public HashMap validate() throws Exception {

	HashMap map = new HashMap();
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." );
	return map;
}

/**********************SET METHODS*************************/

  public void  setContr_sys_id(String  contr_sys_id) {this.contr_sys_id=  contr_sys_id; } ;
  public void  setOrdering_facility_id(String  ordering_facility_id) {this.ordering_facility_id=  ordering_facility_id; } ;
  public void  setSource_type(String  source_type) {this.source_type=  source_type; } ;
  public void  setSource_code(String  source_code) {this.source_code=  source_code; } ;
  public void  setSpecimen_type(String  specimen_type) {this.specimen_type=  specimen_type; } ;
  public void  setNurse_collect_yn(String  nurse_collect_yn) {this.nurse_collect_yn=  nurse_collect_yn; } ;
  public void  setUrgency_indicator(String  urgency_indicator) {this.urgency_indicator=  urgency_indicator; } ;
  public void  setLabel_gen_on_order_yn(String  label_gen_on_order_yn) {this.label_gen_on_order_yn=  label_gen_on_order_yn; } ;
  public void  setLook_ahead_min(int  look_ahead_min) {this.look_ahead_min=  look_ahead_min; } ;

/**********************GET METHODS*************************/

  public String getContr_sys_id() { return this.contr_sys_id ; } ;
  public String getOrdering_facility_id() { return this.ordering_facility_id ; } ;
  public String getSource_type() { return this.source_type ; } ;
  public String getSource_code() { return this.source_code ; } ;
  public String getSpecimen_type() { return this.specimen_type ; } ;
  public String getNurse_collect_yn() { return this.nurse_collect_yn ; } ;
  public String getUrgency_indicator() { return this.urgency_indicator ; } ;
  public String getLabel_gen_on_order_yn(){return this.label_gen_on_order_yn;} ;
  public int getLook_ahead_min() { return this.look_ahead_min ; } ;

/*********************METHOD TO SET ALL THE FEILDS AT ONCE********************/

 public void setAll( Hashtable recordSet ) {
	 //System.out.println("###in set all,recordSet=="+recordSet);
	if(recordSet.containsKey("contr_sys_id"))
		 setContr_sys_id((String)recordSet.get("contr_sys_id"));
	if(recordSet.containsKey("ordering_facility_id"))
		 setOrdering_facility_id((String)recordSet.get("ordering_facility_id"));
	if(recordSet.containsKey("source_type"))
		 setSource_type((String)recordSet.get("source_type"));
	if(recordSet.containsKey("source_code"))
		 setSource_code((String)recordSet.get("source_code"));
	if(recordSet.containsKey("specimen_type"))
		 setSpecimen_type((String)recordSet.get("specimen_type"));
	if(recordSet.containsKey("nurse_collect_yn"))
		 setNurse_collect_yn((String)recordSet.get("nurse_collect_yn"));
	if(recordSet.containsKey("urgency_indicator"))
		 setUrgency_indicator((String)recordSet.get("urgency_indicator"));
	if(recordSet.containsKey("label_gen_on_order_yn"))		 setLabel_gen_on_order_yn(checkForNull((String)recordSet.get("label_gen_on_order_yn"),"N"));
	if(recordSet.containsKey("look_ahead_min"))		 setLook_ahead_min(Integer.parseInt(checkForNull((String)recordSet.get("look_ahead_min"),"0")));
	this.mode = (String)recordSet.get("mode");
}

/*********************METHOD TO Reset the Class variable****************/

	public void clear() {
			 contr_sys_id						="";
			 ordering_facility_id				= "" ;
			 source_type						= "" ;
			 source_code						= "" ;
			 specimen_type						= "" ;
			 nurse_collect_yn					= "" ;
			 urgency_indicator					= "" ;
			 label_gen_on_order_yn				= "" ;
			 look_ahead_min						= 0 ;
}

/*********************METHOD TO Insert*************************/

public HashMap insert(){
try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			ArrayList insertData = new ArrayList() ;
			ArrayList whereData = new ArrayList() ;

			insertData.add(contr_sys_id);
			insertData.add(ordering_facility_id);
			insertData.add(source_type);
//System.out.println("source_code===="+source_code);
//System.out.println("source_code===="+java.net.URLDecoder.decode(source_code,"UTF-8"));
			insertData.add(source_code);
			insertData.add(specimen_type);
			insertData.add(nurse_collect_yn);
			insertData.add(urgency_indicator);
			insertData.add(label_gen_on_order_yn);
			insertData.add(String.valueOf(look_ahead_min));
			insertData.add(login_by_id ) ;
			insertData.add(login_at_ws_no ) ;
			insertData.add(login_facility_id ) ;
			insertData.add(login_by_id ) ;
			insertData.add(login_at_ws_no ) ;
			insertData.add(login_facility_id ) ;

			whereData.add(ordering_facility_id) ;
			whereData.add(contr_sys_id) ;
			whereData.add(source_type) ;
			whereData.add(source_code);
			whereData.add(specimen_type);
			whereData.add(urgency_indicator);

		//System.out.println("addddd"+insertData);
		sqlMap.put("InsertSQL",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_INSERT"));
    	   sqlMap.put("SelectSQL",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_DUPLICATE_CHK"));

			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			tabData.put( "WhereData",whereData);
		//	tabData.put( "sql",sqlMap.toString());


		//	return tabData ;
			return getResult(tabData,sqlMap) ;
			}
	catch(Exception e){
		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
	}

}

/*********************METHOD TO Update*************************/

public HashMap modify(){
	try{
			HashMap tabData = new HashMap();
			HashMap sqlMap = new HashMap();
			ArrayList modifyData = new ArrayList() ;
		//	ArrayList whereData = new ArrayList() ;

			/*UPDATE OR_SPEC_LABEL_GEN_RULE SET URGENCY_INDICATOR=?,NURSE_COLLECT_YN=?,	LABEL_GEN_ON_ORDER_YN=?,LOOK_AHEAD_MIN=?,MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE ORDERING_FACILITY_ID=? AND  CONTR_SYS_ID =? AND SOURCE_TYPE =? AND SOURCE_CODE=? and SPECIMEN_TYPE =?*/
//System.out.println("##nurse_collect_yn="+nurse_collect_yn+" , label_gen_on_order_yn="+label_gen_on_order_yn+", look_ahead_min="+String.valueOf(look_ahead_min)+", login_by_id="+login_by_id+" ,login_at_ws_no="+login_at_ws_no+" ,login_facility_id="+login_facility_id+" ,ordering_facility_id="+ordering_facility_id+" ,contr_sys_id="+contr_sys_id+" ,source_type="+source_type+" ,source_code="+source_code+" ,specimen_type="+specimen_type+" ,urgency_indicator="+urgency_indicator);
			modifyData.add(nurse_collect_yn);
			modifyData.add(label_gen_on_order_yn);
			modifyData.add(String.valueOf(look_ahead_min));
			modifyData.add(login_by_id ) ;
			modifyData.add(login_at_ws_no ) ;
			modifyData.add(login_facility_id ) ;
			modifyData.add(ordering_facility_id) ;
			modifyData.add(contr_sys_id) ;
			modifyData.add(source_type) ;
			modifyData.add(source_code);
			modifyData.add(specimen_type);
			modifyData.add(urgency_indicator);

			//System.out.println("####modify mode="+modifyData);


		   sqlMap.put("ModifySQL",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_UPDATE_NEW"));
			tabData.put( "properties", getProperties() );
			tabData.put( "ModifyData",modifyData);
		//	tabData.put("sql",sqlMap.toString());
		//	return tabData;
			return getResult(tabData,sqlMap) ;
			}
	catch(Exception e){
		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
	}
}

/*********************METHOD TO Delete*************************/

public HashMap delete(){
try{
	HashMap tabData = new HashMap();
	ArrayList delData = new ArrayList() ;
	HashMap sqlMap = new HashMap();

	delData.add(ordering_facility_id);
	delData.add(contr_sys_id) ;
	delData.add(source_type) ;
	delData.add(source_code);
	delData.add(specimen_type);
	delData.add(urgency_indicator);
	delData.add(nurse_collect_yn);

	sqlMap.put("DeleteSQL",OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_DELETE") );
	tabData.put("properties",getProperties());
	tabData.put("DeleteData",delData);
	//tabData.put("sqlMap",sqlMap);
	//return tabData ;
	return getResult(tabData,sqlMap) ;
	}
	catch(Exception e){
		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
	}
}

/*********************DoCommon*************************/

	 private void doCommon() throws Exception {
}

/**************get Combo Options for Facility********/
public String getComboOptions(String key)throws Exception {
Connection connection =null ;
if(key == null )
	return "Improper key Passes";
try
{
     	connection = getConnection();
		String sql = "";
		String str = "";

		if(key.trim().equalsIgnoreCase("facility")){
		sql = OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_FACILITY_SELECT") ;
		str = Populate.getComboOptions(sql,connection,"FACILITY_ID","FACILITY_NAME");
		}else if(key.trim().equalsIgnoreCase("specimen")){
		sql= OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_SPECIMEN");
		str = Populate.getComboOptions(sql,connection,"ALPHANUM_VALUE","ALPHANUM_VALUE");
		}

		return str;
 }catch(Exception e){
		logErrorMessage(e);
		return null;
 }finally{
		closeConnection(connection);
		 
 }//End of finally
}
/*Added By Siva Kumr for Specimen Type Enhancements for Lab Module Check - 29/8/2003*/
public String getComboOptions(String key,String strType)throws Exception {
Connection connection =null ;
PreparedStatement pstmt = null ;
ResultSet resultSet = null ;
if(key == null )
	return "Improper key Passes";
try
{

        //System.out.println("SpecimenLabelGenerationBean:getComboOptions()");
		connection = getConnection();

		String sql = "";
		String str = "";

		if(key.trim().equalsIgnoreCase("facility")){
		sql = OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_FACILITY_SELECT") ;
		str = Populate.getComboOptions(sql,connection,"FACILITY_ID","FACILITY_NAME");
		}else if(key.trim().equalsIgnoreCase("specimen")){
            //System.out.println("SpecimenLabelGenerationBean:BeforeFirst");
            //System.out.println(OrRepository.
            //    getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_LABINSTALL_YN"));
            pstmt		= connection.prepareStatement(OrRepository.
                getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
				pstmt.setString(1,"RL");
            resultSet	= pstmt.executeQuery();
            //System.out.println("SpecimenLabelGenerationBean:afterFirst");
            if (resultSet != null && resultSet.next()) {
                if ((resultSet.getString(1)).equalsIgnoreCase("Y")) {
                    sql = OrRepository.
                        getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_SPECIMEN1");
                    if (strType != null && strType.length() > 0) {
                        //System.out.println("SpecimenLabelGenerationBean :" +
                        //strType);
                        str = Populate.
                            getComboOptions(sql,connection,"specimen_type_code","SPECIMEN_DESC",strType);
                    }else{
                        //System.out.println("SpecimenLabelGenerationBeanInElse");
                        str = Populate.
                            getComboOptions(sql,connection,"specimen_type_code","SPECIMEN_DESC");
                    }

                }
                else {
                    sql= OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_SPECIMEN");
                    str = Populate.getComboOptions(sql,connection,"ALPHANUM_VALUE","ALPHANUM_VALUE",strType);
                }
            }
            else {
                sql= OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_SPECIMEN");
                str = Populate.getComboOptions(sql,connection,"ALPHANUM_VALUE","ALPHANUM_VALUE",strType);
            }
		}
        //System.out.println("SpecimenLabelGenerationBean :" + str);
        if ((str == null || str.equals("")) && (strType != null && strType.length() > 0)) {
            //System.out.println("in str.equals(\"\")");
            str = "<option value=strType 'selected'>strType</option>";
        }
		return str;
 }catch(Exception e){
		//System.out.println("SpecimenLabelGenerationBeanInError"+e);
        logErrorMessage(e);
		return null;
 }finally{
		closeResultSet(resultSet);
		closeStatement(pstmt);
		closeConnection(connection);
		
 }//End of finally
}
/*End of Addition by Siva Kumar - 29/8/203*/

////////////////////////////////////////////////////////////////////
/*************get Combo Options Dynamic Population***********/
/*public String getComboBoxHtml(Hashtable ht) throws Exception {
	String sql = "" ;
	String optionString = "";
	String comboBoxString = "";
	Connection con = null;
try
	{
		if( ht == null )
			return "Hashtable Passed to  this method is null for Combo Method";

		con = getConnection();
	 	String  source_type = ((String)ht.get("source_type")).trim();
		String  facility_id = ((String)ht.get("facility_id")).trim();

		String valSource[]  ={"D","C","N","R"} ;
		String sqlSource[]= {OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_DEPT"),
		OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_CLINIC"),
		OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_NURSING"),
		OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_REFERRAL")} ;


		sql = Formatter.chkReturn(valSource,source_type,sqlSource,"");
		if(!source_type.equals("R"))
			sql  =Formatter.replaceForSQL(sql,"?",facility_id);
		optionString = Populate.getComboOptions(sql,con,"CODE","SHORT_DESC");



		if(optionString.trim().equals(""))
		comboBoxString="&nbsp;<select name='source_code'><option value=''>&nbsp;&nbsp;&nbsp;&nbsp;---select---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
		else
		comboBoxString="&nbsp;<select name='source_code'><option value='ALL'> ALL&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;

		}catch(Exception e){
		throw e;
	}finally
	{
		closeConnection(con);
		
	}

	return comboBoxString;
}*/
/*********************load in Update Mode*****************/
public void load(String ordering_facility_id_p,String source_type_p, String source_code_p ,String specimen_type_p)throws Exception{
 Connection 	connection  = null;
 PreparedStatement pstmt = null ;
 ResultSet resultSet = null ;

try
	{
		connection  = getConnection();
		pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_LOADUPDATE"));
		pstmt.setString(1,ordering_facility_id_p.trim());
		pstmt.setString(2,source_type_p.trim());
		pstmt.setString(3,source_code_p.trim());
		pstmt.setString(4,specimen_type_p.trim());

		resultSet	= pstmt.executeQuery();

		while(resultSet.next()){
		setContr_sys_id(ChkDef.defaultString(resultSet.getString("CONTR_SYS_ID")));
		setUrgency_indicator(ChkDef.defaultString(resultSet.getString("URGENCY_INDICATOR")));
		setNurse_collect_yn(ChkDef.defaultString(resultSet.getString("NURSE_COLLECT_YN")));
		setLabel_gen_on_order_yn(ChkDef.defaultString(resultSet.getString("LABEL_GEN_ON_ORDER_YN")));
		setLook_ahead_min(Integer.parseInt(checkForNull((String)resultSet.getString("LOOK_AHEAD_MIN"),"0")));
		}

	}catch(Exception e){
		System.err.println("error loading values::"+e.toString());
	}finally{
			closeResultSet(resultSet);
		 	closeStatement(pstmt);
			closeConnection(connection);
		 
	}
}
/**********This Method  Actually Calls the EJB's Method ********************/
private  HashMap getResult(HashMap tabData , HashMap sqlMap ){
	//System.out.println("####in getResult()");
		HashMap map  = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();

		//SingleTableHandlerHome home = null;
		//SingleTableHandlerRemote remote = null;

		try
		{
			/********************LOOK UP*************************/
			/*InitialContext context = new InitialContext() ;
			Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")) ;
			home		 = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
			remote		 = home.create() ;*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		    Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 		    Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass(); 		    
					
			if(mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE"))) {
				//map = remote.delete(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				//map = remote.insert(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

				//System.out.println("map value"+map);
			}else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
				// map = remote.modify(tabData, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
		 
		    argArray		= null;
		    paramArray	= null;
			 
			 //System.out.println("here"+(String) map.get( "msgid" ));
			 
			 if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "Common")) ;
				}
				
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);




			
			/*String message = (String)map.get("msgid");
		boolean result = ((Boolean) map.get("result")).booleanValue() ;
		 if( result ) 
		{
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", getMessage(language_id,(String) map.get("msgid"),"SM") ) ;
		}
        else
		{
			map.put( "result", new Boolean( false ) ) ;
            if( message.equals( "CODE_ALREADY_EXISTS" ) )
			{
				
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common") ) ;
				
				
				//map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				

			}
            else
			{
				System.out.println("in bean "+ (String)map.get("msgid"));
			
				map.put( "message", getMessage(language_id,(String)map.get("msgid"),"Common")) ;
			}
        }*/
		  //return map;

	  }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		//return map ;
	  }finally {
			clear();
			/*try {
				if( remote != null )
					remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
		}
		//System.out.println("final map"+map);
		//return map;

		  return map;

 }//End of Method

}//ENd of the class
