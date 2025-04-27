/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;
import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.TPNConsGroup.*;

//saved on 25/10/2005
public class TPNConsGroupBean extends PhAdapter implements Serializable {

	private Hashtable recordSet		= new Hashtable();

	public TPNConsGroupBean() 
	{
		//Constructor
		try 
		{
			doCommon() ;
		}
		catch(Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception 
	{
	}

	public void clear() 
	{
		super.clear() ;
		
	}

	/* Over-ridden Adapter methods endS here */
	/* Function specific methods start */



	public String getLoggedInFacility()  
	{
		return login_facility_id;
	}
	

	public HashMap validate() throws Exception {
		HashMap map=new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map;
	}


public HashMap getConsGroupDetails(String gCode)
{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		HashMap result=new HashMap();
		
		try {
			connection = getConnection() ;
			//this query retrieveds cons group info
			boolean assesment_req_yn =CommonBean.isSiteSpecific(connection,"PH","ASSESMENT_REQ_YN");//added for ML-MMOH-CRF-1126
			
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_GROUP_SELECT1" )) ; //Common-ICN-0090
			//Added for ML-MMOH-CRF-1126 start
			if(assesment_req_yn){
			pstmt = connection.prepareStatement("SELECT CONST_GROUP_NAME,DISP_SRL_NO,EFF_STATUS FROM PH_TPN_CONST_GRP_LANG_VW PH_TPN_CONSTITUENT_GROUP WHERE  CONST_GROUP_CODE = ? AND LANGUAGE_ID = ?") ;
			} else {  //Common-ICN-0090
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_GROUP_SELECT1" )) ; //Common-ICN-0090  
			}

			////Added for ML-MMOH-CRF-1126 end
			pstmt.setString(1,gCode);
			pstmt.setString(2, getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if (resultSet.next()) {
				result.put("GNAME",resultSet.getString("CONST_GROUP_NAME"));
				result.put("SRLNO",resultSet.getString("DISP_SRL_NO"));
				//added for ML-MMOH-CRF-1126 start
				if(assesment_req_yn){
				result.put("EFF_STATUS",resultSet.getString("EFF_STATUS"));
				}
				//added for ML-MMOH-CRF-1126 end
			}
		}
		catch ( Exception e ) {
			
			e.printStackTrace() ;
			result.put("GNAME",e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {System.err.println(es);
			}
		
		}
		return result;

}
public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values
		
		*/
		
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		this.recordSet = recordSet;
	}

 public HashMap insert() {
// added for ML-MMOH-CRF-1126 start
	 HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();

		tabData.put("flag","test flag");
		tabData.put("result",new Boolean(true));
		tabData.put("message","message");

		tabData.put( "PROPERTIES", getProperties() );
		
		String gCode=(String)recordSet.get("gCode");
		String gName=(String)recordSet.get("gName");
		String eff_status=(String)recordSet.get("eff_status");
		if(eff_status.equals("")||eff_status==null)
			eff_status="D";
		String display_sri_no=(String)recordSet.get("srlno");

		tabData.put("GCODE",gCode);
		tabData.put("GNAME",gName);
		tabData.put("EFF_STATUS",eff_status);
		tabData.put("DISPLAY_SRI_NO",display_sri_no);
		tabData.put("LOGIN_BY_ID",login_by_id);
		tabData.put("LOGIN_AT_WS_NO",login_at_ws_no);
		tabData.put("LOGIN_FACILITY_ID",login_facility_id);
		Connection connection	= null ;
		PreparedStatement pstmt_select_disp_count=null;
		String count="";
		ResultSet resultSet = null ;
		try
		{
				sqlMap.put("SQLINSERT", PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_GROUP_INSERT" ) );
		
				String disp_count="select count(*)  disp_count from PH_TPN_CONSTITUENT_GROUP where DISP_SRL_NO= ?";
				
				
				 connection	= getConnection() ;

				 pstmt_select_disp_count=connection.prepareStatement(disp_count);
				
				 pstmt_select_disp_count.setString(1,display_sri_no);
				 resultSet=pstmt_select_disp_count.executeQuery();
				
				if(resultSet !=null && resultSet.next())
					{
					count=	resultSet.getString("DISP_COUNT");
					
					System.out.println("count==> "+count);
					}	
				if(Integer.parseInt(count) == 0){
					 /*					TPNConsGroupHome home=null;
					TPNConsGroupRemote remote=null;
					InitialContext context = new InitialContext() ;
					Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_PH_TPNCONSGROUP" ) ) ;
					home  = (TPNConsGroupHome) PortableRemoteObject.narrow( object, TPNConsGroupHome.class ) ;
					remote = home.create() ; 

					//map=localUpdate (tabData,sqlMap );
					map=remote.modify(tabData,sqlMap);*/

					//Object home=com.medicom.ESLP.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_TPNCONSGROUP"),TPNConsGroupHome.class,getLocalEJB());

			     Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TPNCONSGROUP" ),TPNConsGroupHome.class,getLocalEJB());





					Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[]=new Object[2];
					argArray[0]=tabData;
					argArray[1]=sqlMap;

					Class[] paramArray=new Class[2];
					paramArray[0]=tabData.getClass();
					paramArray[1]=sqlMap.getClass();

					map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);//Problem
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result")).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				else
					{
					if( ((String)map.get( "msgid" )).equals( "CONSTITUENT_GROUP_CODE" ) )
				
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH"));	
					map.put( "result", new Boolean( true ) ) ;
					}
		}
				else{
					map.put( "message","Display Serial No Can’t Be Duplicate");
					map.put( "result", new Boolean( true ) ) ;
		}
		
		
		}
		 catch (Exception e)
		 {
				tabData.put("result",new Boolean(false));
				tabData.put("message",e.toString());
		 }
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt_select_disp_count) ;
				closeConnection( connection );
						}
			catch ( Exception fe ) {
		
				fe.printStackTrace() ;
			}
		}
		return map;

}

