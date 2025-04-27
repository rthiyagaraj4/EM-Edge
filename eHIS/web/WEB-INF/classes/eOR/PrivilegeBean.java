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

import eOR.ORPrivilege.*;

public class  PrivilegeBean  extends eOR.Common.OrAdapter implements Serializable
{
	protected Hashtable all_values =	null;
	protected String                      privilege_ctx_id;
	protected String                      privilege_id;
	protected String                      privilege_ctx;
	protected String                      facility_id;
	protected String                      appl_user_id;
	protected String                      reln_id;
	protected String                      resp_id;
	protected String                      privilege_value;
	protected ArrayList					  recstorehandler;
	protected String                      priv_value;
	protected String                      flag_value;

	protected String					  appl_user_name;
	protected String					  pract_reln_name;
	protected String					  resp_name	;
	protected String					  facility_name;
	protected String					  mode = "";

	public String tempChk		=	"";
eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

/*********************Constructor *************************/

 public PrivilegeBean()
{
			 privilege_id						= ""    ;
			 privilege_ctx						= ""    ;
			 facility_id						= ""    ;
			 appl_user_id						= ""    ;
			 reln_id							= ""    ;
			 resp_id							= ""    ;
			 privilege_value					= ""    ;
			 appl_user_name						= ""	;
			 pract_reln_name					= ""	;
		   	resp_name							= ""	;
			facility_name						= ""	;
			priv_value						= ""	;
			flag_value						= "";
			 recstorehandler					= new ArrayList();
			try {
				doCommon();
			}catch(Exception e) {e.printStackTrace();}
	}

/*********************Validate *************************/

public HashMap validate() throws Exception {
	HashMap map = new HashMap();
	map.put( "result", new Boolean( true ) ) ;

	return map;
}

/**********************SET METHODS*************************/

  public void  setPrivilege_ctx_id(String  privilege_ctx_id) {this.privilege_ctx_id=  privilege_ctx_id; } ;
  public void  setPrivilege_id(String  privilege_id) {this.privilege_id=  privilege_id; } ;
  public void  setPrivilege_ctx(String  privilege_ctx) {this.privilege_ctx=  privilege_ctx; } ;
  public void  setFacility_id(String  facility_id) {this.facility_id=  facility_id; } ;
  public void  setAppl_user_id(String  appl_user_id) {this.appl_user_id=  appl_user_id; } ;
  public void  setReln_id(String  reln_id) {this.reln_id=  reln_id; } ;
  public void  setResp_id(String  resp_id) {this.resp_id=  resp_id; } ;
  public void  setPrivilege_value(String  privilege_value) {this.privilege_value =  privilege_value;

  } ;
  public void  setAppl_user_name(String  appl_user_name) {this.appl_user_name=  appl_user_name; } ;
  public void  setPract_reln_name(String  pract_reln_name) {this.pract_reln_name=  pract_reln_name; } ;
  public void  setResp_name(String  resp_name) {this.resp_name=  resp_name; } ;
  public void  setFacility_name(String  facility_name) {this.facility_name=  facility_name; } ;
  public void  setPrivValue(String  priv_value) {this.priv_value =  priv_value; } ;
  public void  setFlagValue(String  flag_value) {this.flag_value +=  flag_value; } ;


/**********************GET METHODS*************************/

  public String getPrivilege_ctx_id() { return this.privilege_ctx_id ; } ;
  public String getPrivilege_id() { return this.privilege_id ; } ;
  public String getPrivilege_ctx() { return this.privilege_ctx ; } ;
  public String getFacility_id() { return this.facility_id ; } ;
  public String getAppl_user_id() { return this.appl_user_id ; } ;
  public String getReln_id() { return this.reln_id ; } ;
  public String getResp_id() { return this.resp_id ; } ;
  public String getPrivilege_value() {
	 return this.privilege_value;
	 } ;
  public String getPrivValue() { return this.priv_value ; } ;
  public String getFlagValue() { return this.flag_value ; } ;

