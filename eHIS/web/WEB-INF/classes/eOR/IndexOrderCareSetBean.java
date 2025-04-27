/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR ;

import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.rmi.*;
import javax.ejb.*;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;
import eOR.ORIndexOrderCareSet.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import eOR.Common.*;
import eCommon.Common.*;

public class  IndexOrderCareSetBean extends eOR.Common.OrAdapter implements Serializable
{
	protected String care_set_id;
	protected String index_type;
	protected String facility_id;
	protected String source_type;
	protected String source_code;
	protected Hashtable MultiHashData = new Hashtable();
	protected String SelectYNStr;
	protected String diag_code_scheme = "";
	protected String diagnosis_code = "";
	String debug="";
	//eOR.IndexRecBean indexRecSet = new eOR.IndexRecBean();
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();



/*********************Constructor *************************/

 public IndexOrderCareSetBean(){
	care_set_id	= ""    ;
	index_type		= ""    ;
	facility_id		= ""    ;
	source_type		= ""    ;
	source_code		= ""    ;
	SelectYNStr		= ""	;

	try{
		doCommon();
	}catch(Exception e) {e.printStackTrace() ;}
}

/**********************SET METHODS*************************/

  public void  setCare_set_id(String  care_set_id) {this.care_set_id=  care_set_id; } ;
  public void  setIndex_type(String  index_type) {this.index_type=  index_type; } ;
  public void  setFacility_id(String  facility_id) {this.facility_id=  facility_id; } ;
  public void  setSource_type(String  source_type) {this.source_type=  source_type; } ;
  public void  setSource_code(String  source_code) {this.source_code=  source_code; } ;
  public void  setSelectYNStr(String  SelectYNStr) {this.SelectYNStr=  SelectYNStr; } ;

/**********************GET METHODS*************************/