 private HashMap localInsert( HashMap tabData , HashMap sqlMap ) {
	 HashMap map = new HashMap() ;
	map.put( "flag", "0" ) ;
	map.put( "result", new Boolean( false ) ) ;
	map.put( "msgid", "inside insert" ) ;
	
	Connection connection	= null ;
	PreparedStatement pstmt_insert=null;
	
	int tmpcount;

	//ResultSet resultSet = null ;


	String user=(String)tabData.get("LOGIN_BY_ID");
	String wsno=(String)tabData.get("LOGIN_AT_WS_NO");
	String facility=(String)tabData.get("LOGIN_FACILITY_ID");
	String gCode=(String)tabData.get("GCODE");
	String gName=(String)tabData.get("GNAME");
	
	String eff_status=(String)tabData.get("EFF_STATUS");
	if(eff_status.equals("")||eff_status==null)
		eff_status="D";
	String display_sri_no=(String)tabData.get("SRLNO");

	try {
				
		 connection	= getConnection() ;

		 pstmt_insert=connection.prepareStatement((String) sqlMap.get( "SQLINSERT"));
		
//		 pstmt_update.setString(1,gName);
//		 pstmt_update.setString(2,user);
//		 pstmt_update.setString(3,wsno);
//		 pstmt_update.setString(4,facility);
//		 pstmt_update.setString(5,gCode);
		 
		 
		 
		 pstmt_insert.setString(1,gCode);
		 pstmt_insert.setString(2,gName);
		 pstmt_insert.setString(3,display_sri_no);
		 pstmt_insert.setString(4,eff_status);
		 pstmt_insert.setString(5,user);
		 pstmt_insert.setString(6,wsno);
		 pstmt_insert.setString(7,facility);
		 pstmt_insert.setString(8,user);
		 pstmt_insert.setString(9,wsno);
		 pstmt_insert.setString(10,facility);

		tmpcount =pstmt_insert.executeUpdate() ;
		if (tmpcount==0) {
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid", "Error During Updation into Constituent Group!!! ");
				return map;
		}
		else
		{
				map.put( "result", new Boolean( true) ) ;
				map.put( "msgid", "RECORD_INSERTED") ;

		}
		
		connection.commit();


	}//end of try
	
	catch( Exception e ) {
		map.put( "result", new Boolean( false ) ) ;
		map.put( "msgid", "Error During Updation into Constituent Group!!!  " +e) ;

	}
	finally {
		try {
			//closeResultSet( resultSet ) ;
			closeStatement( pstmt_insert) ;
			closeConnection( connection );
			//closeConnection( connection, (Properties)tabData.get( "properties" ) );
		}
		catch ( Exception fe ) {
	
			fe.printStackTrace() ;
		}
	}
	return map ;
}
 public String getSrlNo() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String result="";
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT MAX(DISP_SRL_NO) SRL_NO FROM PH_TPN_CONSTITUENT_GROUP WHERE CONST_GROUP_CODE IS NOT NULL") ;
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				result=(Integer.parseInt(resultSet.getString("SRL_NO"))+1)+"";
			}
			
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database1" ) ;
			e.printStackTrace() ;
			
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {   
				System.err.println(es);
			}
		
		}
		return result;

} 
// Added for ML-MMOH-CRF-1126 - End
 public HashMap modify() {

//		HashMap result=new HashMap();
		HashMap tabData=new HashMap();
		HashMap sqlMap=new HashMap();
		HashMap map=new HashMap();
		Connection con = null; // Added for ML-MMOH-CRF-1126 
		tabData.put("flag","test flag");
		tabData.put("result",new Boolean(true));
		tabData.put("message","message");

		tabData.put( "PROPERTIES", getProperties() );
		
		String gCode=(String)recordSet.get("gCode");
		String gName=(String)recordSet.get("gName");

		tabData.put("GCODE",gCode);
		tabData.put("GNAME",gName);
		tabData.put("LOGIN_BY_ID",login_by_id);
		tabData.put("LOGIN_AT_WS_NO",login_at_ws_no);
		tabData.put("LOGIN_FACILITY_ID",login_facility_id);
		String eff_status=(String)recordSet.get("eff_status"); // Added for ML-MMOH-CRF-1126 start
		boolean site = false;
		try{ 
			con = getConnection();
			site = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "ASSESMENT_REQ_YN");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
				 try {
						closeConnection(con);
					}
					catch ( Exception e ) {
						e.printStackTrace() ;
					}
		}
		if(site){
		   if(eff_status.equals("")){
			   eff_status = "D";
		   }
		   tabData.put("EFF_STATUS",eff_status);
		   tabData.put("SITE_SPECIFIC","Y");
		}
		else{
			tabData.put("SITE_SPECIFIC","N");
		} // Added for ML-MMOH-CRF-1126 - End
		
		try
		{
				sqlMap.put("SQLUPDATE", PhRepository.getPhKeyValue( "SQL_PH_TPN_CONS_GROUP_UPDATE" ) );
				//Added for ML-MMOH-CRF-1126 start
				if(site){
					sqlMap.put("SQLUPDATE", "UPDATE PH_TPN_CONSTITUENT_GROUP SET  CONST_GROUP_NAME=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, EFF_STATUS=? WHERE CONST_GROUP_CODE=?");	
				}
		 //Added for ML-MMOH-CRF-1126 end
/*					TPNConsGroupHome home=null;
					TPNConsGroupRemote remote=null;
					InitialContext context = new InitialContext() ;
					Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_PH_TPNCONSGROUP" ) ) ;
					home  = (TPNConsGroupHome) PortableRemoteObject.narrow( object, TPNConsGroupHome.class ) ;
					remote = home.create() ; 

					//map=localUpdate (tabData,sqlMap );
					map=remote.modify(tabData,sqlMap);*/

					//Object home=com.medicom.ESLP.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_TPNCONSGROUP"),TPNConsGroupHome.class,getLocalEJB());

			     Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TPNCONSGROUP" ),TPNConsGroupHome.class,getLocalEJB());





					Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[]=new Object[2];
					argArray[0]=tabData;
					argArray[1]=sqlMap;

					Class[] paramArray=new Class[2];
					paramArray[0]=tabData.getClass();
					paramArray[1]=sqlMap.getClass();

					map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result")).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				else
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;			
			
		}
		 catch (Exception e)
		 {
			// 		System.err.println("6");
				tabData.put("result",new Boolean(false));
				tabData.put("message",e.toString());
		 }
		return map;
}

	private HashMap localUpdate( HashMap tabData , HashMap sqlMap ) {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Modify" ) ;
		
		Connection connection	= null ;
		PreparedStatement pstmt_update=null;
		
		int tmpcount;

		//ResultSet resultSet = null ;

	
		String user=(String)tabData.get("LOGIN_BY_ID");
		String wsno=(String)tabData.get("LOGIN_AT_WS_NO");
		String facility=(String)tabData.get("LOGIN_FACILITY_ID");
		String gCode=(String)tabData.get("GCODE");
		String gName=(String)tabData.get("GNAME");

		try {
					
			 connection	= getConnection() ;

			 pstmt_update=connection.prepareStatement((String) sqlMap.get( "SQLUPDATE"));
			
			 pstmt_update.setString(1,gName);
			 pstmt_update.setString(2,user);
			 pstmt_update.setString(3,wsno);
			 pstmt_update.setString(4,facility);
			 pstmt_update.setString(5,gCode);
	
			tmpcount =pstmt_update.executeUpdate() ;
			if (tmpcount==0) {
					map.put( "result", new Boolean( false ) ) ;
					map.put( "msgid", "Error During Updation into Constituent Group!!! ");
					return map;
			}
			else
			{
					map.put( "result", new Boolean( true) ) ;
					map.put( "msgid", "RECORD_INSERTED") ;

			}
			
			connection.commit();


		}//end of try
		
		catch( Exception e ) {
			map.put( "result", new Boolean( false ) ) ;
			map.put( "msgid", "Error During Updation into Constituent Group!!!  " +e) ;

		}
		finally {
			try {
				//closeResultSet( resultSet ) ;
				closeStatement( pstmt_update) ;
				closeConnection( connection );
				//closeConnection( connection, (Properties)tabData.get( "properties" ) );
				connection.rollback();
			}
			catch ( Exception fe ) {
		
				fe.printStackTrace() ;
			}
		}
		return map ;
	}


	

				  
	/* Function specific methods end */
}

