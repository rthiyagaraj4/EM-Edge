/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------
?           100            	?           	?				?					created
09/10/2014	IN050655		VijayakumarK	09/10/2014							iASSIST ID : 807002 Index Tick sheet by practitioner is a 
																				good functionality to provide personalised tick sheets to practitioners.
------------------------------------------------------------------------------------------------------------------------------------------
*/
package eOR ;

import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;
import eOR.ORIndexTickSheet.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import eOR.Common.*;
import eCommon.Common.*;
public class  IndexTickSheet extends eOR.Common.OrAdapter implements Serializable
{
	protected String order_category;
	protected String tick_sheet_id;
	protected String index_type;
	protected String facility_id;
	protected String source_type;
	protected String source_code;
	protected Hashtable MultiHashData = new Hashtable();
	protected String SelectYNStr;
	String debug="";
	//eOR.IndexRecBean indexRecSet = new eOR.IndexRecBean();
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();



/*********************Constructor *************************/

 public IndexTickSheet(){
	tick_sheet_id	= ""    ;
	index_type		= ""    ;
	facility_id		= ""    ;
	source_type		= ""    ;
	source_code		= ""    ;
	SelectYNStr		= ""	;

	try{
		doCommon();
	}catch(Exception e) {e.printStackTrace();}
}

/**********************SET METHODS*************************/

  public void  setOrder_category(String  order_category) {this.order_category=  order_category; } ;
  public void  setTick_sheet_id(String  tick_sheet_id) {this.tick_sheet_id=  tick_sheet_id; } ;
  public void  setIndex_type(String  index_type) {this.index_type=  index_type; } ;
  public void  setFacility_id(String  facility_id) {this.facility_id=  facility_id; } ;
  public void  setSource_type(String  source_type) {this.source_type=  source_type; } ;
  public void  setSource_code(String  source_code) {this.source_code=  source_code; } ;
  public void  setSelectYNStr(String  SelectYNStr) {this.SelectYNStr=  SelectYNStr; } ;

/**********************GET METHODS*************************/

  public String getOrder_category() { return this.order_category ; } ;
  public String getTick_sheet_id() { return this.tick_sheet_id ; } ;
  public String getIndex_type() { return this.index_type ; } ;
  public String getFacility_id() { return this.facility_id ; } ;
  public String getSource_type() { return this.source_type ; } ;
  public String getSource_code() { return this.source_code ; } ;
  public String getSelectYNStr() { return this. SelectYNStr ; } ;

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

public void setAll( Hashtable recordSet ) {
try{
	//System.out.println("#####in set all method");
	//Hashtable htRecord = new Hashtable();
	String multiRec ="";

	order_category = (String)recordSet.get("order_category");
	tick_sheet_id  = (String)recordSet.get("tick_sheet_id");
	index_type     = (String)recordSet.get("index_type");
	facility_id    = (String)recordSet.get("facility_id");
	source_type    = (String)recordSet.get("source_type");

	SelectYNStr    = (String)recordSet.get("SelectYNStr");

	if(facility_id==null || facility_id.equals("null") || facility_id.equals(""))facility_id="";
	if(source_type==null || source_type.equals("null") || source_type.equals(""))source_type="";

	if(index_type.equals("F")){
		if(source_type.equals("C")){
			multiRec = source_type;
		 }else if(source_type.equals("N")){
			multiRec = source_type;
		 }else if(source_type.equals("A")){
			multiRec = source_type;
		 }
	}else if(index_type.equals("S")){
		multiRec = index_type;
	}else if(index_type.equals("P")){
		multiRec = index_type;
	}
	/*
	if(!SelectYNStr.equals("")){
		String sel_code		=	"";
		String index_val	=	"";
		int index			= 0;

		StringTokenizer stoken_code = new StringTokenizer(SelectYNStr,"~");
		int count_code		=	stoken_code.countTokens();
		for(int i=0;i<count_code;i++){
			sel_code		=	stoken_code.nextToken();
			index_val		=	sel_code.substring(9);
			index			=	Integer.parseInt(index_val);
			htRecord		=	(java.util.Hashtable) indexRecSet.getObject(index);
			htRecord.put("associate_yn"		,	"Y");
			indexRecSet.setObject((index),htRecord);
			IndexTickShArrList.add(i,htRecord);
			}
		}
		*/
		MultiHashData.put("order_category",order_category);
		MultiHashData.put("tick_sheet_id",tick_sheet_id);
		MultiHashData.put("index_type",index_type);
		MultiHashData.put("facility_id",facility_id);
		MultiHashData.put("source_type",source_type);
		MultiHashData.put("multiRec",multiRec);

	 }
	 catch(Exception e){
		 try{
		 throw new Exception("Excweption@SetAll: "+e);
		 }catch(Exception ee)
		 {ee.printStackTrace();}
	 }

}



public HashMap validate() throws Exception {
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." ) ;
	return map ;
}


/*********************METHOD TO Reset the Class variable*************************/

