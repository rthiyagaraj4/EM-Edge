/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class DrugScheduleBean extends PhAdapter implements Serializable {

/*1*/	protected String	schedule_id					   = "" ;                    
/*2*/	protected String	schedule_desc				   = "" ;
/*3*/	protected String	order_auth_reqd_yn			   = "Y" ;
/*4*/	protected String    order_auth_level			   = "" ; 
/*5*/	protected String    order_cosign_reqd_yn		   = "Y" ;
/*6*/	protected String    order_cosign_level             = "" ;
/*7*/	protected String    spl_appr_reqd_yn               = "Y" ;
/*8*/	protected String    spl_appr_level                 = "" ;
/*9*/	protected String	repeat_single_cont_order_yn    = "Y" ;
/*10*/	protected String	disp_auth_reqd_yn              = "Y" ;
/*11*/	protected String	eff_status					   = "E" ;
	
	
/**************************** COTR()  ***************************************/	
public DrugScheduleBean() 
{
	    try 
		{
		doCommon();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
}

	/* Over-ridden Adapter methods start here */
/**************************** clear()  ***************************************/	
public void clear() {
		
schedule_id					   = "" ;  
schedule_desc				   = "" ;  
order_auth_reqd_yn			   = "Y" ;  
order_auth_level			   = "" ;  
order_cosign_reqd_yn		   = "Y" ;  
order_cosign_level             = "" ;  
spl_appr_reqd_yn               = "Y" ;  
spl_appr_level                 = "" ;  
repeat_single_cont_order_yn    = "Y" ;  
disp_auth_reqd_yn              = "Y" ;  
eff_status					   = "E" ;  
super.clear() ;
}
/**************************** doCommon()  ***************************************/	

private void doCommon() throws Exception {
	}
/* Over-ridden Adapter methods end here */

/**************************** validate()  ***************************************/	
	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}

/**************************** Set...XYZ()  ***************************************/	
	
public void setSCHEDULE_ID( String schedule_id ) {
		this.schedule_id = schedule_id  ;	
	}

public void setSCHEDULE_DESC( String schedule_desc )	{
		this.schedule_desc = schedule_desc  ;
	}
public void setORDER_AUTH_REQD_YN ( String order_auth_reqd_yn ){
		if(order_auth_reqd_yn.equals("") || order_auth_reqd_yn==null )
			this.order_auth_reqd_yn = "N" ;
		else
			this.order_auth_reqd_yn = order_auth_reqd_yn ;
	}
public void setORDER_AUTH_LEVEL( String order_auth_level ) {
		if(order_auth_level.equals("") || order_auth_level==null )
			this.order_auth_level = "";
		else
			this.order_auth_level = order_auth_level ;
}
public void setORDER_COSIGN_REQD_YN( String order_cosign_reqd_yn )	{
		if(order_cosign_reqd_yn.equals("") || order_cosign_reqd_yn==null )
			this.order_cosign_reqd_yn = "N" ;
		else
			this.order_cosign_reqd_yn = order_cosign_reqd_yn ;
}
public void setORDER_COSIGN_LEVEL ( String order_cosign_level ){
		if(order_cosign_level.equals("") || order_cosign_level==null )
			this.order_cosign_level = "" ;
		else
			this.order_cosign_level = order_cosign_level ;
}
public void setSPL_APPR_REQD_YN( String spl_appr_reqd_yn ) {
		if(spl_appr_reqd_yn.equals("") || spl_appr_reqd_yn==null )
			this.spl_appr_reqd_yn = "N" ;
		else
			this.spl_appr_reqd_yn = spl_appr_reqd_yn ;	
}
public void setSPL_APPR_LEVEL( String spl_appr_level ) {
		if(spl_appr_level.equals("") || spl_appr_level==null )
			this.spl_appr_level = "" ;
		else
			this.spl_appr_level = spl_appr_level ;
}
public void setREPEAT_SINGLE_CONT_ORDER_YN( String repeat_single_cont_order_yn ) {
		if(repeat_single_cont_order_yn.equals("") || repeat_single_cont_order_yn==null )
			this.repeat_single_cont_order_yn = "N" ;
		else
			this.repeat_single_cont_order_yn = repeat_single_cont_order_yn ;		
}
public void setDISP_AUTH_REQD_YN( String disp_auth_reqd_yn ) {
		if(disp_auth_reqd_yn.equals("") || disp_auth_reqd_yn==null )
			this.disp_auth_reqd_yn = "N" ;
		else
			this.disp_auth_reqd_yn = disp_auth_reqd_yn ;
}
public void setEFF_STATUS( String eff_status ) {
		if(eff_status.equals("") || eff_status==null )
			this.eff_status = "D" ;
		else
			this.eff_status = eff_status ;
}
/*********************************************************************************/	
/* Get Methods Start */

public String getSCHEDULE_ID() {
	return	this.schedule_id ;	
	}
public String getSCHEDULE_DESC()	{
	return	this.schedule_desc;
	}
public String getORDER_AUTH_REQD_YN (){
	return	this.order_auth_reqd_yn ;
	}
public String getORDER_AUTH_LEVEL() {
		return this.order_auth_level;	
	}
public String getORDER_COSIGN_REQD_YN()	{
		return this.order_cosign_reqd_yn ;
	}
public String getORDER_COSIGN_LEVEL (){
		return this.order_cosign_level;
	}
public String getSPL_APPR_REQD_YN() {
	return	this.spl_appr_reqd_yn;	
	}
public String getSPL_APPR_LEVEL() {
		return this.spl_appr_level ;
	}
public String getREPEAT_SINGLE_CONT_ORDER_YN() {
		return this.repeat_single_cont_order_yn ;	
	}
public String getDISP_AUTH_REQD_YN() {
		return this.disp_auth_reqd_yn;	
	}
public String getEFF_STATUS() {
		return this.eff_status ;	
	}
/*********************************************************************************/	
public void setAll(Hashtable recordSet)
{
		
	/*1*/	if(recordSet.containsKey("schedule_id"))
			 setSCHEDULE_ID((String)recordSet.get("schedule_id")) ;
		
	/*2*/	if(recordSet.containsKey("schedule_desc"))
			setSCHEDULE_DESC((String)recordSet.get("schedule_desc")) ;
		
	/*3*/	if(recordSet.containsKey("order_auth_reqd_yn"))
			setORDER_AUTH_REQD_YN(  (String)recordSet.get("order_auth_reqd_yn") ) ;
		
	/*4*/	if(recordSet.containsKey("order_auth_level"))
			setORDER_AUTH_LEVEL((String)recordSet.get("order_auth_level")) ;
		
	/*5*/	if(recordSet.containsKey("order_cosign_reqd_yn"))
			setORDER_COSIGN_REQD_YN((String)recordSet.get("order_cosign_reqd_yn")) ;
		
	/*6*/	if(recordSet.containsKey("order_cosign_level"))
			setORDER_COSIGN_LEVEL((String)recordSet.get("order_cosign_level")) ;
		
	/*7*/	if(recordSet.containsKey("spl_appr_reqd_yn"))
			setSPL_APPR_REQD_YN((String)recordSet.get("spl_appr_reqd_yn")) ;
		
	/*8*/	if(recordSet.containsKey("spl_appr_level"))
			setSPL_APPR_LEVEL((String)recordSet.get("spl_appr_level")) ;
	
	/*9*/	if(recordSet.containsKey("repeat_single_cont_order_yn"))
			setREPEAT_SINGLE_CONT_ORDER_YN((String)recordSet.get("repeat_single_cont_order_yn")) ;
	
	/*10*/ if(recordSet.containsKey("disp_auth_reqd_yn"))
			setDISP_AUTH_REQD_YN((String)recordSet.get("disp_auth_reqd_yn")) ;
	
	/*11*/ if(recordSet.containsKey("eff_status"))
			setEFF_STATUS((String)recordSet.get("eff_status")) ;
	
	/*12*/ if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
}

/******************************  insert() ************************************************/
public HashMap insert() 
{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "test" ) ;

		ArrayList insertData = new ArrayList() ;
		ArrayList whereData = new ArrayList() ;
		StringBuffer sb= new StringBuffer();
    try
	{
		insertData.add( schedule_id ) ;
		insertData.add( schedule_desc ) ;
		insertData.add(	order_auth_reqd_yn ) ;

		insertData.add( order_auth_level) ;
		insertData.add( order_cosign_reqd_yn ) ;
		insertData.add( order_cosign_level ) ;
		insertData.add( spl_appr_reqd_yn ) ;
		insertData.add( spl_appr_level ) ;
		
		insertData.add( repeat_single_cont_order_yn ) ;
		insertData.add( disp_auth_reqd_yn ) ;
		insertData.add( eff_status ) ;

		insertData.add( login_by_id ) ;
		insertData.add( login_at_ws_no ) ;
		insertData.add( login_facility_id ) ;

		insertData.add( login_by_id ) ;
		insertData.add( login_at_ws_no ) ;
		insertData.add( login_facility_id ) ;
		
		whereData.add( schedule_id ) ;
		
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "InsertData",insertData);
		tabData.put( "WhereData",whereData);

		HashMap sqlMap = new HashMap() ;  
		 try{
			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue( "SQL_PH_DRUG_SCHEDULE_SELECT3" ) );
			sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue( "SQL_PH_DRUG_SCHEDULE_INSERT") );
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
			map = remote.insert( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class ,getLocalEJB());
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
				//map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
			    map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
					map.put( "message",getMessage( getLanguageId(), (String) map.get( "msgid" ),"Common" ) ) ;
				else
					map.put( "message", (String)map.get("msgid") ) ;
			}
		} catch(Exception e) {
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		
		}
	}catch(Exception e){
		System.err.println( "Error Calling EJB : "+e ) ;
		map.put( "message", "exp :"+e.getMessage()) ;
		map.put("flag",sb.toString());
		e.printStackTrace() ;
	
	}
	/*finally {
			try {
				
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
	}*/  //finally
		return map ;
}//insert ends

