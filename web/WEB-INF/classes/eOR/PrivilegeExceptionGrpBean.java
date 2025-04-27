/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;
import eOR.ORPrivilegeExceptionGrp.* ;
import eOR.Common.*;
import eCommon.Common.*;

public class PrivilegeExceptionGrpBean extends eOR.Common.OrAdapter implements Serializable
{
	protected String exception_type;
	protected String grp_exception_id;
	protected String grp_exception_name;
	protected String order_category;
	protected String order_type_code;
	public String debug="";
	public String bean_mode="";
	protected Hashtable MultiHashData = new Hashtable();
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

/*********************Constructor *************************/

 public PrivilegeExceptionGrpBean(){
	exception_type = "";
	grp_exception_id = "";
	grp_exception_name = "";
	order_category = "";
	order_type_code = "";
	bean_mode ="";
	try{
		doCommon();
	}catch(Exception e) {e.printStackTrace();}
 }

/**********************SET METHODS*************************/
  public void  setException_type(String exception_type) {this.exception_type = exception_type;};
  public void  setGrp_exception_id(String grp_exception_id) {this.grp_exception_id = grp_exception_id;};
  public void  setGrp_exception_name(String grp_exception_name) {this.grp_exception_name = grp_exception_name; } ;
  public void  setOrder_category(String order_category) {this.order_category = order_category; } ;
  public void  setOrder_type_code(String order_type_code) {this.order_type_code = order_type_code; } ;
  public void  setDebug(String  debug) {this.debug=  debug; } ;
  public void  setBean_mode(String bean_mode){this.bean_mode = bean_mode;};

/**********************GET METHODS*************************/


  public String getException_type() { return this.exception_type ; } ;
  public String getGrp_exception_id() { return this.grp_exception_id ; } ;
  public String getGrp_exception_name() { return this.grp_exception_name ; } ;
  public String getOrder_category() { return this.order_category ; } ;
  public String getOrder_type_code() { return this.order_type_code ; } ;
  public String getDebug() { return this.debug ; } ;
  public String getBean_mode(){ return this.bean_mode;};

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSet ) {
	try{
		System.out.println("hereinsetall"+recordSet);
		setException_type((String)recordSet.get("exception_type"));
		setGrp_exception_id((String)recordSet.get("grp_exception_id"));
		setGrp_exception_name((String)recordSet.get("grp_exception_name"));
		setMode((String)recordSet.get("mode"));
		setOrder_category((String)recordSet.get("order_category") == null ? "" : (String)recordSet.get("order_category"));
		setOrder_type_code((String)recordSet.get("order_type_code") == null ? "" : (String)recordSet.get("order_type_code"));
		setBean_mode((String)recordSet.get("bean_mode"));
	}
	catch(Exception e){
	try{
		throw new Exception("Excweption@SetAll: "+e);
		}catch(Exception ee){ee.printStackTrace();
		}
	 }
 }//end of setALL