	public void clear() {
	tick_sheet_id	= ""    ;
	index_type		= ""    ;
	facility_id		= ""    ;
	source_type		= ""    ;
	source_code		= ""    ;
	SelectYNStr		= ""	;
	super.clear() ;
}


/*********************METHOD TO Insert*************************/

public HashMap insert(){
	//debug +="inside insert";
	HashMap map = new HashMap() ;
	StringBuffer tmpBuff	= new StringBuffer();
	HashMap tabData = new HashMap() ;
	HashMap split = new HashMap();
	ArrayList deleteArrList = new ArrayList();
	ArrayList insertArrList = new ArrayList();
	//ArrayList updateArrList = new ArrayList();
	ArrayList IndexTickShArrList = new ArrayList();

	String valid= "", associate_yn="", index_type="";
	String SQL_OR_INDEX_TICK_SHEET_DELETE = "";

	index_type = (String)MultiHashData.get("multiRec");

	map.put( "result", new Boolean( false ) ) ;
	map.put( "flag","") ;

	//ORIndexTickSheetHome home = null ;
	//ORIndexTickSheetRemote remote = null ;

	//debug += "index_type :"+index_type;
	try{
		IndexTickShArrList = multiRecBean.getAllDBRecords();
		//debug += "Before IndexTickShArrListSize:"+IndexTickShArrList.size();

		//System.out.println("allRecords.size()="+allRecords.size());
		//System.out.println("allRecords="+allRecords);

		for(int j=0;j<IndexTickShArrList.size();j++){

			split			= (HashMap)IndexTickShArrList.get(j);
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


		//debug += "After IndexTickShArrListSize:"+IndexTickShArrList.size();
		//debug += "delSize:"+deleteArrList.size();
		//debug += "insSize:"+insertArrList.size();

		MultiHashData.put("login_by_id", login_by_id);
		MultiHashData.put("login_at_ws_no",login_at_ws_no);
		MultiHashData.put("login_facility_id",login_facility_id);

		tabData.put("MultiHashData",MultiHashData);
		tabData.put("deleteArrList",deleteArrList);
		tabData.put("insertArrList",insertArrList);
		tabData.put("properties", (Properties)getProperties());



		if(index_type.equals("P"))
			SQL_OR_INDEX_TICK_SHEET_DELETE = OrRepository.getOrKeyValue("SQL_DELETE_TICK_SHEET_PRACT");
		else if(index_type.equals("S"))
			SQL_OR_INDEX_TICK_SHEET_DELETE = OrRepository.getOrKeyValue("SQL_DELETE_TICK_SHEET_SERVICE");
		else if(index_type.equals("C") || index_type.equals("N") )
			SQL_OR_INDEX_TICK_SHEET_DELETE = OrRepository.getOrKeyValue("SQL_DELETE_TICK_SHEET_SOURCE");


		HashMap sqlMap = new HashMap();
		sqlMap.put("SQL_OR_INDEX_TICK_SHEET_DELETE", SQL_OR_INDEX_TICK_SHEET_DELETE );
		sqlMap.put("SQL_OR_INDEX_TICK_SHEET_INSERT", OrRepository.getOrKeyValue("SQL_OR_INDEX_TICK_SHEET_INSERT"));
		sqlMap.put("SQL_OR_INDEX_TICK_SHEET_REC_CNT", OrRepositoryExt.getOrKeyValue("SQL_OR_INDEX_TICK_SHEET_REC_CNT"));

		//ORIndexTickSheetHome home = null ;
		//ORIndexTickSheetRemote remote = null ;

		/***/
			//eOR.ORIndexTickSheetHome home = new eOR.ORIndexTickSheetHome();
			//eOR.ORIndexTickSheetManager remote = new eOR.ORIndexTickSheetManager();
		/***/
		//debug += "going to call ejb";


		/*InitialContext context = new InitialContext() ;
		Object object = context.lookup( OrRepository.getOrKeyValue("INDEX_TICK_SHEET_JNDI") ) ;

		home  = (ORIndexTickSheetHome) PortableRemoteObject.narrow( object, ORIndexTickSheetHome.class ) ;
		remote = home.create() ;*/

		/*commented now*/
		/*map = remote.insert( tabData, sqlMap ) ;*/
		/*commented now*/

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("INDEX_TICK_SHEET_JNDI"), ORIndexTickSheetHome.class, getLocalEJB());
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

		//debug +="after ejb";
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
		map.put( "message", e.getMessage()+debug) ;
		e.printStackTrace() ;
		}finally{
			clear();
		/*try {
			if( remote != null ){
				remote.remove() ;
			}
		}catch( Exception ee ) {
			System.err.println( ee.getMessage() ) ;
			map.put( "message", ee.getMessage() ) ;
			}*/
	}
	return map ;
}

/*********************METHOD TO Update*************************/

public HashMap modify(){
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "modify failure.." );
	return map;

}