/******************************** modify()   ********************************/
public HashMap modify() 
{
StringBuffer debug=new StringBuffer();
debug.append("INSIDE MODIFY//");

HashMap map = new HashMap() ;
map.put( "result", new Boolean( false ) ) ;		

ArrayList insertRow = new ArrayList() ;

	insertRow.add( schedule_desc  ) ;
	
	insertRow.add( order_auth_reqd_yn ) ;
	insertRow.add(order_auth_level) ;
	insertRow.add(order_cosign_reqd_yn) ;
	insertRow.add(order_cosign_level) ;
	insertRow.add(spl_appr_reqd_yn) ;
	insertRow.add(spl_appr_level) ;
	insertRow.add(repeat_single_cont_order_yn) ;
	insertRow.add(disp_auth_reqd_yn) ;
	insertRow.add(eff_status) ;
		
	insertRow.add( login_by_id ) ;
	insertRow.add( login_at_ws_no ) ;
	insertRow.add( login_facility_id ) ;
	
	insertRow.add( schedule_id  ) ;

	HashMap tabData = new HashMap() ;
	tabData.put( "properties", getProperties() );
	tabData.put( "ModifyData",insertRow);

	HashMap sqlMap = new HashMap() ;

    try
	{
	sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue( "SQL_PH_DRUG_SCHEDULE_UPDATE" ) );
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}

