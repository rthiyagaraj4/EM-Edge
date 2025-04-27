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
import eOR.ORMultiFacilityProcessing.* ;
import eOR.Common.*;

public class  MultiFacilityProcessingBean extends OrAdapter implements Serializable
{
	protected String ordering_facility_id;
	protected String order_category;
	protected String order_type_code;
	protected String performing_facility_id;
	protected String source_type_code;
	protected String source_location_code;
	protected String performing_location_code;
	public String debug="";
	protected Hashtable MultiHashData = new Hashtable();
	protected Hashtable ModifyMultiHashData = new Hashtable();
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

/*********************Constructor *************************/

 public MultiFacilityProcessingBean(){
	ordering_facility_id="";
	order_category="";
	order_type_code="";
	performing_facility_id="";
	try{
		doCommon();
	}catch(Exception e) {e.printStackTrace();}
 }

/**********************SET METHODS*************************/

  public void  setOrdering_facility_id(String  ordering_facility_id) {this.ordering_facility_id=  ordering_facility_id; } ;
  public void  setOrder_category(String order_category) {this.order_category = order_category; } ;
  public void  setOrder_type_code(String order_type_code) {this.order_type_code = order_type_code; } ;
  public void  setPerforming_facility_id(String performing_facility_id) {this.performing_facility_id = performing_facility_id; } ;
  public void  setSource_type_code(String source_type_code) {this.source_type_code = source_type_code; } ;
  public void  setSource_location_code(String source_location_code) {this.source_location_code = source_location_code; } ;
  public void  setPerforming_location_code(String performing_location_code) {this.performing_location_code = performing_location_code; } ;
  public void  setDebug(String  debug) {this.debug=  debug; } ;

/**********************GET METHODS*************************/

  public String getOrdering_facility_id() { return this.ordering_facility_id ; } ;
  public String getOrder_category() { return this.order_category ; } ;
  public String getOrder_type_code() { return this.order_type_code ; } ;
  public String getPerforming_facility_id() { return this.performing_facility_id ; } ;
  public String getSource_type_code() { return this.source_type_code ; } ;
  public String getSource_location_code() { return this.source_location_code ; } ;
  public String getPerforming_location_code() { return this.performing_location_code ; } ;
  public String getDebug() { return this.debug ; } ;


/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSet ) {

	try{
		setOrdering_facility_id((String)recordSet.get("ordering_facility_id"));
		setOrder_category((String)recordSet.get("order_category"));
		setOrder_type_code((String)recordSet.get("order_type_code"));
		setPerforming_facility_id((String)recordSet.get("performing_facility_id"));
		setSource_type_code((String)recordSet.get("source_type_code"));
		setSource_location_code((String)recordSet.get("source_location_code"));
		setPerforming_location_code((String)recordSet.get("performing_facility_lo"));
		setMode((String)recordSet.get("mode"));
	}
	catch(Exception e){
	try{
		throw new Exception("Exception@SetAll: "+e);
		}catch(Exception ee){ee.printStackTrace();
		}
	 }
 }//end of setALL