  public String getCare_set_id() { return this.care_set_id ; } ;
  public String getIndex_type() { return this.index_type ; } ;
  public String getFacility_id() { return this.facility_id ; } ;
  public String getSource_type() { return this.source_type ; } ;
  public String getSource_code() { return this.source_code ; } ;
  public String getSelectYNStr() { return this. SelectYNStr ; } ;

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

public void setAll( Hashtable recordSet ) {
try{
	//Hashtable htRecord = new Hashtable();
	String multiRec ="";

	care_set_id	   = (String)recordSet.get("care_set_id");
	index_type     = (String)recordSet.get("index_type");
	facility_id    = (String)recordSet.get("facility_id");
	source_type    = (String)recordSet.get("source_type");
	SelectYNStr    = (String)recordSet.get("SelectYNStr");
	diag_code_scheme  = (String)recordSet.get("diag_code_scheme");
	diagnosis_code    = (String)recordSet.get("diagnosis_code");

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
	}else if(index_type.equals("D")){
		multiRec = index_type;
	}
		MultiHashData.put("care_set_id",care_set_id);
		MultiHashData.put("index_type",index_type);
		MultiHashData.put("facility_id",facility_id);
		MultiHashData.put("source_type",source_type);
		MultiHashData.put("multiRec",multiRec);
		MultiHashData.put("diag_code_scheme",diag_code_scheme);
		MultiHashData.put("diagnosis_code",diagnosis_code);

	 }
	 catch(Exception e){
		 try{
		 throw new Exception("Exception@SetAll: "+e);
		 }catch(Exception ee)
		 {ee.printStackTrace() ;}
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
	care_set_id	= ""    ;
	index_type		= ""    ;
	facility_id		= ""    ;
	source_type		= ""    ;
	source_code		= ""    ;
	SelectYNStr		= ""	;
	super.clear() ;
}


/*********************METHOD TO Insert*************************/

public HashMap insert()
{
	StringBuffer tmpBuff	= new StringBuffer();
	HashMap map = new HashMap() ;
	HashMap tabData = new HashMap() ;
	HashMap split = new HashMap();
	ArrayList deleteArrList = new ArrayList();
	ArrayList insertArrList = new ArrayList();
	//ArrayList updateArrList = new ArrayList();
	ArrayList IndexCareSetArrList = new ArrayList();

	//ORIndexOrderCareSetHome home = null ;
	//ORIndexOrderCareSetRemote remote = null ;

	String valid= "", associate_yn="", index_type="";
	String SQL_OR_INDEX_CARE_SET_DELETE = "";

	index_type = (String)MultiHashData.get("multiRec");

	map.put( "result", new Boolean( false ) ) ;
	map.put( "flag","") ;

	try
	{
		IndexCareSetArrList = multiRecBean.getAllDBRecords();
		for(int j=0;j<IndexCareSetArrList.size();j++)
		{
			split			= (HashMap)IndexCareSetArrList.get(j);
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

		MultiHashData.put("login_by_id", login_by_id);
		MultiHashData.put("login_at_ws_no",login_at_ws_no);
		MultiHashData.put("login_facility_id",login_facility_id);

		tabData.put("MultiHashData",MultiHashData);
		tabData.put("deleteArrList",deleteArrList);
		tabData.put("insertArrList",insertArrList);
		tabData.put("properties", (Properties)getProperties());

		if(index_type.equals("P"))
			SQL_OR_INDEX_CARE_SET_DELETE = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_PRACT_DELETE");
		else if(index_type.equals("S"))
			SQL_OR_INDEX_CARE_SET_DELETE = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_SERVICE_DELETE");
		else if(index_type.equals("D") || index_type.equals("A"))
			SQL_OR_INDEX_CARE_SET_DELETE = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_DIAGNOSIS_DELETE");
		else if(index_type.equals("C") || index_type.equals("N") )
			SQL_OR_INDEX_CARE_SET_DELETE = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_SOURCE_DELETE");


		HashMap sqlMap = new HashMap();
		sqlMap.put("SQL_OR_INDEX_CARE_SET_DELETE", SQL_OR_INDEX_CARE_SET_DELETE );
		sqlMap.put("SQL_OR_INDEX_CARE_SET_INSERT", OrRepository.getOrKeyValue("SQL_OR_INDEX_CARE_SET_INSERT"));

		/*InitialContext context = new InitialContext() ;
		Object object = context.lookup( OrRepository.getOrKeyValue("OR_INDEX_ORDER_CARE_SET_JNDI") ) ;
		home  = (ORIndexOrderCareSetHome) PortableRemoteObject.narrow( object, ORIndexOrderCareSetHome.class ) ;
		remote = home.create() ;

		map = remote.insert( tabData, sqlMap ) ;*/
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_INDEX_ORDER_CARE_SET_JNDI"), ORIndexOrderCareSetHome.class, getLocalEJB());
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
	catch(Exception e)
	{
		System.err.println( "Error Calling EJB : "+e ) ;
		map.put( "message", e.getMessage()+debug) ;
		e.printStackTrace() ;
	}finally
	{
		clear();
		/*try
		{
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
	public String getComboOptionsOrdCategory()throws Exception
	{
		Connection connection = null ;
		try
		{
			connection = getConnection();
			String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_INDEX_CARE_SET_ORD_CATEGORY_OPTIONS"),connection,"order_category","short_desc");
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
	* Used to get Option Item for Care Set
    * @return option Item in a String format.
    */
	public String getComboOptionsCareSet() throws Exception{
		Connection connection = null ;
		try{

			connection = getConnection();
			String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_INDEX_CARE_SET_OPTIONS"),connection,"CARE_SET_ID ","CARE_SET_DESC");
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
	* Used to get Option Item dynamically for Care Set
    * based on the Order Category
    * @return option Item in a String format.
    */
	public String getComboBoxHtml() throws Exception {
		String sql = "" ;
		String optionString = "";
		String comboBoxString = "";
		Connection connection = null;
		try	{

			//if( ht == null )
			//	return "Hashtable Passed to this method is null";

			connection = getConnection();
			//String  type = (String)ht.get("type");
			//if(type.trim().equalsIgnoreCase("OrderCategory"))
			{
				//sql	= replace(OrRepository.getOrKeyValue("SQL_OR_INDEX_CARE_SET_OPTIONS") , "?" ,(String)ht.get("order_category"));
				sql	= OrRepository.getOrKeyValue("SQL_OR_INDEX_CARE_SET_OPTIONS");
				optionString = Populate.getComboOptions(sql, connection, "CARE_SET_ID", "CARE_SET_DESC");
				//comboBoxString = "&nbsp;<select name='care_set_id' onChange=''><option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   ---Select---   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>" + optionString + "</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>" ;
				comboBoxString = optionString;
			}
			//else
			//	throw new Exception("Exception :-in Bean getComboBoxHtml function Hashtable Passed should contain order_category or care_set ID only");
			//}
		}
		catch(Exception e){
			throw e;
		}
		finally{
			try
			 {
				closeConnection(connection);
			 }catch(Exception e){e.printStackTrace() ;

			 }
		}
		return comboBoxString;
	}

  /**
	* Used to get Option Item for Facility ID
    * @return option Item in a String format.
    */
	public String getComboOptionsFacId()
	{
		Connection connection = null ;
		String str = "";
		try{

			connection = getConnection();
			str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_CARE_SET_FACILITY_ID_OPTIONS"),connection,"FACILITY_ID","FACILITY_NAME");
			return str;
		}catch(Exception e){
			System.err.println("Exception in IndexOrderCareSetBean.getComboOptionsFacId - "+e);
			str = "<option> -- error -- </option>";
		}
		finally{
			try{
				closeConnection(connection);
			}catch(Exception e){
				System.err.println("Exception in IndexOrderCareSetBean.getComboOptionsFacId while closing connection - "+e);
			}
		}
		return str;
	}

 /**
   * Used to get the Diag Code to displayed near the Diag Code Label.
   * in the form of code value pair
   * @return String of Code/Value Pair.
   */
	public String[] getDiagCodeString(String care_set_id)	throws Exception
	{
		Connection connection 		= null;
		ResultSet rs1				= null;
		PreparedStatement pstmt1	= null;
		ResultSet rs				= null;
		PreparedStatement pstmt 	= null;
		String str[] = {"","",""};
		try
		{
			connection = getConnection();

			pstmt = connection.prepareStatement(eOR.Common.OrRepository.getOrKeyValue("SQL_OR_CARE_SET_DIAG_CODE"));
			rs = pstmt.executeQuery();

			while (rs.next())
			{
				str[0] = rs.getString("scheme");
				str[1] = rs.getString("scheme_desc");
			}

			pstmt1 = null;
			pstmt1 = connection.prepareStatement(eOR.Common.OrRepository.getOrKeyValue("SQL_OR_CARE_SET_DIAG_CODE_SELECT"));
			pstmt1.setString(1, care_set_id);
			pstmt1.setString(2, str[0]);
			rs1 = pstmt1.executeQuery();

			while (rs1.next())
			{
				str[2] = rs1.getString("diagnosis_code");
			}

		}catch(Exception e)
		{
			throw(e);
		}finally
		{
			try
			{
				closeResultSet(rs1);
				closeStatement(pstmt1);
				closeResultSet(rs);
				closeStatement(pstmt);
				closeConnection(connection);
			}catch(Exception e){e.printStackTrace() ;}
		}
		return str;
	}

 /**
   * Used to fetch all the records existing in
   * the Database for the given criteria and put the same in a MultiRecordBean.
   */
	public int fetchDBRecords( String care_set_id,
								String index_type, String facility_id)
							 throws Exception
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		//String valid="N";
		String desc="", SQL_QUERY="", code="";
		java.util.HashMap htMapRecord = null;
		int total_rec = 0;

		try
		{
			int checkRec = multiRecBean.getSize("DB");

			if(checkRec==0)
			{
				connection = getConnection();
				//multiRecBean.clearDBRec();
				if(index_type.equals("P"))
					SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_PRACT_DB_REC");
				else if(index_type.equals("S"))
					SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_SERVICE_DB_REC");
				else if(index_type.equals("C"))
					SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_CLINIC_DB_REC");
				else if(index_type.equals("N"))
					SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_NURS_UNT_DB_REC");

				pstmt = connection.prepareStatement(SQL_QUERY);

				if((index_type.equals("P")) || (index_type.equals("S")))
				{
					pstmt.setString(1,care_set_id);
				}else if((index_type.equals("C")) || (index_type.equals("N")))
				{
					pstmt.setString(1,care_set_id);
					pstmt.setString(2,facility_id);
				}

				rs = pstmt.executeQuery();

				if(rs != null)
				{
					while(rs.next())
					{
						code = rs.getString("code");
						desc = rs.getString("long_desc");
						if(desc == null || desc.equals("null"))
							desc="";
						htMapRecord = new HashMap();
						htMapRecord.put("code"			,	code);
						htMapRecord.put("pract_desc"	,	desc);
						htMapRecord.put("valid"			,	"Y");
						htMapRecord.put("associate_yn"	,   "N");
						htMapRecord.put("status"		,   "N");

						multiRecBean.putObject(htMapRecord);
					}
				}
			}

			total_rec = multiRecBean.getSize("DB");
			return total_rec;
		}catch(Exception e)
		{
			throw e;
		}
		finally
		{
			try
			{
				closeResultSet(rs);
				closeStatement(pstmt);
				closeConnection(connection);
			}catch(Exception e){throw e;}
		}
	}

 /**
   * Used to fetch all the records for a given Criteria
   */
	public Object getRecordSet(String index, String index_type,
								String fac_id, String tabValue)
								throws Exception
	{
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
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_PRACT_NAME");
					else if(index_type.equals("S"))
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_SERVICE_NAME");
					else if(index_type.equals("C"))
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_CLINIC_NAME");
					else if(index_type.equals("N"))
						SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_NURS_UNT_NAME");
					}
					else
					{
						if(index_type.equals("P"))
							SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_OTH_PRACT_NAME");
						else if(index_type.equals("S"))
							SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_OTH_SERVICE_NAME");
						else if(index_type.equals("C"))
							SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_OTH_CLINIC_NAME");
						else if(index_type.equals("N"))
							SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_CARE_SET_OTH_NURS_UNT_NAME");
					}
				}
				pstmt = connection.prepareStatement(SQL_QUERY);
				if(tabValue.equals("S")){
					if(!(index.equals("OTH"))){
						if(index_type.equals("P") || index_type.equals("S")){
							pstmt.setString(1,index+"%");
						}
						else if(index_type.equals("C") || index_type.equals("N")){
							pstmt.setString(1,index+"%");
							pstmt.setString(2,fac_id);
						}
					}
					else{
						/*if(index_type.equals("P") || index_type.equals("S")){
						}*/
						if(index_type.equals("C") || index_type.equals("N"))
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
						else if(index_type.equals("C") || index_type.equals("N")){
							pstmt.setString(1,index+"%");
							pstmt.setString(2,fac_id);
							pstmt.setString(3,index_type);
							pstmt.setString(4,index+"%");
							pstmt.setString(5,fac_id);
							pstmt.setString(6,index_type);
							pstmt.setString(7,index+"%");
							pstmt.setString(8,index+"%");
							pstmt.setString(9,"F");
						}
					}
					//else{}
				}
				rs = pstmt.executeQuery();
					if(rs != null){
						while(rs.next()){
							if(tabValue.equals("S")){
								code = rs.getString("code");
								pract_desc = rs.getString("long_desc");
								valid = rs.getString("valid");

								/*if(valid.equals("Y"))
									status="D";
								else if(valid.equals("N"))
									status="E";*/

								}else if(tabValue.equals("A")){
								if(index_type.equals("P")){
									code = rs.getString("practitioner_id");
									pract_desc = rs.getString("practitioner_name");
								}
								else if(index_type.equals("S")){
									code = rs.getString("service_code");
									pract_desc = rs.getString("service_desc");
								}
								else if(index_type.equals("C") || index_type.equals("N")){
									code = rs.getString("source_code");
									pract_desc = rs.getString("source_desc");
								}
							}
							if(pract_desc == null || pract_desc.equals("null"))pract_desc="";
							htRecord = new HashMap();
							htRecord.put("code"			,	code);
							htRecord.put("pract_desc"	,	pract_desc);
							htRecord.put("valid"		,	valid);
							htRecord.put("associate_yn" ,   "N");
							htRecord.put("status"		,	"N");
							multiRecBean.putListObject(htRecord);
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

	public ArrayList getDiagScheme() throws Exception 
	{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;

			ArrayList DiagScheme = new ArrayList() ;
			try{
					connection	= getConnection();
 					pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_INDEX_ORDER_SET_DIAG_SCHEME") ) ;
										
					resultSet	= pstmt.executeQuery() ;
					if ( resultSet != null )
					{
						String[] record	= null;
						while(resultSet.next())
						{
							record 	  = new String[2];
							record[0] = resultSet.getString( "code" )  ;
							record[1] = resultSet.getString( "description" )  ;
							DiagScheme.add(record) ;
						}
					}
				}catch ( Exception e )	{
					System.err.println( "Error loading values from database When Populating Order Category" +e) ;
					e.printStackTrace() ;
					throw e ;
				} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
				}
				return DiagScheme;
	}	 

	public String getTermDesc(String term_code) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String term_desc= "";
		try{
				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_INDEX_ORDER_SET_TERM_DESC") ) ;
				pstmt.setString(1,checkForNull(term_code,"")); 
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )
				{
					while(resultSet.next())
					{
						term_desc = checkForNull(resultSet.getString( "description" ), "" );
					}
				}
				return term_desc; // Only one record per
			}catch ( Exception e )	{
					System.err.println( "Error loading values from database When Populating Order Type" +e) ;
					e.printStackTrace() ;
					return null;
			} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
			}
	}	


//******************************************* For EJB ************************************
/*    public HashMap insert( HashMap tabDataParam, HashMap sqlMap ) throws RemoteException
	{
		HashMap map = new HashMap() ;
		StringBuffer messages = new StringBuffer() ;
		StringBuffer traceVal = new StringBuffer() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		PreparedStatement pstmt_del = null ;
		map.put( "result", new Boolean( false ) ) ;
		//map.put( "flag", "insert" ) ;
		boolean insert_flag = false ;
		boolean delete_flag = false ;

		String care_set_id				= "";
		String index_type				= "";
		String facility_id				= "";
		String source_type				= "";
		String multiRec					= "";
		String diag_code_scheme			= "";
		String diagnosis_code			= "";

		String login_by_id				= "";
		String login_at_ws_no			= "";
		String login_facility_id		= "";

		int [] insertCounts ;
		int [] deleteCounts ;
		int insSourceCount = 0;

		String SQL_OR_INDEX_CARE_SET_INSERT = (String) sqlMap.get("SQL_OR_INDEX_CARE_SET_INSERT");
		String SQL_OR_INDEX_CARE_SET_DELETE = (String) sqlMap.get("SQL_OR_INDEX_CARE_SET_DELETE");

		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();

		Hashtable HashHdrData			= new Hashtable();

		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");

		traceVal.append("MultiHashData = "+HashHdrData.toString());
		traceVal.append("InsertRecords = "+insertArrList.toString());
		traceVal.append("DeleteRecords = "+deleteArrList.toString());

		care_set_id				= (String)HashHdrData.get("care_set_id");
		index_type				= (String)HashHdrData.get("index_type");
		facility_id				= (String)HashHdrData.get("facility_id");
		source_type				= (String)HashHdrData.get("source_type");
		multiRec				= (String)HashHdrData.get("multiRec");
		diag_code_scheme		= (String)HashHdrData.get("diag_code_scheme");
		diagnosis_code			= (String)HashHdrData.get("diagnosis_code");

		login_by_id				= (String)HashHdrData.get("login_by_id");
		login_at_ws_no			= (String)HashHdrData.get("login_at_ws_no");
		login_facility_id		= (String)HashHdrData.get("login_facility_id");

		try {
			//connection = getConnection((Properties)tabDataParam.get( "properties" )) ;
			connection = getConnection() ;
		}catch(Exception Exp){
			throw new EJBException( Exp.getMessage() ) ;
		}

		try{
			if(!multiRec.equals("A")){

				if(insertArrList.size() >0)
					insert_flag = false;
				else
					insert_flag = true;

				if(deleteArrList.size() >0)
					delete_flag = false;
				else
					delete_flag = true;
				traceVal.append("index_type = "+index_type);
				traceVal.append("multiRec = "+multiRec);
				if(insertArrList.size() > 0)
				{
					pstmt = connection.prepareStatement(SQL_OR_INDEX_CARE_SET_INSERT);
					HashMap tabData  = new HashMap();
					for(int k=0 ; k < insertArrList.size() ; k++)
					{
						tabData  = (HashMap)insertArrList.get(k);
						int para = 1;
						pstmt.setString(para++ ,care_set_id);
						pstmt.setString(para++ ,index_type);

						if(index_type.equals("F")){
							pstmt.setString(para++ ,facility_id);
							pstmt.setString(para++ ,source_type);
						}else{
							pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
							pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
						}

						if((multiRec.equals("C")) || (multiRec.equals("N")))
							pstmt.setString(para++ ,(String)tabData.get("code"));
						else
							pstmt.setNull(para++ ,java.sql.Types.NUMERIC);

						if(multiRec.equals("P"))
							pstmt.setString(para++ ,(String)tabData.get("code"));
						else
							pstmt.setNull(para++ ,java.sql.Types.NUMERIC);

						pstmt.setNull(para++ ,java.sql.Types.NUMERIC);

						if(multiRec.equals("S"))
							pstmt.setString(para++ ,(String)tabData.get("code"));
						else
							pstmt.setNull(para++ ,java.sql.Types.NUMERIC);

						pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
						pstmt.setNull(para++ ,java.sql.Types.NUMERIC);

						pstmt.setString(para++ ,login_by_id);
						pstmt.setString(para++ ,login_at_ws_no);
						pstmt.setString(para++ ,login_facility_id);
						pstmt.setString(para++ ,login_by_id);
						pstmt.setString(para++ ,login_at_ws_no);
						pstmt.setString(para++ ,login_facility_id);

						pstmt.addBatch();
					}

					insertCounts = pstmt.executeBatch();
					traceVal.append("insertCount's Count:*** "+insertCounts.length );

					for (int i=0;i<insertCounts.length ;i++ ){
						if(insertCounts[i]<0  && insertCounts[i] != -2 ){
							insert_flag=false;
							break;
						}
						else{
						insert_flag=true;
						}
					}
				}else if (index_type.equals("D"))
				{
					//traceVal.append("start -- "+care_set_id+index_type+diag_code_scheme+diagnosis_code);
					pstmt = connection.prepareStatement(SQL_OR_INDEX_CARE_SET_INSERT);
					int para = 1;
					pstmt.setString(para++ ,care_set_id);
					pstmt.setString(para++ ,index_type);
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,"");
					pstmt.setString(para++ ,diag_code_scheme);
					pstmt.setString(para++ ,diagnosis_code);
					pstmt.setString(para++ ,login_by_id);
					pstmt.setString(para++ ,login_at_ws_no);
					pstmt.setString(para++ ,login_facility_id);
					pstmt.setString(para++ ,login_by_id);
					pstmt.setString(para++ ,login_at_ws_no);
					pstmt.setString(para++ ,login_facility_id);
					//traceVal.append("end");

					int diag_result = pstmt.executeUpdate();
					if(diag_result == 1)	insert_flag = true;
					//traceVal.append(diag_result+" -- commit -- "+insert_flag);
				}

				if(insert_flag && deleteArrList.size() >0 )
				{
					pstmt_del	= connection.prepareStatement(SQL_OR_INDEX_CARE_SET_DELETE);
					HashMap delMapData  = new HashMap();

					for(int k=0 ; k < deleteArrList.size() ; k++){
					delMapData  = (HashMap)deleteArrList.get(k);

					pstmt_del.setString(1 ,care_set_id);
					if(multiRec.equals("P") || multiRec.equals("S")){
						pstmt_del.setString(2 ,(String)delMapData.get("code"));
					}else if(multiRec.equals("N") || multiRec.equals("C")){
						pstmt_del.setString(2 ,facility_id);
						pstmt_del.setString(3 ,multiRec);
						pstmt_del.setString(4 ,(String)delMapData.get("code"));
					}else if(multiRec.equals("D")){
						pstmt_del.setString(2 ,diag_code_scheme);
						pstmt_del.setString(3 ,diagnosis_code);
					}
					pstmt_del.addBatch();
				}

				deleteCounts = pstmt_del.executeBatch();

				for (int i=0;i<deleteCounts.length ;i++ ){
					if(deleteCounts[i]<0  && deleteCounts[i] != -2 ){
						delete_flag=false;
						break;
					}
					else{
						delete_flag=true;
					}
				}
			}

			//traceVal.append("delete_flag:*** "+delete_flag);

		}else if(multiRec.equals("A")){
			pstmt = connection.prepareStatement(SQL_OR_INDEX_CARE_SET_INSERT);
			int para = 1;
			pstmt.setString(para++ ,care_set_id);
			pstmt.setString(para++ ,index_type);
			pstmt.setString(para++ ,facility_id);
			pstmt.setString(para++ ,"A");
			pstmt.setString(para++ ,"*ALL");
			pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
			pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
			pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
			pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
			pstmt.setNull(para++ ,java.sql.Types.NUMERIC);
			pstmt.setString(para++ ,login_by_id);
			pstmt.setString(para++ ,login_at_ws_no);
			pstmt.setString(para++ ,login_facility_id);
			pstmt.setString(para++ ,login_by_id);
			pstmt.setString(para++ ,login_at_ws_no);
			pstmt.setString(para++ ,login_facility_id);

			insSourceCount = pstmt.executeUpdate();

			if(insSourceCount > 0){
				insert_flag = true;
				delete_flag = true;
			}
		}

		if(insert_flag && delete_flag)
		{
			//traceVal.append("abt to commit");
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
		}
		else{
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			throw new EJBException("Insert/Update Failed");
		}

	}
	catch(Exception e)
	{
		//traceVal.append(e.getMessage());
		String errormsg = e.toString();
		if(errormsg.indexOf("unique") >= 1)
			messages.append("CODE_ALREADY_EXISTS");
	}
	finally{
	   try {
		    closeStatement( pstmt ) ;
			closeStatement( pstmt_del ) ;
			//closeConnection( connection, (Properties)tabDataParam.get( "properties" ) );
			closeConnection( connection);
		}catch ( Exception fe ) {
			System.err.println( fe.getMessage() ) ;
			traceVal.append(fe.getMessage());
			//map.put( "traceVal", traceVal.toString() ) ;
		}
	}

	map.put( "msgid", messages.toString()) ;
	map.put( "traceVal", traceVal.toString() ) ;

	return map ;
	} */
//******************************************* For EJB ************************************

}//END of the class
