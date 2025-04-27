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

import eOR.Common.*;
import eCommon.Common.*;

public class  SpecialityForOrderable extends eOR.Common.OrAdapter implements Serializable
{
	protected String order_catalog_code;
	protected String specialilty_code;
	public String debug="";
	protected Hashtable MultiHashData = new Hashtable();
	protected Hashtable hashtable=null;

	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

/*********************Constructor *************************/

 public SpecialityForOrderable(){
	order_catalog_code	= ""    ;
	specialilty_code	= ""    ;

	try{
		doCommon();
	}catch(Exception e) {e.printStackTrace() ;}
 }	

/**********************SET METHODS*************************/

  public void  setOrder_catalog_code(String  order_catalog_code) {this.order_catalog_code=  order_catalog_code; } ;
  public void  setSpeciality_code(String  specialilty_code) {this.specialilty_code=specialilty_code; } ;
  public void  setDebug(String  debug) {this.debug=  debug; } ;

/**********************GET METHODS*************************/

  public String getOrder_catalog_code() { return this.order_catalog_code ; } ;
  public String getSpeciality_code() { return this.specialilty_code ; } ;
  public String getDebug() { return this.debug ; } ;


/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/

 public void setAll( Hashtable recordSet ) {
	 try
	 {
		 hashtable=recordSet;
		if(recordSet.containsKey("order_catalog_code"))
		{ 		setOrder_catalog_code(((String)hashtable.get("order_catalog_code"))==null?"":(String)hashtable.get("order_catalog_code"));
		}
		if(recordSet.containsKey("splty_code"))
		{
		 setSpeciality_code(((String)hashtable.get("splty_code"))==null?"":(String)hashtable.get("splty_code"));
		}
		//if(recordSet.containsKey("mode"))
		//{
		 setMode("1");
		//}
	}
	catch(Exception e){
	try{
		throw new Exception("Excweption@SetAll: "+e);
		}catch(Exception ee){ee.printStackTrace() ;
		}
	 }
 }//end

/********************Validate Method ****************************/ 
  public HashMap validate() throws Exception {
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." ) ;
	return map ;
 }//end of validate


 public HashMap insert(){
	 System.out.println("in insert");
	StringBuffer tmpBuff	= new StringBuffer();
	HashMap map = new HashMap() ;
	HashMap tabData = new HashMap() ;
	HashMap split = new HashMap();
	ArrayList deleteArrList = new ArrayList();
	ArrayList insertArrList = new ArrayList();
	ArrayList updateArrList = new ArrayList();
	ArrayList allRecords = new ArrayList();
	String valid= "", associate_yn="";

	map.put( "result", new Boolean( false ) ) ;
	map.put( "flag","") ;
	
	try {
		allRecords = multiRecBean.getAllDBRecords();
		if(allRecords.size()>0){
		for(int j=0;j<allRecords.size();j++){
			split			= (HashMap)allRecords.get(j);
			valid			= (String) split.get("valid");
			associate_yn	= (String) split.get("associate_yn");
			System.out.println("split"+split);
			System.out.println("valid"+valid);
			System.out.println("associate_yn"+associate_yn);
			   
				if(valid.equals("Y")){
				if(associate_yn.equals("D")){
					deleteArrList.add(split);
				}
				 if(associate_yn.equals("Y")){
					 updateArrList.add(split);
					}
			   }else if(valid.equals("N")){
				if(associate_yn.equals("Y")){
					insertArrList.add(split);
				}
			}
			}
	}else{
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message","CLICK_ONE_ORDERABLE");
		return map;	
		}
		
		MultiHashData.put("order_catalog_code", getOrder_catalog_code());
		MultiHashData.put("speciality_code", getSpeciality_code());
		MultiHashData.put("login_by_id", login_by_id);
		MultiHashData.put("login_at_ws_no",login_at_ws_no);
		MultiHashData.put("login_facility_id",login_facility_id);
		tabData.put("MultiHashData",MultiHashData);
		tabData.put("deleteArrList",deleteArrList);
		tabData.put("insertArrList",insertArrList);
		tabData.put("updateArrList",updateArrList);
		tabData.put("properties", (Properties)getProperties());
       
		HashMap sqlMap = new HashMap();
	
		sqlMap.put("SQL_OR_SPLTY_FOR_ORDERABLE_DELETE", OrRepositoryExt.getOrKeyValue("SQL_OR_SPLTY_FOR_ORDERABLE_DELETE") );
		sqlMap.put("SQL_OR_SPLTY_FOR_ORDERABLE_INSERT", OrRepositoryExt.getOrKeyValue("SQL_OR_SPLTY_FOR_ORDERABLE_INSERT") );
		map=OrderablesForSpeciality(tabData,sqlMap);
		
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}
				else
				{
					String ErrorMessage= (String)map.get("message");
					if(ErrorMessage.equals("ERROR_INSERTING"))
					{
						map.put("message",getMessage(language_id,(String)map.get("message"),"SM"));
					}
					else
					{
						map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
					}
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
		
	}
	return map ;
 }//end of insert

/*********************METHOD TO Reset the Class variable*************************/