/*********************METHOD TO Insert*************************/
public HashMap insert(){
	HashMap map = new HashMap() ;
	StringBuffer tmpBuff	= new StringBuffer();
	//debug +="inside insert";
	map.put( "result", new Boolean( false ) ) ;
	//map.put( "result", new Boolean( true ) ) ;
	//map.put( "message","success...");
	//map.put( "flag",debug) ;

	HashMap tabData = new HashMap() ;
	HashMap split = new HashMap();
	ArrayList deleteArrList = new ArrayList();
	ArrayList insertArrList = new ArrayList();
	//ArrayList updateArrList = new ArrayList();
	ArrayList allRecords = new ArrayList();
	String valid= "", associate_yn="";
	try {
		allRecords = multiRecBean.getAllDBRecords();
		//debug += "Before allRecords:"+allRecords.size();
		//if(allRecords.size()>0){
		for(int j=0;j<allRecords.size();j++){
			split			= (HashMap)allRecords.get(j);

			if(split.containsValue(order_type_code))
				break;

			valid			= (String) split.get("valid");
			associate_yn	= (String) split.get("associate_yn");
//System.out.println("109"+valid);
//System.out.println("109s"+split);
//System.out.println("associate_yn"+associate_yn);
			if(valid.equals("Y")){
				if(associate_yn.equals("D")){
					deleteArrList.add(split);
				}
			}else if(valid.equals("N")){
				if(associate_yn.equals("Y")||associate_yn.equals("N")){
					insertArrList.add(split);
				}
			}
			

		}
		
		//else
		//{
			//System.out.println("hereentering");
		//map.put( "result", new Boolean( false ) ) ;
		//map.put( "message","CLICK_ONE_ORDERABLE");
		//return map;
		//}
		//debug += "After allRecords:"+allRecords.size();
		//debug += "delSize:"+deleteArrList.size();
		//debug += "insSize:"+insertArrList.size();
		//System.out.println("124insSize"+insertArrList.size());
//System.out.println("Insertarraylist124"+insertArrList);
//System.out.println("deleteArrList125"+deleteArrList);

		String hdr_order_category  = getOrder_category();
		String hdr_order_type_code = getOrder_type_code();

		if(hdr_order_category == null || hdr_order_category.equals("null")) hdr_order_category="";
		if(hdr_order_type_code == null || hdr_order_type_code.equals("null")) hdr_order_type_code="";

		//debug += "getException_type()	 :"+getException_type();
		//debug += "getgrp_exception_id()  :"+getGrp_exception_id();
		//debug += "hdr_order_category	 :"+hdr_order_category;
		//debug += "hdr_order_type_code	 :"+hdr_order_type_code;
		//debug += "getgrp_exception_name():"+getGrp_exception_name();
		//debug += "getMode():"+getMode();

		MultiHashData.put("exception_type", getException_type());
		MultiHashData.put("grp_exception_id", getGrp_exception_id());
		MultiHashData.put("order_category", hdr_order_category);
		MultiHashData.put("order_type_code", hdr_order_type_code);
		MultiHashData.put("grp_exception_name", getGrp_exception_name());
		MultiHashData.put("bean_mode", getBean_mode());

		MultiHashData.put("login_by_id", login_by_id);
		MultiHashData.put("login_at_ws_no",login_at_ws_no);
		MultiHashData.put("login_facility_id",login_facility_id);
//System.out.println("ininsertcheckingofdata"+MultiHashData);
		//debug += "getMode :"+getMode();
		tabData.put("MultiHashData",MultiHashData);
		tabData.put("deleteArrList",deleteArrList);
		tabData.put("insertArrList",insertArrList);
		tabData.put("properties", (Properties)getProperties());

		HashMap sqlMap = new HashMap();
		
		sqlMap.put("SQL_OR_PRIV_GRP_EXCEPTION_INSERT", OrRepository.getOrKeyValue("SQL_OR_PRIV_GRP_EXCEPTION_INSERT") );
		sqlMap.put("SQL_OR_PRIV_GRP_EXCEPTION_COMP_INSERT", OrRepository.getOrKeyValue("SQL_OR_PRIV_GRP_EXCEPTION_COMP_INSERT") );
		sqlMap.put("SQL_OR_PRIV_GRP_EXCEPTION_COMP_DELETE", OrRepository.getOrKeyValue("SQL_OR_PRIV_GRP_EXCEPTION_COMP_DELETE"));
		
		//ORPrivilegeExceptionGrpHome home = null ;
		//ORPrivilegeExceptionGrpRemote remote = null ;

		//eOR.ORPrivilegeExceptionGrpManager remote = new eOR.ORPrivilegeExceptionGrpManager();

	/*	InitialContext context = new InitialContext() ;
		Object object = context.lookup( OrRepositoryExt.getOrKeyValue("OR_PRIV_EXCEPTION_GRP_JNDI") ) ;
		home  = (ORPrivilegeExceptionGrpHome) PortableRemoteObject.narrow( object, ORPrivilegeExceptionGrpHome.class ) ;
		remote = home.create() ;
		map = remote.insert( tabData, sqlMap ) ;*/
		
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("OR_PRIV_EXCEPTION_GRP_JNDI"), ORPrivilegeExceptionGrpHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();
 		map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
		 
		argArray		= null;
		paramArray		= null;	
		//System.out.println("==================================================================");
		//System.out.println("=========================="+((Boolean) map.get( "result" )).booleanValue());
		/*if( ((Boolean) map.get( "result" )).booleanValue() ){
			map.put( "message", map.get( "msgid" ) ) ;
			map.put( "traceVal", map.get( "traceVal" ) ) ;
			map.put( "flag", debug ) ;
		}
		else{
			map.put( "message", map.get("msgid") ) ;
			map.put( "traceVal", map.get( "traceVal" ) ) ;
			map.put( "flag", debug ) ;
		}*/
		if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "Common")) ;
				}
				
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);

	}
	catch(Exception e) {
	System.err.println( "Error Calling EJB : "+e ) ;
	map.put( "message", e.getMessage()) ;
	e.printStackTrace() ;
	}
	
	return map ;
 }//end of insert