/*  SingleTableHandlerHome home = null;
	SingleTableHandlerRemote remote = null;*/

	try {
/*		InitialContext context = new InitialContext() ;
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
	
		if(((Boolean) map.get( "result" )).booleanValue()){
			debug.append("Inside result after ejb call modify() result="+((Boolean) map.get( "result" )).booleanValue()+"//getMessage((String) map.get)" +getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") );
		    //map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
			map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
		}
		else{
		if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
			map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
		else{
			debug.append("Inside else result fails here ejb call modify()//"+((Boolean) map.get( "result" )).booleanValue()+"//messageid//"+(map.get("msgid")) );
			map.put( "message", (map.get("msgid"))) ;
			}
			}
	}//try
	catch(Exception e) {
		System.err.println( "Error Calling EJB : "+e ) ;
		map.put( "message", e.getMessage()) ;
		map.put("flag",debug.toString());
		e.printStackTrace() ;
	}
/*	finally {
			try {} 
			catch( Exception ee ){
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		map.put("flag",debug.toString());
		return map ;		
}
//******************************************************************************************

/***CHECK REFILL_YN VALUE OF PH_PARAM****/
public String getRefillStatus()	{

		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query            =   "";
		String refill_yn			=	"";

	    try
	    {
         sql_query               = PhRepository.getPhKeyValue("SQL_PH_DRUG_SCHEDULE_SELECT4");

		 connection  = getConnection() ;
         pstmt       = connection.prepareStatement(sql_query) ;
	  	 resultSet   =   pstmt.executeQuery();

				if(resultSet.next())
                {
				refill_yn	=	resultSet.getString(1);
                }
            } catch ( Exception e ) {
                System.err.println( "Error"+e ) ;
                e.printStackTrace() ;
            } finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es)
					{
           				System.out.println("Exception while closing resultsets and statements"+es.toString());
					}
              }
		return refill_yn;
}


/*********************   getDataForHyperLink() **********************************/
// called in the AddModify page,evoked from onsuccess() and modify() in js

public ArrayList getDataForHyperLink(String schedule_id)  throws Exception 
{
		ArrayList AllColsArr = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

try {

	connection = getConnection() ;
	
	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SCHEDULE_SELECT2") ) ;
	pstmt.setString(1,schedule_id.trim());
	resultSet = pstmt.executeQuery() ;
	
	if ( resultSet != null && resultSet.next() )  
	{
		AllColsArr.add( (String) resultSet.getString( "schedule_id" ) ) ;
		AllColsArr.add( (String)resultSet.getString( "schedule_desc" ) ) ;
		AllColsArr.add( (String)resultSet.getString( "order_auth_reqd_yn" ) ) ;
		AllColsArr.add( (String)resultSet.getString( "order_auth_level" ) ) ;
		AllColsArr.add( (String)resultSet.getString( "order_cosign_reqd_yn" ) ) ;
		AllColsArr.add( (String)resultSet.getString( "order_cosign_level" ) ) ;
		AllColsArr.add( (String)resultSet.getString( "spl_appr_reqd_yn" ) ) ;
		AllColsArr.add( (String)resultSet.getString( "spl_appr_level" ) ) ;
		AllColsArr.add( (String)resultSet.getString( "repeat_single_cont_order_yn" ) ) ;
		AllColsArr.add( (String)resultSet.getString( "disp_auth_reqd_yn" ) ) ;
		AllColsArr.add( (String)resultSet.getString( "EFF_STATUS" ) ) ;
	}
	}catch ( Exception e ) 
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
				}
				catch(Exception es) 
				{
					System.out.println("Exception while closing resultsets and statements"+es.toString());
				}
		}
		
		return AllColsArr;
}
}//class ends
/********************************************************************************/