 public void clear() {
	order_catalog_code = ""    ;
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

 /*********Method to fetch the Data Base Values*************/
 public int fetchDBRecords(String order_catalog_code,String splty_code,String group_by)throws Exception {
	Connection connection = null ;
	PreparedStatement pstmt=null;
	HashMap htMapRecord = null;
	ResultSet rs=null;
	int total_rec =0;
	String SQL_QUERY="", code="", desc="" ,spec_code="";
	try{
		int checkRec = multiRecBean.getSize("DB");
		if(checkRec==0){
			connection = getConnection();
			if(group_by.equals("S"))
			{
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_SPLTY_FOR_ORDERABLE_SPLTY_DB_REC");
				pstmt = connection.prepareStatement(SQL_QUERY);
				pstmt.setString(1,splty_code);
			}
			else if(group_by.equals("O"))
			{
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_SPLTY_FOR_ORDERABLE_CATALOG_DB_REC");
				pstmt = connection.prepareStatement(SQL_QUERY);
				pstmt.setString(1,order_catalog_code);
			}
		
			rs = pstmt.executeQuery();
			if(rs != null){
				while(rs.next()){
				code					=	rs.getString("code");
				desc					=	rs.getString("description");
				if(group_by.equals("S"))
				{
					spec_code=rs.getString("spec_code");
				}

				if(desc == null || desc.equals("null"))desc="";
				if(spec_code == null || spec_code.equals("null"))spec_code="";
				htMapRecord		=	new HashMap();
				htMapRecord.put("code"			,	code);
				htMapRecord.put("desc"	,	desc);
				htMapRecord.put("spec_code"	,	spec_code);
				htMapRecord.put("valid"			,	"Y");
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
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return total_rec;
 }//end of fetchRecords  */


 /*********************Method to fetch Alphabetical Records ***********************/
// public Object getRecordSet(String index, String service_code)throws Exception{
 public Object getRecordSet(String index,String group_by)throws Exception{
	Connection connection = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		java.util.HashMap htRecord = null;
		String  desc="", SQL_QUERY="", code="",spec_code="";//,status="E";
		//valid="N",
		//String default_yn="";
		connection = getConnection();
		multiRecBean.clearSelectRec();
		if(group_by.equals("S"))
		{
			if(!(index.equals("OTH")))
			{
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_SPLTY_FOR_ORDERABLE_CATALOG_DESC");
			}
			else
			{
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_SPLTY_FOR_ORDERABLE_CATALOG_DESC_OTH");
			}
		}
		else if(group_by.equals("O"))
		{
			if(!(index.equals("OTH")))
			{
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_SPLTY_FOR_ORDERABLE_SPLTY_DESC");
			}
			else
			{
				SQL_QUERY = OrRepositoryExt.getOrKeyValue("SQL_OR_SPLTY_FOR_ORDERABLE_SPLTY_DESC_OTH");
			}

		}

		pstmt = connection.prepareStatement(SQL_QUERY);
		if(!(index.equals("OTH"))){
			pstmt.setString(1,index+"%");
		}
		rs = pstmt.executeQuery();
		if(rs != null){
			while(rs.next()){
				code				=	rs.getString("code");
				desc		=	rs.getString("description");
				if(group_by.equals("S"))
				{
					spec_code	=	rs.getString("spec_code");
				}
			//	default_yn						=	 rs.getString("DEFAULT_YN");
				if(desc == null || desc.equals("null"))desc="";
				if(spec_code == null || spec_code.equals("null"))spec_code="";
                htRecord					=	new HashMap();
				htRecord.put("code"			,	code);
				htRecord.put("desc"	,	desc);
				htRecord.put("spec_code"	,	spec_code);
				htRecord.put("default_yn"	,	"N");
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
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return multiRecBean;
 }//end of getRecordSet

 public HashMap OrderablesForSpeciality(HashMap tabDataParam, HashMap sqlMap) throws Exception 
{
	System.out.println("tabDataParam"+tabDataParam);
	StringBuffer traceVal = new StringBuffer() ;
    Connection connection = null ;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt_del = null ;
	PreparedStatement pstmt_update = null ;
	 StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
        boolean insert_flag = false ;
		boolean delete_flag = false ;
		boolean update_flag = false ;
        String order_catalog_code	= "";
        String speciality_code	= "";
        String login_by_id			    = "";
		String login_at_ws_no			= "";
		String login_facility_id			= "";
		int [] insertCounts ;
		int [] deleteCounts ;
		
        String SQL_OR_SPLTY_FOR_ORDERABLE_DELETE = (String) sqlMap.get("SQL_OR_SPLTY_FOR_ORDERABLE_DELETE");
		String SQL_OR_SPLTY_FOR_ORDERABLE_INSERT= (String) sqlMap.get("SQL_OR_SPLTY_FOR_ORDERABLE_INSERT");
		ArrayList deleteArrList	= new ArrayList();
		ArrayList insertArrList = new ArrayList();
		ArrayList updateArrList = new ArrayList();
        Hashtable HashHdrData			= new Hashtable();
		insertArrList			= (ArrayList)tabDataParam.get("insertArrList");
		deleteArrList			= (ArrayList)tabDataParam.get("deleteArrList");
		updateArrList			= (ArrayList)tabDataParam.get("updateArrList");
		HashHdrData				= (Hashtable)tabDataParam.get("MultiHashData");
		order_catalog_code			= (String)HashHdrData.get("order_catalog_code");
		speciality_code			= (String)HashHdrData.get("speciality_code");
        login_by_id				= (String)HashHdrData.get("login_by_id");
		login_at_ws_no			= (String)HashHdrData.get("login_at_ws_no");
		login_facility_id		= (String)HashHdrData.get("login_facility_id");

		try {
			connection = getConnection() ;
		}catch(Exception Exp){
			System.err.println( "Error in getting the query : "+Exp ) ;
			map.put( "message", Exp.getMessage() ) ;
		}

		try{
			 if(insertArrList.size() >0)
				insert_flag = false;
			else
				insert_flag = true;

			if(deleteArrList.size() >0)
				delete_flag = false;
			else
				delete_flag = true;
			if(updateArrList.size() >0)
				update_flag = false;
			else
				update_flag = true;
              			 
				pstmt					= connection.prepareStatement(SQL_OR_SPLTY_FOR_ORDERABLE_INSERT);
				HashMap tabData  = new HashMap();

				    for(int k=0 ; k < insertArrList.size() ; k++){
					
					tabData  = (HashMap)insertArrList.get(k);
					if(!order_catalog_code.equals(""))
				  {
						
					pstmt.setString(1 ,(String)tabData.get("code"));
					pstmt.setString(2 ,order_catalog_code);
				  }
				  else if(!speciality_code.equals(""))
				{
					pstmt.setString(1 ,speciality_code);
					pstmt.setString(2 ,(String)tabData.get("code"));
				}
					pstmt.setString(3,login_by_id);
					pstmt.setString(4 ,login_at_ws_no);
					pstmt.setString(5 ,login_facility_id);
					pstmt.setString(6 ,login_by_id);
					pstmt.setString(7 ,login_at_ws_no);
					pstmt.setString(8 ,login_facility_id);
                    pstmt.addBatch();
				}
                insertCounts = pstmt.executeBatch();
				
			
				for (int i=0;i<insertCounts.length ;i++ ){
					if(insertCounts[i]<0  && insertCounts[i] != -2 ){
						insert_flag=false;
						break;
					}
					else{
					insert_flag=true;
					}
				}
			
			if(insert_flag && deleteArrList.size() >0 ){
				
                pstmt_del	= connection.prepareStatement(SQL_OR_SPLTY_FOR_ORDERABLE_DELETE);
                HashMap delMapData  = new HashMap();
               for(int k=0 ; k < deleteArrList.size() ; k++){
				   
				delMapData  = (HashMap)deleteArrList.get(k);
               if(!order_catalog_code.equals(""))
				  {
				   
					pstmt_del.setString(1 ,(String)delMapData.get("code"));
					pstmt_del.setString(2 ,order_catalog_code);
				  }
				  else if(!speciality_code.equals(""))
				{
					pstmt_del.setString(1 ,speciality_code);
					pstmt_del.setString(2 ,(String)delMapData.get("code"));
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
               
    if(insert_flag && delete_flag)
	{
		connection.commit();
		map.put( "result", new Boolean( true ) ) ;
		messages.append( "RECORD_INSERTED" ) ;
	}
	else if(updateArrList.size()>0)
	{
		connection.commit();
		map.put( "result", new Boolean( true ) ) ;
		messages.append( "RECORD_INSERTED" ) ;
	}
	else{
			connection.rollback();
			map.put( "result", new Boolean( false ) ) ;
			messages.append("ERROR_INSERTING");
		}

	}
	catch(Exception e){
	traceVal.append(e.getMessage());
	map.put( "traceVal", traceVal.toString() ) ;
	}
	finally{
	   try {
		    closeStatement( pstmt ) ;
			closeStatement( pstmt_del ) ;
			closeStatement( pstmt_update ) ;
			closeConnection(connection);
		}catch ( Exception fe ) {
			System.err.println( fe.getMessage() ) ;
			fe.printStackTrace() ;
			traceVal.append(fe.getMessage());
			map.put( "traceVal", traceVal.toString() ) ;
		}
	}
	map.put( "message", messages.toString() ) ;
	map.put( "traceVal", traceVal.toString() ) ;
	return map ;
}


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

 public String getSpecialityCode(String order_catalog_code) 
	{
	
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet rs			= null;
		String spec_code="";

		try 
		{
				connection = getConnection() ;
				pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_SPLTY_FOR_ORDERABLE_SPLTY") ) ;
				pstmt.setString(1, order_catalog_code);
				rs = pstmt.executeQuery() ;
				while (rs.next())
				{			
					spec_code=rs.getString("spec_code");
				}

		}
		catch( Exception e )
		{
			e.printStackTrace() ;
		}
		finally
		{
			try
			{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception ee) 
			{
					ee.printStackTrace() ;
			}
		}
		return spec_code;
	}


}	//end of class