/*********************METHOD TO Insert*************************/
public HashMap insert(){

	HashMap map = new HashMap() ;
	//debug +="inside insert";
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message","success...");
	map.put( "flag",debug) ;

	HashMap tabData = new HashMap() ;
	HashMap split = new HashMap();
	ArrayList deleteArrList = new ArrayList();
	ArrayList insertArrList = new ArrayList();
	//ArrayList updateArrList = new ArrayList();
	ArrayList allRecords = new ArrayList();
	String valid= "", associate_yn="";
	String SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1="SELECT count(*) from OR_ORDER_FACILITY_CROSS_REF where ordering_facility_id = ? and order_category = ? and order_type_code = ? and order_catalog_code = ? and ordering_source_type=DECODE(?,'LB','L','RD','R','RX','I','MI','M','TR','T','PC','P') and ordering_source_code=? and performing_facility_id=?";
	//String index_type="";

	//ORMultiFacilityProcessingHome home = null ;
	//ORMultiFacilityProcessingRemote remote = null ;
	try {
		fetchDBRecords(getOrdering_facility_id(), getOrder_category(), getOrder_type_code(), getPerforming_facility_id(), getSource_type_code(), getSource_location_code());
		allRecords = multiRecBean.getAllDBRecords();

		//debug += "Before allRecords:"+allRecords.size();
	
		if(allRecords.size()>0){
		for(int j=0;j<allRecords.size();j++){
   
			split			= (HashMap)allRecords.get(j);
			
			valid			= (String) split.get("valid");
			associate_yn	= (String) split.get("associate_yn");
			

			if(valid.equals("Y")){
				if(associate_yn.equals("D")){
					deleteArrList.add(split);
				}
			}else if(valid.equals("N")){
				if(associate_yn.equals("Y")){
		
					insertArrList.add(split);
				}
			}

		}
	}else{
	
		if(!order_type_code.equals("ALL")){
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message","CLICK_ONE_ORDERABLE");
		return map;	}
	}
		//debug += "After allRecords:"+allRecords.size();
		//debug += "delSize:"+deleteArrList.size();
		//debug += "insSize:"+insertArrList.size();
	
		//debug += "getOrdering_facility_id():"+getOrdering_facility_id();
		//debug += "getOrder_category:"+getOrder_category();
		//debug += "getOrder_type_code():"+getOrder_type_code();
		//debug += "getPerforming_facility_id():"+getPerforming_facility_id();

		MultiHashData.put("ordering_facility_id", getOrdering_facility_id());
		MultiHashData.put("order_category", getOrder_category());
		MultiHashData.put("order_type_code", getOrder_type_code());
		MultiHashData.put("performing_facility_id", getPerforming_facility_id());
		MultiHashData.put("source_type_code", getSource_type_code());
		MultiHashData.put("source_location_code", getSource_location_code());
		MultiHashData.put("performing_location_code",getPerforming_location_code());;
		MultiHashData.put("login_by_id", login_by_id);
		MultiHashData.put("login_at_ws_no",login_at_ws_no);
		MultiHashData.put("login_facility_id",login_facility_id);

		tabData.put("MultiHashData",MultiHashData);
		tabData.put("deleteArrList",deleteArrList);
		tabData.put("insertArrList",insertArrList);
		tabData.put("properties", (Properties)getProperties());

		HashMap sqlMap = new HashMap();
		//sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK", OrRepository.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK"));
		//sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1",
           // OrRepository.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1"));
		 sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1",SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1);
		sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_DELETE", OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_DELETE") );
		sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_INSERT", OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_INSERT") );



		//eOR.ORMultiFacilityProcessingManager remote = new eOR.ORMultiFacilityProcessingManager();

		/*InitialContext context = new InitialContext() ;
		Object object = context.lookup( OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_JNDI") ) ;
		home  = (ORMultiFacilityProcessingHome) PortableRemoteObject.narrow( object, ORMultiFacilityProcessingHome.class ) ;
		remote = home.create() ;

		map = remote.insert( tabData, sqlMap ) ;*/
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_JNDI"), ORMultiFacilityProcessingHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();
 		map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;


		if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "Common")) ;
				}
        /*
        Iterator values = map.values().iterator();
        while(values.hasNext()) {

        }

        map.get("flag"));*/
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

	}
	catch(Exception e) {

	map.put( "message", e.getMessage()+debug) ;
	e.printStackTrace() ;
	}finally{
		clear();
		/*try {
			if( remote != null ){
				remote.remove() ;
			}
		}catch( Exception ee ) {

			map.put( "message", ee.getMessage() ) ;
			}*/
	}
	return map ;
 }//end of insert