  public String getAppl_user_name() { return this.appl_user_name ; } ;
  public String getPract_reln_name() { return this.pract_reln_name ; } ;
  public String getResp_name() { return this.resp_name ; } ;
  public String getFacility_name() { return this.facility_name ; } ;


/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSet ) {
	 all_values = recordSet;
	if(recordSet.containsKey("privilege_ctx_id"))
		 setPrivilege_ctx_id((String)recordSet.get("privilege_ctx_id"));
	if(recordSet.containsKey("privilege_id"))
		 setPrivilege_id((String)recordSet.get("privilege_id"));
	if(recordSet.containsKey("privilege_ctx"))
		 setPrivilege_ctx((String)recordSet.get("privilege_ctx"));
	if(recordSet.containsKey("facility_id"))
		 setFacility_id((String)recordSet.get("facility_id"));
	if(recordSet.containsKey("appl_user_id")){
		 setAppl_user_id(checkForNull((String)recordSet.get("appl_user_id")));}
	if(recordSet.containsKey("reln_id"))
		 setReln_id(checkForNull((String)recordSet.get("reln_id")));
	if(recordSet.containsKey("resp_id"))
		 setResp_id(checkForNull((String)recordSet.get("resp_id")));
	if(recordSet.containsKey("priv_value"))
	 {
		 setPrivValue((String)recordSet.get("priv_value"));
	 }
	 if(recordSet.containsKey("priv_value"))
	 	 setFlagValue((String)recordSet.get("flag_value"));
	 
	this.mode = (String)recordSet.get("mode");
	synStore(recordSet);
}

/*********************METHOD TO Reset the Class variable*************************/

	public void clear() {
			 privilege_id						= ""    ;
			 privilege_ctx						= ""    ;
			 facility_id						= ""    ;
			 appl_user_id						= ""    ;
			 reln_id							= ""    ;
			 resp_id							= ""    ;
			 privilege_value					= ""    ;
			 priv_value= "";
			 flag_value= "";
}
/***************************************************************/
public Object getComboOptions(String option) {
Connection connection =null ;
try
{		
		connection		        = getConnection();
		Object str		        = "";
		//String comboBoxString	= "";
		 if(option.trim().equalsIgnoreCase("facility")){
		str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_FACILITY"),connection,"facility_id","facility_name");
		}else if(option.trim().equalsIgnoreCase("groupIndentifier")){
		str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_IDEN"),connection,"grp_exception_id","grp_exception_name");
		}
		return str;

}catch(Exception e){
		System.out.println(e.getMessage());
		return null;
}finally{

		try
		 {
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();

		 }
	}

}
/**************************************************************/
public void clearALL(){

recstorehandler.clear();
}
/**************************************************************/
public synchronized ArrayList getIdentifiers(){
	
Connection connection =null ;
PreparedStatement pstmt = null ;
ResultSet rs = null;

try{
	
	connection	 = getConnection();
	pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_IDEN"));

	rs = pstmt.executeQuery();

	HashMap	tempHash = new HashMap();

	String grp_exception_id = "";
	String grp_exception_name ="";

	while(rs.next()){

	tempHash = new HashMap();

	grp_exception_id = rs.getString("grp_exception_id");
	grp_exception_name = rs.getString("grp_exception_name");

	tempHash.put("grp_exception_id"	  ,grp_exception_id);
	tempHash.put("grp_exception_name" ,grp_exception_name);
	tempHash.put("include"			  ,"N");
	recstorehandler.add(tempHash);
	} //End of while loop

  }catch(Exception e){

			e.printStackTrace();
			tempChk += e.getMessage();

  }finally{

		try
		 {
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);

		 }catch(Exception e){e.printStackTrace();

		 }
  }
   return recstorehandler;

}
/****************************************************************/
public ArrayList getIdentifiersStore(){
return recstorehandler;
}
/*********************METHOD TO Insert*************************/

