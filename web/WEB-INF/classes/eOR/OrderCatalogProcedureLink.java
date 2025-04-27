/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.util.*;
import java.io.*;
import java.sql.*;
import javax.ejb.*;
import javax.rmi.*;
import javax.naming.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;

public class OrderCatalogProcedureLink extends OrAdapter implements Serializable
{

//	protected String order_catalog_code="";
//	protected String term_set_code="";
//	protected String term_set="";
	protected String proc_or_group="";
//	protected String default_yn="";
	protected Hashtable hashtable=null;




	public void setProcOrGroup(String proc_or_group){
		this.proc_or_group=proc_or_group;
	}
	

	public String getProc_or_group(){
		return proc_or_group;
	}


	public void setAll(Hashtable recordSetMultiple){
		hashtable=recordSetMultiple;
		setMode((String)recordSetMultiple.get("mode"));
		if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
		for(int i=0;i<10;i++)
		{
		if(hashtable.containsKey("default_yn"+i))
		{
			if(((String)hashtable.get("default_yn"+i)).equals("") || ((String)hashtable.get("default_yn"+i)).equals("N"))
				hashtable.put("default_yn"+i,"N");
			else
				hashtable.put("default_yn"+i,"Y");
		
		}
		}
	}else
		{

		if(((String)hashtable.get("default_yn")).equals("") || ((String)hashtable.get("default_yn")).equals("N"))
				hashtable.put("default_yn","N");
			else
				hashtable.put("default_yn","Y");	
	}
//		System.out.println("########in setall,hashtable="+hashtable);

		

	}

	public HashMap validate() throws Exception{
//		System.out.println("###in validate()");
		HashMap hashmap=new HashMap();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int temp=0;
		

		hashmap.put("result",new Boolean(true));
//		System.out.println("@@@@@@@@@@@@@@@@");
		if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
//					System.out.println("$$$$$$$$$$$$$$$$$$");

		proc_or_group=ProcOrGroupValue((String)hashtable.get("order_catalog_code"));
		setProcOrGroup(proc_or_group);
		for(int j=0;j<10;j++){
//			System.out.println("%%%%%%%%%%%%%%");	
			if((hashtable.get("default_yn"+j)==null?"N":(String)hashtable.get("default_yn"+j)).equals("Y"))
			temp++;	
			}
		}else{			if((hashtable.get("default_yn")==null?"N":(String)hashtable.get("default_yn")).equals("Y"))
			temp++;		
		}

		try{	

			    con=getConnection();
				pstmt=con.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_DEFAULT_YN_CHECK"));
				//System.out.println("####order_catalog_code="+order_catalog_code);
				pstmt.setString(1,(String)hashtable.get("order_catalog_code"));
				rs=pstmt.executeQuery();
					int i=0;
				if(rs!=null && rs.next()){
					i=rs.getInt("record_count");
//					System.out.println("##in validate(),i="+i+", temp="+temp);
					if(i>0){
						if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
					if(temp>0){
//						System.out.println("###more than default");
					hashmap.put("result",new Boolean(false));
					hashmap.put("message","ATLEAST_ONE_DEFAULT");
					}else{
//						System.out.println("###aaaaaaaaaaaaaaaaaa");
					hashmap.put("result",new Boolean(true));
					hashmap.put("message","sucess");					
					}
					}else if(getMode().equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){

						//modify mode validations
					if(temp>0){
						String db_term_set_code=getDBTermSetCode((String)hashtable.get("order_catalog_code"));
						
						if(db_term_set_code.equals((String)hashtable.get("term_set_code")))
						{
//							System.out.println("###a555555555555555");
							hashmap.put("result",new Boolean(true));
							hashmap.put("message","sucess");
						}else{
//							System.out.println("###88888888888888");
								hashmap.put("result",new Boolean(false));
								hashmap.put("message","ATLEAST_ONE_DEFAULT");		
						}
					}else{
//							System.out.println("##########delete mode2222222");
							hashmap.put("result",new Boolean(true));
							hashmap.put("message","sucess");				
					
					}
					
					}else{
//						System.out.println("##########delete mode");
							hashmap.put("result",new Boolean(true));
							hashmap.put("message","sucess");
					
					}
					}
					else{
						if(temp>1)
						{
//							System.out.println("###bbbbbbbbbbbbbbbbbbb");

							hashmap.put("result",new Boolean(false));
							hashmap.put("message","ATLEAST_ONE_DEFAULT");						
						}else
						{	//System.out.println("###ccccccccccccccc");

							hashmap.put("result",new Boolean(true));
							hashmap.put("message","sucess");		
						}					
					}
				}

			}catch (Exception e){
				System.err.println("exception in OrderCatalogProcedureLink.java"+e);
				hashmap.put("result",new Boolean(false));
				hashmap.put("message",e);
				throw e;
			}finally{
					try{
						closeResultSet(rs);
						closeStatement(pstmt);
						closeConnection(con);
					}catch(Exception e1){
						System.err.println("exception in OrderCatalogProcedureLink.java"+e1);
						e1.printStackTrace();
					}
			}
		
		//}