/********************Validate Method ****************************/

 public HashMap validate() throws Exception {
	HashMap map = new HashMap() ;
	//map.put( "result", new Boolean( false ) ) ;
	String exp_type = getException_type();
	String grp_exp_id = getGrp_exception_id();
	String b_mode = getBean_mode();
	boolean chkRecords = false;
	//System.out.println("_______________________________");
	//System.out.println("exp_type"+exp_type);
	if((exp_type.equals("OC")) && (b_mode.equals("I"))){
			//System.out.println("exp_type      :"+exp_type);
			//	chkRecords = checkRecords(exp_type,grp_exp_id);
		chkRecords = checkRecords(grp_exp_id);
		if(chkRecords){
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", getMessage(language_id,"CODE_ALREADY_EXISTS","Common")) ;
		}else{
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", "success.." ) ;
		}
	}else{
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
	}
	return map ;
 }//end of validate

/*********************METHOD TO Reset the Class variable*************************/

 public void clear() {
	grp_exception_id="";
	order_category="";
	order_type_code="";
	grp_exception_name="";
	super.clear() ;
 }//end of clear


/*********************METHOD TO Update*************************/

 public HashMap modify(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "success.." ) ;
	return map;
 }//end of modify

 /*********************METHOD TO Delete*************************/

 public HashMap delete(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." );
	return map;
 }//end of delete

 /*********************doCommon METHOD *************************/

 private void doCommon() throws Exception {
 }

 /*********************loadData METHOD *************************/
 public void loadData() throws Exception {
 }

 /*********************Servvice Option  METHOD *************************/