public HashMap insert()
{

	//System.out.println("here10======================");
	HashMap sqlMap = new HashMap() ;
	HashMap recordStoreParam = new HashMap() ;
	int counter = 0;
	String update_value[] = null;
	String update_value1[] = null;
	int noOfRecords = Integer.parseInt((String)all_values.get("noOfRecords"));
	String values = getPrivValue();
	String dummy = "";
	String temp="";
	String privil_id="";
	String grp_excep_id="";
	StringTokenizer stoken = new StringTokenizer(values,"~");
	final int count_code		=	stoken.countTokens();
	update_value = new String[count_code];
	int k = 0;
	while(stoken.hasMoreTokens()){
		update_value[k]	=	stoken.nextToken();
		k++;
	}
	try{
		HashMap tabData =null;
		StringTokenizer stoken2= null;
		String tempString = "";
		StringTokenizer stoken1 = null;
	for(int i=0;i<noOfRecords;i++)
	{
			tabData = new HashMap() ;
			HashMap tempValue = (HashMap)recstorehandler.get(i);
			
			grp_excep_id = (String)tempValue.get("grp_exception_id");

				for(int x=0;x<update_value.length;x++){
				stoken2= new StringTokenizer(update_value[x],"||");
				stoken2.nextToken();
				tempString = stoken2.nextToken();
				stoken1 = new StringTokenizer(tempString,",");
				final int count_code1		=	stoken1.countTokens();	
			
				dummy = stoken1.nextToken();
				if(grp_excep_id.equals(dummy))
				{
					update_value1 = new String[count_code1];
					update_value1[0] = dummy;
					int p=1;
					while(p<=9)
					{
						dummy =stoken1.nextToken();
						update_value1[p]= dummy;
						//temp += update_value1[p]+",";
						temp = temp+update_value1[p]+",";
						p++;
					}
					
					int m=10;
					while(stoken1.hasMoreTokens())
					{
						update_value1[m]  = stoken1.nextToken();

						//privil_id += update_value1[m]+",";
						privil_id = privil_id+update_value1[m]+",";
						m++;

					}				

				tabData.put("privilege_value",temp);temp="";
				tabData.put("privilege_id",privil_id);privil_id="";
				tabData.put("grp_exception_id",grp_excep_id);
				tabData.put("login_by_id"		  ,login_by_id) ;
				tabData.put("login_at_ws_no"     ,login_at_ws_no ) ;
				tabData.put("login_facility_id"  ,login_facility_id ) ;
				recordStoreParam.put(String.valueOf(counter),tabData);
				counter++;
			 }

			}
	}
	sqlMap.put("SQL_OR_PRIVILEGE_CTX_INSERT",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_CTX_INSERT"));
	sqlMap.put("SQL_OR_PRIVILEGE_CTX_EXP_INSERT",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_CTX_EXP_INSERT"));
	sqlMap.put("SQL_OR_PRIVILEGE_CTX_DUP",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_CTX_DUP"));
	sqlMap.put("SQL_OR_PRIVILEGE_SEL_SEQ",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_SEL_SEQ"));
	sqlMap.put("SQL_OR_PRIVILEGE_CTX_DELETE",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_CTX_DELETE"));
   //System.err.println("IN THE PRIVILAIGE"+tabData+sqlMap);
	return getResult(recordStoreParam,sqlMap );
	}catch(Exception e){
	recordStoreParam.put("Exception",e.getMessage());
	return recordStoreParam;
	}

}

/*********************METHOD TO Update*************************/

public HashMap modify(){
	HashMap sqlMap = new HashMap() ;
	HashMap recordStoreParam = new HashMap() ;
	int counter = 0;
	String update_value[] = null;
	String update_value1[] = null;
	int noOfRecords = Integer.parseInt((String)all_values.get("noOfRecords"));
	String values = getPrivValue();
	String dummy = "";
	String privil_id="";
	String temp="";
	String grp_excep_id ="";
	StringTokenizer stoken = new StringTokenizer(values,"~");
	final int count_code		=	stoken.countTokens();
	update_value = new String[count_code];
	int k = 0;
	while(stoken.hasMoreTokens()){
		update_value[k]	=	stoken.nextToken();
		k++;
	}

	try{
		HashMap tabData=null;
		StringTokenizer stoken2= null;
		String tempString = "";	
		StringTokenizer stoken1 = null;
	for(int i=0;i<noOfRecords;i++)
	{
			tabData = new HashMap() ;
			HashMap tempValue = (HashMap)recstorehandler.get(i);
			grp_excep_id = (String)tempValue.get("grp_exception_id");
			for(int x=0;x<update_value.length;x++){
				stoken2= new StringTokenizer(update_value[x],"||");
				stoken2.nextToken();
				tempString = stoken2.nextToken();	
				stoken1 = new StringTokenizer(tempString,",");
				final int count_code1		=	stoken1.countTokens();

				dummy = stoken1.nextToken();
				if(grp_excep_id.equals(dummy))
				{
					
					update_value1 = new String[count_code1];
					update_value1[0] = dummy;

					int p=1;
					while(p<=9)
					{
						dummy =stoken1.nextToken();
						update_value1[p]= dummy;
						//temp += update_value1[p]+",";
						temp =temp+update_value1[p]+",";
						p++;
					}
					

					int m=10;//end of modified by Kavitha.K 
					while(stoken1.hasMoreTokens())
					{
						update_value1[m]  = stoken1.nextToken();

						//privil_id += update_value1[m]+",";
						privil_id =privil_id+update_value1[m]+",";
						m++;

					}
					tabData.put("privilege_value",temp);temp="";
					tabData.put("privilege_id",privil_id);privil_id="";
					tabData.put("grp_exception_id",grp_excep_id);
					tabData.put("login_by_id"		  ,login_by_id) ;
					tabData.put("login_at_ws_no"     ,login_at_ws_no ) ;
					tabData.put("login_facility_id"  ,login_facility_id ) ;
					recordStoreParam.put(String.valueOf(counter),tabData);
					counter++;
				}


			}
	}
	sqlMap.put("SQL_OR_PRIVILEGE_CTX_INSERT",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_CTX_INSERT"));
	sqlMap.put("SQL_OR_PRIVILEGE_CTX_EXP_INSERT",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_CTX_EXP_INSERT"));
	sqlMap.put("SQL_OR_PRIVILEGE_CTX_DUP",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_CTX_DUP"));
	sqlMap.put("SQL_OR_PRIVILEGE_SEL_SEQ",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_SEL_SEQ"));
	sqlMap.put("SQL_OR_PRIVILEGE_CTX_DELETE",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_CTX_DELETE"));
	sqlMap.put("SQL_OR_PRIVILEGE_CTX_EXP_DELETE",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_CTX_EXP_DELETE"));


		return getResult(recordStoreParam,sqlMap );
	}catch(Exception e){
		recordStoreParam.put("Exception",e.getMessage());
		return recordStoreParam;
	}
}


/*********************METHOD TO Delete*************************/

public HashMap delete()
{
	HashMap sqlMap = new HashMap() ;
	HashMap recordStoreParam = new HashMap() ;
	try{
		sqlMap.put("SQL_OR_PRIVILEGE_CTX_EXP_DELETE",OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_CTX_EXP_DELETE"));

		recordStoreParam.put("privilege_ctx_id",privilege_ctx_id.trim());

		return getResult(recordStoreParam,sqlMap );

	}catch(Exception e)
	{
		recordStoreParam.put("Exception",e.getMessage());
		return recordStoreParam;
	}
}
/**********This Method  Actually Calls the EJB's Method ********************/

 private  HashMap getResult(HashMap record , HashMap sqlMap ) {

	HashMap map  = new HashMap() ;
	StringBuffer tmpBuff	= new StringBuffer();
	try
		{ 
		   //System.out.println("here12======================");
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("PRIVILEGE_JNDI"), ORPrivilegeHome.class, getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
             
			HashMap tabDataParam =  new HashMap() ;
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "records",     record );
			tabDataParam.put("appl_user_id",((String)all_values.get("appl_user_id")).trim());
			tabDataParam.put("reln_id",((String)all_values.get("reln_id")).trim());
			tabDataParam.put("resp_id",((String)all_values.get("resp_id")).trim());
			tabDataParam.put("privilege_ctx_id",privilege_ctx_id);

			tabDataParam.put("privilege_ctx",(String)all_values.get("privilege_ctx"));
			tabDataParam.put("facility_id",(String)all_values.get("facility_id"));

			Object argArray[]	= new Object[2];
			argArray[0]		= tabDataParam;
			argArray[1]		= sqlMap;
 			Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabDataParam.getClass();
			paramArray[1]	= sqlMap.getClass();
			 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				
			
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			}
			else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			}
			//System.out.println("=====map===="+map+"==");
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
		 
			  argArray		= null;
			  paramArray	= null;
				//System.out.println("=====map===="+map+"==========map.get(message)===="+map.get( "message" ));
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
				}
				
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);



			
		  return map;

	 }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message","err in func bean" +  e.getMessage() );
		e.printStackTrace() ;
		return map ;
	}

}//End of Method

/*********************DoCommon*************************/

	 private void doCommon() throws Exception {
}
/**********************************************************/
public synchronized void   synStore(HttpServletRequest request)
{
int noOfRecords  =ChkDef.defaultInt(((String)request.getParameter("noOfRecords")));

tempChk = 0 + "+"+ noOfRecords ;
  try{
	  String include = "";
	  String privilege_value = "";
	for (int i = 0; i <noOfRecords ; i++){
		include = "";
		privilege_value = "";
		tempChk += include ;
		tempChk += privilege_value;
	 	if(include.trim().equalsIgnoreCase("Y") || include.trim().equalsIgnoreCase("N")){
			HashMap temp = (HashMap)recstorehandler.get(i);
			temp.put("include",include);
		}
		if(privilege_value.trim().equalsIgnoreCase("S") || privilege_value.trim().equalsIgnoreCase("M") ||privilege_value.trim().equalsIgnoreCase("A") || privilege_value.trim().equalsIgnoreCase("N")){
			HashMap temp = (HashMap)recstorehandler.get(i);
			temp.put("privilege_value",privilege_value);
		}
	}
   }catch(Exception e){
	logErrorMessage(e);
	}

}
/**************************************************************************/
private void  synStore(Hashtable request){


int noOfRecords  =ChkDef.defaultInt(((String)request.get("noOfRecords")));//added by Kavitha.K


tempChk = 0 + "+"+ noOfRecords ;//modified by Kavitha.K 1/10/2005
  try{
	  String include = "";
	String privilege_value = "";
	for (int i = 0; i < noOfRecords ; i++){
		include = "";
		privilege_value = "";
		tempChk += include ;
		tempChk += privilege_value;
	 	if(include.trim().equalsIgnoreCase("Y")|| include.trim().equalsIgnoreCase("N"))
		{
			HashMap temp = (HashMap)recstorehandler.get(i);
			temp.put("include",include);
		}
		
		if(privilege_value.trim().equalsIgnoreCase("S") || privilege_value.trim().equalsIgnoreCase("M") ||privilege_value.trim().equalsIgnoreCase("A") || privilege_value.trim().equalsIgnoreCase("N"))
		{
			HashMap temp = (HashMap)recstorehandler.get(i);
			temp.put("privilege_value",privilege_value);
		}
	 }
   }catch(Exception e){
	logErrorMessage(e);
	}

}
/*********************load in Update Mode*****************/
public void loadHeader(String privilege_ctx_id)
{
 Connection 	connection  = null;
 PreparedStatement pstmt = null ;
 ResultSet resultSet = null ;
 setFacility_id(ChkDef.defaultString(privilege_ctx_id));
try
	{
		connection  = getConnection();
		pstmt		= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_UPDATE_HEADER"));

		pstmt.setString(1,privilege_ctx_id);
		resultSet	= pstmt.executeQuery();
		while(resultSet.next()){
			setFacility_id(ChkDef.defaultString(resultSet.getString("facility_id")));
			setFacility_name(ChkDef.defaultString(resultSet.getString("facility_name")));
			setPrivilege_id(ChkDef.defaultString(resultSet.getString("privilege_id")));
			setAppl_user_id(ChkDef.defaultString(resultSet.getString("appl_user_id")));
			setReln_id(ChkDef.defaultString(resultSet.getString("reln_id")));
			setResp_id(ChkDef.defaultString(resultSet.getString("resp_id")));
			tempChk ="temp pract_reln_name=" +  resultSet.getString("pract_reln_name");
			setPrivilege_value(ChkDef.defaultString(resultSet.getString("privilege_value")));
			setAppl_user_name(ChkDef.defaultString(resultSet.getString("appl_user_name")));
			setPract_reln_name(ChkDef.defaultString(resultSet.getString("pract_reln_name")));
			setResp_name(ChkDef.defaultString(resultSet.getString("resp_name")));
	  }

	}catch(Exception e){
		tempChk+=e.getMessage();

	}finally{
		try
		 {
				closeResultSet(resultSet) ;
				closeStatement(pstmt) ;
				closeConnection(connection) ;
		 }catch(Exception e){e.printStackTrace();
		 }
	}
}
/*******************load in Update Detail****************************/
public void loadDetail(String privilege_ctx_id)
{
 Connection 	connection  = null;
 PreparedStatement pstmt = null ;
 ResultSet resultSet = null ;
 setFacility_id(ChkDef.defaultString(privilege_ctx_id));

try
	{
		connection   =getConnection();
		pstmt		 =connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_UPDATE_DETAIL"));

		pstmt.setString(1,privilege_ctx_id);

		resultSet	  =pstmt.executeQuery();
		int sizeOfALL =recstorehandler.size();

		String grp_exception_id_DB="";
		String grp_exception_id_ALL = "";
		while(resultSet.next()){
			 grp_exception_id_DB = resultSet.getString("grp_exception_id");
			for (int i = 0; i < sizeOfALL ; i++){
			HashMap temp = (HashMap)recstorehandler.get(i);
			grp_exception_id_ALL = (String)temp.get("grp_exception_id");
			if(grp_exception_id_DB.trim().equalsIgnoreCase(grp_exception_id_ALL.trim()))
			{
				temp.put("include","Y");
			}
			}
		}

	}catch(Exception e){
		tempChk+=e.getMessage();

	}finally{
		try
		 {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		 }catch(Exception e){e.printStackTrace();
		 }
	}
}

public Vector getDistPrivilegeCtxID(HashMap temp)
{
	Connection 	connection  = null;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	Vector distPrivList = new Vector();
try
	{
		connection   =getConnection();
		pstmt		 =connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_DISTINCT_CTX_QUERY"));
		pstmt.setString(1,(String)temp.get("privilege_ctx_id"));
		pstmt.setString(2,(String)temp.get("privilege_id"));
		pstmt.setString(3,(String)temp.get("facility_id"));
		pstmt.setString(4,(String)temp.get("appl_user_id"));
		pstmt.setString(5,(String)temp.get("reln_id"));
		pstmt.setString(6,(String)temp.get("resp_id"));
		pstmt.setString(7,(String)temp.get("privilege_value"));
		pstmt.setString(8,(String)temp.get("appl_user_name"));
		pstmt.setString(9,(String)temp.get("resp_name"));
		pstmt.setString(10,(String)temp.get("facility_name"));
		pstmt.setString(11,(String)temp.get("pract_reln_name"));

		resultSet	  =pstmt.executeQuery();


		while(resultSet != null && resultSet.next())
		{
			distPrivList.add(resultSet.getString("privilege_ctx_id"));
		}

	}catch(Exception e){
		tempChk+=e.getMessage();

	}finally{
		try
		 {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		 }catch(Exception e){e.printStackTrace();
		 }
	}
	return distPrivList;
}

public Vector getPrivilegeIDs(String privilege_ctx_id,String grp_exception_id)
{

	Connection 	connection  = null;
	PreparedStatement pstmt = null ;
	ResultSet resultSet = null ;
	Vector listPrivilege = new Vector();
	
try
	{
		connection   =getConnection();
		pstmt		 =connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_PRIV_VALUE"));
		pstmt.setString(1,privilege_ctx_id.trim());
		pstmt.setString(2,grp_exception_id.trim());
		resultSet	  =pstmt.executeQuery();
		while(resultSet != null && resultSet.next())
		{
			listPrivilege.add(resultSet.getString("privilege_id"));
			listPrivilege.add(resultSet.getString("privilege_value"));
		}

	}catch(Exception e){
		tempChk+=e.getMessage();
		e.printStackTrace();

	}finally{
		try
		 {
			closeResultSet(resultSet) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		 }catch(Exception e){e.printStackTrace();
		 }
	}
	
	return listPrivilege;
}
/***************************To get the multiRecord bean ***********/

 /**
   * Used the get the Latest MultiRecordBean Instance
   * @return MultiRecordBean object.
   */
 public Object getBean(){
	return this.multiRecBean;
 }//end of getBeanz

}//ENd of the class