//		System.out.println("####hashmap="+hashmap);
		return hashmap;
	}
	
	public HashMap insert(){
//		System.out.println("####in insert()");
		HashMap hashmap=new HashMap();
		hashmap.put("result",new Boolean(true));
		hashmap.put("flag","true");

		ArrayList recordStore=new ArrayList();
		ArrayList whereData=new ArrayList();
		ArrayList tabData=null;
		ArrayList tabData1=null;
		String ID="";
		HashMap sqlMap=new HashMap();
		HashMap tabDataParam=new HashMap();

		try{
		sqlMap.put("InsertSQL",(String)OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_INSERT"));
		sqlMap.put("SelectSQL",(String)OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_DUPLICATE_CHK"));
		}
		catch(Exception e){
			System.err.println("exception in insert of OrderCatalogProcedureLink.java="+e);
			e.printStackTrace();
		}
		
		for(int i=0;i<10;i++){
			ID = "term_set_code"  + i ;
			tabData = new ArrayList() ;
			tabData1 = new ArrayList() ;

			if(!(((String)hashtable.get(ID)).equals("")||(String)hashtable.get(ID)==null))
			{
//			System.out.println("##########@@@@@@@@@@@@#######i="+i);
			tabData.add(((hashtable.get("order_catalog_code")==null || hashtable.get("order_catalog_code").equals(""))?"":(String)hashtable.get("order_catalog_code")).trim());
			tabData.add(((hashtable.get("term_set"+i)==null || hashtable.get("term_set"+i).equals(""))?"":(String)hashtable.get("term_set"+i)).trim());
			tabData.add(((hashtable.get("term_set_code"+i)==null ||hashtable.get("term_set_code"+i).equals(""))?"":(String)hashtable.get("term_set_code"+i)).trim());
			tabData.add(proc_or_group.trim());
			tabData.add(((hashtable.get("default_yn"+i)==null || hashtable.get("default_yn"+i).equals(""))?"N":(String)hashtable.get("default_yn"+i)).trim());
			tabData.add(((String)login_by_id).trim());
			tabData.add(((String)login_at_ws_no).trim());
			tabData.add(((String)login_facility_id).trim());
			tabData.add(((String)login_by_id).trim());
			tabData.add(((String)login_at_ws_no).trim());
			tabData.add(((String)login_facility_id).trim());
			recordStore.add((ArrayList)tabData);
			tabData1.add(((hashtable.get("order_catalog_code")==null || hashtable.get("order_catalog_code").equals(""))?"":(String)hashtable.get("order_catalog_code")).trim());
			tabData1.add(((hashtable.get("term_set"+i)==null || hashtable.get("term_set"+i).equals(""))?"":(String)hashtable.get("term_set"+i)).trim());
			tabData1.add(((hashtable.get("term_set_code"+i)==null || hashtable.get("term_set_code"+i).equals(""))?"":(String)hashtable.get("term_set_code"+i)).trim());

			whereData.add((ArrayList)tabData1);
//			System.out.println("#####recordStore("+i+")="+recordStore);
//			System.out.println("#####whereData("+i+")="+whereData);
			}
		}

		tabDataParam.put("InsertData",recordStore);
		tabDataParam.put("WhereData",whereData);
		tabDataParam.put("properties",getProperties());
		
//		System.out.println("###in insert mode, tabDataParam="+tabDataParam);
//		System.out.println("###in insert mode, sqlMap="+sqlMap);
		return getResult(tabDataParam,sqlMap);

	}
/*****************modify method*********************************/
public HashMap modify() 
	{
//System.out.println("###in modify of bean,hashtable="+hashtable);
		HashMap dataMap = new HashMap() ;
		ArrayList tabdata = new ArrayList() ;

		tabdata.add( ((String)hashtable.get("default_yn")) ) ;
		tabdata.add( ((String)hashtable.get("order_catalog_code")).trim() ) ;
		tabdata.add( ((String)hashtable.get("term_set")).trim() ) ;		
		tabdata.add( ((String)hashtable.get("term_set_code")).trim() ) ;		
				
		HashMap sqlMap = new HashMap() ;
		try
		{
			sqlMap.put( "ModifySQL",OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_UPDATE") );
		}catch(Exception e){e.printStackTrace();}
		
		dataMap.put("properties", getProperties() );
		dataMap.put("ModifyData",tabdata);

		return getResult(dataMap,sqlMap) ;

	 }// end of modify method
/*****************delete method*********************************/
public HashMap delete(){
	try{
	HashMap sqlMap=new HashMap();
	ArrayList deldata=new ArrayList();
	HashMap tabData=new HashMap();
//	String order_catalog_code=((String)hashtable.get("order_catalog_code")).trim();
//	String proc_code=((String)hashtable.get("term_set_code")).trim();
	//System.out.println("####in delete,order_catalog_code="+order_catalog_code);
	//System.out.println("####in delete,proc_code="+proc_code);
	deldata.add(((String)hashtable.get("order_catalog_code")).trim());
	deldata.add(((String)hashtable.get("term_set")).trim());
	deldata.add(((String)hashtable.get("term_set_code")).trim());

	sqlMap.put("DeleteSQL",(String)OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_DELETE"));
	tabData.put("properties",getProperties());
	tabData.put("DeleteData",deldata);
	//System.out.println("##in delete,tabData="+tabData);
	//System.out.println("##in delete,sqlMap="+sqlMap);
	return getResult(tabData,sqlMap);

	}catch(Exception e){
	System.err.println("exception in delete method of OrderCatalogProcedureLink.java="+e);
	e.printStackTrace();
	return null;
	}
}
/*****************getResult method*********************************/

private  HashMap getResult(HashMap tabData , HashMap sqlMap )
{

	//System.out.println("####in get result###");
	String traceVal = "";
	HashMap map  = new HashMap() ;
	//SingleTableHandlerHome home = null;
	//SingleTableHandlerRemote remote = null;
    map.put( "result", new Boolean( false ) ) ;
    map.put( "flag", "true" ) ;

	try
	{
		/********************LOOK UP*************************/
		/*InitialContext context = new InitialContext() ;
		Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER")) ;
		home=(SingleTableHandlerHome)PortableRemoteObject.narrow( object, SingleTableHandlerHome.class) ;
		remote		 = home.create() ;*/

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
    	Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 		Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();


		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) 
		{//System.out.println("####in getresult, delete()");
			map = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);		

		}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) 
		{
			//System.out.println("####in getresult, insert()");
			//map = remote.singleBatchHandler(tabData,sqlMap);
			map = (java.util.HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);		

		}else if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) )
		{
			//map = remote.modify(tabData, sqlMap ) ;
			map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);	
		}


			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				argArray	= null;
				paramArray	= null;

		//System.out.println("#####map21="+map);
		String message = (String)map.get("msgid");
		boolean result = ((Boolean) map.get("result")).booleanValue() ;
		//System.out.println("#####3result="+result);
        if( result ) 
		{
			//System.out.println("#######if result=true");
			map.put( "result", new Boolean( true ) ) ;
			map.put( "message", getMessage(language_id,(String) map.get("msgid"),"SM") ) ;
		}
        else
		{
			//System.out.println("##########if result=false");
			map.put( "result", new Boolean( false ) ) ;
            if( message.equals( "CODE_ALREADY_EXISTS" ) )
			{
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common") ) ;
				String invalidCode_1=delimitedString( (ArrayList)map.get("invalidCode"));
				String temp="";
				String invalidCode="";

				StringTokenizer invalidCode_2=new StringTokenizer(invalidCode_1,",");
				while (invalidCode_2.hasMoreTokens())
				{
					
					temp=invalidCode_2.nextToken();
					//System.out.println("#########33temp="+temp);
					StringTokenizer invalidCode_3=new StringTokenizer(temp,":");
					while(invalidCode_3.hasMoreTokens())
					{
						invalidCode_3.nextToken();
						//System.out.println("invalidCode="+invalidCode);
						invalidCode_3.nextToken();
						//invalidCode+=invalidCode_3.nextToken();
						invalidCode=invalidCode+invalidCode_3.nextToken();
						//invalidCode+=",";
						invalidCode=invalidCode+",";
					//System.out.println("invalidCode="+invalidCode);
					}
				}
				/*String temp_1="";
				while (invalidCode_2.hasMoreTokens())
				{
					
					temp=invalidCode_2.nextToken();
					System.out.println("#########33temp="+temp);
					StringTokenizer invalidCode_3=new StringTokenizer(temp,":");
					while(invalidCode_3.hasMoreTokens())
					{
						invalidCode_3.nextToken();
						temp_1+=invalidCode_3.nextToken();
						temp_1+=",";
					System.out.println("temp_1="+invalidCode);
					}
				}
				String invalidCode="";		
				StringTokenizer invalidCode_4=new StringTokenizer(temp_1,",");
				while(invalidCode_4.hasMoreTokens())
				{
					invalidCode_4.nextToken();
					invalidCode=invalidCode_4.nextToken();
					invalidCode+=getProcCodeDesc(invalidCode);
					invalidCode+=",";
					System.out.println("invalidCode="+invalidCode);
				}*/

				//System.out.println("invalidCodedddddd="+invalidCode.substring(0,invalidCode.length()-1));
				//map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
				map.put( "invalidCode",invalidCode.substring(0,invalidCode.length()-1)) ;
				

			}
            else
				map.put( "message", getMessage(language_id,(String) map.get("msgid"),"Common")) ;
        }
		//System.out.println("####map#############="+map);
		return map;

	}catch(Exception e)
	{
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		return map ;
	}
	finally
	{
		clear();
		/*try 
		{
			if( remote != null )
				remote.remove() ;
		} catch( Exception ee ) 
		{
			System.out.println( "Error Calling EJB in finnally:" + ee ) ;
			ee.printStackTrace();
			System.err.println( ee.getMessage() ) ;
			map.put( "message", ee.getMessage() ) ;
		}*/
		map.put("traceVal",traceVal);
	 }

	}