/********************Validate Method ****************************/
 public HashMap validate() throws Exception {
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." ) ;
	return map ;
 }//end of validate

/*********************METHOD TO Reset the Class variable*************************/

 public void clear() {
	ordering_facility_id="";
	order_category="";
	order_type_code="";
	performing_facility_id="";
	super.clear() ;
 }//end of clear


/*********************METHOD TO Update*************************/

 public HashMap modify()
{
	
	
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message","success...");
	map.put( "flag",debug) ;

	HashMap tabData = new HashMap() ;
	HashMap split = new HashMap();
	ArrayList deleteArrList = new ArrayList();
	ArrayList insertArrList = new ArrayList();

	ArrayList allRecords = new ArrayList();
	String valid= "", associate_yn="";
	String SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1="SELECT count(*) from OR_ORDER_FACILITY_CROSS_REF where ordering_facility_id = ? and order_category = ? and order_type_code = ? and order_catalog_code = ? and ordering_source_type=DECODE(?,'LB','L','RD','R','RX','I','MI','M','TR','T','PC','P') and ordering_source_code=? and performing_facility_id=?";
	
	try { 
		fetchDBRecords(getOrdering_facility_id(), getOrder_category(), getOrder_type_code(), getPerforming_facility_id(), getSource_type_code(), getSource_location_code());
		allRecords = multiRecBean.getAllDBRecords();

	
	
		if(allRecords.size()>0){
		for(int j=0;j<allRecords.size();j++){
       
			split			= (HashMap)allRecords.get(j);
			
			valid			= (String) split.get("valid");
			associate_yn	= (String) split.get("associate_yn");
		

			if(valid.equals("Y")){
				if(associate_yn.equals("D")){
					deleteArrList.add(split);
				}
			}else if(valid.equals("N")){
				if(associate_yn.equals("Y")){
					
					insertArrList.add(split);
				}
			}

		}
	}else{
		
		if(!order_type_code.equals("ALL")){
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message","CLICK_ONE_ORDERABLE");
		return map;	}
	}
		

		ModifyMultiHashData.put("ordering_facility_id", getOrdering_facility_id());
		ModifyMultiHashData.put("order_category", getOrder_category());
		ModifyMultiHashData.put("order_type_code", getOrder_type_code());
		ModifyMultiHashData.put("performing_facility_id", getPerforming_facility_id());
		ModifyMultiHashData.put("source_type_code", getSource_type_code());
		ModifyMultiHashData.put("source_location_code", getSource_location_code());
		ModifyMultiHashData.put("performing_location_code",getPerforming_location_code());
		ModifyMultiHashData.put("login_by_id", login_by_id);
		ModifyMultiHashData.put("login_at_ws_no",login_at_ws_no);
		ModifyMultiHashData.put("login_facility_id",login_facility_id);

		tabData.put("ModifyMultiHashData",ModifyMultiHashData);
		tabData.put("deleteArrList",deleteArrList);
		tabData.put("insertArrList",insertArrList);
		tabData.put("properties", (Properties)getProperties());

		HashMap sqlMap = new HashMap();
		//sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK", OrRepository.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK"));
		//sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1",
            //OrRepository.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1"));
		sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1",SQL_OR_MULTI_FAC_PROCESSING_DUP_CHK1);
		sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_DELETE", OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_DELETE") );
		sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_INSERT", OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_INSERT") );
		sqlMap.put("SQL_OR_MULTI_FAC_PROCESSING_UPDATE", OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_UPDATE") );


		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_JNDI"), ORMultiFacilityProcessingHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();
 		map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;


		if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "Common")) ;
				}
       

	}
	catch(Exception e) {

	map.put( "message", e.getMessage()+debug) ;
	e.printStackTrace() ;
	}finally{
		clear();
		
	}
	return map ;
}//end of modify

 /*********************METHOD TO Delete*************************/

 public HashMap delete()
{
	    HashMap tabData = new HashMap();
		HashMap sqlData = new HashMap();
		HashMap hashMap = new HashMap(); 
		try
		{
		
			sqlData.put("SQL_OR_MULTI_FAC_PROCESSING_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_DELETE"));
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_JNDI"), ORMultiFacilityProcessingHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			tabData.put("ordering_facility_id",ordering_facility_id.trim());
			tabData.put("order_category",order_category.trim());
			tabData.put("order_type_code",order_type_code.trim());
			tabData.put("source_type_code",source_type_code.trim());
			tabData.put("source_location_code",source_location_code.trim());
			tabData.put("performing_facility_id",performing_facility_id.trim());

			tabData.put("properties", getProperties());
			
			Object argArray[]	= new Object[2];
				argArray[0]		= tabData;
				argArray[1]		= sqlData;
 			Class [] paramArray = new Class[2];
 		 		paramArray[0]	= tabData.getClass();
				paramArray[1]	= sqlData.getClass();

 			hashMap = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;
					
			hashMap.put( "message", getMessage(language_id, (String) hashMap.get( "message" ), "SM")) ;

		}catch(Exception e)
		{

			e.printStackTrace();
		}
		return hashMap;
 }//end of delete

 /*********************doCommon METHOD *************************/

 private void doCommon() throws Exception {
 }

 /*********************loadData METHOD *************************/
 public void loadData() throws Exception {
 }

 /*********************Servvice Option  METHOD *************************/
 public String getComboOptionsFacId(String defaultval)  throws Exception{
	Connection connection = null ;
	try{
		connection = getConnection();
		String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_OR_FAC"),connection,"FACILITY_ID   ","FACILITY_NAME",defaultval.trim());
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

public String getComboOptionsOrCat(String defaultval)  throws Exception{
	Connection connection = null ;
	String[] language_id_param = new String[1];
	try{
		language_id_param[0] = language_id;
		connection = getConnection();
		String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC4"),connection,"order_category","short_desc",defaultval.trim(),language_id_param);
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
public String getComboBoxHtml(Hashtable ht,String defaultval) throws Exception {
	String sql = "" ;
	String optionString = "";
	String comboBoxString = "";
	Connection connection = null;
	String selected="";
	String disabled="";
	if(defaultval.trim().equalsIgnoreCase("ALL"))
	{
		selected="selected";
	}
	if(!defaultval.trim().equals(""))
	{
		disabled="disabled";
	}
	try	{

		if( ht == null )
			return "Hashtable Passed to  this method is null";

		connection = getConnection();
	 	String  type = (String)ht.get("type");
		if(type.trim().equalsIgnoreCase("OrderCategory")){
			sql			  = replace(OrRepository.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_OR_TYPE_SELECT") , "?" ,(String)ht.get("order_category"));

			optionString  = Populate.getComboOptions(sql,connection,"order_type_code","short_desc",defaultval.trim());

			comboBoxString="<select name='order_type_code' "+disabled+" onChange='setForAll(this);'><option>---Select---</option><option value='ALL' "+selected+" >   AALL    </option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
		}else if(type.trim().equalsIgnoreCase("OrderingFacID")){
			sql			  = replace(OrRepository.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_PRFM_FAC") , "?" ,(String)ht.get("ordering_facility_id"));

			//optionString  = Populate.getComboOptions(sql,connection,"facility_id","facility_name");
			optionString  = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_OR_FAC"),connection,"FACILITY_ID   ","FACILITY_NAME",defaultval.trim());

			comboBoxString="<select name='performing_facility_id' "+disabled+" onChange='fillPerformingLocation(this);'><option>---Select---</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
		}/*else if(type.trim().equalsIgnoreCase("PerformFacID")){
			sql = OrRepository.getOrKeyValue("SQL_OR_ORDERABLES_BY_PERFORM_LOCN_PERF_LOCN");
            sql = replace(sql, "?", this.getLoginFacilityId());
            sql = replace(sql, "?", (String)ht.get("location_type"));

            optionString = Populate.getComboOptions(sql,connection,"performing_deptloc_code","performing_deptloc_short_desc");
            comboBoxString="&nbsp;<select name='performing_facility_lo' ><option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ; //onChange='parent.parent.fillComboOptions(this);'
		}*/
		else
			throw new Exception("Exception :-in Bean getComboBoxHtml function Hashtable Passed should contain order_category or tick_sheet ID only");

		}
	catch(Exception e){
		throw e;
	}
	finally
	{
		try
		 {
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();

		 }
	}

	return comboBoxString;
}

/*************************************************************/
private String replace(String str ,String change ,String replace)
	{
		int t = str.indexOf(change);

		if( t == -1)
		return str;

		str   = str.substring(0,t) + " '" + replace.trim()+ "' " + str.substring(t+1)  ;

		return str ;
	}

/************************************************************/
 /*********Method to fetch the Data Base Values*************/
 public int fetchDBRecords(String ordering_facility_id, String order_category, String order_type_code, String performing_facility_id, String source_type_code, String source_location_code)throws Exception {

	int total_rec =0;
	Connection connection = null ;
	PreparedStatement pstmt=null;
	HashMap htMapRecord = null;
	ResultSet rs=null;

	String SQL_QUERY="", code="", desc="", performing_locn="" ;

	try{
		int checkRec = multiRecBean.getSize("DB");

		if(checkRec==0){
			connection = getConnection();
			SQL_QUERY = OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_ASSOCIATED_REC");
			
			pstmt = connection.prepareStatement(SQL_QUERY);

			pstmt.setString(1,ordering_facility_id);

			pstmt.setString(2,order_category);

			pstmt.setString(3,order_type_code);

			pstmt.setString(4,performing_facility_id);

			pstmt.setString(5,source_type_code);

			pstmt.setString(6,source_location_code);


			rs = pstmt.executeQuery();

			if(rs != null){
				while(rs.next()){

				code					=	rs.getString("code");
				desc					=	rs.getString("long_desc");
				performing_locn			=	rs.getString("performing_locn");

				if(desc == null || desc.equals("null"))desc="";
				if (performing_locn == null || performing_locn.equals("null")) performing_locn = "";
				htMapRecord		=	new HashMap();
				htMapRecord.put("code"				,	code);
				htMapRecord.put("catalog_desc"		,	desc);
				htMapRecord.put("performing_locn" 	, 	performing_locn);
				htMapRecord.put("valid"				,	"Y");
				htMapRecord.put("associate_yn"		,   "N");
				htMapRecord.put("status"			,   "N");

				multiRecBean.putObject(htMapRecord);
			}
		}
			
			
			closeResultSet(rs);
			closeStatement(pstmt);
	}
	total_rec = multiRecBean.getSize("DB");

	}
	catch(Exception e){
		throw e;
	}
	finally{
		try{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return total_rec;
 }//end of fetchRecords

 /*********************Method to fetch Alphabetical Records ***********************/

// public Object getRecordSet(String index, String performing_facility_id,String order_category,String order_type_code)throws Exception{
 public Object getRecordSet(String index,String order_category,String order_type_code,String ordering_facility_id, String performing_facility_id, String source_type, String source_location)throws Exception{

	Connection connection = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String associate_detail_yn="";

	try{
		java.util.HashMap htRecord = null;
		String catalog_desc="", SQL_QUERY="", code="";//valid="N",status="E";
		connection = getConnection();
		multiRecBean.clearSelectRec();
		if(!(index.equals("OTH"))){
			SQL_QUERY = OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_CATALOG_DESC");
			
		}else{
			SQL_QUERY = OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_CATALOG_DESC_OTH");
			
		}
		pstmt = connection.prepareStatement(SQL_QUERY);
		if(!(index.equals("OTH"))){
			pstmt.setString(1,order_category);
			pstmt.setString(2,order_type_code);
			pstmt.setString(3,index+"%");
			//pstmt.setString(4,performing_facility_id);
		}else{
			pstmt.setString(1,order_category);
			pstmt.setString(2,order_type_code);
			//pstmt.setString(3,performing_facility_id);
		}

		rs = pstmt.executeQuery();
		if(rs != null){
			while(rs.next()){
				associate_detail_yn="";
				code				=	rs.getString("code");
				catalog_desc		=	rs.getString("long_desc");
				//valid				=	rs.getString("valid");

				/*if(valid.equals("Y"))
					status="D";
				else if(valid.equals("N"))
					status="E";*/
				/*sql_detail_query = OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_ASSOCIATED_REC_OTHER_FACILITY");
			
			pstmt_detail = connection.prepareStatement(sql_detail_query);

			pstmt_detail.setString(1,ordering_facility_id);
			pstmt_detail.setString(2,order_category);
			pstmt_detail.setString(3,order_type_code);
			pstmt_detail.setString(4,performing_facility_id);
			pstmt_detail.setString(5,source_type);
			pstmt_detail.setString(6,source_location);
			pstmt_detail.setString(7,code);

			rs_detail = pstmt_detail.executeQuery();

			if(rs_detail != null)
			{
				while(rs_detail.next())
				{
					associate_detail_yn="A";
					
				}
			}*/


				
				if(catalog_desc == null || catalog_desc.equals("null"))catalog_desc="";

				htRecord					=	new HashMap();

				htRecord.put("code"			,	code);
				htRecord.put("catalog_desc"	,	catalog_desc);
				htRecord.put("performing_locn",	"");
				htRecord.put("valid"		,	"N");
				/*if(associate_detail_yn.equalsIgnoreCase("A"))
				{
		
					htRecord.put("associate_yn" ,   "A");
				}
				else
				{*/
			
				htRecord.put("associate_yn" ,   "N");
				//}
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
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return multiRecBean;
 }//end of getRecordSet

 /***************************To get the multiRecord bean ***********/
 public Object getBean(){
	return this.multiRecBean;
 }//end of getBean

 /***************************To clear the multiRecord bean ***********/
  public boolean clearDBRec()throws Exception{
	boolean clearFlag = false;
	clearFlag = multiRecBean.clearDBRec();
	return clearFlag;
 }//end of clearDBRec

/*********/
	public String getOrCatString()throws Exception{
	Connection 	connection  = null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	try {
		connection  = getConnection();

		pstmt					= connection.prepareStatement(eOR.Common.OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC4"));
		pstmt.setString(1,language_id);
		rs						= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();

		String  codeCol	 = "";
		String  codeDesc = "";

		while (rs.next()){
				codeDesc = ChkDef.defaultString(rs.getString(1));
				codeCol	 = ChkDef.defaultString(rs.getString(2));
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
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();}
		}
	}
	/*********/

    /*Added By Siva Kumr for Location Type Enhancements - 28/8/2003*/
	public ArrayList getLocationSpecific(String locType,String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		ArrayList LocationClass = new ArrayList();
		try {
			connection = getConnection() ;
            if (locType != null && locType.equals("C")) {
                pstmt = connection.prepareStatement(
                    OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINTC")) ;
                pstmt.setString(1,facility_id);
            }
            else if (locType != null && locType.equals("N")) {
                pstmt = connection.prepareStatement(
                    OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINTN")) ;
                pstmt.setString(1,facility_id);
            }
            /*else {
                pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_OR_PARAM_FOR_FACILITY_OTHER_LOC_PRINT")) ;
                pstmt.setString(1,operating_facility_id);
                pstmt.setString(2,operating_facility_id);
            }*/
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[3];
				record[0] = resultSet.getString("location_code");
				record[1] = resultSet.getString("location_desc");
                record[2] = resultSet.getString("Locn_Type");

				LocationClass.add(record);
			}
			return LocationClass;
		} catch ( Exception e )	{

			e.printStackTrace() ;
			LocationClass.add(e);
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
			
		}

	}

////////////////End of Addition by Siva Kumar///////////////////////////////

	public ArrayList getPerformingLocn(String locType,String facility_id,String order_catalog_code) throws Exception {







		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//String labchk="";

		ArrayList LocationClass = new ArrayList();
		try {
			boolean installed = false;
			connection = getConnection() ;
			if (locType.equalsIgnoreCase("LB")) {
				//labchk=checkForNull(getmoduleRL(order_catalog_code,locType,order_type_code,login_facility_id),"");

                //if ((isModuleInstalled(facility_id,"RL")).equalsIgnoreCase("Y")) {changed on 7/19/2007 for lab_instal logic by uma 
              //  if (labchk.equalsIgnoreCase("IBARL")) {
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN_LB")) ;
	    			pstmt.setString(1,facility_id);
                    pstmt.setString(2,order_catalog_code);																    
					installed = true;
				//}
            } 
			else if (locType.equalsIgnoreCase("RD")) {
				if ((isModuleInstalled(facility_id,locType)).equalsIgnoreCase("Y")) {
					pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN_RD")) ;
					pstmt.setString(1,facility_id);
		            pstmt.setString(2,order_catalog_code);
					installed = true;
				}
			}
			if (!installed){
				closeStatement(pstmt);		    
	        pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PERFORMING_DEPT_LOCN")) ;
			pstmt.setString(1,"en");
			pstmt.setString(2,facility_id);
			pstmt.setString(3,locType); 
			pstmt.setString(4,order_catalog_code);                    
			}        

            resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[3];
				record[0] = resultSet.getString("short_desc");
				record[1] = resultSet.getString("code");
				record[2] = resultSet.getString("default_yn");

                LocationClass.add(record);
			}
			return LocationClass;
		} catch ( Exception e )	{

			e.printStackTrace() ;
			LocationClass.add(e);
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
			
		}

	}

/********* Method to Populate Perf Location when OrderType is ALL  **********/

public ArrayList getPerformingLocn1(String locType,String facility_id) throws Exception {





		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		ArrayList LocationClass1 = new ArrayList();
		try {
			boolean installed = false;
			connection = getConnection() ;
			if (locType.equalsIgnoreCase("LB")) {
               // if ((isModuleInstalled(facility_id,"RL")).equalsIgnoreCase("Y")) {changed on 7/19/2007 for lab_install check by uma 
				pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_PERFORM_LOCN_LB_SELECT")) ;
	    			pstmt.setString(1,facility_id);    
					installed = true;
			//	}
	
            } else if (locType.equalsIgnoreCase("RD")) {
				if ((isModuleInstalled(facility_id,locType)).equalsIgnoreCase("Y")) {
					pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_PERFORM_LOCN_RD_SELECT")) ;
					pstmt.setString(1,facility_id);	
					installed = true;
				}
			}

			if (!installed){
				closeStatement(pstmt);
 			    
	        pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("MULTI_FAC_PROCESSING_PERFORM_LOCN_SELECT")) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locType); 
			
			} 
            resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String record[] = new String[3];
				record[0] = resultSet.getString("short_desc");
				record[1] = resultSet.getString("code");





              LocationClass1.add(record);
			}
			return LocationClass1;
		} catch ( Exception e )	{

			e.printStackTrace() ;
			LocationClass1.add(e);
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;			
		}

	}

/********* End of Method to Populate Perf Location when OrderType is ALL  **********/

	public String  isModuleInstalled(String facility_id, String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String install_yn = "";



		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN") ) ;

			pstmt.setString(1, order_category.trim());
			pstmt.setString(2, facility_id.trim());

			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null && resultSet.next() ) {
				install_yn = resultSet.getString(1)  ;

			}else{
				install_yn  = "N";

			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}

		return install_yn;
	}

    /********Gives the DataBase Record if already  present or for Ascc /else Original DataBase record***********/
	public boolean setBeanItemValue(int rowIndex, String value)throws Exception{


		boolean altSelRecord  =	false;
		boolean altDBRecord =	false;
		int foundIndex = 0;
		//String valid ="";
		java.util.HashMap hash = new java.util.HashMap();
		//java.util.HashMap hashDB = new java.util.HashMap();

		hash = (java.util.HashMap)multiRecBean.getListObject(rowIndex);

		//if(value.equals("Y")){
			hash.put("performing_locn", value);
			altSelRecord = multiRecBean.setListObject(rowIndex, hash);

			if(altSelRecord){


				foundIndex = multiRecBean.scanRecord(hash);
				if(foundIndex != -1){
					altDBRecord = multiRecBean.setObject(foundIndex,hash);

				}else{
					altDBRecord = multiRecBean.putObject(hash);

				}
			}
		/*}else if(value.equals("N")){
			hash.put("performing_locn", value);
			altSelRecord = multiRecBean.setListObject(rowIndex, hash);
			if(altSelRecord){
				altDBRecord =multiRecBean.removeRecord(hash);
			}

		}*/
		return altDBRecord;
	}


	/**
	  * Used to set the latest status of the bean value in the Associted records and inturn
	  * keep both to ArrayList in Synchronize, based on the operations
	  * performed on them.
	  * @param rowIndex refers the row Position.
	  *	@param value refers to the latest value.
	  */
	public boolean setDBBeanItemValue(int rowIndex, String value)throws Exception{

		boolean altDBRecord =	false;
		//String valid ="";
		java.util.HashMap hash = new java.util.HashMap();
		hash = (java.util.HashMap)multiRecBean.getObject(rowIndex);
		hash.put("performing_locn", value);
		altDBRecord = multiRecBean.setObject(rowIndex,hash);

		return altDBRecord;
	}
	/*public String getmoduleRL(String catalogcode,String categorycode,String ordertypecode,String facility_id) throws Exception 
{
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String modname="";
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("OR_GET_INTERFACED_APPL"));
			pstmt.setString(1,(String)catalogcode);
			pstmt.setString(2,(String)categorycode);
			pstmt.setString(3,(String)ordertypecode);
			pstmt.setString(4,(String)facility_id);
			rs	  =pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				modname = rs.getString("modname");
			}
		}
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally { 
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return modname;
		
}*/

public String getPerformingLocation(String ordering_facility_id,String order_category, String order_type_code,String source_type,String source_location,String performing_facility_id) throws Exception {
			
		Connection connection 		= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		
		String performing_locn	= "";
		try{

				ordering_facility_id 	= (ordering_facility_id == null) ? "":ordering_facility_id;
				order_category 	= (order_category == null) ? "":order_category;
				order_type_code 	= (order_type_code == null) ? "":order_type_code;
				source_type 	= (source_type == null) ? "":source_type;
				source_location 	= (source_location == null) ? "":source_location;
				performing_facility_id 	= (performing_facility_id == null) ? "":performing_facility_id;

				connection  = getConnection();
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_MULTI_FAC_PROCESSING_PERFORM_LOCN") ) ;
				pstmt.setString(1, ordering_facility_id);
				pstmt.setString(2, order_category);
				pstmt.setString(3, order_type_code);
				pstmt.setString(4, source_type);
				pstmt.setString(5, source_location);
				pstmt.setString(6, performing_facility_id);

				rs	  =pstmt.executeQuery();
				while(rs != null && rs.next())
				{
					performing_locn	=rs.getString("PERFORMING_DEPTLOC_CODE");
				}
			}catch ( Exception e )	
			{
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			
			return performing_locn;
}//End Of performing_locn


}//end of class