/*********************METHOD TO Delete*************************/

	public HashMap delete(){
		HashMap map = new HashMap();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "delete failure.." );
		return map;
	}


	private void doCommon() throws Exception {

	}


	public void loadData() throws Exception {
	}


  /**
	* Used to get Option Item for Order Category
    * @return option Item in a String format.
    */
	public String getComboOptionsOrCat()throws Exception {
		Connection connection = null ;
		try
		{
			connection = getConnection();
			String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_CAT_INDEX_TICK"),connection,"order_category","order_category_desc");
			return str;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			try{
				closeConnection(connection);
			}catch(Exception e){
			 throw e;
		   }
		}
	}

  /**
	* Used to get Option Item for Tick Sheet
    * @return option Item in a String format.
    */
	public String getComboOptionsTickSh() throws Exception{
		Connection connection = null ;
		try{

			connection = getConnection();
			String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_TICK_SH"),connection,"TICK_SHEET_ID ","TICK_SHEET_DESC");
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

  /**
	* Used to get Option Item for Facility ID
    * @return option Item in a String format.
    */
	public String getComboOptionsFacId()  throws Exception{
		Connection connection = null ;
		try{

			connection = getConnection();
			String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_FACILITY_ID"),connection,"FACILITY_ID   ","FACILITY_NAME");
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

 /**
   * Used to get the Order Category values based on the Query
   * in the form of code value pair
   * @return String of Code/Value Pair.
   */
	public String getOrCatString()throws Exception{
	Connection 	connection  = null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	try {
		connection  = getConnection();  

		//pstmt						= connection.prepareStatement(eOR.Common.OrRepository.getOrKeyValue("SQL_OR_TICK_SHEETS_ORD_CAT_SELECT"));
		pstmt						= connection.prepareStatement(eOR.Common.OrRepository.getOrKeyValue("SQL_OR_CAT_INDEX_TICK"));
		rs							= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
		String  codeCol			    = "";
		String  codeDesc			= "";
		while (rs.next()){
				codeCol			    = ChkDef.defaultString(rs.getString(1));
				codeDesc			= ChkDef.defaultString(rs.getString(2));
			   sb.append(codeCol + "," + codeDesc + ",");
			 //   sb.append(codeDesc + "," + codeCol + ",");
		}

		 String str =   sb.toString() ;
		 sb.setLength(0);
		 if(str!=null && str.length()>0)
			return str.substring(0, str.length()-1);
		 else 
			return str;	
 
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


 /**
   * Used to fetch all the existence record in
   * the Database for the given criteria and put the same in a MultiRecordBean.
   * @param exception_type refers the Exception Type Field.
   * @param order_category refers the Group Id Field.
   * @param tick_sheet_id refers the Group Name Field.
   * @param index_type refers the Index Type Field.
   * @param facility_id refers Facility Id Field.
   * @return total number records fetched.
   */
	//IN050655 starts
	//public int fetchDBRecords(String order_category, String tick_sheet_id, String index_type, String facility_id)throws Exception {
	public int fetchDBRecords(String order_category, String tick_sheet_id, String index_type,String source_type, String facility_id)throws Exception {
	//IN050655 ends

		Connection connection			= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String  desc="", SQL_QUERY="", code="";
		//String valid="N";
		java.util.HashMap htMapRecord = null;
		int total_rec = 0;


		try{
			int checkRec = multiRecBean.getSize("DB");

			if(checkRec==0){
				connection = getConnection();
				//multiRecBean.clearDBRec();
				if(index_type.equals("P"))
					SQL_QUERY = OrRepository.getOrKeyValue("SQL_PRACT_DB_REC");
				else if(index_type.equals("S"))
					SQL_QUERY = OrRepository.getOrKeyValue("SQL_SERVICE_DB_REC");
				//IN050655 starts
				//else if(index_type.equals("C"))
				else  if(index_type.equals("F"))
				{
					if(source_type.equals("C"))
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_CLINIC_DB_REC");
					//else if(index_type.equals("N"))
					else if(source_type.equals("N"))
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_NURS_UNT_DB_REC");
				}
				//IN050655 ends
				if(!SQL_QUERY.equals("")){//IN050655
				pstmt = connection.prepareStatement(SQL_QUERY);

				if((index_type.equals("P")) || (index_type.equals("S"))){
					pstmt.setString(1,order_category);
					pstmt.setString(2,tick_sheet_id);
					//}else if((index_type.equals("C")) || (index_type.equals("N"))){//IN050655
					}else if(index_type.equals("F")){//IN050655
					pstmt.setString(1,order_category);
					pstmt.setString(2,tick_sheet_id);
					pstmt.setString(3,facility_id);
				}

				rs = pstmt.executeQuery();

				if(rs != null){

					while(rs.next()){

					code					=	rs.getString("code");
					desc					=	rs.getString("long_desc");

					if(desc == null || desc.equals("null"))desc="";

					htMapRecord		=	new HashMap();

					htMapRecord.put("code"			,	code);
					htMapRecord.put("pract_desc"	,	desc);
					htMapRecord.put("valid"			,	"Y");
					htMapRecord.put("associate_yn"	,   "N");
					htMapRecord.put("status"		,   "N");

					multiRecBean.putObject(htMapRecord);
						}
				}
			}
		}

		total_rec = multiRecBean.getSize("DB");

		return total_rec;
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
}



 /**
   * Used to fetch all the redords for a given Criteria
   * @param index refers the Alphabet selected.
   * @param index_type refers Index Type Field.
   * @param fac_id  refers Facility ID.
   * @param tabValue refers Tab values from where its accessed.
   * @param order_category refers Order Category.
   * @param tick_sheet_id refers Tick Sheet ID.
   * @return MultiRecordBean object.
   */
	//IN050655 starts
	//public Object getRecordSet(String index, String index_type, String fac_id, String tabValue)throws Exception{
	public Object getRecordSet(String index, String index_type,String source_type, String fac_id, String tabValue)throws Exception{
	//IN050655 ends
		Connection connection = null ;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			java.util.HashMap htRecord = null;
			String valid="N", pract_desc="", SQL_QUERY="", code="";//,status="E";
			connection = getConnection();
			multiRecBean.clearSelectRec();
			if(tabValue.equals("S")){
				if(!(index.equals("OTH"))){
					if(index_type.equals("P"))
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_PRACT_NAME");
					else if(index_type.equals("S"))
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_SERVICE_NAME");
					//IN050655
					//else if(index_type.equals("C"))
					else if(index_type.equals("F"))
					{//IN050655
						if(source_type.equals("C"))//IN050655
							SQL_QUERY = OrRepository.getOrKeyValue("SQL_CLINIC_NAME");
						else if(source_type.equals("N"))//IN050655
							SQL_QUERY = OrRepository.getOrKeyValue("SQL_NURS_UNT_NAME");
					}
				}//IN050655
					else{
						if(index_type.equals("P"))
							SQL_QUERY = OrRepository.getOrKeyValue("SQL_OTH_PRACT_NAME");
						else if(index_type.equals("S"))
							SQL_QUERY = OrRepository.getOrKeyValue("SQL_OTH_SERVICE_NAME");
						
						//else if(index_type.equals("C"))//IN050655
						else if(index_type.equals("F"))//IN050655
						{//IN050655
							if(source_type.equals("C"))//IN050655
								SQL_QUERY = OrRepository.getOrKeyValue("SQL_OTH_CLINIC_NAME");
							else if(source_type.equals("N"))//IN050655
								SQL_QUERY = OrRepository.getOrKeyValue("SQL_OTH_NURS_UNT_NAME");
						}//IN050655
					}
				}else if(tabValue.equals("A")){
					valid="Y";
					if(!(index.equals("OTH"))){
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_ASSOCIATE_REC");
					}
					
				}
				if(!SQL_QUERY.equals("")){//IN050655
				pstmt = connection.prepareStatement(SQL_QUERY);
				if(tabValue.equals("S")){
					if(!(index.equals("OTH"))){
						if(index_type.equals("P") || index_type.equals("S")){
							pstmt.setString(1,index+"%");
							//pstmt.setString(2,order_category);
							//pstmt.setString(3,tick_sheet_id);
							//pstmt.setString(4,order_category);
							//pstmt.setString(5,tick_sheet_id);
							//pstmt.setString(6,index+"%");
							//pstmt.setString(7,index_type);
						}
						//IN050655 starts
						//else if(index_type.equals("C") || index_type.equals("N")){
						else if(index_type.equals("F")){
						//IN050655 ends
							pstmt.setString(1,index+"%");
							pstmt.setString(2,fac_id);
							//pstmt.setString(3,order_category);
							//pstmt.setString(4,tick_sheet_id);
							//pstmt.setString(5,fac_id);
							//pstmt.setString(6,index_type);
							//pstmt.setString(7,order_category);
							//pstmt.setString(8,tick_sheet_id);
							//pstmt.setString(9,fac_id);
							//pstmt.setString(10,index+"%");
							//pstmt.setString(11,"F");
						}
					}
					else{
						/*if(index_type.equals("P") || index_type.equals("S")){
							//pstmt.setString(1,order_category);
							//pstmt.setString(2,tick_sheet_id);
							//pstmt.setString(3,order_category);
							//pstmt.setString(4,tick_sheet_id);
							//pstmt.setString(5,index_type);
						}
						else */
						//IN050655 starts	
						//if(index_type.equals("C") || index_type.equals("N"))
						if(index_type.equals("F"))
						//IN050655 ends
						{
							pstmt.setString(1,fac_id);

						}
					}
				}
				else if(tabValue.equals("A")){
					if(!(index.equals("OTH"))){
						if(index_type.equals("P") || index_type.equals("S")){
							pstmt.setString(1,index+"%");
							pstmt.setNull(2,java.sql.Types.NUMERIC);
							pstmt.setNull(3,java.sql.Types.NUMERIC);
							pstmt.setString(4,index+"%");
							pstmt.setNull(5,java.sql.Types.NUMERIC);
							pstmt.setNull(6,java.sql.Types.NUMERIC);
							pstmt.setString(7,index+"%");
							pstmt.setString(8,index+"%");
							pstmt.setString(9,index_type);
						}
						//else if(index_type.equals("C") || index_type.equals("N")){//IN050655
						else if(index_type.equals("F"))//IN050655
						{
							pstmt.setString(1,index+"%");
							pstmt.setString(2,fac_id);
							//pstmt.setString(3,index_type);//IN050655
							pstmt.setString(3,source_type);//IN050655
							pstmt.setString(4,index+"%");
							pstmt.setString(5,fac_id);
							//pstmt.setString(6,index_type);//IN050655
							pstmt.setString(6,source_type);//IN050655
							pstmt.setString(7,index+"%");
							pstmt.setString(8,index+"%");
							pstmt.setString(9,"F");
						}
					}
					
				}
				rs = pstmt.executeQuery();
					if(rs != null){
						while(rs.next()){
							if(tabValue.equals("S")){
								code					=	rs.getString("code");
								pract_desc				=	rs.getString("long_desc");
								valid					=	rs.getString("valid");

							/*	if(valid.equals("Y"))
									status="D";
								else if(valid.equals("N"))
									status="E"; */

								}else if(tabValue.equals("A")){
								if(index_type.equals("P")){
									code					=	rs.getString("practitioner_id");
									pract_desc				=	rs.getString("practitioner_name");
								}
								else if(index_type.equals("S")){
									code					=	rs.getString("service_code");
									pract_desc				=	rs.getString("service_desc");
								}
								//IN050655 starts
								//else if(index_type.equals("C") || index_type.equals("N")){
								else if(index_type.equals("F")){
								//IN050655 ends
									code					=	rs.getString("source_code");
									pract_desc				=	rs.getString("source_desc");
								}
							}
							if(pract_desc == null || pract_desc.equals("null"))pract_desc="";
							htRecord					=	new HashMap();
							htRecord.put("code"			,	code);
							htRecord.put("pract_desc"	,	pract_desc);
							htRecord.put("valid"		,	valid);
							htRecord.put("associate_yn" ,   "N");
							htRecord.put("status"		,	"N");
							multiRecBean.putListObject(htRecord);
						}
					}
				}//IN050655
					return multiRecBean;
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

		}


 /**
   * Used the get the Latest MultiRecordBean Instance
   * @return MultiRecordBean object.
   */
	public Object getBean(){
		return this.multiRecBean;
	}

 /**
   * Used to clear the records from the MultiRecordBean
   * @returns true if cleared else false
   */
	public boolean clearDBRec()throws Exception{
		boolean clearFlag = false;
		clearFlag = multiRecBean.clearDBRec();
		return clearFlag;
	}


  /**
	* Used to get Option Item dynamically for Tick Sheet
    * based on the Order Category
    * @return option Item in a String format.
    */
	public String getComboBoxHtml(Hashtable ht) throws Exception {
		String sql = "" ;
		String optionString = "";
		String comboBoxString = "";
		Connection connection = null;
		try	{

			if( ht == null )
				return "Hashtable Passed to  this method is null";

			connection = getConnection();
			String  type = (String)ht.get("type");
			if(type.trim().equalsIgnoreCase("OrderCategory")){
				sql			  = replace(OrRepository.getOrKeyValue("SQL_OR_CATALOG_TICK_SHEET_NEW") , "?" ,(String)ht.get("order_category"));

				optionString  = Populate.getComboOptions(sql,connection,"TICK_SHEET_ID","TICK_SHEET_DESC");

				comboBoxString="<select name='tick_sheet_id' onChange=''><option>---Select---   </option>" + optionString + "</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>" ;
			}
			else
				throw new Exception("Exception :-in Bean getComboBoxHtml function Hashtable Passed should contain order_category or tick_sheet ID only");

			}
		catch(Exception e){
			throw e;
		}
		finally{
			try
			 {
				closeConnection(connection);
			 }catch(Exception e){e.printStackTrace();

			 }
		}
		return comboBoxString;
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
	//IN050655 starts
 /**
   * Used to fetch all the redords for a given Criteria
   * @param index_type refers Index Type Field.
   * @param source_type  refers the Source Type Field.
   * @param fac_id  refers Facility ID.
   * @param tabValue refers Tab values from where its accessed.
   * @param order_category refers Order Category.
   * @param tick_sheet_id refers Tick Sheet ID.
   * @return MultiRecordBean object.
   */
	public Object getSearchRecordSet(String searchcode, String searchdesc,String index_type, String source_type, String fac_id, String tabValue)throws Exception{
		Connection connection = null ;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			java.util.HashMap htRecord = null;
			String valid="N", pract_desc="", SQL_QUERY="", code="";
			connection = getConnection();
			multiRecBean.clearSelectRec();
			if(tabValue.equals("S")){
				
					if(index_type.equals("P"))
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_SEARCH_PRACT_NAME");
					else if(index_type.equals("S"))
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_SEARCH_SERVICE_NAME");
					else if(index_type.equals("F"))
					{
						if(source_type.equals("C"))
							SQL_QUERY = OrRepository.getOrKeyValue("SQL_SEARCH_CLINIC_NAME");
						else if(source_type.equals("N"))
							SQL_QUERY = OrRepository.getOrKeyValue("SQL_SEARCH_NURS_UNT_NAME");
					}
				
				}
			if(!SQL_QUERY.equals("")){
				pstmt = connection.prepareStatement(SQL_QUERY);
				if(tabValue.equals("S")){
					
						if(index_type.equals("P") || index_type.equals("S")){
							pstmt.setString(1,searchcode);
							pstmt.setString(2,searchdesc);
						}
						else if(index_type.equals("F")){
							pstmt.setString(1,searchcode);
							pstmt.setString(2,searchdesc);
							pstmt.setString(3,fac_id);
						}
					
					
				}
				
				rs = pstmt.executeQuery();
					if(rs != null){
						while(rs.next()){
							if(tabValue.equals("S")){
								code					=	rs.getString("code");
								pract_desc				=	rs.getString("long_desc");
								valid					=	rs.getString("valid");
							}
							if(pract_desc == null || pract_desc.equals("null"))pract_desc="";
							htRecord					=	new HashMap();
							htRecord.put("code"			,	code);
							htRecord.put("pract_desc"	,	pract_desc);
							htRecord.put("valid"		,	valid);
							htRecord.put("associate_yn" ,   "N");
							htRecord.put("status"		,	"N");
							multiRecBean.putListObject(htRecord);
						}
					}
				}
					return multiRecBean;
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

		}
	//IN050655 ends
}//ENd of the class