/********************************************************/
	public void clear(){
		super.clear();
//		order_catalog_code="";
//		term_set_code="";
//		term_set="";
		proc_or_group="";
//		default_yn="";
		hashtable=null;
	}
/*********************ProcOrGroupValue**********************************/

public String ProcOrGroupValue(String order_catalog_code){
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String Order_Catalog_nature="";
	try{
		con=getConnection();
		pstmt=con.prepareStatement((String)OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_PROC_OR_GROUP"));
		pstmt.setString(1,order_catalog_code);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next())
		Order_Catalog_nature=rs.getString(1);
		if(Order_Catalog_nature.equals("A"))
			proc_or_group="P";
		else if(Order_Catalog_nature.equals("P"))
			proc_or_group="G";
		
	}catch(Exception e){
	System.err.println("Exception in ProcOrGroupValue method of OrderCatalogProcedureLink.java="+e);
	e.printStackTrace();
	}finally{
		try{	
		closeResultSet(rs);
		closeStatement(pstmt);
		closeConnection(con);
		}catch(Exception e1){
			System.err.println("Exception in finally of ProcOrGroupValue method of OrderCatalogProcedureLink.java="+e1);
			e1.printStackTrace();
		
		}
	}
//System.out.println("###in ProcOrGroupValue of bean,proc_or_group of "+order_catalog_code+" is="+proc_or_group);
	return proc_or_group;
}
/*****************getDBTermSetCode********************/
public String getDBTermSetCode(String code){
Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String db_term_set_code="";
	try{
		con=getConnection();
		pstmt=con.prepareStatement((String)OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_PROC_CODE"));
		pstmt.setString(1,code);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next())
		db_term_set_code=rs.getString(1);
		
	}catch(Exception e){
	System.err.println("Exception in ProcOrGroupValue method of OrderCatalogProcedureLink.java="+e);
	e.printStackTrace();
	}finally{
		try{	
		closeResultSet(rs);
		closeStatement(pstmt);
		closeConnection(con);
		}catch(Exception e1){
			System.err.println("Exception in finally of ProcOrGroupValue method of OrderCatalogProcedureLink.java="+e1);
			e1.printStackTrace();
		
		}
	}
//System.out.println("###in ProcOrGroupValue of bean,db_term_set_code of "+code+" is="+db_term_set_code);
	return db_term_set_code;



}
/*****************populating of term_set list box********************/
public ArrayList populateTermSet () throws Exception 
	{
		ArrayList TermSet = new ArrayList() ;
		Connection connection=null;
		java.sql.ResultSet resultSet=null;
		java.sql.PreparedStatement pstmt = null;

		try {
			connection=	getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_POPULATE_TERM_SET") ) ;
			if(!(pstmt==null)){
				resultSet = pstmt.executeQuery() ;
			}
			String[] record =null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "term_set_id" )  ;
				record[1] = resultSet.getString( "term_set_desc" )  ;
				TermSet.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return TermSet;
	}