/**
  * Used to get Option Item for Order Category
  * @return option Item in a String format.
 */
 public String getComboOptionsOrCat()  throws Exception{
	Connection connection = null ;
	String[] language_id_param = new String[1];
	try{
		language_id_param[0] = language_id;
		connection = getConnection();
		String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_EXP_GRP_OR_CAT_SELECT"),connection,"order_category","short_desc",language_id_param);
		return str;
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
}
/*************************************************************/
 /**
  * Used to get Option Item for Order Type
  * @return option Item in a String format.
  */
 public String getComboOptionsOrType()  throws Exception{
	try{
		String optionStr="";
		Hashtable hTable = new Hashtable();
		hTable.put("type", "OrderCategory");
		hTable.put("order_category", "");
		hTable.put("populate", "string");
		optionStr = getComboBoxHtml(hTable);
		return optionStr;
	}
	catch(Exception e){
		throw e;
	}
}

/**
  * Used to get Option Item dynamically for Order Type
  * based on the Order Category
  * @return option Item in a String format.
 */
public String getComboBoxHtml(Hashtable ht) throws Exception {
	String sql = "" ;
	String optionString = "";
	String comboBoxString = "";
	String  returnType = "";
	String returnString="";
	Connection connection = null;
	try	{
		if( ht == null )
			return "Hashtable Passed to  this method is null";
		connection = getConnection();
	 	String  type = (String)ht.get("type");
		returnType = (String)ht.get("populate");
		if(type.trim().equalsIgnoreCase("OrderCategory")){
		sql	= replace(OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_EXP_GRP_OR_TYPE_SELECT") , "?" ,(String)ht.get("order_category"));
		optionString  = Populate.getComboOptions(sql,connection,"order_type_code","short_desc");
		comboBoxString="&nbsp;<select name='order_type_code' onChange=''><option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---Select---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select>" ;
		}
		else
			throw new Exception("Exception :-in Bean getComboBoxHtml function Hashtable Passed should contain order_category or tick_sheet ID only");

		if(returnType.equals("string")){
			returnString =  optionString;
		}else if(returnType.equals("list")){
			returnString =  comboBoxString;
		}
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();
		 }
	}
	return returnString;
}

 /**
  * Used to replace the selected value to form a proper SQL String
  * @return String
 */
 private String replace(String str ,String change ,String replace){
	int t = str.indexOf(change);
	if( t == -1)
	return str;
	str   = str.substring(0,t) + " '" + replace.trim()+ "' " + str.substring(t+1)  ;
	return str ;
}
 /**
   * Used to Check for the existence of the record in
   * the Database for the given criteria
   * @param exception_type refers the Exception Type Field
   * @param grp_exception_id refers the Group Id Field
   * @return true if it is existing else return false
   */
   // public boolean checkRecords(String exception_type, String grp_exception_id)throws Exception {
 public boolean checkRecords(String grp_exception_id)throws Exception {
	Connection connection = null ;
	PreparedStatement pstmt=null ;
	ResultSet rs=null;
	String SQL_QUERY="";
	boolean checkRecord = false;
	int count = 0;
	try{
		connection = getConnection();
		SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_PRIV_GRP_EXCEPTION_COUNT");
		pstmt = connection.prepareStatement(SQL_QUERY);
		pstmt.setString(1,grp_exception_id);
		//pstmt.setString(2,exception_type);
		rs = pstmt.executeQuery();
		if(rs != null){
			while(rs.next()){
			 count					=	rs.getInt("count");
			}
		}

		if(count > 0)
			checkRecord = true;
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeResultSet(rs) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		}
		catch(Exception e){throw e;}
	}
	return checkRecord;
 }

 /**
   * Used to fetch all the existence record in
   * the Database for the given criteria and put the same in a MultiRecordBean
   * @param exception_type refers the Exception Type Field
   * @param grp_exception_id refers the Group Id Field
   * @param grp_exception_name refers the Group Name Field
   * @return total number records fetched.
   */
   //public int fetchDBRecords(String exception_type, String grp_exception_id, String grp_exception_name)throws Exception {

   public int fetchDBRecords(String exception_type, String grp_exception_id)throws Exception {

	int total_rec =0;
	Connection connection = null ;
	PreparedStatement pstmt=null;
	HashMap htMapRecord = null;
	ResultSet rs=null;

	String SQL_QUERY="", code="", desc="" ;
	String dflt_value = "";
	try{
		int checkRec = multiRecBean.getSize("DB");
		if(checkRec==0){
			connection = getConnection();
			
			if(!exception_type.equals("OC"))
			{
				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_EXP_GRP_ASSOCIATE_REC");
				pstmt = connection.prepareStatement(SQL_QUERY);

				pstmt.setString(1,grp_exception_id);
				pstmt.setString(2,exception_type);

				dflt_value = "Y";
			}
			else
			{
				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_EXP_GRP_ORD_CAT_ASSOCIATE_REC");
				pstmt = connection.prepareStatement(SQL_QUERY);

				pstmt.setString(1,grp_exception_id);
				pstmt.setString(2,exception_type);
				pstmt.setString(3,grp_exception_id);
				pstmt.setString(4,exception_type);
			}

			//pstmt.setString(3,grp_exception_name);

			rs = pstmt.executeQuery();

			if(rs != null){
				while(rs.next()){
				code					=	rs.getString("code");
				desc					=	rs.getString("long_desc");
				try{
				dflt_value				=	rs.getString("dflt_value");
				}catch(SQLException sqle)
					{
						dflt_value = "Y";
					}

				if(desc == null || desc.equals("null"))desc="";
				htMapRecord		=	new HashMap();
				htMapRecord.put("code"			,	code);
				htMapRecord.put("long_desc"		,	desc);
				htMapRecord.put("valid"			,	dflt_value);// changed to N from Y by Subhash on 14th April 2004 
														// "Y" is changed to dflt_value
				htMapRecord.put("associate_yn"	,   "N");
				htMapRecord.put("status"		,   "N");

				multiRecBean.putObject(htMapRecord);
			}
		}
	}
	total_rec = multiRecBean.getSize("DB");
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeResultSet(rs) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		}
		catch(Exception e){throw e;}
	}
	return total_rec;
 }//end of fetchRecords

 /*********************Method to fetch Alphabetical Records ***********************/

 /**
   * Used to fetch all the redords for a given Criteria
   * @param index refers the Alphabet selected
   * @param exception_type refers Exception Type Field
   * @return MultiRecordBean object
   */
 public Object getRecordSet(String index, String exception_type, String order_type_code, String order_category)throws Exception{
	Connection connection = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		java.util.HashMap htRecord = null;
		//String valid="N";
		String long_desc="", SQL_QUERY="", code="";
		//String status="E";
		connection = getConnection();
		multiRecBean.clearSelectRec();
		if(!(index.equals("OTH"))){
			if(exception_type.equals("OC")){
				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST");
			
			}else if(exception_type.equals("OT")){
				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_EXP_GRP_OR_TYPE_DESC");
			}else if(exception_type.equals("OR")){
				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_EXP_GRP_ORDERABLE_DESC");
			}
		}else if(index.equals("OTH")){
			if(exception_type.equals("OT")){
				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_EXP_GRP_OR_TYPE_DESC_OTH");
			}else if(exception_type.equals("OR")){
				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_EXP_GRP_ORDERABLE_DESC_OTH");
			}
		}

		pstmt = connection.prepareStatement(SQL_QUERY);

		if(!(index.equals("OTH"))){
			if(exception_type.equals("OC"))
			{
				pstmt.setString(1,language_id);
			}
			else if(exception_type.equals("OT")){
				pstmt.setString(1,index+"%");
			}else if(exception_type.equals("OR")){
				pstmt.setString(1,order_category);
				pstmt.setString(2,order_type_code);
				pstmt.setString(3,index+"%");
			}
		}else if(index.equals("OTH")){
			if(exception_type.equals("OR")){
				pstmt.setString(1,order_category);
				pstmt.setString(2,order_type_code);
			}
		}

		rs = pstmt.executeQuery();

		if(rs != null){
			while(rs.next()){
				if(exception_type.equals("OC"))
				{
				code				=	rs.getString("order_category");
				long_desc		=	rs.getString("short_desc");
				}
				else
				{
				code				=	rs.getString("code");
				long_desc		=	rs.getString("long_desc");
				}

				/*if(valid.equals("Y"))
					status="D";
				else if(valid.equals("N"))
					status="E";
				*/

				if(long_desc == null || long_desc.equals("null"))long_desc="";

				htRecord					=	new HashMap();

				htRecord.put("code"			,	code);
				htRecord.put("long_desc"	,	long_desc);
				htRecord.put("valid"		,	"N");
				htRecord.put("associate_yn" ,   "N");
				htRecord.put("status"		,	"N");
				multiRecBean.putListObject(htRecord);
			}
		}
	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeResultSet(rs) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		}
		catch(Exception e){throw e;}
	}
	return multiRecBean;
 }//end of getRecordSet
 /***************************To get the multiRecord bean ***********/

 /**
   * Used the get the Latest MultiRecordBean Instance
   * @return MultiRecordBean object.
   */
 public Object getBean(){
	return this.multiRecBean;
 }//end of getBean

 /***************************To clear the multiRecord bean ***********/

 /**
   * Used to clear the records from the MultiRecordBean
   * @returns true if cleared else false
   */
  public boolean clearDBRec()throws Exception{
	boolean clearFlag = false;
	clearFlag = multiRecBean.clearDBRec();
	return clearFlag;
 }//end of clearDBRec


 /**
   * Used to get the Order Category values based on the Query
   * in the form of code value pair
   * @return String of Code/Value Pair.
   */
 public String getOrCatString()throws Exception{
	Connection 	connection  = null;
	ResultSet rs		= null;
	PreparedStatement pstmt		= null;
	try {
		connection  = getConnection();
		
		pstmt						= connection.prepareStatement(eOR.Common.OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST"));
		pstmt.setString(1,language_id);
		 rs							= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
		String  codeCol			    = "";
		String  codeDesc			= "";

		while (rs.next()){
				codeDesc		    = ChkDef.defaultString(rs.getString(1));
				codeCol				= ChkDef.defaultString(rs.getString(2));
			    sb.append(codeCol+ "," +codeDesc+ ",");
		}

		 String str =   sb.toString() ;
		 sb.setLength(0);
		 return str.substring(0, str.length()-1);
		}catch(Exception e){
		throw(e);
		//return null;
	}finally{
		try{
			closeResultSet(rs) ;
			closeStatement(pstmt) ;
			closeConnection(connection) ;
		 }catch(Exception e){e.printStackTrace();}
		}
	}

}//end of class