/*****************retrives values to display in the update mode page********************/

public String getComboString(){
Connection 	connection  = null;
java.sql.PreparedStatement pstmt		= null;
java.sql.ResultSet rs	= null;
	try {
		connection  = getConnection();

		pstmt						= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_POPULATE_TERM_SET"));
		rs							= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();

		String  codeCol			    = "";
		String  codeDesc			= "";

		while (rs.next()){
				codeCol			    = ChkDef.defaultString(rs.getString(1));
				codeDesc			= ChkDef.defaultString(rs.getString(2));
			    sb.append(codeCol + "," + codeDesc + ",");
		}

		 String str =   sb.toString() ;
		 sb.setLength(0);
		// System.out.println("###str.substring(0, str.length()-1)="+str.substring(0, str.length()-1));
		 return str.substring(0, str.length()-1);
	}catch(Exception e){
		System.err.println(e.getMessage());
		e.printStackTrace();
		return null;
	}finally{
		try{
			closeResultSet(rs);
			closeStatement(pstmt);
				closeConnection(connection);
		 }catch(Exception e){e.printStackTrace();}
	}
}

/*****************retrives values to display in the update mode page********************/
public String[] loadData(String TermSetCode,String OrderCatalogCode)throws Exception
	{
	//System.out.println("in bean,activity_type="+activity_type);
	if(TermSetCode.equals(""))return null;
	if(OrderCatalogCode.equals(""))return null;
	String[] loadDataVal = new String[4] ;
	Connection connection	=null;
	ResultSet resultSet	  	= null;
	java.sql.PreparedStatement pstmt		= null;
	try {
		connection=getConnection() ;

		pstmt	= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROCEDURE_LINK_SELECT"));
		pstmt.setString(1,TermSetCode.trim());
		pstmt.setString(2,OrderCatalogCode.trim());
		
			resultSet		= pstmt.executeQuery();
			if(resultSet != null && resultSet.next()){
			loadDataVal[0]=resultSet.getString( "order_catalog" ) ;
			loadDataVal[1]=resultSet.getString( "proc_code_desc" ) ;
			loadDataVal[2]=resultSet.getString( "proc_coding_scheme" ) ;
			//loadDataVal[3]=resultSet.getString( "proc_coding_scheme_desc" ) ;
			loadDataVal[3]=resultSet.getString( "default_yn" ) ;
			
		
		}
//		System.out.println("####OrderCatalogProcLink,  order_catalog="+loadDataVal[0]);
//		System.out.println("####OrderCatalogProcLink,  term_set_desc="+loadDataVal[1]);
//		System.out.println("####OrderCatalogProcLink,  term_set="+loadDataVal[2]);
		//System.out.println("####OrderCatalogProcLink,  term_set_display="+loadDataVal[3]);
//		System.out.println("####OrderCatalogProcLink,  default_yn="+loadDataVal[3]);
		
		return loadDataVal;

	} catch ( Exception e )	{
		System.err.println( "Error loading values from database" ) ;
		e.printStackTrace() ;
		throw e ;
	} finally {
		closeResultSet(resultSet);
		closeStatement(pstmt);
		closeConnection(connection) ;
		

	}
	}

/********************************************************/
/*public String getProcCodeDesc(String code){
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String proc_code_desc="";
	try{
		con=getConnection();		pstmt=con.prepareStatement((String)OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_PROC_LINK_PROC_OR_GROUP"));
		pstmt.setString(1,order_catalog_code);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next())
		Order_Catalog_nature=rs.getString(1);
		if(Order_Catalog_nature.equals("A"))
			proc_or_group="P";
		else if(Order_Catalog_nature.equals("P"))
			proc_or_group="G";
		
	}catch(Exception e){
	System.err.println("Exception in ProcOrGroupValue method of OrderCatalogProcedureLink.java="+e);
	e.printStackTrace();
	}finally{
		try{	
		closeResultSet(rs);
		closeStatement(pstmt);
		closeConnection(con);
		}catch(Exception e1){
			System.err.println("Exception in finally of ProcOrGroupValue method of OrderCatalogProcedureLink.java="+e1);
			e1.printStackTrace();
		
		}
	}
System.out.println("###in ProcOrGroupValue of bean,proc_or_group of "+order_catalog_code+" is="+proc_or_group);
	return proc_or_group;
}*/

/********************************************************/
	/*public ArrayList getProc_code_scheme() {
		//System.out.println("##in getProc_code_scheme()");
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Proc_code_scheme		= new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_PROCEDURE_LINK_PROC_CODE_SCHEME_SELECT") ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "scheme" )  ;
				record[1] = resultSet.getString( "scheme_desc" )  ;

				Proc_code_scheme.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			//throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception e) {
				e.printStackTrace() ;
			}
		}
		//System.out.println("##in getProc_code_scheme(),Proc_code_scheme="+Proc_code_scheme);

		return Proc_code_scheme;
	}*/



};

